<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<c:if test="${children!=null }">
	<c:forEach items="${children}" var="chan">
		<ul id="${chan.code}"
			style="display:none;color:#333;list-style-image:url('${ctx}/images/left_sider_menu_arow.png;')">
			<li><a <c:if test="${chan.children!=null }">onclick="setUlCss('${chan.code}')" href="javascript:void(0)"</c:if> >${chan.name}</a></li>
			<c:set var="children" value="${chan.children}" scope="request" />
			<jsp:include page="subnav.jsp"></jsp:include>
		</ul>
	</c:forEach>
</c:if>