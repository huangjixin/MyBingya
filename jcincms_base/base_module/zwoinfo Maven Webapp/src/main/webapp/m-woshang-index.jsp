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
		<a href="${ctx}/"><img alt="智沃科技" src="${ctx}/images/m-banner.jpg"
			style="height: auto;width: 100%;"></a>
	</div>
	<div class="banner">
		<ul>
			<li><a href="${ctx}/channel/cases"><img alt=""
					src="${ctx}/images/mob2.jpg" style="width: 90%;height: auto;"></a></li>
			<li><a href="#"><img alt="" src="${ctx}/images/mob4.jpg"
					style="width: 90%;height: auto;"></a></li>
			<li><a href="${ctx}/channel/service"><img alt=""
					src="${ctx}/images/mob5.jpg" style="width: 90%;height: auto;"></a></li>
			<li><a href="${ctx}/channel/aboutus"><img alt="" src="${ctx}/images/mob8.jpg"
					style="width: 90%;height: auto;"></a></li>
		</ul>
	</div>
	<div class="clear"></div>
	<div class="devider"></div>
	<div
		style="padding: 5px 0;text-align: center;background-color: red;color:#ffffff;">
		<span>成功案例</span>
	</div>
	<div style="padding-top: 5px;text-align: center;">
		<img alt="智沃科技" src="${ctx}/images/m-case-banner1.jpg"
			style="width: 49%;"> <img alt="智沃科技"
			src="${ctx}/images/m-case-banner2.jpg" style="width: 49%;">
	</div>

	<div
		style="padding: 5px 0;text-align: center;background-color: red;color:#ffffff;">
		<span>公司主营业务</span>
	</div>
	<div class="global" style="padding: 0px 10px;">
		<div class="case">
			<span> <img alt="网站建设" src="${ctx}/images/serv1.jpg">
				<div>网站建设</div>
				<div>营销型网站</div>
				<div>展示型网站</div>
			</span> 
			<span> <img alt="网站建设" src="${ctx}/images/serv2.jpg">
				<div>移动开发</div>
				<div>手机网站开发</div>
				<div>APP开发</div>
			</span> 
			<span> <img alt="网站建设" src="${ctx}/images/serv3.jpg">
				<div>网络营销</div>
				<div>SEO优化</div>
				<div>网站推广</div>
			</span> 
			<span> <img alt="网站建设" src="${ctx}/images/serv4.jpg">
				<div>微信公众号开发</div>
				<div>微网站开发</div>
				<div>APP开发</div>
			</span>
		</div>
	</div>
	<div class="clear"></div>
	<div class="devider"></div>
	<div
		style="padding: 5px 0;text-align: center;background-color: red;color:#ffffff;">
		<span>公司新闻</span>
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
