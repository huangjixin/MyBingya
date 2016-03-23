<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>fruitRecord管理</title>
<%@ include file="/WEB-INF/admin/include/js.jsp"%>
<script type="text/javascript">
	$().ready(function() {
		$('#tgrid').datagrid('getPager').pagination({displayMsg:'当前显示从{from}-{to},共{total}条记录'});
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
			url : '${ctxAdmin}/fruitRecord/deleteById',
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

	function create(){
		window.location.href='${ctxAdmin}/fruitRecord/create'; 
	}
	
	function update(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			return;
		}
		
		window.location.href='${ctxAdmin}/fruitRecord/update/'+row[0].id+''; 
	}
		
	function show(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			return;
		}
		
		window.location.href='${ctxAdmin}/fruitRecord/show/'+row[0].id; 
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
		if ($("idInput").val() != "") {
			queryParams.id = $("#idInput").val();
		}
		if ($("resultInput").val() != "") {
			queryParams.result = $("#resultInput").val();
		}
		if ($("createDateInput").val() != "") {
			queryParams.createDate = $("#createDateInput").val();
		}
		if ($("createByInput").val() != "") {
			queryParams.createBy = $("#createByInput").val();
		}
		if ($("updateDateInput").val() != "") {
			queryParams.updateDate = $("#updateDateInput").val();
		}
		if ($("updateByInput").val() != "") {
			queryParams.updateBy = $("#updateByInput").val();
		}
		if ($("descriptionInput").val() != "") {
			queryParams.description = $("#descriptionInput").val();
		}

		$("#tgrid").datagrid("getPager").pagination({
			pageNumber : 1
		});

		$("#tgrid").datagrid("options").queryParams = queryParams;
		$("#tgrid").datagrid("reload");
	}

	//清除
	function clearSearch() {
			$("#idInput").val("");
			$("#resultInput").val("");
			$("#createDateInput").val("");
			$("#createByInput").val("");
			$("#updateDateInput").val("");
			$("#updateByInput").val("");
			$("#descriptionInput").val("");
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
		window.open('${ctxAdmin}/fruitRecord/exportExcel');
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
			<shiro:hasPermission name="fruitRecord:create">
				<input type="button" value="添加" id="btn_Add" name="btn_Add" onclick="create();" /> 
			</shiro:hasPermission>
			<shiro:hasPermission name="fruitRecord:delete">
				<input type="button" value="删除" onclick="deleteRows();" />
			</shiro:hasPermission>
			<shiro:hasPermission name="fruitRecord:update">
				<input type="button" value="更新" onclick="update();" /> 
			</shiro:hasPermission>
			<shiro:hasPermission name="fruitRecord:view">
				<input type="button" value="详情" onclick="show();" /> 
			</shiro:hasPermission>
			<input type="button" id="searchBtn" value="搜索" onclick="search();" />
			<input type="button" id="clearBtn" value="清除" onclick="clearSearch();" />
			<input type="button" id="exportBtn" value="导出excel"
				onclick="exportExcel()" /> <input type="button" id="importBtn"
				value="导入excel" onclick="importExcel()" />
		</div>
		<div style="padding: 5px;border: 0px;">
			<label>id:</label>
			<input  id="idInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>result:</label>
			<input  id="resultInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>createDate:</label>
			<input  id="createDateInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>createBy:</label>
			<input  id="createByInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>updateDate:</label>
			<input  id="updateDateInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>updateBy:</label>
			<input  id="updateByInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>description:</label>
			<input  id="descriptionInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
		</div>
		<table id="tgrid" title="" class="easyui-datagrid"
			style="height:350px;"
			data-options="
								pageSize : 10,
								pageList : [ 5, 10, 15, 20 ],
								nowrap : true,
								striped : true,
								collapsible : true,
								url: '${ctxAdmin}/fruitRecord/select',
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
					<th data-options="field:'id',align:'center'" width="100%">id</th>
					<th data-options="field:'result',align:'center'" width="100%">result</th>
					<th data-options="field:'createDate',align:'center'" width="100%">createDate</th>
					<th data-options="field:'createBy',align:'center'" width="100%">createBy</th>
					<th data-options="field:'updateDate',align:'center'" width="100%">updateDate</th>
					<th data-options="field:'updateBy',align:'center'" width="100%">updateBy</th>
					<th data-options="field:'description',align:'center'" width="100%">description</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>
