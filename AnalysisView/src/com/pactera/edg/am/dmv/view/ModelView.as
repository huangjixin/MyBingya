package com.pactera.edg.am.dmv.view
{
    import com.roguedevelopment.objecthandles.*;
    import com.pactera.edg.am.dmv.factory.*;
    import com.pactera.edg.am.dmv.system.*;
    import com.pactera.edg.am.dmv.view.grid.*;
    import com.pactera.edg.am.dmv.view.line.*;
    import com.pactera.edg.am.dmv.view.model.*;
    
    import flash.events.*;
    import flash.external.*;
    import flash.geom.*;
    
    import mx.controls.*;
    import mx.core.*;
    import mx.managers.*;

    public class ModelView extends UIComponent
    {
        private var _container:ModelComponent;
        public var grid:Grid;
        public var handles:Array = null;
        private var _modelXml:XML;
        private var models:Array;
        private var _analysType:String;
        private var searchW:searchWindow;
        private var _modelViewId:String;
        private var lines:Array;
        

        public function ModelView()
        {
            models = [];
            lines = [];
            this.grid = new Grid();
            initHandles();
            return;
        }// end function

        public function get container() : ModelComponent
        {
            return this._container;
        }// end function

        public function set Lines(param1:Array) : void
        {
            this.lines = param1;
            return;
        }// end function

        public function updateModelView() : void
        {
            var _loc_1:DisplayElement = null;
            this.grid.initAll(this.models);
            this.grid.reCalculate(this.models);
            for each (_loc_1 in this.models)
            {
                
                this.grid.moveModel(_loc_1);
            }
            if (this.contains(this.container))
            {
                this.removeChild(this.container);
            }
            this.addChild(this.container);
            return;
        }// end function

        public function clearSelected(param1:Array) : void
        {
            var _loc_2:DisplayElement = null;
            var _loc_3:ModelContainer = null;
            for each (_loc_2 in param1)
            {
                
                if (_loc_2.subModels.length > 0)
                {
                    _loc_3 = _loc_2.container;
                    _loc_3.getObjectHandles().selectionManager.clearSelection();
                    clearSelected(_loc_2.subModels);
                }
            }
            return;
        }// end function

        public function getAnalysType() : String
        {
            return this._analysType;
        }// end function


        public function searchDataMap(_event:ContextMenuEvent) : void
        {
        	var event:* = _event;
        	var modelId:String;
            var modelType:String;
            modelId = (event.mouseTarget.parent as DisplayElement).modelId;
            modelType = (event.mouseTarget.parent as DisplayElement).modelType;
            doSearchDataMap(modelId,modelType);
        }
        public function removeSearchW():void{
        	var _searchW:searchWindow= com.pactera.edg.am.dmv.view.searchWindow.g_searchW
        	if (_searchW != null && _searchW.visible)
            {
                PopUpManager.removePopUp(_searchW);
                _searchW=null;
            }
        }
        public function doSearchDataMap(modelId:String,modelType:String) : void
        {
        	removeSearchW();
            searchW = searchWindow(PopUpManager.createPopUp(this, searchWindow, false));
            PopUpManager.centerPopUp(searchW);
            searchW.mainApp = this;

            searchW.callBackFun = function (param1:String):void
            {
                ExternalInterface.call("searchMetaData", modelId, param1, modelType);
                return;
            }// end function
            ;
             com.pactera.edg.am.dmv.view.searchWindow.setSearchWindow(searchW);
            return;
        }// end function

        public function setAnalysType(param1:String) : void
        {
            this._analysType = param1;
            return;
        }// end function

        public function getLines() : Array
        {
            return this.lines;
        }// end function

        public function set modelViewId(param1:String) : void
        {
            this._modelViewId = param1;
            return;
        }// end function

        public function saveDataMap(event:ContextMenuEvent) : void
        {
            var event:* = event;
            var factory:* = ApplicationConfig.getInstance().modelFactory;
            getDataMapXml(this.modelXml);
            
            var ws:* = new MyWebservice(factory.getDataMapping().url);
            var array:Array=this.modelXml[0];
            ws.send(factory.getDataMapping().savefunc, array);
            //array;
            ws.onCompleteResultObject = function (param1:String):void
            {
                if (param1 == "0")
                {
                    Alert.show("发生错误！");
                }
                else if (param1 == "1")
                {
                    Alert.show("保存成功！");
                }
                return;
            }// end function
            ;
            return;
        }// end function

        private function modelOpenView(param1:DisplayElement) : void
        {
            var _loc_2:DisplayElement = null;
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

        override protected function createChildren() : void
        {
            if (this.container == null)
            {
                this._container = new ModelComponent();
                this.addChild(this.container);
            }
            return;
        }// end function

        public function set modelXml(param1:XML) : void
        {
            var displayElement:DisplayElement = null;
            var line:Line = null;
            this._modelXml = param1;
            var xmlToModel:XmlToModel = new XmlToModel();
            xmlToModel.canvas = this;
            xmlToModel.runXmlToModel(this._modelXml);
            this.models = xmlToModel.getModels();
            this.lines = xmlToModel.getLines();
            this.models = this.grid.SwimModelFormat(this.models, this.lines);
            for each (displayElement in this.models)
            {
                
                this.container.addChild(displayElement);
                this.modelOpenView(displayElement);
            }
            this.container.registerModels(this.handles);
            for each (line in this.lines)
            {
                
                this.container.addChild(line);
            }
            for each (line in this.lines)
            {
                
                this.container.setChildIndex(line, (this.container.numChildren - 1));
            }
            this.updateModelView();
            return;
        }// end function

        override protected function measure() : void
        {
            super.measure();
            var _loc_1:* = this.container.getExplicitOrMeasuredHeight() + 10;
            this.measuredMinHeight = this.container.getExplicitOrMeasuredHeight() + 10;
            this.measuredHeight = _loc_1;
            _loc_1= this.container.getExplicitOrMeasuredWidth() + 10;
            this.measuredWidth = this.container.getExplicitOrMeasuredWidth() + 10;
            this.measuredMinWidth = _loc_1;
            return;
        }// end function

        public function getModels() : Array
        {
            return this.models;
        }// end function

        private function initHandles() : void
        {
            handles = [];
            handles.push(new HandleDescription(HandleRoles.RESIZE_UP, new Point(50, 0), new Point(0, 0)));
            handles.push(new HandleDescription(HandleRoles.RESIZE_RIGHT, new Point(100, 50), new Point(0, 0)));
            handles.push(new HandleDescription(HandleRoles.RESIZE_DOWN, new Point(50, 100), new Point(0, 0)));
            handles.push(new HandleDescription(HandleRoles.RESIZE_LEFT, new Point(0, 50), new Point(0, 0)));
//			handles.push( new HandleDescription( HandleRoles.MOVE,
//								    new Point(50,50) , 
//								    new Point(0,0) ) ); 
            return;
        }// end function

        public function get modelViewId() : String
        {
            return this._modelViewId;
        }// end function

        public function set Models(param1:Array) : void
        {
            this.models = param1;
            return;
        }// end function

        public function get modelXml() : XML
        {
            return this._modelXml;
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

        public function initAllModelbisAnalysicLinkModel(param1:Array) : void
        {
            var _loc_2:DisplayElement = null;
            for each (_loc_2 in param1)
            {
                
                _loc_2.bisAnalysicLinkModel = false;
                if (_loc_2.subModels.length > 0)
                {
                    initAllModelbisAnalysicLinkModel(_loc_2.subModels);
                }
            }
            return;
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            this.container.setActualSize(param1 - 10, param2 - 10);
            return;
        }// end function

        public function getGrid() : Grid
        {
            return this.grid;
        }// end function

        public function getDataMapXml(param1:XML) : void
        {
            var nodeItem:XML = null;
            var displayEle:DisplayElement = null;
            var nodesChildren:* = param1.child("nodes").children();
            for each (nodeItem in nodesChildren)
            {
                
                displayEle = getModelById(nodeItem.@mdid);
                if (displayEle != null)
                {
                    nodeItem.@x = displayEle.x;
                    nodeItem.@y = displayEle.y;
                    nodeItem.@width = displayEle.width;
                    nodeItem.@height = displayEle.height;
                }
                if (displayEle.subModels.length > 0)
                {
                    getDataMapXml(nodeItem);
                }
            }
            return;
        }// end function

    }
}
