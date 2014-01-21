package com.itsm.configuration.model
{
	import com.itsm.configuration.controller.TopoProviderEvent;
	import com.itsm.configuration.model.business.TopoProviderDelegate;
	
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class TopoProviderRemoteProxy extends EventDispatcher
	{
		public static const NAME:String = "TopoProviderRemoteProxy";
		
		public function TopoProviderRemoteProxy(target:IEventDispatcher=null)
		{
			super(target);
		}
		
		public function test():void  
		{  
			var delegate:TopoProviderDelegate = new TopoProviderDelegate(new Responder(testResult, testFault));  
			delegate.test();  
		}
		
		private function testResult(event:ResultEvent):void
		{
			var object:Object = event.result;
			dispatchEvent(new TopoProviderEvent(TopoProviderEvent.TEST_RESULT,object));
		}
		
		private function testFault(event:FaultEvent):void
		{
			var object:Object = event.fault;
			dispatchEvent(new TopoProviderEvent(TopoProviderEvent.TEST_FAULT,object));
		}
		
		public function saveGraphLayout(xml:String):void  
		{  
			var delegate:TopoProviderDelegate = new TopoProviderDelegate(new Responder(saveGraphLayoutResult, saveGraphLayoutFault));  
			delegate.saveGraphLayout(xml);  
		}
		
		private function saveGraphLayoutResult(event:ResultEvent):void
		{
			var object:Object = event.result;
			dispatchEvent(new TopoProviderEvent(TopoProviderEvent.SAVE_GRAPH_LAYOUT_RESULT,object));
		}
		
		private function saveGraphLayoutFault(event:FaultEvent):void
		{
			var object:Object = event.fault;
			dispatchEvent(new TopoProviderEvent(TopoProviderEvent.SAVE_GRAPH_LAYOUT_FAULT,object));
		}
		
		public function getGraphLayout():void  
		{  
			var delegate:TopoProviderDelegate = new TopoProviderDelegate(new Responder(getGraphLayoutResult, getGraphLayoutFault));  
			delegate.getGraphLayout();  
		}
		
		private function getGraphLayoutResult(event:ResultEvent):void
		{
			var object:Object = event.result;
			dispatchEvent(new TopoProviderEvent(TopoProviderEvent.GET_GRAPH_LAYOUT_RESULT,object));
		}
		
		private function getGraphLayoutFault(event:FaultEvent):void
		{
			var object:Object = event.fault;
			dispatchEvent(new TopoProviderEvent(TopoProviderEvent.GET_GRAPH_LAYOUT_FAULT,object));
		}
		
		public function getUnlinkItem( xml:String, itemType:String, keyword:String):void  
		{  
			var delegate:TopoProviderDelegate = new TopoProviderDelegate(new Responder(getUnlinkItemResult, getUnlinkItemFault));  
			delegate.getUnlinkItem( xml, itemType,  keyword);  
		}
		
		private function getUnlinkItemResult(event:ResultEvent):void
		{
			var object:Object = event.result;
			dispatchEvent(new TopoProviderEvent(TopoProviderEvent.GET_UNLINK_ITEM_RESULT,object));
		}
		
		private function getUnlinkItemFault(event:FaultEvent):void
		{
			var object:Object = event.fault;
			dispatchEvent(new TopoProviderEvent(TopoProviderEvent.GET_UNLINK_ITEM_FAULT,object));
		}
	}
}