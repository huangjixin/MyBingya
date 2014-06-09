package com.pactera.edg.am.dmv.view.grid
{
    import com.pactera.edg.am.dmv.factory.*;
    import com.pactera.edg.am.dmv.system.*;

    public class OpenGrid extends Grid
    {
        private var factory:ModelFactory;

        public function OpenGrid()
        {
            factory = ApplicationConfig.getInstance().modelFactory;
            return;
        }// end function

        override public function init(param1:Array) : void
        {
            super.init(param1);
            return;
        }// end function

        override public function getGasHeight() : int
        {
            return 5;
        }// end function

        override public function getGasWidth() : int
        {
            return 15;
        }// end function

    }
}
