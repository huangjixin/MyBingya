package com.pactera.edg.am.kpi.preload
{
    import com.pactera.edg.am.kpi.system.*;
    import flash.display.*;
    import flash.events.*;
    import flash.text.*;
    import mx.events.*;
    import mx.preloaders.*;

    public class LongTopPreloader extends DownloadProgressBar
    {
        public var msg:TextField;
        private var _preloader:Sprite;

        public function LongTopPreloader()
        {
            msg = new TextField();
            msg.x = 200;
            msg.y = 200;
            addChild(msg);
            return;
        }// end function

        private function preloader_initProgressHandler(event:Event) : void
        {
            event.stopImmediatePropagation();
            _preloader.removeEventListener(FlexEvent.INIT_PROGRESS, preloader_initProgressHandler);
            return;
        }// end function

        override protected function completeHandler(event:Event) : void
        {
            ApplicationConfig.getInstance().initData();
            ApplicationConfig.getInstance().addEventListener(ApplicationConfig.Init_Complete, configInitHandler);
            return;
        }// end function

        override protected function rslProgressHandler(event:RSLEvent) : void
        {
            msg.text = "第一次运行,初始化...";
            return;
        }// end function

        override public function set preloader(param1:Sprite) : void
        {
            param1.addEventListener(FlexEvent.INIT_PROGRESS, preloader_initProgressHandler, false, 10);
            super.preloader = param1;
            _preloader = param1;
            return;
        }// end function

        private function configInitHandler(event:Event) : void
        {
            _preloader.dispatchEvent(new FlexEvent(FlexEvent.INIT_PROGRESS));
            _preloader = null;
            return;
        }// end function

    }
}
