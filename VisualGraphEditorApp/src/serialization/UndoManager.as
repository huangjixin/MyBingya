package serialization
{
	import cn.hnisi.ravis.editor.VisualGraphEditor;
	
	import mx.core.UIComponent;
	
	public class UndoManager extends UIComponent
	{
		// The diagram editor to which to undo manager is attached
		private var _editor:VisualGraphEditor;
		
		// Contains the successive states of the graph.
		private var _states:Vector.<Object> = new Vector.<Object>();
		
		// Index of the current state.
		private var _currentState:int = -1;
		
		// Was the graph modified since the last state change?
		private var _modified:Boolean = false;
		
		private var _mouseDown:Boolean = false;
		
		private var _undoEnabled:Boolean = true;
		
		private var _undoLimit:uint = 100;
		
		protected var _serializer:XMLSerializer = new XMLSerializer();
		
		public function UndoManager()
		{
			super();
		}

		public function get editor():VisualGraphEditor
		{
			return _editor;
		}

		public function set editor(value:VisualGraphEditor):void
		{
			_editor = value;
		}

	}
}