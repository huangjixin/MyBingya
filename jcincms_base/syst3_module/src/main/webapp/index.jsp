<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/css/demo.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/swiper.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/webtry_roll.js"></script>
<style type="text/css">
#picnav .arrow-left {
	background: url(images/arrows.png) no-repeat left top;
	position: absolute;
	left: 10px;
	top: 50%;
	margin-top: -15px;
	width: 17px;
	height: 30px;
}

#picnav .arrow-right {
	background: url(images/arrows.png) no-repeat left bottom;
	position: absolute;
	right: 10px;
	top: 50%;
	margin-top: -15px;
	width: 17px;
	height: 30px;
}

.swiper-container {
	height: 200px;
	width: 100%;
}

.pagination {
	position: absolute;
	left: 0;
	text-align: center;
	bottom: 5px;
	width: 100%;
}

.swiper-pagination-switch {
	display: inline-block;
	width: 10px;
	height: 10px;
	border-radius: 10px;
	background: #999;
	box-shadow: 0px 1px 2px #555 inset;
	margin: 0 3px;
	cursor: pointer;
}

.swiper-active-switch {
	background: #fff;
}

.swiper-slide { /* padding-left: 1px;
	padding-top: 2px; */
	
}
</style>
</head>
<title>首页</title>
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
		<!-- 导航菜单 -->
		<jsp:include page="menu.jsp" flush="true"></jsp:include>
		<div class="spacer"></div>
		<div id="main">
			<div id="content">
				<div id="picnav">
					<a class="arrow-left" href="#"></a> <a class="arrow-right" href="#"></a>
					<div class="swiper-container">
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
						<div class="swiper-button-next swiper-button-white"></div>
						<div class="swiper-button-prev swiper-button-white"></div>
					</div>
				</div>
				<div id="recommend">
					<div class="box-header">热点推荐</div>
					<div class="box-center">
						<ul>
							<c:if test="${recommendDocs!=null}">
								<c:forEach var="doc" items="${recommendDocs}">
									<c:choose>
										<c:when test="${doc.channel!=null}">
											<li><a
												href="${ctx}/${doc.channel.linkAddr}/doc/${doc.id}">${doc.title}</a></li>
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
				<div class="spacer"></div>
				<div class="box" style="float: left;width: 100%;min-height: 140px;">
					<div class="box-header" style="width: 25%;">图文资讯</div>
					<div class="box-center" style="text-align: center;">
						<ul id="ScrollBox">
							<li><a href="products.html" title="覆盆子酮"><img
									src="${ctx}/images/slide-1.jpg" alt="覆盆子酮" width="140"
									height="100" /><span>覆盆子酮</span></a></li>
							<li><a href="products.html" title="氯霉素"><img
									src="${ctx}/images/slide-2.jpg" alt="氯霉素" width="140"
									height="100" /><span>氯霉素</span></a></li>
							<li><a href="products.html" title="利巴韦林(病毒唑）"><img
									src="${ctx}/images/slide-3.jpg" alt="利巴韦林(病毒唑）" width="140"
									height="100" /><span>利巴韦林(病毒唑）</span></a></li>
							<li><a href="products.html" title="土霉素"><img
									src="${ctx}/images/slide-4.jpg" alt="土霉素" width="140"
									height="100" /><span>土霉素</span></a></li>
						</ul>
						<script language="javascript" type="text/javascript">
						<!--//--><![CDATA[//><!--
							var scrollPic_01 = new ScrollPic();
							scrollPic_01.scrollContId = "ScrollBox"; //内容容器ID
							scrollPic_01.arrLeftId = "LeftArr1";//左箭头ID
							scrollPic_01.arrRightId = "RightArr1"; //右箭头ID
							scrollPic_01.frameWidth = 648;//显示框宽度
							scrollPic_01.pageWidth = 162; //翻页宽度
							scrollPic_01.speed = 10; //移动速度(单位毫秒，越小越快)
							scrollPic_01.space = 5; //每次移动像素(单位px，越大越快)
							scrollPic_01.autoPlay = true; //自动播放
							scrollPic_01.autoPlayTime = 3; //自动播放间隔时间(秒)
							scrollPic_01.initialize(); //初始化
							//--><!]]>
						</script>
					</div>
				</div>
				<div>
					<!-- <div id="LeftArr1"></div>
					<div id="RightArr1"></div> -->

				</div>
				<div class="spacer"></div>
				<c:if test="${modules!=null}">
					<c:forEach var="channel" items="${modules}" varStatus="status">
						<c:if test="${channel.name!=null && channel.name!=''}">
							<c:if test="${status.index%2==0}">
								<div class="box" style="float: left;">
							</c:if>
							<c:if test="${status.index%2==1}">
								<div class="box" style="float: right;">
							</c:if>
							<div class="box-header">
								<a href="${ctx}/${channel.linkAddr}" style="color: #ffffff;">${channel.name}</a>
							</div>
							<div class="box-center">
								<ul>
									<c:set var="docs"
										value="${fns:getDocByChannelCode(channel.code,10)}"></c:set>
									<c:if test="${docs!=null}">
										<c:forEach var="doc" items="${docs}">
											<li><a href="${ctx}/${channel.linkAddr}/doc/${doc.id}"
												target="blank">${doc.title}<span><fmt:formatDate
															value="${doc.createDate}" pattern="yyyy.MM.dd" /></span></a></li>
											<hr
												style="height:1px;border:none;border-top:1px dashed #CCCCCC;" />
										</c:forEach>
									</c:if>
								</ul>
							</div>
			</div>
			<c:if test="${status.index%2==1}">
				<div class="spacer"></div>
			</c:if>
			</c:if>
			</c:forEach>
			</c:if>
			<div class="spacer"></div>
		</div>
		<!-- 右边导航 -->
		<jsp:include page="right_side.jsp" flush="true"></jsp:include>

	</div>
	<div class="clear"></div>
	<jsp:include page="footer.jsp" flush="true"></jsp:include>
	<script src="${ctx}/js/swiper.js"></script>
	<script>
	 var swiper = new Swiper('.swiper-container', {
	        pagination: '.swiper-pagination',
	        paginationClickable: '.swiper-pagination',
	        nextButton: '.swiper-button-next',
	        prevButton: '.swiper-button-prev',
	        loop : true,
	        autoplay : 2500,
			autoplayDisableOnInteraction : true,
	        spaceBetween: 30,
	        effect: 'fade'
	    });
	</script>
</body>
</html>
