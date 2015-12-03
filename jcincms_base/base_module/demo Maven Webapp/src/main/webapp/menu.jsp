<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div class="menu">
	<div
		style="height:40px;z-index:3;background:#212121;margin-left:20px; top:0; left:0; display:block;">
		<ul>
			<li><a href="${ctx}">首页</a></li>
			<c:if test="${list!=null}">
				<c:forEach var="channel" items="${list}">
					<c:if test="${channel.name!=null && channel.name!=''}">
						<li><a href="${ctx}/${channel.linkAddr}">${channel.name}</a>
							<c:if test="${channel.children!=null}">
								<ul>
									<c:if test="${channel.children!=null}">
										<c:forEach var="channel" items="${channel.children}">
											<c:if test="${channel.name!=null && channel.name!=''}">
												<li><a href="${ctx}/${channel.linkAddr}">${channel.name}</a>
													<c:if test="${channel.children!=null}">
														<ul>
															<c:if test="${channel.children!=null}">
																<c:forEach var="channel" items="${channel.children}">
																	<c:if test="${channel.name!=null && channel.name!=''}">
																		<li><a href="${ctx}/${channel.linkAddr}">${channel.name}</a>
																			<c:if test="${channel.children!=null}">
																				<ul>
																					<c:if test="${channel.children!=null}">
																						<c:forEach var="channel"
																							items="${channel.children}">
																							<c:if
																								test="${channel.name!=null && channel.name!=''}">
																								<li><a href="${ctx}/${channel.linkAddr}">${channel.name}</a>
																									<c:if test="${channel.children!=null}">
																										<ul>

																										</ul>
																									</c:if></li>
																							</c:if>
																						</c:forEach>
																					</c:if>
																				</ul>
																			</c:if></li>
																	</c:if>
																</c:forEach>
															</c:if>
														</ul>
													</c:if></li>
											</c:if>
										</c:forEach>
									</c:if>
								</ul>
							</c:if></li>
					</c:if>
				</c:forEach>
			</c:if>
			<!-- <li><a href="/program/1/index.html">网页编程</a>
				<ul>
					<li><a href="/program/1/index.html"> ASP编程教程</a></li>
					<li><a href="/program/2/index.html"> PHP编程教程</a></li>
					<li><a href="/program/3/index.html"> MySQL数据库</a></li>
					<li><a href="/program/6/index.html"> Access数据库</a></li>
					<li><a href="/program/8/index.html"> jQuery编程</a></li>
					<li><a href="/program/10/index.html"> Javascript编程</a></li>
				</ul></li>
			<li> -->
		</ul>
	</div>
</div>

<%-- <div id="nav">
		<div id="menu">
			<div
				style="width: 100%;height:42px;z-index:3;background:#212121; top:0; left:0; display:block;">
				<ul class="hnav">
					<li><a href="${ctx}">首页</a></li>
					<c:if test="${list!=null}">
						<c:forEach var="channel" items="${list}">
							<c:if test="${channel.name!=null && channel.name!=''}">
								<li><a href="${ctx}/${channel.linkAddr}">${channel.name}</a></li>
							</c:if>
						</c:forEach>
					</c:if>
					<li><a href="/program/1/index.html">网页编程</a>
						<ul>
							<li><a href="/program/1/index.html"> ASP编程教程</a></li>
							<li><a href="/program/2/index.html"> PHP编程教程</a></li>
							<li><a href="/program/3/index.html"> MySQL数据库</a></li>
							<li><a href="/program/6/index.html"> Access数据库</a></li>
							<li><a href="/program/8/index.html"> jQuery编程</a></li>
							<li><a href="/program/10/index.html"> Javascript编程</a></li>
						</ul></li>
					<li><a href="/graphic/21/index.html">平面设计</a>
						<ul>
							<li><a href="/graphic/21/100/index.html">平面设计常识</a></li>
							<li><a href="/graphic/21/126/index.html"> 平面设计教程</a></li>
							<li><a href="/graphic/21/116/index.html"> 名片票券设计</a></li>
							<li><a href="/graphic/21/117/index.html"> 文字标识设计</a></li>
							<li><a href="/graphic/21/119/index.html">企业VI设计</a></li>
							<li><a href="/graphic/21/123/index.html"> 广告出版包装</a></li>
							<li><a href="/graphic/21/120/index.html"> 平面精品推荐</a></li>
						</ul></li>
					<li><a href="/design/30/index.html">我的设计</a>
						<ul>
							<li><a href="/design/30/8/index.html"> 网页设计</a></li>
							<li><a href="/design/30/9/index.html"> 平面设计</a>
								<ul>
									<li><a href="/design/30/8/index.html"> 网页设计</a></li>
									<li><a href="/design/30/9/index.html"> 平面设计</a></li>
								</ul></li>
							<li><a href="/design/30/10/index.html">网店装修</a></li>
							<li><a href="/design/30/11/index.html"> 图标设计</a></li>
							<li><a href="/design/30/12/index.html">广告设计 </a></li>
							<li><a href="/design/30/13/index.html">文字设计 </a></li>
							<li><a href="/design/30/15/index.html">软件UI设计</a></li>
							<li><a href="/design/30/19/index.html">摄影素材</a></li>
						</ul></li>
					<li class="hover"><a href="/item/1/index.html">精选专题</a>
						<ul></ul></li>
				</ul>

			</div>
		</div> 
</div>--%>