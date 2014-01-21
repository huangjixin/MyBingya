package com.itsm.configuration.model.vo
{
	[Bindable]
	[RemoteClass(alias="com.itsm.configuration.dao.pojo.ConfigurationItemVO")]
	public class ConfigurationItem
	{
		public var id:Number;
		public var CI_ID:Number;
		public var CI_CODE:String;//配置编号 自动生成
		public var CT:String;//资产类型	
		public var PN:String;//批次号
		public var CI_NAME:String;//资产名称
		public var PROVIDER:String;//供应商 
		public var BRAND:String;//品牌
		public var  MODEL:String;//型号
		public var  PRICE:Number;//单价  +加	
		public var STORAGE_DATE:String;//入库日期 
		public var CI_DESC:String;//资产描述
		public  var OWN_DEPT_ID:Number;//所属单位
		
		public function ConfigurationItem()
		{
		}
	}
}