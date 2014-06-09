package com.pactera.edg.am.view.model
{
    import com.pactera.edg.am.factory.*;
    import com.pactera.edg.am.view.*;
    import com.pactera.edg.am.view.extender.*;
    import com.pactera.edg.am.view.grid.*;
    import com.pactera.edg.am.view.line.*;
    import com.roguedevelopment.objecthandles.*;
    import com.pactera.edg.am.bi.utils.*;
    
    import flash.display.*;
    import flash.events.*;
    import flash.external.*;
    import flash.geom.*;
    import flash.ui.*;
    import flash.utils.*;
    
    import mx.controls.*;
    import mx.core.*;
    import mx.managers.CursorManager;
    
    
  import mx.events.MenuEvent;
        import mx.core.FlexSprite;
        import com.pactera.edg.am.utilities.RightClickManager;
        import com.pactera.edg.am.view.handler.*;
        
    public class DisplayElement extends UIComponent implements IModel
    {
        protected var _lines:Array;
        public var myObject:DealEvent = null;
        public var bisAnalysicModel:Boolean = false;
        protected var menuBar:Menu;
        public var bisAnalysicLinkModel:Boolean = false;
        private var _rowNumber:int;
        public var colorProperty:ColorProperty = null;
        protected var _iconObject1:Image;
        protected var _image:Image;
        public var defineColor:uint;
        private var _mdtype:String;
        private var refToModels:Array;
        private var _modelType:String;
        private var _modelState:ModelState;
        public var notRelatedModelDic:Dictionary = null;
        private var _extensible:IExtendBehavior;
        private var _rectOne:Sprite;
        protected var submodels:Array;
        private var fromModels:Array;
        protected var _iconObject:Image;
        private var _detailInfoWin:CustomPopUpWin;
        private var toModels:Array;
        private var _modelId:String;
        protected var _parentmodel:DisplayElement;
        protected var _container:ModelContainer;
        public var linkUpModelsDic:Dictionary = null;
        private var _spanrow:int = 1;
        private var _sequence:Number = 0;
        private var _mdcode:String;
        public var linkLines:Array = null;
        public var myTimer:Timer = null;
        private var _stageMouseX:Number;
        private var _stageMouseY:Number;
        private var _isClick:Boolean;
        private var toLines:Array;
        public var grid:Grid;
        private var _icon:String;
        protected var _title:IUITextField;
        public var linkDownModelsDic:Dictionary = null;
        private var _basicLineColor:uint;
        private var _colNumber:int;
        private var _basicColor:uint;
        private var fromLines:Array;
        private var _xPos:Number;
        private var refFromModels:Array;
        private var _isOpen:Boolean;
        public var myGraphicUtil:GraphicUtil = null;
        private var _mdname:String;
        private var _mdStatus:String;
        private var _factory:ModelFactory;
        private var _modelName:String;
        private var _nodeId:String = "";
        private var _mdmodelName:String;
        private var _mdlocation:String;
        private var _modelView:ModelView;
        private var _yPos:Number;
        public static const defaultCloseIcon:Class = DisplayElement_defaultCloseIcon;
        public static const defaultIcon:Class = DisplayElement_defaultIcon;

        //zzg 2011-12-15
        //增加记忆自动排列的位置，便于计算手工偏移相对自动排列的位置偏差
        public var autoPx:Number;
        public var autoPy:Number;
  


        
        public function DisplayElement()
        {
            this.submodels = [];
            this.grid = new Grid();
            this._lines = [];
            this.toModels = new Array();
            this.fromModels = new Array();
            this.refToModels = [];
            this.refFromModels = [];
            this.toLines = new Array();
            this.fromLines = new Array();
            this.isOpen = false;
            this.isClick = false;
            this.myObject = new DealEvent();
            this.myGraphicUtil = new GraphicUtil();
            this.myTimer = new Timer(1000, 1);
            this.colorProperty = new ColorProperty();
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

        public function moveAll() : void
        {
            var _loc_1:DisplayElement = null;
            for each (_loc_1 in this.subModels)
            {
                
                this.grid.moveModel(_loc_1);
            }
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

        public function clearSelected(param1:Array, param2:String) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_4:ModelContainer = null;
            var _loc_5:ObjectHandles = null;
            for each (_loc_3 in param1)
            {
                
                if (_loc_3.subModels.length > 0 && _loc_3.container != null)
                {
                    if (_loc_3.nodeId != param2)
                    {
                        _loc_4 = _loc_3.container;
                        if (_loc_4.getObjectHandles() == null)
                        {
                            continue;
                        }
                        if (_loc_4.getObjectHandles().selectionManager.currentlySelected.length == 1)
                        {
                            _loc_5 = _loc_4.getObjectHandles();
                            _loc_5.selectionManager.clearSelection();
                            _loc_5 = null;
                            break;
                        }
                    }
                    if (_loc_3.isOpen)
                    {
                        this.clearSelected(_loc_3.subModels, param2);
                    }
                }
            }
            return;
        }// end function

        private function getChildWidth(param1:Number) : Number
        {
            var _loc_4:DisplayObject = null;
            var _loc_2:Number = 0;
            var _loc_3:int = 0;
            while (_loc_3 < this.numChildren)
            {
                
                _loc_4 = this.getChildAt(_loc_3) as DisplayObject;
                if (_loc_4 as Image)
                {
                    _loc_2 = _loc_2 + 15;
                }
                else if (_loc_4 as IUITextField)
                {
                    _loc_2 = _loc_2 + this.measureText(this.title.text).width;
                }
                _loc_3++;
            }
            _loc_2 = _loc_2 + 40;
            return Math.max(param1, _loc_2);
        }// end function

        public function get iconObject1() : Image
        {
            return this._iconObject1;
        }// end function

        public function get modelId() : String
        {
            return this._modelId;
        }// end function

        public function recoverModel() : void
        {
            if (this.bisAnalysicModel)
            {
                this.basicColor = colorProperty.analysisModelSecondColor;
            }
            else
            {
                this.basicColor = this.defineColor;
            }
            GraphicUtil.drawRectOne(this, 0.1, 0.1);
            GraphicUtil.turnModelColor(this.colorProperty.linecolor, this.basicColor, this);
            GraphicUtil.turnModelTextColor(this.colorProperty.fontcolor, this);
            this.setLinkLinesColor(false);
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
            return _loc_1;
        }// end function

        public function set iconObject1(param1:Image) : void
        {
            this._iconObject1 = param1;
            return;
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

        public function getToModels() : Array
        {
            return this.toModels;
        }// end function

        public function setLinkLinesColor(param1:Boolean = true) : void
        {
            this.changeLinkLineColor(this.linkLines, param1);
            return;
        }// end function

        public function set modelId(param1:String) : void
        {
            this._modelId = param1;
            return;
        }// end function

        public function operModelLines(param1:DisplayElement) : void
        {
            var _loc_2:Line = null;
            var _loc_3:String = null;
            var _loc_4:String = null;
            if (param1.lines.length > 0)
            {
                for each (_loc_2 in param1.lines)
                {
                    
                    if (_loc_2.toModel.parentmodel != null && _loc_2.fromModel.parentmodel != null)
                    {
                        _loc_3 = _loc_2.toModel.parentmodel.nodeId;
                        _loc_4 = _loc_2.fromModel.parentmodel.nodeId;
                        if (_loc_3 == _loc_4)
                        {
                            param1.removelineDispatchEvent(_loc_2);
                        }
                        else
                        {
                            param1.lineDispatchEvent(_loc_2);
                        }
                        continue;
                    }
                    param1.lineDispatchEvent(_loc_2);
                }
            }
            return;
        }// end function

        public function get mdlocation() : String
        {
            return this._mdlocation;
        }// end function

        public function get spanrow() : int
        {
            return this._spanrow;
        }// end function

        public function setLinkModelColor(param1:Boolean = true) : void
        {
            if (this.linkUpModelsDic == null && this.linkDownModelsDic == null && this.linkLines == null)
            {
                this.linkUpModelsDic = new Dictionary();
                this.linkDownModelsDic = new Dictionary();
                this.linkLines = [];
                this.searchLinkModels(this);
            }
            else if (this is BasicModel)
            {
                this.linkUpModelsDic = new Dictionary();
                this.linkDownModelsDic = new Dictionary();
                this.linkLines = [];
                this.searchLinkModels(this);
            }
            this.bisAnalysicLinkModel = param1;
            this.changeLinkModelColor(this.linkUpModelsDic, param1);
            this.changeLinkModelColor(this.linkDownModelsDic, param1);
            this.changeLinkLineColor(this.linkLines, param1);
            return;
        }// end function

        public function get title() : IUITextField
        {
            return this._title;
        }// end function

        public function get mdStatus() : String
        {
            return this._mdStatus;
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

        public function get icon() : String
        {
            return this._icon;
        }// end function

        public function showContextMenu() : void
        {
        	var wmode:String=com.pactera.edg.am.utilities.MouseWheelEnabler.getBrowserInfo().flashWmode;
        	//trace("wmode:"+wmode);
        	if(wmode!=null&&wmode.toLowerCase()=="opaque"){//增加定制菜单
        		addCustomContextMenuEvent();
        	}
        	//增加传统菜单,支持全屏模式下也能正常操作
        		addNormalContextMenuEvent();
        	
        }
        //增加传统菜单
        public function addNormalContextMenuEvent():void{
            var _loc_4:ContextMenuItem = null;
            var _loc_5:ContextMenuItem = null;
            var _loc_6:ContextMenuItem = null;
            var _loc_1:* = new ContextMenu();
            var _loc_2:* = this.factory.analysisType;
            if (_loc_2 != "7")
            {
                _loc_4 = new ContextMenuItem("影响分析");
                _loc_4.addEventListener(ContextMenuEvent.MENU_ITEM_SELECT, this.getYXAnalysisByContextMenu);
                _loc_5 = new ContextMenuItem("血统分析");
                _loc_5.addEventListener(ContextMenuEvent.MENU_ITEM_SELECT, this.getXYAnalysisByContextMenu);
                _loc_1.customItems.push(_loc_4);
                _loc_1.customItems.push(_loc_5);
            }
            else
            {
                _loc_6 = new ContextMenuItem("ETL任务调度");
                _loc_6.addEventListener(ContextMenuEvent.MENU_ITEM_SELECT, this.getETLJobByContextMenu);
                _loc_1.customItems.push(_loc_6);
            }
            var _loc_3:* = new ContextMenuItem("显示详细信息");
            _loc_3.addEventListener(ContextMenuEvent.MENU_ITEM_SELECT, this.getDetailInfoByContextMenu);
            _loc_1.customItems.push(_loc_3);
            _loc_1.hideBuiltInItems();
            this.rectOne.contextMenu = _loc_1;
            return;
        }// end function
        
        
        
        //增加定制菜单
        public function addCustomContextMenuEvent():void{
        	
        	this.rectOne.addEventListener(RightClickManager.RIGHT_CLICK,onCustomRightClickHandler);
        	
        }
      
        private function rightClickMenuItemHandler(event:MenuEvent) : void
        {
        	   var menuItemIdx:* = event.index;
        	   var anaType:String = this.factory.analysisType;
	            if(anaType!= "7")
	            {
			            switch(menuItemIdx)
			            {
			                case 0:
			                {//影响分析
			                    this.getYXAnalysis(event);
			                    break;
			                }
			                case 1:
			                { //"血统分析"   
			                	 this.getXYAnalysis(event);
			                	break;
			                }
			                case 2:
			                {//"显示详细信息"
			                    this.getDetailInfo(event);
			                    break;
			                }
			                default:
			                {
			                    break;
			                }
			            }
	            }else{
	            	switch(menuItemIdx)
			            {
			                case 0:
			                {//"ETL任务调度"
			                    this.getETLJob(event);
			                    break;
			                }
			                case 1:
			                {//"显示详细信息"
			                    this.getDetailInfo(event);
			                    break;
			                }
			                default:
			                {
			                    break;
			                }
			            }
	            	
	            }
            return;
        	
        	
        }
        private static var rightClickMenu:Menu=null;
        public function removeRightClickMenu():void
        {
        	if(rightClickMenu!=null)
		    {
		     rightClickMenu.hide();
		     //menu.removeEventListener(MenuEvent.ITEM_CLICK,menuItemClickHandler);
		     rightClickMenu=null;
		    }
        }
        public function onCustomRightClickHandler(event:MouseEvent):void
        {
        	//清除定制鼠标
        	CursorManager.removeAllCursors();
        	removeRightClickMenu();
        	  
        	var menuItemData:String;
          
          	var anaType:String = this.factory.analysisType;
            if(anaType!= "7")
            {
            	menuItemData = "<root><node label=\"影响分析\" />" + 
        	 		"<node label=\"血统分析\"  />" + 
        	 		"<node label=\"显示详细信息\" />" + 
        	 		"</root>";
            }else{
            	menuItemData = "<root>"+
        	 		"<node label=\"ETL任务调度\" />" + 
        	 		"<node label=\"显示详细信息\" />" + 
        	 		"</root>";
            }
            
            rightClickMenu=Menu.createMenu(this,menuItemData,false);
  			rightClickMenu.addEventListener("itemClick", this.rightClickMenuItemHandler);
			rightClickMenu.labelField = "@label";
  			var point:Point = new Point(mouseX,mouseY);   
		    point = localToGlobal(point);    
		    rightClickMenu.show(point.x,point.y);
		    return ;
        }






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
	    private function getDetailInfoByContextMenu(event:ContextMenuEvent) : void
        {
        	doDetailInfo() ;
        }
  		private function getDetailInfo(event:MenuEvent) : void
        {
        	doDetailInfo() ;
        }
        private function doDetailInfo() : void
        {
            ExternalInterface.call("MM.Analyse.openMetadata", this.modelId);
            return;
        }// end function

        public function set mdlocation(param1:String) : void
        {
            this._mdlocation = param1;
            return;
        }// end function

        public function getExWidth() : int
        {
        	
        	if(isNeedCache&&exWidth.getValue(this.id)!=null){
        		//trace("DisplayElements...getExWidth() use cache["+this.name+"]");
        	   return exWidth.getValue(this.id) as int;
        	}
        	
            var _loc_5:DisplayElement = null;
            var _loc_6:Number = NaN;
            var _loc_1:Number = 0;
            var _loc_2:Number = 0;
            var _loc_3:Number = 0;
            var _loc_4:Number = 0;
            if (this.isOpen)
            {
                for each (_loc_5 in this.subModels)
                {
                    
                    _loc_4 = Math.max(_loc_5.colNumber, _loc_4);
                }
                _loc_3 = _loc_3 - _loc_4 * 15;
                while (_loc_4 >= 0)
                {
                    
                    for each (_loc_5 in this.subModels)
                    {
                        
                        if (_loc_4 == _loc_5.colNumber)
                        {
                            _loc_6 = _loc_5.getExWidth() + _loc_5.parentmodel.grid.getGasWidth();
                            if (_loc_2 < _loc_6)
                            {
                                _loc_2 = _loc_6;
                            }
                        }
                    }
                    _loc_3 = _loc_3 + (_loc_2 + 25);
                    this.grid.initColMaxWidth(_loc_4, _loc_2 - 10);
                    _loc_2 = 0;
                    _loc_4 = _loc_4 - 1;
                }
            }
            _loc_1 = this.getChildWidth(_loc_1);
            
            
            //缓存，避免递归算法导致性能下降
            exWidth.put(this.id,Math.max(_loc_1, _loc_3));
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

        public function set modelName(param1:String) : void
        {
            this._modelName = param1;
            return;
        }// end function

        public function lineDispatchEvent(param1:Line) : void
        {
            param1.dispatchEvent(new Event(Line.MODEL_MOVE));
            return;
        }// end function

        public function removelineDispatchEvent(param1:Line) : void
        {
            param1.dispatchEvent(new Event(Line.LINE_REMOVE));
            return;
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
                
                if (_loc_1.fromModel.bisAnalysicLinkModel || _loc_1.toModel.bisAnalysicLinkModel)
                {
                    continue;
                }
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

        public function get nodeId() : String
        {
            return this._nodeId;
        }// end function

        public function get detailInfoWin() : CustomPopUpWin
        {
            return this._detailInfoWin;
        }// end function

        public function get parentmodel() : DisplayElement
        {
            return this._parentmodel;
        }// end function

        public function lineColorDispatchEvent() : void
        {
            var _loc_1:Line = null;
            for each (_loc_1 in this.lines)
            {
                
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
            //搜索连接上游模型
            this.searchUpLinkModels(param1);
            //搜索连接下游模型
            this.searchDownLinkModels(param1);
            if (!param1.isOpen)
            {
                for each (_loc_2 in param1.subModels)
                {
                    
                    this.searchLinkModels(_loc_2);
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
                if (!param1.isOpen)
                {
                    param1.parentmodel.extensible.modelState.changeModelState();
                }
                this.setModelOpen(param1.parentmodel);
            }
            return;
        }// end function

        public function set title(param1:IUITextField) : void
        {
            this._title = param1;
            return;
        }// end function

	    private function getXYAnalysisByContextMenu(event:ContextMenuEvent) : void
        {
        	 doXYAnalysis() ;
        }
         private function getXYAnalysis(event:MenuEvent) : void
        {
        	 doXYAnalysis() ;
        }
        private function doXYAnalysis() : void
        {
           // var _loc_2:* = event.target as ContextMenuItem;
            var _loc_3:* = new Object();
            _loc_3["instanceId"] = this.modelId;
            _loc_3["instanceCode"] = this.mdcode;
            _loc_3["analysType"] = "2";
            ExternalInterface.call("sendToJavaScript", _loc_3);
            return;
        }// end function

        public function set mdStatus(param1:String) : void
        {
            this._mdStatus = param1;
            return;
        }// end function

        public function set modelView(param1:ModelView) : void
        {
            this._modelView = param1;
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

        public function findModelById(param1:String) : DisplayElement
        {
            var _loc_2:DisplayElement = null;
            var _loc_3:DisplayElement = null;
            if (this.nodeId == param1)
            {
                return this;
            }
            for each (_loc_2 in this.submodels)
            {
                
                _loc_3 = _loc_2.findModelById(id);
                if (_loc_3 != null)
                {
                    return _loc_3;
                }
            }
            return null;
        }// end function

        public function get colNumber() : int
        {
            return this._colNumber;
        }// end function

        public function getRightPoint(param1:UIComponent) : Point
        {
            if (param1 == null)
            {
                return null;
            }
            return new Point(0, 0);
        }// end function

        public function get modelState() : ModelState
        {
            return this._modelState;
        }// end function

        public function get stageMouseX() : Number
        {
            return this._stageMouseX;
        }// end function

        public function get stageMouseY() : Number
        {
            return this._stageMouseY;
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
		private function getYXAnalysisByContextMenu(event:ContextMenuEvent) : void
        {
        	doYXAnalysis();
        }
         private function getYXAnalysis(event:MenuEvent) : void
        {
        	doYXAnalysis();
        }
        private function doYXAnalysis() : void
        {
            var _loc_2:* = new Object();
            _loc_2["instanceId"] = this.modelId;
            _loc_2["instanceCode"] = this.mdcode;
            _loc_2["analysType"] = "1";
            ExternalInterface.call("sendToJavaScript", _loc_2);
            return;
        }// end function

        public function set icon(param1:String) : void
        {
            this._icon = param1;
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
            if (param1 == null)
            {
                return null;
            }
            return new Point(0, 0);
        }// end function

        public function get lines() : Array
        {
            return this._lines;
        }// end function

        public function removelinesDispatchEvent() : void
        {
            var _loc_1:Line = null;
            for each (_loc_1 in this.lines)
            {
                
                _loc_1.dispatchEvent(new Event(Line.LINE_REMOVE));
            }
            return;
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

        //zzg 2011-12-14
        //移除模型元素
        public function removeModel(param1:DisplayElement):void{
        	//找到对象索引位置
        	var idx:int=this.subModels.indexOf(param1);
        	//通过splice方法，删除Array中对象
        	this.subModels.splice(idx,1);
        	this._container.removeChild(param1);
            return;
        }
        public function addModel(param1:DisplayElement) : void
        {
            this.subModels.push(param1);
            this._container.addChild(param1);
            return;
        }// end function

        public function contract() : void
        {
            this._extensible.contract();
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

        public function get iconObject() : Image
        {
            return this._iconObject;
        }// end function

        public function get yPos() : Number
        {
            return this._yPos;
        }// end function

        //搜索下游模型
        public function searchDownLinkModels(param1:DisplayElement) : void
        {
            var itemDE:DisplayElement = null;
            var line:Line = null;
            var scModelDE:DisplayElement = null;
            var scmNodeId:String = null;
            param1.buildToModels();
            var toModelsArr:Array = param1.getToModels();
            if (toModelsArr.length > 0)
            {
                for each (itemDE in toModelsArr)
                {
                    line = param1.getLinkToLine(itemDE);
                    if (line != null)
                    {
                    	//记录关联线
                        this.linkLines.push(line);
                    }
                    //避免连接循环
                    if (itemDE.nodeId == this.nodeId)
                    {
                        continue;
                    }
                    //获取到合适的已显示元素，避免itemDE父级元素未展开引起的问题。
                    scModelDE = this.getSuperCloseModel(itemDE);
                    scmNodeId = scModelDE.nodeId;
                    if (this.linkDownModelsDic[scmNodeId] != scModelDE)
                    {
                        this.linkDownModelsDic[scmNodeId] = scModelDE;
                        //递归处理完成所有关联模型
                        this.searchDownLinkModels(itemDE);
                    }
                }
            }
            return;
        }// end function

        public function extend() : void
        {
            this._extensible.extend();
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
                if (param2)
                {
                    GraphicUtil.turnModelColor(this.colorProperty.mouselinecolor, _loc_3.basicColor, _loc_3);
                    GraphicUtil.turnModelTextColor(this.colorProperty.mouselinecolor, _loc_3);
                }
                else
                {
                    if (this.checkLinkModelStatus(_loc_4))
                    {
                        continue;
                    }
                    GraphicUtil.turnModelColor(this.colorProperty.linecolor, _loc_3.basicColor, _loc_3);
                    GraphicUtil.turnModelTextColor(this.colorProperty.fontcolor, _loc_3);
                }
                _loc_3.bisAnalysicLinkModel = param2;
            }
            return;
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

        public function realseSelected() : void
        {
            var _loc_2:ModelComponent = null;
            var _loc_3:ObjectHandles = null;
            if (this.parentmodel != null)
            {
                _loc_2 = this.modelView.container;
                if (_loc_2.getObjectHandles() == null)
                {
                    return;
                }
                if (_loc_2.getObjectHandles().selectionManager.currentlySelected.length == 1)
                {
                    _loc_3 = _loc_2.getObjectHandles();
                    _loc_3.selectionManager.clearSelection();
                    _loc_3 = null;
                    return;
                }
            }
            var _loc_1:* = this.parentmodel == null ? ("") : (this.parentmodel.nodeId);
            this.clearSelected(this.modelView.getModels(), _loc_1);
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
                    _loc_3.lineColor = this.colorProperty.mouselinecolor;
                }
                else
                {
                    _loc_3.lineColor = this.colorProperty.linecolor;
                }
                _loc_3.paint();
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
         
      
       
      //内部缓存对象，便于递归算法优化效率
        private static var exHeight:HashMap=new HashMap();
        private static var exWidth:HashMap=new HashMap();
        //默认不启用缓存，增加的缓存机制，只是为了优化部分程序，逐步全面启用。
        public static var isNeedCache:Boolean=false;
        public static function resetExCache(param1:Array):Boolean
        {
          // trace("DisplayElements...resetExCache");
           if(param1==null){
          	 	exHeight.clear();
           	 	exWidth.clear();
           }else{
           	    var item:DisplayElement = null;
	           	for each ( item in param1){
	           		exWidth.remove(item.id);
	           		exHeight.remove(item.id);
	           	}
           }
           //标识启用缓存
           isNeedCache=true;
           return true;
        }
        
		//计算高度
        public function getExHeight() : int
        {
        	if(isNeedCache&&exHeight.getValue(this.id)!=null){
        		//trace("DisplayElements...getExHeight() use cache["+this.name+"]");
        	   return exHeight.getValue(this.id) as int ;
        	}
            var sm:DisplayElement = null;
            var rowHeight:Number = NaN;
            //默认行高
            var defualtRowHeight:Number = 26;
            if (!this.isOpen && this as SwimModel)
            {
                var _loc_7:int = 56;
                defualtRowHeight = 56;
                trace("[SwimModel]"+this.modelName+",("+this.rowNumber+","+this.colNumber+"),"+(_loc_7));
                // 保存起来，避免重算
                exHeight.put(this.id,_loc_7);
                return _loc_7;
               //return _loc_7;
            }
            //最大rowNumber的子模型的占位高度
            var rowMaxHeight:Number = 0;
            //间距
            var subModelHeight:Number = 0;
            //子模型最大的rowNumber
            var submodelsMaxRowNumber:Number = 0;
            if (this.isOpen)
            {
            	//遍历子模型元素，获取rowNumber最大值
                for each (sm in this.subModels)
                {
                    
                    submodelsMaxRowNumber = Math.max(sm.rowNumber, submodelsMaxRowNumber);
                }
                subModelHeight = subModelHeight - (submodelsMaxRowNumber + 1) * 10;
                while (submodelsMaxRowNumber >= 0)
                {
                    
                     //取每行最大高度
                    for each (sm in this.subModels)
                    {
                        if (submodelsMaxRowNumber == sm.rowNumber)
                        {
                        	//计算_loc_5元素的占位高度，
                            rowHeight = sm.getExHeight() + sm.parentmodel.grid.getGasHeight() * 2;
                            //如果比标准_loc_2大，则以_loc_6为准
                            if (rowMaxHeight < rowHeight)
                            {
                                rowMaxHeight = rowHeight;
                            }
                        }
                    }
                    //不断累计子元素的高度
                    subModelHeight = subModelHeight + (rowMaxHeight + 10);
                    
                    //准备取下一行的行高值
                    rowMaxHeight = 0;
                    submodelsMaxRowNumber = submodelsMaxRowNumber - 1;
                }
            }
           //trace("[normal]"+this.modelName+",("+this.rowNumber+","+this.colNumber+"),"+(defualtRowHeight + subModelHeight));
            //保存起来
            exHeight.put(this.id,defualtRowHeight + subModelHeight);
            return defualtRowHeight + subModelHeight;
           // return defualtRowHeight + subModelHeight;
        }// end function

        public function set mdmodelName(param1:String) : void
        {
            this._mdmodelName = param1;
            return;
        }// end function

        public function setNotRelatedModelColor(param1:Boolean) : void
        {
            var _loc_2:DisplayElement = null;
            this.notRelatedModelDic = null;
            this.notRelatedModelDic = new Dictionary();
            this.searchNotRelatedModel(this.modelView.getModels());
            for each (_loc_2 in this.notRelatedModelDic)
            {
                
                this.changeNotRelatedModleColor(_loc_2, param1);
            }
            return;
        }// end function

        public function get basicLineColor() : uint
        {
            return this._basicLineColor;
        }// end function

        public function getRefToModels() : Array
        {
            return this.refToModels;
        }// end function

        public function set mdname(param1:String) : void
        {
            this._mdname = param1;
            return;
        }// end function

        public function set setgrid(param1:Grid) : void
        {
            this.grid = param1;
            return;
        }// end function

        public function buildToModels() : void
        {
            var line:Line;
            try
            {
                var idx:String ;
                var lineArr:Array = this.lines;
                for (idx in lineArr)
                {
                    line = lineArr[idx];
                    if (line.refFlag)
                    {
                        if (line.fromModel == this)
                        {
                            this.toModels.push(line.toModel);
                            this.fromModels.push(line.toModel);
                        }
                        else if (line.toModel == this)
                        {
                            this.toModels.push(line.fromModel);
                            this.fromModels.push(line.fromModel);
                        }
                        continue;
                    }
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

        //检查显示元素的父级状态是否是打开状态
        //便于判断显示元素是否是正常显示，避免是隐藏状态
        public function checkParentStat(param1:DisplayElement) : Boolean
        {
            var _loc_2:Boolean = false;
            if (param1.parentmodel == null)
            {
                return true;
            }
            if (param1.parentmodel.isOpen)
            {
                _loc_2 = this.checkParentStat(param1.parentmodel);
            }
            return _loc_2;
        }// end function

        public function get image() : Image
        {
            return this._image;
        }// end function

        public function lineRemoveColorDispatchEvent() : void
        {
            var _loc_1:Line = null;
            for each (_loc_1 in this.lines)
            {
                
                _loc_1.dispatchEvent(new Event(Line.LINE_REMOVECOLOR));
            }
            return;
        }// end function

        public function getLinkFromLine(param1:DisplayElement) : Line
        {
            var _loc_2:Line = null;
            var _loc_4:Line = null;
            this.buildFromLines();
            var _loc_3:* = this.getFromLines();
            for each (_loc_4 in _loc_3)
            {
                
                if (_loc_4.fromModel.modelId == param1.modelId)
                {
                    _loc_2 = _loc_4;
                }
            }
            return _loc_2;
        }// end function

        private function checkNotRelatedModelStatus(param1:String) : Boolean
        {
            var _loc_3:DisplayElement = null;
            var _loc_2:Boolean = false;
            for each (_loc_3 in this.modelView.clickedModles)
            {
                
                if (_loc_3 == null)
                {
                    continue;
                }
                if (_loc_3.nodeId == this.nodeId)
                {
                    continue;
                }
                if (_loc_3.notRelatedModelDic[param1] != null)
                {
                    _loc_2 = true;
                    break;
                }
            }
            return _loc_2;
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
                    if (this.notRelatedModelDic[_loc_2.nodeId] != _loc_2)
                    {
                        this.notRelatedModelDic[_loc_2.nodeId] = _loc_2;
                    }
                }
                if (_loc_2.subModels.length > 0 && _loc_2.isOpen)
                {
                    this.searchNotRelatedModel(_loc_2.subModels);
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
                if (_loc_3.container == null)
                {
                    _loc_2 = _loc_3;
                    continue;
                }
                if (!_loc_3.container.visible)
                {
                    _loc_2 = _loc_3;
                }
            }
            return _loc_2;
        }// end function

        public function get modelView() : ModelView
        {
            return this._modelView;
        }// end function

        public function set xPos(param1:Number) : void
        {
            this._xPos = param1;
            return;
        }// end function

        public function set nodeId(param1:String) : void
        {
            this._nodeId = param1;
            return;
        }// end function

        public function genContainerObjectHandles(param1:DisplayElement) : void
        {
            param1.container.genObjectHandles();
            if (param1.parentmodel != null)
            {
                this.genContainerObjectHandles(param1.parentmodel);
            }
            param1 = null;
            return;
        }// end function

        public function set parentmodel(param1:DisplayElement) : void
        {
            this._parentmodel = param1;
            return;
        }// end function

        public function set detailInfoWin(param1:CustomPopUpWin) : void
        {
            this._detailInfoWin = param1;
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

        public function set rowNumber(param1:int) : void
        {
            this._rowNumber = param1;
            return;
        }// end function

        public function linesDispatchEvent() : void
        {
            var _loc_1:Line = null;
            for each (_loc_1 in this.lines)
            {
                
                _loc_1.dispatchEvent(new Event(Line.MODEL_MOVE));
            }
            return;
        }// end function

        public function set sequence(param1:Number) : void
        {
            this._sequence = param1;
            return;
        }// end function

        public function removeAllLineColorDispatchEvent(param1:DisplayElement) : void
        {
            var _loc_2:Line = null;
            var _loc_3:DisplayElement = null;
            if (this.checkParentStat(param1))
            {
                for each (_loc_2 in param1.lines)
                {
                    
                    _loc_2.dispatchEvent(new Event(Line.LINE_REMOVECOLOR));
                }
            }
            else
            {
                this.operModelLines(param1);
            }
            if (param1.subModels.length > 0)
            {
                for each (_loc_3 in param1.subModels)
                {
                    
                    this.removeAllLineColorDispatchEvent(_loc_3);
                }
            }
            return;
        }// end function

        public function setLineAlpha(param1:DisplayElement, param2:Number) : void
        {
            var _loc_3:Line = null;
            for each (_loc_3 in param1.lines)
            {
                
                _loc_3.lineAlpha = param2;
                _loc_3.paint();
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

        public function get mdmodelName() : String
        {
            return this._mdmodelName;
        }// end function

        public function getLinkToLine(param1:DisplayElement) : Line
        {
            var _loc_2:Line = null;
            var _loc_4:Line = null;
            this.buildToLines();
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

        public function allLineColorDispatchEvent(param1:DisplayElement) : void
        {
            var _loc_2:Line = null;
            var _loc_3:DisplayElement = null;
            if (this.checkParentStat(param1))
            {
                for each (_loc_2 in param1.lines)
                {
                    
                    _loc_2.dispatchEvent(new Event(Line.LINE_SETCOLOR));
                }
            }
            else
            {
                this.operModelLines(param1);
            }
            if (param1.subModels.length > 0)
            {
                for each (_loc_3 in param1.subModels)
                {
                    
                    this.allLineColorDispatchEvent(_loc_3);
                }
            }
            return;
        }// end function

        //获取可用的显示状态，避免对象的上级被收拢引起的显示问题
        //该函数返回合适的已显示对象。
        public function getSuperCloseModel(param1:DisplayElement) : DisplayElement
        {
        	//检查父级对象状态是否是打开状态
            if (this.checkParentStat(param1))
            {
                return param1;
            }
            //如果父级状态未打开，则获取父级对象模型的已显示对象。
            return this.getSuperCloseModel(param1.parentmodel);
        }// end function

        public function buildFromModels() : void
        {
            var line:Line;
            try
            {
                var idx:String ;
                var lineArr:Array = this.lines;
                //zzg 2011-12-15 纠正反编译错漏
                //  while (_loc_3 in _loc_2)
                for (idx in lineArr)
                {
                    
                    line = lineArr[idx];
                    if (line.refFlag)
                    {
                        if (line.toModel == this)
                        {
                            this.toModels.push(line.fromModel);
                            this.fromModels.push(line.fromModel);
                        }
                        else if (line.fromModel == this)
                        {
                            this.toModels.push(line.toModel);
                            this.fromModels.push(line.toModel);
                        }
                        continue;
                    }
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
            var _loc_5:DisplayElement = null;
            var _loc_6:String = null;
            param1.fromModels = [];
            param1.toModels = [];
            param1.buildFromModels();
            var _loc_2:* = param1.getFromModels();
            if (_loc_2.length > 0)
            {
                for each (_loc_3 in _loc_2)
                {
                    
                    _loc_4 = param1.getLinkFromLine(_loc_3);
                    if (_loc_4 != null)
                    {
                        this.linkLines.push(_loc_4);
                    }
                    if (_loc_3.nodeId == this.nodeId)
                    {
                        continue;
                    }
                    _loc_5 = this.getSuperCloseModel(_loc_3);
                    _loc_6 = _loc_5.nodeId;
                    if (this.linkUpModelsDic[_loc_6] != _loc_5)
                    {
                        this.linkUpModelsDic[_loc_5.nodeId] = _loc_5;
                        this.searchUpLinkModels(_loc_3);
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

        public function get sequence() : Number
        {
            return this._sequence;
        }// end function
        private function getETLJobByContextMenu(event:ContextMenuEvent) : void
        {
        	doETLJob();
        }
 		private function getETLJob(event:MenuEvent) : void
        {
        	doETLJob();
        }
        private function doETLJob() : void
        {
            var _loc_2:* = new Object();
            _loc_2["instanceId"] = this.modelId;
            _loc_2["instanceCode"] = this.mdcode;
            _loc_2["analysType"] = "7";
            ExternalInterface.call("sendToJavaScript", _loc_2);
            return;
        }// end function

        public function get rectOne() : Sprite
        {
            return this._rectOne;
        }// end function

        public function get basicColor() : uint
        {
            return this._basicColor;
        }// end function

        public function set stageMouseX(param1:Number) : void
        {
            this._stageMouseX = param1;
            return;
        }// end function

        public function changeNotRelatedModleColor(param1:DisplayElement, param2:Boolean) : void
        {
            if (param2)
            {
                GraphicUtil.drawRectOne(param1, 0.5, 0.5);
                GraphicUtil.turnModelTextColor(this.colorProperty.linecolor, param1);
                param1.setLineAlpha(param1, 0.1);
            }
            else
            {
                GraphicUtil.drawRectOne(param1, 0.1, 0.1);
                param1.setLineAlpha(param1, 0.5);
                GraphicUtil.turnModelTextColor(this.colorProperty.fontcolor, param1);
            }
            param1 = null;
            return;
        }// end function

        public function getRefFromModels() : Array
        {
            return this.refFromModels;
        }// end function

        public function set stageMouseY(param1:Number) : void
        {
            this._stageMouseY = param1;
            return;
        }// end function

        public function set extensible(param1:IExtendBehavior) : void
        {
            param1.model = this;
            this._extensible = param1;
            return;
        }// end function

        private function checkLinkModelStatus(param1:String) : Boolean
        {
            var _loc_3:DisplayElement = null;
            var _loc_2:Boolean = false;
            for each (_loc_3 in this.modelView.clickedModles)
            {
                
                if (_loc_3 == null)
                {
                    continue;
                }
                if (_loc_3.linkDownModelsDic[param1] != null || _loc_3.linkUpModelsDic[param1] != null)
                {
                    _loc_2 = true;
                    break;
                }
            }
            return _loc_2;
        }// end function

        public function set lines(param1:Array) : void
        {
            this._lines = param1;
            return;
        }// end function

    }
}
