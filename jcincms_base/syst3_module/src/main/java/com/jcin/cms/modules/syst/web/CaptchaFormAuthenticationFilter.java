package com.jcin.cms.modules.syst.web;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcin.cms.modules.syst.web.captchaexception.IncorrectCaptchaException;

public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {
	private boolean captchaEnabled;
	
	private static final Logger LOG = LoggerFactory.getLogger(CaptchaFormAuthenticationFilter.class);
	
	public CaptchaFormAuthenticationFilter() {
	}
	@Override
	/**
	 * 登录验证
	 */
	protected boolean executeLogin(ServletRequest request,
			ServletResponse response) throws Exception {
		
		CaptchaUsernamePasswordToken token = createToken(request, response);
		try {
			/*图形验证码验证*/
			if(captchaEnabled)
				doCaptchaValidate((HttpServletRequest) request, token);
			super.executeLogin(request, response);
			LOG.info(token.getUsername()+"登录成功");
			return true;
		}catch (AuthenticationException e) {
			LOG.info(token.getUsername()+"登录失败--"+e);
			request.getRequestDispatcher("/admin/login").forward(request, response);
			return false;
		}
	}

	// 验证码校验
	protected void doCaptchaValidate(HttpServletRequest request,
			CaptchaUsernamePasswordToken token) {
		//session中的图形码字符串
		String captcha = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		//比对
		if (captcha != null && !captcha.equalsIgnoreCase(token.getCaptcha())) {
			request.setAttribute("shiroLoginFailure", IncorrectCaptchaException.class.getName());
			throw new IncorrectCaptchaException("验证码错误！");
		}
	}

	@Override
	protected CaptchaUsernamePasswordToken createToken(ServletRequest request,
			ServletResponse response) {
		String username = getUsername(request);
		String password = getPassword(request);
		String captcha = getCaptcha(request);
		boolean rememberMe = isRememberMe(request);
		String host = getHost(request);

		return new CaptchaUsernamePasswordToken(username,
				password.toCharArray(), rememberMe, host, captcha);
	}

	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";

	private String captchaParam = DEFAULT_CAPTCHA_PARAM;

	public String getCaptchaParam() {
		return captchaParam;
	}

	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}

	protected String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, getCaptchaParam());
	}
	
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
}
