package com.pactera.edg.am.view.model
{
    import com.pactera.edg.am.view.*;
    import com.pactera.edg.am.view.handler.*;
    import com.roguedevelopment.objecthandles.*;
    import flash.display.*;
    import flash.events.*;
    import flash.utils.*;
    import mx.core.*;
    import mx.events.ScrollEvent;

	import com.pactera.edg.am.view.handler.DegrafaHandle;
	
    public class MyObjectHandles extends ObjectHandles
    {
        public var movedModelDic:Dictionary = null;
        public var objectId:String;

        public function MyObjectHandles(param1:Sprite, param2:ObjectHandlesSelectionManager = null, param3:IFactory = null, param4:IChildManager = null)
        {
            var _loc_5:* = new Date();
            if (param3 == null)
            {
                param3 = new ClassFactory(com.pactera.edg.am.view.handler.DegrafaHandle);
            }
            super(param1, param2, param3, param4);
            this.defaultHandles = null;
            this.objectId = _loc_5.getTime().toString() + Math.random();
            this.movedModelDic = new Dictionary();
            return;
        }// end function

       /*
       *注册组件 
       */
        override public function registerComponent(param1:Object, param2:IEventDispatcher, param3:Array = null, param4:Boolean = true, param5:Array = null) : void
        {
            super.registerComponent(param1, param2);
            return;
        }// end function

      //反注册组件
        override public function unregisterComponent(param1:IEventDispatcher) : void
        {
            super.unregisterComponent(param1);
            return;
        }// end function


       //尝试监听scroll事件 todo
        override protected function onContainerScroll(event:ScrollEvent):void
        {
           super.onContainerScroll(event);
           trace("[MyObjectHandels.as] onContainerScroll...");
        }
        
        
       /*
       *当组件被鼠标点击按下 
       */
        override protected function onComponentMouseDown(event:MouseEvent) : void
        {
        	//trace("[MyObjectHandels.as] onComponentMouseDown...");
            var _loc_2:* = event.target as DisplayObject;
            if (_loc_2.parent is DisplayElement)
            {
                if ((_loc_2.parent as DisplayElement).modelView.tourFlag)
                {
                    return;
                }
            }
            super.onComponentMouseDown(event);
            return;
        }// end function

        /*
        *当容器被移动 
        */
        override protected function onContainerMouseMove(event:MouseEvent) : void
        {
        	//trace("[MyObjectHandels.as] onContainerMouseMove...");
            var _loc_2:DisplayElement = null;
            super.onContainerMouseMove(event);
            if (selectionManager.currentlySelected.length == 1)
            {//限制一次只能选择一个
                _loc_2 = selectionManager.currentlySelected[0] as DisplayElement;
                //通知相关线条改变颜色。
                _loc_2.allLineColorDispatchEvent(_loc_2);
                //记忆拖放的位置，便于后期节点展开或其他时候，刷新保持
                _loc_2.xPos = _loc_2.x;
                _loc_2.yPos = _loc_2.y;
                //如果是基本模型
                if (_loc_2 is BasicModel)
                {   
                     //将被移动对象在父对象的子对象索引改变到最后。
                    (_loc_2.parent as UIComponent).setChildIndex(_loc_2, ((_loc_2.parent as UIComponent).numChildren - 1));
                }
            }
            return;
        }// end function

        /*
        *管理移动对象的限制区域 
        */
        override public function addDefaultConstraint(param1:IConstraint) : void
        {
            if (this.defaultConstraints != null)
            {
                this.defaultConstraints = [];
            }
            super.addDefaultConstraint(param1);
            return;
        }// end function

        /*
        *当容器托放完成时 
        */
        override protected function onContainerMouseUp(event:MouseEvent) : void
        {
        	//trace("[MyObjectHandels.as] onContainerMouseUp...");
            var _loc_2:DisplayElement = null;
            super.onContainerMouseUp(event);
            if (selectionManager.currentlySelected.length == 1)
            {
                _loc_2 = selectionManager.currentlySelected[0] as DisplayElement;
                _loc_2.removeAllLineColorDispatchEvent(_loc_2);
                if (_loc_2.parent as ModelComponent)
                {
                	//登记被移动的对象集合，被移动的对象被特殊标识出来了
                    this.movedModelDic[_loc_2.nodeId] = _loc_2;
                    //刷新父对象
                    (_loc_2.parent as ModelComponent).invalidateProperties();
                    (_loc_2.parent as ModelComponent).invalidateSize();
                    (_loc_2.parent as ModelComponent).invalidateDisplayList();
                }
            }
            return;
        }// end function

    }
}
