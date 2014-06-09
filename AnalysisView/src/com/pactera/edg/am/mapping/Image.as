package com.pactera.edg.am.mapping
{

    public class Image extends Object
    {
        private var _search:String;
        private var _fullScreen:String;
        private var _normalScreen:String;
        private var _export:String;
        private var _zoomin:String;
        private var _help:String;
        private var _zoomout:String;
        private var _print:String;
        private var _tour:String;

        public function Image()
        {
            return;
        }// end function

        public function get help() : String
        {
            return this._help;
        }// end function

        public function set help(param1:String) : void
        {
            this._help = param1;
            return;
        }// end function

        public function set zoomout(param1:String) : void
        {
            this._zoomout = param1;
            return;
        }// end function

        public function set search(param1:String) : void
        {
            this._search = param1;
            return;
        }// end function

        public function get tour() : String
        {
            return this._tour;
        }// end function

        public function set print(param1:String) : void
        {
            this._print = param1;
            return;
        }// end function

        public function get fullScreen() : String
        {
            return this._fullScreen;
        }// end function

        public function get zoomout() : String
        {
            return this._zoomout;
        }// end function

        public function get zoomin() : String
        {
            return this._zoomin;
        }// end function

        public function set normalScreen(param1:String) : void
        {
            this._normalScreen = param1;
            return;
        }// end function

        public function get search() : String
        {
            return this._search;
        }// end function

        public function set export(param1:String) : void
        {
            this._export = param1;
            return;
        }// end function

        public function set tour(param1:String) : void
        {
            this._tour = param1;
            return;
        }// end function

        public function set fullScreen(param1:String) : void
        {
            this._fullScreen = param1;
            return;
        }// end function

        public function get normalScreen() : String
        {
            return this._normalScreen;
        }// end function

        public function get export() : String
        {
            return this._export;
        }// end function

        public function get print() : String
        {
            return this._print;
        }// end function

        public function set zoomin(param1:String) : void
        {
            this._zoomin = param1;
            return;
        }// end function

    }
}
