<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${channel.name}--上海网聚化工有限公司</title>
<meta name="robots" content="all" />
<meta name="keywords"
	content="医药原料及中间体，无机化工产品，香精香料及植物提取物，食品化工产品，有机化工产品，农资化工产品" />
<meta name="description"
	content="上海网聚化工有限公司和进出口有限公司是以无机化工、有机化工、精细化工、香精香料、食品添加剂、医药原料及中间体等经营、销售为一体的高科技化工企业。" />
<meta name="Identifier-URL" content="http://www.netgather.com" />
<link rel="Shortcut Icon" href="/favicon.ico" type="image/x-icon" />
<link rel="Bookmark" href="/favicon.ico" type="image/x-icon" />
<link href="${ctx}/defaultApp/css/reset.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/defaultApp/css/webmain.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/defaultApp/css/ddsmoothmenu.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/defaultApp/scripts/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${ctx}/defaultApp/scripts/jquery.KinSlideshow-1.2.1.js"></script>
<script type="text/javascript" src="${ctx}/defaultApp/scripts/webtry_roll.js"></script>
<script type="text/javascript" src="${ctx}/defaultApp/scripts/ddsmoothmenu.js"></script>
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
			<img src="${ctx}/defaultApp/images/logo.gif" width="650" height="90"
				alt="上海网聚化工有限公司" />
		</div>
		<%@include file="menu.jsp" %>
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
			<a href="#"><img src="${ctx}/defaultApp/images/banner01.jpg"
				alt="多年的经营过程中，不断优化货源渠道，使产品价格更具竞争力！" width="950" height="152" /></a> <a
				href="#"><img src="${ctx}/defaultApp/images/banner02.jpg"
				alt="多年的经营过程中，不断优化货源渠道，使产品价格更具竞争力！" width="950" height="152" /></a> <a
				href="#"><img src="${ctx}/defaultApp/images/banner03.jpg"
				alt="多年的经营过程中，不断优化货源渠道，使产品价格更具竞争力！" width="950" height="152" /></a>
		</div>
		<div id="page_main" class="clearfix">
			<div class="page-right">
				<div class="site-nav">
					<span>当前位置 : </span><a href="${ctx}">公司主页</a> &gt;&gt; <a
						href="${ctx}/channel/products" title="产品展示">产品展示</a>
				</div>
				<div class="page-products">
					<ul class="clearfix">
						<c:forEach var="doc" items="${page.rows}">
							<tr>
								<td class="time-list"><span>2015.10.27</span></td>
								<td style="text-align: center;"><a
									href="${ctx}/${channel.linkAddr}/doc/${doc.id}" target="blank"
									title="${doc.title}">${doc.title}</a></td>
							</tr>
						</c:forEach>
						

						<li><a href="products.html" title="氯霉素"><img
								src="${ctx}/defaultApp/uploadfile/20110611023092419241.jpg" width="210"
								height="150" alt="氯霉素" /><span>氯霉素</span></a></li>

						<li><a href="products.html" title="利巴韦林(病毒唑）"><img
								src="${ctx}/defaultApp/uploadfile/20110611022328652865.jpg" width="210"
								height="150" alt="利巴韦林(病毒唑）" /><span>利巴韦林(病毒唑）</span></a></li>

						<li><a href="products.html" title="土霉素"><img
								src="${ctx}/defaultApp/uploadfile/20110611021745864586.jpg" width="210"
								height="150" alt="土霉素" /><span>土霉素</span></a></li>

						<li><a href="products.html" title="盐酸特比奈芬"><img
								src="${ctx}/defaultApp/uploadfile/20110611014993929392.jpg" width="210"
								height="150" alt="盐酸特比奈芬" /><span>盐酸特比奈芬</span></a></li>

						<li><a href="products.html" title="氯化钾"><img
								src="${ctx}/defaultApp/uploadfile/20110611032733583358.jpg" width="210"
								height="150" alt="氯化钾" /><span>氯化钾</span></a></li>

						<li><a href="products.html" title="磷酸二氢钾"><img
								src="${ctx}/defaultApp/uploadfile/20110611032516391639.jpg" width="210"
								height="150" alt="磷酸二氢钾" /><span>磷酸二氢钾</span></a></li>

						<li><a href="products.html" title="微晶纤维素"><img
								src="${ctx}/defaultApp/uploadfile/20110611032067186718.jpg" width="210"
								height="150" alt="微晶纤维素" /><span>微晶纤维素</span></a></li>

						<li><a href="products.html" title="氢化铝锂"><img
								src="${ctx}/defaultApp/uploadfile/2011061103180984984.jpg" width="210"
								height="150" alt="氢化铝锂" /><span>氢化铝锂</span></a></li>

						<li><a href="products.html" title="淀粉酶"><img
								src="${ctx}/defaultApp/uploadfile/2011061103170236236.jpg" width="210"
								height="150" alt="淀粉酶" /><span>淀粉酶</span></a></li>

						<li><a href="products.html" title="抗氧剂BHT"><img
								src="${ctx}/defaultApp/uploadfile/20110611031576567656.jpg" width="210"
								height="150" alt="抗氧剂BHT" /><span>抗氧剂BHT</span></a></li>

						<li><a href="products.html" title="香兰素"><img
								src="${ctx}/defaultApp/uploadfile/20110611031134093409.jpg" width="210"
								height="150" alt="香兰素" /><span>香兰素</span></a></li>

						<li><a href="products.html" title="丁香罗勒油"><img
								src="${ctx}/defaultApp/uploadfile/20110611031086798679.jpg" width="210"
								height="150" alt="丁香罗勒油" /><span>丁香罗勒油</span></a></li>

						<li><a href="products.html" title="聚乙烯醇"><img
								src="${ctx}/defaultApp/uploadfile/20110611030589108910.jpg" width="210"
								height="150" alt="聚乙烯醇" /><span>聚乙烯醇</span></a></li>

						<li><a href="products.html" title="次磷酸"><img
								src="${ctx}/defaultApp/uploadfile/20110611025642914291.jpg" width="210"
								height="150" alt="次磷酸" /><span>次磷酸</span></a></li>
					</ul>
					<div class="page_list">
						<div class="list_info">
							共${page.total}个/${page.totalPage+1}页
							<c:if test="${page.page>1}">
								<span
									onclick="javascript:window.location.href='${ctx}/channel/news?page=1'">&nbsp;&lt;&lt;&nbsp;</span>
							</c:if>
							<c:if test="${page.page>1}">
								<span onclick="javascript:window.location.href='${ctx}/channel/news?page=${page.page-1}'">&nbsp;&lt;&nbsp;</span>
							</c:if>
							<span class="current">${page.page}</span>
							<c:if test="${page.page < page.totalPage+1}">
								<span onclick="javascript:window.location.href='${ctx}/channel/news?page=${page.page+1}'">&nbsp;&gt;&nbsp;</span>
							</c:if>
							<c:if test="${page.page < page.totalPage+1}">
								<span onclick="javascript:window.location.href='${ctx}/channel/news?page=${page.totalPage+1}'">&nbsp;&gt;&gt;&nbsp;</span>
							</c:if>
						</div>
					</div>
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
				<%@include file="contact.jsp" %>
			</div>
		</div>
		<%@include file="footer.jsp" %>
	</div>
</body>
</html>