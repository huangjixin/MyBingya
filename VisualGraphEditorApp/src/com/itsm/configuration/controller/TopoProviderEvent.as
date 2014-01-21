package com.itsm.configuration.controller
{
	import flash.events.Event;
	
	public class TopoProviderEvent extends Event
	{
		public static const TEST:String = "test";
		public static const TEST_RESULT:String = "testResult";
		public static const TEST_FAULT:String = "testFault";
		
		public static const GET_GRAPH_LAYOUT:String = "getGraphLayout";
		public static const GET_GRAPH_LAYOUT_RESULT:String = "getGraphLayoutResult";
		public static const GET_GRAPH_LAYOUT_FAULT:String = "getGraphLayoutFault";
		
		public static const SAVE_GRAPH_LAYOUT:String = "saveGraphLayout";
		public static const SAVE_GRAPH_LAYOUT_RESULT:String = "saveGraphLayoutResult";
		public static const SAVE_GRAPH_LAYOUT_FAULT:String = "saveGraphLayoutFault";
		
		public static const GET_UNLINK_ITEM:String = "getUnlinkItem";
		public static const GET_UNLINK_ITEM_RESULT:String = "getUnlinkItemResult";
		public static const GET_UNLINK_ITEM_FAULT:String = "getUnlinkItemFault";
		
		/**
		 *	事件派发捆绑数据； 
		 */
		public var object:Object;
		
		public function TopoProviderEvent(type:String, object:Object=null,bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			this.object = object;
		}
	}
}