package com.itsm.configuration.model.business
{
	import com.itsm.common.Global;
	
	import mx.rpc.IResponder;
	import mx.rpc.remoting.RemoteObject;

	public class TopoProviderDelegate
	{
		private var _responder : IResponder;  
		private var _service : Object; 
		
		public function TopoProviderDelegate(pResponder : IResponder)
		{
			_service = new RemoteObject();  
			_service.endpoint = Global.getInstance().endPoint;  // 端点；
			_service.destination = "topoProvider";         // 目标对象；
			_service.makeObjectsBindable=true;  
			_service.showBusyCursor=true;
			
			_responder = pResponder;
		}
		
		public function test():void  
		{  
			var call:Object = _service.test();  
			call.addResponder(_responder);  
		}
		
		public function saveGraphLayout(xml:String):void  
		{  
			var call:Object = _service.saveGraphLayout(xml);  
			call.addResponder(_responder);  
		}
		
		public function getGraphLayout():void  
		{  
			var call:Object = _service.getGraphLayout();  
			call.addResponder(_responder);  
		}
		
		
		public function getUnlinkItem( xml:String, itemType:String,  keyword:String):void  
		{  
			var call:Object = _service.getUnlinkItem( xml, itemType,  keyword);  
			call.addResponder(_responder);  
		}
		
	}
}