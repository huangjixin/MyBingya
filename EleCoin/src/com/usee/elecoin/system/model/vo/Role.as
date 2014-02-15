package com.usee.elecoin.system.model.vo  
{  
	[RemoteClass(alias="com.bingya.domain.system.Role")]      
	[Bindable]  
	public class Role  
	{  
		private var _id:String;  
		private var _name:String;  
		private var _description:String;  
		private var _createdate:String;  
		
		public static var object:Object = {"id":"id","name":"角色名","description":"描述","createdate":"登记日期"};
		public function Role()  
		{  
			
		}  
		
		public function get id():String{  
			return _id;  
		}  
		
		public function set id(pData:String):void{  
			_id=pData;  
		}  
		
		public function get name():String{  
			return _name;  
		}  
		
		public function set name(pData:String):void{  
			_name=pData;  
		}  
		
		public function get description():String{  
			return _description;  
		}  
		
		public function set description(pData:String):void{  
			_description=pData;  
		}  
		
		public function get createdate():String{  
			return _createdate;  
		}  
		
		public function set createdate(pData:String):void{  
			_createdate=pData;  
		}  
	}  
}  