package com.pactera.edg.am.kpi.view.extender
{
    import com.pactera.edg.am.kpi.view.*;
    import com.pactera.edg.am.kpi.view.extender.*;
    import com.pactera.edg.am.kpi.view.model.*;
    import flash.geom.*;

    public class IconExtender extends Object implements IExtendBehavior
    {
        private var _container:IContainer;
        private var _modelState:IState;
        private var _model:DisplayElement;

        public function IconExtender()
        {
            this._modelState = new CloseModelState(this);
            return;
        }// end function

        public function get container() : IContainer
        {
            return this._container;
        }// end function

        public function set container(param1:IContainer) : void
        {
            this._container = param1;
            return;
        }// end function

        public function getRightPoint() : Point
        {
            return null;
        }// end function

        public function set modelState(param1:IState) : void
        {
            this._modelState = param1;
            return;
        }// end function

        public function contract() : void
        {
            return;
        }// end function

        public function getLeftPoint() : Point
        {
            return null;
        }// end function

        public function get modelState() : IState
        {
            return this._modelState;
        }// end function

        public function get model() : DisplayElement
        {
            return this._model;
        }// end function

        public function getTopPoint() : Point
        {
            return null;
        }// end function

        public function extend() : void
        {
            return;
        }// end function

        public function set model(param1:DisplayElement) : void
        {
            this._model = param1;
            return;
        }// end function

        public function getBottomPoint() : Point
        {
            return null;
        }// end function

    }
}
