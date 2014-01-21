package com.hjx.bpmn.graphic
{
	import com.hjx.graphic.Renderer;
	
	import mx.core.IVisualElement;
	import mx.events.ResizeEvent;
	
	import spark.layouts.VerticalAlign;
	import spark.layouts.VerticalLayout;

	/**
	 * 横甬道池，用于放置甬道。 
	 * @author huangjixin
	 * 
	 */
	public class HorizontalPool extends HorizontalLane
	{
		public function HorizontalPool()
		{
			super();	
		}
		
		/**
		 * 更改布局为横布局。 
		 * @param partName
		 * @param instance
		 * 
		 */
		protected override function partAdded(partName:String, instance:Object):void
		{
			super.partAdded(partName, instance);
			if (instance == graph) 
			{
				/*var vLayout:VerticalLayout= new VerticalLayout();vLayout.verticalAlign= VerticalAlign.MIDDLE;
				vLayout.gap = -2;
				this.graph.layout =vLayout;
				this.graph.allowReparenting = false;*/
			}
		}
	}
}