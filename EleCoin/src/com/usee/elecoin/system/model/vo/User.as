package com.usee.elecoin.system.model.vo
{
	[RemoteClass(alias="com.bingya.domain.system.User")]      
	[Bindable]  
	public class User  
	{  
		public var id:String;  
		public var username:String;  
		public var password:String;  
		public var status:int;  
		public var description:String;  
		public var enabled:Boolean;  
		public var createdate:Date;  
		
		public function User()  
		{  
			
		}  
	}  
}