package com.pactera.edg.am.dmv.tween
{
    import flash.display.*;
    import flash.events.*;
    import flash.filters.*;

    public class GlowTween
    {
        private var _color:uint;
        private var _blur:Number;
        private var _target:InteractiveObject;
        private var _toggle:Boolean;

        public function GlowTween(param1:InteractiveObject, param2:uint = 16777215)
        {
            _target = param1;
            _color = param2;
            _toggle = true;
            _blur = 2;
            return;
        }// end function

        private function startGlowHandler(event:MouseEvent) : void
        {
            _target.addEventListener(Event.ENTER_FRAME, blinkHandler, false, 0, true);
            return;
        }// end function

        public function remove() : void
        {
            _target.removeEventListener(Event.ENTER_FRAME, blinkHandler);
            _target.filters = null;
            _target = null;
            return;
        }// end function

        private function blinkHandler(event:Event) : void
        {
            if (_blur >= 10)
            {
                _toggle = false;
            }
            else if (_blur <= 2)
            {
                _toggle = true;
            }
            if (_toggle)
            {
                var _loc_4:* = _blur + 1;
                _blur = _loc_4;
            }
            else
            {
                _blur = _blur - 1;
            }
            var _loc_2:* = new GlowFilter(_color, 1, _blur, _blur, 2, 2);
            _target.filters = [_loc_2];
            return;
        }// end function

        public function stopGlow() : void
        {
            _target.removeEventListener(Event.ENTER_FRAME, blinkHandler);
            _target.filters = null;
            return;
        }// end function

        public function startGlow() : void
        {
            _target.addEventListener(Event.ENTER_FRAME, blinkHandler, false, 0, true);
            return;
        }// end function

        private function stopGlowHandler(event:MouseEvent) : void
        {
            _target.removeEventListener(Event.ENTER_FRAME, blinkHandler);
            _target.filters = null;
            return;
        }// end function

    }
}
