package com.itsm.common
{
	import mx.controls.dataGridClasses.DataGridColumn; 
	
	public class CheckBoxColumn extends DataGridColumn{ 
		
		public var cloumnSelected:Boolean=false;//保存该列是否全选的属性（用户先点击全选后在手动的取消几行数据的选中状态时，这里的状态不会改变）           
		
		public var selectItems:Array = new Array();//用户保存用户选中的数据 
		
		
		public function CheckBoxColumn(columnName:String=null){ 
			super(columnName);  
		} 
	} 
}