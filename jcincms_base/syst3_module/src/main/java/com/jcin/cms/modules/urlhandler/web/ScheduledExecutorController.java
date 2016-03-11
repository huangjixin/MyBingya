/**
 * 一句话描述该类：倒计时控制器<br/>
 * @author 黄记新
 * @date 2016-3-11,上午9:53:26
 *
 */
package com.jcin.cms.modules.urlhandler.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	private static int countTime = 30;

	
	public ScheduledExecutorService scheduExec = Executors
			.newScheduledThreadPool(1);

	@RequestMapping(value = { "", "game" })
	public String channels(Model uiModel, HttpServletRequest httpServletRequest) {
		uiModel.addAttribute("countTime", countTime);
		uiModel.addAttribute("time", getTime());
		return "game.jsp";
	}

	@RequestMapping(value = { "startUp" })
	@ResponseBody
	public void startUp() {
		if (scheduExec.isShutdown() || scheduExec.isTerminated()) {
			scheduExec = Executors.newScheduledThreadPool(1);
			scheduExec.scheduleAtFixedRate(new Runnable() {
				@Override
				public void run() {
					countTime--;
					if (countTime == 0) {
						int way = generateLuckyNum();
						int resu = getRandom();
						if(way<=3){
							//计算最大化利益的值，更改结果。
							if(way==1){
								
							}else{
								//如果resu是利益持平的值，则返回它，否则返回打平值。
								
							}
						}else{
							//不干涉。
						}
						countTime = 30;
					}
					System.out.println(countTime + ";" + getTime());
				}
			}, 1, 1, TimeUnit.SECONDS);
		}
	}

	// 启动计时器
	private void lanuchTimer() {
		scheduExec.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				countTime--;
				if (countTime == 0) {
					try {
						Thread.sleep(60000);
						countTime = 30;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(countTime + ";" + getTime());
			}
		}, 1, 1, TimeUnit.SECONDS);
	}

	/**
	 * 关闭。
	 */
	@RequestMapping(value = { "shutDown" })
	@ResponseBody
	public void shutDown() {
		scheduExec.shutdownNow();
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

	// 1代表全吃，最低赔，2,3代表不输赔，其余代表不干涉。
	private static int generateLuckyNum() {
		int way = getArrayList();

		System.out.println("本盘的趋势是："+way+",1代表全吃，最低赔，2,3代表不输赔，其余代表不干涉。");
		return way;
	}

	// 在10之间取出一个数，决定本盘走势。
	private static int getArrayList() {
		Random random = new Random();
		int s = random.nextInt(10) + 1;
		return s;
	}

	public static void main(String[] args) {

		/*ScheduledExecutorController executorController = new ScheduledExecutorController();
		// executorController.lanuchTimer();
		for (int i = 0; i < 100; i++) {
			System.out.println(ScheduledExecutorController.getRandom());
		}*/
		List list = new ArrayList ();
		for (int i = 0; i < 1000; i++) {
			int way = generateLuckyNum();
			if(way==1||way==2||way==3){
				list.add(way);
			}
		}
		System.out.println("结束");
	}
}
