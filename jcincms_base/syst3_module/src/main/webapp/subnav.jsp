<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<c:if test="${chan!=null }">
	<c:if test="${chan.children!=null }">
		<c:forEach items="${chan.children}" var="chan">
			<a href="${ctx}/${chan.linkAddr}" class="button button-primary button-rounded button-small">${chan.name}</a>
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