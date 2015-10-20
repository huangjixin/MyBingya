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
<script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="${ctx}/ueditor/lang/zh-cn/zh-cn.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/icon.css">
<script type="text/javascript">
	//实例化编辑器
	//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
	var ue = UE.getEditor('editor');

	$().ready(function() {
		createDocumentTree();
		ue.addListener("ready", function () {
	        // editor准备好之后才可以使用
	        ue.setContent('${document.content}');
	 });
	});
	
	//创建文档树。
	function createDocumentTree(){
		$('#channelId').combotree({ 	
				url: '${ctxAdmin}/document/getChannelTree',
				valuefield : 'id',
				textfield : 'name',
				required : false,
				editable : false,
				onClick : function(node) {
					/*  JJ.Prm.GetDepartmentUser(node.id, 'selUserFrom'); 
					$('#parentId').val(node.id);*/
				}, //全部折叠
				onLoadSuccess : function(node, data) {
					$('#channelId').combotree('tree').tree("collapseAll");
					var cId = "${document.channelId}";
					if(cId !=""){
						$('#channelId').combotree("setValue",cId);
					}
				}
			});
	}

	function clearParentInput(){
		$('#channelId').combotree('clear');
	}
	
	function submitForm(){
		var cont = ue.getContent();
		$('#content').val(cont);
		$('#validForm').submit();
	}
</script>
<title>文档查看</title>
</head>
<body>
	<form:form id="validForm" action="" method="post" commandName="document">
		<input name="id" value="${document.id}" type="hidden" />
				<div class="desc">
					<b onclick="appendCon()">文档信息查看</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;栏目：</th>
									<td nowrap="nowrap" align="left"><input id="channelId" name="channelId"/>&nbsp;<form:errors path="channelId" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;标题：</th>
									<td nowrap="nowrap" align="left"><form:input path="title" value="${document.title}"/>&nbsp;<form:errors path="title" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;作者：</th>
									<td nowrap="nowrap" align="left"><form:input path="author" value="${document.author}"/>&nbsp;<form:errors path="author" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;颜色：</th>
									<td nowrap="nowrap" align="left"><form:input path="color" value="${document.color}"/>&nbsp;<form:errors path="color" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;关键字：</th>
									<td nowrap="nowrap" align="left"><form:input path="keyword" value="${document.keyword}"/>&nbsp;<form:errors path="keyword" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;</th>
									<td nowrap="nowrap" align="left"></td>
								</tr>
								<%-- <tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;描述：</th>
									<td  style="text-align: left;" colspan="6"><textarea name="descrition" value="${document.descrition}"/>&nbsp;<form:errors path="descrition" cssStyle="color:red;"></form:errors></td>
								</tr> --%>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;优先级：</th>
									<td nowrap="nowrap" align="left"><form:input path="priority" value="${document.priority}"/>&nbsp;<form:errors path="priority" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;来源：</th>
									<td nowrap="nowrap" align="left"><form:input path="source" value="${document.source}"/>&nbsp;<form:errors path="source" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;来源地址：</th>
									<td nowrap="nowrap" align="left"><form:input path="sourceAddr" value="${document.sourceAddr}"/>&nbsp;<form:errors path="sourceAddr" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
								<th>&nbsp;标题图片：</th>
									<td nowrap="nowrap" align="left"><form:input path="titleImage" value="${document.titleImage}"/>&nbsp;<form:errors path="titleImage" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;文件名：</th>
									<td nowrap="nowrap" align="left"><form:input path="fileName" value="${document.fileName}"/>&nbsp;<form:errors path="fileName" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;</th>
									<td nowrap="nowrap" align="left"></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;文件地址：</th>
									<td nowrap="nowrap" align="left"><form:input path="fileAddr" value="${document.fileAddr}"/>&nbsp;<form:errors path="fileAddr" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;大小：</th>
									<td nowrap="nowrap" align="left"><form:input path="size" value="${document.size}"/>&nbsp;<form:errors path="size" cssStyle="color:red;"></form:errors></td>
									<th>&nbsp;</th>
									<td nowrap="nowrap" align="left"><input id="content" name="content" type="hidden" value="${document.content}"/>&nbsp;<form:errors path="content" cssStyle="color:red;"></form:errors></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/document'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
				<div>
					<b>正文</b>
				    <script id="editor" type="text/plain" style="width:100%;height:500px;"></script>
				</div>
		</form:form>		
</body>
</html>