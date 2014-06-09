package com.pactera.edg.am.kpi.view.model.chart
{
    import mx.charts.*;
    import mx.charts.series.*;
    import mx.containers.*;

    public class ColumnChartModel extends IChart
    {
        private var columnChart:ColumnChart;

        public function ColumnChartModel()
        {
            columnChart = new ColumnChart();
            columnChart.percentWidth = 100;
            columnChart.percentHeight = 100;
            columnChart.x = 0;
            columnChart.y = 0;
            legend = new Legend();
            legend.percentWidth = 40;
            legend.percentHeight = 100;
            legend.y = 0;
            return;
        }// end function

        override public function init() : void
        {
            var _loc_3:* = null;
            columnChart.showDataTips = true;
            columnChart.dataProvider = this.dataProvider;
            var _loc_1:* = new CategoryAxis();
            _loc_1.categoryField = this.categoryField;
            _loc_1.dataProvider = this.dataProvider;
            columnChart.horizontalAxis = _loc_1;
            var _loc_2:* = new Array();
            for each (_loc_3 in this.dataName)
            {
                
                this._columnSeries = new ColumnSeries();
                this._columnSeries.xField = this.categoryField;
                this._columnSeries.yField = _loc_3;
                this._columnSeries.maxColumnWidth = 7;
                this._columnSeries.displayName = _loc_3;
                _loc_2.push(this._columnSeries);
            }
            columnChart.series = _loc_2;
            this.legend.dataProvider = columnChart;
            return;
        }// end function

        public function get legendChart() : Legend
        {
            return this.legend;
        }// end function

        override public function get chartPanel() : Panel
        {
            this._chartPanel.title = "统计图";
            this._chartPanel.width = 200;
            this._chartPanel.height = 200;
            this._chartPanel.addChild(columnChart);
            return this._chartPanel;
        }// end function

        public function get colChart() : ColumnChart
        {
            return this.columnChart;
        }// end function

    }
}
