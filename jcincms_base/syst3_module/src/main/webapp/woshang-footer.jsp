<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div id="footer" class="globalWidth"
	style="background-image: url('${ctx}/images/footer-bg.png');background-repeat: repeat;">
	<div
		style="text-align: center;height: 50px;line-height: 50px;font-size: 16px;color: #A7A7A7;">
		<span>加入我们 </span>|<span> 联系我们 </span>|<span> 智沃作品</span>
	</div>
	<div class="contentWidth">
		<div>
			<hr style="height:1px;border:none;border-top:1px dashed gray;" />
		</div>

		<div style="padding: 15px 0;">
			<div style="float: left;margin-left:10px; ">
				<div
					style="margin:0 auto;width:20px;line-height:24px;color: #CA2B2F;">关注我们</div>
			</div>
			<div style="float: left;margin-left:10px; ">
				<img alt="智沃手机网站" src="${ctx}/images/m-erweima.png">
			</div>
			<div style="float: left;margin-left:20px; ">
				<img alt="智沃微网站" src="${ctx}/images/w-erweima.png">
			</div>
			<div style="float: left;margin-left:50px;height: 50px;">
				<div>
					电话：<span style="color:#CA2B2F;">139 2620 5227</span>
				</div>
				<div>
					邮箱：<span style="color:#CA2B2F;">625152644@qq.com</span>
				</div>
				<div>
					地址：<span style="color:#CA2B2F;">广州市天河区科技园1幢1单元17楼1701号</span>
				</div>
			</div>
			<div
				style="float: left;margin-left:10px;color: #626262;height: 50px;line-height: 50px;">
				<div>QQ群：40497044</div>
			</div>
		</div>
		<div style="clear: both;height: 20px;"></div>
		<div>
			<hr style="height:1px;border:none;border-top:1px solid gray;" />
		</div>
	</div>
	<div
		style="text-align: center;height: 100px;line-height: 100px;font-size: 24px;color: #A7A7A7;">
		<span>广州专业的互动策划、营销网站设计、移动网站、微网站开发公司</span>
	</div>
</div>
<div class="globalWidth"
	style="background: -moz-linear-gradient(top, #141414, #141414);background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#141414),
		to(#141414) );">
	<div class="contentWidth"
		style="text-align: center;height: 40px;line-height: 40px;">
		<span style="font-size: 14px;color: #ffffff">Copyright
			2015-2016 广州智沃信息技术 All rights reserved</span>
	</div>
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