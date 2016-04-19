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
				proProduct_id:{
					required : true
				},
				proProerties_id:{
					required : true
				},
				proValue_id:{
					required : true
				},
				isSku:{
					required : true
				},
				skuId:{
					required : true
				}
			},messages : {
				id:{
					required : "必填"
				},
				proProduct_id:{
					required : "必填"
				},
				proProerties_id:{
					required : "必填"
				},
				proValue_id:{
					required : "必填"
				},
				isSku:{
					required : "必填"
				},
				skuId:{
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
		$('#proProduct_id').val("");
		$('#proProerties_id').val("");
		$('#proValue_id').val("");
		$('#isSku').val("");
		$('#skuId').val("");
	}
</script>
<title>productValue更新</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/productValue/update/${productValue.id}" method="post">
				<input name="id" value="${productValue.id}" type="hidden" />
				<div class="desc">
					<b>productValue信息更新</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table class="table">
					<tr>
						<th>&nbsp;id：</th>
						<td>
							<input id="id" name="id" 
								value="${productValue.id}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;proProduct_id：</th>
						<td>
							<input id="proProduct_id" name="proProduct_id" 
								value="${productValue.proProduct_id}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;proProerties_id：</th>
						<td>
							<input id="proProerties_id" name="proProerties_id" 
								value="${productValue.proProerties_id}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;proValue_id：</th>
						<td>
							<input id="proValue_id" name="proValue_id" 
								value="${productValue.proValue_id}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;isSku：</th>
						<td>
							<input id="isSku" name="isSku" 
								value="${productValue.isSku}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;skuId：</th>
						<td>
							<input id="skuId" name="skuId" 
								value="${productValue.skuId}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					</tr>
					<tr>
						<th style="width: 150px;">&nbsp;</th>
						<td  style="text-align: left;" colspan="6">&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/productValue'"/></td>
					</tr>
				</table>	
		</form>		
</body>
</html>