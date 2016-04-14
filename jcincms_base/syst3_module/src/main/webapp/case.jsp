<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="meta-channel.jsp" flush="true"></jsp:include>
<jsp:include page="css.jsp" flush="true"></jsp:include>
<jsp:include page="js.jsp" flush="true"></jsp:include>
<title>成功案例,广州智沃,广州智沃——专业的互联网营销策划与人才服务商</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<jsp:include page="menu.jsp" flush="true"></jsp:include>
	<div class="globalWidth" id="banner">
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<img alt="智沃案例" src="${ctx}/images/case-01.jpg"
						style="width: 100%;">
				</div>
				<div class="swiper-slide">
					<img alt="智沃案例" src="${ctx}/images/case-02.jpg"
						style="width: 100%;">
				</div>
			</div>
			<!-- 如果需要分页器 -->
			<div class="swiper-pagination"></div>
		</div>
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
			<span style="color:#333333;font-size: 30px;">CASE成功案例</span><span
				style="color:#333333;font-size: 12px;">我们的作品，他们的故事！</span>
		</div>
		<hr class="hr"></hr>
	</div>
	<div class="globalWidth">
		<div class="contentWidth" style="text-align: left;" id="imglist">
			<c:set var="docs" value="${page.rows}"></c:set>
			<c:if test="${docs!=null}">
				<ul id="case_ul">
					<c:forEach var="doc" items="${docs}">
						<a href="${ctx}/${channel.linkAddr}/doc/${doc.id}"><li><img src="${ctx}/${doc.titleImage}" /> <span>${doc.title}</span></li></a>
					</c:forEach>
				</ul>
			</c:if>

			<c:if test="${docs!=null}">
				<hr
					style="width: 100%;height:1px;border:none;border-top:1px solid #CCCCCC;" />
				<div class="spacer" style="height: 20px;"></div>
				<div
					style="width:100%;padding: 15px 0px 15px 5px;font-size: 12px;text-align: center;">
					<a href="${ctx}/${channel.linkAddr}?page=1"
						class="button button-primary button-rounded button-small">首页</a>&nbsp;&nbsp;
					<c:if test="${page.page>1}">
						<a href="${ctx}/${channel.linkAddr}?page=${page.page-1}"><span>上一页</span></a>&nbsp;&nbsp;</c:if>
					<span>${page.page}</span>&nbsp;&nbsp;
					<c:if test="${page.page < page.totalPage+1}">
						<a href="${ctx}/${channel.linkAddr}?page=${page.page+1}"><span>下一页</span></a>&nbsp;&nbsp;</c:if>
					<c:if test="${page.page < page.totalPage+1}">
						<a href="${ctx}/${channel.linkAddr}?page=${page.totalPage+1}"
							class="button button-primary button-rounded button-small">末页</a>&nbsp;&nbsp;</c:if>
					&nbsp;&nbsp;<span>共${page.totalPage+1}页 ${page.total}条</span>
				</div>
			</c:if>
		</div>
	</div>
	<jsp:include page="footer.jsp" flush="true"></jsp:include>
	<script type="text/javascript">
	var swiper = new Swiper('.swiper-container', {
		pagination : '.swiper-pagination',
		slidesPerView : 1,
		effect : 'fade',
		paginationClickable : true,
		spaceBetween : 30,
		loop: true,
		keyboardControl : true,
        centeredSlides: true,
        autoplay: 3000,
        autoplayDisableOnInteraction: true
	});
	</script>
</body>
</html>
