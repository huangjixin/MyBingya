<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/admin/include/js.jsp"%>
<script type="text/javascript">
	$().ready(function() {
		validateForm();
	});

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
						site : {
							required : true
						},
						name : {
							required : true
						},
						ismasterpic : {
							required : true
						}
					},
					messages : {
						site : {
							required : "必填"
						},
						name : {
							required : "必填"
						},
						ismasterpic : {
							required : "必填"
						}
					},
					submitHandler : function(form) {
						return true;
					}
				})
	}

	function selectFile() {
		document.getElementById("msg").innerHTML = "";
		$('#file').click();
	}

	function uploadImage() {
		// 利用ajaxFileUpload js 插件上传图片
		$.ajaxFileUpload({
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

				$('#site').val(data.fileAddr);
				$('#fileName').val(data.fileName);
			},
			error : function(data, status, e) {
				document.getElementById("msg").innerHTML = "图片上传失败,请重新选择图片";
			}
		});
		return false;
	}

	function clearForm() {
		$('#site').val("");
		$('#name').val("");
		$('#position').val("");
		$('#sortid').val("");
	}
</script>
<title>商品图片添加</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/images/create" method="post">
		<div class="desc">
			<b>商品图片信息添加</b>&nbsp;&nbsp;<b style="color: red;" id="msg">${msg}</b>
		</div>
		<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;" />
		<table class="table">
			<tr>
				<th>&nbsp;文件名：</th>
				<td><input id="fileName" name="fileName"
					value="${document.fileName}" class="input" />&nbsp;<input
					id="fileUploadBtn" type="button" value="上传" onclick="selectFile()" /><input
					style="display: none" type="file" id="file" name="file"
					onchange="uploadImage()" /><br /></td>
				<th>&nbsp;图片地址：</th>
				<td><input id="site" name="site" value="${images.site}"
					class="input" /> &nbsp;<label for="site" style="color:red;">*</label></td>
			</tr>
			<tr>
				<th>&nbsp;商品：</th>
				<td><input id="proProductId" name="proProductId"
					value="${images.proProductId}" type="hidden" /> <input id="name"
					name="name" readonly="readonly" class="input" />&nbsp; <input
					type="button" onclick="$('#dlg').dialog('open')" value="选择商品" />
					&nbsp;<label for="name" style="color:red;">*</label></td>
				<th>&nbsp;位置：</th>
				<td><input id="position" name="position" class="input"
					value="${images.position}" /> &nbsp;<label for="position"
					style="color:red;">*</label></td>
			</tr>
			<tr>
				<th>&nbsp;序号ID：</th>
				<td><input id="sortid" name="sortid" value="${images.sortid}"
					class="input" /> &nbsp;<label for="sortid" style="color:red;">*</label></td>
				<th>&nbsp;是否为主图：</th>
				<td><select id="ismasterpic" name="ismasterpic" class="input">
						<option value="0"
							<c:if test="${images.ismasterpic == 0}">selected="selected"</c:if>>否</option>
						<option value="1"
							<c:if test="${images.ismasterpic == 1}">selected="selected"</c:if>>是</option>
				</select> &nbsp;<label for="ismasterpic" style="color:red;">*</label></td>
			</tr>
			<tr>
				<th style="width: 150px;">&nbsp;</th>
				<td style="text-align: left;" colspan="6"><input type="submit"
					value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input
					type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input
					type="button" value="返回"
					onclick="javascript:window.location.href='${ctxAdmin}/images'" /></td>
			</tr>
		</table>
	</form>
	<div id="dlg" class="easyui-dialog" title="文档选择"
		data-options="iconCls:'icon-save',closed: true"
		style="width:600px;height:350px;padding:10px">
		<div style="padding: 5px;border: 0px;">
			<script>
				//搜索
				function search() {
					var queryParams = {};
					if ($("nameInput").val() != "") {
						queryParams.name = $("#nameInput").val();
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
					$("#nameInput").val("");
					//$("#enNameInput").val("");
				}
				
				function cancelSelected(){
					$("#tgrid").datagrid("uncheckAll");
				}
			</script>
			<label>品牌名称:</label> <input id="nameInput"> <input
				type="button" id="searchBtn" value="搜索" onclick="search();" /> <input
				type="button" id="clearBtn" value="清除" onclick="clearSearch();" />
				<input
				type="button" value="取消选中" onclick="cancelSelected();" />
		</div>
		<table id="tgrid" title="" class="easyui-datagrid"
			data-options="
								pageSize : 10,
								pageList : [ 5, 10, 15, 20 ],
								nowrap : true,
								striped : true,
								collapsible : true,
								url: '${ctxAdmin}/product/select',
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
		    						$('#name').val(rowData['name']);
                                    $('#proProductId').val(rowData['id']);
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
				field : 'name',
				title : '商品名称',
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