<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/css/demo.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript">
	function setUlCss(id) {
		$('#' + id).toggle();
	}
</script>
<title>${document.title}</title>
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
				<div class="spacer"></div>
				<div class="article">
					<div class="info">
						<div style="width: 100%;text-align: center;">
							<span style="font-weight: bold;font-size: 16px;">${document.title}</span>
						</div>
						<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;" />
						<p>${document.content}</p>
					</div>
				</div>
			</div>
			<!-- 右边导航 -->
			<div id="left_side">
				<div class="box" style="width: 250px;">
					<c:forEach items="${navChan}" var="chan" varStatus="status">
						<c:if test="${status.index==0}">
							<div class="box-header">${chan.name}</div>
							<div class="box-center">
								<c:if test="${chan.children!=null}">
									<ul
										style="paddingLeft:0;font-size:14px;list-style-image:url('${ctx}/images/left_sider_menu_arow.png;')">
										<c:set var="chan" value="${chan}" scope="request" />
										<jsp:include page="subnav.jsp"></jsp:include>
									</ul>
								</c:if>
							</div>
						</c:if>
					</c:forEach>
				</div>
				<div class="spacer"></div>
				<jsp:include page="contact.jsp" flush="true"></jsp:include>
			</div>
		</div>
		<div class="clear"></div>
		<!-- 网页底部 -->
		<jsp:include page="footer.jsp" flush="true"></jsp:include>
	</div>
</body>
</html>
