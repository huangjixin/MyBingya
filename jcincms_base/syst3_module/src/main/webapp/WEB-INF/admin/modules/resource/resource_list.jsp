<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>资源管理</title>
	<%@ include file="/WEB-INF/admin/include/js.jsp"%>
	<script type="text/javascript">
	$().ready(function() {
		 $('#tgrid').treegrid({  
		    onLoadSuccess:function(node,data){  
		    	$('#tgrid').treegrid("collapseAll");
			}  
		}) 
// 		$('#tgrid').treegrid('collapseAll');
// 		$('#tgrid').treegrid.tree("collapseAll");
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
								url: '${ctxAdmin}/resource/getResourceTree',
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
					<th data-options="field:'name',align:'left'" width="100%">名称</th>
					<!-- <th data-options="field:'description',align:'center'" width="100%">描述</th> -->
					<th data-options="field:'path',align:'center'" width="100%">路径</th>
					<th data-options="field:'parentId',align:'center',hidden:true" width="100%">父亲Id</th>
					<th data-options="field:'type',align:'center',formatter:formatType" width="100%">类型</th>
					<th data-options="field:'authName',align:'center'" width="100%">权限名</th>
					<th data-options="field:'sort',align:'center'" width="100%">序号</th>
					<th data-options="field:'createDate',align:'center'" width="100%">创建日期</th>
					<th data-options="field:'updateDate',align:'center'" width="100%">更新日期</th>
					<th data-options="field:'createBy',align:'center'" width="100%">创建人</th>
					<th data-options="field:'updateBy',align:'center'" width="100%">更新人</th>
				</tr>
			</thead>
		</table>
		<script type="text/javascript">
			function formatType(val,row,index){
				return val=='menu'?'菜单':'按钮';
			}
		</script>
</body>
</html>