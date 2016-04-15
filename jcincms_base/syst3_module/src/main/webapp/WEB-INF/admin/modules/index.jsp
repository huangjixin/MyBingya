<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>系统首页</title>
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/demo/demo.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/jquery-easyui/themes/icon.css" />
<link href="${ctxAdmin}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${ctx}/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
</script>
<script type="text/javascript">
	$().ready(function() {
		//顶部导航切换
		$(".nav li a").click(function(){
			$(".nav li a.selected").removeClass("selected")
			$(this).addClass("selected");
		})
		
		$('.title').click(function(){
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if($ul.is(':visible')){
				$(this).next('ul').slideUp();
			}else{
				$(this).next('ul').slideDown();
			}
		});
		
		$('#tgrid').treegrid({
			onClickRow : function(row) {
				doLink(row.text,row.path);
			},
			onLoadSuccess:function (row, data){
				$('#tgrid').treegrid('collapseAll');
			}
		});
	});
	
	//打开连接。
	function doLink(title,url) {
		if (url == null||url=="") {
			return;
		}
// 		$("#ifrContentArea").attr("src",'${ctxAdmin}/'+url);
		addTab(title, url);
	}
	
	function showUser(){
// 		$("#ifrContentArea").attr("src",'${ctxAdmin}/user/show/'+$('#userId').val());
	}
	
	function changePassword(){
// 		$("#ifrContentArea").attr("src",'${ctxAdmin}/user/changePassword');
	}
	
	function addTab(title, url){  
		    var tt = $('#tabs');  
		    if (tt.tabs('exists', title)){//如果tab已经存在,则选中并刷新该tab          
		        tt.tabs('select', title);  
// 		        refreshTab({tabTitle:title,url:url});  
		    } else {  
		        if (url){  
					if(url=='http://tongji.baidu.com'){
						window.open("http://tongji.baidu.com");  				
					}else{
						var content = '<iframe id="ifrContentArea" frameborder="0" name="main" style="width:100%;height:99%;" border="0"  scrolling="auto" src="${ctxAdmin}/'+url+'"></iframe>';  
					}
		            
		        } else {  
		            var content = '未实现';  
		        }  
		        tt.tabs('add',{  
		            title:title,  
		            closable:true,  
		            content:content
		        });  
		    }  
		}  
		/**     
		 * 刷新tab 
		 * @cfg  
		 *example: {tabTitle:'tabTitle',url:'refreshUrl'} 
		 *如果tabTitle为空，则默认刷新当前选中的tab 
		 *如果url为空，则默认以原来的url进行reload 
		 */  
		function refreshTab(cfg){  
		    var refresh_tab = cfg.tabTitle?$('#tabs').tabs('getTab',cfg.tabTitle):$('#tabs').tabs('getSelected');  
		    if(refresh_tab && refresh_tab.find('iframe').length > 0){  
		    var _refresh_ifram = refresh_tab.find('iframe')[0];  
		    var refresh_url = cfg.url?cfg.url:_refresh_ifram.src;  
		    //_refresh_ifram.src = refresh_url;  
		    _refresh_ifram.contentWindow.location.href=refresh_url;  
		    }  
		}
</script>
<style type="text/css">
html,body {
	margin: 0;
	padding: 0;
	border: 0;
	width: 100%;
	height: 100%;
	overflow: hidden;
}

.logo {
	font-family: "微软雅黑", "Helvetica Neue", ​Helvetica, ​Arial, ​sans-serif;
	font-size: 28px;
	font-weight: bold;
	color: #444;
	cursor: default;
	position: absolute;
	top: 28px;
	left: 15px;
	line-height: 28px;
}

.topNav {
	position: absolute;
	right: 8px;
	bottom: 10px;
	font-size: 12px;
	line-height: 25px;
}

.topNav a {
	text-decoration: none;
	color: #222;
	font-weight: normal;
	font-size: 12px;
	line-height: 25px;
	margin-left: 3px;
	margin-right: 3px;
}

.topNav a:hover {
	text-decoration: underline;
	color: Blue;
}

.mini-layout-region-south img {
	vertical-align: top;
}
</style>
</head>
<body>
	<input type="hidden" id="userId" value="${fns:getUserId()}" />
	<div class="easyui-layout" fit="true">
		<div data-options="region:'north',split:false"
			style="overflow:hidden;height:90px;background:url(${ctxAdmin}/images/topbg.gif) repeat-x;)">
			<div class="topleft">
				<a href="${ctxAdmin}/"><img src="${ctxAdmin}/images/logo.png"
					title="系统首页" /></a>
			</div>
			<ul class="nav">
				<li><a href="#" class="selected"><img
						src="${ctxAdmin}/images/icon01.png" title="工作台" />
						<h2>工作台</h2></a></li>
				<li><a href="#"><img
						src="${ctxAdmin}/images/icon02.png" title="模型管理" />
						<h2>模型管理</h2></a></li>
				<li><a href="#"><img
						src="${ctxAdmin}/images/icon03.png" title="模块设计" />
						<h2>模块设计</h2></a></li>
				<li><a href="#"><img
						src="${ctxAdmin}/images/icon04.png" title="常用工具" />
						<h2>常用工具</h2></a></li>
				<li><a href="#"><img
						src="${ctxAdmin}/images/icon05.png" title="文件管理" />
						<h2>文件管理</h2></a></li>
				<li><a href="#"><img
						src="${ctxAdmin}/images/icon06.png" title="系统设置" />
						<h2>系统设置</h2></a></li>
			</ul>
			<div class="topright">
				<ul>
					<li><span><img src="${ctxAdmin}/images/help.png"
							title="帮助" class="helpimg" /></span><a href="#">帮助</a></li>
					<li><a href="#">关于</a></li>
					<li><a href="${ctxAdmin}/logout">退出</a></li>
				</ul>
				<c:set var="user" value="${fns:getUser()}"></c:set>
				<div class="user">
					<span>${user.username}</span> <i>消息</i> <b>5</b>
				</div>
			</div>
			<%-- <div class="logo">J2EE应用开发平台</div>
			<c:set var="user" value="${fns:getUser()}"></c:set>
			<div class="topNav">
				欢迎<a onclick="showUser();"><b style="color: red;">${user.username}</b></a>，上次登录是：<b style="color: red;"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${user.lastLogin}" /></b> &nbsp;&nbsp;<a  onclick="changePassword();">密码修改</a>&nbsp;&nbsp;<a href="../index.html">首页</a> | <a href="../demo/index.html">在线示例</a>
				| <a href="../docs/api/index.html">Api手册</a> | <a
					href="../index.html#tutorial">开发教程</a> | <a
					href="${ctxAdmin}/logout">退出</a>
			</div> --%>
		</div>

		<div data-options="region:'west',split:false" title=""
			style="background:#f0f9fd;overflow: hidden;width: 187px;">
			<jsp:include page="left.jsp" flush="true"></jsp:include>
			<%-- <table id="tgrid" title="" class="easyui-treegrid" style=""
				data-options="
								url: '${ctxAdmin}/resource/getMenu',
								method: 'get',
								lines: true,
								rownumbers: false,
								idField: 'id',
								treeField: 'name',
								showHeader: false,
								fit:true,
								fitColumns:true
							">
				<thead>
					<tr>
						<th id="nameFieldTh" data-options="field:'name'" width="100%">Name</th>
					</tr>
				</thead>
			</table> --%>
		</div>
		<div data-options="region:'center',title:''">
			<div class="easyui-tabs" fit="true" border="false" id="tabs">
				<div title="首页">
					<iframe id="ifrContentArea" frameborder="0" name="main"
						style="width:100%;height:99%;" border="0" scrolling="auto"
						src="${ctxAdmin}/system"></iframe>
				</div>
			</div>
		</div>
		<!-- <div data-options="region:'south'"
			style="text-align:center;height:25px;padding-top: 2px;">
			Copyright © 黄记新软件有限公司版权所有</div> -->
	</div>
</body>
</html>