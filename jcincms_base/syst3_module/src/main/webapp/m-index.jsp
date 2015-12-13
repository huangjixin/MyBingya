<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>移动端首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- viewport是网页默认的宽度和高度，上面这行代码的意思是，网页宽度默认等于屏幕宽度（width=device-width），原始缩放比例（initial-scale=1）为1.0，即网页初始大小占屏幕面积的100%。 -->
<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/slider.js"></script>
<script type="text/javascript" src="${ctx}/js/webtry_roll.js"></script>
<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<style type="text/css">
@charset "utf-8";
/*
 * By jasonshan@tencent.com
 * date 2013.9.18
 * v  1.0
 * 适配首页样式
 */
/*reset*/
body,div,ol,ul,h1,h2,h3,h4,h5,h6,p,th,td,dl,dd,form,iframe,input,textarea,select,label,article,aside,footer,header,menu,nav,section,time,audio,video
	{
	margin: 0;
	padding: 0;
}

article,aside,footer,header,hgroup,nav,section,audio,canvas,video,img {
	display: block;
}

body { /* font: normal 100% Helvetica, Arial, sans-serif; */
	font-size: 100%;
	font-family: Helvetica, STHeiti, Droid Sans Fallback;
	-webkit-text-size-adjust: 100%;
	-ms-text-size-adjust: 100%;
	-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
}

textarea {
	resize: none;
}

iframe,img {
	border: 0;
}

ul,ol {
	list-style: none;
}

input,select,textarea {
	outline: 0;
	-webkit-user-modify: read-write-plaintext-only;
}

input {
	-webkit-appearance: none;
}

a {
	text-decoration: none;
}

body,.global {
	background: #fafafa
}

/*header*/
.header {
	width: 100%;
	border-bottom: 2px solid #317ecb;
}

.logo {
	display: inline-block;
	text-indent: -9999em;
	width: 102px;
	height: 30px;
	background-image: url(http://mat1.gtimg.com/www/mobi/image/logo.png);
	background-repeat: no-repeat;
	background-position: 0 0;
	-webkit-background-size: 102px 30px;
	-moz-background-size: 102px 30px;
	-o-background-size: 102px 30px;
	background-size: 102px 30px;
	margin: 7px 0 0 10px;
}

.logo a {
	display: block;
}

/*************** 幻灯片开始***********************/
.focus {
	width: 100%;
    min-height: 165px; max-height: 165px;
	/* padding: 2px;
	border: 1px solid #E1E1E1; */
	background: #fff;
	position: relative
}
.focus img{
    max-width: 100%;
    margin: 0 auto
}
.focus .sliderwrapper span {
	display: block;
	width: 100%;
	height: 32px;
	background: #000;
	filter: alpha(opacity = 70);
	-moz-opacity: 0.7;
	opacity: 0.7;
	position: absolute;
	left: 0px;
	top: 150px
}

.focus .pagination {
	position: absolute;
	top:155px;
	right:0;
}

.focus .pagination a {
	width: 19px;
	height: 19px;
	line-height: 19px;
	display: inline;
	float: left;
	margin-right: 7px;
	cursor: pointer;
	background: #fff;
	text-align: center
}

.focus .pagination a:hover,.focus .pagination a.selected {
	background: #FB7E39;
	color: #fff
}

.focus a {
	color: #444;
	text-decoration: none;
	outline: none
}

.focus a:hover {
	color: #c00;
	text-decoration: underline
}
/************** 幻灯片结束***********************/

/************** 菜单开始 **************************/
.menu {
	height: 40px;
	font-size: 14px;
	background: #212121;
	z-index: 3;
	display: block;
}

.menu ul {
	margin: 0;
	padding: 0;
	float: left;
	list-style: none;
	background: #222;
}

.menu ul a {
	color: #FFF;
	display: block;
	padding: 0 15px;
	text-decoration: none;
}

.menu ul a:hover {
	color: #FFF;
}

.menu ul li {
	margin: 0;
	padding: 0;
	float: left;
	height: 40px;
	line-height: 40px;
	white-space: nowrap;
}

.menu ul li:hover {
	position: relative;
	background: #62b00e;
}

.menu ul li:hover>ul {
	display: block;
}

.menu ul ul {
	z-index: 9999;
	top: 100%;
	left: 0;
	display: none;
	background: #222;
	position: absolute;
	/* border: 1px solid #888; */
}

.menu ul ul li {
	clear: both;
	min-width: 100%;
}

.menu ul ul ul {
	top: 2px;
	left: 100%;
}

.menu ul ul ul ul ul ul {
	left: auto;
	right: 100%;
}

/************** 菜单结束 **************************/

/*------
list*/
.list {
	padding: 0 8px 0;
}

.list li {
	overflow: hidden;
	border-bottom: 1px solid #eceef0;
	box-shadow: 0 1px 1px #fff;
}

.list li a {
	display: block;
	color: #000;
}

/*topnews 要闻*/
.topnews {
	padding: 5px 8px;
}

.topnews li {
	height: 35px;
	line-height: 35px;
	/*padding: 0 9px 0 60px;*/
	position: relative;
	min-width: 234px;
	word-wrap: break-word;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

.topnews li strong {
	font-style: normal;
	font-weight: normal;
	position: relative;

	/*    position: absolute;
    left: 9px;*/
}

.topnews li strong a {
	color: #458fce;
	display: inline-block;
}

.list li strong a {
	color: #458fce;
}

.list li strong a:visited {
	color: #458fce;
}

.topnews li strong,.topnews li span {
	font-size: 1.0625em;
	/*font-size: 1em;*/
}

.topnews li span { /*display: inline-block;*/
	/*width: 100%; */
	
}

.topnews li span a {
	color: #111;
	display: inline;
}

.topnews li strong:after {
	content: "|";
	color: #d5d5d5;
	/*display: inline-block;*/
	font-size: 1em;
	margin: 0 6px;
	/*    position: absolute;
    right: -10px;
    top: 0;*/
}

.topnews li:last-of-type {
	border-bottom: none;
	box-shadow: none;
	/*display: none;*/
}

.topnews li:last-child() {
	
}

/*module*/
.module {
	overflow: hidden;
}

.module,.module .content {
	width: 100%;
}

.module .content {
	display: -webkit-box;
	display: -ms-flexbox;
	padding-bottom: 23px;
}

.module .panel {
	width: 100%;
	position: relative;
	float: left;
}

/*head*/
.head {
	height: 38px;
	border-top: 2px solid #9ac7ed;
	background-image: url(http://mat1.gtimg.com/www/mobi/image/headbg.png);
	background-repeat: no-repeat;
	-webkit-background-size: 320px 62px;
	-moz-background-size: 320px 62px;
	-o-background-size: 320px 62px;
	background-size: 320px 62px;
	background-position: left -31px;
}

.head h2 { /*font-size: 1em;*/
	font-size: 1em;
	font-weight: normal;
	display: inline-block;
	text-align: center;
	float: left;
	width: 80px;
	height: 40px;
	line-height: 40px;
	color: #2a70be;
}

.head h2.current {
	border-top: 2px solid #2a70be;
	margin-top: -2px;
	background-image: url(http://mat1.gtimg.com/www/mobi/image/tab_ui.png);
	background-repeat: no-repeat;
	-webkit-background-size: 80px 40px;
	-moz-background-size: 80px 40px;
	-o-background-size: 80px 40px;
	background-size: 80px 40px;
	background-position: left top;
	color: #c14545;
}

#footer {
	width: 100%;
	height: 50px;
	line-height: 50px;
	text-align: center;
	font-size: 0.75em;
}
</style>
</head>

<body>
	<div class="header">
		<a href="${ctx}/"><img alt="logo" src="${ctx}/images/logo.gif"
			style="height: 40px;" /></a>
	</div>
	<%-- <div id="header">
	</div> --%>
	<div class="menu"
		style="height:40px;z-index:3;background:#212121;top:0; left:0; display:block;">
		<ul>
			<c:if test="${list!=null}">
				<c:forEach var="channel" items="${list}">
					<c:if test="${channel.name!=null && channel.name!=''}">
						<li><a href="${ctx}/${channel.linkAddr}">${channel.name}</a></li>
					</c:if>
				</c:forEach>
			</c:if>
			<!-- <li><a href="/program/1/index.html">ASP编程教程</a></li>
			<li><a href="/program/2/index.html">PHP编程教程</a></li>
			<li><a href="/program/3/index.html">MySQL数据库</a></li>
			<li><a href="/program/6/index.html">Access数据库</a></li>
			<li><a href="/program/8/index.html">jQuery编程</a></li>
			<li><a href="/program/1/index.html">ASP编程教程</a></li>
			<li><a href="/program/2/index.html">PHP编程教程</a></li>
			<li><a href="/program/3/index.html">MySQL数据库</a></li>
			<li><a href="/program/6/index.html">Access数据库</a></li>
			<li><a href="/program/8/index.html">jQuery编程</a></li> -->
		</ul>
	</div>
	<div id="picnav">
		<div class="focus">
			<div id="sliderA" class="sliderwrapper">
				<div class="contentdiv">
					<div>
						<a href="#" target="_blank"><img src="${ctx}/images/0.jpg"
							alt="" border="0" /></a>
					</div>
					<span>野猴占宅为王 房东用计抓捕</span>
				</div>
				<div class="contentdiv">
					<div>
						<a href="#" target="_blank"><img src="${ctx}/images/1.jpg"
							alt="" border="0" /></a>
					</div>
					<span>中国海军舰艇将赴南海训练</span>
				</div>
			</div>
			<div id="paginate-sliderA" class="pagination">
				<i class="toc"></i><i class="toc"></i><i class="toc"></i><i
					class="toc"></i>
			</div>
		</div>
	</div>
	<div style="height: 20px;"></div>
	<div class="list topnews">
		<ul>
			<c:if test="${recommendDocs!=null}">
				<c:forEach var="doc" items="${recommendDocs}">
					<c:choose>
						<c:when test="${doc.channel!=null}">
							<li><a href="${ctx}/${doc.channel.linkAddr}/doc/${doc.id}">${doc.title}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${ctx}/channel/recommend/doc/${doc.id}">${doc.title}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:if>
		</ul>
	</div>
	<c:if test="${list!=null}">
		<c:forEach var="channel" items="${list}" varStatus="status">
			<div class="module">
				<div class="head">
					<h2 class="current" data-tab="news">${channel.name}</h2>
				</div>
				<div class="list topnews">
					<ul>
						<c:set var="docs"
							value="${fns:getDocByChannelCode(channel.code,10)}"></c:set>
						<c:if test="${docs!=null}">
							<c:forEach var="doc" items="${docs}">
								<li><a href="${ctx}/${channel.linkAddr}/doc/${doc.id}">${doc.title}</a></li>
							</c:forEach>
						</c:if>
					</ul>
				</div>
			</div>
		</c:forEach>
	</c:if>
	<div>
		<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;" />
	</div>
	<div id="footer" style="text-align: center;padding-bottom: 5px;">Copyright
		© 2011-2015 jcincms内容管理系统.</div>
	<script type="text/javascript">
		featuredcontentslider.init({
			id : "sliderA",
			contentsource : [ "inline", "" ],
			toc : "#increment",
			nextprev : [ "", "" ],
			revealtype : "mouseover",
			enablefade : [ true, 0.15 ],
			autorotate : [ true, 3500 ],
			delay : 150,
			onChange : function(previndex, curindex) {
			}
		});
	</script>
</body>
</html>
