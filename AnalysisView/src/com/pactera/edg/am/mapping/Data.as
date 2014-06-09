package com.pactera.edg.am.mapping
{

    public class Data extends Object
    {
        private var _filterCondition:String;
        private var _filterfunc:String;
        private var _typename:String;
        private var _subdatafunc:String;
        private var _url:String;
        private var _initfunc:String;

        public function Data()
        {
            return;
        }// end function

        public function get filterCondition() : String
        {
            return this._filterCondition;
        }// end function

        public function get typename() : String
        {
            return this._typename;
        }// end function

        public function set filterCondition(param1:String) : void
        {
            this._filterCondition = param1;
            return;
        }// end function

        public function set typename(param1:String) : void
        {
            this._typename = param1;
            return;
        }// end function

        public function get initfunc() : String
        {
            return this._initfunc;
        }// end function

        public function set subdatafunc(param1:String) : void
        {
            this._subdatafunc = param1;
            return;
        }// end function

        public function set url(param1:String) : void
        {
            this._url = param1;
            return;
        }// end function

        public function set initfunc(param1:String) : void
        {
            this._initfunc = param1;
            return;
        }// end function

        public function get subdatafunc() : String
        {
            return this._subdatafunc;
        }// end function

        public function get url() : String
        {
            return this._url;
        }// end function

        public function set filterfunc(param1:String) : void
        {
            this._filterfunc = param1;
            return;
        }// end function

        public function get filterfunc() : String
        {
            return this._filterfunc;
        }// end function

    }
}
