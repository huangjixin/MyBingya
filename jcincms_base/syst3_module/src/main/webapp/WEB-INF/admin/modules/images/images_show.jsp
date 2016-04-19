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
				site:{
					required : true
				},
				proProduct_id:{
					required : true
				},
				position:{
					required : true
				},
				sortid:{
					required : true
				},
				ismasterpic:{
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
				site:{
					required : "必填"
				},
				proProduct_id:{
					required : "必填"
				},
				position:{
					required : "必填"
				},
				sortid:{
					required : "必填"
				},
				ismasterpic:{
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
		$('#site').val("");
		$('#proProduct_id').val("");
		$('#position').val("");
		$('#sortid').val("");
		$('#ismasterpic').val("");
		$('#createDate').val("");
		$('#updateDate').val("");
	}
</script>
<title>images更新</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/images/update/${images.id}" method="post">
				<input name="id" value="${images.id}" type="hidden" />
				<div class="desc">
					<b>images信息更新</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table class="table">
					<tr>
						<th>&nbsp;id：</th>
						<td>
							<input id="id" name="id" 
								value="${images.id}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;site：</th>
						<td>
							<input id="site" name="site" 
								value="${images.site}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;proProduct_id：</th>
						<td>
							<input id="proProduct_id" name="proProduct_id" 
								value="${images.proProduct_id}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;position：</th>
						<td>
							<input id="position" name="position" 
								value="${images.position}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;sortid：</th>
						<td>
							<input id="sortid" name="sortid" 
								value="${images.sortid}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;ismasterpic：</th>
						<td>
							<input id="ismasterpic" name="ismasterpic" 
								value="${images.ismasterpic}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;createDate：</th>
						<td>
							<input id="createDate" name="createDate" 
								value="${images.createDate}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;updateDate：</th>
						<td>
							<input id="updateDate" name="updateDate" 
								value="${images.updateDate}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					</tr>
					<tr>
						<th style="width: 150px;">&nbsp;</th>
						<td  style="text-align: left;" colspan="6">&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/images'"/></td>
					</tr>
				</table>	
		</form>		
</body>
</html>