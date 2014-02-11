import com.as3xls.xls.ExcelFile;
import com.as3xls.xls.Sheet;
import com.usee.elecoin.common.Page;
import com.usee.elecoin.system.controller.UserRemoteServerEvent;
import com.usee.elecoin.system.model.UserRemoteServerProxy;
import com.usee.elecoin.system.model.vo.User;
import com.usee.elecoin.system.view.UserForm;

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

private var userProxy:UserRemoteServerProxy = new UserRemoteServerProxy();
private var userForm:UserForm;

protected function navigatorcontent1_creationCompleteHandler(event:FlexEvent):void
{
	userProxy.query(this.page);
	
	userProxy.addEventListener(UserRemoteServerEvent.queryResult,onqueryResult);
	userProxy.addEventListener(UserRemoteServerEvent.queryFault,onqueryFault);
	userProxy.addEventListener(UserRemoteServerEvent.insertResult,oninsertResult);
	userProxy.addEventListener(UserRemoteServerEvent.insertFault,oninsertFault);
	userProxy.addEventListener(UserRemoteServerEvent.updateResult,onupdateResult);
	userProxy.addEventListener(UserRemoteServerEvent.updateFault,onupdateFault);
	userProxy.addEventListener(UserRemoteServerEvent.deleteByPrimaryKeyResult,ondeleteByPrimaryKeyResult);
	userProxy.addEventListener(UserRemoteServerEvent.deleteByPrimaryKeyFault,ondeleteByPrimaryKeyFault);
}

/**
 * 查询分页成功 
 * @param event
 * 
 */
protected function onqueryResult(event:UserRemoteServerEvent):void
{
	this.page = event.object as Page;
	/*if(this.page.page>this.page.total){
		this.page.page = this.page.total;
		queryBtn_clickHandler(null);
	}*/
}

/**
 *  查询分页失败。
 * @param event
 * 
 */
protected function onqueryFault(event:UserRemoteServerEvent):void
{
	Alert.show(event.object.toString());
}

protected function pagecomponent1_pageChangeHandler(event:Event):void
{
	userProxy.query(this.page,keyInput.text);
}

/**
 * 查询 
 * @param event
 * 
 */
protected function queryBtn_clickHandler(event:MouseEvent):void
{
	userProxy.query(this.page,keyInput.text);
}

/**
 * 添加用户 
 * @param event
 * 
 */
protected function addBtn_clickHandler(event:MouseEvent):void
{
	userForm = PopUpManager.createPopUp(this,UserForm) as UserForm;
	PopUpManager.centerPopUp(userForm);
	userForm.confirmBtn.addEventListener(MouseEvent.CLICK,onconfirmBtnClick);
}

/**
 * 
 * @param event
 * 
 */
protected function onconfirmBtnClick(event:MouseEvent):void
{
	var user:User = userForm.user;
	if(user.id && user.id!=""){
	
	}else{
//		user.createdate = new Date();
		user.id = new Date().time+"";
		userProxy.insert(user);
	}
}

protected function oninsertFault(event:UserRemoteServerEvent):void
{
	Alert.show(event.object.toString());
}

protected function oninsertResult(event:UserRemoteServerEvent):void
{
	PopUpManager.removePopUp(userForm);
	keyInput.text = "";
	queryBtn_clickHandler(null);
}

protected function updateBtn_clickHandler(event:MouseEvent):void
{
	userForm = PopUpManager.createPopUp(this,UserForm) as UserForm;
	userForm.user = dataGrid.selectedItem as User;
	PopUpManager.centerPopUp(userForm);
	userForm.confirmBtn.addEventListener(MouseEvent.CLICK,onconfirmBtnClick);
}

protected function onupdateFault(event:UserRemoteServerEvent):void
{
	Alert.show(event.object.toString());
}

protected function onupdateResult(event:UserRemoteServerEvent):void
{
	PopUpManager.removePopUp(userForm);
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
	var user:User = dataGrid.selectedItem as User;
	userProxy.deleteByPrimaryKey(user.id);
}

protected function ondeleteByPrimaryKeyFault(event:UserRemoteServerEvent):void
{
	Alert.show(event.object.toString());
}

protected function ondeleteByPrimaryKeyResult(event:UserRemoteServerEvent):void
{
	keyInput.text = "";
	queryBtn_clickHandler(null);
}

/**
 * 导出excel 
 * @param event
 * 
 */
private var sheet:Sheet;

protected function exportExcelBtn_clickHandler(event:MouseEvent):void
{
	var arrayCol:IList = dataGrid.dataProvider;
	var excelFile:ExcelFile = new ExcelFile();
	for(var i:int=1; i<=arrayCol.length;i++){  
		var obj:Object = arrayCol.getItemAt(i-1);  
		var xml:XML = describeType(obj);
		var j:int = 0;  
		for each(var accessor:XML in xml..accessor){
			var name:String= accessor.@name;
			var type:String= accessor.@type;
			var zh_cnName:String = User.object[name];
			if(zh_cnName){
				excelFile.sheets.addItem(generateSheet(0,j,zh_cnName));
			}else{
				excelFile.sheets.addItem(generateSheet(0,j,name));
			}
			  
			excelFile.sheets.addItem(generateSheet(i,j,obj[name]));
			j += 1;  
		}
		
		/*var j:int = 0;  
		for(var key:String in obj){  
			excelFile.sheets.addItem(generateSheet(0,j,key));  
			excelFile.sheets.addItem(generateSheet(i,j,obj[key]));  
			j += 1;  
		} */ 
	}  
	var mbytes:ByteArray = excelFile.saveToByteArray(); 
	
	var stream:FileStream = new FileStream(); 
	var docsDir:File = File.documentsDirectory.resolvePath("abc.xls"); // 定死文件名
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