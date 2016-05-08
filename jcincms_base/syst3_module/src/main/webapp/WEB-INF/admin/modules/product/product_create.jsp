<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<script type="text/javascript">
	//实例化编辑器
	//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
	var ue = UE.getEditor('editor');
	function HtmlDecode(text) {
		return text.replace(/&/g, '&').replace(/"/g, '\"').replace(/</g, '<')
				.replace(/>/g, '>');
	}

	$().ready(function() {
		validateForm();

		ue.addListener("ready", function() {
			// editor准备好之后才可以使用
			var textS = HtmlDecode('${product.content}');
			ue.setContent(textS);
		});
	});

	function selectFile() {
		document.getElementById("msg").innerHTML = "";
		$('#file').click();
	}

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
						$('#fileName').val(data.fileName);

						var insertText = '<div><input value="'+data.fileAddr+'" class="input" />&nbsp;<input value="插入" type="button" onclick="insertContent(\''
								+ data.fileAddr + '\');" /></div>';
						$("#fileAddrTd").append(insertText);

						if ('' == $('#assets').val()) {
							$('#assets').val(data.assetsId);
						} else {
							var assIds = $('#assets').val();
							assIds += "," + data.assetsId;
							$('#assets').val(assIds);
						}
					},
					error : function(data, status, e) {
						document.getElementById("msg").innerHTML = "图片上传失败,请重新选择图片";
					}
				});
		return false;
	}

	function validateForm() {
		$("#validForm").validate(
				{
					errorPlacement : function(error, element) {
						$(element).closest("form").find(
								"label[for='" + element.attr("id") + "']")
								.append(error);
					},
					errorElement : "span",
					rules : {
						id : {
							required : true
						},
						name : {
							required : true
						},
						proBrandId : {
							required : true
						},
						content : {
							required : true
						}
					},
					messages : {
						id : {
							required : "必填"
						},
						name : {
							required : "必填"
						},
						proBrandId : {
							required : "必填"
						},
						content : {
							required : "必填"
						}
					},
					submitHandler : function(form) {
						if ($('#zhName').val() == '') {
							document.getElementById("msg").innerHTML = "请选择品牌";
							return false;
						}
						var cont = ue.getContent();
						$('#content').val(cont);
						return true;
					}
				})
	}
	function clearForm() {
		$('#id').val("");
		$('#name').val("");
		$('#proBrandId').val("");
		$('#content').val("");
	}

	function insertContent(content) {
		var contextPath = "${ctx}/";

		var str = '<p><img src="'+contextPath + content + '" title="" alt=""/></p>';
		ue.execCommand('inserthtml', str);
	}

	//缩略图上传。
	function selectTitleImageFile() {
		document.getElementById("msg").innerHTML = "";
		$('#titleImagefile').click();
	}

	function uploadTitleImage() {
		// 利用ajaxFileUpload js 插件上传图片
		$.ajaxFileUpload({
			url : '${ctxAdmin}/document/uploadFile',
			secureuri : false,
			fileElementId : 'titleImagefile',
			dataType : "text",
			success : function(data, status) {
				data = data.replace(/<pre.*?>/g, ''); //ajaxFileUpload会对服务器响应回来的text内容加上<pre style="....">text</pre>前后缀   
				data = data.replace(/<PRE.*?>/g, '');
				data = data.replace("<PRE>", '');
				data = data.replace("</PRE>", '');
				data = data.replace("<pre>", '');
				data = data.replace("</pre>", '');
				data = jQuery.parseJSON(data);
				document.getElementById("msg").innerHTML = data.msg;

				$("#titleImage").val(data.fileAddr);
				$("#titleImg").attr("src", "${ctx}/" + data.fileAddr);

				if ('' == $('#assets').val()) {
					$('#assets').val(data.assetsId);
				} else {
					var assIds = $('#assets').val();
					assIds += "," + data.assetsId;
					$('#assets').val(assIds);
				}
			},
			error : function(data, status, e) {
				document.getElementById("msg").innerHTML = "图片上传失败,请重新选择图片";
			}
		});
		return false;
	}

	//产品图宣传。
	function imageFile(imgesId) {
		document.getElementById("msg").innerHTML = "";
		$('#' + imgesId).click();
	}

	var imagesCount = 0;

	function uploadImageFile(imagefileId) {
		// 利用ajaxFileUpload js 插件上传图片
		$
				.ajaxFileUpload({
					url : '${ctxAdmin}/document/uploadFile',
					secureuri : false,
					fileElementId : imagefileId,
					dataType : "text",
					success : function(data, status) {
						data = data.replace(/<pre.*?>/g, ''); //ajaxFileUpload会对服务器响应回来的text内容加上<pre style="....">text</pre>前后缀   
						data = data.replace(/<PRE.*?>/g, '');
						data = data.replace("<PRE>", '');
						data = data.replace("</PRE>", '');
						data = data.replace("<pre>", '');
						data = data.replace("</pre>", '');
						data = jQuery.parseJSON(data);
						document.getElementById("msg").innerHTML = data.msg;

						var insertText = '<div style="padding:10px 0;" id="imagesDiv'+imagesCount+'"><input name="images['+imagesCount+'].site" value="'+data.fileAddr+'" type="hidden"><img id="titleImg1" src="${ctx}/'+data.fileAddr+'" style="width:160px;height:160px;background-color: gray;border: 1px solid black;" /></div><input type="button" value="删除" onclick="$(\'#imagesDiv'+imagesCount+'\').remove();$(\'#image'+imagesCount+'\').remove();"/>';
						$("#imagesTd").append(insertText);
						insertText ='<input id="image'+imagesCount+'" name="image"  value="'+data.fileAddr+'" class="input" /><br>';
						$("#imagesTd0").append(insertText);

						$("#image1").val(data.fileAddr);

						imagesCount += 1;

						if ('' == $('#assets').val()) {
							$('#assets').val(data.assetsId);
						} else {
							var assIds = $('#assets').val();
							assIds += "," + data.assetsId;
							$('#assets').val(assIds);
						}
					},
					error : function(data, status, e) {
						document.getElementById("msg").innerHTML = "图片上传失败,请重新选择图片";
					}
				});
		return false;
	}
</script>
<title>商品添加</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/product/create" method="post">
		<input id="proBrandId" name="proBrandId" value="${product.proBrandId}"
			type="hidden" /> <input id="images" value="${product.images}"
			type="hidden" /> <input id="assets" name="assets"
			value="${product.assets}" type="hidden" /> <input id="content"
			name="content" value="${product.content}" type="hidden" />
		<div class="desc">
			<b>商品信息添加</b>&nbsp;&nbsp;<b style="color: red;" id="msg">${msg}</b>
		</div>
		<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;" />
		<table class="table">
			<tr>
				<th>&nbsp;商品名称：</th>
				<td><input id="name" name="name" value="${product.name}"
					class="input" /> &nbsp; <label for="name" style="color:red;">*</label></td>
				<th>&nbsp;品牌：</th>
				<td><input type="text" id="zhName" name="brandName" class="input"
					readonly="readonly" /> &nbsp; <input type="button"
					onclick="$('#dlg').dialog('open')" value="选择品牌" /> &nbsp; <label
					for="proBrandId" style="color:red;">*</label></td>
			</tr>
			<tr>
				<th>&nbsp;页面标题：</th>
				<td><input id="title" name="title" value="${product.title}"
					class="input" /> &nbsp; <label for="title" style="color:red;">*</label></td>
				<th>&nbsp;关键字：</th>
				<td><input type="text" id="keywords" name="keywords" class="input"/>  &nbsp; <label
					for="keywords" style="color:red;">*</label></td>
			</tr>
			<tr>
				<th>&nbsp;描述：</th>
				<td colspan="6"><textarea name="description" style="width: 90%;height:100px;">${product.description}</textarea></td>
			</tr>
			<tr>
				<th>&nbsp;封面缩略图：</th>
				<td><input id="titleImage" name="titleImage"
					value="${product.titleImage}" class="input" /> &nbsp; <label
					for="titleImage" style="color:red;">*</label> <input
					id="titleImageBtn" type="button" value="上传"
					onclick="selectTitleImageFile()" /><input style="display: none"
					type="file" id="titleImagefile" name="file"
					onchange="uploadTitleImage()" /></td>
				<th>&nbsp;预览（160*160）：</th>
				<td><img id="titleImg" src=""
					style="width:160px;height:160px;background-color: gray;border: 1px solid black" /></td>
			</tr>
			<tr>
				<th>&nbsp;价格：</th>
				<td colspan="6"><input type="radio" name="price" value="9400以上" />9400以上<input
					type="radio" name="price" value="0-699" checked="checked" />0-699
					<input type="radio" name="price" value="1800-2699" />1800-2699<input
					type="radio" name="price" value="2700-5499" />2700-5499<input
					type="radio" name="price" value="1300-1799" />1300-1799<input
					type="radio" name="price" value="700-1299" />700-1299<input
					type="radio" name="price" value="2700-5499" />5500-9399</td>
			</tr>
			<tr>
				<th>&nbsp;尺寸：</th>
				<td colspan="6"><input type="radio" name="measure"
					value="10.1英寸及以下 " checked="checked" />10.1英寸及以下 <input
					type="radio" name="measure" value="12英寸 " />12英寸 <input
					type="radio" name="measure" value="11英寸" />11英寸<input type="radio"
					name="measure" value="14英寸 " />14英寸 <input type="radio"
					name="measure" value="13英寸 " />13英寸 <input type="radio"
					name="measure" value="16英寸" />16英寸<input type="radio"
					name="measure" value="15英寸" />15英寸<input type="radio"
					name="measure" value="17英寸17英寸以上" />17英寸17英寸以上</td>
			</tr>
			<tr>
				<th>&nbsp;商品款式集:</th>
				<td id="imagesTd0">
					<div style="padding: 10px 0;">
						<input type="button" value="上传" onclick="imageFile('imagefile')" /><input
							style="display: none" type="file" id="imagefile" name="file"
							onchange="uploadImageFile('imagefile')" />
					</div> 
					<c:forEach var="images"
						items="${product.images}" varStatus="images">
						<input id="image${images.index}" name="image" class="input" value="${product.images[images.index].site}"/>
					</c:forEach>
				</td>
				<th>&nbsp;预览（160*160）：</th>
				<td id="imagesTd"><c:forEach var="images"
						items="${product.images}" varStatus="images">
						<div id="imagesDiv${images.index}">
							<input name="images[${images.index }].id"
								value="${product.images[images.index].id}" type="hidden"> <input
								name="images[${images.index }].site"
								value="${product.images[images.index].site}" type="hidden"> <input
								name="images[${images.index }].position"
								value="${product.images[images.index].position}" type="hidden">
							<input name="images[${images.index }].sortid"
								value="${product.images[images.index ].sortid}" type="hidden"> <img
								id="titleImg1" src="${ctx}/${product.images[images.index].site}"
								style="width:160px;height:160px;background-color: gray;border: 1px solid black;" />
							<input type="button" value="删除" onclick="$('#image${images.index}').remove();$('#imagesDiv${images.index}').remove();"/>
						</div>

					</c:forEach></td>
			</tr>

			<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
				<th>&nbsp;文件名：</th>
				<td><input id="fileName" name="fileName" value="" class="input" />
					&nbsp; <input id="fileUploadBtn" type="button" value="上传"
					onclick="selectFile()" /> <input style="display: none" type="file"
					id="file" name="file" onchange="uploadImage()" /> <br /></td>
				<th>&nbsp;文件地址：</th>
				<td id="fileAddrTd"></td>
			</tr>
			<%--<tr>
      <th>&nbsp;</th>
      <td>&nbsp;</td>
      <th>&nbsp;content：</th>
      <td><textarea id="content" name="content">${product.content}</textarea>
        &nbsp;
        <label for="content" style="color:red;">*</label></td>
    </tr>--%>
			<tr>
				<th style="width: 150px;">&nbsp;</th>
				<td style="text-align: left;" colspan="6"><input type="submit"
					value="保存" /> &nbsp;&nbsp; <input type="reset" value="重置" />
					&nbsp;&nbsp; <input type="button" value="清空" onclick="clearForm();" />
					&nbsp;&nbsp; <input type="button" value="返回"
					onclick="javascript:window.location.href='${ctxAdmin}/product'" /></td>
			</tr>
		</table>
		<div>
			<b>商品详情</b>
			<script id="editor" type="text/plain"
				style="width:100%;height:500px;"></script>
		</div>
	</form>
	<div id="dlg" class="easyui-dialog" title="文档选择"
		data-options="iconCls:'icon-save',closed: true"
		style="width:600px;height:350px;padding:10px">
		<div style="padding: 5px;border: 0px;">
			<script>
				//搜索
				function search() {
					var queryParams = {};
					if ($("zhNameInput").val() != "") {
						queryParams.zhName = $("#zhNameInput").val();
					}
					//if ($("enNameInput").val() != "") {
					//			queryParams.enName = $("#enNameInput").val();
					//		}

					$("#tgrid").datagrid("getPager").pagination({
						pageNumber : 1
					});

					$("#tgrid").datagrid("options").queryParams = queryParams;
					$("#tgrid").datagrid("reload");
				}

				//清除
				function clearSearch() {
					$("#zhNameInput").val("");
					//$("#enNameInput").val("");
				}
			</script>
			<label>品牌名称:</label> <input id="zhNameInput"> <input
				type="button" id="searchBtn" value="搜索" onclick="search();" /> <input
				type="button" id="clearBtn" value="清除" onclick="clearSearch();" />
		</div>
		<table id="tgrid" title="" class="easyui-datagrid"
			data-options="
								pageSize : 10,
								pageList : [ 5, 10, 15, 20 ],
								nowrap : true,
								striped : true,
								collapsible : true,
								url: '${ctxAdmin}/brand/select',
								loadMsg : '数据装载中......',
								method: 'get',
								singleSelect : true,
								selectOnCheck: true,
								checkOnSelect: true,
								rownumbers: false,
								treeField: 'name',
								showHeader: true,
								pagination : true,
		    					onSelect:function (rowIndex, rowData){
		    						$('#zhName').val(rowData['zhName']);
                                    $('#proBrandId').val(rowData['id']);
		   						},
                                columns : [ [ {
				field : 'ck',
				checkbox : true
			}, {
				field : 'id',
				hidden : true,
				title : 'id',
				align : 'center',
				width : 80
			}, {
				field : 'proCategory_id',
				title : '商品种类',
				align : 'center',
				width : 80
			}, {
				field : 'zhName',
				title : '中文名',
				align : 'center',
				width : 80
			}, {
				field : 'enName',
				title : '英文名',
				align : 'center',
				width : 80
			},{
				field : 'updateDate',
				title : '更新日期',
				align : 'center',
				width : 80
			}, {
				field : 'createDate',
				title : '创建日期',
				align : 'center',
				width : 80
			}

			] ]
							">
		</table>
	</div>
</body>
</html>