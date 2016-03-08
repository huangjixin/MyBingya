<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<c:if test="${chan!=null }">
	<c:if test="${chan.children!=null }">
		<c:forEach items="${chan.children}" var="chan">
			<c:choose>
				<c:when test="${channel!=null && chan.name==channel.name}">
					<a href="${ctx}/${chan.linkAddr}"><div
							class="navButtonSelected">${chan.name}</div></a>
				</c:when>
				<c:otherwise>
					<a href="${ctx}/${chan.linkAddr}">
						<div class="navButton">${chan.name}</div>
					</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</c:if>
</c:if>