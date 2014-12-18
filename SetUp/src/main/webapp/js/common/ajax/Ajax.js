/**
 * DWR��ܵ�AJAX�����࣬Ϊ���ں�ԭ����BUFFALO
 * zhou.jundi
 * @param async
 * @returns
 */
var Ajax = function(async) {
	if (typeof (async) == "undefined")
		async = true;
	this.async = async;
};

Ajax.prototype = {
	async : null,
	callback : null,
	stackMessage : null,
	msg : null,
	showStackDialog:function(msg, stackMessage){
		if($('#errorWindow')[0]==null){
			var errorWindow = "<div id='errorWindow' iconCls='icon-error' style='width:700px;height:400px;' title='��ջ��Ϣ'><textarea id='errorWindowMsg' style='width:99%;height:98%;' >"+stackMessage+"</textarea></div>"
			$(errorWindow).appendTo("body");
		}else{
			$('#errorWindowMsg').val(stackMessage);
		}
		
		$('#errorWindow').dialog({
			modal : true,
			buttons : [{
				text : 'ȷ��',
				iconCls : 'icon-ok',
				handler : function() {
					$('#errorWindow').dialog('close');
				}
			} ]
		});
	},
	showMsg:function(options,param){

        var site = $.extend( {
            left : "",
            top : "",
            right : 0,
            bottom : -document.body.scrollTop
                    - document.documentElement.scrollTop
        }, param || {});
        var win = $("body > div .messager-body");
        if(win.length<=0)
        	 $.messager.show(options);
        win = $("body > div .messager-body");
        win.window("window").css( {
            left : site.left,
            top : site.top,
            right : site.right,
            zIndex : $.fn.window.defaults.zIndex++,
            bottom : site.bottom
        });
	},
	exceptionHandler : function(msg, exc){
		//if(exc.excType=='ERROR'){
		//	showStackDialog(msg, exc.stackMessage);
		//}else if(exc.excType=='INFO'){
			//Ajax.getAsy().showStackDialog('"+msg+"', '"+exc+"')
			//alert(msg+"<span onclick=\"Ajax.getAsy().showStackDialog('"+msg+"', '"+exc.stackMessage+"')\" ><img  src='../../base/images/more.jpg' style='vertical-align:middle;cursor: hand;' name='moreImg'></span>");
			var random = 'moreImg'+Math.round(Math.random()*10000);
		    var path = "";
		    var width = 350;
		    var height = 200;
		    var left = document.body.clientWidth-350;
		    var top = document.body.clientHeight-360;
		    var param={left:left>0?left:350,top:top>0?top:360,right:0,bottom:""};
		    /**
		    if(js_path_prefix || typeof js_path_prefix != "undefined"){
		    	path ="/";
		    }else{
		    	path ="../..";
		    }  */
		    path ="/";
		    var more_img = "<img id='"+random+"' src='"+path+"/base/images/more.jpg' style='vertical-align:middle;cursor:hand;'/>";
		    if("INFO" == exc.excType){
		    	more_img = "";
		    }
			var options ={title:'��ʾ��Ϣ',msg:(msg.length>500?(msg.substring(0,500)+"..."):msg) + more_img,
				  showType:'show',width:width,height:height};
			Ajax.getAsy().showMsg(options,param);
			$('#'+random).bind("click",function(){
				var moreMsg = "";
				if(exc && exc.stackMessage && typeof exc.stackMessage != "undefined"){
					moreMsg = exc.stackMessage;
				}else{
					moreMsg =msg;
				}
				Ajax.getAsy().showStackDialog(msg,moreMsg);
			});
			
			if( $.unCover ){
				$.unCover();
			}
			
		//}
	},
	_remoteCall : function(serviceName, methodName, params, callBackFun,
			exceptionHandlerFun) {
		var asyncFlag = this.async;
		if(exceptionHandlerFun==null){
			exceptionHandlerFun = this.exceptionHandler;
		}
		params[params.length] = {
			callback : function(data) {
				if(callBackFun!=null){
					// ���ط���,Ϊ���Ǹ�ӱ���ԭ��BUFFALO�Ľṹ
					var result = {};
					result.data = data;
					result.getResult = function() {
						return this.data;
					}
					callBackFun(result);
				}
			},
			exceptionHandler : exceptionHandlerFun,
			async : asyncFlag
		}
	    //alert("serviceName = " + serviceName + " methodName = " + methodName);
		dwr.engine._execute(dwr.engine._pathToDwrServlet, serviceName,
				methodName, params);

	}
}

Ajax.prototype.remoteCall = function(serviceName, methodName, params, callBack,
		exceptionHandler) {
	return Ajax.__remoteCall(this, serviceName, methodName, params, callBack,
			exceptionHandler);
}
Ajax.__remoteCall = function(ajax, serviceName, methodName, params, callBack,
		exceptionHandler) {
	return ajax._remoteCall(serviceName, methodName, params, callBack,
			exceptionHandler);
}

//�첽
Ajax.getAsy = function() {
	return new Ajax(true);
}

//ͬ��
Ajax.getSy = function() {
	return new Ajax(false);
}
