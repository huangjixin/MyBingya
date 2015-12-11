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
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/icon.css">
<script type="text/javascript">
$().ready(function() {
	createResourceTree();
});

function createResourceTree(){
	$('#organizationId').combotree({ 	
			url: '${ctxAdmin}/organization/getOrganizationTree',
			valuefield : 'id',
			textfield : 'name',
			required : false,
			editable : false,
			onClick : function(node) {
				/*  JJ.Prm.GetDepartmentUser(node.id, 'selUserFrom'); 
				$('#parentId').val(node.id);*/
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				/* var tree = $('#organizationId').combotree('tree');
// 				$('#organizationId').combotree('tree').tree("collapseAll");
				var orgid = $('#organizationIdInput').val();
				if(orgid == ''){
					return ;
				}
				
				var node = tree.tree('find', orgid);
				if(node !=null){
					tree.tree('select', node.target);
					$('#organizationId').val(node.text);
				} */
				
			}
		});
}

function clearOrgInput(){
	$('#organizationId').combotree('clear');
}

function clearRoleInput(){
	$('#organizationId').combotree('clear');
}

function onsubmitEventHandler(){
	var szReg=/^[A-Za-zd]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+[A-Za-zd]{2,5}$/; 
	var bChk=szReg.test($('#email').val()); 
	if(bChk==false){
		$('#tip')[0].innerHTML="email格式不对";
		return false; 
	}else{
		$('#tip')[0].innerHTML="";
	}
	return true; 
}
</script>
<title>用户修改</title>
</head>
<body>
	<form:form id="validForm" action="${ctxAdmin}/user/update/${user.id}"
		method="post" commandName="user" onsubmit="return onsubmitEventHandler();">
		<input name="id" value="${user.id}" type="hidden" />
		<input id="organizationIdInput" value="${organizationId}" type="hidden" />
		<div class="desc">
			<b>用户信息修改</b>&nbsp;&nbsp;&nbsp;&nbsp;<b style="color: red;">${msg}</b>
		</div>
		<table width="100%" border="0" cellpadding="2" cellspacing="0">
			<tr>
				<td width="100%">
					<table border="0" cellpadding="3" cellspacing="1" width="100%"
						align="center" style="background-color: #b9d8f3;">
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: normal;">
							<th>&nbsp;用户名：</th>
							<td nowrap="nowrap" align="left"><form:input path="username"
									value="${user.username}" />&nbsp;<form:errors path="username"
									cssStyle="color:red;"></form:errors></td>
							<th>密码&nbsp;</th>
							<td nowrap="nowrap" align="left"><input type="password"
									name="password" value="${user.password}" />&nbsp;<form:errors
									path="password" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;角色组：</th>
							<td nowrap="nowrap" align="left"><select id="roleIdSelect"
								name="roleId" style="width: 100px;">
									<option value="">请选择</option>
									<c:if test="${roleList !=null }">
										<c:forEach var="role" items="${roleList}">
											<option value="${role.id}" <c:if test="${roleId!=null && roleId==role.id}">selected="selected"</c:if>>${role.name}</option>
										</c:forEach>
									</c:if>
							</select>&nbsp; <input type="button" value="清除"
								onclick="clearRoleInput();" /></td>
						</tr>
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: normal;">
							<th>&nbsp;父亲节点：</th>
							<td nowrap="nowrap" align="left"><input id="organizationId"
								name="organizationId" value="${organizationId}">&nbsp; <input type="button" value="清除"
								onclick="clearOrgInput();" /></td>
							<th>&nbsp;性别：</th>
							<td nowrap="nowrap" align="left"><select id="sex"
								name="sex" style="width:100px;">
								<%-- <option value="1" >男</option>
								<option value="0" <c:if test="${user.sex==0}">selected="selected"</c:if>>女</option> --%>
									<c:forEach var="sh" items="${fns:getByType('sex')}">
										<option value="${sh.value}"
											<c:if test="${sh.value == user.sex}">selected="selected"</c:if>
											<c:if test="${sh.value == user.sex}">selected="selected"</c:if>>${sh.label}</option>
									</c:forEach>
							</select></td>
							<th>&nbsp;邮箱：</th>
							<td nowrap="nowrap" align="left">
								<input id="email" name="email" value="${user.email}">&nbsp;<span style="color: red;">*</span>
							</td> 
						</tr>
						<tr
							style="text-align: right; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
							<th style="width: 150px;">&nbsp;</th>
							<td style="text-align: left;" colspan="6"><input
								type="submit" value="保存" />&nbsp;&nbsp;<input type="button"
								value="返回"
								onclick="javascript:window.location.href='${ctxAdmin}/user'" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>