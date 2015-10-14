<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>organization管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="Organization列表">
<meta http-equiv="description" content="管理">
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/demo/demo.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/icon.css" />
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
	    $('#orgTree').tree({
	    	url:'${ctxAdmin}/organization/getOrganizationTree',method:'get',animate:true,checkbox:true,onSelect: function(node){
	    		$('#resourceTree').tree("options").url = '${ctxAdmin}/organization/getResourceCheckboxTree?organizationId='+node.id;
		    	$('#resourceTree').tree('reload');
	    	}
	    });
	    $('#resourceTree').tree({
	    	url:'${ctxAdmin}/organization/getResourceCheckboxTree',method:'get',animate:true,checkbox:true
	    });
	});

	function connectOrganizationResource(){
		var row = $('#orgTree').tree('getSelected');
		if (row == null) {
			return;
		}
		
        var nodes = $('#resourceTree').tree('getChecked');
        var s = '';
        for(var i=0; i<nodes.length; i++){
            if (s != '') s += ',';
            s += nodes[i].id;
        }

		var pamameter = {};
		pamameter.organizationId = row.id;
		pamameter.resourceIds = s;
		
        $.ajax({
			cache : true,
			type : "POST",
			url : '${ctxAdmin}/organization/connectOrganizationResource',
			data : pamameter,
			async : false,
			error : function(request) {
				alert("连接失败");
			},
			success : function(data) {
				alert("授权成功"); // 重新加载;
			}
		});
	}
	
	// 移除条目；
	function deleteRows(selecedRow) {
		var pamameter = null;
		//多行删除。
		var row = $('#orgTree').tree('getChecked');
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
			url : '${ctxAdmin}/organization/deleteById',
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
		window.location.href = '${ctxAdmin}/organization/create';
	}

	function update() {
		var row = $('#orgTree').tree('getSelected');
		if (row == null) {
			return;
		}

		window.location.href = '${ctxAdmin}/organization/update/' + row.id;
	}

	function show() {
		var row = $('#tgrid').datagrid('getSelections');
		if (row == null || row.length == 0) {
			return;
		}

		window.location.href = '${ctxAdmin}/organization/show/' + row[0].id;
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
		window.open('${ctxAdmin}/organization/exportExcel');
	}

	//导入excel
	function importExcel() {

	}
</script>
</head>

<body class="easyui-layout" data-options="fit:true">
	<div data-options="region:'north'" style="padding:5px;">
						<input type="button" value="添加" id="btn_Add" name="btn_Add"
						onclick="javascript:window.location.href='${ctxAdmin}/organization/create'" />
					<input type="button" value="删除" onclick="deleteRows();" /> <input
						type="button" value="更新" onclick="update();" /> <input
						type="button" value="详情" onclick="show();" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="授权" onclick="connectOrganizationResource();"/>
	</div>
	<div data-options="region:'center'" title=""
		style="padding:1px;background:#ffffff;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center'" title="资源树"
				style="padding:1px;background:#ffffff;">
				<ul id="resourceTree"></ul>
			</div>
			<div data-options="region:'west',split:true" title="组织列表"
				style="width:400px;padding:1px;">
				<ul id="orgTree"></ul>	
			</div>
		</div>
	</div>
</body>
</html>
