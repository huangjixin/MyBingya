package com.jcin.cms.service.system.impl.vo;

import java.io.Serializable;
import java.util.List;

import com.jcin.cms.domain.system.Menu;

public class MenuExtention extends Menu implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<MenuExtention> children;

	public List<MenuExtention> getChildren() {
		return children;
	}

	public void setChildren(List<MenuExtention> children) {
		this.children = children;
	}

}