package com.pactera.edg.am.dmv.utilities
{
    import flash.display.*;
    import flash.events.*;
    import flash.external.*;
    import flash.utils.getTimer;
    
    public class MouseWheelEnabler extends Object
    {
    	 private static var initialised:Boolean = false;
    	private static var currentItem:InteractiveObject;
        private static var browserMouseEvent:MouseEvent;

        static private var lastEventTime:uint = 0;
		
		static public var useRawValues:Boolean;
		static public var eventTimeout:Number = 50;		//in milliseconds
		
		

		
        public function MouseWheelEnabler()
        {
            return;
        }// end function

        public static function init(param1:Stage, _useRawDelta:Boolean = false) : void
        {
            if (!initialised)
            {
                initialised = true;
                registerListenerForMouseMove(param1);
                registerJS();
            }
            useRawValues = _useRawDelta;
            return;
        }// end function
 		private static function registerListenerForMouseMove(stage:Stage) : void
        {
        	//Generate a target and an internal mouse event so we can access
			//the mouse event properties when an external event is fired
            stage.addEventListener(MouseEvent.MOUSE_MOVE, function (event:MouseEvent) : void
												            {
												                currentItem = InteractiveObject(event.target);
												                browserMouseEvent = MouseEvent(event);
												                return;
												            }// end function
            );
            return;
        }// end function
        private static function registerJS() : void
        {
            if (ExternalInterface.available)
            {
                var id:String = 'mws_' + Math.floor(Math.random()*1000000);
				ExternalInterface.addCallback(id, function():void{});
				
				ExternalInterface.call(MouseWheelEnabler_JavaScript.CODE);
				ExternalInterface.call("mws.InitMouseWheelSupport", id);
				ExternalInterface.addCallback('externalMouseEvent', handleExternalMouseEvent);	
//                ExternalInterface.call(MouseWheelEnabler_JavaScript.CODE);
//                ExternalInterface.call("eb.InitMacMouseWheel", id);
//                ExternalInterface.addCallback("externalMouseEvent", handleExternalMouseEvent);
            }
            return;
        }// end function

       

        private static function handleExternalMouseEvent(rawDelta:Number, scaledDelta:Number) : void
        {
        	var delta:Number;
			var curTime:uint = getTimer();
			
			if (curTime >= eventTimeout + lastEventTime)
			{//dispatch
					if (useRawValues)
					{//use raw
						delta = rawDelta;
					}//use raw
					else
					{//use scaled
						delta = scaledDelta;
					}//use scaled
					
					
		            if (currentItem && browserMouseEvent)
		            {
		                currentItem.dispatchEvent(
						                new MouseEvent(MouseEvent.MOUSE_WHEEL, 
										                true, 
										                false,
										                 browserMouseEvent.localX, 
										                 browserMouseEvent.localY, 
										                 browserMouseEvent.relatedObject, 
										                 browserMouseEvent.ctrlKey, 
										                 browserMouseEvent.altKey, 
										                 browserMouseEvent.shiftKey, 
										                 browserMouseEvent.buttonDown, 
										                 int(delta)
									                 )
		                 );
		            }
		            
	          	  lastEventTime = curTime;
			}//dispatch
            return;
        }// end function

		public static function getBrowserInfo():BrowserInfo
		{//getBrowserInfo
			if (ExternalInterface.available)
			{//get browser info
				var infoObj:Object = ExternalInterface.call("mws.getBrowserInfo");
				var platformObj:Object = ExternalInterface.call("mws.getPlatformInfo");
				var agent:String = ExternalInterface.call("mws.getAgentInfo");
				var flashWmode:String  = ExternalInterface.call("mws.getFlashWmode");
				
				return new BrowserInfo(infoObj, platformObj, agent,flashWmode);
			}//get browser info
			else
			{//null
				return null;
			}//null
		}//getBrowserInfo
		
    }
}


class MouseWheelEnabler_JavaScript
{
	public static const CODE : XML = 
	
	<script><![CDATA[
		function()
		{
			// create unique namespace
			if(typeof mws == "undefined" || !mws)	
			{
				mws = {};
			}
			
			var userAgent = navigator.userAgent.toLowerCase();
			mws.agent = userAgent;
			mws.platform = 
			{
				win:/win/.test(userAgent),
				mac:/mac/.test(userAgent),
				other:!/win/.test(userAgent) && !/mac/.test(userAgent)
			};
			
			mws.vars = {};
			
			mws.browser = 
			{
				version: (userAgent.match(/.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/) || [])[1],
				safari: /webkit/.test(userAgent) && !/chrome/.test(userAgent),
				opera: /opera/.test(userAgent),
				msie: /msie/.test(userAgent) && !/opera/.test(userAgent),
				mozilla: /mozilla/.test(userAgent) && !/(compatible|webkit)/.test(userAgent),
				chrome: /chrome/.test(userAgent)
			};
			
			// find the function we added
			mws.findSwf = function(id) 
			{
				var objects = document.getElementsByTagName("object");
				for(var i = 0; i < objects.length; i++)
				{
					if(typeof objects[i][id] != "undefined")
					{
						return objects[i];
					}
				}
				
				var embeds = document.getElementsByTagName("embed");
				
				for(var j = 0; j < embeds.length; j++)
				{
					if(typeof embeds[j][id] != "undefined")
					{
						return embeds[j];
					}
				}
					
				return null;
			}
			mws._flashWmode="";
			mws.flashWmode =function (swf)
			{
				if( typeof swf.getAttribute == "undefined" )
				{
					return "undefined";
				}
				
				var _wmode = swf.getAttribute( "wmode" );
				if( typeof _wmode == "undefined" )
				{
					return "undefined";
				}
				return _wmode;
			}
			mws.usingWmode = function( swf )
			{
				if( typeof swf.getAttribute == "undefined" )
				{
					return false;
				}
				
				var wmode = swf.getAttribute( "wmode" );
				if( typeof wmode == "undefined" )
				{
					return false;
				}
				
				return true;
			}
			
			//Debug logging
			mws.log = function( message ) 
			{
				if( typeof console != "undefined" )
				{
					console.log( message );
				}
				else
				{
					//alert( message );
				}
			}
			
			mws.shouldAddHandler = function( swf )
			{
				if( !swf )
				{
					return false;
				}
				
				return true;
			}
			
			mws.getBrowserInfo = function()
			{//getBrowserObj
				return mws.browser;
			}//getBrowserObj
			
			mws.getAgentInfo = function()
			{//getAgentInfo
				return mws.agent;
			}//getAgentInfo
			
			mws.getPlatformInfo = function()
			{//getPlatformInfo
				return mws.platform;
			}//getPlatformInfo
			
			mws.getFlashWmode= function()
			{
			  return mws._flashWmode;	
		    }
			mws.addScrollListeners = function()
			{//addScrollListeners
				
				// install mouse listeners
				if(typeof window.addEventListener != 'undefined') 
				{
					window.addEventListener('DOMMouseScroll', _mousewheel, false);
				}
				
				window.onmousewheel = document.onmousewheel = _mousewheel;
				
			}//addScrollListeners
			
			mws.removeScrollListeners = function()
			{//removeScrollListeners
				// install mouse listeners
				if(typeof window.removeEventListener != 'undefined') 
				{
					window.removeEventListener('DOMMouseScroll', _mousewheel, false);
				}
				
				window.onmousewheel = document.onmousewheel = null;
			}//removeScrollListeners
			
			mws.InitMouseWheelSupport = function(id) 
			{//InitMouseWheelSupport
				//grab reference to the swf
				var swf = mws.findSwf(id);
				//alert("swf:"+mws.usingWmode(swf));
				//see if we can add the mouse listeners
				mws._flashWmode=mws.flashWmode(swf);
				
				var shouldAdd = mws.shouldAddHandler( swf );
				
				if( shouldAdd ) 
				{
					/// Mousewheel support
					_mousewheel = function(event) 
					{//Mouse Wheel
							
						//Cover for IE
						if (!event) event = window.event;
						
						var rawDelta = 0;
						var divisor = 1;
						var scaledDelta = 0;
						
						//Handle scaling the delta.
						//This is becoming less and less useful as more browser/hardware combos emerge.
						if(event.wheelDelta)	
						{//normal event
							rawDelta = event.wheelDelta;
							
							if(mws.browser.opera)
							{
								divisor = 12;
							}
							else if(mws.browser.safari && mws.browser.version.split(".")[0] >= 528)
							{
								divisor = 12;
							}
							else
							{
								divisor = 120;
							}
						}//normal event
						else if(event.detail)		
						{//special event
							rawDelta = -event.detail;
						}//special event
						else
						{//odd event
							//Unhandled event type (future browser graceful fail)
							rawDelta = 0;
							scaledDelta = 0;
							
							//alert('Odd Event');
						}//odd event
						
						if(Math.abs(rawDelta) >= divisor)
						{//divide
							scaledDelta = rawDelta/divisor;
						}//divide
						else
						{//don't scale
							scaledDelta = rawDelta;
						}//don't scale
						
						//Call into the swf to fire a mouse event
						swf.externalMouseEvent(rawDelta, scaledDelta);
						
						if(event.preventDefault)	
						{//Stop default action
							event.preventDefault();
						}//Stop default action
						else
						{//stop default action (IE)
							return false;
						}//stop default action (IE)
							
						return true;
					}//MouseWheel

					//set up listeners
					swf.onmouseover = mws.addScrollListeners;
					swf.onmouseout = mws.removeScrollListeners;
				}//Should Add
					
			}//InitMouseWheelSupport
			
		}
	]]></script>;
}

