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

<title>menu管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="user,user list,Menu列表">
<meta http-equiv="description" content="管理">
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
		//多行删除。
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
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

		if (pamameter == null) {
			return;
		}
		$.ajax({
			cache : true,
			type : "POST",
			url : 'menu/deleteById',
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

	function update(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			return;
		}
		
		window.location.href='<%=basePath%>menu/edit/'+row[0].id; 
	}

	function show(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			return;
		}
		
		window.location.href='<%=basePath%>menu/'+row[0].id; 
	}
	//处理事件的函数
	function onKeyEnter(e) {
		if (e == 13 || e == 32) {
			search();
			e.returnValue = false;
			//返回false，在没有使用document.loginForm.submit()时可用于取消提交
		}
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
		window.open('<%=basePath%>menu/exportExcel');
	}

	//导入excel
	function importExcel() {

	}
</script>
</head>

<body class="easyui-layout" data-options="fit:true">
	<!-- 	<div data-options="region:'north'" style="padding:0px;"></div> -->
	<div data-options="region:'center'" title=""
		style="padding:0px;background:#ffffff;">
		<div id="toolBar" style="padding: 5px;border: 0px;">
			<input type="button" value="添加" id="btn_Add" name="btn_Add"
				onclick="javascript:window.location.href='menu/new'" /> 
			<input type="button"
				value="删除" onclick="deleteRows()" /> 
			<input type="button"
				value="更新" onclick="update()" /> 
			<input type="button"
				value="详情" onclick="show()" /> 
			<input type="button" id="searchBtn" value="搜索" onclick="search()" />
			<input type="button" id="clearBtn" value="清除" onclick="clearSearch()" />
			<input type="button" id="exportBtn" value="导出excel"
				onclick="exportExcel()" /> <input type="button" id="importBtn"
				value="导入excel" onclick="importExcel()" />
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
								fitColumns:true
							">
			<thead>
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<th id="nameFieldTh"
						data-options="field:'name',align:'center'" width="100%">name</th>
					<th id="descriptionFieldTh"
						data-options="field:'description',align:'center'" width="100%">description</th>
					<th id="pathFieldTh"
						data-options="field:'path',align:'center'" width="100%">path</th>
					<th id="parentIdFieldTh"
						data-options="field:'parentId',align:'center'" width="100%">parentId</th>
					<th id="createDateFieldTh"
						data-options="field:'createDate',align:'center'" width="100%">createDate</th>
					<th id="iconFieldTh"
						data-options="field:'icon',align:'center'" width="100%">icon</th>
					<th id="updateDateFieldTh"
						data-options="field:'updateDate',align:'center'" width="100%">updateDate</th>
					<th id="urlFieldTh"
						data-options="field:'url',align:'center'" width="100%">url</th>
				</tr>
			</thead>
		</table>

	</div>
	<form id="addForm" action="menu/new"></form>
	<form id="updateForm" action="menu/edit"></form>
</body>
</html>
