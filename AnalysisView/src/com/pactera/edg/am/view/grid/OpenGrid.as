package com.pactera.edg.am.view.grid
{
    import com.pactera.edg.am.factory.*;
    import com.pactera.edg.am.system.*;

    public class OpenGrid extends Grid
    {
        private var factory:ModelFactory;

        public function OpenGrid()
        {
            this.factory = ApplicationConfig.getInstance().modelFactory;
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
