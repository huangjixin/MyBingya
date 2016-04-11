<html>
<head>
<#include "m-meta.ftl" >
<#include "m-css.ftl" >
<#include "m-js.ftl" >
</head>
<title>广州智沃,华南品牌,专业建设营销建站,手机网站，微网站，微商城</title>
<body>
	<!-- 头部 -->
	<#include "m-header.ftl" >
	<div class="clear"></div>
	<!-- 菜单 -->
	<#include "m-menu.ftl" >
	<div class="clear"></div>
	<div style="height: 1px;"></div>
	<div style="padding: 5px 0px;">
		<a href="${ctx}/"><img alt="智沃科技" src="${ctx}/images/m-banner.jpg"
			style="height: auto;width: 100%;"></a>
	</div>
	<div class="banner">
		<ul>
			<li><a href="${ctx}/channel/case"><img alt=""
					src="${ctx}/images/mob2.jpg" style="width: 90%;height: auto;"></a></li>
			<li><a href="${ctx}/channel/college"><img alt="" src="${ctx}/images/mob4.jpg"
					style="width: 90%;height: auto;"></a></li>
			<li><a href="${ctx}/channel/web"><img alt=""
					src="${ctx}/images/mob5.jpg" style="width: 90%;height: auto;"></a></li>
			<li><a href="${ctx}/channel/aboutus"><img alt="" src="${ctx}/images/mob8.jpg"
					style="width: 90%;height: auto;"></a></li>
		</ul>
	</div>
	<div class="clear"></div>
	<div class="devider"></div>
	<div
		style="padding: 5px 0;text-align: center;background-color: red;color:#ffffff;">
		<span>成功案例</span>
	</div>
	<div class="global">
		<div class="news">
			<ul style="padding-top: 10px;">
				<c:set var="docs" value="${fns:getDocByChannelCode('case',10)}"></c:set>
				<c:if test="${docs!=null}">
					<c:forEach var="doc" items="${docs}">
						<li><a href="${ctx}/channel/case/doc/${doc.id}">
								<div style="float: left;">
									<img src="${ctx}/${doc.titleImage}"
										style="width: 80px;height:80px;">
								</div>
								<div style="float: left;margin-left: 20px;width:240px;">
									<div>
										<span style="font-weight: bold;float:none;">${doc.title}</span>
									</div>
									<div style="font-size: 12px;padding-top: 5px;">
										<#setting date_format="yyyy.MM.dd">
											<#if doc.createDate ??>${doc.createDate?date}</#if>
									</div>
									<div style="font-size: 12px;padding-top: 5px;">${doc.contentShort}……</div>
								</div>
								<div class="clear"></div>
						</a></li>
						<hr class="hr"></hr>
					</c:forEach>
				</c:if>
			</ul>
		</div>
	</div>
	<div class="clear"></div>
	<div class="devider"></div>
	<div
		style="padding: 5px 0;text-align: center;background-color: red;color:#ffffff;">
		<span>成功案例</span>
	</div>
	<div style="padding-top: 5px;text-align: center;">
		<a href="${ctx}/channel/case"><img alt="智沃科技" src="${ctx}/images/m-case-banner1.jpg"
			style="width: 49%;"> <img alt="智沃科技"
			src="${ctx}/images/m-case-banner2.jpg" style="width: 49%;"></a>
	</div>

	<div
		style="padding: 5px 0;text-align: center;background-color: red;color:#ffffff;">
		<span>公司主营业务</span>
	</div>
	<div class="global" style="padding: 0px 10px;">
		<div class="case">
			<span> 
				<div style="width: 120px;"><i id="zhizuo" style="color:#455DC2;"
							class="fa fa-desktop fa-5x"></i></div>
				<div>网站建设</div>
				<div>营销型网站</div>
				<div>展示型网站</div>
			</span> 
			<span> <div style="width: 120px;"><i id="zhizuo" style="color:#E37C51;"
							class="fa fa-html5 fa-5x"></i></div>
				<div>移动开发</div>
				<div>手机网站开发</div>
				<div>APP开发</div>
			</span> 
			<span><div style="width: 120px;"><i id="zhizuo" style="color:#2A92DE;"
							class="fa fa-globe fa-spin fa-5x"></i></div>
				<div>网络营销</div>
				<div>SEO优化</div>
				<div>网站策划推广</div>
			</span> 
			<span><div style="width: 120px;"><i id="zhizuo" style="color:green;"
							class="fa fa-comments fa-5x"></i></div>
				<div>微信公众号</div>
				<div>微网站开发</div>
				<div>APP开发</div>
			</span>
		</div>
	</div>
	<div class="clear"></div>
	<div class="devider"></div>
	<div
		style="padding: 5px 0;text-align: center;background-color: red;color:#ffffff;">
		<span>公司新闻</span>
	</div>
	<div class="global">
		<div class="news">
			<ul style="padding-top: 10px;">
				<#if menusMap?exists>
					<#list menusMap?keys as rootKey>
						<#if rootKey=='news'>
							<#list menusMap[rootKey] as doc>
								<#setting date_format="yyyy.MM.dd">
									<li><a href="${ctx}/channel/news/doc/${doc.id}">${doc.title}<span><#if doc.createDate ??>${doc.createDate?date}</#if></span></a></li>
							</#list>
						</#if>
					</#list>
				</#if>
			</ul>
		</div>
	</div>
	
	<div class="clear"></div>
	<div class="devider"></div>
	<div
		style="padding: 5px 0;text-align: center;background-color: red;color:#ffffff;">
		<span>营销知识</span>
	</div>
	<div class="global">
		<div class="news">
			<ul style="padding-top: 10px;">
				<#if menusMap?exists>
					<#list menusMap?keys as rootKey>
						<#if rootKey=='college'>
							<#list menusMap[rootKey] as doc>
								<#setting date_format="yyyy.MM.dd">
									<li><a href="${ctx}/channel/news/doc/${doc.id}">${doc.title}<span><#if doc.createDate ??>${doc.createDate?date}</#if></span></a></li>
							</#list>
						</#if>
					</#list>
				</#if>
			</ul>
		</div>
	</div>

	<div class="clear"></div>
	<!-- 底部 -->
	<#include "m-footer.ftl" >
	<!-- 菜单底部 -->
	<#include "m-bottommenu.ftl" >
</body>
</html>
