package com.pactera.edg.am.kpi.view.model.chart
{
    import com.adobe.serialization.json.*;
    import com.pactera.edg.am.kpi.factory.*;
    import com.pactera.edg.am.kpi.system.*;
    import mx.charts.*;
    import mx.charts.series.*;
    import mx.collections.*;
    import mx.containers.*;

    public class IChart extends Object
    {
        protected var _columnSeries:ColumnSeries;
        protected var _categoryField:String;
        protected var _dataProvider:ArrayCollection;
        protected var _chartPanel:Panel;
        protected var _legend:Legend;
        protected var _dataName:Array;

        public function IChart()
        {
            _chartPanel = new Panel();
            _categoryField = new String();
            _dataName = new Array();
            return;
        }// end function

        public function get dataProvider() : ArrayCollection
        {
            return this._dataProvider;
        }// end function

        public function get chartPanel() : Panel
        {
            return this._chartPanel;
        }// end function

        public function buildXml(param1:XML) : void
        {
            var _loc_6:* = null;
            var _loc_7:* = null;
            var _loc_8:* = null;
            var _loc_9:* = null;
            var _loc_10:* = null;
            var _loc_11:* = null;
            var _loc_12:* = null;
            var _loc_13:* = null;
            var _loc_14:* = null;
            var _loc_15:* = null;
            var _loc_16:* = null;
            var _loc_2:* = new ArrayCollection();
            var _loc_3:* = ApplicationConfig.getInstance().modelFactory;
            var _loc_4:* = param1;
            var _loc_5:* = 0;
            if (_loc_4 != null)
            {
                _loc_6 = _loc_3.getNodeMapping().categoryfield;
                _loc_7 = _loc_4.attribute(_loc_6);
                _loc_6 = _loc_3.getNodeMapping().chartdata;
                _loc_8 = _loc_4.elements(_loc_6);
                this.categoryField = _loc_7;
                _loc_9 = new String();
                for each (_loc_10 in _loc_8)
                {
                    
                    _loc_6 = _loc_3.getNodeMapping().categoryvalue;
                    _loc_12 = _loc_10.attribute(_loc_6);
                    _loc_6 = _loc_3.getNodeMapping().data;
                    _loc_13 = _loc_10.elements(_loc_6);
                    _loc_9 = "{\"" + _loc_7 + "\":\"" + _loc_12 + "\",";
                    for each (_loc_14 in _loc_13)
                    {
                        
                        _loc_6 = _loc_3.getNodeMapping().dataname;
                        _loc_15 = _loc_14.attribute(_loc_6);
                        _loc_6 = _loc_3.getNodeMapping().datavalue;
                        _loc_16 = _loc_14.attribute(_loc_6);
                        _loc_9 = _loc_9 + ("\"" + _loc_15 + "\":" + _loc_16 + ",");
                        if (_loc_5 == 0)
                        {
                            this.dataName.push(_loc_15);
                        }
                    }
                    _loc_5++;
                    _loc_9 = _loc_9.substring(0, (_loc_9.length - 1)) + "}";
                    _loc_2.addItem(_loc_9);
                }
                _loc_9 = "{\"data\":[" + _loc_2 + "]}";
                _loc_11 = new Object();
                _loc_11 = JSON.decode(_loc_9);
                this.dataProvider = new ArrayCollection(_loc_11.data as Array);
            }
            return;
        }// end function

        public function get legend() : Legend
        {
            return this._legend;
        }// end function

        public function init() : void
        {
            return;
        }// end function

        public function set chartPanel(param1:Panel) : void
        {
            this._chartPanel = param1;
            return;
        }// end function

        public function get dataName() : Array
        {
            return this._dataName;
        }// end function

        public function set columnSeries(param1:ColumnSeries) : void
        {
            this._columnSeries = param1;
            return;
        }// end function

        public function get categoryField() : String
        {
            return this._categoryField;
        }// end function

        public function set legend(param1:Legend) : void
        {
            this._legend = param1;
            return;
        }// end function

        public function set dataName(param1:Array) : void
        {
            this._dataName = param1;
            return;
        }// end function

        public function get columnSeries() : ColumnSeries
        {
            return this._columnSeries;
        }// end function

        public function set dataProvider(param1:ArrayCollection) : void
        {
            this._dataProvider = param1;
            return;
        }// end function

        public function set categoryField(param1:String) : void
        {
            this._categoryField = param1;
            return;
        }// end function

    }
}
