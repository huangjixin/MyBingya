		<div id="left_side">
			<div class="box" style="width: 250px;">
				<div class="box-header">点击率排行榜</div>
				<!-- <div><hr style="width:100%;height:1px;border:none;border-top:1px solid #0088DD;" /></div> -->
				<div class="box-center">
					<ul style="list-style:none;">
						<#if clickCountDocs ??>
							<#list clickCountDocs as doc>
								<li><a href="${ctx}/${doc.channel.linkAddr}/doc/${doc.id}"
														target="blank">${doc.title}</a></li>
							</#list>
						</#if>
					</ul>
				</div>
			</div>
			<div class="spacer"></div>
			<div class="box" style="width: 250px;">
				<div class="box-header">分类目录</div>
				<!-- <div><hr style="width:100%;height:1px;border:none;border-top:1px solid #0088DD;" /></div> -->
				<div class="box-center" style="font-size: 14px;">
					<div class="category">elasticsearch</div>
				</div>
				<div style="height: 12px;"></div>
			</div>
		</div>