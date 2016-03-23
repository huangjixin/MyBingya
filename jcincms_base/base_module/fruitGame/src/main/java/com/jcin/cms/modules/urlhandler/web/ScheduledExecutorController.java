/**
 * 一句话描述该类：倒计时控制器<br/>
 * @author 黄记新
 * @date 2016-3-11,上午9:53:26
 *
 */
package com.jcin.cms.modules.urlhandler.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.common.PasswordHelper;
import com.jcin.cms.modules.bet.domain.Account;
import com.jcin.cms.modules.bet.domain.FruitBetresult;
import com.jcin.cms.modules.bet.domain.FruitRecord;
import com.jcin.cms.modules.bet.service.IAccountHistoryService;
import com.jcin.cms.modules.bet.service.IAccountService;
import com.jcin.cms.modules.bet.service.IFruitBetresultHistoryService;
import com.jcin.cms.modules.bet.service.IFruitBetresultService;
import com.jcin.cms.modules.bet.service.IFruitRecordService;
import com.jcin.cms.modules.syst.domain.User;
import com.jcin.cms.modules.syst.service.IUserService;
import com.jcin.cms.modules.syst.web.SessionListener;
import com.jcin.cms.modules.urlhandler.domain.BetDomain;
import com.jcin.cms.modules.urlhandler.domain.BetResultDomain;
import com.jcin.cms.modules.urlhandler.domain.InfoDomain;
import com.jcin.cms.web.BaseController;

/**
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/scheduled")
public class ScheduledExecutorController extends BaseController {
	private static String START = "start";
	private static String END = "end";
	private static String STATUS = END;

	private static int currentLuckyNum = 0;
	private static int totalTime = 90;

	private static int currentway = 0;
	private static int countTime = totalTime;
	private static List currentList = new ArrayList();
	private static List<BetResultDomain> game = new ArrayList<BetResultDomain>();

	private static List<FruitBetresult> list = new ArrayList<FruitBetresult>();
	
	private static Map<String, User> map = new HashMap<String,User>();

	public ScheduledExecutorService scheduExec = null;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private IAccountHistoryService accountHistoryService;
	
	@Autowired
	private IFruitRecordService fruitRecordService;
	
	@Autowired
	private IFruitBetresultService fruitBetresultService;
	
	@Autowired
	private IFruitBetresultHistoryService fruitBetresultHistoryService;
	
	@RequestMapping(value = "getInfo")
	@ResponseBody
	public InfoDomain getInfo(Model uiModel,
			HttpServletRequest httpServletRequest) {
		InfoDomain infoDomain = new InfoDomain();
		infoDomain.setCountTime(countTime);
		infoDomain.setStatus(STATUS);
		infoDomain.setCurrentLuckyNum(currentLuckyNum);
		infoDomain.setResult(game);
		infoDomain.setCount(SessionListener.getCount());
		return infoDomain;
	}
	
	/**
	 * 跳向首页函数。
	 * @param uiModel
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = { "/", "/index" })
	public String channels(Model uiModel, HttpServletRequest httpServletRequest) {
		return "scheduled/index.jsp";
	}
	
	/**
	 * 下注函数。
	 * @param betDomain
	 * @param uiModel
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "createBet", method = RequestMethod.POST)
	@ResponseBody
	public String createBet(@ModelAttribute BetDomain betDomain,BindingResult result,Model uiModel, HttpServletRequest httpServletRequest) {
		if(STATUS == END){
			return "end";
		}
		
		if(countTime<60){
			return "overtime";
		}
		Subject currentUser = SecurityUtils.getSubject();  
		if(!currentUser.isAuthenticated()){
			return "login";
		}
		
		if(map.get(currentUser.getPrincipal().toString())!=null){
			User user = map.get(currentUser.getPrincipal().toString());
			Account account = accountService.selectByPrimaryKey(user.getId());
			if(account==null){
				return "accountNotExist";
			}
			if(account.getTotal()<betDomain.getTotal()){
				return "notEnough";
			}
			
			//下注代码。
			FruitBetresult fruitBetresult = new FruitBetresult();
			fruitBetresult.setBoluo((double) betDomain.getBoluo());
			fruitBetresult.setCaomei((double) betDomain.getCaomei());
			fruitBetresult.setCreateBy(user.getUsername());
			fruitBetresult.setCreateDate(new Date());
			fruitBetresult.setDa((double) betDomain.getDa());
			fruitBetresult.setDan((double) betDomain.getDan());
			fruitBetresult.setShuang((double) betDomain.getShuang());
			fruitBetresult.setUserId(user.getId());
			fruitBetresult.setUsername(user.getUsername());
			
			fruitBetresultService.insert(fruitBetresult);
			
			list.add(fruitBetresult);
		}
		return "success";
	}

	@RequestMapping(value = "login",method=RequestMethod.POST)
	@ResponseBody
	public String login(@ModelAttribute User user,BindingResult result, Model uiModel,
			HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException {
	    Subject currentUser = SecurityUtils.getSubject();  
	    String passw = PasswordHelper.encryptPassword(user.getPassword());
		UsernamePasswordToken token = new UsernamePasswordToken(
				user.getUsername(), passw);
	    token.setRememberMe(true);  
	    try {  
	        currentUser.login(token);  
	    } catch (Exception e) {//登录失败 
	    	return "fail";
	    }  
	    User user1 = userService.findByUsername(user.getUsername());
	    map.put(currentUser.getPrincipal().toString(),user1);
	    return "success";
	}
	
	/**
	 * 登录
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "login",method=RequestMethod.GET)
	public String login(HttpServletRequest httpServletRequest) {
		return "scheduled/login.jsp";
	}

	/**
	 * 登出
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest httpServletRequest) {
		Subject currentUser = SecurityUtils.getSubject();
		if(currentUser.isAuthenticated()){
			currentUser.logout();
		}
		map.remove(currentUser.getPrincipal().toString());
		return "scheduled/index.jsp";
	}
	
	/**
	 * 跳向个人中心。
	 * @param uiModel
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	@RequestMapping(value = "/personal")
//	@RequiresAuthentication
	public String personal(Model uiModel,
			HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isAuthenticated()){
			return "redirect:/scheduled/login";
		}
		return "scheduled/personal.jsp";
	}

	@RequestMapping(value = "/register",method=RequestMethod.GET)
	public String register(HttpServletRequest httpServletRequest) {
		return "scheduled/register.jsp";
	}
	
	/**
	 * 注册账号。
	 * @param user
	 * @param result
	 * @param uiModel
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	@ResponseBody
	public String register(@ModelAttribute User user, BindingResult result,Model uiModel,
			HttpServletRequest httpServletRequest) {
		User user2 = userService.findByUsername(user.getUsername());
		if(user2!=null){
			return "exist";
		}
		user.setCreateDate(new Date());
		userService.insert(user);
		
		Account account = new Account();
		account.setCreateBy(user.getUsername());
		account.setId(user.getId());
		account.setTotal(0.0);
		account.setCreateDate(new Date());
		accountService.insert(account);
		return "success";
	}

	@RequestMapping(value = { "startUp" })
	@ResponseBody
	public void startUp() {
		shutDown();
		lanuchTimer();
		STATUS = START;
	}

	/**
	 * 关闭。
	 */
	@RequestMapping(value = { "shutDown" })
	@ResponseBody
	public void shutDown() {
		if (scheduExec != null) {
			scheduExec.shutdownNow();
			STATUS = END;
		}
	}

	// 启动计时器
	private void lanuchTimer() {
		scheduExec = Executors.newScheduledThreadPool(1);
		scheduExec.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				countTime--;

				if (countTime == 10) {
					List<FruitBetresult> list = ScheduledExecutorController
							.generateList();
					int way = generateLuckyNum();
					currentway = way;
					int resu = getRandom();
					currentLuckyNum = resu;
					// 第一个数据是客户赢钱的，第二个是输钱的，第三个到第八个是各种可能的结果。
					List<Double> winlostList = computeCount(resu, list);

					/*
					 * System.out.println(winlostList1.toString());
					 * System.out.println(winlostList2.toString());
					 * System.out.println(winlostList3.toString());
					 * System.out.println(winlostList4.toString());
					 * System.out.println(winlostList5.toString());
					 * System.out.println(winlostList6.toString());
					 * System.out.println();
					 */

					if (way <= 3) {
						List<Double> winlostList1 = computeCount(1, list);
						List<Double> winlostList2 = computeCount(2, list);
						List<Double> winlostList3 = computeCount(3, list);
						List<Double> winlostList4 = computeCount(4, list);
						List<Double> winlostList5 = computeCount(5, list);
						List<Double> winlostList6 = computeCount(6, list);
						List<Double> l = new ArrayList<Double>();
						l.add(winlostList1.get(0));
						l.add(winlostList2.get(0));
						l.add(winlostList3.get(0));
						l.add(winlostList4.get(0));
						l.add(winlostList5.get(0));
						l.add(winlostList6.get(0));
						double min = winlostList1.get(0);
						int flag = 0;
						for (int i = 0; i < 6; i++) {
							if (winlostList1.get(i) < min) {
								min = winlostList1.get(i);
								flag = i;
							}
						}
						// 计算最大化利益的值，更改结果。
						if (way == 1) {
							currentLuckyNum = flag;
						} else {
							// 如果resu是利益持平的值，则返回它，否则返回打平值。
							if (winlostList.get(0) > winlostList.get(1)) {
								currentLuckyNum = flag;
							}
						}

						if (flag == 1) {
							currentList = winlostList1;
						} else if (flag == 2) {
							currentList = winlostList2;
						} else if (flag == 3) {
							currentList = winlostList3;
						} else if (flag == 4) {
							currentList = winlostList4;
						} else if (flag == 5) {
							currentList = winlostList5;
						} else if (flag == 6) {
							currentList = winlostList6;
						}
					} else {
						// 不干涉。
						currentList = winlostList;
					}

					FruitRecord fruitRecord = new FruitRecord();
					fruitRecord.setResult(resu);
					fruitRecord.setId(""+new Date().getTime());
					fruitRecord.setDescription("第"+game.size()+"期结果");
		
					BetResultDomain betResultDomain = new BetResultDomain();
					betResultDomain.setNum(resu);
					
					game.add(betResultDomain);//加载到内存。
					System.out.println("实际上开的是：" + resu + "，本轮的随机数是：" + way
							+ "————1代表最低赔，2,3代表不输赔，4——10不干涉。");
					System.out.println();
				}
				if (countTime == 0) {
					countTime = totalTime;
				}
			}
		}, countTime, 1, TimeUnit.SECONDS);
	}

	public static String getTime() {
		int min = countTime / 60;
		int sec = countTime % 60;
		return "00:" + "0" + min + ":" + sec;
	}

	private static int getRandom() {
		Random random = new Random();
		int s = random.nextInt(6) + 1;
		return s;
	}

	// 1代表全吃，最低赔，2,3代表不输赔，其余代表不干涉。在10之间取出一个数，决定本盘走势。
	private static int generateLuckyNum() {
		Random random = new Random();
		int s = random.nextInt(10) + 1;
		return s;
	}

	// 计算各种收益，亏损。
	private static List<Double> computeCount(int res, List<FruitBetresult> list) {
		double win = 0;// 客户盈利总数。
		double lost = 0;// 客户总共要输总数。
		double pingg = 0;
		double put = 0;
		double bol = 0;
		double caom = 0;
		double xig = 0;
		double xiangj = 0;

		for (FruitBetresult fruitBetresult : list) {
			// 本金
			double mustlost = fruitBetresult.getPingguo() + fruitBetresult.getXiangjiao()
					+ fruitBetresult.getPutao() + fruitBetresult.getBoluo()
					+ fruitBetresult.getXigua() + fruitBetresult.getCaomei()
					+ fruitBetresult.getDa() + fruitBetresult.getXiao()
					+ fruitBetresult.getShuang() + fruitBetresult.getDan();
			if (res == 1) {// 开奖是苹果。
				double pingguoWin = fruitBetresult.getPingguo() * 5
						+ fruitBetresult.getXiao() * 1.8 + fruitBetresult.getDan() * 1.8;
				double pingguoLost = mustlost;

				win += pingguoWin;
				lost += pingguoLost;

				pingg += pingguoWin - pingguoLost;
			} else if (res == 2) {// 开奖是葡萄。
				double putaoWin = fruitBetresult.getPutao() * 5
						+ fruitBetresult.getXiao() * 1.8 + fruitBetresult.getShuang()
						* 1.8;
				double putaoLost = mustlost;

				win += putaoWin;
				lost += putaoLost;

				put += putaoWin - putaoLost;
			} else if (res == 3) {//
				double boluoWin = +fruitBetresult.getBoluo() * 5
						+ fruitBetresult.getXiao() * 1.8 + +fruitBetresult.getDan() * 1.8;

				double boluoLost = mustlost;
				win += boluoWin;
				lost += boluoLost;
				bol += boluoWin - boluoLost;
			} else if (res == 4) {
				double caomeiWin = fruitBetresult.getCaomei() * 5
						+ fruitBetresult.getDa() * 1.8 + fruitBetresult.getShuang() * 1.8;

				double caomeiLost = mustlost;

				win += caomeiWin;
				lost += caomeiLost;
				caom += caomeiWin - caomeiLost;
			} else if (res == 5) {
				double xiguaWin = fruitBetresult.getXigua() * 5 + fruitBetresult.getDa()
						* 1.8 + fruitBetresult.getDan() * 1.8;

				double xigualost = mustlost;
				// + betDomain.getXiao() + betDomain.getShuang();

				win += xiguaWin;
				lost += xigualost;
				xig += xiguaWin - xigualost;
			} else if (res == 6) {
				double xiangjiaoWin = fruitBetresult.getXiangjiao() * 5
						+ fruitBetresult.getDa() * 1.8 + fruitBetresult.getShuang() * 1.8;

				double xiangjiaoLost = mustlost;
				// + betDomain.getXiao() + betDomain.getDan();

				win += xiangjiaoWin;
				lost += xiangjiaoLost;
				xiangj += xiangjiaoWin - xiangjiaoLost;
			}
		}

		List<Double> list2 = new ArrayList<Double>();
		list2.add(win);
		list2.add(lost);
		list2.add(pingg);
		list2.add(put);
		list2.add(bol);
		list2.add(caom);
		list2.add(xig);
		list2.add(xiangj);
		return list2;
	}

	private static List<FruitBetresult> generateList() {
		/*
		 * Iterator<BetDomain> it = ScheduledExecutorController.list.iterator();
		 * while (it.hasNext()) { it.remove(); }
		 */
		list = new ArrayList<FruitBetresult>();
		/*Random random = new Random();
		for (int i = 0; i < 100; i++) {

			int money = random.nextInt(10);
			int s = random.nextInt(1000);
			s = s % 3 + 1;
			BetDomain betDomain = new BetDomain();
			if (s == 1) {
				int buyN = random.nextInt(6) + 1;
				betDomain.setMoney(buyN, money);
			} else if (s == 2) {
				int buyN = random.nextInt(6) + 1;
				betDomain.setMoney(buyN, money);
				do {
					buyN = random.nextInt(6) + 1;
				} while (buyN == random.nextInt(6) + 1);
				betDomain.setMoney(buyN, money);
			} else if (s == 3) {
				int buyN1 = random.nextInt(6) + 1;
				betDomain.setMoney(buyN1, money);

				int buyN2 = random.nextInt(6) + 1;
				do {
					buyN2 = random.nextInt(6) + 1;
				} while (buyN1 == buyN2);
				betDomain.setMoney(buyN2, money);

				int buyN3 = random.nextInt(6) + 1;
				do {
					buyN3 = random.nextInt(6) + 1;
				} while (buyN1 == buyN3 || buyN2 == buyN3);
				betDomain.setMoney(buyN3, money);

			} else if (s == 4) {
				int buyN1 = random.nextInt(6) + 1;
				betDomain.setMoney(buyN1, money);

				int buyN2 = random.nextInt(6) + 1;
				do {
					buyN2 = random.nextInt(6) + 1;
				} while (buyN1 == buyN2);
				betDomain.setMoney(buyN2, money);

				int buyN3 = random.nextInt(6) + 1;
				do {
					buyN3 = random.nextInt(6) + 1;
				} while (buyN1 == buyN3 || buyN2 == buyN3);
				betDomain.setMoney(buyN3, money);

				int buyN4 = random.nextInt(6) + 1;
				do {
					buyN4 = random.nextInt(6) + 1;
				} while (buyN1 == buyN4 || buyN2 == buyN4 || buyN3 == buyN4);
				betDomain.setMoney(buyN4, money);

			} else if (s == 5) {
				int buyN1 = random.nextInt(6) + 1;
				betDomain.setMoney(buyN1, money);

				int buyN2 = random.nextInt(6) + 1;
				do {
					buyN2 = random.nextInt(6) + 1;
				} while (buyN1 == buyN2);
				betDomain.setMoney(buyN2, money);

				int buyN3 = random.nextInt(6) + 1;
				do {
					buyN3 = random.nextInt(6) + 1;
				} while (buyN1 == buyN3 || buyN2 == buyN3);
				betDomain.setMoney(buyN3, money);

				int buyN4 = random.nextInt(6) + 1;
				do {
					buyN4 = random.nextInt(6) + 1;
				} while (buyN1 == buyN4 || buyN2 == buyN4 || buyN3 == buyN4);
				betDomain.setMoney(buyN4, money);

				int buyN5 = random.nextInt(6) + 1;
				do {
					buyN5 = random.nextInt(6) + 1;
				} while (buyN1 == buyN5 || buyN2 == buyN5 || buyN3 == buyN5
						|| buyN4 == buyN5);
				betDomain.setMoney(buyN5, money);
			}

			s = random.nextInt(1000);
			s %= 2;
			money = random.nextInt(10);
			if (s == 0) {
				betDomain.setDa(money);
			} else {
				betDomain.setXiao(money);
			}

			s = random.nextInt(1000);
			s %= 2;
			money = random.nextInt(10);
			if (s == 0) {
				betDomain.setDan(money);
			} else {
				betDomain.setShuang(money);
			}

			list.add(betDomain);
		}*/

		return list;
	}

	public static void main(String[] args) {
		ScheduledExecutorController executorController = new ScheduledExecutorController(); // executorController.lanuchTimer();
		executorController.lanuchTimer();
		/*
		 * for (int i = 0; i < 100; i++) {
		 * System.out.println(ScheduledExecutorController.getRandom()); }
		 */

		/*
		 * List list = new ArrayList(); for (int i = 0; i < 1000; i++) { int way
		 * = generateLuckyNum(); if (way == 1 || way == 2 || way == 3) {
		 * list.add(way); } }
		 */
		System.out.println("结束");
	}
}
