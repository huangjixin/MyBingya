<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/css/demo.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<style type="text/css">
	.table{
	width:700px;
	margin:10px auto 7px;
	font-size:12px;
	overflow:hidden;
	border:1px solid #DDD;
	border-collapse:collapse;
}
.table * td{
	padding:6px;
	border:1px solid #EEE;
}

.table thead * th{
	background:#FFF url(table_tbg.gif) 0px 1px repeat-x;
	border:1px solid #E3E3E3;
	padding:6px;
	color:#999;
}
.table tbody * th{
	text-align:left;
	background:#FFA;
	border:1px solid #DDD;
} 
.table tbody * th strong{
	line-height:21px;
	text-indent:10px;
	color:#999;
}
.td1{
	text-align:right;
	color:#666;
}
.td2,.td3,.td4,.td5,.td6,.td7,.td8,.td9{
	text-align:center;
}
.td5{
	background:#FAFAFA;
}
.td6,.td7,.td8,.td9{
	background:#F5F9F0;
}
	
</style>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<title>${document.title}</title>
</head>
<body>
	<div id="container">
		<!-- 头部 -->
		<jsp:include page="header.jsp" flush="true"></jsp:include>
		<div class="spacer"></div>
		<!-- 导航菜单 -->
		<jsp:include page="menu.jsp" flush="true"></jsp:include>
		<div class="spacer"></div>
		<div id="main">
			<div id="content">
				<!-- 位置-->
				<jsp:include page="nav.jsp" flush="true"></jsp:include>
				<div class="spacer"></div>
				<div class="article">
					<div class="info">
						<div style="width: 100%;text-align: center;">
							<span style="font-weight: bold;font-size: 16px;">${document.title}</span>
						</div>
						<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;" />
						<div style="width: 100%;text-align: center;font-size: 12px;">
							${document.author}&nbsp;&nbsp;&nbsp;&nbsp;<span><fmt:formatDate
									value="${document.createDate}" pattern="yyyy.MM.dd" /></span>&nbsp;&nbsp;阅读:
							<span id="hits"><script type="text/javascript">
								$("#hits").load('${ctx}/channel/getClickCount?id=${document.id}');
							</script></span>
						</div>
						<p>${document.content}</p>
					</div>
				</div>
				<div class="spacer"></div>
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
			</div>
			<!-- 右边导航 -->
			<jsp:include page="right_side.jsp" flush="true"></jsp:include>
		</div>
		<div class="clear"></div>
		<!-- 网页底部 -->
		<jsp:include page="footer.jsp" flush="true"></jsp:include>
	</div>
</body>
</html>
