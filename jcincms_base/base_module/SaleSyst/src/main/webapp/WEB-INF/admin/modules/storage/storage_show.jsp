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
				proName:{
					required : true
				},
				proId:{
					required : true
				},
				buyId:{
					required : true
				},
				saleId:{
					required : true
				},
				procount:{
					required : true
				}
			},messages : {
				id:{
					required : "必填"
				},
				proName:{
					required : "必填"
				},
				proId:{
					required : "必填"
				},
				buyId:{
					required : "必填"
				},
				saleId:{
					required : "必填"
				},
				procount:{
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
		$('#proName').val("");
		$('#proId').val("");
		$('#buyId').val("");
		$('#saleId').val("");
		$('#procount').val("");
	}
</script>
<title>storage添加</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/storage/create" method="post">
				<div class="desc">
					<b>storage信息添加</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;id：</th>
									<td nowrap="nowrap" align="left">
									<input id="id" 
										   name="id" 
										   value="${storage.id}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
									<th>&nbsp;proName：</th>
									<td nowrap="nowrap" align="left">
									<input id="proName" 
										   name="proName" 
										   value="${storage.proName}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
									<th>&nbsp;proId：</th>
									<td nowrap="nowrap" align="left">
									<input id="proId" 
										   name="proId" 
										   value="${storage.proId}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;buyId：</th>
									<td nowrap="nowrap" align="left">
									<input id="buyId" 
										   name="buyId" 
										   value="${storage.buyId}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
									<th>&nbsp;saleId：</th>
									<td nowrap="nowrap" align="left">
									<input id="saleId" 
										   name="saleId" 
										   value="${storage.saleId}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
									<th>&nbsp;procount：</th>
									<td nowrap="nowrap" align="left">
									<input id="procount" 
										   name="procount" 
										   value="${storage.procount}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/storage'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form>		
</body>
</html>