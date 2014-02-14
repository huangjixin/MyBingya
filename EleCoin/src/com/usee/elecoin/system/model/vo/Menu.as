package com.usee.elecoin.system.model.vo
{
	[RemoteClass(alias="com.bingya.domain.system.Menu")]	
	[Bindable]
	public class Menu
	{

		private var _id:String;
		private var _name:String;
		private var _description:String;
		private var _path:String;
		private var _parentid:String;
		private var _createdate:Date;
		private var _icon:String;

		public function Menu()
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

		public function get path():String{
			return _path;
		}

		public function set path(pData:String):void{
			_path=pData;
		}

		public function get parentid():String{
			return _parentid;
		}

		public function set parentid(pData:String):void{
			_parentid=pData;
		}

		public function get createdate():Date{
			return _createdate;
		}

		public function set createdate(pData:Date):void{
			_createdate=pData;
		}

		public function get icon():String{
			return _icon;
		}

		public function set icon(pData:String):void{
			_icon=pData;
		}
	}
}