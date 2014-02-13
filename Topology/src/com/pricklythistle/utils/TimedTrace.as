package com.pricklythistle.utils
{
	import flash.utils.Dictionary;
	import flash.utils.getTimer;
	
	public class TimedTrace
	{
		public function TimedTrace()
		{
			super();
		}
		
		private static var traceCache:Dictionary = new Dictionary();
		
		public static function timedTrace(message:String,key:String = "timedTrace", display:Boolean = true):void
		{			
			var lastCall:uint = traceCache[key];
			var currentTime:uint = getTimer();
			if(lastCall == 0)
			{
				display = false;
			} else {
				var elapsedTime:uint = currentTime - lastCall;
			}
			
			trace(key + ": " + message + " : " + elapsedTime);
			
			traceCache[key] = currentTime;
		}

	}
}