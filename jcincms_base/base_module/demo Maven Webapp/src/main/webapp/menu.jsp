<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div id="nav">
	<div id="menu">
		<div
			style="width: 100%;height:42px;z-index:3;background:#212121; top:0; left:0; display:block;">
			<ul class="hnav">
				<li><a href="${ctx}">首页</a></li>
				<c:if test="${list!=null}">
					<c:forEach var="channel" items="${list}">
						<c:if test="${channel.name!=null && channel.name!=''}">
							<li><a href="${ctx}/${channel.linkAddr}">${channel.name}</a></li>
						</c:if>
					</c:forEach>
				</c:if>
			</ul>
		</div>
	</div>
</div>