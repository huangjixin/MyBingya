package com.usee.elecoin.system.model
{
	
	import com.usee.elecoin.common.Page;
	import com.usee.elecoin.system.controller.RoleRemoteServerEvent;
	import com.usee.elecoin.system.model.business.RoleRemoteServerDelegate;
	import com.usee.elecoin.system.model.vo.Role;
	
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
	public class RoleRemoteServerProxy  extends EventDispatcher
	{
		public function RoleRemoteServerProxy()
		{
		}
		
		/**
		 * 分页查询
		 * @param id
		 * 
		 */
		public function  query( page:Page,  key:String="",  orderCondition:String=""):void
		{  
			var delegate:RoleRemoteServerDelegate = new RoleRemoteServerDelegate(new Responder(queryResult, queryFault));  
			delegate.query( page,  key,  orderCondition);
		}
		
		private function queryResult(event:ResultEvent):void
		{
			dispatchEvent(new RoleRemoteServerEvent(RoleRemoteServerEvent.queryResult,event.result)); 
		}
		
		private function queryFault(event:FaultEvent):void  
		{  
			dispatchEvent(new RoleRemoteServerEvent(RoleRemoteServerEvent.queryFault,event.fault));
			Alert.show(event.fault.toString());
		} 
		
		/**
		 * 添加用户
		 * @param id
		 * 
		 */
		public function  insert( role:Role):void
		{  
			var delegate:RoleRemoteServerDelegate = new RoleRemoteServerDelegate(new Responder(insertResult, insertFault));  
			delegate.insert( role);
		}
		
		private function insertResult(event:ResultEvent):void
		{
			dispatchEvent(new RoleRemoteServerEvent(RoleRemoteServerEvent.insertResult,event.result)); 
		}
		
		private function insertFault(event:FaultEvent):void  
		{  
			dispatchEvent(new RoleRemoteServerEvent(RoleRemoteServerEvent.insertFault,event.fault));
		} 
		
		/**
		 * 修改用户
		 * @param id
		 * 
		 */
		public function  update( role:Role):void
		{  
			var delegate:RoleRemoteServerDelegate = new RoleRemoteServerDelegate(new Responder(updateResult, updateFault));  
			delegate.update( role);
		}
		
		private function updateResult(event:ResultEvent):void
		{
			dispatchEvent(new RoleRemoteServerEvent(RoleRemoteServerEvent.updateResult,event.result)); 
		}
		
		private function updateFault(event:FaultEvent):void  
		{  
			dispatchEvent(new RoleRemoteServerEvent(RoleRemoteServerEvent.updateFault,event.fault));
		} 
		
		/**
		 * 删除用户
		 * @param id
		 * 
		 */
		public function   deleteByPrimaryKey( id:String):void
		{  
			var delegate:RoleRemoteServerDelegate = new RoleRemoteServerDelegate(new Responder(deleteByPrimaryKeyResult, deleteByPrimaryKeyFault));  
			delegate.deleteByPrimaryKey(id);
		}
		
		private function deleteByPrimaryKeyResult(event:ResultEvent):void
		{
			dispatchEvent(new RoleRemoteServerEvent(RoleRemoteServerEvent.deleteByPrimaryKeyResult,event.result)); 
		}
		
		private function deleteByPrimaryKeyFault(event:FaultEvent):void  
		{  
			dispatchEvent(new RoleRemoteServerEvent(RoleRemoteServerEvent.deleteByPrimaryKeyFault,event.fault));
		} 
		
		/**
		 * 删除用户
		 * @param id
		 * 
		 */
		public function   selectAll():void
		{  
			var delegate:RoleRemoteServerDelegate = new RoleRemoteServerDelegate(new Responder(selectAllResult, selectAllFault));  
			delegate.selectAll();
		}
		
		private function selectAllResult(event:ResultEvent):void
		{
			dispatchEvent(new RoleRemoteServerEvent(RoleRemoteServerEvent.selectAllResult,event.result)); 
		}
		
		private function selectAllFault(event:FaultEvent):void  
		{  
			dispatchEvent(new RoleRemoteServerEvent(RoleRemoteServerEvent.selectAllFault,event.fault));
		} 
	}
}