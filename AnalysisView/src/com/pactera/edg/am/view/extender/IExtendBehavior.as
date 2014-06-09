package com.pactera.edg.am.view.extender
{
    import com.pactera.edg.am.view.*;
    import com.pactera.edg.am.view.model.*;

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
