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
				<#list introspectedColumns as introspectedColumn>
				${introspectedColumn}:{
					required : true
				}<#if ((introspectedColumn_index+1)<(introspectedColumns?size))>,</#if>
				</#list>
			},messages : {
				<#list introspectedColumns as introspectedColumn>
				${introspectedColumn}:{
					required : "必填"
				}<#if ((introspectedColumn_index+1)<(introspectedColumns?size))>,</#if>
				</#list>
			},
			submitHandler : function(form) {
					return true;
				}
			})
	}
	
	function clearForm(){
		<#list introspectedColumns as introspectedColumn>
		$('#${introspectedColumn}').val("");
		</#list>
	}
</script>
<title>${objInst}更新</title>
</head>
<body>
	<form id="validForm" action="${r'${ctxAdmin}'}/${objInst}/update/${r'${'}${objInst}.id}" method="post">
				<input name="id" value="${r'${'}${objInst}.id}" type="hidden" />
				<div class="desc">
					<b>${objInst}信息更新</b>&nbsp;&nbsp;<b style="color: red;">${r'${msg}'}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<#assign iSum=0>
								<#list introspectedColumns as introspectedColumn>
								<#if (iSum%3==0)>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
								</#if>
									<th>&nbsp;${introspectedColumn}：</th>
									<td nowrap="nowrap" align="left"><input id="${introspectedColumn}" name="${introspectedColumn}" value="${r'${'}${objInst}.${introspectedColumn}}"/>&nbsp;<span style="color: red;">*</span></td>
								<#if (iSum%3!=0 && iSum%3==2)>
								</tr>
								</#if>
								<#assign iSum=iSum+1>
								</#list>
								<#if (iSum%3!=0)>
								</tr>
								</#if>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${r'${ctxAdmin}'}/${objInst}'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form>		
</body>
</html>