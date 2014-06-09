package com.pactera.edg.am.kpi.view
{
    import com.pactera.edg.am.kpi.factory.*;
    import com.pactera.edg.am.kpi.system.*;
    import com.pactera.edg.am.kpi.view.model.*;
    import flash.events.*;
    import flash.net.*;
    import mx.containers.*;
    import mx.controls.*;
    import mx.controls.dataGridClasses.*;
    import mx.rpc.events.*;
    import mx.rpc.soap.*;

    public class ModelGrid extends Panel
    {
        private var columnName:DataGridColumn;
        private var dataGrid:DataGrid;
        private var factory:ModelFactory;
        private var loader:URLLoader;
        private var modelDataGrid:DataGrid;
        private var childXml:XML;
        private var dataColumn:Array;
        private var _modelId:String;
        private var _model:DisplayElement;
        private var columnValue:DataGridColumn;

        public function ModelGrid()
        {
            modelDataGrid = new DataGrid();
            columnName = new DataGridColumn();
            columnValue = new DataGridColumn();
            dataColumn = new Array();
            dataGrid = new DataGrid();
            factory = ApplicationConfig.getInstance().modelFactory;
            this.visible = false;
			trace("factory:"+factory);
			trace("factory.getArguments():"+factory.getArguments());
			
            this.columnName.headerText = factory.getArguments().attributesAttname;
            this.columnName.dataField = factory.getArguments().attributesAttnameCode;
            this.columnValue.headerText = factory.getArguments().attributesAttvalue;
            this.columnValue.dataField = factory.getArguments().attributesAttvalueCode;
            this.columnName.wordWrap = true;
            this.dataGrid.variableRowHeight = true;
            this.dataColumn.push(this.columnName);
            this.dataColumn.push(this.columnValue);
            dataGrid.columns = dataGrid.columns.concat(this.dataColumn);
            dataGrid.rowCount = factory.getArguments().rowCount;
            dataGrid.wordWrap = true;
            this.addChild(this.dataGrid);
            return;
        }// end function

        private function onfault(event:FaultEvent) : void
        {
            Alert.show("fault===" + event);
            return;
        }// end function

        public function set modelId(param1:String) : void
        {
            this._modelId = param1;
            return;
        }// end function

        public function set model(param1:DisplayElement) : void
        {
            this._model = param1;
            return;
        }// end function

        public function loadXML() : void
        {
            this.loader = new URLLoader();
            var _loc_1:* = new URLRequest("F:/workspace/PictoralView/src/xml/attribute_example.xml");
            this.loader.load(_loc_1);
            this.loader.addEventListener(Event.COMPLETE, onCompleteHandler);
            return;
        }// end function

        public function buildDataGrid() : void
        {
            var _loc_3:* = null;
            var _loc_4:* = null;
            var _loc_5:* = null;
            var arguments:ModelFactory = ApplicationConfig.getInstance().modelFactory;
            if (arguments.getDataMapping().typename == "webservice")
            {
                _loc_3 = new WebService();
                _loc_3.wsdl = arguments.getDataMapping().url;
                _loc_3.useProxy = false;
                _loc_3.loadWSDL();
                _loc_4 = _loc_3.getOperation(arguments.getDataMapping().argumentsfunc) as Operation;
                _loc_5 = new Array();
                _loc_5.push(this.modelId);
                _loc_4.arguments = _loc_5;
                _loc_4.addEventListener(FaultEvent.FAULT, onfault);
                _loc_4.addEventListener(ResultEvent.RESULT, onresult);
                _loc_4.send();
            }
            return;
        }// end function

        public function get modelId() : String
        {
            return this._modelId;
        }// end function

        public function get model() : DisplayElement
        {
            return this._model;
        }// end function

        private function onCompleteHandler(event:Event) : void
        {
            var _loc_2:* = null;
            this.removeChild(this.dataGrid);
            this.childXml = new XML(this.loader.data);
            this.dataGrid.dataProvider = this.childXml.attributes.attribute;
            for each (_loc_2 in this.childXml.head)
            {
                
                this.title = factory.getArguments().headTitle + _loc_2.mdcode;
            }
            this.addChild(this.dataGrid);
            this.visible = true;
			trace("onCompleteHandler");
            this.width = 430;
            return;
        }// end function

        private function onresult(event:ResultEvent) : void
        {
            var _loc_2:* = null;
            this.removeChild(this.dataGrid);
            this.childXml = new XML(event.result);
            this.dataGrid.dataProvider = this.childXml.attributes.attribute;
            for each (_loc_2 in this.childXml.head)
            {
                
                this.title = factory.getArguments().headTitle + _loc_2.mdcode;
            }
            this.addChild(this.dataGrid);
            this.visible = true;
			trace("onresult");
            this.width = 430;
            return;
        }// end function

    }
}
