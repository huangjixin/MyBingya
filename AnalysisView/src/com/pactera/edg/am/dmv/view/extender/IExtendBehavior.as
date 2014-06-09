package com.pactera.edg.am.dmv.view.extender
{
    import com.pactera.edg.am.dmv.view.*;
    import com.pactera.edg.am.dmv.view.model.*;
    import com.pactera.edg.am.dmv.view.IState;

    public interface IExtendBehavior
    {

        public function IExtendBehavior();

        function set modelState(param1:IState) : void;

        function set model(param1:DisplayElement) : void;

        function contract() : void;

        function get modelState() : IState;

        function get model() : DisplayElement;

        function extend() : void;

    }
}
