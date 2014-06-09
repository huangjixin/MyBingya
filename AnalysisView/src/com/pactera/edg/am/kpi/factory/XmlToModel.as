package com.pactera.edg.am.kpi.factory
{
    import com.pactera.edg.am.kpi.system.*;
    import com.pactera.edg.am.kpi.view.*;
    import com.pactera.edg.am.kpi.view.line.*;
    import com.pactera.edg.am.kpi.view.model.*;

    public class XmlToModel extends Object
    {
        private var configxml:XML;
        private var _modelGrid:ModelGrid;
        private var xml:XML;
        private var modelHead:ModelHead;
        private var models:Array;
        private var _canvas:ModelView;
        private var lines:Array;
        private static const fieldIcon:Class = XmlToModel_fieldIcon;
        private static const tableIcon:Class = XmlToModel_tableIcon;
        private static const systemIcon:Class = XmlToModel_systemIcon;
        private static const mappingIcon:Class = XmlToModel_mappingIcon;

        public function XmlToModel()
        {
            models = [];
            lines = [];
            modelHead = new ModelHead();
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
            var _loc_6:* = null;
            var _loc_7:* = null;
            var _loc_8:* = null;
            var _loc_9:* = null;
            var _loc_10:* = null;
            var _loc_11:* = null;
            var _loc_12:* = null;
            var _loc_13:* = null;
            var _loc_14:* = null;
            var _loc_15:* = null;
            var _loc_16:* = null;
            var _loc_17:* = null;
            var _loc_18:* = null;
            var _loc_19:* = null;
            var _loc_20:* = null;
            var _loc_21:* = null;
            var _loc_22:* = null;
            var _loc_23:* = null;
            var _loc_24:* = null;
            var _loc_25:* = null;
            var _loc_26:* = null;
            var _loc_27:* = null;
            var _loc_28:* = null;
            var _loc_29:* = null;
            var _loc_30:* = null;
            var _loc_31:* = null;
            var _loc_32:* = null;
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
            for each (_loc_7 in _loc_5)
            {
                
                _loc_9 = new Line();
                _loc_10 = new Style();
                _loc_11 = new Direction();
                _loc_12 = _loc_3.getNodeMapping().fromstyle;
                _loc_13 = _loc_3.getNodeMapping().tostyle;
                _loc_14 = _loc_7.attribute(_loc_12);
                _loc_15 = _loc_7.attribute(_loc_13);
                _loc_10.fromstyle = _loc_14 == "" ? (0) : (_loc_7.attribute(_loc_12));
                _loc_10.tostyle = _loc_15 == "" ? (1) : (_loc_7.attribute(_loc_13));
                _loc_10.style = 1;
                _loc_16 = _loc_3.getNodeMapping().transtypeid;
                _loc_17 = _loc_7.attribute(_loc_16);
                if (_loc_17 == "")
                {
                    _loc_10.linestyle = 1;
                    _loc_11.direction = 1;
                }
                else
                {
                    _loc_20 = _loc_3.getlineMapping()[_loc_17.toLowerCase()];
                    _loc_10.linestyle = _loc_20.@style;
                    _loc_11.direction = _loc_20.@direction;
                    _loc_9.lineColor = _loc_20.@color;
                    _loc_9.lineB = _loc_20.@thickness;
                }
                _loc_18 = _loc_3.getNodeMapping().frommdid;
                _loc_19 = _loc_3.getNodeMapping().tomdid;
                if (this.getModelById(_loc_7.attribute(_loc_18)) == null || this.getModelById(_loc_7.attribute(_loc_19)) == null)
                {
                    continue;
                }
                _loc_9.fromModel = this.getModelById(_loc_7.attribute(_loc_18));
                _loc_9.toModel = this.getModelById(_loc_7.attribute(_loc_19));
                _loc_9.style = _loc_10;
                _loc_9.direction = _loc_11;
                if (this.LineInLines(_loc_9))
                {
                    _loc_9.fromModel.addLine(_loc_9);
                    _loc_9.toModel.addLine(_loc_9);
                    this.lines.push(_loc_9);
                }
            }
            _loc_4 = _loc_3.getNodeMapping().refnode.split(".");
            _loc_2 = this.xml;
            for each (_loc_6 in _loc_4)
            {
                
                _loc_5 = _loc_2.elements(_loc_6);
                if (_loc_5.length() <= 0)
                {
                    break;
                }
                _loc_2 = _loc_5[0];
            }
            for each (_loc_8 in _loc_5)
            {
                
                _loc_21 = new Line();
                _loc_22 = new Style();
                _loc_23 = new Direction();
                _loc_24 = _loc_3.getNodeMapping().srcstyle;
                _loc_25 = _loc_3.getNodeMapping().targetstyle;
                _loc_26 = _loc_8.attribute(_loc_24);
                _loc_27 = _loc_8.attribute(_loc_25);
                _loc_22.fromstyle = _loc_26 == "" ? (1) : (_loc_8.attribute(_loc_24));
                _loc_22.tostyle = _loc_27 == "" ? (1) : (_loc_8.attribute(_loc_25));
                _loc_22.style = 1;
                _loc_28 = _loc_3.getNodeMapping().reftypeid;
                _loc_29 = _loc_7.attribute(_loc_28);
                if (_loc_29 == "")
                {
                    _loc_22.linestyle = 0;
                    _loc_23.direction = 0;
                }
                else
                {
                    _loc_32 = _loc_3.getlineMapping()[_loc_29.toLowerCase()];
                    _loc_22.linestyle = _loc_32.@style;
                    _loc_23.direction = _loc_32.@direction;
                    _loc_21.lineColor = _loc_32.@color;
                    _loc_21.lineB = _loc_32.@thickness;
                }
                _loc_30 = _loc_3.getNodeMapping().srcmdid;
                _loc_31 = _loc_3.getNodeMapping().targetmdid;
                if (this.getModelById(_loc_7.attribute(_loc_30)) == null || this.getModelById(_loc_7.attribute(_loc_31)) == null)
                {
                    continue;
                }
                _loc_21.fromModel = this.getModelById(_loc_7.attribute(_loc_30));
                _loc_21.toModel = this.getModelById(_loc_7.attribute(_loc_31));
                _loc_21.style = _loc_22;
                _loc_21.direction = _loc_23;
                if (this.LineInLines(_loc_21))
                {
                    _loc_21.fromModel.addLine(_loc_21);
                    _loc_21.toModel.addLine(_loc_21);
                    this.lines.push(_loc_21);
                }
            }
            return;
        }// end function

        public function getLines() : Array
        {
            return this.lines;
        }// end function

        public function get modelGrid() : ModelGrid
        {
            return this._modelGrid;
        }// end function

        public function runXmlToSubModel(param1:XML, param2:Array, param3:Array) : void
        {
            this.xml = param1;
            this.models = param2;
            this.lines = param3;
            this.buildSubModel(this.xml);
            this.buildSubLine(this.xml);
            return;
        }// end function

        private function buildLine() : void
        {
            var _loc_5:* = null;
            var _loc_6:* = null;
            var _loc_7:* = null;
            var _loc_8:* = null;
            var _loc_9:* = null;
            var _loc_10:* = null;
            var _loc_11:* = null;
            var _loc_12:* = null;
            var _loc_13:* = null;
            var _loc_14:* = null;
            var _loc_15:* = null;
            var _loc_16:* = null;
            var _loc_17:* = null;
            var _loc_18:* = null;
            var _loc_19:* = null;
            var _loc_20:* = null;
            var _loc_21:* = null;
            var _loc_22:* = null;
            var _loc_23:* = null;
            var _loc_24:* = null;
            var _loc_25:* = null;
            var _loc_26:* = null;
            var _loc_27:* = null;
            var _loc_28:* = null;
            var _loc_29:* = null;
            var _loc_30:* = null;
            var _loc_31:* = null;
            var _loc_1:* = this.xml;
            var _loc_2:* = ApplicationConfig.getInstance().modelFactory;
            var _loc_3:* = _loc_2.getNodeMapping().transnode.split(".");
            var _loc_4:* = new XMLList();
            for each (_loc_5 in _loc_3)
            {
                
                _loc_4 = _loc_1.elements(_loc_5);
                if (_loc_4.length() <= 0)
                {
                    break;
                }
                _loc_1 = _loc_4[0];
            }
            for each (_loc_6 in _loc_4)
            {
                
                _loc_8 = new Line();
                _loc_9 = new Style();
                _loc_10 = new Direction();
                _loc_11 = _loc_2.getNodeMapping().fromstyle;
                _loc_12 = _loc_2.getNodeMapping().tostyle;
                _loc_13 = _loc_6.attribute(_loc_11);
                _loc_14 = _loc_6.attribute(_loc_12);
                _loc_9.fromstyle = _loc_13 == "" ? (0) : (_loc_6.attribute(_loc_11));
                _loc_9.tostyle = _loc_14 == "" ? (1) : (_loc_6.attribute(_loc_12));
                _loc_9.style = 1;
                _loc_15 = _loc_2.getNodeMapping().transtypeid;
                _loc_16 = _loc_6.attribute(_loc_15);
                if (_loc_16 == "")
                {
                    _loc_9.linestyle = 1;
                    _loc_10.direction = 1;
                }
                else
                {
                    _loc_19 = _loc_2.getlineMapping()[_loc_16.toLowerCase()];
                    _loc_9.linestyle = _loc_19.@style;
                    _loc_10.direction = _loc_19.@direction;
                    _loc_8.lineColor = _loc_19.@color;
                    _loc_8.lineB = _loc_19.@thickness;
                }
                _loc_17 = _loc_2.getNodeMapping().frommdid;
                _loc_18 = _loc_2.getNodeMapping().tomdid;
                if (this.getModelById(_loc_6.attribute(_loc_17)) == null || this.getModelById(_loc_6.attribute(_loc_18)) == null)
                {
                    continue;
                }
                _loc_8.fromModel = this.getModelById(_loc_6.attribute(_loc_17));
                _loc_8.toModel = this.getModelById(_loc_6.attribute(_loc_18));
                _loc_8.style = _loc_9;
                _loc_8.direction = _loc_10;
                if (this.LineInLines(_loc_8))
                {
                    _loc_8.fromModel.addLine(_loc_8);
                    _loc_8.toModel.addLine(_loc_8);
                    this.lines.push(_loc_8);
                }
            }
            _loc_3 = _loc_2.getNodeMapping().refnode.split(".");
            _loc_1 = this.xml;
            for each (_loc_5 in _loc_3)
            {
                
                _loc_4 = _loc_1.elements(_loc_5);
                if (_loc_4.length() <= 0)
                {
                    break;
                }
                _loc_1 = _loc_4[0];
            }
            for each (_loc_7 in _loc_4)
            {
                
                _loc_20 = new Line();
                _loc_21 = new Style();
                _loc_22 = new Direction();
                _loc_23 = _loc_2.getNodeMapping().srcstyle;
                _loc_24 = _loc_2.getNodeMapping().targetstyle;
                _loc_25 = _loc_7.attribute(_loc_23);
                _loc_26 = _loc_7.attribute(_loc_24);
                _loc_21.fromstyle = _loc_25 == "" ? (1) : (_loc_7.attribute(_loc_23));
                _loc_21.tostyle = _loc_26 == "" ? (1) : (_loc_7.attribute(_loc_24));
                _loc_21.style = 1;
                _loc_27 = _loc_2.getNodeMapping().reftypeid;
                _loc_28 = _loc_7.attribute(_loc_27);
                if (_loc_28 == "")
                {
                    _loc_21.linestyle = 0;
                    _loc_22.direction = 0;
                }
                else
                {
                    _loc_31 = _loc_2.getlineMapping()[_loc_28.toLowerCase()];
                    _loc_21.linestyle = _loc_31.@style;
                    _loc_22.direction = _loc_31.@direction;
                    _loc_20.lineColor = _loc_31.@color;
                    _loc_20.lineB = _loc_31.@thickness;
                }
                _loc_29 = _loc_2.getNodeMapping().srcmdid;
                _loc_30 = _loc_2.getNodeMapping().targetmdid;
                if (this.getModelById(_loc_7.attribute(_loc_29)) == null || this.getModelById(_loc_7.attribute(_loc_30)) == null)
                {
                    continue;
                }
                _loc_20.fromModel = this.getModelById(_loc_7.attribute(_loc_29));
                _loc_20.toModel = this.getModelById(_loc_7.attribute(_loc_30));
                _loc_20.style = _loc_21;
                _loc_20.direction = _loc_22;
                if (this.LineInLines(_loc_20))
                {
                    _loc_20.fromModel.addLine(_loc_20);
                    _loc_20.toModel.addLine(_loc_20);
                    this.lines.push(_loc_20);
                }
            }
            return;
        }// end function

        public function get canvas() : ModelView
        {
            return this._canvas;
        }// end function

        private function buildModel(param1:XML, param2:DisplayElement) : Array
        {
            var _loc_7:* = null;
            var _loc_8:* = null;
            var _loc_9:* = null;
            var _loc_3:* = [];
            var _loc_4:* = ApplicationConfig.getInstance().modelFactory;
            _loc_4.canvas = this.canvas;
            _loc_4.modelGrid = this.modelGrid;
            var _loc_5:* = _loc_4.getNodeMapping().nodenode.split(".");
            var _loc_6:* = new XMLList();
            for each (_loc_7 in _loc_5)
            {
                
                _loc_6 = param1.elements(_loc_7);
                if (_loc_6.length() <= 0)
                {
                    break;
                }
                param1 = _loc_6[0];
            }
            for each (_loc_8 in _loc_6)
            {
                
                _loc_9 = _loc_4.factory(_loc_8, param2);
                _loc_9.subModels = this.buildModel(_loc_8, _loc_9);
                _loc_3.push(_loc_9);
            }
            return _loc_3;
        }// end function

        public function set modelGrid(param1:ModelGrid) : void
        {
            this._modelGrid = param1;
            return;
        }// end function

        private function LineInModel(param1:DisplayElement, param2:Array) : Number
        {
            var _loc_4:* = null;
            var _loc_3:* = 0;
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

        private function buildModelHead() : void
        {
            var _loc_5:* = null;
            var _loc_6:* = null;
            var _loc_7:* = null;
            var _loc_1:* = this.xml;
            var _loc_2:* = ApplicationConfig.getInstance().modelFactory;
            var _loc_3:* = _loc_2.getNodeMapping().headnode.split(".");
            var _loc_4:* = new XMLList();
            for each (_loc_5 in _loc_3)
            {
                
                _loc_4 = _loc_1.elements(_loc_5);
                _loc_1 = _loc_4[0];
            }
            for each (_loc_6 in _loc_4)
            {
                
                _loc_7 = _loc_2.getNodeMapping().mdanalystyle;
                this.modelHead.mdAnalyStyle = _loc_6.elements(_loc_7).text();
                _loc_7 = _loc_2.getNodeMapping().viewid;
                this.modelHead.viewId = _loc_6.attribute(_loc_7);
            }
            return;
        }// end function

        private function getModelById(param1:String) : DisplayElement
        {
            var _loc_2:* = null;
            var _loc_3:* = null;
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

        public function getModels() : Array
        {
            return this.models;
        }// end function

        private function LineInLines(param1:Line) : Boolean
        {
            var _loc_2:* = null;
            for each (_loc_2 in this.lines)
            {
                
                if (_loc_2.fromModel == param1.fromModel && _loc_2.toModel == param1.toModel && _loc_2.direction.direction == param1.direction.direction)
                {
                    return false;
                }
            }
            return true;
        }// end function

        private function buildSubModel(param1:XML) : void
        {
            var _loc_6:* = null;
            var _loc_7:* = null;
            var _loc_8:* = null;
            var _loc_9:* = null;
            var _loc_10:* = null;
            var _loc_11:* = null;
            var _loc_2:* = [];
            var _loc_3:* = ApplicationConfig.getInstance().modelFactory;
            var _loc_4:* = _loc_3.getNodeMapping().nodenode.split(".");
            var _loc_5:* = new XMLList();
            for each (_loc_6 in _loc_4)
            {
                
                _loc_5 = param1.elements(_loc_6);
                if (_loc_5.length() <= 0)
                {
                    break;
                }
                param1 = _loc_5[0];
            }
            for each (_loc_7 in _loc_5)
            {
                
                _loc_8 = this.getModelById(_loc_7.attribute(_loc_3.getNodeMapping().mdid)) as CombinationModel;
                if (_loc_8 == null)
                {
                    continue;
                }
                if (_loc_8.subModels.length > 0)
                {
                    _loc_8.subModels = [];
                }
                _loc_9 = new XMLList();
                for each (_loc_6 in _loc_4)
                {
                    
                    _loc_9 = _loc_7.elements(_loc_6);
                    if (_loc_9.length() <= 0)
                    {
                        break;
                    }
                    _loc_7 = _loc_9[0];
                }
                for each (_loc_10 in _loc_9)
                {
                    
                    _loc_11 = _loc_3.factory(_loc_10, _loc_8);
                    _loc_8.addModel(_loc_11);
                }
                this.updatamodels(_loc_8);
            }
            return;
        }// end function

        public function set canvas(param1:ModelView) : void
        {
            this._canvas = param1;
            return;
        }// end function

        private function updatamodels(param1:DisplayElement) : void
        {
            var _loc_2:* = 0;
            var _loc_3:* = null;
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

        private function getParentModel(param1:DisplayElement, param2:Array) : DisplayElement
        {
            var _loc_4:* = null;
            var _loc_5:* = 0;
            var _loc_3:* = null;
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

        public function getModelHead() : ModelHead
        {
            return this.modelHead;
        }// end function

    }
}
