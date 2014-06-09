package com.pactera.edg.am.view
{
    import com.pactera.edg.am.view.*;
    import com.pactera.edg.am.view.extender.*;

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
