/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2016-3-12,上午10:00:50
 *
 */
package com.jcin.cms.modules.syst.web;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class SysFormAuthenticationFilter extends FormAuthenticationFilter {
	
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		return super.onLoginSuccess(token, subject, request, response);
	}
	
	@Override
	public void setSuccessUrl(String successUrl) {
		super.setSuccessUrl(successUrl);
	}
	
	@Override
	public String getSuccessUrl() {
		String succUrl =super.getSuccessUrl(); 
		return succUrl;
	}
}
