<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>游戏首页</title>
<meta name="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<script type="text/javascript" src="/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/scheduled.css">
<style type="text/css">
table.imagetable {
	width: 100%;
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
	font-family: verdana, arial, sans-serif;
}

table.imagetable th {
	background: #b5cfd2 url('cell-blue.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}

table.imagetable td {
/* 	background: #dcddc0; */
	background: #ffffff;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
	font-size: 1.5em;
}

table.imagetable img {
	width:50px;
	height:auto;
}
</style>
<script type="text/javascript">
	var countTime = -1;
	var status= "end";
	var running= true;
	$().ready(function() {
		getRemoteInfo();
	})
	
	function getRemoteInfo(){
		$.ajax({
				type : "get",
				url : "/scheduled/getInfo",
				dataType : "json",
				success : function(data) {
					setData(data);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					status == "end"
				}
			});
	}
	
	function setData(data){
		countTime = data["countTime"];
		status= data["status"];
		setTimeDoc();
		
		document.getElementById("onlineNum").innerHTML = data["count"];
		
		var currentLuckyNum= data["currentLuckyNum"];
		document.getElementById("luckN").innerHTML = currentLuckyNum;
		
		if(currentLuckyNum==1){
			$("#resuImg").attr("src","./images/big_1.jpg");
		}else if(currentLuckyNum==2){
			$("#resuImg").attr("src","./images/big_2.jpg");
		}else if(currentLuckyNum==3){
			$("#resuImg").attr("src","./images/big_3.jpg");
		}else if(currentLuckyNum==4){
			$("#resuImg").attr("src","./images/big_4.jpg");
		}else if(currentLuckyNum==5){
			$("#resuImg").attr("src","./images/big_5.jpg");
		}else if(currentLuckyNum==6){
			$("#resuImg").attr("src","./images/big_6.jpg");
		}
			
		$("#resultTable tr:gt(0)").remove();
		var resultArr = data["result"];
		for(var i=resultArr.length-1;i>=0;i--){
			if(resultArr[i]['num']==1){
				$("#resultTable").append("<tr><td>"+(i+1)+"场</td><td>"+resultArr[i]['num']+"</td><td><img src='./images/big_1.jpg'></td></tr>")
			}else if(resultArr[i]['num']==2){
				$("#resultTable").append("<tr><td>"+(i+1)+"场</td><td>"+resultArr[i]['num']+"</td><td><img src='./images/big_2.jpg'></td></tr>")
			}else if(resultArr[i]['num']==3){
				$("#resultTable").append("<tr><td>"+(i+1)+"场</td><td>"+resultArr[i]['num']+"</td><td><img src='./images/big_3.jpg'></td></tr>")
			}else if(resultArr[i]['num']==4){
				$("#resultTable").append("<tr><td>"+(i+1)+"场</td><td>"+resultArr[i]['num']+"</td><td><img src='./images/big_4.jpg'></td></tr>")
			}else if(resultArr[i]['num']==5){
				$("#resultTable").append("<tr><td>"+(i+1)+"场</td><td>"+resultArr[i]['num']+"</td><td><img src='./images/big_5.jpg'></td></tr>")
			}else if(resultArr[i]['num']==6){
				$("#resultTable").append("<tr><td>"+(i+1)+"场</td><td>"+resultArr[i]['num']+"</td><td><img src='./images/big_6.jpg'></td></tr>")
			}
			
		}
	}
	
	function setTimeDoc(){
		if(countTime!=0){
			var t = countTime;
			var m=Math.floor(t/60%60);
			var s=Math.floor(t%60);
			document.getElementById("min").innerHTML = (m<10?"0"+m:m)+"分";
			document.getElementById("sec").innerHTML = (s<10?"0"+s:s)+"秒";
		}
		
		if(countTime==0){
			if(status == "start"){//已经开始
				getRemoteInfo();
			}else{//已经关闭
			
			}
		}else{
			countTime-=1;
		}
	}
	
	window.setInterval(function(){setTimeDoc();}, 1000);
</script>
</head>
<body>
	<div id="header">
		<h1>猴王游戏</h1>
		<a href="/intro.html"><h4 style="color: 0;">规则介绍</h4></a>
		<a href="/scheduled/logout"><h4 style="color: 0;">退出</h4></a>
	</div>
	<div id="banner">
		<script language="Javascript">
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
		</script>
	</div>
	<div class="global">
		<div class="content">
			<img alt="" src="./images/88.png">
		</div>
		<div class="content">
			<div class="indexonline">
				当前在线人数:&nbsp;<span id="onlineNum"></span>
			</div>
			<div class="indexonline">
				当前第 <span id="onlineChang"></span> 场，竞猜倒计时：
			</div>
			<div class="devider"></div>
			<div>
				<span id="min"
					style="padding: 5px 10px;font-size: 30px;background-color: #C71C60;color:white;font-weight: bold;">
					0分</span> <span id="sec"
					style="padding: 5px 10px;font-size: 30px;background-color: #C71C60;color:white;font-weight: bold;margin-left: 10px;">
					0秒</span>
			</div>
			<div class="devider" style="height: 20px;"></div>
			<div>
				<a href="/scheduled/personal"><span
					style="padding: 5px 10px;font-size: 30px;background-color: #EECB3F;color:white;font-weight: bold;">
						马上下注</span></a>
			</div>
			<div class="devider"></div>
			<div class="indexonline">
				上期结果：<span id="luckN"></span>
				<div><img id="resuImg" src=""></div>
			</div>
			<div class="devider"></div>
			<div style="text-align: center;margin: 0 auto;width: 100%;">
				<table class="imagetable" id="resultTable">
					<tr>
						<th>场次</th>
						<th>结果</th>
						<th>水果</th>
					</tr>
				</table>
			</div>
			<div class="devider"></div>
			<h3>全天24小时不间断开奖</h3>
			<h3>5分钟开一次奖，场场爆满</h3>
		</div>
	</div>
	<div id="footer">猴王版权所有</div>
</body>
</html>
