package com.pactera.edg.am.view.model
{
    import flash.geom.*;
    import mx.controls.*;
    import mx.core.*;

    public class Icon extends DisplayElement
    {

        public function Icon()
        {
            return;
        }// end function

        override public function getTopPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = 15 / 2;
            var _loc_4:Number = 0;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            this.graphics.clear();
            this.container.setActualSize(this._iconObject.width, this._iconObject.height);
            this.setChildIndex(this._iconObject, 0);
            this.invalidateDisplayList();
            this.invalidateSize();
            return;
        }// end function

        override public function getRightPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:Number = 15;
            var _loc_4:* = 15 / 2;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override public function getLeftPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:Number = 0;
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
            this._container.setActualSize(this._iconObject.width, this._iconObject.height);
            this.setActualSize(Math.max(this._container.width, this._title.textWidth + this._iconObject.width + 20, this._title.textHeight), this._container.height + this._title.height);
            this.invalidateSize();
            this.invalidateDisplayList();
            return;
        }// end function

        override protected function measure() : void
        {
            super.measure();
            this.measuredWidth = this._iconObject.width;
            this.measuredHeight = this._iconObject.height;
            return;
        }// end function

        override public function getBottomPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = 15 / 2;
            var _loc_4:Number = 15;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

    }
}
