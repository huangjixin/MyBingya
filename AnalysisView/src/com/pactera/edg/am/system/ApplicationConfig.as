package com.pactera.edg.am.system
{
    import com.pactera.edg.am.factory.*;
    import flash.events.*;
    import flash.net.*;
    import flash.system.*;
    import mx.controls.*;

    public class ApplicationConfig extends Object implements IEventDispatcher
    {
        private var _modelFactory:ModelFactory;
        private var loader:URLLoader;
        protected var dispatcher:EventDispatcher;
        private static var config:ApplicationConfig = null;
        private static const modelUrl:String = "../modelMapping.xml";
        public static const Init_Complete:String = "longtop_init_completed";

        public function ApplicationConfig()
        {
			trace("ApplicationConfig create...");
			//initData();
            this.dispatcher = new EventDispatcher(this);
            return;
        }// end function

        private function securityErrorHandler(event:SecurityErrorEvent) : void
        {
            trace("securityErrorHandler: " + event);
            return;
        }// end function

        public function willTrigger(param1:String) : Boolean
        {
            return this.dispatcher.willTrigger(param1);
        }// end function

        public function dispatchEvent(event:Event) : Boolean
        {
            return this.dispatcher.dispatchEvent(event);
        }// end function

        public function removeEventListener(param1:String, param2:Function, param3:Boolean = false) : void
        {
            this.dispatcher.removeEventListener(param1, param2, param3);
            return;
        }// end function

        public function addEventListener(param1:String, param2:Function, param3:Boolean = false, param4:int = 0, param5:Boolean = true) : void
        {
            this.dispatcher.addEventListener(param1, param2, param3, param4, param5);
            return;
        }// end function

        private function httpStatusHandler(event:Event) : void
        {
            trace("httpStatusHandler: " + event);
            return;
        }// end function

        private function completeHandler(event:Event) : void
        {
			trace("completeHandler ...");
            var _loc_2:* = URLLoader(event.target);
            var _loc_3:* = new XML(_loc_2.data);
            trace(_loc_2.data);
            this._modelFactory = new ModelFactory(_loc_3);
            this.dispatchEvent(new Event(Init_Complete));
            return;
        }// end function

        public function initData() : void
        {
			trace("initData");
            var request:* = new URLRequest(modelUrl);
            this.loader = new URLLoader();
            this.configureListeners(this.loader);
            var aPolce:* = new LoaderContext(true);
            try
            {
                this.loader.load(request);
            }
            catch (error:Error)
            {
                Alert.show("error");
                trace("Error loading requested document: " + modelUrl);
            }
            return;
        }// end function

        private function progressHandler(event:ProgressEvent) : void
        {
           // trace("progressHandler loaded:" + event.bytesLoaded + " total: " + event.bytesTotal);
            return;
        }// end function

        private function openHandler(event:Event) : void
        {
            trace("openHandler: " + event);
            return;
        }// end function

        public function get modelFactory() : ModelFactory
        {
            return this._modelFactory;
        }// end function

        private function ioErrorHandler(event:IOErrorEvent) : void
        {
            Alert.show("dd");
            trace("ioErrorHandler: " + event);
            return;
        }// end function

        private function configureListeners(param1:URLLoader) : void
        {
			trace("ApplicationConfig configureListeners...");
            param1.addEventListener(Event.COMPLETE, this.completeHandler);
            param1.addEventListener(Event.OPEN, this.openHandler);
            param1.addEventListener(ProgressEvent.PROGRESS, this.progressHandler);
            param1.addEventListener(SecurityErrorEvent.SECURITY_ERROR, this.securityErrorHandler);
            param1.addEventListener(HTTPStatusEvent.HTTP_STATUS, this.httpStatusHandler);
            param1.addEventListener(IOErrorEvent.IO_ERROR, this.ioErrorHandler);
            return;
        }// end function

        public function hasEventListener(param1:String) : Boolean
        {
            return this.dispatcher.hasEventListener(param1);
        }// end function

        public static function getInstance() : ApplicationConfig
        {
            if (config == null)
            {
                config = new ApplicationConfig;
            }
            return config;
        }// end function

    }
}
