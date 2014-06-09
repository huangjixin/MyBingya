package com.pactera.edg.am.dmv.view.handler
{
    import com.pactera.edg.am.dmv.view.model.*;
    import mx.core.*;

    import com.pactera.edg.am.utilities.RightClickManager;
    import mx.managers.CursorManager;
    import mx.controls.Menu;
    import flash.geom.Point;
    
    
    public class CustomContextMenu extends UIComponent
    {
        private var _canDel:Boolean = false;
        private var _model:DisplayElement;
        private var _canModify:Boolean = false;
        private var _canAdd:Boolean = false;

        public function CustomContextMenu()
        {
            return;
        }// end function

        public function get canDel() : Boolean
        {
            return this._canDel;
        }// end function

        public function disableContextMenu() : void
        {
            return;
        }// end function

        public function setCanModify(param1:String) : void
        {
            if (param1 == "Y")
            {
                this._canModify = true;
            }
            return;
        }// end function

        public function get model() : DisplayElement
        {
            return this._model;
        }// end function

        public function contructContextMenu() : void
        {
            return;
        }// end function

        public function get canAdd() : Boolean
        {
            return this._canAdd;
        }// end function

        public function set model(param1:DisplayElement) : void
        {
            this._model = param1;
            return;
        }// end function

        public function get canModify() : Boolean
        {
            return this._canModify;
        }// end function

        public function setCanAdd(param1:String) : void
        {
            if (param1 == "Y")
            {
                this._canAdd = true;
            }
            return;
        }// end function

        public function setCanDel(param1:String) : void
        {
            if (param1 == "Y")
            {
                this._canDel = true;
            }
            return;
        }// end function


        public static var rightClickMenu:Menu=null;
        //右键菜单响应函数
        public static var rightClickMenuHandlerId:Array=[];
        public static function removeRightClickMenu():void
        {
        	if(rightClickMenu!=null)
		    {
		     rightClickMenu.hide();
		     //menu.removeEventListener(MenuEvent.ITEM_CLICK,menuItemClickHandler);
		     rightClickMenu=null;
		    }
		    //初始化
		    if(rightClickMenuHandlerId!=null){
		     	 rightClickMenuHandlerId=null;
		     	 rightClickMenuHandlerId=[];
		    }
        }
    }
}
