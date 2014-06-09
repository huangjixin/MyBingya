package com.pactera.edg.am.dmv.view.model
{
    import flash.display.*;
    import flash.events.*;
    import flash.geom.*;
    import flash.text.*;
    import mx.controls.*;
    import mx.core.*;
    import mx.managers.*;

    public class BasicModel extends DisplayElement implements IFocusManagerComponent
    {
        private var odsIconObject:Image;
        private static const systemIcon:Class = BasicModel_systemIcon;
        private static const systemOdsIcon:Class = BasicModel_systemOdsIcon;

        public function BasicModel()
        {
            this.addEventListener(FocusEvent.FOCUS_OUT, myObject.modelFocusEventOutHandler);
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
            var _loc_3:* = _loc_2.defaultModelWidth / 2;
            var _loc_4:* = _loc_2.height + 10;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override public function getTopPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = _loc_2.defaultModelWidth / 2;
            var _loc_4:Number = 0;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            this.isOpen = true;
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
            GraphicUtil.drawRectOne(this);
            var _loc_3:* = this.measureText(title.text);
            title.setActualSize(_loc_3.width + 5, _loc_3.height + 5);
            var _loc_4:* = Math.round((param2 - _loc_3.height - 5) / 2);
            var _loc_5:Number = 15;
            if (this.mdcode.toUpperCase() == "CDBDP")
            {
                iconObject.visible = false;
                iconObject.includeInLayout = false;
                _loc_5 = 32;
                odsIconObject.setActualSize(_loc_5, _loc_5);
                odsIconObject.move(8, (param2 - _loc_5) / 2);
            }
            else
            {
                odsIconObject.visible = false;
                odsIconObject.includeInLayout = false;
                iconObject.setActualSize(_loc_5, _loc_5);
                iconObject.move(8, (param2 - _loc_5) / 2);
            }
            title.move(8 + _loc_5 + 5, _loc_4);
            this.rectOne.x = 0;
            this.rectOne.y = 0;
            this.lineDispatchEvent();
            basicColor = ColorProperty.colorTypeObject[this.typeClass];
            if (this.isDashModel)
            {
                basicLineColor = colorProperty.dashBorderColor;
                GraphicUtil.turnDashModelGradientColor(basicLineColor, basicColor, this);
            }
            else
            {
                basicLineColor = colorProperty.borderColor;
                GraphicUtil.turnModelGradientColor(basicLineColor, basicColor, this);
            }
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
            super.createChildren();
            if (this.title == null)
            {
                title = createTextField();
                title.text = modelName;
                title.setColor(this.colorProperty.fontcolor);
                addChild(DisplayObject(title));
            }
            if (iconObject == null)
            {
                iconObject = new Image();
                iconObject.load(systemIcon);
                addChild(iconObject);
            }
            if (odsIconObject == null)
            {
                odsIconObject = new Image();
                odsIconObject.load(systemOdsIcon);
                addChild(odsIconObject);
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
