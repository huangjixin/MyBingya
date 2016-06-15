<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<script type="text/javascript">
	$().ready(function() {
		//导航切换
		$(".menuson li").click(function() {
			$(".menuson li.active").removeClass("active")
			$(this).addClass("active");
		});
	});
</script>
<div class="lefttop">
	<span></span>主菜单
</div>
<dl class="leftmenu">
	<c:forEach var="resource" items="${menu}">
		<dd>
			<div class="title">
				<span></span>${resource.name}
			</div>
			<c:if test="${resource.children!=null}">
				<ul class="menuson">
					<c:forEach var="resource" items="${resource.children}">
						<li onclick="javascript:doLink('${resource.name}','${resource.path}');"><cite></cite><b 
							>${resource.name}</b><i></i></li>
					</c:forEach>
				</ul>
			</c:if>
		</dd>
	</c:forEach>
	<!-- <dd>
		<div class="title">
			<span></span>管理信息
		</div>
		<ul class="menuson">
			<li><cite></cite><a href="index.html" target="rightFrame">首页模版</a><i></i></li>
			<li class="active"><cite></cite><a href="right.html"
				target="rightFrame">数据列表</a><i></i></li>
			<li><cite></cite><a href="imgtable.html" target="rightFrame">图片数据表</a><i></i></li>
			<li><cite></cite><a href="form.html" target="rightFrame">添加编辑</a><i></i></li>
			<li><cite></cite><a href="imglist.html" target="rightFrame">图片列表</a><i></i></li>
			<li><cite></cite><a href="imglist1.html" target="rightFrame">自定义</a><i></i></li>
			<li><cite></cite><a href="tools.html" target="rightFrame">常用工具</a><i></i></li>
			<li><cite></cite><a href="filelist.html" target="rightFrame">信息管理</a><i></i></li>
			<li><cite></cite><a href="tab.html" target="rightFrame">Tab页</a><i></i></li>
			<li><cite></cite><a href="error.html" target="rightFrame">404页面</a><i></i></li>
		</ul>
	</dd>
	<dd>
		<div class="title">
			<span></span>其他设置
		</div>
		<ul class="menuson">
			<li><cite></cite><a href="#">编辑内容</a><i></i></li>
			<li><cite></cite><a href="#">发布信息</a><i></i></li>
			<li><cite></cite><a href="#">档案列表显示</a><i></i></li>
		</ul>
	</dd>
	<dd>
		<div class="title">
			<span></span>编辑器
		</div>
		<ul class="menuson">
			<li><cite></cite><a href="#">自定义</a><i></i></li>
			<li><cite></cite><a href="#">常用资料</a><i></i></li>
			<li><cite></cite><a href="#">信息列表</a><i></i></li>
			<li><cite></cite><a href="#">其他</a><i></i></li>
		</ul>
	</dd>
	<dd>
		<div class="title">
			<span></span>日期管理
		</div>
		<ul class="menuson">
			<li><cite></cite><a href="#">自定义</a><i></i></li>
			<li><cite></cite><a href="#">常用资料</a><i></i></li>
			<li><cite></cite><a href="#">信息列表</a><i></i></li>
			<li><cite></cite><a href="#">其他</a><i></i></li>
		</ul>
	</dd> -->
</dl>

