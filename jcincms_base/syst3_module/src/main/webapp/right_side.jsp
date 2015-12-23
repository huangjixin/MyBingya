<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div id="left_side">
	<div class="box" style="width: 250px;">
		<div class="box-header">点击率排行榜</div>
		<!-- <div><hr style="width:100%;height:1px;border:none;border-top:1px solid #0088DD;" /></div> -->
		<div class="box-center">
			<ul style="list-style:none;">
				<c:if test="${clickCountDocs!=null}">
					<c:forEach items="${clickCountDocs}" var="doc">
						<li><a href="${ctx}/${doc.channel.linkAddr}/doc/${doc.id}"
												target="blank">${doc.title}</a></li>
					</c:forEach>
				</c:if>
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