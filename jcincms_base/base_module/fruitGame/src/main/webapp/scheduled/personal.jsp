<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>个人中心</title>
<meta name="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript" src="/js/jquery.validate.js"></script>
<script type="text/javascript" src="/js/localization/messages_zh.js"></script>
<link rel="stylesheet" type="text/css" href="/css/scheduled.css">
<style type="text/css">
table.imagetable {
	width: 80%;
	border-collapse: collapse;
	margin: 0 auto;
}

table.imagetable th {
	padding: 5px;
}

table.imagetable td {
	padding: 5px;
}
</style>
<script type="text/javascript">
	$().ready(function() {
		$("#form").validate({
			submitHandler:function(form) {
				document.getElementById("tip").innerHTML = "正在提交……";
				var options = {    
       				success:function(data){
						document.getElementById("tip").innerHTML = data;
					},error : function(XMLResponse) {  
                        document.getElementById("tip").innerHTML = "错误";
               		}    
   				};
				$("#form").ajaxSubmit(options);          //用Jquery Form的函数
// 				$("#form").submit();          //用Jquery Form的函数
  			}
		})
	});
</script>
</head>

<body>
	<div id="header">
		<h1>猴王游戏</h1>
	</div>
	<div id="banner">
		<!-- <script language="Javascript">
			var datelocalweek = new Array("星期日", "星期一", "星期二", "星期三", "星期四",
					"星期五", "星期六");
			var datelocalnow = new Date();
			var datelocalyear = datelocalnow.getFullYear();
			var datelocalmonth = (datelocalmonth = "0"
					+ (datelocalnow.getMonth() + 1)).substr(
					datelocalmonth.length - 2, 2);
			var datelocalday = (datelocalday = "0" + datelocalnow.getDate())
					.substr(datelocalday.length - 2, 2);
			var datelocalweekday = datelocalweek[datelocalnow.getDay()];
			document.write(datelocalyear + "年" + datelocalmonth + "月"
					+ datelocalday + "日 " + datelocalweekday);
		</script> -->
	</div>
	<div class="global">
		<div class="content">
			<img alt="" src="/scheduled/images/88.png">
		</div>
		<div class="content">
			<div class="indexonline">
				当前第 <span id="onlineChang"></span> 场，竞猜倒计时：
			</div>
			<div  class="indexonline">最低下注1分，输入后提交下注</div>
			<form name="form" id="form" action="/scheduled/createBet" method="post"
				style="width: 100%;">
				<div style="text-align: center;margin: 0 auto;width: 100%;">
					<table class="imagetable">
						<tr>
							<td><img src="/scheduled/images/1.png"></td>
							<td>苹果</td>
							<td><input type="text" name="pingguo" id="pingguo" class="input">
							</td>
						</tr>
						<tr>
							<td><img src="/scheduled/images/2.png"></td>
							<td>葡萄</td>
							<td><input type="text" name="putao" id="putao" class="input"></td>
						</tr>
						<tr>
							<td><img src="/scheduled/images/3.png"></td>
							<td>菠萝</td>
							<td><input type="text" name="boluo" id="boluo" class="input"></td>
						</tr>
						<tr>
							<td><img src="/scheduled/images/4.png"></td>
							<td>草莓</td>
							<td><input type="text" name="caomei" id="caomei" class="input"></td>
						</tr>
						<tr>
							<td><img src="/scheduled/images/5.png"></td>
							<td>西瓜</td>
							<td><input type="text" name="xigua" id="xigua" class="input"></td>
						</tr>
						<tr>
							<td><img src="/scheduled/images/6.png"></td>
							<td>香蕉</td>
							<td><input type="text" name="xiangjiao" id="xiangjiao" class="input"></td>
						</tr>
						<tr>
							<td><img src="/scheduled/images/7.png"></td>
							<td>大</td>
							<td><input type="text" name="da" id="da"  class="input"></td>
						</tr>
						<tr>
							<td><img src="/scheduled/images/8.png"></td>
							<td>小</td>
							<td><input type="text" name="xiao" id="xiao" class="input"></td>
						</tr>
						<tr>
							<td><img src="/scheduled/images/9.png"></td>
							<td>单</td>
							<td><input type="text" name="dan" id="dan" class="input"></td>
						</tr>
						<tr>
							<td><img src="/scheduled/images/10.png"></td>
							<td>双</td>
							<td><input type="text" name="shuang" id="shuang" class="input"></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="提交" class="submit"></td>
							<td><input type="button" value="返回首页" class="submit"  onclick="window.location.href='index';"></td>
						</tr>
					</table>
				</div>
			</form>
			<span id="tip"></span>
			<div class="devider"></div>
			<h3>全天24小时不间断开奖</h3>
			<h3>5分钟开一次奖，场场爆满</h3>
		</div>
	</div>
	<div id="footer">猴王版权所有</div>
</body>
</html>
