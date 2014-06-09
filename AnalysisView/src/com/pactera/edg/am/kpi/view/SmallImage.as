package com.pactera.edg.am.kpi.view
{
    import flash.display.*;
    import flash.events.*;
    import flash.geom.*;
    import mx.controls.*;
    import mx.core.*;
    import mx.events.*;
    import mx.graphics.*;
	//import com.pactera.edg.am.kpi.mapping.Image;

    public class SmallImage extends Image
    {
        private var rect:UIComponent;
        private var canClose:Boolean = true;
        private var _target:ModelView;
        private var drag:Boolean = false;

        public function SmallImage()
        {
            return;
        }// end function

        public function set target(param1:ModelView) : void
        {
            this._target = param1;
            this.paint();
            this.target.addEventListener(Event.SCROLL, targetScrollHandler);
            this.target.addEventListener(Event.RENDER, targetRenderHandler);
            this.targetRenderHandler();
            return;
        }// end function

        private function targetRenderHandler(event:Event = null) : void
        {
            var _loc_2:* = null;
            var _loc_3:* = null;
            var _loc_4:* = null;
            if (this.target.container.width == 0 || this.target.container.height == 0)
            {
                _loc_2 = new Bitmap();
            }
            else
            {
                _loc_3 = new Matrix();
                _loc_3.scale(this.width / this.target.container.width, this.height / this.target.container.height);
                _loc_4 = ImageSnapshot.captureBitmapData(this.target.container, _loc_3);
                _loc_2 = new Bitmap(_loc_4);
            }
            this.load(_loc_2);
            this.setChildIndex(this.rect, 1);
            return;
        }// end function

        private function targetScrollHandler(event:Event = null) : void
        {
            var _loc_2:* = 0;
            var _loc_3:* = 0;
            if (this.target.horizontalScrollBar)
            {
                _loc_2 = this.target.horizontalScrollPosition * (this.width - this.rect.width) / this.target.horizontalScrollBar.maxScrollPosition;
            }
            if (this.target.verticalScrollBar)
            {
                _loc_3 = this.target.verticalScrollPosition * (this.height - this.rect.height) / this.target.verticalScrollBar.maxScrollPosition;
            }
            this.rect.move(_loc_2, _loc_3);
            return;
        }// end function

        public function get target() : ModelView
        {
            return this._target;
        }// end function

        private function mouseDownHandler(event:MouseEvent) : void
        {
            var _loc_2:* = new Rectangle(0, 0, this.width - this.rect.width, this.height - this.rect.height);
            var _loc_3:* = systemManager.getSandboxRoot();
            _loc_3.addEventListener(MouseEvent.MOUSE_MOVE, mouseMoveHandler);
            _loc_3.addEventListener(MouseEvent.MOUSE_UP, mouseUpHandler);
            _loc_3.addEventListener(SandboxMouseEvent.MOUSE_UP_SOMEWHERE, mouseUpHandler);
            this.systemManager.deployMouseShields(true);
            this.rect.startDrag(false, _loc_2);
            return;
        }// end function

        private function mouseUpHandler(event:MouseEvent) : void
        {
            var _loc_2:* = systemManager.getSandboxRoot();
            _loc_2.removeEventListener(MouseEvent.MOUSE_MOVE, mouseMoveHandler);
            _loc_2.removeEventListener(MouseEvent.MOUSE_UP, mouseUpHandler);
            _loc_2.removeEventListener(SandboxMouseEvent.MOUSE_UP_SOMEWHERE, mouseUpHandler);
            this.systemManager.deployMouseShields(false);
            this.rect.stopDrag();
            return;
        }// end function

        private function mouseMoveHandler(event:MouseEvent) : void
        {
            if (this.target.verticalScrollBar)
            {
                this.target.verticalScrollPosition = this.target.verticalScrollBar.maxScrollPosition * this.rect.y / (this.height - this.rect.height);
            }
            if (this.target.horizontalScrollBar)
            {
                this.target.horizontalScrollPosition = this.target.horizontalScrollBar.maxScrollPosition * this.rect.x / (this.width - this.rect.width);
            }
            return;
        }// end function

        public function paint() : void
        {
            if (this.rect)
            {
                this.removeChild(this.rect);
            }
            this.rect = new UIComponent();
            this.rect.graphics.beginFill(0, 0);
            this.rect.graphics.lineStyle(1, 0);
            this.rect.graphics.drawRect(0, 0, this.width * this._target.width / this.target.screen.width, this.height * this._target.height / this.target.screen.height);
            this.rect.graphics.endFill();
            this.rect.width = this.width * this._target.width / this.target.screen.width;
            this.rect.height = this.height * this._target.height / this.target.screen.height;
            this.rect.addEventListener(MouseEvent.MOUSE_DOWN, mouseDownHandler);
            this.addChild(this.rect);
            return;
        }// end function

    }
}
