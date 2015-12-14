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
<link rel="stylesheet" type="text/css" href="${ctx}/css/m-demo.css">
</head>
<body>
	<div class="header">
		<a href="${ctx}/"><img alt="logo" src="${ctx}/images/logo.gif"
			style="height: 40px;" /></a>
	</div>
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
