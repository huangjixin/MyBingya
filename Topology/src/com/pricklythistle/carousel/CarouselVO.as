package com.pricklythistle.carousel
{
	//##################################################################
	//#
	//#		Class to hold x, y and z values for each item in carousel
	//#		also calculates position and scale based on angle and elevation
	//#
	//##################################################################
	
	import com.pricklythistle.utils.MathUtil;
	
	import flash.display.DisplayObject;
	
	import mx.core.IDataRenderer;
	
	public class CarouselVO
	{
		public var renderer:IDataRenderer;
		public var x:Number;
		public var y:Number;
		public var z:Number;
		public var itemWidth:Number;
		public var itemHeight:Number;
		public var angleOffset:Number;
		public var data:Object;
		
		public function calculatePosition(rotation:Number,elevation:Number,yZero:Number,
			width:Number,height:Number,
			renderWidth:Number,renderHeight:Number, 
			frontScale:Number, backScale:Number):void
		{
			//calculates x, y, z and size from angle, elevation and size of carousel.
			
			rotation = rotation+90;
			var radius:Number = (width - (renderWidth*2))/2;
			var angle:Number = rotation + angleOffset;
			
			angle = MathUtil.degreeToRadian(angle);
			
			var zOffset:Number = (radius * Math.sin(angle));
			z = radius + zOffset;
			var scale:Number = ((z/(radius*2))*(frontScale-backScale)) + backScale;
			
			x = radius * Math.cos(angle);
			x += renderWidth + radius;
			y = yZero + elevation*(zOffset/radius);
			
			var displayItem:DisplayObject = renderer as DisplayObject;
			
			itemWidth = scale*(renderWidth);
			itemHeight = scale*(renderHeight);
			
			displayItem.width = itemWidth;
			displayItem.height = itemHeight;
			
			displayItem.x = x - (itemWidth/2);
			displayItem.y = y - (itemHeight/2);
			
			//trace("displayItem.x: " + displayItem.x + " displayItem.y: " + displayItem.y + " x: " + x + " y: " + y + " itemWidth: " + itemWidth + " itemHeight: " + itemHeight);
		}
	}
}