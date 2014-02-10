package com.usee.elecoin.system.model
{
	
	import com.usee.elecoin.common.Page;
	import com.usee.elecoin.system.controller.UserRemoteServerEvent;
	import com.usee.elecoin.system.model.business.UserRemoteServerDelegate;
	import com.usee.elecoin.system.model.vo.User;
	
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
		
		/**
		 * 登录 
		 * @param username
		 * @param password
		 * 
		 */
		public function  login(username:String,password:String):void 
		{  
			var delegate:UserRemoteServerDelegate = new UserRemoteServerDelegate(new Responder(loginResult, loginFault));  
			delegate.login(username,password);
		}
		
		private function loginResult(event:ResultEvent):void
		{
			dispatchEvent(new UserRemoteServerEvent(UserRemoteServerEvent.loginResult,event.result)); 
		}
		
		private function loginFault(event:FaultEvent):void  
		{  
			dispatchEvent(new UserRemoteServerEvent(UserRemoteServerEvent.loginFault,event.fault));
			Alert.show(event.fault.toString());
		} 
		
		/**
		 * 获取菜单Id 
		 * @param id
		 * 
		 */
		public function getMenuByUserId(id:String):void  
		{  
			var delegate:UserRemoteServerDelegate = new UserRemoteServerDelegate(new Responder(getMenuByUserIdResult, getMenuByUserIdFault));  
			delegate.getMenuByUserId(id);
		}
		
		private function getMenuByUserIdResult(event:ResultEvent):void
		{
			dispatchEvent(new UserRemoteServerEvent(UserRemoteServerEvent.getMenuByUserIdResult,event.result)); 
		}
		
		private function getMenuByUserIdFault(event:FaultEvent):void  
		{  
			dispatchEvent(new UserRemoteServerEvent(UserRemoteServerEvent.getMenuByUserIdFault,event.fault));
			Alert.show(event.fault.toString());
		} 
		
		/**
		 * 分页查询
		 * @param id
		 * 
		 */
		public function  query( page:Page,  key:String="",  orderCondition:String=""):void
		{  
			var delegate:UserRemoteServerDelegate = new UserRemoteServerDelegate(new Responder(queryResult, queryFault));  
			delegate.query( page,  key,  orderCondition);
		}
		
		private function queryResult(event:ResultEvent):void
		{
			dispatchEvent(new UserRemoteServerEvent(UserRemoteServerEvent.queryResult,event.result)); 
		}
		
		private function queryFault(event:FaultEvent):void  
		{  
			dispatchEvent(new UserRemoteServerEvent(UserRemoteServerEvent.queryFault,event.fault));
			Alert.show(event.fault.toString());
		} 
		
		/**
		 * 添加用户
		 * @param id
		 * 
		 */
		public function  insert( user:User):void
		{  
			var delegate:UserRemoteServerDelegate = new UserRemoteServerDelegate(new Responder(insertResult, insertFault));  
			delegate.insert( user);
		}
		
		private function insertResult(event:ResultEvent):void
		{
			dispatchEvent(new UserRemoteServerEvent(UserRemoteServerEvent.insertResult,event.result)); 
		}
		
		private function insertFault(event:FaultEvent):void  
		{  
			dispatchEvent(new UserRemoteServerEvent(UserRemoteServerEvent.insertFault,event.fault));
		} 
		
		/**
		 * 修改用户
		 * @param id
		 * 
		 */
		public function  update( user:User):void
		{  
			var delegate:UserRemoteServerDelegate = new UserRemoteServerDelegate(new Responder(updateResult, updateFault));  
			delegate.update( user);
		}
		
		private function updateResult(event:ResultEvent):void
		{
			dispatchEvent(new UserRemoteServerEvent(UserRemoteServerEvent.updateResult,event.result)); 
		}
		
		private function updateFault(event:FaultEvent):void  
		{  
			dispatchEvent(new UserRemoteServerEvent(UserRemoteServerEvent.updateFault,event.fault));
		} 
		
		/**
		 * 删除用户
		 * @param id
		 * 
		 */
		public function   deleteByPrimaryKey( id:String):void
		{  
			var delegate:UserRemoteServerDelegate = new UserRemoteServerDelegate(new Responder(deleteByPrimaryKeyResult, deleteByPrimaryKeyFault));  
			delegate.deleteByPrimaryKey(id);
		}
		
		private function deleteByPrimaryKeyResult(event:ResultEvent):void
		{
			dispatchEvent(new UserRemoteServerEvent(UserRemoteServerEvent.deleteByPrimaryKeyResult,event.result)); 
		}
		
		private function deleteByPrimaryKeyFault(event:FaultEvent):void  
		{  
			dispatchEvent(new UserRemoteServerEvent(UserRemoteServerEvent.deleteByPrimaryKeyFault,event.fault));
		} 
	}
}