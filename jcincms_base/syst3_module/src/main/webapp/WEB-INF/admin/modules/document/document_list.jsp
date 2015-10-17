<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>document管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="Document列表">
<meta http-equiv="description" content="管理">
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/demo/demo.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/icon.css"/>
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	Date.prototype.format = function(format) {
		var o = {
			"M+" : this.getMonth() + 1, //month
			"d+" : this.getDate(), //day
			"h+" : this.getHours(), //hour
			"m+" : this.getMinutes(), //minute
			"s+" : this.getSeconds(), //second
			"q+" : Math.floor((this.getMonth() + 3) / 3), //quarter
			"S" : this.getMilliseconds()
		//millisecond
		}
		if (/(y+)/.test(format))
			format = format.replace(RegExp.$1, (this.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		for ( var k in o)
			if (new RegExp("(" + k + ")").test(format))
				format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
						: ("00" + o[k]).substr(("" + o[k]).length));
		return format;
	}

	$().ready(function() {
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
			url : '${ctxAdmin}/document/deleteById',
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
		window.location.href='${ctxAdmin}/document/create'; 
	}
	
	function update(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			return;
		}
		
		window.location.href='${ctxAdmin}/document/update/'+row[0].id+''; 
	}
		
	function show(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			return;
		}
		
		window.location.href='${ctxAdmin}/document/show/'+row[0].id; 
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
		if ($("channelIdInput").val() != "") {
			queryParams.channelId = $("#channelIdInput").val();
		}
		if ($("titleInput").val() != "") {
			queryParams.title = $("#titleInput").val();
		}
		if ($("colorInput").val() != "") {
			queryParams.color = $("#colorInput").val();
		}
		if ($("keywordInput").val() != "") {
			queryParams.keyword = $("#keywordInput").val();
		}
		if ($("descInput").val() != "") {
			queryParams.desc = $("#descInput").val();
		}
		if ($("priorityInput").val() != "") {
			queryParams.priority = $("#priorityInput").val();
		}
		if ($("sourceInput").val() != "") {
			queryParams.source = $("#sourceInput").val();
		}
		if ($("sourceAddrInput").val() != "") {
			queryParams.sourceAddr = $("#sourceAddrInput").val();
		}
		if ($("authorInput").val() != "") {
			queryParams.author = $("#authorInput").val();
		}
		if ($("titleImageInput").val() != "") {
			queryParams.titleImage = $("#titleImageInput").val();
		}
		if ($("fileNameInput").val() != "") {
			queryParams.fileName = $("#fileNameInput").val();
		}
		if ($("fileAddrInput").val() != "") {
			queryParams.fileAddr = $("#fileAddrInput").val();
		}
		if ($("sizeInput").val() != "") {
			queryParams.size = $("#sizeInput").val();
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
			$("#channelIdInput").val("");
			$("#titleInput").val("");
			$("#colorInput").val("");
			$("#keywordInput").val("");
			$("#descInput").val("");
			$("#priorityInput").val("");
			$("#sourceInput").val("");
			$("#sourceAddrInput").val("");
			$("#authorInput").val("");
			$("#titleImageInput").val("");
			$("#fileNameInput").val("");
			$("#fileAddrInput").val("");
			$("#sizeInput").val("");
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
		window.open('${ctxAdmin}/document/exportExcel');
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
				onclick="javascript:window.location.href='${ctxAdmin}/document/create'" /> 
			<input type="button"
				value="删除" onclick="deleteRows();" /> 
			<input type="button"
				value="更新" onclick="update();" /> 
			<input type="button"
				value="详情" onclick="show();" /> 
			<input type="button" id="searchBtn" value="搜索" onclick="search();" />
			<input type="button" id="clearBtn" value="清除" onclick="clearSearch();" />
			<input type="button" id="exportBtn" value="导出excel"
				onclick="exportExcel()" /> <input type="button" id="importBtn"
				value="导入excel" onclick="importExcel()" />
		</div>
		<div style="padding: 5px;border: 0px;">
			<label>id:</label>
			<input  id="idInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>channelId:</label>
			<input  id="channelIdInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>title:</label>
			<input  id="titleInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>color:</label>
			<input  id="colorInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>keyword:</label>
			<input  id="keywordInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>desc:</label>
			<input  id="descInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>priority:</label>
			<input  id="priorityInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>source:</label>
			<input  id="sourceInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>sourceAddr:</label>
			<input  id="sourceAddrInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>author:</label>
			<input  id="authorInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>titleImage:</label>
			<input  id="titleImageInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>fileName:</label>
			<input  id="fileNameInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>fileAddr:</label>
			<input  id="fileAddrInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>size:</label>
			<input  id="sizeInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>content:</label>
			<input  id="contentInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
		</div>
		<table id="tgrid" title="" class="easyui-datagrid"
			style="height:350px;"
			data-options="
								pageSize : 10,
								pageList : [ 5, 10, 15, 20 ],
								nowrap : true,
								striped : true,
								collapsible : true,
								url: '${ctxAdmin}/document/select',
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
					<th data-options="field:'channelId',align:'center'" width="100%">channelId</th>
					<th data-options="field:'title',align:'center'" width="100%">title</th>
					<th data-options="field:'color',align:'center'" width="100%">color</th>
					<th data-options="field:'keyword',align:'center'" width="100%">keyword</th>
					<th data-options="field:'desc',align:'center'" width="100%">desc</th>
					<th data-options="field:'priority',align:'center'" width="100%">priority</th>
					<th data-options="field:'source',align:'center'" width="100%">source</th>
					<th data-options="field:'sourceAddr',align:'center'" width="100%">sourceAddr</th>
					<th data-options="field:'author',align:'center'" width="100%">author</th>
					<th data-options="field:'titleImage',align:'center'" width="100%">titleImage</th>
					<th data-options="field:'fileName',align:'center'" width="100%">fileName</th>
					<th data-options="field:'fileAddr',align:'center'" width="100%">fileAddr</th>
					<th data-options="field:'size',align:'center'" width="100%">size</th>
					<th data-options="field:'content',align:'center'" width="100%">content</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>
