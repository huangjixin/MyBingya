package com.pactera.edg.am.dmv.view
{
    import com.pactera.edg.am.dmv.view.model.*;
    import com.roguedevelopment.objecthandles.*;
    import mx.core.*;
    import mx.events.*;
     import com.pactera.edg.am.dmv.view.interfaces.*;

    public class ModelContainer extends UIComponent implements MMIContainer
    {
        private var _model:DisplayElement;
        private var objectHandles:MyObjectHandles;

        public function ModelContainer()
        {
        	 this.objectHandles = new MyObjectHandles(this, null, null);
            this.addEventListener(FlexEvent.INITIALIZE, initializeHandler);
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
                    objectHandles.unregisterComponent(_loc_2.rectOne);
                }
                _loc_1++;
            }
            return;
        }// end function

        public function get model() : DisplayElement
        {
            return this._model;
        }// end function

        public function registerModels(param1:Array = null) : void
        {
            var _loc_3:DisplayElement = null;
            objectHandles = new MyObjectHandles(this, null, null);
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

        public function set model(param1:DisplayElement) : void
        {
            this._model = param1;
            return;
        }// end function

        public function getObjectHandles() : MyObjectHandles
        {
            return objectHandles;
        }// end function

		private  function getColorVal(defaultColor:uint,settingColor:String):uint{
			if(settingColor==null||settingColor.length==0){
				return defaultColor;
			}else{
				return uint(settingColor);
			}
		}
        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
			var _modelContainerFillColor:uint = 0xF8F3DF;
			//zzg 20130813 增加颜色定制参数
			if(Application!=null&&
				Application.application!=null&&
				Application.application.parameters!=null&&
				Application.application.parameters.isCustomColor=="1" //需要定义颜色
			){
				_modelContainerFillColor=getColorVal(_modelContainerFillColor,Application.application.parameters.dmv_modelContainerFillColor);
			}
			
            //GraphicUtil.turnUIComponentGradientColor(16777215, [16777215, 16578519], this);
            return;
        }// end function

        private function initializeHandler(event:FlexEvent) : void
        {
            this.styleName = "gradient";
            return;
        }// end function

        override protected function createChildren() : void
        {
            var _loc_1:DisplayElement = null;
            super.createChildren();
            for each (_loc_1 in this.model.subModels)
            {
                
                this.addChild(_loc_1);
            }
            this.registerModels(this.model.modelView.handles);
            return;
        }// end function

        public function genObjectHandles() : void
        {
            unRegisterComponent();
            objectHandles = new MyObjectHandles(this, null, null);
            registerModels();
            return;
        }// end function
        
        public function registerModel(param1:Array, param2:DisplayElement) : void
        {
            this.objectHandles.registerComponent(param2, param2.rectOne, param1);
            return;
        }// end function
        override protected function measure() : void
        {
            super.measure();
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
