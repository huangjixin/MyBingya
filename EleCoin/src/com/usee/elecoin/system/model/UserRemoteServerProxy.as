package com.usee.elecoin.system.model
{
	
	import com.usee.elecoin.system.controller.UserRemoteServerEvent;
	import com.usee.elecoin.system.model.business.UserRemoteServerDelegate;
	
	import flash.events.EventDispatcher;
	
	import mx.controls.Alert;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	[Bindable]
	public class UserRemoteServerProxy  extends EventDispatcher
	{
		public function UserRemoteServerProxy()
		{
		}
		
		public function getStr():void  
		{  
			var delegate:UserRemoteServerDelegate = new UserRemoteServerDelegate(new Responder(getStrResult, getStrFault));  
			delegate.getStr();
		}
		
		private function getStrResult(event:ResultEvent):void
		{
			dispatchEvent(new UserRemoteServerEvent(UserRemoteServerEvent.getStrResult,event.result)); 
			Alert.show(event.result.toString());
		}
		
		private function getStrFault(event:FaultEvent):void  
		{  
			dispatchEvent(new UserRemoteServerEvent(UserRemoteServerEvent.getStrFault,event.fault));
			Alert.show(event.fault.toString());
		} 
	}
}