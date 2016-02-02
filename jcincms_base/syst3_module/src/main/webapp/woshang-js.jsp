<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				jQuery.jqtab = function(tabtit, tab_conbox, shijian) {
					$(tab_conbox).find("li").hide();
					$(tabtit).find("li:first").addClass("thistab").show();
					$(tab_conbox).find("li:first").show();

					$(tabtit).find("li").bind(
							shijian,
							function() {
								$(this).addClass("thistab").siblings("li")
										.removeClass("thistab");
								var activeindex = $(tabtit).find("li").index(
										this);
								$(tab_conbox).children().eq(activeindex).show()
										.siblings().hide();
								return false;
							});

				};
				/*调用方法如下：*/
				/* $.jqtab("#tabs", "#tab_conbox", "click"); */
				$.jqtab("#tabs", "#tab_conbox", "mouseenter");

				/* $.jqtab("#tabs2", "#tab_conbox2", "mouseenter"); */

			});
</script>