package com.pactera.edg.am.dmv.factory
{
    import com.pactera.edg.am.dmv.system.*;
    import com.pactera.edg.am.dmv.view.*;
    import com.pactera.edg.am.dmv.view.line.*;
   // import com.pactera.edg.am.dmv.view.model.*;
    import com.pactera.edg.am.dmv.view.model.*;
    import com.pactera.edg.am.dmv.view.model.DisplayElement;
    
    public class XmlToModel extends Object
    {
        private var configxml:XML;
        private var xml:XML;
        private var models:Array;
        private var _canvas:ModelView;
        private var lines:Array;

        public function XmlToModel()
        {
            models = [];
            lines = [];
            return;
        }// end function

        public function runXmlToModel(param1:XML) : void
        {
            this.xml = param1;
            this.models = this.buildModel(this.xml, null);
            this.buildLine();
            return;
        }// end function

        private function buildSubLine(param1:XML) : void
        {
            var _loc_6:String = null;
            var _loc_7:XML = null;
            var _loc_8:Line = null;
            var _loc_9:Style = null;
            var _loc_10:String = null;
            var _loc_11:String = null;
            var _loc_12:String = null;
            var _loc_13:String = null;
            var _loc_14:String = null;
            var _loc_15:String = null;
            var _loc_16:String = null;
            var _loc_17:String = null;
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
                
                _loc_8 = new Line();
                _loc_9 = new Style();
                _loc_10 = _loc_3.getNodeMapping().fromstyle;
                _loc_11 = _loc_3.getNodeMapping().tostyle;
                _loc_12 = _loc_7.attribute(_loc_10);
                _loc_13 = _loc_7.attribute(_loc_11);
                _loc_9.fromstyle = _loc_12 == "" ? (0) : (_loc_7.attribute(_loc_10));
                _loc_9.tostyle = _loc_13 == "" ? (1) : (_loc_7.attribute(_loc_11));
                _loc_9.style = 1;
                _loc_14 = _loc_3.getNodeMapping().transtypeid;
                _loc_15 = _loc_7.attribute(_loc_14);
                _loc_16 = _loc_3.getNodeMapping().frommdid;
                _loc_17 = _loc_3.getNodeMapping().tomdid;
                if (this.getModelById(_loc_7.attribute(_loc_16)) == null || this.getModelById(_loc_7.attribute(_loc_17)) == null)
                {
                    continue;
                }
                _loc_8.fromModel = this.getModelById(_loc_7.attribute(_loc_16));
                _loc_8.toModel = this.getModelById(_loc_7.attribute(_loc_17));
                _loc_8.style = _loc_9;
                if (this.LineInLines(_loc_8))
                {
                    _loc_8.fromModel.addLine(_loc_8);
                    _loc_8.toModel.addLine(_loc_8);
                    this.lines.push(_loc_8);
                }
            }
            return;
        }// end function

        public function getLines() : Array
        {
            return this.lines;
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
            var _loc_5:String = null;
            var _loc_6:XML = null;
            var _loc_7:Line = null;
            var _loc_8:Style = null;
            var _loc_9:String = null;
            var _loc_10:String = null;
            var _loc_11:String = null;
            var _loc_12:String = null;
            var _loc_13:String = null;
            var _loc_14:String = null;
            var _loc_15:String = null;
            var _loc_16:String = null;
            var _loc_17:DisplayElement = null;
            var _loc_18:DisplayElement = null;
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
                
                _loc_7 = new Line();
                _loc_8 = new Style();
                _loc_9 = _loc_2.getNodeMapping().fromstyle;
                _loc_10 = _loc_2.getNodeMapping().tostyle;
                _loc_11 = _loc_6.attribute(_loc_9);
                _loc_12 = _loc_6.attribute(_loc_10);
                _loc_8.fromstyle = _loc_11 == "" ? (0) : (_loc_6.attribute(_loc_9));
                _loc_8.tostyle = _loc_12 == "" ? (1) : (_loc_6.attribute(_loc_10));
                _loc_8.style = 1;
                _loc_13 = _loc_2.getNodeMapping().transtypeid;
                _loc_14 = _loc_6.attribute(_loc_13);
                _loc_15 = _loc_2.getNodeMapping().frommdid;
                _loc_16 = _loc_2.getNodeMapping().tomdid;
                _loc_17 = this.getModelById(_loc_6.attribute(_loc_15));
                _loc_18 = this.getModelById(_loc_6.attribute(_loc_16));
                if (_loc_17 == null || _loc_18 == null)
                {
                    continue;
                }
                else if (_loc_17.modelId == _loc_18.modelId)
                {
                    continue;
                }
                _loc_7.fromModel = _loc_17;
                _loc_7.toModel = _loc_18;
                _loc_7.style = _loc_8;
                if (this.LineInLines(_loc_7))
                {
                    _loc_7.fromModel.addLine(_loc_7);
                    _loc_7.toModel.addLine(_loc_7);
                    this.lines.push(_loc_7);
                }
            }
            return;
        }// end function

        private function buildSubModel(param1:XML) : void
        {
            var _loc_6:String = null;
            var _loc_7:XML = null;
            var _loc_8:DataMapComModel = null;
            var _loc_9:XMLList = null;
            var _loc_10:XML = null;
            var _loc_11:DisplayElement = null;
            var _loc_2:Array = [];
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
                
                _loc_8 = this.getModelById(_loc_7.attribute(_loc_3.getNodeMapping().mdid)) as DataMapComModel;
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

        public function get canvas() : ModelView
        {
            return this._canvas;
        }// end function

        private function buildModel(param1:XML, param2:DisplayElement) : Array
        {
            var _loc_7:String = null;
            var _loc_8:XML = null;
            var _loc_9:DisplayElement = null;
            var _loc_3:Array = [];
            var _loc_4:* = ApplicationConfig.getInstance().modelFactory;
            ApplicationConfig.getInstance().modelFactory.canvas = this.canvas;
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
                
                if (_loc_8.attribute("x") != "")
                {
                    _loc_9 = _loc_4.factory(_loc_8, param2);
                    _loc_9.subModels = this.buildModel(_loc_8, _loc_9);
                    _loc_3.push(_loc_9);
                }
            }
            for each (_loc_8 in _loc_6)
            {
                
                if (_loc_8.attribute("x") == "")
                {
                    _loc_9 = _loc_4.factory(_loc_8, param2);
                    _loc_9.subModels = this.buildModel(_loc_8, _loc_9);
                    _loc_3.push(_loc_9);
                }
            }
            return _loc_3;
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

        public function set canvas(param1:ModelView) : void
        {
            this._canvas = param1;
            return;
        }// end function

    }
}
