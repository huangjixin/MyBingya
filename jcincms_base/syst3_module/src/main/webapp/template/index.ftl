<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="jsp,cms,jcincms,java,建站系统,免费,开源,首页">
<meta name="description" content="jsp,cms,jcincms,java,建站系统,免费,开源,首页">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx}/css/demo.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/slider.js"></script>
<script type="text/javascript" src="${ctx}/js/webtry_roll.js"></script>
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
<title>首页</title>
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
		<div class="menu">
			<div
				style="height:40px;z-index:3;background:#212121;margin-left:20px; top:0; left:0; display:block;">
				<ul>
					<li><a href="${ctx}">首页</a></li>
					<#list menus as menu>
						<li><a href="${ctx}/${menu.linkAddr}">${menu.name}</a>
							<#if menu.children ??>
								<ul>
									<#list menu.children as menu>
											<li><a href="${ctx}/${menu.linkAddr}">${menu.name}</a>
												<#if menu.children ??>
													<ul>
														<#list menu.children as menu>
															<li><a href="${ctx}/${menu.linkAddr}">${menu.name}</a>
															<#if menu.children ??>
																<ul>
																	<#list menu.children as menu>
																		<li><a href="${ctx}/${menu.linkAddr}">${menu.name}</a>
																		<#if menu.children ??>
																			<ul>
																				<#list menu.children as menu>
																					<li><a href="${ctx}/${menu.linkAddr}">${menu.name}</a>
																					<#if menu.children ??>
																						<ul>
														
																						</ul>
																					</#if>
																					</li>
																				</#list>
																			</ul>
																		</#if>
																		</li>
																	</#list>
																</ul>
															</#if>
															</li>
														</#list>
													</ul>
												</#if>
											</li>
									</#list>	
								</ul>
							</#if>
						</li>
					</#list>
				</ul>
			</div>
		</div>
		<div class="spacer"></div>
		<div id="main">
			<div id="content">
				<div id="picnav">
					<div class="focus">
						<div id="sliderA" class="sliderwrapper">
							<div class="contentdiv">
								<div class="slPic">
									<a href="#" target="_blank"><img src="${ctx}/images/79064170.jpg"
										alt="" width="400" height="194" border="0" /></a><a href="#"
										target="_blank"></a>
								</div>
								<span></span>
							</div>
							<div class="contentdiv">
								<div class="slPic">
									<a href="#" target="_blank"><img src="${ctx}/images/79084479.jpg"
										alt="" width="400" height="194" border="0" /></a><a href="#"
										target="_blank"></a>
								</div>
								<span></span>
							</div>
						</div>
						<div id="paginate-sliderA" class="pagination">
							<i class="toc"></i><i class="toc"></i><i class="toc"></i><i
								class="toc"></i>
						</div>
					</div>
				</div>
				<div id="recommend">
					<div class="box-header">热点推荐</div>
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
					<div class="box-center" style="text-align: center;">
						<ul id="ScrollBox">
							<li><a href="products.html" title="覆盆子酮"><img
									src="${ctx}/images/slide-1.jpg" alt="覆盆子酮" width="140"
									height="100" /><span>覆盆子酮</span></a></li>
							<li><a href="products.html" title="氯霉素"><img
									src="${ctx}/images/slide-2.jpg" alt="氯霉素" width="140"
									height="100" /><span>氯霉素</span></a></li>
							<li><a href="products.html" title="利巴韦林(病毒唑）"><img
									src="${ctx}/images/slide-3.jpg" alt="利巴韦林(病毒唑）" width="140"
									height="100" /><span>利巴韦林(病毒唑）</span></a></li>
							<li><a href="products.html" title="土霉素"><img
									src="${ctx}/images/slide-4.jpg" alt="土霉素" width="140"
									height="100" /><span>土霉素</span></a></li>
						</ul>
						<script language="javascript" type="text/javascript">
						<!--//--><![CDATA[//><!--
							var scrollPic_01 = new ScrollPic();
							scrollPic_01.scrollContId = "ScrollBox"; //内容容器ID
							scrollPic_01.arrLeftId = "LeftArr1";//左箭头ID
							scrollPic_01.arrRightId = "RightArr1"; //右箭头ID
							scrollPic_01.frameWidth = 648;//显示框宽度
							scrollPic_01.pageWidth = 162; //翻页宽度
							scrollPic_01.speed = 10; //移动速度(单位毫秒，越小越快)
							scrollPic_01.space = 5; //每次移动像素(单位px，越大越快)
							scrollPic_01.autoPlay = true; //自动播放
							scrollPic_01.autoPlayTime = 3; //自动播放间隔时间(秒)
							scrollPic_01.initialize(); //初始化
							//--><!]]>
						</script>
					</div>
				</div>
				<div>
					<!-- <div id="LeftArr1"></div>
					<div id="RightArr1"></div> -->

				</div>
				<div class="spacer"></div>
				<#list menus as channel>
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
		</div>
		<!-- 右边导航 -->
		
	</div>
		<div class="spacer"></div>
		<div id="footer">Copyright © 2011-2015 jcincms内容管理系统. Powered by chepoo.com.京ICP备11014024号 .
		</div>
	<script type="text/javascript">
		featuredcontentslider.init({
			id : "sliderA",
			contentsource : [ "inline", "" ],
			toc : "#increment",
			nextprev : [ "", "" ],
			revealtype : "mouseover",
			enablefade : [ true, 0.15 ],
			autorotate : [ true, 3500 ],
			delay : 150,
			onChange : function(previndex, curindex) {
			}
		});
	</script>	
</body>
</html>
