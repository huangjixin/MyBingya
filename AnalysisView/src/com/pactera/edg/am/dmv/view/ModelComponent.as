package com.pactera.edg.am.dmv.view
{
    import com.pactera.edg.am.dmv.view.model.*;
    import com.roguedevelopment.objecthandles.constraints.*;
    import mx.core.*;

    public class ModelComponent extends UIComponent
    {
        private var _lastMeasuredHeight:int;
        private var objectHandles:MyObjectHandles;
        private var _lastMeasuredWeight:int;

        public function ModelComponent()
        {
            objectHandles = new MyObjectHandles(this, null, null);
            var _loc_1:* = new MovementConstraint();
            _loc_1.minX = 0;
            _loc_1.minY = 0;
            objectHandles.addDefaultConstraint(_loc_1);
            return;
        }// end function

        public function registerModel(param1:Array, param2:DisplayElement) : void
        {
            objectHandles.registerComponent(param2, param2.rectOne, param1);
            return;
        }// end function

        public function registerModels(param1:Array = null) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_2:int = 0;
            while (_loc_2 < this.numChildren)
            {
                
                if (this.getChildAt(_loc_2) as DisplayElement)
                {
                    _loc_3 = DisplayElement(this.getChildAt(_loc_2));
                    if (param1 == null)
                    {
                        objectHandles.registerComponent(_loc_3, _loc_3.rectOne, _loc_3.modelView.handles);
                    }
                    else
                    {
                        objectHandles.registerComponent(_loc_3, _loc_3.rectOne, param1);
                    }
                }
                _loc_2++;
            }
            return;
        }// end function

        public function getObjectHandles() : MyObjectHandles
        {
            return objectHandles;
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            return;
        }// end function

        public function genObjectHandles() : void
        {
            objectHandles = new MyObjectHandles(this, null, null);
            return;
        }// end function

        override protected function measure() : void
        {
            var _loc_6:UIComponent = null;
            var _loc_7:DisplayElement = null;
            super.measure();
            var _loc_1:Number = 0;
            var _loc_2:Number = 0;
            var _loc_3:* = new Array();
            var _loc_4:* = new Array();
            var _loc_5:int = 0;
            while (_loc_5 < this.numChildren)
            {
                
                _loc_6 = this.getChildAt(_loc_5) as UIComponent;
                if (_loc_6 is DisplayElement)
                {
                    _loc_7 = _loc_6 as DisplayElement;
                    _loc_4.push(_loc_7.x + _loc_7.getExplicitOrMeasuredWidth());
                    _loc_3.push(_loc_7.y + _loc_7.getExplicitOrMeasuredHeight());
                }
                _loc_5++;
            }
            _loc_1 = getMaxNum(_loc_4) + 10;
            _loc_2 = getMaxNum(_loc_3) + 10;
            var _loc_8:* = _loc_2;
            this.measuredMinHeight = _loc_2;
            this.measuredHeight = _loc_8;
            _loc_8 = _loc_1;
            this.measuredWidth = _loc_1;
            this.measuredMinWidth = _loc_8;
            return;
        }// end function

        private function getMaxNum(param1:Array) : Number
        {
            var _loc_3:Number = NaN;
            var _loc_2:Number = 0;
            for each (_loc_3 in param1)
            {
                
                _loc_2 = Math.max(_loc_2, _loc_3);
            }
            return _loc_2;
        }// end function

    }
}
