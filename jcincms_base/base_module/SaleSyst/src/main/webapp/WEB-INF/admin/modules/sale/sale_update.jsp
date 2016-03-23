<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/admin/include/js.jsp"%>
<script type="text/javascript">
	$().ready(function() {
		validateForm();
		createDataGrid();
		
		var cDate = '${sale.createDate}';
		if(cDate!=""){
			$("#createDateInput").datebox("setValue",toDate(cDate));
		}
	});

	function createDataGrid(){
		$('#tgrid').datagrid({
		    height: 200,
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
		        { field: 'id', title: 'id', align: 'center',width:80 },
		        { field: 'name', title: '商品名称', align: 'center',width:80 }
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
		    	$("#proId").val(rowData.id);
				$("#proName").val(rowData.name);
		    }
		});
	}
	
	function validateForm(){
		$("#validForm").validate({
			errorPlacement : function(error,element) {
				$(element).closest("form").find("label[for='"+ element.attr("id")+ "']").append(error);
			},errorElement : "span",
			rules : {
				proName : {
					required : true
				},
				saleNum : {
					required : true,
					number:true 
				},
				saleAmount : {
					required : true,
					number:true
				}
			},messages : {
				proName : {
					required : "必填"
				},
				saleNum : {
					required : "必填"
				},
				saleAmount : {
					required : "必填"
				}
			},
			submitHandler : function(form) {
					return true;
				}
			})
	}
	
	function clearForm(){
		$('#id').val("");
		$('#proId').val("");
		$('#saleAmount').val("");
		$('#totalAmount').val("");
		$('#createDate').val("");
		$('#createBy').val("");
		$('#saleNum').val("");
		$('#proName').val("");
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
	
	function computeTotalAmount(){
		$("#totalAmount").val($("#saleNum").val()*$("#saleAmount").val());
	}
</script>
<title>出货更新</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/sale/update/${sale.id}"
		method="post">
		<input name="id" value="${sale.id}" type="hidden" />
		<div class="desc">
			<b>出货信息更新</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
		</div>
		<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;" />
		<table width="100%" border="0" cellpadding="2" cellspacing="0">
			<tr>
				<td width="100%">
					<table border="0" cellpadding="3" cellspacing="1" width="100%"
						align="center" style="background-color: #b9d8f3;">
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;商品：</th>
							<td nowrap="nowrap" align="left"><input id="proName"
								name="proName" value="${sale.proName}" readonly="true" /> <input
								type="button" value="选择商品" onclick="$('#dlg').dialog('open')" />
								<input id="proId" name="proId" value="${sale.proId}"
								type="hidden" />&nbsp;<label for="proName" style="color:red;">*</label></td>
							<th>&nbsp;卖出数量：</th>
							<td nowrap="nowrap" align="left"><input id="saleNum"
								name="saleNum" value="${sale.saleNum}"
								onchange="computeTotalAmount();" />&nbsp;<label for="saleNum"
								style="color:red;">*</label></td>
							<th>&nbsp;单价（如：XX元/斤）：</th>
							<td nowrap="nowrap" align="left"><input id="saleAmount"
								name="saleAmount" value="${sale.saleAmount}"
								onchange="computeTotalAmount();" />&nbsp;<label
								for="saleAmount" style="color:red;">*</label></td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;总额：</th>
							<td nowrap="nowrap" align="left"><input id="totalAmount"
								name="totalAmount" value="${sale.totalAmount}" readonly="true" />&nbsp;元&nbsp;<label
								for="totalAmount" style="color:red;">*</label></td>
							<th>销售日期:</th>
							<td nowrap="nowrap" align="left"><input id="createDateInput" class="easyui-datebox"></td>
							<th></th>
							<td></td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th style="width: 150px;">&nbsp;</th>
							<td style="text-align: left;" colspan="6"><input
								type="submit" value="保存" />&nbsp;&nbsp;<input type="reset"
								value="重置" />&nbsp;&nbsp;<input type="button" value="清空"
								onclick="clearForm();" />&nbsp;&nbsp;<input type="button"
								value="返回"
								onclick="javascript:window.location.href='${ctxAdmin}/sale'" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
	<div id="dlg" class="easyui-dialog" title="文档选择"
		data-options="iconCls:'icon-save',closed: true"
		style="width:600px;height:350px;padding:10px">
		<div style="padding: 5px;border: 0px;">
			<label>商品名称:</label> <input id="nameInput"
				onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<input type="button" id="searchBtn" value="搜索" onclick="search();" />
			<input type="button" id="clearBtn" value="清除"
				onclick="clearSearch();" />
		</div>
		<table id="tgrid">
		</table>
	</div>
</body>
</html>