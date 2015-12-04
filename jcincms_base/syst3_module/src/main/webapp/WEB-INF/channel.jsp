<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/css/demo.css">
<style type="text/css"></style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="js/slider.js"></script>
</head>
<body>
	<div id="container">
		<div id="header">
			<div id="logo">
				<img alt="logo" src="${ctx}/images/logo.gif" />
			</div>
			<div id="headerContact">
				<span>2015年11月26日 星期四</span>
			</div>
		</div>
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
								<hr>
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
			</div>
			<!-- 右边导航 -->
			<jsp:include page="right_side.jsp" flush="true"></jsp:include>
		</div>
		<div class="clear"></div>
		<jsp:include page="footer.jsp" flush="true"></jsp:include>
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
