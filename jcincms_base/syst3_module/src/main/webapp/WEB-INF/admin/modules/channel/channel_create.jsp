<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/admin/include/js.jsp"%>
<script type="text/javascript">
	var chanTemp = "${channel.channelTemplete}";
	var geneTemp = "${channel.geneTemplate}";
	var mGeneTemp = "${channel.mGeneTemplate}";
	var docgeneTemp = "${channel.docGeneTemplate}";
	var docMgeneTemp = "${channel.docMgeneTemplate}";
	var mchannelTemp = "${channel.mchannelTemplate}";
	var mdocumentTemp = "${channel.mdocumentTemplate}";
	var documentTemp = "${channel.documentTemplete}";
	var fileUrl = "${ctxAdmin}/document/getWebsiteFiles?refresh=" + true;
	
	$().ready(function() {
		validateForm();

		createChannelTree();
		createFileTree();
		createGeneTree();
		createmGeneTemplateTree();

		createDocTree();
		createMDocTree();
		createMChannelTree();

		createDocGeneTree();
		createDocMgeneTree();
	});

	function validateForm(){
		$("#validForm").validate({
			errorPlacement: function(error, element) {
			// Append error within linked label
			$( element )
				.closest( "form" ).find( "label[for='" + element.attr( "id" ) + "']" )
						.append( error );
		},
		errorElement: "span",
			rules : {
				name : {
					required : true
				},
				code : {
					required : true
				},
				keyword : {
					required : true
				},
				linkAddr : {
					required : true
				}
			},
			messages : {
				name : {
					required : "必填"
				},
				code : {
					required : "必填"
				},
				keyword : {
					required : "必填"
				},
				linkAddr : {
					required : "必填"
				}
			},submitHandler:function(form) {
				$('#channelTemplete').val(chanTemp);
				$('#gTemplete').val(geneTemp);
				$('#mgTemplete').val(mGeneTemp);
				$('#docGTemplete').val(docgeneTemp);
				$('#docMgTemplete').val(docMgeneTemp);
				$('#mchTemplete').val(mchannelTemp);
				$('#mdocTemplete').val(mdocumentTemp);
				$('#docTemplete').val(documentTemp);
				var row = $('#tgrid').datagrid('getSelected');
				if (row) {
					$("#documentId").val(row.id);
				}
				
// 				$('#validForm').submit();
				return true;
  			}
		})
	}
	
	function createChannelTree() {
		$('#parentId').combotree({
			url : '${ctxAdmin}/channel/getChannelTree',
			valuefield : 'id',
			width:300,
			textfield : 'name',
			required : false,
			editable : false,
			onClick : function(node) {
				/*  JJ.Prm.GetDepartmentUser(node.id, 'selUserFrom'); 
				$('#parentId').val(node.id);*/
				// 				$('#linkAddr').val(node.code);
				if (node.parentIds == '' || node.parentIds == null) {
					$('#parentIds').val(node.id);
				} else {
					$('#parentIds').val(node.parentIds + "," + node.id);
				}
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#parentId').combotree('tree').tree("collapseAll");
			}
		});
	}

	//创建文件树。
	function createFileTree() {
		$('#chanTemplete').combotree({
			url:fileUrl,
			textfield : 'name',
			width:300,
			required : false,
			editable : false,
			onClick : function(node) {
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#chanTemplete').combotree('tree').tree("collapseAll");
				var dTemplete = "${channel.channelTemplete}";
				$('#chanTemplete').combotree("setValue", dTemplete);
			},
			onSelect : function(item) {
				var parent = item;
				var tree = $('#chanTemplete').combotree('tree');
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

				chanTemp = pathStr;
			}
		});
	}

	//创建栏目文档生成模板文件树。
	function createDocGeneTree() {
		$('#docGeneTemplete').combotree({
			url:fileUrl,
			valuefield : 'id',
			textfield : 'name',
			width:300,
			required : false,
			editable : false,
			onClick : function(node) {
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#docGeneTemplete').combotree('tree').tree("collapseAll");
				var dTemplete = "${channel.docGeneTemplate}";
				$('#docGeneTemplete').combotree("setValue", dTemplete);
			},
			onSelect : function(item) {
				var parent = item;
				var tree = $('#docGeneTemplete').combotree('tree');
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

				docgeneTemp = pathStr;
			}
		});
	}

	function createMChannelTree() {
		$('#mchannelTemplate').combotree({
			url:fileUrl,
			valuefield : 'id',
			textfield : 'name',
			width:300,
			required : false,
			editable : false,
			onClick : function(node) {
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#mchannelTemplate').combotree('tree').tree("collapseAll");
				var dTemplete = "${channel.docGeneTemplate}";
				$('#mchannelTemplate').combotree("setValue", dTemplete);
			},
			onSelect : function(item) {
				var parent = item;
				var tree = $('#mchannelTemplate').combotree('tree');
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

				mchannelTemp = pathStr;
			}
		});
	}

	function createDocTree() {
		$('#documentTemplate').combotree({
			url:fileUrl,
			valuefield : 'id',
			textfield : 'name',
			width:300,
			required : false,
			editable : false,
			onClick : function(node) {
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#documentTemplate').combotree('tree').tree("collapseAll");
				var dTemplete = "${channel.documentTemplete}";
				$('#documentTemplate').combotree("setValue", dTemplete);
			},
			onSelect : function(item) {
				var parent = item;
				var tree = $('#documentTemplate').combotree('tree');
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

				documentTemp = pathStr;
			}
		});
	}
	
	function createMDocTree() {
		$('#mdocumentTemplate').combotree({
			url:fileUrl,
			valuefield : 'id',
			textfield : 'name',
			width:300,
			required : false,
			editable : false,
			onClick : function(node) {
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#mdocumentTemplate').combotree('tree').tree("collapseAll");
				var dTemplete = "${channel.mdocumentTemplate}";
				$('#mdocumentTemplate').combotree("setValue", dTemplete);
			},
			onSelect : function(item) {
				var parent = item;
				var tree = $('#mdocumentTemplate').combotree('tree');
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

				mdocumentTemp = pathStr;
			}
		});
	}
	//创建栏目文档生成模板文件树。
	function createDocMgeneTree() {
		$('#docMgeneTemplete').combotree({
			url:fileUrl,
			valuefield : 'id',
			textfield : 'name',
			width:300,
			required : false,
			editable : false,
			onClick : function(node) {
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#docMgeneTemplete').combotree('tree').tree("collapseAll");
				var dTemplete = "${channel.docMgeneTemplate}";
				$('#docMgeneTemplete').combotree("setValue", dTemplete);
			},
			onSelect : function(item) {
				var parent = item;
				var tree = $('#docMgeneTemplete').combotree('tree');
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

				docMgeneTemp = pathStr;
			}
		});
	}
	
	//创建生成模板文件树。
	function createGeneTree() {
		$('#geneTemplete').combotree({
			url:fileUrl,
			valuefield : 'id',
			textfield : 'name',
			width:300,
			required : false,
			editable : false,
			onClick : function(node) {
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#geneTemplete').combotree('tree').tree("collapseAll");
				var dTemplete = "${channel.geneTemplate}";
				$('#geneTemplete').combotree("setValue", dTemplete);
			},
			onSelect : function(item) {
				var parent = item;
				var tree = $('#geneTemplete').combotree('tree');
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
			url:fileUrl,
			valuefield : 'id',
			textfield : 'name',
			width:300,
			required : false,
			editable : false,
			onClick : function(node) {
				/*  JJ.Prm.GetDepartmentUser(node.id, 'selUserFrom'); 
				$('#parentId').val(node.id);*/
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#mGeneTemplate').combotree('tree').tree("collapseAll");
				var gTemplete = "${channel.mGeneTemplate}";
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

	function oncodeComplete() {
		$('#linkAddr').val("");
		var node = $('#parentId').combotree('tree').tree("getSelected");
		var co = $('#code').val();
		if (node) {
			if ("" != co) {
				$('#linkAddr').val(node.linkAddr + "/" + co);
			}
		} else {
			if ("" != co) {
				$('#linkAddr').val("channel/" + co);
			}
		}
	}

	function clearParentInput() {
		$('#parentId').combotree('clear');
		$('#parentIds').val('');
	}

	function clearTreeInput(id) {
		if(id=="chanTemplete"){
			$('#chanTemplete').combotree('clear');
			chanTemp = '';
		}else if(id=="mchannelTemplate"){
			$('#mchannelTemplate').combotree('clear');
			mchannelTemp = '';
		}else if(id=="geneTemplete"){
			$('#geneTemplete').combotree('clear');
			geneTemp = '';
		}else if(id=="mGeneTemplate"){
			$('#mGeneTemplate').combotree('clear');
			mGeneTemp = "";
		}else if(id=="documentTemplate"){
			$('#documentTemplate').combotree('clear');
			documentTemp = "";
		}else if(id=="mdocumentTemplate"){
			$('#mdocumentTemplate').combotree('clear');
			mdocumentTemp = "";
		}else if(id=="docGeneTemplete"){
			$('#docGeneTemplete').combotree('clear');
			docgeneTemp = "";
		}else if(id=="docMgeneTemplete"){
			$('#mdocumentTemplate').combotree('clear');
			docMgeneTemp = "";
		}
	}
	
	function clearForm() {
		$('#parentId').combotree('clear');
		$('#name').val("");
		$('#code').val("");
		$('#keyword').val("");
		$('#linkAddr').val("");
		$('#descrition').val("");
	}

	function onasdocumentChange() {
		var asdoc = $("#asdocument").val();

		if (asdoc == "true") {
			$("#channelTemplete").val('');
			$("#channelTemplete").attr('disabled', true);
			$("#docBtn").attr('disabled', false);
		} else {
			$("#channelTemplete").attr('disabled', false);
			$("#docBtn").attr('disabled', true);
			$("#documentId").val('');
		}
	}

	function onsubmitHandler() {
	}

	//搜索
	function search() {
		var queryParams = {};
		if ($("titleInput").val() != "") {
			queryParams.title = $("#titleInput").val();
		}
		if ($("authorInput").val() != "") {
			queryParams.author = $("#authorInput").val();
		}

		$("#tgrid").datagrid("getPager").pagination({
			pageNumber : 1
		});

		$("#tgrid").datagrid("options").queryParams = queryParams;
		$("#tgrid").datagrid("reload");
	}

	//清除
	function clearSearch() {
		$("#titleInput").val("");
		$("#authorInput").val("");
	}

	function selectFile() {
		$('#file').click();
	}

	function uploadImage() {
		//alert("图片上传失败,请重新选择图片");
		//$('#msg').text('正在上传'');
		// 检查图片格式
		var f = document.getElementById("file").value;
		if (!/.(gif|jpg|jpeg|png|JPG|PNG)$/.test(f)) {
			alert("图片类型必须是.jpeg,jpg,png中的一种")
			return false;
		}
		// 利用ajaxFileUpload js 插件上传图片
		$.ajaxFileUpload({
			url : '${ctxAdmin}/document/uploadFile',
			secureuri : false,
			fileElementId : "file",
			dataType : "text",
			success : function(data, status) {
				document.getElementById("msg").innerHTML = "上传成功";
				data = data.replace(/<pre.*?>/g, ''); //ajaxFileUpload会对服务器响应回来的text内容加上<pre style="....">text</pre>前后缀   
				data = data.replace(/<PRE.*?>/g, '');
				data = data.replace("<PRE>", '');
				data = data.replace("</PRE>", '');
				data = data.replace("<pre>", '');
				data = data.replace("</pre>", '');
				data = jQuery.parseJSON(data);
				// 				var a_id=eval('data'）;
				$('#image').val(data.fileAddr);
				/* var contextPath = "${ctx}";
				if(contextPath==""){
					$('#channelImg').attr("src", "/"+data.fileAddr);
				}else{
					$('#channelImg').attr("src", "/${ctx}/"+data.fileAddr);
				} */
			},
			error : function(data, status, e) {
				document.getElementById("msg").innerHTML = "图片上传失败,请重新选择图片";
			}
		});
		return false;
	}
</script>
<title>栏目添加</title>
</head>
<body>
	<form:form id="validForm" action="${ctxAdmin}/channel/create"
		method="post" commandName="channel">
		<input id="channelTemplete" name="channelTemplete"
			value="${channel.channelTemplete}" type="hidden" />
		<input id="gTemplete" name="geneTemplate"
			value="${channel.geneTemplate}" type="hidden" />
		<input id="mgTemplete" name="mGeneTemplate"
			value="${channel.mGeneTemplate}" type="hidden" />
		<input id="docGTemplete" name="docGeneTemplate"
			value="${channel.docGeneTemplate}" type="hidden" />
		<input id="docMgTemplete" name="docMgeneTemplate"
			value="${channel.docMgeneTemplate}" type="hidden" />
		<input id="mchTemplete" name="mchannelTemplate"
			value="${channel.mchannelTemplate}" type="hidden" />
		<input id="mdocTemplete" name="mdocumentTemplate"
			value="${channel.mdocumentTemplate}" type="hidden" />
		<input id="docTemplete" name="documentTemplete"
			value="${channel.documentTemplete}" type="hidden" />
		<input id="documentId" name="documentId" value="${channel.documentId}"
			type="hidden" />
		<input id="parentIds" name="parentIds" value="${channel.parentIds}"
			type="hidden" />
		<div>
			<b>栏目信息添加</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
		</div>
		<table class="table">
			<tr>
				<th>&nbsp;栏目：</th>
				<td><form:input path="parentId"
						value="${channel.parentId}" />&nbsp;<input type="button"
					value="清除" onclick="clearParentInput();" />&nbsp;<span
					style="color: red;">*</span></td>
				<th>&nbsp;名称：</th>
				<td><input id="name" name="name" class="input"
					value="${channel.name}" type="text" required />
					&nbsp;<label for="name" style="color:red;">*</label></td>
			</tr>
			<tr>
				<th>&nbsp;编码：</th>
				<td><input id="code" name="code" class="input"
					value="${channel.code}" onchange="oncodeComplete()"
					onkeyup="value=value.replace(/[^a-zA-Z]/g,'')" type="text" required />
					&nbsp;<label for="code" style="color:red;">*</label></td>
				<th>&nbsp;关键字：</th>
				<td><form:input id="keyword" class="input"
						path="keyword" value="${channel.keyword}" />
						&nbsp;<label for="keyword" style="color:red;">*</label></td>
			</tr>
			<tr>
				<th>&nbsp;链接地址：</th>
				<td><form:input id="linkAddr"
						path="linkAddr" value="${channel.linkAddr}"  class="input"/>
						&nbsp;<label for="linkAddr" style="color:red;">*</label></td>
				<th>&nbsp;新窗口打开：</th>
				<td><select id="openMode"
					name="openMode" style="width:100px;">
						<c:forEach var="mode" items="${fns:getByType('openMode')}">
							<option value="${mode.value}"
								<c:if test="${mode.value == false}">selected="selected"</c:if>>${mode.label}</option>
						</c:forEach>
				</select>&nbsp;</td>
			</tr>
			<tr>
				<th>&nbsp;栏目模板：</th>
				<td><input id="chanTemplete"
					path="chanTemplete" />&nbsp;<input type="button" value="清除"
					onclick="clearTreeInput('chanTemplete');" /><b id="channelTempleteTip"></b>
					<input id="refreshFiles" type="checkbox" value="刷新" /> &nbsp; <input
					value="重新获取" type="button" onclick="createFileTree();"></td>
				<th>&nbsp;是否隐藏：</th>
				<td><select id="hidden"
					name="hidden" style="width:100px;">
						<c:forEach var="sh" items="${fns:getByType('hidden')}">
							<option value="${sh.value}"
								<c:if test="${sh.value == false}">selected="selected"</c:if>>${sh.label}</option>
						</c:forEach>
				</select>&nbsp;</td>
			</tr>
			<tr>
				<th>&nbsp;栏目手机端模板：</th>
				<td colspan="6"><input id="mchannelTemplate" />&nbsp;<input type="button" value="清除"
					onclick="clearTreeInput('mchannelTemplate');" /></td>
			</tr>
			<tr>
				<th>&nbsp;栏目文档模板：</th>
				<td><input id="documentTemplate" />&nbsp;<input type="button" value="清除"
					onclick="clearTreeInput('documentTemplate');;" /></td>
				<th>&nbsp;栏目文档手机端模板：</th>
				<td>&nbsp;<input id="mdocumentTemplate" />&nbsp;<input type="button" value="清除"
					onclick="clearTreeInput('mdocumentTemplate');" /></td>
			</tr>
			<tr>
				<th>&nbsp;描述：</th>
				<td><form:textarea
						id="descrition" path="descrition" value="${channel.descrition}"
						style="width:400px;height:100px;" />&nbsp;<form:errors
						path="descrition" cssStyle="color:red;"></form:errors></td>
				<th>&nbsp;当成文档：</th>
				<td><select id="asdocument"
					name="asdocument" style="width:100px;"
					onchange="onasdocumentChange()">
						<c:forEach var="asdoc" items="${fns:getByType('asdocument')}">
							<option value="${asdoc.value}"
								<c:if test="${asdoc.value == false}">selected="selected"</c:if>>${asdoc.label}</option>
						</c:forEach>
				</select>&nbsp;<input id="docBtn" type="button" value="选择文档" disabled="true"
					onclick="$('#dlg').dialog('open')" /></td>
			</tr>
			<tr>
				<th>&nbsp;手工排序：</th>
				<td style="text-align: left;"><form:input id="sort" path="sort"  class="input"
						value="${channel.sort}" />&nbsp; </td>
				<th>&nbsp;图片：</th>
				<td style="text-align: left;"><form:input id="image"
						path="image" value="${channel.image}" /><input
					id="fileUploadBtn" type="button" value="上传" onclick="selectFile()" /><input
					style="display: none" type="file" id="file" name="file"
					onchange="uploadImage()" /></td>
			</tr>
			<tr>
				<th>&nbsp;栏目生成模板：</th>
				<td><input id="geneTemplete" />
					&nbsp;<input type="button" value="清除"
					onclick="clearTreeInput('geneTemplete');" /></td>
				<th>&nbsp;栏目手机端模板：</th>
				<td><input id="mGeneTemplate" />
					&nbsp;<input type="button" value="清除"
					onclick="clearTreeInput('mGeneTemplate');" /></td>
			</tr>
			<tr>
				<th>&nbsp;栏目文档生成模板：</th>
				<td><input id="docGeneTemplete" />
					&nbsp;<input type="button" value="清除"
					onclick="clearTreeInput('docGeneTemplete');" /></td>
				<th>&nbsp;栏目文档手机端模板：</th>
				<td><input id="docMgeneTemplete" />
					&nbsp;<input type="button" value="清除"
					onclick="clearTreeInput('docMgeneTemplete');" /></td>
			</tr>
			<tr>
				<th style="width: 150px;">&nbsp;</th>
				<td style="text-align: left;" colspan="6"><input type="submit"
					value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input
					type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input
					type="button" value="返回"
					onclick="javascript:window.location.href='${ctxAdmin}/channel'" />
					<c:if test="${channel.id!=null}">
									&nbsp;&nbsp;<input type="button" value="更新"
							onclick="javascript:window.location.href='${ctxAdmin}/channel/update/${channel.id}'" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<div>
		<img id="channelImg" alt="" src="" />
	</div>
	<div id="dlg" class="easyui-dialog" title="文档选择"
		data-options="iconCls:'icon-save',closed: true"
		style="width:600px;height:350px;padding:10px">
		<div style="padding: 5px;border: 0px;">
			<label>标题:</label> <input id="titleInput"
				onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<label>作者:</label> <input id="authorInput"
				onkeydown="onKeyEnter(event.keyCode||event.which);">&nbsp;&nbsp;
			<input type="button" id="searchBtn" value="搜索" onclick="search();" />
			<input type="button" id="clearBtn" value="清除"
				onclick="clearSearch();" />
		</div>
		<table id="tgrid" title="" class="easyui-datagrid"
			data-options="
								pageSize : 10,
								pageList : [ 5, 10, 15, 20 ],
								nowrap : true,
								striped : true,
								collapsible : true,
								url: '${ctxAdmin}/document/select',
								loadMsg : '数据装载中......',
								method: 'get',
								singleSelect : true,
								selectOnCheck: true,
								checkOnSelect: true,
								rownumbers: false,
								treeField: 'name',
								showHeader: true,
								fit:false,
								fitColumns:true,
								pagination : true
							">
			<thead>
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<th data-options="field:'id',align:'center',hidden:true"
						width="100%">id</th>
					<th data-options="field:'title',align:'center'" width="100%">标题</th>
					<th data-options="field:'author',align:'center'" width="100%">作者</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>