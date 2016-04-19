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

	function validateForm(){
		$("#validForm").validate({
			errorPlacement : function(error,element) {
				$(element).closest("form").find("label[for='"+ element.attr("id")+ "']").append(error);
			},errorElement : "span",
			rules : {
								id:{
					required : true
				},
				serialnumber:{
					required : true
				},
				ordercol:{
					required : true
				},
				createDate:{
					required : true
				},
				updateDate:{
					required : true
				},
				paytime:{
					required : true
				},
				logistics:{
					required : true
				},
				status:{
					required : true
				},
				title:{
					required : true
				},
				counts:{
					required : true
				},
				price:{
					required : true
				},
				amount:{
					required : true
				},
				realAmount:{
					required : true
				},
				disAmount:{
					required : true
				},
				postage:{
					required : true
				},
				hasPostage:{
					required : true
				},
				buyerIp:{
					required : true
				},
				buyerAddr:{
					required : true
				}
			},messages : {
				id:{
					required : "必填"
				},
				serialnumber:{
					required : "必填"
				},
				ordercol:{
					required : "必填"
				},
				createDate:{
					required : "必填"
				},
				updateDate:{
					required : "必填"
				},
				paytime:{
					required : "必填"
				},
				logistics:{
					required : "必填"
				},
				status:{
					required : "必填"
				},
				title:{
					required : "必填"
				},
				counts:{
					required : "必填"
				},
				price:{
					required : "必填"
				},
				amount:{
					required : "必填"
				},
				realAmount:{
					required : "必填"
				},
				disAmount:{
					required : "必填"
				},
				postage:{
					required : "必填"
				},
				hasPostage:{
					required : "必填"
				},
				buyerIp:{
					required : "必填"
				},
				buyerAddr:{
					required : "必填"
				}
			},
			submitHandler : function(form) {
					return true;
				}
			})
	}
	
	function clearForm(){
		$('#id').val("");
		$('#serialnumber').val("");
		$('#ordercol').val("");
		$('#createDate').val("");
		$('#updateDate').val("");
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
<title>order更新</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/order/update/${order.id}" method="post">
				<input name="id" value="${order.id}" type="hidden" />
				<div class="desc">
					<b>order信息更新</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table class="table">
					<tr>
						<th>&nbsp;id：</th>
						<td>
							<input id="id" name="id" 
								value="${order.id}"/>
									&nbsp;<label for="id" style="color:red;">*</label></td>
						<th>&nbsp;serialnumber：</th>
						<td>
							<input id="serialnumber" name="serialnumber" 
								value="${order.serialnumber}"/>
									&nbsp;<label for="serialnumber" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;ordercol：</th>
						<td>
							<input id="ordercol" name="ordercol" 
								value="${order.ordercol}"/>
									&nbsp;<label for="ordercol" style="color:red;">*</label></td>
						<th>&nbsp;createDate：</th>
						<td>
							<input id="createDate" name="createDate" 
								value="${order.createDate}"/>
									&nbsp;<label for="createDate" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;updateDate：</th>
						<td>
							<input id="updateDate" name="updateDate" 
								value="${order.updateDate}"/>
									&nbsp;<label for="updateDate" style="color:red;">*</label></td>
						<th>&nbsp;paytime：</th>
						<td>
							<input id="paytime" name="paytime" 
								value="${order.paytime}"/>
									&nbsp;<label for="paytime" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;logistics：</th>
						<td>
							<input id="logistics" name="logistics" 
								value="${order.logistics}"/>
									&nbsp;<label for="logistics" style="color:red;">*</label></td>
						<th>&nbsp;status：</th>
						<td>
							<input id="status" name="status" 
								value="${order.status}"/>
									&nbsp;<label for="status" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;title：</th>
						<td>
							<input id="title" name="title" 
								value="${order.title}"/>
									&nbsp;<label for="title" style="color:red;">*</label></td>
						<th>&nbsp;counts：</th>
						<td>
							<input id="counts" name="counts" 
								value="${order.counts}"/>
									&nbsp;<label for="counts" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;price：</th>
						<td>
							<input id="price" name="price" 
								value="${order.price}"/>
									&nbsp;<label for="price" style="color:red;">*</label></td>
						<th>&nbsp;amount：</th>
						<td>
							<input id="amount" name="amount" 
								value="${order.amount}"/>
									&nbsp;<label for="amount" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;realAmount：</th>
						<td>
							<input id="realAmount" name="realAmount" 
								value="${order.realAmount}"/>
									&nbsp;<label for="realAmount" style="color:red;">*</label></td>
						<th>&nbsp;disAmount：</th>
						<td>
							<input id="disAmount" name="disAmount" 
								value="${order.disAmount}"/>
									&nbsp;<label for="disAmount" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;postage：</th>
						<td>
							<input id="postage" name="postage" 
								value="${order.postage}"/>
									&nbsp;<label for="postage" style="color:red;">*</label></td>
						<th>&nbsp;hasPostage：</th>
						<td>
							<input id="hasPostage" name="hasPostage" 
								value="${order.hasPostage}"/>
									&nbsp;<label for="hasPostage" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th>&nbsp;buyerIp：</th>
						<td>
							<input id="buyerIp" name="buyerIp" 
								value="${order.buyerIp}"/>
									&nbsp;<label for="buyerIp" style="color:red;">*</label></td>
						<th>&nbsp;buyerAddr：</th>
						<td>
							<input id="buyerAddr" name="buyerAddr" 
								value="${order.buyerAddr}"/>
									&nbsp;<label for="buyerAddr" style="color:red;">*</label></td>
					</tr>
					<tr>
						<th style="width: 150px;">&nbsp;</th>
						<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/order'"/></td>
					</tr>
				</table>	
		</form>		
</body>
</html>