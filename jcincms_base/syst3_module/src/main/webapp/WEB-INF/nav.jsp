<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div class="position">
	<div style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px;">
		<span>当前位置: <a href="${ctx}/">首页</a> <c:if
				test="${navChan !=null}">
				<c:forEach var="chan" items="${navChan}">
										><a href="${ctx}/${chan.linkAddr}">${chan.name}</a>
				</c:forEach>
			</c:if></span>
	</div>
</div>