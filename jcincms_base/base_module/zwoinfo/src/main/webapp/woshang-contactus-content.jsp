<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div style="width:100%;;text-align: center;position:relative;">
	<img alt="联系我们" src="${ctx}/images/contactus_banner.jpg"
		style="width: 100%;height: auto;">
</div>
<div class="contentWidth">
	<div style="text-align: center;background-color: #ffffff;padding-top: 10px;padding-bottom: 10px;">
		<c:forEach items="${navChan}" var="chan" varStatus="status">
			<c:if test="${status.index==0}">
				<c:if test="${chan.children!=null}">
					<c:set var="chan" value="${chan}" scope="request" />
					<jsp:include page="woshang-subnav.jsp"></jsp:include>
				</c:if>
			</c:if>
		</c:forEach>
		<div class="clear"></div>
	</div>
</div>
