package demo.editor.link
{
	public class ActionTile
	{
		private var _imageName:String;
		private var _label:String;
		private var _shapeType:String;
		
		public function get imageName():String{
			return _imageName;
		}
		
		public function set imageName(imageName:String):void{
			this._imageName=imageName;
		}
		
		public function get label():String{
			return this._label;
		}
		
		public function set label(label:String):void{
			this._label=label;
		}
		
		public function get shapeType():String{
			return _shapeType;
		}
		
		public function set shapeType(shapeType:String):void{
			this._shapeType=shapeType;
		}
		
		public var action:Function;
	}
}