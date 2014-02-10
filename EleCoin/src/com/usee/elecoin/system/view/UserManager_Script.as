import com.usee.elecoin.common.Page;
import com.usee.elecoin.system.controller.UserRemoteServerEvent;
import com.usee.elecoin.system.model.UserRemoteServerProxy;
import com.usee.elecoin.system.model.vo.User;
import com.usee.elecoin.system.view.UserForm;

import flash.events.Event;
import flash.events.MouseEvent;

import mx.controls.Alert;
import mx.events.FlexEvent;
import mx.managers.PopUpManager;

private var userProxy:UserRemoteServerProxy = new UserRemoteServerProxy();
private var userForm:UserForm;

protected function navigatorcontent1_creationCompleteHandler(event:FlexEvent):void
{
	userProxy.query(this.page);
	
	userProxy.addEventListener(UserRemoteServerEvent.queryResult,onqueryResult);
	userProxy.addEventListener(UserRemoteServerEvent.queryFault,onqueryFault);
	userProxy.addEventListener(UserRemoteServerEvent.insertResult,oninsertResult);
	userProxy.addEventListener(UserRemoteServerEvent.insertFault,oninsertFault);
	userProxy.addEventListener(UserRemoteServerEvent.updateResult,onupdateResult);
	userProxy.addEventListener(UserRemoteServerEvent.updateFault,onupdateFault);
	userProxy.addEventListener(UserRemoteServerEvent.deleteByPrimaryKeyResult,ondeleteByPrimaryKeyResult);
	userProxy.addEventListener(UserRemoteServerEvent.deleteByPrimaryKeyFault,ondeleteByPrimaryKeyFault);
}

/**
 * 查询分页成功 
 * @param event
 * 
 */
protected function onqueryResult(event:UserRemoteServerEvent):void
{
	this.page = event.object as Page;
	/*if(this.page.page>this.page.total){
		this.page.page = this.page.total;
		queryBtn_clickHandler(null);
	}*/
}

/**
 *  查询分页失败。
 * @param event
 * 
 */
protected function onqueryFault(event:UserRemoteServerEvent):void
{
	Alert.show(event.object.toString());
}

protected function pagecomponent1_pageChangeHandler(event:Event):void
{
	userProxy.query(this.page,keyInput.text);
}

/**
 * 查询 
 * @param event
 * 
 */
protected function queryBtn_clickHandler(event:MouseEvent):void
{
	userProxy.query(this.page,keyInput.text);
}

/**
 * 添加用户 
 * @param event
 * 
 */
protected function addBtn_clickHandler(event:MouseEvent):void
{
	userForm = PopUpManager.createPopUp(this,UserForm) as UserForm;
	PopUpManager.centerPopUp(userForm);
	userForm.confirmBtn.addEventListener(MouseEvent.CLICK,onconfirmBtnClick);
}

/**
 * 
 * @param event
 * 
 */
protected function onconfirmBtnClick(event:MouseEvent):void
{
	var user:User = userForm.user;
	if(user.id && user.id!=""){
	
	}else{
//		user.createdate = new Date();
		userProxy.insert(user);
	}
}

protected function oninsertFault(event:UserRemoteServerEvent):void
{
	Alert.show(event.object.toString());
}

protected function oninsertResult(event:UserRemoteServerEvent):void
{
	PopUpManager.removePopUp(userForm);
	keyInput.text = "";
	queryBtn_clickHandler(null);
}

protected function updateBtn_clickHandler(event:MouseEvent):void
{
	userForm = PopUpManager.createPopUp(this,UserForm) as UserForm;
	userForm.user = dataGrid.selectedItem as User;
	PopUpManager.centerPopUp(userForm);
	userForm.confirmBtn.addEventListener(MouseEvent.CLICK,onconfirmBtnClick);
}

protected function onupdateFault(event:UserRemoteServerEvent):void
{
	Alert.show(event.object.toString());
}

protected function onupdateResult(event:UserRemoteServerEvent):void
{
	PopUpManager.removePopUp(userForm);
	keyInput.text = "";
	queryBtn_clickHandler(null);
}


/**
 * 删除 
 * @param event
 * 
 */
protected function deleteBtn_clickHandler(event:MouseEvent):void
{
	var user:User = dataGrid.selectedItem as User;
	userProxy.deleteByPrimaryKey(user.id);
}

protected function ondeleteByPrimaryKeyFault(event:UserRemoteServerEvent):void
{
	Alert.show(event.object.toString());
}

protected function ondeleteByPrimaryKeyResult(event:UserRemoteServerEvent):void
{
	keyInput.text = "";
	queryBtn_clickHandler(null);
}