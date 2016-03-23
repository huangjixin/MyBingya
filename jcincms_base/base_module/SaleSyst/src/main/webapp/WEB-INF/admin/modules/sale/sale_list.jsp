<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>sale管理</title>
<%@ include file="/WEB-INF/admin/include/js.jsp"%>
<script type="text/javascript">
	$().ready(function() {
		createDataGrid();
		$('#tgrid').datagrid('getPager').pagination({
			displayMsg : '当前显示从{from}-{to},共{total}条记录'
		});
	});

	function createDataGrid() {
		$('#tgrid').datagrid({
			height : 350,
			pageSize : 10,
			pageList : [ 5, 10, 15, 20 ],
			nowrap : true,
			striped : true,
			collapsible : true,
			url : '${ctxAdmin}/sale/select',
			loadMsg : '数据装载中......',
			method : 'get',
			singleSelect : false,
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
				hidden : true,
				title : 'id',
				align : 'center',
				width : 100
			}, {
				field : 'proId',
				title : 'proId',
				hidden : true,
				align : 'center',
				width : 100
			}, {
				field : 'proName',
				title : '商品名称',
				align : 'center',
				width : 100
			}, {
				field : 'saleNum',
				title : '卖出数量',
				align : 'center',
				width : 100
			}, {
				field : 'saleAmount',
				title : '卖出单价(元)',
				align : 'center',
				width : 100
			}, {
				field : 'totalAmount',
				title : '总额',
				align : 'center',
				width : 100
			}, {
				field : 'createDate',
				title : '日期',
				align : 'center',
				width : 100
			}, {
				field : 'createBy',
				title : '创建人',
				align : 'center',
				width : 100
			}

			] ],
			onBeforeLoad : function(param) {
			},
			onLoadSuccess : function(data) {

			},
			onLoadError : function() {

			},
			onClickCell : function(rowIndex, field, value) {

			},
			onSelect : function(rowIndex, rowData) {

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
			url : '${ctxAdmin}/sale/deleteById',
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
		window.location.href = '${ctxAdmin}/sale/create';
	}

	function update() {
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length == 0) {
			return;
		}

		window.location.href = '${ctxAdmin}/sale/update/' + row[0].id + '';
	}

	function show() {
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length == 0) {
			return;
		}

		window.location.href = '${ctxAdmin}/sale/show/' + row[0].id;
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
		if ($("proIdInput").val() != "") {
			queryParams.proId = $("#proIdInput").val();
		}
		if ($("saleAmountInput").val() != "") {
			queryParams.saleAmount = $("#saleAmountInput").val();
		}
		if ($("totalAmountInput").val() != "") {
			queryParams.totalAmount = $("#totalAmountInput").val();
		}
		if ($("createDateInput").val() != "") {
			queryParams.createDate = $("#createDateInput").val();
		}
		if ($("createByInput").val() != "") {
			queryParams.createBy = $("#createByInput").val();
		}
		if ($("saleNumInput").val() != "") {
			queryParams.saleNum = $("#saleNumInput").val();
		}
		if ($("proNameInput").val() != "") {
			queryParams.proName = $("#proNameInput").val();
		}

		$("#tgrid").datagrid("getPager").pagination({
			pageNumber : 1
		});

		$("#tgrid").datagrid("options").queryParams = queryParams;
		$("#tgrid").datagrid("reload");
	}

	//清除
	function clearSearch() {
		$("#createDateInput").val("");
		$("#proNameInput").val("");
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
		window.open('${ctxAdmin}/sale/exportExcel');
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
				onclick="update();" />  <input type="button" id="searchBtn" value="搜索"
				onclick="search();" /> <input type="button" id="clearBtn"
				value="清除" onclick="clearSearch();" /> <input type="button"
				id="exportBtn" value="导出excel" onclick="exportExcel()" /> <input
				type="button" id="importBtn" value="导入excel" onclick="importExcel()" />
		</div>
		<div style="padding: 5px;border: 0px;">
			<label>日期:</label> <input id="createDateInput"
				onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>商品名称:</label> <input id="proNameInput"
				onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
		</div>
		<table id="tgrid">
		</table>
	</div>
</body>
</html>
