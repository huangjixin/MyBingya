package com.pactera.edg.am.kpi.rightClick
{
    import flash.display.*;
    import mx.utils.*;

    dynamic public class RightClickRegister extends Sprite
    {
        private var rightClickRegisted:Boolean = false;

        public function RightClickRegister()
        {
            if (!rightClickRegisted)
            {
                RightClickManager.regist();
                rightClickRegisted = true;
            }
            try
            {
                name = NameUtil.createUniqueName(this);
            }
            catch (e:Error)
            {
            }
            return;
        }// end function

        override public function toString() : String
        {
            return NameUtil.displayObjectToString(this);
        }// end function

    }
}
