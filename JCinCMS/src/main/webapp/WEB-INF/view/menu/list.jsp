<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>菜单列表</title>

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
<script type="text/javascript" src="js/jquery.form.js"></script>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/common.css">
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
	$().ready(function() {
	});

	var curKeyIndex = -1;
	//单元格嵌入按钮。
	function formatterWithBtn(value, rec) {
		var btn = '<input type="button" onclick="add()" value="新增" /> <input type="button" onclick="update(1)" value="修改" /> <input type="button" onclick="deleteRows(\"+rec+\")" value="删除" />';
		return btn;
	}

	//edit：null新增；
	//edit：1保存并返回；
	//edit：2保存并新增；
	function add(edit) {
		alert("add");
	}

	//edit：null新增；
	//edit：1保存并返回；
	//edit：2保存并新增；
	function update() {
		//多行删除。
		var row = $("#tgrid").treegrid('getSelections');
		if (row == null) {
			return;
		}

		$('#idInput').val(row[0].id);
		// 		alert(path);
		// 		$('#updateForm').attr("action", path);
		$('#updateForm').submit();
	}

	//删除；
	//number:1删除一条。
	//number:不为null删除数组。
	function deleteRows() {
		//多行删除。
		var row = $("#tgrid").treegrid('getSelections');
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

		if (row != null) {
			var pam = {
				idstring : string
			};
			$.ajax({
				cache : true,
				type : "POST",
				url : 'menu/deleteById',
				data : pam,
				async : false,
				error : function(request) {
					alert("连接失败");
				},
				success : function(data) {
					$("#tgrid").treegrid('reload'); // 重新加载;
				}
			});
		}
	}

	function toListView() {
		$("#editResult").html("");
		$('#listView').show();
		$('#editView').hide();
	}

	function toEditViewView() {
		$('#editView').show();
		$('#listView').hide();
	}

	function refresh() {
		$("#tgrid").treegrid("reload");
	}

	function submitListener() {
		$("#editResult").html("");
		var str = $('#menuForm').formSerialize(); // registerForm为form id
		$.ajax({
			cache : true,
			type : "POST",
			url : 'menu/new',
			data : str,// 你的formid
			async : false,
			error : function(request) {
				$("#editResult").html("连接失败");
			},
			success : function(data) {
				$("#editResult").html("保存成功");
			}
		});
	}

	function clearForm() {
		$("#name").val("");
		$("#url").val("");
		$("#description").val("");
	}

	function ontgridLoadSuccess(data) {
		if (curKeyIndex > 0) {
			$("#tgrid").treegrid("select", 0);
		}
	}
</script>
</head>

<body class="easyui-layout" data-options="fit:true">
	<div data-options="region:'center'" title=""
		style="padding:0px;background:#ffffff;">
		<div id="listView" style="width: 100%;height:100%;">
			<div id="toolBar" style="padding: 5px;border: 0px;">
				<div>
					<input type="button" value="新增" onclick="toEditViewView();" /> <input
						type="button" value="删除" onclick="deleteRows()" /> <input
						type="button" value="修改" id="btn_Update" name="btn_Update"
						onclick="update();" /><input type="button" value="刷新"
						onclick="refresh()" />
				</div>
			</div>
			<table id="tgrid" title="" class="easyui-treegrid"
				data-options="
								url: 'menu/getMenu',
								method: 'get',
								rownumbers: false,
								idField: 'id',
								treeField: 'name',
								showHeader: true,
								lines: true,
								singleSelect : false,
								selectOnCheck: true,
								checkOnSelect: true,
								fit:true,
								fitColumns:true,
								onLoadSuccess : ontgridLoadSuccess
							">
				<thead>
					<tr>
						<th field="ck" data-options="checkbox:true"></th>
						<th id="nameFieldTh" data-options="field:'name',align:'left'"
							width="100%">名称</th>
						<th id="urlFieldTh" data-options="field:'url',align:'center'"
							width="100%">连接的URL</th>
						<th id="descriptionTh"
							data-options="field:'description',align:'center'" width="100%">描述</th>
<!-- 						<th id="descriptionTh" -->
<!-- 							data-options="field:'opt',align:'center',formatter:formatterWithBtn" -->
<!-- 							width="100%">操作</th> -->
						<!-- <th id="createdateFieldTh" data-options="field:'createdate'" 
						width="100%">创建日期</th>
					<th id="updatedateFieldTh" data-options="field:'updatedate'"
 						width="100%">更新日期</th> -->
					</tr>
				</thead>
			</table>
		</div>
		<div id="editView" style="display: none;">
			<form id="menuForm" onsubmit="return false;">
				<table width="100%" id="ListArea" border="1px;"
					bordercolor="#C5C5C5" align="center" cellpadding="0"
					cellspacing="0" style="border-collapse: collapse;">
					<tbody>
						<tr class="tr1">
							<td class="td1" colSpan="4">&nbsp;&nbsp;&nbsp;&nbsp;<input
								type="button" value="返回" onclick="toListView();" /></td>
						</tr>
						<tr class="tr1">
							<th class="th1">名称:</th>
							<td class="td1"><input type="text" name="name" id="name"
								value="localhost" size="35"></td>
							<th class="th1">连接URL:</th>
							<td class="td1" colSpan="3"><input type="text" name="url"
								id="url" value="" size="35"></td>
						</tr>

						<tr class="tr1">
							<th class="th1">描述:</th>
							<td class="td1" colSpan="3" style="padding: 4px;"><textarea
									id="description" style="width: 520px;height: 100px;"></textarea>
							</td>
						</tr>
						<tr class="tr1">
							<td class="td1" colSpan="4" style="padding: 4px;">&nbsp;&nbsp;&nbsp;&nbsp;<input
								type="button" value="保存" id="btn_login"
								onclick="submitListener();" /> <input type="button"
								value="清除表单" id="btn_clearForm" onclick="clearForm();" />
								<h1 id="editResult"></h1></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
	<form id="updateForm" action="menu/menuUpdate" method="get">
		<input type="hidden" id="idInput" name="id" />
	</form>
</body>
</html>
