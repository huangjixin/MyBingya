<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<ul>
	
	<c:if test="${list!=null}">
		<c:forEach var="channel" items="${list}">
			<c:if test="${channel.name!=null && channel.name!=''}">
				<li><a href="${ctx}/${channel.linkAddr}">${channel.name}</a> <c:if
						test="${channel.children!=null}">
						<c:set var="list" value="${channel.children}" scope="request" />
						<jsp:include page="submenu.jsp"></jsp:include>
					</c:if></li>
			</c:if>
		</c:forEach>
	</c:if>
</ul>

<%-- <c:if test="${list!=null}">
	<ul>
		<c:forEach var="channel" items="${list}">
			<c:if test="${channel.name!=null && channel.name!=''}">
				<li><a href="${ctx}/${channel.linkAddr}">${channel.name}</a>
					<c:set var="list" value="${channel.children}" scope="request" />
					<jsp:include page="submenu.jsp"></jsp:include>
				</li>
			</c:if>
		</c:forEach>
	</ul>
</c:if> --%>
