package com.pactera.edg.am.kpi.view
{
    import flash.geom.*;
    import mx.containers.*;
    import mx.controls.*;
    import mx.events.*;
    import mx.managers.*;

    public class HelpWindow extends TitleWindow
    {
        private var help:Panel;
        private var _titleStr:String = "Help";
        private var _windowModel:Spacer;
        private var _heightNum:Number = 204;
        private var _titleFontSize:Number = 12;
        private var _widthNum:Number = 256;

        public function HelpWindow()
        {
            this.verticalScrollPolicy = "auto";
            this.horizontalScrollPolicy = "auto";
            return;
        }// end function

        public function getWindowPanel() : Panel
        {
            this.addEventListener(CloseEvent.CLOSE, this.closeWindowPanel);
            this.showCloseButton = true;
            this.title = "图例";
            this.width = 500;
            this.height = 360;
            this.layout = "absolute";
            this.rederModel(10, 20, 64154, 0, "分析起始节点");
            this.rederLine(100, 20, 0, "普通连线", 1);
            this.rederModel(10, 60, 6520319, 4673535, "选中节点");
            this.rederLine(100, 60, 16716947, "前置连线", 1);
            this.rederModel(10, 100, 15397366, 13421772, "普通节点");
            this.rederLine(100, 100, 16711680, "后置连线", 1);
            this.rederLine(100, 140, 0, "引用连线", 2);
            this.rederModel(10, 140, 16716947, 14423100, "前置节点");
            this.rederModel(10, 180, 16711680, 524288, "后置节点");
            return this;
        }// end function

        public function set widthNum(param1:Number) : void
        {
            this._widthNum = param1;
            return;
        }// end function

        public function rederModel(param1:Number, param2:Number, param3:uint, param4:uint, param5:String) : void
        {
            var _loc_6:* = new Label();
            _loc_6.text = param5;
            _loc_6.x = param1 + 65;
            _loc_6.y = param2;
            this.addChild(_loc_6);
            var _loc_7:* = new Spacer();
            _loc_7.graphics.clear();
            _loc_7.graphics.lineStyle(1, param4);
            _loc_7.graphics.beginFill(param3);
            _loc_7.graphics.drawRoundRect(param1, param2, 60, 20, 10);
            _loc_7.graphics.endFill();
            this.addChild(_loc_7);
            return;
        }// end function

        public function set titleFontSize(param1:Number) : void
        {
            this._titleFontSize = param1;
            return;
        }// end function

        private function checkIn(param1:Point, param2:Point, param3:Boolean, param4:Boolean) : Boolean
        {
            var _loc_5:* = true;
            if (param3)
            {
                if (param1.x > param2.x)
                {
                    _loc_5 = false;
                }
            }
            else if (param1.x < param2.x)
            {
                _loc_5 = false;
            }
            if (param4)
            {
                if (param1.y > param2.y)
                {
                    _loc_5 = false;
                }
            }
            else if (param1.y < param2.y)
            {
                _loc_5 = false;
            }
            return _loc_5;
        }// end function

        public function freeDraw(param1:Point, param2:Point, param3:Spacer) : void
        {
            var _loc_6:* = NaN;
            if (!param1)
            {
                param1 = new Point(0, 0);
            }
            if (!param2)
            {
                param2 = new Point(0, 0);
            }
            var _loc_4:* = 3;
            var _loc_5:* = 3;
            _loc_6 = Math.atan2(param2.y - param1.y, param2.x - param1.x);
            var _loc_7:* = _loc_4 * Math.cos(_loc_6);
            var _loc_8:* = _loc_4 * Math.sin(_loc_6);
            var _loc_9:* = _loc_5 * Math.cos(_loc_6);
            var _loc_10:* = _loc_5 * Math.sin(_loc_6);
            var _loc_11:* = true;
            var _loc_12:* = true;
            if (param2.x < param1.x)
            {
                _loc_11 = false;
            }
            if (param2.y < param1.y)
            {
                _loc_12 = false;
            }
            var _loc_13:* = new Point(param1.x, param1.y);
            var _loc_14:* = new Point(param2.x, param2.y);
            var _loc_15:* = "solid";
            while (checkIn(_loc_13, param2, _loc_11, _loc_12))
            {
                
                if (_loc_15 == "solid")
                {
                    _loc_14.x = _loc_13.x + _loc_7;
                    _loc_14.y = _loc_13.y + _loc_8;
                    param3.graphics.moveTo(_loc_13.x, _loc_13.y);
                    param3.graphics.lineTo(_loc_14.x, _loc_14.y);
                    _loc_15 = "space";
                }
                else
                {
                    _loc_14.x = _loc_13.x + _loc_9;
                    _loc_14.y = _loc_13.y + _loc_10;
                    param3.graphics.moveTo(_loc_14.x, _loc_14.y);
                    _loc_15 = "solid";
                }
                _loc_13.x = _loc_14.x;
                _loc_13.y = _loc_14.y;
            }
            return;
        }// end function

        public function rederLine(param1:Number, param2:Number, param3:uint, param4:String, param5:Number) : void
        {
            var _loc_8:* = null;
            var _loc_9:* = null;
            var _loc_6:* = new Label();
            _loc_6.text = param4;
            _loc_6.x = param1 + 255;
            _loc_6.y = param2;
            this.addChild(_loc_6);
            var _loc_7:* = new Spacer();
            if (param5 != 1)
            {
                _loc_8 = new Point(param1 + 200, param2 + 10);
                _loc_9 = new Point(param1 + 240, param2 + 10);
                _loc_7.graphics.lineStyle(2, param3);
                this.freeDraw(_loc_8, _loc_9, _loc_7);
            }
            else
            {
                _loc_7.graphics.lineStyle(2, param3);
                _loc_7.graphics.moveTo(param1 + 200, param2 + 10);
                _loc_7.graphics.lineTo(param1 + 240, param2 + 10);
            }
            this.addChild(_loc_7);
            return;
        }// end function

        public function closeWindowPanel(event:CloseEvent) : void
        {
            PopUpManager.removePopUp(this);
            return;
        }// end function

        public function get heightNum() : Number
        {
            return this._heightNum;
        }// end function

        public function get widthNum() : Number
        {
            return this._widthNum;
        }// end function

        public function get titleFontSize() : Number
        {
            return this._titleFontSize;
        }// end function

        public function set titleStr(param1:String) : void
        {
            this._titleStr = param1;
            return;
        }// end function

        public function get titleStr() : String
        {
            return this._titleStr;
        }// end function

        public function set heightNum(param1:Number) : void
        {
            this._heightNum = param1;
            return;
        }// end function

    }
}
