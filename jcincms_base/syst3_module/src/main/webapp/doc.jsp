<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/css/demo.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
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
						<div style="width: 100%;text-align: center;font-size: 12px;">
							${document.author}&nbsp;&nbsp;&nbsp;&nbsp;<span><fmt:formatDate
									value="${document.createDate}" pattern="yyyy.MM.dd" /></span>&nbsp;&nbsp;阅读:
							<span id="hits"><script type="text/javascript">
								$("#hits").load('${ctx}/channel/getClickCount?id=${document.id}');
							</script></span>
						</div>
						<p>${document.content}</p>
					</div>
				</div>
				<div class="spacer"></div>
				<c:if test="${lastdoc!=null}">
					<div style="font-size: 12px;">
						<span>上一篇：</span><a
							href="${ctx}/${channel.linkAddr}/doc/${lastdoc.id}">${lastdoc.title}</a>
					</div>
				</c:if>
				<c:if test="${nextdoc!=null}">
					<div style="font-size: 12px;">
						<span>下一篇：</span><a
							href="${ctx}/${channel.linkAddr}/doc/${nextdoc.id}">${nextdoc.title}</a>
					</div>
				</c:if>
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
