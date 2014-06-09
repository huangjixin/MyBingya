package com.pactera.edg.am.kpi.view.line
{
    import flash.geom.*;
    import mx.core.*;

    public class Style extends UIComponent
    {
        private var _fromstyle:int = 0;
        private var _tostyle:int = 0;
        private var _style:int = 0;
        private var _linestyle:int = 0;

        public function Style()
        {
            return;
        }// end function

        public function arrowDrawStartUD(param1:Point, param2:Point, param3:Line) : void
        {
            var _loc_4:* = param1.x;
            var _loc_5:* = param1.y;
            var _loc_6:* = param2.x;
            var _loc_7:* = param2.y;
            if (_loc_7 >= _loc_5)
            {
                param3.graphics.moveTo(Math.abs(_loc_4), Math.abs(_loc_5));
                param3.graphics.lineTo(Math.abs(_loc_4) + 5, Math.abs(_loc_5) + 5);
                param3.graphics.moveTo(Math.abs(_loc_4), Math.abs(_loc_5));
                param3.graphics.lineTo(Math.abs(_loc_4) - 5, Math.abs(_loc_5) + 5);
            }
            else if (_loc_7 < _loc_5)
            {
                param3.graphics.moveTo(Math.abs(_loc_4), Math.abs(_loc_5));
                param3.graphics.lineTo(Math.abs(_loc_4) + 5, Math.abs(_loc_5) - 5);
                param3.graphics.moveTo(Math.abs(_loc_4), Math.abs(_loc_5));
                param3.graphics.lineTo(Math.abs(_loc_4) - 5, Math.abs(_loc_5) - 5);
            }
            return;
        }// end function

        public function get fromstyle() : int
        {
            return this._fromstyle;
        }// end function

        public function arrowDrawEndUD(param1:Point, param2:Point, param3:Line) : void
        {
            var _loc_4:* = param1.x;
            var _loc_5:* = param1.y;
            var _loc_6:* = param2.x;
            var _loc_7:* = param2.y;
            if (_loc_7 >= _loc_5)
            {
                param3.graphics.moveTo(Math.abs(_loc_6), Math.abs(_loc_7));
                param3.graphics.lineTo(Math.abs(_loc_6) + 5, Math.abs(_loc_7) - 5);
                param3.graphics.moveTo(Math.abs(_loc_6), Math.abs(_loc_7));
                param3.graphics.lineTo(Math.abs(_loc_6) - 5, Math.abs(_loc_7) - 5);
            }
            else if (_loc_7 < _loc_5)
            {
                param3.graphics.moveTo(Math.abs(_loc_6), Math.abs(_loc_7));
                param3.graphics.lineTo(Math.abs(_loc_6) + 5, Math.abs(_loc_7) + 5);
                param3.graphics.moveTo(Math.abs(_loc_6), Math.abs(_loc_7));
                param3.graphics.lineTo(Math.abs(_loc_6) - 5, Math.abs(_loc_7) + 5);
            }
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

        public function set fromstyle(param1:int) : void
        {
            this._fromstyle = param1;
            return;
        }// end function

        public function simpleEndLR(param1:Point, param2:Point, param3:Line) : void
        {
            var _loc_4:* = param1.x;
            var _loc_5:* = param1.y;
            var _loc_6:* = param2.x;
            var _loc_7:* = param2.y;
            if (_loc_6 >= _loc_4)
            {
                param3.graphics.moveTo(Math.abs(_loc_6) - 5, Math.abs(_loc_7) + 5);
                param3.graphics.lineTo(Math.abs(_loc_6) - 5, Math.abs(_loc_7) - 5);
            }
            else if (_loc_6 < _loc_4)
            {
                param3.graphics.moveTo(Math.abs(_loc_6) + 5, Math.abs(_loc_7) + 5);
                param3.graphics.lineTo(Math.abs(_loc_6) + 5, Math.abs(_loc_7) - 5);
            }
            return;
        }// end function

        public function complexEndLR(param1:Point, param2:Point, param3:Line) : void
        {
            var _loc_4:* = param1.x;
            var _loc_5:* = param1.y;
            var _loc_6:* = param2.x;
            var _loc_7:* = param2.y;
            if (_loc_6 >= _loc_4)
            {
                param3.graphics.moveTo(Math.abs(_loc_6) - 5, Math.abs(_loc_7));
                param3.graphics.lineTo(Math.abs(_loc_6), Math.abs(_loc_7) + 5);
                param3.graphics.moveTo(Math.abs(_loc_6) - 5, Math.abs(_loc_7));
                param3.graphics.lineTo(Math.abs(_loc_6), Math.abs(_loc_7) - 5);
                param3.graphics.moveTo(Math.abs(_loc_6) - 5, Math.abs(_loc_7) + 5);
                param3.graphics.lineTo(Math.abs(_loc_6) - 5, Math.abs(_loc_7) - 5);
                param3.graphics.drawCircle(Math.abs(_loc_6) - 7, Math.abs(_loc_7), 2);
            }
            else if (_loc_6 < _loc_4)
            {
                param3.graphics.moveTo(Math.abs(_loc_6) + 5, Math.abs(_loc_7));
                param3.graphics.lineTo(Math.abs(_loc_6), Math.abs(_loc_7) + 5);
                param3.graphics.moveTo(Math.abs(_loc_6) + 5, Math.abs(_loc_7));
                param3.graphics.lineTo(Math.abs(_loc_6), Math.abs(_loc_7) - 5);
                param3.graphics.moveTo(Math.abs(_loc_6) + 5, Math.abs(_loc_7) + 5);
                param3.graphics.lineTo(Math.abs(_loc_6) + 5, Math.abs(_loc_7) - 5);
                param3.graphics.drawCircle(Math.abs(_loc_6) + 5, Math.abs(_loc_7), 2);
            }
            return;
        }// end function

        public function simpleStartLR(param1:Point, param2:Point, param3:Line) : void
        {
            var _loc_4:* = param1.x;
            var _loc_5:* = param1.y;
            var _loc_6:* = param2.x;
            var _loc_7:* = param2.y;
            if (_loc_6 >= _loc_4)
            {
                param3.graphics.moveTo(Math.abs(_loc_4) + 5, Math.abs(_loc_5) + 5);
                param3.graphics.lineTo(Math.abs(_loc_4) + 5, Math.abs(_loc_5) - 5);
            }
            else if (_loc_6 < _loc_4)
            {
                param3.graphics.moveTo(Math.abs(_loc_4) - 5, Math.abs(_loc_5) + 5);
                param3.graphics.lineTo(Math.abs(_loc_4) - 5, Math.abs(_loc_5) - 5);
            }
            return;
        }// end function

        public function complexStartLR(param1:Point, param2:Point, param3:Line) : void
        {
            var _loc_4:* = param1.x;
            var _loc_5:* = param1.y;
            var _loc_6:* = param2.x;
            var _loc_7:* = param2.y;
            if (_loc_6 >= _loc_4)
            {
                param3.graphics.moveTo(Math.abs(_loc_4) + 5, Math.abs(_loc_5));
                param3.graphics.lineTo(Math.abs(_loc_4), Math.abs(_loc_5) + 5);
                param3.graphics.moveTo(Math.abs(_loc_4) + 5, Math.abs(_loc_5));
                param3.graphics.lineTo(Math.abs(_loc_4), Math.abs(_loc_5) - 5);
                param3.graphics.moveTo(Math.abs(_loc_4) + 5, Math.abs(_loc_5) + 5);
                param3.graphics.lineTo(Math.abs(_loc_4) + 5, Math.abs(_loc_5) - 5);
                param3.graphics.drawCircle(Math.abs(_loc_4) + 7, Math.abs(_loc_5), 2);
            }
            else if (_loc_6 < _loc_4)
            {
                param3.graphics.moveTo(Math.abs(_loc_4) - 5, Math.abs(_loc_5));
                param3.graphics.lineTo(Math.abs(_loc_4), Math.abs(_loc_5) + 5);
                param3.graphics.moveTo(Math.abs(_loc_4) - 5, Math.abs(_loc_5));
                param3.graphics.lineTo(Math.abs(_loc_4), Math.abs(_loc_5) - 5);
                param3.graphics.moveTo(Math.abs(_loc_4) - 5, Math.abs(_loc_5) + 5);
                param3.graphics.lineTo(Math.abs(_loc_4) - 5, Math.abs(_loc_5) - 5);
                param3.graphics.drawCircle(Math.abs(_loc_4) - 7, Math.abs(_loc_5), 2);
            }
            return;
        }// end function

        public function complexEndUD(param1:Point, param2:Point, param3:Line) : void
        {
            var _loc_4:* = param1.x;
            var _loc_5:* = param1.y;
            var _loc_6:* = param2.x;
            var _loc_7:* = param2.y;
            if (_loc_7 >= _loc_5)
            {
                param3.graphics.moveTo(Math.abs(_loc_6) - 5, Math.abs(_loc_7));
                param3.graphics.lineTo(Math.abs(_loc_6), Math.abs(_loc_7) - 5);
                param3.graphics.moveTo(Math.abs(_loc_6) + 5, Math.abs(_loc_7));
                param3.graphics.lineTo(Math.abs(_loc_6), Math.abs(_loc_7) - 5);
                param3.graphics.moveTo(Math.abs(_loc_6) + 5, Math.abs(_loc_7) - 5);
                param3.graphics.lineTo(Math.abs(_loc_6) - 5, Math.abs(_loc_7) - 5);
                param3.graphics.drawCircle(Math.abs(_loc_6), Math.abs(_loc_7) - 7, 2);
            }
            else if (_loc_7 < _loc_5)
            {
                param3.graphics.moveTo(Math.abs(_loc_6) - 5, Math.abs(_loc_7));
                param3.graphics.lineTo(Math.abs(_loc_6), Math.abs(_loc_7) + 5);
                param3.graphics.moveTo(Math.abs(_loc_6) + 5, Math.abs(_loc_7));
                param3.graphics.lineTo(Math.abs(_loc_6), Math.abs(_loc_7) + 5);
                param3.graphics.moveTo(Math.abs(_loc_6) + 5, Math.abs(_loc_7) + 5);
                param3.graphics.lineTo(Math.abs(_loc_6) - 5, Math.abs(_loc_7) + 5);
                param3.graphics.drawCircle(Math.abs(_loc_6), Math.abs(_loc_7) + 7, 2);
            }
            return;
        }// end function

        public function get tostyle() : int
        {
            return this._tostyle;
        }// end function

        public function paint(param1:Line, param2:Point, param3:Point, param4:int) : void
        {
            param1.graphics.clear();
            param1.graphics.lineStyle(param1.lineB, param1.lineColor);
            var _loc_5:* = param2.x;
            var _loc_6:* = param2.y;
            var _loc_7:* = param3.x;
            var _loc_8:* = param3.y;
            var _loc_9:* = new Point();
            var _loc_10:* = new Point();
            if (this.style == 0)
            {
                param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                param1.graphics.lineTo(Math.abs(_loc_7), Math.abs(_loc_8));
            }
            else if (this.style == 1)
            {
                if (param4 == 0)
                {
                    switch(this.fromstyle)
                    {
                        case 1:
                        {
                            this.arrowDrawStartUD(param2, param3, param1);
                            break;
                        }
                        case 2:
                        {
                            this.simpleStartUD(param2, param3, param1);
                            break;
                        }
                        case 3:
                        {
                            this.complexStartUD(param2, param3, param1);
                            break;
                        }
                        default:
                        {
                            break;
                        }
                    }
                    if (Math.abs(_loc_5) - Math.abs(_loc_7) < 10 && Math.abs(_loc_5) - Math.abs(_loc_7) > -10)
                    {
                        if (this.linestyle == 0)
                        {
                            this.freeDraw(param2, param3, param1);
                        }
                        else
                        {
                            param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                            param1.graphics.lineTo(Math.abs(_loc_7), Math.abs(_loc_8));
                        }
                    }
                    else if (Math.abs(_loc_5) - Math.abs(_loc_7) >= 10)
                    {
                        if (this.linestyle == 0)
                        {
                            if (_loc_8 >= _loc_6)
                            {
                                param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                                _loc_10.x = _loc_5;
                                _loc_10.y = _loc_8 - 20;
                                this.freeDraw(param2, _loc_10, param1);
                                param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_8) - 20);
                                param1.graphics.curveTo(Math.abs(_loc_5), Math.abs(_loc_8) - 10, Math.abs(_loc_5) - 10, Math.abs(_loc_8) - 10);
                                _loc_9.x = _loc_5 - 10;
                                _loc_9.y = _loc_8 - 10;
                                _loc_10.x = _loc_7 + 10;
                                _loc_10.y = _loc_8 - 10;
                                this.freeDraw(_loc_9, _loc_10, param1);
                                param1.graphics.moveTo(Math.abs(_loc_7) + 10, Math.abs(_loc_8) - 10);
                                param1.graphics.curveTo(Math.abs(_loc_7), Math.abs(_loc_8) - 10, Math.abs(_loc_7), Math.abs(_loc_8));
                            }
                            else if (_loc_8 < _loc_6)
                            {
                                param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                                _loc_10.x = _loc_5;
                                _loc_10.y = _loc_8 + 20;
                                this.freeDraw(param2, _loc_10, param1);
                                param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_8) + 20);
                                param1.graphics.curveTo(Math.abs(_loc_5), Math.abs(_loc_8) + 10, Math.abs(_loc_5) - 10, Math.abs(_loc_8) + 10);
                                _loc_9.x = _loc_5 - 10;
                                _loc_9.y = _loc_8 + 10;
                                _loc_10.x = _loc_7 + 10;
                                _loc_10.y = _loc_8 + 10;
                                this.freeDraw(_loc_9, _loc_10, param1);
                                param1.graphics.moveTo(Math.abs(_loc_7) + 10, Math.abs(_loc_8) + 10);
                                param1.graphics.curveTo(Math.abs(_loc_7), Math.abs(_loc_8) + 10, Math.abs(_loc_7), Math.abs(_loc_8));
                            }
                        }
                        else if (_loc_8 >= _loc_6)
                        {
                            param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                            param1.graphics.lineTo(Math.abs(_loc_5), Math.abs(_loc_8) - 20);
                            param1.graphics.curveTo(Math.abs(_loc_5), Math.abs(_loc_8) - 10, Math.abs(_loc_5) - 10, Math.abs(_loc_8) - 10);
                            param1.graphics.lineTo(Math.abs(_loc_7) + 10, Math.abs(_loc_8) - 10);
                            param1.graphics.curveTo(Math.abs(_loc_7), Math.abs(_loc_8) - 10, Math.abs(_loc_7), Math.abs(_loc_8));
                        }
                        else if (_loc_8 < _loc_6)
                        {
                            param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                            param1.graphics.lineTo(Math.abs(_loc_5), Math.abs(_loc_8) + 20);
                            param1.graphics.curveTo(Math.abs(_loc_5), Math.abs(_loc_8) + 10, Math.abs(_loc_5) - 10, Math.abs(_loc_8) + 10);
                            param1.graphics.lineTo(Math.abs(_loc_7) + 10, Math.abs(_loc_8) + 10);
                            param1.graphics.curveTo(Math.abs(_loc_7), Math.abs(_loc_8) + 10, Math.abs(_loc_7), Math.abs(_loc_8));
                        }
                    }
                    else if (Math.abs(_loc_5) - Math.abs(_loc_7) <= -10)
                    {
                        if (this.linestyle == 0)
                        {
                            if (_loc_8 >= _loc_6)
                            {
                                param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                                param1.graphics.curveTo(Math.abs(_loc_5), Math.abs(_loc_6) + 10, Math.abs(_loc_5) + 10, Math.abs(_loc_6) + 10);
                                _loc_9.x = _loc_5 + 10;
                                _loc_9.y = _loc_6 + 10;
                                _loc_10.x = _loc_7 - 10;
                                _loc_10.y = _loc_6 + 10;
                                this.freeDraw(_loc_9, _loc_10, param1);
                                param1.graphics.moveTo(Math.abs(_loc_7) - 10, Math.abs(_loc_6) + 10);
                                param1.graphics.curveTo(Math.abs(_loc_7), Math.abs(_loc_6) + 10, Math.abs(_loc_7), Math.abs(_loc_6) + 20);
                                _loc_9.x = _loc_7;
                                _loc_9.y = _loc_6 + 20;
                                this.freeDraw(_loc_9, param3, param1);
                            }
                            else if (_loc_8 < _loc_6)
                            {
                                param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                                param1.graphics.curveTo(Math.abs(_loc_5), Math.abs(_loc_6) - 10, Math.abs(_loc_5) + 10, Math.abs(_loc_6) - 10);
                                _loc_9.x = _loc_5 + 10;
                                _loc_9.y = _loc_6 - 10;
                                _loc_10.x = _loc_7 - 10;
                                _loc_10.y = _loc_6 - 10;
                                this.freeDraw(_loc_9, _loc_10, param1);
                                param1.graphics.moveTo(Math.abs(_loc_7) - 10, Math.abs(_loc_6) - 10);
                                param1.graphics.curveTo(Math.abs(_loc_7), Math.abs(_loc_6) - 10, Math.abs(_loc_7), Math.abs(_loc_6) - 20);
                                _loc_9.x = _loc_7;
                                _loc_9.y = _loc_6 - 20;
                                this.freeDraw(_loc_9, param3, param1);
                            }
                        }
                        else if (_loc_8 >= _loc_6)
                        {
                            param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                            param1.graphics.curveTo(Math.abs(_loc_5), Math.abs(_loc_6) + 10, Math.abs(_loc_5) + 10, Math.abs(_loc_6) + 10);
                            param1.graphics.lineTo(Math.abs(_loc_7) - 10, Math.abs(_loc_6) + 10);
                            param1.graphics.curveTo(Math.abs(_loc_7), Math.abs(_loc_6) + 10, Math.abs(_loc_7), Math.abs(_loc_6) + 20);
                            param1.graphics.lineTo(Math.abs(_loc_7), Math.abs(_loc_8));
                        }
                        else if (_loc_8 < _loc_6)
                        {
                            param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                            param1.graphics.curveTo(Math.abs(_loc_5), Math.abs(_loc_6) - 10, Math.abs(_loc_5) + 10, Math.abs(_loc_6) - 10);
                            param1.graphics.lineTo(Math.abs(_loc_7) - 10, Math.abs(_loc_6) - 10);
                            param1.graphics.curveTo(Math.abs(_loc_7), Math.abs(_loc_6) - 10, Math.abs(_loc_7), Math.abs(_loc_6) - 20);
                            param1.graphics.lineTo(Math.abs(_loc_7), Math.abs(_loc_8));
                        }
                    }
                    switch(this.tostyle)
                    {
                        case 1:
                        {
                            this.arrowDrawEndUD(param2, param3, param1);
                            break;
                        }
                        case 2:
                        {
                            this.simpleEndUD(param2, param3, param1);
                            break;
                        }
                        case 3:
                        {
                            this.complexEndUD(param2, param3, param1);
                            break;
                        }
                        default:
                        {
                            break;
                        }
                    }
                }
                else if (param4 == 1)
                {
                    switch(this.fromstyle)
                    {
                        case 1:
                        {
                            this.arrowDrawStartLR(param2, param3, param1);
                            break;
                        }
                        case 2:
                        {
                            this.simpleStartLR(param2, param3, param1);
                            break;
                        }
                        case 3:
                        {
                            this.complexStartLR(param2, param3, param1);
                            break;
                        }
                        default:
                        {
                            break;
                        }
                    }
                    if (Math.abs(_loc_6) - Math.abs(_loc_8) < 10 && Math.abs(_loc_6) - Math.abs(_loc_8) > -10)
                    {
                        if (this.linestyle == 0)
                        {
                            this.freeDraw(param2, param3, param1);
                        }
                        else
                        {
                            param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                            param1.graphics.lineTo(Math.abs(_loc_7), Math.abs(_loc_8));
                        }
                    }
                    else if (Math.abs(_loc_6) - Math.abs(_loc_8) >= 10)
                    {
                        if (this.linestyle == 0)
                        {
                            if (_loc_7 >= _loc_5)
                            {
                                param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                                _loc_10.x = _loc_7 - 20;
                                _loc_10.y = _loc_6;
                                this.freeDraw(param2, _loc_10, param1);
                                param1.graphics.moveTo(Math.abs(_loc_7) - 20, Math.abs(_loc_6));
                                param1.graphics.curveTo(Math.abs(_loc_7) - 10, Math.abs(_loc_6), Math.abs(_loc_7) - 10, Math.abs(_loc_6) - 10);
                                _loc_9.x = _loc_7 - 10;
                                _loc_9.y = _loc_6 - 10;
                                _loc_10.x = _loc_7 - 10;
                                _loc_10.y = _loc_8 + 10;
                                this.freeDraw(_loc_9, _loc_10, param1);
                                param1.graphics.moveTo(Math.abs(_loc_7) - 10, Math.abs(_loc_8) + 10);
                                param1.graphics.curveTo(Math.abs(_loc_7) - 10, Math.abs(_loc_8), Math.abs(_loc_7), Math.abs(_loc_8));
                            }
                            else if (_loc_7 < _loc_5)
                            {
                                param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                                _loc_10.x = _loc_7 + 20;
                                _loc_10.y = _loc_6;
                                this.freeDraw(param2, _loc_10, param1);
                                param1.graphics.moveTo(Math.abs(_loc_7) + 20, Math.abs(_loc_6));
                                param1.graphics.curveTo(Math.abs(_loc_7) + 10, Math.abs(_loc_6), Math.abs(_loc_7) + 10, Math.abs(_loc_6) - 10);
                                _loc_9.x = _loc_7 + 10;
                                _loc_9.y = _loc_6 - 10;
                                _loc_10.x = _loc_7 + 10;
                                _loc_10.y = _loc_8 + 10;
                                this.freeDraw(_loc_9, _loc_10, param1);
                                param1.graphics.moveTo(Math.abs(_loc_7) + 10, Math.abs(_loc_8) + 10);
                                param1.graphics.curveTo(Math.abs(_loc_7) + 10, Math.abs(_loc_8), Math.abs(_loc_7), Math.abs(_loc_8));
                            }
                        }
                        else if (_loc_7 >= _loc_5)
                        {
                            param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                            param1.graphics.lineTo(Math.abs(_loc_7) - 20, Math.abs(_loc_6));
                            param1.graphics.curveTo(Math.abs(_loc_7) - 10, Math.abs(_loc_6), Math.abs(_loc_7) - 10, Math.abs(_loc_6) - 10);
                            param1.graphics.lineTo(Math.abs(_loc_7) - 10, Math.abs(_loc_8) + 10);
                            param1.graphics.curveTo(Math.abs(_loc_7) - 10, Math.abs(_loc_8), Math.abs(_loc_7), Math.abs(_loc_8));
                        }
                        else if (_loc_7 < _loc_5)
                        {
                            param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                            param1.graphics.lineTo(Math.abs(_loc_7) + 20, Math.abs(_loc_6));
                            param1.graphics.curveTo(Math.abs(_loc_7) + 10, Math.abs(_loc_6), Math.abs(_loc_7) + 10, Math.abs(_loc_6) - 10);
                            param1.graphics.lineTo(Math.abs(_loc_7) + 10, Math.abs(_loc_8) + 10);
                            param1.graphics.curveTo(Math.abs(_loc_7) + 10, Math.abs(_loc_8), Math.abs(_loc_7), Math.abs(_loc_8));
                        }
                    }
                    else if (Math.abs(_loc_6) - Math.abs(_loc_8) <= -10)
                    {
                        if (this.linestyle == 0)
                        {
                            if (_loc_7 >= _loc_5)
                            {
                                param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                                param1.graphics.curveTo(Math.abs(_loc_5) + 10, Math.abs(_loc_6), Math.abs(_loc_5) + 10, Math.abs(_loc_6) + 10);
                                _loc_9.x = _loc_5 + 10;
                                _loc_9.y = _loc_6 + 10;
                                _loc_10.x = _loc_5 + 10;
                                _loc_10.y = _loc_8 - 10;
                                this.freeDraw(_loc_9, _loc_10, param1);
                                param1.graphics.moveTo(Math.abs(_loc_5) + 10, Math.abs(_loc_8) - 10);
                                param1.graphics.curveTo(Math.abs(_loc_5) + 10, Math.abs(_loc_8), Math.abs(_loc_5) + 20, Math.abs(_loc_8));
                                _loc_9.x = _loc_5 + 20;
                                _loc_9.y = _loc_8;
                                _loc_10.x = _loc_7;
                                _loc_10.y = _loc_8;
                                this.freeDraw(_loc_9, _loc_10, param1);
                            }
                            else if (_loc_7 < _loc_5)
                            {
                                param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                                param1.graphics.curveTo(Math.abs(_loc_5) - 10, Math.abs(_loc_6), Math.abs(_loc_5) - 10, Math.abs(_loc_6) + 10);
                                _loc_9.x = _loc_5 - 10;
                                _loc_9.y = _loc_6 + 10;
                                _loc_10.x = _loc_5 - 10;
                                _loc_10.y = _loc_8 - 10;
                                this.freeDraw(_loc_9, _loc_10, param1);
                                param1.graphics.moveTo(Math.abs(_loc_5) - 10, Math.abs(_loc_8) - 10);
                                param1.graphics.curveTo(Math.abs(_loc_5) - 10, Math.abs(_loc_8), Math.abs(_loc_5) - 20, Math.abs(_loc_8));
                                _loc_9.x = _loc_5 - 20;
                                _loc_9.y = _loc_8;
                                _loc_10.x = _loc_7;
                                _loc_10.y = _loc_8;
                                this.freeDraw(_loc_9, _loc_10, param1);
                            }
                        }
                        else if (_loc_7 >= _loc_5)
                        {
                            param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                            param1.graphics.curveTo(Math.abs(_loc_5) + 10, Math.abs(_loc_6), Math.abs(_loc_5) + 10, Math.abs(_loc_6) + 10);
                            param1.graphics.lineTo(Math.abs(_loc_5) + 10, Math.abs(_loc_8) - 10);
                            param1.graphics.curveTo(Math.abs(_loc_5) + 10, Math.abs(_loc_8), Math.abs(_loc_5) + 20, Math.abs(_loc_8));
                            param1.graphics.lineTo(Math.abs(_loc_7), Math.abs(_loc_8));
                        }
                        else if (_loc_7 < _loc_5)
                        {
                            param1.graphics.moveTo(Math.abs(_loc_5), Math.abs(_loc_6));
                            param1.graphics.curveTo(Math.abs(_loc_5) - 10, Math.abs(_loc_6), Math.abs(_loc_5) - 10, Math.abs(_loc_6) + 10);
                            param1.graphics.lineTo(Math.abs(_loc_5) - 10, Math.abs(_loc_8) - 10);
                            param1.graphics.curveTo(Math.abs(_loc_5) - 10, Math.abs(_loc_8), Math.abs(_loc_5) - 20, Math.abs(_loc_8));
                            param1.graphics.lineTo(Math.abs(_loc_7), Math.abs(_loc_8));
                        }
                    }
                    switch(this.tostyle)
                    {
                        case 1:
                        {
                            this.arrowDrawEndLR(param2, param3, param1);
                            break;
                        }
                        case 2:
                        {
                            this.simpleEndLR(param2, param3, param1);
                            break;
                        }
                        case 3:
                        {
                            this.complexEndLR(param2, param3, param1);
                            break;
                        }
                        default:
                        {
                            break;
                        }
                    }
                }
            }
            return;
        }// end function

        public function simpleStartUD(param1:Point, param2:Point, param3:Line) : void
        {
            var _loc_4:* = param1.x;
            var _loc_5:* = param1.y;
            var _loc_6:* = param2.x;
            var _loc_7:* = param2.y;
            if (_loc_7 >= _loc_5)
            {
                param3.graphics.moveTo(Math.abs(_loc_4) + 5, Math.abs(_loc_5) + 5);
                param3.graphics.lineTo(Math.abs(_loc_4) - 5, Math.abs(_loc_5) + 5);
            }
            else if (_loc_7 < _loc_5)
            {
                param3.graphics.moveTo(Math.abs(_loc_4) + 5, Math.abs(_loc_5) - 5);
                param3.graphics.lineTo(Math.abs(_loc_4) - 5, Math.abs(_loc_5) - 5);
            }
            return;
        }// end function

        public function complexStartUD(param1:Point, param2:Point, param3:Line) : void
        {
            var _loc_4:* = param1.x;
            var _loc_5:* = param1.y;
            var _loc_6:* = param2.x;
            var _loc_7:* = param2.y;
            if (_loc_7 >= _loc_5)
            {
                param3.graphics.moveTo(Math.abs(_loc_4) - 5, Math.abs(_loc_5));
                param3.graphics.lineTo(Math.abs(_loc_4), Math.abs(_loc_5) + 5);
                param3.graphics.moveTo(Math.abs(_loc_4) + 5, Math.abs(_loc_5));
                param3.graphics.lineTo(Math.abs(_loc_4), Math.abs(_loc_5) + 5);
                param3.graphics.moveTo(Math.abs(_loc_4) + 5, Math.abs(_loc_5) + 5);
                param3.graphics.lineTo(Math.abs(_loc_4) - 5, Math.abs(_loc_5) + 5);
                param3.graphics.drawCircle(Math.abs(_loc_4), Math.abs(_loc_5) + 7, 2);
            }
            else if (_loc_7 < _loc_5)
            {
                param3.graphics.moveTo(Math.abs(_loc_4) - 5, Math.abs(_loc_5));
                param3.graphics.lineTo(Math.abs(_loc_4), Math.abs(_loc_5) - 5);
                param3.graphics.moveTo(Math.abs(_loc_4) + 5, Math.abs(_loc_5));
                param3.graphics.lineTo(Math.abs(_loc_4), Math.abs(_loc_5) - 5);
                param3.graphics.moveTo(Math.abs(_loc_4) + 5, Math.abs(_loc_5) - 5);
                param3.graphics.lineTo(Math.abs(_loc_4) - 5, Math.abs(_loc_5) - 5);
                param3.graphics.drawCircle(Math.abs(_loc_4), Math.abs(_loc_5) - 7, 2);
            }
            return;
        }// end function

        public function set style(param1:int) : void
        {
            this._style = param1;
            return;
        }// end function

        public function simpleEndUD(param1:Point, param2:Point, param3:Line) : void
        {
            var _loc_4:* = param1.x;
            var _loc_5:* = param1.y;
            var _loc_6:* = param2.x;
            var _loc_7:* = param2.y;
            if (_loc_7 >= _loc_5)
            {
                param3.graphics.moveTo(Math.abs(_loc_4) + 5, Math.abs(_loc_5) - 5);
                param3.graphics.lineTo(Math.abs(_loc_4) - 5, Math.abs(_loc_5) - 5);
            }
            else if (_loc_7 < _loc_5)
            {
                param3.graphics.moveTo(Math.abs(_loc_6) + 5, Math.abs(_loc_7) + 5);
                param3.graphics.lineTo(Math.abs(_loc_6) - 5, Math.abs(_loc_7) + 5);
            }
            return;
        }// end function

        public function freeDraw(param1:Point, param2:Point, param3:Line) : void
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

        public function set tostyle(param1:int) : void
        {
            this._tostyle = param1;
            return;
        }// end function

        public function get style() : int
        {
            return this._style;
        }// end function

        public function arrowDrawEndLR(param1:Point, param2:Point, param3:Line) : void
        {
            var _loc_4:* = param1.x;
            var _loc_5:* = param1.y;
            var _loc_6:* = param2.x;
            var _loc_7:* = param2.y;
            if (_loc_6 >= _loc_4)
            {
                param3.graphics.moveTo(Math.abs(_loc_6), Math.abs(_loc_7));
                param3.graphics.lineTo(Math.abs(_loc_6) - 5, Math.abs(_loc_7) + 5);
                param3.graphics.moveTo(Math.abs(_loc_6), Math.abs(_loc_7));
                param3.graphics.lineTo(Math.abs(_loc_6) - 5, Math.abs(_loc_7) - 5);
            }
            else if (_loc_6 < _loc_4)
            {
                param3.graphics.moveTo(Math.abs(_loc_6), Math.abs(_loc_7));
                param3.graphics.lineTo(Math.abs(_loc_6) + 5, Math.abs(_loc_7) + 5);
                param3.graphics.moveTo(Math.abs(_loc_6), Math.abs(_loc_7));
                param3.graphics.lineTo(Math.abs(_loc_6) + 5, Math.abs(_loc_7) - 5);
            }
            return;
        }// end function

        public function set linestyle(param1:int) : void
        {
            this._linestyle = param1;
            return;
        }// end function

        public function arrowDrawStartLR(param1:Point, param2:Point, param3:Line) : void
        {
            var _loc_4:* = param1.x;
            var _loc_5:* = param1.y;
            var _loc_6:* = param2.x;
            var _loc_7:* = param2.y;
            if (_loc_6 >= _loc_4)
            {
                param3.graphics.moveTo(Math.abs(_loc_4), Math.abs(_loc_5));
                param3.graphics.lineTo(Math.abs(_loc_4) + 5, Math.abs(_loc_5) + 5);
                param3.graphics.moveTo(Math.abs(_loc_4), Math.abs(_loc_5));
                param3.graphics.lineTo(Math.abs(_loc_4) + 5, Math.abs(_loc_5) - 5);
            }
            else if (_loc_6 < _loc_4)
            {
                param3.graphics.moveTo(Math.abs(_loc_4), Math.abs(_loc_5));
                param3.graphics.lineTo(Math.abs(_loc_4) - 5, Math.abs(_loc_5) + 5);
                param3.graphics.moveTo(Math.abs(_loc_4), Math.abs(_loc_5));
                param3.graphics.lineTo(Math.abs(_loc_4) - 5, Math.abs(_loc_5) - 5);
            }
            return;
        }// end function

        public function get linestyle() : int
        {
            return this._linestyle;
        }// end function

    }
}
