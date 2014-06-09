package com.pactera.edg.am.view
{
    import flash.events.*;
    import mx.controls.*;
    import mx.controls.listClasses.*;
    import mx.utils.*;

    public class CheckBoxItemRenderer extends CheckBox
    {
        private var currData:XML;

        public function CheckBoxItemRenderer()
        {
            this.addEventListener(Event.CHANGE, this.onClickCheckBox);
            return;
        }// end function

        override public function set enabled(param1:Boolean) : void
        {
            if (this.currData)
            {
                param1 = this.currData.enabled == false ? (false) : (true);
            }
            super.enabled = param1;
            return;
        }// end function

        override public function set data(param1:Object) : void
        {
            this.currData = XML(param1);
            if (param1.@selected == "true")
            {
                this.selected = true;
            }
            else
            {
                this.selected = false;
            }
            this.label = param1.@name;
            return;
        }// end function

        private function onClickCheckBox(event:Event) : void
        {
            var _loc_2:* = ListBase(listData.owner);
            var _loc_3:* = _loc_2.selectedItems;
            this.currData.@selected = this.selected;
            if (this.selected)
            {
                _loc_3.push(this.currData);
            }
            else
            {
                _loc_3.splice(ArrayUtil.getItemIndex(this.currData, _loc_3), 1);
            }
            _loc_2.selectedItems = _loc_3;
            return;
        }// end function

    }
}
