<%@page import="com.jcin.cms.common.Global"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<%
	Subject subject = SecurityUtils.getSubject();
	if (subject.isAuthenticated()) {
		response.sendRedirect(request.getContextPath() + "/"
				+ Global.getAdminPath());
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
<link rel="stylesheet" type="text/css"
	href="${ctx}/logincss/css/reset.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/logincss/css/login.css" />
<script type="text/javascript">
	function submitData(){
		document.getElementById("formLogin").submit();
	}
	function refreshCaptcha(){  
		    document.getElementById("img_captcha").src="${ctx}/images/kaptcha.jpg?t=" + Math.random();  
	}
</script>

<link href="${ctxAdmin}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.form.js"></script>
<script type="text/javascript" src="${ctxAdmin}/js/cloud.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/js/localization/messages_zh.js"></script>
<script language="javascript">
	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
		})
		
		$("#formLogin").validate({
			errorPlacement: function(error, element) {
			$( element )
				.closest( "form" ).find( "label[for='" + element.attr( "id" ) + "']" )
						.append( error );
		},
		errorElement: "span",
			rules : {
				username : {
					required : true
				},
				password : {
					required : true
				}
			},
			messages : {
				username : {
					required : "必填",
				},
				password : {
					required : "必填",
				}
			},submitHandler:function(form) {
				document.getElementById("tip").innerHTML = "正在登陆……";
				var param = {
				        username : $("#username").val(),
				        password : $("#password").val()
				};
				$.ajax({ 
			        type: "post", 
			        url: "${ctxAdmin}/login", 
			        data: param, 
			        success: function(data) { 
			            if(data == 'success'){
			            	 //登录成功
			                window.location.href = "${ctxAdmin}/";
			            }else{
			            	document.getElementById("tip").innerHTML = "用户名/密码错误";
			            }
			        },
			        error: function(data) { 
			            alert("调用失败...."); 
			        }
			    });
				
				return false;
  			}
		})
	});
</script>
</head>

<body
	style="background-color:#1c77ac; background-image:url(${ctxAdmin}/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>
	<div class="logintop">
		<span>欢迎登录后台管理界面平台</span>
		<ul>
			<li><a href="${ctx}/">回首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>

	<div class="loginbody">
		<span class="systemlogo"></span>
		<form id="formLogin" action="${ctx}/admin/login" method="post">
			<div class="loginbox">
				<ul>
					<li><input id="username" name="username" type="text"
						class="loginuser" value="admin" /><label for="username" style="color:red;">*</label></li>
					<li><input id="password" name="password" type="password"
						class="loginpwd" value="123456" /><label for="password" style="color:red;">*</label></li>
					<li><input type="submit" class="loginbtn" value="登录" />&nbsp;&nbsp;<input
						type="reset" class="loginbtn" value="重置" />&nbsp; <%-- <input name="captcha"
						value=""
						style="width: 50px;height: 30px;border:1px solid;border-color: #000;" /><img
						id="img_captcha" alt="验证码" src="${ctx}/images/kaptcha.jpg" style="border: none;"
						title="点击更换" onclick="javascript:refreshCaptcha();"> --%>
					<!-- <label><a
							href="#">忘记密码？</a></label> --></li>
					<li><span id="tip" style="color: red;">${error}</span></li>
				</ul>
			</div>
		</form>
	</div>
	<div class="loginbm">广州智沃科技版权所有</div>
	<%-- <div class="logintop">
		<div class="logoname"></div>
	</div>
	<div class="loginCont">
		<div class="loginBox">
			<div class="box">
				<form id="formLogin" action="${ctx}/admin/login" method="post">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="logintab">
						<tr>
							<th>用户名</th>
							<td>
								<div class="loginipt">
									<span class="useric"></span> <input type="text" name="username"
										id="username" value="admin" />
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
							<img id="img_captcha" alt="验证码" src="${ctx}/images/kaptcha.jpg"
								title="点击更换" onclick="javascript:refreshCaptcha();">
						</c:if>
						<a id="btn_login" class="greBtn" onclick="submitData();">登录</a><input
							id="subBtn" type="submit" style="display: none;">
					</div>

					<p id="hintMsg" class="remind">&emsp;${error}</p>
				</form>
			</div>
		</div>
	</div> --%>
	<%-- <form action="<%=basePath%>admin/login" method="post">
		<br />用户帐号： <input type="text" name="username" id="username" value="" />
		<br />登录密码： <input type="password" name="password" id="password"
			value="" /> <br /> <input type="hidden" name="rememberMe"
			value="true" /> <input value="登录" type="submit"> <br />
		<h6>${error}</h6>
	</form> --%>
</body>
</html>
