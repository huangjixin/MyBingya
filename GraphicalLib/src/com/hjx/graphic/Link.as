package com.hjx.graphic
{
	import flash.display.DisplayObject;
	import flash.events.Event;
	import flash.geom.Point;
	import flash.geom.Rectangle;
	
	import spark.primitives.Path;

	/**
	 * @date 2014-6-3,@author 黄记新
	 * 该连线继承自Renderer，用于渲染连线元素。
	 */
	public class Link extends Renderer
	{
		private var _startNode:Node;
		private var _endNode:Node;
		
		
		private var _fallbackEndPoint:Point;
		
		private var _fallbackStartPoint:Point;
		
		/**
		 * 连线的形状 
		 */
		private var _shapeType:String = LinkShapeType.STRAIGHT;
		/**
		 * 形状是否改变标志变量。 
		 */
		private var _shapeTypeChange:Boolean;
		
		private var linkTypeOrthogonal:String;
		
		/**
		 * 连线的起始位置。 
		 */
		private var _startConnectionArea:String = LinkConnectionArea.CENTER;
		/**
		 * 连线结束区域。 
		 */
		private var _endConnectionArea:String = LinkConnectionArea.CENTER;
		
		[SkinPart(required="false")]
		public var endArrow:Path;
		[SkinPart(required="true")]
		public var path:Path;
		[SkinPart(required="false")]
		public var startArrow:Path;
		
		[SkinPart(required="false")]
		/**
		 * 存放label标签等元素。 
		 */
		public var labelElement:DisplayObject;
		
		
		private var _shapePoints:Vector.<Point>;
		
		public function Link(startNode:Node=null,endNode:Node=null)
		{
			this.fallbackStartPoint = new Point(0, 0);
			this.fallbackEndPoint = new Point(0, 0);
			this._shapePoints = new Vector.<Point>();
			
			super();
			if(startNode){
				this.startNode = startNode;
			}
			if(endNode){
				this.endNode = endNode;
			}
		}
		
		//-------------------------------------------------------------------------
		//-- getter和setter函数
		//-------------------------------------------------------------------------
		/**
		 * 结束节点的连接区域。 
		 * @return 
		 * 
		 */
		[Bindable]
		[Inspectable(enumeration="left,right,top,bottom,center")]
		public function get endConnectionArea():String
		{
			return _endConnectionArea;
		}
		
		public function set endConnectionArea(value:String):void
		{
			_endConnectionArea = value;
			invalidateDisplayList();
		}
		
		/**
		 * 开始节点的连接区域。 
		 * @return 
		 * 
		 */
		[Bindable]
		[Inspectable(enumeration="left,right,top,bottom,center")]
		public function get startConnectionArea():String
		{
			return _startConnectionArea;
		}
		
		public function set startConnectionArea(value:String):void
		{
			_startConnectionArea = value;
			invalidateDisplayList();
		}
		
		[Bindable]
		public function get fallbackStartPoint():Point
		{
			return _fallbackStartPoint;
		}
		
		public function set fallbackStartPoint(value:Point):void
		{
			/*if (!value) 
			{
			throw new ArgumentError("参数类型错误");
			}*/
			
			_fallbackStartPoint = value;
			if (!this.startNode) 
			{
				this.invalidateShape();
			}
		}
		
		[Bindable]
		public function get fallbackEndPoint():Point
		{
			return _fallbackEndPoint;
		}
		
		public function set fallbackEndPoint(value:Point):void
		{
			/*if (!value) 
			{
			throw new ArgumentError("参数类型错误");
			}*/
			_fallbackEndPoint = value;
			if (!this.endNode) 
			{
				this.invalidateShape();
			}
		}
		
		[Bindable]
		[Inspectable(enumeration="straight,free,orthogonal,oblique")]
		public function get shapeType():String
		{
			return _shapeType;
		}
		
		public function set shapeType(value:String):void
		{
			_shapeType = value;
			_shapeTypeChange = true;
			this.invalidateShape();
		}
		
		[Bindable(event="endNodeChange")]
		/**
		 * 终止节点。 
		 */
		public function get endNode():Node
		{
			return _endNode;
		}
		
		/**
		 * @private
		 */
		public function set endNode(value:Node):void
		{
			if( _endNode !== value)
			{
				var index:int;
				/*var eNode:Node = this._endNode;
				if(eNode){
				index = eNode.incomingLinks.indexOf(this);
				if(index ==-1){
				eNode.incomingLinks.splice(index,1);
				}
				}*/
				_endNode = value;
				dispatchEvent(new Event("endNodeChange"));
				invalidateShape();
				
				index==-1;
				if(_endNode){
					fallbackEndPoint = null;
					index = _endNode.incomingLinks.indexOf(this);
					if(index==-1){
						_endNode.incomingLinks.push(this);	
					}
				}
			}
		}
		
		/**
		 * 起始节点。 
		 */
		[Bindable(event="startNodeChange")]
		public function get startNode():Node
		{
			return _startNode;
		}
		
		public function set startNode(value:Node):void
		{
			if( _startNode !== value)
			{
				var index:int=-1;
				/*var sNode:Node = this._startNode;
				if(sNode){
				index = sNode.outgoingLinks.indexOf(this);
				if(index ==-1){
				sNode.incomingLinks.splice(index,1);
				}
				}*/
				_startNode = value;
				dispatchEvent(new Event("startNodeChange"));
				invalidateShape();
				
				index=-1;
				if(_startNode){
					fallbackStartPoint = null;
					index = _startNode.outgoingLinks.indexOf(this);
					if(index ==-1){
						_startNode.outgoingLinks.push(this);
					}
				}
			}
		}
		
		/**
		 * 计算Path的矩形框。 
		 * @param path
		 * @return 
		 * 
		 */
		public static function getPathBounds(path:Path):Rectangle
		{
			var rect:Rectangle = new Rectangle(path.measuredX, path.measuredY, path.measuredWidth, path.measuredHeight);
			var weight:Number = path.stroke == null ? 0 : path.stroke.weight;
			if (weight != 0) 
			{
				rect.width = rect.width + weight;
				rect.height = rect.height + weight;
				rect.x = rect.x - weight / 2;
				rect.y = rect.y - weight / 2;
			}
			return rect;
		}
		
		/**
		 * 刷新连线形状。 
		 * 
		 */
		public function invalidateShape():void
		{
			_shapeTypeChange = true;
			invalidateProperties();
			return;
		}

		


	}
}