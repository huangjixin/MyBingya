import com.as3xls.xls.ExcelFile;
import com.as3xls.xls.Sheet;
import com.usee.elecoin.common.Page;
import com.usee.elecoin.system.controller.MenuRemoteServerEvent;
import com.usee.elecoin.system.controller.RoleRemoteServerEvent;
import com.usee.elecoin.system.model.MenuRemoteServerProxy;
import com.usee.elecoin.system.model.RoleRemoteServerProxy;
import com.usee.elecoin.system.model.vo.Role;
import com.usee.elecoin.system.view.RoleForm;

import flash.events.Event;
import flash.events.MouseEvent;
import flash.filesystem.File;
import flash.filesystem.FileMode;
import flash.filesystem.FileStream;
import flash.net.FileReference;
import flash.utils.ByteArray;
import flash.utils.describeType;

import mx.collections.ArrayCollection;
import mx.collections.IList;
import mx.controls.Alert;
import mx.events.FlexEvent;
import mx.managers.PopUpManager;

import spark.events.GridSelectionEvent;

private var menuProxy:MenuRemoteServerProxy = new MenuRemoteServerProxy();

private var roleProxy:RoleRemoteServerProxy = new RoleRemoteServerProxy();
private var roleForm:RoleForm;

[Bindable]
private var roles:ArrayCollection;

[Bindable]
private var menuTreeXml:Object;

protected function navigatorcontent1_creationCompleteHandler(event:FlexEvent):void
{
	roleProxy.query(this.page);
	
	roleProxy.addEventListener(RoleRemoteServerEvent.queryResult,onqueryResult);
	roleProxy.addEventListener(RoleRemoteServerEvent.queryFault,onqueryFault);
	roleProxy.addEventListener(RoleRemoteServerEvent.insertResult,oninsertResult);
	roleProxy.addEventListener(RoleRemoteServerEvent.insertFault,oninsertFault);
	roleProxy.addEventListener(RoleRemoteServerEvent.updateResult,onupdateResult);
	roleProxy.addEventListener(RoleRemoteServerEvent.updateFault,onupdateFault);
	roleProxy.addEventListener(RoleRemoteServerEvent.deleteByPrimaryKeyResult,ondeleteByPrimaryKeyResult);
	roleProxy.addEventListener(RoleRemoteServerEvent.deleteByPrimaryKeyFault,ondeleteByPrimaryKeyFault);
	roleProxy.addEventListener(RoleRemoteServerEvent.selectAllResult,onselectAllResult);
	roleProxy.addEventListener(RoleRemoteServerEvent.selectAllFault,onselectAllFault);
	
	menuProxy.addEventListener(MenuRemoteServerEvent.serializMenuToXmlResult,onserializMenuToXmlResult);
	menuProxy.addEventListener(MenuRemoteServerEvent.serializMenuToXmlFault,onserializMenuToXmlFault);
}

/**
 * 查询分页成功 
 * @param event
 * 
 */
protected function onqueryResult(event:RoleRemoteServerEvent):void
{
	this.page = event.object as Page;
}

/**
 *  查询分页失败。
 * @param event
 * 
 */
protected function onqueryFault(event:RoleRemoteServerEvent):void
{
	Alert.show(event.object.toString());
}

protected function pagecomponent1_pageChangeHandler(event:Event):void
{
	roleProxy.query(this.page,keyInput.text);
}

/**
 * 查询 
 * @param event
 * 
 */
protected function queryBtn_clickHandler(event:MouseEvent):void
{
	roleProxy.query(this.page,keyInput.text);
}

/**
 * 添加用户 
 * @param event
 * 
 */
protected function addBtn_clickHandler(event:MouseEvent):void
{
	roleForm = PopUpManager.createPopUp(this,RoleForm) as RoleForm;
	PopUpManager.centerPopUp(roleForm);
	roleForm.confirmBtn.addEventListener(MouseEvent.CLICK,onconfirmBtnClick);
}

/**
 * 
 * @param event
 * 
 */
protected function onconfirmBtnClick(event:MouseEvent):void
{
	var role:Role = roleForm.role;
	if(role.id && role.id!=""){//如果user有id就是为更新动作，否则就是新增。
		roleProxy.update(role);
	}else{
		roleProxy.insert(role);
	}
}

protected function oninsertFault(event:RoleRemoteServerEvent):void
{
	Alert.show(event.object.toString());
}

protected function oninsertResult(event:RoleRemoteServerEvent):void
{
	PopUpManager.removePopUp(roleForm);
	keyInput.text = "";
	queryBtn_clickHandler(null);
}

protected function updateBtn_clickHandler(event:MouseEvent):void
{
	roleForm = PopUpManager.createPopUp(this,RoleForm) as RoleForm;
	roleForm.role = dataGrid.selectedItem as Role;
	PopUpManager.centerPopUp(roleForm);
	roleForm.confirmBtn.addEventListener(MouseEvent.CLICK,onconfirmBtnClick);
}

protected function onupdateFault(event:RoleRemoteServerEvent):void
{
	Alert.show(event.object.toString());
}

protected function onupdateResult(event:RoleRemoteServerEvent):void
{
	PopUpManager.removePopUp(roleForm);
	keyInput.text = "";
	queryBtn_clickHandler(null);
}


/**
 * 删除 
 * @param event
 * 
 */
protected function deleteBtn_clickHandler(event:MouseEvent):void
{
	var role:Role = dataGrid.selectedItem as Role;
	roleProxy.deleteByPrimaryKey(role.id);
}

protected function ondeleteByPrimaryKeyFault(event:RoleRemoteServerEvent):void
{
	Alert.show(event.object.toString());
}

protected function ondeleteByPrimaryKeyResult(event:RoleRemoteServerEvent):void
{
	keyInput.text = "";
	queryBtn_clickHandler(null);
}

protected function onselectAllFault(event:RoleRemoteServerEvent):void
{
	Alert.show(event.object.toString());
}

protected function onselectAllResult(event:RoleRemoteServerEvent):void
{
	var arrayCol:IList = event.object as ArrayCollection;
	if(arrayCol){
		if(arrayCol.length>0){
			exportExcel(arrayCol);		
		}
	}
}

/**
 * 查看具体的条目信息,查询相应的角色。
 * @param event
 * 
 */
protected function dataGrid_selectionChangeHandler(event:GridSelectionEvent):void
{
	var role:Role = dataGrid.selectedItem as Role;
	if(role){
		menuProxy.serializMenuToXml(role.id);
	}
}

protected function onserializMenuToXmlFault(event:MenuRemoteServerEvent):void
{
	Alert.show(event.object.toString());
}

protected function onserializMenuToXmlResult(event:MenuRemoteServerEvent):void
{
	var xmlStr:String = event.object as String;
	menuTreeXml = new XML(xmlStr);
}

//---------------------------------------------------------------------
//-- 导出excel
//---------------------------------------------------------------------
/**
 * 导出excel 
 * @param event
 * 
 */
private var sheet:Sheet;

protected function exportExcelBtn_clickHandler(event:MouseEvent):void
{
	roleProxy.selectAll();
}

//------------------------------------------------------------------------------------------
//--- 逻辑函数
//------------------------------------------------------------------------------------------
private function exportExcel(arrayCol:IList):void
{
	var excelFile:ExcelFile = new ExcelFile();
	for(var i:int=1; i<=arrayCol.length;i++){  
		var obj:Object = arrayCol.getItemAt(i-1);  
		var xml:XML = describeType(obj);
		var j:int = 0;  
		for each(var accessor:XML in xml..accessor){
			var name:String= accessor.@name;
			var type:String= accessor.@type;
			var zh_cnName:String = Role.object[name];
			if(zh_cnName){
				excelFile.sheets.addItem(generateSheet(0,j,zh_cnName));
			}else{
				excelFile.sheets.addItem(generateSheet(0,j,name));
			}
//			excelFile.sheets.addItem(generateSheet(0,j,name));
			excelFile.sheets.addItem(generateSheet(i,j,obj[name]));
			j += 1;  
		}
	}  
	var mbytes:ByteArray = excelFile.saveToByteArray(); 
	
	var stream:FileStream = new FileStream(); 
	var docsDir:File = File.documentsDirectory.resolvePath("用户列表.xls"); // 定死文件名
	try
	{
		docsDir.browseForSave("Save As");
		docsDir.addEventListener(Event.SELECT, saveData);
	}
	catch (error:Error)
	{
		trace("Failed:", error.message)
	}
	
	function saveData(event:Event):void
	{
		var newFile:File = event.target as File;
		
		if (!newFile.exists)
		{
			var stream:FileStream = new FileStream();
			stream.open(newFile, FileMode.WRITE);
			stream.writeBytes(mbytes);
			// 写文件流
			stream.close();
		}
	}
	/*var file:FileReference = new FileReference();  
	try  
	{  
	file.save(mbytes,"测试文件.xls"); // 定死文件名  
	}catch (error:Error){  
	trace("Failed:", error.message)  
	}*/  
	
	function generateSheet(i:int,j:int,o:Object):Sheet{  
		if(!sheet){  
			sheet = new Sheet();  
			sheet.resize(10,10);  
		}  
		sheet.setCell(i, j, String(o));  
		return sheet;  
	}  
}