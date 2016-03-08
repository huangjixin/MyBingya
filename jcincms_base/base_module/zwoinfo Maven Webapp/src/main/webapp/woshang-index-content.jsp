<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div class="globalWidth">
	<div class="contentWidth">
		<div style="text-align: center;">
			<h1 style="color: #FF4A00;">打造更省钱 更赚钱的营销型网站</h1>
		</div>
		<div style="float: left;">
			<div>
				<h2>更省钱</h2>
				<h3>让您网站更容易免费排名到百度第一页</h3>
				<ul style="color: #0;">
					<li>先进的技术平台</li>
					<li>SEO优化系统</li>
					<li>锁定搜索引擎网站排名靠前</li>
					<li>流量更多，让你更省钱</li>
				</ul>
			</div>
		</div>
		<div style="float: right;">
			<img alt="智沃" src="${ctx}/images/baidusearch.jpg">
		</div>
		<div class="clear"></div>
		<div style="float: right;">
			<div>
				<h2>更赚钱</h2>
				<h3>同样的流量更多的询盘，比传统网页高20倍</h3>
				<ul style="color: #0;">
					<li>什么产品、卖给谁、怎么卖</li>
					<li>你的优势、客户的好处</li>
					<li>六大核心定位系统快速锁定、打动你的目标客户</li>
					<li>把空洞的“高大上”转变为切实的营销力</li>
					<li>吸引询盘，让你更赚钱</li>
				</ul>
			</div>
		</div>
		<div style="float: left;">
			<img alt="智沃" src="${ctx}/images/chart.jpg">
		</div>
	</div>
</div>
<div class="clear"></div>
<hr class="hr">
</div>
<div style="text-align: center;">
	<h1 style="color: #FF4A00;">做好网站!=网上盈利</h1>
	<h3 style="color: #585858;">网络盈利的几个关键点你HOLD住了吗</h3>
</div>
<div style="text-align: center;">
	<img alt="智沃网络推广" src="${ctx}/images/index_promotion.png">
</div>
<div style="text-align: center;">
	<h2 style="color: #BCBCBC;">OUR PRODUCT</h2>
	<h1 style="color: #FF4A00;">智沃产品</h1>
	<h3 style="color: #585858;">完整的全网营销系列产品，全方位助力网络营销</h3>
</div>

<div class="globalWidth">
	<div class="contentWidth">
		<a href="${ctx}/channel/service">
			<div class="globalDiv"
				style="float: left;width: 20%;text-align: center;margin-right: 9px;">
				<img alt="智沃营销网站设计" src="${ctx}/images/web.png">
				<div>
					<h3>高端网站设计</h3>
				</div>
				<div>
					<h4>营销型网站</h4>
				</div>
				<div>
					<h4>赚钱的网站</h4>
				</div>
				<hr class="hr">
			</div>
			<div class="globalDiv"
				style="float: left;width: 20%;text-align: center;">
				<img alt="智沃营销网站设计" src="${ctx}/images/mouse.png">
				<div>
					<h3>移动网站设计</h3>
				</div>
				<div>
					<h4>手机网站</h4>
				</div>
				<div>
					<h4>APP</h4>
				</div>
				<hr class="hr">
			</div>
			<div class="globalDiv"
				style="float: right;width: 20%;text-align: center;">
				<img alt="智沃营销网站设计" src="${ctx}/images/search.png">
				<div>
					<h3>网络营销策划</h3>
				</div>
				<div>
					<h4>提升企业形象</h4>
				</div>
				<div>
					<h4>带来订单</h4>
				</div>
				<hr class="hr">
			</div>
			<div class="globalDiv"
				style="float: right;width: 20%;text-align: center;margin-right: 9px;">
				<img alt="智沃营销网站设计" src="${ctx}/images/project.png">
				<div>
					<h3>项目定制开发</h3>
				</div>
				<div>
					<h4>网络定制开发</h4>
				</div>
				<div>
					<h4>CMS内容管理</h4>
				</div>
				<hr class="hr">
			</div>
		</a>
	</div>
</div>
<div class="clear"></div>
<div class="devider"></div>
<div class="globalWidth">
	<div class="contentWidth">
		<div class="case">
			<div>
				<span style="font-weight: bold;"><a
					href="${ctx}/channel/news">成功案例</a></span>
			</div>
			<hr class="hr">
			<ul style="width: 100%;position: relative;left: -40px;">
				<c:set var="casesdocs"
					value="${fns:getDocByChannelCode('cases',10)}"></c:set>
				<c:if test="${casesdocs!=null}">
					<c:forEach var="doc" items="${casesdocs}">
						<li><a
							href="${ctx}/channel/news/doc/${doc.id}" target="blank">${doc.title}
							<img src="${ctx}/${doc.fileAddr}" style="width: 120px;height: auto;float: left;margin-right: 10px;margin-top: 10px;">
							<p style="font-size: 12px;">${doc.contentShort}</p>
							</a></li>
							<%-- <span><fmt:formatDate value="${doc.createDate}" pattern="yyyy.MM.dd" /></span> --%>
						<div class="clear"></div>
					</c:forEach>
				</c:if>
			</ul>
		</div>
	</div>
</div>
<div class="clear"></div>
<div class="devider"></div>
<div class="globalWidth">
	<div class="contentWidth">
		<div>
			<div class="news">
				<div>
					<span style="font-weight: bold;"><a
						href="${ctx}/channel/news">公司动态</a></span>
				</div>
				<hr class="hr">
				<ul style="width: 100%;position: relative;left: -40px;">
					<c:set var="docs" value="${fns:getDocByChannelCode('news',10)}"></c:set>
					<c:if test="${docs!=null}">
						<c:forEach var="doc" items="${docs}">
							<li><a href="${ctx}/channel/news/doc/${doc.id}"
								target="blank">${doc.title}<%-- <span><fmt:formatDate
											value="${doc.createDate}" pattern="yyyy.MM.dd" /></span> --%></a></li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
			<div class="build">
				<div>
					<span style="font-weight: bold;">网络营销</span>
				</div>
				<hr class="hr">
				<ul style="width: 100%;position: relative;left: -40px;">
					<c:set var="docs" value="${fns:getDocByChannelCode('yingxiao',10)}"></c:set>
					<c:if test="${docs!=null}">
						<c:forEach var="doc" items="${docs}">
							<li><a href="${ctx}/channel/news/doc/${doc.id}"
								target="blank">${doc.title}<%-- <span><fmt:formatDate
											value="${doc.createDate}" pattern="yyyy.MM.dd" /></span> --%></a></li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
		</div>
		<div class="clear"></div>
	</div>
</div>
