package com.itsm.common
{ 
	import spark.components.gridClasses.GridColumn;
	
	public class CheckBoxHeaderColumn extends GridColumn  
	{  
		 public function CheckBoxHeaderColumn(columnName:String=null)  
		 {  
			  super(columnName);  
		 }  
	 /**is the checkbox in header selected**/  
		 public var selected:Boolean = false;  
		 
	}  
}