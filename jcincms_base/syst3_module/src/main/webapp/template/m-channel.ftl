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
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/slider.js"></script>
<script type="text/javascript" src="${ctx}/js/webtry_roll.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/m-demo.css">
<title>${channel.name}</title>
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
	<div id="content">
		<#if page ??>
					<#list page.rows as doc>
							<div class="spacer"></div>
							<div class="article">
								<div class="info">
									<span style="font-weight: bold;font-size: 14px;"><a
										href="${ctx}/${channel.linkAddr}/doc/${doc.id}" target="blank">${doc.title}</a></span>&nbsp;&nbsp;
									<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
									<p>文章摘要：<#if doc.contentShort ??>${doc.contentShort}</#if></p>
									<div style="font-size: 12px;">
										<#setting date_format="yyyy.MM.dd">
										${doc.author}&nbsp;&nbsp;&nbsp;&nbsp;<span
											style="font-size: 12px;"><#if doc.createDate ??>${doc.createDate?date}</#if></span>
									</div>
								</div>
							</div>
					</#list>
				</#if>
				<#if page ??>
					<div class="spacer"></div>
					<div style="width:auto;padding: 5px 0px 5px 5px;font-size: 12px;">
							<a href="${ctx}/${channel.linkAddr}?page=1"><span>首页</span></a>&nbsp;&nbsp;
							<#if (page.page>1)>
								<a href="${ctx}/${channel.linkAddr}?page=${page.page-1}"><span>上一页</span></a>&nbsp;&nbsp;</#if>
							<span>${page.page}</span>&nbsp;&nbsp;
							<#if (page.page < page.totalPage+1)>
								<a href="${ctx}/${channel.linkAddr}?page=${page.page+1}"><span>下一页</span></a>&nbsp;&nbsp;</#if>
							<#if (page.page < page.totalPage+1)>
								<a href="${ctx}/${channel.linkAddr}?page=${page.totalPage+1}"><span>末页</span></a>&nbsp;&nbsp;</#if>
							&nbsp;&nbsp;<span>共${page.totalPage+1}页 ${page.total}条</span>
					 </div>
				</#if>
	</div>
	<hr style="width:100%;height:1px;border:none;border-top:1px solid #CCCCCC;" />
	<div id="footer" style="text-align: center;padding-bottom: 5px;">Copyright
		© 2011-2015 jcincms内容管理系统.</div>
</body>
</html>
