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
		<div class="contentWidth" style="text-align: left;">
			<#assign docs=page.rows/>
			<#if docs ??>
				<ul id="case_ul">
					<#list docs as doc>
						<a href="${ctx}/${channel.linkAddr}/doc/${doc.id}"><li><img src="${ctx}/${doc.titleImage}" /> <span>${doc.title}</span></li></a>
					</#list>
				</ul>
			</#if>
			
			<#if docs ??>
				<div class="spacer"></div>
				<div
					style="width:100%;padding: 15px 0px 15px 5px;font-size: 12px;text-align: center;">
					<a href="${ctx}/${channel.linkAddr}?page=1"  class="button button-primary button-rounded button-small">首页</a>&nbsp;&nbsp;
					<#if (page.page>1)>
						<a href="${ctx}/${channel.linkAddr}?page=${page.page-1}"  class="button button-primary button-rounded button-small">上一页</a>&nbsp;&nbsp;</#if>
					${page.page}&nbsp;&nbsp;
					<#if (page.page < page.totalPage+1)>
						<a href="${ctx}/${channel.linkAddr}?page=${page.page+1}"  class="button button-primary button-rounded button-small">下一页</a>&nbsp;&nbsp;</#if>
					<#if (page.page < page.totalPage+1)>
						<a href="${ctx}/${channel.linkAddr}?page=${page.totalPage+1}"  class="button button-primary button-rounded button-small">末页</a>&nbsp;&nbsp;</#if>
					&nbsp;&nbsp;<span>共${page.totalPage+1}页 ${page.total}条</span>
				</div>
			</#if>
		</div>
	</div>
	<#include "footer.ftl">
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
</body>
</html>
