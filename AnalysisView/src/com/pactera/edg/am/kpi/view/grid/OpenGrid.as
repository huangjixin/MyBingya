package com.pactera.edg.am.kpi.view.grid
{
    import com.pactera.edg.am.kpi.factory.*;
    import com.pactera.edg.am.kpi.system.*;

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
            return 10;
        }// end function

        override public function getGasWidth() : int
        {
            return 10;
        }// end function

    }
}
