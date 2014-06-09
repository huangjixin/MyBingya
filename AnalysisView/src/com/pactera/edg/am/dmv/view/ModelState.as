package com.pactera.edg.am.dmv.view
{
    import com.pactera.edg.am.dmv.view.*;
    import com.pactera.edg.am.dmv.view.extender.*;
    import com.pactera.edg.am.dmv.view.IState;

    public class ModelState extends Object implements IState
    {
        protected var _extensible:IExtendBehavior;

        public function ModelState(param1:IExtendBehavior)
        {
            this._extensible = param1;
            return;
        }// end function

        public function changeModelState() : void
        {
            trace(this._extensible.model.mdname);
            trace("hell0");
            return;
        }// end function

    }
}
