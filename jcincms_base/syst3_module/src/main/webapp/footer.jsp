<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<script type="text/javascript">
	//initiating jQuery
	jQuery(function($) {
		$(document).ready(function() {
			try{
				$('#alarm-ring')[0].play();
			}
			catch(e){}
			
			$('#nav').onePageNav();

			//enabling stickUp on the '.navbar-wrapper' class
			$('#menuContainer').stickUp();

			createTab();
			$(".content_p1_img").mouseover(function(e) {
				// 				if(checkHover(e,this)){
				// 					anim(this, 'fadeInUp');
				// 			    }
			});
			
			window.onscroll = function(){
				animateContent3();
		        animateContent6();
		    }
			
// 			alert($(".content_p1_img").height()+""+$(".content_p1_img").width());
			// 			$(".content_p1_img").mouseout(function() {
			// 				if(checkHover(e,this)){
			// 					anim(this, 'fadeInDown');
			// 			    }
			// 			});
			// 			anim('.content_p1_img', 'bounceInLeft')
			// 			$('.content_p1_img').addClass('animated bounceInLeft');
		});
	});

	function animateContent6(){
		var scrollTop = document.body.scrollTop;
		var obj = document.getElementById("content6");
	    var _getHeight = obj.offsetTop;
	    if(scrollTop > _getHeight-100){
	    	$(".content6_div").animate({height:"300px"});
	    }
	}

	function animateContent3(){
		var scrollTop = document.body.scrollTop;
		var obj = document.getElementById("content3");
	    var _getHeight = obj.offsetTop;
	    if(scrollTop > _getHeight-200){
	    	$("#content3_p").animate({left:"20px"});
	    	$("#content3_ul").animate({left:"20px"});
	    	$("#p3-1").animate({right:"0px"});
	    	$("#p3-2").animate({right:"0px"});
	    }
	}

	
	function include(url) {
		$.get(url, function(data) {
			document.write(data);
		})
	}

	function anim(target, x) {
		$(target)
				.removeClass()
				.addClass(x + ' animated')
				.one(
						'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend',
						function() {
							$(this).removeClass();
						});
	};

	function createTab() {
		//Default Action
		$(".tab_content").hide(); //Hide all content
		$("ul.tabs li:first").addClass("active").show(); //Activate first tab
		$(".tab_content:first").show(); //Show first tab content

		//On Click Event
		$("ul.tabs li").click(function() {
			$("ul.tabs li").removeClass("active"); //Remove any "active" class
			$(this).addClass("active"); //Add "active" class to selected tab
			$(".tab_content").hide(); //Hide all tab content
			var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content
			$(activeTab).fadeIn(); //Fade in the active content
			return false;
		});
	}
	
	
	<!-- Initialize Swiper -->
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
<audio id="alarm-ring" preload>
	<source src="assets/audio/ticktac.mp3" type="audio/mpeg" />
	<source src="assets/audio/ticktac.ogg" type="audio/ogg" />
</audio>
<div class="globalWidth" id="footer"
	style="text-align: center;background-color: #0A264D;color:#466D88;">
	<div class="contentWidth">
		<div
			style="width: 100%;margin: 0 auto;text-align: center;padding-top: 30px;padding-bottom: 30px;">
			<div>
				<img alt="" src="${ctx}/images/logo.png">
			</div>
			<div>——我们的产品——</div>
			<div>
				<span>全网营销型网站</span>
			</div>
			<div>广州智沃信息科技有限公司——专业的互联网营销策划与人才服务商，专业的互动策划、营销网站设计、移动网站、微网站开发公司。服务范围涉及：微信开发，软件外包，网站建设等</div>
		</div>
	</div>
	<div class="contentWidth"
		style="text-align: center;height: 40px;line-height: 40px;">
		<span style="font-size: 14px;color: #ffffff">Copyright
			2015-2016 广州智沃信息技术 All rights reserved</span>
	</div>
</div>