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

<title>mysql日志</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="mysql,mysql list">
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
	function deleteRows() {
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

		var pamameter = {
			idstring : string
		};
		$.ajax({
			cache : true,
			type : "POST",
			url : 'mysql/deleteById',
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

		if ($("#nameInput").val() != "") {
			queryParams.name = $("#nameInput").val();
		}

		if ($("#operatorInput").val() != "") {
			queryParams.operator = $("#operatorInput").val();
		}
		if ($("#ipInput").val() != "") {
			queryParams.operator = $("#operatorInput").val();
		}

		$("#tgrid").datagrid("getPager").pagination({
			pageNumber : 1
		});

		$("#tgrid").datagrid("options").queryParams = queryParams;
		$("#tgrid").datagrid("reload");
	}

	//清除
	function clearSearch() {
		$("#nameInput").val("");
		$("#operatorInput").val("");
		$("#ipInput").val("");
	}

	//格式化用户状态显示。
	function formatDate(val, row) {
		var date = new Date();
		date.setTime(val);
		var result = date.format("yyyy-MM-dd hh:mm:ss");

		return result;
	}

	//导出excel
	function exportExcel() {
		var pamameter = $("#tgrid").datagrid("options").queryParams;
		$.ajax({
			cache : true,
			type : "GET",
			url : "mysql/exportExcel",
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

	//导入excel
	function importExcel() {

	}

	//备份
	function backup() {
		$.ajax({
			cache : true,
			type : "GET",
			url : "mysql/backup",
			async : false,
			error : function(request) {
				alert("连接失败");
			},
			success : function(data) {
				$("#tgrid").datagrid("reload");
			}
		});
	}

	//还原。
	function restore() {
		var row = $("#tgrid").datagrid("getSelected");
		if(row == null){
			return;
		}
		var pamameter = {
			path : row.path
		};
		alert(row.path);
		$.ajax({
			cache : true,
			type : "GET",
			url : "mysql/restore",
			async : false,
			data : pamameter,
			error : function(request) {
				alert("连接失败");
			},
			success : function(data) {
				$("#tgrid").datagrid("reload");
			}
		});
	}
</script>
</head>

<body class="easyui-layout" data-options="fit:true">
	<!-- 	<div data-options="region:'north'" style="padding:0px;"></div> -->
	<div data-options="region:'center'" title=""
		style="padding:0px;background:#ffffff;">
		<div id="toolBar" style="padding: 5px;border: 0px;">
			<input type="button" value="删除" onclick="deleteRows()" /> <label>名称:</label><input
				id="nameInput" onkeydown="onKeyEnter(event.keyCode||event.which);">
			<label>操作人:</label><input id="operatorInput"
				onkeydown="onKeyEnter(event.keyCode||event.which);"> <label>IP:</label><input
				id="ipInput" onkeydown="onKeyEnter(event.keyCode||event.which);">
			<input type="button" id="searchBtn" value="搜索" onclick="search()" />
			<input type="button" id="clearBtn" value="清除" onclick="clearSearch()" />
			<input type="button" id="exportBtn" value="导出excel"
				onclick="exportExcel()" /> <input type="button" id="importBtn"
				value="导入excel" onclick="importExcel()" /> <input type="button"
				id="backupBtn" value="备份" onclick="backup()" /> <input
				type="button" id="restoreBtn" value="还原" onclick="restore()" />
		</div>
		<table id="tgrid" title="" class="easyui-datagrid"
			style="height:350px;"
			data-options="
								pageSize : 10,
								pageList : [ 5, 10, 15, 20 ],
								nowrap : true,
								striped : true,
								collapsible : true,
								url: 'mysql/select',
								loadMsg : '数据装载中......',
								method: 'get',
								singleSelect : false,
								selectOnCheck: true,
								checkOnSelect: true,
								rownumbers: false,
								showHeader: true,
								fit:false,
								fitColumns:true,
								pagination : true
							">
			<thead>
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<th id="idFieldTh" data-options="field:'id',align:'center'"
						width="100%">ID</th>
					<th id="sqlnameFieldTh"
						data-options="field:'sqlname',align:'center'" width="100%">名称</th>
					<th id="operatorFieldTh"
						data-options="field:'operator',align:'center'" width="100%">操作人</th>
					<th id="pathFieldTh" data-options="field:'path',align:'center'"
						width="100%">全路径</th>
					<th id="createDateFieldTh"
						data-options="field:'createdate',align:'center',formatter:formatDate"
						width="100%">修改日期</th>
				</tr>
			</thead>
		</table>

	</div>
</body>
</html>
