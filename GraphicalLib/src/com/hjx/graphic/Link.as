package com.hjx.graphic
{
	import flash.display.DisplayObject;
	import flash.display.DisplayObjectContainer;
	import flash.events.Event;
	import flash.geom.Point;
	import flash.geom.Rectangle;
	
	import mx.collections.ArrayCollection;
	import mx.core.UIComponent;
	import mx.graphics.SolidColorStroke;
	
	import spark.primitives.Path;
	
	import ws.tink.spark.graphics.SolidColorDash;

	/**
	 * @date 2014-6-3,@author 黄记新
	 * 该连线继承自Renderer，用于渲染连线元素。
	 */
	[Style(name="caps", inherit="yes", type="String",enumeration="round,square,none")]
	[Style(name="caretColor", inherit="yes", type="uint",format="Color")]
	[Style(name="color", inherit="yes", type="uint",format="Color")]
	[Style(name="dashArray", inherit="yes", type="Array")]
	[Style(name="dashStyle", inherit="yes", type="String",enumeration="none,dash,dot,dashDot")]
	[Style(name="dash", inherit="yes", type="Number")]
	[Style(name="endArrowType", inherit="yes", type="String",enumeration="triangle,open,sunken,curved,square,diamond,circle,star")]
	[Style(name="endArrowVisible", inherit="yes", type="Boolean",format="Boolean",enumeration="true,false")]
	[Style(name="joints", inherit="yes", type="String",enumeration="round,miter,bevel")]
	[Style(name="miterLimit", inherit="yes", type="uint",format="Number")]
	[Style(name="orthogonalSpacing", inherit="yes", type="Number")]
	[Style(name="pixelHinting", inherit="yes", type="Boolean",format="Boolean")]
	[Style(name="radius", inherit="yes", type="Number")]
	[Style(name="selectedColor", inherit="yes", type="uint",format="Color")]
	[Style(name="selectedStrokeWidth", inherit="yes", type="uint",format="Number")]
	[Style(name="startArrowType", inherit="yes", type="String",enumeration="triangle,open,sunken,curved,square,diamond,circle,star")]
	[Style(name="startArrowVisible", inherit="yes", type="Boolean",format="Boolean",enumeration="true,false")]
	[Style(name="strokeColor", inherit="yes", type="uint",format="Color")]
	[Style(name="strokeWidth", inherit="yes", type="uint",format="Number")]
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
		
		private var _strokeWidth:Number = 2;
		private var _strokeWidthChange:Boolean;
		private var _radius:Number = 5;
		private var _radiusChange:Boolean;
		private var _dashStyle:String = DashStyle.NONE;
		private var _dashStyleChange:Boolean;
		private var _startArrowVisible:Boolean;
		private var _startArrowVisibleChange:Boolean;
		private var _endArrowVisible:Boolean;
		private var _endArrowVisibleChange:Boolean;
		private var _startArrowType:String;
		private var _startArrowTypeChange:Boolean;
		private var _endArrowType:String;
		private var _endArrowTypeChange:Boolean;
		private var _orthogonalSpacing:Number = 12;
		private var _orthogonalSpacingChange:Boolean;
		private var _dash:Number = 8;
		private var _dashChange:Boolean;
		
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
				var eNode:Node = this._endNode;
				if(eNode){
					index = eNode.incomingLinks.indexOf(this);
				if(index ==-1){
				eNode.incomingLinks.splice(index,1);
				}
				}
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
				var sNode:Node = this._startNode;
				if(sNode){
					index = sNode.outgoingLinks.indexOf(this);
					if(index ==-1){
					sNode.incomingLinks.splice(index,1);
					}
				}
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

		private function getCollpasedSubGraph(arr:ArrayCollection,render:Renderer):SubGraph
		{
			if(render.parent is Graph){
				var graph:Graph = Graph(render.parent);
				var parentDoc:Object = graph.parentDocument;
				var parentSubGraph:SubGraph;
				if(parentDoc.hasOwnProperty("hostComponent")){
					var hostComponent:Object = parentDoc["hostComponent"];
					var render1:Renderer;
					if(hostComponent is Renderer){
						render1 = parentDoc["hostComponent"] as Renderer;
					}
					if(render1 is SubGraph){
						parentSubGraph = render1 as SubGraph;
					}
					if(parentSubGraph){
						arr.addItem(parentSubGraph);
						getCollpasedSubGraph(arr,render1);
						return parentSubGraph;
					}else{
						return null;
					}
				}
			}
			
			return null;
		}//getCollpaseSubGraph结束
		
		/**
		 * 获得当前path的矩形框推荐值。 
		 * @return 
		 * 
		 */
		public function getBoundsForMeasure():Rectangle
		{
			this.updateBoundsForMeasure();
			if (this.path != null) 
			{
				return getPathBounds(this.path);
			}
			return new Rectangle();
		}
		
		private final function updateBoundsForMeasure():void
		{
			this.computeShapePoints();
			return;
		}
		
		/**
		 * 计算连线的形状。 
		 * 
		 */
		internal function computeShapePoints():void
		{
			var realVisialeStartNode:Node = this.getVisibleStartNode();
			var realVisialeEndNode:Node = this.getVisibleEndNode();
			var defaultStartPoint:Point = new Point();
			var defaultEndPoint:Point = new Point();
			var displayObjectContainer:DisplayObjectContainer = this.parent == null ? this : this.parent;
			var startNodeRect:Rectangle;
			var endNodeRect:Rectangle;
			
			if(this.startNode){
				startNodeRect = realVisialeStartNode.getNodeOrBaseBounds(displayObjectContainer);
				defaultStartPoint.x = startNodeRect.x + startNodeRect.width/2;
				defaultStartPoint.y = startNodeRect.y + startNodeRect.height/2;
				
				this.fallbackStartPoint = defaultStartPoint.clone();
			}else{
				defaultStartPoint = this.fallbackStartPoint.clone();
			}
			
			if(this.endNode){
				endNodeRect = realVisialeEndNode.getNodeOrBaseBounds(displayObjectContainer);
				defaultEndPoint.x = endNodeRect.x + endNodeRect.width/2;
				defaultEndPoint.y = endNodeRect.y + endNodeRect.height/2;
				
				this.fallbackEndPoint = defaultEndPoint.clone();
			}else{
				defaultEndPoint = this.fallbackEndPoint.clone();
			}
			
			var point1:Point =defaultStartPoint;
			var point2:Point =defaultEndPoint;
			var radian:Number=0;
			var minOffset:Number=0; //直连线偏移量。
			var offsetX:Number=0;
			var offsetY:Number=0;
			
			switch(this.shapeType)
			{
				case LinkShapeType.STRAIGHT:
				{
					if (this._shapePoints == null) 
					{
						this._shapePoints = new Vector.<flash.geom.Point>();
					}
					else 
					{
						this._shapePoints.splice(0, this._shapePoints.length);
					}
					
					//计算连接区域的点。
					if(this.startNode){
						if(startConnectionArea == LinkConnectionArea.CENTER){
							//计算开始节点偏移量坐标。
							radian= Math.atan2(point1.y - point2.y, point1.x - point2.x);
							minOffset = Math.min(Math.abs(realVisialeStartNode.width/2/Math.cos(radian)),Math.abs(realVisialeStartNode.height/2/Math.sin(radian)));
							offsetX = minOffset*Math.cos(radian);
							offsetY = minOffset*Math.sin(radian);
							defaultStartPoint.offset(-offsetX,-offsetY);
							
						}else if(startConnectionArea == LinkConnectionArea.LEFT){
							offsetX = Math.abs(realVisialeStartNode.width/2);
							offsetY = 0;
							defaultStartPoint.offset(-offsetX,-offsetY);
						}else if(startConnectionArea == LinkConnectionArea.RIGHT){
							offsetX = Math.abs(realVisialeStartNode.width/2);
							offsetY = 0;
							defaultStartPoint.offset(offsetX,-offsetY);
						}else if(startConnectionArea == LinkConnectionArea.TOP){
							offsetX = 0;
							offsetY = Math.abs(realVisialeStartNode.height/2);
							defaultStartPoint.offset(-offsetX,-offsetY);
						}else if(startConnectionArea == LinkConnectionArea.BOTTOM){
							offsetX = 0;
							offsetY = Math.abs(realVisialeStartNode.height/2);
							defaultStartPoint.offset(-offsetX,offsetY);
						}
						
						this.fallbackStartPoint = defaultStartPoint.clone();
					}else{
						defaultStartPoint = this.fallbackStartPoint.clone();
					}
					
					if(this.endNode){
						if(endConnectionArea == LinkConnectionArea.CENTER){
							//计算开始节点偏移量坐标。
							radian= Math.atan2(point2.y - point1.y, point2.x - point1.x);
							minOffset = Math.min(Math.abs(realVisialeEndNode.width/2/Math.cos(radian)),Math.abs(realVisialeEndNode.height/2/Math.sin(radian)));
							offsetX = minOffset*Math.cos(radian);
							offsetY = minOffset*Math.sin(radian);
							defaultEndPoint.offset(-offsetX,-offsetY);							
						}else if(endConnectionArea == LinkConnectionArea.LEFT){
							offsetX = Math.abs(realVisialeEndNode.width/2);
							offsetY = 0;
							defaultEndPoint.offset(-offsetX,-offsetY);
						}else if(endConnectionArea == LinkConnectionArea.RIGHT){
							offsetX = Math.abs(realVisialeEndNode.width/2);
							offsetY = 0;
							defaultEndPoint.offset(offsetX,-offsetY);
						}else if(endConnectionArea == LinkConnectionArea.TOP){
							offsetX = 0;
							offsetY = Math.abs(realVisialeEndNode.height/2);
							defaultEndPoint.offset(-offsetX,-offsetY);
						}else if(endConnectionArea == LinkConnectionArea.BOTTOM){
							offsetX = 0;
							offsetY = Math.abs(realVisialeEndNode.height/2);
							defaultEndPoint.offset(-offsetX,offsetY);
						}
						
						this.fallbackEndPoint = defaultEndPoint.clone();
					}else{
						defaultEndPoint = this.fallbackEndPoint.clone();
					}
					
					this._shapePoints.push(defaultStartPoint);
					this._shapePoints.push(defaultEndPoint);
					if(labelElement){
						validateNow();
						radian= Math.atan2(defaultEndPoint.y - defaultStartPoint.y, defaultEndPoint.x - defaultStartPoint.x);
						var labelElementWidth:Number =UIComponent(labelElement).width; 
						var labelElementHeight:Number =UIComponent(labelElement).height; 
						//						labelElement.rotation = radian*180/Math.PI;
						labelElement.x = defaultStartPoint.x/2+defaultEndPoint.x/2-labelElementWidth/2;
						labelElement.y = defaultStartPoint.y/2+defaultEndPoint.y/2-labelElementHeight/2;
						/*						labelElement.x = defaultStartPoint.x/2+defaultEndPoint.x/2-labelElement.width/2-labelElement.width*Math.sin(radian)/2;;
						labelElement.y = defaultStartPoint.y/2+defaultEndPoint.y/2-labelElement.height/2-labelElement.height*Math.cos(radian)/2;*/
						/*var dx:Number = labelElement.x;
						var dy:Number = labelElement.y;
						labelElement.x = dx * Math.cos(radian) - dy * Math.sin(radian);
						labelElement.y = dy * Math.cos(radian) + dx * Math.sin(radian);*/
					}
					break;
				}
				case LinkShapeType.ORTHOGONAL:
				{
					
				}	
				default:
				{
					break;
				}
			}
		}
		
		/**
		 * 查找开始节点。 
		 * @return 
		 * 
		 */
		public function getVisibleStartNode():Node
		{
			if (!this.startNode) 
			{
				return null;
			}
			if (this.parent == null || this.startNode.parent == this.parent) 
			{
				return this.startNode;
			}
			return this.getRealVisible(this.startNode);
		}
		
		/**
		 * 查找可阅的结束节点。 
		 * @return 
		 * 
		 */
		public function getVisibleEndNode():Node
		{
			if (!this.endNode) 
			{
				return null;
			}
			if (this.parent == null || this.endNode.parent == this.parent) 
			{
				return this.endNode;
			}
			return this.getRealVisible(this.endNode);
		}
		
		/**
		 * 因为子图是可嵌套和缩放的，认为处于收缩状态的子图里面的节点不是可视化节点。 
		 * @param node
		 * @return 
		 * 
		 */
		internal function getRealVisible(node:Node):Node
		{
			var localNode:Node = node;
			while (!(localNode.parent == null) &&
				localNode.parent is Graph &&
				Graph(localNode.parent).owningSubGraph) 
			{
				localNode = Graph(localNode.parent).owningSubGraph;
				if (!(localNode is SubGraph && SubGraph(localNode).collapsed)) 
				{
					continue;
				}
				node = localNode;
			}
			return node;
			
			var subGraph:SubGraph = getParentSubGraph(node.parent);
			while (subGraph) 
			{
				if(!subGraph.collapsed){
					node = subGraph;
					break;
				}
				subGraph = getParentSubGraph(subGraph.parent);
			}
			return node;
		}

		/**
		 * 得到上级子图。 
		 * @param object
		 * @return 
		 * 
		 */
		internal static function getParentSubGraph(object:Object):SubGraph{
			while (object is DisplayObject) 
			{
				if (object is SubGraph) 
				{
					return SubGraph(object);
				}
				object = object.parent;
			}
			return null;
		}
		
		private function createDashRoundPolyline(shapePoints:Vector.<Point>,radius:Number):String{
			var data:String;
			var point:Point;
			if(shapeType == "straight"){
				for each (point in shapePoints) 
				{
					if(point == shapePoints[0]){
						data = "M "+point.x+" "+point.y+" ";
					}else{
						data+="L "+point.x+" "+point.y+" ";					
					}
				}
				
			}
			
			return data;
		}
		
		override protected function commitProperties():void{
			super.commitProperties();
			if(_strokeWidthChange ||
				_radiusChange ||
				_dashStyleChange ||
				_startArrowVisibleChange ||
				_endArrowVisibleChange ||
				_startArrowTypeChange ||
				_endArrowTypeChange ||
				_shapeTypeChange ||
				_orthogonalSpacingChange||
				_dashChange){
				/*if (_shapeTypeChange || _orthogonalSpacingChange) 
				{
				
				}*/
				this.computeShapePoints();
				if (this.path && this._shapePoints) 
				{
					this.updateArrow();
					this.path.data = createDashRoundPolyline(this._shapePoints, this._radius);
					var color:uint;
					if(this._dashStyle == DashStyle.NONE){
						if(!path.stroke || path.stroke is SolidColorStroke){
							color = getStyle("strokeColor");
							if(styleManager.isValidStyleValue(color)){
								path.stroke = new SolidColorStroke(color,this._strokeWidth,0.6);							
							}else{
								path.stroke = new SolidColorStroke(0,this._strokeWidth,0.6);
							}
						}
					}else if(this._dashStyle == DashStyle.DASH){
						if(!path.stroke || path.stroke is SolidColorStroke){
							color = getStyle("strokeColor");
							if(styleManager.isValidStyleValue(color)){
								path.stroke = new SolidColorDash(_dash,_dash,color,this._strokeWidth,0.6);				
							}else{
								path.stroke = new SolidColorDash(_dash,_dash,0x808080,this._strokeWidth,0.6);
							}
						}
					}
					/*if (this._curved) 
					{
					this.configureCurvedPath(this.path);
					}
					else 
					{
					loc1 = com.ibm.ilog.elixir.diagram.utils.PathUtil.createDashRoundPolyline(this._shapePoints, this._radius, this._dashArray, this.firstPointOfPath, this.lastPointOfPath);
					this.path.data = loc1;
					}*/
					/*if (this.getFlag(LinkShapeChangeFlag) || this.getFlag(ArrowVisibilityChangeFlag) || this.getFlag(ArrowTypeChangeFlag)) 
					{
					this.updateArrow();
					}*/
				}
				
				_strokeWidthChange=
					_radiusChange=
					_dashStyleChange=
					_startArrowVisibleChange=
					_endArrowVisibleChange=
					_startArrowTypeChange=
					_endArrowTypeChange = 
					_shapeTypeChange = 
					_orthogonalSpacingChange = 
					_dashChange=false;
			}
			//			draw();
		}
		
		/**
		 * 更新箭头，根据箭头是否可视计算旋转角度和偏移量。 
		 * 
		 */
		internal function updateArrow():void
		{
			var point1:Point;
			var point2:Point;
			var radian:Number;
			if (this.startArrow) 
			{
				this._startArrowVisible= getStyle("startArrowVisible");
				this._endArrowVisible = getStyle("endArrowVisible");
				
				if ((this._startArrowVisible && this._endArrowVisible) || this._startArrowVisible) 
				{
					point1 = this._shapePoints[0];
					point2 = this._shapePoints[1];
					if (point1 && point2 && !(isNaN(point1.length) || isNaN(point2.length))) 
					{
						radian = Math.atan2(point1.y - point2.y, point1.x - point2.x);
						this.startArrow.rotation = radian * 180 / Math.PI;
						this.startArrow.x = point1.x;
						this.startArrow.y = point1.y;
						this.startArrow.visible = true;
						var midWidth:Number;
						var startRect:Rectangle = getPathBounds(this.startArrow);
						//						var startOffsetW:Number = Math.max(10,startRect.width);
						var startOffsetW:Number = startRect.width;
						point1.offset(-startOffsetW * Math.cos(radian),-startOffsetW*Math.sin(radian));
						this._shapePoints[0] = point1;
					}
				}
				else 
				{
					this.startArrow.visible = false;
				}
			}
			if (this.endArrow) 
			{
				if ((this._startArrowVisible && this._endArrowVisible) || this._endArrowVisible) 
				{
					point1 = this._shapePoints[this._shapePoints.length - 2];
					point2 = this._shapePoints[(this._shapePoints.length - 1)];
					if (point1 && point2 && !(isNaN(point1.length) || isNaN(point2.length))) 
					{
						radian = Math.atan2(point2.y - point1.y, point2.x - point1.x);
						this.endArrow.rotation = radian * 180 / Math.PI;
						this.endArrow.x = point2.x;
						this.endArrow.y = point2.y;
						this.endArrow.visible = true;
						var endRect:Rectangle = getPathBounds(this.startArrow);
						//						var endOffsetW:Number = Math.max(10,endRect.width);
						var endOffsetW:Number = endRect.width;
						point2.offset(-endOffsetW * Math.cos(radian),-endOffsetW*Math.sin(radian));
						this._shapePoints[this._shapePoints.length - 1] = point2;
					}
				}
				else 
				{
					this.endArrow.visible = false;
				}
			}
			return;
		}
		
		internal function clonePointVector(shapePoints:Vector.<Point>):Vector.<Point>
		{
			var length:int = shapePoints ? shapePoints.length : 0;
			if (length == 0) 
			{
				return null;
			}
			
			var result:Vector.<Point> =new Vector.<Point>(length);
			var flag:int = 0;
			while (flag < length) 
			{
				result[flag] = shapePoints[flag].clone();
				++flag;
			}
			return result;
		}
		
		override protected function partAdded(partName:String, instance:Object):void{
			if(instance == this.startArrow){
				this.startArrow.visible = getStyle("startArrowVisible")
			}
			if(instance == this.endArrow){
				this.endArrow.visible = getStyle("endArrowVisible")
			}
			
			if(instance == this.labelElement){
				invalidateShape();
			}
		}
	}
}