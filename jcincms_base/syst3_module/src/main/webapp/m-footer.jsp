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
	jQuery(function($) {
		$(document).ready(function() {
			$('#menuContainer').stickUp();
		});
	});
	
	var swiper = new Swiper('.swiper-container', {
		pagination : '.swiper-pagination',
		slidesPerView : 1,
		paginationClickable : true,
		spaceBetween : 30,
		loop: true,
		keyboardControl : true,
		nextButton : '.swiper-button-next',
		prevButton : '.swiper-button-prev',
	});
</script>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?8a73e59ca4b3c76c4061afd550f44726";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
