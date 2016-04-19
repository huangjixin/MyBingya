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
				proCategory_id:{
					required : true
				},
				sortid:{
					required : true
				},
				createDate:{
					required : true
				},
				updateDate:{
					required : true
				},
				status:{
					required : true
				}
			},messages : {
				id:{
					required : "必填"
				},
				name:{
					required : "必填"
				},
				proCategory_id:{
					required : "必填"
				},
				sortid:{
					required : "必填"
				},
				createDate:{
					required : "必填"
				},
				updateDate:{
					required : "必填"
				},
				status:{
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
		$('#proCategory_id').val("");
		$('#sortid').val("");
		$('#createDate').val("");
		$('#updateDate').val("");
		$('#status').val("");
	}
</script>
<title>properties更新</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/properties/update/${properties.id}" method="post">
				<input name="id" value="${properties.id}" type="hidden" />
				<div class="desc">
					<b>properties信息更新</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table class="table">
					<tr>
						<th>&nbsp;id：</th>
						<td>
							<input id="id" name="id" 
								value="${properties.id}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;name：</th>
						<td>
							<input id="name" name="name" 
								value="${properties.name}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;proCategory_id：</th>
						<td>
							<input id="proCategory_id" name="proCategory_id" 
								value="${properties.proCategory_id}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;sortid：</th>
						<td>
							<input id="sortid" name="sortid" 
								value="${properties.sortid}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;createDate：</th>
						<td>
							<input id="createDate" name="createDate" 
								value="${properties.createDate}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;updateDate：</th>
						<td>
							<input id="updateDate" name="updateDate" 
								value="${properties.updateDate}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;status：</th>
						<td>
							<input id="status" name="status" 
								value="${properties.status}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					<tr>
						<th style="width: 150px;">&nbsp;</th>
						<td  style="text-align: left;" colspan="6">&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/properties'"/></td>
					</tr>
				</table>	
		</form>		
</body>
</html>