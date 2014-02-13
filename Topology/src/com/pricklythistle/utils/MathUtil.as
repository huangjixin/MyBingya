package com.pricklythistle.utils
{
	//##################################################################
	//#
	//#		Simple class for converting between degrees and radians
	//#
	//##################################################################
	
	
	public class MathUtil
	{
		public static function radToDegree(radians:Number):Number
		{
			return radians*(180/Math.PI);
		}
		public static function degreeToRadian(degrees:Number):Number
		{
			return degrees*(Math.PI/180);
		}
	}
}