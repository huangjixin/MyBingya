<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div class="globalWidth">
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<img alt="智沃" src="${ctx}/images/woshang_index_banner1.jpg">
			</div>
			<div class="swiper-slide">
				<img alt="智沃" src="${ctx}/images/woshang_index_banner2.jpg">
			</div>
			<div class="swiper-slide">
				<img alt="智沃" src="${ctx}/images/woshang_index_banner3.jpg">
			</div>
		</div>
		<!-- 如果需要分页器 -->
		<div class="swiper-pagination"></div>
		<!-- 如果需要导航按钮 -->
		<div class="swiper-button-prev"></div>
		<div class="swiper-button-next"></div>
	</div>
</div>
