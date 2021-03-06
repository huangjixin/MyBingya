<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>文档管理</title>
<%@ include file="/WEB-INF/admin/include/js.jsp"%>
<script type="text/javascript">
	$().ready(function() {
		createChannelTree();
		$('#tgrid').datagrid('getPager').pagination({displayMsg:'当前显示从{from}-{to},共{total}条记录'});
	});

	function createChannelTree() {
		$('#channelInput').combotree({
			url : '${ctxAdmin}/channel/getChannelTree',
			valuefield : 'id',
			textfield : 'name',
			required : false,
			editable : false,
			onClick : function(node) {
				/*  JJ.Prm.GetDepartmentUser(node.id, 'selUserFrom'); 
				$('#parentId').val(node.id);*/
// 				$('#linkAddr').val(node.code);
				if(node){
					$('#channelId').val(node.id);
				}else{
					$('#channelId').val("");
				}
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#channelInput').combotree('tree').tree("collapseAll");
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
		var grid = $('#tgrid');  
		var options = grid.datagrid('getPager').data("pagination").options;  
		var curr = options.pageNumber;
		window.location.href='${ctxAdmin}/document/update/'+row[0].id+'?pageNumber='+curr; 
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
		if ($("#titleInput").val() != "") {
			queryParams.title = $("#titleInput").val();
		}
		if ($("#authorInput").val() != "") {
			queryParams.author = $("#authorInput").val();
		}
		if ($("#documentTempleteInput").val() != "") {
			queryParams.documentTemplete = $("#documentTempleteInput").val();
		}
		if ($("#channelId").val() != "") {
			queryParams.channelId = $("#channelId").val();
		}

		$("#tgrid").datagrid("getPager").pagination({
			pageNumber : 1
		});

		$("#tgrid").datagrid("options").queryParams = queryParams;
		$("#tgrid").datagrid("reload");
	}

	function clearChannelIdInput() {
		$("#channelInput").combotree('clear');
	}
	
	//清除
	function clearSearch() {
			$("#titleInput").val("");
			$("#authorInput").val("");
			$("#documentTempleteInput").val("");
			$("#channelId").val("");
			$("#channelInput").combotree('clear');
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
	
	// 移除静态html；
	function deleteChannelDoc() {
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
			url : '${ctxAdmin}/document/deleteChannelDoc',
			data : pamameter,
			async : false,
			error : function(request) {
				alert("连接失败");
			},
			success : function(data) {
				document.getElementById("tip").innerHTML="删除成功"; // 重新加载;
			}
		});
	}
	//生成静态html；
	function geneChannelDoc() {
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
			url : '${ctxAdmin}/document/geneChannelDoc',
			data : pamameter,
			async : false,
			error : function(request) {
				alert("连接失败");
			},
			success : function(data) {
				document.getElementById("tip").innerHTML="生成成功"; // 重新加载;
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
			<shiro:hasPermission name="document:create">
				<input type="button" value="添加" id="btn_Add" name="btn_Add" onClick="create();" /> 
			</shiro:hasPermission>
			<shiro:hasPermission name="document:delete">
				<input type="button" value="删除" onClick="deleteRows();" />
			</shiro:hasPermission>
			<shiro:hasPermission name="document:update">
				<input type="button" value="更新" onClick="update();" /> 
			</shiro:hasPermission>
			<shiro:hasPermission name="document:view">
				<input type="button" value="详情" onClick="show();" /> 
			</shiro:hasPermission> 
			<input type="button" id="searchBtn" value="搜索" onClick="search();" />
			<input type="button" id="clearBtn" value="清除" onClick="clearSearch();" />
			<input type="button" value="删除静态HTML" onClick="deleteChannelDoc();" />
        	<input type="button" value="生成静态HTML" onClick="geneChannelDoc();" />
            <span id="tip"></span>
			<!-- <input type="button" id="exportBtn" value="导出excel"
				onclick="exportExcel()" /> --> <!-- <input type="button" id="importBtn"
				value="导入excel" onclick="importExcel()" /> -->
		</div>
		<div style="padding: 5px;border: 0px;">
			<input  id="channelId" type="hidden">
			<label>标题:</label>
			<input  id="titleInput" onKeyDown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>作者:</label>
			<input  id="authorInput" onKeyDown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>模板:</label>
			<input  id="documentTempleteInput" onKeyDown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>栏目:</label>
			<input  id="channelInput" onKeyDown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<input type="button" value="清除" onClick="clearChannelIdInput();" />
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
					<th data-options="field:'id',align:'center',hidden:true" width="100%">id</th>
					<th data-options="field:'channelId',align:'center',hidden:true" width="100%">channelId</th>
					<th data-options="field:'title',align:'center'" width="100%">标题</th>
					<!-- <th data-options="field:'documentTemplete',align:'center'" width="100%">jsp动态文档模板</th>
					<th data-options="field:'geneTemplate',align:'center'" width="100%">PC静态化模板</th>
					<th data-options="field:'mGeneTemplate',align:'center'" width="100%">移动端静态化模板</th> -->
					<th data-options="field:'author',align:'center'" width="100%">作者</th>
					<th data-options="field:'createDate',align:'center'" width="100%">日期</th>
					<th data-options="field:'recommend',align:'center'" width="100%">是否推荐</th>
					
				</tr>
			</thead>
		</table>
	</div>
	<%@ include file="/WEB-INF/admin/include/footer.jsp"%>
</body>
</html>
