package com.pactera.edg.am.kpi.view.line
{
    import com.pactera.edg.am.kpi.view.model.*;
    import flash.geom.*;
    import mx.core.*;

    public class Direction extends Object
    {
        private var _direction:int = 0;

        public function Direction()
        {
            return;
        }// end function

        public function getToPoint(param1:DisplayElement, param2:DisplayElement, param3:UIComponent) : Point
        {
            if (this.direction == 0)
            {
                if (param1.getTopPoint(param3).y > param2.getBottomPoint(param3).y)
                {
                    return param2.getBottomPoint(param3);
                }
                if (param1.getBottomPoint(param3).y < param2.getTopPoint(param3).y)
                {
                    return param2.getTopPoint(param3);
                }
                if (param1.getRightPoint(param3).x < param2.getLeftPoint(param3).x)
                {
                    return param2.getLeftPoint(param3);
                }
                return param2.getRightPoint(param3);
            }
            else if (this.direction == 1)
            {
                if (param1.getRightPoint(param3).x < param2.getLeftPoint(param3).x)
                {
                    return param2.getLeftPoint(param3);
                }
                if (param1.getLeftPoint(param3).x > param2.getRightPoint(param3).x)
                {
                    return param2.getRightPoint(param3);
                }
                if (param1.getTopPoint(param3).y > param2.getBottomPoint(param3).y)
                {
                    return param2.getBottomPoint(param3);
                }
                return param2.getTopPoint(param3);
            }
            return null;
        }// end function

        public function getFromPoint(param1:DisplayElement, param2:DisplayElement, param3:UIComponent) : Point
        {
            if (this.direction == 0)
            {
                if (param1.getBottomPoint(param3).y + 10 < param2.getTopPoint(param3).y)
                {
                    return param1.getBottomPoint(param3);
                }
                if (param1.getTopPoint(param3).y - 10 > param2.getBottomPoint(param3).y)
                {
                    return param1.getTopPoint(param3);
                }
                if (param1.getRightPoint(param3).x < param2.getLeftPoint(param3).x)
                {
                    return param1.getRightPoint(param3);
                }
                return param1.getLeftPoint(param3);
            }
            else if (this.direction == 1)
            {
                if (param1.getRightPoint(param3).x < param2.getLeftPoint(param3).x)
                {
                    return param1.getRightPoint(param3);
                }
                if (param1.getLeftPoint(param3).x > param2.getRightPoint(param3).x)
                {
                    return param1.getLeftPoint(param3);
                }
                if (param1.getTopPoint(param3).y > param2.getBottomPoint(param3).y)
                {
                    return param1.getTopPoint(param3);
                }
                return param1.getBottomPoint(param3);
            }
            return null;
        }// end function

        public function set direction(param1:int) : void
        {
            this._direction = param1;
            return;
        }// end function

        public function get direction() : int
        {
            return this._direction;
        }// end function

    }
}
