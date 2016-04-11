<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="m-meta.jsp" flush="true"></jsp:include>
<jsp:include page="m-css.jsp" flush="true"></jsp:include>
<jsp:include page="m-js.jsp" flush="true"></jsp:include>
<title>关于广州智沃,智沃商务,华南品牌,专业建设营销建站,手机网站，微网站</title>
</head>
<body>
	<!-- 头部 -->
	<jsp:include page="m-header.jsp" flush="true"></jsp:include>
	<div class="clear"></div>
	<!-- 菜单 -->
	<jsp:include page="m-menu.jsp" flush="true"></jsp:include>
	<div class="clear"></div>
	<div style="height: 1px;"></div>
	<div style="padding: 5px 0px;">
		<a href="${ctx}/"><img alt="智沃科技"
			src="${ctx}/images/aboutus_banner.jpg" style="height: auto;width: 100%;"></a>
	</div>
	<div
		style="padding: 5px 0;text-align: center;background-color: red;color:#ffffff;">
		<span>ABOUT关于我们</span>
	</div>
	<div class="global">
		<div style="text-align: center;color: #333333;padding: 10px 0;"  id="aboutus_content">
			${document.content}
			<hr class="hr" style="border-top:1px dashed #cccccc;padding: 0px 0;"></hr>	
		</div>
	</div>
	<div class="clear"></div>
	<!-- 底部 -->
	<jsp:include page="m-footer.jsp" flush="true"></jsp:include>
	<!-- 菜单底部 -->
	<jsp:include page="m-bottommenu.jsp" flush="true"></jsp:include>
</body>
</html>
