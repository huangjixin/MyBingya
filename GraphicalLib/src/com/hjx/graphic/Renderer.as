/**
 * 2014-6-3,@author 黄记新
 */
package com.hjx.graphic
{
	import mx.core.IVisualElement;
	import mx.core.IVisualElementContainer;
	
	import spark.components.supportClasses.SkinnableComponent;
	
	/**
	 * 顶级渲染器，用于展示图形，它的后代可能是节点或者连线。
	 * 
	 */
	/**
	 *  边饰类，可以继承。
	 */
	[Style(name="adornerClass", inherit="yes", type="Class")]
	public class Renderer extends SkinnableComponent
	{
		
		public function Renderer()
		{
			super();
		}
		
		public function getX(renderer:Renderer):Number
		{
			var result:Number=NaN;
			if (renderer.left is Number) 
			{
				result = Number(renderer.left);
				if (!isNaN(result)) 
				{
					return result;
				}
			}
			return renderer.x;
		}
		
		public function setX(renderer:Renderer, x:Number):void
		{
			if (renderer.left is Number && !isNaN(Number(renderer.left))) 
			{
				renderer.left = x;
			}
			else 
			{
				renderer.x = x;
			}
			return;
		}
		
		public function getY(renderer:Renderer):Number
		{
			var result:Number=NaN;
			if (renderer.top is Number) 
			{
				result = Number(renderer.top);
				if (!isNaN(result)) 
				{
					return result;
				}
			}
			return renderer.y;
		}
		
		public function setY(renderer:Renderer, y:Number):void
		{
			if (renderer.top is Number && !isNaN(Number(renderer.top))) 
			{
				renderer.top = y;
			}
			else 
			{
				renderer.y = y;
			}
			return;
		}
		//---------------------------------------------------------------------
		//----- 可供继承的方法
		//---------------------------------------------------------------------
		/**
		 * 根据ID获得皮肤元素。
		 * @param id 参数id为字符串，将通过id查询皮肤元素。
		 * @return 
		 * 
		 */
		protected function getSkinElementById(id:String):IVisualElement
		{
			if(!skin)
				return null;
			if(skin is IVisualElementContainer)
				return getSkinElementByIdImpl(IVisualElementContainer(skin),id);
			return null;
		}//getSkinElementById结束
		
		/**
		 * 根据ID获得皮肤元素的具体实现方法,遍历皮肤容器（请注意学习相关技巧）。 
		 * @param id
		 * @return 
		 * 
		 */
		private function getSkinElementByIdImpl(iVisualContainer:IVisualElementContainer,id:String):IVisualElement
		{
			var ele:IVisualElement;
			var eleNum:int = 0;
			var length:int = iVisualContainer.numElements;
			while(eleNum < length){
				ele = iVisualContainer.getElementAt(eleNum);
				if(ele["id"] && ele["id"]==id)
					return ele;
				
				if(ele is IVisualElementContainer)
					return getSkinElementByIdImpl(IVisualElementContainer(ele),id);
				
			}
			return null;
		}
	}
}