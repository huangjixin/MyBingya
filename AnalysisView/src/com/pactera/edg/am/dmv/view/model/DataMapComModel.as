package com.pactera.edg.am.dmv.view.model
{
    import com.pactera.edg.am.dmv.view.*;
    import com.roguedevelopment.objecthandles.constraints.*;
    import flash.display.*;
    import flash.events.*;
    import flash.geom.*;
    import flash.text.*;
    import mx.controls.*;
    import mx.core.*;
    import mx.managers.*;
    import com.pactera.edg.am.dmv.view.model.*;
    

    public class DataMapComModel extends DisplayElement implements IFocusManagerComponent
    {
        private static const systemLevelIcon:Class = DataMapComModel_systemLevelIcon;

        public function DataMapComModel()
        {
            this.submodels = [];
            this._lines = [];
            this.addEventListener(FocusEvent.FOCUS_OUT, myObject.modelFocusEventOutHandler, false, 0, true);
            return;
        }// end function

        override public function getRightPoint(param1:UIComponent) : Point
        {
            var _loc_2:DisplayElement = null;
            var _loc_3:Number = NaN;
            var _loc_4:Number = NaN;
            var _loc_5:Point = null;
            if (this.parentmodel == null || this.parentmodel.isOpen)
            {
                _loc_2 = this.getPointModel(this);
                _loc_3 = 0;
                _loc_4 = 0;
                _loc_3 = _loc_2.width;
                _loc_4 = _loc_2.height / 2;
                _loc_5 = new Point(_loc_3, _loc_4);
                return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
            }
            return this.parentmodel.getRightPoint(param1);
        }// end function

        override public function getBottomPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:Number = 0;
            var _loc_4:Number = 0;
            if (_loc_2.isOpen)
            {
                _loc_3 = _loc_2.getExWidth() / 2;
                _loc_4 = _loc_2.getExHeight();
            }
            else
            {
                _loc_3 = _loc_2.defaultModelWidth / 2;
                _loc_4 = _loc_2.title.textHeight + 10;
            }
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
            var _loc_3:Number = 0;
            if (_loc_2.isOpen)
            {
                _loc_3 = _loc_2.getExWidth() / 2;
            }
            else
            {
                _loc_3 = _loc_2.defaultModelWidth / 2;
            }
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
            var _loc_6:DisplayElement = null;
            var _loc_7:Number = NaN;
            var _loc_8:Number = NaN;
            var _loc_9:MovementConstraint = null;
            super.updateDisplayList(param1, param2);
            if (defaultModelHeight != 0 && defaultModelWidth != 0)
            {
                this.setActualSize(defaultModelWidth, defaultModelHeight);
                param1 = defaultModelWidth;
                param2 = defaultModelHeight;
                defaultModelWidth = 0;
                defaultModelHeight = 0;
            }
            else
            {
                this.setActualSize(param1, param2);
            }
            var _loc_3:* = param1 - 5;
            var _loc_4:* = param2 - 5;
            iconObject.setActualSize(20, 20);
            iconObject.move(8, 2);
            var _loc_5:* = this.measureText(title.text);
            title.setActualSize(_loc_5.width + 5, _loc_5.height + 5);
            title.move(8 + 20 + 5, 2);
            if (this.isOpen)
            {
                if (this.subModels.length > 0)
                {
                    this.container.move(5, 20 + 5);
                    this.container.visible = true;
                    this.grid.reCalculate(this.submodels);
                    _loc_7 = param1 - 5 - 5;
                    _loc_8 = param2 - 5 - 20 - 5;
                    container.setActualSize(_loc_7, _loc_8);
                    _loc_9 = new MovementConstraint();
                    _loc_9.minX = 0;
                    _loc_9.minY = 0;
                    _loc_9.maxX = _loc_7;
                    _loc_9.maxY = _loc_8;
                    this.container.genObjectHandles();
                    this.container.getObjectHandles().addDefaultConstraint(_loc_9);
                }
                this.lineDispatchEvent();
                for each (_loc_6 in this.submodels)
                {
                    
                    this.grid.moveModel(_loc_6);
                    _loc_6.lineDispatchEvent();
                }
                if (this.subModels.length > 0)
                {
                    this.setChildIndex(container, (this.numChildren - 1));
                }
            }
            basicColor = ColorProperty.colorTypeObject[this.typeClass];
            if (this.isDashModel)
            {
                basicLineColor = colorProperty.dashBorderColor;
                com.pactera.edg.am.dmv.view.model.GraphicUtil.turnDashModelColor(basicLineColor, basicColor, this);
            }
            else
            {
                basicLineColor = colorProperty.borderColor;
                com.pactera.edg.am.dmv.view.model.GraphicUtil.turnModelColor(basicLineColor, basicColor, this);
            }
            com.pactera.edg.am.dmv.view.model.GraphicUtil.drawRectOne(this);
            return;
        }// end function

        override public function getLeftPoint(param1:UIComponent) : Point
        {
            var _loc_2:DisplayElement = null;
            var _loc_3:Number = NaN;
            var _loc_4:Number = NaN;
            var _loc_5:Point = null;
            if (this.parentmodel == null || this.parentmodel.isOpen)
            {
                _loc_2 = this.getPointModel(this);
                _loc_3 = 0;
                _loc_4 = 0;
                _loc_3 = 0;
                _loc_4 = _loc_2.height / 2;
                _loc_5 = new Point(_loc_3, _loc_4);
                return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
            }
            return this.parentmodel.getLeftPoint(param1);
        }// end function

        override protected function createChildren() : void
        {
            if (this.title == null)
            {
                title = createTextField();
                title.text = modelName;
                title.setColor(1393291);
                addChild(DisplayObject(title));
            }
            if (iconObject == null)
            {
                iconObject = new Image();
                iconObject.load(systemLevelIcon);
                addChild(iconObject);
            }
            if (this.rectOne == null)
            {
                rectOne = new Sprite();
                rectOne.doubleClickEnabled = true;
                this.addChild(rectOne);
                this.rectOne.addEventListener(MouseEvent.ROLL_OVER, myObject.modelRollOverHandler, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.ROLL_OUT, myObject.modelRollOutHandler, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.ROLL_OVER, myObject.modelDetailInfoRollOverHandler, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.ROLL_OUT, myObject.modelDetailInfoRollOutHandler, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.CLICK, myObject.onClick, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.DOUBLE_CLICK, myObject.onDoubleClick, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.MOUSE_DOWN, myObject.modelMouseDownHandler, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.MOUSE_UP, myObject.modelMouseUpHandler, false, 0, true);
                this.rigthMenu.contructContextMenu();
            }
            if (this.container == null)
            {
                this.container = new ModelContainer();
                this.addChild(container);
                this.container.visible = false;
            }
            return;
        }// end function

        override protected function measure() : void
        {
            super.measure();
            var _loc_1:* = defaultModelHeight == 0 ? (this.getExHeight() + 10) : (defaultModelHeight);
            this.measuredMinHeight = defaultModelHeight == 0 ? (this.getExHeight() + 10) : (defaultModelHeight);
            this.measuredHeight = _loc_1;
            _loc_1 = defaultModelWidth == 0 ? (this.getExWidth() + 10) : (defaultModelWidth);
            this.measuredWidth = defaultModelWidth == 0 ? (this.getExWidth() + 10) : (defaultModelWidth);
            this.measuredMinWidth = _loc_1;
            return;
        }// end function

    }
}
