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

	});
</script>
</head>

<body class="easyui-layout">
	<div region="north" title="" split="false" id="header"
		style="height:100px;">
		<!-- 		<div id="header" > -->
		<!-- 			<h1></h1> -->
		<!-- 		</div> -->
	</div>
	<!-- 	<div region="south" title="" split="false" -->
	<!-- 		style="height:30px;"></div> -->
	<!-- 	<div region="east" iconCls="icon-reload" title="" split="false" -->
	<!-- 		style="width:100px;"></div> -->
	<div region="west" split="true" title="" style="width:180px;">
		<!--数据源属性 data:[{id:2,name:'Tair'},{id:2,name:'Tair'},{id:2,name:'Tair'}], -->
		<table id="tgrid" title="" class="easyui-treegrid"
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
		<!-- 		<table title="Folder Browser" class="easyui-treegrid" -->
		<!-- 			data-options=" -->
		<!-- 		                url: 'menu/getMenu', -->
		<!-- 		                method: 'get', -->
		<!-- 		                rownumbers: false, -->
		<!-- 		                idField: 'id', -->
		<!-- 		                treeField: 'name' -->
		<!-- 		                fit:true, -->
		<!-- 		                fitColumns:true -->
		<!-- 		            "> -->
		<!-- 			<thead> -->
		<!-- 				<tr> -->
		<!-- 					<th data-options="field:'name'" width="220">Name</th> -->
		<!-- 				</tr> -->
		<!-- 			</thead> -->
		<!-- 		</table> -->
	</div>
	<div region="center" title="" style="padding:5px;background:#eee;">

	</div>
</body>
</html>
