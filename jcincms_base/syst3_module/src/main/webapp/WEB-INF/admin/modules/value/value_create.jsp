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
				proProperties_id:{
					required : true
				},
				status:{
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
				}
			},messages : {
				id:{
					required : "必填"
				},
				name:{
					required : "必填"
				},
				proProperties_id:{
					required : "必填"
				},
				status:{
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
		$('#proProperties_id').val("");
		$('#status').val("");
		$('#proCategory_id').val("");
		$('#sortid').val("");
		$('#createDate').val("");
		$('#updateDate').val("");
	}
</script>
<title>value添加</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/value/create" method="post">
				<div class="desc">
					<b>value信息添加</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table class="table">
					<tr>
					<th>&nbsp;id：</th>
					<td>
						<input id="id" name="id" 
								value="${value.id}"/>
									&nbsp;<label for="id" style="color:red;">*</label></td>
					<th>&nbsp;name：</th>
					<td>
						<input id="name" name="name" 
								value="${value.name}"/>
									&nbsp;<label for="name" style="color:red;">*</label></td>
					</tr>
					<tr>
					<th>&nbsp;proProperties_id：</th>
					<td>
						<input id="proProperties_id" name="proProperties_id" 
								value="${value.proProperties_id}"/>
									&nbsp;<label for="proProperties_id" style="color:red;">*</label></td>
					<th>&nbsp;status：</th>
					<td>
						<input id="status" name="status" 
								value="${value.status}"/>
									&nbsp;<label for="status" style="color:red;">*</label></td>
					</tr>
					<tr>
					<th>&nbsp;proCategory_id：</th>
					<td>
						<input id="proCategory_id" name="proCategory_id" 
								value="${value.proCategory_id}"/>
									&nbsp;<label for="proCategory_id" style="color:red;">*</label></td>
					<th>&nbsp;sortid：</th>
					<td>
						<input id="sortid" name="sortid" 
								value="${value.sortid}"/>
									&nbsp;<label for="sortid" style="color:red;">*</label></td>
					</tr>
					<tr>
					<th>&nbsp;createDate：</th>
					<td>
						<input id="createDate" name="createDate" 
								value="${value.createDate}"/>
									&nbsp;<label for="createDate" style="color:red;">*</label></td>
					<th>&nbsp;updateDate：</th>
					<td>
						<input id="updateDate" name="updateDate" 
								value="${value.updateDate}"/>
									&nbsp;<label for="updateDate" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th style="width: 150px;">&nbsp;</th>
						<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/value'"/></td>
					</tr>
				</table>	
		</form>		
</body>
</html>