package com.pactera.edg.am.kpi.view.dragger
{
    import com.pactera.edg.am.kpi.view.*;
    import com.pactera.edg.am.kpi.view.model.*;
    import flash.events.*;

    public interface IDragBehavior
    {

        public function IDragBehavior();

        function set canvas(param1:ModelView) : void;

        function set model(param1:DisplayElement) : void;

        function mouseDownHandler(event:MouseEvent) : void;

        function mouseMoveHandler(event:MouseEvent) : void;

        function mouseDoubleClickHandler(event:MouseEvent) : void;

        function get model() : DisplayElement;

        function mouseUpHandler(event:MouseEvent) : void;

        function lineDispatchEvent() : void;

        function get canvas() : ModelView;

    }
}
