package com.pactera.edg.am.kpi.view.model
{
    import com.pactera.edg.am.kpi.rightClick.*;
    import flash.display.*;
    import flash.events.*;
    import flash.geom.*;
    import mx.controls.*;
    import mx.core.*;
    import mx.managers.*;

    public class CombinationModel extends DisplayElement implements IFocusManagerComponent
    {
        private static const defaultIcon:Class = CombinationModel_defaultIcon;

        public function CombinationModel()
        {
            this.submodels = [];
            this._lines = [];
            return;
        }// end function

        public function addModel(param1:DisplayElement) : void
        {
            this.subModels.push(param1);
            this._container.addChild(param1);
            return;
        }// end function

        override public function getRightPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = 0;
            if (_loc_2.isOpen)
            {
                _loc_3 = _loc_2.getExWidth();
            }
            else
            {
                _loc_3 = _loc_2.defaultModelWidth;
            }
            var _loc_4:* = (_loc_2.title.textHeight + 10) / 2;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            var _loc_6:* = param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
            return _loc_6;
        }// end function

        override public function getBottomPoint(param1:UIComponent) : Point
        {
            var _loc_4:* = NaN;
            var _loc_5:* = null;
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = 0;
            if (_loc_2.isOpen)
            {
                _loc_3 = _loc_2.getExWidth() / 2;
                _loc_4 = _loc_2.getDefaultHeight();
                _loc_5 = new Point(_loc_3, _loc_4);
            }
            else
            {
                _loc_3 = _loc_2.defaultModelWidth / 2;
                _loc_4 = _loc_2.title.textHeight + 10;
                _loc_5 = new Point(_loc_3, _loc_4);
            }
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override public function getTopPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = 0;
            if (_loc_2.isOpen)
            {
                _loc_3 = _loc_2.getExWidth() / 2;
            }
            else
            {
                _loc_3 = _loc_2.defaultModelWidth / 2;
            }
            var _loc_4:* = 0;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            var _loc_3:* = null;
            super.updateDisplayList(param1, param2);
            if (this.factory.getViewMapping().isImage)
            {
                if (!this.isOpen)
                {
                    if (this.parentmodel == null)
                    {
                        this._title.move(this.iconObject.width + 5, 40);
                    }
                    else
                    {
                        this._title.move(this.iconObject.width + 5, 5);
                    }
                }
                else
                {
                    this._title.move(this.iconObject.width + 5, 5);
                }
            }
            else
            {
                this._title.move(this.iconObject.width + 5, 5);
            }
			
			
			var txtRect:* = this.measureText(title.text);
			title.setActualSize(txtRect.width + 5, txtRect.height + 5);
			
            this._iconObject.x = 5;
            this._iconObject.y = 5;
            this.graphics.clear();
            this.buildRectOne();
            this.container.move(0, this._title.textHeight + 10);
            this.lineDispatchEvent();
            for each (_loc_3 in this.submodels)
            {
                
                this.grid.moveModel(_loc_3);
                _loc_3.lineDispatchEvent();
            }
            this._rectOne.addEventListener(MouseEvent.CLICK, this.mouseClickHandler);
            this.addEventListener(FocusEvent.FOCUS_OUT, this.focusEventOutHandler);
            this._rectOne.addEventListener(MouseEvent.MOUSE_OUT, this.mouseOutHandler);
            this._rectOne.addEventListener(MouseEvent.MOUSE_OVER, this.mouseOverHandler);
            this._rectOne.addEventListener(MouseEvent.MOUSE_MOVE, this.mouseMoveHandler);
            this._rectOne.addEventListener(MouseEvent.MOUSE_DOWN, this.mouseDownHandler);
            this._rectOne.addEventListener(MouseEvent.DOUBLE_CLICK, this.mouseDoubleClickHandler);
            if (this.menubarXML != null)
            {
                RightClickHandles.getInstance().setHandleFunction(this._rectOne, this, this.menubarXML);
            }
            this.container.setActualSize(this.grid.getMaxWidth(), this.grid.getMaxHeigth());
            this.setChildIndex(this._iconObject, 0);
            this.invalidateDisplayList();
            this.invalidateSize();
            return;
        }// end function

        override public function getLeftPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = 0;
            var _loc_4:* = (_loc_2.title.textHeight + 10) / 2;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override protected function createChildren() : void
        {
            var _loc_1:* = null;
            super.createChildren();
            this._iconObject = new Image();
            this._iconObject.width = 15;
            this._iconObject.height = 15;
            this._iconObject.load(this.icon);
            this.addChild(this._iconObject);
            this._container.visible = false;
            this.addChild(this._container);
            if (this.factory.getViewMapping().isImage)
            {
                if (!this.isOpen)
                {
                    this._iconObject.visible = false;
                }
            }
            for each (_loc_1 in this.submodels)
            {
                
                this._container.addChild(_loc_1);
            }
            this._title = createTextField();
            this._title.text = this.modelName;
            if (this.factory.getViewMapping().isImage)
            {
                if (!this.isOpen)
                {
                    if (this.parentmodel == null)
                    {
                        if (this._image == null)
                        {
                            this._image = new Image();
                        }
                        this._image.width = 40;
                        this._image.height = 40;
                        this._image.x = (this._title.width + 10) / 2 - 20;
                        this._image.load(this.imageIcon);
                        this.addChild(this._image);
                        this._container.visible = false;
                        this.addChild(this._container);
                    }
                }
            }
            this._title.height = this.defaultModelHeight;
            this._title.width = this.defaultModelWidth;
            this.addChild(DisplayObject(this._title));
            this.grid.reCalculate(this.submodels);
            this._container.setActualSize(this.grid.getMaxWidth(), this.grid.getMaxHeigth());
            this.setActualSize(Math.max(this._container.width, this._title.textWidth + this._iconObject.width + 20, this._title.textHeight + 10), this._container.height + this.title.height + 10);
            this.invalidateSize();
            this.invalidateDisplayList();
            return;
        }// end function

        override protected function measure() : void
        {
            super.measure();
            this.measuredWidth = this.getExWidth();
            this.measuredHeight = this.getExHeight();
            return;
        }// end function

    }
}
