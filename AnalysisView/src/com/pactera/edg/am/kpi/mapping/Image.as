package com.pactera.edg.am.kpi.mapping
{

    public class Image extends Object
    {
        private var _help:String;
        private var _print:String;
        private var _zoomin:String;
        private var _zoomout:String;

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

        public function get print() : String
        {
            return this._print;
        }// end function

        public function set zoomin(param1:String) : void
        {
            this._zoomin = param1;
            return;
        }// end function

        public function set zoomout(param1:String) : void
        {
            this._zoomout = param1;
            return;
        }// end function

        public function set print(param1:String) : void
        {
            this._print = param1;
            return;
        }// end function

        public function get zoomout() : String
        {
            return this._zoomout;
        }// end function

        public function get zoomin() : String
        {
            return this._zoomin;
        }// end function

    }
}
