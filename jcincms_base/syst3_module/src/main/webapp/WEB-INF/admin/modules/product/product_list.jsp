<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>product管理</title>
<%@ include file="/WEB-INF/admin/include/js.jsp"%>
<script type="text/javascript">
	$().ready(function() {
		createDataGrid();
		$('#tgrid').datagrid('getPager').pagination({displayMsg:'当前显示从{from}-{to},共{total}条记录'});
	});

	function createDataGrid(){
		$('#tgrid').datagrid({
		    height: 350,
		    pageSize : 10,
			pageList : [ 5, 10, 15, 20 ],
			nowrap : true,
			striped : true,
			collapsible : true,
			url: '${ctxAdmin}/product/select',
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
			pagination : true,
		    columns: [[
		        { field: 'ck', checkbox: true },
		        		{ field: 'id',hidden:true, title: 'id', align: 'center',width:80 }
		        	,
		        		{ field: 'name',title: 'name', align: 'center',width:80 }
		        	,
		        		{ field: 'proBrand_id',title: 'proBrand_id', align: 'center',width:80 }
		        	,
		        		{ field: 'createDate',title: 'createDate', align: 'center',width:80 }
		        	,
		        		{ field: 'updateDate',title: 'updateDate', align: 'center',width:80 }
		        	,
		        		{ field: 'content',title: 'content', align: 'center',width:80 }
		        	
		    ]],
		    onBeforeLoad: function (param) {
		    },
		    onLoadSuccess: function (data) {
		        
		    },
		    onLoadError: function () {
		        
		    },
		    onClickCell: function (rowIndex, field, value) {
		        
		    },
		    onSelect:function (rowIndex, rowData){
		    	
		    }
		});
	}
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
			url : '${ctxAdmin}/product/deleteById',
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
		window.location.href='${ctxAdmin}/product/create'; 
	}
	
	function update(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			return;
		}
		
		window.location.href='${ctxAdmin}/product/update/'+row[0].id+''; 
	}
		
	function show(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			return;
		}
		
		window.location.href='${ctxAdmin}/product/show/'+row[0].id; 
	}
	
	//处理事件的函数
	function onKeyEnter(e) {
		if (e == 13 || e == 32) {
			search();
			e.returnValue = false;
		}
	}

	//搜索
	function search() {
		var queryParams = {};
		if ($("idInput").val() != "") {
			queryParams.id = $("#idInput").val();
		}
		if ($("nameInput").val() != "") {
			queryParams.name = $("#nameInput").val();
		}
		if ($("proBrand_idInput").val() != "") {
			queryParams.proBrand_id = $("#proBrand_idInput").val();
		}
		if ($("createDateInput").val() != "") {
			queryParams.createDate = $("#createDateInput").val();
		}
		if ($("updateDateInput").val() != "") {
			queryParams.updateDate = $("#updateDateInput").val();
		}
		if ($("contentInput").val() != "") {
			queryParams.content = $("#contentInput").val();
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
			$("#nameInput").val("");
			$("#proBrand_idInput").val("");
			$("#createDateInput").val("");
			$("#updateDateInput").val("");
			$("#contentInput").val("");
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
		window.open('${ctxAdmin}/product/exportExcel');
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
			<shiro:hasPermission name="product:create">
				<input type="button" value="添加" id="btn_Add" name="btn_Add" onclick="create();" /> 
			</shiro:hasPermission>
			<shiro:hasPermission name="product:delete">
				<input type="button" value="删除" onclick="deleteRows();" />
			</shiro:hasPermission>
			<shiro:hasPermission name="product:update">
				<input type="button" value="查看" onclick="update();" /> 
			</shiro:hasPermission>
			<!--<shiro:hasPermission name="product:view">
				<input type="button" value="详情" onclick="show();" /> 
			</shiro:hasPermission>-->
			<input type="button" id="searchBtn" value="搜索" onclick="search();" />
			<input type="button" id="clearBtn" value="清除" onclick="clearSearch();" />
			<input type="button" id="exportBtn" value="导出excel"
				onclick="exportExcel()" /> <input type="button" id="importBtn"
				value="导入excel" onclick="importExcel()" />
		</div>
		<div style="padding: 5px;border: 0px;">
			<label>id:</label>
			<input  id="idInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>name:</label>
			<input  id="nameInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>proBrand_id:</label>
			<input  id="proBrand_idInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>createDate:</label>
			<input  id="createDateInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>updateDate:</label>
			<input  id="updateDateInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>content:</label>
			<input  id="contentInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
		</div>
		<table id="tgrid">
		</table>
	</div>
</body>
</html>
