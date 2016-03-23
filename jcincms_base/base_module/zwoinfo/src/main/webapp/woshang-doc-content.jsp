<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div class="globalWidth">
	<div style="width:100%;;text-align: center;position:relative;">
		<img alt="服务流程" src="${ctx}/images/kfzx_banner.jpg"
			style="width: 100%;height: auto;">
	</div>
	<div class="contentWidth">
		<div style="padding: 5px;background-color: #EC3901;">
			<span style="color: #ffffff;font-size: 12px;">当前位置： <a
				href="${ctx}/"
				style="color: #ffffff;font-size: 12px;text-decoration: none;">首页</a>
				<c:if test="${navChan !=null}">
					<c:forEach var="chan" items="${navChan}">
										><a href="${ctx}/${chan.linkAddr}"
							style="color: #ffffff;font-size: 12px;text-decoration: none;">${chan.name}</a>
					</c:forEach>
				</c:if>
			</span>
		</div>
		<div class="devider"></div>
		<div style="text-align: center;color: #333333;">
			<h3>${document.title}</h3>
		</div>
		<hr
			style="width: 100%;height:1px;border:none;border-top:1px solid #CCCCCC;" />
		<div class="document">${document.content}</div>
		<div class="devider"></div>
		<c:if test="${lastdoc!=null}">
			<div style="width: 100%;font-size: 12px;">
				<span>上一篇：</span><a style="text-decoration: none;color: #333333;"
					href="${ctx}/${channel.linkAddr}/doc/${lastdoc.id}">${lastdoc.title}</a>
			</div>
		</c:if>
		<c:if test="${nextdoc!=null}">
			<div style="width: 100%;font-size: 12px;">
				<span>下一篇：</span><a style="text-decoration: none;color: #333333;"
					href="${ctx}/${channel.linkAddr}/doc/${nextdoc.id}">${nextdoc.title}</a>
			</div>
		</c:if>
	</div>
</div>