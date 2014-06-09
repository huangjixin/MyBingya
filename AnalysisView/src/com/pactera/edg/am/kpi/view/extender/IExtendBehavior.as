package com.pactera.edg.am.kpi.view.extender
{
    import com.pactera.edg.am.kpi.view.*;
    import com.pactera.edg.am.kpi.view.model.*;

    public interface IExtendBehavior
    {

        public function IExtendBehavior();

        function set modelState(param1:IState) : void;

        function get container() : IContainer;

        function contract() : void;

        function set model(param1:DisplayElement) : void;

        function get modelState() : IState;

        function set container(param1:IContainer) : void;

        function extend() : void;

        function get model() : DisplayElement;

    }
}
