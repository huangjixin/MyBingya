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

<title>菜单列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="menu,menu list">
<meta http-equiv="description" content="菜单列表">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui/dwrloader.js"></script>
<script type="text/javascript" src="js/jquery-easyui/easyloader.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/common.css">
<style type="text/css">
.table {
	border-collapse: collapse;
}

.tr1 {
	width: 100px;
	text-align: right;
	background-color: #F7F7F7;
}

.th1 {
	width: 100px;
	background-color: #F7F7F7;
	text-align: right;
	padding-right: 2px;
	background-color: #F7F7F7;
	font-weight: normal;
}

.td1 {
	width: 250px;
	background-color: #ffffff;
	text-align: left;
	width: 200px;
	padding-left: 2px;
}
</style>
<script type="text/javascript">
	$().ready(function() {
	});
</script>
</head>

<body class="easyui-layout" fit="true">
	<div region="center" title="" style="padding:0px;background:#ffffff;">
		<div id="toolBar" style="width: 100%;">
			<input type="button" value="删除" onclick="deleteRows()" />
		</div>
		<div style="width: 100%;height:320px;">
			<table id="tgrid" title="" class="easyui-datagrid"
				data-options="
								pageSize : 10,
								pageList : [ 5, 10, 15, 20 ],
								nowrap : true,
								striped : true,
								collapsible : true,
								url: 'opelog/select',
								loadMsg : '数据装载中......',
								method: 'get',
								singleSelect : false,
								rownumbers: false,
								treeField: 'name',
								showHeader: true,
								fit:true,
								fitColumns:true,
								pagination : true
							">
				<thead>
					<tr>
						<th id="nameFieldTh" data-options="field:'name',align:'left'"
							width="100%">名称</th>
						<th id="urlFieldTh" data-options="field:'url',align:'center'"
							width="100%">连接的URL</th>
						<th id="createDateFieldTh" data-options="field:'createDate',align:'center'"
							width="100%">修改日期</th>
					</tr>
				</thead>
			</table>
		</div>

	</div>
</body>
</html>
