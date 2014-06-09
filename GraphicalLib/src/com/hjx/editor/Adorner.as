package com.hjx.editor
{
	import com.hjx.graphic.Graph;
	import com.hjx.graphic.Renderer;
	
	import flash.display.DisplayObject;
	import flash.events.Event;
	import flash.events.MouseEvent;
	import flash.geom.Point;
	
	import mx.events.SandboxMouseEvent;

	/**
	 * @date 2014-6-6,@author 黄记新
	 */
	public class Adorner extends BaseAdorner
	{
		protected var startX:Number;
		protected var startY:Number;
		
		protected var lastX:Number;
		protected var lastY:Number;
		
		private var _interactiveHandle:DisplayObject;
		
		public function Adorner(adornedObj:Renderer)
		{
			super(adornedObj);
		}
		
		public function get editor():GraphicEditor
		{
			return GraphicEditor.getEditor(this);
		}
		
		public function get graph():Graph
		{
			var editor:GraphicEditor = this.editor;
			if (editor != null) 
			{
				return editor.graph;
			}
			return null;
		}
		/**
		 * 判断是不手柄。，由子类复写。
		 * @param arg1
		 * @return 
		 * 
		 */
		protected function isHandle(object:Object):Boolean
		{
			return false;
		}
		
		
		/**
		 *  
		 * @param event
		 * 
		 */
		internal function mouseDownInHandle(event:MouseEvent):void
		{
			event.stopPropagation();
			
			this.interactiveHandle = DisplayObject(event.currentTarget);
			this.handlePressed(this.interactiveHandle, event);
			this.startX = event.stageX;
			this.startY = event.stageY;
			
			var displayObject:DisplayObject=systemManager.getSandboxRoot();
			displayObject.addEventListener(flash.events.MouseEvent.MOUSE_UP, this.mouseUpInStage, true);
			displayObject.addEventListener(flash.events.MouseEvent.MOUSE_MOVE, this.mouseMoveInStage, true);
			displayObject.addEventListener(mx.events.SandboxMouseEvent.MOUSE_UP_SOMEWHERE, this.mouseUpInStage, true);
			displayObject.addEventListener(mx.events.SandboxMouseEvent.MOUSE_MOVE_SOMEWHERE, this.mouseMoveInStage, true);
			systemManager.deployMouseShields(true);
			return;
		}
		
		protected function mouseMoveInStage(event:MouseEvent):void
		{
			event.stopPropagation();
			
			var currentX:Number = event.stageX;
			var currentY:Number = event.stageY;
						
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
			
			this.handleDragged(this.interactiveHandle, event, currentX - this.lastX, currentY - this.lastY);
		}
		
		protected function mouseUpInStage(event:MouseEvent):void
		{
			if (this.interactiveHandle != null) 
			{
				this.handleReleased(this.interactiveHandle, event);
			}
			
			event.stopPropagation();
			var displayObject:DisplayObject=systemManager.getSandboxRoot();
			displayObject.removeEventListener(MouseEvent.MOUSE_UP, this.mouseUpInStage, true);
			displayObject.removeEventListener(MouseEvent.MOUSE_MOVE, this.mouseMoveInStage, true);
			displayObject.removeEventListener(SandboxMouseEvent.MOUSE_UP_SOMEWHERE, this.mouseUpInStage, true);
			displayObject.removeEventListener(SandboxMouseEvent.MOUSE_MOVE_SOMEWHERE, this.mouseMoveInStage, true);
			systemManager.deployMouseShields(false);
		}
		
		protected function handleDragged(displayObject:DisplayObject, event:MouseEvent, offsetX:Number, offsetY:Number):void
		{
			return;
		}
		
		protected function handlePressed(displayObject:DisplayObject, event:MouseEvent):void
		{
			event.stopPropagation();
			return;
		}
		
		/**
		 * 手柄放开，由子类继承并复写，实现具体内容。 
		 * @param arg1
		 * @param arg2
		 * 
		 */
		protected function handleReleased(displayObject:DisplayObject, event:MouseEvent):void
		{
			return;
		}
		
		protected function moveDragPoint(param1:Number, param2:Number) : void
		{
			var _loc_3:Point = new Point(param1, param2);
			var _loc_4:Point = this.editor.graph.localToGlobal(new Point(0, 0));
			_loc_3 = this.editor.graph.localToGlobal(_loc_3);
			this.startX = this.startX + (_loc_3.x - _loc_4.x);
			this.startY = this.startY + (_loc_3.y - _loc_4.y);
		}
		
		/**
		 * 为手柄添加侦听。 
		 * @param partName
		 * @param instance
		 * 
		 */
		protected override function partAdded(partName:String, instance:Object):void{
			var displayObject:DisplayObject = null;
			if (this.isHandle(instance)) 
			{
				displayObject = DisplayObject(instance);
				displayObject.addEventListener(MouseEvent.MOUSE_DOWN, this.mouseDownInHandle);
			}
			super.partAdded(partName, instance);
			return;
		}

		public function get interactiveHandle():DisplayObject
		{
			return _interactiveHandle;
		}

		public function set interactiveHandle(value:DisplayObject):void
		{
			_interactiveHandle = value;
		}

	}
}