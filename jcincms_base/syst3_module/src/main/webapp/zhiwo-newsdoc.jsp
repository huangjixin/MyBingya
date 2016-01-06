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
		<div class="globalWidth" id="navigation">
			<div class="contentWidth">
				<!-- 导航菜单 -->
				<jsp:include page="zhiwo-menu.jsp" flush="true"></jsp:include>
			</div>
		</div>
		<div class="globalWidth">
			<div class="swiper-container">
				<img src="${ctx}/images/swiper1.png">
			</div>
		</div>
		<div class="devider"></div>
		<div class="globalWidth">
			<div class="contentWidth" style="text-align: center;">
				<div style="width:750px;float: left;">
					<div style="border: 1px solid #cccccc;padding-top: 20px;">
						<div style="width: 100%;text-align: center;">
							<span style="font-weight: bold;font-size: 16px;">${document.title}</span>
						</div>
						<hr
							style="width: 93%;height:1px;border:none;border-top:1px solid #CCCCCC;" />
						<div>${document.content}</div>
					</div>
				</div>
				<div id="rightside" style="width:200px;float: right;">
					<div class="panel">
						<c:forEach items="${navChan}" var="chan" varStatus="status">
							<c:if test="${status.index==0}">
								<div class="panel-header">
									<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${chan.name}</span>
								</div>
								<ul
									style="list-style-image: url('${ctx}/images/left_sider_menu_arow.png');">
									<li><a href="${ctx}/${channel.linkAddr}">智沃新闻</a></li>
								</ul>
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
			</div>
		</div>
		<div class="clear"></div>
		<!-- 底部 -->
		<jsp:include page="zhiwo-footer.jsp" flush="true"></jsp:include>
	</div>
</body>
</html>
