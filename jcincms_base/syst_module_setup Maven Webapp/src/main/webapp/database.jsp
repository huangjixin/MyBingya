<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-cache, no-store, max-age=0" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>数据库设置</title>
<style type="text/css">
#container {
	margin: 0 auto; /*设置整个容器在浏览器中水平居中*/
	padding: 20px;
}

#header {
	margin: 0 auto; /*设置整个容器在浏览器中水平居中*/
	text-align: center;
}

#content {
	width: 100%;
	text-align: center;
/* 	border: 1px solid #0000ff; */
}

#footer {
	margin-top:20px;
	width: 100%;
	text-align: center;
}
</style>
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>数据库设置</h1>
		</div>
		<div id="content">
			<div id="form" style="margin-top: 20px;">
				<form action="${ctx}/setup/database" method="get">
					<input
					type="submit" name="submit" value="我同意" style="padding: 2px">&nbsp;
				<input type="button" name="exit" value="我不同意" style="padding: 2px"
					onclick="javascript: window.close(); return false;">
				</form>
			</div>
		</div>
		<div id="footer">
			&copy;2010 - 2015 <a href="http://www.baidu.com/">JCinCMS</a>
		</div>
	</div>
</body>
</html>
