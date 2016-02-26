<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div class="globalWidth" id="menuContainer">
	<div class="menu">
		<ul>
			<li><a href="${ctx}/">首页</a></li>
			<c:if test="${list!=null}">
				<c:forEach var="chan" items="${list}">
					<c:if test="${chan.name!=null && chan.name!=''}">
						<li><a href="${ctx}/${chan.linkAddr}"
							<c:if test="${channel!=null && chan.name==channel.name }">class="selected"</c:if>>${chan.name}</a>
							<c:set var="list" value="${chan.children}" scope="request" /> <%-- <jsp:include page="submenu.jsp"></jsp:include> --%></li>
					</c:if>
				</c:forEach>
			</c:if>
		</ul>
	</div>
</div>



