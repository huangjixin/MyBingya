package com.usee.elecoin.content.model.vo
{
	[RemoteClass(alias="com.bingya.domain.system.Comment")]   
	[Bindable]  
	public class Comment  
	{  
		
		private var _id:String;  
		private var _content:String;  
		private var _tbArticleId:String;  
		private var _parentid:String;  
		
		
		public function Comment()  
		{  
			
		}  
		
		public function get id():String{  
			return _id;  
		}  
		
		public function set id(pData:String):void{  
			_id=pData;  
		}  
		
		public function get content():String{  
			return _content;  
		}  
		
		public function set content(pData:String):void{  
			_content=pData;  
		}  
		
		public function get tbArticleId():String{  
			return _tbArticleId;  
		}  
		
		public function set tbArticleId(pData:String):void{  
			_tbArticleId=pData;  
		}  
		
		public function get parentid():String{  
			return _parentid;  
		}  
		
		public function set parentid(pData:String):void{  
			_parentid=pData;  
		}  
		
		
		
	}  
}  