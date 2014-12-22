﻿package com.pactera.edg.am.view.extender
{
    import com.pactera.edg.am.view.*;
    import com.pactera.edg.am.view.extender.*;
    import com.pactera.edg.am.view.model.*;

    public class SwimModelExtender extends Object implements IExtendBehavior
    {
        private var _container:IContainer;
        private var _modelState:IState;
        private var _model:DisplayElement;

        public function SwimModelExtender()
        {
            this._modelState = new CloseModelState(this);
            return;
        }// end function

        public function get container() : IContainer
        {
            return this._container;
        }// end function

        public function get modelState() : IState
        {
            return this._modelState;
        }// end function

        public function get model() : DisplayElement
        {
            return this._model;
        }// end function

        public function contract() : void
        {
            this._modelState = new CloseModelState(this);
            this.model.isOpen = false;
            return;
        }// end function

        public function set container(param1:IContainer) : void
        {
            this._container = param1;
            return;
        }// end function

        public function set modelState(param1:IState) : void
        {
            this._modelState = param1;
            return;
        }// end function

        public function set model(param1:DisplayElement) : void
        {
            this._model = param1;
            return;
        }// end function

        public function extend() : void
        {
            this._modelState = new OpenModelState(this);
            this.model.isOpen = true;
            return;
        }// end function

    }
}