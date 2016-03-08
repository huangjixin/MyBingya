<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div class="globalWidth">
	<div style="width:100%;;text-align: center;position:relative;">
		<img alt="服务流程" src="${ctx}/images/kfzx_banner.jpg"
			style="width: 100%;height: auto;">
	</div>
	<div class="contentWidth">
		<c:set var="docs" value="${page.rows}"></c:set>
		<c:if test="${docs!=null}">
			<ul id="newslist">
				<c:forEach var="doc" items="${docs}">
					<li style="margin-top: 20px;margin-bottom: 20px;"><a
						href="${ctx}/${channel.linkAddr}/doc/${doc.id}" target="blank"><span
							style="font-weight: bold;">${doc.title}</span>
							<div class="devider"></div>
							<div style="font-size: 12px;">${doc.contentShort}……</div></a></li>
					<hr class="hr" style="border-top:1px dashed #cccccc;"></hr>
				</c:forEach>
			</ul>
		</c:if>
		<c:if test="${docs!=null}">
			<div class="spacer"></div>
			<div
				style="width:100%;padding: 5px 0px 5px 5px;font-size: 12px;text-align: center;">
				<a href="${ctx}/${channel.linkAddr}?page=1"><span>首页</span></a>&nbsp;&nbsp;
				<c:if test="${page.page>1}">
					<a href="${ctx}/${channel.linkAddr}?page=${page.page-1}"><span>上一页</span></a>&nbsp;&nbsp;</c:if>
				<span>${page.page}</span>&nbsp;&nbsp;
				<c:if test="${page.page < page.totalPage+1}">
					<a href="${ctx}/${channel.linkAddr}?page=${page.page+1}"><span>下一页</span></a>&nbsp;&nbsp;</c:if>
				<c:if test="${page.page < page.totalPage+1}">
					<a href="${ctx}/${channel.linkAddr}?page=${page.totalPage+1}"><span>末页</span></a>&nbsp;&nbsp;</c:if>
				&nbsp;&nbsp;<span>共${page.totalPage+1}页 ${page.total}条</span>
			</div>
		</c:if>
	</div>

</div>

