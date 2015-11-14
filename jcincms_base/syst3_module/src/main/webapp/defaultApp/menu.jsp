<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="MainMenu" class="ddsmoothmenu">
	<ul>
		<c:forEach var="channel" items="${list}">
			<li><a href="${ctx}/${channel.linkAddr}" title="${channel.name}"
				<c:if test="${channel.linkAddr=='/'}">id="menu_selected"</c:if>><span>${channel.name}</span></a>
				<c:if test="${channel.children!= null }">
					<ul class="menulevel">
						<c:forEach var="chan" items="${channel.children}">
							<li><a href="${ctx}/${chan.linkAddr}" title="${chan.name}"><span>${chan.name}</span></a>
								<c:if test="${chan.children!= null }">
									<ul class="menulevel">
										<c:forEach var="ch" items="${chan.children}">
											<li><a href="${ctx}/${ch.linkAddr}" title="${ch.name}"><span>${ch.name}</span></a>
											</li>
										</c:forEach>
									</ul>
								</c:if></li>
						</c:forEach>
					</ul>
				</c:if></li>
		</c:forEach>
	</ul>
</div>
