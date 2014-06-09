package com.pactera.edg.am.dmv.view
{
    import com.pactera.edg.am.dmv.view.extender.*;

    public class OpenModelState extends ModelState
    {

        public function OpenModelState(param1:IExtendBehavior)
        {
            super(param1);
            return;
        }// end function

        override public function changeModelState() : void
        {
            this._extensible.contract();
            this._extensible.model.setActualSize(this._extensible.model.getExWidth(), this._extensible.model.getExHeight());
            return;
        }// end function

    }
}
