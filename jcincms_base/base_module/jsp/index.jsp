<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/css/demo.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/swiper.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/swiper.js"></script>
</head>
<title>首页</title>
<body>
	<div id="container">
		<!-- 头部 -->
		<jsp:include page="header.jsp" flush="true"></jsp:include>
		<!-- 导航菜单 -->
		<jsp:include page="menu.jsp" flush="true"></jsp:include>
		<div class="spacer"></div>
		<div id="main">
			<div id="content">
				<div id="picnav">
					<a class="arrow-left" href="#"></a> <a class="arrow-right" href="#"></a>
					<div class="swiper-container swiper-container-fade">
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
				<div class="box" style="float: left;width:100%;min-height: 140px;">
					<div class="box-header" style="width: 25%;">图文资讯</div>
					<div class="box-center" style="text-align: center;padding-top: 5px;">
						<div class="swiper-container swiper-container-scroll" style="height:125px;">
							<div class="swiper-wrapper">
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-1.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-2.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-3.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-4.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-1.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-2.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-3.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-4.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-2.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-3.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-1.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-4.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
							</div>
							<!-- Add Pagination -->
							<div class="swiper-pagination swiper-pagination-pictrueScroll"></div>
						</div>
					</div>
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
	<script>
		var swiper = new Swiper('.swiper-container-fade', {
			pagination : '.swiper-pagination-white',
			paginationClickable : true,
			nextButton : '.swiper-button-next',
			prevButton : '.swiper-button-prev',
			loop : true,
			autoplay : 2500,
			autoplayDisableOnInteraction : true,
			spaceBetween : 30,
			effect : 'fade'
		});
		var swiper1 = new Swiper('.swiper-container-scroll', {
			pagination : '.swiper-pagination-pictrueScroll',
			loop : true,
			autoplay : 2500,
			autoplayDisableOnInteraction : true,
			slidesPerView : 4,
			paginationClickable : true,
			spaceBetween : 30,
			grabCursor: true
			
		});
	</script>
</body>
</html>
