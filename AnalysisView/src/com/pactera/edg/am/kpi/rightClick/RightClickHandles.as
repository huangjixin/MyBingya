package com.pactera.edg.am.kpi.rightClick
{
    import com.pactera.edg.am.kpi.view.handler.*;
    import com.pactera.edg.am.kpi.view.model.*;
    
    import flash.display.*;
    import flash.events.*;
    import flash.geom.*;
    import flash.utils.*;
    
    import mx.controls.*;
    import mx.events.*;

    public class RightClickHandles extends Object
    {
        private var menuBar:Menu;
        private static var _instance:RightClickHandles = null;

        public function RightClickHandles(param1:PrivateClass)
        {
            return;
        }// end function

        public function setHandleFunction(target:Sprite, param2:DisplayElement, param3:XML) : void
        {
            var model:* = param2;
            var items:* = param3;
//            with ({})
//            {
//                {}.c = function (event:MouseEvent) : void
//			            {
//			                rightClickHandler(event, items, model);
//			                return;
//			            }// end function
//	                    ;
//            }
            target.addEventListener(
				RightClickManager.RIGHT_CLICK,
				function (event:MouseEvent) : void
		            {
		                rightClickHandler(event, items, model);
		                return;
		            }// end function
            );
            return;
        }// end function

        protected function rightClickHandler(event:MouseEvent, param2:XML, param3:DisplayElement) : void
        {
            var event:* = event;
            var items:* = param2;
            var model:* = param3;
            if (menuBar != null)
            {
                menuBar.hide();
            }
            menuBar = Menu.createMenu(event.target as DisplayObjectContainer, items, false);
            menuBar.labelField = "@itemname";
            menuBar.variableRowHeight = true;
//            with ({})
//            {
//                {}.c = function (event:MenuEvent) : void
//            {
//                mouseRightClickHandler(event, model);
//                return;
//            }// end function
//            ;
//            }
            menuBar.addEventListener(MenuEvent.ITEM_CLICK, function (event:MenuEvent) : void
            {
                mouseRightClickHandler(event, model);
                return;
            }// end function
            );
            var point:* = new Point(event.localX, event.localY);
            point = event.target.localToGlobal(point);
            menuBar.show(point.x, point.y);
            return;
        }// end function

        private function mouseRightClickHandler(event:MenuEvent, param2:DisplayElement) : void
        {
            getFunction(event.item as XML).call(DisplayElement, param2, event.item.@url);
            return;
        }// end function

        private function handler(event:ContextMenuEvent) : void
        {
            Alert.show("Undefined");
            return;
        }// end function

        private function getFunction(param1:XML) : Function
        {
            var _loc_2:* = null;
            var _loc_3:* = null;
            var _loc_4:* = null;
            if (param1.@handler != null && param1.@handler != "")
            {
                _loc_3 = getDefinitionByName(param1.@handler) as Class;
                _loc_4 = new _loc_3;
            }
            else
            {
                return this.handler;
            }
            return _loc_4[param1.@funcName];
        }// end function

        public static function getInstance() : RightClickHandles
        {
            if (_instance == null)
            {
                _instance = new RightClickHandles(new PrivateClass());
            }
            return _instance;
        }// end function

    }
}

import com.pactera.edg.am.kpi.view.handler.*;
import com.pactera.edg.am.kpi.view.model.*;

import flash.display.*;
import flash.events.*;
import flash.geom.*;
import flash.utils.*;

import mx.controls.*;
import mx.events.*;

class PrivateClass extends Object
{

    function PrivateClass()
    {
        return;
    }// end function

}

