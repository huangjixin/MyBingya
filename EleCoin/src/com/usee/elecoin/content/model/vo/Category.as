package com.usee.elecoin.content.model.vo
{
	[RemoteClass(alias="com.bingya.domain.system.Category")]      
	[Bindable]  
	public class Category  
	{  
		
		private var _id:String;  
		private var _name:String;  
		private var _description:String;  
		private var _parentid:String;  
		
		
		public function Category()  
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
		
		public function get parentid():String{  
			return _parentid;  
		}  
		
		public function set parentid(pData:String):void{  
			_parentid=pData;  
		}  
		
	}  
}  