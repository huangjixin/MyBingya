<#if chan ??>
	<#if chan.children ??>
		<#list chan.children as chan>
			<a href="${ctx}/${chan.linkAddr}" class="button button-primary button-rounded button-small">${chan.name}</a>
		</#list>
	</#if>
</#if>