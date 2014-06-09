package com.pactera.edg.am.view
{
    import com.pactera.edg.am.view.interfaces.*;
    import com.pactera.edg.am.view.model.*;
    import mx.core.*;

    public class ModelContainer extends UIComponent implements MMIContainer
    {
        private var _model:DisplayElement;
        private var objectHandles:MyObjectHandles;
        public var objectId:String;

        public function ModelContainer()
        {
            this.objectHandles = new MyObjectHandles(this, null, null);
            this.objectId = "objectHandlesId" + Math.random().toString();
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

        override protected function createChildren() : void
        {
            var _loc_1:DisplayElement = null;
            super.createChildren();
            for each (_loc_1 in this.model.subModels)
            {
                
                this.addChild(_loc_1);
            }
            this.registerModels(ModelView.handles);
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

        public function registerModel(param1:Array, param2:DisplayElement) : void
        {
            this.objectHandles.registerComponent(param2, param2.rectOne, param1);
            return;
        }// end function

        public function get model() : DisplayElement
        {
            return this._model;
        }// end function

        public function set model(param1:DisplayElement) : void
        {
            this._model = param1;
            return;
        }// end function

        public function getObjectHandles() : MyObjectHandles
        {
            return this.objectHandles;
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
			//zzg 20130723 增加颜色定制参数
			if(Application!=null&&
				Application.application!=null&&
				Application.application.parameters!=null&&
				Application.application.parameters.isCustomColor=="1" //需要定义颜色
			){
				_modelContainerFillColor=getColorVal(_modelContainerFillColor,Application.application.parameters.mv_modelContainerFillColor);
			}
			
			GraphicUtil.turnModelColor(_modelContainerFillColor, _modelContainerFillColor, this);
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
