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
Date.prototype.format = function(format) {
	var o = {
		"M+" : this.getMonth() + 1, //month
		"d+" : this.getDate(), //day
		"h+" : this.getHours(), //hour
		"m+" : this.getMinutes(), //minute
		"s+" : this.getSeconds(), //second
		"q+" : Math.floor((this.getMonth() + 3) / 3), //quarter
		"S" : this.getMilliseconds()
	//millisecond
	}
	if (/(y+)/.test(format))
		format = format.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(format))
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
					: ("00" + o[k]).substr(("" + o[k]).length));
	return format;
}

//格式化用户状态显示。
function formatDate(val, row) {
	var date = new Date();
	date.setTime(val);
	var result = date.format("yyyy-MM-dd hh:mm:ss");

	return result;
}

$().ready(function() {
});

function refreshRows() {
	$("#tgrid").treegrid('reload'); // 重新加载;
}

// 移除条目；
function deleteRows() {
	//多行删除。
	var row = $('#tgrid').treegrid('getSelections');
	if (row == null) {
		return;
	}
	var i = 0;
	var string = "";
	for (i; i < row.length; i++) {
		string += row[i].id;
		if (i < row.length - 1) {
			string += ',';
		} else {
			break;
		}
	}

	var pamameter = {
		idstring : string
	};
	$.ajax({
		cache : true,
		type : "POST",
		url : 'opelog/deleteById',
		data : pamameter,
		async : false,
		error : function(request) {
			alert("连接失败");
		},
		success : function(data) {
			$("#tgrid").treegrid('reload'); // 重新加载;
		}
	});
}

//更新
function update() {
	//多行删除。
	var row = $('#tgrid').treegrid('getSelections');
	if (row == null) {
		return;
	}
//		var path = "payed/payedUpdate?id='" + row[0].id+"'";
	$('#idInput').val(row[0].id);
	$('#updateForm').submit();
}

</script>
</head>

<body class="easyui-layout" data-options="fit:true">
	<div id="toolBar" style="padding: 5px;border: 0px;">
				<input type="button" value="新增" onclick="$('#addForm').submit();" />
				<input type="button" value="修改" onclick="update();" /> <input
					type="button" value="删除" onclick="deleteRows()" /> <input
					type="button" value="刷新" onclick="refreshRows()" />
			</div>
			<table id="tgrid" title="" class="easyui-treegrid"
				data-options="
								url: 'menu/getMenu',
								method: 'get',
								rownumbers: false,
								idField: 'id',
								treeField: 'name',
								showHeader: true,
								lines: true,
								singleSelect : false,
								selectOnCheck: true,
								checkOnSelect: true,
								fit:true,
								fitColumns:true
							">
				<thead>
					<tr>
						<th field="ck" data-options="checkbox:true"></th>
						<th id="nameFieldTh" data-options="field:'name',align:'left'"
							width="100%">名称</th>
						<th id="urlFieldTh" data-options="field:'url',align:'center'"
							width="100%">连接的URL</th>
						<th id="descriptionTh"
							data-options="field:'description',align:'center'" width="100%">描述</th>
					</tr>
				</thead>
			</table>
	<form id="addForm" action="menu/new"></form>
	<form id="updateForm" action="menu/edit">
		<input type="hidden" id="idInput" name="id" />
	</form>
</body>
</html>
