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
		<div class="globalWidth" style="position:relative;width: 100%;">
			<div class="swiper-container">
				<img src="${ctx}/images/swiper1.png">
			</div>
			<div
				style="background:black; filter: alpha(opacity=60); opacity:0.6; position: absolute;bottom: 0px;z-index: 1;width:100%;height: 20px;line-height: 20px;">
				<div class="contentWidth">
					<span style="color: #ffffff;font-size: 12px;">当前位置：首页>新闻中心</span>
				</div>
			</div>
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
							<ul style="list-style-type: square;list-style: square;">
								<c:forEach var="doc" items="${docs}">
									<li style="text-align: left;margin-bottom: 10px;"><span
										style="font-size: 14px;"><a
											style="text-decoration: none;color: #333333;"
											href="${ctx}/${channel.linkAddr}/doc/${doc.id}"
											target="blank">${doc.title}</a></span></li>
									<hrstyle ="height:1px;border:none;border-top:1px solid #CCCCCC;" />
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
