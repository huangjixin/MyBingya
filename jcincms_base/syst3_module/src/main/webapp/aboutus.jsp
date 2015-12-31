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
					<div class="box-header">${channel.name}</div>
					<!-- <div><hr style="width:100%;height:1px;border:none;border-top:1px solid #0088DD;" /></div> -->
					<div class="box-center">
						<%-- <div>
							<ul
								style="color:#333;list-style-image:url('${ctx}/images/left_sider_menu_arow.png;')">
								<li><a onclick="setUlCss('test')" href="javascript:void(0)">test</a>
									<ul id="test" style="display:none;color:#333;list-style-image:url('${ctx}/images/left_sider_menu_arow.png;')">
										<li><a style="color:#333333;" href="javascript:void(0)">weg</a></li>
										<li><a style="color:#333333;" href="javascript:void(0)">tfdbgest</a></li>
										<li><a style="color:#333333;" href="javascript:void(0)">tebfdbst</a></li>
									</ul></li>
								<li><a href="javascript:void(0)">weg</a></li>
								<li><a href="javascript:void(0)">tfdbgest</a></li>
								<li><a href="javascript:void(0)">tebfdbst</a></li>
								<li><a href="javascript:void(0)">tecvbst</a></li>
								<li><a href="javascript:void(0)">vcbtest</a></li>
								<c:forEach items="${navChan}" var="chan" varStatus="status">
									<c:if test="${status.index==0}">
										<c:forEach  items="${chan.children}" var="chan" varStatus="status">
											<li><a <c:if test="${chan.children!=null }">onclick="setUlCss('${chan.code}')"</c:if> href="javascript:void(0)">${chan.name}</a>
												<c:if test="${chan.children!=null }">
													<ul id="chan.code" style="display:none;color:#333;list-style-image:url('${ctx}/images/left_sider_menu_arow.png;')">
														<li><a style="color:#333333;" href="javascript:void(0)">weg</a></li>
														<li><a style="color:#333333;" href="javascript:void(0)">tfdbgest</a></li>
														<li><a style="color:#333333;" href="javascript:void(0)">tebfdbst</a></li>
													</ul>
												</c:if>
											</li>
										</c:forEach>
									</c:if>
								</c:forEach>
							</ul>
						</div> --%>
						<c:forEach items="${navChan}" var="chan" varStatus="status">
							<c:if test="${status.index==0}">
								<c:if test="${chan.children!=null}">
									<ul style="color:#333;list-style-image:url('${ctx}/images/left_sider_menu_arow.png;')">
										<c:forEach  items="${chan.children}" var="chan">
											<li><a <c:if test="${chan.children!=null }">onclick="setUlCss('${chan.code}')" href="javascript:void(0)"</c:if> <c:if test="${chan.children==null }">href="${ctx}/${chan.linkAddr}"</c:if>>${chan.name}</a>
												<c:set var="children" value="${chan.children}" scope="request" />
												<jsp:include page="subnav.jsp"></jsp:include>
											</li>
										</c:forEach>
									</ul>
									
								</c:if>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
		<!-- 网页底部 -->
		<jsp:include page="footer.jsp" flush="true"></jsp:include>
	</div>
</body>
</html>
