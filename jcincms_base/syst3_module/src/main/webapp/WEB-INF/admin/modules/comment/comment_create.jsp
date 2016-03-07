<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/admin/include/js.jsp"%>
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
<title>comment添加</title>
</head>
<body>
	<form:form id="validForm" action="${ctxAdmin}/comment/create" method="post" commandName="comment">
				<div class="desc">
					<b>comment信息添加</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
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