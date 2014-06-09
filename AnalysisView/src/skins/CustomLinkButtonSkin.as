package skins
{
    import mx.skins.halo.*;

    public class CustomLinkButtonSkin extends ButtonSkin
    {

        public function CustomLinkButtonSkin()
        {
            return;
        }// end function

        override protected function updateDisplayList(param1:Number, param2:Number) : void
        {
            super.updateDisplayList(param1, param2);
            var _loc_3:* = getStyle("cornerRadius");
            var _loc_4:* = getStyle("rollOverColor");
            var _loc_5:* = getStyle("selectionColor");
            var _loc_6:* = getStyle("toggleBackgroundColor") || getStyle("themeColor");
            graphics.clear();
            switch(name)
            {
                case "upSkin":
                {
                    drawRoundRect(0, 0, param1, param2, _loc_3, 0, 0);
                    break;
                }
                case "selectedUpSkin":
                case "selectedOverSkin":
                {
                    drawRoundRect(0, 0, param1, param2, _loc_3, _loc_6, 1);
                    break;
                }
                case "overSkin":
                {
                    graphics.lineStyle(1, 6130632, 1);
                    drawRoundRect(0, 0, param1, param2, _loc_3, _loc_4, 1);
                    break;
                }
                case "selectedDownSkin":
                case "downSkin":
                {
                    drawRoundRect(0, 0, param1, param2, _loc_3, _loc_5, 1);
                    break;
                }
                case "selectedDisabledSkin":
                {
                    drawRoundRect(0, 0, param1, param2, _loc_3, _loc_6, 0.2);
                    break;
                }
                case "disabledSkin":
                {
                    drawRoundRect(0, 0, param1, param2, _loc_3, 0, 0);
                    break;
                }
                default:
                {
                    break;
                }
            }
            return;
        }// end function

    }
}
