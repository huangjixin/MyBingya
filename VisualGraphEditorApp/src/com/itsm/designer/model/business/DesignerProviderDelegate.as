package com.itsm.designer.model.business
{
	import com.itsm.common.Global;
	
	import mx.rpc.IResponder;
	import mx.rpc.remoting.RemoteObject;

	public class DesignerProviderDelegate
	{
		private var _responder : IResponder;  
		private var _service : Object;
		
		public function DesignerProviderDelegate(pResponder : IResponder)
		{
			_service = new RemoteObject();  
			_service.endpoint = Global.getInstance().endPoint;  // 端点；
			_service.destination = "designerProvider";         // 目标对象；
			_service.makeObjectsBindable=true;  
			_service.showBusyCursor=true;
			
			_responder = pResponder;
		}
		
		public function getRoles(domainId:Number):void  
		{  
			var call:Object = _service.getRoles(domainId);  
			call.addResponder(_responder);  
		}
		
		public function getMainFormFields():void  
		{  
			var call:Object = _service.getMainFormFields();  
			call.addResponder(_responder);  
		}
		
		public function saveProcessDefinition(domainId:Number, procDefiName:String , version:String,  procDefiXml:String,  gpdXml:String,base64String:String):void  
		{  
			var call:Object = _service.saveProcessDefinition(domainId, procDefiName , version,  procDefiXml,  gpdXml,base64String);  
			call.addResponder(_responder);  
		}
		
		public function getAllProcessDefinitionInfo( domainId:Number):void  
		{  
			var call:Object = _service.getAllProcessDefinitionInfo(domainId);  
			call.addResponder(_responder);  
		}
		
		public function getProcessDefinition(domainId:Number, procDefiName:String , version:String):void  
		{  
			var call:Object = _service.getProcessDefinition(domainId, procDefiName , version);  
			call.addResponder(_responder);  
		}
		
		public function deployProcessDefinition(domainId:Number, procDefiName:String , version:String):void  
		{  
			var call:Object = _service.deployProcessDefinition(domainId, procDefiName , version);  
			call.addResponder(_responder);  
		}
		
		
		public function getProcessDefinitionById(processInstanceId:Number):void  
		{  
			var call:Object = _service.getProcessDefinitionByInstanceId(processInstanceId);  
			call.addResponder(_responder);  
		}
		
		
		public function getFlowInfo(ticketId:Number):void  
		{  
			var call:Object = _service.getFlowInfo(ticketId);  
			call.addResponder(_responder);  
		}
		
	}
}