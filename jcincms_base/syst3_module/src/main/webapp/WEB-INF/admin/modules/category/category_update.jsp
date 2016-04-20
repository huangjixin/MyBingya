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

	function validateForm(){
		$("#validForm").validate({
			errorPlacement : function(error,element) {
				$(element).closest("form").find("label[for='"+ element.attr("id")+ "']").append(error);
			},errorElement : "span",
			rules : {
								id:{
					required : true
				},
				name:{
					required : true
				},
				parentId:{
					required : true
				},
				sortid:{
					digits:true,
					required : true
				},
				createDate:{
					required : true
				},
				updateDate:{
					required : true
				},
				isParent:{
					required : true
				}
			},messages : {
				id:{
					required : "必填"
				},
				name:{
					required : "必填"
				},
				parentId:{
					required : "必填"
				},
				sortid:{
					digits:"整数",
					required : "必填"
				},
				createDate:{
					required : "必填"
				},
				updateDate:{
					required : "必填"
				},
				isParent:{
					required : "必填"
				}
			},
			submitHandler : function(form) {
					return true;
				}
			})
	}
	
	function clearForm(){
		$('#id').val("");
		$('#name').val("");
		$('#parentId').val("");
		$('#sortid').val("");
		$('#createDate').val("");
		$('#updateDate').val("");
		$('#isParent').val("");
	}
	
	function createTree(){
		$('#parentId').combotree({ 	
				url: '${ctxAdmin}/category/getCategoryTree',
				width:300,
				valuefield : 'id',
				textfield : 'name',
				required : false,
				editable : false,
				onClick : function(node) {
					/*  JJ.Prm.GetDepartmentUser(node.id, 'selUserFrom'); 
					$('#parentId').val(node.id);*/
				}, //全部折叠
				onLoadSuccess : function(node, data) {
					$('#parentId').combotree('tree').tree("collapseAll");
					var val = "${category.parentId}";
					$('#parentId').combotree("setValue", val);
				}
			});
	}
	
	function clearParentInput(){
		$('#parentId').combotree('clear');
	}
</script>
<title>商品种类更新</title>
</head>
<body>
<form id="validForm" action="${ctxAdmin}/category/update/${category.id}" method="post">
  <input name="id" value="${category.id}" type="hidden" />
  <div class="desc"> <b>商品种类信息更新</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b> </div>
  <hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
  <table class="table">
    <tr>
      <th>&nbsp;种类名称：</th>
      <td><input id="name" name="name" 
								value="${category.name}"/>
        &nbsp;
        <label for="name" style="color:red;">*</label></td>
      <th>&nbsp;所述种类：</th>
      <td><input id="parentId" name="parentId" 
								value="${category.parentId}"/>
        &nbsp;
        <label for="parentId" style="color:red;">*</label></td>
    </tr>
    <tr>
      <th>&nbsp;排序ID（越小越靠前）：</th>
      <td><input id="sortid" name="sortid" 
								value="${category.sortid}"/>
        &nbsp;
        <label for="sortid" style="color:red;">*</label></td>
      <th>&nbsp;是否为父类：</th>
      <td><%--<input id="isParent" name="isParent" 
								value="${category.isParent}"/>--%>
        <select id="isParent" name="isParent" style="width:100px;">
          	<option label="是" value="1" <c:if test="${category.isParent == 1}">selected="selected"</c:if> />
            <option label="否" value="0" <c:if test="${category.isParent == 0}">selected="selected"</c:if> />
          </select>
        &nbsp;
        <label for="isParent" style="color:red;">*</label></td>
    </tr>
    <tr>
      <th style="width: 150px;">&nbsp;</th>
      <td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />
        &nbsp;&nbsp;
        <input type="reset" value="重置" />
        &nbsp;&nbsp;
        <input type="button" value="清空" onclick="clearForm();" />
        &nbsp;&nbsp;
        <input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/category'"/></td>
    </tr>
  </table>
</form>
</body>
</html>