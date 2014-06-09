package com.pactera.edg.am.dmv.utilities
{
    import flash.display.*;
    import flash.events.*;
    import flash.geom.*;
    import flash.net.*;
    import flash.system.*;
    import flash.utils.*;
    import mx.containers.accordionClasses.*;
    import mx.controls.tabBarClasses.*;
    import mx.core.*;

    public class IconUtility extends BitmapAsset
    {
        private static var dictionary:Dictionary;

        public function IconUtility() : void
        {
            addEventListener(Event.ADDED, this.addedHandler, false, 0, true);
            return;
        }// end function

        private function getData(param1:Object) : void
        {
            var _loc_3:Object = null;
            var _loc_4:Loader = null;
            var _loc_2:* = dictionary[param1];
            if (_loc_2)
            {
                _loc_3 = _loc_2.source;
                if (_loc_2.width > 0 && _loc_2.height > 0)
                {
                    bitmapData = new BitmapData(_loc_2.width, _loc_2.height, true, 16777215);
                }
                if (_loc_3 is Loader)
                {
                    _loc_4 = _loc_3 as Loader;
                    if (!_loc_4.content)
                    {
                        _loc_4.contentLoaderInfo.addEventListener(Event.COMPLETE, this.completeHandler, false, 0, true);
                    }
                    else
                    {
                        this.displayLoader(_loc_4);
                    }
                }
            }
            return;
        }// end function

        private function completeHandler(event:Event) : void
        {
            if (event && event.target && event.target is LoaderInfo)
            {
                this.displayLoader(event.target.loader as Loader);
            }
            return;
        }// end function

        private function addedHandler(event:Event) : void
        {
            var _loc_2:AccordionHeader = null;
            var _loc_3:Tab = null;
            if (parent)
            {
                if (parent is AccordionHeader)
                {
                    _loc_2 = parent as AccordionHeader;
                    this.getData(_loc_2.data);
                }
                else if (parent is Tab)
                {
                    _loc_3 = parent as Tab;
                    this.getData(_loc_3.data);
                }
                else
                {
                    this.getData(parent);
                }
            }
            return;
        }// end function

        private function displayLoader(param1:Loader) : void
        {
            var _loc_2:UIComponent = null;
            if (!bitmapData)
            {
                bitmapData = new BitmapData(param1.content.width, param1.content.height, true, 16777215);
            }
            bitmapData.draw(param1, new Matrix(bitmapData.width / param1.width, 0, 0, bitmapData.height / param1.height, 0, 0));
            if (parent is UIComponent)
            {
                _loc_2 = parent as UIComponent;
                _loc_2.invalidateSize();
            }
            return;
        }// end function

        public static function getClass(param1:UIComponent, param2:String, param3:Number = NaN, param4:Number = NaN) : Class
        {
			trace("IconUtility....start donwload icon class");
            if (!dictionary)
            {
                dictionary = new Dictionary(false);
            }
            var loader:Loader = new Loader();
            loader.load(new URLRequest(param2 as String), new LoaderContext(true));
            
            dictionary[param1] = {source:loader, width:param3, height:param4};
            return IconUtility;
        }// end function

    }
}
