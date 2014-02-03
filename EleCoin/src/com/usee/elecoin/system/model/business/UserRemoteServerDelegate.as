/***********************************************
 **** 版权声明处 **
 ****  为了方便阅读和维护，请严格遵守相关代码规范，谢谢   ****
 *******************************************/
package com.usee.elecoin.system.model.business
{
	
	import com.usee.elecoin.common.Global;
	import com.usee.elecoin.common.Page;
	
	import mx.rpc.IResponder;
	import mx.rpc.remoting.mxml.RemoteObject;

	/*******************************************
	 **** huangjixin,2012-5-24,下午1:25:36 **
	 **** 大厅展示远程委托类，用于远程交互调用  **
	 *******************************************/
	public class UserRemoteServerDelegate
	{
		//_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
		// private 私有变量声明处，请以“_”开头定义变量
		// 例如：private var _example:String;
		//_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
		
		private var _responder : IResponder;  
		private var _service : Object; 
		//_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
		// public 公有变量声明处
		//_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
		
		
		//_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
		// 构造函数，初始化相关工作可以放在里面
		//_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
		public function UserRemoteServerDelegate(pResponder : IResponder)
		{
			_service = new RemoteObject();  
			_service.endpoint = Global.getInstance().endPoint;  // 端点；
			_service.destination = "userServiceImpl";        // 目标对象；
			_service.makeObjectsBindable=true;  
			_service.showBusyCursor=true;
			
			_responder = pResponder;
		}//构造函数结束
		
		//_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
		// 相关事件响应函数和逻辑函数存放处
		//_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
		/**
		 * 登录。 
		 * @param username
		 * @param password
		 * 
		 */
		public function  login(username:String,password:String):void
		{
			var call:Object = _service.login(username,password);  
			call.addResponder(_responder);  
		}
		
		/**
		 * 获取菜单。
		 * @param id
		 * 
		 */
		public function  getMenuByUserId(id:String):void
		{
			var call:Object = _service.getMenuByUserId(id);  
			call.addResponder(_responder);  
		}
		
		/**
		 * 分页查询。 
		 * @param page
		 * @param key
		 * @param orderCondition
		 * 
		 */
		public function  query( page:Page,  key:String=null,  orderCondition:String=null):void
		{
			var call:Object = _service.query( page,  key,  orderCondition);  
			call.addResponder(_responder);  
		}
		
		public function  getStr():void
		{
			var call:Object = _service.getStr();  
			call.addResponder(_responder);  
		}
		
	}//类结束
}//包结束