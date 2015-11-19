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
		
	});

	function clearForm(){
		$('#id').val("");
		$('#documentId').val("");
		$('#createDate').val("");
		$('#updateDate').val("");
		$('#content').val("");
		$('#parentIds').val("");
		$('#parentId').val("");
		$('#hidden').val("");
	}
</script>
<title>comment更新</title>
</head>
<body>
	<form:form id="validForm" action="${ctxAdmin}/comment/update/${comment.id}" method="post" commandName="comment">
				<input name="id" value="${comment.id}" type="hidden" />
				<div class="desc">
					<b>comment信息更新</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;id：</th>
									<td nowrap="nowrap" align="left"><form:input id="id" path="id" value="${comment.id}"/>&nbsp;<form:errors path="id" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;documentId：</th>
									<td nowrap="nowrap" align="left"><form:input id="documentId" path="documentId" value="${comment.documentId}"/>&nbsp;<form:errors path="documentId" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;createDate：</th>
									<td nowrap="nowrap" align="left"><form:input id="createDate" path="createDate" value="${comment.createDate}"/>&nbsp;<form:errors path="createDate" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;updateDate：</th>
									<td nowrap="nowrap" align="left"><form:input id="updateDate" path="updateDate" value="${comment.updateDate}"/>&nbsp;<form:errors path="updateDate" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;content：</th>
									<td nowrap="nowrap" align="left"><form:input id="content" path="content" value="${comment.content}"/>&nbsp;<form:errors path="content" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;parentIds：</th>
									<td nowrap="nowrap" align="left"><form:input id="parentIds" path="parentIds" value="${comment.parentIds}"/>&nbsp;<form:errors path="parentIds" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;parentId：</th>
									<td nowrap="nowrap" align="left"><form:input id="parentId" path="parentId" value="${comment.parentId}"/>&nbsp;<form:errors path="parentId" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;hidden：</th>
									<td nowrap="nowrap" align="left"><form:input id="hidden" path="hidden" value="${comment.hidden}"/>&nbsp;<form:errors path="hidden" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/comment'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form:form>		
</body>
</html>