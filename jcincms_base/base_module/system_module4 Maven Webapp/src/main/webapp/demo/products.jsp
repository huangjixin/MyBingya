<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>产品</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
/*body*/
#container {
	width: 100%;
	margin: 0 auto;
}

/*header*/
#header {
	height: 70px;
	background: #CCFFCC;
	margin-bottom: 8px;
}

#nav {
	height: 30px;
	background: #CCFFCC;
	margin-bottom: 8px;
}

  /*main*/  
#maincontent {
	margin-bottom: 8px;
}

#main {
	float: left;
	width: 664px;
	height: 500px;
	background: #FFFF99;
}

#side {
	float: right;
	width: 228px;
	height: 500px;
	background: #FFCC99;
}

  /*footer*/  
#footer {
	height: 70px;
	background: #CCFFCC;
}

.clear{
	float: none;
}
</style>
</head>

<body>
	<div id="container">
		<div id="header">此处显示 id "header" 的内容</div>
		<div id="nav">此处显示 id "nav" 的内容</div>
		<div id="maincontent">
			<div id="main">此处显示 id "main" 的内容</div>
			<div id="side">此处显示 id "side" 的内容</div>
		</div>
		<div class="clear"></div>
		<div id="footer">此处显示 id "footer" 的内容</div>
	</div>
</body>
</html>
