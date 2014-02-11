package com.usee.elecoin.system.controller
{
	import flash.events.Event;
	
	public class MySqlRemoteServerEvent extends Event
	{
		public static const backup:String = "backup";
		public static const backupResult:String = "backupResult";
		public static const backupFault:String = "backupFault";

		public static const restore:String = "restore";
		public static const restoreResult:String = "restoreResult";
		public static const restoreFault:String = "restoreFault";
		//_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
		// public 公有变量声明处
		//_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
		/**
		 *	事件派发捆绑数据； 
		 */
		public var object:Object;
		
		
		public function MySqlRemoteServerEvent(type:String, object:Object=null, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			this.object = object;
		}
	}
}