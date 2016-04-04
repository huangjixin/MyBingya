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
				animateContent2();
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

	function animateContent2(){
		var scrollTop = document.body.scrollTop;
		var obj = document.getElementById("content2");
	    var _getHeight = obj.offsetTop;
	    if(scrollTop > _getHeight+200){
	    	$("#content2_wap1").animate({right:"0px"});
	    	$("#content2_wap2").animate({left:"10px"});
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
<script type="text/javascript">
$(document).ready(function(){

	$(".side ul li").hover(function(){
		$(this).find(".sidebox").stop().animate({"width":"124px"},200).css({"opacity":"1","filter":"Alpha(opacity=100)","background":"#ae1c1c"})	
	},function(){
		$(this).find(".sidebox").stop().animate({"width":"45px"},200).css({"opacity":"0.8","filter":"Alpha(opacity=80)","background":"#000"})	
	});
	/* $("#eee").hover(function(){
		$(".erwei").fadeIn(300);
		},function(){
			$(".erwei").hide();
	}); */
});

//回到顶部
function goTop(){
	$('html,body').animate({'scrollTop':0},600);
}
</script>
<style>
.guestBook{
	position: fixed;
	bottom:0;
	right: 0;
	z-index: 100;
}
/* side */
.side {
	position: fixed;
	width: 45px;
	height: 275px;
	right: 0;
	top: 224px;
	z-index: 100;
}

.side ul li {
	width: 45px;
	height: 45px;
	float: left;
	position: relative;
	border-bottom: 1px solid #444;
}

.side ul li .sidebox {
	position: absolute;
	width: 45px;
	height: 45px;
	top: 0;
	right: 0;
	transition: all 0.3s;
	background: #000;
	opacity: 0.8;
	filter: Alpha(opacity = 80);
	color: #fff;
	font: 14px/45px "微软雅黑";
	overflow: hidden;
}

.side ul li .sidetop {
	width: 45px;
	height: 45px;
	line-height: 45px;
	display: inline-block;
	background: #000;
	opacity: 0.8;
	filter: Alpha(opacity = 80);
	transition: all 0.3s;
}

.side ul li .sidetop:hover {
	background: #ae1c1c;
	opacity: 1;
	filter: Alpha(opacity = 100);
}

.side ul li img {
	float: left;
}

.side .erwei {
	width: 150px;
	height: 165px;
	position: absolute;
	bottom: 84px;
	right: 45px;
	display: none;
}
</style>
<div class="side">
	<ul>
		<li><div
					class="sidebox">
					<img src="${ctx}/images/side_icon01.png">营销技巧
				</div></a></li>
		<li><a
			href="http://wpa.qq.com/msgrd?v=3&uin=517714860&site=qq&menu=yes"
			rel="nofollow"><div class="sidebox">
					<img src="${ctx}/images/side_icon02.png">QQ咨询
				</div></a></li>
		<li id="eee"><a href="javascript:void(0);" class="sidetop"><img
				src="${ctx}/images/side_icon04.png" id="erwei"></a></li>
		<li style="border:none;"><a href="javascript:goTop();"
			class="sidetop"><img
				src="${ctx}/images/side_icon05.png"></a></li>
	</ul>
	<div class="erwei">
		<img src="/templets/zhsgstyle/images/zonghengewm.jpg" alt="广州智沃-二维码"
			width="150" height="165">
	</div>
	<div class="guestBook">
		<img src="${ctx}/images/55.gif" alt="广州智沃-互动">
	</div>
</div>
