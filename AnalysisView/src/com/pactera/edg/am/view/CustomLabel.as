package com.pactera.edg.am.view
{
    import flash.events.*;
    import flash.text.*;
    import mx.controls.*;

    public class CustomLabel extends Label
    {
        private var _defalutLabelWidth:Number = 0;
        public var colNum:Number = 0;
        private var bdefalutLabelWidthChange:Boolean = false;
        public var rowNum:Number = 0;

        public function CustomLabel()
        {
            return;
        }// end function

        public function get defalutLabelWidth() : Number
        {
            return this._defalutLabelWidth;
        }// end function

        override protected function measure() : void
        {
            var _loc_2:Array = null;
            var _loc_3:int = 0;
            var _loc_4:String = null;
            var _loc_5:TextLineMetrics = null;
            var _loc_6:int = 0;
            var _loc_7:int = 0;
            var _loc_8:int = 0;
            var _loc_9:String = null;
            super.measure();
            var _loc_1:* = this.measureText(text);
            if (this.defalutLabelWidth == 0)
            {
                this.measuredWidth = _loc_1.width + 10;
                this.measuredHeight = _loc_1.height + 5;
            }
            else
            {
                _loc_2 = [];
                _loc_3 = 0;
                _loc_4 = this.text;
                _loc_4 = _loc_4.replace(/\n/g, "");
                _loc_6 = 0;
                while (_loc_6 <= _loc_4.length)
                {
                    
                    _loc_9 = _loc_4.substring(_loc_3, _loc_6) + "A";
                    _loc_5 = this.measureText(_loc_9);
                    if (_loc_5.width > this.defalutLabelWidth)
                    {
                        _loc_3 = _loc_6;
                        _loc_2.push(_loc_6);
                    }
                    _loc_6++;
                }
                _loc_7 = 0;
                for each (_loc_8 in _loc_2)
                {
                    
                    _loc_4 = _loc_4.replace(_loc_4.substr(0, _loc_8 - _loc_7), _loc_4.substr(0, _loc_8 - _loc_7).concat("\n"));
                    _loc_7++;
                }
                this.text = _loc_4;
                this.measuredWidth = Math.min(_loc_1.width, this.defalutLabelWidth) + 10;
                this.measuredHeight = _loc_1.height * (_loc_2.length + 1) + 5;
            }
            return;
        }// end function

        public function set defalutLabelWidth(param1:Number) : void
        {
            this._defalutLabelWidth = param1;
            this.bdefalutLabelWidthChange = true;
            this.invalidateProperties();
            dispatchEvent(new Event("widthChanged"));
            return;
        }// end function

        override protected function commitProperties() : void
        {
            if (this.bdefalutLabelWidthChange)
            {
                this.bdefalutLabelWidthChange = false;
                this.invalidateSize();
                this.invalidateProperties();
                this.invalidateDisplayList();
            }
            return;
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            this.setActualSize(param1, param2);
            return;
        }// end function

    }
}
