<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/* jQuery.jqtab = function(tabtit, tab_conbox, shijian) {
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
		$.jqtab("#tabs", "#tab_conbox", "mouseenter"); */
		/*调用方法如下：*/
		/* $.jqtab("#tabs", "#tab_conbox", "click"); */
		/* $.jqtab("#tabs2", "#tab_conbox2", "mouseenter"); */
	});
	window.onload = function() {
		menuFixed('menuContainer');
	}
	
	function menuFixed(id){
	    var obj = document.getElementById(id);
	    var _getHeight = obj.offsetTop;
	    
	    window.onscroll = function(){
	        changePos(id,_getHeight);
	    }
	}
	var menuPosi='relative';
	function changePos(id,height){
	    var obj = document.getElementById(id);
	    var scrollTop = document.body.scrollTop;
	    
	    if(scrollTop < height){
	    	if(menuPosi != 'relative'){
	    		menuPosi = 'relative';
	    		obj.style.position = 'relative';
		        obj.style.display = 'block';
	    	}
	    }else{
	    	if(menuPosi == 'relative'){
	    		menuPosi = 'fixed';
	    		obj.style.position = 'fixed';
	 	        obj.style.top = 0;
	    	}
	    }
	}
</script>
