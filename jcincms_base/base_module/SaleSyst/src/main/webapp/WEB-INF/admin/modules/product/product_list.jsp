<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>商品管理</title>
<%@ include file="/WEB-INF/admin/include/js.jsp"%>
<script type="text/javascript">
	$().ready(function() {
		createDataGrid();
		$('#tgrid').datagrid('getPager').pagination({
			displayMsg : '当前显示从{from}-{to},共{total}条记录'
		});
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
			showHeader: true,
			fit:false,
			fitColumns:true,
			pagination : true,
		    columns: [[
		        { field: 'ck', checkbox: true },
		        { field: 'id',hidden:true, title: 'id', align: 'center',width:80 },
		        { field: 'name', title: '商品名称', align: 'center',width:80 },
		       // { field: 'procount', title: '库存', align: 'center',width:80 },
		        { field: 's_total_amount', title: '销售总额', align: 'center',width:80 },
		        { field: 'b_total_amount', title: '总成本', align: 'center',width:80 },
		        { field: 'createDate', title: '录入日期', align: 'center',width:80 }
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

	function create() {
		window.location.href = '${ctxAdmin}/product/create';
	}

	function update() {
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length == 0) {
			return;
		}

		window.location.href = '${ctxAdmin}/product/update/' + row[0].id + '';
	}

	function show() {
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length == 0) {
			return;
		}

		window.location.href = '${ctxAdmin}/product/show/' + row[0].id;
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
		if ($("beginDateInput").val() != "") {
			queryParams.beginDate = $('#beginDateInput').datebox('getValue');//$("#beginDateInput").val();
		}
		if ($("endDateInput").val() != "") {
			queryParams.endDate = $('#endDateInput').datebox('getValue');//$("#endDateInput").val();
		}
		
// 		queryParams.countTotal = document.getElementById("countTotal").checked;

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
			<input type="button" value="添加" id="btn_Add" name="btn_Add"
				onclick="create();" /> <input type="button" value="删除"
				onclick="deleteRows();" /> <input type="button" value="更新"
				onclick="update();" /> <input type="button" value="营业详情"
				onclick="show();" /> <input type="button" id="searchBtn" value="搜索"
				onclick="search();" /> <input type="button" id="clearBtn"
				value="清除" onclick="clearSearch();" /> <!-- <input type="button"
				id="exportBtn" value="导出excel" onclick="exportExcel()" /> -->
		</div>
		<div style="padding: 5px;border: 0px;">
			<label>商品名称:</label> <input id="nameInput"
				onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>开始日期:</label> <input id="beginDateInput"  class="easyui-datetimebox"
				onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>结束日期:</label> <input id="endDateInput"  class="easyui-datetimebox"
				onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<!-- <label><input id="countTotal" name="countTotal" type="checkbox" />算总账 </label>  -->
		</div>
		<table id="tgrid">
		</table>
	</div>
</body>
</html>
