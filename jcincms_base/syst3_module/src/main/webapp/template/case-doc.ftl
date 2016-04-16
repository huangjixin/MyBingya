<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "meta-doc.ftl">
<#include "css.ftl">
<#include "js.ftl">
<title>${document.title},智沃商务,专业建设营销建站,手机网站，微网站</title>
</head>
<body>
	<#include "header.ftl">
	<#include "menu.ftl">
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
		<div class="contentWidth" style="text-align: left;position: relative;">
			<span style="color:#333333;font-size: 30px;">CASE成功案例</span><span
				style="color:#333333;font-size: 12px;">我们的作品，他们的故事！</span>
		</div>
		<hr class="hr"></hr>
	</div>
	<div class="globalWidth">
		<div style="text-align: center;color: #333333;padding: 20px 0;">
			<h3>${document.title}</h3>
			<span>
			<#setting date_format="yyyy.MM.dd">
										<#if document.createDate ??>${document.createDate?date}</#if>
			<div class="bshare-custom"><a title="分享到QQ空间" class="bshare-qzone"></a><a title="分享到新浪微博" class="bshare-sinaminiblog"></a><a title="分享到人人网" class="bshare-renren"></a><a title="分享到腾讯微博" class="bshare-qqmb"></a><a title="分享到网易微博" class="bshare-neteasemb"></a><a title="更多平台" class="bshare-more bshare-more-icon more-style-addthis"></a><span class="BSHARE_COUNT bshare-share-count">0</span></div><script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/buttonLite.js#style=-1&amp;uuid=&amp;pophcol=2&amp;lang=zh"></script><script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/bshareC0.js"></script>
		</div>
		<div class="contentWidth">
			<hr
				style="width: 100%;height:1px;border:none;border-top:1px solid #CCCCCC;" />
			<div style="padding: 20px 0;">${document.content}</div>
			<#if lastdoc ??>
				<div style="width: 100%;font-size: 12px;text-align: left;padding: 5px 0;">
					<span>上一篇：</span><a style="text-decoration: none;color: #333333;"
						href="${ctx}/${channel.linkAddr}/doc/${lastdoc.id}">${lastdoc.title}</a>
				</div>
			</#if>
			<#if nextdoc ??>
				<div style="width: 100%;font-size: 12px;text-align: left;padding: 5px 0;">
					<span>下一篇：</span><a style="text-decoration: none;color: #333333;"
						href="${ctx}/${channel.linkAddr}/doc/${nextdoc.id}">${nextdoc.title}</a>
				</div>
			</#if>
		</div>
	</div>
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
	<#include "footer.ftl">
</body>
</html>
