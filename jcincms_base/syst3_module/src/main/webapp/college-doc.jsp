<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="meta-doc.jsp" flush="true"></jsp:include>
<jsp:include page="css.jsp" flush="true"></jsp:include>
<jsp:include page="js.jsp" flush="true"></jsp:include>
<title>网络营销学院_广州智沃——专业的互联网营销策划与人才服务商</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<jsp:include page="menu.jsp" flush="true"></jsp:include>
	<div class="globalWidth" id="banner">
		<img alt="" src="${ctx}/images/colloege_banner.png"
			style="width: 100%;">
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
		<div style="text-align: center;color: #333333;padding: 20px 0;">
			<h3>${document.title}</h3>
			<span><fmt:formatDate value="${document.createDate}"
					pattern="yyyy-MM-dd" /></span>
			<div class="bshare-custom"><a title="分享到QQ空间" class="bshare-qzone"></a><a title="分享到新浪微博" class="bshare-sinaminiblog"></a><a title="分享到人人网" class="bshare-renren"></a><a title="分享到腾讯微博" class="bshare-qqmb"></a><a title="分享到网易微博" class="bshare-neteasemb"></a><a title="更多平台" class="bshare-more bshare-more-icon more-style-addthis"></a><span class="BSHARE_COUNT bshare-share-count">0</span></div><script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/buttonLite.js#style=-1&amp;uuid=&amp;pophcol=2&amp;lang=zh"></script><script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/bshareC0.js"></script>
		</div>
		<div class="contentWidth">
			<hr
				style="width: 100%;height:1px;border:none;border-top:1px solid #CCCCCC;" />
			<div style="padding: 20px 0;">${document.content}</div>
			<c:if test="${lastdoc!=null}">
				<div style="width: 100%;font-size: 12px;text-align: left;padding: 20px 0;">
					<span>上一篇：</span><a style="text-decoration: none;color: #333333;"
						href="${ctx}/${channel.linkAddr}/doc/${lastdoc.id}">${lastdoc.title}</a>
				</div>
			</c:if>
			<c:if test="${nextdoc!=null}">
				<div style="width: 100%;font-size: 12px;text-align: left;padding: 20px 0;">
					<span>下一篇：</span><a style="text-decoration: none;color: #333333;"
						href="${ctx}/${channel.linkAddr}/doc/${nextdoc.id}">${nextdoc.title}</a>
				</div>
			</c:if>
		</div>
	</div>
	<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>
