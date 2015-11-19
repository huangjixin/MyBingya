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
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/demo/demo.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/icon.css"/>
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$().ready(function() {
		createResourceTree();
	});
	
	function createResourceTree(){
		$('#parentId').combotree({ 	
				url: '${ctxAdmin}/resource/getResourceTree',
				valuefield : 'id',
				textfield : 'name',
				required : false,
				editable : false,
				onClick : function(node) {
				}, //全部折叠
				onLoadSuccess : function(node, data) {
					$('#parentId').combotree('tree').tree("collapseAll");
					var parId = "${resource.parentId}";
					$('#parentId').combotree("setValue",parId);
				}
			});
	}
	
	function clearParentInput(){
		$('#parentId').combotree('clear');
	}
</script>
<title>资源添加</title>
</head>
<body>
	<form:form id="validForm" action="${ctxAdmin}/resource/create"
		method="post" commandName="resource">
		<div class="desc">
			<b>资源信息查看</b>&nbsp;&nbsp;&nbsp;&nbsp;<b style="color: red;">${msg}</b>
		</div>
		<table width="100%" border="0" cellpadding="2" cellspacing="0">
			<tr>
				<td width="100%">
					<table border="0" cellpadding="3" cellspacing="1" width="100%"
						align="center" style="background-color: #b9d8f3;">
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: normal;">
							<th>&nbsp;名称：</th>
							<td nowrap="nowrap" align="left"><form:input path="name"
									value="${resource.name}" />&nbsp;<form:errors path="name"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;权限名称：</th>
							<td nowrap="nowrap" align="left"><form:input path="authName"
									value="${resource.authName}" />&nbsp;<form:errors
									path="authName" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;访问路径：</th>
							<td nowrap="nowrap" align="left"><form:input path="path"
									value="${resource.path}" />&nbsp;<form:errors path="path"
									cssStyle="color:red;"></form:errors></td>
						</tr>
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: normal;">
							<th>&nbsp;类型：</th>
							<td nowrap="nowrap" align="left"><select id="type"
								name="type" style="width: 141px;">
									<option value="menu">菜单</option>
									<option value="button">按钮</option>
							</select>&nbsp;<form:errors path="type"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;父亲节点：</th>
							<td nowrap="nowrap" align="left"><input id="parentId"
								name="parentId">&nbsp; <input type="button" value="清除"
								onclick="clearParentInput();" /></td>
							<th>&nbsp;</th>
							<td nowrap="nowrap" align="left"></td>
						</tr>
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
							<th style="width: 150px;">&nbsp;</th>
							<td style="text-align: left;" colspan="6"><input type="button"
								value="返回"
								onclick="javascript:window.location.href='${ctxAdmin}/resource'" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>