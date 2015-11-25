<%@page import="com.jcin.cms.common.Global"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<% 
	Subject subject = SecurityUtils.getSubject();
	if (subject.isAuthenticated()) {
		response.sendRedirect(request.getContextPath()+"/"+Global.getAdminPath());	
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="login，登录">
<meta http-equiv="description" content="login，登录">
<link rel="stylesheet" type="text/css" href="${ctx}/logincss/css/reset.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/logincss/css/login.css" />
<script type="text/javascript">
	function submitData(){
		document.getElementById("formLogin").submit();
	}
	function refreshCaptcha(){  
		    document.getElementById("img_captcha").src="${ctx}/images/kaptcha.jpg?t=" + Math.random();  
	}
</script>
</head>

<body style="text-align: center; margin: 0 auto;">
	<div class="logintop">
		<div class="logoname"></div>
	</div>
	<div class="loginCont">
		<div class="loginBox">
			<div class="box">
				<form id="formLogin" action="${ctx}/admin/login"  method="post">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="logintab">
						<tr>
							<th>用户名</th>
							<td>
								<div class="loginipt">
									<span class="useric"></span> <input type="text"
										name="username" id="username" value="admin" />
								</div>
							</td>
						</tr>
						<tr>
							<th>密&nbsp;&nbsp;码</th>
							<td>
								<div class="loginipt focus">
									<span class="lockic"></span> <input type="password"
										name="password" id="password" value="123456" />
								</div>
							</td>
						</tr>
						<c:if test="${captchaEnabled==true}">
						<tr>
							<th>验证码</th>
							<td>
								<div class="loginipt focus">
									<input type="text" name="captcha" />
								</div>
							</td>
						</tr>
						</c:if>
					</table>
					<div>
						<c:if test="${captchaEnabled==true}">
							<img id="img_captcha" alt="验证码" src="${ctx}/images/kaptcha.jpg" title="点击更换"  onclick="javascript:refreshCaptcha();">
						</c:if>
						<a id="btn_login" class="greBtn" onclick="submitData();">登录</a><input id="subBtn" type="submit" style="display: none;">
					</div>
					
					<p id="hintMsg" class="remind">&emsp;${error}</p>
				</form>
			</div>
		</div>
	</div>
	<%-- <form action="<%=basePath%>admin/login" method="post">
		<br />用户帐号： <input type="text" name="username" id="username" value="" />
		<br />登录密码： <input type="password" name="password" id="password"
			value="" /> <br /> <input type="hidden" name="rememberMe"
			value="true" /> <input value="登录" type="submit"> <br />
		<h6>${error}</h6>
	</form> --%>
</body>
</html>
