<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<html>
<head>
<jsp:include page="m-woshang-meta.jsp" flush="true"></jsp:include>
<jsp:include page="m-woshang-css.jsp" flush="true"></jsp:include>
<jsp:include page="m-woshang-js.jsp" flush="true"></jsp:include>
</head>
<title>广州智沃,华南品牌,专业建设营销建站,手机网站，微网站，微商城</title>
<body>
	<!-- 头部 -->
	<jsp:include page="m-woshang-header.jsp" flush="true"></jsp:include>
	<div class="clear"></div>
	<!-- 菜单 -->
	<jsp:include page="m-woshang-menu.jsp" flush="true"></jsp:include>
	<div class="clear"></div>
	<div style="height: 1px;"></div>
	<div style="padding: 5px 0px;">
		<a href="${ctx}/"><img alt="智沃科技" src="${ctx}/images/service.jpg"
			style="height: auto;width: 100%;"></a>
	</div>
	<div class="clear"></div>
	<div class="devider"></div>
	<div
		style="padding: 5px 0;text-align: center;background-color: red;color:#ffffff;">
		<span>智沃科技：品牌服务三大核心优势</span>
	</div>
	<div class="global">
		<div class="news">
			<ul style="padding-top: 10px;">
				<c:set var="docs" value="${fns:getDocByChannelCode('news',10)}"></c:set>
				<c:if test="${docs!=null}">
					<c:forEach var="doc" items="${docs}">
						<li><a href="${ctx}/channel/news/doc/${doc.id}"
							target="blank">${doc.title}<span><fmt:formatDate
										value="${doc.createDate}" pattern="yyyy.MM.dd" /></span></a></li>
						<hr class="hr"></hr>
					</c:forEach>
				</c:if>
			</ul>
		</div>
	</div>

	<div class="clear"></div>
	<!-- 底部 -->
	<jsp:include page="m-woshang-footer.jsp" flush="true"></jsp:include>

	<!-- 菜单底部 -->
	<jsp:include page="m-woshang-bottommenu.jsp" flush="true"></jsp:include>
</body>
</html>
