<div class="globalWidth">
	<div style="width:100%;;text-align: center;position:relative;">
		<img alt="服务流程" src="${ctx}/images/kfzx_banner.jpg"
			style="width: 100%;height: auto;">
	</div>
	<div class="contentWidth">
		<div style="padding: 5px;background-color: #EC3901;">
			<span style="color: #ffffff;font-size: 12px;">当前位置： <a
				href="${ctx}/"
				style="color: #ffffff;font-size: 12px;text-decoration: none;">首页</a>
				<#if navChan ??>
					<#list navChan as chan>
										><a href="${ctx}/${chan.linkAddr}"
							style="color: #ffffff;font-size: 12px;text-decoration: none;">${chan.name}</a>
					</#list>
				</#if>
			</span>
		</div>
		<div class="devider"></div>
		<div style="padding: 10px;border: 1px solid #cccccc;">
		<#assign docs=page.rows>
		<#if docs ??>
			<ul id="newslist">
				<#list docs as doc>
					<li style="margin-top: 20px;margin-bottom: 20px;"><a
						href="${ctx}/${channel.linkAddr}/doc/${doc.id}" target="blank"><span
							style="font-weight: bold;">${doc.title}</span>
							<div class="devider"></div>
							<div style="font-size: 12px;">${doc.contentShort}……</div></a></li>
					<hr class="hr" style="border-top:1px dashed #cccccc;"></hr>
				</#list>
			</ul>
		</#if>
		<#if docs ??>
			<div class="spacer"></div>
			<div
				style="width:100%;padding: 5px 0px 5px 5px;font-size: 12px;text-align: center;">
				<a href="${ctx}/${channel.linkAddr}?page=1"><span>首页</span></a>&nbsp;&nbsp;
				<#if (page.page>1)>
					<a href="${ctx}/${channel.linkAddr}?page=${page.page-1}"><span>上一页</span></a>&nbsp;&nbsp;</#if>
				<span>${page.page}</span>&nbsp;&nbsp;
				<#if (page.page < page.totalPage+1)>
					<a href="${ctx}/${channel.linkAddr}?page=${page.page+1}"><span>下一页</span></a>&nbsp;&nbsp;</#if>
				<#if (page.page < page.totalPage+1)>
					<a href="${ctx}/${channel.linkAddr}?page=${page.totalPage+1}"><span>末页</span></a>&nbsp;&nbsp;</#if>
				&nbsp;&nbsp;<span>共${page.totalPage+1}页 ${page.total}条</span>
			</div>
		</#if>
		</div>
	</div>

</div>