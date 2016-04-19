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
				skuId:{
					required : true
				},
				counts:{
					required : true
				},
				price:{
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
				skuId:{
					required : "必填"
				},
				counts:{
					required : "必填"
				},
				price:{
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
		$('#skuId').val("");
		$('#counts').val("");
		$('#price').val("");
		$('#createDate').val("");
		$('#updateDate').val("");
	}
</script>
<title>proPackage更新</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/proPackage/update/${proPackage.id}" method="post">
				<input name="id" value="${proPackage.id}" type="hidden" />
				<div class="desc">
					<b>proPackage信息更新</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table class="table">
					<tr>
						<th>&nbsp;id：</th>
						<td>
							<input id="id" name="id" 
								value="${proPackage.id}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;skuId：</th>
						<td>
							<input id="skuId" name="skuId" 
								value="${proPackage.skuId}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;counts：</th>
						<td>
							<input id="counts" name="counts" 
								value="${proPackage.counts}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;price：</th>
						<td>
							<input id="price" name="price" 
								value="${proPackage.price}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;createDate：</th>
						<td>
							<input id="createDate" name="createDate" 
								value="${proPackage.createDate}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;updateDate：</th>
						<td>
							<input id="updateDate" name="updateDate" 
								value="${proPackage.updateDate}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					</tr>
					<tr>
						<th style="width: 150px;">&nbsp;</th>
						<td  style="text-align: left;" colspan="6">&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/proPackage'"/></td>
					</tr>
				</table>	
		</form>		
</body>
</html>