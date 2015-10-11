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
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/themes/icon.css">
<script type="text/javascript">
	$().ready(function() {
	});
</script>
<title>上传</title>
</head>
<body>
	<div style="width: 100%;text-align: center;">
			<b>信息添加成功</b><button  onclick="javascript:window.location.href='${ctx}/tqunhuInfo/create'">继续添加上传</button>
		</div>
</body>
</html>