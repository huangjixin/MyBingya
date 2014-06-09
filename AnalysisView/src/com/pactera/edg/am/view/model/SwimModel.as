package com.pactera.edg.am.view.model
{
    import flash.display.*;
    import flash.events.*;
    import flash.geom.*;
    import mx.controls.*;
    import mx.core.*;
    import mx.managers.*;

    public class SwimModel extends DisplayElement implements IFocusManagerComponent
    {
        private static const defaultIcon:Class = SwimModel_defaultIcon;
        private static const defaultIcon1:Class = SwimModel_defaultIcon1;

        public function SwimModel()
        {
            this.submodels = [];
            this._lines = [];
            return;
        }// end function

        override public function getRightPoint(param1:UIComponent) : Point
        {
            var _loc_7:Image = null;
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:Number = 0;
            var _loc_4:Number = 0;
            if (this.isOpen)
            {
                _loc_3 = _loc_2.getExWidth();
                _loc_4 = (_loc_2.title.textHeight + 10) / 2;
            }
            else
            {
                _loc_7 = _loc_2.iconObject1;
                _loc_3 = _loc_7.x + _loc_7.width;
                _loc_4 = _loc_7.y + _loc_7.height / 2;
            }
            var _loc_5:* = new Point(_loc_3, _loc_4);
            var _loc_6:* = param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override public function getBottomPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:Number = 0;
            var _loc_4:Number = 0;
            _loc_3 = _loc_2.getExWidth() / 2;
            _loc_4 = _loc_2.getExHeight();
            if (this.factory.getViewMapping().isImage)
            {
                if (!this.isOpen)
                {
                    if (this.parentmodel == null)
                    {
                        if (this.modelName.length > 6)
                        {
                            _loc_3 = 80 / 2;
                        }
                    }
                }
            }
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override public function getTopPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = _loc_2.getExWidth() / 2;
            if (this.factory.getViewMapping().isImage)
            {
                if (!this.isOpen)
                {
                    if (this.parentmodel == null)
                    {
                        if (this.modelName.length > 6)
                        {
                            _loc_3 = 80 / 2;
                        }
                    }
                }
            }
            var _loc_4:Number = 0;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            var _loc_8:Number = NaN;
            var _loc_9:DisplayElement = null;
            var _loc_10:DisplayElement = null;
            var _loc_11:Number = NaN;
            var _loc_12:Number = NaN;
            var _loc_13:Number = NaN;
            super.updateDisplayList(param1, param2);
            var _loc_3:* = this.getExWidth();
            var _loc_4:* = this.getExHeight();
            var _loc_5:* = _loc_3 - 5;
            var _loc_6:* = _loc_4 - 5;
            this.setActualSize(_loc_3, _loc_4);
            GraphicUtil.drawRectOne(this);
            this.setChildIndex(iconObject, (this.numChildren - 1));
            var _loc_7:* = new ColorProperty();
            if (this.isOpen)
            {
                if (this.subModels.length > 0)
                {
                    this.addChild(container);
                    for each (_loc_10 in this.submodels)
                    {
                        
                        this.container.addChild(_loc_10);
                    }
                    this.container.move(15, this._title.textHeight + 10);
                    this.container.visible = true;
                    this.grid.reCalculate(this.submodels);
                    _loc_11 = this.grid.getMaxWidth();
                    _loc_12 = this.grid.getMaxHeigth();
                    container.setActualSize(_loc_11, _loc_12);
                }
                iconObject1.setActualSize(15, 15);
                iconObject.setActualSize(15, 15);
                _loc_8 = Math.round((_loc_5 - 15) / 2);
                iconObject.move(10, 6);
                iconObject1.move(10 + 15 + 5, 6);
                title.move(10 + 15 + 15 + 5 + 5, 6);
                if (this.bisAnalysicModel)
                {
                    basicColor = colorProperty.analysisModelSecondColor;
                }
                else
                {
                    basicColor = this.defineColor;
                }
                basicLineColor = _loc_7.linecolor;
                if (this.subModels.length > 0)
                {
                    this.setChildIndex(container, this.numChildren - 2);
                }
                this.linesDispatchEvent();
                for each (_loc_9 in this.submodels)
                {
                    
                    this.grid.moveModel(_loc_9);
                    _loc_9.linesDispatchEvent();
                }
            }
            else
            {
                iconObject1.setActualSize(15, 15);
                iconObject.setActualSize(15, 15);
                title.setActualSize(_loc_6 - 15 - 15, _loc_5 - 15 - 15);
                _loc_13 = Math.round((_loc_3 - 15) / 2);
                iconObject.move(_loc_13, 4);
                iconObject1.move(_loc_13, 4 + 15 + 5);
                title.move(2, 4 + 15 + 15 + 5 + 5);
                basicColor = _loc_7.bgcolor;
                basicLineColor = _loc_7.bgcolor;
                this.container.visible = false;
                this.linesDispatchEvent();
                for each (_loc_9 in this.submodels)
                {
                    
                    _loc_9.removelinesDispatchEvent();
                }
            }
            GraphicUtil.turnModelColor(basicLineColor, basicColor, this);
            return;
        }// end function

        override public function getLeftPoint(param1:UIComponent) : Point
        {
            var _loc_6:Image = null;
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:Number = 0;
            var _loc_4:Number = 0;
            if (this.isOpen)
            {
                _loc_3 = 0;
                _loc_4 = (_loc_2.title.textHeight + 10) / 2;
            }
            else
            {
                _loc_6 = _loc_2.iconObject1;
                _loc_3 = _loc_6.x;
                _loc_4 = _loc_6.y + _loc_6.height / 2;
            }
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override protected function createChildren() : void
        {
            var _loc_1:DisplayElement = null;
            if (this.title == null)
            {
                title = createTextField();
                title.text = modelName;
                addChild(DisplayObject(title));
            }
            if (iconObject1 == null)
            {
                iconObject1 = new Image();
                iconObject1.load(defaultIcon1);
                addChild(iconObject1);
            }
            if (iconObject == null)
            {
                iconObject = new Image();
                iconObject.load(defaultIcon);
                addChild(iconObject);
                iconObject.addEventListener(MouseEvent.CLICK, myObject.imageClick);
            }
            if (this.rectOne == null)
            {
                rectOne = new Sprite();
                this.addChild(rectOne);
                this.rectOne.addEventListener(MouseEvent.ROLL_OVER, myObject.modelRollOverHandler);
                this.rectOne.addEventListener(MouseEvent.ROLL_OUT, myObject.modelRollOutHandler);
                this.rectOne.addEventListener(MouseEvent.CLICK, myObject.modelClickHandler);
                this.rectOne.addEventListener(MouseEvent.ROLL_OVER, myObject.modelDetailInfoRollOverHandler);
                this.rectOne.addEventListener(MouseEvent.ROLL_OUT, myObject.modelDetailInfoRollOutHandler);
                this.showContextMenu();
            }
            this.container.visible = false;
            if (this.subModels.length > 0)
            {
                this.addChild(container);
                for each (_loc_1 in this.submodels)
                {
                    
                    this.container.addChild(_loc_1);
                }
            }
            return;
        }// end function

    }
}
