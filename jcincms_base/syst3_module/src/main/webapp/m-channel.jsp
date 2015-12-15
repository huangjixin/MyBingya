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
		</ul>
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
	<div id="content">
		<c:set var="docs" value="${page.rows}"></c:set>
		<c:if test="${docs!=null}">
			<c:forEach var="doc" items="${docs}">
				<div class="spacer"></div>
				<div class="article">
					<div class="info">
						<span style="font-weight: bold;font-size: 14px;"><a
							href="${ctx}/${channel.linkAddr}/doc/${doc.id}" target="blank">${doc.title}</a></span>&nbsp;&nbsp;
						<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;" />
						<p>文章摘要：${doc.contentShort}</p>
						<div style="font-size: 12px;">
							${doc.author}&nbsp;&nbsp;&nbsp;&nbsp;<span
								style="font-size: 12px;"><fmt:formatDate
									value="${doc.createDate}" pattern="yyyy.MM.dd" /></span>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>
		<c:if test="${docs!=null}">
			<div class="spacer"></div>
			<div style="width:auto;padding: 5px 0px 5px 5px;font-size: 12px;">
				<a href="${ctx}/${channel.linkAddr}?page=1"><span>首页</span></a>&nbsp;&nbsp;
				<c:if test="${page.page>1}">
					<a href="${ctx}/${channel.linkAddr}?page=${page.page-1}"><span>上一页</span></a>&nbsp;&nbsp;</c:if>
				<span>${page.page}</span>&nbsp;&nbsp;
				<c:if test="${page.page < page.totalPage+1}">
					<a href="${ctx}/${channel.linkAddr}?page=${page.page+1}"><span>下一页</span></a>&nbsp;&nbsp;</c:if>
				<c:if test="${page.page < page.totalPage+1}">
					<a href="${ctx}/${channel.linkAddr}?page=${page.totalPage+1}"><span>末页</span></a>&nbsp;&nbsp;</c:if>
				&nbsp;&nbsp;<span>共${page.totalPage+1}页 ${page.total}条</span>
			</div>
		</c:if>
	</div>
	<div>
		<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;" />
	</div>
	<div id="footer" style="text-align: center;padding-bottom: 5px;">Copyright
		© 2011-2015 jcincms内容管理系统.</div>
</body>
</html>
