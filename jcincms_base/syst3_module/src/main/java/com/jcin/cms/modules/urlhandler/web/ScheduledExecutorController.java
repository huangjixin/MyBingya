/**
 * 一句话描述该类：倒计时控制器<br/>
 * @author 黄记新
 * @date 2016-3-11,上午9:53:26
 *
 */
package com.jcin.cms.modules.urlhandler.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcin.cms.modules.syst.domain.User;
import com.jcin.cms.modules.syst.service.IUserService;
import com.jcin.cms.modules.urlhandler.domain.BetDomain;
import com.jcin.cms.modules.urlhandler.domain.BetResultDomain;
import com.jcin.cms.modules.urlhandler.domain.InfoDomain;

/**
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = "/scheduled")
public class ScheduledExecutorController {

	private static final int PINGGUO = 1;
	private static final int PUTAO = 2;
	private static final int BOLUO = 3;
	private static final int CAOMEI = 4;
	private static final int XIGUA = 5;
	private static final int XIANGJIAO = 6;

	private static String START = "start";
	private static String END = "end";
	private static String STATUS = END;

	private static int currentLuckyNum = 0;
	private static int totalTime = 15;

	private static int currentway = 0;
	private static int countTime = totalTime;
	private static List currentList = new ArrayList();
	private static List<BetResultDomain> game = new ArrayList<BetResultDomain>();

	private static List<BetDomain> list = new ArrayList<BetDomain>();

	public ScheduledExecutorService scheduExec = null;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = { "", "index" })
	public String channels(Model uiModel, HttpServletRequest httpServletRequest) {
		/*uiModel.addAttribute("countTime", countTime);
		uiModel.addAttribute("time", getTime());
		uiModel.addAttribute("currentLuckyNum", currentLuckyNum);
		uiModel.addAttribute("currentList", currentList.toString());
		uiModel.addAttribute("currentway", currentway);*/

		return "scheduled/index.html";
	}

	@RequestMapping(value = "getInfo")
	@ResponseBody
	public InfoDomain getInfo(Model uiModel,
			HttpServletRequest httpServletRequest) {
		InfoDomain infoDomain = new InfoDomain();
		infoDomain.setCount(SessionListener.getCount());
		infoDomain.setCountTime(countTime);
		infoDomain.setStatus(STATUS);
		infoDomain.setCurrentLuckyNum(currentLuckyNum);
		infoDomain.setResult(game);
		return infoDomain;
	}

	@RequestMapping(value = "login",method=RequestMethod.POST)
	@ResponseBody
	public User login(User user, Model uiModel,
			HttpServletRequest httpServletRequest) {
		 //当前Subject  
	    Subject currentUser = SecurityUtils.getSubject();  
	    UsernamePasswordToken token = new UsernamePasswordToken(  
	           user.getUsername(),  
	           user.getPassword());  
	    token.setRememberMe(true);  
	    try {  
	        /* 
	         * 在调用了login方法后，SecurityManager会收到AuthenticationToken，并将其发送给已配置的Realm 
	         * ，执行必须的认证检查。每个Realm都能在必要时对提交的AuthenticationTokens作出反应。 
	         * 但是如果登录失败了会发生什么？如果用户提供了错误密码又会发生什么？通过对Shiro的运行时AuthenticationException做出反应 
	         * ，你可以控制失败 
	         */  
	        currentUser.login(token);  
	        /*request.getRequestDispatcher("/index.jsp").forward(request,  
	                response);*/  
	    } catch (Exception e) {//登录失败  
//	        e.printStackTrace();  
	        /*request.setAttribute("msg", "不匹配的用户名和密码");  
	        request.getRequestDispatcher("/login.jsp").forward(request,  
	                response);*/  
	    	return null;
	    }  
	    
		return user;
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest httpServletRequest) {
		Subject currentUser = SecurityUtils.getSubject();
		if(currentUser.isAuthenticated()){
			currentUser.logout();
		}
		return "redirect:index.html";
	}
	
	@RequestMapping(value = "/personal")
	public String personal(Model uiModel,
			HttpServletRequest httpServletRequest) {
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isAuthenticated()){
			return "scheduled/login.html";
		}
		return "scheduled/personal.html";
	}

	@RequestMapping(value = "/register")
	@ResponseBody
	public String register(User user, Model uiModel,
			HttpServletRequest httpServletRequest) {
		System.out.println(user.getUsername());
		return null;
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
					List<BetDomain> list = ScheduledExecutorController
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

					BetResultDomain betResultDomain = new BetResultDomain();
					betResultDomain.setNum(resu);
					game.add(betResultDomain);
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
	private static List<Double> computeCount(int res, List<BetDomain> list) {
		double win = 0;// 客户盈利总数。
		double lost = 0;// 客户总共要输总数。
		double pingg = 0;
		double put = 0;
		double bol = 0;
		double caom = 0;
		double xig = 0;
		double xiangj = 0;

		for (BetDomain betDomain : list) {
			// 本金
			double mustlost = betDomain.getPingguo() + betDomain.getXiangjiao()
					+ betDomain.getPutao() + betDomain.getBoluo()
					+ betDomain.getXigua() + betDomain.getCaomei()
					+ betDomain.getDa() + betDomain.getXiao()
					+ betDomain.getShuang() + betDomain.getDan();
			if (res == 1) {// 开奖是苹果。
				double pingguoWin = betDomain.getPingguo() * 5
						+ betDomain.getXiao() * 1.8 + betDomain.getDan() * 1.8;
				double pingguoLost = mustlost;

				win += pingguoWin;
				lost += pingguoLost;

				pingg += pingguoWin - pingguoLost;
			} else if (res == 2) {// 开奖是葡萄。
				double putaoWin = betDomain.getPutao() * 5
						+ betDomain.getXiao() * 1.8 + betDomain.getShuang()
						* 1.8;
				double putaoLost = mustlost;

				win += putaoWin;
				lost += putaoLost;

				put += putaoWin - putaoLost;
			} else if (res == 3) {//
				double boluoWin = +betDomain.getBoluo() * 5
						+ betDomain.getXiao() * 1.8 + +betDomain.getDan() * 1.8;

				double boluoLost = mustlost;
				win += boluoWin;
				lost += boluoLost;
				bol += boluoWin - boluoLost;
			} else if (res == 4) {
				double caomeiWin = betDomain.getCaomei() * 5
						+ betDomain.getDa() * 1.8 + betDomain.getShuang() * 1.8;

				double caomeiLost = mustlost;

				win += caomeiWin;
				lost += caomeiLost;
				caom += caomeiWin - caomeiLost;
			} else if (res == 5) {
				double xiguaWin = betDomain.getXigua() * 5 + betDomain.getDa()
						* 1.8 + betDomain.getDan() * 1.8;

				double xigualost = mustlost;
				// + betDomain.getXiao() + betDomain.getShuang();

				win += xiguaWin;
				lost += xigualost;
				xig += xiguaWin - xigualost;
			} else if (res == 6) {
				double xiangjiaoWin = betDomain.getXiangjiao() * 5
						+ betDomain.getDa() * 1.8 + betDomain.getShuang() * 1.8;

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

	private static List<BetDomain> generateList() {
		/*
		 * Iterator<BetDomain> it = ScheduledExecutorController.list.iterator();
		 * while (it.hasNext()) { it.remove(); }
		 */
		list = new ArrayList<BetDomain>();
		Random random = new Random();
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
		}

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
