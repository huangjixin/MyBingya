package com.hjx.graphic
{
	import flash.display.DisplayObject;
	import flash.events.Event;
	import flash.geom.Rectangle;
	
	import mx.core.UIComponent;
	import mx.events.MoveEvent;
	import mx.events.ResizeEvent;

	/**
	 * @date 2014-6-3,@author 黄记新
	 * 该节点元素用于渲染图形节点，继承自Renderer.
	 */
	[Style(name="backgroundColor", inherit="no", type="uint",format="Color")]
	[Style(name="borderColor", inherit="no", type="uint",format="Color")]
	[Style(name="color", inherit="yes", type="uint",format="Color")]
	[Style(name="selectedColor", inherit="yes", type="uint",format="Color")]
	[Style(name="selectedTextColor", inherit="yes", type="uint",format="Color")]
	[Style(name="toBeAddedPalette", inherit="yes", type="Class")]
	public class Node extends Renderer
	{
		private var _label:String;

		private var _links:Vector.<Link> = new Vector.<Link>();

		private var _incomingLinks:Vector.<Link> = new Vector.<Link>();

		private var _outgoingLinks:Vector.<Link> = new Vector.<Link>();

		//--------------------------------------------------------
		// public 公有变量声明处
		//--------------------------------------------------------
		[SkinPart(required="true")]
		/**
		 * 存放label标签等元素。 
		 */
		public var labelElement:DisplayObject;
		
		[SkinPart(required="true")]
		public var base:UIComponent;
		
		public function Node()
		{
			super();
		}
		
		[Bindable]
		public function get label():String
		{
			return _label;
		}
		
		public function set label(value:String):void
		{
			_label = value;
		}
		
		[Bindable]
		public function get links():Vector.<Link>
		{
			return _links;
		}
		
		public function set links(value:Vector.<Link>):void
		{
			_links = value;
		}
		
		[Bindable]
		public function get incomingLinks():Vector.<Link>
		{
			return _incomingLinks;
		}
		
		public function set incomingLinks(value:Vector.<Link>):void
		{
			_incomingLinks = value;
		}
		
		[Bindable]
		public function get outgoingLinks():Vector.<Link>
		{
			return _outgoingLinks;
		}
		
		public function set outgoingLinks(value:Vector.<Link>):void
		{
			_outgoingLinks = value;
		}
		
		public function getIncomingLinks():Vector.<Link>{
			return _incomingLinks;
		}
		
		public function getIncomingLinksCount():int{
			return _incomingLinks.length;
		}
		
		public function getLinks():Vector.<Link>{
			return this.incomingLinks.concat(outgoingLinks);
		}
		
		public function getLinksCount():int{
			return getIncomingLinksCount()+getOutgoingLinksCount();
		}
		
		public function getNodeOrBaseBounds(targetCoordinateSpace:DisplayObject):Rectangle{
			return this.getBounds(targetCoordinateSpace);
		}
		
		public function getOutgoingLinks():Vector.<Link>{
			return _outgoingLinks;
		}
		
		public function getOutgoingLinksCount():int{
			return _outgoingLinks.length;
		}
		
		public function clearLinks():void{
			this.incomingLinks.splice(0,this.incomingLinks.length);
			this.outgoingLinks.splice(0,this.outgoingLinks.length);
		}
		
		/**
		 * 刷新连线形状。 
		 * 
		 */
		public function invalidateLinkShape():void{
			for each (var incomingLink:Link in incomingLinks) 
			{
				incomingLink.invalidateShape();	
			}
			for each (var outgoingLink:Link in outgoingLinks) 
			{
				outgoingLink.invalidateShape();	
			}
		}
		
		/**
		 * 当位置变化或者大小变化的时候，重绘连线。 
		 * @param event
		 * 
		 */
		protected function baseGeometryChanged(event:Event):void
		{
			invalidateLinkShape();
		}
		
		/**
		 * 监控移动缩放，刷新连线。 
		 * @param partName
		 * @param instance
		 * 
		 */
		override protected function partAdded(partName:String, instance:Object):void{
			super.partAdded(partName, instance);
			if(instance == base){
				base.addEventListener(MoveEvent.MOVE,baseGeometryChanged);
				base.addEventListener(ResizeEvent.RESIZE,baseGeometryChanged);
			}
		}
		
		override protected function partRemoved(partName:String, instance:Object):void{
			super.partRemoved(partName, instance);
			if(instance == base){
				base.removeEventListener(MoveEvent.MOVE,baseGeometryChanged);
				base.removeEventListener(ResizeEvent.RESIZE,baseGeometryChanged);
			}
		}
		
	}
}