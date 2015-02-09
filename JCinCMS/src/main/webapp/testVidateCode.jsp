<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>验证码</title>
<script type="text/javascript">
	function refresh(obj) {
		obj.src = "validateCode/getValidateCode?" + Math.random();
	}
</script>
</head>
<body>
	<form action="" method="post">
		<label>输入验证码</label><br /> <input type="text" name="randomCode" /><img
			title="点击更换" onclick="javascript:refresh(this);" src="validateCode/getValidateCode"><br />
		<input type="submit" value="submit">
	</form>
</body>
</html>