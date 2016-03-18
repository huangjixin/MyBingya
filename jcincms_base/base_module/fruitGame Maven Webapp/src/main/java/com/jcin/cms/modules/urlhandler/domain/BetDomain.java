/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2016-3-11,下午3:03:37
 *
 */
package com.jcin.cms.modules.urlhandler.domain;

import java.io.Serializable;

public class BetDomain implements Serializable {

	public BetDomain() {
		super();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  int pingguo ;
	private  int putao ;
	private  int boluo ;
	private  int caomei ;
	private  int xigua ;
	private  int xiangjiao ;
	private  int xiao ;
	private  int da ;
	private  int dan ;
	private  int shuang ;
	
	public void setMoney(int s,int money){
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
	public int getPingguo() {
		return pingguo;
	}
	public void setPingguo(int pingguo) {
		this.pingguo = pingguo;
	}
	public int getPutao() {
		return putao;
	}
	public void setPutao(int putao) {
		this.putao = putao;
	}
	public int getBoluo() {
		return boluo;
	}
	public void setBoluo(int boluo) {
		this.boluo = boluo;
	}
	public int getCaomei() {
		return caomei;
	}
	public void setCaomei(int caomei) {
		this.caomei = caomei;
	}
	public int getXigua() {
		return xigua;
	}
	public void setXigua(int xigua) {
		this.xigua = xigua;
	}
	public int getXiangjiao() {
		return xiangjiao;
	}
	public void setXiangjiao(int xiangjiao) {
		this.xiangjiao = xiangjiao;
	}
	public int getXiao() {
		return xiao;
	}
	public void setXiao(int xiao) {
		this.xiao = xiao;
	}
	public int getDa() {
		return da;
	}
	public void setDa(int da) {
		this.da = da;
	}
	public int getDan() {
		return dan;
	}
	public void setDan(int dan) {
		this.dan = dan;
	}
	public int getShuang() {
		return shuang;
	}
	public void setShuang(int shuang) {
		this.shuang = shuang;
	}
	
}
