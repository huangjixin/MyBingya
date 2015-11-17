<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
th {
	font-weight: normal;
	font-size: 12px;
}
</style>
<script type="text/javascript"
	src="${ctx}/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/themes/icon.css">
<script type="text/javascript">
	var chanTemp = "${channel.channelTemplete}";
	$().ready(function() {
		createOrganizationTree();
		createFileTree();
		/* alert($('#parentIds').val()); */
	});

	function createOrganizationTree() {
		$('#parentId').combotree({
			url : '${ctxAdmin}/channel/getChannelTree',
			valuefield : 'id',
			textfield : 'name',
			required : false,
			editable : false,
			onClick : function(node) {
				/*  JJ.Prm.GetDepartmentUser(node.id, 'selUserFrom'); 
				$('#parentId').val(node.id);*/
// 				$('#linkAddr').val(node.code);
				if(node.parentIds=='' ||node.parentIds==null){
					$('#parentIds').val(node.id);
				}else{
					$('#parentIds').val(node.parentIds+","+node.id);
				}
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#parentId').combotree('tree').tree("collapseAll");
				var parId = "${channel.parentId}";
				if (parId != "") {
					$('#parentId').combotree("setValue", parId);
				}
			}
		});
	}

	//创建文件树。
	function createFileTree() {
		$('#chanTemplete').combotree({
			url : '${ctxAdmin}/document/getWebsiteFiles',
			valuefield : 'id',
			textfield : 'name',
			required : false,
			editable : false,
			onClick : function(node) {
				/*  JJ.Prm.GetDepartmentUser(node.id, 'selUserFrom'); 
				$('#parentId').val(node.id);*/
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#chanTemplete').combotree('tree').tree("collapseAll");
				var dTemplete = "${channel.channelTemplete}";
				if (dTemplete != "") {
					var index = dTemplete.lastIndexOf("/");
					if(index>0){
						dTemplete = dTemplete.substring(index+1,dTemplete.length)+".jsp";
						$('#chanTemplete').combotree("setValue", dTemplete);
					}else{
						$('#chanTemplete').combotree("setValue", dTemplete+".jsp");
					}
					
				}
			},onSelect: function (item) {  
                var parent = item;  
                var tree = $('#chanTemplete').combotree('tree');  
                var path = new Array();  
                do {  
                    path.unshift(parent.text);  
                    var parent = tree.tree('getParent', parent.target);  
                } while (parent);  
                var pathStr = '';  
                for (var i = 0; i < path.length; i++) {  
                    pathStr += path[i];  
                    if (i < path.length - 1) {  
                        pathStr += '/';  
                    }  
                }  
                
                chanTemp = pathStr; 
            }  
		});
	}
	
	function oncodeComplete() {
		$('#linkAddr').val("");
		var node = $('#parentId').combotree('tree').tree("getSelected");
		var co = $('#code').val();
		if (node) {
			if ("" != co) {
				$('#linkAddr').val(node.linkAddr + "/" + co);
			}
		} else {
			if ("" != co) {
				$('#linkAddr').val("channel/"+co);
			}
		}
	}

	function clearParentInput() {
		$('#parentId').combotree('clear');
		$('#parentIds').val('');
	}

	function clearForm() {
		$('#parentId').combotree('clear');
		$('#name').val("");
		$('#code').val("");
		$('#keyword').val("");
		$('#linkAddr').val("");
		$('#descrition').val("");
	}

	function onasdocumentChange() {
		var asdoc = $("#asdocument").val();

		if (asdoc == "true") {
			$("#channelTemplete").val('');
			$("#channelTemplete").attr('disabled', true);
			$("#docBtn").attr('disabled', false);
		} else {
			$("#channelTemplete").attr('disabled', false);
			$("#docBtn").attr('disabled', true);
			$("#documentId").val('');
		}
	}

	function onsubmitHandler() {
		if(chanTemp.indexOf(".") > 0){
			chanTemp = chanTemp.substring(0,chanTemp.indexOf("."));
		}
		$('#channelTemplete').val(chanTemp);
		var row = $('#tgrid').datagrid('getSelected');
		if (row) {
			//$.messager.alert('Info', row.id);
			$("#documentId").val(row.id);
		}
	}
	

	//搜索
	function search() {
		var queryParams = {};
		if ($("titleInput").val() != "") {
			queryParams.title = $("#titleInput").val();
		}
		if ($("authorInput").val() != "") {
			queryParams.author = $("#authorInput").val();
		}

		$("#tgrid").datagrid("getPager").pagination({
			pageNumber : 1
		});

		$("#tgrid").datagrid("options").queryParams = queryParams;
		$("#tgrid").datagrid("reload");
	}

	//清除
	function clearSearch() {
			$("#titleInput").val("");
			$("#authorInput").val("");
	}
</script>
<title>栏目更新</title>
</head>
<body>
	<form:form id="validForm"
		action="${ctxAdmin}/channel/update/${channel.id}" method="post"
		commandName="channel" onsubmit="onsubmitHandler()">
		<input name="id" value="${channel.id}" type="hidden" />
		<input id="channelTemplete" name="channelTemplete" value="${channel.channelTemplete}" type="hidden" />
		<input id="parentIds" name="parentIds" value="${channel.parentIds}" type="hidden" />
		<input id="documentId" name="documentId" value="${channel.documentId}" type="hidden" />
		<div class="descrition">
			<b>栏目信息更新</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
		</div>
		<table width="100%" border="0" cellpadding="2" cellspacing="0">
			<tr>
				<td width="100%">
					<table border="0" cellpadding="3" cellspacing="1" width="100%"
						align="center" style="background-color: #b9d8f3;">
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;栏目：</th>
							<td nowrap="nowrap" align="left"><form:input path="parentId"
									value="${channel.parentId}" />&nbsp;<input type="button"
								value="清除" onclick="clearParentInput();" />
							<form:errors path="parentId" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;名称：</th>
							<td nowrap="nowrap" align="left"><form:input path="name"
									value="${channel.name}" />&nbsp;<form:errors path="name"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;编码：</th>
							<td nowrap="nowrap" align="left"><form:input path="code"
									value="${channel.code}" onchange="oncodeComplete()" />&nbsp;<form:errors
									path="code" cssStyle="color:red;"></form:errors></td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;关键字：</th>
							<td nowrap="nowrap" align="left"><form:input path="keyword"
									value="${channel.keyword}" />&nbsp;<form:errors path="keyword"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;链接地址：</th>
							<td nowrap="nowrap" align="left"><form:input path="linkAddr"
									value="${channel.linkAddr}" />&nbsp;<form:errors
									path="linkAddr" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;新窗口打开：</th>
							<td nowrap="nowrap" align="left"><select id="openMode"
								name="openMode" style="width:100px;">
									<c:forEach var="mode" items="${fns:getByType('openMode')}">
										<option value="${mode.value}"
											<c:if test="${mode.value == channel.openMode}">selected="selected"</c:if>>${mode.label}</option>
									</c:forEach>
							</select>&nbsp;<form:errors path="openMode" cssStyle="color:red;"></form:errors></td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;栏目模板：</th>
							<td nowrap="nowrap" align="left"><input id="chanTemplete" path="chanTemplete" />&nbsp;<form:errors
									path="channelTemplete" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;是否显示：</th>
							<td nowrap="nowrap" align="left"><select id="hidden"
								name="hidden" style="width:100px;">
									<c:forEach var="sh" items="${fns:getByType('hidden')}">
										<option value="${sh.value}"
											<c:if test="${sh.value == channel.hidden}">selected="selected"</c:if>>${sh.label}</option>
									</c:forEach>
							</select>&nbsp;<form:errors path="hidden" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;当成文档：</th>
							<td nowrap="nowrap" align="left"><select id="asdocument"
								name="asdocument" style="width:100px;"
								onchange="onasdocumentChange()">
									<c:forEach var="asdoc" items="${fns:getByType('asdocument')}">
										<option value="${asdoc.value}"
											<c:if test="${asdoc.value == channel.asdocument}">selected="selected"</c:if>>${asdoc.label}</option>
									</c:forEach>
							</select>&nbsp;<input id="docBtn" type="button" value="选择文档"
								<c:if test="${channel.asdocument==false}"> disabled="true"</c:if>
								onclick="$('#dlg').dialog('open')" />
							<form:errors path="asdocument" cssStyle="color:red;"></form:errors></td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;描述：</th>
							<td nowrap="nowrap" align="left" colspan="6"><form:textarea
									path="descrition" value="${channel.descrition}"
									style="width:400px;height:100px;" />&nbsp;<form:errors
									path="descrition" cssStyle="color:red;"></form:errors></td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;手工排序：</th>
							<td style="text-align: left;" colspan="6">
								<form:input id="sort" path="sort" value="${channel.sort}" />&nbsp;
								<form:errors path="sort" cssStyle="color:red;"></form:errors>
							</td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th style="width: 150px;">&nbsp;</th>
							<td style="text-align: left;" colspan="6"><input
								type="submit" value="保存" />&nbsp;&nbsp;<input type="reset"
								value="重置" />&nbsp;&nbsp;<input type="button" value="清空"
								onclick="clearForm();" />&nbsp;&nbsp;<input type="button"
								value="返回"
								onclick="javascript:window.location.href='${ctxAdmin}/channel'" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form:form>
	<div id="dlg" class="easyui-dialog" title="文档选择"
		data-options="iconCls:'icon-save',closed: true"
		style="width:600px;height:350px;padding:10px">
		<div style="padding: 5px;border: 0px;">
			<label>标题:</label> <input id="titleInput"
				onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>作者:</label> <input id="authorInput"
				onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<input type="button" id="searchBtn" value="搜索" onclick="search();" />
			<input type="button" id="clearBtn" value="清除" onclick="clearSearch();" />
		</div>
		<table id="tgrid" title="" class="easyui-datagrid"
			data-options="
								pageSize : 10,
								pageList : [ 5, 10, 15, 20 ],
								nowrap : true,
								striped : true,
								collapsible : true,
								url: '${ctxAdmin}/document/select',
								loadMsg : '数据装载中......',
								method: 'get',
								singleSelect : true,
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
					<th data-options="field:'id',align:'center',hidden:true"
						width="100%">id</th>
					<th data-options="field:'title',align:'center'" width="100%">标题</th>
					<th data-options="field:'author',align:'center'" width="100%">作者</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>