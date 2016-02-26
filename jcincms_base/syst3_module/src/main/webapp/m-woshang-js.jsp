<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	});
	
	function showhide(id) {
		var sbtitle = document.getElementById(id);
		if (sbtitle) {
			if (sbtitle.style.display == 'block') {
				sbtitle.style.display = 'none';
			} else {
				sbtitle.style.display = 'block';
			}
		}
	}
</script>
