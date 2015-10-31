<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>角色管理</title>
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
	$()
			.ready(
					function() {
						$('#tgrid')
								.datagrid(
										{
											pageSize : 10,
											pageList : [ 5, 10, 15, 20 ],
											nowrap : true,
											striped : true,
											collapsible : true,
											url : '${ctxAdmin}/role/select',
											loadMsg : '数据装载中......',
											method : 'get',
											singleSelect : true,
											selectOnCheck : true,
											checkOnSelect : true,
											rownumbers : false,
											treeField : 'name',
											showHeader : true,
											fit : false,
											fitColumns : true,
											pagination : true,
											columns : [ [ {
												field : 'ck',
												checkbox : true
											}, {
												field : 'id',
												align : 'center',
												hidden : true
											}, {
												field : 'name',
												title : '角色名',
												align : 'center',
												width : 100
											} ] ],
											onClickRow : function(index, row) {
												var queryParams = {};
												queryParams.roleId = row.id;
												$('#resourceTree').tree("options").url = '${ctxAdmin}/role/getResourceCheckboxTree?roleId='+ row.id;
												// 	$('#resourceTree').tree("options").queryParams = queryParams;
												$('#resourceTree').tree('reload');
												
												$("#usergrid").datagrid("options").url = '${ctxAdmin}/role/getByRoleId?roleId='+ row.id;;
												$("#usergrid").datagrid("reload");
												
											}
										});

						$('#resourceTree').tree({
							url : '${ctxAdmin}/role/getResourceCheckboxTree',
							method : 'get',
							animate : true,
							checkbox : true
						});
					});

	function connectRoleResource() {
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length == 0) {
			return;
		}

		var nodes = $('#resourceTree').tree('getChecked');
		var s = '';
		for ( var i = 0; i < nodes.length; i++) {
			if (s != '')
				s += ',';
			s += nodes[i].id;
		}

		var pamameter = {};
		pamameter.roleId = row[0].id;
		pamameter.resourceIds = s;

		$.ajax({
			cache : true,
			type : "POST",
			url : '${ctxAdmin}/role/connectRoleResource',
			data : pamameter,
			async : false,
			error : function(request) {
				alert("连接失败");
			},
			success : function(data) {
				alert("授权成功"); // 重新加载;
			}
		});
	}
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
			url : '${ctxAdmin}/role/deleteById',
			data : pamameter,
			async : false,
			error : function(request) {
				alert("连接失败");
			},
			success : function(data) {
				alert("授权成功"); // 重新加载;
			}
		});
	}

	function create() {
		window.location.href = '${ctxAdmin}/role/create';
	}
	function update() {
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length == 0) {
			return;
		}

		window.location.href = '${ctxAdmin}/role/update/' + row[0].id;
	}

	function show() {
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length == 0) {
			return;
		}

		window.location.href = '${ctxAdmin}/role/show/' + row[0].id;
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
		if ($("nameInput").val() != "") {
			queryParams.name = $("#nameInput").val();
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
	}

	//导出excel
	function exportExcel() {
		window.open('${ctxAdmin}/role/exportExcel');
	}

	//导入excel
	function importExcel() {

	}
</script>
</head>
<body class="easyui-layout" data-options="fit:true">
	<div data-options="region:'east',split:true" title="资源"
		style="width:200px;padding:1px;">
		<ul id="resourceTree"></ul>
	</div>
	<div data-options="region:'north'" style="padding:5px;">
		<shiro:hasPermission name="role:create">
				<input type="button" value="添加" id="btn_Add" name="btn_Add" onclick="create();" /> 
			</shiro:hasPermission>
			<shiro:hasPermission name="role:delete">
				<input type="button" value="删除" onclick="deleteRows();" />
			</shiro:hasPermission>
			<shiro:hasPermission name="role:update">
				<input type="button" value="更新" onclick="update();" /> 
			</shiro:hasPermission>
			<shiro:hasPermission name="role:view">
				<input type="button" value="详情" onclick="show();" /> 
			</shiro:hasPermission>
			<input type="button" id="exportBtn"
			value="导出excel" onclick="exportExcel()" /> <input type="button"
			id="importBtn" value="导入excel" onclick="importExcel()" />
		&nbsp;&nbsp;&nbsp;&nbsp; <label>角色名:</label> <input id="nameInput"
			onkeydown="onKeyEnter(event.keyCode||event.which);"> <input
			type="button" id="searchBtn" value="搜索" onclick="search();" /> <input
			type="button" id="clearBtn" value="清除" onclick="clearSearch();" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="授权" onclick="connectRoleResource();" />

	</div>
	<div data-options="region:'center'" title=""
		style="padding:1px;background:#ffffff;">
		<table id="tgrid">
		</table>
		<div style="height: 10px;"></div>
		
		<table id="usergrid" title="" class="easyui-datagrid"
			style="height:350px;"
			data-options="
								pageSize : 10,
								pageList : [ 5, 10, 15, 20 ],
								nowrap : true,
								striped : true,
								loadMsg : '数据装载中......',
								method: 'get',
								rownumbers: false,
								showHeader: true,
								fit:false,
								fitColumns:true,
								pagination : true
							">
			<thead>
				<tr>
					<th id="idFieldTh"
						data-options="field:'id',align:'center',hidden:true" width="100%">id</th>
					<th id="usernameFieldTh"
						data-options="field:'username',align:'center'" width="100%">用户名</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>