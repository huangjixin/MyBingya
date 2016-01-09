<div
	style="background:black; filter: alpha(opacity=60); opacity:0.6; position: absolute;bottom: 0px;z-index: 1;width:100%;height: 20px;line-height: 20px;">
	<div class="contentWidth">
		<span style="color: #ffffff;font-size: 12px;">当前位置： <a
			href="${ctx}/" style="color: #ffffff;font-size: 12px;text-decoration: none;">首页</a> 
			<#if navChan ??>
				<#list navChan as chan>
										><a href="${ctx}/${chan.linkAddr}"
						style="color: #ffffff;font-size: 12px;text-decoration: none;">${chan.name}</a>
				</#list>
			</#if>
		</span>
	</div>
</div>