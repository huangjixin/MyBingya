<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<title>用户添加</title>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui/dwrloader.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui/easyloader.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/jquery-easyui/themes/icon.css">
<style type="text/css">
.table {
	border-collapse: collapse;
}

.tr1 {
	width: 100px;
	text-align: right;
	background-color: #F7F7F7;
}

.th1 {
	width: 50px;
	background-color: #F7F7F7;
	text-align: right;
	padding-right: 2px;
	background-color: #F7F7F7;
	font-weight: normal;
}

.td1 {
	width: 250px;
	background-color: #ffffff;
	text-align: left;
	width: 200px;
	padding-left: 2px;
	padding: 4px;
}
</style>
<script type="text/javascript">
	//清除表单。
	function clearForm() {
// 		$('.easyui-combotree').combotree('clear');
// 		$('#roleId').val('');
// 		$('#name').val('');
// 		$('#url').val('');
// 		$('#description').val('');
// 		$('#result').html('');
	}

	//父类菜单变化。
	function onChange(rec) {
		$('#roleId').val(rec.id);
	}

	function onLoadSuccess() {
		var roleId = $('#roleId').val();
		var data = $('#roleCombobox').combobox('getData');
		for(var i=0;i<data.length;i++){
			if(data[i].id ==  roleId){
				$('#roleCombobox').combobox('select', data[i].name);
			}
		}
	}
</script>
</head>
<body>
	<form id="form_return" action="list"></form>
	<form action="create" method="post">
		<table width="100%" border="1px;" bordercolor="#C5C5C5" align="center"
			cellpadding="0" cellspacing="0" style="border-collapse: collapse;">
			<tbody>
				<tr class="tr1">
					<th class="th1">用户名:</th>
					<td class="td1"><input type="hidden" id="idInput" name="id"/><input type="text" name="username" id="name"
						value="${user.username}" size="35"></td>
				</tr>
				<tr class="tr1">
					<th class="th1">密  码:</th>
					<td class="td1"><input type="password" name="password" id="password"
						value="" size="35"></td>
				</tr>
				<tr class="tr1">
					<th class="th1">角色:</th>
					<td class="td1"><input type="hidden" name="roleId"
						id="roleId" value="${roleId}"><input
						class="easyui-combobox" id="roleCombobox"
						data-options="editable : false,url:'<%=basePath%>role/selectAll',method:'get',onSelect:onChange,onLoadSuccess:onLoadSuccess,textField:'name'"
						style="width:224px;">  <input type="button"
						onclick="$('.easyui-combobox').combobox('clear');$('#roleId').val('');"
						value="清除" /></td>
				</tr>
				<tr class="tr1">
					<th class="th1">描述:</th>
					<td class="td1" colSpan="3" style="padding: 4px;"><textarea
							id="description" name="description"
							style="width: 520px;height: 100px;">${user.description}</textarea></td>
				</tr>
				<tr class="tr1">
					<th></th>
					<td class="td1"><input type="submit" value="保存" /><input
						type="button" value="清除表单" onclick="clearForm();" /><input
						type="button" value="返回" onclick="$('#form_return').submit();" />
						<label id="result">${result}</label></td>

				</tr>
			</tbody>
		</table>
	</form>


</body>
</html>