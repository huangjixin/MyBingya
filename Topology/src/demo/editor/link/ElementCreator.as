package demo.editor.link
{
	import flash.events.MouseEvent;
	
	import twaver.*;
	import twaver.network.*;

	public class ElementCreator extends ActionTile implements  IElementCreator
	{
		private var _styles:Array;
		private var _elementClass:Class=Node;
		
		public function get elementClass():Class{
			return this._elementClass;
		}
		
		public function set elementClass(elementClass:Class):void{
			this._elementClass=elementClass;
		}
		
		public function set styles(styles:Array):void{
			this._styles=styles;
		}
		
		public function addStyle(name:String,value:*):void{
			this._styles.push([name,value]);
		}
		
		public function createElement(evt:MouseEvent,network:Network):IElement{
			var element:IElement = new elementClass();
			element.parent = network.currentSubNetwork;
			element.name=label;
			element.icon = imageName;
			element.setStyle(Styles.OUTER_STYLE, Consts.OUTER_STYLE_GLOW);
			if(shapeType){
				element.setStyle(Styles.CONTENT_TYPE,Consts.CONTENT_TYPE_VECTOR);
				element.setStyle(Styles.VECTOR_SHAPE, shapeType);
			}
			if(_styles){
				for each(var style:* in _styles){
					element.setStyle(style[0],style[1]);
				}
			}
			if(element is Node){
			(element as Node).image=imageName;
				if(network){
					(element as Node).centerLocation=network.getLogicalPoint(evt);
				}
			}
			return element;
		}
	}
}