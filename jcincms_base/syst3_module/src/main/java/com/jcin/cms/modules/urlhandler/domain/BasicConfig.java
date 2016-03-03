package com.jcin.cms.modules.urlhandler.domain;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("basicConfig")
public class BasicConfig implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * 首页模板位置。
	 */
	@Value("${web.indexTemp}")
	private String indexTemp;
	@Value("${web.mindexTemp}")
	/**
	 * 移动首页模板位置
	 */
	private String mindexTemp;
	@Value("${web.indexJsp}")
	/**
	 * 首页JSP位置
	 */
	private String indexJsp;
	
	@Value("${web.mindexJsp}")
	/**
	 * 移动首页JSP位置
	 */
	private String mindexJsp;


	public String getIndexTemp() {
		return indexTemp;
	}

	public void setIndexTemp(String indexTemp) {
		this.indexTemp = indexTemp;
	}

	public String getMindexTemp() {
		return mindexTemp;
	}

	public void setMindexTemp(String mindexTemp) {
		this.mindexTemp = mindexTemp;
	}

	public String getIndexJsp() {
		return indexJsp;
	}

	public void setIndexJsp(String indexJsp) {
		this.indexJsp = indexJsp;
	}
	
	public String getMindexJsp() {
		return mindexJsp;
	}

	public void setMindexJsp(String mindexJsp) {
		this.mindexJsp = mindexJsp;
	}
}