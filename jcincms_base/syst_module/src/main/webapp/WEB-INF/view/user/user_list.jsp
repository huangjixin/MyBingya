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

<title>用户管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="user,user list,User列表">
<meta http-equiv="description" content="管理">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui/themes/icon.css">
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
			url : 'user/deleteById',
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

	function update(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			return;
		}
		
		window.location.href='<%=basePath%>user/edit/'+row[0].id; 
	}

	function show(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			return;
		}
		
		window.location.href='<%=basePath%>user/'+row[0].id; 
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
		if ($("usernameInput").val() != "") {
			queryParams.username = $("#usernameInput").val();
		}
		if ($("passwordInput").val() != "") {
			queryParams.password = $("#passwordInput").val();
		}
		if ($("statusInput").val() != "") {
			queryParams.status = $("#statusInput").val();
		}
		if ($("descriptionInput").val() != "") {
			queryParams.description = $("#descriptionInput").val();
		}
		if ($("enabledInput").val() != "") {
			queryParams.enabled = $("#enabledInput").val();
		}
		if ($("createDateInput").val() != "") {
			queryParams.createDate = $("#createDateInput").val();
		}
		if ($("updateDateInput").val() != "") {
			queryParams.updateDate = $("#updateDateInput").val();
		}
		if ($("ipInput").val() != "") {
			queryParams.ip = $("#ipInput").val();
		}
		if ($("telephoneInput").val() != "") {
			queryParams.telephone = $("#telephoneInput").val();
		}
		if ($("saltInput").val() != "") {
			queryParams.salt = $("#saltInput").val();
		}
		if ($("lockedInput").val() != "") {
			queryParams.locked = $("#lockedInput").val();
		}
		if ($("emailInput").val() != "") {
			queryParams.email = $("#emailInput").val();
		}
		if ($("sexInput").val() != "") {
			queryParams.sex = $("#sexInput").val();
		}
		if ($("addressInput").val() != "") {
			queryParams.address = $("#addressInput").val();
		}
		if ($("userGroup_idInput").val() != "") {
			queryParams.userGroup_id = $("#userGroup_idInput").val();
		}

		$("#tgrid").datagrid("getPager").pagination({
			pageNumber : 1
		});

		$("#tgrid").datagrid("options").queryParams = queryParams;
		$("#tgrid").datagrid("reload");
	}

	//清除
	function clearSearch() {
			$("#usernameInput").val("");
			$("#statusInput").val("");
			$("#descriptionInput").val("");
			$("#enabledInput").val("");
			$("#ipInput").val("");
			$("#telephoneInput").val("");
			$("#saltInput").val("");
			$("#lockedInput").val("");
			$("#emailInput").val("");
			$("#sexInput").val("");
			$("#addressInput").val("");
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
		window.open('<%=basePath%>user/exportExcel');
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
				onclick="javascript:window.location.href='user/new'" /> 
			<input type="button"
				value="删除" onclick="deleteRows()" /> 
			<input type="button"
				value="更新" onclick="update()" /> 
			<input type="button"
				value="详情" onclick="show()" /> 
			<input type="button" id="searchBtn" value="搜索" onclick="search()" />
			<input type="button" id="clearBtn" value="清除" onclick="clearSearch()" />
			<input type="button" id="exportBtn" value="导出excel"
				onclick="exportExcel()" /> <input type="button" id="importBtn"
				value="导入excel" onclick="importExcel()" />
		</div>
		<div style="padding: 5px;border: 0px;">
			<label>用户名:</label>
			<input  id="usernameInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>状态:</label>
			<input  id="statusInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>描述:</label>
			<input  id="descriptionInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>是否可用:</label>
			<input  id="enabledInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>ip地址:</label>
			<input  id="ipInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>电话:</label>
			<input  id="telephoneInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>锁定:</label>
			<input  id="lockedInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>邮箱:</label>
			<input  id="emailInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>性别:</label>
			<input  id="sexInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>地址:</label>
			<input  id="addressInput" onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
		</div>
		<table id="tgrid" title="" class="easyui-datagrid"
			style="height:350px;"
			data-options="
								pageSize : 10,
								pageList : [ 5, 10, 15, 20 ],
								nowrap : true,
								striped : true,
								collapsible : true,
								url: 'user/select',
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
					<th id="idFieldTh"
						data-options="field:'id',align:'center'" width="100%">id</th>
					<th id="usernameFieldTh"
						data-options="field:'username',align:'center'" width="100%">用户名</th>
					<th id="statusFieldTh"
						data-options="field:'status',align:'center'" width="100%">状态</th>
					<th id="descriptionFieldTh"
						data-options="field:'description',align:'center'" width="100%">描述</th>
					<th id="enabledFieldTh"
						data-options="field:'enabled',align:'center'" width="100%">是否可用</th>
					<th id="createDateFieldTh"
						data-options="field:'createDate',align:'center'" width="100%">创建日期</th>
					<th id="updateDateFieldTh"
						data-options="field:'updateDate',align:'center'" width="100%">更新日期</th>
					<th id="ipFieldTh"
						data-options="field:'ip',align:'center'" width="100%">ip地址</th>
					<th id="telephoneFieldTh"
						data-options="field:'telephone',align:'center'" width="100%">电话</th>
					<th id="lockedFieldTh"
						data-options="field:'locked',align:'center'" width="100%">锁定</th>
					<th id="emailFieldTh"
						data-options="field:'email',align:'center'" width="100%">email</th>
					<th id="sexFieldTh"
						data-options="field:'sex',align:'center'" width="100%">性别</th>
					<th id="addressFieldTh"
						data-options="field:'address',align:'center'" width="100%">地址</th>
				</tr>
			</thead>
		</table>

	</div>
	<form id="addForm" action="user/new"></form>
	<form id="updateForm" action="user/edit"></form>
</body>
</html>
