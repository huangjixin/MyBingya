<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript">
	if(window.location.toString().indexOf('pref=padindex') != -1){
	}else{
		if(/AppleWebKit.*Mobile/i.test(navigator.userAgent) || (/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/.test(navigator.userAgent))){  
	      if(window.location.href.indexOf("?mobile")<0){
			try{
				if(/Android|Windows Phone|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)){
					window.location.href="${ctx}/m-index.html";
				}/*else if(/iPad/i.test(navigator.userAgent)){
	              	window.location.href="http://www.qq.com/pad/"
				}else{
					window.location.href="http://xw.qq.com/simple/s/index/"
				}*/
			}catch(e){}
		  }
		}
	}

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
	function changePos(id,height){
	    var obj = document.getElementById(id);
	    var scrollTop = document.body.scrollTop;
	    if(scrollTop < height){
	        obj.style.position = 'relative';
	        obj.style.display = 'block';
	    }else{
	        obj.style.position = 'fixed';
	        obj.style.top = 0;
	    }
	}
</script>