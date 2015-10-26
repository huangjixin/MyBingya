<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${document.title}</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript"
	src="${ctx}/js/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript">
	
	var pageCount = 1;//总页数
	var regExp = /_ueditor_page_break_tag_/;//根据某处字符来分页
	var saveContent;//用于保存分页数据
	var content, pageList;//保存全局ID

	//ID=需要分页的html
	//page=显示分页样式
	UeInitialize = function (id,page) {
	    content = $(id);
	    pageList = $(page);
	    if (content != null && regExp.test(content.html())) {
	        saveContent = content.html().split(regExp);
	        pageCount = saveContent.length;
	    }
	    window.UePageContent(1);
	};

	//显示分页的内容并自动生成页数
	UePageContent = function (pageIndex) {
	    if (pageIndex >= 1 && pageIndex <= pageCount && saveContent != null && saveContent.length >= 0) {
	        var pageHtml = pageList;
	        if ((parseInt(pageIndex) - 1) <= saveContent.length) {
	            content.html(saveContent[parseInt(pageIndex) - 1]);
	        }

	        pageHtml.html("");
	        var innHtml = "页数：" + pageIndex + "/" + pageCount;
	        innHtml += "<a target='_self' href='javascript:UePageContent(1)'>首页</a>";
	        if (pageIndex > 1) {
	            innHtml += "<a target='_self' href='javascript:UePageContent(" + (parseInt(pageIndex) - 1) + ")'> 上一页 </a>";
	        }
	        if (pageIndex < pageCount) {
	            innHtml += "<a target='_self' href='javascript:UePageContent(" + (parseInt(pageIndex) + 1) + ")'> 下一页 </a>";
	        }
	        innHtml += "<a target='_self' href='javascript:UePageContent(" + pageCount + ")'> 末页 </a>";
	        pageHtml.html(innHtml);
	    }
	}
	
	$().ready(function() {
// 		alert($('#content').html());
		UeInitialize('#content','#page');
	});
	</script>
	
  </head>
  
  <body>
  <div id="content" style="width:100%;text-align: center;">
  	${document.content}<br>
  </div>
  <div id="page"></div>
  </body>
</html>
