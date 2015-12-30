<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>${channel.name}</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="keywords" content="${channel.name},${channel.keyword}">
<meta name="description" content="${channel.name},${channel.keyword}">
<meta name="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/swiper.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/m-demo.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/swiper.js"></script>
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
		</ul>
	</div>
	<div style="width: 100%;background-color: #ececec;">
		<div style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px;">
			<a href="${ctx}/" style="color: #333333;">首页</a>
			<c:if test="${navChan !=null}">
					<c:forEach var="chan" items="${navChan}" varStatus="status">
						-<a href="${ctx}/${chan.linkAddr}" style="color: #333333;">${chan.name}</a>
					</c:forEach>
				</c:if>
		</div>
	</div>
	<div id="picnav">
		<div class="swiper-container swiper-container-fade">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<img src="${ctx}/images/79084479.jpg" width="400" height="200"
						border="0" />
				</div>
				<div class="swiper-slide">
					<img src="${ctx}/images/79064170.jpg" width="400" height="200"
						border="0" />
				</div>
				<div class="swiper-slide">
					<img src="${ctx}/images/79084750.jpg" width="400" height="200"
						border="0" />
				</div>
				<div class="swiper-slide">
					<img src="${ctx}/images/79085270.jpg" width="400" height="200"
						border="0" />
				</div>
			</div>
			<div class="swiper-pagination swiper-pagination-white"></div>
		</div>
	</div>
	<div style="height: 10px;"></div>
	<div class="module">
		<div class="head">
			<h2 class="current" data-tab="news">热点推荐</h2>
		</div>
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
	</div>
	
	<c:if test="${channel.children!=null}">
		<c:forEach var="channel" items="${channel.children}" varStatus="status">
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
			<div style="width: 100%;text-align: center;background-color: #F3F3F9;line-height: 30px;height: 30px;"><a href="${ctx}/${channel.linkAddr}" style="color: #333333;">进入${channel.name}</a></div>
			<div style="height: 5px;"></div>
		</c:forEach>
	</c:if>
	<jsp:include page="m-footer.jsp" flush="true"></jsp:include>
	<script>
		var swiper = new Swiper('.swiper-container-fade', {
			pagination : '.swiper-pagination-white',
			paginationClickable : true,
			loop : true,
			autoplay : 2500,
			autoplayDisableOnInteraction : true,
			spaceBetween : 30,
			effect : 'fade'
		});
	</script>
</body>
</html>
