package com.pactera.edg.am.kpi.factory
{
    import com.pactera.edg.am.kpi.mapping.*;
    import com.pactera.edg.am.kpi.view.*;
    import com.pactera.edg.am.kpi.view.dragger.*;
    import com.pactera.edg.am.kpi.view.extender.*;
    import com.pactera.edg.am.kpi.view.grid.*;
    import com.pactera.edg.am.kpi.view.handler.*;
    import com.pactera.edg.am.kpi.view.model.*;
    import flash.events.*;
    import flash.external.*;
    import flash.ui.*;
    import flash.utils.*;
    import mx.controls.*;
    import mx.core.*;

    public class ModelFactory extends Object
    {
        private var lineMapping:Object;
        private var dataMapping:Data;
        private var modelViewArgument:ModelViewArgument;
        private var nodeMapping:Node;
        private var _modelGrid:ModelGrid;
        private var xml:XML;
        private var mappingArguments:com.pactera.edg.am.kpi.mapping.Arguments;
        private var register:Register;
        private var viewMapping:View;
        private var imageMapping:com.pactera.edg.am.kpi.mapping.Image;
        private var classMapping:Object;
        private var _canvas:ModelView;

        public function ModelFactory(param1:XML)
        {
            var _loc_4:* = null;
            var _loc_6:* = null;
            var _loc_7:* = null;
            var _loc_8:* = null;
            mappingArguments= new com.pactera.edg.am.kpi.mapping.Arguments();
            dataMapping = new Data();
            modelViewArgument = new ModelViewArgument();
            nodeMapping = new Node();
            viewMapping = new View();
            imageMapping = new com.pactera.edg.am.kpi.mapping.Image();
            var _loc_2:* = ExternalInterface.call("getAnalysType");
            var _loc_3:* = param1.elements("view");
            for each (_loc_4 in _loc_3)
            {
                
                if (_loc_4.@name == _loc_2)
                {
                    this.xml = _loc_4[0];
                    break;
                }
            }
            if (this.xml == null)
            {
                return;
            }
            var _loc_5:* = this.xml.modelMapping[0];
            this.classMapping = new Object();
            for each (_loc_6 in _loc_5.model)
            {
                
                _loc_7 = _loc_6.@modelName;
                this.classMapping[_loc_7.toLowerCase()] = _loc_6;
            }
            _loc_5 = this.xml.lineMapping[0];
            this.lineMapping = new Object();
            for each (_loc_6 in _loc_5.line)
            {
                
                _loc_8 = _loc_6.@id;
                this.lineMapping[_loc_8.toLowerCase()] = _loc_6;
            }
            _loc_5 = this.xml.argumentsMapping[0];
            this.setArguments(_loc_5);
            _loc_5 = this.xml.dataMapping[0];
            this.setDataMapping(_loc_5);
            _loc_5 = this.xml.modelArgumentMapping[0];
            this.setModelViewArgument(_loc_5);
            _loc_5 = this.xml.nodeMapping[0];
            this.setNodeMapping(_loc_5);
            _loc_5 = this.xml.viewMapping[0];
            this.setViewMapping(_loc_5);
            _loc_5 = this.xml.imageMapping[0];
            this.setImageMapping(_loc_5);
            return;
        }// end function

        public function getViewMapping() : View
        {
            return this.viewMapping;
        }// end function

        private function getFunction(param1:XML) : Function
        {
            var _loc_2:* = null;
            var _loc_3:* = null;
            var _loc_4:* = null;
            if (param1.@handler != null && param1.@handler != "")
            {
                _loc_3 = getDefinitionByName(param1.@handler) as Class;
                _loc_4 = new _loc_3;
            }
            else
            {
                return this.handler;
            }
            return _loc_4[param1.@funcName];
        }// end function

        public function setDataMapping(param1:XML) : void
        {
            this.dataMapping.argumentsfunc = param1.method.@argumentsfunc;
            this.dataMapping.initfunc = param1.method.@initfunc;
            this.dataMapping.subdatafunc = param1.method.@subdatafunc;
            this.dataMapping.typename = param1.type.@name;
            this.dataMapping.url = param1.type.@url;
            return;
        }// end function

        public function factory(param1:XML, param2:DisplayElement) : DisplayElement
        {
            var _loc_15:* = null;
            var _loc_16:* = 0;
            var _loc_17:* = 0;
            var _loc_18:* = null;
            var _loc_19:* = null;
            var _loc_20:* = null;
            var _loc_21:* = null;
            var _loc_22:* = null;
            var _loc_23:* = null;
            var _loc_24:* = null;
            register = new Register();
            var _loc_3:* = new ModelContainer();
            var _loc_4:* = this.getNodeMapping().mdmodelcode;
            var _loc_5:* = param1.attribute(_loc_4);
            var _loc_6:* = this.getDefinition(_loc_5.toLowerCase());
            var _loc_7:* = getDefinitionByName(_loc_6.@modelClass) as Class;
            var _loc_8:* = new _loc_7;
            _loc_8.icon = _loc_6.@icon;
            _loc_8.imageIcon = _loc_6.@image;
            _loc_4 = this.getNodeMapping().mdid;
            _loc_8.id = param1.attribute(_loc_4);
            _loc_8.modelId = param1.attribute(_loc_4);
            _loc_4 = this.getNodeMapping().mdmodelcode;
            _loc_8.modelType = param1.attribute(_loc_4);
            _loc_4 = this.getNodeMapping().mdcolor;
            _loc_8.color = param1.attribute(_loc_4);
            _loc_4 = this.getNodeMapping().mdcode;
            _loc_8.mdcode = param1.attribute(_loc_4);
            _loc_4 = this.getNodeMapping().mdtype;
            _loc_8.mdtype = param1.attribute(_loc_4);
            _loc_4 = this.getNodeMapping().mdqid;
            _loc_8.mdqid = param1.attribute(_loc_4);
            var _loc_9:* = _loc_6.@modelClass;
            var _loc_10:* = _loc_9.toString().split(".");
            _loc_8.modelClass = _loc_10[4];
            _loc_4 = this.getNodeMapping().mdname;
            _loc_8.mdname = param1.attribute(_loc_4);
            var _loc_11:* = "";
            var _loc_12:* = 0;
            if (this.getNodeMapping().view.length > 0)
            {
                for each (_loc_4 in this.getNodeMapping().view)
                {
                    
                    _loc_15 = param1.attribute(_loc_4);
                    _loc_16 = 0;
                    _loc_17 = 0;
                    while (_loc_16 < _loc_15.length)
                    {
                        
                        _loc_18 = /^[A-Za-z0-9]+$/;
                        if (_loc_18.test(_loc_15.charAt(_loc_16)))
                        {
                            _loc_12 = _loc_12 + 8;
                            _loc_17++;
                        }
                        else
                        {
                            _loc_12 = _loc_12 + 12;
                        }
                        _loc_16++;
                    }
                    if (_loc_17 % 2 == 1)
                    {
                        _loc_12 = _loc_12 + 6;
                    }
                    _loc_11 = _loc_11 + (param1.attribute(_loc_4) + " | ");
                    _loc_12 = _loc_12 + 8;
                }
                _loc_11 = _loc_11.substring(0, _loc_11.length - 3);
                _loc_12 = _loc_12 - 8;
            }
            else
            {
                _loc_15 = param1.attribute(_loc_4);
                _loc_16 = 0;
                _loc_17 = 0;
                while (_loc_16 < _loc_15.length)
                {
                    
                    if (_loc_18.test(_loc_15.charAt(_loc_16)))
                    {
                        _loc_12 = _loc_12 + 8;
                        _loc_17++;
                    }
                    else
                    {
                        _loc_12 = _loc_12 + 12;
                    }
                    _loc_16++;
                }
                if (_loc_17 % 2 == 1)
                {
                    _loc_12 = _loc_12 + 6;
                }
                _loc_11 = param1.attribute(_loc_4);
            }
            _loc_8.modelName = _loc_11;
            _loc_4 = this.getNodeMapping().mdtip;
            _loc_8.modelTip = param1.attribute(_loc_4);
            _loc_8.parentmodel = param2;
            var _loc_13:* = _loc_8.createTextField();
            _loc_13.text = _loc_11;
            _loc_8.defaultModelWidth = 30 + _loc_12;
            _loc_8.defaultModelHeight = _loc_13.textHeight + 10;
            _loc_8.isOpen = false;
            _loc_8.container = _loc_3;
            _loc_8.modelView = this.canvas;
            _loc_8.modelGrid = this.modelGrid;
            _loc_8.factory = this;
            _loc_8.contextMenu = new ContextMenu();
            _loc_8.contextMenu.hideBuiltInItems();
			trace("_loc_6.@gridClass :"+_loc_6.@gridClass);
            if (_loc_6.@gridClass != null && _loc_6.@gridClass != "")
            {
                _loc_19 = getDefinitionByName(_loc_6.@gridClass) as Class;
                _loc_20 = new _loc_19;
                _loc_8.setgrid = _loc_20;
            }
            if (_loc_6.@extender != null && _loc_6.@extender != "")
            {
                _loc_21 = getDefinitionByName(_loc_6.@extender) as Class;
                _loc_22 = new _loc_21;
                _loc_8.extensible = _loc_22;
                _loc_22.container = _loc_3;
            }
            if (_loc_6.@dragger != null && _loc_6.@dragger != "")
            {
                _loc_23 = getDefinitionByName(_loc_6.@dragger) as Class;
                _loc_24 = new _loc_23;
                _loc_8.draggable = _loc_24;
                _loc_24.model = _loc_8;
                _loc_24.canvas = this.canvas;
            }
            _loc_8.menubarXML = _loc_6.contextMenu[0];
            _loc_4 = this.getNodeMapping().chartnode;
            var _loc_14:* = param1.elements(_loc_4)[0];
            if (_loc_14 != null)
            {
                _loc_8.chartXML = _loc_14;
                _loc_4 = this.getNodeMapping().chartClass;
                _loc_8.chartClass = _loc_14.attribute(_loc_4);
            }
            return _loc_8;
        }// end function

        public function get modelGrid() : ModelGrid
        {
            return this._modelGrid;
        }// end function

        private function handler(event:ContextMenuEvent) : void
        {
            trace("Undefined");
            Alert.show("Undefined");
            return;
        }// end function

        public function set canvas(param1:ModelView) : void
        {
            this._canvas = param1;
            return;
        }// end function

        public function setArguments(param1:XML) : void
        {
            this.mappingArguments.title = param1.@title;
            this.mappingArguments.rowCount = param1.@rowCount;
            if (param1.@istrue == "true")
            {
                this.mappingArguments.istrue = true;
            }
            else
            {
                this.mappingArguments.istrue = false;
            }
            this.mappingArguments.headMdcode = param1.head.@mdcode;
            this.mappingArguments.headMdid = param1.head.@mdid;
            this.mappingArguments.headNode = param1.head.@node;
            this.mappingArguments.headTitle = param1.head.@title;
            this.mappingArguments.headTitleCode = param1.head.@titleCode;
            this.mappingArguments.attributesAttname = param1.attributes.@attname;
            this.mappingArguments.attributesAttnameCode = param1.attributes.@attnameCode;
            this.mappingArguments.attributesAttvalue = param1.attributes.@attvalue;
            this.mappingArguments.attributesAttvalueCode = param1.attributes.@attvalueCode;
            this.mappingArguments.attributesRoot = param1.attributes.@root;
            return;
        }// end function

        public function getDataMapping() : Data
        {
            return this.dataMapping;
        }// end function

        public function getModelViewArgument() : ModelViewArgument
        {
            return this.modelViewArgument;
        }// end function

        public function set modelGrid(param1:ModelGrid) : void
        {
            this._modelGrid = param1;
            return;
        }// end function

        public function get canvas() : ModelView
        {
            return this._canvas;
        }// end function

        public function setModelViewArgument(param1:XML) : void
        {
            var _loc_3:* = null;
            var _loc_4:* = 0;
            this.modelViewArgument.defaultFillColor = param1.@defaultFillColor;
            this.modelViewArgument.defaultRimColor = param1.@defaultRimColor;
            this.modelViewArgument.fillColor = param1.@fillColor;
            this.modelViewArgument.focusInFill = param1.focusEventInHandler.@fillColor;
            this.modelViewArgument.focusInRim = param1.focusEventInHandler.@rimColor;
            this.modelViewArgument.focusOutFill = param1.focusEventOutHandler.@fillColor;
            this.modelViewArgument.focusOutRim = param1.focusEventOutHandler.@rimColor;
            this.modelViewArgument.fromLineColor = param1.mouseClickHandler.fromLine.@lineColor;
            this.modelViewArgument.fromModelFill = param1.mouseClickHandler.fromModel.@fillColor;
            this.modelViewArgument.fromModelRim = param1.mouseClickHandler.fromModel.@rimColor;
            this.modelViewArgument.mouseClickFill = param1.mouseClickHandler.@fillColor;
            this.modelViewArgument.mouseClickRim = param1.mouseClickHandler.@rimColor;
            this.modelViewArgument.mouseOutFill = param1.mouseOutHandler.@fillColor;
            this.modelViewArgument.mouseOutRim = param1.mouseOutHandler.@rimColor;
            this.modelViewArgument.mouseOutClickFill = param1.mouseOutHandler.@isClickFill;
            this.modelViewArgument.mouseOutClickRim = param1.mouseOutHandler.@isClickRim;
            this.modelViewArgument.messageColor = param1.@messageColor;
            this.modelViewArgument.mouseOverFill = param1.mouseOverHandler.@fillColor;
            this.modelViewArgument.mouseOverRim = param1.mouseOverHandler.@rimColor;
            this.modelViewArgument.mouseOverClickFill = param1.mouseOverHandler.@isClickFill;
            this.modelViewArgument.mouseOverClickRim = param1.mouseOverHandler.@isClickRim;
            this.modelViewArgument.toLineColor = param1.mouseClickHandler.toLine.@lineColor;
            this.modelViewArgument.toModelFill = param1.mouseClickHandler.toModel.@fillColor;
            this.modelViewArgument.toModelRim = param1.mouseClickHandler.toModel.@rimColor;
            this.modelViewArgument.rimColor = param1.@rimColor;
            this.modelViewArgument.lineColor = param1.@lineColor;
            var _loc_2:* = [];
            for each (_loc_3 in param1.customization)
            {
                
                _loc_4 = _loc_3.@color;
                _loc_2.push(_loc_4);
            }
            this.modelViewArgument.customization = _loc_2;
            return;
        }// end function

        public function getlineMapping() : Object
        {
            return this.lineMapping;
        }// end function

        public function getArguments() : Arguments
        {
            return this.mappingArguments;
        }// end function

        public function setNodeMapping(param1:XML) : void
        {
            var _loc_3:* = null;
            var _loc_4:* = null;
            this.nodeMapping.frommdid = param1.transformer.@frommdid;
            this.nodeMapping.headnode = param1.head.@node;
            this.nodeMapping.mdanalystyle = param1.head.@mdanalystyle;
            this.nodeMapping.mdcode = param1.node.@mdcode;
            this.nodeMapping.mdid = param1.node.@mdid;
            this.nodeMapping.mdqid = param1.node.@mdqid;
            this.nodeMapping.mdmodelcode = param1.node.@mdmodelcode;
            this.nodeMapping.mdname = param1.node.@mdname;
            this.nodeMapping.nodenode = param1.node.@node;
            this.nodeMapping.mdtip = param1.node.@mdtip;
            this.nodeMapping.mdcolor = param1.node.@mdcolor;
            this.nodeMapping.mdtype = param1.node.@mdtype;
            this.nodeMapping.refnode = param1.refmapping.@node;
            this.nodeMapping.srcmdid = param1.refmapping.@srcmdid;
            this.nodeMapping.targetmdid = param1.refmapping.@targetmdid;
            this.nodeMapping.tomdid = param1.transformer.@tomdid;
            this.nodeMapping.transnode = param1.transformer.@node;
            this.nodeMapping.viewid = param1.head.@viewid;
            this.nodeMapping.viewname = param1.head.@viewname;
            this.nodeMapping.fromstyle = param1.transformer.@fromstyle;
            this.nodeMapping.tostyle = param1.transformer.@tostyle;
            this.nodeMapping.srcstyle = param1.refmapping.@srcstyle;
            this.nodeMapping.targetstyle = param1.refmapping.@targetstyle;
            this.nodeMapping.transtypeid = param1.transformer.@transtypeid;
            this.nodeMapping.reftypeid = param1.refmapping.@reftypeid;
            this.nodeMapping.categoryfield = param1.chart.@categoryfield;
            this.nodeMapping.categoryvalue = param1.chart.@categoryvalue;
            this.nodeMapping.chartClass = param1.chart.@chartClass;
            this.nodeMapping.dataname = param1.chart.@dataname;
            this.nodeMapping.datavalue = param1.chart.@datavalue;
            this.nodeMapping.chartnode = param1.chart.@node;
            this.nodeMapping.data = param1.chart.@data;
            this.nodeMapping.chartdata = param1.chart.@chartdata;
            var _loc_2:* = [];
            for each (_loc_3 in param1.view)
            {
                
                _loc_4 = _loc_3.@node;
                _loc_2.push(_loc_4);
            }
            this.nodeMapping.view = _loc_2;
            return;
        }// end function

        private function getDefinition(param1:String) : XML
        {
            return this.classMapping[param1];
        }// end function

        public function getImageMapping() : com.pactera.edg.am.kpi.mapping.Image
        {
            return this.imageMapping;
        }// end function

        public function setImageMapping(param1:XML) : void
        {
            this.imageMapping.zoomin = param1.zoomin.@url;
            this.imageMapping.zoomout = param1.zoomout.@url;
            this.imageMapping.print = param1.print.@url;
            this.imageMapping.help = param1.help.@url;
            return;
        }// end function

        public function getNodeMapping() : Node
        {
            return this.nodeMapping;
        }// end function

        public function setViewMapping(param1:XML) : void
        {
            var _loc_3:* = null;
            var _loc_4:* = null;
            var _loc_2:* = [];
            for each (_loc_3 in param1.viewName)
            {
                
                _loc_4 = _loc_3.@node;
                _loc_2.push(_loc_4);
            }
            this.viewMapping.viewName = _loc_2;
            if (param1.isOpen.@value == "true")
            {
                this.viewMapping.isOpen = true;
            }
            else
            {
                this.viewMapping.isOpen = false;
            }
            if (param1.isImage.@value == "true")
            {
                this.viewMapping.isImage = true;
            }
            else
            {
                this.viewMapping.isImage = false;
            }
            this.viewMapping.width = param1.width.@value;
            this.viewMapping.height = param1.height.@value;
            return;
        }// end function

    }
}
