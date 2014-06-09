package com.pactera.edg.am.kpi.view.model
{
    import com.pactera.edg.am.kpi.factory.*;
    import com.pactera.edg.am.kpi.system.*;
    import com.pactera.edg.am.kpi.view.*;
    import com.pactera.edg.am.kpi.view.dragger.*;
    import com.pactera.edg.am.kpi.view.extender.*;
    import com.pactera.edg.am.kpi.view.grid.*;
    import com.pactera.edg.am.kpi.view.line.*;
    import com.pactera.edg.am.kpi.view.model.*;
    import flash.display.*;
    import flash.events.*;
    import flash.geom.*;
    import mx.controls.*;
    import mx.core.*;
    import mx.events.*;

    public class DisplayElement extends UIComponent implements IModel
    {
        protected var _lines:Array;
        private var _draggable:IDragBehavior;
        private var _modelTip:String;
        private var _drag:Boolean = false;
        private var _fillColor:uint;
        protected var menuBar:Menu;
        private var _isMark:Boolean;
        private var _rowNumber:int;
        protected var _image:Image;
        private var _color:Number = -1;
        private var _mdtype:String;
        private var _modelType:String;
        private var _modelState:ModelState;
        private var _modelGrid:ModelGrid;
        private var _position:Boolean = false;
        private var _extensible:IExtendBehavior;
        private var _isDefaultOpen:Boolean;
        protected var _rectOne:Sprite;
        protected var submodels:Array;
        private var fromModels:Array;
        protected var _iconObject:Image;
        private var _defaultModelWidth:Number;
        private var _menubarXML:XML;
        private var toModels:Array;
        private var _chartXML:XML;
        private var _modelId:String;
        protected var _parentmodel:DisplayElement;
        protected var _container:ModelContainer;
        private var _imageIcon:String;
        private var _spanrow:int = 1;
        private var _isImage:Boolean;
        private var _mdcode:String;
        private var _isClick:Boolean;
        private var toLines:Array;
        protected var grid:Grid;
        private var _rimColor:uint;
        private var _defaultModelHeight:Number;
        private var _mdqid:String;
        private var _icon:String;
        protected var _title:IUITextField;
        private var _canClose:Boolean = true;
        private var _colNumber:int;
        private var fromLines:Array;
        private var rightClickTarget:DisplayObject;
        protected var _modelClass:String;
        private var showMessageStr:Sprite;
        private var _isOpen:Boolean;
        private var _mdname:String;
        private var _factory:ModelFactory;
        private var textField:IUITextField = null;
        private var _modelName:String;
        private var _chartClass:String;
        private var _modelView:ModelView;
        private var _rectX:Number;
        private var _rectY:Number;

        public function DisplayElement()
        {
            submodels = [];
            grid = new Grid();
            _lines = [];
            toModels = new Array();
            fromModels = new Array();
            toLines = new Array();
            fromLines = new Array();
            showMessageStr = new Sprite();
            this.isClick = false;
            this.isMark = false;
            this._rectOne = new Sprite();
            return;
        }// end function

        public function get modelType() : String
        {
            return this._modelType;
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

        public function get mdcode() : String
        {
            return this._mdcode;
        }// end function

        public function get modelGrid() : ModelGrid
        {
            return this._modelGrid;
        }// end function

        public function set canClose(param1:Boolean) : void
        {
            this._canClose = param1;
            return;
        }// end function

        public function set factory(param1:ModelFactory) : void
        {
            this._factory = param1;
            return;
        }// end function

        public function get canClose() : Boolean
        {
            return this._canClose;
        }// end function

        public function clearAll() : void
        {
            this.graphics.clear();
            this.eventRender();
            return;
        }// end function

        public function set modelGrid(param1:ModelGrid) : void
        {
            this._modelGrid = param1;
            return;
        }// end function

        public function moveAll() : void
        {
            var _loc_1:* = null;
            for each (_loc_1 in this.subModels)
            {
                
                this.grid.moveModel(_loc_1);
            }
            return;
        }// end function

        public function get modelId() : String
        {
            return this._modelId;
        }// end function

        public function set isMark(param1:Boolean) : void
        {
            this._isMark = param1;
            return;
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
            return _loc_1;
        }// end function

        public function addLine(param1:Line) : void
        {
            this._lines.push(param1);
            return;
        }// end function

        public function clearModelsInTo(param1:Array) : void
        {
            var _loc_2:* = null;
            for each (_loc_2 in param1)
            {
                
                if (_loc_2.title.text != "")
                {
                    _loc_2.graphics.clear();
                    _loc_2.isClick = true;
                    _loc_2.isMark = true;
                    _loc_2.fillColor = this.factory.getModelViewArgument().toModelFill;
                    _loc_2.rimColor = this.factory.getModelViewArgument().toModelRim;
                    if (this.factory.getViewMapping().isImage)
                    {
                        if (_loc_2.isOpen || _loc_2.parentmodel != null)
                        {
                            this.renderModel(_loc_2);
                        }
                        continue;
                    }
                    this.renderModel(_loc_2);
                }
            }
            return;
        }// end function

        public function get chartClass() : String
        {
            return this._chartClass;
        }// end function

        public function getToModels() : Array
        {
            return this.toModels;
        }// end function

        public function createTextFieldStr() : void
        {
            if (this.textField == null)
            {
                this.textField = IUITextField(createInFontContext(UITextField));
                textField.enabled = enabled;
                textField.ignorePadding = true;
                textField.selectable = false;
                textField.styleName = this;
            }
            if (!this.textField.visible)
            {
                this.textField.visible = true;
            }
            return;
        }// end function

        public function set modelId(param1:String) : void
        {
            this._modelId = param1;
            return;
        }// end function

        public function showMessage() : void
        {
            var _loc_4:* = null;
            var _loc_1:* = 0;
            var _loc_2:* = 0;
            var _loc_3:* = 0;
            while (_loc_2 < this.modelTip.length)
            {
                
                _loc_4 = /^[A-Za-z0-9]+$/;
                if (_loc_4.test(this.modelTip.charAt(_loc_2)))
                {
                    _loc_1 = _loc_1 + 8;
                    _loc_3++;
                }
                else
                {
                    _loc_1 = _loc_1 + 12;
                }
                _loc_2++;
            }
            if (_loc_3 % 2 == 1)
            {
                _loc_1 = _loc_1 + 6;
            }
            this.showMessageStr.graphics.clear();
            this.showMessageStr.graphics.lineStyle(1, 16777215);
            this.showMessageStr.graphics.beginFill(this.factory.getModelViewArgument().messageColor, 0.1);
            this.showMessageStr.graphics.drawRoundRect(this.mouseX + 30, this.mouseY + 10, _loc_1 + 10, 25, 10);
            this.showMessageStr.graphics.endFill();
            this.addChild(this.showMessageStr);
            this.titleStr = this.modelTip;
            return;
        }// end function

        public function set menubarXML(param1:XML) : void
        {
            this._menubarXML = param1;
            return;
        }// end function

        public function get spanrow() : int
        {
            return _spanrow;
        }// end function

        public function get isImage() : Boolean
        {
            return this._isImage;
        }// end function

        public function set position(param1:Boolean) : void
        {
            this._position = param1;
            return;
        }// end function

        public function mouseMoveHandler(event:MouseEvent) : void
        {
            if (event.buttonDown)
            {
                this.canClose = false;
            }
            this._draggable.mouseMoveHandler(event);
            return;
        }// end function

        public function get mdqid() : String
        {
            return this._mdqid;
        }// end function

        public function get title() : IUITextField
        {
            return this._title;
        }// end function

        public function clearLinesInTo(param1:Array) : void
        {
            var _loc_2:* = null;
            for each (_loc_2 in param1)
            {
                
                _loc_2.lineB = 2;
                _loc_2.lineColor = this.factory.getModelViewArgument().toLineColor;
                _loc_2.graphics.clear();
                this.renderLine(_loc_2);
            }
            return;
        }// end function

        public function focusEventOutHandler(event:FocusEvent) : void
        {
            if (!this.factory.getViewMapping().isImage)
            {
                this.isClick = false;
                this.isMark = false;
                this.rimColor = this.factory.getModelViewArgument().rimColor;
                if (this.color == -1 || this.color >= this.factory.getModelViewArgument().customization.length)
                {
                    this.fillColor = this.factory.getModelViewArgument().fillColor;
                }
                else
                {
                    this.fillColor = this.factory.getModelViewArgument().customization[this.color];
                }
                this.clearAll();
                this.buildFromModels();
                this.buildToModels();
                this.clearModelsOut(this);
                this.clearLinesOut(this.buildLines());
            }
            else if (this.isOpen || this.parentmodel != null)
            {
                this.isClick = false;
                this.isMark = false;
                this.rimColor = this.factory.getModelViewArgument().rimColor;
                if (this.color == -1 || this.color >= this.factory.getModelViewArgument().customization.length)
                {
                    this.fillColor = this.factory.getModelViewArgument().fillColor;
                }
                else
                {
                    this.fillColor = this.factory.getModelViewArgument().customization[this.color];
                }
                this.clearAll();
                this.buildFromModels();
                this.buildToModels();
                this.clearModelsOut(this);
                this.clearLinesOut(this.buildLines());
            }
            return;
        }// end function

        public function mouseDownHandler(event:MouseEvent) : void
        {
            this.canClose = true;
            this._draggable.mouseDownHandler(event);
            return;
        }// end function

        public function clearModelsInFrom(param1:Array) : void
        {
            var _loc_2:* = null;
            for each (_loc_2 in param1)
            {
                
                if (_loc_2.title.text != "")
                {
                    _loc_2.graphics.clear();
                    _loc_2.isClick = true;
                    _loc_2.isMark = true;
                    _loc_2.fillColor = this.factory.getModelViewArgument().fromModelFill;
                    _loc_2.rimColor = this.factory.getModelViewArgument().fromModelRim;
                    if (this.factory.getViewMapping().isImage)
                    {
                        if (_loc_2.isOpen || _loc_2.parentmodel != null)
                        {
                            this.renderModel(_loc_2);
                        }
                        continue;
                    }
                    this.renderModel(_loc_2);
                }
            }
            return;
        }// end function

        public function set drag(param1:Boolean) : void
        {
            this._drag = param1;
            return;
        }// end function

        public function initAll() : void
        {
            var _loc_1:* = null;
            for each (_loc_1 in this.subModels)
            {
                
                _loc_1.initAll();
            }
            this.grid.init(this.subModels);
            this.grid.reCalculate(this.subModels);
            return;
        }// end function

        public function set chartClass(param1:String) : void
        {
            this._chartClass = param1;
            return;
        }// end function

        public function get icon() : String
        {
            return this._icon;
        }// end function

        public function get imageIcon() : String
        {
            return this._imageIcon;
        }// end function

        public function set defaultModelWidth(param1:Number) : void
        {
            this._defaultModelWidth = param1;
            return;
        }// end function

        public function get container() : ModelContainer
        {
            if (_container == null)
            {
                return new ModelContainer();
            }
            return this._container;
        }// end function

        public function getDefaultWidth() : int
        {
            if (this._title == null)
            {
                return this.iconObject.width + 5;
            }
            return Math.max(this._container.width, this.iconObject.width + this._title.textWidth);
        }// end function

        public function get isClick() : Boolean
        {
            return this._isClick;
        }// end function

        public function get isOpen() : Boolean
        {
            return this._isOpen;
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
		
        public function getExWidth() : int
        {
            var _loc_5:* = null;
            var _loc_6:* = null;
            //var _loc_1:* = this.defaultModelWidth;
			var _loc_1:* = this.getMaxTitleWidth();
            var _loc_2:* = 0;
            var _loc_3:* = 0;
            var _loc_4:* = 0;
            if (this.isOpen)
            {
                for each (_loc_5 in this.subModels)
                {
                    
                    if (_loc_5.rowNumber > _loc_4)
                    {
                        _loc_4 = _loc_5.rowNumber;
                    }
                }
                while (_loc_4 >= 0)
                {
                    
                    for each (_loc_6 in this.subModels)
                    {
                        
                        if (_loc_4 == _loc_6.rowNumber)
                        {
                            _loc_2 = _loc_2 + (_loc_6.getExWidth() + _loc_6.parentmodel.grid.getGasWidth() * 2);
                        }
                    }
                    if (_loc_3 < _loc_2)
                    {
                        _loc_3 = _loc_2;
                    }
                    _loc_2 = 0;
                    _loc_4 = _loc_4 - 1;
                }
            }
            return Math.max(_loc_1, _loc_3);
        }// end function

        public function mouseDoubleClickHandler(event:MouseEvent) : void
        {
            this.canClose = true;
            this._draggable.mouseDoubleClickHandler(event);
            return;
        }// end function

        public function set spanrow(param1:int) : void
        {
            if (param1 > 0)
            {
                this._spanrow = param1;
            }
            return;
        }// end function

        public function get isDefaultOpen() : Boolean
        {
            return this._isDefaultOpen;
        }// end function

        public function buildFromLines() : void
        {
            var _loc_1:* = null;
            var _loc_2:* = null;
            for each (_loc_1 in this.fromModels)
            {
                
                for each (_loc_2 in _loc_1.lines)
                {
                    
                    if (_loc_2.fromModel == _loc_1)
                    {
                        this.fromLines.push(_loc_2);
                    }
                }
            }
            return;
        }// end function

        public function set modelName(param1:String) : void
        {
            this._modelName = param1;
            return;
        }// end function

        public function get mdname() : String
        {
            return this._mdname;
        }// end function

        public function get defaultModelHeight() : Number
        {
            return this._defaultModelHeight;
        }// end function

        public function set mdtype(param1:String) : void
        {
            this._mdtype = param1;
            return;
        }// end function

        public function lineDispatchEvent() : void
        {
            this._draggable.lineDispatchEvent();
            return;
        }// end function

        public function set image(param1:Image) : void
        {
            this._image = param1;
            return;
        }// end function

        public function set mdqid(param1:String) : void
        {
            this._mdqid = param1;
            return;
        }// end function

        public function set isImage(param1:Boolean) : void
        {
            this._isImage = param1;
            return;
        }// end function

        public function clearModelsOut(param1:DisplayElement) : void
        {
            var _loc_3:* = null;
            var _loc_2:* = param1.ModelInLine();
            for each (_loc_3 in _loc_2)
            {
                
                if (_loc_3.title.text != "")
                {
                    _loc_3.graphics.clear();
                    _loc_3.isClick = false;
                    _loc_3.isMark = false;
                    _loc_3.rimColor = this.factory.getModelViewArgument().rimColor;
                    if (_loc_3.color == -1 || _loc_3.color >= this.factory.getModelViewArgument().customization.length)
                    {
                        _loc_3.fillColor = this.factory.getModelViewArgument().fillColor;
                    }
                    else
                    {
                        _loc_3.fillColor = this.factory.getModelViewArgument().customization[_loc_3.color];
                    }
                    if (this.factory.getViewMapping().isImage)
                    {
                        if (_loc_3.isOpen || _loc_3.parentmodel != null)
                        {
                            this.renderModel(_loc_3);
                        }
                        continue;
                    }
                    this.renderModel(_loc_3);
                }
            }
            return;
        }// end function

        public function getTopPoint(param1:UIComponent) : Point
        {
            return null;
        }// end function

        public function set chartXML(param1:XML) : void
        {
            this._chartXML = param1;
            return;
        }// end function

        public function mouseOutHandler(event:MouseEvent) : void
        {
            if (!this.factory.getViewMapping().isImage)
            {
                if (!this.isMark)
                {
                    if (!this.isClick)
                    {
                        this.rimColor = this.factory.getModelViewArgument().mouseOutRim;
                        if (this.color == -1 || this.color >= this.factory.getModelViewArgument().customization.length)
                        {
                            this.fillColor = this.factory.getModelViewArgument().fillColor;
                        }
                        else
                        {
                            this.fillColor = this.factory.getModelViewArgument().customization[this.color];
                        }
                    }
                    else
                    {
                        this.rimColor = this.factory.getModelViewArgument().mouseOutClickRim;
                        this.fillColor = this.factory.getModelViewArgument().mouseOutClickFill;
                    }
                }
                this.eventRender();
            }
            else if (this.isOpen || this.parentmodel != null)
            {
                if (!this.isMark)
                {
                    if (!this.isClick)
                    {
                        this.rimColor = this.factory.getModelViewArgument().mouseOutRim;
                        if (this.color == -1 || this.color >= this.factory.getModelViewArgument().customization.length)
                        {
                            this.fillColor = this.factory.getModelViewArgument().fillColor;
                        }
                        else
                        {
                            this.fillColor = this.factory.getModelViewArgument().customization[this.color];
                        }
                    }
                    else
                    {
                        this.rimColor = this.factory.getModelViewArgument().mouseOutClickRim;
                        this.fillColor = this.factory.getModelViewArgument().mouseOutClickFill;
                    }
                }
                this.eventRender();
            }
            this.clearModelMessage();
            return;
        }// end function

        public function set color(param1:Number) : void
        {
            this._color = param1;
            return;
        }// end function

        public function get subModels() : Array
        {
            return this.submodels;
        }// end function

        public function getFromModels() : Array
        {
            return this.fromModels;
        }// end function

        public function eventRender() : void
        {
            if (this.title.text != "")
            {
                if (this.modelId == this.modelView.modelViewId)
                {
                    this.rimColor = this.factory.getModelViewArgument().defaultRimColor;
                    this.fillColor = this.factory.getModelViewArgument().defaultFillColor;
                }
                else if (!this.isClick)
                {
                    this.rimColor = this.factory.getModelViewArgument().rimColor;
                    if (this.color == -1 || this.color >= this.factory.getModelViewArgument().customization.length)
                    {
                        this.fillColor = this.factory.getModelViewArgument().fillColor;
                    }
                    else
                    {
                        this.fillColor = this.factory.getModelViewArgument().customization[this.color];
                    }
                }
                this.graphics.clear();
                this.graphics.lineStyle(1, this.rimColor);
                this.graphics.beginFill(this.fillColor);
                if (this.isOpen)
                {
                    this.graphics.drawRoundRect(this.rectX, this.rectY, this.getExWidth(), this.defaultModelHeight, 10);
                }
                else
                {
                    this.graphics.drawRoundRect(this.rectX, this.rectY, this.defaultModelWidth, this.defaultModelHeight, 10);
                }
                this.graphics.endFill();
            }
            return;
        }// end function

        public function getRightPoint(param1:UIComponent) : Point
        {
            return null;
        }// end function

        public function set title(param1:IUITextField) : void
        {
            this._title = param1;
            return;
        }// end function

        public function get parentmodel() : DisplayElement
        {
            return this._parentmodel;
        }// end function

        public function get modelTip() : String
        {
            return this._modelTip;
        }// end function

        public function getFromLines() : Array
        {
            return this.fromLines;
        }// end function

        public function findModelById(param1:String) : DisplayElement
        {
            var _loc_2:* = null;
            var _loc_3:* = null;
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

        public function set modelView(param1:ModelView) : void
        {
            this._modelView = param1;
            return;
        }// end function

        public function get modelState() : ModelState
        {
            return this._modelState;
        }// end function

        public function get colNumber() : int
        {
            return this._colNumber;
        }// end function

        public function menuHandler(event:MenuEvent) : void
        {
            return;
        }// end function

        public function set imageIcon(param1:String) : void
        {
            this._imageIcon = param1;
            return;
        }// end function

        public function renderLine(param1:Line) : void
        {
            param1.paint();
            return;
        }// end function

        public function set icon(param1:String) : void
        {
            this._icon = param1;
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
            var _loc_1:* = null;
            var _loc_2:* = null;
            for each (_loc_1 in this.toModels)
            {
                
                for each (_loc_2 in _loc_1.lines)
                {
                    
                    if (_loc_2.toModel == _loc_1)
                    {
                        this.toLines.push(_loc_2);
                    }
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

        public function getBottomPoint(param1:UIComponent) : Point
        {
            return null;
        }// end function

        public function get lines() : Array
        {
            return this._lines;
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

        public function getLeftPoint(param1:UIComponent) : Point
        {
            return null;
        }// end function

        public function chartRender() : void
        {
            this._rectOne.graphics.clear();
            this._rectOne.graphics.lineStyle(0, 0xFFFFFF, 0.1);
            this._rectOne.graphics.beginFill(0x00FFFF, 0.1);
			//zzg 20130528 调整高度为300
            this._rectOne.graphics.drawRoundRect(this.rectX, this.rectY, 200, 300, 10);
            this._rectOne.graphics.endFill();
            this.addChild(this._rectOne);
            return;
        }// end function

        public function get isMark() : Boolean
        {
            return this._isMark;
        }// end function

        public function get iconObject() : Image
        {
            return this._iconObject;
        }// end function

        public function mouseUpHandler(event:MouseEvent) : void
        {
            this._draggable.mouseUpHandler(event);
            if (this.canClose)
            {
                this._extensible.modelState.changeModelState();
            }
            return;
        }// end function

        public function set draggable(param1:IDragBehavior) : void
        {
            this._draggable = param1;
            return;
        }// end function

        public function getToLines() : Array
        {
            return this.toLines;
        }// end function

        public function getDefaultHeight() : int
        {
            if (this._title == null)
            {
                return 10;
            }
            return this._title.textHeight + 10;
        }// end function

        public function ModelInLine() : Array
        {
            var _loc_2:* = null;
            var _loc_1:* = [];
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

        public function getRelationX(param1:DisplayObjectContainer) : int
        {
            var _loc_4:* = null;
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
            var _loc_4:* = null;
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

        public function get position() : Boolean
        {
            return this._position;
        }// end function

        public function get menubarXML() : XML
        {
            return this._menubarXML;
        }// end function

        public function getExHeight() : int
        {
            var _loc_6:* = null;
            var _loc_7:* = null;
            var _loc_1:* = 15;
            var _loc_2:* = 0;
            var _loc_3:* = 0;
            var _loc_4:* = 0;
            var _loc_5:* = 0;
            if (this.container.visible)
            {
                for each (_loc_6 in this.subModels)
                {
                    
                    if (_loc_6.rowNumber > _loc_5)
                    {
                        _loc_5 = _loc_6.rowNumber;
                    }
                }
                while (_loc_5 >= 0)
                {
                    
                    for each (_loc_7 in this.subModels)
                    {
                        
                        if (_loc_5 == _loc_7.rowNumber)
                        {
                            _loc_2 = _loc_2 + (_loc_7.getExHeight() + _loc_7.parentmodel.grid.getGasHeight() * 2);
                            if (_loc_4 < _loc_2)
                            {
                                _loc_4 = _loc_2;
                            }
                            _loc_2 = 0;
                        }
                    }
                    _loc_3 = _loc_3 + _loc_4;
                    _loc_4 = 0;
                    _loc_5 = _loc_5 - 1;
                }
            }
            if (this.factory.getViewMapping().isImage)
            {
                if (this.parentmodel == null)
                {
                    return _loc_1 + _loc_3 + 50;
                }
                return _loc_1 + _loc_3 + 10;
            }
            else
            {
                return _loc_1 + _loc_3 + 10;
            }
        }// end function

        public function buildLines() : Array
        {
            var _loc_2:* = null;
            var _loc_3:* = null;
            var _loc_4:* = null;
            var _loc_5:* = null;
            var _loc_1:* = [];
            for each (_loc_2 in this.fromModels)
            {
                
                for each (_loc_4 in _loc_2.lines)
                {
                    
                    if (_loc_4.fromModel == _loc_2)
                    {
                        _loc_1.push(_loc_4);
                    }
                }
            }
            for each (_loc_3 in this.toModels)
            {
                
                for each (_loc_5 in _loc_3.lines)
                {
                    
                    if (_loc_5.toModel == _loc_3)
                    {
                        _loc_1.push(_loc_5);
                    }
                }
            }
            return _loc_1;
        }// end function

        public function extend() : void
        {
            _extensible.extend();
            return;
        }// end function

        public function renderModel(param1:DisplayElement) : void
        {
            if (param1.modelId == param1.modelView.modelViewId)
            {
                param1.rimColor = this.factory.getModelViewArgument().defaultRimColor;
                param1.fillColor = this.factory.getModelViewArgument().defaultFillColor;
            }
            param1.graphics.clear();
            param1.graphics.lineStyle(1, param1.rimColor);
            param1.graphics.beginFill(param1.fillColor);
            if (param1.isOpen)
            {
                param1.graphics.drawRoundRect(param1.rectX, param1.rectY, param1.getExWidth(), param1.defaultModelHeight, 10);
            }
            else
            {
                param1.graphics.drawRoundRect(param1.rectX, param1.rectY, param1.defaultModelWidth, param1.defaultModelHeight, 10);
            }
            param1.graphics.endFill();
            return;
        }// end function

        public function get drag() : Boolean
        {
            return this._drag;
        }// end function

        public function clearLinesOut(param1:Array) : void
        {
            var _loc_2:* = null;
            for each (_loc_2 in param1)
            {
                
                _loc_2.lineB = 0.25;
                _loc_2.lineColor = this.factory.getModelViewArgument().lineColor;
                _loc_2.graphics.clear();
                this.renderLine(_loc_2);
            }
            return;
        }// end function

        public function get defaultModelWidth() : Number
        {
            return this._defaultModelWidth;
        }// end function

        public function set fillColor(param1:uint) : void
        {
            this._fillColor = param1;
            return;
        }// end function

        public function set isDefaultOpen(param1:Boolean) : void
        {
            this._isDefaultOpen = param1;
            return;
        }// end function

        public function set setgrid(param1:Grid) : void
        {
            this.grid = param1;
            return;
        }// end function

        public function get mdtype() : String
        {
            return this._mdtype;
        }// end function

        public function set mdname(param1:String) : void
        {
            this._mdname = param1;
            return;
        }// end function

        public function buildToModels() : void
        {
            var _loc_1:* = null;
            for each (_loc_1 in this.lines)
            {
                
                if (_loc_1.fromModel == this)
                {
                    this.toModels.push(_loc_1.toModel);
                }
            }
            return;
        }// end function

        public function get image() : Image
        {
            return this._image;
        }// end function

        public function set defaultModelHeight(param1:Number) : void
        {
            this._defaultModelHeight = param1;
            return;
        }// end function

        public function get chartXML() : XML
        {
            return this._chartXML;
        }// end function

        public function get color() : Number
        {
            return this._color;
        }// end function

        public function set modelTip(param1:String) : void
        {
            this._modelTip = param1;
            return;
        }// end function

        public function get modelName() : String
        {
            return this._modelName;
        }// end function

        public function iconRender() : void
        {
            this._rectOne.graphics.clear();
            this._rectOne.graphics.lineStyle(0, 16777215, 0.1);
            this._rectOne.graphics.beginFill(16777215, 0.1);
            this._rectOne.graphics.drawRoundRect(this._iconObject.x, this._iconObject.y, 15, 15, 10);
            this._rectOne.graphics.endFill();
            this.addChild(this._rectOne);
            return;
        }// end function

        public function set titleStr(param1:String) : void
        {
            var _loc_6:* = null;
            var _loc_2:* = 0;
            var _loc_3:* = 0;
            var _loc_4:* = 0;
            while (_loc_3 < param1.length)
            {
                
                _loc_6 = /^[A-Za-z0-9]+$/;
                if (_loc_6.test(param1.charAt(_loc_3)))
                {
                    _loc_2 = _loc_2 + 8;
                    _loc_4++;
                }
                else
                {
                    _loc_2 = _loc_2 + 12;
                }
                _loc_3++;
            }
            if (_loc_4 % 2 == 1)
            {
                _loc_2 = _loc_2 + 6;
            }
            this.createTextFieldStr();
            var _loc_5:* = this.textField;
            _loc_5.text = param1;
            _loc_5.x = this.mouseX + 32;
            _loc_5.y = this.mouseY + 13;
            _loc_5.width = _loc_2 + 10;
            this.showMessageStr.addChild(DisplayObject(_loc_5));
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

        public function set parentmodel(param1:DisplayElement) : void
        {
            this._parentmodel = param1;
            return;
        }// end function

        public function clearModelMessage() : void
        {
            this.showMessageStr.graphics.clear();
            this.textField.setVisible(false);
            return;
        }// end function

        public function set rowNumber(param1:int) : void
        {
            this._rowNumber = param1;
            return;
        }// end function

        public function get modelView() : ModelView
        {
            return this._modelView;
        }// end function

        public function set subModels(param1:Array) : void
        {
            this.submodels = param1;
            this.grid.init(this.submodels);
            return;
        }// end function

        public function buildRectOne() : void
        {
            this._rectOne.graphics.clear();
            this._rectOne.graphics.lineStyle(0, 16777215, 0.1);
            this._rectOne.graphics.beginFill(16777215, 0.1);
            if (this.isOpen)
            {
                this._rectOne.graphics.drawRoundRect(this.rectX, this.rectY, this.getExWidth(), this.defaultModelHeight, 10);
            }
            else
            {
                this._rectOne.graphics.drawRoundRect(this.rectX, this.rectY, this.defaultModelWidth, this.defaultModelHeight, 10);
            }
            this._rectOne.graphics.endFill();
            this.addChild(this._rectOne);
            if (!this.factory.getViewMapping().isImage || this.isOpen)
            {
                this.eventRender();
            }
            if (this.parentmodel != null)
            {
                this.eventRender();
            }
            return;
        }// end function

        public function get draggable() : IDragBehavior
        {
            return this._draggable;
        }// end function

        public function render() : void
        {
            if (this.modelId == this.modelView.modelViewId)
            {
                this.rimColor = this.factory.getModelViewArgument().defaultRimColor;
                this.fillColor = this.factory.getModelViewArgument().defaultFillColor;
            }
            else if (!this.isClick)
            {
                this.rimColor = this.factory.getModelViewArgument().rimColor;
                if (this.color == -1 || this.color >= this.factory.getModelViewArgument().customization.length)
                {
                    this.fillColor = this.factory.getModelViewArgument().fillColor;
                }
                else
                {
                    this.fillColor = this.factory.getModelViewArgument().customization[this.color];
                }
            }
            this.graphics.clear();
            this.graphics.lineStyle(1, this.rimColor);
            this.graphics.beginFill(this.fillColor);
            if (this.isOpen)
            {
                this.graphics.drawRoundRect(this.rectX, this.rectY, this.getExWidth(), this.defaultModelHeight, 10);
            }
            else
            {
                this.graphics.drawRoundRect(this.rectX, this.rectY, this.defaultModelWidth, this.defaultModelHeight, 10);
            }
            this.graphics.endFill();
            return;
        }// end function

        public function set modelClass(param1:String) : void
        {
            this._modelClass = param1;
            return;
        }// end function

        public function get fillColor() : uint
        {
            return this._fillColor;
        }// end function

        public function get getgrid() : Grid
        {
            return this.grid;
        }// end function

        public function contract() : void
        {
            _extensible.contract();
            return;
        }// end function

        public function iconClickHandler(event:MouseEvent) : void
        {
            this.rimColor = this.factory.getModelViewArgument().mouseClickRim;
            this.fillColor = this.factory.getModelViewArgument().mouseClickFill;
            this.isClick = true;
            this.isMark = true;
            this.buildFromModels();
            this.buildToModels();
            this.buildFromLines();
            this.buildToLines();
            this.clearModelsInFrom(this.getFromModels());
            this.clearModelsInTo(this.getToModels());
            this.clearLinesInFrom(this.getFromLines());
            this.clearLinesInTo(this.getToLines());
            return;
        }// end function

        public function buildFromModels() : void
        {
            var _loc_1:* = null;
            for each (_loc_1 in this.lines)
            {
                
                if (_loc_1.toModel == this)
                {
                    this.fromModels.push(_loc_1.fromModel);
                }
            }
            return;
        }// end function

        public function get rowNumber() : int
        {
            return this._rowNumber;
        }// end function

        public function clearLinesInFrom(param1:Array) : void
        {
            var _loc_2:* = null;
            for each (_loc_2 in param1)
            {
                
                _loc_2.lineB = 2;
                _loc_2.lineColor = this.factory.getModelViewArgument().fromLineColor;
                _loc_2.graphics.clear();
                this.renderLine(_loc_2);
            }
            return;
        }// end function

        public function get modelClass() : String
        {
            return this._modelClass;
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

        public function set rimColor(param1:uint) : void
        {
            this._rimColor = param1;
            return;
        }// end function

        public function mouseClickHandler(event:MouseEvent) : void
        {
            var _loc_2:* = ApplicationConfig.getInstance().modelFactory;
            if (_loc_2.getArguments().istrue)
            {
                this.modelGrid.modelId = this.modelId;
                this.modelGrid.model = this;
                this.modelGrid.buildDataGrid();
                if (!this.factory.getViewMapping().isImage)
                {
                    this.rimColor = this.factory.getModelViewArgument().mouseClickRim;
                    this.fillColor = this.factory.getModelViewArgument().mouseClickFill;
                    this.isClick = true;
                    this.isMark = true;
                    this.clearAll();
                    this.buildFromModels();
                    this.buildToModels();
                    this.buildFromLines();
                    this.buildToLines();
                    this.clearModelsInFrom(this.getFromModels());
                    this.clearModelsInTo(this.getToModels());
                    this.clearLinesInFrom(this.getFromLines());
                    this.clearLinesInTo(this.getToLines());
                }
                else if (this.isOpen || this.parentmodel != null)
                {
                    this.rimColor = this.factory.getModelViewArgument().mouseClickRim;
                    this.fillColor = this.factory.getModelViewArgument().mouseClickFill;
                    this.isClick = true;
                    this.isMark = true;
                    this.clearAll();
                    this.buildFromModels();
                    this.buildToModels();
                    this.buildFromLines();
                    this.buildToLines();
                    this.clearModelsInFrom(this.getFromModels());
                    this.clearModelsInTo(this.getToModels());
                    this.clearLinesInFrom(this.getFromLines());
                    this.clearLinesInTo(this.getToLines());
                }
            }
            else if (this.isOpen || this.parentmodel != null)
            {
                this.rimColor = this.factory.getModelViewArgument().mouseClickRim;
                this.fillColor = this.factory.getModelViewArgument().mouseClickFill;
                this.isClick = true;
                this.isMark = true;
                this.clearAll();
                this.buildFromModels();
                this.buildToModels();
                this.buildFromLines();
                this.buildToLines();
                this.clearModelsInFrom(this.getFromModels());
                this.clearModelsInTo(this.getToModels());
                this.clearLinesInFrom(this.getFromLines());
                this.clearLinesInTo(this.getToLines());
            }
            return;
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

        public function get rimColor() : uint
        {
            return this._rimColor;
        }// end function

        public function mouseOverHandler(event:MouseEvent) : void
        {
            if (!this.factory.getViewMapping().isImage)
            {
                if (!this.isMark)
                {
                    if (!this.isClick)
                    {
                        this.rimColor = this.factory.getModelViewArgument().mouseOverRim;
                        if (this.color == -1 || this.color >= this.factory.getModelViewArgument().customization.length)
                        {
                            this.fillColor = this.factory.getModelViewArgument().fillColor;
                        }
                        else
                        {
                            this.fillColor = this.factory.getModelViewArgument().customization[this.color];
                        }
                    }
                    else
                    {
                        this.rimColor = this.factory.getModelViewArgument().mouseOverClickRim;
                        this.fillColor = this.factory.getModelViewArgument().mouseOverClickFill;
                    }
                }
                this.eventRender();
            }
            else if (this.isOpen || this.parentmodel != null)
            {
                if (!this.isMark)
                {
                    if (!this.isClick)
                    {
                        this.rimColor = this.factory.getModelViewArgument().mouseOverRim;
                        if (this.color == -1 || this.color >= this.factory.getModelViewArgument().customization.length)
                        {
                            this.fillColor = this.factory.getModelViewArgument().fillColor;
                        }
                        else
                        {
                            this.fillColor = this.factory.getModelViewArgument().customization[this.color];
                        }
                    }
                    else
                    {
                        this.rimColor = this.factory.getModelViewArgument().mouseOverClickRim;
                        this.fillColor = this.factory.getModelViewArgument().mouseOverClickFill;
                    }
                }
                this.eventRender();
            }
            this.showMessage();
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
