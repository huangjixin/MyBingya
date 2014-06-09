package com.pactera.edg.am.dmv.view.model
{
    import com.pactera.edg.am.dmv.factory.*;
    import com.pactera.edg.am.dmv.system.*;
    import com.pactera.edg.am.dmv.view.*;
    
    import flash.display.*;
    import flash.events.*;
    import flash.external.*;
    import flash.geom.*;
    import flash.utils.*;
    
    import mx.collections.*;
    import mx.managers.*;

    public class DealEvent extends Object
    {
        private var isDoubleClick:Boolean;
        private var isDragging:Boolean;
        private static const closedHandImg:Class = DealEvent_closedHandImg;
        private static const opendHandImg:Class = DealEvent_opendHandImg;

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
                removeCustomEventListener(param1.parentmodel);
            }
            param1 = null;
            return;
        }// end function

        public function modelDetailInfoRollOutHandler(event:MouseEvent) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_2:* = event.target as DisplayObject;
            if (_loc_2.parent as DisplayElement)
            {
                _loc_3 = _loc_2.parent as DisplayElement;
                _loc_3.myTimer.stop();
                if( _loc_3.detailInfoWin!=null){
	                _loc_3.detailInfoWin.includeInLayout = false;
	                _loc_3.detailInfoWin.visible = false;
                  }
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
                _loc_3 = null;
            }
            CursorManager.removeCursor(CursorManager.currentCursorID);
            CursorManager.setCursor(opendHandImg);
            return;
        }// end function

        private function clickOrDouble(event:MouseEvent) : void
        {
            var _loc_2:* = event.target as DisplayObject;
            var _loc_3:* = _loc_2.parent as DisplayElement;
            _loc_3.realseSelected(event);
            if (isDoubleClick)
            {
                if (_loc_3.stage.displayState == StageDisplayState.FULL_SCREEN)
                {
                    _loc_3.stage.displayState = StageDisplayState.NORMAL;
                }
                ExternalInterface.call("showMetaData", _loc_3.modelId, _loc_3.mdcode);
            }
            else if (_loc_3 as DataMapComModel)
            {
                modelClickHandler(event);
            }
            else if (_loc_3 as BasicModel)
            {
                basicModelClickHandler(event);
            }
            return;
        }// end function

        public function modelFocusEventOutHandler(event:FocusEvent) : void
        {
            var _loc_2:DisplayElement = null;
            var _loc_3:DisplayElement = null;
            var _loc_4:uint = 0;
            if (event.target as DisplayElement)
            {
                event.stopImmediatePropagation();
                _loc_3 = event.target as DisplayElement;
                _loc_3.glowTween.stopGlow();
                _loc_3.isClick = false;
                if (_loc_3.isOpen)
                {
                    _loc_3.basicColor = ColorProperty.colorTypeObject[_loc_3.typeClass];
                    if (_loc_3.isDashModel)
                    {
                        _loc_3.basicLineColor = _loc_3.colorProperty.dashBorderColor;
                        if (_loc_3 is DataMapComModel)
                        {
                            GraphicUtil.turnDashModelColor(_loc_3.basicLineColor, _loc_3.basicColor, _loc_3);
                        }
                        else
                        {
                            GraphicUtil.turnDashModelGradientColor(_loc_3.basicLineColor, _loc_3.basicColor, _loc_3);
                        }
                    }
                    else
                    {
                        _loc_3.basicLineColor = _loc_3.colorProperty.linecolor;
                        if (_loc_3 is DataMapComModel)
                        {
                            GraphicUtil.turnModelColor(_loc_3.basicLineColor, _loc_3.basicColor, _loc_3);
                        }
                        else
                        {
                            GraphicUtil.turnModelGradientColor(_loc_3.basicLineColor, _loc_3.basicColor, _loc_3);
                        }
                    }
                    _loc_4 = _loc_3.colorProperty.fontcolor;
                    GraphicUtil.turnModelTextColor(_loc_4, _loc_3);
                }
                for each (_loc_2 in _loc_3.modelView.getModels())
                {
                    
                    addChildEventListener(_loc_2);
                }
                _loc_3.lineAddEventDispatchEvent();
                _loc_3.setLinkModelColor(false);
                _loc_3.setNotRelatedModelColor(false);
                _loc_3.setLinkLinesColor(false);
                _loc_3.lineRemoveColorDispatchEvent();
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
                _loc_3.glowTween.stopGlow();
                if (_loc_3.isDashModel)
                {
                    _loc_3.basicLineColor = _loc_3.colorProperty.dashBorderColor;
                    if (_loc_3 is DataMapComModel)
                    {
                        GraphicUtil.turnDashModelColor(_loc_3.basicLineColor, _loc_3.basicColor, _loc_3);
                    }
                    else
                    {
                        GraphicUtil.turnDashModelGradientColor(_loc_3.basicLineColor, _loc_3.basicColor, _loc_3);
                    }
                }
                else
                {
                    _loc_3.basicLineColor = _loc_3.colorProperty.linecolor;
                    if (_loc_3 is DataMapComModel)
                    {
                        GraphicUtil.turnModelColor(_loc_3.basicLineColor, _loc_3.basicColor, _loc_3);
                    }
                    else
                    {
                        GraphicUtil.turnModelGradientColor(_loc_3.basicLineColor, _loc_3.basicColor, _loc_3);
                    }
                }
                GraphicUtil.turnModelTextColor(_loc_3.colorProperty.fontcolor, _loc_3);
                _loc_3.lineRemoveColorDispatchEvent();
                _loc_3 = null;
            }
            CursorManager.removeCursor(CursorManager.currentCursorID);
            return;
        }// end function

        public function modelClickHandler(event:MouseEvent) : void
        {
            var _loc_3:Boolean = false;
            var _loc_4:DisplayElement = null;
            var _loc_5:DisplayElement = null;
            var _loc_2:* = event.target as DisplayObject;
            if (_loc_2.parent as DisplayElement)
            {
                _loc_5 = _loc_2.parent as DisplayElement;
                _loc_3 = _loc_5.isClick;
                _loc_5.isClick = !_loc_3;
                _loc_5.glowTween.stopGlow();
                if (_loc_3)
                {
                    _loc_5.basicColor = ColorProperty.colorTypeObject[_loc_5.typeClass];
                    if (_loc_5.isDashModel)
                    {
                        _loc_5.basicLineColor = _loc_5.colorProperty.dashBorderColor;
                        GraphicUtil.turnDashModelColor(_loc_5.basicLineColor, _loc_5.basicColor, _loc_5);
                    }
                    else
                    {
                        _loc_5.basicLineColor = _loc_5.colorProperty.linecolor;
                        GraphicUtil.turnModelColor(_loc_5.basicLineColor, _loc_5.basicColor, _loc_5);
                    }
                    for each (_loc_4 in _loc_5.modelView.getModels())
                    {
                        
                        addChildEventListener(_loc_4);
                    }
                    _loc_5.lineRemoveColorDispatchEvent();
                    _loc_5.lineAddEventDispatchEvent();
                }
                else
                {
                    _loc_5.basicColor = _loc_5.colorProperty.mousefillcolor;
                    _loc_5.basicLineColor = _loc_5.colorProperty.mouselinecolor;
                    GraphicUtil.dropShadow(_loc_5.basicLineColor, _loc_5.basicColor, _loc_5);
                    for each (_loc_4 in _loc_5.modelView.getModels())
                    {
                        
                        removeChildEventListener(_loc_4);
                    }
                    _loc_5.lineColorDispatchEvent();
                    _loc_5.lineRemoveEventDispatchEvent();
                }
                //zzg 2011-12-20
                if(_loc_5.detailInfoWin!=null){
	                _loc_5.detailInfoWin.includeInLayout = false;
	                _loc_5.detailInfoWin.visible = false;
                }
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
                _loc_3 = null;
            }
            _loc_2 = null;
            CursorManager.removeCursor(CursorManager.currentCursorID);
            CursorManager.setCursor(closedHandImg);
            return;
        }// end function

        private function setPopUpWinProperty(event:MouseEvent) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_4:int = 0;
            var _loc_5:Point = null;
            var _loc_6:MyWebservice = null;
            var _loc_7:Array = null;
            var _loc_8:XML = null;
            var _loc_2:* = event.target as DisplayObject;
            if (_loc_2.parent as DisplayElement)
            {
                _loc_3 = _loc_2.parent as DisplayElement;
                if (_loc_3.detailInfoWin != null)
                {
                	_loc_3.detailInfoWin.modelXmlList = null;
                     _loc_4 = 10;
                    _loc_5 = new Point(_loc_3.mouseX, _loc_3.mouseY);
                    _loc_5 = event.target.localToGlobal(_loc_5);
                    _loc_3.detailInfoWin.x = _loc_5.x + _loc_4;
                    _loc_3.detailInfoWin.y = _loc_5.y + _loc_4;
                    if (_loc_3.factory.getDataMapping().typename == "webservice")
                    {
                        if (!_loc_3.factory.isDebug)
                        {
                            if (_loc_3.detailXml == null)
                            {
                                _loc_6 = new MyWebservice(_loc_3.factory.getDataMapping().url);
                                _loc_7 = [_loc_3.modelId];
                                _loc_6.send(_loc_3.factory.getDataMapping().tipfunc, _loc_7);
                                _loc_6.onCompleteResult = _loc_3.handleResult;
                            }
                            else
                            {
                                _loc_3.handleResult(_loc_3.detailXml);
                            }
                        }
                        else
                        {
                            _loc_8 = new XML("<nodes><node name=\"索引\">8</node><node name=\"表\">483</node><node name=\"最新时间\">2011-05-09 12:00:00</node></nodes>");
                            
                            _loc_3.handleResult(_loc_8);
                        }
                    }
                }
            }
            return;
        }// end function

        public function onClick(event:MouseEvent) : void
        {
            var event:* = event;
            isDoubleClick = false;
            
               
            var timer:* = new Timer(260, 1);
            timer.start();
             clickOrDouble(event);
//            timer.addEventListener(TimerEvent.TIMER, function (event:TimerEvent)
//            {
//                clickOrDouble(event);
//                return;
//            }// end function
//            );
            return;
        }// end function

        public function modelRollOverHandler(event:MouseEvent) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_2:* = event.target as DisplayObject;
            if (_loc_2.parent as DisplayElement)
            {
                _loc_3 = _loc_2.parent as DisplayElement;
                _loc_3.basicLineColor = _loc_3.colorProperty.mouselinecolor;
                if (_loc_3.isDashModel)
                {
                    if (_loc_3 is DataMapComModel)
                    {
                        GraphicUtil.turnDashModelColor(_loc_3.basicLineColor, _loc_3.basicColor, _loc_3);
                    }
                    else
                    {
                        GraphicUtil.turnDashModelGradientColor(_loc_3.basicLineColor, _loc_3.basicColor, _loc_3);
                    }
                }
                else if (_loc_3 is DataMapComModel)
                {
                    GraphicUtil.turnModelColor(_loc_3.basicLineColor, _loc_3.basicColor, _loc_3);
                }
                else
                {
                    GraphicUtil.turnModelGradientColor(_loc_3.basicLineColor, _loc_3.basicColor, _loc_3);
                }
                GraphicUtil.turnModelTextColor(_loc_3.colorProperty.mouselinecolor, _loc_3);
                _loc_3.lineColorDispatchEvent();
                _loc_3.glowTween.startGlow();
                _loc_3 = null;
            }
            _loc_2 = null;
            CursorManager.removeCursor(CursorManager.currentCursorID);
            CursorManager.setCursor(opendHandImg);
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
//           element.myTimer.addEventListener(TimerEvent.TIMER, function (event:TimerEvent) : void
//            {
//                setPopUpWinProperty(event);
//                return;
//            }// end function
//            );
//                element;
            }
            return;
        }// end function

        public function addChildEventListener(param1:DisplayElement) : void
        {
            var _loc_2:DisplayElement = null;
            param1.rectOne.addEventListener(MouseEvent.ROLL_OUT, param1.myObject.modelRollOutHandler, false, 0, true);
            param1.rectOne.addEventListener(MouseEvent.ROLL_OVER, param1.myObject.modelRollOverHandler, false, 0, true);
            param1.rectOne.addEventListener(MouseEvent.ROLL_OUT, param1.myObject.modelDetailInfoRollOutHandler, false, 0, true);
            param1.rectOne.addEventListener(MouseEvent.ROLL_OVER, param1.myObject.modelDetailInfoRollOverHandler, false, 0, true);
            for each (_loc_2 in param1.subModels)
            {
                
                addChildEventListener(_loc_2);
            }
            param1 = null;
            return;
        }// end function

        public function removeChildEventListener(param1:DisplayElement) : void
        {
            var _loc_2:DisplayElement = null;
            param1.rectOne.removeEventListener(MouseEvent.ROLL_OUT, param1.myObject.modelRollOutHandler);
            param1.rectOne.removeEventListener(MouseEvent.ROLL_OVER, param1.myObject.modelRollOverHandler);
            param1.rectOne.removeEventListener(MouseEvent.ROLL_OUT, param1.myObject.modelDetailInfoRollOutHandler);
            param1.rectOne.removeEventListener(MouseEvent.ROLL_OVER, param1.myObject.modelDetailInfoRollOverHandler);
            param1.glowTween.stopGlow();
            param1.myTimer.stop();
            for each (_loc_2 in param1.subModels)
            {
                
                removeChildEventListener(_loc_2);
            }
            param1 = null;
            return;
        }// end function

        public function onDoubleClick(event:MouseEvent) : void
        {
            isDoubleClick = true;
            return;
        }// end function

        private function addCustomEventListener(param1:DisplayElement) : void
        {
            param1.rectOne.addEventListener(MouseEvent.ROLL_OUT, param1.myObject.modelRollOutHandler, false, 0, true);
            param1.rectOne.addEventListener(MouseEvent.ROLL_OVER, param1.myObject.modelRollOverHandler, false, 0, true);
            if (param1.parentmodel != null)
            {
                addCustomEventListener(param1.parentmodel);
            }
            return;
        }// end function

        public function basicModelClickHandler(event:MouseEvent) : void
        {
            var clickFlag:Boolean;
            var model:DisplayElement;
            var element:DisplayElement;
            var ws:MyWebservice;
            var array:Array;
            var event:* = event;
            var argObject:* = event.target as DisplayObject;
            var factory:* = ApplicationConfig.getInstance().modelFactory;
            if (argObject.parent as DisplayElement)
            {
                element = argObject.parent as DisplayElement;
                clickFlag = element.isClick;
                element.isClick = !clickFlag;
                element.glowTween.stopGlow();
                if (clickFlag)
                {
                    element.basicColor = ColorProperty.colorTypeObject[element.typeClass];
                    if (element.isDashModel)
                    {
                        element.basicLineColor = element.colorProperty.dashBorderColor;
                        GraphicUtil.turnDashModelGradientColor(element.basicLineColor, element.basicColor, element);
                    }
                    else
                    {
                        element.basicLineColor = element.colorProperty.linecolor;
                        GraphicUtil.turnModelGradientColor(element.basicLineColor, element.basicColor, element);
                    }
                    var _loc_3:int = 0;
                    var _loc_4:* = element.modelView.getModels();
                    while (_loc_4 in _loc_3)
                    {
                        
                        model = _loc_4[_loc_3];
                        addChildEventListener(model);
                    }
                    element.setLinkModelColor(false);
                    element.setNotRelatedModelColor(false);
                    element.setLinkLinesColor(false);
                    element.lineRemoveColorDispatchEvent();
                    element.lineAddEventDispatchEvent();
                }
                else
                {
                    ws = new MyWebservice(factory.getDataMapping().url);
                   //array;
                    ws.send(factory.getDataMapping().linkNodesfunc, array);
                    ws.onCompleteResult = function (param1:XML):void
		            {
		                var _loc_4:XML = null;
		                var _loc_2:* = param1.child("relations").children();
		                var _loc_3:* = param1.child("system").attribute("id").toString();
		                element.linkNodesIdCollection = new ArrayCollection();
		                element.linkNodesIdCollection.addItem(_loc_3);
		                for each (_loc_4 in _loc_2)
		                {
		                    
		                    element.linkNodesIdCollection.addItem(_loc_4.attribute("systemId").toString());
		                }
		                element.basicColor = element.colorProperty.mousefillcolor;
		                element.basicLineColor = element.colorProperty.mouselinecolor;
		                if (element.isDashModel)
		                {
		                    GraphicUtil.dropDashShadow(element.basicLineColor, element.basicColor, element);
		                }
		                else
		                {
		                    GraphicUtil.dropShadow(element.basicLineColor, element.basicColor, element);
		                }
		                for each (model in element.modelView.getModels())
		                {
		                    
		                    removeChildEventListener(model);
		                }
		                element.setLinkModelColor(true);
		                element.setNotRelatedModelColor(true);
		                element.setLinkLinesColor(true);
		                element.lineColorDispatchEvent();
		                element.lineRemoveEventDispatchEvent();
		                return;
		            }// end function
		            ;
                }
                if( element.detailInfoWin!=null){
	                element.detailInfoWin.includeInLayout = false;
	                element.detailInfoWin.visible = false;
                }
            }
            return;
        }// end function

    }
}
