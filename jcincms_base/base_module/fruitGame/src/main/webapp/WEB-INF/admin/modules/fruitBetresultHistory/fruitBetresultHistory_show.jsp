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
<title>fruitBetresultHistory查看</title>
</head>
<body>
	<form:form id="validForm" commandName="fruitBetresultHistory">
				<div class="desc">
					<b>fruitBetresultHistory信息更新</b>
				</div>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;id：</th>
									<td nowrap="nowrap" align="left"><form:input path="id" value="${fruitBetresultHistory.id}"/>&nbsp;<form:errors path="id" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;createDate：</th>
									<td nowrap="nowrap" align="left"><form:input path="createDate" value="${fruitBetresultHistory.createDate}"/>&nbsp;<form:errors path="createDate" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;createBy：</th>
									<td nowrap="nowrap" align="left"><form:input path="createBy" value="${fruitBetresultHistory.createBy}"/>&nbsp;<form:errors path="createBy" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;updateDate：</th>
									<td nowrap="nowrap" align="left"><form:input path="updateDate" value="${fruitBetresultHistory.updateDate}"/>&nbsp;<form:errors path="updateDate" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;updateBy：</th>
									<td nowrap="nowrap" align="left"><form:input path="updateBy" value="${fruitBetresultHistory.updateBy}"/>&nbsp;<form:errors path="updateBy" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;da：</th>
									<td nowrap="nowrap" align="left"><form:input path="da" value="${fruitBetresultHistory.da}"/>&nbsp;<form:errors path="da" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;xiao：</th>
									<td nowrap="nowrap" align="left"><form:input path="xiao" value="${fruitBetresultHistory.xiao}"/>&nbsp;<form:errors path="xiao" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;dan：</th>
									<td nowrap="nowrap" align="left"><form:input path="dan" value="${fruitBetresultHistory.dan}"/>&nbsp;<form:errors path="dan" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;shuang：</th>
									<td nowrap="nowrap" align="left"><form:input path="shuang" value="${fruitBetresultHistory.shuang}"/>&nbsp;<form:errors path="shuang" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;pingguo：</th>
									<td nowrap="nowrap" align="left"><form:input path="pingguo" value="${fruitBetresultHistory.pingguo}"/>&nbsp;<form:errors path="pingguo" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;putao：</th>
									<td nowrap="nowrap" align="left"><form:input path="putao" value="${fruitBetresultHistory.putao}"/>&nbsp;<form:errors path="putao" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;boluo：</th>
									<td nowrap="nowrap" align="left"><form:input path="boluo" value="${fruitBetresultHistory.boluo}"/>&nbsp;<form:errors path="boluo" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;caomei：</th>
									<td nowrap="nowrap" align="left"><form:input path="caomei" value="${fruitBetresultHistory.caomei}"/>&nbsp;<form:errors path="caomei" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;xigua：</th>
									<td nowrap="nowrap" align="left"><form:input path="xigua" value="${fruitBetresultHistory.xigua}"/>&nbsp;<form:errors path="xigua" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;xiangjiao：</th>
									<td nowrap="nowrap" align="left"><form:input path="xiangjiao" value="${fruitBetresultHistory.xiangjiao}"/>&nbsp;<form:errors path="xiangjiao" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;description：</th>
									<td nowrap="nowrap" align="left"><form:input path="description" value="${fruitBetresultHistory.description}"/>&nbsp;<form:errors path="description" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;username：</th>
									<td nowrap="nowrap" align="left"><form:input path="username" value="${fruitBetresultHistory.username}"/>&nbsp;<form:errors path="username" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;userId：</th>
									<td nowrap="nowrap" align="left"><form:input path="userId" value="${fruitBetresultHistory.userId}"/>&nbsp;<form:errors path="userId" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/fruitBetresultHistory'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form:form>		
</body>
</html>