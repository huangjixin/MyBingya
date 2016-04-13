<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="meta-channel.jsp" flush="true"></jsp:include>
<jsp:include page="css.jsp" flush="true"></jsp:include>
<jsp:include page="js.jsp" flush="true"></jsp:include>
<script type="text/javascript" src="${ctx}/js/jquery.validate.js"></script>
<%-- <script type="text/javascript" src="${ctx}/js/jquery-ui/jquery-ui.js"></script> --%>
<script type="text/javascript"
	src="${ctx}/js/localization/messages_zh.js"></script>
<style type="text/css">
#validForm .input{
	height:20px;
	width: 280px;
}
#validForm .descrition{
	height:200px;
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
<title>让我们知道你的需求_广州智沃——专业的互联网营销策划与人才服务商</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<jsp:include page="menu.jsp" flush="true"></jsp:include>
	<div class="globalWidth" id="banner">
		<img alt="" src="${ctx}/images/aboutus_banner.jpg"
			style="width: 100%;">
	</div>
	<div class="globalWidth">
		<div class="contentWidth" style="text-align: left;position: relative;">
			<span style="font-size: 12px;color:#333333;">当前位置： <a
				href="${ctx}/"
				style="font-size: 12px;text-decoration: none;color:#333333;">首页</a>
				<c:if test="${navChan !=null}">
					<c:forEach var="chan" items="${navChan}">
										><a href="${ctx}/${chan.linkAddr}"
							style="font-size: 12px;text-decoration: none;color:#333333;">${chan.name}</a>
					</c:forEach>
				</c:if>
			</span>
		</div>
	</div>
	<div class="globalWidth">
		<div class="contentWidth" style="text-align: left;position: relative;">
			<span style="color:#333333;font-size: 30px;">提交您的需求</span><span
				style="color:#333333;font-size: 12px;">最专业的互联网营销策划与人才提供商！</span>
		</div>
		<hr class="hr"></hr>
	</div>
	<div class="globalWidth">
		<div class="contentWidth" style="text-align: left;padding: 5px 0;">
			<div>
				<span>${msg}</span>
			</div>
			<form id="validForm" action="${ctx}/guestbook/create"
				method="post">
				<table class="table">
					<tr>
						<th>&nbsp;主题：</th>
						<td><input id="topic" name="topic" value="${guestbook.topic}"
							class="input" /> &nbsp;<label for="topic" style="color:red;">*</label></td>
						<th>&nbsp;电话：</th>
						<td><input id="tel" name="tel" value="${guestbook.tel}"
							class="input" /> &nbsp;<label for="guestbook" style="color:red;">*</label>
					</tr>
					<tr>
						<th>&nbsp;内容：</th>
						<td colspan="4"><textarea id="content" name="content"
								class="descrition">${guestbook.content}</textarea> &nbsp;<label
							for="content" style="color:red;">*</label></td>
						</td>
					</tr>
					<tr>
						<th>&nbsp;qq：</th>
						<td><input id="qq" name="qq" value="${guestbook.qq}"
							class="input" /> &nbsp;<label for="qq" style="color:red;">*</label></td>
						<th>&nbsp;名称：</th>
						<td><input id="name" name="name" value="${guestbook.name}"
							class="input" /> &nbsp;<label for="name" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;email：</th>
						<td colspan="4"><input id="email" name="email"
							value="${guestbook.email}" class="input" /> &nbsp;<label
							for="email" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th style="width: 150px;">&nbsp;</th>
						<td style="text-align: left;" colspan="6"><input
							type="submit" value="保存" />&nbsp;&nbsp;<input type="reset"
							value="重置" />&nbsp;&nbsp;<input type="button" value="清空"
							onclick="clearForm();" />&nbsp;&nbsp;<input type="button"
							value="返回"
							onclick="javascript:window.location.href='${ctx}/'" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp" flush="true"></jsp:include>
	<script type="text/javascript">
		$().ready(function() {
			validateForm();
		});

		function validateForm() {
			$("#validForm").validate(
					{
						errorPlacement : function(error, element) {
							$(element).closest("form").find(
									"label[for='" + element.attr("id") + "']")
									.append(error);
						},
						errorElement : "span",
						rules : {
							topic : {
								maxlength:100,
								required : true
							},
							content : {
								maxlength:800,
								required : true
							},
							tel : {
								maxlength:11,
								digits:true,
								required : true
							},
							qq : {
								maxlength:11,
								digits:true,
								required : true
							},
							name : {
								maxlength:20,
								required : true
							},
							email : {
								maxlength:100,
								email:true,
								required : true
							}
						},
						messages : {
							topic : {
								maxlength:"不要超过50字",
								required : "必填"
							},
							content : {
								maxlength:"不要超过400字",
								required : "必填"
							},
							tel : {
								maxlength:"不要超过11字母",
								required : "必填"
							},
							qq : {
								maxlength:"不要超过11字母",
								required : "必填"
							},
							name : {
								maxlength:"不要超过4字",
								required : "必填"
							},
							email : {
								maxlength:"不要超过100字母",
								required : "必填"
							}
						},
						submitHandler : function(form) {
							return true;
						}
					})
		}

		function clearForm() {
			$('#topic').val("");
			$('#content').val("");
			$('#tel').val("");
			$('#qq').val("");
			$('#name').val("");
			$('#email').val("");
		}
	</script>
</body>
</html>
