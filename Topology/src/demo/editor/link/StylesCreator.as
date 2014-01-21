package demo.editor.link
{
	import twaver.*;
	
	public class StylesCreator extends ActionTile implements  IStylesCreator
	{
		
		private var _styles:Array;
		
		public function set styles(styles:Array):void{
			this._styles=styles;
		}
		
		public function createStyles(element:IElement):void{
			if(element==null){
				return;
			}
			if(!_styles){
				return;
			}
			for each(var style:* in _styles){
				element.setStyle(style[0],style[1]);
			}
		}
	}
}