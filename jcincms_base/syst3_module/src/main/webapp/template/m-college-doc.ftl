<html>
<head>
<#include "m-meta-doc.ftl">
<#include "m-css.ftl" >
<#include "m-js.ftl" >
</head>
<title>${document.title},广州智沃,专业建设营销建站,手机网站，微网站</title>
<body>
	<!-- 头部 -->
	<#include "m-header.ftl" >
	<div class="clear"></div>
	<!-- 菜单 -->
	<#include "m-menu.ftl" >
	<div class="clear"></div>
	<div style="height: 1px;"></div>
	<div style="padding: 5px 0px;">
		<img alt="智沃科技" src="${ctx}/images/colloege_banner.png"
			style="height: auto;width: 100%;">
	</div>
	<div class="clear"></div>
	<div
		style="padding: 5px 0;text-align: center;background-color: red;color:#ffffff;">
		<span>COLLEGE网络营销学院</span>
	</div>
	<div class="global">
		<div style="text-align: center;color: #333333;padding: 20px 0;">
			<h3>${document.title}</h3>
			<span><#setting date_format="yyyy.MM.dd">
				<#if document.createDate ??>${document.createDate?date}</#if></span>
			<div class="bshare-custom">
				<a title="分享到QQ空间" class="bshare-qzone"></a><a title="分享到新浪微博"
					class="bshare-sinaminiblog"></a><a title="分享到人人网"
					class="bshare-renren"></a><a title="分享到腾讯微博" class="bshare-qqmb"></a><a
					title="分享到网易微博" class="bshare-neteasemb"></a><a title="更多平台"
					class="bshare-more bshare-more-icon more-style-addthis"></a><span
					class="BSHARE_COUNT bshare-share-count">0</span>
			</div>
			<script type="text/javascript" charset="utf-8"
				src="http://static.bshare.cn/b/buttonLite.js#style=-1&amp;uuid=&amp;pophcol=2&amp;lang=zh"></script>
			<script type="text/javascript" charset="utf-8"
				src="http://static.bshare.cn/b/bshareC0.js"></script>
		</div>
		<div class="contentWidth">
			<hr
				style="width: 100%;height:1px;border:none;border-top:1px solid #CCCCCC;" />
			<div style="padding: 20px 0;" class="docContent">${document.content}</div>
			<#if lastdoc ??>
				<div style="width: 100%;font-size: 12px;text-align: left;padding: 20px 0;">
					<span>上一篇：</span><a style="text-decoration: none;color: #333333;"
						href="${ctx}/${channel.linkAddr}/doc/${lastdoc.id}">${lastdoc.title}</a>
				</div>
			</#if>
			<#if nextdoc ??>
				<div style="width: 100%;font-size: 12px;text-align: left;padding: 20px 0;">
					<span>下一篇：</span><a style="text-decoration: none;color: #333333;"
						href="${ctx}/${channel.linkAddr}/doc/${nextdoc.id}">${nextdoc.title}</a>
				</div>
			</#if>
		</div>
	</div>

	<div class="clear"></div>
	<!-- 底部 -->
	<#include "m-footer.ftl" >
	<!-- 菜单底部 -->
	<#include "m-bottommenu.ftl" >
</body>
</html>
