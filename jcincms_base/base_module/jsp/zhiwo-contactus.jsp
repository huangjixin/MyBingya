<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/css/timeswo.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/swiper.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/swiper.js"></script>
<script type="text/javascript">
	function setUlCss(id) {
		$('#' + id).toggle();
	}
</script>
</head>
<title>${document.title}</title>
<body>
	<div id="container">
		<div class="globalWidth">
			<div class="contentWidth" id="header">
				<!-- 头部 -->
				<jsp:include page="zhiwo-header.jsp" flush="true"></jsp:include>
			</div>
		</div>
		<div class="globalWidth" id="navigation" style="background-image: url('${ctx}/images/navigationBg.png');">
			<div class="contentWidth">
				<!-- 导航菜单 -->
				<jsp:include page="zhiwo-menu.jsp" flush="true"></jsp:include>
			</div>
		</div>
		<div class="globalWidth" style="position:relative;width: 100%;">
			<!-- 图片展示 -->
			<jsp:include page="zhiwo-index-swiper.jsp"></jsp:include>
			<!-- 导航 -->
			<jsp:include page="zhiwo-nav.jsp"></jsp:include>
		</div>
		<div class="devider"></div>
		<div class="globalWidth">
			<div class="contentWidth" style="text-align: center;">
				<div>
					<div style="border: 1px solid #cccccc;padding-top: 20px;">
						<div style="width: 100%;text-align: center;">
							<span style="font-weight: bold;font-size: 16px;">${document.title}</span>
						</div>
						<hr
							style="width: 93%;height:1px;border:none;border-top:1px solid #CCCCCC;" />
						<div>${document.content}</div>
					</div>
				</div>
				<div></div>
			</div>
		</div>
		<div class="clear"></div>
		<!-- 底部 -->
		<jsp:include page="zhiwo-footer.jsp" flush="true"></jsp:include>
	</div>
</body>
</html>
