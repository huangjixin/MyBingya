<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div class="swiper-container">
	<img style="width: 100%;" src="${ctx}/images/swiper1.png">
</div>
<%-- <div class="swiper-container swiper-container-fade">
	<div class="swiper-wrapper">
		<div class="swiper-slide">
			<img src="${ctx}/images/swiper1.png" />
		</div>
		<div class="swiper-slide">
			<img src="${ctx}/images/swiper1.png" />
		</div>
		<div class="swiper-slide">
			<img src="${ctx}/images/swiper1.png" />
		</div>
		<div class="swiper-slide">
			<img src="${ctx}/images/swiper1.png" />
		</div>
	</div>
	<div class="swiper-pagination swiper-pagination-white"></div>
	<div class="swiper-button-next swiper-button-white"></div>
	<div class="swiper-button-prev swiper-button-white"></div>
</div>
<script>
	var swiper = new Swiper('.swiper-container-fade', {
		pagination : '.swiper-pagination-white',
		paginationClickable : true,
		nextButton : '.swiper-button-next',
		prevButton : '.swiper-button-prev',
		loop : true,
		autoplay : 2500,
		autoplayDisableOnInteraction : true,
		spaceBetween : 30,
		effect : 'fade'
	});
</script> --%>