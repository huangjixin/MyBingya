<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<html>
<head>
<style type="text/css">
body {
	
}

#container {
	width: 960px;
	margin: 0 auto;
}

#header {
	width: 100%;
}

#headerContact {
	position: absolute;
	right: 200px;
	top: 0px;
}

#nav {
	width: 100%;
}

#main {
	width: 100%;
}

#content {
	float: left;
	width: 690px;
}

#picnav {
	float: left;
	width: 404px;
	height: 200px;
	border-radius: 5px 5px 5px 5px;
	border-style: solid;
	border-width: 1px;
	border-color: #CCCCCC;
}

#recommend {
	float: right;
	width: 275px;
	height: 200px;
	border-radius: 5px 5px 5px 5px;
	border-style: solid;
	border-width: 1px;
	border-color: #CCCCCC;
	text-decoration: none;
}

#recommend a,a:LINK,a:VISITED {
	color: #0088DD;
	text-decoration: none;
}

#recommend a:HOVER {
	text-decoration: underline;
}

#left_side {
	float: right;
	/* 	width: 250px; */
	/* 	height: 100px; */
	/* 	background-color: #0dffee */
}

#footer {
	width: 100%;
	height: 50px;
	line-height: 50px;
	text-align: center;
	font-size: 12px;
}

#menu ul {
	list-style: none;
	margin: 0px;
}

#menu ul li {
	float: left;
}

.spacer {
	clear: both;
	width: 100%;
	height: 5px;
}

.box {
	width: 340px;
	/* height: 250px; */ 
	min-height:230px;
	overflow: hidden;
	border-radius: 5px 5px 5px 5px;
	border-style: solid;
	border-width: 1px;
	border-color: #CCCCCC;
	border-width: 1px;
	font-size: 12px;
	overflow: hidden;
}

.box a {
	text-decoration: none;
}

.box-header {
	margin: 0 auto;
	width: 50%;
	height: 25px;
	text-align: center;
	vertical-align: middle;
	color: white;
	background-color: #C01E22;
	line-height: 25px;
	font-size: 14px;
}

.box-center {
	color: #0088DD;
	font-size: 14px;
	width: 100%;
	/* 	height: 100%; */
	overflow: auto;
	font-size: 12px;
}

.box-center ul {
	position: relative;
	left: -12px;
	top: -5px;
}

.box-center .category {
	float: left;
	width: 100px;
	margin-left: 20px;
	margin-top: 10px;
	text-align: center;
}

.box-center li {
	margin-top: 5px;
	list-style-type: square;
}

.box .center li {
	list-style-type: none;
}

.clear {
	clear: both;
}

/*************** 幻灯片开始***********************/
.focus {
	width: 400px;
	height: 194px;
	padding: 2px;
	border: 1px solid #E1E1E1;
	background: #fff;
	position: relative
}

.focus .sliderwrapper span {
	display: block;
	width: 400px;
	height: 32px;
	background: #000;
	filter: alpha(opacity =                       70);
	-moz-opacity: 0.7;
	opacity: 0.7;
	position: absolute;
	left: 2px;
	top: 160px
}

.focus .pagination {
	position: absolute;
	top: 170px;
	right: 0
}

.focus .pagination a {
	width: 19px;
	height: 19px;
	line-height: 19px;
	display: inline;
	float: left;
	margin-right: 7px;
	cursor: pointer;
	background: #fff;
	text-align: center
}

.focus .pagination a:hover,.focus .pagination a.selected {
	background: #FB7E39;
	color: #fff
}

.focus a {
	color: #444;
	text-decoration: none;
	outline: none
}

.focus a:hover {
	color: #c00;
	text-decoration: underline
}
/************** 幻灯片结束***********************/
/* a {
	text-decoration: none;
} */

/* a:link {
	color: #333;
}

a:visited {
	text-decoration: none;
	color: #333;
	font-size: 12px;
}

a:hover {
	color: #666;
}

a:focus {
	outline: none;
} */
.hnav {
	height: 40px;
	float: left;
	margin-left: 10px;
	display: block;
}

.hnav li {
	height: 40px;
	float: left;
	display: block;
	position: relative;
}

.hnav li a {
	color: #fff;
	display: block;
	font-size: 14px;
	line-height: 42px;
	padding: 0 10px;
	font-family: "微软雅黑";
	margin-right: 1px;
	text-decoration: none;
}

.hnav li a:hover {
	color: #FFF;
}

.hnav li:hover a,.hnav li.hover a {
	background: #62b00e;
}

.hnav li ul {
	display: block;
	padding: 0px 0 10px 0;
	position: absolute;
	z-index: 9999;
	display: none;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1)
}

.hnav li ul li {
	width: 100%;
	height: 10px;
	display: block;
	clear: both;
}

.hnav li ul li a {
	width: 100%;
	height: 50px;
	line-height: 100px;
	display: block;
	clear: both;
	padding: 0 100px;
}

.hnav li ul li a:hover {
	background: #454648;
}

.position {
	overflow: hidden;
	width: 100%;
	border-style: solid;
	border-width: 1px;
	border-color: #CCCCCC;
	/* 	padding: 5px; */
	/* 	padding-right: 0px; */
}

.article {
	overflow: hidden;
	width: 100%;
	border-style: solid;
	border-width: 1px;
	border-color: #CCCCCC;
}

.article .info {
	overflow: auto;
	width: 90%;
	padding: 20px;
	color: #333333;
	/* 	font-size: 12px; */
}
</style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="js/slider.js"></script>
</head>
<body>
	<div id="container">
		<div id="header">
			<div id="logo">
				<img alt="logo" src="/images/logo.gif" />
			</div>
			<div id="headerContact">
				<span>2015年11月26日 星期四</span>
			</div>
		</div>
		<div class="spacer"></div>
		<div id="nav">
			<div id="menu">
				<div
					style="width: 100%;height:42px;z-index:3;background:#212121; top:0; left:0; display:block;">
					<ul class="hnav">
						<li><a href="/">首页</a></li>
						<li><a href="/article/19/index.html">网页教程</a></li>
						<li><a href="/article/21/index.html">网页设计</a></li>
						<li><a href="/article/22/index.html">网页特效</a></li>
						<li><a href="/program/1/index.html">网页编程</a></li>
						<li><a href="/graphic/21/index.html">平面设计</a></li>
						<li><a href="/design/30/index.html">我的设计</a></li>
						<li><a href="/item/index.html">精选专题</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="spacer"></div>
		<div id="main">
			<div id="content">
				<div class="position">
					<div
						style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px;">
						<span>当前位置: 首页 > java</span>
					</div>
				</div>
				<div class="spacer"></div>
				<c:if test="${channel!=null}">
					<c:forEach var="chan" items="${channel.children}" varStatus="status">
						<c:if test="${chan.name!=null && chan.name!=''}">
							<c:if test="${status.count%2==0}">
								<div class="box" style="float: left;">
							</c:if>
							<c:if test="${status.count%2==1}">
								<div class="box" style="float: right;">
							</c:if>
							<div class="box-header">${chan.name}</div>
							<div class="box-center">
								<ul>
									<c:set var="docs"
										value="${fns:getDocByChannelCode(chan.code,10)}"></c:set>
									<c:if test="${docs!=null}">
										<c:forEach var="doc" items="${docs}">
											<li><a href="${ctx}/${chan.linkAddr}/doc/${doc.id}"
												target="blank">${doc.title}</a></li>
										</c:forEach>
									</c:if>
								</ul>
							</div>
			</div>
			<c:if test="${status.count%2==0}">
				<div class="spacer"></div>
			</c:if>
			</c:if>
			</c:forEach>
			</c:if>
			<div class="box" style="float: left;">
				<div class="box-header">智慧互联网解决方案</div>
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
						<li>solr4的solr-ik插件</li>
						<li>elasticsearch查询优化案例</li>
					</ul>
				</div>
			</div>
			<div class="box" style="float: right;">
				<div class="box-header">企业社交商务云平台</div>
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
						<li>solr4的solr-ik插件</li>
						<li>elasticsearch查询优化案例</li>
					</ul>
				</div>
			</div>
			<div class="spacer"></div>
			<div class="box" style="float: left;">
				<div class="box-header">企业互联网咨询</div>
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
						<li>solr4的solr-ik插件</li>
						<li>elasticsearch查询优化案例</li>
					</ul>
				</div>
			</div>
			<div class="box" style="float: right;">
				<div class="box-header">智慧互联网平台</div>
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
						<li>solr4的solr-ik插件</li>
						<li>elasticsearch查询优化案例</li>
					</ul>
				</div>
			</div>
			<div class="spacer"></div>
			<div class="article">
				<div class="info">
					<span style="font-weight: bold;font-size: 14px;">Redis主从同步</span>
					<hr>
					<p>现象： 日志中输出DEBUG级别的日志：Could not retrieve login configuration:
						java.lang.SecurityException: 无法定位登录配置 分析：
						此为未使用sasl连接zookeeper时，zookeeper客户端提示的日志。参见：https://cwiki.apache.org/confluence/display/ZOOKEEPER/Zookeeper+and+SASL
						解决： 忽略此日志。 提高全部logg ...</p>
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
	<div id="footer">Copyright © 2011-2015 IT技术精华网. Powered by
		chepoo.com.京ICP备11014024号 .</div>
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
