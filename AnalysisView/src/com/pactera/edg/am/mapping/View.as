package com.pactera.edg.am.mapping
{

    public class View extends Object
    {
        private var _width:Number;
        private var _height:Number;
        private var _viewName:Array;
        private var _isImage:Boolean;
        private var _isOpen:Boolean;

        public function View()
        {
            return;
        }// end function

        public function set viewName(param1:Array) : void
        {
            this._viewName = param1;
            return;
        }// end function

        public function set isImage(param1:Boolean) : void
        {
            this._isImage = param1;
            return;
        }// end function

        public function get width() : Number
        {
            return this._width;
        }// end function

        public function get viewName() : Array
        {
            return this._viewName;
        }// end function

        public function get isImage() : Boolean
        {
            return this._isImage;
        }// end function

        public function get isOpen() : Boolean
        {
            return this._isOpen;
        }// end function

        public function set height(param1:Number) : void
        {
            this._height = param1;
            return;
        }// end function

        public function get height() : Number
        {
            return this._height;
        }// end function

        public function set isOpen(param1:Boolean) : void
        {
            this._isOpen = param1;
            return;
        }// end function

        public function set width(param1:Number) : void
        {
            this._width = param1;
            return;
        }// end function

    }
}
