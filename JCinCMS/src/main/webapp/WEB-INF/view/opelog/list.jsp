<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>操作日志</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="menu,menu list">
<meta http-equiv="description" content="菜单列表">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui/dwrloader.js"></script>
<script type="text/javascript" src="js/jquery-easyui/easyloader.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="js//ajaxfileupload.css">
<style type="text/css">
.table {
	border-collapse: collapse;
}

.tr1 {
	width: 100px;
	text-align: right;
	background-color: #F7F7F7;
}

.th1 {
	width: 100px;
	background-color: #F7F7F7;
	text-align: right;
	padding-right: 2px;
	background-color: #F7F7F7;
	font-weight: normal;
}

.td1 {
	width: 250px;
	background-color: #ffffff;
	text-align: left;
	width: 200px;
	padding-left: 2px;
}
</style>
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

	function refreshRows() {
		$("#tgrid").datagrid('reload'); // 重新加载;
	}

	// 移除条目；
	function deleteRows() {
		//多行删除。
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null) {
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

		var pamameter = {
			idstring : string
		};
		$.ajax({
			cache : true,
			type : "POST",
			url : 'opelog/deleteById',
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

		if ($("#nameInput").val() != "") {
			queryParams.name = $("#nameInput").val();
		}

		if ($("#operatorInput").val() != "") {
			queryParams.operator = $("#operatorInput").val();
		}
		if ($("#ipInput").val() != "") {
			queryParams.operator = $("#operatorInput").val();
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
		$("#operatorInput").val("");
		$("#ipInput").val("");
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
		var pamameter = $("#tgrid").datagrid("options").queryParams;
		var param = "?";
		param += "name=" + $("#nameInput").val();
		param += "&operator=" + $("#operatorInput").val();
		param += "&ip=" + $("#ipInput").val();
		var url = "opelog/exportExcel" + param;
		window.open(url);
	}

	//导入excel
	function importExcel() {
		$("#file").fileupload();
	}

	function submit() {
		$.ajaxFileUpload({
			url : "opelog/importExcel",
			fileElementId : "uFile",
			success : function(data, status) {
				//alert(123);
			},
			error : function(data, status) {
				//alert(456);
			}
		});
	}

	function onfilechange() {
		var options = {
			//         target:        '#output',   // target element(s) to be updated with server response 
			// 			beforeSubmit : showRequest, // pre-submit callback 
			success : onexcelToList,
			// post-submit callback 

			// other available options: 
			url : "opelog/excelToList", // override for form's 'action' attribute 
		//type:      type        // 'get' or 'post', override for form's 'method' attribute 
		// 		dataType:  json        // 'xml', 'script', or 'json' (expected server response type) 
		//clearForm: true        // clear all form fields after successful submit 
		//resetForm: true        // reset the form after successful submit 

		// $.ajax options can be used here too, for example: 
		//timeout:   3000 
		};
		$("#fileForm").ajaxSubmit(options);
	}

	function onexcelToList(result) {
		var data = {
			total : result.length,
			rows : [ result ]
		};
		$("#tgrid").datagrid("loadData", result);
	}

	function openfile() {
		try {
			var fd = new ActiveXObject("MSComDlg.CommonDialog");
			fd.Filter = "图像文件 (*.jpg;*.jpeg;*.gif)|*.jpg;*.jpeg;*.gif";
			fd.FilterIndex = 2;
			// 必须设置MaxFileSize. 否则出错
			fd.MaxFileSize = 128;
			fd.ShowOpen();
			document.getElementById("txtFileName").value = fd.Filename;
			document.getElementById("textImage").src = fd.FileName;
		} catch (e) {
			alert("你的浏览器不支持ActiveX！\r\n请启用ActiveX后重试．");
			document.getElementById("txtFileName").value = "";
		}
	}
</script>
</head>

<body class="easyui-layout" data-options="fit:true">
	<!-- 	<div data-options="region:'north'" style="padding:0px;"></div> -->
	<div data-options="region:'center'" title=""
		style="padding:0px;background:#ffffff;">
		<div id="toolBar" style="padding: 5px;border: 0px;">
			<input type="button" value="删除" onclick="deleteRows()" /> <input
				type="button" value="刷新" onclick="refreshRows()" /><label>名称:</label><input
				id="nameInput" onkeydown="onKeyEnter(event.keyCode||event.which);">
			<label>操作人:</label><input id="operatorInput"
				onkeydown="onKeyEnter(event.keyCode||event.which);"> <label>IP:</label><input
				id="ipInput" onkeydown="onKeyEnter(event.keyCode||event.which);">
			<input type="button" id="searchBtn" value="搜索" onclick="search()" />
			<input type="button" id="clearBtn" value="清除" onclick="clearSearch()" />
			<input type="button" id="exportBtn" value="导出excel"
				onclick="exportExcel();" />
			<!-- 				<input type="button" id="submittBtn" -->
			<!-- 				value="提交" onclick="importExcel();" /> -->
			<!-- 			<form id="fileForm" method="POST" enctype="multipart/form-data" -->
			<!-- 				action="opelog/importExcel"> -->
			<input type="button" value="导入excel"
				onclick="return $('#file').click();" /> <input type="file"
				id="file" name="file" value="" style="width: 0px;height: 0px;"
				onchange="onfilechange();" accept=".xls"> <input type="submit" value="提交">
			<!-- 			</form> -->

		</div>
		<table id="tgrid" title="" class="easyui-datagrid"
			style="height:350px;"
			data-options="
								pageSize : 10,
								pageList : [ 5, 10, 15, 20 ],
								nowrap : true,
								striped : true,
								collapsible : true,
								url: 'opelog/select',
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
					<th id="nameFieldTh" data-options="field:'name',align:'left'"
						width="100%">名称</th>
					<th id="operatorFieldTh"
						data-options="field:'operator',align:'center'" width="100%">操作人</th>
					<th id="createDateFieldTh"
						data-options="field:'createdate',align:'center',formatter:formatDate"
						width="100%">修改日期</th>
				</tr>
			</thead>
		</table>

	</div>
</body>
</html>
