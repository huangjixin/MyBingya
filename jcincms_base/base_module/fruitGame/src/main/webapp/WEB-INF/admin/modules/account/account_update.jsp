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
		$('#total').val("");
		$('#createDate').val("");
		$('#updateDate').val("");
		$('#description').val("");
		$('#createBy').val("");
		$('#updateBy').val("");
		$('#username').val("");
	}
</script>
<title>account更新</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/account/update/${account.id}" method="post">
				<input name="id" value="${account.id}" type="hidden" />
				<div class="desc">
					<b>account信息更新</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;id：</th>
									<td nowrap="nowrap" align="left"><input id="id" name="id" value="${account.id}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;total：</th>
									<td nowrap="nowrap" align="left"><input id="total" name="total" value="${account.total}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;createDate：</th>
									<td nowrap="nowrap" align="left"><input id="createDate" name="createDate" value="${account.createDate}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;updateDate：</th>
									<td nowrap="nowrap" align="left"><input id="updateDate" name="updateDate" value="${account.updateDate}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;description：</th>
									<td nowrap="nowrap" align="left"><input id="description" name="description" value="${account.description}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;createBy：</th>
									<td nowrap="nowrap" align="left"><input id="createBy" name="createBy" value="${account.createBy}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;updateBy：</th>
									<td nowrap="nowrap" align="left"><input id="updateBy" name="updateBy" value="${account.updateBy}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;username：</th>
									<td nowrap="nowrap" align="left"><input id="username" name="username" value="${account.username}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/account'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form>		
</body>
</html>