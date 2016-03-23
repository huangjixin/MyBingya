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
		$('#result').val("");
		$('#createDate').val("");
		$('#createBy').val("");
		$('#updateDate').val("");
		$('#updateBy').val("");
		$('#description').val("");
	}
</script>
<title>fruitRecord添加</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/fruitRecord/create" method="post">
				<div class="desc">
					<b>fruitRecord信息添加</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;id：</th>
									<td nowrap="nowrap" align="left"><input id="id" name="id" value="${fruitRecord.id}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;result：</th>
									<td nowrap="nowrap" align="left"><input id="result" name="result" value="${fruitRecord.result}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;createDate：</th>
									<td nowrap="nowrap" align="left"><input id="createDate" name="createDate" value="${fruitRecord.createDate}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;createBy：</th>
									<td nowrap="nowrap" align="left"><input id="createBy" name="createBy" value="${fruitRecord.createBy}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;updateDate：</th>
									<td nowrap="nowrap" align="left"><input id="updateDate" name="updateDate" value="${fruitRecord.updateDate}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;updateBy：</th>
									<td nowrap="nowrap" align="left"><input id="updateBy" name="updateBy" value="${fruitRecord.updateBy}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;description：</th>
									<td nowrap="nowrap" align="left"><input id="description" name="description" value="${fruitRecord.description}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/fruitRecord'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form>		
</body>
</html>