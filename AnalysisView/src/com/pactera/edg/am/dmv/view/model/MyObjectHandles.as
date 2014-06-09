package com.pactera.edg.am.dmv.view.model
{
    import com.pactera.edg.am.dmv.view.*;
    import com.pactera.edg.am.dmv.view.handler.*;
    import com.roguedevelopment.objecthandles.*;
    import flash.display.*;
    import flash.events.*;
    import mx.core.*;

    public class MyObjectHandles extends ObjectHandles
    {

        public function MyObjectHandles(param1:Sprite, param2:ObjectHandlesSelectionManager = null, param3:IFactory = null, param4:IChildManager = null)
        {
            if (param3 == null)
            {
            	//param3 = new ClassFactory(com.roguedevelopment.objecthandles.CircleHandle); //com.roguedevelopment.objecthandles.CircleHandle
                param3 = new ClassFactory(DegrafaHandle); //DegrafaHandle
            }
            super(param1, param2, param3, param4);
            
            
            this.defaultHandles = [];
            
//            handles = [];
//			handles.push( new HandleDescription( HandleRoles.RESIZE_UP ,
//								    new Point(50,0) , 
//								    new Point(0,0) ) ); 
//			handles.push( new HandleDescription( HandleRoles.RESIZE_RIGHT,
//								    new Point(100,50) , 
//								    new Point(0,0) ) ); 
//			handles.push( new HandleDescription( HandleRoles.RESIZE_DOWN ,
//								    new Point(50,100) ,
//								    new Point(0,0) ) ); 
//			handles.push( new HandleDescription( HandleRoles.RESIZE_LEFT,
//								    new Point(0,50) ,
//								    new Point(0,0) ) ); 
//			handles.push( new HandleDescription( HandleRoles.MOVE,
//								    new Point(50,50) , 
//								    new Point(0,0) ) ); 
								    
					    
            
            return;
        }// end function

        override public function unregisterComponent(param1:IEventDispatcher) : void
        {
            super.unregisterComponent(param1);
            return;
        }// end function

        override public function registerComponent(param1:Object, param2:IEventDispatcher, param3:Array = null, param4:Boolean = true, param5:Array = null) : void
        {
        	if(param3!=null){
        		trace("param3:"+param3+","+param3.length);
        	}else{
        		trace("param3:"+param3);
        	}
            super.registerComponent(param1, param2, param3);
            return;
        }// end function

        override protected function onContainerMouseMove(event:MouseEvent) : void
        {
            var _loc_2:DisplayElement = null;
            super.onContainerMouseMove(event);
            if (selectionManager.currentlySelected.length == 1)
            {
                _loc_2 = selectionManager.currentlySelected[0] as DisplayElement;
                _loc_2.lineColorDispatchEvent();
                _loc_2.reDrawChildLine();
                _loc_2.xPos = _loc_2.x;
                _loc_2.yPos = _loc_2.y;
            }
            return;
        }// end function

        override protected function onContainerMouseUp(event:MouseEvent) : void
        {
            var _loc_2:DisplayElement = null;
            super.onContainerMouseUp(event);
            if (selectionManager.currentlySelected.length == 1)
            {
                _loc_2 = selectionManager.currentlySelected[0] as DisplayElement;
                if (_loc_2.parent is ModelComponent)
                {
                    (_loc_2.parent as ModelComponent).invalidateProperties();
                    (_loc_2.parent as ModelComponent).invalidateSize();
                    (_loc_2.parent as ModelComponent).invalidateDisplayList();
                }
            }
            return;
        }// end function

    }
}
