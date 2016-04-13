<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="m-meta.jsp" flush="true"></jsp:include>
<jsp:include page="m-css.jsp" flush="true"></jsp:include>
<jsp:include page="m-js.jsp" flush="true"></jsp:include>
<script type="text/javascript" src="${ctx}/js/jquery.validate.js"></script>
<%-- <script type="text/javascript" src="${ctx}/js/jquery-ui/jquery-ui.js"></script> --%>
<script type="text/javascript"
	src="${ctx}/js/localization/messages_zh.js"></script>
<%-- <script type="text/javascript" src="${ctx}/js/jquery.mobile-1.4.5.js"></script> 
<link rel="stylesheet" type="text/css"
	href="${ctx}/css/jquery.mobile-1.4.5.css">--%>
<style type="text/css">
.formBtn {
	font-size: 20px;
	width: 80px;
	height: 35px;
	line-height: 35px;
	border: 0;
	background-color: red;
	color: #ffffff;
}

.formInput {
	border: 1px solid #999;
	height: 30px;
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
	text-align: right;
	font-size: 14px;
	background: #F4FAFF;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #B9D8F3;
}

table.table td {
	text-align: left;
	/* 	background: #dcddc0; */
	background: #F4FAFF;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #B9D8F3;
	font-size: 16px;
	/* 	font-size: 1.5em; */
}
</style>
<title>让我们知道你的需求,智沃商务,华南品牌,专业建设营销建站,手机网站，微网站</title>
</head>
<body>
	<!-- 头部 -->
	<jsp:include page="m-header.jsp" flush="true"></jsp:include>
	<div class="clear"></div>
	<!-- 菜单 -->
	<jsp:include page="m-menu.jsp" flush="true"></jsp:include>
	<div class="clear"></div>
	<div style="height: 1px;"></div>
	<div style="padding: 5px 0px;">
		<img alt="智沃科技" src="${ctx}/images/aboutus_banner.jpg"
			style="height: auto;width: 100%;">
	</div>
	<div
		style="padding: 5px 0;text-align: center;background-color: red;color:#ffffff;">
		<span>请让我们知道您的需求</span>
	</div>
	<div class="global" style="padding: 10px 0;">
		<form id="validForm" action="${ctx}/guestbook/m_create" method="post">
			<table class="table">
				<tr>
					<th>&nbsp;主题：</th>
					<td><input id="topic" name="topic" value="${guestbook.topic}"
						class="formInput" /> &nbsp;<label for="topic" style="color:red;">*</label></td>
				</tr>
				<tr>
					<th>&nbsp;电话：</th>
					<td><input id="tel" name="tel" value="${guestbook.tel}"
						class="formInput" /> &nbsp;<label for="guestbook"
						style="color:red;">*</label>
				</tr>
				<tr>
					<th>&nbsp;qq：</th>
					<td><input id="qq" name="qq" value="${guestbook.qq}"
						class="formInput" /> &nbsp;<label for="qq" style="color:red;">*</label></td>
				</tr>
				<tr>
					<th>&nbsp;名称：</th>
					<td><input id="name" name="name" value="${guestbook.name}"
						class="formInput" /> &nbsp;<label for="name" style="color:red;">*</label></td>
				</tr>
				<tr>
					<th>&nbsp;email：</th>
					<td colspan="4"><input id="email" name="email"
						value="${guestbook.email}" class="formInput" /> &nbsp;<label
						for="email" style="color:red;">*</label></td>
				</tr>
				<tr>
					<th>&nbsp;内容：</th>
					<td colspan="4"><textarea id="content" name="content"
							style="height: 150px;">${guestbook.content}</textarea> &nbsp;<label
						for="content" style="color:red;">*</label></td>
					</td>
				</tr>
				<tr>
					<th style="width: 150px;">&nbsp;</th>
					<td style="text-align: left;" colspan="6"><input type="submit"
						value="保存" class="formBtn" />&nbsp;&nbsp;<!-- <input type="reset" value="重置"  class="formBtn"/>&nbsp;&nbsp;<input
						type="button" value="清空" onclick="clearForm();"  class="formBtn"/>&nbsp;&nbsp; -->
						<input type="button" value="返回" class="formBtn"
						onclick="javascript:window.location.href='${ctx}/m-index'" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="clear"></div>
	<!-- 底部 -->
	<jsp:include page="m-footer.jsp" flush="true"></jsp:include>
	<!-- 菜单底部 -->
	<jsp:include page="m-bottommenu.jsp" flush="true"></jsp:include>
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
								maxlength : 100,
								required : true
							},
							content : {
								maxlength : 800,
								required : true
							},
							tel : {
								maxlength : 11,
								digits : true,
								required : true
							},
							qq : {
								maxlength : 11,
								digits : true,
								required : true
							},
							name : {
								maxlength : 20,
								required : true
							},
							email : {
								maxlength : 100,
								email : true,
								required : true
							}
						},
						messages : {
							topic : {
								maxlength : "不要超过50字",
								required : "必填"
							},
							content : {
								maxlength : "不要超过400字",
								required : "必填"
							},
							tel : {
								maxlength : "不要超过11字母",
								required : "必填"
							},
							qq : {
								maxlength : "不要超过11字母",
								required : "必填"
							},
							name : {
								maxlength : "不要超过4字",
								required : "必填"
							},
							email : {
								maxlength : "不要超过100字母",
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
