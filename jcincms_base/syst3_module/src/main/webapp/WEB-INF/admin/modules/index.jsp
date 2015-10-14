<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>系统首页</title>
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/demo/demo.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/themes/icon.css" />
<script type="text/javascript"
	src="${ctx}/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$('#tgrid').treegrid({
			onClickRow : function(row) {
				doLink(row.path);
			}
		});
	});
	
	//打开连接。
	function doLink(url) {
		if (url == null||url=="") {
			return;
		}
		$("#ifrContentArea").attr("src",'${ctxAdmin}/'+url);
	}
	
	function showUser(){
		$("#ifrContentArea").attr("src",'${ctxAdmin}/user/show/'+$('#userId').val());
	}
	
	function changePassword(){
		$("#ifrContentArea").attr("src",'${ctxAdmin}/user/changePassword');
	}
</script>
<style type="text/css">
html,body {
	margin: 0;
	padding: 0;
	border: 0;
	width: 100%;
	height: 100%;
	overflow: hidden;
}

.logo {
	font-family: "微软雅黑", "Helvetica Neue", ​Helvetica, ​Arial, ​sans-serif;
	font-size: 28px;
	font-weight: bold;
	color: #444;
	cursor: default;
	position: absolute;
	top: 28px;
	left: 15px;
	line-height: 28px;
}

.topNav {
	position: absolute;
	right: 8px;
	bottom: 10px;
	font-size: 12px;
	line-height: 25px;
}

.topNav a {
	text-decoration: none;
	color: #222;
	font-weight: normal;
	font-size: 12px;
	line-height: 25px;
	margin-left: 3px;
	margin-right: 3px;
}

.topNav a:hover {
	text-decoration: underline;
	color: Blue;
}

.mini-layout-region-south img {
	vertical-align: top;
}
</style>
</head>
<body>
	<input type="hidden" id="userId" value="${fns:getUserId()}"/>
	<div class="easyui-layout" fit="true">
		<div data-options="region:'north',split:true" style="height:80px;background:-moz-linear-gradient(top,#DBEAF9,#ffffff);/*火狐*/background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(#b8c4cb), to(#f6f6f8));">
			<div class="logo">J2EE应用开发平台</div>
			<div class="topNav">
				欢迎<a onclick="showUser();"><b style="color: red;">${fns:getUsername()}</b></a>，上次登录是：<b style="color: red;">2015/10/11</b> &nbsp;&nbsp;<a  onclick="changePassword();">密码修改</a>&nbsp;&nbsp;<a href="../index.html">首页</a> | <a href="../demo/index.html">在线示例</a>
				| <a href="../docs/api/index.html">Api手册</a> | <a
					href="../index.html#tutorial">开发教程</a> | <a
					href="${ctxAdmin}/logout">退出</a>
			</div>
		</div>

		<div data-options="region:'west',split:true" title="菜单"
			style="width:230px;padding: 1px;">
			<table id="tgrid" title="" class="easyui-treegrid"
				style=""
				data-options="
								url: '${ctxAdmin}/resource/getMenu',
								method: 'get',
								lines: true,
								rownumbers: false,
								idField: 'id',
								treeField: 'name',
								showHeader: false,
								fit:true,
								fitColumns:true
							">
				<thead>
					<tr>
						<th id="nameFieldTh" data-options="field:'name'" width="100%">Name</th>
					</tr>
				</thead>
			</table>
		</div>
		<div data-options="region:'center',title:''">
			<iframe id="ifrContentArea" frameborder="0" name="main"
					style="width:100%;height:99%;" border="0"  scrolling="auto"></iframe>
		</div>
		<!-- <div data-options="region:'south'"
			style="text-align:center;height:25px;padding-top: 2px;">
			Copyright © 黄记新软件有限公司版权所有</div> -->
	</div>
</body>
</html>