package com.jcin.cms.modules.syst.web;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcin.cms.modules.syst.web.captchaexception.IncorrectCaptchaException;

public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {
	private boolean captchaEnabled;
	
	private static final Logger LOG = LoggerFactory.getLogger(CaptchaFormAuthenticationFilter.class);
	
	//保存异常对象到request
	@Override
	protected void setFailureAttribute(ServletRequest request,
			AuthenticationException ae) {
		request.setAttribute(getFailureKeyAttribute(), ae);
	}
	
	public boolean isCaptchaEnabled() {
		return captchaEnabled;
	}
	public void setCaptchaEnabled(boolean captchaEnabled) {
		this.captchaEnabled = captchaEnabled;
	}
	
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
