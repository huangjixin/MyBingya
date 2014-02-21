package com.usee.elecoin.content.model.vo
{
	[RemoteClass(alias="com.bingya.domain.system.Asset")]     
	[Bindable]  
	public class Asset  
	{  

		private var _id:String;  
		private var _name:String;  
		private var _path:String;  
		
		
		public function Asset()  
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
		
		public function get path():String{  
			return _path;  
		}  
		
		public function set path(pData:String):void{  
			_path=pData;  
		}  
	}
}