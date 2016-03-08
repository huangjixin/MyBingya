<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>${document.title}</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- viewport是网页默认的宽度和高度，上面这行代码的意思是，网页宽度默认等于屏幕宽度（width=device-width），原始缩放比例（initial-scale=1）为1.0，即网页初始大小占屏幕面积的100%。 -->
<meta name="keywords" content="${document.title},${document.keyword}">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/m-demo.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
</head>
<body>
	<div class="header">
		<a href="${ctx}/"><img alt="logo" src="${ctx}/images/logo.gif"
			style="height: 40px;" /></a>
	</div>
	<div class="menu"
		style="height:40px;z-index:3;background:#212121;top:0; left:0; display:block;">
		<ul>
			<c:if test="${list!=null}">
				<c:forEach var="channel" items="${list}">
					<c:if test="${channel.name!=null && channel.name!=''}">
						<li><a href="${ctx}/${channel.linkAddr}">${channel.name}</a></li>
					</c:if>
				</c:forEach>
			</c:if>
		</ul>
	</div>
	<div style="width: 100%;background-color: #ececec;">
		<div class="nav" style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px;">
			<a href="${ctx}/" style="color: #333333;">首页</a>
			<c:if test="${navChan !=null}">
					<c:forEach var="chan" items="${navChan}" varStatus="status">
						-<a href="${ctx}/${chan.linkAddr}" style="color: #333333;">${chan.name}</a>
					</c:forEach>
				</c:if>
		</div>
	</div>
	<div class="primary" style="overflow: hidden;">
		<!-- title/S -->
		<h1 class="title"
			style="font-size:1.375em;color: #000;text-align:left;padding: 15px 0 5px;font-weight: 700;line-height: 26px;margin: 0 8px;">${document.title}</h1>
		<div class="meta"
			style="margin: 0 8px;overflow: hidden;font-size: 0.8125em;position: relative;height: 26px;border-bottom: 1px solid #eceef0;">
			<span class="time"><fmt:formatDate value="${document.createDate}" pattern="yyyy.MM.dd" /></span>&nbsp;&nbsp;&nbsp;&nbsp;<span class="author">${document.author}</span>&nbsp;&nbsp;阅读:
			<span id="hits"><script type="text/javascript">
				$("#hits").load('${ctx}/channel/getClickCount?id=${document.id}');
			</script></span>
		</div>
		<div class="content fontsmall">
			<p
				style="padding: 0 10px;font-size: 1em;color: #393939;line-height: 30px;word-wrap:break-word;margin-bottom: 5px;text-align: justify;">
				${document.content}
			</p>
		</div>
	</div>
	<c:if test="${lastdoc!=null}">
		<div style="font-size: 12px;">
			<span>上一篇：</span><a
				href="${ctx}/${channel.linkAddr}/doc/${lastdoc.id}">${lastdoc.title}</a>
		</div>
	</c:if>
	<c:if test="${nextdoc!=null}">
		<div style="font-size: 12px;">
			<span>下一篇：</span><a
				href="${ctx}/${channel.linkAddr}/doc/${nextdoc.id}">${nextdoc.title}</a>
		</div>
	</c:if>
	<jsp:include page="m-footer.jsp" flush="true"></jsp:include>
</body>
</html>
