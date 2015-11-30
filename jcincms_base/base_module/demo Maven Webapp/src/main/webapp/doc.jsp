<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/css/demo.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
</head>
<body>
	<div id="container">
		<div id="header">
			<div id="logo">
				<img alt="logo" src="${ctx }/images/logo.gif" />
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
				<div class="position">
					<div
						style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px;">
						<span>当前位置: 首页 > java</span>
					</div>
				</div>
				<div class="spacer"></div>
				<div class="article">
					<div class="info">
						<div style="width: 100%;text-align: center;">
							<span style="font-weight: bold;font-size: 16px;">${document.title}</span>
						</div>
						<hr>
						<div style="width: 100%;text-align: center;font-size: 12px;">
							${document.author}&nbsp;&nbsp;&nbsp;&nbsp;<span
								style="font-size: 12px;"><fmt:formatDate
									value="${document.createDate}" pattern="yyyy.MM.dd" /></span>
						</div>
						<p>${document.content}</p>
					</div>
				</div>
			</div>
			<!-- 右边导航 -->
			<jsp:include page="right_side.jsp" flush="true"></jsp:include>
		</div>
		<div class="clear"></div>
		<!-- 网页底部 -->
		<jsp:include page="footer.jsp" flush="true"></jsp:include>
	</div>
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
