<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<title><#if document.title ??>${document.title}</#if></title>
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
	<div class="primary" style="overflow: hidden;">
		<#setting date_format="yyyy.MM.dd">
		<!-- title/S -->
		<h1 class="title"
			style="font-size:1.375em;color: #000;text-align:left;padding: 15px 0 5px;font-weight: 700;line-height: 26px;margin: 0 8px;">${document.title}</h1>
		<div class="meta"
			style="margin: 0 8px;overflow: hidden;font-size: 0.8125em;position: relative;height: 26px;border-bottom: 1px solid #eceef0;">
			<span class="time"><#if document.createDate ??>${document.createDate?date}</#if></span>&nbsp;&nbsp;&nbsp;&nbsp;<span class="author">${document.author}</span>
		</div>
		<div class="content fontsmall">
			<p
				style="padding: 0 10px;font-size: 1em;color: #393939;line-height: 30px;word-wrap:break-word;margin-bottom: 5px;text-align: justify;">
				${document.content}
			</p>
		</div>
	</div>
	<#if lastdoc ??>
		<div>
			<span>上一篇：</span><a href="${ctx}/${channel.linkAddr}/doc/${lastdoc.id}">${lastdoc.title}</a>
		</div>
	</#if>
	<#if nextdoc ??>
		<div>
			<span>下一篇：</span><a href="${ctx}/${channel.linkAddr}/doc/${nextdoc.id}">${nextdoc.title}</a>
		</div>
	</#if>
	<hr style="width:100%;height:1px;border:none;border-top:1px solid #CCCCCC;" />
	<div id="footer" style="text-align: center;padding-bottom: 5px;">Copyright
		© 2011-2015 jcincms内容管理系统.</div>
	<script type="text/javascript">
		featuredcontentslider.init({
			id : "sliderA",
			contentsource : [ "inline", "" ],
			toc : "#increment",
			nextprev : [ "", "" ],
			revealtype : "mouseover",
			enablefade : [ true, 0.15 ],
			autorotate : [ true, 3500 ],
			delay : 150,
			onChange : function(previndex, curindex) {
			}
		});
	</script>	
</body>
</html>
