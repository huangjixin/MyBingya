<html>
<head>
<#include "m-meta.ftl" >
<#include "m-css.ftl" >
<#include "m-js.ftl" >
</head>
<title>关于广州智沃,广州智沃,专业建设营销建站,手机网站，微网站，微商城</title>
<body>
	<!-- 头部 -->
	<#include "m-header.ftl" >
	<div class="clear"></div>
	<!-- 菜单 -->
	<#include "m-menu.ftl" >
	<div class="clear"></div>
	<div style="height: 1px;"></div>
	<div style="padding: 5px 0px;">
		<img alt="智沃科技" src="${ctx}/images/aboutus_banner.jpg"
			style="height: auto;width: 100%;">
	</div>
	<div class="clear"></div>
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
	<#include "m-footer.ftl" >
	<!-- 菜单底部 -->
	<#include "m-bottommenu.ftl" >
</body>
</html>
