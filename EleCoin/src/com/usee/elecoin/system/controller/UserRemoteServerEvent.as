package com.usee.elecoin.system.controller
{
	import flash.events.Event;
	
	public class UserRemoteServerEvent extends Event
	{
		public static const getStr:String = "getStr";
		public static const getStrResult:String = "getStrResult";
		public static const getStrFault:String = "getStrFault";

		public static const login:String = "login";
		public static const loginResult:String = "loginResult";
		public static const loginFault:String = "loginFault";

		public static const getMenuByUserId:String = "getMenuByUserId";
		public static const getMenuByUserIdResult:String = "getMenuByUserIdResult";
		public static const getMenuByUserIdFault:String = "getMenuByUserIdFault";

		public static const query:String = "query";
		public static const queryResult:String = "queryResult";
		public static const queryFault:String = "queryFault";

		public static const insert:String = "insert";
		public static const insertResult:String = "insertResult";
		public static const insertFault:String = "insertFault";

		public static const update:String = "update";
		public static const updateResult:String = "updateResult";
		public static const updateFault:String = "updateFault";

		public static const deleteByPrimaryKey:String = "deleteByPrimaryKey";
		public static const deleteByPrimaryKeyResult:String = "deleteByPrimaryKeyResult";
		public static const deleteByPrimaryKeyFault:String = "deleteByPrimaryKeyFault";
		
		public static const selectAll:String = "selectAll";
		public static const selectAllResult:String = "selectAllResult";
		public static const selectAllFault:String = "selectAllFault";
		
		public static const getRolesById:String = "getRolesById";
		public static const getRolesByIdResult:String = "getRolesByIdResult";
		public static const getRolesByIdFault:String = "getRolesByIdFault";
		
		public static const bandUserRole:String = "bandUserRole";
		public static const bandUserRoleResult:String = "bandUserRoleResult";
		public static const bandUserRoleFault:String = "bandUserRoleFault";
		//_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
		// public 公有变量声明处
		//_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
		/**
		 *	事件派发捆绑数据； 
		 */
		public var object:Object;
		
		
		public function UserRemoteServerEvent(type:String, object:Object=null, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			this.object = object;
		}
	}
}