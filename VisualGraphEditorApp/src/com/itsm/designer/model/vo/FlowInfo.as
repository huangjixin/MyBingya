package com.itsm.designer.model.vo
{
	[Bindable]
	[RemoteClass(alias="com.itsm.flow.dao.pojo.FlowInfo")]
	public class FlowInfo
	{
		public var  PROCESSOR:Number;
		public var  TICKET_ID:Number;
		public var MEMO:String;
		public var FLOW_INFO_ID:Number;
		public var INFO_TYPE:Number;
		public var CONTENT:String;
		public var PROCESS_TIME:String;
		public var NODE_NAME:String;
		public var ORI_PROCESSOR:String;
		
		public function FlowInfo()
		{
		}
	}
}