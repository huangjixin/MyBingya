package com.pactera.edg.am.view.model
{
    import com.adobe.serialization.json.*;
    import com.pactera.edg.am.factory.*;
    import com.pactera.edg.am.utilities.*;
    import com.pactera.edg.am.view.*;
    
    import flash.display.*;
    import flash.events.*;
    import flash.geom.*;
    
    import mx.controls.*;
    import mx.core.*;
    import mx.managers.*;

    public class DealEvent extends Object
    {
        private var cursorID:Number = 0;
        private var isDoubleClick:Boolean;
        private var isDragging:Boolean;
        private static const closedHandImg:Class = DealEvent_closedHandImg;
        private static const opendHandImg:Class = DealEvent_opendHandImg;
		private static const defaultColorProperty:ColorProperty=new ColorProperty();
        public function DealEvent()
        {
            return;
        }// end function

        private function removeCustomEventListener(param1:DisplayElement) : void
        {
            param1.rectOne.removeEventListener(MouseEvent.ROLL_OUT, param1.myObject.modelRollOutHandler);
            param1.rectOne.removeEventListener(MouseEvent.ROLL_OVER, param1.myObject.modelRollOverHandler);
            if (param1.parentmodel != null)
            {
                this.removeCustomEventListener(param1.parentmodel);
            }
            param1 = null;
            return;
        }// end function

        private function setPreSelectModelProperty(param1:DisplayElement) : void
        {
            if (param1.bisAnalysicModel)
            {
                param1.basicColor = defaultColorProperty.analysisModelSecondColor;
            }
            else
            {
                param1.basicColor = param1.defineColor;
            }
            param1.basicLineColor = param1.colorProperty.linecolor;
            GraphicUtil.turnModelColor(param1.basicLineColor, param1.basicColor, param1);
            param1.setLinkModelColor(false);
            param1.setNotRelatedModelColor(false);
            param1.setLinkLinesColor(false);
            param1 = null;
            return;
        }// end function

        private function genArgsment(param1:DisplayElement) : Object
        {
            var _loc_4:DisplayElement = null;
            var _loc_5:Array = null;
            var _loc_2:* = new Object();
            _loc_2["instanceId"] = param1.modelId;
            _loc_2["nodeId"] = param1.nodeId;
            var _loc_3:* = new Array();
            param1.buildFromModels();
            for each (_loc_4 in param1.getFromModels())
            {
                
                _loc_3.push({instanceId:_loc_4.modelId, nodeId:_loc_4.nodeId});
            }
            _loc_2["upperNodes"] = _loc_3;
            _loc_5 = new Array();
            param1.buildToModels();
            for each (_loc_4 in param1.getToModels())
            {
                
                _loc_5.push({instanceId:_loc_4.modelId, nodeId:_loc_4.nodeId});
            }
            _loc_2["lowerNodes"] = _loc_5;
            return _loc_2;
        }// end function

        public function addChildEventListener(param1:DisplayElement) : void
        {
            var _loc_2:DisplayElement = null;
            if (!param1.bisAnalysicLinkModel)
            {
                param1.rectOne.addEventListener(MouseEvent.ROLL_OUT, param1.myObject.modelRollOutHandler, false, 0, true);
                param1.rectOne.addEventListener(MouseEvent.ROLL_OVER, param1.myObject.modelRollOverHandler, false, 0, true);
            }
            if (param1.subModels.length > 0)
            {
                for each (_loc_2 in param1.subModels)
                {
                    
                    this.addChildEventListener(_loc_2);
                }
            }
            param1 = null;
            return;
        }// end function

		//zzg 
        public function setPopUpWinProperty(event:MouseEvent) : void
        {
            var _loc_3:int = 0;
            var _loc_4:DisplayElement = null;
            var _loc_5:Point = null;
            var _loc_2:* = event.target as DisplayObject;
            if (_loc_2.parent as DisplayElement)
            {
                _loc_3 = 10;
                _loc_4 = _loc_2.parent as DisplayElement;
                if (_loc_4.detailInfoWin != null)
                {
                    _loc_4.detailInfoWin.includeInLayout = true;
                    _loc_4.detailInfoWin.visible = true;
                    _loc_4.detailInfoWin.model = _loc_4;
                    _loc_5 = new Point(_loc_4.mouseX, _loc_4.mouseY);
                    _loc_5 = event.target.localToGlobal(_loc_5);
                    _loc_4.detailInfoWin.x = _loc_5.x + _loc_3;
                    _loc_4.detailInfoWin.y = _loc_5.y + _loc_3;
                }
                _loc_4 = null;
            }
            return;
        }// end function

        public function modelDetailInfoRollOutHandler(event:MouseEvent) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_2:* = event.target as DisplayObject;
            if (_loc_2.parent as DisplayElement)
            {
                _loc_3 = _loc_2.parent as DisplayElement;
                //zzg
                if(  _loc_3.detailInfoWin!=null){
                	_loc_3.detailInfoWin.includeInLayout = false;
               	    _loc_3.detailInfoWin.visible = false;
                }
                _loc_3.myTimer.stop();
                _loc_3 = null;
            }
            return;
        }// end function

        public function modelRollOutHandler(event:MouseEvent) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_2:* = event.target as DisplayObject;
            if (_loc_2.parent as DisplayElement)
            {
                _loc_3 = _loc_2.parent as DisplayElement;
                CursorManager.removeCursor(this.cursorID);
                _loc_3.basicLineColor = _loc_3.colorProperty.linecolor;
                GraphicUtil.turnModelColor(_loc_3.basicLineColor, _loc_3.basicColor, _loc_3);
                GraphicUtil.turnModelTextColor(_loc_3.colorProperty.fontcolor, _loc_3);
                _loc_3.lineRemoveColorDispatchEvent();
                _loc_3 = null;
            }
            return;
        }// end function

        public function modelClickHandler(event:MouseEvent) : void
        {
            var _loc_3:Boolean = false;
            var _loc_4:DisplayElement = null;
            var _loc_5:DisplayElement = null;
            var _loc_6:uint = 0;
            var _loc_2:* = event.target as DisplayObject;
            if (_loc_2.parent is DisplayElement)
            {
                _loc_5 = _loc_2.parent as DisplayElement;
                _loc_3 = _loc_5.isClick;
                _loc_5.isClick = !_loc_3;
                _loc_6 = _loc_5.colorProperty.fontcolor;
                if (_loc_3)
                {
                    if (_loc_5.bisAnalysicModel)
                    {
                        _loc_5.basicColor = defaultColorProperty.analysisModelSecondColor;
                    }
                    else
                    {
                        _loc_5.basicColor = _loc_5.defineColor;
                    }
                    _loc_5.basicLineColor = _loc_5.colorProperty.linecolor;
                    GraphicUtil.turnModelColor(_loc_5.basicLineColor, _loc_5.basicColor, _loc_5);
                    for each (_loc_4 in _loc_5.modelView.getModels())
                    {
                        
                        this.addChildEventListener(_loc_4);
                    }
                    _loc_5.modelView.clickedModles[_loc_5.nodeId] = null;
                    _loc_5.setLinkModelColor(false);
                    _loc_5.setNotRelatedModelColor(false);
                    _loc_5.setLinkLinesColor(false);
                    _loc_5.lineAddEventDispatchEvent();
                }
                else
                {
                    if (_loc_5.modelView.preSelectedModel != null)
                    {
                        this.setPreSelectModelProperty(_loc_5.modelView.preSelectedModel);
                        _loc_5.modelView.preSelectedModel = null;
                    }
                    if (_loc_5.bisAnalysicModel)
                    {
                        _loc_5.basicColor = defaultColorProperty.analysisModelColor;
                    }
                    else
                    {
                        _loc_5.basicColor = _loc_5.colorProperty.mousefillcolor;
                    }
                    _loc_5.basicLineColor = _loc_5.colorProperty.mouselinecolor;
                    GraphicUtil.dropShadow(_loc_5.basicLineColor, _loc_5.basicColor, _loc_5);
                    _loc_6 = _loc_5.colorProperty.mouselinecolor;
                    GraphicUtil.turnModelTextColor(_loc_6, _loc_5);
                    for each (_loc_4 in _loc_5.modelView.getModels())
                    {
                        
                        this.removeChildEventListener(_loc_4);
                    }
                    _loc_5.modelView.clickedModles[_loc_5.nodeId] = _loc_5;
                    _loc_5.setLinkModelColor(true);
                    _loc_5.setNotRelatedModelColor(true);
                    _loc_5.setLinkLinesColor(true);
                    _loc_5.lineRemoveEventDispatchEvent();
                }
                trace("...[debug]_loc_5["+_loc_5+"]");
                   trace("...[debug]_loc_5.detailInfoWin["+ _loc_5.detailInfoWin+"]");
                    if (_loc_5.detailInfoWin != null)
                {
	                _loc_5.detailInfoWin.includeInLayout = false;
	                
	                _loc_5.detailInfoWin.visible = false;
                }
                _loc_5.realseSelected();
                _loc_5 = null;
            }
            return;
        }// end function

        public function modelMouseDownHandler(event:MouseEvent) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_2:* = event.target as DisplayObject;
            if (_loc_2.parent is DisplayElement)
            {
                _loc_3 = _loc_2.parent as DisplayElement;
                _loc_3.rectOne.removeEventListener(MouseEvent.ROLL_OVER, _loc_3.myObject.modelDetailInfoRollOverHandler);
                _loc_3.rectOne.removeEventListener(MouseEvent.ROLL_OVER, _loc_3.myObject.modelRollOverHandler);
                _loc_3.rectOne.removeEventListener(MouseEvent.ROLL_OUT, _loc_3.myObject.modelRollOutHandler);
                _loc_3 = null;
            }
            CursorManager.removeCursor(this.cursorID);
            this.cursorID = CursorManager.setCursor(closedHandImg);
            return;
        }// end function

        /**
        * getMore图片点击事件响应
        * @author zzg
        * @date 2011-12-14
        * 
        */
        public function getMoreImageClick(event:MouseEvent) : void
        {
            var model:DisplayElement;
            var factory:ModelFactory;
            var processBar:com.pactera.edg.am.utilities.ProgressBarCanvas;
            var point:Point;
            var ws:MyWebservice;
            var str:String;
            var array:Array;
            var event:* = event;
            
            var getMoreModel:DisplayElement=(event.target as UIComponent).parent as DisplayElement;
            //注意，该处是model=parent.parent,
            model = getMoreModel.parent.parent as DisplayElement;
            
            model.modelView.clickedModles[model.nodeId] = null;
            model.isClick = false;
            //禁止以下语句执行，避免将展开的节点收拢
			//model.extensible.modelState.changeModelState();
            model.modelView.clearAllSelected();
            model.setLinkModelColor(false);
            model.setNotRelatedModelColor(false);
            model.setLinkLinesColor(false);
            
            
            //获取隐藏的信息
            var hiddenXmlString:String="<root><nodes><node><nodes></nodes></node></nodes></root>";
            //在字典中移除
            if(getMoreModel is GetMoreModel){
            	hiddenXmlString=(getMoreModel as GetMoreModel).getHiddenXmlString();
            }
            //trace("[dealevent]hiddenXmlString:"+hiddenXmlString);
            model.modelView.modelsHashMap[getMoreModel.nodeId] = null;
            model.removeModel(getMoreModel);
          
            //添加剩余的子元素
		    processBar = com.pactera.edg.am.utilities.ProgressBarCanvas(PopUpManager.createPopUp(model, com.pactera.edg.am.utilities.ProgressBarCanvas, true));
		    //zzg 2011-12-12 修改标签为中文
		    //processBar.btnLabel = "Loading...";
		    processBar.btnLabel = "数据正在载入，请稍侯…";
		    point = new Point(Application.application.width / 2, Application.application.height / 2);
		    point = model.modelView.parent.parent.globalToLocal(point);
		    
		    processBar.move((point.x - processBar.width / 2),(point.y - processBar.height / 2));
		   // ModelView
		    processBar.callBack = function ():void
						            {
						              
										//param1:XML
								        var _loc_2:* = XMLList(hiddenXmlString);
								        //var hiddenXml:XML= new XML(hiddenXmlString);
								       // trace(hiddenXml.toXMLString());
								        var _loc_3:XmlToModel = new XmlToModel();
								        _loc_3.modelView = model.modelView;
								       // trace("[getMoreImageClick]");
								        //最后一个参数，标识isGetMore，用于区分第一次加载子元素的情况
								        _loc_3.runXmlToSubModel(_loc_2[0], model.modelView.getModels(), model.modelView.getLines(),true);
								        //叠加model和line
								        model.modelView.Models = _loc_3.getModels();
								        //暂时不考虑lines
								       // model.modelView.Lines = _loc_3.getLines();
								        
								        model.genContainerObjectHandles(model);
								        
								        processBar.closeProcessBar();
								        
								        model.modelView.updateModelView();
		        
						                return;
						            }// end function
						            ;
//			PopUpManager.bringToFront(processBar);
//			processBar.invalidateDisplayList();
//		         
//			processBar.addEventListener("InitBarComplete",function(event:InitBarCmpEvent):void{
//
//			
//			});            

            return;
        }// end function
        public function imageClick(event:MouseEvent) : void
        {
            var model:DisplayElement;
            var factory:ModelFactory;
            var processBar:com.pactera.edg.am.utilities.ProgressBarCanvas;
            var point:Point;
            var ws:MyWebservice;
            var str:String;
            var array:Array;
            var event:* = event;
            model = (event.target as UIComponent).parent as DisplayElement;
            model.modelView.clickedModles[model.nodeId] = null;
            model.isClick = false;
            model.extensible.modelState.changeModelState();
            model.modelView.clearAllSelected();
            model.setLinkModelColor(false);
            model.setNotRelatedModelColor(false);
            model.setLinkLinesColor(false);
            if (model.isOpen)
            {//如果模型展开了
		                model.iconObject.load(DisplayElement.defaultCloseIcon);//改变图标，提示用户点击收拢子节点
		                if (model.subModels.length == 0)
		                {//如果子模型未加载，立刻加载数据
		                    factory = model.factory;
		                    if (factory.getDataMapping().typename == "webservice")
		                    {
		                        if (!factory.isDebug)
		                        {
		                            processBar = com.pactera.edg.am.utilities.ProgressBarCanvas(PopUpManager.createPopUp(model, com.pactera.edg.am.utilities.ProgressBarCanvas, true));
		                            //zzg 2011-12-12 修改标签为中文
		                            //processBar.btnLabel = "Loading...";
		                            processBar.btnLabel = "数据正在载入，请稍侯…";
		                            point = new Point(Application.application.width / 2, Application.application.height / 2);
		                            point = model.modelView.parent.parent.globalToLocal(point);
		                            processBar.move(point.x - processBar.width / 2, point.y - processBar.height / 2);
		                            ws = new MyWebservice(factory.getDataMapping().url);
		                            str = com.adobe.serialization.json.JSON.encode(this.genArgsment(model));
		                            array = new Array();
		                            array.push(str);
		                            processBar.callBack = function ():void
												            {
												                ws.send(factory.getDataMapping().subdatafunc, array);
												                array = null;
												                return;
												            }// end function
												            ;
		                            ws.onCompleteResult = function (param1:XML):void
												            {
												                processBar.closeProcessBar();
												                var _loc_2:* = XMLList(param1);
												               // trace(_loc_2[0].toXMLString());
												                var _loc_3:XmlToModel = new XmlToModel();
												                _loc_3.modelView = model.modelView;
												                _loc_3.runXmlToSubModel(_loc_2[0], model.modelView.getModels(), model.modelView.getLines());
												                model.modelView.Models = _loc_3.getModels();
												                model.modelView.Lines = _loc_3.getLines();
												                 trace("param1:---["+_loc_3.getLines()+"]-\n\n\n\n\n"+param1+"\n\n\n\n\n");
												                model.genContainerObjectHandles(model);
												                model.modelView.updateModelView();
												                return;
												            }// end function
		          				 							 ;
		                        }// end of if (!factory.isDebug)
		                    }//end of if (factory.getDataMapping().typename == "webservice")
	                	}//end of if (model.subModels.length == 0)
		                else
		                {//如果已经加载了子模型数据，刷新试图
		                    model.genContainerObjectHandles(model);
		                    model.modelView.updateModelView();
		                }
            }else
            {//如果已经打开，则，收拢
                model.iconObject.load(DisplayElement.defaultIcon);
                model.genContainerObjectHandles(model);
                model.modelView.updateModelView();
            }
            return;
        }// end function

        //设置分析模型点击效果
        public function setAnalysisModelClickEffect(param1:DisplayElement) : void
        {
            var _loc_2:DisplayElement = null;
            param1.isClick = true;
            param1.setFocus();
            param1.basicColor = defaultColorProperty.analysisModelColor;
            param1.basicLineColor = param1.colorProperty.mouselinecolor;
            GraphicUtil.dropShadow(param1.basicLineColor, param1.basicColor, param1);
            for each (_loc_2 in param1.modelView.getModels())
            {
                
                this.removeChildEventListener(_loc_2);
            }
            param1.lineRemoveEventDispatchEvent();
            param1.setLinkModelColor(true);
            param1.setNotRelatedModelColor(true);
            param1.setLinkLinesColor(true);
            param1 = null;
            return;
        }// end function

        public function modelRollOverHandler(event:MouseEvent) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_4:uint = 0;
            var _loc_2:* = event.target as DisplayObject;
            if (_loc_2.parent as DisplayElement)
            {
                _loc_3 = _loc_2.parent as DisplayElement;
                CursorManager.removeAllCursors();
                this.cursorID = CursorManager.setCursor(opendHandImg);
                
                _loc_3.basicLineColor = _loc_3.colorProperty.mouselinecolor;
                GraphicUtil.turnModelColor(_loc_3.basicLineColor, _loc_3.basicColor, _loc_3);
                _loc_4 = _loc_3.colorProperty.mouselinecolor;
                GraphicUtil.turnModelTextColor(_loc_4, _loc_3);
                _loc_3.lineColorDispatchEvent();
                _loc_3 = null;
            }
            return;
        }// end function

        public function modelMouseUpHandler(event:MouseEvent) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_2:* = event.target as DisplayObject;
            if (_loc_2.parent is DisplayElement)
            {
                _loc_3 = _loc_2.parent as DisplayElement;
                _loc_3.rectOne.addEventListener(MouseEvent.ROLL_OVER, _loc_3.myObject.modelDetailInfoRollOverHandler, false, 0, true);
                _loc_3.rectOne.addEventListener(MouseEvent.ROLL_OVER, _loc_3.myObject.modelRollOverHandler, false, 0, true);
                _loc_3.rectOne.addEventListener(MouseEvent.ROLL_OUT, _loc_3.myObject.modelRollOutHandler, false, 0, true);
                _loc_3 = null;
            }
            CursorManager.removeCursor(this.cursorID);
            this.cursorID = CursorManager.setCursor(opendHandImg);
            return;
        }// end function

        public function removeChildEventListener(param1:DisplayElement) : void
        {
            var _loc_2:DisplayElement = null;
            param1.rectOne.removeEventListener(MouseEvent.ROLL_OUT, param1.myObject.modelRollOutHandler);
            param1.rectOne.removeEventListener(MouseEvent.ROLL_OVER, param1.myObject.modelRollOverHandler);
            if (param1.subModels.length > 0)
            {
                for each (_loc_2 in param1.subModels)
                {
                    
                    this.removeChildEventListener(_loc_2);
                }
            }
            param1 = null;
            return;
        }// end function

        public function modelDetailInfoRollOverHandler(event:MouseEvent) : void
        {
            var element:DisplayElement;
            var event:* = event;
            var argObject:* = event.target as DisplayObject;
            if (argObject.parent as DisplayElement)
            {
                element = argObject.parent as DisplayElement;
                element.myTimer.start();
                setPopUpWinProperty(event);
//                element.myTimer.addEventListener(TimerEvent.TIMER, setPopUpWinProperty
////                function (event:TimerEvent) : void
////				            {
////				            	trace("this.setPopUpWinProperty...")
////				                this.setPopUpWinProperty(event);
////				                return;
////				            }// end function
//            	);
//                element;
            }
            return;
        }// end function

        private function addCustomEventListener(param1:DisplayElement) : void
        {
            param1.rectOne.addEventListener(MouseEvent.ROLL_OUT, param1.myObject.modelRollOutHandler, false, 0, true);
            param1.rectOne.addEventListener(MouseEvent.ROLL_OVER, param1.myObject.modelRollOverHandler, false, 0, true);
            if (param1.parentmodel != null)
            {
                this.addCustomEventListener(param1.parentmodel);
            }
            param1 = null;
            return;
        }// end function

        public function focusEventOutHandler(event:FocusEvent) : void
        {
            var _loc_2:DisplayElement = null;
            var _loc_3:DisplayElement = null;
            event.stopImmediatePropagation();
            if (event.target as DisplayElement)
            {
                _loc_3 = event.target as DisplayElement;
                if (event.relatedObject == null)
                {
                    return;
                }
                if (event.relatedObject.parent as LinkBar)
                {
                    _loc_3.modelView.preSelectedModel = _loc_3;
                    return;
                }
                _loc_3.modelView.preSelectedModel = null;
                _loc_3.setNotRelatedModelColor(false);
                _loc_3 = null;
            }
            return;
        }// end function

    }
}
