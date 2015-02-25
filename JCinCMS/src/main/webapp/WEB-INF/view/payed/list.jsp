<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
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

<title>已付款管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="已付款列表">
<meta http-equiv="description" content="已付款管理">
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
<link rel="stylesheet" type="text/css" href="css/common.css">
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

	$().ready(function() {
	});

	// 移除条目；
	function deleteRows(selecedRow) {
		var pamameter = null;
		if (selecedRow != null) {
			alert(selecedRow.material);
			pamameter = {};
			pamameter.idstring = selecedRow.id;
		} else {
			//多行删除。
			var row = $('#tgrid').datagrid('getSelections');
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
			pamameter = {};
			pamameter.idstring = string;
		}

		if (pamameter == null) {
			return;
		}
		$.ajax({
			cache : true,
			type : "POST",
			url : 'payed/deleteById',
			data : pamameter,
			async : false,
			error : function(request) {
				alert("连接失败");
			},
			success : function(data) {
				$("#tgrid").datagrid('reload'); // 重新加载;
			}
		});
	}

	//处理事件的函数
	function onKeyEnter(e) {
		if (e == 13 || e == 32) {
			search();
			e.returnValue = false;
			//返回false，在没有使用document.loginForm.submit()时可用于取消提交
		}
	}

	//搜索
	function search() {
		var queryParams = {};

		if ($("#materialInput").val() != "") {
			queryParams.material = $("#materialInput").val();
		}

		if ($("#sizeInput").val() != "") {
			queryParams.size = $("#sizeInput").val();
		}

		if ($("#customerNameInput").val() != "") {
			queryParams.customerName = $("#customerNameInput").val();
		}
		if ($("#recorddateInput").val() != "") {
			queryParams.recorddate = $("#recorddateInput").val();
		}
		
		$("#tgrid").datagrid("getPager").pagination({
			pageNumber : 1
		});

		$("#tgrid").datagrid("options").queryParams = queryParams;
		$("#tgrid").datagrid("reload");
	}

	//清除
	function clearSearch() {
		$("#materialInput").val("");
		$("#sizeInput").val("");
		$("#customerNameInput").val("");
		$("#recorddateInput").val("");
	}

	//格式化用户状态显示。
	function formatDate(val, row) {
		var date = new Date();
		date.setTime(val);
		var result = date.format("yyyy-MM-dd hh:mm:ss");

		return result;
	}

	//更新
	function update() {
		//多行删除。
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null) {
			return;
		}
// 		var path = "payed/payedUpdate?id='" + row[0].id+"'";
		$('#idInput').val(row[0].id);
// 		alert(path);
// 		$('#updateForm').attr("action", path);
		$('#updateForm').submit();
	}
	
	//导出excel
	function exportExcel(){
		var pamameter = $("#tgrid").datagrid("options").queryParams;
		$.ajax({
			cache : true,
			type : "GET",
			url : "payed/exportExcel",
			data : pamameter,
			async : false,
			error : function(request) {
				alert("连接失败");
			},
			success : function(data) {
				alert("导出成功");
			}
		});
	}
</script>
</head>

<body class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center'" title=""
		style="padding:0px;background:#ffffff;">
		<div id="toolBar" style="padding: 5px;border: 0px;">
			<input type="button" value="添加" id="btn_Add" name="btn_Add"
				onclick="$('#addForm').submit();" /> <input type="button"
				value="修改" id="btn_Update" name="btn_Update" onclick="update();" /> <input
				type="button" value="删除" onclick="deleteRows()" /> <label>材质:</label><input
				id="materialInput"
				onkeydown="onKeyEnter(event.keyCode||event.which);"> <label>规格:</label><input
				id="sizeInput" onkeydown="onKeyEnter(event.keyCode||event.which);">
				<label>客户名:</label><input
				id="customerNameInput" onkeydown="onKeyEnter(event.keyCode||event.which);">
				<label>日期:</label><input
				id="recorddateInput" onkeydown="onKeyEnter(event.keyCode||event.which);">
			<input type="button" id="searchBtn" value="搜索" onclick="search()" />
			<input type="button" id="clearBtn" value="清除" onclick="clearSearch()" />
			<input type="button" id="exportBtn" value="导出excel" onclick="exportExcel()" />
		</div>
		<table id="tgrid" title="" class="easyui-datagrid"
			style="height:350px;"
			data-options="
								pageSize : 10,
								pageList : [ 5, 10, 15, 20 ],
								nowrap : true,
								striped : true,
								collapsible : true,
								url: 'payed/select',
								loadMsg : '数据装载中......',
								method: 'get',
								singleSelect : false,
								selectOnCheck: true,
								checkOnSelect: true,
								rownumbers: false,
								treeField: 'name',
								showHeader: true,
								fit:false,
								fitColumns:true,
								pagination : true
							">
			<thead>
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<th data-options="field:'id',align:'left'" width="100%">ID</th>
					<th id="createDateFieldTh"
						data-options="field:'recorddate',align:'center'"
						width="100%">日期</th>
					<th data-options="field:'material',align:'left'" width="100%">材质</th>
					<th data-options="field:'customerName',align:'left'" width="100%">客户名</th>
					<th data-options="field:'size',align:'center'" width="100%">规格</th>
					<th data-options="field:'weight',align:'center'" width="100%">重量</th>
					<th data-options="field:'price',align:'center'" width="100%">单价</th>
					<th data-options="field:'goodsMoney',align:'center'" width="100%">货款</th>
					<th id="createDateFieldTh"
						data-options="field:'createdate',align:'center',formatter:formatDate"
						width="100%">操作日期</th>
				</tr>
			</thead>
		</table>

	</div>
	<form id="addForm" action="payed/payedAdd"></form>
	<form id="updateForm" action="payed/payedUpdate" method="get">
		<input type="hidden" id="idInput" name="id"/> 
	</form>
</body>
</html>
