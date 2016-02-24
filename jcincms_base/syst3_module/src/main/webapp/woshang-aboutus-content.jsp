<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div class="globalWidth" style="background-color: #F7F7F7;">
	<div style="width:100%;;text-align: center;position:relative;">
		<img alt="服务流程" src="${ctx}/images/about-banner.png"
			style="width: auto;height: auto;">
		<div
			style="width:100%;position: absolute;bottom: 0px;text-align: center;"
			class="contentWidth">
			<div class="contentWidth">
				<div style="width:100%;background-color:#ffffff;padding: 10px 0;">
					<h2>专注·用心·热情</h2>
					<span>我们注重设计情感，赋予每个作品独特的气质！</span>
				</div>
			</div>
		</div>
	</div>
	<div class="devider"></div>
	<div class="contentWidth">
		<div style="text-align: center;">
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
</div>

