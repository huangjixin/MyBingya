import com.usee.elecoin.common.Page;
import com.usee.elecoin.system.controller.MenuRemoteServerEvent;
import com.usee.elecoin.system.model.MenuRemoteServerProxy;

import flash.events.Event;

import mx.controls.Alert;
import mx.events.FlexEvent;

private var menuProxy:MenuRemoteServerProxy = new MenuRemoteServerProxy();

[Bindable]
private var treeXMLSource:Object;
protected function navigatorcontent1_creationCompleteHandler(event:FlexEvent):void
{
	menuProxy.serializMenuToXml();
	
	menuProxy.addEventListener(MenuRemoteServerEvent.serializMenuToXmlResult,onserializMenuToXmlResult);
	menuProxy.addEventListener(MenuRemoteServerEvent.serializMenuToXmlFault,onserializMenuToXmlFault);
}

/**
 * 查询分页成功 
 * @param event
 * 
 */
protected function onserializMenuToXmlResult(event:MenuRemoteServerEvent):void
{
	var xmlStr:String = event.object as String;
	treeXMLSource = new XML(xmlStr);
}

/**
 *  查询分页失败。
 * @param event
 * 
 */
protected function onserializMenuToXmlFault(event:MenuRemoteServerEvent):void
{
	Alert.show(event.object.toString());
}
