<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/admin/include/js.jsp"%>
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
					if(parId !=""){
						$('#parentId').combotree("setValue",parId);
					}
				}
			});
	}
	
	function clearParentInput(){
		$('#parentId').combotree('clear');
	}
</script>
<title>资源修改</title>
</head>
<body>
	<form:form id="validForm" action="${ctxAdmin}/resource/update/${resource.id}"
		method="post" commandName="resource">
		<div class="desc">
			<b>资源信息修改</b>&nbsp;&nbsp;&nbsp;&nbsp;<b style="color: red;">${msg}</b>
		</div>
		<table width="100%" border="0" cellpadding="2" cellspacing="0">
			<tr>
				<td width="100%">
					<table border="0" cellpadding="3" cellspacing="1" width="100%"
						align="center" style="background-color: #b9d8f3;">
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: normal;">
							<th>&nbsp;名称：</th>
							<td nowrap="nowrap" align="left"><input id="name" name="name"
									value="${resource.name}" /></td>
							<th>&nbsp;权限名称：</th>
							<td nowrap="nowrap" align="left"><input name="authName"
									value="${resource.authName}" /></td>
							<th>&nbsp;访问路径：</th>
							<td nowrap="nowrap" align="left"><input name="path"
									value="${resource.path}" /></td>
						</tr>
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: normal;">
							<th>&nbsp;类型：</th>
							<td nowrap="nowrap" align="left"><select id="type"
								name="type" style="width: 141px;">
									<option value="menu" <c:if test="${resource.type == 'menu'}">selected="selected"</c:if>>菜单</option>
									<option value="button" <c:if test="${resource.type == 'button'}">selected="selected"</c:if>>按钮</option>
							</select>&nbsp;<form:errors path="type"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;父亲节点：</th>
							<td nowrap="nowrap" align="left"><input id="parentId"
								name="parentId">&nbsp; <input type="button" value="清除"
								onclick="clearParentInput();" /></td>
							<th>&nbsp;手工排序：</th>
							<td style="text-align: left;" colspan="6">
								<form:input id="sort" path="sort" value="${resource.sort}" />&nbsp;
								<form:errors path="sort" cssStyle="color:red;"></form:errors>
							</td>
						</tr>
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
							<th style="width: 150px;">&nbsp;</th>
							<td style="text-align: left;" colspan="6"><input
								type="submit" value="保存" />&nbsp;&nbsp;<input type="button"
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