<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="meta-channel.jsp" flush="true"></jsp:include>
<jsp:include page="css.jsp" flush="true"></jsp:include>
<jsp:include page="js.jsp" flush="true"></jsp:include>
<title>网络营销学院_广州智沃——专业的互联网营销策划与人才服务商</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<jsp:include page="menu.jsp" flush="true"></jsp:include>
	<div class="globalWidth" id="banner">
		<img alt="" src="${ctx}/images/colloege_banner.png" style="width: 100%;">
	</div>
	<div class="globalWidth">
		<div class="contentWidth" style="text-align: left;position: relative;">
			<span style="font-size: 12px;color:#333333;">当前位置： <a
				href="${ctx}/"
				style="font-size: 12px;text-decoration: none;color:#333333;">首页</a>
				<c:if test="${navChan !=null}">
					<c:forEach var="chan" items="${navChan}">
										><a href="${ctx}/${chan.linkAddr}"
							style="font-size: 12px;text-decoration: none;color:#333333;">${chan.name}</a>
					</c:forEach>
				</c:if>
			</span>
		</div>
	</div>
	<div class="globalWidth">
		<div class="contentWidth" style="text-align: left;position: relative;">
			<span style="color:#333333;font-size: 30px;">COLLEGE网络营销学院</span><span
				style="color:#333333;font-size: 12px;">将网销进行到底！</span>
		</div>
		<hr class="hr"></hr>
	</div>
	<div class="globalWidth">
		<div class="contentWidth" style="text-align: left;">
			<c:set var="docs" value="${page.rows}"></c:set>
			<c:if test="${docs!=null}">
				<ul id="newslist">
					<c:forEach var="doc" items="${docs}">
						<li style="margin-top: 20px;margin-bottom: 20px;"><a
							href="${ctx}/${channel.linkAddr}/doc/${doc.id}">
								<div style="float: left;">
									<img src="${ctx}/${doc.titleImage}"
										style="width: 100px;height:100px;">
								</div>
								<div style="float: left;margin-left: 20px;width:80%;">
									<div>
										<span style="font-weight: bold;">${doc.title}</span>
									</div>
									
									<div style="font-size: 12px;padding-top: 5px;">
										<fmt:formatDate value="${doc.createDate}" pattern="yyyy-MM-dd" />
									</div>
									<div style="font-size: 12px;padding-top: 5px;">${doc.contentShort}……</div>
								</div>
								<div class="clear"></div>
								
						</a></li>

						<hr class="hr" style="border-top:1px dashed #cccccc;"></hr>
					</c:forEach>
				</ul>
			</c:if>
			
			<c:if test="${docs!=null}">
				<div class="spacer"></div>
				<div
					style="width:100%;padding: 15px 0px 15px 5px;font-size: 12px;text-align: center;">
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
	<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>
