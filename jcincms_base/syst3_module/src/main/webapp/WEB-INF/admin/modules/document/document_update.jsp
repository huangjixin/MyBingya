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
<title>document更新</title>
</head>
<body>
	<form:form id="validForm" action="${ctxAdmin}/document/update/${document.id}" method="post" commandName="document">
				<input name="id" value="${document.id}" type="hidden" />
				<div class="desc">
					<b>document信息更新</b>&nbsp;&nbsp;<b>${msg}</b>
				</div>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;id：</th>
									<td nowrap="nowrap" align="left"><form:input path="id" value="${document.id}"/>&nbsp;<form:errors path="id" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;channelId：</th>
									<td nowrap="nowrap" align="left"><form:input path="channelId" value="${document.channelId}"/>&nbsp;<form:errors path="channelId" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;title：</th>
									<td nowrap="nowrap" align="left"><form:input path="title" value="${document.title}"/>&nbsp;<form:errors path="title" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;color：</th>
									<td nowrap="nowrap" align="left"><form:input path="color" value="${document.color}"/>&nbsp;<form:errors path="color" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;keyword：</th>
									<td nowrap="nowrap" align="left"><form:input path="keyword" value="${document.keyword}"/>&nbsp;<form:errors path="keyword" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;desc：</th>
									<td nowrap="nowrap" align="left"><form:input path="desc" value="${document.desc}"/>&nbsp;<form:errors path="desc" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;priority：</th>
									<td nowrap="nowrap" align="left"><form:input path="priority" value="${document.priority}"/>&nbsp;<form:errors path="priority" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;source：</th>
									<td nowrap="nowrap" align="left"><form:input path="source" value="${document.source}"/>&nbsp;<form:errors path="source" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;sourceAddr：</th>
									<td nowrap="nowrap" align="left"><form:input path="sourceAddr" value="${document.sourceAddr}"/>&nbsp;<form:errors path="sourceAddr" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;author：</th>
									<td nowrap="nowrap" align="left"><form:input path="author" value="${document.author}"/>&nbsp;<form:errors path="author" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;titleImage：</th>
									<td nowrap="nowrap" align="left"><form:input path="titleImage" value="${document.titleImage}"/>&nbsp;<form:errors path="titleImage" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;fileName：</th>
									<td nowrap="nowrap" align="left"><form:input path="fileName" value="${document.fileName}"/>&nbsp;<form:errors path="fileName" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;fileAddr：</th>
									<td nowrap="nowrap" align="left"><form:input path="fileAddr" value="${document.fileAddr}"/>&nbsp;<form:errors path="fileAddr" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;size：</th>
									<td nowrap="nowrap" align="left"><form:input path="size" value="${document.size}"/>&nbsp;<form:errors path="size" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;content：</th>
									<td nowrap="nowrap" align="left"><form:input path="content" value="${document.content}"/>&nbsp;<form:errors path="content" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/document'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form:form>		
</body>
</html>