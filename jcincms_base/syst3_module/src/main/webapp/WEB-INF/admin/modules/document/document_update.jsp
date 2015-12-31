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
<script type="text/javascript" src="${ctx}/js/ajaxfileupload.js"></script>
<script type="text/javascript" charset="utf-8">
	window.UEDITOR_HOME_URL = "${ctx}/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
</script>
<script type="text/javascript" src="${ctx}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${ctx}/ueditor/ueditor.all.min.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" src="${ctx}/ueditor/lang/zh-cn/zh-cn.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-easyui/themes/icon.css">
<script type="text/javascript">
	//实例化编辑器
	//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
	var ue = UE.getEditor('editor');
	var docTemp = "${document.documentTemplete}";
	var geneTemp = "${document.geneTemplate}";
	var mGeneTemp = "${document.mGeneTemplate}";
	
	$().ready(function() {
		createDocumentTree();
		createFileTree();
		createGeneTempleteTree();
		createmGeneTemplateTree();
		ue.addListener("ready", function() {
			// editor准备好之后才可以使用
			ue.setContent('${document.content}');
		});
	});

	//创建文档树。
	function createDocumentTree() {
		$('#channelId').combotree({
			url : '${ctxAdmin}/document/getChannelTree',
			valuefield : 'id',
			textfield : 'name',
			required : false,
			editable : false,
			onClick : function(node) {
				/*  JJ.Prm.GetDepartmentUser(node.id, 'selUserFrom'); 
				$('#parentId').val(node.id);*/
			}, onLoadSuccess : function(node, data) {
				$('#channelId').combotree('tree').tree("collapseAll");
				var cId = "${document.channelId}";
				if (cId != "") {
					$('#channelId').combotree("setValue", cId);
				}
			}
		});
	}
	
	//创建文件树。
	function createFileTree() {
		var checked = $('#refreshFiles').is(':checked')?true:false;
		$('#docTemplete').combotree({
			url : '${ctxAdmin}/document/getWebsiteFiles?refresh='+checked,
			valuefield : 'id',
			textfield : 'name',
			required : false,
			editable : false,
			onClick : function(node) {
				/*  JJ.Prm.GetDepartmentUser(node.id, 'selUserFrom'); 
				$('#parentId').val(node.id);*/
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#docTemplete').combotree('tree').tree("collapseAll");
					var dTemplete = "${document.documentTemplete}";
				   $('#docTemplete').combotree("setValue", dTemplete);
			},onSelect: function (item) {  
                var parent = item;  
                var tree = $('#docTemplete').combotree('tree');  
                var path = new Array();  
                do {  
                    path.unshift(parent.text);  
                    var parent = tree.tree('getParent', parent.target);  
                } while (parent);  
                var pathStr = '';  
                for (var i = 0; i < path.length; i++) {  
                    pathStr += path[i];  
                    if (i < path.length - 1) {  
                        pathStr += '/';  
                    }  
                }  
                
                docTemp = pathStr; 
            }  
		});
	}

	//创建页面模板树。
	function createGeneTempleteTree() {
		$('#geneTemplate').combotree({
			url : '${ctxAdmin}/document/getWebsiteFiles',
			valuefield : 'id',
			textfield : 'name',
			required : false,
			editable : false,
			onClick : function(node) {
				/*  JJ.Prm.GetDepartmentUser(node.id, 'selUserFrom'); 
				$('#parentId').val(node.id);*/
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#geneTemplate').combotree('tree').tree("collapseAll");
				var gTemplete = "${document.geneTemplate}";
				$('#geneTemplate').combotree("setValue", gTemplete);
			},onSelect: function (item) {  
                var parent = item;  
                var tree = $('#geneTemplate').combotree('tree');  
                var path = new Array();  
                do {  
                    path.unshift(parent.text);  
                    var parent = tree.tree('getParent', parent.target);  
                } while (parent);  
                var pathStr = '';  
                for (var i = 0; i < path.length; i++) {  
                    pathStr += path[i];  
                    if (i < path.length - 1) {  
                        pathStr += '/';  
                    }  
                }  
                
                geneTemp = pathStr; 
            }  
		});
	}
	//创建移动页面模板树。
	function createmGeneTemplateTree() {
		$('#mGeneTemplate').combotree({
			url : '${ctxAdmin}/document/getWebsiteFiles',
			valuefield : 'id',
			textfield : 'name',
			required : false,
			editable : false,
			onClick : function(node) {
				/*  JJ.Prm.GetDepartmentUser(node.id, 'selUserFrom'); 
				$('#parentId').val(node.id);*/
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#mGeneTemplate').combotree('tree').tree("collapseAll");
				var gTemplete = "${document.mGeneTemplate}";
				$('#mGeneTemplate').combotree("setValue", gTemplete);
			},onSelect: function (item) {  
                var parent = item;  
                var tree = $('#mGeneTemplate').combotree('tree');  
                var path = new Array();  
                do {  
                    path.unshift(parent.text);  
                    var parent = tree.tree('getParent', parent.target);  
                } while (parent);  
                var pathStr = '';  
                for (var i = 0; i < path.length; i++) {  
                    pathStr += path[i];  
                    if (i < path.length - 1) {  
                        pathStr += '/';  
                    }  
                }  
                
                mGeneTemp = pathStr; 
            }  
		});
	}
	
	function clearParentInput() {
		$('#channelId').combotree('clear');
	}

	function cleardocTemplete() {
		$('#docTemplete').combotree('clear');
		docTemp = "";
	}
	
	function cleargeneTemplate(){
		$('#geneTemplate').combotree('clear');
		geneTemp = "";
	}
	
	function clearmGeneTemplate(){
		$('#mGeneTemplate').combotree('clear');
		mGeneTemp = "";
	}

	//jquery 提交表单。
	function submitForm() {
		var contxt = ue.getContentTxt();
		if(contxt!=$('#contentShort').val()){
			if(contxt.length>200){
				contxt = contxt.substring(0,200);
			}
			$('#contentShort').val(contxt);
		}
		
		var cont = ue.getContent();
		$('#content').val(cont);
		$('#documentTemplete').val(docTemp);
		$('#gTemplete').val(geneTemp);
		$('#mgTemplete').val(mGeneTemp);
		$('#validForm').submit();
	}

	function selectFile() {
		$('#file').click();
	}

	function uploadImage() {
		// 		alert("图片上传失败,请重新选择图片");
		// 		$('#msg').text('正在上传'');
		// 检查图片格式
		/* var f = document.getElementById("file").value;
		if (!/.(gif|jpg|jpeg|png|JPG|PNG)$/.test(f)) {
			alert("图片类型必须是.jpeg,jpg,png中的一种")
			return false;
		} */
		// 利用ajaxFileUpload js 插件上传图片
		$.ajaxFileUpload({
			url : '${ctxAdmin}/document/uploadFile',
			secureuri : false,
			fileElementId : "file",
			dataType : "text",
			success : function(data, status) {
				data = data.replace(/<pre.*?>/g, ''); //ajaxFileUpload会对服务器响应回来的text内容加上<pre style="....">text</pre>前后缀   
				data = data.replace(/<PRE.*?>/g, ''); 
				data = data.replace("<PRE>", ''); 
				data = data.replace("</PRE>", ''); 
				data = data.replace("<pre>", ''); 
				data = data.replace("</pre>", ''); 
				data = jQuery.parseJSON( data );
// 				var a_id=eval('data'）;
				alert(data.msg);
				$('#fileName').val(data.fileName);
				$('#fileAddr').val(data.fileAddr);
				$('#size').val(data.size);
				if(''==$('#assetsIds').val()){
					$('#assetsIds').val(data.assetsId);
				}else{
					var assIds = $('#assetsIds').val();
					assIds += ","+data.assetsId;
					$('#assetsIds').val(assIds);
				}
			},
			error : function(data, status, e) {
				alert("图片上传失败,请重新选择图片");
			}
		});
		return false;
	}
	
	function insert(){
		var str = '<p><img src="${ctx}'+$('#fileAddr').val()+'" title="'+$('#fileName').val()+'" alt="'+$('#fileName').val()+'"/></p>';
		ue.execCommand( 'inserthtml', str);
	}
</script>
<title>文档修改</title>
</head>
<body>
	<form:form id="validForm"
		action="${ctxAdmin}/document/update/${document.id}" method="post" commandName="document">
		<input name="id" value="${document.id}" type="hidden" />
		<input id="contentShort" name="contentShort" value="${document.contentShort}" type="hidden" />
		<input id="assetsIds" name="assetsIds" value="${document.assetsIds}" type="hidden" />
		<input id="documentTemplete" name="documentTemplete" value="${document.documentTemplete}" type="hidden" />
		<input id="gTemplete" name="geneTemplate" value="${document.geneTemplate}" type="hidden" />
		<input id="mgTemplete" name="mGeneTemplate" value="${document.mGeneTemplate}" type="hidden" />
		<div class="desc">
			<b>文档信息修改</b>&nbsp;&nbsp;<b id="msg" style="color: red;">${msg}</b>
		</div>
		<table width="100%" border="0" cellpadding="2" cellspacing="0">
			<tr>
				<td width="100%">
					<table border="0" cellpadding="3" cellspacing="1" width="100%"
						align="center" style="background-color: #b9d8f3;">
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;栏目：</th>
							<td nowrap="nowrap" align="left"><input id="channelId"
								name="channelId" />&nbsp;<form:errors path="channelId"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;标题：</th>
							<td nowrap="nowrap" align="left"><form:input path="title"
									value="${document.title}" />&nbsp;<form:errors path="title"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;作者：</th>
							<td nowrap="nowrap" align="left"><form:input path="author"
									value="${document.author}" />&nbsp;<form:errors path="author"
									cssStyle="color:red;"></form:errors></td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;颜色：</th>
							<td nowrap="nowrap" align="left"><form:input path="color"
									value="${document.color}" />&nbsp;<form:errors path="color"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;关键字：</th>
							<td nowrap="nowrap" align="left"><form:input path="keyword"
									value="${document.keyword}" />&nbsp;<form:errors path="keyword"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;是否显示：</th>
							<td nowrap="nowrap" align="left"><select  id="hidden" name="hidden" style="width:100px;">
										<c:forEach var="sh" items="${fns:getByType('hidden')}">
											<option value="${sh.value}" <c:if test="${sh.value == true}">selected="selected"</c:if>>${sh.label}</option>
										</c:forEach>
									</select>&nbsp;<form:errors path="hidden" cssStyle="color:red;"></form:errors></td>
						</tr>
						<%-- <tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;描述：</th>
									<td  style="text-align: left;" colspan="6"><textarea name="descrition" value="${document.descrition}"/>&nbsp;<form:errors path="descrition" cssStyle="color:red;"></form:errors></td>
								</tr> --%>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;优先级：</th>
							<td nowrap="nowrap" align="left"><form:input path="priority"
									value="${document.priority}" />&nbsp;<form:errors
									path="priority" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;来源：</th>
							<td nowrap="nowrap" align="left"><form:input path="source"
									value="${document.source}" />&nbsp;<form:errors path="source"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;来源地址：</th>
							<td nowrap="nowrap" align="left"><form:input
									path="sourceAddr" value="${document.sourceAddr}" />&nbsp;<form:errors
									path="sourceAddr" cssStyle="color:red;"></form:errors></td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;标题图片：</th>
							<td nowrap="nowrap" align="left"><form:input
									path="titleImage" value="${document.titleImage}" />&nbsp;<form:errors
									path="titleImage" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;：</th>
							<td nowrap="nowrap" align="left">
								<input id="content" name="content" type="hidden" value="" />&nbsp;<form:errors
									path="content" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;文档模板：</th>
							<td nowrap="nowrap" align="left">
								<input id="docTemplete"/>
								&nbsp;
								<input type="button" onclick="cleardocTemplete();" value="清除"/>
								&nbsp;
								<input id="refreshFiles" type="checkbox">刷新</input>
								&nbsp;
								<input value="重新获取" type="button"  onclick="createFileTree();" ><form:errors path="documentTemplete" cssStyle="color:red;"></form:errors>
							</td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;文件名：</th>
							<td nowrap="nowrap" align="left"><form:input path="fileName"
									value="${document.fileName}" />&nbsp;<input id="fileUploadBtn"
								type="button" value="上传" onclick="selectFile()" /><input
								style="display: none" type="file" id="file" name="file"
								onchange="uploadImage()" />&nbsp;<form:errors path="fileName"
									cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;文件地址：</th>
							<td nowrap="nowrap" align="left"><form:input path="fileAddr"
									value="${document.fileAddr}" />&nbsp;<form:errors
									path="fileAddr" cssStyle="color:red;"></form:errors><input id="insertBtn" value="插入" type="button" onclick="insert();"/></td>
							<th>&nbsp;大小：</th>
							<td nowrap="nowrap" align="left"><form:input path="size"
									value="${document.size}" />&nbsp;<form:errors path="size"
									cssStyle="color:red;"></form:errors></td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th>&nbsp;是否推荐：</th>
							<td nowrap="nowrap" align="left" ><select  id="recommend" name="recommend" style="width:100px;">
										<c:forEach var="sh" items="${fns:getByType('recommend')}">
											<option value="${sh.value}" <c:if test="${sh.value == false}">selected="selected"</c:if> <c:if test="${sh.value == true}">selected="selected"</c:if>>${sh.label}</option>
										</c:forEach>
									</select>&nbsp;<form:errors path="recommend" cssStyle="color:red;"></form:errors></td>
							<th>&nbsp;页面生成模板：</th>
							<td nowrap="nowrap" align="left">
								<input id="geneTemplate"/>
								&nbsp;
								<input type="button" onclick="cleargeneTemplate();" value="清除"/>
								<form:errors path="geneTemplate" cssStyle="color:red;"></form:errors>
							</td>
							<th>&nbsp;手机页面生成模板：</th>
							<td nowrap="nowrap" align="left">
								<input id="mGeneTemplate"/>
								&nbsp;
								<input type="button" onclick="clearmGeneTemplate();" value="清除"/>
								<form:errors path="geneTemplate" cssStyle="color:red;"></form:errors>
							</td>
						</tr>
						<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
							<th style="width: 150px;">&nbsp;</th>
							<td style="text-align: left;" colspan="6"><input
								type="button" value="保存" onclick="submitForm();" />&nbsp;&nbsp;<input
								type="reset" value="重置" />&nbsp;&nbsp;<input type="button"
								value="返回"
								onclick="javascript:window.location.href='${ctxAdmin}/document'" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<%-- <img src="${ctx }/upload/1/20151021_111608.jpg"/> --%>
		<div>
			<b>正文</b>
			<script id="editor" type="text/plain"
				style="width:100%;height:500px;"></script>
			<%-- <textarea name="content" id="editor" style="width:100%;height:500px;" value="${document.content}"></textarea> --%> 
		</div>
	</form:form>
</body>
</html>