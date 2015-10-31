<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>JCMS -- Powerd by jcin</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="演示站 JSPX 站长 资讯 创业 小说程序 运营 管理 ">
<meta http-equiv="description"
	content="这是JCMS的演示站点，包含了新闻、图集、视频、下载、在线留言等模块，能够轻松方便构件您的站点。">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
/*---------- base ---------*/
* {
	padding: 0px;
	margin: 0px;
}

html {
	background: #FFF;
}

body {
	font: 12px Verdana, Arial, Tahoma;
}

img {
	border: none;
}

a {
	color: #256EB1;
	text-decoration: none;
}

a:hover {
	color: #ba2636;
	text-decoration: underline;
}

ul {
	list-style: none;
}

input,select,button {
	font: 12px Verdana, Arial, Tahoma;
	vertical-align: middle;
}
/*---------- base end---------*/
.container { /* 	width: 1000; */
	margin: 0 auto; /*设置整个容器在浏览器中水平居中*/
	/* 	background: #CF3; */
}

#header {
	height: 60px;
	min-width: 960px;
	width: auto !important;
	margin: 0px auto;
	background: #fff;
	width: auto !important;
	margin: 0px auto;
	background: #fff;
}

.topNav {
	float: right;
	margin-top: 23px;
}

.logo {
	width: 960px;
	overflow: hidden;
	margin: 0 auto;
	position: relative;
}
/* .logo .new_logo{position:absolute;top:7px;} */
.logo img {
	vertical-align: middle;
}

#menu {
	width: 960px;
	overflow: hidden;
	margin: 0 auto;
	position: relative;
}

.content {
	margin: 0 auto;
	width: 960px;
	overflow: auto;
	/* 	height: 600px; */
	/*此处对容器设置了高度，一般不建议对容器设置高度，一般使用overflow:auto;属性设置容器根据内容自适应高度，如果不指定高度或不设置自适应高度，容器将默认为1个字符高度，容器下方的布局元素（footer）设置margin-top:属性将无效*/
	margin-top: 0px; /*此处讲解margin的用法，设置content与上面header元素之间的距离*/
/* 	background: #0FF; */
}

.content-Left {
	height: 400px;
	width: 200px;
	margin: 0px; /*设置元素跟其他元素的距离为20像素*/
	float: left; /*设置浮动，实现多列效果，div+Css布局中很重要的*/
	background: #9ed;
}

.content-Main {
/* 	height: 400px; */
	width: 760px;
	margin: 0px; /*设置元素跟其他元素的距离为20像素*/
	float: left; /*设置浮动，实现多列效果，div+Css布局中很重要的*/
/* 	background: #90C; */
}
/*注：Content-Left和Content-Main元素是Content元素的子元素，两个元素使用了float:left;设置成两列，这个两个元素的宽度和这个两个元素设置的padding、margin的和一定不能大于父层Content元素的宽度，否则设置列将失败*/
.footer {
	height: 40px;
	background: #aaC;
	margin-top: 0px;
}

.Clear {
	clear: both;
}
</style>
</head>

<body>
	<div class="container">
		<div id="header">
			<div class="logo">
				<a href="/" class="new_logo"><img title="郑州新开普电子股份有限公司首页"
					src="http://www.newcapec.com.cn/images/logo/logo.png" alt="公司logo" /></a>
				<div class="topNav">
					<a>首页</a> | <a>首页</a> | <a>首页</a> | <a>首页</a> | <a>首页</a>
				</div>
			</div>
		</div>
		<div id="menu">
			<c:forEach var="channel" items="${list}">
				<b>${channel.name }</b>
			</c:forEach>
		</div>
		<div class="content">
			<!-- <div class="content-Left">Content-Left</div> -->
			<div class="content-Main">
				<c:forEach var="chan" items="${list}">
					<a href="${chan.linkAddr}">${chan.name}</a>
					<br>
					<c:forEach var="doc" items="${fns:getDocByChannelId(chan.id)}">
						<a href="${chan.linkAddr}/${doc.id}" target="_blank">${doc.title}</a>
						<br>
					</c:forEach>
					<br>
				</c:forEach>
			</div>
		</div>
		<div class="clear">
			<!--如何你上面用到float,下面布局开始前最好清除一下。-->
		</div>
		<div class="footer">Footer</div>
	</div>
</body>
</html>
