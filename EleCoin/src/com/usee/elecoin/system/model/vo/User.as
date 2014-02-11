package com.usee.elecoin.system.model.vo
{
	[RemoteClass(alias="com.bingya.domain.system.User")]      
	[Bindable]  
	public class User  
	{  
		public static var object:Object = {"username":"用户名","password":"密码","status":"状态","description":"描述","enabled":"enabled","createdate":"登记日期"};
		public var id:String;  
		public var username:String;  
		public var password:String;  
		public var status:int;  
		public var description:String;  
		public var enabled:Boolean;  
		public var createdate:String;  
		
		public function User()  
		{  
			
		}  
	}  
}