package com.pactera.edg.am.view.line
{
    import com.pactera.edg.am.view.line.*;
    import com.pactera.edg.am.view.model.*;
    import flash.events.*;
    import flash.geom.*;
    import mx.core.*;

    public class Line extends UIComponent implements ILine
    {
        private var _lineAlpha:Number = 0.5;
        private var dealEvent:DealEvent = null;
        private var _lineB:Number = 2.5;
        private var _lineColor:uint = 8821177;
        private var _fromModel:DisplayElement;
        private var color:ColorProperty = null;
        private var _refFlag:Boolean = false;
        private var _toModel:DisplayElement;
        private var _style:Style;
        public static const LINE_REMOVECOLOR:String = "line_removecolor";
        public static const MODEL_MOVE:String = "model_move";
        public static const LINE_SETCOLOR:String = "line_color";
        public static const LINE_REMOVE:String = "line_remove";

        public function Line()
        {
            this.color = new ColorProperty();
            this.dealEvent = new DealEvent();
            this.addEventListener(MODEL_MOVE, this.modelMoveHandler);
            this.addEventListener(LINE_REMOVE, this.removeLineHandler);
            this.addEventListener(LINE_SETCOLOR, this.turnColorLineHandler);
            this.addEventListener(LINE_REMOVECOLOR, this.lineRemoveColorHandler);
            this.addEventListener(MouseEvent.MOUSE_OUT, this.colorOutLineHandler);
            this.addEventListener(MouseEvent.MOUSE_OVER, this.colorOverLineHandler);
            this.addEventListener(MouseEvent.CLICK, this.lineClickHandler);
            this.addEventListener(FocusEvent.FOCUS_OUT, this.focusEventOutHandler);
            return;
        }// end function

        public function paint() : void
        {
            var _loc_1:* = this.owner as UIComponent;
            var _loc_2:* = this.fromModel.getRightPoint(_loc_1);
            var _loc_3:* = this.fromModel.getLeftPoint(_loc_1);
            var _loc_4:* = this.toModel.getRightPoint(_loc_1);
            var _loc_5:* = this.toModel.getLeftPoint(_loc_1);
            if (this.refFlag)
            {
                this.style.paint(this, _loc_2, _loc_4, 4);
            }
            else if (_loc_3.x < _loc_5.x)
            {
                this.style.paint(this, _loc_2, _loc_5, 1);
            }
            else if (_loc_3.y > _loc_5.y)
            {
                this.style.paint(this, _loc_2, _loc_5, 2);
            }
            else
            {
                this.style.paint(this, _loc_2, _loc_5, 3);
            }
            return;
        }// end function

        public function set fromModel(param1:DisplayElement) : void
        {
            this._fromModel = param1;
            return;
        }// end function

        public function get style() : Style
        {
            return this._style;
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

        public function colorOutLineHandler(event:Event) : void
        {
            var _loc_3:DisplayElement = null;
            this.lineColor = this.color.linecolor;
            this.lineAlpha = 0.5;
            this.paint();
            var _loc_2:Array = [this.fromModel, this.toModel];
            for each (_loc_3 in _loc_2)
            {
                
                if (_loc_3.isOpen || _loc_3 as CombinationModel)
                {
                    GraphicUtil.turnModelColor(this.color.linecolor, _loc_3.basicColor, _loc_3);
                }
                GraphicUtil.turnModelTextColor(this.color.fontcolor, _loc_3);
            }
            return;
        }// end function

        public function set lineAlpha(param1:Number) : void
        {
            this._lineAlpha = param1;
            return;
        }// end function

        public function get lineB() : Number
        {
            return this._lineB;
        }// end function

        private function modelMoveHandler(event:Event) : void
        {
            this.paint();
            return;
        }// end function

        private function removeLineHandler(event:Event) : void
        {
            this.clear();
            return;
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            return;
        }// end function

        override protected function measure() : void
        {
            super.measure();
            return;
        }// end function

        public function lineRemoveColorHandler(event:Event) : void
        {
            this.lineColor = this.color.linecolor;
            this.lineAlpha = 0.5;
            this.paint();
            return;
        }// end function

        public function set lineColor(param1:uint) : void
        {
            this._lineColor = param1;
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
                
                if (_loc_3.isOpen || _loc_3 as CombinationModel)
                {
                    GraphicUtil.turnModelColor(this.color.linecolor, _loc_3.basicColor, _loc_3);
                }
                GraphicUtil.turnModelTextColor(this.color.fontcolor, _loc_3);
            }
            for each (_loc_3 in this.fromModel.modelView.getModels())
            {
                
                this.dealEvent.addChildEventListener(_loc_3);
            }
            this.fromModel.lineAddEventDispatchEvent();
            return;
        }// end function

        public function colorOverLineHandler(event:Event) : void
        {
            var _loc_3:DisplayElement = null;
            this.lineColor = this.color.mouselinecolor;
            this.lineAlpha = 0.5;
            this.paint();
            var _loc_2:Array = [this.fromModel, this.toModel];
            for each (_loc_3 in _loc_2)
            {
                
                GraphicUtil.turnModelColor(this.color.mouselinecolor, _loc_3.basicColor, _loc_3);
                GraphicUtil.turnModelTextColor(this.color.mouselinecolor, _loc_3);
            }
            return;
        }// end function

        public function set style(param1:Style) : void
        {
            this._style = param1;
            return;
        }// end function

        public function set lineB(param1:Number) : void
        {
            this._lineB = param1;
            return;
        }// end function

        override protected function commitProperties() : void
        {
            super.commitProperties();
            return;
        }// end function

        public function get refFlag() : Boolean
        {
            return this._refFlag;
        }// end function

        public function turnColorLineHandler(event:Event) : void
        {
            this.lineColor = this.color.mouselinecolor;
            this.lineAlpha = 0.5;
            this.paint();
            return;
        }// end function

        public function get lineColor() : uint
        {
            return this._lineColor;
        }// end function

        public function set toModel(param1:DisplayElement) : void
        {
            this._toModel = param1;
            return;
        }// end function

        public function get toModel() : DisplayElement
        {
            return this._toModel;
        }// end function

        public function lineClickHandler(event:Event) : void
        {
            var _loc_3:DisplayElement = null;
            this.setFocus();
            this.lineColor = this.color.mouselinecolor;
            this.lineAlpha = 0.5;
            this.paint();
            var _loc_2:Array = [this.fromModel, this.toModel];
            for each (_loc_3 in _loc_2)
            {
                
                GraphicUtil.turnModelColor(this.color.mouselinecolor, _loc_3.basicColor, _loc_3);
                GraphicUtil.turnModelTextColor(this.color.mouselinecolor, _loc_3);
            }
            for each (_loc_3 in this.fromModel.modelView.getModels())
            {
                
                this.dealEvent.removeChildEventListener(_loc_3);
            }
            this.fromModel.lineRemoveEventDispatchEvent();
            return;
        }// end function

        public function get fromModel() : DisplayElement
        {
            return this._fromModel;
        }// end function

        override protected function childrenCreated() : void
        {
            super.createChildren();
            return;
        }// end function

        public function set refFlag(param1:Boolean) : void
        {
            this._refFlag = param1;
            return;
        }// end function

    }
}
