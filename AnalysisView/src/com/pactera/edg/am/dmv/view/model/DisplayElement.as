package com.pactera.edg.am.dmv.view.model
{
    import com.pactera.edg.am.dmv.factory.*;
    import com.pactera.edg.am.dmv.tween.*;
    import com.pactera.edg.am.dmv.view.*;
    import com.pactera.edg.am.dmv.view.extender.*;
    import com.pactera.edg.am.dmv.view.grid.*;
    import com.pactera.edg.am.dmv.view.handler.*;
    import com.pactera.edg.am.dmv.view.line.*;
    import com.pactera.edg.am.dmv.view.model.*;
    import flash.display.*;
    import flash.events.*;
    import flash.geom.*;
    import flash.utils.*;
    import mx.collections.*;
    import mx.controls.*;
    import mx.core.*;

    public class DisplayElement extends UIComponent implements IModel
    {
        public var detailXml:XML;
        private var _parentmdmodel:String;
        public var myObject:DealEvent = null;
        protected var _lines:Array;
        public var bisAnalysicLinkModel:Boolean = false;
        private var _parentmdid:String;
        private var _rowNumber:int;
        public var colorProperty:ColorProperty = null;
        protected var _image:Image;
        private var _mdtype:String;
        private var _modelType:String;
        private var _modelState:ModelState;
        public var notRelatedModelDic:Dictionary = null;
        public var linkNodesIdCollection:ArrayCollection;
        private var _extensible:IExtendBehavior;
        private var _rectOne:Sprite;
        public var borderThickness:int = 1;
        protected var submodels:Array;
        public var isDashModel:Boolean = false;
        private var fromModels:Array;
        protected var _iconObject:Image;
        private var _detailInfoWin:MyCustomPopUpWin;
        private var _defaultModelWidth:Number = 0;
        private var toModels:Array;
        public var glowTween:GlowTween;
        private var _typeClass:String;
        private var _modelId:String;
        public var myTimer:Timer;
        protected var _parentmodel:DisplayElement;
        protected var _container:ModelContainer;
        public var linkUpModelsDic:Dictionary = null;
        private var _spanrow:int = 1;
        private var _mdcode:String;
        public var linkLines:Array = null;
        private var _isClick:Boolean;
        public var dashlen:Number = 5;
        private var toLines:Array;
        protected var grid:Grid;
        private var _defaultModelHeight:Number = 0;
        public var linkDownModelsDic:Dictionary = null;
        protected var _title:IUITextField;
        private var _basicLineColor:uint;
        private var _colNumber:int;
        private var _basicColor:uint;
        private var fromLines:Array;
        public var gaplen:Number = 5;
        private var _rigthMenu:CustomContextMenu = null;
        private var _xPos:Number;
        private var _isOpen:Boolean;
        private var _mdname:String;
        public var myGraphicUtil:GraphicUtil = null;
        private var _factory:ModelFactory;
        private var textField:IUITextField = null;
        private var _modelName:String;
        private var _modelView:ModelView;
        private var _rectX:Number;
        private var _rectY:Number;
        private var _yPos:Number;

        public function DisplayElement()
        {
            submodels = [];
            grid = new Grid();
            _lines = [];
            toModels = new Array();
            fromModels = new Array();
            toLines = new Array();
            fromLines = new Array();
            this.isClick = false;
            this.isOpen = true;
            myTimer = new Timer(1000, 1);
            colorProperty = new ColorProperty();
            myGraphicUtil = new GraphicUtil();
            myObject = new DealEvent();
            glowTween = new GlowTween(this, colorProperty.effectColor);
            return;
        }// end function

        public function get modelType() : String
        {
            return this._modelType;
        }// end function

        public function get parentmdmodel() : String
        {
            return this._parentmdmodel;
        }// end function

        public function set rigthMenu(param1:CustomContextMenu) : void
        {
            this._rigthMenu = param1;
            return;
        }// end function

        public function set parentmdmodel(param1:String) : void
        {
            this._parentmdmodel = param1;
            return;
        }// end function

        public function get mdcode() : String
        {
            return this._mdcode;
        }// end function

        public function set factory(param1:ModelFactory) : void
        {
            this._factory = param1;
            return;
        }// end function

        public function set modelType(param1:String) : void
        {
            this._modelType = param1;
            return;
        }// end function

        public function set mdcode(param1:String) : void
        {
            this._mdcode = param1;
            return;
        }// end function

        public function moveAll() : void
        {
            var _loc_1:DisplayElement = null;
            for each (_loc_1 in this.subModels)
            {
                
                this.grid.moveModel(_loc_1);
            }
            return;
        }// end function

        public function clearSelected(param1:Array, param2:String) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_4:ModelContainer = null;
            for each (_loc_3 in param1)
            {
                
                if (_loc_3.subModels.length > 0)
                {
                    if (_loc_3.modelId != param2)
                    {
                        _loc_4 = _loc_3.container;
                        _loc_4.getObjectHandles().selectionManager.clearSelection();
                    }
                    clearSelected(_loc_3.subModels, param2);
                }
            }
            return;
        }// end function

        public function get modelId() : String
        {
            return this._modelId;
        }// end function

        public function set iconObject(param1:Image) : void
        {
            this._iconObject = param1;
            return;
        }// end function

        public function createTextField() : IUITextField
        {
            var _loc_1:* = IUITextField(createInFontContext(UITextField));
            _loc_1.enabled = enabled;
            _loc_1.ignorePadding = true;
            _loc_1.selectable = false;
            _loc_1.styleName = this;
            _loc_1.maxChars = 0;
            return _loc_1;
        }// end function

        public function addLine(param1:Line) : void
        {
            this._lines.push(param1);
            return;
        }// end function

        public function set yPos(param1:Number) : void
        {
            this._yPos = param1;
            return;
        }// end function

        public function setLinkLinesColor(param1:Boolean = true) : void
        {
            changeLinkLineColor(this.linkLines, param1);
            return;
        }// end function

        public function getToModels() : Array
        {
            return this.toModels;
        }// end function

        public function set modelId(param1:String) : void
        {
            this._modelId = param1;
            return;
        }// end function

        public function get spanrow() : int
        {
            return _spanrow;
        }// end function

        public function setLinkModelColor(param1:Boolean) : void
        {
            if (linkUpModelsDic == null && linkDownModelsDic == null && linkLines == null)
            {
                modelView.initAllModelbisAnalysicLinkModel(this.modelView.getModels());
                bisAnalysicLinkModel = true;
                linkUpModelsDic = new Dictionary();
                linkDownModelsDic = new Dictionary();
                linkLines = [];
                searchLinkModels(this);
            }
            changeLinkModelColor(linkUpModelsDic, param1);
            changeLinkModelColor(linkDownModelsDic, param1);
            return;
        }// end function

        public function get typeClass() : String
        {
            return this._typeClass;
        }// end function

        public function get title() : IUITextField
        {
            return this._title;
        }// end function

        public function handleResult(param1:XML) : void
        {
            this.detailXml = param1;
            this.detailInfoWin.modelXmlList = param1.children();
            if (this.detailInfoWin.modelXmlList.length() > 0)
            {
                this.detailInfoWin.includeInLayout = true;
                this.detailInfoWin.visible = true;
            }
            return;
        }// end function

        public function initAll() : void
        {
            var _loc_1:DisplayElement = null;
            for each (_loc_1 in this.subModels)
            {
                
                _loc_1.initAll();
            }
            this.grid.init(this.subModels);
            this.grid.reCalculate(this.subModels);
            return;
        }// end function

        public function set defaultModelWidth(param1:Number) : void
        {
            this._defaultModelWidth = param1;
            return;
        }// end function

        public function get container() : ModelContainer
        {
            return this._container;
        }// end function

        public function set basicLineColor(param1:uint) : void
        {
            this._basicLineColor = param1;
            return;
        }// end function

        public function get isClick() : Boolean
        {
            return this._isClick;
        }// end function

        public function get isOpen() : Boolean
        {
            return this._isOpen;
        }// end function

        public function drawBorder(param1:Number, param2:Number, param3:Number, param4:Number, param5:Number, param6:Number) : void
        {
            drawLine(param1, param2, param1 + param3, param2, param5, param6);
            drawLine(param1 + param3, param2, param1 + param3, param2 + param4, param5, param6);
            drawLine(param1 + param3, param2 + param4, param1, param2 + param4, param5, param6);
            drawLine(param1, param2 + param4, param1, param2, param5, param6);
            return;
        }// end function

        public function getExWidth() : int
        {
            var _loc_5:DisplayElement = null;
            var _loc_6:Number = NaN;
            var _loc_1:* = getMaxTitleWidth();
            var _loc_2:Number = 0;
            var _loc_3:Number = 0;
            var _loc_4:Number = 0;
            if (this.isOpen)
            {
                for each (_loc_5 in this.subModels)
                {
                    
                    if (_loc_5.colNumber > _loc_4)
                    {
                        _loc_4 = _loc_5.colNumber;
                    }
                }
                _loc_3 = _loc_3 - _loc_4 * 30;
                while (_loc_4 >= 0)
                {
                    
                    for each (_loc_5 in this.subModels)
                    {
                        
                        if (_loc_4 == _loc_5.colNumber)
                        {
                            _loc_6 = _loc_5.getExWidth() + _loc_5.parentmodel.grid.getGasWidth() * 2;
                            if (_loc_2 < _loc_6)
                            {
                                _loc_2 = _loc_6;
                            }
                        }
                    }
                    _loc_3 = _loc_3 + (_loc_2 + 30);
                    _loc_2 = 0;
                    _loc_4 = _loc_4 - 1;
                }
            }
            return Math.max(_loc_1, _loc_3);
        }// end function

        public function set spanrow(param1:int) : void
        {
            if (param1 > 0)
            {
                this._spanrow = param1;
            }
            return;
        }// end function

        public function get mdname() : String
        {
            return this._mdname;
        }// end function

        public function buildFromLines() : void
        {
            var _loc_1:Line = null;
            this.fromLines = [];
            for each (_loc_1 in this.lines)
            {
                
                if (_loc_1.toModel == this)
                {
                    this.fromLines.push(_loc_1);
                }
            }
            return;
        }// end function

        public function set mdtype(param1:String) : void
        {
            this._mdtype = param1;
            return;
        }// end function

        public function get parentmdid() : String
        {
            return this._parentmdid;
        }// end function

        public function lineDispatchEvent() : void
        {
            var _loc_1:Line = null;
            for each (_loc_1 in lines)
            {
                
                _loc_1.dispatchEvent(new Event(Line.MODEL_MOVE));
            }
            return;
        }// end function

        public function get defaultModelHeight() : Number
        {
            return this._defaultModelHeight;
        }// end function

        public function getFromModels() : Array
        {
            return this.fromModels;
        }// end function

        public function lineAddEventDispatchEvent() : void
        {
            var _loc_1:Line = null;
            for each (_loc_1 in this.modelView.getLines())
            {
                
                _loc_1.addEventListener(MouseEvent.MOUSE_OUT, _loc_1.colorOutLineHandler, false, 0, true);
                _loc_1.addEventListener(MouseEvent.MOUSE_OVER, _loc_1.colorOverLineHandler, false, 0, true);
            }
            return;
        }// end function

        public function set image(param1:Image) : void
        {
            this._image = param1;
            return;
        }// end function

        public function get xPos() : Number
        {
            return this._xPos;
        }// end function

        public function get detailInfoWin() : MyCustomPopUpWin
        {
            return this._detailInfoWin;
        }// end function

        public function set typeClass(param1:String) : void
        {
            this._typeClass = param1;
            return;
        }// end function

        public function get parentmodel() : DisplayElement
        {
            return this._parentmodel;
        }// end function

        public function lineColorDispatchEvent() : void
        {
            var _loc_1:Line = null;
            for each (_loc_1 in lines)
            {
                
                _loc_1.lineAlpha = 0.5;
                _loc_1.dispatchEvent(new Event(Line.LINE_SETCOLOR));
            }
            return;
        }// end function

        public function get subModels() : Array
        {
            return this.submodels;
        }// end function

        private function searchLinkModels(param1:DisplayElement) : void
        {
            var _loc_2:DisplayElement = null;
            searchUpLinkModels(param1);
            searchDownLinkModels(param1);
            if (!param1.isOpen)
            {
                for each (_loc_2 in param1.subModels)
                {
                    
                    searchLinkModels(_loc_2);
                }
            }
            return;
        }// end function

        public function getFromLines() : Array
        {
            return this.fromLines;
        }// end function

        public function setModelOpen(param1:DisplayElement) : void
        {
            if (param1.parentmodel != null)
            {
                param1.parentmodel.extensible.modelState.changeModelState();
                setModelOpen(param1.parentmodel);
            }
            return;
        }// end function

        public function set title(param1:IUITextField) : void
        {
            this._title = param1;
            return;
        }// end function

        public function getTopPoint(param1:UIComponent) : Point
        {
            if (param1 == null)
            {
                return null;
            }
            return new Point(0, 0);
        }// end function

        public function set modelName(param1:String) : void
        {
            this._modelName = param1;
            return;
        }// end function

        public function reDrawChildLine() : void
        {
            var _loc_1:* = undefined;
            if (this.subModels.length > 0)
            {
                for each (_loc_1 in subModels)
                {
                    
                    setLineAlpha(_loc_1, 0.5);
                }
            }
            return;
        }// end function

        public function set modelView(param1:ModelView) : void
        {
            this._modelView = param1;
            return;
        }// end function

        public function removelineDispatchEvent() : void
        {
            var _loc_1:Line = null;
            for each (_loc_1 in lines)
            {
                
                _loc_1.dispatchEvent(new Event(Line.LINE_REMOVE));
            }
            return;
        }// end function

        public function findModelById(param1:String) : DisplayElement
        {
            var _loc_2:DisplayElement = null;
            var _loc_3:DisplayElement = null;
            if (this.id == param1)
            {
                return this;
            }
            for each (_loc_2 in this.submodels)
            {
                
                _loc_3 = _loc_2.findModelById(param1);
                if (_loc_3 != null)
                {
                    return _loc_3;
                }
            }
            return null;
        }// end function

        public function get modelState() : ModelState
        {
            return this._modelState;
        }// end function

        public function get colNumber() : int
        {
            return this._colNumber;
        }// end function

        public function setIsDashModel(param1:String) : void
        {
            if (param1 == "N")
            {
                this.isDashModel = true;
            }
            else
            {
                this.isDashModel = false;
            }
            return;
        }// end function

        public function getRightPoint(param1:UIComponent) : Point
        {
            if (param1 == null)
            {
                return null;
            }
            return new Point(0, 0);
        }// end function

        private function filterLinkModels(param1:ArrayCollection, param2:Dictionary) : void
        {
            var _loc_3:String = null;
            for (_loc_3 in param2)
            {
                
                if (!param1.contains(_loc_3))
                {
                    delete param2[_loc_3];
                    continue;
                }
                continue;
            }
            return;
        }// end function

        public function get rectX() : Number
        {
            return this._rectX;
        }// end function

        public function get rectY() : Number
        {
            return this._rectY;
        }// end function

        public function buildToLines() : void
        {
            var _loc_1:Line = null;
            this.toLines = [];
            for each (_loc_1 in this.lines)
            {
                
                if (_loc_1.fromModel == this)
                {
                    this.toLines.push(_loc_1);
                }
            }
            return;
        }// end function

        public function get extensible() : IExtendBehavior
        {
            return this._extensible;
        }// end function

        public function set isClick(param1:Boolean) : void
        {
            this._isClick = param1;
            return;
        }// end function

        public function get lines() : Array
        {
            return this._lines;
        }// end function

        public function get rigthMenu() : CustomContextMenu
        {
            return this._rigthMenu;
        }// end function

        public function getBottomPoint(param1:UIComponent) : Point
        {
            if (param1 == null)
            {
                return null;
            }
            return new Point(0, 0);
        }// end function

        public function set container(param1:ModelContainer) : void
        {
            param1.model = this;
            this._container = param1;
            return;
        }// end function

        public function get factory() : ModelFactory
        {
            return this._factory;
        }// end function

        public function contract() : void
        {
            _extensible.contract();
            return;
        }// end function

        public function getLeftPoint(param1:UIComponent) : Point
        {
            if (param1 == null)
            {
                return null;
            }
            return new Point(0, 0);
        }// end function

        public function getToLines() : Array
        {
            return this.toLines;
        }// end function

        public function addModel(param1:DisplayElement) : void
        {
            this.subModels.push(param1);
            this._container.addChild(param1);
            return;
        }// end function

        public function get iconObject() : Image
        {
            return this._iconObject;
        }// end function

        public function get yPos() : Number
        {
            return this._yPos;
        }// end function

        private function getMaxTitleWidth() : Number
        {
            var _loc_2:DisplayElement = null;
            var _loc_1:Number = 0;
            if (this.parentmodel != null)
            {
                for each (_loc_2 in parentmodel.subModels)
                {
                    
                    _loc_1 = Math.max(this.measureText(_loc_2.title.text).width + 40, _loc_1);
                }
            }
            else
            {
                _loc_1 = this.measureText(this.title.text).width + 40;
            }
            return _loc_1;
        }// end function

        public function searchDownLinkModels(param1:DisplayElement) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_4:Line = null;
            var _loc_5:String = null;
            if (linkNodesIdCollection == null)
            {
                return;
            }
            var _loc_2:Array = [];
            param1.buildToModels();
            _loc_2 = param1.getToModels();
            if (_loc_2.length > 0)
            {
                for each (_loc_3 in _loc_2)
                {
                    
                    _loc_4 = param1.getLinkToLine(_loc_3);
                    if (_loc_3.modelId == this.modelId)
                    {
                        continue;
                        continue;
                    }
                    _loc_5 = _loc_3.modelId;
                    if (!linkNodesIdCollection.contains(_loc_5))
                    {
                        continue;
                    }
                    this.linkLines.push(_loc_4);
                    if (this.linkDownModelsDic[_loc_5] != _loc_3)
                    {
                        this.linkDownModelsDic[_loc_5] = _loc_3;
                        searchDownLinkModels(_loc_3);
                    }
                }
            }
            return;
        }// end function

        public function extend() : void
        {
            _extensible.extend();
            return;
        }// end function

        public function ModelInLine() : Array
        {
            var _loc_2:Line = null;
            var _loc_1:Array = [];
            for each (_loc_2 in this.lines)
            {
                
                if (_loc_2.toModel == this)
                {
                    _loc_1.push(_loc_2.fromModel);
                }
                if (_loc_2.fromModel == this)
                {
                    _loc_1.push(_loc_2.toModel);
                }
            }
            return _loc_1;
        }// end function

        private function changeLinkModelColor(param1:Dictionary, param2:Boolean) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_4:String = null;
            for (_loc_4 in param1)
            {
                
                _loc_3 = param1[_loc_4] as DisplayElement;
                _loc_3.bisAnalysicLinkModel = true;
                if (_loc_3.isDashModel)
                {
                    if (_loc_3 is DataMapComModel)
                    {
                        if (param2)
                        {
                            GraphicUtil.turnDashModelColor(colorProperty.mouselinecolor, _loc_3.basicColor, _loc_3);
                        }
                        else
                        {
                            GraphicUtil.turnDashModelColor(_loc_3.basicLineColor, _loc_3.basicColor, _loc_3);
                        }
                    }
                    else if (param2)
                    {
                        GraphicUtil.turnDashModelGradientColor(colorProperty.mouselinecolor, _loc_3.basicColor, _loc_3);
                    }
                    else
                    {
                        GraphicUtil.turnDashModelGradientColor(_loc_3.basicLineColor, _loc_3.basicColor, _loc_3);
                    }
                    continue;
                }
                if (_loc_3 is DataMapComModel)
                {
                    if (param2)
                    {
                        GraphicUtil.turnModelColor(colorProperty.mouselinecolor, _loc_3.basicColor, _loc_3);
                    }
                    else
                    {
                        GraphicUtil.turnModelColor(colorProperty.linecolor, _loc_3.basicColor, _loc_3);
                    }
                    continue;
                }
                if (param2)
                {
                    GraphicUtil.turnModelGradientColor(colorProperty.mouselinecolor, _loc_3.basicColor, _loc_3);
                    continue;
                }
                GraphicUtil.turnModelGradientColor(colorProperty.linecolor, _loc_3.basicColor, _loc_3);
            }
            return;
        }// end function

        public function getRelationX(param1:DisplayObjectContainer) : int
        {
            var _loc_4:DisplayElement = null;
            var _loc_2:* = this.x;
            var _loc_3:* = this.parent;
            while (_loc_3 != param1)
            {
                
                if (_loc_3 is DisplayElement)
                {
                    _loc_4 = _loc_3 as DisplayElement;
                    if (!_loc_4._container.visible)
                    {
                        _loc_2 = 0;
                    }
                }
                _loc_2 = _loc_2 + _loc_3.x;
                _loc_3 = _loc_3.parent;
            }
            return _loc_2;
        }// end function

        public function getRelationY(param1:DisplayObjectContainer) : int
        {
            var _loc_4:DisplayElement = null;
            var _loc_2:* = this.y;
            var _loc_3:* = this.parent;
            while (_loc_3 != param1)
            {
                
                if (_loc_3 is DisplayElement)
                {
                    _loc_4 = _loc_3 as DisplayElement;
                    if (!_loc_4._container.visible)
                    {
                        _loc_2 = this.title.textHeight;
                    }
                }
                _loc_3 = _loc_3.parent;
            }
            return _loc_2;
        }// end function

        public function set isOpen(param1:Boolean) : void
        {
            this._isOpen = param1;
            return;
        }// end function

        public function realseSelected(event:MouseEvent) : void
        {
            var _loc_2:ModelComponent = null;
            if (this.parentmodel != null)
            {
                _loc_2 = this.modelView.container;
                _loc_2.getObjectHandles().selectionManager.clearSelection();
            }
            this.clearSelected(this.modelView.getModels(), this.parentmodel != null ? (this.parentmodel.modelId) : (""));
            return;
        }// end function

        private function changeLinkLineColor(param1:Array, param2:Boolean) : void
        {
            var _loc_3:Line = null;
            for each (_loc_3 in param1)
            {
                
                _loc_3.lineAlpha = 0.5;
                if (param2)
                {
                    _loc_3.lineColor = colorProperty.mouselinecolor;
                }
                else
                {
                    _loc_3.lineColor = colorProperty.linecolor;
                }
                _loc_3.paint();
            }
            return;
        }// end function

        public function getExHeight() : int
        {
            var _loc_5:DisplayElement = null;
            var _loc_6:Number = NaN;
            var _loc_1:Number = 26;
            var _loc_2:Number = 0;
            var _loc_3:Number = 0;
            var _loc_4:Number = 0;
            if (this.isOpen)
            {
                for each (_loc_5 in this.subModels)
                {
                    
                    if (_loc_5.rowNumber > _loc_4)
                    {
                        _loc_4 = _loc_5.rowNumber;
                    }
                }
                _loc_3 = _loc_3 - (_loc_4 + 1) * 10;
                while (_loc_4 >= 0)
                {
                    
                    for each (_loc_5 in this.subModels)
                    {
                        
                        if (_loc_4 == _loc_5.rowNumber)
                        {
                            _loc_6 = _loc_5.getExHeight() + _loc_5.parentmodel.grid.getGasHeight() * 2;
                            if (_loc_2 < _loc_6)
                            {
                                _loc_2 = _loc_6;
                            }
                        }
                    }
                    _loc_3 = _loc_3 + (_loc_2 + 10);
                    _loc_2 = 0;
                    _loc_4 = _loc_4 - 1;
                }
            }
            return _loc_1 + _loc_3;
        }// end function

        public function set parentmdid(param1:String) : void
        {
            this._parentmdid = param1;
            return;
        }// end function

        public function setNotRelatedModelColor(param1:Boolean) : void
        {
            var _loc_2:DisplayElement = null;
            if (notRelatedModelDic == null)
            {
                notRelatedModelDic = new Dictionary();
                searchNotRelatedModel(this.modelView.getModels());
            }
            for each (_loc_2 in this.notRelatedModelDic)
            {
                
                if (_loc_2.modelId != this.modelId)
                {
                    if (param1)
                    {
                        GraphicUtil.drawRectOne(_loc_2, 0.8, 0.8);
                        GraphicUtil.turnModelTextColor(colorProperty.linecolor, _loc_2);
                        _loc_2.setLineAlpha(_loc_2, 0.1);
                        continue;
                    }
                    GraphicUtil.drawRectOne(_loc_2);
                    _loc_2.setLineAlpha(_loc_2, 0.5);
                    GraphicUtil.turnModelTextColor(colorProperty.fontcolor, _loc_2);
                }
            }
            return;
        }// end function

        public function get defaultModelWidth() : Number
        {
            return this._defaultModelWidth;
        }// end function

        public function get basicLineColor() : uint
        {
            return this._basicLineColor;
        }// end function

        public function set mdname(param1:String) : void
        {
            this._mdname = param1;
            return;
        }// end function

        public function get mdtype() : String
        {
            return this._mdtype;
        }// end function

        public function buildToModels() : void
        {
            var line:Line;
            this.toModels = [];
            try
            {
                var _loc_2:int = 0;
                var _loc_3:* = this.lines;
                while (_loc_3 in _loc_2)
                {
                    
                    line = _loc_3[_loc_2];
                    if (line.fromModel == this)
                    {
                        this.toModels.push(line.toModel);
                    }
                }
            }
            catch (e:Error)
            {
            }
            return;
        }// end function

        public function getLinkFromLine(param1:DisplayElement) : Line
        {
            var _loc_2:Line = null;
            var _loc_4:Line = null;
            buildFromLines();
            var _loc_3:* = getFromLines();
            for each (_loc_4 in _loc_3)
            {
                
                if (_loc_4.fromModel.modelId == param1.modelId)
                {
                    _loc_2 = _loc_4;
                }
            }
            return _loc_2;
        }// end function

        public function set setgrid(param1:Grid) : void
        {
            this.grid = param1;
            return;
        }// end function

        public function get image() : Image
        {
            return this._image;
        }// end function

        public function lineRemoveColorDispatchEvent() : void
        {
            var _loc_1:Line = null;
            for each (_loc_1 in lines)
            {
                
                _loc_1.lineAlpha = 0.5;
                _loc_1.lineColor = colorProperty.linecolor;
                _loc_1.paint();
            }
            return;
        }// end function

        public function set defaultModelHeight(param1:Number) : void
        {
            this._defaultModelHeight = param1;
            return;
        }// end function

        public function drawLine(param1:Number, param2:Number, param3:Number, param4:Number, param5:Number, param6:Number) : void
        {
            var _loc_7:Number = NaN;
            var _loc_8:Number = NaN;
            var _loc_9:Number = NaN;
            var _loc_10:uint = 0;
            var _loc_11:Number = NaN;
            var _loc_12:Number = NaN;
            var _loc_13:Number = NaN;
            var _loc_14:Number = NaN;
            var _loc_15:uint = 0;
            var _loc_16:Number = NaN;
            var _loc_17:Number = NaN;
            var _loc_18:Number = NaN;
            var _loc_19:Number = NaN;
            if (param1 != param3 || param2 != param4)
            {
                _loc_7 = param5 + param6;
                _loc_8 = Math.sqrt((param1 - param3) * (param1 - param3) + (param2 - param4) * (param2 - param4));
                _loc_9 = Math.atan((param4 - param2) / (param3 - param1));
                _loc_10 = _loc_8 / (param5 + param6);
                _loc_11 = param5 * Math.cos(_loc_9);
                if (param3 < param1)
                {
                    _loc_11 = _loc_11 * -1;
                }
                _loc_12 = param5 * Math.sin(_loc_9);
                _loc_13 = param6 * Math.cos(_loc_9);
                if (param3 < param1)
                {
                    _loc_13 = _loc_13 * -1;
                }
                _loc_14 = param6 * Math.sin(_loc_9);
                _loc_15 = 0;
                while (_loc_15++ < _loc_10)
                {
                    
                    if (param1 == param3 && param2 != param4)
                    {
                        var _loc_20:* = param1;
                        _loc_18 = param1;
                        _loc_16 = _loc_20;
                        if (param4 > param2)
                        {
                            _loc_17 = param2 + (_loc_15 - 1) * (param5 + param6);
                            _loc_19 = _loc_17 + param5;
                        }
                        else
                        {
                            _loc_17 = param2 - (_loc_15 - 1) * (param5 + param6);
                            _loc_19 = _loc_17 - param5;
                        }
                    }
                    else if (param2 == param4 && param1 != param3)
                    {
                        _loc_20 = param2;
                        _loc_19 = param2;
                        _loc_17 = _loc_20;
                        if (param3 > param1)
                        {
                            _loc_16 = param1 + (_loc_15 - 1) * (param5 + param6);
                            _loc_18 = _loc_16 + param5;
                        }
                        else
                        {
                            _loc_16 = param1 - (_loc_15 - 1) * (param5 + param6);
                            _loc_18 = _loc_16 - param5;
                        }
                    }
                    graphics.moveTo(_loc_16, _loc_17);
                    graphics.lineTo(_loc_18, _loc_19);
                }
            }
            return;
        }// end function

        public function get modelName() : String
        {
            return this._modelName;
        }// end function

        public function searchNotRelatedModel(param1:Array) : void
        {
            var _loc_2:DisplayElement = null;
            for each (_loc_2 in param1)
            {
                
                if (!_loc_2.bisAnalysicLinkModel)
                {
                    if (notRelatedModelDic[_loc_2.modelId] != _loc_2)
                    {
                        notRelatedModelDic[_loc_2.modelId] = _loc_2;
                    }
                }
                if (_loc_2.subModels.length > 0 && _loc_2.isOpen)
                {
                    searchNotRelatedModel(_loc_2.subModels);
                }
            }
            return;
        }// end function

        public function getPointModel(param1:DisplayElement) : DisplayElement
        {
            var _loc_2:* = param1;
            var _loc_3:* = param1;
            while (_loc_3.parentmodel != null)
            {
                
                _loc_3 = _loc_3.parentmodel;
                if (!_loc_3.container.visible)
                {
                    _loc_2 = _loc_3;
                }
            }
            return _loc_2;
        }// end function

        public function getIsDashModel() : Boolean
        {
            return this.isDashModel;
        }// end function

        public function set xPos(param1:Number) : void
        {
            this._xPos = param1;
            return;
        }// end function

        public function set detailInfoWin(param1:MyCustomPopUpWin) : void
        {
            this._detailInfoWin = param1;
            return;
        }// end function

        public function get modelView() : ModelView
        {
            return this._modelView;
        }// end function

        public function set parentmodel(param1:DisplayElement) : void
        {
            this._parentmodel = param1;
            return;
        }// end function

        public function set rowNumber(param1:int) : void
        {
            this._rowNumber = param1;
            return;
        }// end function

        public function setLineAlpha(param1:DisplayElement, param2:Number) : void
        {
            var _loc_3:Line = null;
            var _loc_4:DisplayElement = null;
            for each (_loc_3 in param1.lines)
            {
                
                _loc_3.lineAlpha = param2;
                _loc_3.paint();
            }
            if (param1.isOpen && param1.submodels.length > 0)
            {
                for each (_loc_4 in param1.subModels)
                {
                    
                    setLineAlpha(_loc_4, param2);
                }
            }
            return;
        }// end function

        public function lineRemoveEventDispatchEvent() : void
        {
            var _loc_1:Line = null;
            for each (_loc_1 in this.modelView.getLines())
            {
                
                _loc_1.removeEventListener(MouseEvent.MOUSE_OUT, _loc_1.colorOutLineHandler);
                _loc_1.removeEventListener(MouseEvent.MOUSE_OVER, _loc_1.colorOverLineHandler);
            }
            return;
        }// end function

        public function set subModels(param1:Array) : void
        {
            this.submodels = param1;
            this.grid.init(this.submodels);
            return;
        }// end function

        public function get getgrid() : Grid
        {
            return this.grid;
        }// end function

        public function getLinkToLine(param1:DisplayElement) : Line
        {
            var _loc_2:Line = null;
            var _loc_4:Line = null;
            buildToLines();
            var _loc_3:* = this.getToLines();
            for each (_loc_4 in _loc_3)
            {
                
                if (_loc_4.toModel.modelId == param1.modelId)
                {
                    _loc_2 = _loc_4;
                }
            }
            return _loc_2;
        }// end function

        public function set basicColor(param1:uint) : void
        {
            this._basicColor = param1;
            return;
        }// end function

        public function buildFromModels() : void
        {
            var line:Line;
            this.fromModels = [];
            try
            {
                var _loc_2:int = 0;
                var _loc_3:* = this.lines;
                while (_loc_3 in _loc_2)
                {
                    
                    line = _loc_3[_loc_2];
                    if (line.toModel == this)
                    {
                        this.fromModels.push(line.fromModel);
                    }
                }
            }
            catch (e:Error)
            {
            }
            return;
        }// end function

        public function get rowNumber() : int
        {
            return this._rowNumber;
        }// end function

        public function set rectOne(param1:Sprite) : void
        {
            this._rectOne = param1;
            return;
        }// end function

        public function searchUpLinkModels(param1:DisplayElement) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_4:Line = null;
            var _loc_5:String = null;
            if (linkNodesIdCollection == null)
            {
                return;
            }
            param1.buildFromModels();
            var _loc_2:* = param1.getFromModels();
            if (_loc_2.length > 0)
            {
                for each (_loc_3 in _loc_2)
                {
                    
                    _loc_4 = param1.getLinkFromLine(_loc_3);
                    if (_loc_3.modelId == this.modelId)
                    {
                        continue;
                        continue;
                    }
                    _loc_5 = _loc_3.modelId;
                    if (!linkNodesIdCollection.contains(_loc_5))
                    {
                        continue;
                    }
                    this.linkLines.push(_loc_4);
                    if (this.linkUpModelsDic[_loc_5] != _loc_3)
                    {
                        this.linkUpModelsDic[_loc_5] = _loc_3;
                        searchUpLinkModels(_loc_3);
                    }
                }
            }
            return;
        }// end function

        public function set modelState(param1:ModelState) : void
        {
            this._modelState = param1;
            return;
        }// end function

        public function set colNumber(param1:int) : void
        {
            this._colNumber = param1;
            return;
        }// end function

        public function get basicColor() : uint
        {
            return this._basicColor;
        }// end function

        public function get rectOne() : Sprite
        {
            return this._rectOne;
        }// end function

        public function set rectX(param1:Number) : void
        {
            this._rectX = param1;
            return;
        }// end function

        public function set rectY(param1:Number) : void
        {
            this._rectY = param1;
            return;
        }// end function

        public function set extensible(param1:IExtendBehavior) : void
        {
            param1.model = this;
            this._extensible = param1;
            return;
        }// end function

        public function set lines(param1:Array) : void
        {
            this._lines = param1;
            return;
        }// end function

    }
}
