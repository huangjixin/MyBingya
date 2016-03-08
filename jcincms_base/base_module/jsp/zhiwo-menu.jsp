<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div class="menu">
	<ul>
		<li><a href="${ctx}/">首页</a></li>
		<c:if test="${list!=null}">
			<c:forEach var="channel" items="${list}">
				<c:if test="${channel.name!=null && channel.name!=''}">
					<li><a href="${ctx}/${channel.linkAddr}">${channel.name}</a> <c:set
							var="list" value="${channel.children}" scope="request" /> 
							<%-- <jsp:include page="submenu.jsp"></jsp:include> --%></li>
				</c:if>
			</c:forEach>
		</c:if>
	</ul>
</div>
