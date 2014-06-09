package com.pactera.edg.am.kpi.view.model
{
    import com.pactera.edg.am.kpi.rightClick.*;
    import flash.display.*;
    import flash.events.*;
    import flash.geom.*;
    import mx.controls.*;
    import mx.core.*;
    import mx.managers.*;

    public class BasicModel extends DisplayElement implements IFocusManagerComponent
    {
        private static const defaultIcon:Class = BasicModel_defaultIcon;

        public function BasicModel()
        {
            return;
        }// end function

        override public function getRightPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = _loc_2.defaultModelWidth;
            var _loc_4:* = (_loc_2.title.textHeight + 10) / 2;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override public function getBottomPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = _loc_2.defaultModelWidth / 2;
            var _loc_4:* = _loc_2.title.textHeight + 10;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override public function getTopPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = _loc_2.defaultModelWidth / 2;
            var _loc_4:* = 0;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            var _loc_3:* = null;
            super.updateDisplayList(param1, param2);
            this._title.move(this._iconObject.width + 5, 5);
			
			var txtRect:* = this.measureText(title.text);
			title.setActualSize(txtRect.width + 5, txtRect.height + 5);
			
			
            this._iconObject.x = 5;
            this._iconObject.y = 5;
            this.graphics.clear();
            this.buildRectOne();
            this.container.move(0, this._title.textHeight + 10);
            for each (_loc_3 in this.submodels)
            {
                
                this.grid.moveModel(_loc_3);
            }
            this._rectOne.addEventListener(MouseEvent.CLICK, this.mouseClickHandler, false);
            this.addEventListener(FocusEvent.FOCUS_OUT, this.focusEventOutHandler, false);
            this._rectOne.addEventListener(MouseEvent.MOUSE_OUT, this.mouseOutHandler, false);
            this._rectOne.addEventListener(MouseEvent.MOUSE_OVER, this.mouseOverHandler, false);
            this._rectOne.addEventListener(MouseEvent.MOUSE_DOWN, this.mouseDownHandler, false);
            if (this.menubarXML != null)
            {
                RightClickHandles.getInstance().setHandleFunction(this._rectOne, this, this.menubarXML);
            }
            this.container.setActualSize(this.grid.getMaxWidth(), this.grid.getMaxHeigth());
            this.setChildIndex(this._iconObject, 0);
            this.invalidateDisplayList();
            this.invalidateSize();
            return;
        }// end function

        override public function getLeftPoint(param1:UIComponent) : Point
        {
            var _loc_2:* = this.getPointModel(this);
            var _loc_3:* = 0;
            var _loc_4:* = (_loc_2.title.textHeight + 10) / 2;
            var _loc_5:* = new Point(_loc_3, _loc_4);
            return param1.globalToLocal(_loc_2.localToGlobal(_loc_5));
        }// end function

        override protected function createChildren() : void
        {
            var _loc_1:* = null;
            super.createChildren();
            this._iconObject = new Image();
            this._iconObject.width = 15;
            this._iconObject.height = 15;
            this._iconObject.load(this.icon);
            this.addChild(this._iconObject);
            this._container.visible = false;
            this.addChild(this._container);
            for each (_loc_1 in this.submodels)
            {
                
                this._container.addChild(_loc_1);
            }
		
            this._title = createTextField();
            this._title.text = this.modelName;
            this._title.height = this.defaultModelHeight;
            this._title.width = this.defaultModelWidth;
			
            this._rectOne.addChild(DisplayObject(this._title));
            this.grid.reCalculate(this.submodels);
            this._container.setActualSize(this.grid.getMaxWidth(), this.grid.getMaxHeigth());
            this.setActualSize(Math.max(this._container.width, this._title.textWidth + this._iconObject.width + 20, this._title.textHeight), this._container.height + this._title.height);
            this.invalidateSize();
            this.invalidateDisplayList();
            return;
        }// end function

        override protected function measure() : void
        {
            super.measure();
			//zzg 20130528
            this.measuredWidth = Math.max(this.container.width, this._title.textWidth + this._iconObject.width + 20, this._title.textHeight + 10);
            this.measuredHeight = this.container.height + this._title.height + 10;
			trace("kpi BasciModel this.measuredWidth["+this.measuredWidth+"]   this.measuredHeight["+  this.measuredHeight+"]");
            return;
        }// end function
		
		//zzg 20130528
//		override protected function measure() : void
//		{
//			super.measure();
//			var exHeight:* = getExHeight();
//			this.measuredHeight = getExHeight();
//			
//			this.measuredMinHeight = exHeight;
//			var exWidth:* = getExWidth();
//			this.measuredWidth = getExWidth();
//			trace("kpi[BasicModel]this.measuredWidth="+this.measuredWidth);
//			this.measuredMinWidth = exWidth;
//			return;
//		}// end function
		//20130711
//		override protected function measure() : void
//		{
//			super.measure();
//			var _loc_1:* = defaultModelHeight == 0 ? (this.getExHeight() + 10) : (defaultModelHeight);
//			this.measuredMinHeight = defaultModelHeight == 0 ? (this.getExHeight() + 10) : (defaultModelHeight);
//			this.measuredHeight = _loc_1;
//			_loc_1 = defaultModelWidth == 0 ? (this.getExWidth() + 10) : (defaultModelWidth);
//			this.measuredWidth = defaultModelWidth == 0 ? (this.getExWidth() + 10) : (defaultModelWidth);
//			this.measuredMinWidth = _loc_1;
//			return;
//		}// end function


    }
}
