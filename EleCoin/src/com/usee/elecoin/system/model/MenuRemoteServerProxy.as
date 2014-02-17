package com.usee.elecoin.system.model
{
	
	import com.usee.elecoin.common.Page;
	import com.usee.elecoin.system.controller.MenuRemoteServerEvent;
	import com.usee.elecoin.system.model.business.MenuRemoteServerDelegate;
	import com.usee.elecoin.system.model.vo.Menu;
	
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
	public class MenuRemoteServerProxy  extends EventDispatcher
	{
		public function MenuRemoteServerProxy()
		{
		}
		
		/**
		 * 分页查询
		 * @param id
		 * 
		 */
		public function  query( page:Page,  key:String="",  orderCondition:String=""):void
		{  
			var delegate:MenuRemoteServerDelegate = new MenuRemoteServerDelegate(new Responder(queryResult, queryFault));  
			delegate.query( page,  key,  orderCondition);
		}
		
		private function queryResult(event:ResultEvent):void
		{
			dispatchEvent(new MenuRemoteServerEvent(MenuRemoteServerEvent.queryResult,event.result)); 
		}
		
		private function queryFault(event:FaultEvent):void  
		{  
			dispatchEvent(new MenuRemoteServerEvent(MenuRemoteServerEvent.queryFault,event.fault));
			Alert.show(event.fault.toString());
		} 
		
		/**
		 * 添加用户
		 * @param id
		 * 
		 */
		public function  insert( role:Menu):void
		{  
			var delegate:MenuRemoteServerDelegate = new MenuRemoteServerDelegate(new Responder(insertResult, insertFault));  
			delegate.insert( role);
		}
		
		private function insertResult(event:ResultEvent):void
		{
			dispatchEvent(new MenuRemoteServerEvent(MenuRemoteServerEvent.insertResult,event.result)); 
		}
		
		private function insertFault(event:FaultEvent):void  
		{  
			dispatchEvent(new MenuRemoteServerEvent(MenuRemoteServerEvent.insertFault,event.fault));
		} 
		
		/**
		 * 修改用户
		 * @param id
		 * 
		 */
		public function  update( role:Menu):void
		{  
			var delegate:MenuRemoteServerDelegate = new MenuRemoteServerDelegate(new Responder(updateResult, updateFault));  
			delegate.update( role);
		}
		
		private function updateResult(event:ResultEvent):void
		{
			dispatchEvent(new MenuRemoteServerEvent(MenuRemoteServerEvent.updateResult,event.result)); 
		}
		
		private function updateFault(event:FaultEvent):void  
		{  
			dispatchEvent(new MenuRemoteServerEvent(MenuRemoteServerEvent.updateFault,event.fault));
		} 
		
		/**
		 * 删除用户
		 * @param id
		 * 
		 */
		public function   deleteByPrimaryKey( id:String):void
		{  
			var delegate:MenuRemoteServerDelegate = new MenuRemoteServerDelegate(new Responder(deleteByPrimaryKeyResult, deleteByPrimaryKeyFault));  
			delegate.deleteByPrimaryKey(id);
		}
		
		private function deleteByPrimaryKeyResult(event:ResultEvent):void
		{
			dispatchEvent(new MenuRemoteServerEvent(MenuRemoteServerEvent.deleteByPrimaryKeyResult,event.result)); 
		}
		
		private function deleteByPrimaryKeyFault(event:FaultEvent):void  
		{  
			dispatchEvent(new MenuRemoteServerEvent(MenuRemoteServerEvent.deleteByPrimaryKeyFault,event.fault));
		} 
		
		/**
		 * 查询所有的菜单。
		 * @param id
		 * 
		 */
		public function   selectAll():void
		{  
			var delegate:MenuRemoteServerDelegate = new MenuRemoteServerDelegate(new Responder(selectAllResult, selectAllFault));  
			delegate.selectAll();
		}
		
		private function selectAllResult(event:ResultEvent):void
		{
			dispatchEvent(new MenuRemoteServerEvent(MenuRemoteServerEvent.selectAllResult,event.result)); 
		}
		
		private function selectAllFault(event:FaultEvent):void  
		{  
			dispatchEvent(new MenuRemoteServerEvent(MenuRemoteServerEvent.selectAllFault,event.fault));
		} 
		
		/**
		 * 查询xml菜单。
		 * @param id
		 * 
		 */
		public function   serializMenuToXml(roleId:String = null):void
		{  
			var delegate:MenuRemoteServerDelegate = new MenuRemoteServerDelegate(new Responder(serializMenuToXmlResult, serializMenuToXmlFault));  
			delegate.serializMenuToXml(roleId);
		}
		
		private function serializMenuToXmlResult(event:ResultEvent):void
		{
			dispatchEvent(new MenuRemoteServerEvent(MenuRemoteServerEvent.serializMenuToXmlResult,event.result)); 
		}
		
		private function serializMenuToXmlFault(event:FaultEvent):void  
		{  
			dispatchEvent(new MenuRemoteServerEvent(MenuRemoteServerEvent.serializMenuToXmlFault,event.fault));
		} 
	}
}