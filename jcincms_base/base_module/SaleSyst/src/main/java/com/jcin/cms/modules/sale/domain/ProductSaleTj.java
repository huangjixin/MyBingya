/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2016-3-22,下午4:55:42
 *
 */
package com.jcin.cms.modules.sale.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductSaleTj  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private int procount;
	private double profit;
	private double s_total_amount;
	private double b_total_amount;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date pcreateDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date screateDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date bcreateDate;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProcount() {
		return procount;
	}

	public void setProcount(int procount) {
		this.procount = procount;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public double getS_total_amount() {
		return s_total_amount;
	}

	public void setS_total_amount(double s_total_amount) {
		this.s_total_amount = s_total_amount;
	}

	public double getB_total_amount() {
		return b_total_amount;
	}

	public void setB_total_amount(double b_total_amount) {
		this.b_total_amount = b_total_amount;
	}

	public Date getPcreateDate() {
		return pcreateDate;
	}

	public void setPcreateDate(Date pcreateDate) {
		this.pcreateDate = pcreateDate;
	}

	public Date getScreateDate() {
		return screateDate;
	}

	public void setScreateDate(Date screateDate) {
		this.screateDate = screateDate;
	}

	public Date getBcreateDate() {
		return bcreateDate;
	}

	public void setBcreateDate(Date bcreateDate) {
		this.bcreateDate = bcreateDate;
	}

}
