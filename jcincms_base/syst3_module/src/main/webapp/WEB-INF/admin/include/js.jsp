<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${ctx}/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.validate.js"></script>
<%-- <script type="text/javascript" src="${ctx}/js/jquery-ui/jquery-ui.js"></script> --%>
<script type="text/javascript"
	src="${ctx}/js/localization/messages_zh.js"></script>
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/demo/demo.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/themes/icon.css">
<%-- <link rel="stylesheet" type="text/css" href="${ctx}/js/jquery-ui/jquery-ui.css"> --%>
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
th {
	font-weight: normal;
	font-size: 12px;
	width: 50px;
}
</style>