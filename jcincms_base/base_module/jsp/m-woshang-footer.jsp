<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div class="globalWidth"
	style="background: -moz-linear-gradient(top, #141414, #141414);background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#141414),
		to(#141414) );">
	<div class="contentWidth"
		style="text-align: center;height: 40px;line-height: 40px;">
		<span style="font-size: 14px;color: #ffffff">Copyright 广州智沃信息技术 All rights reserved</span>
	</div>
	<div style="height: 40px;"></div>
</div>
<script src="${ctx}/js/swiper.min.js"></script>
<!-- Initialize Swiper -->
<script>
	var swiper = new Swiper('.swiper-container', {
		pagination : '.swiper-pagination',
		slidesPerView : 1,
		paginationClickable : true,
		spaceBetween : 30,
		keyboardControl : true,
		nextButton : '.swiper-button-next',
		prevButton : '.swiper-button-prev',
	});
</script>