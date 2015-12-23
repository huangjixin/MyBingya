<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="${channel.name},${channel.keyword},jsp,cms,jcincms,java,建站系统,免费,开源">
<meta name="description" content="${channel.name},${channel.keyword},jsp,cms,jcincms,java,建站系统,免费,开源">
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
				window.location.href="${ctx}/${channel.linkAddr}/docs/${channel.code}${i}m.html";
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
				<#if page ??>
					<#list page.rows as doc>
							<div class="spacer"></div>
							<div class="article">
								<div class="info">
									<span style="font-weight: bold;font-size: 14px;"><a
										href="${ctx}/${channel.linkAddr}/doc/${doc.id}" target="blank">${doc.title}</a></span>&nbsp;&nbsp;
									<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
									<p>文章摘要：<#if doc.contentShort ??>${doc.contentShort}</#if></p>
									<div style="font-size: 12px;">
										<#setting date_format="yyyy.MM.dd">
										${doc.author}&nbsp;&nbsp;&nbsp;&nbsp;<span
											style="font-size: 12px;"><#if doc.createDate ??>${doc.createDate?date}</#if></span>
									</div>
								</div>
							</div>
					</#list>
				</#if>
				<#if page ??>
					<div class="spacer"></div>
					<div style="width:auto;padding: 5px 0px 5px 5px;font-size: 12px;">
							<a href="${ctx}/${channel.linkAddr}?page=1"><span>首页</span></a>&nbsp;&nbsp;
							<#if (page.page>1)>
								<a href="${ctx}/${channel.linkAddr}?page=${page.page-1}"><span>上一页</span></a>&nbsp;&nbsp;</#if>
							<span>${page.page}</span>&nbsp;&nbsp;
							<#if (page.page < page.totalPage+1)>
								<a href="${ctx}/${channel.linkAddr}?page=${page.page+1}"><span>下一页</span></a>&nbsp;&nbsp;</#if>
							<#if (page.page < page.totalPage+1)>
								<a href="${ctx}/${channel.linkAddr}?page=${page.totalPage+1}"><span>末页</span></a>&nbsp;&nbsp;</#if>
							&nbsp;&nbsp;<span>共${page.totalPage+1}页 ${page.total}条</span>
					 </div>
				</#if>
			</div>		
		</div>
		<!-- 右边导航 -->
		<div id="left_side">
			<div class="box" style="width: 250px;">
				<div class="box-header">点击率排行榜</div>
				<!-- <div><hr style="width:100%;height:1px;border:none;border-top:1px solid #0088DD;" /></div> -->
				<div class="box-center">
					<ul style="list-style:none;">
						<#if clickCountDocs ??>
							<#list clickCountDocs as doc>
								<li><a href="${ctx}/${doc.channel.linkAddr}/doc/${doc.id}"
														target="blank">${doc.title}</a></li>
							</#list>
						</#if>
					</ul>
				</div>
			</div>
			<div class="spacer"></div>
			<div class="box" style="width: 250px;">
				<div class="box-header">分类目录</div>
				<!-- <div><hr style="width:100%;height:1px;border:none;border-top:1px solid #0088DD;" /></div> -->
				<div class="box-center" style="font-size: 14px;">
					<div class="category">elasticsearch</div>
					<div class="category">hadoop</div>
					<div class="category">Java</div>
					<div class="category">linux</div>
					<div class="category">lucene</div>
					<div class="category">memcached</div>
					<div class="category">mongodb</div>
					<div class="category">mysql</div>
					<div class="category">Oracle</div>
					<div class="category">redis</div>
					<div class="category">中文分词</div>
					<div class="category">产品</div>
					<div class="category">分布式系统</div>
					<div class="category">微博架构</div>
					<div class="category">推荐系统</div>
					<div class="category">操作系统</div>
				</div>
				<div style="height: 12px;"></div>
			</div>
		</div>
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
