<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>安装向导</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>images/setup.css" />
</head>

<body>
	<div class="container">
		<div class="header">
			<h1>安装向导</h1>
		</div>
		<div class="main" style="margin-top:-123px;">
			<div class="licenseblock">
				<p style="color:red;padding-bottom:10px;text-align:center;">环境要求：JDK1.5或更高版本、MySQL5.0或更高版本、Tomcat5.5或更高版本。</p>
				<textarea style="width:100%;height:280px;">
  用户许可协议

  版权所有 (c)2010-2014，jspxcms.com

  保留所有权利。

  感谢您使用JCinCMS。

一、许可
  1.1 您可以在完全遵守本最终用户许可协议，特别是2.1条款，的基础上，将本软件应用于非商业和商业用途，而不必支付软件版权授权费用。
  1.2 您可以在协议规定的约束和限制范围内修改JCinCMS源代码(如果被提供的话)或界面风格以适应您的网站要求。
  1.3 您拥有使用本软件构建的网站中全部会员资料、文章及相关信息的所有权，并独立承担与文章内容的相关法律义务。
  1.4 在获得商业授权之后，您可以获得更多的软件功能，并且得到技术支持和服务。
  1.5 商业授权用户享有反映和提出意见的权力，并被优先考虑。

二、约束和限制
  2.1 无论如何，即无论用途如何、是否经过修改或美化、修改程度如何，只要使用JCinCMS的整体或任何部分，未经书面许可，网站所有页面标题（title）上的“Powered by JCinCMS”和页脚处的JCinCMS名称、链接（http://www.jspxcms.com/）都必须保留，而不能清除、修改或隐藏。
  2.2 不得对本软件或与之关联的商业授权进行出租、出售、抵押或发放子许可证。 
  2.3 禁止在JCinCMS的整体或任何部分基础上以发展任何派生版本、修改版本或第三方版本用于重新分发。
  2.4 如果您未能遵守本协议的条款，您的授权将被终止，所被许可的权利将被收回，并承担相应法律责任。

三、免责声明
  3.1 本软件及所附带的文件是作为不提供任何明确的或隐含的赔偿或担保的形式提供的。
  3.2 用户出于自愿而使用本软件，您必须了解使用本软件的风险，在尚未购买产品技术服务之前，我们不承诺提供任何形式的技术支持、使用担保，也不承担任何因使用本软件而产生问题的相关责任。
</textarea>
			</div>
		</div>
		<div class="btnbox marginbot">
			<form action="<%=basePath%>servlet/SetUpServlet?method=agreeSetup" method="post">
				<input type="hidden" name="step" value="0"> <input
					type="submit" name="submit" value="我同意" style="padding: 2px">&nbsp;
				<input type="button" name="exit" value="我不同意" style="padding: 2px"
					onclick="javascript: window.close(); return false;">
			</form>
		</div>
		<div class="footer">
			&copy;2014 - 2015 <a href="http://www.baidu.com/">JCinCMS</a>
		</div>
	</div>
</body>
</html>
