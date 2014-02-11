package com.usee.elecoin.system.model
{
	
	import com.usee.elecoin.common.Page;
	import com.usee.elecoin.system.controller.MySqlRemoteServerEvent;
	import com.usee.elecoin.system.model.business.MySqlRemoteServerDelegate;
	
	import flash.events.EventDispatcher;
	
	import mx.controls.Alert;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	[Bindable]
	/**
	 *  
	 * @author 黄记新
	 * 
	 */
	public class MySqlRemoteServerProxy  extends EventDispatcher
	{
		public function MySqlRemoteServerProxy()
		{
		}
		
		/**
		 * 备份，传入路径 
		 * @param path
		 * 
		 */
		public function backup(path:String=null):void  
		{  
			var delegate:MySqlRemoteServerDelegate = new MySqlRemoteServerDelegate(new Responder(backupResult, backupFault));  
			delegate.backup(path);
		}
		
		private function backupResult(event:ResultEvent):void
		{
			dispatchEvent(new MySqlRemoteServerEvent(MySqlRemoteServerEvent.backupResult,event.result)); 
			Alert.show(event.result.toString());
		}
		
		private function backupFault(event:FaultEvent):void  
		{  
			dispatchEvent(new MySqlRemoteServerEvent(MySqlRemoteServerEvent.backupFault,event.fault));
			Alert.show(event.fault.toString());
		} 
		
		/**
		 * 备份，传入路径 
		 * @param path
		 * 
		 */
		public function restore(path:String):void  
		{  
			var delegate:MySqlRemoteServerDelegate = new MySqlRemoteServerDelegate(new Responder(restoreResult, restoreFault));  
			delegate.restore(path);
		}
		
		private function restoreResult(event:ResultEvent):void
		{
			dispatchEvent(new MySqlRemoteServerEvent(MySqlRemoteServerEvent.restoreResult,event.result)); 
			Alert.show(event.result.toString());
		}
		
		private function restoreFault(event:FaultEvent):void  
		{  
			dispatchEvent(new MySqlRemoteServerEvent(MySqlRemoteServerEvent.restoreFault,event.fault));
			Alert.show(event.fault.toString());
		} 
		
	}
}