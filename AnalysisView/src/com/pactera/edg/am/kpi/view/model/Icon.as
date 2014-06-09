package com.pactera.edg.am.kpi.view.model
{
    import com.pactera.edg.am.kpi.rightClick.*;
    import flash.display.*;
    import flash.events.*;
    import flash.geom.*;
    import mx.controls.*;
    import mx.core.*;

    public class Icon extends DisplayElement
    {
        private static const defaultIcon:Class = Icon_defaultIcon;

        public function Icon()
        {
            return;
        }// end function

        override public function getTopPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = 15 / 2;
            var _loc_4:* = 0;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            this.graphics.clear();
            this.iconRender();
            this._rectOne.addEventListener(MouseEvent.CLICK, this.iconClickHandler, false);
            this.addEventListener(FocusEvent.FOCUS_OUT, this.focusEventOutHandler, false);
            this._rectOne.addEventListener(MouseEvent.MOUSE_OUT, this.mouseOutHandler, false);
            this._rectOne.addEventListener(MouseEvent.MOUSE_OVER, this.mouseOverHandler, false);
            this._rectOne.addEventListener(MouseEvent.MOUSE_MOVE, this.mouseMoveHandler, false);
            this._rectOne.addEventListener(MouseEvent.MOUSE_DOWN, this.mouseDownHandler, false);
            this.container.setActualSize(this._iconObject.width, this._iconObject.height);
            this.setChildIndex(this._iconObject, 0);
            this.invalidateDisplayList();
            this.invalidateSize();
            return;
        }// end function

        override public function getRightPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = 15;
            var _loc_4:* = 15 / 2;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override public function getLeftPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = 0;
            var _loc_4:* = 15 / 2;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override protected function createChildren() : void
        {
            super.createChildren();
            this._iconObject = new Image();
            this._iconObject.width = 15;
            this._iconObject.height = 15;
            this._iconObject.load(this.icon);
            this.addChild(this._iconObject);
            this._title = createTextField();
            this._title.text = "";
            this._title.height = 0;
            this._title.width = 0;
            if (this.menubarXML != null)
            {
                RightClickHandles.getInstance().setHandleFunction(this._rectOne, this, this.menubarXML);
            }
            this._rectOne.addChild(DisplayObject(this._title));
            this._container.setActualSize(this._iconObject.width, this._iconObject.height);
            this.setActualSize(Math.max(this._container.width, this._title.textWidth + this._iconObject.width + 20, this._title.textHeight), this._container.height + this._title.height);
            this.invalidateSize();
            this.invalidateDisplayList();
            return;
        }// end function

        override protected function measure() : void
        {
            super.measure();
			//zzg 20130528
            this.measuredWidth = this._iconObject.width;
            this.measuredHeight = this._iconObject.height;
            return;
        }// end function

        override public function getBottomPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = 15 / 2;
            var _loc_4:* = 15;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

    }
}
