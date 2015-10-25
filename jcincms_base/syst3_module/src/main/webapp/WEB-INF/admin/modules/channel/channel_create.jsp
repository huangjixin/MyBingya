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
<script type="text/javascript">
	$().ready(function() {
		createOrganizationTree();
	});

	function createOrganizationTree(){
		$('#parentId').combotree({ 	
				url: '${ctxAdmin}/channel/getChannelTree',
				valuefield : 'id',
				textfield : 'name',
				required : false,
				editable : false,
				onClick : function(node) {
					/*  JJ.Prm.GetDepartmentUser(node.id, 'selUserFrom'); 
					$('#parentId').val(node.id);*/
					$('#linkAddr').val(node.code);
				}, //全部折叠
				onLoadSuccess : function(node, data) {
					$('#parentId').combotree('tree').tree("collapseAll");
				}
			});
	}

	function oncodeComplete(){
		$('#linkAddr').val("");
		var node = $('#parentId').combotree('tree').tree("getSelected");
		var co = $('#code').val();
		if(node){
			if(""!=co){
				$('#linkAddr').val(node.code+"/"+co);
			}
		}else{
			if(""!=co){
				$('#linkAddr').val(co);
			}
		}
	}
	
	function clearParentInput(){
		$('#parentId').combotree('clear');
	}
	
	function clearForm(){
		$('#parentId').combotree('clear');
		$('#name').val("");
		$('#code').val("");
		$('#keyword').val("");
		$('#linkAddr').val("");
		$('#descrition').val("");
	}
</script>
<title>栏目添加</title>
</head>
<body>
	<form:form id="validForm" action="${ctxAdmin}/channel/create" method="post" commandName="channel">
				<div class="descrition">
					<b>栏目信息添加</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;栏目：</th>
									<td nowrap="nowrap" align="left"><form:input path="parentId" value="${channel.parentId}"/>&nbsp;<input type="button" value="清除"
								onclick="clearParentInput();" /><form:errors path="parentId" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;名称：</th>
									<td nowrap="nowrap" align="left"><form:input id="name" path="name" value="${channel.name}"/>&nbsp;<form:errors path="name" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;编码：</th>
									<td nowrap="nowrap" align="left"><form:input  id="code" path="code" value="${channel.code}" onchange="oncodeComplete()"/>&nbsp;<form:errors path="code" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;关键字：</th>
									<td nowrap="nowrap" align="left"><form:input id="keyword" path="keyword" value="${channel.keyword}"/>&nbsp;<form:errors path="keyword" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;链接地址：</th>
									<td nowrap="nowrap" align="left"><form:input id="linkAddr" path="linkAddr" value="${channel.linkAddr}"/>&nbsp;<form:errors path="linkAddr" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;新窗口打开：</th>
									<td nowrap="nowrap" align="left"><select  id="openMode" name="openMode" style="width:100px;">
										<c:forEach var="mode" items="${fns:getByType('openMode')}">
											<option value="${mode.value}" <c:if test="${mode.value == false}">selected="selected"</c:if>>${mode.label}</option>
										</c:forEach>
									</select>&nbsp;<form:errors path="openMode" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;栏目模板：</th>
									<td nowrap="nowrap" align="left"><form:input id="channelTemplete" path="channelTemplete" value="${channel.channelTemplete}"/>&nbsp;<form:errors path="channelTemplete" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;是否显示：</th>
									<td nowrap="nowrap" align="left"><select  id="hidden" name="hidden" style="width:100px;">
										<c:forEach var="sh" items="${fns:getByType('hidden')}">
											<option value="${sh.value}" <c:if test="${sh.value == false}">selected="selected"</c:if>>${sh.label}</option>
										</c:forEach>
									</select>&nbsp;<form:errors path="hidden" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;当成文档：</th>
									<td nowrap="nowrap" align="left"><select  id="asdocument" name="asdocument" style="width:100px;">
										<c:forEach var="asdoc" items="${fns:getByType('asdocument')}">
											<option value="${asdoc.value}" <c:if test="${asdoc.value == false}">selected="selected"</c:if>>${asdoc.label}</option>
										</c:forEach>
									</select>&nbsp;<form:errors path="asdocument" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;描述：</th>
									<td nowrap="nowrap" align="left" colspan="6"><form:textarea id="descrition" path="descrition" value="${channel.descrition}" style="width:400px;height:100px;"/>&nbsp;<form:errors path="descrition" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/channel'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form:form>		
</body>
</html>