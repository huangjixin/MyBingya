package com.hjx.utils
{
	import flash.geom.Point;
	import flash.utils.Dictionary;
	import flash.utils.describeType;
	import flash.utils.getDefinitionByName;
	import flash.utils.getQualifiedClassName;
	
	import mx.collections.ArrayCollection;
	import mx.core.UIComponent;
	import mx.utils.ObjectUtil;

	/**
	 * @date 2014-6-4,@author 黄记新
	 */
	public class CloneUtil
	{
		private static var  excluded:Dictionary;
		
		public function CloneUtil()
		{
		}
		
		
		public static function clone(obj:Object):Object
		{
			var instance:Object = null;
			
			try {
				var xmlType:XML = describeType(obj);
				var typeName:String = xmlType.@name;
				if(isBasicTypeName(typeName))
					return obj;            
				if(typeName == "Array")
				{
					var arr:Array = new Array();
					for(var i:String in obj)
					{
						arr[i] = clone(obj[i]);
					}
					return arr;
				}
				else if(typeName.search("Vector") >= 0)
				{
					var vector:Vector = new Vector();
					for each(var item:Object in vector)
					{
						vector.push(clone(item));
					}
					return vector;
				}else if(typeName.search("ArrayCollection") >= 0)
				{
					var coll:ArrayCollection = new ArrayCollection();
					for each(var item1:Object in obj)
					{
						coll.addItem(clone(item1));
					}
					return coll;
				}else if(obj is Point){
					return Point(obj).clone();
				}
				
				var className:String = getQualifiedClassName(obj);
				var clazz:Class = Class(getDefinitionByName(className));
				
				instance = new clazz();
				
				cloneStyle(obj,instance);
				
				var options:Object = new Object();
				options["includeReadOnly"] = false;
				if(!excluded){
					excluded = new Dictionary();
				}
				var excludes:Array = excluded[className] as Array;
				if(excludes == null){
					excludes = getExcludedProperties(obj);
					excluded[className] = excludes;
				}
				
				var objInfo:Object = ObjectUtil.getClassInfo(obj, excludes, options);
				var fieldName:Array = objInfo["properties"] as Array; 
				for each(var q:QName in fieldName){
					if(xmlType.@isDynamic == "true")
					{
						instance[q.localName] = clone(obj[q.localName]);
					}
					else
					{
						var accs:XMLList = xmlType..accessor.(@name == q.localName);
						if(accs != null && accs.length() > 0 && (accs[0].@access == "readwrite" || accs[0].@access == "write")
							)
						{
							instance[q.localName] = clone(obj[q.localName]);
						}
					}
				} 
			}
			catch(e:ReferenceError)
			{
				trace(e);
			}
			catch(e:TypeError) 
			{
				trace(e);
			}   
			
			return instance;
		}
		
		
		protected static function getExcludedProperties(object:Object) : Array
		{
			if(object is UIComponent)
				return getRendererProperties();
			else
				return new Array();
		}
		
		private static var rendererProperties:Array = null;
		
		private static function getRendererProperties() : Array 
		{
			if(rendererProperties == null){
				rendererProperties = new Array();
				for each(var name:QName in ObjectUtil.getClassInfo(new UIComponent())["properties"]){
					var pname:String = name.localName;
					if(pname != "left" &&
						pname != "top" &&
						pname != "x" &&
						pname != "y" &&
						pname != "width" &&
						pname != "height")
						rendererProperties.push(pname);
				}
			}
			return rendererProperties;
		}
		public static function isBasicTypeName(typeName:String):Boolean
		{
			return (typeName == "String"
				|| typeName == "int"
				|| typeName == "uint"
				|| typeName == "Boolean"
				|| typeName == "Number"
				|| typeName == "null");
		}
		
		public static function cloneStyle(renderer:Object, cloneRenderer:Object):void
		{
			var describe:* = describeType(renderer);
			var objectMetadata:* = describe.metadata;
			var styleProp:XMLList = objectMetadata.(@name=="Style").arg.(@key=="name");
			for each (var xml:XML in styleProp) 
			{
				cloneRenderer.setStyle(xml.@value,renderer.getStyle(xml.@value));
			}
		}
	}
}