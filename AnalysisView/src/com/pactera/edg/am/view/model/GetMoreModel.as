package com.pactera.edg.am.view.model
{
    import flash.display.*;
    import flash.events.*;
    import flash.geom.*;
    
    import mx.controls.*;
    import mx.core.*;
    import mx.managers.*;

//得到更多特殊显示模型
//在子节点较多的情况下，通过该对象，和用户交互
//作用：
//1.提示用户还有更多对象未显示
//2.用户点击该对象图标后，可再显示100条
//通过该对象，屏蔽一次显示7000个子节点的做法
    public class GetMoreModel extends DisplayElement implements IFocusManagerComponent
    {
        private static const defaultIcon1:Class = GetMoreModel_defaultIcon1;

        public function GetMoreModel()
        {
            this.addEventListener(FocusEvent.FOCUS_OUT, myObject.focusEventOutHandler, false, 0, true);
            return;
        }// end function

        override public function getRightPoint(param1:UIComponent) : Point
        {
            var _loc_2:DisplayElement = null;
            var _loc_3:Number = NaN;
            var _loc_4:Number = NaN;
            var _loc_5:Point = null;
            if (this.parentmodel == null || this.parentmodel.isOpen)
            {
                _loc_2 = this.getPointModel(this);
                _loc_3 = 0;
                _loc_4 = 0;
                if (_loc_2.parentmodel == null)
                {
                    _loc_3 = _loc_2.getExWidth();
                }
                else
                {
                    _loc_3 = _loc_2.parentmodel.grid.getColMaxWidth(_loc_2.colNumber);
                }
                _loc_4 = (_loc_2.title.textHeight + 10) / 2;
                _loc_5 = new Point(_loc_3, _loc_4);
                return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
            }
            else
            {
                return this.parentmodel.getRightPoint(param1);
            }
        }// end function

        override public function getBottomPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = _loc_2.getExWidth() / 2;
            var _loc_4:* = _loc_2.title.textHeight + 10;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override public function getTopPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = _loc_2.getExWidth() / 2;
            var _loc_4:Number = 0;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            var _loc_3:Number = 0;
            if (this.parentmodel == null)
            {
                _loc_3 = getExWidth();
            }
            else
            {
                _loc_3 = this.parentmodel.grid.getColMaxWidth(this.colNumber);
            }
            var _loc_4:* = this.getExHeight();
            this.isOpen = true;
            this.setActualSize(_loc_3, _loc_4);
            var _loc_5:* = Math.round((_loc_4 - 15) / 2);
            iconObject1.setActualSize(15, 15);
            iconObject1.move(8 + 5, _loc_5);
            //zzg 2011-12-14 将iconObject1的z-index调整，便于响应点击事件
             this.setChildIndex(iconObject1, (this.numChildren - 1));
            title.setActualSize(title.textWidth + 5, title.textHeight + 5);
            title.move(8 + 15 + 5, _loc_5);
//            if (this.bisAnalysicModel)
//            {
//                basicColor = ColorProperty.analysisModelSecondColor;
//            }
//            else
//            {
				//zzg 2011-12-15 修改定制getMore颜色
                this.defineColor = colorProperty.getMoreModelColor;//colorProperty.basfillcolor;
                basicColor = this.defineColor;
//            }
            basicLineColor = this.colorProperty.linecolor;
            GraphicUtil.turnModelColor(basicLineColor, basicColor, this);
            GraphicUtil.drawRectOne(this);
            var _loc_6:* = checkParentStat(this);
            if (checkParentStat(this))
            {
                this.linesDispatchEvent();
            }
            else
            {
                operModelLines(this);
            }
            return;
        }// end function

        override public function getLeftPoint(param1:UIComponent) : Point
        {
            var _loc_2:DisplayElement = null;
            var _loc_3:Number = NaN;
            var _loc_4:Number = NaN;
            var _loc_5:Point = null;
            if (this.parentmodel == null || this.parentmodel.isOpen)
            {
                _loc_2 = this.getPointModel(this);
                _loc_3 = 0;
                _loc_4 = 0;
                _loc_3 = 0;
                _loc_4 = (_loc_2.title.textHeight + 10) / 2;
                _loc_5 = new Point(_loc_3, _loc_4);
                return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
            }
            return this.parentmodel.getLeftPoint(param1);
        }// end function

        override protected function createChildren() : void
        {
            super.createChildren();
            if (this.title == null)
            {
                title = createTextField();
                if (this.modelName.length > 20)
                {
                    this.title.text = this.modelName.substr(0, 19) + "...";
                }
                else
                {
                    this.title.text = modelName;
                }
                addChild(DisplayObject(title));
            }
            if (iconObject1 == null)
            {
                iconObject1 = new Image();
                if (this.icon == "" || this.icon == null)
                {
                    iconObject1.load(defaultIcon1);
                }
                else
                {
                    iconObject1.load(this.icon);
                }
                addChild(iconObject1);
                iconObject1.addEventListener(MouseEvent.CLICK,myObject.getMoreImageClick, false, 0, true);
            }
            if (this.rectOne == null)
            {
                rectOne = new Sprite();
                this.addChild(rectOne);
                this.rectOne.addEventListener(MouseEvent.CLICK, myObject.modelClickHandler, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.ROLL_OVER, myObject.modelRollOverHandler, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.ROLL_OUT, myObject.modelRollOutHandler, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.ROLL_OVER, myObject.modelDetailInfoRollOverHandler, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.ROLL_OUT, myObject.modelDetailInfoRollOutHandler, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.MOUSE_DOWN, myObject.modelMouseDownHandler, false, 0, true);
                this.rectOne.addEventListener(MouseEvent.MOUSE_UP, myObject.modelMouseUpHandler, false, 0, true);
                //this.showContextMenu();
            }
            return;
        }// end function

        override protected function measure() : void
        {
            super.measure();
            var exHeight:* = getExHeight();
            this.measuredHeight = getExHeight();
            this.measuredMinHeight = exHeight;
            var exWidth:* = getExWidth();
            this.measuredWidth = getExWidth();
            this.measuredMinWidth = exWidth;
            return;
        }// end function

        //隐藏的xml节点信息
        private var hiddenXml:String="";
        public function setHiddenXmlString(xmlStr:String):void
        {
        	//trace("[setHiddenXmlString]xmlStr:"+xmlStr);
        	hiddenXml=xmlStr;
        }
        public function getHiddenXmlString():String
        {
        	return hiddenXml;
        }
        
    }
}
