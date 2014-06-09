package com.pactera.edg.am.view
{
    import com.pactera.edg.am.view.model.*;
    import flash.events.*;
    import flash.text.*;
    import mx.core.*;

    public class CustomPopUpWin extends UIComponent
    {
        private var defaultWidth:Number = 200;
        private var resourceLabel:CustomLabel;
        private var myLableInfo:CustomLabel;
        private var locationLabelInfo:CustomLabel;
        private var locationLabel:CustomLabel;
        private var classLabel:CustomLabel;
        private var classLabelInfo:CustomLabel;
        private var resourceLabelInfo:CustomLabel;
        private var _model:DisplayElement;
        private var myLable:CustomLabel;
        private var bTextChange:Boolean = false;

        public function CustomPopUpWin()
        {
            return;
        }// end function

        override protected function commitProperties() : void
        {
            if (this.bTextChange)
            {
                this.bTextChange = false;
                this.myLableInfo.text = this._model.mdname;
                this.classLabelInfo.text = this._model.mdcode;
                this.resourceLabelInfo.text = this._model.mdmodelName;
                this.locationLabelInfo.text = this._model.mdlocation;
            }
            return;
        }// end function

        public function set model(param1:DisplayElement) : void
        {
            this._model = param1;
            this.bTextChange = true;
            dispatchEvent(new Event("textChanged"));
            this.invalidateProperties();
            this.invalidateSize();
            this.invalidateDisplayList();
            return;
        }// end function

        override protected function createChildren() : void
        {
            super.createChildren();
            if (this.myLable == null)
            {
                this.myLable = new CustomLabel();
                this.myLable.rowNum = 0;
                this.myLable.colNum = 0;
                this.myLable.text = "名称:";
                addChild(this.myLable);
            }
            if (this.myLableInfo == null)
            {
                this.myLableInfo = new CustomLabel();
                this.myLableInfo.rowNum = 0;
                this.myLableInfo.colNum = 1;
                addChild(this.myLableInfo);
            }
            if (this.resourceLabel == null)
            {
                this.resourceLabel = new CustomLabel();
                this.resourceLabel.rowNum = 1;
                this.resourceLabel.colNum = 0;
                this.resourceLabel.text = "元数据类型:";
                addChild(this.resourceLabel);
            }
            if (this.resourceLabelInfo == null)
            {
                this.resourceLabelInfo = new CustomLabel();
                this.resourceLabelInfo.rowNum = 1;
                this.resourceLabelInfo.colNum = 1;
                addChild(this.resourceLabelInfo);
            }
            if (this.classLabel == null)
            {
                this.classLabel = new CustomLabel();
                this.classLabel.rowNum = 2;
                this.classLabel.colNum = 0;
                this.classLabel.text = "代码:";
                addChild(this.classLabel);
            }
            if (this.classLabelInfo == null)
            {
                this.classLabelInfo = new CustomLabel();
                this.classLabelInfo.rowNum = 2;
                this.classLabelInfo.colNum = 1;
                addChild(this.classLabelInfo);
            }
            if (this.locationLabel == null)
            {
                this.locationLabel = new CustomLabel();
                this.locationLabel.rowNum = 3;
                this.locationLabel.colNum = 0;
                this.locationLabel.text = "路径:";
                addChild(this.locationLabel);
            }
            if (this.locationLabelInfo == null)
            {
                this.locationLabelInfo = new CustomLabel();
                this.locationLabelInfo.rowNum = 3;
                this.locationLabelInfo.colNum = 1;
                addChild(this.locationLabelInfo);
            }
            return;
        }// end function

        override protected function measure() : void
        {
            var _loc_5:CustomLabel = null;
            super.measure();
            var _loc_1:* = this.measureLabel(this.myLable, this.myLableInfo);
            if (_loc_1)
            {
                this.classLabel.rowNum = this.myLable.rowNum + 2;
            }
            else
            {
                this.classLabel.rowNum = this.myLable.rowNum + 1;
            }
            _loc_1 = this.measureLabel(this.classLabel, this.classLabelInfo);
            if (_loc_1)
            {
                this.resourceLabel.rowNum = this.classLabel.rowNum + 2;
            }
            else
            {
                this.resourceLabel.rowNum = this.classLabel.rowNum + 1;
            }
            _loc_1 = this.measureLabel(this.resourceLabel, this.resourceLabelInfo);
            if (_loc_1)
            {
                this.locationLabel.rowNum = this.resourceLabel.rowNum + 2;
            }
            else
            {
                this.locationLabel.rowNum = this.resourceLabel.rowNum + 1;
            }
            this.measureLabel(this.locationLabel, this.locationLabelInfo);
            var _loc_2:Number = 0;
            var _loc_3:Number = 0;
            var _loc_4:int = 0;
            while (_loc_4 < this.numChildren)
            {
                
                _loc_5 = this.getChildAt(_loc_4) as CustomLabel;
                _loc_2 = Math.max(_loc_2, _loc_5.rowNum);
                _loc_3 = Math.max(_loc_3, _loc_5.colNum);
                _loc_4++;
            }
            var custHight:* = this.getCustomHight(_loc_2) + 10;
            this.measuredMinHeight = this.getCustomHight(_loc_2) + 10;
            this.measuredHeight = custHight;
            var minWidth:* = Math.min(this.getCustomWidth(_loc_3), this.defaultWidth) + 10;
            this.measuredMinWidth = Math.min(this.getCustomWidth(_loc_3), this.defaultWidth) + 10;
            this.measuredWidth = minWidth;
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

        public function get model() : DisplayElement
        {
            return this._model;
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

        private function getStrActual(param1:String) : String
        {
            return param1.replace(/[^\x00-\xff]/g,"xx");
        }// end function

        private function measureLabel(param1:CustomLabel, param2:CustomLabel) : Boolean
        {
            var _loc_3:Boolean = false;
            var _loc_4:* = this.measureText(this.getStrActual(param2.text));
            var _loc_5:* = this.measureText(param1.text);
            var _loc_6:* = param1.getExplicitOrMeasuredWidth() + _loc_4.width + 10;
            if (param1.getExplicitOrMeasuredWidth() + _loc_4.width + 10 > this.defaultWidth)
            {
                param2.defalutLabelWidth = this.defaultWidth;
                param2.rowNum = param1.rowNum + 1;
                param2.colNum = 0;
                _loc_3 = true;
            }
            else
            {
                param2.rowNum = param1.rowNum;
                param2.colNum = 1;
            }
            return _loc_3;
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            var _loc_3:* = param1;
            var _loc_4:* = param2;
            this.myLable.setActualSize(this.myLable.getExplicitOrMeasuredWidth(), this.myLable.getExplicitOrMeasuredHeight());
            this.myLableInfo.setActualSize(this.myLableInfo.getExplicitOrMeasuredWidth(), this.myLableInfo.getExplicitOrMeasuredHeight());
            this.resourceLabel.setActualSize(this.resourceLabel.getExplicitOrMeasuredWidth(), this.resourceLabel.getExplicitOrMeasuredHeight());
            this.resourceLabelInfo.setActualSize(this.resourceLabelInfo.getExplicitOrMeasuredWidth(), this.resourceLabelInfo.getExplicitOrMeasuredHeight());
            this.locationLabel.setActualSize(this.locationLabel.getExplicitOrMeasuredWidth(), this.locationLabel.getExplicitOrMeasuredHeight());
            this.locationLabelInfo.setActualSize(this.locationLabelInfo.getExplicitOrMeasuredWidth(), this.locationLabelInfo.getExplicitOrMeasuredHeight());
            this.classLabel.setActualSize(this.classLabel.getExplicitOrMeasuredWidth(), this.classLabel.getExplicitOrMeasuredHeight());
            this.classLabelInfo.setActualSize(this.classLabelInfo.getExplicitOrMeasuredWidth(), this.classLabelInfo.getExplicitOrMeasuredHeight());
            this.myLable.move(4, 4);
            if (this.myLableInfo.rowNum == 0)
            {
                this.myLableInfo.move(4 + this.myLable.width, 4);
            }
            else if (this.myLableInfo.rowNum == 1)
            {
                this.myLableInfo.move(4, 4 + this.getCustomHight((this.myLableInfo.rowNum - 1)));
            }
            this.classLabel.move(4, 4 + this.getCustomHight((this.classLabel.rowNum - 1)));
            if (this.classLabelInfo.rowNum == (this.myLableInfo.rowNum + 1))
            {
                this.classLabelInfo.move(4 + this.classLabel.width, 4 + this.getCustomHight((this.classLabel.rowNum - 1)));
            }
            else if (this.classLabelInfo.rowNum == this.myLableInfo.rowNum + 2)
            {
                this.classLabelInfo.move(4, 4 + this.getCustomHight(this.classLabel.rowNum));
            }
            this.resourceLabel.move(4, 4 + this.getCustomHight((this.resourceLabel.rowNum - 1)));
            if (this.resourceLabelInfo.rowNum == (this.classLabelInfo.rowNum + 1))
            {
                this.resourceLabelInfo.move(4 + this.resourceLabel.width, 4 + this.getCustomHight((this.resourceLabel.rowNum - 1)));
            }
            else if (this.resourceLabelInfo.rowNum == this.classLabelInfo.rowNum + 2)
            {
                this.resourceLabelInfo.move(4, 4 + this.getCustomHight(this.resourceLabel.rowNum));
            }
            this.locationLabel.move(4, 4 + this.getCustomHight((this.locationLabel.rowNum - 1)));
            if (this.locationLabelInfo.rowNum == (this.resourceLabelInfo.rowNum + 1))
            {
                this.locationLabelInfo.move(4 + this.locationLabel.width, 4 + this.getCustomHight((this.locationLabel.rowNum - 1)));
            }
            else if (this.locationLabelInfo.rowNum == this.resourceLabelInfo.rowNum + 2)
            {
                this.locationLabelInfo.move(4, 4 + this.getCustomHight(this.locationLabel.rowNum));
            }
            this.setActualSize(param1, param2);
            GraphicUtil.dropShadow(16645838, 16645838, this);
            return;
        }// end function

    }
}
