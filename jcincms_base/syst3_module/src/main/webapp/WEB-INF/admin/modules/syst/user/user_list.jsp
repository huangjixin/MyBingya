<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>
<%@ include file="/WEB-INF/admin/include/js.jsp"%>
<script type="text/javascript">
	$().ready(function() {
		$('#tgrid').datagrid('getPager').pagination({
			displayMsg : '当前显示从{from}-{to},共{total}条记录'
		});
	});

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
			url : '${ctxAdmin}/user/deleteById',
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
		window.location.href = '${ctxAdmin}/user/create';
	}

	function update() {
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length == 0) {
			return;
		}
		window.location.href = '${ctxAdmin}/user/update/' + row[0].id + '';
	}

	function updatePass() {
		/* var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			return;
		}
		window.location.href='${ctxAdmin}/user/update/'+row[0].id+''; */
	}

	function show() {
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length == 0) {
			return;
		}

		window.location.href = '${ctxAdmin}/user/show/' + row[0].id;
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
		if ($("usernameInput").val() != "") {
			queryParams.username = $("#usernameInput").val();
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
	}

	//导出excel
	function exportExcel() {
		window.open('${ctxAdmin}/user/exportExcel');
	}

	//导入excel
	function importExcel() {

	}
</script>
</head>
<body>
	<div id="toolBar">
		<%-- <shiro:hasPermission name="user:create">
		</shiro:hasPermission>
		<shiro:hasPermission name="user:delete">
		</shiro:hasPermission>
		<shiro:hasPermission name="user:update">
		</shiro:hasPermission>
		<shiro:hasPermission name="user:update">
		</shiro:hasPermission> --%>
		<input type="button" value="添加" id="btn_Add" name="btn_Add"
			onclick="create();" /> <input type="button" value="删除"
			onclick="deleteRows();" /> <input type="button" value="详情"
			onclick="update();" /> <input type="button" value="重置密码"
			onclick="updatePass();" /> <input type="button" id="exportBtn"
			value="导出excel" onclick="exportExcel()" /> <input type="button"
			id="importBtn" value="导入excel" onclick="importExcel()" />
	</div>
	<div style="padding: 5px;border: 0px;">
		<label>用户名:</label> <input id="usernameInput"
			onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;<input
			type="button" id="searchBtn" value="搜索" onclick="search();" /> <input
			type="button" id="clearBtn" value="清除" onclick="clearSearch();" />
	</div>
	<table id="tgrid" class="easyui-datagrid" style="height:350px;"
		data-options="
								pageSize : 10,
								pageList : [ 5, 10, 15, 20 ],
								nowrap : true,
								striped : true,
								collapsible : true,
								url: '${ctxAdmin}/user/select',
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
					data-options="field:'id',align:'center',hidden:true" width="100%">id</th>
				<th data-options="field:'username',align:'center'" width="100%">用户名</th>
				<th data-options="field:'roleName',align:'center'" width="100%">角色名</th>
				<th data-options="field:'sex',align:'center',formatter:formatSex"
					width="100%">性别</th>
				<th data-options="field:'loginCount',align:'center'" width="100%">登录次数</th>
				<th data-options="field:'loginIp',align:'center'" width="100%">最后登录IP</th>
				<th data-options="field:'lastLogin',align:'center'" width="100%">上一次登录</th>
				<th data-options="field:'loginDate',align:'center'" width="100%">登录日期</th>
				<th data-options="field:'createDate',align:'center'" width="100%">创建日期</th>
				<th data-options="field:'updateDate',align:'center'" width="100%">更新日期</th>
				<th data-options="field:'createBy',align:'center'" width="100%">创建人</th>
				<th data-options="field:'updateBy',align:'center'" width="100%">更新人</th>
			</tr>
		</thead>
	</table>
	<script type="text/javascript">
		/* ,formatter:formatRolename */
		function formatRolename(val, row, index) {
			return '<a href="#" onclick="editUser(' + index + ')">修改</a>';
		}

		function formatSex(val, row, index) {
			return val == '1' ? '男' : '女';
		}
	</script>
	<%@ include file="/WEB-INF/admin/include/footer.jsp"%>
</body>
</html>