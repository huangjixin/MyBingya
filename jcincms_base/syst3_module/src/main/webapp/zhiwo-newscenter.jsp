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
	$(document).ready(function() {
		$("#scrollDiv").textSlider({
			line : 1,
			speed : 500,
			timer : 3000
		});
	});
	function setUlCss(id) {
		$('#' + id).toggle();
	}
</script>

</head>
<title>${channel.name}</title>
<body>
	<div id="container">
		<div class="globalWidth">
			<div class="contentWidth" id="header">
				<!-- 头部 -->
				<jsp:include page="zhiwo-header.jsp" flush="true"></jsp:include>
			</div>
		</div>
		<div class="globalWidth" id="navigation"
			style="background-image: url('${ctx}/images/navigationBg.png');">
			<div class="contentWidth">
				<!-- 菜单 -->
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
				<div style="width:750px;float: left;">
					<div style="border: 1px solid #cccccc;padding-top: 20px;">
						<div style="width: 100%;text-align: left;margin-bottom: 10px;">
							<span
								style="padding-left:24px;font-weight: bold;font-size: 16px;">新闻中心</span>
						</div>
						<c:set var="docs" value="${page.rows}"></c:set>
						<c:if test="${docs!=null}">
							<ul class="news">
								<c:forEach var="doc" items="${docs}">
									<li><a href="${ctx}/${channel.linkAddr}/doc/${doc.id}"
										target="blank">${doc.title}</a> <span style="font-size: 14px;"></span></li>
									<!-- <hr class="hr" style="width: 90%;" /> -->
								</c:forEach>
							</ul>
						</c:if>
						<c:if test="${docs!=null}">
							<div class="spacer"></div>
							<div style="width:auto;padding: 5px 0px 5px 5px;font-size: 12px;">
								<a href="${ctx}/${channel.linkAddr}?page=1"><span>首页</span></a>&nbsp;&nbsp;
								<c:if test="${page.page>1}">
									<a href="${ctx}/${channel.linkAddr}?page=${page.page-1}"><span>上一页</span></a>&nbsp;&nbsp;</c:if>
								<span>${page.page}</span>&nbsp;&nbsp;
								<c:if test="${page.page < page.totalPage+1}">
									<a href="${ctx}/${channel.linkAddr}?page=${page.page+1}"><span>下一页</span></a>&nbsp;&nbsp;</c:if>
								<c:if test="${page.page < page.totalPage+1}">
									<a href="${ctx}/${channel.linkAddr}?page=${page.totalPage+1}"><span>末页</span></a>&nbsp;&nbsp;</c:if>
								&nbsp;&nbsp;<span>共${page.totalPage+1}页 ${page.total}条</span>
							</div>
						</c:if>
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
