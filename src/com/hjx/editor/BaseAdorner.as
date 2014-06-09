package com.hjx.editor
{
	import com.hjx.graphic.Renderer;
	
	import flash.display.DisplayObject;
	import flash.geom.Rectangle;
	
	import mx.events.FlexEvent;
	
	import spark.components.supportClasses.SkinnableComponent;
	
	/**
	 * @date 2014-6-6,@author 黄记新
	 */
	public class BaseAdorner extends SkinnableComponent
	{
		public var adornedObject:Renderer;
		
		public function BaseAdorner(adornedObject:Renderer)
		{
			super();
			this.adornedObject = adornedObject;
			
			adornedObject.addEventListener(FlexEvent.UPDATE_COMPLETE, this.updateCompleteHandler);
		}
		
		protected function updateCompleteHandler(event:FlexEvent):void
		{
			invalidateProperties();
		}
		
		public function isMouseNear(offset:Number):Boolean
		{
			var rect:Rectangle=getBounds(stage);
			rect.x = rect.x - offset;
			rect.y = rect.y - offset;
			rect.width = rect.width + 2 * offset;
			rect.height = rect.height + 2 * offset;
			return rect.contains(stage.mouseX, stage.mouseY);
		}
		
		/**
		 * 获得边饰相对的矩形框。 
		 * @param displayObject
		 * @return 
		 * 
		 */
		protected function getAdornerRectangle(displayObject:DisplayObject):Rectangle
		{
			return this.adornedObject.getBounds(displayObject);
		}
		
		/**
		 * 复写 commitProperties函数以便让其自动更新位置。
		 * 
		 */
		override protected function commitProperties():void
		{
			super.commitProperties();
			
			if (parent != null) 
			{
				var rectangle:Rectangle=null;
				rectangle = this.getAdornerRectangle(parent);
				this.left = rectangle.x;
				this.top = rectangle.y;
				this.width = rectangle.width;
				this.height = rectangle.height;
			}
			return;
		}
	}
}