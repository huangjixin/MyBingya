package com.pactera.edg.am.dmv.view.line
{
    import com.pactera.edg.am.dmv.view.line.*;
    import com.pactera.edg.am.dmv.view.model.*;
    import flash.display.*;
    import flash.events.*;
    import flash.external.*;
    import flash.geom.*;
    import flash.utils.*;
    import mx.core.*;

    public class Line extends UIComponent implements ILine
    {
        private var cricle:Sprite;
        private var dealEvent:DealEvent;
        private var _isDashLine:Boolean = false;
        private var _fromModel:DisplayElement;
        private var isDoubleClick:Boolean = false;
        private var _toModel:DisplayElement;
        private var _style:Style;
        private var timer:Timer = null;
        private var _lineAlpha:Number = 0.5;
        private var _lineB:Number = 1.5;
        private var _lineColor:uint = 7773376;
        private var color:ColorProperty;
        public static const LINE_REMOVECOLOR:String = "line_removecolor";
        public static const MODEL_MOVE:String = "model_move";
        public static const LINE_SETCOLOR:String = "line_color";
        public static const LINE_REMOVE:String = "line_remove";

        public function Line()
        {
            color = new ColorProperty();
            dealEvent = new DealEvent();
            timer = new Timer(260, 1);
            this.doubleClickEnabled = true;
            this.addEventListener(MODEL_MOVE, modelMoveHandler);
            this.addEventListener(LINE_REMOVE, removeLineHandler);
            this.addEventListener(LINE_SETCOLOR, turnColorLineHandler);
            this.addEventListener(LINE_REMOVECOLOR, lineRemoveColorHandler);
            this.addEventListener(MouseEvent.MOUSE_OUT, colorOutLineHandler);
            this.addEventListener(MouseEvent.MOUSE_OVER, colorOverLineHandler);
            this.addEventListener(MouseEvent.CLICK, lineClickHandler);
            this.addEventListener(MouseEvent.DOUBLE_CLICK, onLineDoubleClick);
            this.addEventListener(FocusEvent.FOCUS_OUT, focusEventOutHandler);
            return;
        }// end function

        override protected function measure() : void
        {
            super.measure();
            return;
        }// end function

        private function drawCicle() : void
        {
            var _loc_1:* = new Point(this.mouseX, this.mouseY);
            this.graphics.beginFill(65280);
            this.graphics.drawCircle(_loc_1.x, _loc_1.y, 6);
            this.graphics.endFill();
            return;
        }// end function

        public function set lineAlpha(param1:Number) : void
        {
            this._lineAlpha = param1;
            return;
        }// end function

        private function removeLineHandler(event:Event) : void
        {
            this.clear();
            return;
        }// end function

        override protected function createChildren() : void
        {
            if (cricle == null)
            {
                cricle = new Sprite();
            }
            return;
        }// end function

        public function lineRemoveColorHandler(event:Event) : void
        {
            this.lineColor = color.linecolor;
            this.paint();
            return;
        }// end function

        public function set lineB(param1:Number) : void
        {
            this._lineB = param1;
            return;
        }// end function

        public function set lineColor(param1:uint) : void
        {
            this._lineColor = param1;
            return;
        }// end function

        public function get fromModel() : DisplayElement
        {
            return this._fromModel;
        }// end function

        public function get style() : Style
        {
            return this._style;
        }// end function

        private function getEtlInfo(event:MouseEvent) : void
        {
            var _loc_3:DisplayElement = null;
            this.isDoubleClick = true;
            this.setFocus();
            this.lineColor = color.mouselinecolor;
            this.paint();
            var _loc_2:Array = [this.fromModel, this.toModel];
            for each (_loc_3 in _loc_2)
            {
                
                if (_loc_3.isOpen || _loc_3 as DataMapComModel)
                {
                    GraphicUtil.turnModelColor(color.mouselinecolor, _loc_3.basicColor, _loc_3);
                }
                GraphicUtil.turnModelTextColor(color.mouselinecolor, _loc_3);
            }
            for each (_loc_3 in this.fromModel.modelView.getModels())
            {
                
                dealEvent.removeChildEventListener(_loc_3);
            }
            this.fromModel.lineRemoveEventDispatchEvent();
            drawCicle();
            ExternalInterface.call("getStat", this.fromModel.modelId, this.toModel.modelId);
            return;
        }// end function

        private function clickOrDouble(event:TimerEvent) : void
        {
            var _loc_3:DisplayElement = null;
            this.setFocus();
            timer.stop();
            this.lineColor = color.mouselinecolor;
            this.lineAlpha = 0.5;
            this.paint();
            var _loc_2:Array = [this.fromModel, this.toModel];
            for each (_loc_3 in _loc_2)
            {
                
                if (_loc_3.isOpen || _loc_3 as DataMapComModel)
                {
                    GraphicUtil.turnModelColor(color.mouselinecolor, _loc_3.basicColor, _loc_3);
                }
                GraphicUtil.turnModelTextColor(color.mouselinecolor, _loc_3);
            }
            for each (_loc_3 in this.fromModel.modelView.getModels())
            {
                
                dealEvent.removeChildEventListener(_loc_3);
            }
            this.fromModel.lineRemoveEventDispatchEvent();
            if (isDoubleClick)
            {
                if (this.fromModel.factory.dataMapType == "SystemDmType")
                {
                    ExternalInterface.call("getSchemaDataMap", this.fromModel.modelId, this.toModel.modelId);
                }
                else if (this.fromModel.factory.dataMapType == "SchemaDmType")
                {
                    ExternalInterface.call("getDataMapDependency", this.fromModel.modelId, this.toModel.modelId);
                }
            }
            return;
        }// end function

        public function lineClickHandler(event:Event) : void
        {
            isDoubleClick = false;
            timer.start();
            timer.addEventListener(TimerEvent.TIMER, clickOrDouble);
            return;
        }// end function

        public function set fromModel(param1:DisplayElement) : void
        {
            this._fromModel = param1;
            return;
        }// end function

        private function onLineDoubleClick(event:MouseEvent) : void
        {
            isDoubleClick = true;
            return;
        }// end function

        public function get lineAlpha() : Number
        {
            return this._lineAlpha;
        }// end function

        public function clear() : void
        {
            this.graphics.clear();
            return;
        }// end function

        public function get lineB() : Number
        {
            return this._lineB;
        }// end function

        override protected function commitProperties() : void
        {
            super.commitProperties();
            return;
        }// end function

        public function colorOutLineHandler(event:Event) : void
        {
            var _loc_3:DisplayElement = null;
            this.lineColor = color.linecolor;
            this.paint();
            var _loc_2:Array = [this.fromModel, this.toModel];
            for each (_loc_3 in _loc_2)
            {
                
                if (_loc_3.isDashModel)
                {
                    GraphicUtil.turnDashModelColor(color.dashBorderColor, _loc_3.basicColor, _loc_3);
                }
                else
                {
                    GraphicUtil.turnModelGradientColor(color.linecolor, _loc_3.basicColor, _loc_3);
                }
                GraphicUtil.turnModelTextColor(color.fontcolor, _loc_3);
            }
            return;
        }// end function

        public function get lineColor() : uint
        {
            return this._lineColor;
        }// end function

        private function modelMoveHandler(event:Event) : void
        {
            this.paint();
            return;
        }// end function

        public function set toModel(param1:DisplayElement) : void
        {
            this._toModel = param1;
            return;
        }// end function

        public function paint() : void
        {
            if (fromModel.getLeftPoint(this.owner as UIComponent).x < toModel.getLeftPoint(this.owner as UIComponent).x)
            {
                this.style.paint(this, fromModel.getRightPoint(this.owner as UIComponent), toModel.getLeftPoint(this.owner as UIComponent), 1);
            }
            else if (fromModel.getLeftPoint(this.owner as UIComponent).y > toModel.getLeftPoint(this.owner as UIComponent).y)
            {
                this.style.paint(this, fromModel.getRightPoint(this.owner as UIComponent), toModel.getLeftPoint(this.owner as UIComponent), 2);
            }
            else
            {
                this.style.paint(this, fromModel.getRightPoint(this.owner as UIComponent), toModel.getLeftPoint(this.owner as UIComponent), 3);
            }
            return;
        }// end function

        public function colorOverLineHandler(event:Event) : void
        {
            var _loc_3:DisplayElement = null;
            this.lineColor = color.mouselinecolor;
            this.lineAlpha = 0.5;
            this.paint();
            var _loc_2:Array = [this.fromModel, this.toModel];
            for each (_loc_3 in _loc_2)
            {
                
                if (_loc_3.isDashModel)
                {
                    GraphicUtil.turnDashModelGradientColor(color.mouselinecolor, _loc_3.basicColor, _loc_3);
                }
                else
                {
                    GraphicUtil.turnModelGradientColor(color.mouselinecolor, _loc_3.basicColor, _loc_3);
                }
                GraphicUtil.turnModelTextColor(color.mouselinecolor, _loc_3);
            }
            drawCicle();
            return;
        }// end function

        public function set isDashLine(param1:Boolean) : void
        {
            this._isDashLine = param1;
            return;
        }// end function

        public function set style(param1:Style) : void
        {
            this._style = param1;
            return;
        }// end function

        override protected function childrenCreated() : void
        {
            super.createChildren();
            return;
        }// end function

        public function focusEventOutHandler(event:FocusEvent) : void
        {
            var _loc_3:DisplayElement = null;
            this.lineColor = 8424608;
            this.lineAlpha = 0.5;
            this.paint();
            var _loc_2:Array = [this.fromModel, this.toModel];
            for each (_loc_3 in _loc_2)
            {
                
                GraphicUtil.turnModelColor(color.linecolor, _loc_3.basicColor, _loc_3);
                GraphicUtil.turnModelTextColor(color.fontcolor, _loc_3);
            }
            for each (_loc_3 in this.fromModel.modelView.getModels())
            {
                
                dealEvent.addChildEventListener(_loc_3);
            }
            this.fromModel.lineAddEventDispatchEvent();
            return;
        }// end function

        public function get toModel() : DisplayElement
        {
            return this._toModel;
        }// end function

        public function turnColorLineHandler(event:Event) : void
        {
            this.lineColor = color.mouselinecolor;
            this.paint();
            return;
        }// end function

        public function get isDashLine() : Boolean
        {
            return this._isDashLine;
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            return;
        }// end function

    }
}
