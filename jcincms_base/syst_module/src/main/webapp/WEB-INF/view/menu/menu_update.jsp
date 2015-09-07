<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="parentId" value="${menu.parentId}" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui/dwrloader.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui/easyloader.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/jquery-easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/common.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
th {
	font-weight: normal;
	font-size: 12px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
$().ready(function() {
	$('#parentIdTree').combotree
    ({ 	url: '<%=basePath%>menu/getMenu',
			valuefield : 'id',
			textfield : 'name',
			required : false,
			editable : false,
			onClick : function(node) {
				$('#parentId').val(node.id);
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#parentIdTree').combotree('tree').tree("collapseAll");
				var parId = "${menu.parentId}";
				$('#parentIdTree').combotree("setValue",parId);
			}
		});
	});
	
	function clearParentInput(){
		$('#parentId').val('');
		$('#parentIdTree').combotree('clear');
	}
</script>
<title>菜单更新</title>
</head>
<body>
	<form:form id="validForm" action="${ctx}/menu/updateForm" method="post"
		commandName="menu">
		<input type="hidden" name="step" value="1">
		<div class="desc">
			<b>菜单信息更新</b>
		</div>
		<table width="100%" border="0" cellpadding="2" cellspacing="0">
			<tr>
				<td width="100%">
					<table border="0" cellpadding="3" cellspacing="1" width="100%"
						align="center" style="background-color: #b9d8f3;">
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
							<th>&nbsp;名称：</th>
							<td nowrap="nowrap" align="left">
							<form:hidden path="id"
									value="${menu.id}" />
							<form:input path="name"
									value="${menu.name}" />&nbsp;<form:errors path="name"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;描述：</th>
							<td nowrap="nowrap" align="left"><form:input
									path="description" value="${menu.description}" />&nbsp;<form:errors
									path="description" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;路径：</th>
							<td nowrap="nowrap" align="left"><form:input path="path"
									value="${menu.path}" />&nbsp;<form:errors path="path"
									cssStyle="color:red;"></form:errors></td>
						</tr>
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
							<th>&nbsp;父亲节点：</th>
							<td nowrap="nowrap" align="left"><form:errors
									path="parentId" cssStyle="color:red;"></form:errors> <input
								id="parentIdTree">
							<form:hidden id="parentId" path="parentId"
									value="${menu.parentId}" />&nbsp; <input type="button"
								value="清除" onclick="javascript:clearParentInput();" /></td>
							<th>&nbsp;url：</th>
							<td nowrap="nowrap" align="left"><form:input path="url"
									value="${menu.url}" />&nbsp;<form:errors path="url"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;icon：</th>
							<td nowrap="nowrap" align="left"><form:input path="icon"
									value="${menu.icon}" />&nbsp;<form:errors path="icon"
									cssStyle="color:red;"></form:errors></td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th style="width: 150px;">&nbsp;</th>
							<td style="text-align: left;" colspan="6"><input
								type="submit" value="保存" />&nbsp;&nbsp;<input type="button"
								value="返回"
								onclick="javascript:window.location.href='<%=basePath%>menu'" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>