package com.pactera.edg.am.view
{
    import com.pactera.edg.am.factory.*;
    import com.pactera.edg.am.system.*;
    import com.pactera.edg.am.utilities.*;
    import com.pactera.edg.am.view.model.*;
    
    import flash.display.*;
    import flash.events.*;
    import flash.external.ExternalInterface;
    import flash.geom.*;
    import flash.net.*;
    import flash.system.*;
    import flash.utils.*;
    
    import mx.containers.*;
    import mx.controls.*;
    import mx.core.*;
    import mx.effects.*;
    import mx.events.*;
    import mx.graphics.*;
    import mx.graphics.codec.*;
    import mx.managers.*;
    import mx.printing.*;
    import mx.utils.*;
		
    public class MyUIComponent extends HBox
    {
        private var _smallMapView:com.pactera.edg.am.view.CustomSmallMap;
        private var num:Number = 1;
        private var factory:ModelFactory = null;
        private var matchReg:RegExp;
        private var myTextArea:TextInput;
        private var linkBar:LinkBar;
        private var type:String;
        private var _matchModels:Array = null;
        private var zoom:Zoom;
        private var _modelView:ModelView;
        private var filterBar:com.pactera.edg.am.view.analysisFilter;
        private var myButton:Button;
        public static const SEARCH_RESULT:String = "seachResult";

        public function MyUIComponent()
        {
			trace("MyUIComponent create ...");
            this.zoom = new Zoom();
            this.factory = ApplicationConfig.getInstance().modelFactory;
			trace("MyUIComponent set factory ...");
            this.addEventListener(MouseEvent.CLICK, this.filterView);
            return;
        }// end function

        private function doprint() : void
        {
            var _loc_1:* = new FlexPrintJob();
            if (_loc_1.start() != true)
            {
                return;
            }
            _loc_1.addObject(this.modelView.container);
            _loc_1.send();
            return;
        }// end function

        private function doTour() : void
        {
            this.modelView.tourFlag = !this.modelView.tourFlag;
            return;
        }// end function

        private function sendKeyHandler(event:KeyboardEvent) : void
        {
        	trace("[sendKeyHandler]"+event.keyCode);
        	//ExternalInterface.call("getFlashInputHelperValue");
            if (event.keyCode == 13)
            {
                this.fetchMatchModels();
            }
            return;
        }// end function

        public function get smallMapView() : com.pactera.edg.am.view.CustomSmallMap
        {
            return this._smallMapView;
        }// end function
        
        
        
        
    	////////////////////////////////////////////////////////
		//zzg 2011-12-17
		//通过客户端js逻辑配合，修复透明flash引起的中文输入bug
		//目前，已经能输入中文，并能回车、退格删除，基本可满足输入框文字输入要求。 
		public static const initFlashImeBugJs : XML = 
		    <script><![CDATA[
				function installFih(flashObjectId)
				{
							// create unique namespace
							//flash输入法(IME)辅助类(Helper)
							//fih:Flash Ime Helper
							if(typeof fih == "undefined" || !fih)	
							{
								fih = {};
							}	
							fih.init=function(){
				                var inputCtlObj=document.getElementById(this.inputCtrlId);
								if(typeof inputCtlObj == "undefined" || !inputCtlObj)	
							    {   
									var input =document.createElement("<input type='text' id='"+this.inputCtrlId+"' value='' onkeyDown='fih.onFlashInputHelperKeyDown(event)' width='0'>");
						            document.body.appendChild(input);
							    }
							}
							fih.timeoutId=0;
							fih.inputCtrlId="flashInputHelper";
							fih.FlashObjectID=flashObjectId;
						    fih.setFlashInputHelperFocus=function (){
						       document.getElementById(this.inputCtrlId).focus();
							    //先清除定时器
								if (this.timeoutId != 0) {
									try{
										clearTimeout(this.timeoutId);
										this.timeoutId = 0;
									}catch(err){}
								}
							   this.timeoutId=setTimeout("fih.onFlashInputHelperChange()", 100);
						    }
						    fih.onFlashInputHelperChange=function (){
						    	//customRightClick
						    	var flashObj=document.getElementById(this.FlashObjectID);
						    	var inputCtlObj=document.getElementById(this.inputCtrlId);
								if(flashObj.flashInputHelperValueChange!=null){
							       flashObj.flashInputHelperValueChange(inputCtlObj.value);
								   inputCtlObj.value="";//清空
								}
							    this.timeoutId=setTimeout("fih.onFlashInputHelperChange()", 100);
						    }
						
						   fih.onFlashInputHelperKeyDown=function (e){
									var keynum;
								    if(window.event){//IE
								       keynum = e.keyCode
									}else if(e.which) // Netscape/Firefox/Opera
									{
									   keynum = e.which
									}
									if(keynum==8||keynum==13)//
									{//Backspace(8) or Enter(13)
								        //alert(keynum);
								        var flashObj=document.getElementById(this.FlashObjectID);
								        var inputCtlObj=document.getElementById(this.inputCtrlId);
										if(flashObj.flashInputHelperValueChange!=null){
										   flashObj.flashInputHelperValueChange("key_down_"+keynum);
										  // alert(keynum);
										   inputCtlObj.value="";//清空
										}
									}
								}
								fih.init();
				}
			]]></script>;


		private function textInputFocusInHandler(e:FocusEvent):void 
		{
			if (this.stage.displayState == StageDisplayState.FULL_SCREEN)
            {
                  return;//全屏模式，不需要修复中文输入bug
	        }
	        
			//尝试设置中文输入法
			if (Capabilities.hasIME)
			{
			    try
			    {
			        IME.enabled = true;
			        IME.conversionMode = IMEConversionMode.CHINESE;
			    }
			    catch (error:Error)
			    {
			    	trace("[textInputFocusInHandler]:"+error);
			    }
			}
		    
		    var wmode:String=com.pactera.edg.am.utilities.MouseWheelEnabler.getBrowserInfo().flashWmode;
        	//trace("wmode:"+wmode);
        	if(wmode!=null&&wmode.toLowerCase()=="opaque"){//增加定制菜单的时候，需要修复透明flash引起的中文输入问题
				//初始化
				 initCallBackFunc(this.myTextArea);
				  //定位到网页焦点,辅助输入
				 ExternalInterface.call("fih.setFlashInputHelperFocus");
        	}
		}
		private static var isInitCBF:Boolean=false;
		private static function initCallBackFunc(_flashInputObj:TextInput):void{
			if(!isInitCBF){
			    flashInputObj=_flashInputObj;
			    if (ExternalInterface.available)
	            {
	            	//脚本注入
	                ExternalInterface.call(initFlashImeBugJs, ExternalInterface.objectID);
	                ExternalInterface.addCallback('flashInputHelperValueChange', flashInputHelperValueChange);	
	            }
			    isInitCBF=true;
			}
			return;
		}
		private static  var flashInputObj:TextInput;
	    private  static function flashInputHelperValueChange(val:String) : void
        {
        	if(val!=null&&val.length>0){
        		  var event_down:KeyboardEvent;
        		  var event_up:KeyboardEvent;
        		  var keyCode:int;
        		  
        		  var selectionBeginIndex:int;
        		  var selectionEndIndex:int;
        		  var tmpStr:String;
        		if(val=="key_down_8"){//特殊字符传递
        		    //Alert.show("val:"+val);
        		    //测试发现模拟事件无法退格删除,故通过其他方法模拟
//        		     keyCode=8;
//        		     event_down = new KeyboardEvent(KeyboardEvent.KEY_DOWN);
//        		    event_down.keyCode= keyCode;
//        			flashInputObj.dispatchEvent(event_down);
//        			
//        			event_up = new KeyboardEvent(KeyboardEvent.KEY_UP);
//        		    event_up.keyCode= keyCode;
//        			flashInputObj.dispatchEvent(event_up);
        			
        			 selectionBeginIndex=flashInputObj.selectionBeginIndex;//=0;
	        		 selectionEndIndex=flashInputObj.selectionEndIndex;//=0;
	        		 tmpStr=flashInputObj.text;
	        		if(selectionBeginIndex!=selectionEndIndex){
	        			flashInputObj.text=tmpStr.substring(0,selectionBeginIndex)+tmpStr.substring(selectionEndIndex);
	        			flashInputObj.selectionBeginIndex=selectionBeginIndex;
	        		    flashInputObj.selectionEndIndex=selectionBeginIndex;
	        		}else{
	        			flashInputObj.text=tmpStr.substring(0,selectionBeginIndex-1)+tmpStr.substring(selectionEndIndex);
	        			var newIdx:int=selectionBeginIndex-1;
	        			if(newIdx<0){
	        				newIdx=0;
	        			}
	        			flashInputObj.selectionBeginIndex=newIdx;
	        		    flashInputObj.selectionEndIndex=newIdx;
	        		}
	        		
	        		
        		}else if(val=="key_down_13"){	
        		     keyCode=13;
        		     event_down = new KeyboardEvent(KeyboardEvent.KEY_DOWN);
        		    event_down.keyCode= keyCode;
        			flashInputObj.dispatchEvent(event_down);
        			
        			 event_up = new KeyboardEvent(KeyboardEvent.KEY_UP);
        		    event_up.keyCode= keyCode;
        			flashInputObj.dispatchEvent(event_up);	
        		}else{
	        		 selectionBeginIndex=flashInputObj.selectionBeginIndex;//=0;
	        		 selectionEndIndex=flashInputObj.selectionEndIndex;//=0;
	        		 tmpStr=flashInputObj.text;
	        		flashInputObj.text=tmpStr.substring(0,selectionBeginIndex)+val+tmpStr.substring(selectionEndIndex);
	        		flashInputObj.selectionBeginIndex=selectionBeginIndex+val.length;
	        		flashInputObj.selectionEndIndex=selectionBeginIndex+val.length;
	        	    //flashInputObj.text+=val;
        	 	}
        	}
        }

   
   
   
        override protected function createChildren() : void
        {
            var _loc_1:Class = null;
            var _loc_2:Array = null;
            super.createChildren();
            if (this.myTextArea == null)
            {
                this.myTextArea = new TextInput();
                this.myTextArea.editable = true;
                this.myTextArea.visible = false;
                //this.myTextArea.imeMode="CHINESE"; //简体中文IME
                this.myTextArea.focusEnabled=true;
                this.myTextArea.mouseFocusEnabled=true;
                this.myTextArea.enabled=true;
               
                this.myTextArea.addEventListener(FocusEvent.FOCUS_IN, textInputFocusInHandler);
               // this.myTextArea.addEventListener(MouseEvent.MOUSE_DOWN,textInputMouseDownInHandler);//function(event:MouseEvent):void{this.myTextArea.setFocus();});
                addChild(this.myTextArea);
                this.myTextArea.addEventListener(KeyboardEvent.KEY_DOWN, this.sendKeyHandler);
            }
            if (this.myButton == null)
            {
                this.myButton = new Button();
                this.myButton.label = "查询";
                this.myButton.visible = false;
                this.myButton.addEventListener(MouseEvent.CLICK, this.handleClickEvent);
                addChild(this.myButton);
            }
            if (this.linkBar == null)
            {
				trace("this.linkBar.....");
                this.linkBar = new LinkBar();
                _loc_2 = ["", "", "", "", "", "", ""];
                this.linkBar.dataProvider = _loc_2;
                this.linkBar.addEventListener(ChildExistenceChangedEvent.CHILD_ADD, this.childAddHandler);
                this.linkBar.addEventListener(ItemClickEvent.ITEM_CLICK, this.itemClickHandler);
				trace("before addChild(this.linkBar)");
                addChild(this.linkBar);
				trace("after addChild(this.linkBar)");
            }
            if (this.filterBar == null)
            {
                this.filterBar = new com.pactera.edg.am.view.analysisFilter();
                //zzg 001
                addChild(this.filterBar);
                this.filterBar.includeInLayout = false;
                this.filterBar.visible = false;
            }
            return;
        }// end function

        private function childAddHandler(event:ChildExistenceChangedEvent) : void
        {
			trace( "childAddHandler=======");
            var iconClszz:Class = null;
            var modelFc:ModelFactory = ApplicationConfig.getInstance().modelFactory;
            var linkbar:* = event.target as LinkBar;
            var btn:* = event.relatedObject as Button;
            var posIdx:* = linkbar.getChildIndex(btn);
            switch(posIdx)
            {
                case 0:
                {
					trace( "zoomout.url:");
                    var iconStr:String;
					iconStr=modelFc.getImageMapping().zoomout;
					trace("iconStr:"+iconStr);
                    iconClszz = IconUtility.getClass(btn,iconStr, 16, 16);
                    btn.toolTip = "放大";
                    break;
                }
                case 1:
                {
                    iconClszz = IconUtility.getClass(btn, modelFc.getImageMapping().zoomin, 16, 16);
                    btn.toolTip = "缩小";
                    break;
                }
                case 2:
                {
                    iconClszz = IconUtility.getClass(btn, modelFc.getImageMapping().print, 16, 16);
                    btn.toolTip = "打印";
                    break;
                }
                case 3:
                {
                    iconClszz = IconUtility.getClass(btn, modelFc.getImageMapping().search, 16, 16);
                    btn.toolTip = "查询";
                    break;
                }
                case 4:
                {
                    iconClszz = IconUtility.getClass(btn, modelFc.getImageMapping().tour, 16, 16);
                    btn.toolTip = "漫游";
                    break;
                }
                case 5:
                {
                    iconClszz = IconUtility.getClass(btn, modelFc.getImageMapping().fullScreen, 16, 16);
                    btn.toolTip = "全屏";
                    break;
                }
                case 6:
                {
                    iconClszz = IconUtility.getClass(btn, modelFc.getImageMapping().export, 16, 16);
                    btn.toolTip = "导出";
                    break;
                }
                default:
                {
                    break;
                    break;
                }
            }
            btn.setStyle("icon", iconClszz);
            //btn.label = btn.toolTip;//"";
            trace("btn.label:"+btn.label+"icon:"+btn.getStyle("icon"));
            //btn.icon=iconClszz;
            btn.width = 22;//+40;
            btn.height = 18;
            return;
        }// end function

        public function set smallMapView(param1:com.pactera.edg.am.view.CustomSmallMap) : void
        {
            this._smallMapView = param1;
            return;
        }// end function

        private function handleClickEvent(event:Event) : void
        {
            this.fetchMatchModels();
            return;
        }// end function

		
			
			
        private function doFileExport() : void
        {
            return;
        }// end function

        private function blowUpModel() : void
        {
            if (this.modelView != null)
            {
                this.zoom.target = this.modelView;
                this.zoom.zoomHeightFrom = this.num;
                this.zoom.zoomWidthFrom = this.num;
                if (this.num > 1.5)
                {
                    return;
                }
                this.num = this.num + 0.1;
                this.zoom.zoomHeightTo = this.num;
                this.zoom.zoomWidthTo = this.num;
                this.zoom.originX = this.modelView.x;
                this.zoom.originY = this.modelView.y;
                this.zoom.duration = 200;
                this.zoom.play();
            }
            return;
        }// end function

        private function filterView(event:MouseEvent) : void
        {
            var _loc_2:com.pactera.edg.am.view.analysisFilter = null;
            var _loc_3:Array = null;
            var _loc_4:Array = null;
            var _loc_5:XML = null;
            var _loc_6:ModelFactory = null;
            var _loc_7:MyWebservice = null;
            var _loc_8:Array = null;
            if (event.target as com.pactera.edg.am.view.analysisFilter)
            {
                _loc_2 = event.target as com.pactera.edg.am.view.analysisFilter;
                _loc_3 = [];
                _loc_3.push();
                _loc_4 = new Array();
                for each (_loc_5 in _loc_2.valueCombo.dataProvider)
                {
                    
                    if (_loc_5.@selected == "true")
                    {
                        _loc_4.push(_loc_5.@name);
                    }
                }
                _loc_6 = ApplicationConfig.getInstance().modelFactory;
                _loc_7 = new MyWebservice(_loc_6.getDataMapping().url);
                _loc_8 = new Array();
                _loc_8.push(this.modelView.headInfo.sessionId);
                _loc_8.push(this.modelView.headInfo.mdId);
                _loc_8.push(this.modelView.headInfo.mdModelCode);
                _loc_8.push(_loc_2.systemCombo.selectedLabel);
                _loc_8.push(_loc_2.tableCombo.selectedLabel);
                _loc_8.push(_loc_2.columnCombo.selectedLabel);
                _loc_8.push(_loc_4.join("#"));
                _loc_7.send(_loc_6.getDataMapping().filterfunc, _loc_8);
                _loc_7.onCompleteResult = this.onResult;
            }
            return;
        }// end function

        private function searchMathModel(param1:Array) : void
        {
            var _loc_2:String = null;
            var _loc_3:DisplayElement = null;
            if (param1.length > 0)
            {
                for each (_loc_3 in param1)
                {
                    
                    _loc_2 = _loc_3.modelName.toLowerCase();
                    if (this.matchReg.test(_loc_2))
                    {
                        this._matchModels.push(_loc_3);
                    }
                    if (_loc_3.isOpen && _loc_3.subModels.length > 0)
                    {
                        this.searchMathModel(_loc_3.subModels);
                    }
                }
            }
            return;
        }// end function

        private function doFullScreen(event:ItemClickEvent) : void
        {
            var _loc_2:Class = null;
            stage.displayState = stage.displayState == StageDisplayState.NORMAL ? (StageDisplayState.FULL_SCREEN) : (StageDisplayState.NORMAL);
            var _loc_3:* = event.relatedObject as Button;
            if (this.stage.displayState == StageDisplayState.FULL_SCREEN)
            {
                _loc_2 = IconUtility.getClass(_loc_3, this.factory.getImageMapping().normalScreen, 16, 16);
                _loc_3.toolTip = "返回";
            }
            else
            {
                _loc_2 = IconUtility.getClass(_loc_3, this.factory.getImageMapping().fullScreen, 16, 16);
                _loc_3.toolTip = "全屏";
            }
            _loc_3.clearStyle("icon");
            _loc_3.setStyle("icon", _loc_2);
            return;
        }// end function

        private function doActionFileExport() : void
        {
            var request:URLRequest;
            var params:URLVariables;
            try
            {
                request = new URLRequest(encodeURI("../analyseMCommand.do?invoke=downAnalyseFile"));
                request.method = "POST";
                params = new URLVariables();
                params.sessionId = this.modelView.headInfo.sessionId;
                params.metadataId = this.modelView.headInfo.mdId;
                params.fileType = "01";
                params.analyseType = this.modelView.headInfo.mdAnalyStyle;
                params.filterFlag = "0";
                params.d = Math.random();
                request.data = params;
                navigateToURL(request, "_self");
            }
            catch (error:Error)
            {
                Alert.show(error.message);
            }
            return;
        }// end function

        private function itemClickHandler(event:ItemClickEvent) : void
        {
            var _loc_2:* = event.index;
            switch(_loc_2)
            {
                case 0:
                {
                    this.blowUpModel();
                    break;
                }
                case 1:
                {
                    this.reduceModel();
                    break;
                }
                case 2:
                {
                    this.doprint();
                    break;
                }
                case 3:
                {
                    this.dosearch();
                    break;
                }
                case 4:
                {
                    this.doTour();
                    break;
                }
                case 5:
                {
                    this.doFullScreen(event);
                    break;
                }
                case 6:
                {
                    this.showMenu(event);
                    break;
                }
                default:
                {
                    break;
                }
            }
            return;
        }// end function

        public function getMatchModels() : Array
        {
            return this._matchModels;
        }// end function

        private function onResult(param1:XML) : void
        {
            var _loc_2:* = XMLList(param1);
            this.modelView.modelXml = _loc_2[0];
            return;
        }// end function

        public function set modelView(param1:ModelView) : void
        {
            this._modelView = param1;
            return;
        }// end function

		
		//将可视的UIComponent组件转换为ByteArray数组，我就是在UIComponent那里放了一个图片 
		//target:mx.core.UIComponent
		public static function BitmapDataToByteArray(srcBmp:BitmapData):ByteArray
		{ 
//			var imageWidth:uint = target.width; 
//			var imageHeight:uint = target.height; 
//			var srcBmp:BitmapData = new BitmapData( imageWidth, imageHeight ); 
//			//将组件读取为BitmapData对象，bitmagData的数据源 
//			srcBmp.draw( target ); 
			//getPixels方法用于读取指定像素区域生成一个ByteArray，Rectangle是一个区域框，就是起始坐标 
			
			var pixels:ByteArray = srcBmp.getPixels( new Rectangle(0,0,srcBmp.width,srcBmp.height) ); 
			//下面俩行将数据源的高和宽一起存储到数组中,为翻转的时候提供高度和宽度 
			pixels.writeShort(srcBmp.width); 
			pixels.writeShort(srcBmp.height); 
			return pixels; 
		} 
		
		//次方法的参数必须是像上面的ByteArray形式一样的,即需要对象的大小; 
		//此方法返回的Bitmap可以直接赋值给Image的source属性 
		public static function ByteArrayToBitmap(byArr:ByteArray):Bitmap{ 
			if(byArr==null){ 
			    return null; 
			} 
			//读取出存入时图片的高和宽,因为是最后存入的数据,所以需要到尾部读取 
			var bmd:ByteArray= byArr; 
			bmd.position=bmd.length-2; 
			var imageWidth:int = bmd.readShort(); 
			bmd.position=bmd.length-4; 
			var imageHeight:int= bmd.readShort(); 
			var copyBmp:BitmapData = new BitmapData( imageWidth, imageHeight, true ); 
			//利用setPixel方法给图片中的每一个像素赋值,做逆操作 
			//ByteArray数组从零开始存储一直到最后都是图片数据,因为读入时的高和宽都是一样的,所以当循环结束是正好读完 
			bmd.position = 0; 
			for( var i:uint=0; i<imageHeight ; i++ ) 
			{ 
			    for( var j:uint=0; j<imageWidth; j++ ) 
			    { 
			      copyBmp.setPixel( j, i, bmd.readUnsignedInt() ); 
			    } 
			} 
			var bmp:Bitmap = new Bitmap( copyBmp ); 
			return bmp; 
		} 
		private function doAdvImageExport():void
		{
			 var en:JPEGEncoder;
            //zzg 2011-12-14
            var pngEn:PNGEncoder;
            var matrix:Matrix;
            var bitmapData:BitmapData;
            var ba:ByteArray;
            var fr:FileReference;
            var request:URLRequest;
            try
            {
                en = new JPEGEncoder(100);
                
                pngEn=new PNGEncoder();
                
               //matrix = new Matrix();
                 matrix = new Matrix(1, 0, 0, 1);

	               var startExportDate:Date = new Date();
	               var dpi:int=0;//默认0标识和屏幕分辩率一致
	             ba=com.pactera.edg.am.utilities.ImageSnapshot.captureImageAsByteArray(this.modelView,dpi,pngEn,false);
	                 var _loc_2:*= (new Date()).getTime();
	            trace("PNGEncoder图片编码耗时" + (_loc_2 - startExportDate.getTime()) + "毫秒");
	            
                fr = new FileReference();
                if (fr.hasOwnProperty("save"))
                {
                    fr.save(ba,  "分析结果图片导出："+this.modelView.headInfo.mdName+".png");
                }else{
                	 Alert.show("检测到Flash播放器无文件保存权限，请使用\"导出图片(常规)\"功能完成导出");
                }
            }
            catch (e:Error)
            {
                Alert.show(e.message);
            }
            return;
		}
        private function doImageExport() : void
        {
            var en:JPEGEncoder;
            //zzg 2011-12-14
            var pngEn:PNGEncoder;
            var matrix:Matrix;
            var bitmapData:BitmapData;
            var ba:ByteArray;
            var fr:FileReference;
            var request:URLRequest;
            try
            {
                en = new JPEGEncoder(100);
                
                pngEn=new PNGEncoder();
                
               //matrix = new Matrix();
                 matrix = new Matrix(1, 0, 0, 1);
                //matrix.scale(1,1);
//                 var startExportDate:Date = new Date();
//                bitmapData = com.pactera.edg.am.utilities.ImageSnapshot.captureBitmapData(this.modelView, matrix);
//              
//               // var bitMap:Bitmap = new Bitmap(bitmapData);
//                  var _loc_2:* = (new Date()).getTime();
//	            trace("生成位图片耗时" + (_loc_2 - startExportDate.getTime()) + "毫秒");
//	            startExportDate = new Date();
//                //ba = en.encode(bitmapData);
//                 ba = pngEn.encode(bitmapData);
//                 
//	            _loc_2= (new Date()).getTime();
//	            trace("PNGEncoder图片编码耗时" + (_loc_2 - startExportDate.getTime()) + "毫秒");
//	            

	               var startExportDate:Date = new Date();
	             ba=com.pactera.edg.am.utilities.ImageSnapshot.captureImageAsByteArray(this.modelView,0,pngEn,false);
	                 var _loc_2:*= (new Date()).getTime();
	            trace("PNGEncoder图片编码耗时" + (_loc_2 - startExportDate.getTime()) + "毫秒");
//            startExportDate = new Date();
//                ba = en.encode(bitmapData);
//                 //ba = pngEn.encode(bitmapData);
//                 
//	            _loc_2= (new Date()).getTime();
//	            trace("JPEGEncoder图片编码耗时" + (_loc_2 - startExportDate.getTime()) + "毫秒");


//	                startExportDate = new Date();
//	            ba =BitmapDataToByteArray(bitmapData);
//	            
//	             _loc_2= (new Date()).getTime();
//	            trace("BitmapDataToByteArray图片编码耗时" + (_loc_2 - startExportDate.getTime()) + "毫秒");
	            
	            
                trace("[MyUIComponent.as]this.factory.isDebug:"+this.factory.isDebug);
//                if (this.factory.isDebug)
//                {
//                    fr = new FileReference();
//                    if (fr.hasOwnProperty("save"))
//                    {
//                        fr.save(ba, "chart.png");
//                    }
//                }
//                else
//                {
                    request = new URLRequest(encodeURI("../analyseMCommand.do?invoke=downAnalyseImage&MDName=" + this.modelView.headInfo.mdName + "&d=" + Math.random()));
                    request.method = "POST";
                    request.data = ba;
                    request.contentType = "application/octet-stream";
                    navigateToURL(request, "_parent");
//                }
            }
            catch (e:Error)
            {
                Alert.show(e.message);
            }
            return;
        }// end function

        private function reduceModel() : void
        {
            if (this.modelView != null)
            {
                this.zoom.target = this.modelView;
                this.zoom.zoomHeightFrom = this.num;
                this.zoom.zoomWidthFrom = this.num;
                if (this.num < 0.5)
                {
                    return;
                }
                this.num = this.num - 0.1;
                this.zoom.zoomHeightTo = this.num;
                this.zoom.zoomWidthTo = this.num;
                this.zoom.originX = this.modelView.x;
                this.zoom.originY = this.modelView.y;
                this.zoom.duration = 200;
                this.zoom.play();
            }
            return;
        }// end function

        private function menuHandler(event:MenuEvent) : void
        {
        	
        	    var processBar:com.pactera.edg.am.utilities.ProgressBarCanvas;
        	     var point:Point;
        	     
        	
        	     
            var _loc_2:* = event.index;
            switch(_loc_2)
            {
                case 0:
                {
                    this.doImageExport();
                    break;
                }
                case 1:
                {    
                	
                	 doAdvImageExport();
                	 
                	 
//                	   trace("[pbc_0]");
//                	   //添加剩余的子元素
//					    processBar = com.pactera.edg.am.utilities.ProgressBarCanvas(PopUpManager.createPopUp(this.modelView, com.pactera.edg.am.utilities.ProgressBarCanvas, true));
//					    trace("[pbc_1]");
//					    //zzg 2011-12-12 修改标签为中文
//					    //processBar.btnLabel = "Loading...";
//					    processBar.btnLabel = "正在生成图片数据，请等待… ";
//					    point = new Point(Application.application.width / 2, Application.application.height / 2);
//					      trace("[pbc_2]");
//					    point = this.modelView.globalToLocal(point);
//					       trace("[pbc_3]");
//					     
//					    processBar.move((point.x - processBar.width / 2),(point.y - processBar.height / 2));
//					      trace("[pbc_4]");
//					   // ModelView
//					    processBar.callBack = function ():void
//									            {
//									                //高级图像导出，直接本地保存，无需服务器中转
//			                   						 
//			                   						  processBar.closeProcessBar();
//									                return;
//									            }// end function
//									            ;
                  
                  
                	break;
                }
                case 2:
                {
                    this.doActionFileExport();
                    break;
                }
                default:
                {
                    break;
                }
            }
            return;
        }// end function

        public function get modelView() : ModelView
        {
            return this._modelView;
        }// end function

        private function dosearch() : void
        {
            this.myTextArea.visible = !this.myTextArea.visible;
            this.myButton.visible = !this.myButton.visible;
            return;
        }// end function

        private function fetchMatchModels() : void
        {
            var _loc_1:String = null;
            if (this.myTextArea.text == "")
            {
                Alert.show("请输入要查询的信息");
                return;
            }
            this._matchModels = [];
            _loc_1 = StringUtil.trim(this.myTextArea.text);
            this.matchReg = new RegExp(_loc_1.toLowerCase(), "i");
            this.searchMathModel(this.modelView.getModels());
            this.dispatchEvent(new Event(SEARCH_RESULT, true));
            return;
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            var _loc_3:* = param1 - 8;
            var _loc_4:* = param2 - 8;
            var _loc_5:Number = 64;
            var _loc_6:Number = 20;
            this.myButton.setActualSize(_loc_5, _loc_6);
            var _loc_7:Number = 180;
            var _loc_8:Number = 20;
            this.myTextArea.setActualSize(_loc_7, _loc_8);
            if (this.type != "7")
            {
            	//zzg 002
//                if (this.filterBar.includeInLayout)
//                {
//                    this.filterBar.move(4, 1);
//                    this.myTextArea.move(4 + this.filterBar.width, 1);
//                    this.myButton.move(4 + _loc_7 + this.filterBar.width + 5, 1);
//                }
//                else
//                {
                    this.myTextArea.move(4, 1);
                    this.myButton.move(4 + _loc_7 + 5, 1);
//                }
            }
            else
            {
                this.myTextArea.move(4, 1);
                this.myButton.move(4 + _loc_7 + 5, 1);
            }
            this.linkBar.move(param1 - this.linkBar.getExplicitOrMeasuredWidth(), 1);
			
			//zzg 20130723 增加颜色定制参数
			var tbLineColor:String="0x84A2C6";
			var tbFillColor:String="0xC6D3E7";
			if(Application.application.parameters!=null&&
				Application.application.parameters.isCustomColor=="1" //需要定义颜色
			){
				tbLineColor=Application.application.parameters.tbLineColor;
				tbFillColor=Application.application.parameters.tbFillColor;
			}
			
			GraphicUtil.turnModelColor(uint(tbLineColor),uint(tbFillColor) , this);
			
            return;
        }// end function

        private function addEvent(param1:FileReference) : void
        {
            var file:* = param1;
            file.addEventListener(Event.COMPLETE, function () : void
            {
                Alert.show("下载成功！");
                return;
            }// end function
            );
            file.addEventListener(SecurityErrorEvent.SECURITY_ERROR, function () : void
            {
                Alert.show("由于安全错误下载失败");
                return;
            }// end function
            );
            file.addEventListener(IOErrorEvent.IO_ERROR, function ():void
            {
                Alert.show("由于流的问题下载失败");
                return;
            }// end function
            );
            return;
        }// end function

        private function showMenu(event:ItemClickEvent) : void
        {
            var _loc_2:* = "<root><node label=\"导出图片(常规)\" type=\"radio\" groupName=\"radioGroup\" toggled=\"false\"/><node label=\"导出图片(高级)\" type=\"radio\" groupName=\"radioGroup\" toggled=\"true\"/><node label=\"导出文件\" type=\"radio\" groupName=\"radioGroup\"/></root>";
            var _loc_3:* = Menu.createMenu(this, _loc_2, false);
            _loc_3.labelField = "@label";
            _loc_3.addEventListener("itemClick", this.menuHandler);
            var _loc_4:* = new Point();
            var _loc_5:* = event.relatedObject as Button;
            _loc_4.x = _loc_5.x;
            _loc_4.y = _loc_5.y;
            _loc_4 = this.linkBar.localToGlobal(_loc_4);
            _loc_3.show(_loc_4.x - 60-30, _loc_4.y + _loc_5.height);
            _loc_5 = null;
            return;
        }// end function


    }
}
