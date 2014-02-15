import com.usee.elecoin.common.Global;
import com.usee.elecoin.system.controller.UserRemoteServerEvent;
import com.usee.elecoin.system.model.UserRemoteServerProxy;
import com.usee.elecoin.system.model.vo.User;
import com.usee.elecoin.system.view.SystemManager;
import com.usee.elecoin.system.view.TestManager;

import flash.display.DisplayObject;
import flash.events.Event;
import flash.events.IOErrorEvent;
import flash.events.MouseEvent;
import flash.events.ProgressEvent;
import flash.filesystem.File;
import flash.filesystem.FileMode;
import flash.filesystem.FileStream;
import flash.net.FileFilter;

import mx.collections.ArrayCollection;
import mx.collections.ArrayList;
import mx.collections.XMLListCollection;
import mx.controls.Alert;
import mx.core.Container;
import mx.core.FlexGlobals;
import mx.events.FlexEvent;
import mx.rpc.events.FaultEvent;
import mx.rpc.events.ResultEvent;

import spark.components.NavigatorContent;
import spark.events.RendererExistenceEvent;

/**
 * 顶级菜单xml数组。 
 */
private var topMenuXmllist:XMLListCollection;

/**
 * 菜单数组。
 */
private var menuNavArrayList:ArrayCollection = new ArrayCollection();


private var userProxy:UserRemoteServerProxy = new UserRemoteServerProxy();
/**
 * 初始化，设置登录状态。
 */
protected function application1_creationCompleteHandler(event:FlexEvent):void
{
	//				testRemoteServerImpl.getStr();
	this.currentState = "login";//设置好登录状态。
	
	Global.getInstance().endPoint = "http://localhost:8080/Bingya/messagebroker/amf";
	//				
	//				userService.login("admin","123");
	
	userProxy.addEventListener(UserRemoteServerEvent.loginResult,onloginResult);
}

//-------------------------------------------------------------------------
//----远程交互函数
//-------------------------------------------------------------------------
protected function onloginResult(event:UserRemoteServerEvent):void
{
	if(event.object){
		this.currentState = "logon"; //更改登录状态。
		resetBtn_clickHandler(null);//重置登陆表单；
		//		this.callLater(storgeMenuNav,[this.viewStatck]);
		//	storgeMenuNav();//存储菜单以供增删。
		//------------	查询菜单。
		var user:User = event.object as User;
		if(user){
			this.userService.getMenuByUserId(user.id);
		}
		toolTipLabel.visible = false;
	}else{
		resetBtn_clickHandler(null);//重置登陆表单；
		toolTipLabel.visible = true;
		toolTipLabel.text = "用户名或者密码有误";
	}
}

/**
 * 登录失败。 
 * @param event
 * 
 */
protected function onloginFault(event:UserRemoteServerEvent):void
{
	Alert.show(event.object.toString());
}


/**
 * 登录成功。 
 * @param event
 * 
 */
protected function login_resultHandler(event:ResultEvent):void
{
	if(event.result){
		this.currentState = "logon"; //更改登录状态。
		resetBtn_clickHandler(null);//重置登陆表单；
//		this.callLater(storgeMenuNav,[this.viewStatck]);
		//	storgeMenuNav();//存储菜单以供增删。
		//------------	查询菜单。
		var user:User = event.result as User;
		if(user){
			this.userService.getMenuByUserId(user.id);
		}
		toolTipLabel.visible = false;
	}else{
		resetBtn_clickHandler(null);//重置登陆表单；
		toolTipLabel.visible = true;
		toolTipLabel.text = "用户名或者密码有误";
	}
	
}

/**
 * 登录失败。 
 * @param event
 * 
 */
protected function login_faultHandler(event:FaultEvent):void
{
	Alert.show(event.fault.toString());
}

/**
 * 提示，结果该返回这样的xml：<MenuItem>
  <MenuItem id="1" name="系统管理" icon="system">
    <MenuItem id="2" name="用户管理" parentId="1" icon="system"/>
    <MenuItem id="3" name="菜单管理" parentId="1" icon="system"/>
    <MenuItem id="4" name="角色管理" parentId="1" icon="system"/>
    <MenuItem id="8" name="菜单管理" parentId="1" icon="system"/>
  </MenuItem>
  <MenuItem id="5" name="test顶级菜单" icon="system">
    <MenuItem id="6" name="test顶级菜单1" parentId="5" icon="system"/>
    <MenuItem id="7" name="test顶级菜单2" parentId="5" icon="system"/>
  </MenuItem>
</MenuItem> 
 * @param event
 * 
 */
protected function getMenuByUserId_resultHandler(event:ResultEvent):void
{
	//-------------------------- 加载菜单
	var xmlStr:String = event.result as String;
	var xml:XML = new XML(xmlStr);
	var xmllist:XMLList = xml.children();
	topMenuXmllist = new XMLListCollection(xmllist);
//	this.menuBar.dataProvider = xmllist;
	this.topMenuList.dataProvider = topMenuXmllist;
	this.callLater(loadMenuNav,[this.viewStatck]);
//	filterMenuNav(topMenuXmllist);
//	this.buttonBar.dataProvider= new XMLListCollection(xmllist);
}

/**
 * 获取菜单失败。 
 * @param event
 * 
 */
protected function getMenuByUserId_faultHandler(event:FaultEvent):void
{
	Alert.show(event.fault.toString());
}

//-------------------------------------------------------------------------
//----逻辑函数
//-------------------------------------------------------------------------
/**
 * 加载菜单内容。 
 * @param event
 * 
 */
protected function loadMenuNav(container:Container):void
{
	container.removeAllElements();
	for each (var xml:XML in topMenuXmllist) 
	{
		if(xml.@name == "系统管理"){
			var systemManager:SystemManager = new SystemManager();
			systemManager.percentHeight = 100;
			systemManager.percentWidth = 100;
			container.addElement(systemManager);
			systemManager.secondMenuXmllist = new XMLListCollection(xml.children());
		}else if(xml.@name == "test顶级菜单"){
			var testManager:TestManager = new TestManager();
			testManager.percentHeight = 100;
			testManager.percentWidth = 100;
			container.addElement(testManager);
		} 
	}
	
	this.viewStatck.visible = true;//过滤完了菜单把导航器设置为可视。
}

/**
 * 存储菜单内容。 
 * @param event
 * 
 */
protected function storgeMenuNav(container:Container):void
{
	var nav:NavigatorContent;
	for (var i:int = 0; i < container.numElements; i++) 
	{
		nav = container.getElementAt(i) as NavigatorContent;
		if(!menuNavArrayList.contains(nav)){
			menuNavArrayList.addItem(nav);
		}
		/*if(nav.hasOwnProperty("viewStatck")){
			var displayObject:DisplayObject = nav["viewStatck"];
			if(displayObject){
				this.callLater(storgeMenuNav,[displayObject as Container]);
				storgeMenuNav(displayObject as Container);
			}
		}*/
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
				if(nav.hasOwnProperty("secondMenuXmllist")){
					nav["secondMenuXmllist"] = new XMLListCollection(xml.children()); 
				}
				/*if(nav.hasOwnProperty("viewStatck")){
					var displayObject:DisplayObject = nav["viewStatck"];
					if(displayObject){
						filterMenuNav(new XMLListCollection(xml.children()));
					}
				}*/
			}else{
				if(nav.hasOwnProperty("secondMenuXmllist")){
					nav["secondMenuXmllist"] = new XMLListCollection(xml.children()); 
				}
				
				/*if(nav.hasOwnProperty("viewStatck")){
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
//-------------------------------------------------------------------------
//----界面响应函数
//-------------------------------------------------------------------------
/**
 * 登录
 */ 
protected function loginBtn_clickHandler(event:MouseEvent):void
{
//	this.userService.login(this.usernameInput.text,this.passwordInput.text);
	userProxy.login(this.usernameInput.text,this.passwordInput.text);
}
/**
 * 重置
 */
protected function resetBtn_clickHandler(event:MouseEvent):void
{
	this.usernameInput.text=''; 
	this.passwordInput.text= '';
}

/**
 * 退出
 */
protected function logoutBtn_clickHandler(event:MouseEvent):void
{
	this.currentState = "login";
	
	this.viewStatck.visible = false;//过滤完了菜单把导航器设置为可视。
}

/**
 * 顶层菜单渲染器添加的时候 
 * @param event
 * 
 */
protected function topMenuList_rendererAddHandler(event:RendererExistenceEvent):void
{
	//-------------数据格式如下
//	<MenuItem id="1" name="系统管理" icon="system">
//		<MenuItem id="2" name="用户管理" parentId="1" icon="system"/>
//		<MenuItem id="3" name="菜单管理" parentId="1" icon="system"/>
//		<MenuItem id="4" name="角色管理" parentId="1" icon="system"/>
//		<MenuItem id="8" name="菜单管理" parentId="1" icon="system"/>
//	 </MenuItem>
	var xml:XML = event.data as XML;
}

/**
 * 顶层菜单渲染器移除的时候
 * @param event
 * 
 */
protected function topMenuList_rendererRemoveHandler(event:RendererExistenceEvent):void
{
	// TODO Auto-generated method stub
	
}