package com.pactera.edg.am.dmv.view
{
    import com.pactera.edg.am.dmv.factory.*;
    import com.pactera.edg.am.dmv.view.ModelView
    import com.pactera.edg.am.dmv.system.*;
    import com.pactera.edg.am.dmv.utilities.*;
    import com.pactera.edg.am.dmv.view.model.*;
    import flash.display.*;
    import mx.containers.*;
    import mx.controls.*;
    import mx.core.*;
    import mx.effects.*;
    import mx.events.*;

    public class MyUIComponent extends HBox
    {
        private var factory:ModelFactory = null;
        private var num:Number = 1;
        private var zoom:Zoom;
        private var color:ColorProperty = null;
        private var _modelView:ModelView;
        private var linkBar:LinkBar;

        public function MyUIComponent()
        {
            zoom = new Zoom();
            color = new ColorProperty();
            factory = ApplicationConfig.getInstance().modelFactory;
            return;
        }// end function

        private function doFullScreen(event:ItemClickEvent) : void
        {
            var _loc_2:Class = null;
            stage.displayState = stage.displayState == StageDisplayState.NORMAL ? (StageDisplayState.FULL_SCREEN) : (StageDisplayState.NORMAL);
            var _loc_3:* = event.relatedObject as Button;
            if (this.stage.displayState == StageDisplayState.FULL_SCREEN)
            {
                _loc_2 = IconUtility.getClass(_loc_3, factory.getImageMapping().normalScreen, 16, 16);
                stage.scaleMode = StageScaleMode.NO_SCALE;
                _loc_3.toolTip = "返回";
                setRightMenuDisable(true);
            }
            else
            {
                _loc_2 = IconUtility.getClass(_loc_3, factory.getImageMapping().fullScreen, 16, 16);
                _loc_3.toolTip = "全屏";
                setRightMenuDisable(false);
            }
            _loc_3.clearStyle("icon");
            _loc_3.setStyle("icon", _loc_2);
            return;
        }// end function

        private function setModelsRightMenu(param1:Array, param2:Boolean) : void
        {
            var _loc_3:DisplayElement = null;
            for each (_loc_3 in param1)
            {
                
                if (param2)
                {
                    _loc_3.rigthMenu.disableContextMenu();
                }
                else
                {
                    _loc_3.rigthMenu.contructContextMenu();
                }
                if (_loc_3.subModels.length > 0)
                {
                    setModelsRightMenu(_loc_3.subModels, param2);
                }
            }
            return;
        }// end function

        override protected function commitProperties() : void
        {
            super.commitProperties();
            return;
        }// end function

        private function itemClickHandler(event:ItemClickEvent) : void
        {
            var _loc_2:* = event.index;
            switch(_loc_2)
            {
                case 0:
                {
                    blowUpModel();
                    break;
                }
                case 1:
                {
                    reduceModel();
                    break;
                }
                case 2:
                {
                    doFullScreen(event);
                    break;
                }
                default:
                {
                    break;
                }
            }
            return;
        }// end function

        public function setRightMenuDisable(param1:Boolean) : void
        {
            if (param1)
            {
                Application.application.contextMenu = null;
            }
            else
            {
                Application.application.addContextMenu();
            }
            setModelsRightMenu(modelView.getModels(), param1);
            return;
        }// end function

        override protected function createChildren() : void
        {
            var _loc_1:Class = null;
            var _loc_2:Array = null;
            super.createChildren();
            if (linkBar == null)
            {
                linkBar = new LinkBar();
                _loc_2 = ["", "", ""];
                linkBar.dataProvider = _loc_2;
                linkBar.addEventListener(ChildExistenceChangedEvent.CHILD_ADD, childAddHandler);
                linkBar.addEventListener(ItemClickEvent.ITEM_CLICK, itemClickHandler);
                addChild(linkBar);
            }
            return;
        }// end function

        public function set modelView(param1:ModelView) : void
        {
        	trace("[modelView]"+param1);
            this._modelView = param1;
            return;
        }// end function

        override protected function measure() : void
        {
            return;
        }// end function

        private function childAddHandler(event:ChildExistenceChangedEvent) : void
        {
            var _loc_5:Class = null;
            var _loc_2:* = event.target as LinkBar;
            var _loc_3:* = event.relatedObject as Button;
            var _loc_4:* = _loc_2.getChildIndex(_loc_3);
            trace("[MyUIComponent.as]"+factory);
            if (factory &&!factory.isDebug)
            {
                switch(_loc_4)
                {
                    case 0:
                    {
                        _loc_5 = IconUtility.getClass(_loc_3, factory.getImageMapping().zoomin, 16, 16);
                        _loc_3.toolTip = "放大";
                        break;
                    }
                    case 1:
                    {
                        _loc_5 = IconUtility.getClass(_loc_3, factory.getImageMapping().zoomout, 16, 16);
                        _loc_3.toolTip = "缩小";
                        break;
                    }
                    case 2:
                    {
                        _loc_5 = IconUtility.getClass(_loc_3, factory.getImageMapping().fullScreen, 16, 16);
                        _loc_3.toolTip = "全屏";
                        break;
                    }
                    default:
                    {
                        break;
                        break;
                    }
                }
            }
            _loc_3.setStyle("icon", _loc_5);
            _loc_3.label = "";
            _loc_3.width = 22;
            _loc_3.height = 18;
            return;
        }// end function

        private function reduceModel() : void
        {
        	trace("[this.modelView]"+this.modelView+",num:"+num);
            if (this.modelView != null)
            {
                zoom.target = this.modelView;
                zoom.zoomHeightFrom = num;
                zoom.zoomWidthFrom = num;
                if (num < 0.5)
                {
                    return;
                }
                num = num - 0.1;
                zoom.zoomHeightTo = num;
                zoom.zoomWidthTo = num;
                zoom.originX = this.modelView.x;
                zoom.originY = this.modelView.y;
                zoom.duration = 200;
                zoom.play();
                this.modelView.container.invalidateProperties();
            }
            return;
        }// end function

        public function get modelView() : ModelView
        {
            return this._modelView;
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            var _loc_3:* = param1 - 8;
            var _loc_4:* = param2 - 8;
            linkBar.move(param1 - linkBar.getExplicitOrMeasuredWidth(), 0);
			//zzg 20130723 增加颜色定制参数
			var tbLineColor:String="0x84A2C6";
			var tbFillColor:String="0xC6D3E7";
			if(Application.application.parameters!=null&&
				Application.application.parameters.isCustomColor=="1" //需要定义颜色
			){
				tbLineColor=Application.application.parameters.tbLineColor;
				tbFillColor=Application.application.parameters.tbFillColor;
			}
			
			GraphicUtil.turnModelColor(uint(tbLineColor),uint(tbFillColor), this);
            return;
        }// end function

        private function blowUpModel() : void
        {
        	trace("[this.modelView]"+this.modelView+",num:"+num);
            if (this.modelView != null)
            {
                zoom.target = this.modelView;
                zoom.zoomHeightFrom = num;
                zoom.zoomWidthFrom = num;
                if (num > 1.5)
                {
                    return;
                }
                num = num + 0.1;
                zoom.zoomHeightTo = num;
                zoom.zoomWidthTo = num;
                zoom.originX = this.modelView.x;
                zoom.originY = this.modelView.y;
                zoom.duration = 200;
                zoom.play();
                this.modelView.container.invalidateProperties();
            }
            return;
        }// end function

    }
}
