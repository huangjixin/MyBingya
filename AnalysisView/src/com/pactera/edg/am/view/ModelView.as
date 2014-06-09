package com.pactera.edg.am.view
{
    import com.pactera.edg.am.factory.*;
    import com.pactera.edg.am.view.grid.*;
    import com.pactera.edg.am.view.interfaces.*;
    import com.pactera.edg.am.view.line.*;
    import com.pactera.edg.am.view.model.*;
    import com.roguedevelopment.objecthandles.*;
    import com.roguedevelopment.objecthandles.constraints.*;
    import flash.display.*;
    import flash.events.*;
    import flash.geom.*;
    import flash.utils.*;
    
    import mx.events.ScrollEvent;
    import mx.core.*;
    import mx.effects.*;
    import mx.managers.*;

    public class ModelView extends UIComponent
    {
        private var _container:ModelComponent;
        private var basicPoint:Point;
        private var _modelXml:XML;
        private var con:Number;
        private var _headInfo:ModelHead = null;
        private var imageCursor:Class;
        public var modelsHashMap:Dictionary;
        private var _analysType:String;
        private var moveContainer:Move = null;
        private var drap:Boolean;
        private var _tourFlag:Boolean = false;
        private var _preSelectedModel:DisplayElement;
        public var grid:Grid;
        private var startPoint:Point;
        private var toPoint:Point;
        public var clickedModles:Object = null;
        private var color:ColorProperty;
        private var startRoot:UIComponent;
        private var _modelViewId:String;
        private var models:Array;
        private var _analysicStartModel:DisplayElement;
        private var lines:Array;
        public static const handles:Array = new Array(new HandleDescription(HandleRoles.MOVE, new Point(50, 50), new Point(0, 0)));

        public function ModelView()
        {
            this.models = [];
            this.lines = [];
            this.imageCursor = ModelView_imageCursor;
            this.modelsHashMap = new Dictionary();
            this.drap = false;
            this.grid = new Grid();
            this.color = new ColorProperty();
            this.addEventListener(MouseEvent.MOUSE_OVER, this.setMouseStyle, false, 0, true);
            this.addEventListener(MouseEvent.MOUSE_OUT, this.setMouseStyle, false, 0, true);
            this.addEventListener(MouseEvent.MOUSE_MOVE, this.mouseMoveEvent, false, 0, true);
            
            this.moveContainer = new Move();
            this._headInfo = new ModelHead();
            this.clickedModles = new Object();
            return;
        }// end function
        
        public function get container() : ModelComponent
        {
            return this._container;
        }// end function

        private function checkAnalysisModel(param1:Array) : void
        {
            var _loc_2:DisplayElement = null;
            for each (_loc_2 in param1)
            {
                
                if (this.modelViewId == _loc_2.modelId)
                {
                    _loc_2.bisAnalysicModel = true;
                    _loc_2.setModelOpen(_loc_2);
                    this.analysicStartModel = _loc_2;
                    break;
                    continue;
                }
                if (_loc_2.subModels.length > 0)
                {
                    this.checkAnalysisModel(_loc_2.subModels);
                }
            }
            return;
        }// end function

        public function clearAllSelected() : void
        {
        	
            var _loc_1:* = this.container;
            //trace("[ModelView.as]clearAllSelected():"+_loc_1.getObjectHandles());
            if (_loc_1.getObjectHandles() == null)
            {
                return;
            }
            _loc_1.getObjectHandles().selectionManager.clearSelection();
            this.clearSelected(this.getModels());
            return;
        }// end function

        public function mouseUpHandler(event:MouseEvent) : void
        {
            var _loc_2:MovementConstraint = null;
            var _loc_3:Point = null;
            var _loc_4:Point = null;
            if (this.tourFlag)
            {
                this.drap = false;
                _loc_2 = new MovementConstraint();
                _loc_3 = this.localToGlobal(new Point(0, 0));
                _loc_4 = this.container.globalToLocal(_loc_3);
                _loc_2.minX = _loc_4.x;
                _loc_2.minY = _loc_4.y;
                this.container.genObjectHandles();
                this.container.getObjectHandles().addDefaultConstraint(_loc_2);
                this.invalidateProperties();
                this.invalidateSize();
                this.invalidateDisplayList();
            }
            return;
        }// end function

        private function setMouseStyle(event:MouseEvent) : void
        {
            if (event.type == "mouseOver")
            {
                if (this.tourFlag)
                {
                    CursorManager.setCursor(this.imageCursor);
                }
            }
            else if (event.type == "mouseOut")
            {
                CursorManager.removeAllCursors();
            }
            return;
        }// end function

        public function clearSelected(param1:Array) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_2:ObjectHandles = null;
            for each (_loc_3 in param1)
            {
                
                if (_loc_3.container == null || _loc_3.subModels.length == 0)
                {
                    continue;
                }
                _loc_2 = _loc_3.container.getObjectHandles();
                if (_loc_2 == null)
                {
                    continue;
                }
                if (_loc_2.selectionManager.currentlySelected.length == 1)
                {
                    _loc_2.selectionManager.clearSelection();
                    break;
                }
                this.clearSelected(_loc_3.subModels);
            }
            return;
        }// end function

        public function setAnalysType(param1:String) : void
        {
            this._analysType = param1;
            return;
        }// end function

        public function set Models(param1:Array) : void
        {
            this.models = param1;
            return;
        }// end function

        public function updateModelView() : void
        {
            var _loc_1:DisplayElement = null;
            var _loc_2:DisplayElement = null;
            var _loc_3:Line = null;
            this.models = this.grid.ModelPostionFormat(this.models);
            for each (_loc_1 in this.models)
            {
                if (this.container.contains(_loc_1))
                {
                    continue;
                }
                this.container.addChild(_loc_1);
                this.container.registerModel(ModelView.handles, _loc_1);
            }
            

        	
            this.grid.initAll(this.models);
            this.grid.reCalculate(this.models);
            
            
            for each (_loc_2 in this.models)
            {
                this.grid.moveModel(_loc_2);
            }
            for each (_loc_3 in this.lines)
            {
                
                if (this.container.contains(_loc_3))
                {
                    continue;
                }
                this.container.addChild(_loc_3);
                this.container.setChildIndex(_loc_3, (this.container.numChildren - 1));
            }
            if (this.contains(this.container))
            {
                this.removeChild(this.container);
            }
            this.addChild(this.container);
            return;
        }// end function

        public function set analysicStartModel(param1:DisplayElement) : void
        {
            this._analysicStartModel = param1;
            return;
        }// end function

        public function get modelViewId() : String
        {
            return this._modelViewId;
        }// end function

        public function get headInfo() : ModelHead
        {
            return this._headInfo;
        }// end function

        public function getAnalysType() : String
        {
            return this._analysType;
        }// end function

        public function get modelXml() : XML
        {
            return this._modelXml;
        }// end function

        public function addChildEventListener(param1:DisplayElement) : void
        {
            param1.rectOne.addEventListener(MouseEvent.ROLL_OUT, param1.myObject.modelRollOutHandler, false, 0, true);
            param1.rectOne.addEventListener(MouseEvent.ROLL_OVER, param1.myObject.modelRollOverHandler, false, 0, true);
            return;
        }// end function

        public function mouseMoveEvent(event:MouseEvent) : void
        {
            var _loc_2:Number = NaN;
            var _loc_3:Number = NaN;
            var _loc_4:Number = NaN;
            var _loc_5:Number = NaN;
            var _loc_6:Point = null;
            var _loc_7:Point = null;
            if (this.drap)
            {
                _loc_2 = 0;
                _loc_3 = 0;
                this.moveContainer.target = this.container;
                this.moveContainer.end();
                if (this.con == 1)
                {
                    this.con = 2;
                }
                else
                {
                    this.startPoint = this.toPoint;
                }
                this.toPoint = new Point(this.mouseX, this.mouseY);
                _loc_4 = this.toPoint.x - this.startPoint.x;
                _loc_5 = this.toPoint.y - this.startPoint.y;
                _loc_2 = this._container.x + _loc_4;
                _loc_3 = this._container.y + _loc_5;
                _loc_6 = this.container.getMinPosition();
                _loc_7 = this.globalToLocal(this.container.localToGlobal(_loc_6));
                if (_loc_7.x + _loc_4 < 0)
                {
                    _loc_2 = 0;
                    this.drap = false;
                    return;
                }
                if (_loc_7.y + _loc_5 < 0)
                {
                    _loc_3 = 0;
                    this.drap = false;
                    return;
                }
                this.moveContainer.xTo = _loc_2;
                this.moveContainer.yTo = _loc_3;
                this.moveContainer.play();
            }
            return;
        }// end function

        public function set Lines(param1:Array) : void
        {
            this.lines = param1;
            return;
        }// end function

        public function getLines() : Array
        {
            return this.lines;
        }// end function

        public function getGrid() : Grid
        {
            return this.grid;
        }// end function

        public function set modelViewId(param1:String) : void
        {
            this._modelViewId = param1;
            return;
        }// end function

        public function get analysicStartModel() : DisplayElement
        {
            return this._analysicStartModel;
        }// end function

        public function set tourFlag(param1:Boolean) : void
        {
            this._tourFlag = param1;
            return;
        }// end function

        public function modelOpenView(param1:DisplayElement) : void
        {
            var _loc_2:DisplayElement = null;
            if (param1.subModels.length > 0)
            {
                for each (_loc_2 in param1.subModels)
                {
                    
                    this.modelOpenView(_loc_2);
                }
                if (!param1.isOpen)
                {
                    param1.isOpen = true;
                }
            }
            return;
        }// end function

        public function set headInfo(param1:ModelHead) : void
        {
            this._headInfo = param1;
            return;
        }// end function

        public function set preSelectedModel(param1:DisplayElement) : void
        {
            this._preSelectedModel = param1;
            return;
        }// end function

        override protected function measure() : void
        {
            var _loc_1:* = this.container.y + this.container.getExplicitOrMeasuredHeight() + 10;
            this.measuredMinHeight = this.container.y + this.container.getExplicitOrMeasuredHeight() + 10;
            this.measuredHeight = _loc_1;
            var _loc_2:* = this.container.x + this.container.getExplicitOrMeasuredWidth() + 10;
            this.measuredWidth = this.container.x + this.container.getExplicitOrMeasuredWidth() + 10;
            this.measuredMinWidth = _loc_2;
            return;
        }// end function
    
 	
        override protected function createChildren() : void
        {
            if (this.container == null)
            {
                this._container = new ModelComponent();
                this.addChild(this.container);
                this._container.addEventListener(MouseEvent.MOUSE_DOWN, this.mouseDownHandler);
                this._container.addEventListener(MouseEvent.MOUSE_UP, this.mouseUpHandler);
            }
            return;
        }// end function
	  
        public function getModels() : Array
        {
            return this.models;
        }// end function

        public function get preSelectedModel() : DisplayElement
        {
            return this._preSelectedModel;
        }// end function

        public function recoverModels() : void
        {
            var _loc_1:DisplayElement = null;
            for each (_loc_1 in this.modelsHashMap)
            {
            	//zzg 2011-12-14
                if(_loc_1!=null){
               		_loc_1.recoverModel();
                }
            }
            return;
        }// end function

        public function initAllModelbisAnalysicLinkModel(param1:Array) : void
        {
            var _loc_2:DisplayElement = null;
            for each (_loc_2 in param1)
            {
                
                _loc_2.bisAnalysicLinkModel = false;
                _loc_2.isClick = false;
                this.addChildEventListener(_loc_2);
                if (_loc_2.subModels.length > 0)
                {
                    this.initAllModelbisAnalysicLinkModel(_loc_2.subModels);
                }
            }
            return;
        }// end function

        public function set modelXml(param1:XML) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_4:DisplayObject = null;
            this._modelXml = param1;
            var _loc_2:* = new XmlToModel();
            _loc_2.modelView = this;
            _loc_2.runXmlToModel(this._modelXml);
            this.models = _loc_2.getModels();
            this.lines = _loc_2.getLines();
            this.headInfo = _loc_2.getModelHead();
            this.modelViewId = this.headInfo.mdId;
            this.checkAnalysisModel(this.models);
            for each (_loc_3 in this.models)
            {
                
                this.container.addChild(_loc_3);
                this.modelOpenView(_loc_3);
                this.container.registerModel(ModelView.handles, _loc_3);
            }
            _loc_4 = this.systemManager.getSandboxRoot();
            _loc_4.addEventListener(MouseEvent.MOUSE_UP, this.mouseUpHandler, false, 0, true);
            this.updateModelView();
            this.invalidateSize();
            this.invalidateDisplayList();
            return;
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            var _loc_3:* = this.container.getExplicitOrMeasuredWidth();
            var _loc_4:* = this.container.getExplicitOrMeasuredHeight();
            this.container.setActualSize(_loc_3, _loc_4);
            GraphicUtil.turnModelColor(this.color.bgcolor, this.color.bgcolor, this);//0xff0000
            return;
        }// end function

        public function mouseDownHandler(event:MouseEvent) : void
        {
        	//trace("ModelView[mouseDownHandler]...");
            if (this.tourFlag)
            {
                this.drap = true;
                this.con = 1;
                this.startRoot = this.container.owner as UIComponent;
                this.startPoint = new Point(this.mouseX, this.mouseY);
            }
            return;
        }// end function

        public function get tourFlag() : Boolean
        {
            return this._tourFlag;
        }// end function


       //zzg 2011-12-19
       //为DataMapView.mxml增加方法
        public function getDataMapXml(param1:XML) : void
        {
            var _loc_3:XML = null;
            var _loc_4:DisplayElement = null;
            var _loc_2:* = param1.child("nodes").children();
            for each (_loc_3 in _loc_2)
            {
                
                _loc_4 = getModelById(_loc_3.@mdid);
                if (_loc_4 != null)
                {
                    _loc_3.@x = _loc_4.x;
                    _loc_3.@y = _loc_4.y;
                    _loc_3.@width = _loc_4.width;
                    _loc_3.@height = _loc_4.height;
                }
                if (_loc_4.subModels.length > 0)
                {
                    getDataMapXml(_loc_3);
                }
            }
            return;
        }// end function
        
       private function getModelById(param1:String) : DisplayElement
        {
            var _loc_3:DisplayElement = null;
            var _loc_2:DisplayElement = null;
            for each (_loc_3 in this.models)
            {
                
                _loc_2 = _loc_3.findModelById(param1);
                if (_loc_2 != null)
                {
                    break;
                }
            }
            return _loc_2;
        }// end function
        
        
    }
}
