<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<c:choose>
	<c:when test="${channel!=null}">
		<meta name="description" content="${channel.description}" />
		<meta name="keywords" content="${channel.keyword}" />
	</c:when>
	<c:otherwise>
		<meta name="description"
			content="广州智沃科技有限公司是一家以高端网站设计开发为核心业务的电子商务咨询服务机构。我们能为你提供的不仅仅是网站建设，而是一套适合您的解决方案及一支全方的位护航编队。传递品牌文化，雕琢商业品牌，对追求品质和苛求细节的人而言，我们是最理想的电子商务服务商。一支以创新为核心的团队，一支视品质为生命 的团队，一群怀揣梦想的孩子，这就是智沃！电话:13926205227。" />
		<meta name="keywords"
			content="广州网站建设,广州网站建设公司,广州网站制作,广州网站制作公司,广州做网站,广州做网站公司,广州网站设计,广州网站设计公司,广州网站开发公司,广州网站开发,广州建站,广州建站公司,广州网络公司" />
	</c:otherwise>
</c:choose>
