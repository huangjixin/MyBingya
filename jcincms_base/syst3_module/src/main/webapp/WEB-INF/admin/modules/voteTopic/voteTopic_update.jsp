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
<script type="text/javascript"
	src="${ctx}/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/themes/icon.css">
<script type="text/javascript">
	$().ready(function() {

	});

	function clearForm() {
		$('#id').val("");
		$('#type').val("");
		$('#endTime').val("");
		$('#introduction').val("");
		$('#createBy').val("");
		$('#updateBy').val("");
		$('#createDate').val("");
		$('#updateDate').val("");
		$('#name').val("");
	}
</script>
<title>voteTopic更新</title>
</head>
<body>
	<form:form id="validForm"
		action="${ctxAdmin}/voteTopic/update/${voteTopic.id}" method="post"
		commandName="voteTopic">
		<input name="id" value="${voteTopic.id}" type="hidden" />
		<div class="desc">
			<b>voteTopic信息更新</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
		</div>
		<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;" />
		<table width="100%" border="0" cellpadding="2" cellspacing="0">
			<tr>
				<td width="100%">
					<table border="0" cellpadding="3" cellspacing="1" width="100%"
						align="center" style="background-color: #b9d8f3;">
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;id：</th>
							<td nowrap="nowrap" align="left"></td>
							<th>&nbsp;type：</th>
							<td nowrap="nowrap" align="left"><form:input id="type"
									path="type" value="${voteTopic.type}" />&nbsp;<span
								style="color: red;">*</span>&nbsp;<form:errors path="type"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;endTime：</th>
							<td nowrap="nowrap" align="left"><form:input id="endTime"
									path="endTime" value="${voteTopic.endTime}" />&nbsp;<span
								style="color: red;">*</span>&nbsp;<form:errors path="endTime"
									cssStyle="color:red;"></form:errors></td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;introduction：</th>
							<td nowrap="nowrap" align="left"><form:input
									id="introduction" path="introduction"
									value="${voteTopic.introduction}" />&nbsp;<span
								style="color: red;">*</span>&nbsp;<form:errors
									path="introduction" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;createBy：</th>
							<td nowrap="nowrap" align="left"><form:input id="createBy"
									path="createBy" value="${voteTopic.createBy}" />&nbsp;<span
								style="color: red;">*</span>&nbsp;<form:errors path="createBy"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;updateBy：</th>
							<td nowrap="nowrap" align="left"><form:input id="updateBy"
									path="updateBy" value="${voteTopic.updateBy}" />&nbsp;<span
								style="color: red;">*</span>&nbsp;<form:errors path="updateBy"
									cssStyle="color:red;"></form:errors></td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;createDate：</th>
							<td nowrap="nowrap" align="left"><form:input id="createDate"
									path="createDate" value="${voteTopic.createDate}" />&nbsp;<span
								style="color: red;">*</span>&nbsp;<form:errors path="createDate"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;updateDate：</th>
							<td nowrap="nowrap" align="left"><form:input id="updateDate"
									path="updateDate" value="${voteTopic.updateDate}" />&nbsp;<span
								style="color: red;">*</span>&nbsp;<form:errors path="updateDate"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;name：</th>
							<td nowrap="nowrap" align="left"><form:input id="name"
									path="name" value="${voteTopic.name}" />&nbsp;<span
								style="color: red;">*</span>&nbsp;<form:errors path="name"
									cssStyle="color:red;"></form:errors></td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th style="width: 150px;">&nbsp;</th>
							<td style="text-align: left;" colspan="6"><input
								type="submit" value="保存" />&nbsp;&nbsp;<input type="reset"
								value="重置" />&nbsp;&nbsp;<input type="button" value="清空"
								onclick="clearForm();" />&nbsp;&nbsp;<input type="button"
								value="返回"
								onclick="javascript:window.location.href='${ctxAdmin}/voteTopic'" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>