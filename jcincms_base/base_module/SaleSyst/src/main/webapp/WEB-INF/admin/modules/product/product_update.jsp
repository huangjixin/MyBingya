<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/admin/include/js.jsp"%>
<script type="text/javascript">
	$().ready(function() {
		var cDate = '${sale.createDate}';
		if(cDate!=""){
			$("#createDateInput").datebox("setValue",toDate(cDate));
		}
	});

	function clearForm() {
		$('#id').val("");
		$('#name').val("");
		$('#createDate').val("");
		$('#createBy').val("");
		$('#parentId').val("");
		$('#description').val("");
	}
</script>
<title>商品更新</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/product/update/${product.id}"
		method="post">
		<input name="id" value="${product.id}" type="hidden" />
		<div class="desc">
			<b>商品信息更新</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
		</div>
		<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;" />
		<table width="100%" border="0" cellpadding="2" cellspacing="0">
			<tr>
				<td width="100%">
					<table border="0" cellpadding="3" cellspacing="1" width="100%"
						align="center" style="background-color: #b9d8f3;">
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;商品名称：</th>
							<td nowrap="nowrap" align="left"><input id="name"
								name="name" value="${product.name}" />&nbsp;<span
								style="color: red;">*</span></td>
							<th>&nbsp;商品描述：</th>
							<td nowrap="nowrap" align="left"><input id="description"
								name="description" value="${product.description}" />&nbsp;<span
								style="color: red;">*</span></td>
							<th>&nbsp;</th>
							<td nowrap="nowrap" align="left"></td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th style="width: 150px;">&nbsp;</th>
							<td style="text-align: left;" colspan="6"><input
								type="submit" value="保存" />&nbsp;&nbsp;<input type="reset"
								value="重置" />&nbsp;&nbsp;<input type="button" value="清空"
								onclick="clearForm();" />&nbsp;&nbsp;<input type="button"
								value="返回"
								onclick="javascript:window.location.href='${ctxAdmin}/product'" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>