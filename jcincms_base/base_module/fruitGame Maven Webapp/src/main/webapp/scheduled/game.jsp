<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>水果幸运游戏</title>
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
	var countTime = ${countTime};
	
	function run(){
		setInterval(getRTime,1000);
	}
	
	function getRTime(){
		var t = countTime;

		var h=Math.floor(t/60/60%24);
		var m=Math.floor(t/60%60);
		var s=Math.floor(t%60);

		document.getElementById("time").innerHTML = (h<10?"0"+h:h) + ":"+(m<10?"0"+m:m)+":"+(s<10?"0"+s:s);
		countTime--; 
		if(countTime==0){
			location.reload();
		}           
	}
	
	window.setInterval(function(){getRTime();}, 1000); 
	
	function startUp(){
		$.ajax({
			url: "${pageContext.request.contextPath}/scheduled/startUp",
			success: function (result) {
			     location.reload(); 
			}
		});
	}
	</script>
</head>

<body>
	<div id="header">猴王游戏介绍</div>
	<div id="banner"></div>
	<div class="global">
		<div class="content">
			<img alt="" src="/scheduled/images/88.png">
		</div>
		<div class="content">
		</div>
	</div>
	<div id="CountMsg" class="HotDate">
		<span id="time">00:00:00</span><input type="button" value="按钮"
			onclick="">
	</div>
	<div>
		<span>幸运号是:${currentLuckyNum}</span>
	</div>
	<div>
		<span>本局结果:${currentList}</span>
	</div>
	<div>
		<span>本轮的随机数是：${currentway}————1代表最低赔，2,3代表不输赔，4——10不干涉。</span>
	</div>
</body>
</html>
