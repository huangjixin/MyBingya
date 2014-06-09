package com.pactera.edg.am.kpi.view
{
    import com.pactera.edg.am.kpi.view.extender.*;

    public class CloseModelState extends ModelState
    {

        public function CloseModelState(param1:IExtendBehavior)
        {
            super(param1);
            return;
        }// end function

        override public function changeModelState() : void
        {
            this._extensible.extend();
            this._extensible.model.setActualSize(this._extensible.model.getExWidth(), this._extensible.model.getExHeight());
            return;
        }// end function

    }
}
