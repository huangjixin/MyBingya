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
			<jsp:include page="zhiwo-channel-swiper.jsp"></jsp:include>
			<!-- 导航 -->
			<jsp:include page="zhiwo-nav.jsp"></jsp:include>
		</div>
		<div class="devider"></div>
		<div class="globalWidth">
			<div class="contentWidth" style="text-align: center;">
				<div id="rightside" style="width:200px;float: left;">
					<div class="panel">
						<c:forEach items="${navChan}" var="chan" varStatus="status">
							<c:if test="${status.index==0}">
								<div class="panel-header">
									<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${chan.name}</span>
								</div>
								<c:if test="${chan.children!=null}">
									<ul
										style="list-style-image: url('${ctx}/images/left_sider_menu_arow.png');">
										<c:set var="chan" value="${chan}" scope="request" />
										<jsp:include page="subnav.jsp"></jsp:include>
									</ul>
								</c:if>
							</c:if>
						</c:forEach>
					</div>
					<div style="height: 10px;"></div>
					<div class="panel">
						<div class="panel-header">
							<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系我们</span>
						</div>
						<jsp:include page="zhiwo-contact.jsp"></jsp:include>
					</div>
				</div>
				<div style="width:750px;float: right;">
					<div class="doc">
						<div style="width: 100%;text-align: center;">
							<span style="font-weight: bold;font-size: 16px;">${document.title}</span>
						</div>
						<hr class="hr" style="width: 95%;" />
						<div class="content"><p>${document.content}</p></div>
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
		<!-- 底部 -->
		<jsp:include page="zhiwo-footer.jsp" flush="true"></jsp:include>
	</div>
</body>
</html>
