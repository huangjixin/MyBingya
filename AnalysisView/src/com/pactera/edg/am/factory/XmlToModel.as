package com.pactera.edg.am.factory
{
    import com.pactera.edg.am.system.*;
    import com.pactera.edg.am.view.*;
    import com.pactera.edg.am.view.line.*;
    import com.pactera.edg.am.view.model.*;

    public class XmlToModel extends Object
    {
        private var factory:ModelFactory;
        private var configxml:XML;
        private var xml:XML;
        private var modelHead:ModelHead;
        private var _modelView:ModelView;
        private var models:Array;
        private var lines:Array;

        public function XmlToModel()
        {
            this.models = [];
            this.lines = [];
            this.modelHead = new ModelHead();
            this.factory = ApplicationConfig.getInstance().modelFactory;
            return;
        }// end function

        public function runXmlToModel(param1:XML) : void
        {
            this.xml = param1;
            this.models = this.buildModel(this.xml, null);
            this.buildLine();
            this.buildModelHead();
            return;
        }// end function

        private function buildSubLine(param1:XML) : void
        {
            var _loc_6:String = null;
            var _loc_7:Style = null;
            var _loc_8:XML = null;
            var _loc_9:Line = null;
            var _loc_10:String = null;
            var _loc_11:String = null;
            var _loc_12:String = null;
            var _loc_13:String = null;
            var _loc_14:DisplayElement = null;
            var _loc_15:DisplayElement = null;
            var _loc_2:* = this.xml;
            var _loc_3:* = ApplicationConfig.getInstance().modelFactory;
            var _loc_4:* = _loc_3.getNodeMapping().transnode.split(".");
            var _loc_5:* = new XMLList();
            for each (_loc_6 in _loc_4)
            {
                
                _loc_5 = _loc_2.elements(_loc_6);
                if (_loc_5.length() <= 0)
                {
                    break;
                }
                _loc_2 = _loc_5[0];
            }
            _loc_7 = new Style();
            for each (_loc_8 in _loc_5)
            {
                
                _loc_9 = new Line();
                _loc_10 = _loc_8.attribute(_loc_3.getNodeMapping().fromstyle);
                _loc_11 = _loc_8.attribute(_loc_3.getNodeMapping().tostyle);
                _loc_7.fromstyle = _loc_10 == "" ? (0) : (parseInt(_loc_10));
                _loc_7.tostyle = _loc_11 == "" ? (1) : (parseInt(_loc_11));
                _loc_7.style = 1;
                _loc_12 = _loc_3.getNodeMapping().frommdid;
                _loc_13 = _loc_3.getNodeMapping().tomdid;
                _loc_14 = this.getModelFromDictionary(_loc_8.attribute(_loc_12).toString());
                _loc_15 = this.getModelFromDictionary(_loc_8.attribute(_loc_13).toString());
                if (_loc_14 == null || _loc_15 == null)
                {
                    continue;
                }
                _loc_9.fromModel = _loc_14;
                _loc_9.toModel = _loc_15;
                _loc_9.style = _loc_7;
                if (this.LineInLines(_loc_9))
                {
                    _loc_9.fromModel.addLine(_loc_9);
                    _loc_9.toModel.addLine(_loc_9);
                    this.lines.push(_loc_9);
                }
            }
            return;
        }// end function

        public function getLines() : Array
        {
            return this.lines;
        }// end function

        private function getModelFromDictionary(param1:String) : DisplayElement
        {
            if (param1 != "")
            {
                return this.modelView.modelsHashMap[param1];
            }
            return null;
        }// end function

        public function runXmlToSubModel(param1:XML, param2:Array, param3:Array,isGetMore:Boolean=false) : void
        {
            this.xml = param1;
            this.models = param2;
            this.lines = param3;
            //zzg 增加isGetMore参数
            this.buildSubModel(this.xml,isGetMore);
            this.buildSubLine(this.xml);
            return;
        }// end function

        private function buildLine() : void
        {
            var _loc_4:String = null;
            var _loc_1:* = this.xml;
            //    <transformer node="transformers.transformer" frommdid="fromid" tomdid="toid"/>
            var mapping:* = this.factory.getNodeMapping().transnode.split(".");//node="transformers.transformer" 
            var transformerXml:* = new XMLList();
            for each (_loc_4 in mapping)
            {
                
                transformerXml = _loc_1.elements(_loc_4);
                if (transformerXml.length() <= 0)
                {
                    break;
                }
                _loc_1 = transformerXml[0];
            }
            this.constructLine(transformerXml, "transformer");
            _loc_1 = this.xml;
            mapping = this.factory.getNodeMapping().refnode.split(".");
            for each (_loc_4 in mapping)
            {
                
                transformerXml = _loc_1.elements(_loc_4);
                if (transformerXml.length() <= 0)
                {
                    break;
                }
                _loc_1 = transformerXml[0];
            }
            this.constructLine(transformerXml, "refmapping");
            return;
        }// end function

        private static var getmoreModelIdSeq:int=0;
        //zzg 2011-12-14 
        //增加一个参数，用于标识是否是加载更多(getMore)
        private function buildSubModel(param1:XML,isGetMore:Boolean=false) : void
        {
            var mapping:String = null;
            var nodeXml:XML = null;
            var nodeId:String = null;
            var nodeDisplayElement:DisplayElement = null;
            //zzg 2011-12-14 隐藏子节点集合
            var hiddenSubNodeXmlString:String="<root><nodes>";
            var subNodeXmlList:XMLList = null;
            var subNodeXml:XML = null;
            var subNodeDisplayElement:DisplayElement = null;
            var _loc_2:Array = [];
             //zzg 2011-12-13 经查 该nodenode为："nodes.node"
            //    <node node="nodes.node" mdid="mdid" nodeId="id" mdcode="mdcode" mdname="mdname" mdmodelcode="mdmodelcode" mdtip="mdcode" mdlocation="mdlocation" layer="layer" mdmodelname="mdmodelname"/>
            // this.factory.getNodeMapping().nodenode指的是node="nodes.node" 的属性值
            var nodeMappingPath:* = this.factory.getNodeMapping().nodenode.split(".");
            var nodesnodeXmlList:* = new XMLList();
            for each (mapping in nodeMappingPath)
            {
                //获取到目标数据
                nodesnodeXmlList = param1.elements(mapping);
                if (nodesnodeXmlList.length() <= 0)
                {//找不到，则退出
                    break;
                }
                 //重新缩小搜索范围
                param1 = nodesnodeXmlList[0];
            }
            for each (nodeXml in nodesnodeXmlList)
            {
                
                //id="n0-g005ca3039f64c3ea4e5c386fd6141c4" 
                nodeId = nodeXml.attribute(this.factory.getNodeMapping().nodeId);//"id"
                hiddenSubNodeXmlString+=" <node id=\""+nodeId+"\"><nodes>";
                nodeDisplayElement = this.getModelFromDictionary(nodeId);
                
              //  trace("[nodeId]"+nodeId+",nodeDisplayElement:"+nodeDisplayElement);
                
                if (nodeDisplayElement == null)
                {
                    continue;
                }
                if (!isGetMore&&(nodeDisplayElement.subModels.length > 0))
                {//如果不是加载更多，则如果已经有子元素，无需加载
                    continue;
                }
                subNodeXmlList = new XMLList();
                for each (mapping in nodeMappingPath)
                {
                    
                    subNodeXmlList = nodeXml.elements(mapping);
                    if (subNodeXmlList.length() <= 0)
                    {
                        break;
                    }
                    nodeXml = subNodeXmlList[0];
                }
                
                //zzg 2011-12-31
	            //考虑到大数据量的影响，准备改造，避免一次加载>100个子节点对象，
	            //后期将其封装到一个特殊的对象中，便于逐步展开
	            var nodeCnt:int=0;
	            var nodeMaxPerTime:int=100;
	            var hideNodeCnt:int=0;
            
                for each (subNodeXml in subNodeXmlList)
                {
                    if(nodeCnt<nodeMaxPerTime){
                    	//trace("[subNodeXml]"+subNodeXml);
		                //节点模型实例
	                    subNodeDisplayElement = this.factory.factory(subNodeXml, nodeDisplayElement);
	                    this.modelView.modelsHashMap[subNodeDisplayElement.nodeId] = subNodeDisplayElement;
	                    nodeDisplayElement.addModel(subNodeDisplayElement);
                    }else{
                    	//暂时存储未显示的对象
                    	hiddenSubNodeXmlString+=subNodeXml.toXMLString();
                    	
            			hideNodeCnt++;
            		}
            		 nodeCnt++;
                }
                if(hideNodeCnt>0){
                	    //模拟建立特殊的GetMoreMOdel节点
                	    var idSeq:int=(getmoreModelIdSeq++);
                	   
                	   
                	    subNodeXml=new XML("<node" + 
                	    		" id=\"GetMore_"+idSeq+"\"" + 
                	    		" mdid=\"mdid_getmore_"+idSeq+"\" " + 
                	    		" mdcode=\"点击显示更多内容\" mdname=\"更多("+hideNodeCnt+")...\"" + 
                	    		" mdmodelcode=\"GfGetMore\"" + 
                	    		" mdmodelname=\"GfGetMore\"" + 
                	    		" mdlocation=\""+nodeDisplayElement.mdlocation+"\"/>");
                	    //节点模型实例
	                    subNodeDisplayElement = this.factory.factory(subNodeXml, nodeDisplayElement);
	                    
	                     //添加xml结束符号
                	    hiddenSubNodeXmlString+=" </nodes></node></nodes></root>"
                	    //trace("[hiddenSubNodeXmlString]:"+hiddenSubNodeXmlString);
                	    if(subNodeDisplayElement is GetMoreModel){
                	    	//trace("try set hidden xml string");
                	    	(subNodeDisplayElement as GetMoreModel).setHiddenXmlString(hiddenSubNodeXmlString);
                	    }
                	    
                	    
	                    this.modelView.modelsHashMap[subNodeDisplayElement.nodeId] = subNodeDisplayElement;
	                    nodeDisplayElement.addModel(subNodeDisplayElement);
            		    trace("[buildSubModel(param1:XML)]考虑性能问题，不构建对象，避免显示，将改进为逐步展开模式，优化性能，已隐藏节点个数["+hideNodeCnt+"]");
                }
                //刷新当前展开节点的模型数据
                this.updatamodels(nodeDisplayElement);
            }
            return;
        }// end function


/*
   <head>
    <mdid>vd2eea15710f4f2a9a85c4d6dfde8250</mdid>
    <mdcode>CD0002</mdcode>
    <mdname>行政区域代码</mdname>
    <mdmodelcode>GfCommonCode</mdmodelcode>
    <mdmodelname>公共代码</mdmodelname>
    <sessionid>0</sessionid>
  </head> 
 */
        private function buildModelHead() : void
        {
            var _loc_4:String = null;
            var _loc_5:XML = null;
            var mapping:String = null;
            var _loc_1:* = this.xml;
            //head
            var headMapping:* = this.factory.getNodeMapping().headnode.split(".");
            var headXml:* = new XMLList();
            for each (_loc_4 in headMapping)
            {
                
                headXml = _loc_1.elements(_loc_4);
                _loc_1 = headXml[0];
            }
            //实际上，headXml只是有一个元素，多个元素以最后一个为准
            for each (_loc_5 in headXml)
            {
                
                // this.nodeMapping.mdanalystyle = param1.head.@mdanalystyle;
                //    <head node="head" mdanalystyle="mdanalystyle" mdid="mdid" mdcode="mdcode" mdname="mdname" mdmodelcode="mdmodelcode" sessionid="sessionid"/>
                // mdanalystyle="mdanalystyle"
                mapping = this.factory.getNodeMapping().mdanalystyle;
                //该出的值可能为空
                this.modelHead.mdAnalyStyle = _loc_5.elements(mapping).text();
                //    <node node="nodes.node" mdid="mdid" nodeId="id" mdcode="mdcode" mdname="mdname" mdmodelcode="mdmodelcode" mdtip="mdcode" mdlocation="mdlocation" layer="layer" mdmodelname="mdmodelname"/>
                mapping = this.factory.getNodeMapping().mdid;//mdid="mdid" 
                //<mdid>vd2eea15710f4f2a9a85c4d6dfde8250</mdid>
                this.modelHead.mdId = _loc_5.elements(mapping).text();//
                //    <mdcode>CD0002</mdcode>
                this.modelHead.mdCode = _loc_5.mdcode.toString();
                //    <mdname>行政区域代码</mdname>
                this.modelHead.mdName = _loc_5.mdname;
                //<mdmodelcode>GfCommonCode</mdmodelcode>
                this.modelHead.mdModelCode = _loc_5.mdmodelcode;
                //<sessionid>0</sessionid>
                this.modelHead.sessionId = _loc_5.sessionid;
            }
            return;
        }// end function

        public function set modelView(param1:ModelView) : void
        {
            this._modelView = param1;
            return;
        }// end function

        private function LineInModel(param1:DisplayElement, param2:Array) : Number
        {
            var _loc_4:DisplayElement = null;
            var _loc_3:Number = 0;
            for each (_loc_4 in param2)
            {
                
                if (param1 == _loc_4)
                {
                    return _loc_3;
                }
                _loc_3 = _loc_3 + 1;
            }
            return -1;
        }// end function

        public function getModels() : Array
        {
            return this.models;
        }// end function

        private function buildModel(param1:XML, param2:DisplayElement) : Array
        {
            var _loc_6:String = null;
            var nodeXml:XML = null;
            var nodeModelInstance:DisplayElement = null;
            var nodeModelArr:Array = [];
            this.factory.canvas = this.modelView;
            //zzg 2011-12-13 经查 该nodenode为："nodes.node"
            //    <node node="nodes.node" mdid="mdid" nodeId="id" mdcode="mdcode" mdname="mdname" mdmodelcode="mdmodelcode" mdtip="mdcode" mdlocation="mdlocation" layer="layer" mdmodelname="mdmodelname"/>
            // this.factory.getNodeMapping().nodenode指的是node="nodes.node" 的属性值
            var _loc_4:* = this.factory.getNodeMapping().nodenode.split(".");
            var nodesnodeXml:* = new XMLList();
            for each (_loc_6 in _loc_4)
            {
                //获取到目标数据
                nodesnodeXml = param1.elements(_loc_6);
                if (nodesnodeXml.length() <= 0)
                {//找不到，则退出
                    break;
                }
                //重新缩小搜索范围
                param1 = nodesnodeXml[0];
            }
            for each (nodeXml in nodesnodeXml)
            {
                //节点模型实例
                nodeModelInstance = this.factory.factory(nodeXml, param2);
                nodeModelInstance.subModels = this.buildModel(nodeXml, nodeModelInstance);
                this.modelView.modelsHashMap[nodeModelInstance.nodeId] = nodeModelInstance;
                nodeModelArr.push(nodeModelInstance);
            }
            return nodeModelArr;
        }// end function

        private function LineInLines(param1:Line) : Boolean
        {
            var _loc_2:Line = null;
            for each (_loc_2 in this.lines)
            {
                
                if (_loc_2.fromModel == param1.fromModel && _loc_2.toModel == param1.toModel)
                {
                    return false;
                }
            }
            return true;
        }// end function

        private function constructLine(transformerXml:XMLList, param2:String) : void
        {
            var _loc_6:XML = null;
            var _loc_7:Line = null;
            var _loc_8:DisplayElement = null;
            var _loc_9:DisplayElement = null;
            var _loc_3:* = new Style();
            if (param2 == "transformer")
            {
                _loc_3.fromstyle = 0;
                _loc_3.tostyle = 1;
            }
            else if (param2 == "refmapping")
            {
                _loc_3.fromstyle = 0;
                _loc_3.tostyle = 0;
            }
            _loc_3.style = 1;
            var _loc_4:String = "";
            var _loc_5:String = "";
            for each (_loc_6 in transformerXml)
            {
                
                _loc_7 = new Line();
                if (param2 == "transformer")
                {
                    _loc_4 = this.factory.getNodeMapping().frommdid;
                    _loc_5 = this.factory.getNodeMapping().tomdid;
                }
                else if (param2 == "refmapping")
                {
                    _loc_7.refFlag = true;
                    _loc_4 = this.factory.getNodeMapping().srcmdid;
                    _loc_5 = this.factory.getNodeMapping().targetmdid;
                }
                _loc_8 = this.getModelFromDictionary(_loc_6.attribute(_loc_4).toString());
                _loc_9 = this.getModelFromDictionary(_loc_6.attribute(_loc_5).toString());
                if (_loc_8 == null || _loc_9 == null)
                {
                    continue;
                }
                _loc_7.fromModel = _loc_8;
                _loc_7.toModel = _loc_9;
                _loc_7.style = _loc_3;
                if (this.LineInLines(_loc_7))
                {
                    _loc_7.fromModel.addLine(_loc_7);
                    _loc_7.toModel.addLine(_loc_7);
                    this.lines.push(_loc_7);
                }
            }
            return;
        }// end function

        private function getModelById(param1:String) : DisplayElement
        {
            var _loc_2:DisplayElement = null;
            var _loc_3:DisplayElement = null;
            for each (_loc_2 in this.models)
            {
                
                _loc_3 = _loc_2.findModelById(param1);
                if (_loc_3 != null)
                {
                    return _loc_3;
                }
            }
            return null;
        }// end function

        private function getParentModel(param1:DisplayElement, param2:Array) : DisplayElement
        {
            var _loc_4:DisplayElement = null;
            var _loc_5:int = 0;
            var _loc_3:DisplayElement = null;
            for each (_loc_4 in param2)
            {
                
                if (param1 == _loc_4)
                {
                    _loc_3 = param1.parentmodel;
                    _loc_5 = this.LineInModel(param1, _loc_3.subModels);
                    _loc_3.subModels.splice(_loc_5, 1, param1);
                    break;
                    continue;
                }
                _loc_3 = this.getParentModel(param1, _loc_4.subModels);
                if (_loc_3 != null)
                {
                    break;
                }
            }
            return _loc_3;
        }// end function

        public function get modelView() : ModelView
        {
            return this._modelView;
        }// end function

        private function updatamodels(param1:DisplayElement) : void
        {
            var _loc_2:int = 0;
            var _loc_3:DisplayElement = null;
            if (param1.parentmodel == null)
            {
                _loc_2 = this.LineInModel(param1, this.models);
                this.models.splice(_loc_2, 1, param1);
            }
            else
            {
                _loc_3 = this.getParentModel(param1, this.models);
                this.updatamodels(_loc_3);
            }
            return;
        }// end function

        public function getModelHead() : ModelHead
        {
            return this.modelHead;
        }// end function

    }
}
