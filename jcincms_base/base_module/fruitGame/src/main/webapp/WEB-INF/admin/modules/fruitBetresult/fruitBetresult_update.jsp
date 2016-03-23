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
<title>fruitBetresult更新</title>
</head>
<body>
	<form id="validForm" action="${ctxAdmin}/fruitBetresult/update/${fruitBetresult.id}" method="post">
				<input name="id" value="${fruitBetresult.id}" type="hidden" />
				<div class="desc">
					<b>fruitBetresult信息更新</b>&nbsp;&nbsp;<b style="color: red;">${msg}</b>
				</div>
				<hr style="height:1px;border:none;border-top:1px solid #CCCCCC;"/>
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
						<td width="100%">
							<table border="0" cellpadding="3" cellspacing="1" width="100%"
								align="center" style="background-color: #b9d8f3;">
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;id：</th>
									<td nowrap="nowrap" align="left"><input id="id" name="id" value="${fruitBetresult.id}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;createDate：</th>
									<td nowrap="nowrap" align="left"><input id="createDate" name="createDate" value="${fruitBetresult.createDate}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;createBy：</th>
									<td nowrap="nowrap" align="left"><input id="createBy" name="createBy" value="${fruitBetresult.createBy}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;updateDate：</th>
									<td nowrap="nowrap" align="left"><input id="updateDate" name="updateDate" value="${fruitBetresult.updateDate}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;updateBy：</th>
									<td nowrap="nowrap" align="left"><input id="updateBy" name="updateBy" value="${fruitBetresult.updateBy}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;da：</th>
									<td nowrap="nowrap" align="left"><input id="da" name="da" value="${fruitBetresult.da}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;xiao：</th>
									<td nowrap="nowrap" align="left"><input id="xiao" name="xiao" value="${fruitBetresult.xiao}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;dan：</th>
									<td nowrap="nowrap" align="left"><input id="dan" name="dan" value="${fruitBetresult.dan}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;shuang：</th>
									<td nowrap="nowrap" align="left"><input id="shuang" name="shuang" value="${fruitBetresult.shuang}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;pingguo：</th>
									<td nowrap="nowrap" align="left"><input id="pingguo" name="pingguo" value="${fruitBetresult.pingguo}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;putao：</th>
									<td nowrap="nowrap" align="left"><input id="putao" name="putao" value="${fruitBetresult.putao}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;boluo：</th>
									<td nowrap="nowrap" align="left"><input id="boluo" name="boluo" value="${fruitBetresult.boluo}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;caomei：</th>
									<td nowrap="nowrap" align="left"><input id="caomei" name="caomei" value="${fruitBetresult.caomei}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;xigua：</th>
									<td nowrap="nowrap" align="left"><input id="xigua" name="xigua" value="${fruitBetresult.xigua}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;xiangjiao：</th>
									<td nowrap="nowrap" align="left"><input id="xiangjiao" name="xiangjiao" value="${fruitBetresult.xiangjiao}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th>&nbsp;description：</th>
									<td nowrap="nowrap" align="left"><input id="description" name="description" value="${fruitBetresult.description}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;username：</th>
									<td nowrap="nowrap" align="left"><input id="username" name="username" value="${fruitBetresult.username}"/>&nbsp;<span style="color: red;">*</span></td>
									<th>&nbsp;userId：</th>
									<td nowrap="nowrap" align="left"><input id="userId" name="userId" value="${fruitBetresult.userId}"/>&nbsp;<span style="color: red;">*</span></td>
								</tr>
								<tr style="text-align: right; BACKGROUND-COLOR: #F4FAFF; ">
									<th style="width: 150px;">&nbsp;</th>
									<td  style="text-align: left;" colspan="6"><input type="submit" value="保存" />&nbsp;&nbsp;<input type="reset" value="重置" />&nbsp;&nbsp;<input type="button" value="清空" onclick="clearForm();" />&nbsp;&nbsp;<input type="button" value="返回" onclick="javascript:window.location.href='${ctxAdmin}/fruitBetresult'"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>	
		</form>		
</body>
</html>