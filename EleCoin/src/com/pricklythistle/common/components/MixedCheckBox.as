package com.pricklythistle.common.components
{
	import flash.display.Graphics;
	import flash.events.Event;
	
	import mx.controls.CheckBox;

	public class MixedCheckBox extends CheckBox
	{
		private var _value:int;
		
		public function MixedCheckBox():void
		{
			this.addEventListener(Event.CHANGE,onCheckBoxChange);
		}
		
		private function onCheckBoxChange(e:Event):void
		{
			if (this.selected)
			{
				value = 1;
			} else {
				value = 0;
			}
		}
		
		public function set value (v:int):void
		{
			this.removeEventListener(Event.CHANGE,onCheckBoxChange);
			
			_value = v;
			
			switch(v)
			{
				case 0:
				this.selected = false;
				break;
				
				case 1:
				this.selected = true;
				break;
				
				case 2:
				this.selected = false;
				break;
			}
			
			
			updateGraphics();
			
			this.addEventListener(Event.CHANGE,onCheckBoxChange);
		}
		
		private function updateGraphics():void
		{
			var g:Graphics = this.graphics;
			
			g.clear();
			
			if(value == 2)
			{
				//draw black square indicating some children selected some not
				g.beginFill(0x000000,1);
				var gX:Number = this.width/2+4;
				var gY:Number = this.height/2-4;
				g.drawRect(gX,gY,8,8);
//				g.endFill();
			}
		}
		
		[Bindable]
		public function get value ():int
		{
			return _value;
		}
	}
}