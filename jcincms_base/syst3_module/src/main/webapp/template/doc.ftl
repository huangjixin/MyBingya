<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="${document.title},${document.keyword}">
<meta name="description" content="${document.title},${document.keyword}">
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
				window.location.href="${ctx}/${channel.linkAddr}/docs/${document.id}m.html";
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
<title><#if document.title ??>${document.title}</#if></title>
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
					<li><a href="${ctx}/">首页</a></li>
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
				<div class="article">
					<#setting date_format="yyyy.MM.dd">
					<#if document ??>
						<div class="info">
						<div style="width: 100%;text-align: center;">
							<span style="font-weight: bold;font-size: 16px;">${document.title}</span>
						</div>
						<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
						<div style="width: 100%;text-align: center;font-size: 12px;">
							${document.author}&nbsp;&nbsp;&nbsp;&nbsp;<span><#if document.createDate ??>${document.createDate?date}</#if></span>
							&nbsp;&nbsp;阅读:
							<span id="hits"><script type="text/javascript">
								$("#hits").load('${ctx}/channel/getClickCount?id=${document.id}');
							</script></span>
						</div>
						<p>${document.content}</p>
					</div>
					</#if>
				</div>
				<div class="spacer"></div>
				<#if lastdoc ??>
					<div style="font-size: 12px;">
						<span>上一篇：</span><a href="${ctx}/${channel.linkAddr}/doc/${lastdoc.id}">${lastdoc.title}</a>
					</div>
				</#if>
				<#if nextdoc ??>
					<div style="font-size: 12px;">
						<span>下一篇：</span><a href="${ctx}/${channel.linkAddr}/doc/${nextdoc.id}">${nextdoc.title}</a>
					</div>
				</#if>
			</div>		
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
