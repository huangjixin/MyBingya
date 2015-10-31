<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>关于我们--上海网聚化工有限公司</title>
<meta name="robots" content="all" />
<meta name="keywords"
	content="医药原料及中间体，无机化工产品，香精香料及植物提取物，食品化工产品，有机化工产品，农资化工产品" />
<meta name="description"
	content="上海网聚化工有限公司和进出口有限公司是以无机化工、有机化工、精细化工、香精香料、食品添加剂、医药原料及中间体等经营、销售为一体的高科技化工企业。" />
<meta name="Identifier-URL" content="http://www.netgather.com" />
<link rel="Shortcut Icon" href="/favicon.ico" type="image/x-icon" />
<link rel="Bookmark" href="/favicon.ico" type="image/x-icon" />
<link href="${ctx}/default/css/reset.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/default/css/webmain.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/default/css/ddsmoothmenu.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="${ctx}/default/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript"
	src="scripts/jquery.KinSlideshow-1.2.1.js"></script>
<script type="text/javascript"
	src="${ctx}/default/scripts/webtry_roll.js"></script>
<script type="text/javascript"
	src="${ctx}/default/scripts/ddsmoothmenu.js"></script>
<script type="text/javascript">
	ddsmoothmenu.init({
		mainmenuid : "MainMenu", //menu DIV id
		orientation : 'h', //Horizontal or vertical menu: Set to "h" or "v"
		classname : 'ddsmoothmenu', //class added to menu's outer DIV
		//customtheme: ["#1c5a80", "#18374a"],
		contentsource : "markup" //"markup" or ["container_id", "path_to_menu_file"]
	})
</script>
</head>
<body>
	<div id="wrapper">
		<div class="top">
			<img src="${ctx}/default/images/logo.gif" width="650" height="90"
				alt="上海网聚化工有限公司" />
			<div id="lang">
				<a
					href="javascript:if(confirm('只有企业版才有多语言功能，请点击确定访问netgather.com咨询。')){location.href='http://www.netgather.com'}"><img
					src="${ctx}/default/default/images/gb.gif" width="16" height="11"
					alt="English" />English</a>
			</div>
		</div>
		<div id="MainMenu" class="ddsmoothmenu">
			<ul>
				<c:forEach var="channel" items="${list}">
					<li><a href="${ctx}/${channel.linkAddr}"
						title="${channel.name}"
						<c:if test="${channel.linkAddr=='/'}">id="menu_selected"</c:if>><span>${channel.name}</span></a>
						<c:if test="${channel.children!= null }">
							<ul class="menulevel">
								<c:forEach var="chan" items="${channel.children}">
									<li><a href="${ctx}/${chan.linkAddr}" title="${chan.name}"><span>${chan.name}</span></a></li>
								</c:forEach>
							</ul>
						</c:if></li>
				</c:forEach>
				<!-- <li><a href="index.html" title="公司主页"><span>公司主页</span></a></li>
				<li><a href="single.html" title="关于我们" id="menu_selected"><span>关于我们</span></a>
				<ul class="menulevel">
						<li><a href="single.html" title="组织构架">组织构架</a></li>
						<li><a href="single.html" title="公司历史">公司历史</a></li>
						<li><a href="single.html" title="联系我们">联系我们</a></li>
					</ul></li>
				<li><a href="products.html" title="产品展示"><span>产品展示</span></a>
				<ul class="menulevel">
						<li><a href="products.html" title="医药原料及中间体">医药原料及中间体</a></li>
						<li><a href="products.html" title="无机化工产品">无机化工产品</a></li>
						<li><a href="products.html" title="香精香料及植物提取物">香精香料及植物提取物</a></li>
						<li><a href="products.html" title="食品化工产品">食品化工产品</a></li>
						<li><a href="products.html" title="有机化工产品">有机化工产品</a></li>
						<li><a href="products.html" title="农资化工产品">农资化工产品</a></li>
					</ul></li>
				<li><a href="news.html" title="新闻中心"><span>新闻中心</span></a></li>
				<li><a href="jobs.html" title="招聘信息"><span>招聘信息</span></a></li>
				<li><a href="guestbook.html" title="留言反馈"><span>留言反馈</span></a></li>
				<li><a href="http://www.netgather.com" target="_blank"
					title="网聚网"><span>网聚网</span></a></li> -->
			</ul>
		</div>
		<script type="text/javascript">
			$(function() {
				$("#banner").KinSlideshow({
					moveStyle : "right",
					titleBar : {
						titleBar_height : 32,
						titleBar_bgColor : "#000",
						titleBar_alpha : 0.7
					},
					titleFont : {
						TitleFont_size : 12,
						TitleFont_color : "#FFFFFF",
						TitleFont_weight : "normal"
					},
					btn : {
						btn_bgColor : "#2d2d2d",
						btn_bgHoverColor : "#1072aa",
						btn_fontColor : "#FFF",
						btn_fontHoverColor : "#FFF",
						btn_borderColor : "#4a4a4a",
						btn_borderHoverColor : "#1188c0",
						btn_borderWidth : 1
					}
				});
			})
		</script>
		<div id="banner">
			<a href="#"><img src="${ctx}/default/images/banner01.jpg"
				alt="多年的经营过程中，不断优化货源渠道，使产品价格更具竞争力！" width="950" height="152" /></a> <a
				href="#"><img src="${ctx}/default/images/banner02.jpg"
				alt="多年的经营过程中，不断优化货源渠道，使产品价格更具竞争力！" width="950" height="152" /></a> <a
				href="#"><img src="${ctx}/default/images/banner03.jpg"
				alt="多年的经营过程中，不断优化货源渠道，使产品价格更具竞争力！" width="950" height="152" /></a>
		</div>
		<div id="page_main" class="clearfix">
			<div class="page-right">
				<div class="site-nav">
					<span>当前位置 : </span><a href="index.html">公司主页</a> &gt;&gt; <a
						href="news.html" title="新闻中心">新闻中心</a>
				</div>
				<div class="page-single">
					<p style="LINE-HEIGHT: 25px">
						<span class="hps" title="点击可显示其他翻译"></span>
						${document.content}
					</p>
				</div>
			</div>
			<div class="page-left">
				<div class="left-search">
					<h2>
						<span>站内搜索</span>
					</h2>
					<form action="" method="post" id="sitesearch" name="sitesearch">
						<p>
							<select name="searchid" id="searchid"><option value="2">产品展示</option>
								<option value="3" selected="selected">新闻中心</option>
								<option value="4">招聘信息</option></select>
						</p>
						<p>
							<input name="searchtext" type="text" id="searchtext" />
						</p>
						<p>
							<input name="searchbutton" type="submit" id="searchbutton"
								value="" />
						</p>
					</form>
				</div>
				<div class="left-contact">
					<h2>
						<span>联系我们</span>
					</h2>
					<p>
						<span>地址: </span>上海市嘉定区华亭镇<br /> <span>邮编: </span>200000<br /> <span>联系人:
						</span>网聚化工<br /> <span>电话: </span>021-58888888<br /> <span>传真:
						</span>021-58888888<br /> <span>手机: </span>13888888888<br /> <span>邮箱:
						</span>netgather@netgather.com
					</p>
				</div>
				<img src="${ctx}/default/images/tel.gif" width="240" height="59" alt="联系我们" />
			</div>
		</div>
		<div id="copyright">
			Copyright ©2004-2011&nbsp;<a href="http://www.netgather.com"
				title="上海网聚化工有限公司">上海网聚化工有限公司www.netgather.com</a> All Rights
			Reserved.<br /> <span>地址: </span>上海市嘉定区华亭镇 <span>邮编: </span>200000 <span>联系人:
			</span>网聚化工<br /> <span>电话: </span>021-58888888 <span>传真: </span>021-58888888
			<span>手机: </span>13888888888<br /> <span>邮箱: </span>netgather@netgather.com
		</div>
	</div>
</body>
</html>