/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2016-3-11,下午3:03:37
 *
 */
package com.jcin.cms.modules.urlhandler.domain;

import java.io.Serializable;

import com.jcin.cms.modules.bet.domain.FruitBetresult;

public class BetDomain extends FruitBetresult implements Serializable {

	private static final long serialVersionUID = 1L;

	public void setMoney(int s,double money){
		if (s == 1) {
			setPingguo(money);
		} else if (s == 2) {
			setPutao(money);
		} else if (s == 3) {
			setBoluo(money);
		} else if (s == 4) {
			setCaomei(money);
		} else if (s == 5) {
			setXigua(money);
		} else if (s == 6) {
			setXiangjiao(money);
		} 
	}
	
	public double getTotal(){
		return getPingguo()+getPutao()+getBoluo()+getCaomei()+getXigua()+getXiangjiao()+getDa()+getXiao()+getDan()+getShuang();
	}
}
