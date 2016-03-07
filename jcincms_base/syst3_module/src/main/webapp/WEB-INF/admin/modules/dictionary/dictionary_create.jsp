<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/admin/include/js.jsp"%>
<title>字典创建</title>
</head>
<body>
	<form:form id="validForm" action="${ctxAdmin}/dictionary/create" method="post" commandName="dictionary">
				<div class="desc">
					<b>字典信息添加</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;类型：</th>
									<td nowrap="nowrap" align="left"><form:input path="type" value="${dictionary.type}"/>&nbsp;<form:errors path="type" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;键：</th>
									<td nowrap="nowrap" align="left"><form:input path="label" value="${dictionary.label}"/>&nbsp;<form:errors path="label" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;值：</th>
									<td nowrap="nowrap" align="left"><form:input path="value" value="${dictionary.value}"/>&nbsp;<form:errors path="value" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/dictionary'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form:form>		
</body>
</html>