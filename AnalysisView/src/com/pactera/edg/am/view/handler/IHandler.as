package com.pactera.edg.am.view.handler
{
    import com.pactera.edg.am.view.model.*;

    public interface IHandler
    {

        public function IHandler();

        function sendToJavaScript(param1:String, param2:String) : void;

        function disposal(param1:DisplayElement, param2:String) : void;

        function owner(param1:DisplayElement, param2:String) : void;

        function impact(param1:DisplayElement, param2:String) : void;

        function lineage(param1:DisplayElement, param2:String) : void;

        function quality(param1:DisplayElement, param2:String) : void;

    }
}
