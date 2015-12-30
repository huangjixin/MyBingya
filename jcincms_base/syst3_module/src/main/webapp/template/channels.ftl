<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="${channel.name},${channel.keyword},jsp,cms,jcincms,java,建站系统,免费,开源">
<meta name="description" content="${channel.name},${channel.keyword},jsp,cms,jcincms,java,建站系统,免费,开源">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx}/css/demo.css">
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
				window.location.href="${ctx}/${channel.linkAddr}/docs/${channel.code}1m.html";
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
<title>${channel.name}</title>
</head>
<body>
	<div id="container">
		<div id="header">
			<div id="logo">
				<img alt="logo" src="${ctx}/images/logo.gif" />
			</div>
			<div id="headerContact">
				<span>2015年11月26日 星期四</span>
			</div>
		</div>
		<!-- 导航菜单 -->
		<#include "template/menu.ftl" >
		<div class="spacer"></div>
		<div id="main">
			<div id="content">
				<div class="position">
					<div style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px;">
					<span>当前位置: <a href="${ctx}/">首页</a> 
						<#list navChan as chan>
							><a href="${ctx}/${chan.linkAddr}">${chan.name}</a>
						</#list>
					</span>
					</div>
				</div>
				<div class="spacer"></div>
				<div id="picnav">
					<a class="arrow-left" href="#"></a> <a class="arrow-right" href="#"></a>
					<div class="swiper-container swiper-container-fade">
						<div class="swiper-wrapper">
							<div class="swiper-slide">
								<img src="${ctx}/images/79084479.jpg" width="400" height="200"
									border="0" />
							</div>
							<div class="swiper-slide">
								<img src="${ctx}/images/79064170.jpg" width="400" height="200"
									border="0" />
							</div>
							<div class="swiper-slide">
								<img src="${ctx}/images/79084750.jpg" width="400" height="200"
									border="0" />
							</div>
							<div class="swiper-slide">
								<img src="${ctx}/images/79085270.jpg" width="400" height="200"
									border="0" />
							</div>
						</div>
						<div class="swiper-pagination swiper-pagination-white"></div>
						<div class="swiper-button-next swiper-button-white"></div>
						<div class="swiper-button-prev swiper-button-white"></div>
					</div>
				</div>
				<div id="recommend">
					<div class="box-header">栏目推荐</div>
					<div class="box-center">
						<ul>
							<#if recommendDocs ??>
								<#list recommendDocs as doc>
									<#if doc.title ??>
										<#if doc.channel ??>
											<li><a href="${ctx}/${doc.channel.linkAddr}/doc/${doc.id}">${doc.title}</a></li>
											<#else>
											<li><a href="${ctx}/channel/recommend/doc/${doc.id}">${doc.title}</a></li>
										</#if>
									</#if>
								</#list>
							</#if>
						</ul>
					</div>
				</div>
				<div class="spacer"></div>
				<div class="box" style="float: left;width: 100%;min-height: 140px;">
					<div class="box-header" style="width: 25%;">图文资讯</div>
					<div class="box-center" style="text-align: center;padding-top: 5px;">
						<div class="swiper-container swiper-container-scroll" style="height:125px;">
							<div class="swiper-wrapper">
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-1.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-2.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-3.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-4.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-1.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-2.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-3.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-4.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-2.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-3.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-1.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
								<div class="swiper-slide">
									<img src="${ctx}/images/slide-4.jpg" alt="覆盆子酮" width="140"
										height="100" />
								</div>
							</div>
							<!-- Add Pagination -->
							<div class="swiper-pagination swiper-pagination-pictrueScroll"></div>
						</div>
					</div>
				</div>
				<div class="spacer"></div>
				<#if subChannels ??>
					<#list subChannels as channel>
						<#if channel.name ??>
							<#if channel_index%2==0>
								<div class="box" style="float: left;">
							</#if>
							<#if channel_index%2==1>
								<div class="box" style="float: right;">
							</#if>
							<div class="box-header">
								<a href="${ctx}/${channel.linkAddr}" style="color: #ffffff;">${channel.name}</a>
							</div>
							<div class="box-center">
								<ul>
									<#if menusMap?exists>
									<#list menusMap?keys as rootKey>
										<#if rootKey==channel.code>
											<#list menusMap[rootKey] as doc>
												<#setting date_format="yyyy.MM.dd">
												<li><a href="${ctx}/${channel.linkAddr}/doc/${doc.id}"
												target="blank">${doc.title}<span><#if doc.createDate ??>${doc.createDate?date}</#if></span></a></li>
												<hr style="height:1px;border:none;border-top:1px dashed #CCCCCC;"/>
											</#list>
										</#if>
										
									</#list>
									</#if>
									
								</ul>
							</div>
						</div>
						<#if channel_index%2==1>
							<div class="spacer"></div>
						</#if>
					</#if>
				</#list>
			</#if>
		</div>
		<!-- 右边导航 -->
		<#include "template/right_side.ftl" >
	</div>
		<div class="spacer"></div>
		<#include "template/footer.ftl" > 
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
		var swiper1 = new Swiper('.swiper-container-scroll', {
			pagination : '.swiper-pagination-pictrueScroll',
			loop : true,
			autoplay : 2500,
			autoplayDisableOnInteraction : true,
			slidesPerView : 4,
			paginationClickable : true,
			spaceBetween : 30,
			grabCursor: true
			
		});
	</script>	
</body>
</html>
