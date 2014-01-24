package com.usee.elecoin.icon
{
	import spark.components.Image;
	
	public class EmbeddedIcons 
	{
		[Bindable]
		[Embed(source="system/system.png")]
		static public var system:Class;
		
		public static function getImageClass(type:String):Class {
			var iconClass:Class = EmbeddedIcons[type];
			return iconClass;
		}
	}
}
