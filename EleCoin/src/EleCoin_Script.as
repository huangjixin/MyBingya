import com.usee.elecoin.system.model.vo.User;

import flash.events.MouseEvent;

import mx.collections.ArrayCollection;
import mx.collections.XMLListCollection;
import mx.controls.Alert;
import mx.core.FlexGlobals;
import mx.events.FlexEvent;
import mx.rpc.events.FaultEvent;
import mx.rpc.events.ResultEvent;

/**
 * 初始化。
 */
protected function application1_creationCompleteHandler(event:FlexEvent):void
{
	//				testRemoteServerImpl.getStr();
	this.currentState = "login";
	//				
	//				userService.login("admin","123");
}

protected function getStrResultHandler(event:ResultEvent):void
{
	Alert.show(event.result.toString(),"调用成功");
}

protected function getStrFaultHandler(event:FaultEvent):void
{
	Alert.show(event.fault.toString(),"调用失败");
}

protected function login_resultHandler(event:ResultEvent):void
{
	resetBtn_clickHandler(null);//重置；
	var user:User = event.result as User;
	if(user){
		this.userService.getMenuByUserId(user.id);
	}
}

protected function login_faultHandler(event:FaultEvent):void
{
	Alert.show(event.fault.toString());
}

protected function getMenuByUserId_resultHandler(event:ResultEvent):void
{
	this.currentState = "logon";
	var xmlStr:String = event.result as String;
	var xml:XML = new XML(xmlStr);
	trace(xml.toString());
	var xmllist:XMLList = xml.children();
	this.menuBar.dataProvider = xmllist;
	this.buttonBar.dataProvider= new XMLListCollection(xmllist);
}

protected function getMenuByUserId_faultHandler(event:FaultEvent):void
{
	Alert.show(event.fault.toString());
}

//-------------------------------------------------------------------------
//----逻辑函数
//-------------------------------------------------------------------------

//-------------------------------------------------------------------------
//----界面响应函数
//-------------------------------------------------------------------------
/**
 * 登录
 */ 
protected function loginBtn_clickHandler(event:MouseEvent):void
{
	this.userService.login(this.usernameInput.text,this.passwordInput.text);
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
}
