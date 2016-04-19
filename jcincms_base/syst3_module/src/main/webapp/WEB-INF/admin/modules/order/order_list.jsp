<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>order管理</title>
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
			url: '${ctxAdmin}/order/select',
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
		        		{ field: 'serialnumber',title: 'serialnumber', align: 'center',width:80 }
		        	,
		        		{ field: 'ordercol',title: 'ordercol', align: 'center',width:80 }
		        	,
		        		{ field: 'createDate',title: 'createDate', align: 'center',width:80 }
		        	,
		        		{ field: 'updateDate',title: 'updateDate', align: 'center',width:80 }
		        	,
		        		{ field: 'paytime',title: 'paytime', align: 'center',width:80 }
		        	,
		        		{ field: 'logistics',title: 'logistics', align: 'center',width:80 }
		        	,
		        		{ field: 'status',title: 'status', align: 'center',width:80 }
		        	,
		        		{ field: 'title',title: 'title', align: 'center',width:80 }
		        	,
		        		{ field: 'counts',title: 'counts', align: 'center',width:80 }
		        	,
		        		{ field: 'price',title: 'price', align: 'center',width:80 }
		        	,
		        		{ field: 'amount',title: 'amount', align: 'center',width:80 }
		        	,
		        		{ field: 'realAmount',title: 'realAmount', align: 'center',width:80 }
		        	,
		        		{ field: 'disAmount',title: 'disAmount', align: 'center',width:80 }
		        	,
		        		{ field: 'postage',title: 'postage', align: 'center',width:80 }
		        	,
		        		{ field: 'hasPostage',title: 'hasPostage', align: 'center',width:80 }
		        	,
		        		{ field: 'buyerIp',title: 'buyerIp', align: 'center',width:80 }
		        	,
		        		{ field: 'buyerAddr',title: 'buyerAddr', align: 'center',width:80 }
		        	
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
			url : '${ctxAdmin}/order/deleteById',
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
		window.location.href='${ctxAdmin}/order/create'; 
	}
	
	function update(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			return;
		}
		
		window.location.href='${ctxAdmin}/order/update/'+row[0].id+''; 
	}
		
	function show(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			return;
		}
		
		window.location.href='${ctxAdmin}/order/show/'+row[0].id; 
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
		if ($("serialnumberInput").val() != "") {
			queryParams.serialnumber = $("#serialnumberInput").val();
		}
		if ($("ordercolInput").val() != "") {
			queryParams.ordercol = $("#ordercolInput").val();
		}
		if ($("createDateInput").val() != "") {
			queryParams.createDate = $("#createDateInput").val();
		}
		if ($("updateDateInput").val() != "") {
			queryParams.updateDate = $("#updateDateInput").val();
		}
		if ($("paytimeInput").val() != "") {
			queryParams.paytime = $("#paytimeInput").val();
		}
		if ($("logisticsInput").val() != "") {
			queryParams.logistics = $("#logisticsInput").val();
		}
		if ($("statusInput").val() != "") {
			queryParams.status = $("#statusInput").val();
		}
		if ($("titleInput").val() != "") {
			queryParams.title = $("#titleInput").val();
		}
		if ($("countsInput").val() != "") {
			queryParams.counts = $("#countsInput").val();
		}
		if ($("priceInput").val() != "") {
			queryParams.price = $("#priceInput").val();
		}
		if ($("amountInput").val() != "") {
			queryParams.amount = $("#amountInput").val();
		}
		if ($("realAmountInput").val() != "") {
			queryParams.realAmount = $("#realAmountInput").val();
		}
		if ($("disAmountInput").val() != "") {
			queryParams.disAmount = $("#disAmountInput").val();
		}
		if ($("postageInput").val() != "") {
			queryParams.postage = $("#postageInput").val();
		}
		if ($("hasPostageInput").val() != "") {
			queryParams.hasPostage = $("#hasPostageInput").val();
		}
		if ($("buyerIpInput").val() != "") {
			queryParams.buyerIp = $("#buyerIpInput").val();
		}
		if ($("buyerAddrInput").val() != "") {
			queryParams.buyerAddr = $("#buyerAddrInput").val();
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
			$("#serialnumberInput").val("");
			$("#ordercolInput").val("");
			$("#createDateInput").val("");
			$("#updateDateInput").val("");
			$("#paytimeInput").val("");
			$("#logisticsInput").val("");
			$("#statusInput").val("");
			$("#titleInput").val("");
			$("#countsInput").val("");
			$("#priceInput").val("");
			$("#amountInput").val("");
			$("#realAmountInput").val("");
			$("#disAmountInput").val("");
			$("#postageInput").val("");
			$("#hasPostageInput").val("");
			$("#buyerIpInput").val("");
			$("#buyerAddrInput").val("");
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
		window.open('${ctxAdmin}/order/exportExcel');
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
			<shiro:hasPermission name="order:create">
				<input type="button" value="添加" id="btn_Add" name="btn_Add" onclick="create();" /> 
			</shiro:hasPermission>
			<shiro:hasPermission name="order:delete">
				<input type="button" value="删除" onclick="deleteRows();" />
			</shiro:hasPermission>
			<shiro:hasPermission name="order:update">
				<input type="button" value="查看" onclick="update();" /> 
			</shiro:hasPermission>
			<!--<shiro:hasPermission name="order:view">
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
			<label>serialnumber:</label>
			<input  id="serialnumberInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>ordercol:</label>
			<input  id="ordercolInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>createDate:</label>
			<input  id="createDateInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>updateDate:</label>
			<input  id="updateDateInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>paytime:</label>
			<input  id="paytimeInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>logistics:</label>
			<input  id="logisticsInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>status:</label>
			<input  id="statusInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>title:</label>
			<input  id="titleInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>counts:</label>
			<input  id="countsInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>price:</label>
			<input  id="priceInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>amount:</label>
			<input  id="amountInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>realAmount:</label>
			<input  id="realAmountInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>disAmount:</label>
			<input  id="disAmountInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>postage:</label>
			<input  id="postageInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>hasPostage:</label>
			<input  id="hasPostageInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>buyerIp:</label>
			<input  id="buyerIpInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>buyerAddr:</label>
			<input  id="buyerAddrInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
		</div>
		<table id="tgrid">
		</table>
	</div>
</body>
</html>
