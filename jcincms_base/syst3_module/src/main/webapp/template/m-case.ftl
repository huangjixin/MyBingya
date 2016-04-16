<html>
<head>
<#include "m-meta.ftl" >
<#include "m-css.ftl" >
<#include "m-js.ftl" >
</head>
<title>成功案例,华南品牌,专业建设营销建站,手机网站，微网站，微商城</title>
<body>
	<!-- 头部 -->
	<#include "m-header.ftl" >
	<div class="clear"></div>
	<!-- 菜单 -->
	<#include "m-menu.ftl" >
	<div class="clear"></div>
	<div style="height: 1px;"></div>
	<div style="padding: 5px 0px;">
		<img alt="智沃科技" src="${ctx}/images/case-01.jpg"
			style="height: auto;width: 100%;">
	</div>
	<div class="clear"></div>
	<div
		style="padding: 5px 0;text-align: center;background-color: red;color:#ffffff;">
		<span>CASE成功案例</span>
	</div>
	<div class="global">
		<div class="news">
			<ul style="padding-top: 10px;">
				<#assign docs=page.rows/>
				<#if docs ??>
						<#list docs as doc>
							<li style="margin-top: 20px;margin-bottom: 20px;"><a
								href="${ctx}/${channel.linkAddr}/doc/${doc.id}">
									<div style="float: left;">
										<img src="${ctx}/${doc.titleImage}"
											style="width: 80px;height:80px;">
									</div>
									<div style="float: left;margin-left: 20px;width:240px;">
										<div>
											<span style="font-weight: bold;">${doc.title}</span>
										</div>
										<div class="clear"></div>
										<div style="font-size: 12px;padding-top: 5px;">
											<#setting date_format="yyyy.MM.dd">
											<#if doc.createDate ??>${doc.createDate?date}</#if>
										</div>
										<div class="clear"></div>
										<div style="font-size: 12px;padding-top: 5px;">${doc.contentShort}……</div>
									</div>
									<div class="clear"></div>
							</a></li>
							<hr class="hr"></hr>
						</#list>
				</#if>
			</ul>
		</div>
	</div>
	<#if docs ??>
				<div class="spacer"></div>
				<div
					style="width:100%;padding: 15px 0px;font-size: 12px;text-align: center;">
					<a href="${ctx}/${channel.linkAddr}?page=1"  class="button button-primary button-rounded button-tiny">首页</a>&nbsp;&nbsp;
					<#if (page.page>1)>
						<a href="${ctx}/${channel.linkAddr}?page=${page.page-1}"  class="button button-primary button-rounded button-tiny">上一页</a>&nbsp;&nbsp;</#if>
					${page.page}&nbsp;&nbsp;
					<#if (page.page < page.totalPage+1)>
						<a href="${ctx}/${channel.linkAddr}?page=${page.page+1}"  class="button button-primary button-rounded button-tiny">下一页</a>&nbsp;&nbsp;</#if>
					<#if (page.page < page.totalPage+1)>
						<a href="${ctx}/${channel.linkAddr}?page=${page.totalPage+1}"  class="button button-primary button-rounded button-tiny">末页</a>&nbsp;&nbsp;</#if>
					&nbsp;&nbsp;<span>共${page.totalPage+1}页 ${page.total}条</span>
				</div>
	</#if>

	<div class="clear"></div>
	<!-- 底部 -->
	<#include "m-footer.ftl" >
	<!-- 菜单底部 -->
	<#include "m-bottommenu.ftl" >
</body>
</html>
