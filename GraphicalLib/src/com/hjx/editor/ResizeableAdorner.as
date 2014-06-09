package com.hjx.editor
{
	import com.hjx.graphic.Renderer;
	
	import flash.display.DisplayObject;
	import flash.events.MouseEvent;
	import flash.geom.Rectangle;
	
	/**
	 * @date 2014-6-6,@author 黄记新
	 */
	public class ResizeableAdorner extends Adorner
	{
		[SkinPart(required="false")]
		public var topLeftHandle:DisplayObject;
		[SkinPart(required="false")]
		public var topRightHandle:DisplayObject;
		[SkinPart(required="false")]
		public var bottomLeftHandle:DisplayObject;
		[SkinPart(required="false")]
		public var bottomRightHandle:DisplayObject;
		
		public function ResizeableAdorner(adornedObj:Renderer)
		{
			super(adornedObj);
		}
		
		private function isResizeHandle(object:Object):Boolean
		{
			return object == this.topLeftHandle || object == this.topRightHandle || object == this.bottomRightHandle || object == this.bottomLeftHandle;
		}
		
		override protected function handleDragged(displayObject:DisplayObject, event:MouseEvent, offsetX:Number, offsetY:Number):void
		{
			if (ResizeHandle(displayObject)) 
			{
				//对所有的选中节点进行缩放和位置调整。
				var selectedObjs:Vector.<Renderer> = this.editor.getSelectedObjects();
				for each (var renderer:Renderer in selectedObjs) 
				{
					var adornerClass:* = renderer.getStyle("adornerClass");
					if(undefined != adornerClass && new adornerClass(renderer) is ResizeableAdorner){
						
						var offsetWidth:Number = 0;
						var offsetHeight:Number = 0;
						var rect:Rectangle = getAdornerRectangle(graph);
						
						var changedRect:Rectangle;
						
						if(displayObject == bottomRightHandle){	//右下边缩放，不用位移
							resizeAdornedObject(renderer,offsetX, offsetY,displayObject);
							changedRect = getAdornerRectangle(graph);
						}else if(displayObject == topLeftHandle){
							translateAdornedObject(renderer,offsetX, offsetY,displayObject);
							resizeAdornedObject(renderer,-offsetX, -offsetY,displayObject);
						}else if(displayObject == bottomLeftHandle){
							translateAdornedObject(renderer,offsetX, 0,displayObject);
							resizeAdornedObject(renderer,-offsetX, offsetY,displayObject);
						}else if(displayObject == topRightHandle){
							translateAdornedObject(renderer,0, offsetY,displayObject);
							resizeAdornedObject(renderer,offsetX, -offsetY,displayObject);
						}
						editor.validateNow();
					}
				}
			}else 
			{
				super.handleDragged(displayObject, event, offsetX, offsetY);
			}
		}
		
		//位移
		protected function translateAdornedObject(adornedObject:Renderer,offsetX:Number, offsetY:Number,displayObject:DisplayObject ):void
		{
			adornedObject.setX(adornedObject,adornedObject.getX(adornedObject)+offsetX);
			adornedObject.setY(adornedObject,adornedObject.getY(adornedObject)+offsetY);
		}
		
		//缩放大小
		protected function resizeAdornedObject(adornedObject:Renderer,offsetX:Number, offsetY:Number,displayObject:DisplayObject):void
		{
			var newWidth:Number= adornedObject.width + offsetX;
			var newHeight:Number=adornedObject.height + offsetY;
			
			if (!isNaN(adornedObject.minWidth)) 
			{
				newWidth = Math.max(newWidth, adornedObject.minWidth);
			}
			if (!isNaN(adornedObject.minHeight)) 
			{
				newHeight = Math.max(newHeight, adornedObject.minHeight);
			}
			if (!isNaN(adornedObject.maxWidth)) 
			{
				newWidth = Math.min(newWidth, adornedObject.maxWidth);
			}
			if (!isNaN(adornedObject.maxHeight)) 
			{
				newHeight = Math.min(newHeight, adornedObject.maxHeight);
			}
			
			newWidth = Math.max(newWidth, 20);
			newHeight = Math.max(newHeight, 20);
			
			var rect:Rectangle = getAdornerRectangle(graph);
			if(displayObject == bottomRightHandle){
				if(graph.mouseX < rect.x + newWidth ||graph.mouseY < rect.y +newHeight ){
					return;
				}
			}else if(displayObject == bottomLeftHandle){
				if(graph.mouseX < rect.x - newWidth ||graph.mouseY < rect.y + newHeight ){
					return;
				}
			}
			
			adornedObject.width = newWidth;
			adornedObject.height = newHeight;
		}
		
		override protected function isHandle(object:Object):Boolean
		{
			if(object is ResizeHandle)
				return true;
			return super.isHandle(object);
		}
	}
}