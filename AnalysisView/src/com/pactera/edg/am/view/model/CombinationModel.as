package com.pactera.edg.am.view.model
{
    import com.pactera.edg.am.view.*;
    import com.roguedevelopment.objecthandles.constraints.*;
    import flash.display.*;
    import flash.events.*;
    import flash.geom.*;
    import flash.system.*;
    import mx.controls.*;
    import mx.core.*;
    import mx.managers.*;

    public class CombinationModel extends DisplayElement implements IFocusManagerComponent
    {
        private static const defaultIcon1:Class = CombinationModel_defaultIcon1;

        public function CombinationModel()
        {
            this.submodels = [];
            this._lines = [];
            this.addEventListener(FocusEvent.FOCUS_OUT, myObject.focusEventOutHandler, false, 0, true);
            return;
        }// end function

        override public function getRightPoint(param1:UIComponent) : Point
        {
            var _loc_2:DisplayElement = null;
            var px:Number = NaN;
            var py:Number = NaN;
            var _loc_5:Point = null;
            //trace(this.mdname);
            if (this.parentmodel == null || this.parentmodel.isOpen)
            {
                _loc_2 = this.getPointModel(this);
                px = 0;
                py = 0;
                if (_loc_2.parentmodel == null)
                {
                    px = _loc_2.getExWidth();
                }
                else
                {
                    px = _loc_2.parentmodel.grid.getColMaxWidth(_loc_2.colNumber);
                }
                py = (_loc_2.title.textHeight + 10) / 2;
                _loc_5 = new Point(px, py);
                return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
            }
            else
            {
                //trace(this.parentmodel.mdname);
                return this.parentmodel.getRightPoint(param1);
            }
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
            var _loc_3:Number = 0;
            _loc_3 = _loc_2.getExWidth() / 2;
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
            var _loc_10:DisplayElement = null;
            super.updateDisplayList(param1, param2);
            var _loc_3:Number = 0;
            if (this.parentmodel == null)
            {
                _loc_3 = getExWidth();
            }
            else
            {
                _loc_3 = this.parentmodel.grid.getColMaxWidth(this.colNumber);
            }
            var _loc_4:* = this.getExHeight();
            this.setActualSize(_loc_3, _loc_4);
            this.setChildIndex(iconObject, (this.numChildren - 1));
            var _loc_5:* = checkParentStat(this);
            this.container.model = this;
            if (this.isOpen)
            {
                if (this.subModels.length > 0)
                {
                    this.container.visible = true;
                    for each (_loc_6 in this.submodels)
                    {
                        
                        if (this.container.contains(_loc_6))
                        {
                            continue;
                        }
                        this.container.addChild(_loc_6);
                    }
                    this.container.move(5, this._title.textHeight + 10);
                    _loc_7 = _loc_3 - 5 - 5;
                    _loc_8 = _loc_4 - 10 - this._title.textHeight - 5;
                    this.container.setActualSize(_loc_7, _loc_8);
                    _loc_9 = new MovementConstraint();
                    _loc_9.minX = 15;
                    _loc_9.minY = 0;
                    _loc_9.maxX = _loc_7 - 30;
                    _loc_9.maxY = _loc_8;
                    this.container.getObjectHandles().addDefaultConstraint(_loc_9);
                    System.gc();
                }
                iconObject.load(DisplayElement.defaultCloseIcon);
                if (_loc_5)
                {
                    this.linesDispatchEvent();
                    for each (_loc_10 in this.submodels)
                    {
                        
                        this.grid.moveModel(_loc_10);
                        _loc_10.linesDispatchEvent();
                    }
                }
                else
                {
                    operModelLines(this);
                    for each (_loc_10 in this.submodels)
                    {
                        
                        operModelLines(_loc_10);
                    }
                }
            }
            else
            {
                iconObject.load(defaultIcon);
                this.container.visible = false;
                if (_loc_5)
                {
                    this.linesDispatchEvent();
                    for each (_loc_10 in this.submodels)
                    {
                        
                        operModelLines(_loc_10);
                    }
                }
                else
                {
                    operModelLines(this);
                }
            }
            if (this.bisAnalysicModel)
            {
                basicColor = colorProperty.analysisModelSecondColor;
            }
            else
            {
                basicColor = this.defineColor;
            }
            iconObject.setActualSize(15, 15);
            iconObject.move(10, 6);
            iconObject1.setActualSize(15, 15);
            iconObject1.move(10 + 15 + 5, 6);
            title.move(10 + 15 + 15 + 5 + 5, 6);
            title.setActualSize(title.textWidth + 5, title.textHeight + 5);
            basicLineColor = this.colorProperty.linecolor;
            GraphicUtil.turnModelColor(basicLineColor, basicColor, this);
            GraphicUtil.drawRectOne(this);
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
                _loc_4 = (_loc_2.title.textHeight + 10) / 2;
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
                if (this.modelName.length > 20)
                {
                    this.title.text = this.modelName.substr(0, 19) + "...";
                }
                else
                {
                    this.title.text = modelName;
                }
                addChild(DisplayObject(title));
            }
            if (iconObject1 == null)
            {
                iconObject1 = new Image();
                if (this.icon == "" || this.icon == null)
                {
                    iconObject.load(defaultIcon1);
                }
                else
                {
                    iconObject1.load(this.icon);
                }
                addChild(iconObject1);
            }
            if (iconObject == null)
            {
                iconObject = new Image();
                addChild(iconObject);
                iconObject.addEventListener(MouseEvent.CLICK, myObject.imageClick, false, 0, true);
            }
            if (this.rectOne == null)
            {
                rectOne = new Sprite();
                this.addChild(rectOne);
                this.rectOne.addEventListener(MouseEvent.ROLL_OVER, myObject.modelRollOverHandler, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.ROLL_OUT, myObject.modelRollOutHandler, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.CLICK, myObject.modelClickHandler, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.ROLL_OVER, myObject.modelDetailInfoRollOverHandler, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.ROLL_OUT, myObject.modelDetailInfoRollOutHandler, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.MOUSE_DOWN, myObject.modelMouseDownHandler, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.MOUSE_UP, myObject.modelMouseUpHandler, false, 0, true);
                this.showContextMenu();
            }
            if (this.container == null)
            {
                this.container = new ModelContainer();
                this.container.visible = false;
                this.addChild(container);
            }
            return;
        }// end function

        override protected function measure() : void
        {
            super.measure();
            var exHeight:* = getExHeight();
            this.measuredHeight = getExHeight();
            this.measuredMinHeight = exHeight;
            var exWidth:* = getExWidth();
            this.measuredWidth = getExWidth();
            this.measuredMinWidth = exWidth;
            return;
        }// end function

    }
}
