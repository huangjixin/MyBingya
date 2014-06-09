package com.pactera.edg.am.dmv.view
{
    import mx.controls.*;
    import mx.rpc.events.*;
    import mx.rpc.soap.mxml.*;

    public class MyWebservice extends Object
    {
        private var webSrv:WebService;
        public var onCompleteResultObject:Function;
        public var onCompleteResult:Function;

	    /**
	     * @private
	     * @author zzg 
	     * @date 2011-12-21
	     * 自定义转义函数，兼容服务器端逻辑
	     * Default implementation of xmlSpecialCharsFilter. Escapes "&" 
	     */
	    private function escapeXML(value:Object):String
	    {
	        var str:String = value.toString();
	        //str = str.replace(/&/g, "&amp;").replace(/</g, "&lt;");
	        //测试发现&lt;的转义，导致后台解析错误，这里改进该函数，
	         str = str.replace(/&/g, "&amp;");
	        return str;
	    }
    
        public function MyWebservice(param1:String)
        {
            webSrv = new WebService();
            webSrv.wsdl = param1;
            //zzg 2011-12-21
            //增加定制的转义函数
            webSrv.xmlSpecialCharsFilter=escapeXML;
            webSrv.useProxy = false;
            webSrv.loadWSDL();
            return;
        }// end function

        private function onfault(event:FaultEvent) : void
        {
            Alert.show(event.toString());
            return;
        }// end function

        private function handleResult(event:ResultEvent) : void
        {
            var _loc_2:* = XML(event.result);
            if (onCompleteResult != null)
            {
                onCompleteResult(_loc_2);
            }
            else if (onCompleteResultObject != null)
            {
                onCompleteResultObject(event.result.toString());
            }
            return;
        }// end function

        public function send(param1:String, param2:Object = null) : void
        {
        		var   arguments : mx.rpc.soap.mxml.Operation;
            arguments = webSrv.getOperation(param1) as Operation;
            arguments.arguments = param2;
            
            arguments.send();
            arguments.addEventListener(FaultEvent.FAULT, onfault);
            arguments.addEventListener(ResultEvent.RESULT, handleResult);
            return;
        }// end function

    }
}
