package com.pactera.edg.am.dmv.view.handler
{
    import com.pactera.edg.am.dmv.view.model.*;
    import flash.events.*;
    import flash.external.*;
    import flash.ui.*;

    import mx.events.MenuEvent;
    import com.pactera.edg.am.utilities.RightClickManager;
    import mx.managers.CursorManager;
    import mx.controls.Menu;
    import flash.geom.Point;
    
    
    public class DataMapComModelContextMenu extends CustomContextMenu
    {

        public function DataMapComModelContextMenu()
        {
            return;
        }// end function

       override public function contructContextMenu() : void
        {
        	var wmode:String=com.pactera.edg.am.utilities.MouseWheelEnabler.getBrowserInfo().flashWmode;
        	trace("contructContextMenu---wmode:"+wmode);
        	if(wmode!=null&&wmode.toLowerCase()=="opaque"){//增加定制菜单
        		addCustomContextMenuEvent();
        	}
        	    //增加传统菜单,支持全屏模式下也能正常操作
        		addNormalContextMenuEvent();
        }
        //zzg 2011-12-20
        //该方法为原来标准菜单构建,这里改名是为了兼容自定义菜单
        public function addNormalContextMenuEvent() : void
        {
            var _loc_3:ContextMenuItem = null;
            var _loc_4:ContextMenuItem = null;
            var _loc_5:ContextMenuItem = null;
            var _loc_6:ContextMenuItem = null;
            var _loc_7:ContextMenuItem = null;
            var _loc_1:* = new ContextMenu();
            var _loc_2:* = new ContextMenuItem("查询");
            _loc_2.addEventListener(ContextMenuEvent.MENU_ITEM_SELECT, this.model.modelView.searchDataMap);
            _loc_1.customItems.push(_loc_2);
            if (this.canDel)
            {
                _loc_3 = new ContextMenuItem("删除");
                _loc_3.addEventListener(ContextMenuEvent.MENU_ITEM_SELECT, operNodeDataMap);
                _loc_1.customItems.push(_loc_3);
            }
            if (this.canModify)
            {
                _loc_4 = new ContextMenuItem("修改");
                _loc_4.addEventListener(ContextMenuEvent.MENU_ITEM_SELECT, operNodeDataMap);
                _loc_1.customItems.push(_loc_4);
            }
            if (this.canAdd)
            {
                _loc_5 = new ContextMenuItem("增加系统");
                _loc_5.addEventListener(ContextMenuEvent.MENU_ITEM_SELECT, operNodeDataMap);
                _loc_1.customItems.push(_loc_5);
                _loc_6 = new ContextMenuItem("增加子层次");
                _loc_6.addEventListener(ContextMenuEvent.MENU_ITEM_SELECT, operNodeDataMap);
                _loc_1.customItems.push(_loc_6);
                _loc_7 = new ContextMenuItem("克隆系统层次");
                _loc_7.addEventListener(ContextMenuEvent.MENU_ITEM_SELECT, operNodeDataMap);
                _loc_1.customItems.push(_loc_7);
            }
            _loc_1.hideBuiltInItems();
            this.model.rectOne.contextMenu = _loc_1;
            return;
        }// end function

        public function operNodeDataMap(event:ContextMenuEvent) : void
        {
            var _loc_2:* = (event.target as ContextMenuItem).caption;
            var _loc_3:* = (event.mouseTarget.parent as DisplayElement).modelId;
            switch(_loc_2)
            {
                case "增加系统":
                {
                    ExternalInterface.call("showAddSystemLevelMetaData", this.model.modelId, this.model.modelType, "System");
                    break;
                }
                case "克隆系统层次":
                {
                    ExternalInterface.call("showCloneMetaData", this.model.parentmdid, this.model.parentmdmodel, this.model.modelType);
                    break;
                }
                case "增加子层次":
                {
                    ExternalInterface.call("showAddSystemLevelMetaData", this.model.modelId, this.model.modelType, "SystemLevel");
                    break;
                }
                case "修改":
                {
                    ExternalInterface.call("showEditMetaData", _loc_3);
                    break;
                }
                case "删除":
                {
                    ExternalInterface.call("showDeleteMetaData", _loc_3);
                    break;
                }
                default:
                {
                    break;
                    break;
                }
            }
            return;
        }// end function

        override public function disableContextMenu() : void
        {
            this.model.rectOne.contextMenu = null;
            return;
        }// end function




////////////////////////////////////////////////
        //增加定制菜单
        public function addCustomContextMenuEvent():void{
        	//trace("[addCustomContextMenuEvent]");
        	this.model.rectOne.addEventListener(RightClickManager.RIGHT_CLICK,onCustomRightClickHandler);
        }
 
        private function rightClickMenuItemHandler(event:MenuEvent) : void
        {
        	   var curModelId:* =this.model.modelId;// (event.mouseTarget.parent as DisplayElement).modelId;
        	   var curModelType:* = this.model.modelType;//(event.mouseTarget.parent as DisplayElement).modelType;
        	   
        	   var menuItemIdx:* = event.index;
               var menuId:String=rightClickMenuHandlerId[menuItemIdx]
			    if(menuId=="searchDataMap"){//查询
			    	  this.model.modelView.doSearchDataMap(curModelId,curModelType);
			    }else if(menuId=="operNodeDataMap_delete"){//删除
			    	  ExternalInterface.call("showDeleteMetaData", curModelId);
			    }else if(menuId=="operNodeDataMap_modify"){//修改
			    	  ExternalInterface.call("showEditMetaData", curModelId);
			    }else if(menuId=="operNodeDataMap_addSys"){//增加系统
			    	  ExternalInterface.call("showAddSystemLevelMetaData", this.model.modelId, this.model.modelType, "System");
			    }else if(menuId=="operNodeDataMap_addSubLevel"){//增加子层次
			    	  ExternalInterface.call("showAddSystemLevelMetaData", this.model.modelId, this.model.modelType, "SystemLevel");
			    }else if(menuId=="operNodeDataMap_cloneSysLevel"){//克隆系统层次
			    	  ExternalInterface.call("showCloneMetaData", this.model.parentmdid, this.model.parentmdmodel, this.model.modelType);
			    }
            return;
        }

        public function onCustomRightClickHandler(event:MouseEvent):void
        {
        	//trace("[onCustomRightClickHandler]");
        	//避免事件继续冒泡，解决多个关联多谢层叠的事件干扰问题
        	event.stopPropagation();
        	
        	//清除定制鼠标
        	CursorManager.removeAllCursors();
        	removeRightClickMenu();
        	  
        	var menuItemData:String;
          
            
        	menuItemData = "<root>" ; 
        	menuItemData+="<node label=\"查询\" />" ;
    	 	rightClickMenuHandlerId.push("searchDataMap");
    	 	if (this.canDel)
            {
            	menuItemData+="<node label=\"删除\" />" ;
                rightClickMenuHandlerId.push("operNodeDataMap_delete");
            }
            if (this.canModify)
            {
            	menuItemData+="<node label=\"修改\" />" ;
                rightClickMenuHandlerId.push("operNodeDataMap_modify");
            }
            if (this.canAdd)
            {
            	menuItemData+="<node label=\"增加系统\" />" ;
                rightClickMenuHandlerId.push("operNodeDataMap_addSys");
                menuItemData+="<node label=\"增加子层次\" />" ;
                rightClickMenuHandlerId.push("operNodeDataMap_addSubLevel");
                menuItemData+="<node label=\"克隆系统层次\" />" ;
                rightClickMenuHandlerId.push("operNodeDataMap_cloneSysLevel");
            }
            
    	 	menuItemData+="</root>";
           
            
            rightClickMenu=Menu.createMenu(this.model,menuItemData,false);
  			rightClickMenu.addEventListener("itemClick", this.rightClickMenuItemHandler);
			rightClickMenu.labelField = "@label";
  			var point:Point = new Point(mouseX,mouseY);   
		    point = localToGlobal(point);    
		   // trace("[onCustomRightClickHandler]"+rightClickMenu+"<-->"+point);
		    rightClickMenu.show(point.x,point.y);
		    return ;
        }
        
    }
}
