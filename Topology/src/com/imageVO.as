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
		
		public function imageVO(imagePath:String)
		{
			super();
			
			this.imagePath = imagePath;
		}

	}
}