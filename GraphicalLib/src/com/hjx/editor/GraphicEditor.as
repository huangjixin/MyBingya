package com.hjx.editor
{
	import com.hjx.graphic.Graph;
	import com.hjx.graphic.Link;
	import com.hjx.graphic.LinkConnectionArea;
	import com.hjx.graphic.Node;
	import com.hjx.graphic.Renderer;
	import com.hjx.graphic.SubGraph;
	import com.hjx.utils.CloneUtil;
	
	import flash.display.DisplayObject;
	import flash.display.DisplayObjectContainer;
	import flash.events.Event;
	import flash.events.KeyboardEvent;
	import flash.events.MouseEvent;
	import flash.geom.Point;
	import flash.geom.Rectangle;
	import flash.utils.Dictionary;
	
	import mx.core.IVisualElement;
	import mx.core.IVisualElementContainer;
	import mx.events.DragEvent;
	import mx.events.SandboxMouseEvent;
	import mx.graphics.SolidColor;
	import mx.graphics.SolidColorStroke;
	
	import spark.components.Group;
	import spark.components.supportClasses.ScrollBarBase;
	import spark.components.supportClasses.SkinnableComponent;
	import spark.filters.GlowFilter;
	import spark.primitives.Rect;
	
	/**
	 * @date 2014-6-3,@author 黄记新
	 */
	[DefaultProperty("mxmlContent")]
	public class GraphicEditor extends SkinnableComponent
	{
		[SkinPart]
		public var adornersGroup:Group;
		
		[SkinPart]
		public var graph:Graph;
		
		public var allowMoving:Boolean=true;
		
		public var allowReparenting:Boolean=true;
		
		public var allowDropping:Boolean =true;
		
		public var allowEditingText:Boolean =true;
		
		public var allowPlayAdorner:Boolean =true;
		
		public var allowPlayRect:Boolean =true;
		
		private var _inAdornerInteraction:Boolean;
		/**
		 * 内部边饰器字典。 
		 */
		internal var adorners:Dictionary;
		/**
		 * 选择对象集。 
		 */
		internal var selectedObjects:Vector.<Renderer>;
		
		/**
		 * 框选矩形框。 
		 */
		private var marquee:Rect;
		
		private var startX:Number;
		private var startY:Number;
		
		private var lastX:Number;
		private var lastY:Number;
		
		internal var mouseDown:Boolean;
		internal var isDragging:Boolean;
		
		internal var _currentSubgraph:SubGraph=null;
		private var currentSubgraphFlashing:Boolean;
		
		public var linkPrototype:Link;
		
		public var cloneFunction:Function;
		public var autoAlign:Boolean = true;
		
		internal static var Top:int=0;
		
		internal static var Right:int=1;
		
		internal static var Bottom:int=2;
		
		internal static var Left:int=3;
		
		private var lastDown:Number = 0;
		private var lastUp:Number = 0;
		private var doubleClickStarted:Boolean;
		
		private var _mxmlContent:Array = [];
		
		public function GraphicEditor()
		{
			super();
			
			this.selectedObjects = new Vector.<Renderer>();
			this.adorners = new Dictionary();
			
			this.addEventListener(MouseEvent.MOUSE_DOWN, this.mouseDownHandler);
			
		}
		
		//--------------------------------------------------------
		// getter和setter函数
		//--------------------------------------------------------
		/**
		 * 该setter函数保证了可以在mxml里面进行组件声明。 
		 * @param value
		 * 
		 */
		public function set mxmlContent(value:Array):void
		{
			_mxmlContent = value;
		}
		
		internal function get currentSubgraph():SubGraph
		{
			return this._currentSubgraph;
		}
		
		internal function set currentSubgraph(subGraph:SubGraph):void
		{
			if (subGraph != this._currentSubgraph) 
			{
				this._currentSubgraph = subGraph;
			}
			this.currentSubgraphFlashing = false;
			return;
		}
		
		public function get inAdornerInteraction():Boolean
		{
			return _inAdornerInteraction;
		}
		
		public function set inAdornerInteraction(value:Boolean):void
		{
			_inAdornerInteraction = value;
		}
		
		
		//--------------------------------------------------------
		// 相关事件响应函数和逻辑函数存放处
		//--------------------------------------------------------
		
		/**
		 * 鼠标响应函数，判断该拖拽还是框选。 
		 * @param event
		 * 
		 */
		internal function mouseDownHandler(event:MouseEvent):void
		{
			this.graph.setFocus();
			
			if(getScrollerBase(event.target))
				return;
			this.startX = graph.mouseX;  
			this.startY = graph.mouseY;
			
			var displayObject:DisplayObject = systemManager.getSandboxRoot(); 
			
			var renderer:Renderer = getRenderer(event.target)
			if(renderer){
//				this.setSelected(renderer, !this.isSelected(renderer));
				this.setSelected(renderer, true);
				if(this.isSelected(renderer)){
					displayObject.addEventListener(MouseEvent.MOUSE_UP, rendererMouseUpHandler, true);  
					displayObject.addEventListener(MouseEvent.MOUSE_MOVE, rendererMouseDragHandler, true);  
					displayObject.addEventListener(SandboxMouseEvent.MOUSE_UP_SOMEWHERE, rendererMouseUpHandler, true);  
					displayObject.addEventListener(SandboxMouseEvent.MOUSE_MOVE_SOMEWHERE, rendererMouseDragHandler, true);  
					systemManager.deployMouseShields(true);
				}
				return;
			}else{
				selectOnly(renderer);
			}
			
			displayObject.addEventListener(MouseEvent.MOUSE_UP, this.mouseUpHandler, true);  
			displayObject.addEventListener(MouseEvent.MOUSE_MOVE, this.mouseDragHandler, true);  
			displayObject.addEventListener(SandboxMouseEvent.MOUSE_UP_SOMEWHERE, this.mouseUpHandler, true);  
			displayObject.addEventListener(SandboxMouseEvent.MOUSE_MOVE_SOMEWHERE, this.mouseDragHandler, true);  
			systemManager.deployMouseShields(true);  
		}
		
		protected function rendererMouseDragHandler(event:Event):void
		{
			var currentX:Number = this.graph.mouseX;  
			var currentY:Number = this.graph.mouseY;
			
			var translated:Boolean = false;
			//此处我们认为移动的距离超过两个像素便认定在拖拽。
			if (Math.abs(currentX - this.startX) > 2 || Math.abs(currentY - this.startY) > 2) 
			{
				translated = true;
				
				this.lastX = this.startX;
				this.lastY = this.startY;
				
				this.startX = currentX;
				this.startY = currentY;
			}
			
			if(!translated){
				return;
			}
			
			for each (var selectedRenderer:Renderer in getSelectedObjects()) 
			{
				translate(selectedRenderer, new Point(currentX - this.lastX, currentY - this.lastY));
				if(selectedRenderer is Node){
					Node(selectedRenderer).invalidateLinkShape();
				}
			}
			
		}
		
		protected function rendererMouseUpHandler(event:Event):void
		{
			var displayObject:DisplayObject = systemManager.getSandboxRoot();
			displayObject.removeEventListener(MouseEvent.MOUSE_UP, this.rendererMouseUpHandler, true);
			displayObject.removeEventListener(MouseEvent.MOUSE_MOVE, this.rendererMouseDragHandler, true);
			displayObject.removeEventListener(SandboxMouseEvent.MOUSE_UP_SOMEWHERE, this.rendererMouseUpHandler, true);
			displayObject.removeEventListener(SandboxMouseEvent.MOUSE_MOVE_SOMEWHERE, this.rendererMouseDragHandler, true);
			systemManager.deployMouseShields(false);
		}		
		
		/**
		 * 鼠标拖拽。 
		 * @param event
		 * 
		 */
		internal function mouseDragHandler(event:MouseEvent):void
		{
			var startPoint:Point; //拖拽开始点。
			
			var currentX:Number = this.graph.mouseX;  
			var currentY:Number = this.graph.mouseY;
			
			var isDragging:Boolean = false;
			//此处我们认为移动的距离超过两个像素便认定在拖拽。
			if (Math.abs(currentX - this.startX) > 2 || Math.abs(currentY - this.startY) > 2) 
			{
				isDragging = true;
				startPoint = new Point(this.startX, this.startY);
			}
			
			if(!isDragging){
				return;
			}
			
			
			if (this.marquee == null) 
			{
				this.marquee = new Rect();
				this.marquee.maxWidth = Number.MAX_VALUE;
				this.marquee.maxHeight = Number.MAX_VALUE;
				var solidColorDash:SolidColorStroke = new SolidColorStroke(0x2A9DFF,1,1);
				var solidColor:SolidColor = new SolidColor(0x0576DC,0.2);
				this.marquee.stroke = solidColorDash;
				this.marquee.fill = solidColor;
				this.adornersGroup.addElement(this.marquee);
			}
			
			var start:Point = this.adornersGroup.globalToLocal(this.graph.localToGlobal(new Point(this.startX, this.startY)));  
			var end:Point = this.adornersGroup.globalToLocal(this.graph.localToGlobal(new Point(currentX, currentY)));  
			this.marquee.left = Math.min(start.x, end.x);  
			this.marquee.top = Math.min(start.y, end.y);  
			this.marquee.width = Math.abs(start.x - end.x);  
			this.marquee.height = Math.abs(start.y - end.y);
		}
		
		internal function mouseUpHandler(event:Event):void
		{
			//移除框选。
			if (this.marquee != null) 
			{
				this.adornersGroup.removeElement(this.marquee);
				this.marquee = null;
			}
			
			var displayObject:DisplayObject = systemManager.getSandboxRoot();
			displayObject.removeEventListener(MouseEvent.MOUSE_UP, this.mouseUpHandler, true);
			displayObject.removeEventListener(MouseEvent.MOUSE_MOVE, this.mouseDragHandler, true);
			displayObject.removeEventListener(SandboxMouseEvent.MOUSE_UP_SOMEWHERE, this.mouseUpHandler, true);
			displayObject.removeEventListener(SandboxMouseEvent.MOUSE_MOVE_SOMEWHERE, this.mouseDragHandler, true);
			systemManager.deployMouseShields(false);
			return;
		}
		
		
		/**
		 * 更改坐标。 
		 * @param renderer
		 * @param point
		 * 
		 */
		internal function translate(renderer:Renderer, point:Point):void
		{
			if(renderer is Link){
				var link:Link = Link(renderer);
				link.fallbackStartPoint = link.fallbackStartPoint.add(point);
				link.fallbackEndPoint = link.fallbackEndPoint.add(point);
			}else{
				renderer.setX(renderer, renderer.getX(renderer) + point.x);
				renderer.setY(renderer, renderer.getY(renderer) + point.y);
			}
		}
		
		/**
		 * 静态函数。
		 */ 
		public static function getRenderer(object:Object):Renderer
		{
			while (object is flash.display.DisplayObject) 
			{
				if (object is Renderer) 
				{
					return Renderer(object);
				}
				object = object.parent;
			}
			return null;
		}
		/**
		 * 静态函数。
		 */ 
		public static function getScrollerBase(object:Object):ScrollBarBase
		{
			while (object is DisplayObject) 
			{
				if (object is ScrollBarBase) 
				{
					return ScrollBarBase(object);
				}
				object = object.parent;
			}
			return null;
		}
		
		/**
		 * 找到顶层编辑器。 
		 * @param displayObject
		 * @return 
		 * 
		 */
		public static function getEditor(displayObject:DisplayObject):GraphicEditor
		{
			var displayObjectContainer:DisplayObjectContainer = displayObject.parent;
			while (displayObjectContainer != null) 
			{
				if (displayObjectContainer is GraphicEditor) 
				{
					return GraphicEditor(displayObjectContainer);
				}
				displayObjectContainer = displayObjectContainer.parent;
			}
			return null;
		}
		
		public static function getLowestCommonGraph(renderer1:Renderer, renderer2:Renderer):Graph
		{
			if (renderer1 == null || renderer2 == null) 
			{
				throw new ArgumentError("参数不得为null");
			}
			var graph1:Graph=renderer1.parent as Graph;
			var graph2:Graph=renderer2.parent as Graph;
			if (graph1 == null || graph2 == null) 
			{
				return null;
			}
			if (graph1 == graph2) 
			{
				return graph1;
			}
			if (isGraphAncestorOf(graph1, graph2)) 
			{
				return graph1;
			}
			if (isGraphAncestorOf(graph2, graph1)) 
			{
				return graph2;
			}
			if (graph1.owningSubGraph == null) 
			{
				return graph1;
			}
			return getLowestCommonGraph(graph1.owningSubGraph, renderer2);
		}
		
		internal static function isGraphAncestorOf(graph1:Graph, graph2:Graph):Boolean
		{
			var graph:Graph;
			if (graph2.owningSubGraph == null) 
			{
				graph = graph2.parent as Graph;
			}
			else 
			{
				graph = graph2.owningSubGraph.parent as  Graph;
			}
			while (graph != null) 
			{
				if (graph == graph1) 
				{
					return true;
				}
				if (graph.owningSubGraph != null) 
				{
					graph = graph.owningSubGraph.parent as  Graph;
					continue;
				}
				graph = graph.parent as Graph;
			}
			return false;
		}
		/**
		 * 坐标转换。 
		 * @param point
		 * @param displayObjectContainer
		 * @return 
		 * 
		 */
		public	function snapPoint(point:Point, displayObjectContainer:DisplayObjectContainer):flash.geom.Point
		{
			if (displayObjectContainer != this.graph) 
			{
				point = this.graph.globalToLocal(displayObjectContainer.localToGlobal(point));
			}
			
			if (displayObjectContainer != this.graph) 
			{
				point = displayObjectContainer.globalToLocal(this.graph.localToGlobal(point));
			}
			
			return point;
		}
		
		public	function deselectAllExcept(renderer:Renderer=null):void
		{
			var item:Renderer=null;
			var vector:Vector.<Renderer> = this.selectedObjects.concat();
			for each (item in vector) 
			{
				if (item == renderer) 
				{
					continue;
				}
				this.setSelected(item, false);
			}
			return;
		}
		
		/**
		 * 只选一个 
		 * @param renderer
		 * 
		 */
		private function selectOnly(renderer:Renderer=null):void
		{
			this.deselectAllExcept(renderer);
			if (renderer != null) 
			{
				this.setSelected(renderer, true);
			}
			return;
		}
		/**
		 * 获取选中对象。 
		 * @return 
		 * 
		 */
		public function getSelectedObjects():Vector.<Renderer>
		{
			return this.selectedObjects.concat();
		}
		
		/**
		 * 判断一个渲染器是否被选中。 
		 * @param renderer
		 * @return 
		 * 
		 */
		public function isSelected(renderer:Renderer):Boolean
		{
			return this.selectedObjects.indexOf(renderer) >= 0;
		}
		
		/**
		 * 设置选中状态 
		 * @param renderer
		 * @param isSelected
		 * 
		 */
		public function setSelected(renderer:Renderer, isSelected:Boolean):void
		{
			if (this.isSelected(renderer) != isSelected) 
			{
				if (isSelected) 
				{
					this.selectedObjects.push(renderer);
				}
				else 
				{
					this.selectedObjects.splice(this.selectedObjects.indexOf(renderer), 1);
				}
				this.updateAdorner(renderer);
			}
			return;
		}
		
		/**
		 * 更新边饰器。 
		 * @param renderer
		 * 
		 */
		internal function updateAdorner(renderer:Renderer):void
		{
			if(!allowPlayAdorner){
				return;
			}
			var adorner:Adorner=this.getAdorner(renderer);
			if (this.isSelected(renderer as Renderer)) 
			{
				if (!adorner) 
				{
					adorner = this.createAdorner(renderer);
					this.adorners[renderer] = adorner;
					this.adornersGroup.addElement(adorner);
					renderer.filters = [new GlowFilter()];
				}
			}
			else if (adorner != null) 
			{
				this.adornersGroup.removeElement(adorner);
				this.adorners[renderer] = null;
				renderer.filters = [];
			}
			return;
		}
		
		internal function createAdorner(renderer:Renderer):Adorner
		{
			var adorner:* = renderer.getStyle("adornerClass");
			if(adorner){
				return new adorner(renderer);
			}
			if (renderer is SubGraph) 
			{
				return new ResizeableAdorner(renderer);
			}else if (renderer is Node) 
			{
				return new ResizeableAdorner(renderer);
			}
			throw new ArgumentError("参数有误");
		}
		
		public function getAdorner(renderer:Renderer):Adorner
		{
			return Adorner(this.adorners[renderer]);
		} 
		
		
		public function createLink(startNodeConnectingArea:String = LinkConnectionArea.CENTER,
								   endNodeConnectingArea:String = LinkConnectionArea.CENTER):Link
		{
			var link:Link=null;
			if (this.linkPrototype == null) 
			{
				link = new Link();
			}
			else 
			{
				link = Link(CloneUtil.clone(this.linkPrototype));
			}
			link.startConnectionArea = startNodeConnectingArea;
			link.endConnectionArea = endNodeConnectingArea;
			return link;
		}
		
		/**
		 * 链接节点。 
		 * 
		 */
		public function connectNodes(startNodeConnectingArea:String = LinkConnectionArea.CENTER,
									 endNodeConnectingArea:String = LinkConnectionArea.CENTER):void
		{
			var selObjs:Vector.<Renderer> = getSelectedObjects();
			if (selObjs.length == 2) {
				if ((selObjs[0] is Node) && (selObjs[1] is Node)) {
					var link:Link = createLink(startNodeConnectingArea,endNodeConnectingArea);
					if (link) {
						link.startNode = Node(selObjs[0]);
						link.endNode = Node(selObjs[1]);
						var linkParent:Graph = GraphicEditor.getLowestCommonGraph(link.startNode, link.endNode);
						linkParent.addElement(link);
					}            
				}
			}        
		}
		/**
		 * 当graph被实例化的时候，赋值mxml内容。 
		 * @param partName
		 * @param instance
		 * 
		 */
		override protected function partAdded(partName:String, instance:Object):void{
			super.partAdded(partName, instance);
			if(instance == graph){
				graph.mxmlContent = _mxmlContent;
			}
		}
	}
}