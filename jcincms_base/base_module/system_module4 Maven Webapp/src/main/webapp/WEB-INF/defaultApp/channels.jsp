<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="${channel.keyword}">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<title>${name}</title>
  </head>
  
  <body>
   	 栏目首页/${channel.name} <br>
    <c:forEach var="chan" items="${list}">
    	<a>${chan.name}</a><br>
    	<c:forEach var="doc" items="${fns:getDocByChannelId(chan.id)}">
    	<a href="${chan.linkAddr}/${doc.id}" target="_blank">${doc.title}</a><br>
    	</c:forEach>
    	<br>
    </c:forEach>
  </body>
</html>
