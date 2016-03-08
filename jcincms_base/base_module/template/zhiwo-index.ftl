<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="智沃，智沃科技,jsp,cms,jcincms,java,建站系统,免费,开源,首页">
<meta name="description" content="智沃，智沃科技,jsp,cms,jcincms,java,建站系统,免费,开源,首页">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx}/css/timeswo.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/swiper.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/swiper.js"></script>
<script type="text/javascript">
if(window.location.toString().indexOf('pref=padindex') != -1){
}else{
	if(/AppleWebKit.*Mobile/i.test(navigator.userAgent) || (/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/.test(navigator.userAgent))){  
      if(window.location.href.indexOf("?mobile")<0){
		try{
			if(/Android|Windows Phone|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)){
				window.location.href="${ctx}/m-index.html";
			}/*else if(/iPad/i.test(navigator.userAgent)){
              	window.location.href="http://www.qq.com/pad/"
			}else{
				window.location.href="http://xw.qq.com/simple/s/index/"
			}*/
		}catch(e){}
	}
	}
}
</script>
<title>智沃首页</title>
</head>
<body>
	<div id="container">
		<div class="globalWidth">
			<div class="contentWidth" id="header">
				<!-- 头部 -->
				<#include "zhiwo-header.ftl" > 
			</div>
		</div>
		<div class="globalWidth" id="navigation"
			style="background-image: url('${ctx}/images/navigationBg.png');">
			<div class="contentWidth">
				<!-- 菜单 -->
				<#include "zhiwo-menu.ftl" > 
			</div>
		</div>
		<div class="globalWidth" style="position:relative;width: 100%;">
			<!-- 图片展示 -->
			<#include "zhiwo-index-swiper.ftl" > 
			<div class="devider"></div>
			<div class="globalWidth">
				<div class="contentWidth" style="text-align: center;">
					<div class="property">
						<div
							style="text-align: left;padding-left: 10px;padding-right: 10px;">
							<div>
								<h3>基于Java</h3>
							</div>
							<hr class="hr">
							<div>
								<img src="${ctx}/images/java.gif" style="float:right;">
								跨平台支持Windows，Linux，Unix等操作系统；支持MySQL数据库；企业级、高性能、分布式、健壮的java
								cms,jsp cms；采用强大的Spring技术。
							</div>
						</div>
					</div>
					<div class="property">
						<div
							style="text-align: left;padding-left: 10px;padding-right: 10px;">
							<div>
								<h3>全站静态化</h3>
							</div>
							<hr class="hr">
							<div>
								<img src="${ctx}/images/jingtaihua.gif" style="float:right;">
								灵活的静态页路径设置；直接使用模板高速生成静态页；支持列表页前N页静态化，减小静态页生成压力；发布信息时自动生成静态页。
							</div>
						</div>
					</div>
					<div class="property">
						<div
							style="text-align: left;padding-left: 10px;padding-right: 10px;">
							<div>
								<h3>自定义模型</h3>
							</div>
							<hr class="hr">
							<div>
								<img src="${ctx}/images/zidingyi.gif" style="float:right;">
								通过模型增加删除字段，调整后台功能；支持新闻、图片、视频、作品、下载、产品等模型；支持可查询字段，构建复杂模型，无限级添加栏目。
							</div>
						</div>
					</div>
					<div class="property" style="width: 592px;">
						<div
							style="text-align: left;padding-left: 10px;padding-right: 10px;">
							<div>
								<h3>服务</h3>
							</div>
							<hr class="hr">
							<div>
								<img src="${ctx}/images/gongnengdingzhi.gif" style="float:right;">
								根据网站的类型、需求，策划网站的栏目、内容，设计网站风格、布局、色彩，并将效果图制作成动态的网站模板；客户有额外的需求，或系统原有功能无法满足特定要求的，可以联系我们在对系统进行功能定制。
							</div>
						</div>
					</div>
					<div class="property">
						<div
							style="text-align: left;padding-left: 10px;padding-right: 10px;">
							<div>
								<h3>支持移动端</h3>
							</div>
							<hr class="hr">
							<div>
								<img src="${ctx}/images/wangzhanjianshe.gif" style="float:right;">
								优化页面，支持对移动端友好浏览，适配各种手机浏览器。
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<!-- 底部 -->
			<#include "zhiwo-footer.ftl" > 
		</div>
</body>
</html>
