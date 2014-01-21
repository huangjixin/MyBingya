package demo.common
{
	import mx.core.ClassFactory;

	import twaver.controls.TableColumn;

	public class BooleanColumn extends TableColumn
	{
		public function BooleanColumn(columnName:String=null)
		{
			var dd :TableColumn = new TableColumn();
			dd
			super(columnName);
			this.itemRenderer = new ClassFactory(BooleanRenderer);
			this.rendererIsEditor = true;
			this.editorDataField = "selected"
		}
		
	}
}