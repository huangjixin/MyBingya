package com.hjx.bpmn.graphic
{
	import com.hjx.jbpm.Start_state;

	public class StartEvent extends Event
	{
		public var star_state:Start_state = new Start_state();
		
		public function StartEvent()
		{
			super();
		}
		
		override public function set label(value:String):void{
			super.label = value;
			
			star_state.name = value;
		}
	}
}