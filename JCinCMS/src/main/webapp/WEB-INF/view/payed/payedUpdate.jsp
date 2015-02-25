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
<title>更新</title>
</head>
<body>
	<form id="form_return" action="list"></form>
	<form action="update" method="post">
		<table>
			<tr>
				<th></th>
				<td><input type="button" value="返回"
					onclick="$('#form_return').submit();" /></td>
			</tr>
			<tr>
				<th>ID：</th>
				<td><input type="text" id="material" name="id"
					value="${payed.id}" /></td>
			</tr>
			<tr>
				<th>材质：</th>
				<td><input type="text" id="material" name="material"
					value="${payed.material}" /></td>
			</tr>
			<tr>
				<th>客户名：</th>
				<td><input type="text" id="customerName" name="customerName"
					value="${payed.customerName}" /></td>
			</tr>
			<tr>
				<th>规格：</th>
				<td><input type="text" id="size" name="size"
					value="${payed.size}" /></td>
			</tr>
			<tr>
				<th>重量：</th>
				<td><input type="text" id="weight" name="weight"
					value="${payed.weight}"  /></td>
			</tr>
			<tr>
				<th>单价：</th>
				<td><input type="text" id="price" name="price"
					value="${payed.price}"  /></td>
			</tr>
			<tr>
				<th>货款：</th>
				<td><input type="text" id="goodsMoney" name="goodsMoney"
					value="${payed.goodsMoney}"  /></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
</body>
</html>