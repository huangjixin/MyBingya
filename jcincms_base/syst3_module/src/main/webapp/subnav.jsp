<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<c:if test="${chan!=null }">
	<c:if test="${chan.children!=null }">
		<c:forEach items="${chan.children}" var="chan">
			<li style="text-align: left;margin-bottom:0px;"><a
				<c:if test="${chan.children!=null}">onclick="setUlCss('${chan.id}')"</c:if>
				<c:if test="${chan.children==null}">href="${ctx}/${chan.linkAddr}"</c:if>
				<c:if test="${chan.children!=null}"></c:if>>${chan.name}</a>
				<c:if test="${chan.children!=null}">
					<ul id="${chan.id}" style="display:none;color:#333;margin-top:5px;">
						<c:set var="chan" value="${chan}" scope="request" />
						<jsp:include page="subnav.jsp"></jsp:include>
					</ul>
				</c:if></li>
		</c:forEach>
	</c:if>
</c:if>
<%-- <c:if test="${children!=null }">
	<c:forEach items="${children}" var="chan">
		<ul id="${chan.code}">
			<li><a>${chan.name}</a></li>
			<c:set var="children" value="${chan.children}" scope="request" />
			<jsp:include page="subnav.jsp"></jsp:include>
		</ul>
	</c:forEach>
</c:if> --%>

<%-- style="display:none;color:#333;list-style-image:url('${ctx}/images/left_sider_menu_arow.png;')" --%>