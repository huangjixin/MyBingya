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

	function setUlCss(id) {
		$('#' + id).toggle();
	}
</script>
<title>${channel.name}</title>
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
			<!-- 导航 -->
			<#include "zhiwo-nav.ftl" > 
		</div>
		<div class="devider"></div>
		<div class="globalWidth">
			<div class="contentWidth" style="text-align: center;">
				<div style="width:750px;float: left;">
					<div class="doc">
						<div style="width: 100%;text-align: center;">
							<span style="font-weight: bold;font-size: 16px;"><#if document.title??>${document.title}</#if></span>
						</div>
						<hr class="hr" style="width: 95%;" />
						<div class="content"><p><#if document.content??>${document.content}</#if></p></div>
						<div class="spacer"></div>
						<#if lastdoc ??>
							<div style="width: 100%;font-size: 12px;">
								<span>上一篇：</span><a style="text-decoration: none;color: #0;"
									href="${ctx}/${channel.linkAddr}/doc/${lastdoc.id}">${lastdoc.title}</a>
							</div>
						</#if>
						<#if nextdoc ??>
							<div style="width: 100%;font-size: 12px;">
								<span>下一篇：</span><a style="text-decoration: none;color: #0;"
									href="${ctx}/${channel.linkAddr}/doc/${nextdoc.id}">${nextdoc.title}</a>
							</div>
						</#if>
					</div>
				</div>
				<div id="rightside" style="width:200px;float: right;">
					<div class="panel">
						<#list navChan as nchan>
							<#if nchan_index==0>
								<div class="panel-header">
									<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${nchan.name}</span>
								</div>
								<ul
									style="list-style-image: url('${ctx}/images/left_sider_menu_arow.png');">
									<li><a href="${ctx}/${channel.linkAddr}">智沃新闻</a></li>
								</ul>
							</#if>
						</#list>
					</div>
					<div style="height: 10px;"></div>
					<div class="panel">
						<div class="panel-header">
							<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系我们</span>
						</div>
						<#include "zhiwo-contact.ftl" >
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
