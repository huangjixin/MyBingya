package com.usee.elecoin.common
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="com.bingya.util.Page")]
	[Bindable]
	public class Page
	{
		public var limit:int = 20; //每页显示条数
		public var start:int = 0;  //起始行号
		public var total:int = -1; //总数
		public var rows:ArrayCollection = new ArrayCollection(); //结果集
		public var page:int = 1;   //第几页
		
		public function Page()
		{
		}

		/*public function get total():int
		{
//			var value:int = (_total / limit) + (_total % limit > 0 ? 1 : 0);
//			return value;
			return _total;
		}

		public function set total(value:int):void
		{
			_total = value;
		}*/

	}
}