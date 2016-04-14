<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "meta-channel.ftl">
<#include "css.ftl">
<#include "js.ftl">
<title>关于广州智沃,智沃商务,专业建设营销建站,手机网站，微网站</title>
</head>
<body>
	<#include "header.ftl">
	<#include "menu.ftl">
	<div class="globalWidth">
		<img alt="" src="${ctx}/images/aboutus_banner.jpg" style="width: 100%;">
	</div>
	<div class="globalWidth">
		<div class="contentWidth" style="text-align: left;position: relative;">
			<span style="font-size: 12px;color:#333333;">当前位置： <a
				href="${ctx}/"
				style="font-size: 12px;text-decoration: none;color:#333333;">首页</a>
				<#if navChan ??>
					<#list navChan as chan>
										><a href="${ctx}/${chan.linkAddr}"
							style="font-size: 12px;text-decoration: none;color:#333333;">${chan.name}</a>
					</#list>
				</#if>
			</span>
		</div>
	</div>
	<div class="globalWidth">
		<div class="contentWidth" style="text-align: left;padding: 5px 0;">
			<#list navChan as chan>
				<#if (chan_index==0)>
					<#if chan.children ??>
						<#assign chan = chan/>
						<#include "subnav.ftl">
					</#if>
				</#if>
			</#list>
		</div>
		<div class="contentWidth" style="text-align: left;position: relative;">
			<span style="color:#333333;font-size: 30px;">ABOUT关于我们</span><span
				style="color:#333333;font-size: 12px;">最专业的互联网营销策划与人才提供商！</span>
		</div>
		<hr class="hr"></hr>
	</div>
	<div class="globalWidth">
		<div class="contentWidth" style="text-align: left;padding: 5px 0;">
			<#list navChan as chan>
				<#if (chan_index==0)>
					<#if chan.children ??>
						<#assign chan=chan />
						<!--<jsp:include page="subnav.jsp"></jsp:include>-->
					</#if>
				</#if>
			</#list>
		</div>
		<div class="contentWidth" style="padding: 5px 0;">
			${document.content}
			<div style="height: 15px;"></div>
			<hr class="hr" style="border-top:1px dashed #cccccc;padding: 15px 0;"></hr>	
		</div>
	</div>
	<#include "footer.ftl">
</body>
</html>
