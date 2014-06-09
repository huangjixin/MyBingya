package com.pactera.edg.am.kpi.view.model
{
    import com.pactera.edg.am.kpi.rightClick.*;
    import com.pactera.edg.am.kpi.view.*;
    import com.pactera.edg.am.kpi.view.model.chart.*;
    import flash.display.*;
    import flash.events.*;
    import flash.geom.*;
    import flash.utils.*;
    import mx.controls.*;
    import mx.core.*;

    public class ChartModel extends DisplayElement
    {
        private static const defaultIcon:Class = ChartModel_defaultIcon;

        public function ChartModel()
        {
            return;
        }// end function

        override public function getTopPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = 200 / 2;
            var _loc_4:* = 0;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            this.graphics.clear();
            this.chartRender();
            this._rectOne.addEventListener(MouseEvent.MOUSE_OUT, this.mouseOutHandler, false);
            this._rectOne.addEventListener(MouseEvent.MOUSE_OVER, this.mouseOverHandler, false);
            this._rectOne.addEventListener(MouseEvent.MOUSE_MOVE, this.mouseMoveHandler, false);
            this._rectOne.addEventListener(MouseEvent.MOUSE_DOWN, this.mouseDownHandler, false);
            this.container.setActualSize(200, 700);
            this.invalidateDisplayList();
            this.invalidateSize();
            return;
        }// end function

        override public function getRightPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = 200;
            var _loc_4:* = 200 / 2;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override public function getLeftPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = 0;
            var _loc_4:* = 200 / 2;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override protected function createChildren() : void
        {
            super.createChildren();
            var _loc_1:* = new Register();
            this._iconObject = new Image();
            this._iconObject.width = 100;
            this._iconObject.height = 100;
            this._iconObject.load(this.icon);
            this.defaultModelWidth = 200;
            this.defaultModelHeight = 200;
            var _loc_2:* = getDefinitionByName("com.pactera.edg.am.kpi.view.model.chart." + this.chartClass) as Class;
            var _loc_3:* = new _loc_2;
            _loc_3.buildXml(this.chartXML);
            _loc_3.init();
            this.addChild(_loc_3.chartPanel);
            this._title = createTextField();
            this._title.text = "统计图";
            this._title.height = 0;
            this._title.width = 0;
            if (this.menubarXML != null)
            {
                RightClickHandles.getInstance().setHandleFunction(this._rectOne, this, this.menubarXML);
            }
            this._rectOne.addChild(DisplayObject(this._title));
            this.setActualSize(200, 700);
            return;
        }// end function

        override protected function measure() : void
        {
            super.measure();
            this.measuredWidth = 200;
            this.measuredHeight = 200;
            return;
        }// end function

        override public function getBottomPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = 200 / 2;
            var _loc_4:* = 200;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

    }
}
