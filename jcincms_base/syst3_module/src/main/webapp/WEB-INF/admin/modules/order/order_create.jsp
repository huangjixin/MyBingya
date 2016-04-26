<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/admin/include/js.jsp"%>
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
						serialnumber : {
							required : true
						},
						paytime : {
							required : true
						},
						logistics : {
							required : true
						},
						status : {
							required : true
						},
						title : {
							required : true
						},
						counts : {
							required : true
						},
						price : {
							required : true
						},
						amount : {
							required : true
						},
						realAmount : {
							required : true
						},
						disAmount : {
							required : true
						},
						postage : {
							required : true
						},
						hasPostage : {
							required : true
						},
						buyerIp : {
							required : true
						},
						buyerAddr : {
							required : true
						}
					},
					messages : {
						serialnumber : {
							required : "必填"
						},
						paytime : {
							required : "必填"
						},
						logistics : {
							required : "必填"
						},
						status : {
							required : "必填"
						},
						title : {
							required : "必填"
						},
						counts : {
							required : "必填"
						},
						price : {
							required : "必填"
						},
						amount : {
							required : "必填"
						},
						realAmount : {
							required : "必填"
						},
						disAmount : {
							required : "必填"
						},
						postage : {
							required : "必填"
						},
						hasPostage : {
							required : "必填"
						},
						buyerIp : {
							required : "必填"
						},
						buyerAddr : {
							required : "必填"
						}
					},
					submitHandler : function(form) {
						return true;
					}
				})
	}
	function clearForm() {
		$('#serialnumber').val("");
		$('#paytime').val("");
		$('#logistics').val("");
		$('#status').val("");
		$('#title').val("");
		$('#counts').val("");
		$('#price').val("");
		$('#amount').val("");
		$('#realAmount').val("");
		$('#disAmount').val("");
		$('#postage').val("");
		$('#hasPostage').val("");
		$('#buyerIp').val("");
		$('#buyerAddr').val("");
	}
</script>
<title>订单添加</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/order/create" method="post">
		<div class="desc">
			<b>订单信息添加</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
		</div>
		<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;" />
		<table class="table">
			<tr>
				<th>&nbsp;流水号：</th>
				<td><input id="serialnumber" name="serialnumber"
					value="${order.serialnumber}" /> &nbsp;<label for="serialnumber"
					style="color:red;">*</label></td>
				<th>&nbsp;付款时间：</th>
				<td><input id="paytime" name="paytime" value="${order.paytime}" />
					&nbsp;<label for="paytime" style="color:red;">*</label></td>
			</tr>
			<tr>
				<th>&nbsp;logistics：</th>
				<td><input id="logistics" name="logistics"
					value="${order.logistics}" /> &nbsp;<label for="logistics"
					style="color:red;">*</label></td>
				<th>&nbsp;状态：</th>
				<td><input id="status" name="status" value="${order.status}" />
					&nbsp;<label for="status" style="color:red;">*</label></td>
			</tr>
			<tr>
				<th>&nbsp;标题：</th>
				<td><input id="title" name="title" value="${order.title}" />
					&nbsp;<label for="title" style="color:red;">*</label></td>
				<th>&nbsp;数量：</th>
				<td><input id="counts" name="counts" value="${order.counts}" />
					&nbsp;<label for="counts" style="color:red;">*</label></td>
			</tr>
			<tr>
				<th>&nbsp;单价：</th>
				<td><input id="price" name="price" value="${order.price}" />
					&nbsp;<label for="price" style="color:red;">*</label></td>
				<th>&nbsp;总额：</th>
				<td><input id="amount" name="amount" value="${order.amount}" />
					&nbsp;<label for="amount" style="color:red;">*</label></td>
			</tr>
			<tr>
				<th>&nbsp;实付总额：</th>
				<td><input id="realAmount" name="realAmount"
					value="${order.realAmount}" /> &nbsp;<label for="realAmount"
					style="color:red;">*</label></td>
				<th>&nbsp;减少金额：</th>
				<td><input id="disAmount" name="disAmount"
					value="${order.disAmount}" /> &nbsp;<label for="disAmount"
					style="color:red;">*</label></td>
			</tr>
			<tr>
				<th>&nbsp;邮费：</th>
				<td><input id="postage" name="postage" value="${order.postage}" />
					&nbsp;<label for="postage" style="color:red;">*</label></td>
				<th>&nbsp;是否有邮费：</th>
				<td><input id="hasPostage" name="hasPostage"
					value="${order.hasPostage}" /> &nbsp;<label for="hasPostage"
					style="color:red;">*</label></td>
			</tr>
			<tr>
				<th>&nbsp;买家Ip：</th>
				<td><input id="buyerIp" name="buyerIp" value="${order.buyerIp}" />
					&nbsp;<label for="buyerIp" style="color:red;">*</label></td>
				<th>&nbsp;买家地址：</th>
				<td><input id="buyerAddr" name="buyerAddr"
					value="${order.buyerAddr}" /> &nbsp;<label for="buyerAddr"
					style="color:red;">*</label></td>
			</tr>
			<tr>
				<th style="width: 150px;">&nbsp;</th>
				<td style="text-align: left;" colspan="6"><input type="submit"
					value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input
					type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input
					type="button" value="返回"
					onclick="javascript:window.location.href='${ctxAdmin}/order'" /></td>
			</tr>
		</table>
	</form>
</body>
</html>