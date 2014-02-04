import com.usee.elecoin.common.Page;
import com.usee.elecoin.system.controller.UserRemoteServerEvent;
import com.usee.elecoin.system.model.UserRemoteServerProxy;

import flash.events.Event;

import mx.controls.Alert;
import mx.events.FlexEvent;

private var userProxy:UserRemoteServerProxy = new UserRemoteServerProxy();

protected function navigatorcontent1_creationCompleteHandler(event:FlexEvent):void
{
	userProxy.query(this.page);
	
	userProxy.addEventListener(UserRemoteServerEvent.queryResult,onqueryResult);
	userProxy.addEventListener(UserRemoteServerEvent.queryFault,onqueryFault);
}

/**
 * 查询分页成功 
 * @param event
 * 
 */
protected function onqueryResult(event:UserRemoteServerEvent):void
{
	this.page = event.object as Page;
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
