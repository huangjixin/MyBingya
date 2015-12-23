<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>栏目管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="Channel列表">
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
		$('#tgrid').treegrid({
			onLoadSuccess:function (row, data){
				$('#tgrid').treegrid('collapseAll');
			}
		});
	});

	// 移除条目；
	function deleteRows(selecedRow) {
		var pamameter = null;
		//多行删除。
		var row = $('#tgrid').treegrid('getSelections');
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
			url : '${ctxAdmin}/channel/deleteById',
			data : pamameter,
			async : false,
			error : function(request) {
				alert("连接失败");
			},
			success : function(data) {
				$("#tgrid").treegrid('reload'); // 重新加载;
			}
		});
	}

	function create(){
		window.location.href='${ctxAdmin}/channel/create'; 
	}
	
	function update(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			return;
		}
		
		window.location.href='${ctxAdmin}/channel/update/'+row[0].id+''; 
	}
		
	function show(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			return;
		}
		
		window.location.href='${ctxAdmin}/channel/show/'+row[0].id; 
	}

	function refreshMenu(){
		$.ajax({
			cache : true,
			url : '${ctxAdmin}/channel/getChannels',
			async : false,
			error : function(request) {
				alert("连接失败");
			},
			success : function(data) {
				alert('刷新成功'); // 重新加载;
			}
		});
	}
	
	//格式化用户状态显示。
	function formatDate(val, row) {
		var date = new Date();
		date.setTime(val);
		var result = date.format("yyyy-MM-dd hh:mm:ss");

		return result;
	}

	function up(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			$("#tooltip")[0].innerHTML="请选择一个节点";
			return;
		}else{
			$("#tooltip")[0].innerHTML="";
		}
		$.ajax({
			cache : true,
			url : '${ctxAdmin}/channel/toUp?id='+row[0].id+'&time='+new Date(),
			async : false,
			error : function(request) {
				alert("连接失败");
			},
			success : function(data) {
				$("#tooltip")[0].innerHTML="操作成功"; // 重新加载;
				$('#tgrid').datagrid('clearSelections');
				$('#tgrid').treegrid('reload');
			}
		});
		
	}

	function down(){
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length==0) {
			$("#tooltip")[0].innerHTML="请选择一个节点";
			return;
		}else{
			$("#tooltip")[0].innerHTML="";
		}
		$.ajax({
			cache : true,
			url : '${ctxAdmin}/channel/toDown?id='+row[0].id+'&time='+new Date(),
			async : false,
			error : function(request) {
				alert("连接失败");
			},
			success : function(data) {
				$("#tooltip")[0].innerHTML="操作成功"; // 重新加载;
				$('#tgrid').datagrid('clearSelections');
				$('#tgrid').treegrid('reload');
			}
		});
	}
</script>
</head>

<body class="easyui-layout" data-options="fit:true">
	<!-- 	<div data-options="region:'north'" style="padding:0px;"></div> -->
	<div data-options="region:'center'" title=""
		style="padding:0px;background:#ffffff;">
		<div id="toolBar" style="padding: 5px;border: 0px;">
			<shiro:hasPermission name="channel:create">
				<input type="button" value="添加" id="btn_Add" name="btn_Add" onclick="create();" /> 
			</shiro:hasPermission>
			<shiro:hasPermission name="channel:delete">
				<input type="button" value="删除" onclick="deleteRows();" />
			</shiro:hasPermission>
			<shiro:hasPermission name="channel:update">
				<input type="button" value="更新" onclick="update();" /> 
			</shiro:hasPermission>
			<shiro:hasPermission name="channel:view">
				<input type="button" value="详情" onclick="show();" /> 
			</shiro:hasPermission>   
			<shiro:hasPermission name="channel:update">
				<input type="button" value="上升" onclick="up();" /> 
			</shiro:hasPermission>
			<shiro:hasPermission name="channel:update">
				<input type="button" value="下降" onclick="down();" /> 
			</shiro:hasPermission>
			<shiro:hasPermission name="channel:update">
				<input type="button" value="刷新栏目缓存" onclick="refreshMenu();" /> 
			</shiro:hasPermission>
			&nbsp;&nbsp;<span id="tooltip" style="color: red;"></span>
		</div>
		
		<table id="tgrid" title="" class="easyui-treegrid"
			style="height:350px;"
			data-options="
								url: '${ctxAdmin}/channel/getChannelTree',
								method: 'get',
								rownumbers: false,
								idField: 'id',
								treeField: 'name',
								showHeader: true,
								lines: true,
								singleSelect : false,
								selectOnCheck: true,
								checkOnSelect: true,
								fitColumns:true
							">
			<thead>
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<th data-options="field:'id',align:'center',hidden:true" width="100%">id</th>
					<th data-options="field:'name',align:'center'" width="100%">路径</th>
					<th data-options="field:'code',align:'center'" width="100%">编码</th>
					<th data-options="field:'channelTemplete',align:'center'" width="100%">栏目模板</th>
					<th data-options="field:'keyword',align:'center'" width="100%">关键字</th>
					<th data-options="field:'linkAddr',align:'center'" width="100%">链接地址</th>
					<th data-options="field:'sort',align:'center'" width="100%">排序序号</th>
					<!-- <th data-options="field:'openMode',align:'center'" width="100%">新窗口打开</th> -->
					<!-- <th data-options="field:'descrition',align:'center'" width="100%">描述</th> -->
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>
