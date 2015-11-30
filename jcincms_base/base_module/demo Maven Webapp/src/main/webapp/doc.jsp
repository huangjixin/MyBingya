<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/css/demo.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
</head>
<body>
	<div id="container">
		<div id="header">
			<div id="logo">
				<img alt="logo" src="${ctx }/images/logo.gif" />
			</div>
			<div id="headerContact">
				<span>2015年11月26日 星期四</span>
			</div>
		</div>
		<div class="spacer"></div>
		<!-- 导航菜单 -->
		<jsp:include page="menu.jsp" flush="true"></jsp:include>
		<div class="spacer"></div>
		<div id="main">
			<div id="content">
				<div class="position">
					<div style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px;"><span>当前位置:  首页  > java</span></div>
				</div>
				<div class="spacer"></div>
				<div class="article">
					<div class="info">
						<div style="width: 100%;text-align: center;">
							<span style="font-weight: bold;font-size: 14px;">${document.title}</span>
						</div>
						<hr>
						<p>${document.content}</p>
					</div>
				</div>
			</div>
			<div id="left_side">
				<div class="box" style="width: 250px;">
					<div class="box-header">热点专题</div>
					<!-- <div><hr style="width:100%;height:1px;border:none;border-top:1px solid #0088DD;" /></div> -->
					<div class="box-center">
						<ul>
							<li>elasticsearch ik分词插件es-ik发布</li>
							<li>solr4的solr-ik插件</li>
							<li>当前几个主要的Lucene中文分词器的比较</li>
							<li>elasticsearch查询优化案例</li>
							<li>JMeter压力测试及并发量计算-2</li>
							<li>solr4的solr-ik插件</li>
							<li>elasticsearch查询优化案例</li>
							<li>JMeter压力测试及并发量计算-2</li>
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
		<div class="clear"></div>
		<!-- 网页底部 -->
	<jsp:include page="footer.jsp" flush="true"></jsp:include>
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
