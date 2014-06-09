package com.pactera.edg.am.kpi.mapping
{

    public class Data extends Object
    {
        private var _typename:String;
        private var _subdatafunc:String;
        private var _url:String;
        private var _initfunc:String;
        private var _argumentsfunc:String;

        public function Data()
        {
            return;
        }// end function

        public function get argumentsfunc() : String
        {
            return this._argumentsfunc;
        }// end function

        public function set argumentsfunc(param1:String) : void
        {
            this._argumentsfunc = param1;
            return;
        }// end function

        public function get typename() : String
        {
            return this._typename;
        }// end function

        public function get url() : String
        {
            return this._url;
        }// end function

        public function set typename(param1:String) : void
        {
            this._typename = param1;
            return;
        }// end function

        public function set url(param1:String) : void
        {
            this._url = param1;
            return;
        }// end function

        public function get subdatafunc() : String
        {
            return this._subdatafunc;
        }// end function

        public function get initfunc() : String
        {
            return this._initfunc;
        }// end function

        public function set initfunc(param1:String) : void
        {
            this._initfunc = param1;
            return;
        }// end function

        public function set subdatafunc(param1:String) : void
        {
            this._subdatafunc = param1;
            return;
        }// end function

    }
}
