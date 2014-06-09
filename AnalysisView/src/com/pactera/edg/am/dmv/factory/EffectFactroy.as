package com.pactera.edg.am.dmv.factory
{
    import mx.effects.*;

    public class EffectFactroy extends Object
    {

        public function EffectFactroy()
        {
            return;
        }// end function

        public static function getIrisEffect() : Iris
        {
            var _loc_1:* = new Iris();
            _loc_1.showTarget = true;
            _loc_1.duration = 2000;
            return _loc_1;
        }// end function

        public static function getFadeEffect() : Fade
        {
            var _loc_1:* = new Fade();
            _loc_1.alphaFrom = 0;
            _loc_1.alphaTo = 1;
            _loc_1.duration = 4000;
            return _loc_1;
        }// end function

        public static function getGlowEffect(param1:uint) : Glow
        {
            var _loc_2:* = new Glow();
            _loc_2.alphaFrom = 0.6;
            _loc_2.alphaTo = 0;
            _loc_2.blurXFrom = 0;
            _loc_2.blurXTo = 50;
            _loc_2.blurYFrom = 0;
            _loc_2.blurYTo = 50;
            _loc_2.duration = 1000;
            _loc_2.color = param1;
            _loc_2.repeatDelay = 100;
            return _loc_2;
        }// end function

    }
}
