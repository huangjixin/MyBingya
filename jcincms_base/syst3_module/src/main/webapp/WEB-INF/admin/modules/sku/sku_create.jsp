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
				productId:{
					required : true
				},
				counts:{
					required : true
				},
				price:{
					required : true
				},
				name:{
					required : true
				},
				status:{
					required : true
				}
			},messages : {
				id:{
					required : "必填"
				},
				productId:{
					required : "必填"
				},
				counts:{
					required : "必填"
				},
				price:{
					required : "必填"
				},
				name:{
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
		$('#productId').val("");
		$('#counts').val("");
		$('#price').val("");
		$('#name').val("");
		$('#status').val("");
	}
</script>
<title>sku添加</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/sku/create" method="post">
				<div class="desc">
					<b>sku信息添加</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table class="table">
					<tr>
					<th>&nbsp;id：</th>
					<td>
						<input id="id" name="id" 
								value="${sku.id}"/>
									&nbsp;<label for="id" style="color:red;">*</label></td>
					<th>&nbsp;productId：</th>
					<td>
						<input id="productId" name="productId" 
								value="${sku.productId}"/>
									&nbsp;<label for="productId" style="color:red;">*</label></td>
					</tr>
					<tr>
					<th>&nbsp;counts：</th>
					<td>
						<input id="counts" name="counts" 
								value="${sku.counts}"/>
									&nbsp;<label for="counts" style="color:red;">*</label></td>
					<th>&nbsp;price：</th>
					<td>
						<input id="price" name="price" 
								value="${sku.price}"/>
									&nbsp;<label for="price" style="color:red;">*</label></td>
					</tr>
					<tr>
					<th>&nbsp;name：</th>
					<td>
						<input id="name" name="name" 
								value="${sku.name}"/>
									&nbsp;<label for="name" style="color:red;">*</label></td>
					<th>&nbsp;status：</th>
					<td>
						<input id="status" name="status" 
								value="${sku.status}"/>
									&nbsp;<label for="status" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th style="width: 150px;">&nbsp;</th>
						<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/sku'"/></td>
					</tr>
				</table>	
		</form>		
</body>
</html>