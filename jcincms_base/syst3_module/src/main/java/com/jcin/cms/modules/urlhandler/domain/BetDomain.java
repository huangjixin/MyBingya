/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2016-3-11,下午3:03:37
 *
 */
package com.jcin.cms.modules.urlhandler.domain;

import java.io.Serializable;

public class BetDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  int pingguo = 0;
	private  int putao = 0;
	private  int boluo = 0;
	private  int caomei = 0;
	private  int xigua = 0;
	private  int xiangjiao = 0;
	private  int xiao = 0;
	private  int da = 0;
	private  int dan = 0;
	private  int shuang = 0;
	
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
	public BetDomain(int pingguo, int putao, int boluo, int caomei, int xigua,
			int xiangjiao, int xiao, int da, int dan, int shuang) {
		super();
		this.pingguo = pingguo;
		this.putao = putao;
		this.boluo = boluo;
		this.caomei = caomei;
		this.xigua = xigua;
		this.xiangjiao = xiangjiao;
		this.xiao = xiao;
		this.da = da;
		this.dan = dan;
		this.shuang = shuang;
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
