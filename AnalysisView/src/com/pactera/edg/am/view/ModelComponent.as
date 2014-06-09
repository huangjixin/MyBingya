package com.pactera.edg.am.view
{
    import com.pactera.edg.am.view.interfaces.*;
    import com.pactera.edg.am.view.model.*;
    import com.roguedevelopment.objecthandles.constraints.*;
    import flash.geom.*;
    import mx.core.*;

    public class ModelComponent extends UIComponent implements MMIContainer
    {
        private var color:ColorProperty = null;
        private var objectHandles:MyObjectHandles = null;

        public function ModelComponent()
        {
            this.objectHandles = new MyObjectHandles(this, null, null);
            var _loc_1:* = new MovementConstraint();
            _loc_1.minX = 0;
            _loc_1.minY = 0;
            this.objectHandles.addDefaultConstraint(_loc_1);
            this.color = new ColorProperty();
            return;
        }// end function

        override protected function measure() : void
        {
        	//zzg 2011-12-13 刷新缓存，便于重算元素尺寸
        	DisplayElement.resetExCache(null);
        	
        	
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
                    _loc_4.push(_loc_7.x + _loc_7.getExWidth());
                    _loc_3.push(_loc_7.y + _loc_7.getExHeight());
                }
                _loc_5++;
            }
            _loc_1 = this.getMaxNum(_loc_4) + 10;
            _loc_2 = this.getMaxNum(_loc_3) + 10;
            var _loc_8:* = _loc_2;
            this.measuredMinHeight = _loc_2;
            this.measuredHeight = _loc_8;
            var _loc_9:* = _loc_1;
            this.measuredWidth = _loc_1;
            this.measuredMinWidth = _loc_9;
            return;
        }// end function

        public function unRegisterComponent() : void
        {
            var _loc_2:DisplayElement = null;
            var _loc_1:int = 0;
            while (_loc_1 < this.numChildren)
            {
                
                if (this.getChildAt(_loc_1) as DisplayElement)
                {
                    _loc_2 = DisplayElement(this.getChildAt(_loc_1));
                    this.objectHandles.unregisterComponent(_loc_2.rectOne);
                }
                _loc_1++;
            }
            return;
        }// end function

        public function getMinPosition() : Point
        {
            var _loc_5:UIComponent = null;
            var _loc_6:DisplayElement = null;
            var _loc_1:* = new Point(0, 0);
            var _loc_2:* = new Array();
            var _loc_3:* = new Array();
            var _loc_4:int = 0;
            while (_loc_4 < this.numChildren)
            {
                
                _loc_5 = this.getChildAt(_loc_4) as UIComponent;
                if (_loc_5 is DisplayElement)
                {
                    _loc_6 = _loc_5 as DisplayElement;
                    _loc_2.push(_loc_6.x);
                    _loc_3.push(_loc_6.y);
                }
                _loc_4++;
            }
            _loc_1 = new Point(this.getMinNum(_loc_2), this.getMinNum(_loc_3));
            return _loc_1;
        }// end function

        private function getMinNum(param1:Array) : Number
        {
            var _loc_3:Number = NaN;
            var _loc_2:* = Number.MAX_VALUE;
            for each (_loc_3 in param1)
            {
                
                _loc_2 = Math.min(_loc_2, _loc_3);
            }
            return _loc_2;
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
                        this.objectHandles.registerComponent(_loc_3, _loc_3.rectOne, ModelView.handles);
                    }
                    else
                    {
                        this.objectHandles.registerComponent(_loc_3, _loc_3.rectOne, param1);
                    }
                }
                _loc_2++;
            }
            return;
        }// end function

        public function registerModel(param1:Array, param2:DisplayElement) : void
        {
            this.objectHandles.registerComponent(param2, param2.rectOne, param1);
            //trace(param1.length);
            return;
        }// end function

        public function getObjectHandles() : MyObjectHandles
        {
            return this.objectHandles;
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            GraphicUtil.turnModelColor(this.color.bgcolor,this.color.bgcolor, this);//0x00ff00
            return;
        }// end function

        public function genObjectHandles() : void
        {
            this.unRegisterComponent();
            this.objectHandles = null;
            this.objectHandles = new MyObjectHandles(this, null, null);
            this.registerModels();
            return;
        }// end function

        private function getMaxNum(param1:Array) : Number
        {
            var _loc_3:Number = NaN;
            var _loc_2:* = Number.MIN_VALUE;
            for each (_loc_3 in param1)
            {
                
                _loc_2 = Math.max(_loc_2, _loc_3);
            }
            return _loc_2;
        }// end function

    }
}
