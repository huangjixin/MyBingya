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
				createDate:{
					required : true
				},
				updateDate:{
					required : true
				},
				content:{
					required : true
				},
				orderId:{
					required : true
				}
			},messages : {
				id:{
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
				},
				orderId:{
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
		$('#createDate').val("");
		$('#updateDate').val("");
		$('#content').val("");
		$('#orderId').val("");
	}
</script>
<title>orderComment更新</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/orderComment/update/${orderComment.id}" method="post">
				<input name="id" value="${orderComment.id}" type="hidden" />
				<div class="desc">
					<b>orderComment信息更新</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table class="table">
					<tr>
						<th>&nbsp;id：</th>
						<td>
							<input id="id" name="id" 
								value="${orderComment.id}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;createDate：</th>
						<td>
							<input id="createDate" name="createDate" 
								value="${orderComment.createDate}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;updateDate：</th>
						<td>
							<input id="updateDate" name="updateDate" 
								value="${orderComment.updateDate}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;content：</th>
						<td>
							<input id="content" name="content" 
								value="${orderComment.content}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;orderId：</th>
						<td>
							<input id="orderId" name="orderId" 
								value="${orderComment.orderId}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					<tr>
						<th style="width: 150px;">&nbsp;</th>
						<td  style="text-align: left;" colspan="6">&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/orderComment'"/></td>
					</tr>
				</table>	
		</form>		
</body>
</html>