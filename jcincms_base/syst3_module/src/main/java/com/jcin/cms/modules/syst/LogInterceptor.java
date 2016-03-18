package com.jcin.cms.modules.syst;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jcin.cms.common.Global;
import com.jcin.cms.common.SpringUtils;
import com.jcin.cms.common.UserUtils;
import com.jcin.cms.modules.syst.dao.LogMapper;
import com.jcin.cms.modules.syst.domain.Log;
import com.jcin.cms.modules.syst.domain.User;

/**
 * 系统拦截器
 * 
 * @author lcw
 * @version 2013-6-6
 */
public class LogInterceptor implements HandlerInterceptor {

	private static Logger logger = Logger.getLogger(LogInterceptor.class
			.getName());

//	private static LogMapper logDao = SpringUtils.getBean(LogMapper.class);

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		String requestRri = request.getRequestURI();
		String uriPrefix = request.getContextPath() + "/"+Global.getAdminPath();
		String method = request.getMethod().toLowerCase();
		boolean oper = (requestRri.indexOf("/create")!=-1
				|| requestRri.indexOf("/update/")!=-1 ||requestRri.indexOf("/delete")!=-1) && "post".equals(method);
		if (ex != null
				|| (StringUtils.startsWithIgnoreCase(requestRri, uriPrefix) && oper)) {

			User user = UserUtils.getUser();
			if (user != null && user.getId() != null) {

				StringBuilder params = new StringBuilder();
				int index = 0;
				for (Object param : request.getParameterMap().keySet()) {
					params.append((index++ == 0 ? "" : "&") + param + "=");
					if ("password".equals(param.toString())) {
						params.append("");
					} else {
						String value = request.getParameter((String) param);
						if(value.length()>100){
							value = value.substring(0, 100);
						}
						
						params.append(value);
					}
				}

				Log log = new Log();
				log.setType(ex == null ? "access" : "exception");
				 log.setId(new Date().getTime()+"");
				 log.setCreateBy(user.getUsername());
				// log.setCreateDate(new Date());
				log.setRemoteAddr(uriPrefix);
//				log.setUserAgent(request.getHeader("user-agent"));
				log.setRequestUri(requestRri);
				log.setMethod(request.getMethod());
				log.setParams(params.toString());
				log.setException(ex != null ? ex.toString() : "");
//				logDao.insert(log);

				logger.debug("save log {type: {" + log.getType()
						+ "}, loginName: {" + user.getUsername() + "}, uri: {"
						+ log.getRequestUri() + "}}, ");

			}
		}

		// logger.debug("最大内存: {}, 已分配内存: {}, 已分配内存中的剩余空间: {}, 最大可用内存: {}",
		// Runtime.getRuntime().maxMemory(), Runtime.getRuntime().totalMemory(),
		// Runtime.getRuntime().freeMemory(),
		// Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory());

	}
}
