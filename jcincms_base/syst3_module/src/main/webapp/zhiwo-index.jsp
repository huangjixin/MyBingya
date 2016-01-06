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
				<div class="property" onmouseover="javascript:this.style.background-color='#cccccc';" onmouseout="javascript:this.style.background-color='#ffffff';">
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
		<div style="width: 100%;">
			<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;" />
		</div>
		<div class="globalWidth">
			<div class="contentWidth">
				<div style="right: 0;position: relative;">
					<span style="border: solid #cccccc 1px;padding: 5px;">网站地图</span>
				</div>
			</div>
		</div>
		<div class="globalWidth">
			<div class="contentWidth"
				style="text-align: center;height: 50px;line-height: 50px;">
				<!-- 导航菜单 -->
				<jsp:include page="zhiwo-footer.jsp" flush="true"></jsp:include>
			</div>
		</div>
	</div>
</body>
</html>
