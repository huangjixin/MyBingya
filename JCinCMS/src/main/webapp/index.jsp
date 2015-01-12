<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>首页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="首页">
<meta http-equiv="description" content="login,登录">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui/dwrloader.js"></script>
<script type="text/javascript" src="js/jquery-easyui/easyloader.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui/themes/icon.css">

<style type="text/css">
body {
	height: 100%;
	overflow: hidden;
	margin: 0px;
	padding: 0px;
}

.box {
	height: 100%;
	background: #ff0000;
	position: absolute;
	width: 100%;
}

#header {
	height: 100px;
	background-image: url(images/headerBG.gif);
	background-repeat: repeat-x;
}
</style>
<script type="text/javascript">
	$().ready(function() {
		$('#tgrid').treegrid({
			onClickRow : function(row) {
				doLink(row.url);
			}
		});
	});

	//打开连接。
	function doLink(url) {
		if (url == null) {
			return;
		}
		$("#ifrContentArea").attr("src", url);
	}
	
	function logout(){
		$.ajax({
				cache : false,
				type : "get",
				url : 'login/validatelogout',
				async : false,
				error : function(request) {
				},
				success : function(data) {
					
				}
			});
	}
</script>
</head>

<body class="easyui-layout" fit="true">
	<div region="north" title="" split="false" id="header"
		style="height:100px;">
		<h1
			style="margin: 0; padding: 15px; cursor: default; font-family: 微软雅黑, 黑体, 宋体;">XX管理系统</h1>
		<input id="logoutBtn" type="button" value="退出"
			style="position: absolute;right:8px;bottom:2px;" onclick="logout()"></input>
	</div>
	<!-- 	<div region="south" title="" split="false"
			style="height:30px;"></div>
		<div region="east" iconCls="icon-reload" title="" split="false"
	 		style="width:100px;"></div> -->
	<div region="west" split="true" title="" style="width:180px;">
		<!--数据源属性 data:[{id:2,name:'Tair'},{id:2,name:'Tair'},{id:2,name:'Tair'}], -->
		<table id="tgrid" title="" class="easyui-treegrid"
			style="padding: 1px;"
			data-options="
								url: 'menu/getMenu',
								method: 'get',
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
	<div region="center" title="" style="padding:1px;background:#ffffff;">
		<iframe id="ifrContentArea" scrolling="auto" frameborder="0"
			style="width: 100%; height: 100%;"></iframe>
	</div>
</body>
</html>
