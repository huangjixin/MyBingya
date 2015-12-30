<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- viewport是网页默认的宽度和高度，上面这行代码的意思是，网页宽度默认等于屏幕宽度（width=device-width），原始缩放比例（initial-scale=1）为1.0，即网页初始大小占屏幕面积的100%。 -->
<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/swiper.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/m-demo.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/swiper.js"></script>
<title>首页</title>
</head>
<body>
	<div class="header">
		<a href="${ctx}/"><img alt="logo" src="${ctx}/images/logo.gif"
			style="height: 40px;" /></a>
	</div>
	<div class="menu"
		style="height:40px;z-index:3;background:#212121;top:0; left:0; display:block;">
		<ul>
			<#if menus ??>
				<#list menus as channel>
					<#if channel.name ??>
						<li><a href="${ctx}/${channel.linkAddr}">${channel.name}</a></li>
					</#if>
				</#list>
			</#if>
		</ul>
	</div>
	<div class="swiper-container swiper-container-fade">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<img src="${ctx}/images/79084479.jpg" width="400" height="200"
						border="0" />
				</div>
				<div class="swiper-slide">
					<img src="${ctx}/images/79064170.jpg" width="400" height="200"
						border="0" />
				</div>
				<div class="swiper-slide">
					<img src="${ctx}/images/79084750.jpg" width="400" height="200"
						border="0" />
				</div>
				<div class="swiper-slide">
					<img src="${ctx}/images/79085270.jpg" width="400" height="200"
						border="0" />
				</div>
			</div>
			<div class="swiper-pagination swiper-pagination-white"></div>
		</div>
	</div>
	<div style="height: 10px;"></div>
	<div class="module">
		<div class="head">
			<h2 class="current" data-tab="news">热点推荐</h2>
		</div>
		<div class="list topnews">
			<ul>
				<#if recommendDocs ??>
					<#list recommendDocs as doc>
						<#if doc.title ??>
								<#if doc.channel ??>
									<li><a href="${ctx}/${doc.channel.linkAddr}/doc/${doc.id}">${doc.title}</a></li>
								<#else>
									<li><a href="${ctx}/channel/recommend/doc/${doc.id}">${doc.title}</a></li>
								</#if>
						</#if>
					</#list>
				</#if>
			</ul>
		</div>
	</div>
	
	<#if modules ??>
		<#list modules as channel>
			<div class="module">
				<div class="head">
					<h2 class="current" data-tab="news">${channel.name}</h2>
				</div>
				<div class="list topnews">
					<#if menusMap?exists>
						<ul>
							<#list menusMap?keys as rootKey>
								<#if rootKey==channel.code>
									<#list menusMap[rootKey] as doc>
										<li><a href="${ctx}/${channel.linkAddr}/doc/${doc.id}"
												>${doc.title}</a></li>
									</#list>
								</#if>
							</#list>
						</ul>
					</#if>
				</div>
			</div>
			<div style="width: 100%;text-align: center;background-color: #F3F3F9;line-height: 30px;height: 30px;"><a href="${ctx}/${channel.linkAddr}" style="color: #333333;">进入${channel.name}</a></div>
			<div style="height: 5px;"></div>
		</#list>
	</#if>
	<#include "template/m-footer.ftl" >
	<script>
		var swiper = new Swiper('.swiper-container-fade', {
			pagination : '.swiper-pagination-white',
			paginationClickable : true,
			loop : true,
			autoplay : 2500,
			autoplayDisableOnInteraction : true,
			spaceBetween : 30,
			effect : 'fade'
		});
	</script>
</body>
</html>
