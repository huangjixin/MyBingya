<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/admin/include/js.jsp"%>
<script type="text/javascript">
	$().ready(function() {
		validateForm();
	});

	function validateForm() {
		$("#validForm").validate(
				{
					errorPlacement : function(error, element) {
						$(element).closest("form").find(
								"label[for='" + element.attr("id") + "']")
								.append(error);
					},
					errorElement : "span",
					rules : {
						name : {
							required : true
						},
						description : {
							required : true
						}
					},
					messages : {
						name : {
							required : "必填"
						},
						description : {
							required : "必填"
						}
					},
					submitHandler : function(form) {
						return true;
					}
				})
	}
	function clearForm() {
		$('#name').val("");
		$('#description').val("");
	}
</script>
<title>会员级别添加</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/memberLebel/create"
		method="post">
		<div class="desc">
			<b>会员级别信息添加</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
		</div>
		<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;" />
		<table class="table">
			<tr>
				<th>&nbsp;级别名称：</th>
				<td><input id="name" name="name" value="${memberLebel.name}" />
					&nbsp;<label for="name" style="color:red;">*</label></td>
			</tr>
			<tr>
				<th>&nbsp;描述：</th>
				<td><input id="description" name="description"
					value="${memberLebel.description}" /> &nbsp;<label
					for="description" style="color:red;">*</label></td>
			</tr>
			<tr>
				<th style="width: 150px;">&nbsp;</th>
				<td style="text-align: left;" colspan="6"><input type="submit"
					value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input
					type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input
					type="button" value="返回"
					onclick="javascript:window.location.href='${ctxAdmin}/memberLebel'" /></td>
			</tr>
		</table>
	</form>
</body>
</html>