/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-10-6,下午7:11:34
 *
 */
package com.jcin.cms.modules.syst.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class CreatedTb implements Serializable{
	private String table_name;
	private List list;
	
	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public CreatedTb(String table_name, String calla,
			Timestamp strtinme, Timestamp vtime, Integer leixing) {
		super();
		this.table_name = table_name;
		this.calla = calla;
		this.strtinme = strtinme;
		this.vtime = vtime;
		this.leixing = leixing;
	}
	
	public CreatedTb() {
		super();
	}

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCalla() {
		return calla;
	}

	public void setCalla(String calla) {
		this.calla = calla;
	}

	public Timestamp getStrtinme() {
		return strtinme;
	}

	public void setStrtinme(Timestamp strtinme) {
		this.strtinme = strtinme;
	}

	public Timestamp getVtime() {
		return vtime;
	}

	public void setVtime(Timestamp vtime) {
		this.vtime = vtime;
	}

	public Integer getLeixing() {
		return leixing;
	}

	public void setLeixing(Integer leixing) {
		this.leixing = leixing;
	}

	private String calla;
	private Timestamp strtinme;
	private Timestamp vtime;
	private Integer leixing;
}
