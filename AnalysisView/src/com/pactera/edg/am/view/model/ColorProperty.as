package com.pactera.edg.am.view.model
{
	import mx.containers.*;
	import mx.controls.*;
	import mx.core.*;
    public class ColorProperty extends Object
    {
		public var searchModelColor:uint = 0xCEFF00;
		private var _mouselinecolor:uint = 0xE1A003;
		private var _basfillcolor:uint =0xCAE2F5;
		private var _comfillcolor:uint = 0xF8F3DF;
		private var _mousefillcolor:uint = 0xF9D76C;
		private var _linecolor:uint = 0x7F8C9F;
		private var _fontcolor:uint = 0;
		private var _swimfillcolor:uint = 0xB8C9DD;
		private var _bgcolor:uint = 0xD6DFE6;//14082022;
		//zzg 2011-12-15
		//定制getMoreModel颜色
		public var getMoreModelColor:uint =0xF1FEEF;
		//static const
		public var  analysisModelColor:uint = 0xFAD163;//16437603;
		//static const
		public var  analysisModelSecondColor:uint =0xFCF6DE;// 16578270;
		//static const
		public var etlBackgroudColorTypeObject:Object = {running:0x4AB64A, ready:0x2161DE, failed:0xFF0000, pending:0x9CC3F7, donetoday:0xFFFF00, donebefore:0xA5AED6};
		//static const
		public var colorDefault:uint = 0xE2EBFE;

		
		
		private  function getColorVal(defaultColor:uint,settingColor:String):uint{
			if(settingColor==null||settingColor.length==0){
				return defaultColor;
			}else{
				return uint(settingColor);
			}
		}
		private  function initEtlBgColorTypeObjectVal(etlType:String,settingColor:String):void{
			var defaultColor:uint=etlBackgroudColorTypeObject[etlType];
			etlBackgroudColorTypeObject[etlType]=getColorVal(defaultColor,settingColor);
		}
		
        public function ColorProperty()
        {
			//zzg 20130723 增加颜色定制参数
			if(Application!=null&&
				Application.application!=null&&
				Application.application.parameters!=null&&
				Application.application.parameters.isCustomColor=="1" //需要定义颜色
			){
				searchModelColor=getColorVal(searchModelColor,Application.application.parameters.mv_searchModelColor);
				_mouselinecolor=getColorVal(_mouselinecolor,Application.application.parameters.mv_mouselinecolor);
				_basfillcolor=getColorVal(_basfillcolor,Application.application.parameters.mv_basfillcolor);
				_comfillcolor=getColorVal(_comfillcolor,Application.application.parameters.mv_comfillcolor);
				_mousefillcolor=getColorVal(_mousefillcolor,Application.application.parameters.mv_mousefillcolor);
				_linecolor=getColorVal(_linecolor,Application.application.parameters.mv_linecolor);
				_fontcolor=getColorVal(_fontcolor,Application.application.parameters.mv_fontcolor);
				_swimfillcolor=getColorVal(_swimfillcolor,Application.application.parameters.mv_swimfillcolor);
				_bgcolor=getColorVal(_bgcolor,Application.application.parameters.mv_bgcolor);
				
				getMoreModelColor=getColorVal(_bgcolor,Application.application.parameters.mv_getMoreModelColor);
				analysisModelColor=getColorVal(analysisModelColor,Application.application.parameters.mv_analysisModelColor);
				analysisModelSecondColor=getColorVal(analysisModelSecondColor,Application.application.parameters.mv_analysisModelSecondColor);
				colorDefault=getColorVal(colorDefault,Application.application.parameters.mv_colorDefault);
				
				initEtlBgColorTypeObjectVal("running",Application.application.parameters.mv_etl_running_color);
				initEtlBgColorTypeObjectVal("ready",Application.application.parameters.mv_etl_ready_color);
				initEtlBgColorTypeObjectVal("failed",Application.application.parameters.mv_etl_failed_color);
				initEtlBgColorTypeObjectVal("pending",Application.application.parameters.mv_etl_pending_color);
				initEtlBgColorTypeObjectVal("donetoday",Application.application.parameters.mv_etl_donetoday_color);
				initEtlBgColorTypeObjectVal("donebefore",Application.application.parameters.mv_etl_donebefore_color);
			}
            return;
        }// end function

        public function get bgcolor() : uint
        {
            return this._bgcolor;
        }// end function

        public function get mousefillcolor() : uint
        {
            return this._mousefillcolor;
        }// end function

        public function get comfillcolor() : uint
        {
            return this._comfillcolor;
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
