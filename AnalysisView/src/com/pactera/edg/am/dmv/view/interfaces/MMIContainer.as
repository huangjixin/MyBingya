package com.pactera.edg.am.dmv.view.interfaces
{
    import com.pactera.edg.am.dmv.view.model.*;

    public interface MMIContainer
    {

        public function MMIContainer();

        function getObjectHandles() : MyObjectHandles;

        function registerModels(param1:Array = null) : void;

        function registerModel(param1:Array, param2:DisplayElement) : void;

    }
}
