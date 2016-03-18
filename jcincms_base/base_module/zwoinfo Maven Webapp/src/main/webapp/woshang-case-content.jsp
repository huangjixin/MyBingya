<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div class="globalWidth">
	<div class="contentWidth">
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<img alt="智沃" src="${ctx}/images/20151202083808_46690.jpg">
				</div>
				<div class="swiper-slide">
					<img alt="智沃" src="${ctx}/images/20151202083840_30197.jpg">
				</div>
			</div>
			<!-- 如果需要分页器 -->
			<div class="swiper-pagination"></div>
			<!-- 如果需要导航按钮 -->
			<!-- <div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div> -->
		</div>
	</div>
	<div class="devider"></div>
	<div class="contentWidth">
		<div class="case-content-left">
			<div class="header">
				<span>联系智沃</span>
			</div>
			<div class="devider"></div>
			<span style="color: #EC3901;font-size: 12px;padding-top: 10px;">广州市智沃信息科技有限公司</span>
			<div class="devider"></div>
			<span style="font-size: 12px;padding-top: 10px;">电话:139 2620
				5227</span>
			<div class="devider"></div>
			<a
				href="http://wpa.qq.com/msgrd?v=3&amp;uin=635152644&amp;site=www.newcapec.com.cn&amp;menu=yes"
				target="_blank"><img alt="在线客服一" border="0"
				src="http://wpa.qq.com/pa?p=2:635152644:46" title="在线客服一" /></a> &nbsp;
			<a href=http://wpa.qq.com/msgrd?V=3&uin=517714860&Site=在线客服二&Menu=yes><img
				border="0" SRC=http://wpa.qq.com/pa?p=1:517714860:5 alt="点击咨询"></a>
		</div>
		<div class="case-content-right">
			<div
				style="padding: 5px;background-color: #EC3901;">
				<span style="color: #ffffff;font-size: 12px;">当前位置： <a
					href="${ctx}/"
					style="color: #ffffff;font-size: 12px;text-decoration: none;">首页</a>
					<c:if test="${navChan !=null}">
						<c:forEach var="chan" items="${navChan}">
										><a href="${ctx}/${chan.linkAddr}"
								style="color: #ffffff;font-size: 12px;text-decoration: none;">${chan.name}</a>
						</c:forEach>
					</c:if>
				</span>
			</div>
			<div class="devider"></div>
			<div
				style="text-align: center;width: 100%;border: 1px solid #cccccc;">
				<c:set var="docs" value="${page.rows}"></c:set>
				<c:if test="${docs!=null}">
					<c:forEach var="doc" items="${docs}" varStatus="status">
						<c:if test="${status.index%2==0}">
							<a href="${ctx}/${channel.linkAddr}/doc/${doc.id}"><div
									style="float: left;text-align: center;margin-top: 10px;margin-left: 25px;">
									<img alt="" src="${ctx}/${doc.fileAddr}" class="case-img">
									<div class="devider"></div>
									<div style="font-size: 12px;">${doc.title}</div>
								</div></a>
						</c:if>
						<c:if test="${status.index%2!=0}">
							<a href="${ctx}/${channel.linkAddr}/doc/${doc.id}"><div
									style="float: right;text-align: center;margin-top: 10px;margin-right: 25px;">
									<img alt="" src="${ctx}/${doc.fileAddr}" class="case-img">
									<div class="devider"></div>
									<div style="font-size: 12px;">${doc.title}</div>
								</div></a>
						</c:if>
					</c:forEach>
					<%-- <ul>
					<c:forEach var="doc" items="${docs}">
						<li style="margin-top: 20px;margin-bottom: 20px;"><a
							href="${ctx}/${channel.linkAddr}/doc/${doc.id}" target="blank">
								<span style="font-weight: bold;">${doc.title}</span>
						</a></li>
						<hr class="hr" style="border-top:1px dashed #cccccc;"></hr>
					</c:forEach>
				</ul>--%>
					<div class="clear"></div>
				</c:if>
			</div>

			<c:if test="${docs!=null}">
				<div class="clear"></div>
				<div
					style="width:100%;padding: 5px 0px 5px 5px;font-size: 12px;text-align: center;">
					<a href="${ctx}/${channel.linkAddr}?page=1"><span>首页</span></a>&nbsp;&nbsp;
					<c:if test="${page.page>1}">
						<a href="${ctx}/${channel.linkAddr}?page=${page.page-1}"><span>上一页</span></a>&nbsp;&nbsp;</c:if>
					<span>${page.page}</span>&nbsp;&nbsp;
					<c:if test="${page.page < page.totalPage+1}">
						<a href="${ctx}/${channel.linkAddr}?page=${page.page+1}"><span>下一页</span></a>&nbsp;&nbsp;</c:if>
					<c:if test="${page.page < page.totalPage+1}">
						<a href="${ctx}/${channel.linkAddr}?page=${page.totalPage+1}"><span>末页</span></a>&nbsp;&nbsp;</c:if>
					&nbsp;&nbsp;<span>共${page.totalPage+1}页 ${page.total}条</span>
				</div>
			</c:if>
		</div>
	</div>
</div>
<div class="clear">