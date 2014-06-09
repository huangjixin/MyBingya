package com.pactera.edg.am.view.model
{
    import flash.display.*;
    import mx.core.*;
    import mx.graphics.*;

    public class GraphicUtil extends Object
    {

        public function GraphicUtil()
        {
            return;
        }// end function

		private static const defaultColorProperty:ColorProperty=new ColorProperty();
        public static function parentColor(param1:uint, param2:uint, param3:DisplayElement, param4:uint) : void
        {
            if (param3.parentmodel != null)
            {
                if (param3.parentmodel.bisAnalysicModel)
                {
                    param2 = defaultColorProperty.analysisModelSecondColor;
                }
                else
                {
                    param2 = param3.defineColor;
                }
                turnModelColor(param1, param2, param3.parentmodel);
                parentColor(param1, param2, param3.parentmodel, param4);
                turnModelTextColor(param4, param3.parentmodel);
            }
            return;
        }// end function

        public static function turnLineColor(param1:uint, param2:UIComponent) : void
        {
            var _loc_3:* = param2.graphics;
            if (_loc_3 != null)
            {
                _loc_3.clear();
                _loc_3.lineStyle(0.25, param1, 1);
            }
            param2 = null;
            _loc_3 = null;
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
            param2 = null;
            _loc_4 = null;
            return;
        }// end function

        public static function turnModelTextBgColor(param1:uint, param2:uint, param3:UIComponent) : void
        {
            var _loc_6:DisplayElement = null;
            var _loc_4:* = param3.graphics;
            var _loc_5:* = new RectangularDropShadow();
            new RectangularDropShadow().distance = 5;
            _loc_5.angle = 35;
            _loc_5.color = 0;
            _loc_5.alpha = 0.4;
            if (_loc_4 != null)
            {
                _loc_6 = param3 as DisplayElement;
                _loc_4.clear();
                _loc_5.drawShadow(_loc_4, _loc_6.title.x, _loc_6.title.y, param3.width, 20);
                _loc_4.beginFill(param2);
                _loc_4.drawRoundRect(_loc_6.title.x, _loc_6.title.y, param3.width, 20, 8);
                _loc_4.endFill();
            }
            _loc_4 = null;
            return;
        }// end function

        public static function turnModelColor(lineColor:uint, fillColor:uint, param3:UIComponent, param4:Number = 1) : void
        {
            var _loc_5:* = param3.graphics;
            if (param3.graphics != null)
            {
                _loc_5.clear();
                _loc_5.lineStyle(0.25, lineColor, 1);
                _loc_5.beginFill(fillColor, param4);
                _loc_5.drawRoundRect(0, 0, param3.width, param3.height, 8);
                _loc_5.endFill();
            }
            _loc_5 = null;
            return;
        }// end function

        public static function turnModelTextColor(param1:uint, param2:DisplayElement) : void
        {
            var fontColor:* = param1;
            var model:* = param2;
            try
            {
                model.title.setColor(fontColor);
                model;
            }
            catch (e:Error)
            {
            }
            return;
        }// end function

        public static function dropTextShadow(param1:uint, param2:uint, param3:Sprite) : void
        {
            var _loc_4:* = param3.graphics;
            var _loc_5:* = new RectangularDropShadow();
            new RectangularDropShadow().distance = 5;
            _loc_5.angle = 35;
            _loc_5.color = 0;
            _loc_5.alpha = 0.4;
            _loc_5.drawShadow(_loc_4, 0, 0, param3.width, param3.height);
            return;
        }// end function

        public static function turnModelsColor(param1:uint, param2:uint, param3:Array, param4:Number = 1) : void
        {
            var _loc_6:UIComponent = null;
            var _loc_5:Graphics = null;
            for each (_loc_6 in param3)
            {
                
                _loc_5 = _loc_6.graphics;
                if (_loc_5 != null)
                {
                    _loc_5.clear();
                    _loc_5.lineStyle(0.25, param1, 1);
                    _loc_5.beginFill(param2, param4);
                    _loc_5.drawRoundRect(0, 0, _loc_6.width, _loc_6.height, 8);
                    _loc_5.endFill();
                }
                _loc_5 = null;
            }
            return;
        }// end function

        public static function drawRectOne(param1:DisplayElement, param2:Number = 0.1, param3:Number = 0.1) : void
        {
            param1.rectOne.graphics.clear();
            param1.rectOne.graphics.lineStyle(0, param1.colorProperty.bgcolor, param2);
            param1.rectOne.graphics.beginFill(param1.colorProperty.bgcolor, param3);
            param1.rectOne.graphics.drawRoundRect(0, 0, param1.width, param1.height, 10);
            param1.rectOne.graphics.endFill();
            param1 = null;
            return;
        }// end function

        public static function dropShadow(param1:uint, param2:uint, param3:UIComponent) : void
        {
            var _loc_4:* = param3.graphics;
            var _loc_5:* = new RectangularDropShadow();
            new RectangularDropShadow().distance = 5;
            _loc_5.angle = 35;
            _loc_5.color = 0;
            _loc_5.alpha = 0.4;
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
