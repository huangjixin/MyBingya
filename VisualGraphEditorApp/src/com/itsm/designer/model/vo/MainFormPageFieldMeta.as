package com.itsm.designer.model.vo
{
	[Bindable]
	[RemoteClass(alias="org.wbase.framework.form.mainform.MainFormPageFieldMeta")]
	public class MainFormPageFieldMeta
	{
		public var  table:String;
		public var  field:String;
		public var  name:String;
		public var  displayName:String;
		public var editDisplay:Boolean;
		public var viewDisplay:Boolean;
		public var listDisplay:Boolean;
		public var queryCondDisplay:Boolean;
		public var  colspan:int;
		public var  view:String;
		public var  edit:String;
		public var  list:String;
		public var  queryCond:String;
		public var   order:int;
		public var   require:int;
		public var  defaultValue:String;
		public var  type:String;
		public var  extProp1:String;
		public var  extProp2:String;
		public var  extProp3:String;
		
		public function MainFormPageFieldMeta()
		{
		}
	}
}