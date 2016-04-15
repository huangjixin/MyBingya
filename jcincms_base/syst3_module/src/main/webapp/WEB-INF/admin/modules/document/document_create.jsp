<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/admin/include/js.jsp"%>
<script type="text/javascript" charset="utf-8">
	window.UEDITOR_HOME_URL = "${ctx}/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
</script>
<script type="text/javascript" src="${ctx}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${ctx}/ueditor/ueditor.all.min.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" src="${ctx}/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="${ctx}/js/stickUp.js"></script>

<script type="text/javascript">
	//实例化编辑器
	//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
	var ue = UE.getEditor('editor');
	var docTemp = "${document.documentTemplete}";
	var geneTemp = "${document.geneTemplate}";
	var mGeneTemp = "${document.mGeneTemplate}";

	$().ready(function() {
		validateForm();
		createDocumentTree();
		// 		createFileTree();
		// 		createGeneTempleteTree();
		// 		createmGeneTemplateTree();

		ue.addListener("ready", function() {
			// editor准备好之后才可以使用
			var textS = HtmlDecode('${document.content}');
			ue.setContent(textS);
		});

		if('${document.titleImage}'==''){
			$('#titleImage').val('images/logo.png');
		}
	});

	function validateForm() {
		$("#validForm").validate(
				{
					errorPlacement : function(error, element) {
						// Append error within linked label
						$(element).closest("form").find(
								"label[for='" + element.attr("id") + "']")
								.append(error);
					},
					errorElement : "span",
					rules : {
						channelId : {
							required : true
						},
						title : {
							required : true
						},
						keyword : {
							required : true
						}
					},
					messages : {
						channelId : {
							required : "必填"
						},
						title : {
							required : "必填"
						},
						keyword : {
							required : "必填"
						}
					},
					submitHandler : function(form) {
						return true;
					}
				})
	}
	//创建文档树。
	function createDocumentTree() {
		$('#channelId').combotree({
			url : '${ctxAdmin}/document/getChannelTree',
			valuefield : 'id',
			textfield : 'name',
			missingMessage : "上级菜单不能为空！",
			required : true,
			width : 300,
			editable : false,
			onClick : function(node) {
				/*  JJ.Prm.GetDepartmentUser(node.id, 'selUserFrom'); 
				$('#parentId').val(node.id);*/
			},
			onLoadSuccess : function(node, data) {
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
		var checked = $('#refreshFiles').is(':checked') ? true : false;
		$('#docTemplete').combotree({
			url : '${ctxAdmin}/document/getWebsiteFiles?refresh=' + checked,
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
			},
			onSelect : function(item) {
				var parent = item;
				var tree = $('#docTemplete').combotree('tree');
				var path = new Array();
				do {
					path.unshift(parent.text);
					var parent = tree.tree('getParent', parent.target);
				} while (parent);
				var pathStr = '';
				for ( var i = 0; i < path.length; i++) {
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
			},
			onSelect : function(item) {
				var parent = item;
				var tree = $('#geneTemplate').combotree('tree');
				var path = new Array();
				do {
					path.unshift(parent.text);
					var parent = tree.tree('getParent', parent.target);
				} while (parent);
				var pathStr = '';
				for ( var i = 0; i < path.length; i++) {
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
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#mGeneTemplate').combotree('tree').tree("collapseAll");
				var gTemplete = "${document.mGeneTemplate}";
				$('#mGeneTemplate').combotree("setValue", gTemplete);
			},
			onSelect : function(item) {
				var parent = item;
				var tree = $('#mGeneTemplate').combotree('tree');
				var path = new Array();
				do {
					path.unshift(parent.text);
					var parent = tree.tree('getParent', parent.target);
				} while (parent);
				var pathStr = '';
				for ( var i = 0; i < path.length; i++) {
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

	function cleargeneTemplate() {
		$('#geneTemplate').combotree('clear');
		geneTemp = "";
	}

	function clearmGeneTemplate() {
		$('#mGeneTemplate').combotree('clear');
		mGeneTemp = "";
	}

	//jquery 提交表单。
	function submitForm() {
		//文章截取前面两百个字。
		var contxt = ue.getContentTxt();
		if (contxt.length > 100) {
			contxt = contxt.substring(0, 100);
		}
		$('#contentShort').val(contxt);
		$('#autoGenerate')
				.val(document.getElementById("autoGenratePC").checked);

		var cont = ue.getContent();
		$('#content').val(cont);
		// 		$('#documentTemplete').val(docTemp);
		// 		$('#gTemplete').val(geneTemp);
		// 		$('#mgTemplete').val(mGeneTemp);
		$('#validForm').submit();
	}

	function selectFile() {
		document.getElementById("uploadTip").innerHTML = "";
		$('#file').click();
	}

	var uploadCount = 0;

	function uploadImage() {
		// 利用ajaxFileUpload js 插件上传图片
		$
				.ajaxFileUpload({
					url : '${ctxAdmin}/document/uploadFile',
					secureuri : false,
					fileElementId : 'file',
					dataType : "text",
					success : function(data, status) {
						data = data.replace(/<pre.*?>/g, ''); //ajaxFileUpload会对服务器响应回来的text内容加上<pre style="....">text</pre>前后缀   
						data = data.replace(/<PRE.*?>/g, '');
						data = data.replace("<PRE>", '');
						data = data.replace("</PRE>", '');
						data = data.replace("<pre>", '');
						data = data.replace("</pre>", '');
						data = jQuery.parseJSON(data);
						// var a_id=eval('data'）;
						document.getElementById("msg").innerHTML = data.msg;
						document.getElementById("uploadTip").innerHTML = data.msg;
						
						var fN = 'fileName' + uploadCount;
						var fA = 'fileAddr' + uploadCount;

						$('#fileName').val(data.fileName);
						$('#size').val(data.size);
						$('#fileAddr').val(data.fileAddr);
						
						if (uploadCount == 0) {
							$('#fileAddr').val(data.fileAddr);
							$('#size').val(data.size);
						} else {
							var insertText = '<div><input value="'+data.fileAddr+'" class="input" />&nbsp;<input value="插入" type="button" onclick="insertContent(\''
									+ data.fileAddr + '\');" /></div>';
							$("#fileAddrTd").append(insertText);
						}

						uploadCount++;

						if ('' == $('#assetsIds').val()) {
							$('#assetsIds').val(data.assetsId);
						} else {
							var assIds = $('#assetsIds').val();
							assIds += "," + data.assetsId;
							$('#assetsIds').val(assIds);
						}
					},
					error : function(data, status, e) {
						document.getElementById("msg").innerHTML = "图片上传失败,请重新选择图片";
					}
				});
		return false;
	}

	function insertContent(content) {
		var contextPath = "${ctx}/";

		var str = '<p><img src="'+contextPath + content + '" title="" alt=""/></p>';
		ue.execCommand('inserthtml', str);
	}

	function insert() {
		var contextPath = "${ctx}/";

		var str = '<p><img src="' + contextPath + $('#fileAddr').val()
				+ '" title="" alt=""/></p>';
		ue.execCommand('inserthtml', str);
	}

	function autoGenratePC() {
		$('#generatePC').val(document.getElementById("autoGenratePC").checked);
	}

	function HtmlDecode(text) {
		return text.replace(/&/g, '&').replace(/"/g, '\"').replace(/</g, '<')
				.replace(/>/g, '>');
	}
</script>
<title>文档添加</title>
</head>
<body>
	<form:form id="validForm" action="${ctxAdmin}/document/create"
		method="post" commandName="document" enctype="multipart/form-data">
		<input id="assetsIds" name="assetsIds" value="${document.assetsIds}"
			type="hidden" />
		<input id="contentShort" name="contentShort"
			value="${document.contentShort}" type="hidden" />
		<input id="autoGenerate" name="autoGenerate" type="hidden" />
		<%-- <input id="documentTemplete" name="documentTemplete"
			value="${document.documentTemplete}" type="hidden" />
		<input id="gTemplete" name="geneTemplate"
			value="${document.geneTemplate}" type="hidden" />
		<input id="mgTemplete" name="mGeneTemplate"
			value="${document.mGeneTemplate}" type="hidden" /> --%>
		<input id="content" name="content" type="hidden" value="" />
		<div class="desc">
			<b>文档信息添加</b>&nbsp;&nbsp;<b id="msg" style="color: red;">${msg}</b>
		</div>
		<table class="table">
			<tr>
				<th>&nbsp;栏目：</th>
				<td><input id="channelId" name="channelId" />&nbsp;<label
					for="channelId" style="color:red;">*</label></td>
				<th>&nbsp;是否显示：</th>
				<td><select id="hidden" name="hidden" style="width:100px;">
						<c:forEach var="sh" items="${fns:getByType('hidden')}">
							<option value="${sh.value}"
								<c:if test="${sh.value == true}">selected="selected"</c:if>>${sh.label}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>&nbsp;标题：</th>
				<td><input id="title" name="title" value="${document.title}"
					class="input" required />&nbsp;<label for="title"
					style="color:red;">*</label></td>
				<th>&nbsp;作者：</th>
				<td><input id="author" name="author" value="${document.author}"
					class="input" /></td>
			</tr>
			<tr>
				<th>&nbsp;颜色：</th>
				<td><input name="color" value="${document.color}" class="input" /></td>
				<th>&nbsp;关键字：</th>
				<td><input id="keyword" name="keyword"
					value="${document.keyword}" class="input" />&nbsp;<label
					for="keyword" style="color:red;">*</label></td>

			</tr>
			<tr>
				<th>&nbsp;描述：</th>
				<td colspan="4"><textarea id="descrition" name="descrition"
						value="${document.descrition}" class="descrition"></textarea></td>
			</tr>
			<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
				<th>&nbsp;来源：</th>
				<td><input name="source" value="${document.source}"
					class="input" /></td>
				<th>&nbsp;来源地址：</th>
				<td><input name="sourceAddr" value="${document.sourceAddr}"
					class="input" /></td>
			</tr>
			<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
				<th>&nbsp;缩略图：</th>
				<td><input name="titleImage" id="titleImage" value="${document.titleImage}"
					class="input" /></td>
				<th>&nbsp;文档模板：</th>
				<td>
					<!-- <input id="docTemplete" /> &nbsp; <input type="button"
					onclick="cleardocTemplete();" value="清除" /> &nbsp; <input
					id="refreshFiles" type="checkbox">刷新</input> &nbsp; <input
					value="重新获取" type="button" onclick="createFileTree();"> -->
				</td>
			</tr>
			<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
				<th>&nbsp;文件名：</th>
				<td><input id="fileName" name="fileName"
					value="${document.fileName}" class="input" />&nbsp;<input
					id="fileUploadBtn" type="button" value="上传" onclick="selectFile()" /><input
					style="display: none" type="file" id="file" name="file"
					onchange="uploadImage()" /><br /></td>
				<th>&nbsp;文件地址：</th>
				<td id="fileAddrTd"><input id="fileAddr" name="fileAddr"
					value="${document.fileAddr}" class="input" />&nbsp;<input
					id="insertBtn" value="插入" type="button" onclick="insert();" /></td>
			</tr>
			<tr>
				<th>&nbsp;大小：</th>
				<td><input id="size" name="size" value="${document.size}"
					class="input" />&nbsp;k</td>
				<th>&nbsp;是否推荐：</th>
				<td><select id="recommend" name="recommend"
					style="width:100px;">
						<c:forEach var="sh" items="${fns:getByType('recommend')}">
							<option value="${sh.value}"
								<c:if test="${sh.value == false}">selected="selected"</c:if>
								<c:if test="${sh.value == true}">selected="selected"</c:if>>${sh.label}</option>
						</c:forEach>
				</select>&nbsp;</td>
			</tr>
			<%-- <tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
				<th>&nbsp;页面生成模板：</th>
				<td><input id="geneTemplate" /> <input id="generatePC"
					name="generatePC" type="hidden" /> &nbsp; <input type="button"
					onclick="cleargeneTemplate();" value="清除" /> <label><input
						type="checkbox" id="autoGenratePC" onclick="autoGenratePC();" />生成模板页面</label>
					<form:errors path="geneTemplate" cssStyle="color:red;"></form:errors>
				</td>
				<th>&nbsp;手机页面生成模板：</th>
				<td><input id="mGeneTemplate" /> &nbsp; <input type="button"
					onclick="clearmGeneTemplate();" value="清除" /> <form:errors
						path="geneTemplate" cssStyle="color:red;"></form:errors></td>
			</tr> --%>
			<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
				<th style="width: 150px;">&nbsp;</th>
				<td style="text-align: left;" colspan="6"><label><input
						type="checkbox" id="autoGenratePC"
						<c:if test="${document.autoGenerate}">checked="checked"</c:if> />自动
						生成html</label> <input type="button" value="保存" onclick="submitForm();" />&nbsp;&nbsp;<input
					type="reset" value="重置" />&nbsp;&nbsp;<input type="button"
					value="返回"
					onclick="javascript:window.location.href='${ctxAdmin}/document'" />
					<c:if test="${document.id!=null}">
									&nbsp;&nbsp;<input type="button" value="更新"
							onclick="javascript:window.location.href='${ctxAdmin}/document/update/${document.id}'" />
					</c:if></td>
			</tr>
		</table>
		<div>
			<b>正文</b>
			<script id="editor" type="text/plain"
				style="width:100%;height:500px;"></script>
		</div>
		<div style="text-align: center;">
			<input type="button" value="上传"
				onclick="selectFile()" /> 
			<input value="插入" type="button" onclick="insert();" />
			<input type="button" value="保存"
				onclick="submitForm();" />&nbsp;&nbsp;<input type="reset"
				value="重置" />&nbsp;&nbsp;<input type="button" value="返回"
				onclick="javascript:window.location.href='${ctxAdmin}/document'" />
			<c:if test="${document.id!=null}">
									&nbsp;&nbsp;<input type="button" value="更新"
					onclick="javascript:window.location.href='${ctxAdmin}/document/update/${document.id}'" />
			</c:if>
			<span id="uploadTip"></span>
		</div>
	</form:form>
</body>
</html>