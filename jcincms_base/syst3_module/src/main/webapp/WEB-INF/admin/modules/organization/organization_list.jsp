<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>organization管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="Organization列表">
<meta http-equiv="description" content="管理">
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/demo/demo.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/icon.css" />
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
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
		if (row == null || row.length == 0) {
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
			url : '${ctxAdmin}/organization/deleteById',
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

	function create() {
		window.location.href = '${ctxAdmin}/organization/create';
	}

	function update() {
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length == 0) {
			return;
		}

		window.location.href = '${ctxAdmin}/organization/update/' + row[0].id
				+ '';
	}

	function show() {
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length == 0) {
			return;
		}

		window.location.href = '${ctxAdmin}/organization/show/' + row[0].id;
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
		window.open('${ctxAdmin}/organization/exportExcel');
	}

	//导入excel
	function importExcel() {

	}
	
	function onLoadSuccess(row, data){
		alert('dfs');
	}
</script>
</head>

<body class="easyui-layout" data-options="fit:true">
	<div data-options="region:'north'" style="padding:5px;">
						<input type="button" value="添加" id="btn_Add" name="btn_Add"
						onclick="javascript:window.location.href='${ctxAdmin}/organization/create'" />
					<input type="button" value="删除" onclick="deleteRows();" /> <input
						type="button" value="更新" onclick="update();" /> <input
						type="button" value="详情" onclick="show();" /> <input
						type="button" id="searchBtn" value="搜索" onclick="search();" /> <input
						type="button" id="clearBtn" value="清除" onclick="clearSearch();" />
					<input type="button" id="exportBtn" value="导出excel"
						onclick="exportExcel()" /> <input type="button" id="importBtn"
						value="导入excel" onclick="importExcel()" />
	</div>
	<div data-options="region:'center'" title=""
		style="padding:1px;background:#ffffff;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center'" title=""
				style="padding:1px;background:#ffffff;">
				
				<table id="tgrid" title="" class="easyui-datagrid"
					style="height:350px;"
					data-options="
								pageSize : 10,
								pageList : [ 5, 10, 15, 20 ],
								nowrap : true,
								striped : true,
								collapsible : true,
								url: '${ctxAdmin}/organization/select',
								loadMsg : '数据装载中......',
								method: 'get',
								singleSelect : false,
								selectOnCheck: true,
								checkOnSelect: true,
								rownumbers: false,
								treeField: 'name',
								showHeader: true,
								fit:false,
								fitColumns:true
							">
					<thead>
						<tr>
							<th data-options="field:'ck',checkbox:true"></th>
							<th data-options="field:'id',align:'center',hidden:true"
								width="100%">id</th>
							<th data-options="field:'name',align:'center'" width="100%">name</th>
							<th data-options="field:'parentId',align:'center'" width="100%">parentId</th>
							<th data-options="field:'parentIds',align:'center'" width="100%">parentIds</th>
							<th data-options="field:'available',align:'center'" width="100%">available</th>
							<th data-options="field:'createDate',align:'center'" width="100%">createDate</th>
							<th data-options="field:'updateDate',align:'center'" width="100%">updateDate</th>
						</tr>
					</thead>
				</table>
			</div>
			<div data-options="region:'west',split:true" title="组织列表"
				style="width:200px;padding:1px;">
				<ul id="tt" class="easyui-tree" data-options="url:'${ctxAdmin}/organization/getOrganizationTree',method:'get',animate:true,checkbox:true"></ul>	
			</div>
		</div>
	</div>
</body>
</html>
