package com.pactera.edg.am.kpi.system
{
    import com.pactera.edg.am.kpi.factory.*;
    import flash.events.*;
    import flash.net.*;
    import flash.system.*;

    public class ApplicationConfig extends Object implements IEventDispatcher
    {
        private var _modelFactory:ModelFactory;
        private var loader:URLLoader;
        protected var dispatcher:EventDispatcher;
        private static var config:ApplicationConfig = null;
		//zzg 20130528 调整路径
        private static const modelUrl:String = "modelMapping.xml";
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
            return dispatcher.willTrigger(param1);
        }// end function

        public function dispatchEvent(event:Event) : Boolean
        {
            return dispatcher.dispatchEvent(event);
        }// end function

        public function removeEventListener(param1:String, param2:Function, param3:Boolean = false) : void
        {
            dispatcher.removeEventListener(param1, param2, param3);
            return;
        }// end function

        public function addEventListener(param1:String, param2:Function, param3:Boolean = false, param4:int = 0, param5:Boolean = true) : void
        {
            dispatcher.addEventListener(param1, param2, param3, param4, param5);
            return;
        }// end function

        private function httpStatusHandler(event:Event) : void
        {
            trace("httpStatusHandler: " + event);
            return;
        }// end function

        private function completeHandler(event:Event) : void
        {
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
            this.loader = new URLLoader();
            configureListeners(loader);
            var request:* = new URLRequest(modelUrl);
            var aPolce:* = new LoaderContext(true);
            try
            {
                loader.load(request);
            }
            catch (error:Error)
            {
                trace("Error loading requested document: " + modelUrl);
            }
            return;
        }// end function

        private function progressHandler(event:ProgressEvent) : void
        {
            trace("progressHandler loaded:" + event.bytesLoaded + " total: " + event.bytesTotal);
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
            trace("ioErrorHandler: " + event);
            return;
        }// end function

        private function configureListeners(param1:URLLoader) : void
        {
            param1.addEventListener(Event.COMPLETE, completeHandler);
            param1.addEventListener(Event.OPEN, openHandler);
            param1.addEventListener(ProgressEvent.PROGRESS, progressHandler);
            param1.addEventListener(SecurityErrorEvent.SECURITY_ERROR, securityErrorHandler);
            param1.addEventListener(HTTPStatusEvent.HTTP_STATUS, httpStatusHandler);
            param1.addEventListener(IOErrorEvent.IO_ERROR, ioErrorHandler);
            return;
        }// end function

        public function hasEventListener(param1:String) : Boolean
        {
            return dispatcher.hasEventListener(param1);
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
