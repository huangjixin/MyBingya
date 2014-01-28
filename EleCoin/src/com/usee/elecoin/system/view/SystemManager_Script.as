import com.usee.elecoin.system.view.MenuManager;
import com.usee.elecoin.system.view.RoleManager;
import com.usee.elecoin.system.view.UserManager;

import flash.display.DisplayObject;
import flash.events.Event;

import mx.collections.ArrayCollection;
import mx.collections.XMLListCollection;
import mx.core.Container;

import spark.components.NavigatorContent;

private var _secondMenuXmllist:XMLListCollection;

/**
 * 菜单数组。
 */
private var menuNavArrayList:ArrayCollection = new ArrayCollection();

[Bindable(event="secondMenuXmllistChange")]
/**
 * 顶级菜单xml数组。 
 */
public function get secondMenuXmllist():XMLListCollection
{
	return _secondMenuXmllist;
}

/**
 * @private
 */
public function set secondMenuXmllist(value:XMLListCollection):void
{
	if( _secondMenuXmllist !== value)
	{
		_secondMenuXmllist = value;
		this.dispatchEvent(new Event("secondMenuXmllistChange"));
//		this.callLater(storgeMenuNav,[this.viewStatck]);
//		this.callLater(filterMenuNav,[this.secondMenuXmllist]);
		this.callLater(loadMenuNav,[this.viewStatck]);
	}
}

/**
 * 存储菜单内容。 
 * @param event
 * 
 */
protected function loadMenuNav(container:Container):void
{
	container.removeAllElements();
	for each (var xml:XML in secondMenuXmllist) 
	{
		if(xml.@name == "用户管理"){
			var userManager:UserManager = new UserManager();
			container.addElement(userManager);
		}else if(xml.@name == "角色管理"){
			var roleManager:RoleManager = new RoleManager();
			container.addElement(roleManager);
		}else if(xml.@name == "菜单管理"){
			var menuManager:MenuManager = new MenuManager();
			container.addElement(menuManager);
		} 
	}
}

protected function storgeMenuNav(container:Container):void
{
	var nav:NavigatorContent;
	for (var i:int = 0; i < container.numElements; i++) 
	{
		nav = container.getElementAt(i) as NavigatorContent;
		if(!menuNavArrayList.contains(nav)){
			menuNavArrayList.addItem(nav);
		}
		if(nav.hasOwnProperty("viewStatck")){
			var displayObject:DisplayObject = nav["viewStatck"];
			if(displayObject){
				storgeMenuNav(displayObject as Container);
			}
		}
	}
}

/**
 * 过滤菜单内容。 
 * @param event
 * 
 */
protected function filterMenuNav(xmlListCollection:XMLListCollection):void
{
	var nav:NavigatorContent;
	for (var i:int = 0; i < menuNavArrayList.length; i++) 
	{
		nav = menuNavArrayList.getItemAt(i) as NavigatorContent;
		var flag:Boolean = false;
		for each (var xml:XML in xmlListCollection) 
		{
			var name:String = xml.@name;
			if(name == nav.label){ //name == nav.name后期要用这样。
				flag= true;
				break;
			}
		}
		if(!flag){
			if(viewStatck.contains(nav)){
				viewStatck.removeElement(nav);
			}
		}else{
			if(!viewStatck.contains(nav)){
				viewStatck.addElementAt(nav,i);
				/*if(nav.hasOwnProperty("secondMenuXmllist")){
					nav["secondMenuXmllist"] = new XMLListCollection(xml.children()); 
				}
				if(nav.hasOwnProperty("viewStatck")){
				var displayObject:DisplayObject = nav["viewStatck"];
				if(displayObject){
				filterMenuNav(new XMLListCollection(xml.children()));
				}
				}*/
			}else{
				/*if(nav.hasOwnProperty("secondMenuXmllist")){
					nav["secondMenuXmllist"] = new XMLListCollection(xml.children()); 
				}
				
				if(nav.hasOwnProperty("viewStatck")){
				var displayObject:DisplayObject = nav["viewStatck"];
				if(displayObject){
				filterMenuNav(new XMLListCollection(xml.children()));
				}
				}*/
			}
		}
	}
	
	this.viewStatck.visible = true;//过滤完了菜单把导航器设置为可视。
}