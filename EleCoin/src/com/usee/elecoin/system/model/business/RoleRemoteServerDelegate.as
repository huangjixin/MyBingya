/***********************************************
 **** 版权声明处 **
 ****  为了方便阅读和维护，请严格遵守相关代码规范，谢谢   ****
 *******************************************/
package com.usee.elecoin.system.model.business
{
	
	import com.usee.elecoin.common.Global;
	import com.usee.elecoin.common.Page;
	import com.usee.elecoin.system.model.vo.Role;
	
	import mx.rpc.IResponder;
	import mx.rpc.remoting.mxml.RemoteObject;

	/*******************************************
	 **** huangjixin,2012-5-24,下午1:25:36 **
	 **** 大厅展示远程委托类，用于远程交互调用  **
	 *******************************************/
	public class RoleRemoteServerDelegate
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
		public function RoleRemoteServerDelegate(pResponder : IResponder)
		{
			_service = new RemoteObject();  
			_service.endpoint = Global.getInstance().endPoint;  // 端点；
			_service.destination = "roleServiceImpl";        // 目标对象；
			_service.makeObjectsBindable=true;  
			_service.showBusyCursor=true;
			
			_responder = pResponder;
		}//构造函数结束
		
		//_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
		// 相关事件响应函数和逻辑函数存放处
		//_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
		
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

		/**
		 * 添加用户 
		 * @param Role
		 * 
		 */
		public function  insert( Role:Role):void
		{
			var call:Object = _service.insert( Role);  
			call.addResponder(_responder);  
		}
		
		/**
		 * 修改用户 
		 * @param Role
		 * 
		 */
		public function  update( Role:Role):void
		{
			var call:Object = _service.update( Role);  
			call.addResponder(_responder);  
		}
		
		/**
		 * 修改用户 
		 * @param Role
		 * 
		 */
		public function  deleteByPrimaryKey( id:String):void
		{
			var call:Object = _service.deleteByPrimaryKey(id);  
			call.addResponder(_responder);  
		}
		
		/**
		 * 修改用户 
		 * @param Role
		 * 
		 */
		public function  selectAll():void
		{
			var call:Object = _service.selectAll();  
			call.addResponder(_responder);  
		}
		
		public function  getStr():void
		{
			var call:Object = _service.getStr();  
			call.addResponder(_responder);  
		}
		
	}//类结束
}//包结束