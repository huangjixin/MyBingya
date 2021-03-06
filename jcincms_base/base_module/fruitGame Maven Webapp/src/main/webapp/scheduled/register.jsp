<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>注册</title>
<meta name="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.form.js"></script>
<script type="text/javascript" src="../js/jquery.mobile-1.4.5.js"></script>
<script type="text/javascript" src="../js/jquery.validate.js"></script>
<script type="text/javascript" src="../js/localization/messages_zh.js"></script>
<link rel="stylesheet" type="text/css" href="../css/scheduled.css">
<link rel="stylesheet" type="text/css"
	href="../css/jquery.mobile-1.4.5.css">
<script type="text/javascript">
	jQuery.validator.addMethod("alnum", function(value, element) {
		return this.optional(element) || /^[a-zA-Z]+$/.test(value);
	}, "只能包括英文字母");

	$().ready(function() {
		$("#form").validate({
			errorPlacement: function(error, element) {
			// Append error within linked label
			$( element )
				.closest( "form" ).find( "label[for='" + element.attr( "id" ) + "']" )
						.append( error );
		},
		errorElement: "span",
			rules : {
				username : {
					required : true,
					minlength : 2
				},
				password : {
					required : true,
					minlength : 5
				},
				confirm_password : {
					required : true,
					minlength : 5,
					equalTo : "#password"
				}
			},
			messages : {
				username : {
					required : "请输入用户名",
					minlength : "用户名必需由两个字母组成"
				},
				password : {
					required : "请输入密码",
					minlength : "密码长度不能小于 5 个字母"
				},
				confirm_password : {
					required : "请输入密码",
					minlength : "密码长度不能小于 5 个字母",
					equalTo : "两次密码输入不一致"
				}
			},submitHandler:function(form) {
				$("#form").ajaxSubmit();          //用Jquery Form的函数
  			}
		})
	});
</script>
</head>

<body>
	<div id="banner"></div>
	<div class="global">
		<div class="content">
			<form name="form" id="form" action="/scheduled/register" method="post">
				<table>
					<tr>
						<td>用户名:</td>
						<td><input type="text" name="username" id="username">
						</td>
						<td>
							<label for="username" style="color:red;">*</label>
						</td>
					</tr>
					<tr>
						<td>密 码:</td>
						<td><input type="password" name="password" id="password">
						</td>
						<td>
							<label for="password" style="color:red;">*</label>
						</td>
					</tr>
					<tr>
						<td>重复密码:</td>
						<td><input type="password" name="confirm_password"
							id="confirm_password">
						</td>
						<td>
							<label for="confirm_password" style="color:red;">*</label>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="注册"></td>
						<td><input type="button" value="返回首页"  onclick="window.location.href='index.html';"></td>
					</tr>
				</table>
			</form>
			<div id="tip"></div>
		</div>
	</div>
</body>
</html>
