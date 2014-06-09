package com.pactera.edg.am.dmv.view.model
{
	import mx.containers.*;
	import mx.controls.*;
	import mx.core.*;
    public class ColorProperty extends Object
    {
		private var _comfillcolor:uint = 0xB8C9DD;
		private var _mouselinecolor:uint = 0xFF8B00;
		private var _basfillcolor:uint = 0xFCF6DE;
		private var _effectColor:uint = 0xDE1E3D;
		private var _borderColor:uint = 0x4277A9;
		private var _mousefillcolor:uint = 0xFCEB60;
		private var _shadowColor:uint = 0;
		private var _dashBorderColor:uint = 0x8FA1AF;
		private var _linecolor:uint = 0x769CC0;
		private var _fontcolor:uint = 0;
		private var _swimfillcolor:uint = 0xB8C9DD;
		private var _bgcolor:uint = 0xDEEBFF;
		
		
		private var _gradientColors:Array = [0xD3E8F9, 0x99CDFF];
		private var _odsGradientColors:Array =[0xD0EFBF, 0x9FE18D];
		public static const colorTypeObject:Object = {System:0xFFFFFF, SystemLevel:0x80C1FE};
		
		private  function getColorVal(defaultColor:uint,settingColor:String):uint{
			if(settingColor==null||settingColor.length==0){
				return defaultColor;
			}else{
				return uint(settingColor);
			}
		}
		private  function initColorTypeObjectVal(colorType:String,settingColor:String):void{
			var defaultColor:uint=colorTypeObject[colorType];
			colorTypeObject[colorType]=getColorVal(defaultColor,settingColor);
		}
		
		private  function initGradientColorsVal(defaultValA:uint,defaultValB:uint,settingColorA:String,settingColorB:String):void{
			_gradientColors[0]=getColorVal(defaultValA,settingColorA);
			_gradientColors[1]=getColorVal(defaultValB,settingColorB);
		}
		private  function initOdsGradientColorsVal(defaultValA:uint,defaultValB:uint,settingColorA:String,settingColorB:String):void{
			_odsGradientColors[0]=getColorVal(defaultValA,settingColorA);
			_odsGradientColors[1]=getColorVal(defaultValB,settingColorB);
		}
		public function ColorProperty()
		{
			//zzg 20130723 增加颜色定制参数
			if(Application!=null&&
				Application.application!=null&&
				Application.application.parameters!=null&&
				Application.application.parameters.isCustomColor=="1" //需要定义颜色
			){
				_comfillcolor=getColorVal(_comfillcolor,Application.application.parameters.dmv_comfillcolor);
				_mouselinecolor=getColorVal(_mouselinecolor,Application.application.parameters.dmv_mouselinecolor);
				_basfillcolor=getColorVal(_basfillcolor,Application.application.parameters.dmv_basfillcolor);
				_effectColor=getColorVal(_effectColor,Application.application.parameters.dmv_effectColor);
				_borderColor=getColorVal(_borderColor,Application.application.parameters.dmv_borderColor);
				_mousefillcolor=getColorVal(_mousefillcolor,Application.application.parameters.dmv_mousefillcolor);
				_shadowColor=getColorVal(_shadowColor,Application.application.parameters.dmv_shadowColor);
				_dashBorderColor=getColorVal(_dashBorderColor,Application.application.parameters.dmv_dashBorderColor);
				_linecolor=getColorVal(_linecolor,Application.application.parameters.dmv_linecolor);
				_fontcolor=getColorVal(_fontcolor,Application.application.parameters.dmv_fontcolor);
				_swimfillcolor=getColorVal(_swimfillcolor,Application.application.parameters.dmv_swimfillcolor);
				_bgcolor=getColorVal(_bgcolor,Application.application.parameters.dmv_bgcolor);
				
				//初始化_gradientColors数组
				initGradientColorsVal(
					_gradientColors[0],
					_gradientColors[1],
					Application.application.parameters.dmv_gradientColors_index_0_color,
					Application.application.parameters.dmv_gradientColors_index_1_color);
				
				//初始化_odsGradientColors数组
				initOdsGradientColorsVal(
					_gradientColors[0],
					_gradientColors[1],
					Application.application.parameters.dmv_odsgradientColors_index_0_color,
					Application.application.parameters.dmv_odsgradientColors_index_1_color);
				
				//初始化colorTypeObject对象
				initColorTypeObjectVal("System",Application.application.parameters.dmv_colorTypeObject_system_color);
				initColorTypeObjectVal("SystemLevel",Application.application.parameters.dmv_colorTypeObject_systemlevel_color);
			}
			
			
			return;
		}// end function

        public function get gradientColors() : Array
        {
            return this._gradientColors;
        }// end function

        public function get comfillcolor() : uint
        {
            return this._comfillcolor;
        }// end function

        public function get mousefillcolor() : uint
        {
            return this._mousefillcolor;
        }// end function

        public function get bgcolor() : uint
        {
            return this._bgcolor;
        }// end function

        public function get borderColor() : uint
        {
            return this._borderColor;
        }// end function

        public function get effectColor() : uint
        {
            return this._effectColor;
        }// end function

        public function get odsGradientColors() : Array
        {
            return this._odsGradientColors;
        }// end function

        public function get shadowColor() : uint
        {
            return this._shadowColor;
        }// end function

        public function get dashBorderColor() : uint
        {
            return this._dashBorderColor;
        }// end function

        public function get basfillcolor() : uint
        {
            return this._basfillcolor;
        }// end function

        public function get linecolor() : uint
        {
            return this._linecolor;
        }// end function

        public function get mouselinecolor() : uint
        {
            return this._mouselinecolor;
        }// end function

        public function get swimfillcolor() : uint
        {
            return this._swimfillcolor;
        }// end function

        public function get fontcolor() : uint
        {
            return this._fontcolor;
        }// end function

    }
}
