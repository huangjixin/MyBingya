package com.jcin.cms.service.system.impl.vo;

import java.io.Serializable;
import java.util.List;

import com.jcin.cms.domain.system.Authorization;

public class AuthorizationExtention extends Authorization implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<AuthorizationExtention> children;

	private String text;
	
	public List<AuthorizationExtention> getChildren() {
		return children;
	}

	public void setChildren(List<AuthorizationExtention> children) {
		this.children = children;
	}

	public String getText() {
		return this.getName();
	}

	public void setText(String text) {
		this.text = this.getName();
	}

}