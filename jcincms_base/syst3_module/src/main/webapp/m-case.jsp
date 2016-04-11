<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="m-meta.jsp" flush="true"></jsp:include>
<jsp:include page="m-css.jsp" flush="true"></jsp:include>
<jsp:include page="m-js.jsp" flush="true"></jsp:include>
<title>成功案例,智沃商务,华南品牌,专业建设营销建站,手机网站，微网站</title>
</head>
<body>
	<!-- 头部 -->
	<jsp:include page="m-header.jsp" flush="true"></jsp:include>
	<div class="clear"></div>
	<!-- 菜单 -->
	<jsp:include page="m-menu.jsp" flush="true"></jsp:include>
	<div class="clear"></div>
	<div style="height: 1px;"></div>
	<div style="padding: 5px 0px;">
		<img alt="智沃科技"
			src="${ctx}/images/case-01.jpg" style="height: auto;width: 100%;">
	</div>
	<div
		style="padding: 5px 0;text-align: center;background-color: red;color:#ffffff;">
		<span>CASE成功案例</span>
	</div>
	<div class="global">
		<div class="news">
			<ul style="padding-top: 10px;">
				<c:set var="docs" value="${page.rows}"></c:set>
				<c:if test="${docs!=null}">
					<c:forEach var="doc" items="${docs}">
						<li><a href="${ctx}/channel/news/doc/${doc.id}">
								<div style="float: left;">
									<img src="${ctx}/${doc.fileAddr}"
										style="width: 80px;height:80px;">
								</div>
								<div style="float: left;margin-left: 20px;width:240px;">
									<div>
										<span style="font-weight: bold;">${doc.title}</span>
									</div>
									<div style="font-size: 12px;padding-top: 5px;">
										<fmt:formatDate value="${doc.createDate}" pattern="yyyy-MM-dd" />
									</div>
									<div style="font-size: 12px;padding-top: 5px;">${doc.contentShort}……</div>
								</div>
								<div class="clear"></div>
						</a></li>
						<hr class="hr"></hr>
					</c:forEach>
				</c:if>
			</ul>
		</div>
	</div>
	<c:if test="${docs!=null}">
		<div class="spacer"></div>
		<div
			style="width:100%;padding: 15px 0px;font-size: 12px;text-align: center;">
			<a href="${ctx}/${channel.linkAddr}?page=1" class="button button-primary button-rounded button-tiny">首页</a>&nbsp;&nbsp;
			<c:if test="${page.page>1}">
				<a href="${ctx}/${channel.linkAddr}?page=${page.page-1}" class="button button-primary button-rounded button-tiny">上一页</a>&nbsp;&nbsp;</c:if>
			<span>${page.page}</span>&nbsp;&nbsp;
			<c:if test="${page.page < page.totalPage+1}">
				<a href="${ctx}/${channel.linkAddr}?page=${page.page+1}" class="button button-primary button-rounded button-tiny">下一页</a>&nbsp;&nbsp;</c:if>
			<c:if test="${page.page < page.totalPage+1}">
				<a href="${ctx}/${channel.linkAddr}?page=${page.totalPage+1}" class="button button-primary button-rounded button-tiny">末页</a>&nbsp;&nbsp;</c:if>
			&nbsp;&nbsp;<span>共${page.totalPage+1}页 ${page.total}条</span>
		</div>
	</c:if>
	<div class="clear"></div>
	<!-- 底部 -->
	<jsp:include page="m-footer.jsp" flush="true"></jsp:include>
	<!-- 菜单底部 -->
	<jsp:include page="m-bottommenu.jsp" flush="true"></jsp:include>
</body>
</html>
