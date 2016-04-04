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
				topic:{
					required : true
				},
				content:{
					required : true
				},
				tel:{
					required : true
				},
				qq:{
					required : true
				},
				name:{
					required : true
				},
				email:{
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
				topic:{
					required : "必填"
				},
				content:{
					required : "必填"
				},
				tel:{
					required : "必填"
				},
				qq:{
					required : "必填"
				},
				name:{
					required : "必填"
				},
				email:{
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
		$('#topic').val("");
		$('#content').val("");
		$('#tel').val("");
		$('#qq').val("");
		$('#name').val("");
		$('#email').val("");
		$('#createDate').val("");
		$('#updateDate').val("");
	}
</script>
<title>guestbook更新</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/guestbook/update/${guestbook.id}" method="post">
				<input name="id" value="${guestbook.id}" type="hidden" />
				<div class="desc">
					<b>guestbook信息更新</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table class="table">
					<tr>
						<th>&nbsp;id：</th>
						<td>
							<input id="id" name="id" 
								value="${guestbook.id}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;topic：</th>
						<td>
							<input id="topic" name="topic" 
								value="${guestbook.topic}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;content：</th>
						<td>
							<input id="content" name="content" 
								value="${guestbook.content}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;tel：</th>
						<td>
							<input id="tel" name="tel" 
								value="${guestbook.tel}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;qq：</th>
						<td>
							<input id="qq" name="qq" 
								value="${guestbook.qq}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;name：</th>
						<td>
							<input id="name" name="name" 
								value="${guestbook.name}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;email：</th>
						<td>
							<input id="email" name="email" 
								value="${guestbook.email}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
						<th>&nbsp;createDate：</th>
						<td>
							<input id="createDate" name="createDate" 
								value="${guestbook.createDate}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;updateDate：</th>
						<td>
							<input id="updateDate" name="updateDate" 
								value="${guestbook.updateDate}"/>
									&nbsp;<label for="proName" style="color:red;">*</label></td>
					<tr>
						<th style="width: 150px;">&nbsp;</th>
						<td  style="text-align: left;" colspan="6">&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/guestbook'"/></td>
					</tr>
				</table>	
		</form>		
</body>
</html>