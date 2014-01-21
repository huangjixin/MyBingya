package com.itsm.common
{
	import flash.events.Event;  
	
	import mx.controls.CheckBox;  
	public class CheckBoxItemDataRenderer extends CheckBox  
	{  
		public function CheckBoxItemDataRenderer()  
		{  
			super();  
			this.addEventListener(Event.CHANGE, changeHandler);  
		}  
		

		override public function set data(value:Object):void  
		{  
			super.data = value;  
			this.selected = listData.label == 'true';  
		}  
		 
		protected function changeHandler(event : Event) : void  
		{  
			if(data is XML)  
				data.@selected = this.selected;  
			else  
				data.selected = this.selected;  
			}  
		  
		}
}