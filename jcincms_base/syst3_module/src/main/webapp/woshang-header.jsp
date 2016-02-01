<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div id="header" class="globalWidth">
	<div id="header-top">
		<div class="contentWidth">
			<div class="left">
				&nbsp; <span>电话：139 2620 5227</span>&nbsp;&nbsp;|&nbsp; <span>邮箱：635152644@qq.com</span>&nbsp;&nbsp;|&nbsp;
				<span>QQ群：40497044</span>
			</div>
			<div class="right">
				<a onclick="SetHome(window.location)" href="javascript:void(0)">设为首页</a>
				| <a onclick="AddFavorite(window.location,document.title)"
					href="javascript:void(0)">加入收藏</a>        
			</div>
		</div>
	</div>
	<div id="logo" class="contentWidth">
		<div class="left">
			<div style="float: left;">
				<a href="${ctx}/"><span></span><img alt="智沃科技"
					src="${ctx}/images/logo.png"></a>
			</div>
			<div style="float: left;">
				<div style="height: 5px;"></div>
				<i></i><span>致力华南品牌崛起[专注-用心-热情]</span>
			</div>
		</div>
	</div>
</div>
