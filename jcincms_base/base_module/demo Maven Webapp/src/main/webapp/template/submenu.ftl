<ul>
	<#if list ??>
		<#list list as channel>
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