<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<html>
<head>
<meta name="keywords" content="${channel.name},${channel.keyword}">
<meta name="description" content="${channel.name},${channel.keyword}">
<link rel="stylesheet" type="text/css" href="${ctx}/css/demo.css">
<style type="text/css"></style>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/slider.js"></script>
<title>${channel.name}</title>
</head>
<body>
	<div id="container">
		<!-- 头部 -->
		<jsp:include page="header.jsp" flush="true"></jsp:include>
		<div class="spacer"></div>
		<!-- 导航菜单 -->
		<jsp:include page="menu.jsp" flush="true"></jsp:include>
		<div class="spacer"></div>
		<div id="main">
			<div id="content">
				<!-- 位置-->
				<jsp:include page="nav.jsp" flush="true"></jsp:include>
				<c:set var="docs" value="${page.rows}"></c:set>
				<c:if test="${docs!=null}">
					<c:forEach var="doc" items="${docs}">
						<div class="spacer"></div>
						<div class="article">
							<div class="info">
								<span style="font-weight: bold;font-size: 14px;"><a
									href="${ctx}/${channel.linkAddr}/doc/${doc.id}" target="blank">${doc.title}</a></span>&nbsp;&nbsp;
								<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
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
			<!-- 右边导航 -->
			<jsp:include page="right_side.jsp" flush="true"></jsp:include>
		</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>
