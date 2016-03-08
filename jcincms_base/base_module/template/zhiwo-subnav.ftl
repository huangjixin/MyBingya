<#if chan ??>
	<#if chan.children ??>
		<#list chan.children as chan>
			<li style="text-align: left;margin-bottom:0px;"><a
				<#--<#if chan.children??>onclick="setUlCss('${chan.id}')"
				<#else>href="${ctx}/${chan.linkAddr}"</#if>display:none;-->
				href="${ctx}/${chan.linkAddr}">${chan.name}</a>
				<#if chan.children??>
					<ul id="${chan.id}" style="color:#333;margin-top:5px;">
						<#assign chan=chan>
						<#include "zhiwo-subnav.ftl" >
					</ul>
				</#if></li>
		</#list>
	</#if>
</#if>