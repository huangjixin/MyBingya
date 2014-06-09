package com.pactera.edg.am.dmv.factory
{
    import com.pactera.edg.am.dmv.mapping.*;
    import com.pactera.edg.am.dmv.view.*;
    import com.pactera.edg.am.dmv.view.extender.*;
    import com.pactera.edg.am.dmv.view.grid.*;
    import com.pactera.edg.am.dmv.view.handler.*;
    import com.pactera.edg.am.dmv.view.model.*;
    
    import flash.events.*;
    import flash.external.*;
    import flash.utils.*;
    
    import mx.controls.*;
    

    public class ModelFactory
    {
        private var imageMapping:com.pactera.edg.am.dmv.mapping.Image;
        private var dataMapping:Data;
        private var _isDebug:Boolean = false;
        private var xml:XML;
        private var register:Register;
        private var viewMapping:View;
        private var _dataMapType:String;
        private var nodeMapping:Node;
        private var classMapping:Object;
        private var _canvas:ModelView;
        private var _detailInfoWin:MyCustomPopUpWin;

        public function ModelFactory(param1:XML)
        {
            var _loc_4:XML = null;
            var _loc_6:XML = null;
            var _loc_7:String = null;
            dataMapping = new Data();
            nodeMapping = new Node();
            viewMapping = new View();
            imageMapping = new com.pactera.edg.am.dmv.mapping.Image();
            var _loc_2:String = "datamap";
            _dataMapType = ExternalInterface.call("getDmtype");
            if (param1.hasOwnProperty("debug") || param1.@debug.toString() != "")
            {
                if (param1.@debug == "false")
                {
                    _isDebug = false;
                }
                else
                {
                    _isDebug = true;
                }
            }
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
            _loc_5 = this.xml.dataMapping[0];
            this.setDataMapping(_loc_5);
            _loc_5 = this.xml.nodeMapping[0];
            this.setNodeMapping(_loc_5);
            _loc_5 = this.xml.viewMapping[0];
            this.setViewMapping(_loc_5);
            _loc_5 = this.xml.imageMapping[0];
            this.setImageMapping(_loc_5);
            return;
        }// end function

        private function handler(event:ContextMenuEvent) : void
        {
            trace("Undefined");
            Alert.show("Undefined");
            return;
        }// end function

        public function getNodeMapping() : Node
        {
            return this.nodeMapping;
        }// end function

        public function get isDebug() : Boolean
        {
            return _isDebug;
        }// end function

        public function setImageMapping(param1:XML) : void
        {
            this.imageMapping.zoomin = param1.zoomin.@url;
            this.imageMapping.zoomout = param1.zoomout.@url;
            this.imageMapping.fullScreen = param1.fullScreen.@url;
            this.imageMapping.normalScreen = param1.normalScreen.@url;
            return;
        }// end function

        public function getDataMapping() : Data
        {
            return this.dataMapping;
        }// end function

        private function getDefinition(param1:String) : XML
        {
            return this.classMapping[param1];
        }// end function

        public function setDataMapping(param1:XML) : void
        {
            this.dataMapping.initfunc = param1.method.@initfunc;
            this.dataMapping.tipfunc = param1.method.@tipfunc;
            this.dataMapping.subdatafunc = param1.method.@subdatafunc;
            this.dataMapping.savefunc = param1.method.@savefunc;
            this.dataMapping.initSchemafunc = param1.method.@linedcfunc;
            this.dataMapping.linkNodesfunc = param1.method.@linkNodesfunc;
            this.dataMapping.typename = param1.type.@name;
            this.dataMapping.url = param1.type.@url;
            return;
        }// end function

        public function getViewMapping() : View
        {
            return this.viewMapping;
        }// end function

        public function set isDebug(param1:Boolean) : void
        {
            _isDebug = param1;
            return;
        }// end function

        private function getFunction(param1:XML) : Function
        {
            var _loc_2:CombinationModelHandler = null;
            var _loc_3:Class = null;
            var _loc_4:Object = null;
            if (param1.@handler != null && param1.@handler != "")
            {
                _loc_3 = getVitDefinitionByName(param1.@handler) as Class;
                _loc_4 = new _loc_3;
            }
            else
            {
                return this.handler;
            }
            return _loc_4[param1.@funcName];
        }// end function

        public function get canvas() : ModelView
        {
            return this._canvas;
        }// end function

        public function set dataMapType(param1:String) : void
        {
            this._dataMapType = param1;
            return;
        }// end function

     
        public function getVitDefinitionByName(name:String):Object
        {
        	 var adjustName:String=name.replace("com.pactera.edg.am.","com.pactera.edg.am.dmv.");
        	 trace("getVitDefinitionByName:"+name+"-->"+adjustName);
        	return getDefinitionByName(adjustName);
        }
        public function factory(param1:XML, param2:DisplayElement) : DisplayElement
        {
            var _loc_8:Class = null;
            var _loc_9:Grid = null;
            var _loc_10:Class = null;
            var _loc_11:IExtendBehavior = null;
            var _loc_12:Class = null;
            var _loc_13:CustomContextMenu = null;
            register = new Register();
            var _loc_3:* = this.getNodeMapping().mdmodelcode;
            var _loc_4:* = param1.attribute(_loc_3);
            var _loc_5:* = this.getDefinition(_loc_4.toLowerCase());
           
            var _loc_6:* = getVitDefinitionByName(_loc_5.@modelClass) as Class;
            var _loc_7:* = new (getVitDefinitionByName(_loc_5.@modelClass) as Class)();
            new (getVitDefinitionByName(_loc_5.@modelClass) as Class)().detailInfoWin = this.detailInfoWin;
            _loc_7.typeClass = _loc_5.@typeClass;
            _loc_3 = this.getNodeMapping().mdid;
            _loc_7.id = param1.attribute(_loc_3);
            _loc_7.modelId = param1.attribute(_loc_3);
            _loc_3 = this.getNodeMapping().mdmodelcode;
            _loc_7.modelType = param1.attribute(_loc_3);
            _loc_3 = this.getNodeMapping().mdcode;
            _loc_7.mdcode = param1.attribute(_loc_3);
            _loc_3 = this.getNodeMapping().mdtype;
            _loc_7.mdtype = param1.attribute(_loc_3);
            _loc_3 = this.getNodeMapping().mdname;
            _loc_7.mdname = param1.attribute(_loc_3);
            _loc_7.modelName = param1.attribute(_loc_3);
            _loc_7.parentmodel = param2;
            _loc_7.setIsDashModel(param1.attribute("hasMetaData").toString());
            _loc_7.defaultModelWidth = param1.attribute("width");
            _loc_7.defaultModelHeight = param1.attribute("height");
            _loc_7.xPos = param1.attribute("x");
            _loc_7.yPos = param1.attribute("y");
            _loc_7.isOpen = false;
            _loc_7.isClick = false;
            _loc_7.modelView = this.canvas;
            _loc_7.factory = this;
            _loc_3 = this.getNodeMapping().parentmdid;
            _loc_7.parentmdid = param1.attribute(_loc_3);
            _loc_3 = this.getNodeMapping().parentmdmodel;
            _loc_7.parentmdmodel = param1.attribute(_loc_3);
            if (_loc_5.@gridClass != null && _loc_5.@gridClass != "")
            {
                _loc_8 = getVitDefinitionByName(_loc_5.@gridClass) as Class;
                _loc_9 = new _loc_8;
                _loc_7.setgrid = _loc_9;
            }
            if (_loc_5.@extender != null && _loc_5.@extender != "")
            {
                _loc_10 = getVitDefinitionByName(_loc_5.@extender) as Class;
                _loc_11 = new _loc_10;
                _loc_7.extensible = _loc_11;
            }
            if (_loc_5.@rightMenu != null && _loc_5.@rightMenu != "")
            {
                _loc_12 = getVitDefinitionByName(_loc_5.@rightMenu) as Class;
                _loc_13 = new _loc_12;
                _loc_13.setCanAdd(param1.attribute("add").toString());
                _loc_13.setCanDel(param1.attribute("delete").toString());
                _loc_13.setCanModify(param1.attribute("modify").toString());
                _loc_7.rigthMenu = _loc_13;
                _loc_13.model = _loc_7;
            }
            return _loc_7;
        }// end function

        public function setViewMapping(param1:XML) : void
        {
            var _loc_3:XML = null;
            var _loc_4:String = null;
            var _loc_2:Array = [];
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

        public function setNodeMapping(param1:XML) : void
        {
            this.nodeMapping.frommdid = param1.transformer.@frommdid;
            this.nodeMapping.mdcode = param1.node.@mdcode;
            this.nodeMapping.mdid = param1.node.@mdid;
            this.nodeMapping.mdmodelcode = param1.node.@mdmodelcode;
            this.nodeMapping.mdname = param1.node.@mdname;
            this.nodeMapping.nodenode = param1.node.@node;
            this.nodeMapping.mdcolor = param1.node.@mdcolor;
            this.nodeMapping.mdtype = param1.node.@mdtype;
            this.nodeMapping.tomdid = param1.transformer.@tomdid;
            this.nodeMapping.transnode = param1.transformer.@node;
            this.nodeMapping.transtypeid = param1.transformer.@transtypeid;
            this.nodeMapping.fromstyle = param1.transformer.@fromstyle;
            this.nodeMapping.tostyle = param1.transformer.@tostyle;
            this.nodeMapping.parentmdid = param1.node.@parentmdid;
            this.nodeMapping.parentmdmodel = param1.node.@parentmdmodel;
            return;
        }// end function

        public function getImageMapping() : com.pactera.edg.am.dmv.mapping.Image
        {
            return this.imageMapping;
        }// end function

        public function set detailInfoWin(param1:MyCustomPopUpWin) : void
        {
            this._detailInfoWin = param1;
            return;
        }// end function

        public function get dataMapType() : String
        {
            return this._dataMapType;
        }// end function

        public function get detailInfoWin() : MyCustomPopUpWin
        {
            return this._detailInfoWin;
        }// end function

        public function set canvas(param1:ModelView) : void
        {
            this._canvas = param1;
            return;
        }// end function

    }
}
