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
				proCategory_id:{
					required : true
				},
				zhName:{
					required : true
				},
				enName:{
					required : true
				},
				status:{
					required : true
				},
				website:{
					required : true
				},
				updateDate:{
					required : true
				},
				createDate:{
					required : true
				},
				description:{
					required : true
				},
				story:{
					required : true
				}
			},messages : {
				id:{
					required : "必填"
				},
				proCategory_id:{
					required : "必填"
				},
				zhName:{
					required : "必填"
				},
				enName:{
					required : "必填"
				},
				status:{
					required : "必填"
				},
				website:{
					required : "必填"
				},
				updateDate:{
					required : "必填"
				},
				createDate:{
					required : "必填"
				},
				description:{
					required : "必填"
				},
				story:{
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
		$('#proCategory_id').val("");
		$('#zhName').val("");
		$('#enName').val("");
		$('#status').val("");
		$('#website').val("");
		$('#updateDate').val("");
		$('#createDate').val("");
		$('#description').val("");
		$('#story').val("");
	}
</script>
<title>brand更新</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/brand/update/${brand.id}" method="post">
				<input name="id" value="${brand.id}" type="hidden" />
				<div class="desc">
					<b>brand信息更新</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table class="table">
					<tr>
						<th>&nbsp;id：</th>
						<td>
							<input id="id" name="id" 
								value="${brand.id}"/>
									&nbsp;<label for="id" style="color:red;">*</label></td>
						<th>&nbsp;proCategory_id：</th>
						<td>
							<input id="proCategory_id" name="proCategory_id" 
								value="${brand.proCategory_id}"/>
									&nbsp;<label for="proCategory_id" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;zhName：</th>
						<td>
							<input id="zhName" name="zhName" 
								value="${brand.zhName}"/>
									&nbsp;<label for="zhName" style="color:red;">*</label></td>
						<th>&nbsp;enName：</th>
						<td>
							<input id="enName" name="enName" 
								value="${brand.enName}"/>
									&nbsp;<label for="enName" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;status：</th>
						<td>
							<input id="status" name="status" 
								value="${brand.status}"/>
									&nbsp;<label for="status" style="color:red;">*</label></td>
						<th>&nbsp;website：</th>
						<td>
							<input id="website" name="website" 
								value="${brand.website}"/>
									&nbsp;<label for="website" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;updateDate：</th>
						<td>
							<input id="updateDate" name="updateDate" 
								value="${brand.updateDate}"/>
									&nbsp;<label for="updateDate" style="color:red;">*</label></td>
						<th>&nbsp;createDate：</th>
						<td>
							<input id="createDate" name="createDate" 
								value="${brand.createDate}"/>
									&nbsp;<label for="createDate" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;description：</th>
						<td>
							<input id="description" name="description" 
								value="${brand.description}"/>
									&nbsp;<label for="description" style="color:red;">*</label></td>
						<th>&nbsp;story：</th>
						<td>
							<input id="story" name="story" 
								value="${brand.story}"/>
									&nbsp;<label for="story" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th style="width: 150px;">&nbsp;</th>
						<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/brand'"/></td>
					</tr>
				</table>	
		</form>		
</body>
</html>