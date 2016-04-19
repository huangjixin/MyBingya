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

	function validateForm(){
		$("#validForm").validate({
			errorPlacement : function(error,element) {
				$(element).closest("form").find("label[for='"+ element.attr("id")+ "']").append(error);
			},errorElement : "span",
			rules : {
								id:{
					required : true
				},
				name:{
					required : true
				},
				proBrand_id:{
					required : true
				},
				createDate:{
					required : true
				},
				updateDate:{
					required : true
				},
				content:{
					required : true
				}
			},messages : {
				id:{
					required : "必填"
				},
				name:{
					required : "必填"
				},
				proBrand_id:{
					required : "必填"
				},
				createDate:{
					required : "必填"
				},
				updateDate:{
					required : "必填"
				},
				content:{
					required : "必填"
				}
			},
			submitHandler : function(form) {
					return true;
				}
			})
	}
	
	function clearForm(){
		$('#id').val("");
		$('#name').val("");
		$('#proBrand_id').val("");
		$('#createDate').val("");
		$('#updateDate').val("");
		$('#content').val("");
	}
</script>
<title>product更新</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/product/update/${product.id}" method="post">
				<input name="id" value="${product.id}" type="hidden" />
				<div class="desc">
					<b>product信息更新</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table class="table">
					<tr>
						<th>&nbsp;id：</th>
						<td>
							<input id="id" name="id" 
								value="${product.id}"/>
									&nbsp;<label for="id" style="color:red;">*</label></td>
						<th>&nbsp;name：</th>
						<td>
							<input id="name" name="name" 
								value="${product.name}"/>
									&nbsp;<label for="name" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;proBrand_id：</th>
						<td>
							<input id="proBrand_id" name="proBrand_id" 
								value="${product.proBrand_id}"/>
									&nbsp;<label for="proBrand_id" style="color:red;">*</label></td>
						<th>&nbsp;createDate：</th>
						<td>
							<input id="createDate" name="createDate" 
								value="${product.createDate}"/>
									&nbsp;<label for="createDate" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;updateDate：</th>
						<td>
							<input id="updateDate" name="updateDate" 
								value="${product.updateDate}"/>
									&nbsp;<label for="updateDate" style="color:red;">*</label></td>
						<th>&nbsp;content：</th>
						<td>
							<input id="content" name="content" 
								value="${product.content}"/>
									&nbsp;<label for="content" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th style="width: 150px;">&nbsp;</th>
						<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/product'"/></td>
					</tr>
				</table>	
		</form>		
</body>
</html>