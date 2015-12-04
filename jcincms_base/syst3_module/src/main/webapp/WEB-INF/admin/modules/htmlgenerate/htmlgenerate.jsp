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
<script type="text/javascript"
	src="${ctx}/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/themes/icon.css">
<script type="text/javascript">
	$().ready(function() {
		createChannelTree();
		createDocTree();
	});
	
	function createChannelTree() {
		$('#channlTree').combotree({
			url : '${ctxAdmin}/channel/getChannelTree',
			valuefield : 'id',
			textfield : 'name',
			required : false,
			editable : false,
			onClick : function(node) {
				
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#channlTree').combotree('tree').tree("collapseAll");
			}
		});
	}
	
	function createDocTree() {
		$('#docTree').combotree({
			url : '${ctxAdmin}/channel/getChannelTree',
			valuefield : 'id',
			textfield : 'name',
			required : false,
			editable : false,
			onClick : function(node) {
				
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#docTree').combotree('tree').tree("collapseAll");
			}
		});
	}
	
	function clearDocTree() {
		$('#docTree').combotree('clear');
	}
	
	function clearChannelTree() {
		$('#channlTree').combotree('clear');
	}
	
	//生成首页
	function generateIndex() {
		$.ajax({  
			url:"${ctxAdmin}/htmlgenerate/generateIndex",  
			//data可以传参多个参数"name=John&location=Boston",    
			//data: "subcompanyId="+subcompanyId,  
			success:function(data){  
// 			    alert("生成首页成功");
			}, error:function(){  
			    alert("出错了");  
			}  
		 });
	}
	
	//删除首页
	function deleteIndex() {
		$.ajax({  
			url:"${ctxAdmin}/htmlgenerate/deleteIndex",  
			//data可以传参多个参数"name=John&location=Boston",    
			//data: "subcompanyId="+subcompanyId,  
			success:function(data){  
			    alert("生成首页成功");
			}, error:function(){  
			    alert("出错了");  
			}  
		 });
	}
	
	
</script>
<title>页面生成</title>
</head>
<body>
	<div class="descrition">
		<b>页面生成</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
	</div>
	<hr>
	<table width="100%" border="0" cellpadding="2" cellspacing="0">
		<tr>
			<td width="100%">
				<table border="0" cellpadding="3" cellspacing="1" width="100%"
					align="center" style="background-color: #b9d8f3;">
					<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
						<th style="width: 150px;">&nbsp;所有html：</th>
						<td style="text-align: left;" colspan="6"><input
							type="button" value="生成所有html" /></td>
					</tr>
					<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
						<th style="width: 150px;">&nbsp;首页html：</th>
						<td style="text-align: left;" colspan="6"><input
							type="button" value="生成首页html" onclick="generateIndex();" />&nbsp;&nbsp;<input
							type="button" value="删除首页html" onclick="deleteIndex();"/></td>
					</tr>
					<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
						<th style="width: 150px;">&nbsp;栏目html：</th>
						<td style="text-align: left;" colspan="6"><input
							id="channlTree" />&nbsp;&nbsp;<input type="button" value="清除"
							onclick="clearChannelTree();" />&nbsp;&nbsp;<input type="button"
							value="生成栏目html" /></td>
					</tr>
					<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
						<th style="width: 150px;">&nbsp;文档html：</th>
						<td style="text-align: left;" colspan="6"><input id="docTree" />&nbsp;&nbsp;<input
							type="button" value="清除" onclick="clearDocTree();" />&nbsp;&nbsp;<input
							type="button" value="生成文档html" /></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>