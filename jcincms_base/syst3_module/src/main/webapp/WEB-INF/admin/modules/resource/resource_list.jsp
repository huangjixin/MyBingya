<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>资源管理</title>
	<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/demo/demo.css"/>
	<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/icon.css"/>
	<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	$().ready(function() {
	});

	// 移除条目；
	function deleteRows(selecedRow) {
		var pamameter = null;
		//多行删除。
		var row = $('#tgrid').treegrid('getSelections');
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
			url : '${ctxAdmin}/resource/deleteById',
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

	function create(){
		window.location.href='${ctxAdmin}/resource/create'; 
	}
	function update(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			return;
		}
		
		window.location.href='${ctxAdmin}/resource/update/'+row[0].id+''; 
	}

	function show(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			return;
		}
		
		window.location.href='${ctxAdmin}/resource/show/'+row[0].id; 
	}
</script>
</head>
<body>
	<div id="toolBar" style="padding: 5px;border: 0px;">
			<shiro:hasPermission name="resource:create">
				<input type="button" value="添加" id="btn_Add" name="btn_Add" onclick="create();" /> 
			</shiro:hasPermission>
			<shiro:hasPermission name="resource:delete">
				<input type="button" value="删除" onclick="deleteRows();" />
			</shiro:hasPermission>
			<shiro:hasPermission name="resource:update">
				<input type="button" value="更新" onclick="update();" /> 
			</shiro:hasPermission>
			<shiro:hasPermission name="resource:view">
				<input type="button" value="详情" onclick="show();" /> 
			</shiro:hasPermission>
		</div>
		<table id="tgrid" title="" class="easyui-treegrid"
			data-options="
								url: '${ctxAdmin}/resource/getResourceTree',
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
					<th data-options="field:'id',align:'center',hidden:true" width="100%">id</th>
					<th data-options="field:'name',align:'center'" width="100%">名称</th>
					<th data-options="field:'description',align:'center'" width="100%">描述</th>
					<th data-options="field:'path',align:'center'" width="100%">路径</th>
					<th data-options="field:'parentId',align:'center'" width="100%">父亲Id</th>
					<th data-options="field:'type',align:'center'" width="100%">类型</th>
					<th data-options="field:'authName',align:'center'" width="100%">权限名</th>
				</tr>
			</thead>
		</table>

</body>
</html>