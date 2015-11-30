<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/css/demo.css">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/slider.js"></script>
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
		<div class="spacer"></div>
		<!-- 导航菜单 -->
		<jsp:include page="menu.jsp" flush="true"></jsp:include>
		<div class="spacer"></div>
		<div id="main">
			<div id="content">
				<div class="position">
					<div
						style="padding-left: 5px;padding-top: 5px;padding-bottom: 5px;">
						<span>当前位置: <a href="${ctx}/">首页</a>
						<c:if test="${navChan !=null}">
							<c:forEach var="chan" items="${navChan}">
										><a href="${ctx}/${chan.linkAddr}">${chan.name}</a>
								</c:forEach>
						</c:if></span>
					</div>
				</div>
				<div class="spacer"></div>
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
					<div class="box-header">栏目头条</div>
					<div class="box-center">
						<ul>
							<c:if test="${recommendDocs!=null}">
								<c:forEach var="doc" items="${recommendDocs}">
									<c:if test="${doc.title!=null && doc.title!=''}">
										<li><a href="${ctx}/channel/recommend/doc/${doc.id}">${doc.title}</a></li>
									</c:if>
								</c:forEach>
							</c:if>
						</ul>
					</div>
				</div>
				<div class="spacer"></div>
				<c:if test="${channel!=null}">
					<c:forEach var="chan" items="${channel.children}" varStatus="status">
						<c:if test="${chan.name!=null && chan.name!=''}">
							<c:if test="${status.index%2==0}">
								<div class="box" style="float: left;">
							</c:if>
							<c:if test="${status.index%2==1}">
								<div class="box" style="float: right;">
							</c:if>
							<div class="box-header"><a href="${ctx}/${chan.linkAddr}">${chan.name}</a></div>
							<div class="box-center">
								<ul>
									<c:set var="docs" value="${fns:getDocByChannelCode(chan.code,10)}"></c:set>
									<c:if test="${docs!=null}">
										<c:forEach var="doc" items="${docs}">
										<li><a href="${ctx}/${chan.linkAddr}/doc/${doc.id}" target="blank">${doc.title}</a></li>
										</c:forEach>
									</c:if>
									<!-- <li>elasticsearch ik分词插件es-ik发布</li>
									<li>elasticsearch ik分词插件es-ik发布</li>
									<li>solr4的solr-ik插件</li>
									<li>当前几个主要的Lucene中文分词器的比较</li>
									<li>elasticsearch查询优化案例</li>
									<li>JMeter压力测试及并发量计算-2</li>
									<li>solr4的solr-ik插件</li>
									<li>elasticsearch查询优化案例</li>
									<li>JMeter压力测试及并发量计算-2</li>
									<li>solr4的solr-ik插件</li>
									<li>elasticsearch查询优化案例</li> -->
								</ul>
							</div>
			</div>
			<c:if test="${status.index%2==1}">
				<div class="spacer"></div>
			</c:if>
			</c:if>
			</c:forEach>
			</c:if>
			<div class="spacer"></div>
		</div>
		<!-- 右边导航 -->
		<jsp:include page="right_side.jsp" flush="true"></jsp:include>
	</div>
	<div class="clear"></div>
	<!-- 网页底部 -->
	<jsp:include page="footer.jsp" flush="true"></jsp:include>
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
