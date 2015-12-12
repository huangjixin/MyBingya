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
	
	//生成全部
	function generateAll() {
		$('#tip')[0].innerHTML="正在生成全部……";
		$.ajax({  
			url:"${ctxAdmin}/htmlgenerate/generateAll",  
			//data可以传参多个参数"name=John&location=Boston",    
			//data: "subcompanyId="+subcompanyId,  
			success:function(data){  
				$('#tip')[0].innerHTML="生成全部成功";
// 			    alert("生成首页成功");
			}, error:function(){  
			    alert("出错了");  
			}  
		 });
	}
	//删除全部
	function deleteAll() {
		$('#tip')[0].innerHTML="正在删除全部……";
		$.ajax({  
			url:"${ctxAdmin}/htmlgenerate/deleteAll",  
			//data可以传参多个参数"name=John&location=Boston",    
			//data: "subcompanyId="+subcompanyId,  
			success:function(data){  
				$('#tip')[0].innerHTML="删除全部成功";
// 			    alert("生成首页成功");
			}, error:function(){  
			    alert("出错了");  
			}  
		 });
	}
	
	//生成首页
	function generateIndex() {
		$('#tip')[0].innerHTML="正在生成首页……";
		$.ajax({  
			url:"${ctxAdmin}/htmlgenerate/generateIndex",  
			//data可以传参多个参数"name=John&location=Boston",    
			//data: "subcompanyId="+subcompanyId,  
			success:function(data){  
				$('#tip')[0].innerHTML="生成首页成功";
// 			    alert("生成首页成功");
			}, error:function(){  
			    alert("出错了");  
			}  
		 });
	}
	
	//删除首页
	function deleteIndex() {
		$('#tip')[0].innerHTML="正在删除首页……";
		$.ajax({  
			url:"${ctxAdmin}/htmlgenerate/deleteIndex",  
			//data可以传参多个参数"name=John&location=Boston",    
			//data: "subcompanyId="+subcompanyId,  
			success:function(data){  
				$('#tip')[0].innerHTML="删除首页成功";
			}, error:function(){  
			    alert("出错了");  
			}  
		 });
	}
	
	//生成栏目
	function generateChannel() {
		var node = $('#channlTree').combotree('tree').tree("getSelected");
		if(node==null){
			$('#tip')[0].innerHTML="请选中栏目";
			return;
		}
		var checked = $('#generateSubchannel').is(':checked')?true:false;
		$('#tip')[0].innerHTML="正在生成选中的栏目……";
		$.ajax({  
			url:"${ctxAdmin}/htmlgenerate/generateChannel?id="+node.id+"&generateSubchannel="+checked,  
			//data可以传参多个参数"name=John&location=Boston",    
			//data: "subcompanyId="+subcompanyId,  
			success:function(data){ 
				$('#tip')[0].innerHTML="生成栏目成功";
			}, error:function(){  
			    alert("出错了");  
			}  
		 });
	}
	
	//删除栏目
	function deleleChannel() {
		var node = $('#channlTree').combotree('tree').tree("getSelected");
		if(node==null){
			$('#tip')[0].innerHTML="请选中栏目";
			return;
		}
		$('#tip')[0].innerHTML="正在删除选中的栏目……";
		var checked = $('#generateSubchannel').is(':checked')?true:false;
		$.ajax({  
			url:"${ctxAdmin}/htmlgenerate/deleleChannel?id="+node.id+"&deleteSubchannel="+checked,  
			success:function(data){ 
				$('#tip')[0].innerHTML="删除栏目成功";
			}, error:function(){  
			    alert("出错了");  
			}  
		 });
	}
	
	//删除栏目文档
	function deleleChannelDoc() {
		var node = $('#docTree').combotree('tree').tree("getSelected");
		if(node==null){
			$('#tip')[0].innerHTML="请选中栏目";
			return;
		}
		$('#tip')[0].innerHTML="正在删除选中的栏目文档……";
		var checked = $('#deleteSubchannelDoc').is(':checked')?true:false;
		$.ajax({  
			url:"${ctxAdmin}/htmlgenerate/deleteChannelDoc?id="+node.id+"&deleteSubchannelDoc="+checked,  
			//data可以传参多个参数"name=John&location=Boston",    
			//data: "subcompanyId="+subcompanyId,  
			success:function(data){ 
				$('#tip')[0].innerHTML="删除栏目文档成功";
			}, error:function(){  
			    alert("出错了");  
			}  
		 });
	}
	
	//生成栏目文档
	function generateDocs() {
		var node = $('#docTree').combotree('tree').tree("getSelected");
		if(node==null){
			$('#tip')[0].innerHTML="请选中栏目";
			return;
		}
		$('#tip')[0].innerHTML="正在生成选中的栏目文档……";
		var checked = $('#deleteSubchannelDoc').is(':checked')?true:false;
		$.ajax({  
			url:"${ctxAdmin}/htmlgenerate/generateDocs?id="+node.id+"&generateSubchannelDoc="+checked,  
			//data可以传参多个参数"name=John&location=Boston",    
			//data: "subcompanyId="+subcompanyId,  
			success:function(data){ 
				$('#tip')[0].innerHTML="生成栏目文档成功";
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
		<b>页面生成</b>&nbsp;&nbsp;<span id="tip" style="color: red;">${msg}</span>
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
							type="button" value="生成所有html"  onclick="generateAll();" />&nbsp;<input
							type="button" value="删除所有html"  onclick="deleteAll();" /></td>
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
							value="生成栏目html" onclick="generateChannel()" />
							&nbsp;&nbsp;<input id="deleteChannel" type="button" value="删除栏目" onclick="deleleChannel()"/>&nbsp;&nbsp;<input id="generateSubchannel" type="checkbox">子栏目</input>
							</td>
					</tr>
					<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
						<th style="width: 150px;">&nbsp;文档html：</th>
						<td style="text-align: left;" colspan="6"><input id="docTree" />&nbsp;&nbsp;<input
							type="button" value="清除" onclick="clearDocTree();" />&nbsp;&nbsp;<input
							type="button" value="生成文档html"  onclick="generateDocs()" />
							&nbsp;&nbsp;<input type="button" value="删除文档" onclick="deleleChannelDoc()"/>&nbsp;&nbsp;<input id="deleteSubchannelDoc" type="checkbox">子栏目</input></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>