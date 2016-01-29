<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>文件管理</title>
	<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/demo/demo.css"/>
	<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/icon.css"/>
	<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	$().ready(function() {
		 $('#tgrid').treegrid({  
		    onLoadSuccess:function(node,data){  
		    	$('#tgrid').treegrid("collapseAll");
			}  
		}) 
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
	
	function up(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			$("#tooltip")[0].innerHTML="请选择一个节点";
			return;
		}else{
			$("#tooltip")[0].innerHTML="";
		}
		$.ajax({
			cache : true,
			url : '${ctxAdmin}/resource/toUp?id='+row[0].id,
			async : false,
			error : function(request) {
				alert("连接失败");
			},
			success : function(data) {
				$("#tooltip")[0].innerHTML="操作成功"; // 重新加载;
				$('#tgrid').datagrid('clearSelections');
				$('#tgrid').treegrid('reload');
			}
		});
		
	}

	function down(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			$("#tooltip")[0].innerHTML="请选择一个节点";
			return;
		}else{
			$("#tooltip")[0].innerHTML="";
		}
		$.ajax({
			cache : true,
			url : '${ctxAdmin}/resource/toDown?id='+row[0].id,
			async : false,
			error : function(request) {
				alert("连接失败");
			},
			success : function(data) {
				$("#tooltip")[0].innerHTML="操作成功"; // 重新加载;
				$('#tgrid').datagrid('clearSelections');
				$('#tgrid').treegrid('reload');
			}
		});
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
			<shiro:hasPermission name="resource:update">
				<input type="button" value="上升" onclick="up();" /> 
			</shiro:hasPermission>
			<shiro:hasPermission name="resource:update">
				<input type="button" value="下降" onclick="down();" /> 
			</shiro:hasPermission>
			&nbsp;&nbsp;<span id="tooltip" style="color: red;"></span>
		</div>
		<table id="tgrid" title="" class="easyui-treegrid"
			data-options="
								url: '${ctxAdmin}/document/getWebsiteFiles?refresh=true',
								method: 'get',
								rownumbers: false,
								idField: 'id',
								collapsible:true,
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
				</tr>
			</thead>
		</table>
</body>
</html>