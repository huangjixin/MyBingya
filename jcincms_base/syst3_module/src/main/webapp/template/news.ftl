<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "meta-channel.ftl">
<#include "css.ftl">
<#include "js.ftl">
<title>资讯中心_智沃商务,华南品牌,专业建设营销建站,手机网站，微网站</title>
</head>
<body>
	<#include "header.ftl">
	<#include "menu.ftl">
	<div class="globalWidth">
		<img alt="" src="${ctx}/images/news_banner.png" style="width: 100%;">
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
			<span style="color:#333333;font-size: 30px;">NEWS新闻报道</span><span
				style="color:#333333;font-size: 12px;">关注广州智沃，我们携手前进！</span>
		</div>
		<hr class="hr"></hr>
	</div>
	<div class="globalWidth">
		<div class="contentWidth" style="text-align: left;">
			<#assign docs=page.rows/>
			<#if docs ??>
				<ul id="newslist">
					<#list docs as doc>
						<li style="margin-top: 20px;margin-bottom: 20px;"><a
							href="${ctx}/${channel.linkAddr}/doc/${doc.id}">
								<div style="float: left;">
									<img src="${ctx}/${doc.titleImage}"
										style="width: 100px;height:100px;">
								</div>
								<div style="float: left;margin-left: 20px;width:80%;">
									<div>
										<span style="font-weight: bold;">${doc.title}</span>
									</div>
									<div style="font-size: 12px;padding-top: 5px;">
										<#setting date_format="yyyy.MM.dd">
										<#if doc.createDate ??>${doc.createDate?date}</#if>
									</div>
									<div style="font-size: 12px;padding-top: 5px;">${doc.contentShort}……</div>
								</div>
								<div class="clear"></div>
								
						</a></li>

						<hr class="hr" style="border-top:1px dashed #cccccc;"></hr>
					</#list>
				</ul>
			</#if>
			
			<#if docs ??>
				<div class="spacer"></div>
				<div
					style="width:100%;padding: 15px 0px 15px 5px;font-size: 12px;text-align: center;">
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
	</div>
	<#include "footer.ftl">
</body>
</html>
