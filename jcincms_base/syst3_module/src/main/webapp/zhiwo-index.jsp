<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/css/timeswo.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/swiper.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/swiper.js"></script>
</head>
<title>智沃首页</title>
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
				<!-- 菜单 -->
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
				<div class="property"
					onmouseover="javascript:this.style.background-color='#cccccc';"
					onmouseout="javascript:this.style.background-color='#ffffff';">
					<img src="${ctx}/images/ddd.png">
					<div style="width: 100px;text-align: center;">
						<span>良好的用户口碑 丰富的开发经验</span>
					</div>
				</div>
				<div class="property">
					<img src="${ctx}/images/ddd.png">
					<div style="width: 100px;text-align: center;">
						<span>良好的用户口碑 丰富的开发经验</span>
					</div>
				</div>
				<div class="property">
					<img src="${ctx}/images/ddd.png">
					<div style="width: 100px;text-align: center;">
						<span>良好的用户口碑 丰富的开发经验</span>
					</div>
				</div>
				<div class="property">
					<img src="${ctx}/images/ddd.png">
					<div style="width: 100px;text-align: center;">
						<span>良好的用户口碑 丰富的开发经验</span>
					</div>
				</div>
				<div class="property">
					<img src="${ctx}/images/ddd.png">
					<div style="width: 100px;text-align: center;">
						<span>良好的用户口碑 丰富的开发经验</span>
					</div>
				</div>
				<div class="property">
					<img src="${ctx}/images/ddd.png">
					<div style="width: 100px;text-align: center;">
						<span>良好的用户口碑 丰富的开发经验</span>
					</div>
				</div>
				<div class="property">
					<img src="${ctx}/images/ddd.png">
					<div style="width: 100px;text-align: center;">
						<span>良好的用户口碑 丰富的开发经验</span>
					</div>
				</div>
				<div class="property">
					<img src="${ctx}/images/ddd.png">
					<div style="width: 100px;text-align: center;">
						<span>良好的用户口碑 丰富的开发经验</span>
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
