package com.pactera.edg.am.kpi.rightClick
{
    import flash.display.*;
    import flash.events.*;
    import flash.external.*;
    import mx.core.*;

    public class RightClickManager extends Object
    {
        private static const javascript:XML = <script>
        	<![CDATA[
				function(flashObjectId)
				{				
					var RightClick = {
						init: function (flashObjectId) {
							this.FlashObjectID = flashObjectId;
							this.Cache = this.FlashObjectID;
							if(window.addEventListener){
								 window.addEventListener("mousedown", this.onGeckoMouse(), true);
							} else {
								document.getElementById(this.FlashObjectID).parentNode.onmouseup = function() { document.getElementById(RightClick.FlashObjectID).parentNode.releaseCapture(); }
								document.oncontextmenu = function(){ if(window.event.srcElement.id == RightClick.FlashObjectID) { return false; } else { RightClick.Cache = "nan"; }}
								document.getElementById(this.FlashObjectID).parentNode.onmousedown = RightClick.onIEMouse;
							}
						},
						killEvents: function(eventObject) {
							if(eventObject) {
								if (eventObject.stopPropagation) eventObject.stopPropagation();
								if (eventObject.preventDefault) eventObject.preventDefault();
								if (eventObject.preventCapture) eventObject.preventCapture();
						   		if (eventObject.preventBubble) eventObject.preventBubble();
							}
						},
						onGeckoMouse: function(ev) {
						  	return function(ev) {
						    if (ev.button != 0) {
								RightClick.killEvents(ev);
								if(ev.target.id == RightClick.FlashObjectID && RightClick.Cache == RightClick.FlashObjectID) {
						    		RightClick.call();
								}
								RightClick.Cache = ev.target.id;
							}
						  }
						},
						onIEMouse: function() {
						  	if (event.button ==2||event.button==0) {
								if(window.event.srcElement.id == RightClick.FlashObjectID && RightClick.Cache == RightClick.FlashObjectID) {
									RightClick.call(); 
								}
								document.getElementById(RightClick.FlashObjectID).parentNode.setCapture();
								if(window.event.srcElement.id)
								RightClick.Cache = window.event.srcElement.id;
							}
						},
						call: function() {
//							mainApp.rightClick();
						}
					}
					
					RightClick.init(flashObjectId);
				}
        	]]>
        </script>;
        public static const RIGHT_CLICK:String = "rightClick";
        private static var rightClickTarget:DisplayObject;

        public function RightClickManager()
        {
            return;
        }// end function

        public static function regist() : Boolean
        {
            if (ExternalInterface.available)
            {
                ExternalInterface.addCallback("rightClick", dispatchRightClickEvent);
                Application.application.addEventListener(MouseEvent.MOUSE_OVER, mouseOverHandler);
            }
            return true;
        }// end function

        private static function mouseOverHandler(event:MouseEvent) : void
        {
            rightClickTarget = DisplayObject(event.target);
            return;
        }// end function

        private static function dispatchRightClickEvent() : void
        {
            var _loc_1:* = null;
            if (rightClickTarget != null)
            {
                _loc_1 = new MouseEvent(RIGHT_CLICK, true, false, rightClickTarget.mouseX, rightClickTarget.mouseY);
                rightClickTarget.dispatchEvent(_loc_1);
            }
            return;
        }// end function

    }
}
