package com.pactera.edg.am.kpi.view.line
{
    import com.pactera.edg.am.kpi.view.line.*;
    import com.pactera.edg.am.kpi.view.model.*;
    import flash.events.*;
    import flash.geom.*;
    import mx.core.*;

    public class Line extends UIComponent implements ILine
    {
        private var _direction:Direction;
        private var _lineColor:uint = 0;
        private var _lineB:Number = 0.25;
        private var _fromModel:DisplayElement;
        private var _toModel:DisplayElement;
        private var _style:Style;

        public function Line()
        {
            this.addEventListener("model_move", modelMoveHandler);
            return;
        }// end function

        override protected function measure() : void
        {
            super.measure();
            return;
        }// end function

        public function set direction(param1:Direction) : void
        {
            this._direction = param1;
            return;
        }// end function

        override protected function commitProperties() : void
        {
            super.commitProperties();
            return;
        }// end function

        public function get lineB() : Number
        {
            return this._lineB;
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

        public function get fromModel() : DisplayElement
        {
            return this._fromModel;
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

        override protected function childrenCreated() : void
        {
            super.createChildren();
            return;
        }// end function

        public function paint() : void
        {
            var _loc_1:* = new Point();
            var _loc_2:* = new Point();
            _loc_1 = this.direction.getFromPoint(this.fromModel, this.toModel, this.owner as UIComponent);
            _loc_2 = this.direction.getToPoint(this.fromModel, this.toModel, this.owner as UIComponent);
            this.style.paint(this, _loc_1, _loc_2, this.direction.direction);
            return;
        }// end function

        public function get toModel() : DisplayElement
        {
            return this._toModel;
        }// end function

        public function get style() : Style
        {
            return this._style;
        }// end function

        public function set lineColor(param1:uint) : void
        {
            this._lineColor = param1;
            return;
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            return;
        }// end function

        public function set fromModel(param1:DisplayElement) : void
        {
            this._fromModel = param1;
            return;
        }// end function

        public function get direction() : Direction
        {
            return this._direction;
        }// end function

    }
}
