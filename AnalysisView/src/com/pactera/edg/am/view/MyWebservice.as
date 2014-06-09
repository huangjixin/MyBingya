package com.pactera.edg.am.view
{
    import mx.controls.*;
    import mx.rpc.events.*;
    import mx.rpc.soap.mxml.*;

    public class MyWebservice extends Object
    {
        private var webSrv:WebService;
        public var onCompleteResult:Function;

        public function MyWebservice(param1:String)
        {
            this.webSrv = new WebService();
            this.webSrv.wsdl = param1;
            this.webSrv.useProxy = false;
            this.webSrv.loadWSDL();
            return;
        }// end function

        public function send(param1:String, param2:Object = null) : void
        {
			var   arguments : mx.rpc.soap.mxml.Operation;
			arguments = this.webSrv.getOperation(param1) as mx.rpc.soap.mxml.Operation;
            arguments.arguments = param2;
            arguments.send();
            arguments.addEventListener(FaultEvent.FAULT, this.onfault);
            arguments.addEventListener(ResultEvent.RESULT, this.handleResult);
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
            if (this.onCompleteResult != null)
            {
                this.onCompleteResult(_loc_2);
            }
            return;
        }// end function

    }
}
