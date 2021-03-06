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
				proId:{
					required : true
				},
				saleAmount:{
					required : true
				},
				totalAmount:{
					required : true
				},
				createDate:{
					required : true
				},
				createBy:{
					required : true
				},
				saleNum:{
					required : true
				},
				proName:{
					required : true
				}
			},messages : {
				id:{
					required : "必填"
				},
				proId:{
					required : "必填"
				},
				saleAmount:{
					required : "必填"
				},
				totalAmount:{
					required : "必填"
				},
				createDate:{
					required : "必填"
				},
				createBy:{
					required : "必填"
				},
				saleNum:{
					required : "必填"
				},
				proName:{
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
		$('#proId').val("");
		$('#saleAmount').val("");
		$('#totalAmount').val("");
		$('#createDate').val("");
		$('#createBy').val("");
		$('#saleNum').val("");
		$('#proName').val("");
	}
</script>
<title>sale添加</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/sale/create" method="post">
				<div class="desc">
					<b>sale信息添加</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
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
										   value="${sale.id}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
									<th>&nbsp;proId：</th>
									<td nowrap="nowrap" align="left">
									<input id="proId" 
										   name="proId" 
										   value="${sale.proId}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
									<th>&nbsp;saleAmount：</th>
									<td nowrap="nowrap" align="left">
									<input id="saleAmount" 
										   name="saleAmount" 
										   value="${sale.saleAmount}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;totalAmount：</th>
									<td nowrap="nowrap" align="left">
									<input id="totalAmount" 
										   name="totalAmount" 
										   value="${sale.totalAmount}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
									<th>&nbsp;createDate：</th>
									<td nowrap="nowrap" align="left">
									<input id="createDate" 
										   name="createDate" 
										   value="${sale.createDate}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
									<th>&nbsp;createBy：</th>
									<td nowrap="nowrap" align="left">
									<input id="createBy" 
										   name="createBy" 
										   value="${sale.createBy}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;saleNum：</th>
									<td nowrap="nowrap" align="left">
									<input id="saleNum" 
										   name="saleNum" 
										   value="${sale.saleNum}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
									<th>&nbsp;proName：</th>
									<td nowrap="nowrap" align="left">
									<input id="proName" 
										   name="proName" 
										   value="${sale.proName}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/sale'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form>		
</body>
</html>