<div class="globalWidth" id="menuContainer">
	<div class="menuContent">
		<div class="menu">
			<ul>
				<li><a href="${ctx}/">首页</a></li>
				<#list menus as chan>
						<#if chan.name ??>
							<li><a href="${ctx}/${chan.linkAddr}"
								<#if channel ??>
									<#if channel.name==chan.name>
										class="selected"
									</#if>
								</#if> >${chan.name}</a>
								<#--<#if chan.children ??>
									<#assign list=channel.children>
									<#include "submenu.ftl" >
								</#if>-->
							</li>
						</#if>
				</#list>
			</ul>
		</div>
	</div>
</div>