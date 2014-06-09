package com.pactera.edg.am.kpi.view
{
    import com.pactera.edg.am.kpi.factory.*;
    import com.pactera.edg.am.kpi.system.*;
    import com.pactera.edg.am.kpi.view.grid.*;
    import com.pactera.edg.am.kpi.view.line.*;
    import com.pactera.edg.am.kpi.view.model.*;
	import com.roguedevelopment.objecthandles.*;
	import com.roguedevelopment.objecthandles.constraints.*;
    import flash.display.*;
    import flash.events.*;
    import flash.geom.*;
    
    import mx.containers.*;
    import mx.core.*;
    import mx.effects.*;
	import com.pactera.edg.am.kpi.view.grid.Grid;

    public class ModelView extends Canvas
    {
        private var _container:ModelComponent;
        private var num:Number = 1;
        private var basicPoint:Point;
        private var _modelXml:XML;
        private var _modelGrid:ModelGrid;
        private var con:Number;
        private var point:Point;
        private var _analysType:String;
        private var _modelHead:ModelHead;
        private var moveContainer:Move;
        private var drap:Boolean;
        private var _helpWindow:HelpWindow;
        private var grid:com.pactera.edg.am.kpi.view.grid.Grid;
        private var startPoint:Point;
        private var toPoint:Point;
        private var startRoot:UIComponent;
        private var models:Array;
        private var _modelViewId:String;
        private var lines:Array;

        public function ModelView()
        {
            models = [];
            lines = [];
            _container = new ModelComponent();
            moveContainer = new Move();
            drap = new Boolean();
            _helpWindow = new HelpWindow();
            drap = false;
            this.doubleClickEnabled = true;
            this.grid = new com.pactera.edg.am.kpi.view.grid.Grid();
            return;
        }// end function

        public function get container() : ModelComponent
        {
            return this._container;
        }// end function

        public function mouseUpHandler(event:MouseEvent) : void
        {
            drap = false;
            this.container.invalidateSize();
            this.container.invalidateDisplayList();
            return;
        }// end function

        public function setAnalysType(param1:String) : void
        {
            this._analysType = param1;
            return;
        }// end function

        public function get modelGrid() : ModelGrid
        {
            return this._modelGrid;
        }// end function

        public function set Models(param1:Array) : void
        {
            this.models = param1;
            return;
        }// end function

        public function get helpWindow() : HelpWindow
        {
            if (this._helpWindow.parent == null)
            {
                this._helpWindow = new HelpWindow();
            }
            return this._helpWindow;
        }// end function

        public function set modelGrid(param1:ModelGrid) : void
        {
            this._modelGrid = param1;
            return;
        }// end function

        public function getAnalysType() : String
        {
            return this._analysType;
        }// end function

        public function updateModelView() : void
        {
            var _loc_1:* = null;
            this.grid.initAll(this.models);
            this.grid.reCalculate(this.models);
            for each (_loc_1 in this.models)
            {
                
                this.grid.moveModel(_loc_1);
            }
            this.container.height = this.grid.getMaxHeigth();
            this.container.width = this.grid.getMaxWidth();
			trace("kpi ModelView  this.container.width ["+ this.container.width +"]this.container.height["+this.container.height+"]");
            this.addChild(this.container);
            this.container.invalidateDisplayList();
            this.container.invalidateSize();
            return;
        }// end function

        public function get modelHead() : ModelHead
        {
            return this._modelHead;
        }// end function

        public function get modelXml() : XML
        {
            return this._modelXml;
        }// end function

        public function set container(param1:ModelComponent) : void
        {
            this._container = param1;
            return;
        }// end function

        public function get modelViewId() : String
        {
            return this._modelViewId;
        }// end function

        public function getRightModelWidth() : Number
        {
            var _loc_3:* = null;
            var _loc_1:* = 0;
            var _loc_2:* = 0;
            for each (_loc_3 in this.models)
            {
                
                if (_loc_3.isOpen)
                {
                    _loc_2 = _loc_3.x + _loc_3.getExWidth();
                }
                else
                {
                    _loc_2 = _loc_3.x + _loc_3.defaultModelWidth;
                }
                if (_loc_1 < _loc_2)
                {
                    _loc_1 = _loc_2;
                }
            }
            return _loc_1 + 10;
        }// end function

        public function mouseMoveEvent(event:MouseEvent) : void
        {
            var _loc_2:* = NaN;
            var _loc_3:* = NaN;
            if (drap)
            {
                _loc_2 = 0;
                _loc_3 = 0;
                moveContainer.target = this._container;
                moveContainer.end();
                if (con == 1)
                {
                    con = 2;
                }
                else
                {
                    startPoint = toPoint;
                }
                basicPoint = new Point(this.mouseX, this.mouseY);
                toPoint = startRoot.globalToLocal(this.localToGlobal(basicPoint));
                _loc_2 = this._container.x + (toPoint.x - startPoint.x);
                _loc_3 = this._container.y + (toPoint.y - startPoint.y);
                if (this._container.x < 0)
                {
                    _loc_2 = 0;
                }
                if (this._container.y < 0)
                {
                    _loc_3 = 0;
                }
                moveContainer.xTo = _loc_2;
                moveContainer.yTo = _loc_3;
                moveContainer.play();
            }
            return;
        }// end function

        public function set Lines(param1:Array) : void
        {
            this.lines = param1;
            return;
        }// end function

        public function getGrid() : com.pactera.edg.am.kpi.view.grid.Grid
        {
            return this.grid;
        }// end function

        public function getLines() : Array
        {
            return this.lines;
        }// end function

        public function getBottomModelHeight() : Number
        {
            var _loc_3:* = null;
            var _loc_1:* = 0;
            var _loc_2:* = 0;
            for each (_loc_3 in this.models)
            {
                
                if (_loc_3.isOpen)
                {
                    _loc_2 = _loc_3.y + _loc_3.getExHeight();
                }
                else
                {
                    _loc_2 = _loc_3.y + _loc_3.defaultModelHeight;
                }
                if (_loc_1 < _loc_2)
                {
                    _loc_1 = _loc_2;
                }
            }
            return _loc_1 + 10;
        }// end function

        public function set modelViewId(param1:String) : void
        {
            this._modelViewId = param1;
            return;
        }// end function

        private function modelOpenView(param1:DisplayElement) : void
        {
            var _loc_2:* = null;
            if (param1.subModels.length > 0)
            {
                for each (_loc_2 in param1.subModels)
                {
                    
                    this.modelOpenView(_loc_2);
                }
            }
            param1.extensible.modelState.changeModelState();
            return;
        }// end function

        public function set modelHead(param1:ModelHead) : void
        {
            this._modelHead = param1;
            return;
        }// end function

        public function set modelXml(param1:XML) : void
        {
            var _loc_3:* = null;
            var _loc_4:* = null;
            var _loc_5:* = null;
            var _loc_6:* = null;
            var _loc_7:* = null;
            var _loc_8:* = null;
            this._modelXml = param1;
            var _loc_2:* = new XmlToModel();
            _loc_2.canvas = this;
            _loc_2.modelGrid = this.modelGrid;
            _loc_2.runXmlToModel(this._modelXml);
            this.models = _loc_2.getModels();
            this.lines = _loc_2.getLines();
            this.modelHead = _loc_2.getModelHead();
            this.models = this.grid.ModelFormat(this.models, this.lines);
            this.grid.init(this.models);
            for each (_loc_3 in this.models)
            {
                
                this.container.addChild(_loc_3);
            }
            _loc_4 = ApplicationConfig.getInstance().modelFactory;
            if (_loc_4.getViewMapping().isOpen)
            {
                for each (_loc_8 in this.models)
                {
                    
                    if (_loc_8.modelClass != "ChartModel")
                    {
                        this.modelOpenView(_loc_8);
                    }
                }
                this.grid.initAll(this.models);
            }
            this.grid.reCalculate(this.models);
            for each (_loc_5 in this.models)
            {
                
                this.grid.moveModel(_loc_5);
            }
            for each (_loc_6 in this.lines)
            {
                
                this.container.addChild(_loc_6);
            }
            for each (_loc_6 in this.lines)
            {
                
                this.container.setChildIndex(_loc_6, (this.container.numChildren - 1));
            }
            this.addEventListener(MouseEvent.MOUSE_MOVE, mouseMoveEvent);
            this.addEventListener(MouseEvent.MOUSE_DOWN, mouseDownHandler);
            this.addEventListener(MouseEvent.MOUSE_UP, mouseUpHandler);
            _loc_7 = this.systemManager.getSandboxRoot();
            _loc_7.addEventListener(MouseEvent.MOUSE_UP, mouseUpHandler);
            this.container.height = this.grid.getMaxHeigth();
            this.container.width = this.grid.getMaxWidth();
            this.addChild(this.container);
            this.container.invalidateDisplayList();
            this.container.invalidateSize();
            return;
        }// end function

        public function getModels() : Array
        {
            return this.models;
        }// end function

        public function mouseDownHandler(event:MouseEvent) : void
        {
            drap = true;
            con = 1;
            startRoot = this.owner as UIComponent;
            basicPoint = new Point(this.mouseX, this.mouseY);
            startPoint = startRoot.globalToLocal(this.localToGlobal(basicPoint));
            if (startPoint.x > this._container.parent.width - 10)
            {
                drap = false;
            }
            if (startPoint.y > this._container.parent.height - 10)
            {
                drap = false;
            }
            return;
        }// end function

    }
}
