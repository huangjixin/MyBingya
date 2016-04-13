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
				}
			},messages : {
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
	}
</script>
<title>留言板新增</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/guestbook/create" method="post">
				<div class="desc">
					<b>留言板信息新增</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table class="table">
					<tr>
						<th>&nbsp;主题：</th>
						<td>
							<input id="topic" name="topic" 
								value="${guestbook.topic}" class="input"/>
									&nbsp;<label for="topic" style="color:red;">*</label></td>
						<th>&nbsp;电话：</th>
						<td>
							<input id="tel" name="tel" 
								value="${guestbook.tel}" class="input"/>
									&nbsp;<label for="guestbook" style="color:red;">*</label>
					</tr>
					<tr>
						<th>&nbsp;内容：</th>
						<td colspan="4">
							<textarea id="content" name="content" 
									class="descrition">${guestbook.content}</textarea>
									&nbsp;<label for="content" style="color:red;">*</label></td>
						</td>
					</tr>
					<tr>
						<th>&nbsp;qq：</th>
						<td>
							<input id="qq" name="qq" 
								value="${guestbook.qq}" class="input"/>
									&nbsp;<label for="qq" style="color:red;">*</label></td>
						<th>&nbsp;名称：</th>
						<td>
							<input id="name" name="name" 
								value="${guestbook.name}" class="input"/>
									&nbsp;<label for="name" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;email：</th>
						<td colspan="4">
							<input id="email" name="email" 
								value="${guestbook.email}" class="input"/>
									&nbsp;<label for="email" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th style="width: 150px;">&nbsp;</th>
						<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/guestbook'"/></td>
					</tr>
				</table>	
		</form>		
</body>
</html>