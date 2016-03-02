<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.case span').mouseover(function(e) {
			$(this).siblings().stop().fadeTo(500, 0.4);
		});
		$('.case span').mouseout(function(e) {
			$(this).siblings().stop().fadeTo(500, 1);
		});

		$(window).scroll(function() {
			t = $(document).scrollTop();
			if (t > 150) {
				$(".topnav").stop(false, false);
				$(".topnav").animate({
					top : "0px"
				}, 300);
			} else {
				$(".topnav").stop(false, false);
				$(".topnav").animate({
					top : "-105px"
				}, 300);
			}
		})
	});

	function showhide(id) {
		var sbtitle = document.getElementById(id);
		if (sbtitle) {
			if (sbtitle.style.display == 'block') {
				sbtitle.style.display = 'none';
			} else {
				sbtitle.style.display = 'block';
			}
		}
	}
</script>
