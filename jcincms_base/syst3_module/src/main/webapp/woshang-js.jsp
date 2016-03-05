<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript">
	if(window.location.toString().indexOf('pref=padindex') != -1){
	}else{
		if(/AppleWebKit.*Mobile/i.test(navigator.userAgent) || (/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/.test(navigator.userAgent))){  
	      if(window.location.href.indexOf("?mobile")<0){
			try{
				if(/Android|Windows Phone|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)){
// 					window.location.href="${ctx}/m-index"
					/* <c:choose>
						<c:when test="${document!=null}">
							window.location.href="${ctx}/${channel.linkAddr}/docs/${document.id}m.html";
						</c:when>
						<c:when test="${channel!=null}">
						window.location.href="${ctx}/${channel.linkAddr}/docs/${channel.code}1m.html";
						</c:when>
						<c:otherwise>
						window.location.href="${ctx}/m-index.html";
						</c:otherwise>
					</c:choose> */
				}
			}catch(e){}
		  }
		}
	}
	
	window.onload = function() {
		//menuFixed('menuContainer');
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
	
	function include(url)
	{
		$.get(url,function(data){document.write(data);})
	}
</script>
