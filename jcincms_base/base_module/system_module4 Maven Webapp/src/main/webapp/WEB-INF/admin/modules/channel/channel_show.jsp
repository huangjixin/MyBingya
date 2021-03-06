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
				url: '${ctxAdmin}/channel/getChannelTree',
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
					var parId = "${channel.parentId}";
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
<title>栏目信息查看</title>
</head>
<body>
	<form:form id="validForm" action="" method="post" commandName="channel">
				<input name="id" value="${channel.id}" type="hidden" />
				<div class="descrition">
					<b>栏目信息查看</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;栏目：</th>
									<td nowrap="nowrap" align="left"><form:input path="parentId" value="${channel.parentId}"/>&nbsp;<input type="button" value="清除"
								onclick="clearParentInput();" /><form:errors path="parentId" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;名称：</th>
									<td nowrap="nowrap" align="left"><form:input path="name" value="${channel.name}"/>&nbsp;<form:errors path="name" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;编码：</th>
									<td nowrap="nowrap" align="left"><form:input path="code" value="${channel.code}"/>&nbsp;<form:errors path="code" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;关键字：</th>
									<td nowrap="nowrap" align="left"><form:input path="keyword" value="${channel.keyword}"/>&nbsp;<form:errors path="keyword" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;链接地址：</th>
									<td nowrap="nowrap" align="left"><form:input path="linkAddr" value="${channel.linkAddr}"/>&nbsp;<form:errors path="linkAddr" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;新窗口打开：</th>
									<td nowrap="nowrap" align="left"><select  id="openMode" name="openMode" style="width:100px;">
										<c:forEach var="mode" items="${fns:getByType('openMode')}">
											<option value="${mode.value}" <c:if test="${mode.value == channel.openMode}">selected="selected"</c:if>>${mode.label}</option>
										</c:forEach>
									</select>&nbsp;<form:errors path="openMode" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;描述：</th>
									<td nowrap="nowrap" align="left" colspan="6"><form:textarea path="descrition" value="${channel.descrition}" style="width:400px;height:100px;"/>&nbsp;<form:errors path="descrition" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6">&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/channel'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form:form>		
</body>
</html>