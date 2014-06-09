package com.pactera.edg.am.dmv.view
{
    import com.pactera.edg.am.dmv.view.model.*;
    import flash.events.*;
    import flash.text.*;
    import mx.containers.*;

    public class MyCustomPopUpWin extends Canvas
    {
        private var defaultWidth:Number = 200;
        private var _modelXmlList:XMLList;
        private var bModelXmlListChange:Boolean = false;

        public function MyCustomPopUpWin()
        {
            return;
        }// end function

        override protected function commitProperties() : void
        {
            if (bModelXmlListChange)
            {
                bModelXmlListChange = false;
            }
            return;
        }// end function

        public function get modelXmlList() : XMLList
        {
            return _modelXmlList;
        }// end function

        private function getCustomHight(param1:Number) : Number
        {
            var _loc_4:Number = NaN;
            var _loc_5:int = 0;
            var _loc_6:CustomLabel = null;
            var _loc_2:Number = 0;
            var _loc_3:int = 0;
            while (_loc_3 <= param1)
            {
                
                _loc_4 = 0;
                _loc_5 = 0;
                while (_loc_5 < this.numChildren)
                {
                    
                    _loc_6 = this.getChildAt(_loc_5) as CustomLabel;
                    if (_loc_6.rowNum == _loc_3)
                    {
                        _loc_4 = Math.max(_loc_6.getExplicitOrMeasuredHeight(), _loc_4);
                    }
                    _loc_5++;
                }
                _loc_2 = _loc_2 + _loc_4;
                _loc_3++;
            }
            return _loc_2;
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            var _loc_6:CustomLabel = null;
            super.updateDisplayList(param1, param2);
            var _loc_3:* = param1;
            var _loc_4:* = param2;
            this.setActualSize(param1, param2);
            var _loc_5:int = 0;
            while (_loc_5 < this.numChildren)
            {
                
                _loc_6 = this.getChildAt(_loc_5) as CustomLabel;
                _loc_6.move(0, _loc_6.rowNum * 20 + 5);
                _loc_5++;
            }
            GraphicUtil.turnFillColor(16645838, this, 0.9);
            return;
        }// end function

        public function set modelXmlList(param1:XMLList) : void
        {
            var _loc_2:CustomLabel = null;
            var _loc_4:TextLineMetrics = null;
            var _loc_5:XML = null;
            this.removeAllChildren();
            _modelXmlList = param1;
            dispatchEvent(new Event("modelXmlListChanged"));
            bModelXmlListChange = true;
            var _loc_3:Number = 0;
            for each (_loc_5 in _modelXmlList)
            {
                
                _loc_2 = new CustomLabel();
                _loc_2.text = "  " + _loc_5.@name + ":" + _loc_5.text().toString();
                _loc_4 = this.measureText(_loc_2.text);
                _loc_2.rowNum = _loc_3;
                _loc_2.colNum = 0;
                _loc_2.setActualSize(_loc_4.width + 20, _loc_4.height);
                this.addChild(_loc_2);
                _loc_3 = _loc_3 + 1;
            }
            this.invalidateProperties();
            this.invalidateSize();
            this.invalidateDisplayList();
            return;
        }// end function

        override protected function createChildren() : void
        {
            super.createChildren();
            return;
        }// end function

        override protected function measure() : void
        {
            var _loc_4:CustomLabel = null;
            super.measure();
            var _loc_1:Number = 0;
            var _loc_2:Number = 0;
            var _loc_3:int = 0;
            while (_loc_3 < this.numChildren)
            {
                
                _loc_4 = this.getChildAt(_loc_3) as CustomLabel;
                _loc_1 = Math.max(_loc_1, _loc_4.rowNum);
                _loc_2 = Math.max(_loc_2, _loc_4.colNum);
                _loc_3++;
            }
            var _loc_5:* = getCustomHight(_loc_1) + 10;
            this.measuredMinHeight = getCustomHight(_loc_1) + 10;
            this.measuredHeight = _loc_5;
            _loc_5= getCustomWidth(_loc_2) + 10;
            this.measuredMinWidth = getCustomWidth(_loc_2) + 10;
            this.measuredWidth = _loc_5;
            return;
        }// end function

        private function getCustomWidth(param1:Number) : Number
        {
            var _loc_4:Number = NaN;
            var _loc_5:int = 0;
            var _loc_6:CustomLabel = null;
            var _loc_2:Number = 0;
            var _loc_3:int = 0;
            while (_loc_3 <= param1)
            {
                
                _loc_4 = 0;
                _loc_5 = 0;
                while (_loc_5 < this.numChildren)
                {
                    
                    _loc_6 = this.getChildAt(_loc_5) as CustomLabel;
                    if (_loc_6.colNum == _loc_3)
                    {
                        _loc_4 = Math.max(_loc_6.getExplicitOrMeasuredWidth(), _loc_4);
                    }
                    _loc_5++;
                }
                _loc_2 = _loc_2 + _loc_4;
                _loc_3++;
            }
            return _loc_2;
        }// end function

    }
}
