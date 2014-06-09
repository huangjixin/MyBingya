package com.pactera.edg.am.view
{
    import com.pactera.edg.am.view.extender.*;

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
            this._extensible.model.isOpen = true;
            this._extensible.model.invalidateProperties();
            this._extensible.model.invalidateSize();
            this._extensible.model.invalidateDisplayList();
            return;
        }// end function

    }
}
