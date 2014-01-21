package com.itsm.designer.controller
{
	import flash.events.Event;
	
	public class DesignerProviderEvent extends Event
	{
		public static const GETROLES:String = "getRoles";
		public static const GETROLES_RESULT:String = "getRolesResult";
		public static const GETROLES_FAULT:String = "getRolesFault";
		
		public static const GETMAINFORMFIELDS:String = "getMainFormFields";
		public static const GETMAINFORMFIELDS_RESULT:String = "getMainFormFieldsResult";
		public static const GETMAINFORMFIELDS_FAULT:String = "getMainFormFieldsFault";
		
		public static const SAVE_PROCESS_DEFINITION:String = "saveProcessDefinition";
		public static const SAVE_PROCESS_DEFINITION_RESULT:String = "saveProcessDefinitionResult";
		public static const SAVE_PROCESS_DEFINITION_FAULT:String = "saveProcessDefinitionFault";

		public static const GET_ALL_PROCESS_DEFINITIONINFO:String = "getAllProcessDefinitionInfo";
		public static const GET_ALL_PROCESS_DEFINITIONINFO_RESULT:String = "getAllProcessDefinitionInfoResult";
		public static const GET_ALL_PROCESS_DEFINITIONINFO_FAULT:String = "getAllProcessDefinitionInfoFault";
		
		public static const GET_PROCESS_DEFINITION:String = "getProcessDefinition";
		public static const GET_PROCESS_DEFINITION_RESULT:String = "getProcessDefinitionResult";
		public static const GET_PROCESS_DEFINITION_FAULT:String = "getProcessDefinitionFault";
		
		public static const DEPLOY_PROCESS_DEFINITION:String = "deployProcessDefinition";
		public static const DEPLOY_PROCESS_DEFINITION_RESULT:String = "deployProcessDefinitionResult";
		public static const DEPLOY_PROCESS_DEFINITION_FAULT:String = "deployProcessDefinitionFault";
		
		
		public static const GET_PROCESS_DEFINITION_BYID:String = "getProcessDefinitionById";
		public static const GET_PROCESS_DEFINITION_BYID_RESULT:String = "getProcessDefinitionByIdResult";
		public static const GET_PROCESS_DEFINITION_BYID_FAULT:String = "getProcessDefinitionByIdFault";
		
		
		public static const GET_FLOW_INFO:String = "getFlowInfo";
		public static const GET_FLOW_INFO_RESULT:String = "getFlowInfoResult";
		public static const GET_FLOW_INFO_FAULT:String = "getFlowInfoFault";
		
		/**
		 *	事件派发捆绑数据； 
		 */
		public var object:Object;
		
		public function DesignerProviderEvent(type:String, object:Object=null, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			this.object = object;
		}
	}
}