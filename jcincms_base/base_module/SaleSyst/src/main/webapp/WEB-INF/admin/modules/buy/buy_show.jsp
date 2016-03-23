<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	th {
		font-weight: normal;
		font-size: 12px;
	}
</style>
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/icon.css">
<title>buy查看</title>
</head>
<body>
	<form:form id="validForm" commandName="buy">
				<div class="desc">
					<b>buy信息更新</b>
				</div>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;id：</th>
									<td nowrap="nowrap" align="left"><form:input path="id" value="${buy.id}"/>&nbsp;<form:errors path="id" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;createDate：</th>
									<td nowrap="nowrap" align="left"><form:input path="createDate" value="${buy.createDate}"/>&nbsp;<form:errors path="createDate" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;createBy：</th>
									<td nowrap="nowrap" align="left"><form:input path="createBy" value="${buy.createBy}"/>&nbsp;<form:errors path="createBy" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;proId：</th>
									<td nowrap="nowrap" align="left"><form:input path="proId" value="${buy.proId}"/>&nbsp;<form:errors path="proId" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;buyNum：</th>
									<td nowrap="nowrap" align="left"><form:input path="buyNum" value="${buy.buyNum}"/>&nbsp;<form:errors path="buyNum" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;buyAmount：</th>
									<td nowrap="nowrap" align="left"><form:input path="buyAmount" value="${buy.buyAmount}"/>&nbsp;<form:errors path="buyAmount" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;totalAmount：</th>
									<td nowrap="nowrap" align="left"><form:input path="totalAmount" value="${buy.totalAmount}"/>&nbsp;<form:errors path="totalAmount" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/buy'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form:form>		
</body>
</html>