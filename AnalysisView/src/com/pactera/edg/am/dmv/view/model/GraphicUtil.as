package com.pactera.edg.am.dmv.view.model
{
    import flash.display.*;
    import flash.geom.*;
    import mx.core.*;
    import mx.graphics.*;
    import com.pactera.edg.am.dmv.view.model.*;

    public class GraphicUtil extends Object
    {

        public function GraphicUtil()
        {
            return;
        }// end function

        public static function turnDashModelColor(param1:uint, param2:uint, param3:DisplayElement, param4:Number = 1) : void
        {
            var _loc_6:RectangularDropShadow = null;
            var _loc_7:Matrix = null;
            var _loc_8:Array = null;
            var _loc_9:Array = null;
            var _loc_10:Array = null;
            var _loc_5:* = param3.graphics;
            if (param3.graphics != null)
            {
                _loc_5.clear();
                _loc_6 = new RectangularDropShadow();
                _loc_6.distance = 5;
                _loc_6.angle = 35;
                _loc_6.color = param3.colorProperty.shadowColor;
                _loc_6.alpha = 0.2;
                _loc_6.drawShadow(_loc_5, 0, 0, param3.width, param3.height);
                _loc_7 = new Matrix();
                _loc_7.createGradientBox(param3.width, param3.height / 2, Math.PI / 2, 0, 0);
                _loc_8 = [];
                if (param3.mdcode.toUpperCase() == "CDBDP")
                {
                    _loc_8 = param3.colorProperty.odsGradientColors;
                }
                else
                {
                    _loc_8 = param3.colorProperty.gradientColors;
                }
                _loc_9 = [100, 100];
                _loc_10 = [0, 255];
                _loc_5.beginGradientFill(GradientType.LINEAR, _loc_8, _loc_9, _loc_10, _loc_7);
                _loc_5.drawRoundRect(0, 0, param3.width, param3.height, 8);
                _loc_5.endFill();
                _loc_5.lineStyle(param3.borderThickness, param1, 1);
                param3.drawBorder(0, 0, param3.width, param3.height, param3.dashlen, param3.gaplen);
            }
            _loc_5 = null;
            param3 = null;
            return;
        }// end function

        public static function dropDashShadow(param1:uint, param2:uint, param3:DisplayElement) : void
        {
            var _loc_5:RectangularDropShadow = null;
            var _loc_4:* = param3.graphics;
            if (param3.graphics != null)
            {
                _loc_4.clear();
                _loc_5 = new RectangularDropShadow();
                _loc_5.distance = 5;
                _loc_5.angle = 35;
                _loc_5.color = param3.colorProperty.shadowColor;
                _loc_5.alpha = 0.2;
                _loc_5.drawShadow(_loc_4, 0, 0, param3.width, param3.height);
                _loc_4.beginFill(param2);
                _loc_4.drawRoundRect(0, 0, param3.width, param3.height, 8);
                _loc_4.endFill();
                _loc_4.lineStyle(param3.borderThickness, param1, 1);
                param3.drawBorder(0, 0, param3.width, param3.height, param3.dashlen, param3.gaplen);
            }
            _loc_4 = null;
            param3 = null;
            return;
        }// end function

        public static function turnFillColor(param1:uint, param2:UIComponent, param3:Number = 1) : void
        {
            var _loc_4:* = param2.graphics;
            if (param2.graphics != null)
            {
                _loc_4.clear();
                _loc_4.beginFill(param1, param3);
                _loc_4.drawRoundRect(0, 0, param2.width, param2.height, 8);
                _loc_4.endFill();
            }
            _loc_4 = null;
            param2 = null;
            return;
        }// end function

        public static function drawRectOne(param1:DisplayElement, param2:Number = 0.1, param3:Number = 0.1) : void
        {
            param1.rectOne.graphics.clear();
            var _loc_4:* = new ColorProperty();
            param1.rectOne.graphics.lineStyle(0, _loc_4.bgcolor, param2);
            param1.rectOne.graphics.beginFill(_loc_4.bgcolor, param3);
            param1.rectOne.graphics.drawRoundRect(param1.rectX, param1.rectY, param1.width, param1.height, 8);
            param1.rectOne.graphics.endFill();
            param1 = null;
            return;
        }// end function

        public static function turnModelColor(param1:uint, param2:uint, param3:UIComponent, param4:Number = 1) : void
        {
            var _loc_6:RectangularDropShadow = null;
            var _loc_5:* = param3.graphics;
            if (param3.graphics != null)
            {
                _loc_5.clear();
                _loc_6 = new RectangularDropShadow();
                _loc_6.distance = 5;
                _loc_6.angle = 35;
                _loc_6.color = 0;
                _loc_6.alpha = 0.2;
                _loc_6.drawShadow(_loc_5, 0, 0, param3.width, param3.height);
                _loc_5.lineStyle(0.25, param1, 1);
                _loc_5.beginFill(param2, param4);
                _loc_5.drawRoundRect(0, 0, param3.width, param3.height, 8);
                _loc_5.endFill();
            }
            _loc_5 = null;
            param3 = null;
            return;
        }// end function

        public static function turnModelGradientColor(param1:uint, param2:uint, param3:DisplayElement, param4:Number = 1) : void
        {
            var _loc_6:RectangularDropShadow = null;
            var _loc_7:Matrix = null;
            var _loc_8:Array = null;
            var _loc_9:Array = null;
            var _loc_10:Array = null;
            var _loc_5:* = param3.graphics;
            if (param3.graphics != null)
            {
                _loc_5.clear();
                _loc_6 = new RectangularDropShadow();
                _loc_6.distance = 5;
                _loc_6.angle = 35;
                _loc_6.color = param3.colorProperty.shadowColor;
                _loc_6.alpha = 0.3;
                _loc_6.drawShadow(_loc_5, 0, 0, param3.width, param3.height);
                _loc_5.lineStyle(0.25, param1, 1);
                _loc_7 = new Matrix();
                _loc_7.createGradientBox(param3.width, param3.height / 2, Math.PI / 2, 0, 0);
                _loc_8 = [];
                if (param3.mdcode.toUpperCase() == "CDBDP")
                {
                    _loc_8 = param3.colorProperty.odsGradientColors;
                }
                else
                {
                    _loc_8 = param3.colorProperty.gradientColors;
                }
                _loc_9 = [100, 100];
                _loc_10 = [0, 255];
                _loc_5.beginGradientFill(GradientType.LINEAR, _loc_8, _loc_9, _loc_10, _loc_7);
                _loc_5.drawRoundRect(0, 0, param3.width, param3.height, 8);
                _loc_5.endFill();
            }
            _loc_5 = null;
            param3 = null;
            return;
        }// end function

        public static function turnDashModelGradientColor(param1:uint, param2:uint, param3:DisplayElement, param4:Number = 1) : void
        {
            var _loc_6:RectangularDropShadow = null;
            var _loc_7:Matrix = null;
            var _loc_8:Array = null;
            var _loc_9:Array = null;
            var _loc_10:Array = null;
            var _loc_5:* = param3.graphics;
            if (param3.graphics != null)
            {
                _loc_5.clear();
                _loc_6 = new RectangularDropShadow();
                _loc_6.distance = 5;
                _loc_6.angle = 35;
                _loc_6.color = param3.colorProperty.shadowColor;
                _loc_6.alpha = 0.2;
                _loc_6.drawShadow(_loc_5, 0, 0, param3.width, param3.height);
                _loc_7 = new Matrix();
                _loc_7.createGradientBox(param3.width, param3.height / 2, Math.PI / 2, 0, 0);
                _loc_8 = [];
                if (param3.mdcode.toUpperCase() == "CDBDP")
                {
                    _loc_8 = param3.colorProperty.odsGradientColors;
                }
                else
                {
                    _loc_8 = param3.colorProperty.gradientColors;
                }
                _loc_9 = [100, 100];
                _loc_10 = [0, 255];
                _loc_5.beginGradientFill(GradientType.LINEAR, _loc_8, _loc_9, _loc_10, _loc_7);
                _loc_5.drawRoundRect(0, 0, param3.width, param3.height, 8);
                _loc_5.endFill();
                _loc_5.lineStyle(param3.borderThickness, param1, 1);
                param3.drawBorder(0, 0, param3.width, param3.height, param3.dashlen, param3.gaplen);
            }
            _loc_5 = null;
            param3 = null;
            return;
        }// end function

        public static function turnModelTextColor(param1:uint, param2:DisplayElement) : void
        {
            param2.title.setColor(param1);
            param2 = null;
            return;
        }// end function

        public static function turnUIComponentGradientColor(param1:uint, param2:Array, param3:UIComponent, param4:Number = 1) : void
        {
            var _loc_6:Matrix = null;
            var _loc_7:Array = null;
            var _loc_8:Array = null;
            var _loc_5:* = param3.graphics;
            if (param3.graphics != null)
            {
                _loc_5.clear();
                _loc_5.lineStyle(0.25, param1, 1);
                _loc_6 = new Matrix();
                _loc_6.createGradientBox(param3.width, param3.height / 2, Math.PI / 2, 0, 0);
                _loc_7 = [100, 100];
                _loc_8 = [0, 255];
                _loc_5.beginGradientFill(GradientType.LINEAR, param2, _loc_7, _loc_8, _loc_6);
                _loc_5.drawRoundRect(0, 0, param3.width, param3.height, 8);
                _loc_5.endFill();
            }
            _loc_5 = null;
            param3 = null;
            return;
        }// end function

        public static function dropShadow(param1:uint, param2:uint, param3:UIComponent) : void
        {
            var _loc_4:* = param3.graphics;
            var _loc_5:* = new RectangularDropShadow();
            new RectangularDropShadow().distance = 5;
            _loc_5.angle = 35;
            _loc_5.color = 0;
            _loc_5.alpha = 0.2;
            if (_loc_4 != null)
            {
                _loc_4.clear();
                _loc_5.drawShadow(_loc_4, 0, 0, param3.width, param3.height);
                _loc_4.lineStyle(0.25, param1, 1);
                _loc_4.beginFill(param2);
                _loc_4.drawRoundRect(0, 0, param3.width, param3.height, 8);
                _loc_4.endFill();
            }
            _loc_4 = null;
            param3 = null;
            return;
        }// end function

    }
}
