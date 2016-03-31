<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta name="description"
	content="广州智沃科技有限公司是一家以高端网站设计开发为核心业务的电子商务咨询服务机构。我们能为你提供的不仅仅是网站建设，而是一套适合您的解决方案及一支全方的位护航编队。传递品牌文化，雕琢商业品牌，对追求品质和苛求细节的人而言，我们是最理想的电子商务服务商。一支以创新为核心的团队，一支视品质为生命 的团队，一群怀揣梦想的孩子，这就是智沃！" />
<meta name="keywords"
	content="广州网站建设,广州网站建设公司,广州网站制作,广州网站制作公司,广州做网站,广州做网站公司,广州网站设计,广州网站设计公司,广州网站开发公司,广州网站开发,广州建站,广州建站公司,广州网络公司" />
<jsp:include page="css.jsp" flush="true"></jsp:include>
<jsp:include page="js.jsp" flush="true"></jsp:include>
<title>智沃商务,华南品牌,专业建设营销建站,手机网站，微网站</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<jsp:include page="menu.jsp" flush="true"></jsp:include>
	<div class="globalWidth">
		<img alt="" src="${ctx}/images/news_banner.png" style="width: 100%;">
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
			<span style="color:#333333;font-size: 30px;">NEWS新闻报道</span><span
				style="color:#333333;font-size: 12px;">关注广州智沃，我们携手前进！</span>
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
							href="${ctx}/${channel.linkAddr}/doc/${doc.id}" target="blank">
								<div style="float: left;">
									<img src="${ctx}/${doc.fileAddr}"
										style="width: 100px;height:100px;">
								</div>
								<div style="float: left;margin-left: 20px;">
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
