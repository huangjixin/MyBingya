<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>系统异常</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="异常信息">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	如果你看到该页面，请不要慌张，联系工作人员，把这个页面发给我们，谢谢！^_^<br>
	<%
		Exception ex = (Exception)request.getAttribute("exception");
	%> 
	<H2>
		Exception:
		<%=ex.getMessage();%></H2>
	 
	<P />
	 
	<%
		ex.printStackTrace(new java.io.PrintWriter(out));
	%>
</body>
</html>
