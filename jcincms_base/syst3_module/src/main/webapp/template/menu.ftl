<div class="menu">
	<div
		style="height:40px;z-index:3;background:#212121;margin-left:20px; top:0; left:0; display:block;">
		<ul>
			<li><a href="${ctx}/">首页</a></li>
			<#if menus ??>
				<#list menus as channel>
					<#if channel.name ??>
						<li><a href="${ctx}/${channel.linkAddr}">${channel.name}</a>
							<#if channel.children ??>
								<#assign list=channel.children>
								<#include "submenu.ftl" >
							</#if>
						</li>
					</#if>
				</#list>
			</#if>
		</ul>
	</div>
</div>