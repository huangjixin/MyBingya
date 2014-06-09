package com.pactera.edg.am.kpi.view
{
    import com.pactera.edg.am.kpi.view.*;
    import com.pactera.edg.am.kpi.view.model.*;
    import mx.core.*;
	import com.pactera.edg.am.kpi.view.IContainer;

    public class ModelContainer extends UIComponent implements IContainer
    {
        private var _model:DisplayElement;

        public function ModelContainer()
        {
            return;
        }// end function

        public function set model(param1:DisplayElement) : void
        {
            this._model = param1;
            return;
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            this.graphics.clear();
            this.graphics.lineStyle(1, 13421772);
            this.graphics.beginFill(15397366, 0.8);
            this.graphics.drawRoundRect(0, 0, this.model.getExWidth(), param2, 10);
            this.graphics.endFill();
            return;
        }// end function

        public function get model() : DisplayElement
        {
            return this._model;
        }// end function

    }
}
