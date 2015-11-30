<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/css/demo.css">
<style type="text/css"></style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="js/slider.js"></script>
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
						<span>当前位置: 首页 > java</span>
					</div>
				</div>
				<c:set var="docs" value="${page.rows}"></c:set>
				<c:if test="${docs!=null}">
					<c:forEach var="doc" items="${docs}">
						<div class="spacer"></div>
						<div class="article">
							<div class="info">
								<span style="font-weight: bold;font-size: 14px;"><a
									href="${ctx}/${channel.linkAddr}/doc/${doc.id}" target="blank">${doc.title}</a></span>
								<hr>
								<p>
									<%-- <c:set var="contentStr" value="做一个截取字符串长度的测试"></c:set>
									<c:choose>  
    									<c:when  test="${fn:length(contentStr) > 100}">  
        									<c:out  value="${fn:substring(contentStr, 0, 100)}......"  />  
    									</c:when>  
   									<c:otherwise>  
      									<c:out  value="${contentStr}"  />  
   										</c:otherwise>  
									</c:choose> --%>
									<%-- ${doc.content} --%>
									现象： 日志中输出DEBUG级别的日志：Could not
									retrieve login configuration: java.lang.SecurityException:
									无法定位登录配置 分析：
									此为未使用sasl连接zookeeper时，zookeeper客户端提示的日志。参见：https://cwiki.apache.org/confluence/display/ZOOKEEPER/Zookeeper+and+SASL
									解决： 忽略此日志。 提高全部logg ...
								</p>
								<div>${doc.author}&nbsp;&nbsp;&nbsp;&nbsp;${doc.createDate}</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
			<!-- 右边导航 -->
			<jsp:include page="right_side.jsp" flush="true"></jsp:include>
		</div>
		<div class="clear"></div>
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
