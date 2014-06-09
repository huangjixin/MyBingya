package com.pactera.edg.am.view
{

    public class ModelHead extends Object
    {
        private var _mdCode:String;
        private var _sessionId:String;
        private var _mdModelCode:String;
        private var _mdName:String;
        private var _mdAnalyStyle:String;
        private var _mdId:String;

        public function ModelHead()
        {
            return;
        }// end function

        public function set mdName(param1:String) : void
        {
            this._mdName = param1;
            return;
        }// end function

        public function get mdAnalyStyle() : String
        {
            return this._mdAnalyStyle;
        }// end function

        public function set mdCode(param1:String) : void
        {
            this._mdCode = param1;
            return;
        }// end function

        public function get mdName() : String
        {
            return this._mdName;
        }// end function

        public function set mdAnalyStyle(param1:String) : void
        {
            this._mdAnalyStyle = param1;
            return;
        }// end function

        public function get sessionId() : String
        {
            return this._sessionId;
        }// end function

        public function get mdId() : String
        {
            return this._mdId;
        }// end function

        public function get mdModelCode() : String
        {
            return this._mdModelCode;
        }// end function

        public function set sessionId(param1:String) : void
        {
            this._sessionId = param1;
            return;
        }// end function

        public function set mdId(param1:String) : void
        {
            this._mdId = param1;
            return;
        }// end function

        public function get mdCode() : String
        {
            return this._mdCode;
        }// end function

        public function set mdModelCode(param1:String) : void
        {
            this._mdModelCode = param1;
            return;
        }// end function

    }
}
