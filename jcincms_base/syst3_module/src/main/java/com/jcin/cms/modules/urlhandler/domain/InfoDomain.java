/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2016-3-13,下午8:31:23
 *
 */
package com.jcin.cms.modules.urlhandler.domain;

import java.io.Serializable;

public class InfoDomain  implements Serializable{
	private static final long serialVersionUID = 1L;
	private int countTime;
	private int count;
	private int currentLuckyNum;
	private String status;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCountTime() {
		return countTime;
	}

	public void setCountTime(int countTime) {
		this.countTime = countTime;
	}

	public int getCurrentLuckyNum() {
		return currentLuckyNum;
	}

	public void setCurrentLuckyNum(int currentLuckyNum) {
		this.currentLuckyNum = currentLuckyNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
