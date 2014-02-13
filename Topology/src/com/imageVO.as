package com
{
	//##################################################################
	//#
	//#		VO to hold image path. and vo can be used and passed to
	//#		any item renderer
	//#
	//##################################################################
	
	public class imageVO
	{
		public var imagePath:String;
		public var source:String;
		public var statePic:String;
		public var healthPic:String;
		public var label:String;
		public var rid:String;
		
		public function imageVO(imagePath:String=null)
		{
			super();
			
			this.imagePath = imagePath;
		}

	}
}