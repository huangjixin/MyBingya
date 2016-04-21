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

		createTree();
	});

	function createTree() {
		$('#proCategoryId').combotree({
			url : '${ctxAdmin}/category/getCategoryTree',
			width : 300,
			valuefield : 'id',
			textfield : 'name',
			required : false,
			editable : false,
			onClick : function(node) {
				/*  JJ.Prm.GetDepartmentUser(node.id, 'selUserFrom'); 
				$('#parentId').val(node.id);*/
			}, //全部折叠
			onLoadSuccess : function(node, data) {
				$('#proCategoryId').combotree('tree').tree("collapseAll");
				var val = "${category.proCategoryId}";
				$('#proCategoryId').combotree("setValue", val);
			}
		});
	}

	function clearCategoryIdInput() {
		$('#proCategoryId').combotree('clear');
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
						proCategoryId : {
							required : true
						},
						zhName : {
							required : true
						},
						enName : {
							required : true
						},
						website : {
							required : true
						}
					},
					messages : {
						proCategoryId : {
							required : "必填"
						},
						zhName : {
							required : "必填"
						},
						enName : {
							required : "必填"
						},
						website : {
							required : "必填"
						}
					},
					submitHandler : function(form) {
						return true;
					}
				})
	}
	function clearForm() {
		$('#proCategoryId').val("");
		$('#zhName').val("");
		$('#enName').val("");
		$('#website').val("");
	}
</script>
<title>品牌添加</title>
</head>
<body>
<form id="validForm" action="${ctxAdmin}/brand/create" method="post">
  <div class="desc"> <b>品牌信息添加</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b> </div>
  <hr style="height:1px;border:none;border-top:1px solid #CCCCCC;" />
  <table class="table">
    <tr>
      <th>&nbsp;proCategoryId：</th>
      <td><input class="input" id="proCategoryId"
					name="proCategoryId" value="${brand.proCategoryId}" />
        &nbsp;
        <label
					for="proCategoryId" style="color:red;">*</label></td>
      <th>&nbsp;website：</th>
      <td><input class="input" id="website" name="website"
					value="${brand.website}" />
        &nbsp;
        <label for="website"
					style="color:red;">*</label></td>
    </tr>
    <tr>
      <th>&nbsp;中文名称：</th>
      <td><input class="input" id="zhName" name="zhName"
					value="${brand.zhName}" />
        &nbsp;
        <label for="zhName"
					style="color:red;">*</label></td>
      <th>&nbsp;英文名称：</th>
      <td><input class="input" id="enName" name="enName"
					value="${brand.enName}" />
        &nbsp;
        <label for="enName"
					style="color:red;">*</label></td>
    </tr>
    <tr>
      <th>&nbsp;description：</th>
      <td><textarea class="descrition" id="description" name="description"
					value="${brand.description}" ></textarea>
        &nbsp;
        <label for="description"
					style="color:red;">*</label></td>
      <th>&nbsp;story：</th>
      <td><textarea class="descrition" id="story" name="story">${brand.story}</textarea>
        &nbsp;
        <label for="story"
					style="color:red;">*</label></td>
    </tr>
    <tr>
      <th style="width: 150px;">&nbsp;</th>
      <td style="text-align: left;" colspan="6"><input type="submit"
					value="保存" />
        &nbsp;&nbsp;
        <input type="reset" value="重置" />
        &nbsp;&nbsp;
        <input
					type="button" value="清空" onclick="clearForm();" />
        &nbsp;&nbsp;
        <input
					type="button" value="返回"
					onclick="javascript:window.location.href='${ctxAdmin}/brand'" /></td>
    </tr>
  </table>
</form>
</body>
</html>