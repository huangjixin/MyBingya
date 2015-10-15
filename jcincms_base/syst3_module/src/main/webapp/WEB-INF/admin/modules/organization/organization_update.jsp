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
		createOrganizationTree();
	});

	function createOrganizationTree(){
		$('#parentId').combotree({ 	
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
					$('#parentId').combotree('tree').tree("collapseAll");
					var parId = "${organization.parentId}";
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
<title>组织修改</title>
</head>
<body>
	<form:form id="validForm" action="${ctxAdmin}/organization/update/${organization.id}" method="post" commandName="organization">
		<input name="id" value="${organization.id}" type="hidden" />
				<div class="desc">
					<b>组织信息修改</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;名称：</th>
									<td nowrap="nowrap" align="left"><form:input path="name" value="${organization.name}"/>&nbsp;<form:errors path="name" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;父亲节点：</th>
									<td nowrap="nowrap" align="left"><input id="parentId" name="parentId"/>&nbsp;<form:errors path="parentId" cssStyle="color:red;"></form:errors>&nbsp; <input type="button" value="清除"
								onclick="clearParentInput();" /></td>
									<th>&nbsp;是否可用：</th>
									<td nowrap="nowrap" align="left"><select  id="available" name="available" style="width:100px;">
										<c:forEach var="org" items="${fns:getByType('available')}">
											<option value="${org.value}" <c:if test="${org.value == organization.available}">selected="selected"</c:if>>${org.label}</option>
										</c:forEach>
									</select>&nbsp;<form:errors path="available" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/organization'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form:form>		
</body>
</html>