<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<link href="${ctx}/js/jquery-easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/js/jquery-easyui/themes/icon.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-easyui/easyloader.js"></script>
<script type="text/javascript" src="${ctx}/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/js/localization/messages_zh.js"></script>
<script type="text/javascript">
	$.fn.datebox.defaults.formatter = function(date) {
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		return y + '-' + m + '-' + d;
	}

	function toDate(num) { //Fri Oct 31 18:00:00 UTC+0800 2008
		num = num + "";
		var date = "";
		var month = new Array();
		month["Jan"] = 1;
		month["Feb"] = 2;
		month["Mar"] = 3;
		month["Apr"] = 4;
		month["May"] = 5;
		month["Jan"] = 6;
		month["Jul"] = 7;
		month["Aug"] = 8;
		month["Sep"] = 9;
		month["Oct"] = 10;
		month["Nov"] = 11;
		month["Dec"] = 12;
		var week = new Array();
		week["Mon"] = "一";
		week["Tue"] = "二";
		week["Wed"] = "三";
		week["Thu"] = "四";
		week["Fri"] = "五";
		week["Sat"] = "六";
		week["Sun"] = "日";
		str = num.split(" ");
		date = str[5] + "-";
		date = date + month[str[1]] + "-" + str[2];
		return date;
	}
</script>
<style type="text/css">
#toolBar{
	padding: 5px;
	border: 1px;
}
#validForm .input{
	height:20px;
	width: 300px;
}
#validForm .descrition{
	height:80px;
	width: 90%;
}


table.table {
	width: 100%;
	font-family: verdana, arial, sans-serif;
	font-size: 14px;
	color: #333333;
	border-width: 1px;
	border-color: #B9D8F3;
	border-collapse: collapse;
	font-family: verdana, arial, sans-serif;
}

table.table th {
	text-align:right;
	font-size: 14px;
	background: #F4FAFF;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #B9D8F3;
}

table.table td {
	text-align:left;
/* 	background: #dcddc0; */
	background: #F4FAFF;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #B9D8F3;
	font-size: 16px;
/* 	font-size: 1.5em; */
}

/* table.table img {
	width:50px;
	height:auto;
} */

/* th {
	font-weight: normal;
	font-size: 16px;
	width: 50px;
} */
</style>