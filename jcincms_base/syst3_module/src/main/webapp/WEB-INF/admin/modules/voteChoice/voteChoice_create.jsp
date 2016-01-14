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
		$('#name').val("");
		$('#voteCount').val("");
		$('#createBy').val("");
		$('#updateBy').val("");
		$('#createDate').val("");
		$('#updateDate').val("");
		$('#image').val("");
		$('#tbVoteTopicId').val("");
	}
</script>
<title>voteChoice添加</title>
</head>
<body>
	<form:form id="validForm" action="${ctxAdmin}/voteChoice/create" method="post" commandName="voteChoice">
				<div class="desc">
					<b>voteChoice信息添加</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;id：</th>
									<td nowrap="nowrap" align="left"><form:input id="id" path="id" value="${voteChoice.id}"/>&nbsp;<span style="color: red;">*</span>&nbsp;<form:errors path="id" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;name：</th>
									<td nowrap="nowrap" align="left"><form:input id="name" path="name" value="${voteChoice.name}"/>&nbsp;<span style="color: red;">*</span>&nbsp;<form:errors path="name" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;voteCount：</th>
									<td nowrap="nowrap" align="left"><form:input id="voteCount" path="voteCount" value="${voteChoice.voteCount}"/>&nbsp;<span style="color: red;">*</span>&nbsp;<form:errors path="voteCount" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;createBy：</th>
									<td nowrap="nowrap" align="left"><form:input id="createBy" path="createBy" value="${voteChoice.createBy}"/>&nbsp;<span style="color: red;">*</span>&nbsp;<form:errors path="createBy" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;updateBy：</th>
									<td nowrap="nowrap" align="left"><form:input id="updateBy" path="updateBy" value="${voteChoice.updateBy}"/>&nbsp;<span style="color: red;">*</span>&nbsp;<form:errors path="updateBy" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;createDate：</th>
									<td nowrap="nowrap" align="left"><form:input id="createDate" path="createDate" value="${voteChoice.createDate}"/>&nbsp;<span style="color: red;">*</span>&nbsp;<form:errors path="createDate" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;updateDate：</th>
									<td nowrap="nowrap" align="left"><form:input id="updateDate" path="updateDate" value="${voteChoice.updateDate}"/>&nbsp;<span style="color: red;">*</span>&nbsp;<form:errors path="updateDate" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;image：</th>
									<td nowrap="nowrap" align="left"><form:input id="image" path="image" value="${voteChoice.image}"/>&nbsp;<span style="color: red;">*</span>&nbsp;<form:errors path="image" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;tbVoteTopicId：</th>
									<td nowrap="nowrap" align="left"><form:input id="tbVoteTopicId" path="tbVoteTopicId" value="${voteChoice.tbVoteTopicId}"/>&nbsp;<span style="color: red;">*</span>&nbsp;<form:errors path="tbVoteTopicId" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/voteChoice'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form:form>		
</body>
</html>