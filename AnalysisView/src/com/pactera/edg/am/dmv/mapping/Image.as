package com.pactera.edg.am.dmv.mapping
{

    public class Image
    {
        private var _normalScreen:String;
        private var _zoomin:String;
        private var _fullScreen:String;
        private var _zoomout:String;

        public function Image()
        {
            return;
        }// end function

        public function get normalScreen() : String
        {
            return this._normalScreen;
        }// end function

        public function set normalScreen(param1:String) : void
        {
            this._normalScreen = param1;
            return;
        }// end function

        public function get zoomout() : String
        {
            return this._zoomout;
        }// end function

        public function set zoomin(param1:String) : void
        {
            this._zoomin = param1;
            return;
        }// end function

        public function set fullScreen(param1:String) : void
        {
            this._fullScreen = param1;
            return;
        }// end function

        public function get fullScreen() : String
        {
            return this._fullScreen;
        }// end function

        public function set zoomout(param1:String) : void
        {
            this._zoomout = param1;
            return;
        }// end function

        public function get zoomin() : String
        {
            return this._zoomin;
        }// end function

    }
}
