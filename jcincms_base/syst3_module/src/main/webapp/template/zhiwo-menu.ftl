<div class="menu">
	<ul>
		<li><a href="${ctx}/">首页</a></li>
			<#if menus ??>
				<#list menus as channel>
					<#if channel.name ??>
						<li><a href="${ctx}/${channel.linkAddr}">${channel.name}</a>
							<#--<#if channel.children ??>
								<#assign list=channel.children>
								<#include "submenu.ftl" >
							</#if>-->
						</li>
					</#if>
				</#list>
			</#if>
	</ul>
</div>