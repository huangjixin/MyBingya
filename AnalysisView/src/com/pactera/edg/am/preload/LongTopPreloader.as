package com.pactera.edg.am.preload
{
    import com.pactera.edg.am.system.*;
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
			trace("LongTopPreloader create .....");
            this.msg = new TextField();
            this.msg.x = 200;
            this.msg.y = 200;
            addChild(this.msg);
			trace("LongTopPreloader create ok");
            return;
        }// end function

        private function preloader_initProgressHandler(event:Event) : void
        {
            event.stopImmediatePropagation();
            this._preloader.removeEventListener(FlexEvent.INIT_PROGRESS, this.preloader_initProgressHandler);
            return;
        }// end function

        override protected function completeHandler(event:Event) : void
        {
            ApplicationConfig.getInstance().initData();
            ApplicationConfig.getInstance().addEventListener(ApplicationConfig.Init_Complete, this.configInitHandler);
            return;
        }// end function

        override protected function rslProgressHandler(event:RSLEvent) : void
        {
            this.msg.text = "第一次运行,初始化...";
            return;
        }// end function

        override public function set preloader(param1:Sprite) : void
        {
            param1.addEventListener(FlexEvent.INIT_PROGRESS, this.preloader_initProgressHandler, false, 10);
            super.preloader = param1;
            this._preloader = param1;
            return;
        }// end function

        private function configInitHandler(event:Event) : void
        {
            this._preloader.dispatchEvent(new FlexEvent(FlexEvent.INIT_PROGRESS));
            this._preloader = null;
            return;
        }// end function

    }
}
