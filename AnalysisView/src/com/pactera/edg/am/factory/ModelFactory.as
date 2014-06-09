package com.pactera.edg.am.factory
{
	import com.pactera.edg.am.mapping.Image;
    import com.pactera.edg.am.mapping.*;
    import com.pactera.edg.am.view.*;
    import com.pactera.edg.am.view.extender.*;
    import com.pactera.edg.am.view.grid.*;
    import com.pactera.edg.am.view.handler.*;
    import com.pactera.edg.am.view.model.*;
    
    import flash.events.*;
    import flash.external.*;
    import flash.utils.*;
    
    import mx.controls.*;

    public class ModelFactory extends Object
    {
        private var imageMapping:com.pactera.edg.am.mapping.Image;
        private var dataMapping:Data;
        private var _isDebug:Boolean = false;
        private var definedXml:XML;
        private var _analysisType:String = "";
        private var register:Register;
        private var _analysisModelId:String = "";
        private var viewMapping:View;
        private var nodeMapping:Node;
        private var classMapping:Object;
        private var _canvas:ModelView;
        private var _detailInfoWin:CustomPopUpWin;
		private static const defaultColorProperty:ColorProperty=new ColorProperty();
		
		
        public function ModelFactory(param1:XML)
        {
			//trace("ModelFactory create ...");
            var _loc_3:XML = null;
            var _loc_5:XML = null;
            var _loc_6:String = null;
            this.dataMapping = new Data();
            this.nodeMapping = new Node();
            this.viewMapping = new View();
            this.imageMapping = new com.pactera.edg.am.mapping.Image();
            if (param1.hasOwnProperty("debug") || param1.@debug.toString() != "")
            {
                if (param1.@debug == "false")
                {
                    this._isDebug = false;
                }
                else
                {
                    this._isDebug = true;
                }
            }
            if (this._isDebug)
            {
                this.analysisType = "1";
                this.analysisModelId = "2c9326842bfb03d2012bfb15b0f50001";
            }
            else
            {
                this.analysisType = ExternalInterface.call("getAnalysType");
                this.analysisModelId = ExternalInterface.call("getId");
            }
            var _loc_2:* = param1.elements("view");
            for each (_loc_3 in _loc_2)
            {
                
                if (_loc_3.@name == this.analysisType)
                {
                    this.definedXml = _loc_3[0];
                    break;
                }
            }
            if (this.definedXml == null)
            {
                return;
            }
//            trace("\n\n\n\n\n--------definedXml----------");
//            trace(this.definedXml);
//            trace("-\n\n\n\n\n");
            var _loc_4:* = this.definedXml.modelMapping[0];
			/*
<modelMapping>
  <webservices wsdl="/mm/services/analyse?wsdl"/>
  <model modelName="PxAggregator" modelColor="0xE2EBFE" icon="../images/metamodel/PxAggregator.gif" gridClass="com.pactera.edg.am.view.grid.OpenGrid" modelClass="com.pactera.edg.am.view.model.CombinationModel" extender="com.pactera.edg.am.view.extender.CombinationModelExtender" dragger="com.pactera.edg.am.view.dragger.ModelDragger" renderer="com.pactera.edg.am.view.renderer.CombinationModelRenderer"/>
  <model modelName="PxChangeApply" modelColor="0xE2EBFE" icon="../images/metamodel/PxChangeApply.gif" gridClass="com.pactera.edg.am.view.grid.OpenGrid" modelClass="com.pactera.edg.am.view.model.CombinationModel" extender="com.pactera.edg.am.view.extender.CombinationModelExtender" dragger="com.pactera.edg.am.view.dragger.ModelDragger" renderer="com.pactera.edg.am.view.renderer.CombinationModelRenderer"/>
...
</modelMapping>
			 */
            this.classMapping = new Object();
            for each (_loc_5 in _loc_4.model)
            {
                
                _loc_6 = _loc_5.@modelName;
                this.classMapping[_loc_6.toLowerCase()] = _loc_5;
            }
            
            //zzg 2011-12-13 
            //考虑到子节点较多的情况下需要临时隐藏部分数据，增加"getmoreModel"的特殊mapping
            this.classMapping["GfGetMore".toLowerCase()] = new XML("<model " + 
            		"modelName=\"GfGetMore\" " + 
            		"modelColor=\"0xE2EB00\" " + 
            		//zzg 2011-12-14 暂时不启用图标，系统将使用"默认加号"
            		//"icon=\"../images/metamodel/getMore.gif\" " + 
            		"gridClass=\"com.pactera.edg.am.view.grid.OpenGrid\" " + 
            		"modelClass=\"com.pactera.edg.am.view.model.GetMoreModel\" " + 
            		"extender=\"com.pactera.edg.am.view.extender.GetMoreModelExtender\" " + 
            		"dragger=\"com.pactera.edg.am.view.dragger.ModelDragger\" " + 
            		"renderer=\"com.pactera.edg.am.view.renderer.GetMoreModelRenderer\"/>");
            //数据获取来源
            /*
  <dataMapping>
    <type name="webservice" url="../services/analyse?wsdl"/>
    <method initfunc="getImpact" subdatafunc="getSubNodes" argumentsfunc="getNodeAttributes" filtercond="getFilterCondition" filterfunc="getFilterImpact"/>
  </dataMapping>
            */
            _loc_4 = this.definedXml.dataMapping[0];
            this.setDataMapping(_loc_4);
            //节点映射信息
            /*
  <nodeMapping>
    <head node="head" mdanalystyle="mdanalystyle" mdid="mdid" mdcode="mdcode" mdname="mdname" mdmodelcode="mdmodelcode" sessionid="sessionid"/>
    <node node="nodes.node" mdid="mdid" nodeId="id" mdcode="mdcode" mdname="mdname" mdmodelcode="mdmodelcode" mdtip="mdcode" mdlocation="mdlocation" layer="layer" mdmodelname="mdmodelname"/>
    <transformer node="transformers.transformer" frommdid="fromid" tomdid="toid"/>
    <refmapping node="refmappings.refmapping" srcmdid="srcid" targetmdid="targetid"/>
    <view node="mdname"/>
  </nodeMapping> 
            */
            _loc_4 = this.definedXml.nodeMapping[0];
            this.setNodeMapping(_loc_4);
            /*
 <viewMapping>
    <viewName node="head.mdanalystyle"/>
    <isOpen value="false"/>
    <isImage value="true"/>
    <width value="700"/>
    <height value="650"/>
  </viewMapping> 
            */
            _loc_4 = this.definedXml.viewMapping[0];
            this.setViewMapping(_loc_4);
            
            /*
<imageMapping>
    <zoomin url="../images/icons/zoom_out.png"/>
    <zoomout url="../images/icons/zoom_in.png"/>
    <print url="../images/icons/print.gif"/>
    <help url="../images/icons/help.png"/>
    <tour url="../images/icons/tour.png"/>
    <export url="../images/icons/exporter.gif"/>
    <search url="../images/icons/search.gif"/>
    <fullScreen url="../images/icons/arrow_out.png"/>
    <normalScreen url="../images/icons/arrow_in.png"/>
  </imageMapping> 
            */
            _loc_4 = this.definedXml.imageMapping[0];
            this.setImageMapping(_loc_4);
			//trace("ModelFactory create ok ...");
            return;
        }// end function

        private function handler(event:ContextMenuEvent) : void
        {
            trace("Undefined");
            Alert.show("Undefined");
            return;
        }// end function

        public function get analysisType() : String
        {
            return this._analysisType;
        }// end function

        private function getFunction(param1:XML) : Function
        {
            var _loc_2:CombinationModelHandler = null;
            var _loc_3:Class = null;
            var _loc_4:Object = null;
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

        public function get isDebug() : Boolean
        {
            return this._isDebug;
        }// end function

        public function set analysisModelId(param1:String) : void
        {
            this._analysisModelId = param1;
            return;
        }// end function

        public function setDataMapping(param1:XML) : void
        {
            this.dataMapping.initfunc = param1.method.@initfunc;
            this.dataMapping.subdatafunc = param1.method.@subdatafunc;
            this.dataMapping.filterfunc = param1.method.@filterfunc;
            this.dataMapping.filterCondition = param1.method.@filtercond;
            this.dataMapping.typename = param1.type.@name;
            this.dataMapping.url = param1.type.@url;
            return;
        }// end function

        public function getDataMapping() : Data
        {
            return this.dataMapping;
        }// end function

        public function get canvas() : ModelView
        {
            return this._canvas;
        }// end function

        public function getViewMapping() : View
        {
            return this.viewMapping;
        }// end function

        public function set isDebug(param1:Boolean) : void
        {
            this._isDebug = param1;
            return;
        }// end function

       //创建node实例
       //nodeXml-->nodeModel
       //zzg 2011-12-13
       //本函数的注释例子，以以下节点为参考
       //
       //    <node id="n0" mdid="vd2eea15710f4f2a9a85c4d6dfde8250" mdcode="CD0002" mdname="行政区域代码" mdmodelcode="GfCommonCode" mdmodelname="GfCommonCode" mdlocation="/数据标准/基础">
        public function factory(nodeXml:XML, param2:DisplayElement) : DisplayElement
        {
            var gridClass:Class = null;
            var gridInstance:Grid = null;
            var extender:Class = null;
            var extenderInstance:IExtendBehavior = null;
            this.register = new Register();
            //this.getNodeMapping().mdmodelcode的值为“mdmodelcode”
            var mdmodelcodeMapping:* = this.getNodeMapping().mdmodelcode;
            //    <node id="n0" mdid="vd2eea15710f4f2a9a85c4d6dfde8250" mdcode="CD0002" mdname="行政区域代码" mdmodelcode="GfCommonCode" mdmodelname="GfCommonCode" mdlocation="/数据标准/基础">
            //在广发项目，这里为mdmodelcode="GfCommonCode"
            var mdmodelcode:* = nodeXml.attribute(mdmodelcodeMapping);
            //在广发项目，this.getDefinition(mdmodelcode.toLowerCase())由以下配置决定
            //    <model modelName="GfCommonCode" modelColor="0xE2EBFE" icon="../images/metamodel/Code.gif" gridClass="com.pactera.edg.am.view.grid.OpenGrid" modelClass="com.pactera.edg.am.view.model.CombinationModel" extender="com.pactera.edg.am.view.extender.CombinationModelExtender" dragger="com.pactera.edg.am.view.dragger.ModelDragger" renderer="com.pactera.edg.am.view.renderer.CombinationModelRenderer"/>
            var modelMappingXml:* = this.getDefinition(mdmodelcode.toLowerCase());
            //从model定义xml中，容易知道
            //modelMappingXml.@modelClass为com.pactera.edg.am.view.model.CombinationModel
            trace("modelMappingXml.@modelClass:"+(modelMappingXml.@modelClass));
            var modelClass:* = getDefinitionByName(modelMappingXml.@modelClass) as Class;
            var modelInstance:* = new (modelClass)();
            modelInstance.detailInfoWin = this.detailInfoWin;
            modelInstance.icon = modelMappingXml.@icon;
          
            mdmodelcodeMapping = this.getNodeMapping().nodeId;
            modelInstance.id = nodeXml.attribute(mdmodelcodeMapping);
            modelInstance.nodeId = nodeXml.attribute(mdmodelcodeMapping);
            mdmodelcodeMapping = this.getNodeMapping().mdid;
            modelInstance.modelId = nodeXml.attribute(mdmodelcodeMapping);
            mdmodelcodeMapping = this.getNodeMapping().mdmodelcode;
            modelInstance.modelType = nodeXml.attribute(mdmodelcodeMapping);
            mdmodelcodeMapping = this.getNodeMapping().mdmodelname;
            modelInstance.mdmodelName = nodeXml.attribute(mdmodelcodeMapping);
            mdmodelcodeMapping = this.getNodeMapping().mdcode;
            modelInstance.mdcode = nodeXml.attribute(mdmodelcodeMapping);
            mdmodelcodeMapping = this.getNodeMapping().mdlocation;
            modelInstance.mdlocation = nodeXml.attribute(mdmodelcodeMapping);
            mdmodelcodeMapping = this.getNodeMapping().mdStatus;
            modelInstance.mdStatus = nodeXml.attribute(mdmodelcodeMapping);
            modelInstance.defineColor = this.setDefineColor(modelInstance.mdStatus, modelMappingXml.@modelColor);
            modelInstance.sequence = Number(nodeXml.attribute(this.getNodeMapping().layer));
            mdmodelcodeMapping = this.getNodeMapping().mdname;
            modelInstance.mdname = nodeXml.attribute(mdmodelcodeMapping);
            modelInstance.modelName = nodeXml.attribute(mdmodelcodeMapping);
            modelInstance.bisAnalysicLinkModel = false;
            modelInstance.parentmodel = param2;
            modelInstance.modelView = this.canvas;
            modelInstance.factory = this;
            if (modelMappingXml.@gridClass != null && modelMappingXml.@gridClass != "")
            {
            	//广发项目，modelMappingXml.@gridClass值为“com.pactera.edg.am.view.grid.OpenGrid”
                gridClass = getDefinitionByName(modelMappingXml.@gridClass) as Class;
                gridInstance = new gridClass;
                modelInstance.setgrid = gridInstance;
            }
            if (modelMappingXml.@extender != null && modelMappingXml.@extender != "")
            {
            	//广发项目，modelMappingXml.@extender的值为"com.pactera.edg.am.view.extender.CombinationModelExtender"
                extender = getDefinitionByName(modelMappingXml.@extender) as Class;
                extenderInstance = new extender;
                modelInstance.extensible = extenderInstance;
            }
            return modelInstance;
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

        public function get analysisModelId() : String
        {
            return this._analysisModelId;
        }// end function

        private function getDefinition(param1:String) : XML
        {
            return this.classMapping[param1];
        }// end function

        private function setDefineColor(param1:String, param2:uint) : uint
        {
            var _loc_3:* = ExternalInterface.call("getAnalysType");
            if (_loc_3 == "7")
            {
                param1 = param1.toLocaleLowerCase();
                if (defaultColorProperty.etlBackgroudColorTypeObject[param1] != null)
                {
                    param2 = defaultColorProperty.etlBackgroudColorTypeObject[param1];
                }
            }
            return param2;
        }// end function

        public function getNodeMapping() : Node
        {
            return this.nodeMapping;
        }// end function

        public function setNodeMapping(param1:XML) : void
        {
        	//    <head node="head" mdid="mdid" mdcode="mdcode" title="元数据：" titleCode="mdcode"/>
            this.nodeMapping.headnode = param1.head.@node;//head
            this.nodeMapping.mdanalystyle = param1.head.@mdanalystyle;
            this.nodeMapping.sessionid = param1.head.@sessionid;
            
            this.nodeMapping.mdcode = param1.node.@mdcode;
            this.nodeMapping.mdid = param1.node.@mdid;
            this.nodeMapping.mdmodelcode = param1.node.@mdmodelcode;
            this.nodeMapping.mdmodelname = param1.node.@mdmodelname;
            this.nodeMapping.mdname = param1.node.@mdname;
            this.nodeMapping.nodenode = param1.node.@node;
            this.nodeMapping.mdlocation = param1.node.@mdlocation;
            this.nodeMapping.mdStatus = param1.node.@mdStatus;
            this.nodeMapping.layer = param1.node.@layer;
              //    <node node="nodes.node" mdid="mdid" nodeId="id" mdcode="mdcode" mdname="mdname" mdmodelcode="mdmodelcode" mdtip="mdcode" mdlocation="mdlocation" layer="layer" mdmodelname="mdmodelname"/>
            this.nodeMapping.nodeId = param1.node.@nodeId; //nodeId="id"
            //    <transformer node="transformers.transformer" frommdid="fromid" tomdid="toid"/>
            this.nodeMapping.transnode = param1.transformer.@node;
            this.nodeMapping.frommdid = param1.transformer.@frommdid;
            this.nodeMapping.tomdid = param1.transformer.@tomdid;
            this.nodeMapping.transtypeid = param1.transformer.@transtypeid;
            this.nodeMapping.fromstyle = param1.transformer.@fromstyle;
            this.nodeMapping.tostyle = param1.transformer.@tostyle;
            
            this.nodeMapping.refnode = param1.refmapping.@node;
            this.nodeMapping.srcmdid = param1.refmapping.@srcmdid;
            this.nodeMapping.targetmdid = param1.refmapping.@targetmdid;
            return;
        }// end function

        public function setImageMapping(param1:XML) : void
        {
            this.imageMapping.zoomin = param1.zoomin.@url;
            this.imageMapping.zoomout = param1.zoomout.@url;
            this.imageMapping.print = param1.print.@url;
            this.imageMapping.tour = param1.tour.@url;
            this.imageMapping.export = param1.export.@url;
            this.imageMapping.search = param1.search.@url;
            this.imageMapping.fullScreen = param1.fullScreen.@url;
            this.imageMapping.normalScreen = param1.normalScreen.@url;
            return;
        }// end function

        public function getImageMapping() : com.pactera.edg.am.mapping.Image
        {
            return this.imageMapping;
        }// end function

        public function set detailInfoWin(param1:CustomPopUpWin) : void
        {
            this._detailInfoWin = param1;
            return;
        }// end function

        public function set analysisType(param1:String) : void
        {
            this._analysisType = param1;
            return;
        }// end function

        public function get detailInfoWin() : CustomPopUpWin
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
