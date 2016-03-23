<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/admin/include/js.jsp"%>
<script type="text/javascript">
	$().ready(function() {
		
	});

	function clearForm(){
				$('#id').val("");
		$('#createDate').val("");
		$('#createBy').val("");
		$('#updateDate').val("");
		$('#updateBy').val("");
		$('#da').val("");
		$('#xiao').val("");
		$('#dan').val("");
		$('#shuang').val("");
		$('#pingguo').val("");
		$('#putao').val("");
		$('#boluo').val("");
		$('#caomei').val("");
		$('#xigua').val("");
		$('#xiangjiao').val("");
		$('#description').val("");
		$('#username').val("");
		$('#userId').val("");
	}
</script>
<title>fruitBetresultHistory添加</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/fruitBetresultHistory/create" method="post">
				<div class="desc">
					<b>fruitBetresultHistory信息添加</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;id：</th>
									<td nowrap="nowrap" align="left"><input id="id" name="id" value="${fruitBetresultHistory.id}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;createDate：</th>
									<td nowrap="nowrap" align="left"><input id="createDate" name="createDate" value="${fruitBetresultHistory.createDate}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;createBy：</th>
									<td nowrap="nowrap" align="left"><input id="createBy" name="createBy" value="${fruitBetresultHistory.createBy}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;updateDate：</th>
									<td nowrap="nowrap" align="left"><input id="updateDate" name="updateDate" value="${fruitBetresultHistory.updateDate}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;updateBy：</th>
									<td nowrap="nowrap" align="left"><input id="updateBy" name="updateBy" value="${fruitBetresultHistory.updateBy}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;da：</th>
									<td nowrap="nowrap" align="left"><input id="da" name="da" value="${fruitBetresultHistory.da}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;xiao：</th>
									<td nowrap="nowrap" align="left"><input id="xiao" name="xiao" value="${fruitBetresultHistory.xiao}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;dan：</th>
									<td nowrap="nowrap" align="left"><input id="dan" name="dan" value="${fruitBetresultHistory.dan}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;shuang：</th>
									<td nowrap="nowrap" align="left"><input id="shuang" name="shuang" value="${fruitBetresultHistory.shuang}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;pingguo：</th>
									<td nowrap="nowrap" align="left"><input id="pingguo" name="pingguo" value="${fruitBetresultHistory.pingguo}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;putao：</th>
									<td nowrap="nowrap" align="left"><input id="putao" name="putao" value="${fruitBetresultHistory.putao}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;boluo：</th>
									<td nowrap="nowrap" align="left"><input id="boluo" name="boluo" value="${fruitBetresultHistory.boluo}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;caomei：</th>
									<td nowrap="nowrap" align="left"><input id="caomei" name="caomei" value="${fruitBetresultHistory.caomei}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;xigua：</th>
									<td nowrap="nowrap" align="left"><input id="xigua" name="xigua" value="${fruitBetresultHistory.xigua}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;xiangjiao：</th>
									<td nowrap="nowrap" align="left"><input id="xiangjiao" name="xiangjiao" value="${fruitBetresultHistory.xiangjiao}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;description：</th>
									<td nowrap="nowrap" align="left"><input id="description" name="description" value="${fruitBetresultHistory.description}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;username：</th>
									<td nowrap="nowrap" align="left"><input id="username" name="username" value="${fruitBetresultHistory.username}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;userId：</th>
									<td nowrap="nowrap" align="left"><input id="userId" name="userId" value="${fruitBetresultHistory.userId}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/fruitBetresultHistory'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form>		
</body>
</html>