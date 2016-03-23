/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2016-3-11,下午3:03:37
 *
 */
package com.jcin.cms.modules.urlhandler.domain;

import java.io.Serializable;

import com.jcin.cms.modules.bet.domain.FruitRecord;

public class BetResultDomain extends FruitRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  int num = 0;
	
	public BetResultDomain() {
		super();
	}
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}
