package com.usee.elecoin.content.model.vo
{
	[RemoteClass(alias="com.bingya.domain.system.Article")]	
	[Bindable]
	public class Article
	{
		private var _id:String;  
		private var _title:String;  
		private var _author:String;  
		private var _content:String;  
		private var _description:String;  
		private var _tbCategoryId:String;  
		private var _createdate:Date;  
		private var _source:String;  
		
		public function Article()  
		{  
			
		}  
		
		public function get id():String{  
			return _id;  
		}  
		
		public function set id(pData:String):void{  
			_id=pData;  
		}  
		
		public function get title():String{  
			return _title;  
		}  
		
		public function set title(pData:String):void{  
			_title=pData;  
		}  
		
		public function get author():String{  
			return _author;  
		}  
		
		public function set author(pData:String):void{  
			_author=pData;  
		}  
		
		public function get content():String{  
			return _content;  
		}  
		
		public function set content(pData:String):void{  
			_content=pData;  
		}  
		
		public function get description():String{  
			return _description;  
		}  
		
		public function set description(pData:String):void{  
			_description=pData;  
		}  
		
		public function get tbCategoryId():String{  
			return _tbCategoryId;  
		}  
		
		public function set tbCategoryId(pData:String):void{  
			_tbCategoryId=pData;  
		}  
		
		public function get createdate():Date{  
			return _createdate;  
		}  
		
		public function set createdate(pData:Date):void{  
			_createdate=pData;  
		}  
		
		public function get source():String{  
			return _source;  
		}  
		
		public function set source(pData:String):void{  
			_source=pData;  
		}
	}
}