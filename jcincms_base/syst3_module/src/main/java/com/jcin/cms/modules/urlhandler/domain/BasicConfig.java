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

	@Value("${web.indexTemp}")
	private String indexTemp;
	@Value("${web.mindexTemp}")
	private String mindexTemp;

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
}