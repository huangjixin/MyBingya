package com.pactera.edg.am.kpi.view.dragger
{
    import com.pactera.edg.am.kpi.factory.*;
    import com.pactera.edg.am.kpi.system.*;
    import com.pactera.edg.am.kpi.view.*;
    import com.pactera.edg.am.kpi.view.dragger.*;
    import com.pactera.edg.am.kpi.view.line.*;
    import com.pactera.edg.am.kpi.view.model.*;
    import flash.display.*;
    import flash.events.*;
    import mx.containers.*;
    import mx.controls.*;
    import mx.events.*;
    import mx.rpc.events.*;
    import mx.rpc.soap.*;

    public class ModelDragger extends Canvas implements IDragBehavior
    {
        private var _model:DisplayElement;
        private var _canvas:ModelView;

        public function ModelDragger()
        {
            return;
        }// end function

        public function mouseUpHandler(event:MouseEvent) : void
        {
            var _loc_2:* = null;
            var _loc_3:* = NaN;
            var _loc_4:* = NaN;
            if (this.model.parentmodel == null)
            {
                this.canvas.container.setChildIndex(this.model, 0);
            }
            else
            {
                this.model.parentmodel.container.setChildIndex(this.model, 0);
            }
            if (this.model.title == null)
            {
                this.model.iconObject.removeEventListener(MouseEvent.MOUSE_UP, mouseUpHandler);
            }
            else
            {
                this.model.title.removeEventListener(MouseEvent.MOUSE_UP, mouseUpHandler);
            }
            if (this.model.drag)
            {
                this.model.drag = false;
                this.model.stopDrag();
                _loc_2 = this.model.systemManager.getSandboxRoot();
                _loc_2.removeEventListener(MouseEvent.MOUSE_UP, mouseUpHandler);
                _loc_2.removeEventListener(SandboxMouseEvent.MOUSE_UP_SOMEWHERE, mouseUpHandler);
                this.model.systemManager.deployMouseShields(false);
                if (this.model.parent is ModelContainer)
                {
                    if (this.model.x + this.model.width > this.model.parent.width)
                    {
                        this.model.move(this.model.parent.width - this.model.width - 10, this.model.y);
                    }
                    if (this.model.y + this.model.height > this.model.parent.height)
                    {
                        this.model.move(this.model.x, this.model.parent.height - this.model.height - 10);
                    }
                }
                if (this.model.x < 0)
                {
                    this.model.move(10, this.model.y);
                }
                if (this.model.y < 0)
                {
                    this.model.move(this.model.x, 10);
                }
                _loc_3 = this.model.modelView.getRightModelWidth();
                _loc_4 = this.model.modelView.getBottomModelHeight();
                this.canvas.container.width = _loc_3;
                this.canvas.container.height = _loc_4;
                this.lineDispatchEvent();
                this.model.container.invalidateSize();
                this.model.container.invalidateDisplayList();
            }
            this.canvas.container.invalidateSize();
            this.canvas.container.invalidateDisplayList();
            this.canvas.addEventListener(MouseEvent.MOUSE_MOVE, this.canvas.mouseMoveEvent);
            return;
        }// end function

        public function set model(param1:DisplayElement) : void
        {
            this._model = param1;
            return;
        }// end function

        public function get canvas() : ModelView
        {
            return this._canvas;
        }// end function

        public function mouseMoveHandler(event:MouseEvent) : void
        {
            var _loc_2:* = null;
            if (event.buttonDown)
            {
                if (!this.model.drag)
                {
                    this.canvas.removeEventListener(MouseEvent.MOUSE_MOVE, this.canvas.mouseMoveEvent);
                    this.model.startDrag();
                    _loc_2 = this.model.systemManager.getSandboxRoot();
                    _loc_2.addEventListener(MouseEvent.MOUSE_UP, mouseUpHandler);
                    _loc_2.addEventListener(SandboxMouseEvent.MOUSE_UP_SOMEWHERE, mouseUpHandler);
                    this.model.systemManager.deployMouseShields(true);
                }
                this.model.drag = true;
                this.model.canClose = false;
            }
            return;
        }// end function

        public function mouseDoubleClickHandler(event:MouseEvent) : void
        {
            var arguments:ModelFactory = null;
            var _loc_4:* = null;
            var _loc_5:* = null;
            var _loc_6:* = null;
            this.model.extensible.modelState.changeModelState();
            if (this.model.isOpen)
            {
                if (this.model.subModels.length == 0)
                {
                    arguments = ApplicationConfig.getInstance().modelFactory;
                    if (arguments.getDataMapping().typename == "webservice")
                    {
                        _loc_4 = new WebService();
                        _loc_4.wsdl = arguments.getDataMapping().url;
                        _loc_4.useProxy = false;
                        _loc_4.loadWSDL();
                        _loc_5 = _loc_4.getOperation(arguments.getDataMapping().subdatafunc) as Operation;
                        _loc_6 = new Array();
                        _loc_6.push(this.model.id);
                        _loc_5.arguments = _loc_6;
                        _loc_5.addEventListener(FaultEvent.FAULT, onfault);
                        _loc_5.addEventListener(ResultEvent.RESULT, onresult);
                        _loc_5.send();
                    }
                }
            }
            this.model.modelView.updateModelView();
            return;
        }// end function

        private function onfault(event:FaultEvent) : void
        {
            Alert.show("fault===" + event);
            return;
        }// end function

        public function get model() : DisplayElement
        {
            return this._model;
        }// end function

        public function mouseDownHandler(event:MouseEvent) : void
        {
            this.model.canClose = true;
            if (this.model.parentmodel == null)
            {
                this.canvas.container.setChildIndex(this.model, (this.canvas.getModels().length - 1));
            }
            else
            {
                this.model.parentmodel.container.setChildIndex(this.model, (this.model.parentmodel.container.numChildren - 1));
            }
            if (this.model.title == null)
            {
                this.model.iconObject.addEventListener(MouseEvent.MOUSE_UP, mouseUpHandler);
            }
            else
            {
                this.model.title.addEventListener(MouseEvent.MOUSE_UP, mouseUpHandler);
            }
            return;
        }// end function

        public function lineDispatchEvent() : void
        {
            var _loc_1:* = null;
            var _loc_2:* = null;
            if (this.model.title == null)
            {
                this.model.height = 10;
                this.model.width = Math.max(0, this.model.iconObject.width + 5, 0);
            }
            else
            {
                this.model.height = this.model.container.height + this.model.title.height + 10;
                this.model.width = Math.max(this.model.container.width, this.model.title.textWidth + this.model.iconObject.width + 20, this.model.title.textHeight + 10);
            }
            this.model.invalidateDisplayList();
            this.model.invalidateSize();
            for each (_loc_1 in this.model.lines)
            {
                
                _loc_1.dispatchEvent(new Event("model_move"));
            }
            for each (_loc_2 in this.model.subModels)
            {
                
                _loc_2.lineDispatchEvent();
            }
            return;
        }// end function

        public function set canvas(param1:ModelView) : void
        {
            this._canvas = param1;
            return;
        }// end function

        private function onresult(event:ResultEvent) : void
        {
            var _loc_2:* = XMLList(event.result);
            var _loc_3:* = new XmlToModel();
            _loc_3.runXmlToSubModel(_loc_2[0], this.model.modelView.getModels(), this.model.modelView.getLines());
            this.model.modelView.Models = _loc_3.getModels();
            this.model.modelView.Lines = _loc_3.getLines();
            this.model.modelView.Models = this.model.modelView.getGrid().ModelFormat(this.model.modelView.getModels(), this.model.modelView.getLines());
            this.model.modelView.updateModelView();
            return;
        }// end function

    }
}
