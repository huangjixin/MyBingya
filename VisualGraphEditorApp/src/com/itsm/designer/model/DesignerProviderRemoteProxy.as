package com.itsm.designer.model
{
	import com.itsm.designer.controller.DesignerProviderEvent;
	import com.itsm.designer.model.business.DesignerProviderDelegate;
	
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	
	public class DesignerProviderRemoteProxy extends EventDispatcher
	{
		public static const NAME:String = "DesignerProviderRemoteProxy";
		
		public function DesignerProviderRemoteProxy(target:IEventDispatcher=null)
		{
			super(target);
		}
		
		public function getRoles(domainId:Number):void  
		{  
			var delegate:DesignerProviderDelegate = new DesignerProviderDelegate(new Responder(getRolesResult, getRolesFault));  
			delegate.getRoles(domainId);   
		}
		
		private function getRolesFault(event:FaultEvent):void
		{
			var object:Object = event.fault;
			dispatchEvent(new DesignerProviderEvent(DesignerProviderEvent.GETROLES_FAULT,object));
		}
		
		private function getRolesResult(event:ResultEvent):void
		{
			var object:Object = event.result;
			dispatchEvent(new DesignerProviderEvent(DesignerProviderEvent.GETROLES_RESULT,object));
		}
		
		public function getMainFormFields():void  
		{  
			var delegate:DesignerProviderDelegate = new DesignerProviderDelegate(new Responder(getMainFormFieldsResult,getMainFormFieldsFault));  
			delegate.getMainFormFields();  
		}
		
		private function getMainFormFieldsFault(event:FaultEvent):void
		{
			var object:Object = event.fault;
			dispatchEvent(new DesignerProviderEvent(DesignerProviderEvent.GETMAINFORMFIELDS_FAULT,object));
		}
		
		private function getMainFormFieldsResult(event:ResultEvent):void
		{
			var object:Object = event.result;
			dispatchEvent(new DesignerProviderEvent(DesignerProviderEvent.GETMAINFORMFIELDS_RESULT,object));
		}
		
		public function saveProcessDefinition(domainId:Number, procDefiName:String , version:String,  procDefiXml:String,  gpdXml:String,base64String:String):void  
		{  
			var delegate:DesignerProviderDelegate = new DesignerProviderDelegate(new Responder(saveProcessDefinitionResult,saveProcessDefinitionFault));  
			delegate.saveProcessDefinition(domainId, procDefiName , version,  procDefiXml,  gpdXml,base64String);
		}
		
		private function saveProcessDefinitionFault(event:FaultEvent):void
		{
			var object:Object = event.fault;
			dispatchEvent(new DesignerProviderEvent(DesignerProviderEvent.SAVE_PROCESS_DEFINITION_FAULT,object));
		}
		
		private function saveProcessDefinitionResult(event:ResultEvent):void
		{
			var object:Object = event.result;
			dispatchEvent(new DesignerProviderEvent(DesignerProviderEvent.SAVE_PROCESS_DEFINITION_RESULT,object));
		}
		
		public function getAllProcessDefinitionInfo( domainId:Number):void  
		{  
			var delegate:DesignerProviderDelegate = new DesignerProviderDelegate(new Responder(getAllProcessDefinitionInfoResult,getAllProcessDefinitionInfoFault));  
			delegate.getAllProcessDefinitionInfo( domainId);
		}
		
		private function getAllProcessDefinitionInfoFault(event:FaultEvent):void
		{
			var object:Object = event.fault;
			dispatchEvent(new DesignerProviderEvent(DesignerProviderEvent.GET_ALL_PROCESS_DEFINITIONINFO_FAULT,object));
		}
		
		private function getAllProcessDefinitionInfoResult(event:ResultEvent):void
		{
			var object:Object = event.result;
			dispatchEvent(new DesignerProviderEvent(DesignerProviderEvent.GET_ALL_PROCESS_DEFINITIONINFO_RESULT,object));
		}
		
		public function getProcessDefinition(domainId:Number, procDefiName:String , version:String):void  
		{  
			var delegate:DesignerProviderDelegate = new DesignerProviderDelegate(new Responder(getProcessDefinitionResult,getProcessDefinitionFault));  
			delegate.getProcessDefinition(domainId, procDefiName , version); 
		}
		
		private function getProcessDefinitionFault(event:FaultEvent):void
		{
			var object:Object = event.fault;
			dispatchEvent(new DesignerProviderEvent(DesignerProviderEvent.GET_PROCESS_DEFINITION_FAULT,object));
		}
		
		private function getProcessDefinitionResult(event:ResultEvent):void
		{
			var object:Object = event.result;
			dispatchEvent(new DesignerProviderEvent(DesignerProviderEvent.GET_PROCESS_DEFINITION_RESULT,object));
		}
		
		public function deployProcessDefinition(domainId:Number, procDefiName:String , version:String):void  
		{  
			var delegate:DesignerProviderDelegate = new DesignerProviderDelegate(new Responder(deployProcessDefinitionResult,deployProcessDefinitionFault));  
			delegate.deployProcessDefinition(domainId, procDefiName , version); 
		}
		
		private function deployProcessDefinitionFault(event:FaultEvent):void
		{
			var object:Object = event.fault;
			dispatchEvent(new DesignerProviderEvent(DesignerProviderEvent.DEPLOY_PROCESS_DEFINITION_FAULT,object));
		}
		
		private function deployProcessDefinitionResult(event:ResultEvent):void
		{
			var object:Object = event.result;
			dispatchEvent(new DesignerProviderEvent(DesignerProviderEvent.DEPLOY_PROCESS_DEFINITION_RESULT,object));
		}
		
		public function getProcessDefinitionById(processInstanceId:Number):void  
		{  
			var delegate:DesignerProviderDelegate = new DesignerProviderDelegate(new Responder(getProcessDefinitionByIdResult,getProcessDefinitionByIdFault));  
			delegate.getProcessDefinitionById(processInstanceId); 
		}
		
		private function getProcessDefinitionByIdFault(event:FaultEvent):void
		{
			var object:Object = event.fault;
			dispatchEvent(new DesignerProviderEvent(DesignerProviderEvent.GET_PROCESS_DEFINITION_BYID_FAULT,object));
		}
		
		private function getProcessDefinitionByIdResult(event:ResultEvent):void
		{
			var object:Object = event.result;
			dispatchEvent(new DesignerProviderEvent(DesignerProviderEvent.GET_PROCESS_DEFINITION_BYID_RESULT,object));
		}
		
		public function getFlowInfo(ticketId:Number):void  
		{  
			var delegate:DesignerProviderDelegate = new DesignerProviderDelegate(new Responder(getFlowInfoResult,getFlowInfoFault));  
			delegate.getFlowInfo(ticketId); 
		}
		
		private function getFlowInfoFault(event:FaultEvent):void
		{
			var object:Object = event.fault;
			dispatchEvent(new DesignerProviderEvent(DesignerProviderEvent.GET_FLOW_INFO_FAULT,object));
		}
		
		private function getFlowInfoResult(event:ResultEvent):void
		{
			var object:Object = event.result;
			dispatchEvent(new DesignerProviderEvent(DesignerProviderEvent.GET_FLOW_INFO_RESULT,object));
		}
		
	}
}