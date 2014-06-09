package com.pactera.edg.am.dmv.view
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
            return _defalutLabelWidth;
        }// end function

        override protected function measure() : void
        {
            var _loc_2:Array = null;
            var _loc_3:int = 0;
            var _loc_4:String = null;
            var _loc_5:int = 0;
            var _loc_6:int = 0;
            var _loc_7:String = null;
            var _loc_8:TextLineMetrics = null;
            super.measure();
            var _loc_1:* = this.measureText(text);
            if (defalutLabelWidth == 0)
            {
                var _loc_9:* = _loc_1.width + 10;
                measuredWidth = _loc_1.width + 10;
                measuredMinWidth = _loc_9;
                _loc_9 = _loc_1.height + 5;
                measuredHeight = _loc_1.height + 5;
                measuredMinHeight = _loc_9;
            }
            else
            {
                _loc_2 = [];
                _loc_3 = 0;
                _loc_4 = this.text;
                _loc_4 = _loc_4.replace(/\n/g, "");
                _loc_5 = 0;
                while (_loc_5 < _loc_4.length)
                {
                    
                    _loc_7 = _loc_4.substring(_loc_3, _loc_5);
                    _loc_8 = this.measureText(_loc_7);
                    if (_loc_8.width > defalutLabelWidth)
                    {
                        _loc_3 = _loc_5;
                        _loc_2.push(_loc_5);
                    }
                    _loc_5++;
                }
                for each (_loc_6 in _loc_2)
                {
                    
                    _loc_4 = _loc_4.replace(_loc_4.substr(0, _loc_6), _loc_4.substr(0, _loc_6).concat("\n"));
                }
                this.text = _loc_4;
                _loc_9 = Math.min(_loc_1.width, defalutLabelWidth) + 10;
                measuredWidth = Math.min(_loc_1.width, defalutLabelWidth) + 10;
                measuredMinWidth = _loc_9;
                 _loc_9 = _loc_1.height * (_loc_2.length + 1) + 5;
                measuredHeight = _loc_1.height * (_loc_2.length + 1) + 5;
                measuredMinHeight = _loc_9;
            }
            return;
        }// end function

        public function set defalutLabelWidth(param1:Number) : void
        {
            _defalutLabelWidth = param1;
            bdefalutLabelWidthChange = true;
            this.invalidateSize();
            this.invalidateProperties();
            this.invalidateDisplayList();
            dispatchEvent(new Event("widthChanged"));
            return;
        }// end function

        override protected function commitProperties() : void
        {
            if (bdefalutLabelWidthChange)
            {
                bdefalutLabelWidthChange = false;
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
