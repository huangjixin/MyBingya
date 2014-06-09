package com.pactera.edg.am.view
{
    import com.pactera.edg.am.view.extender.*;

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
            this._extensible.model.isOpen = false;
            this._extensible.model.invalidateProperties();
            this._extensible.model.invalidateSize();
            this._extensible.model.invalidateDisplayList();
            return;
        }// end function

    }
}
