import demo.TopologyService;
import demo.index.NetWorkGroup;

import flash.display.Bitmap;
import flash.display.DisplayObject;
import flash.display.Loader;
import flash.events.Event;
import flash.events.IOErrorEvent;
import flash.events.MouseEvent;
import flash.events.TimerEvent;
import flash.external.ExternalInterface;
import flash.net.URLLoader;
import flash.net.URLLoaderDataFormat;
import flash.net.URLRequest;
import flash.net.URLRequestMethod;
import flash.net.URLVariables;
import flash.utils.Timer;

import mx.collections.ArrayCollection;
import mx.collections.ArrayList;
import mx.collections.XMLListCollection;
import mx.controls.Alert;
import mx.core.FlexGlobals;
import mx.events.FlexMouseEvent;
import mx.managers.PopUpManager;
import mx.rpc.events.FaultEvent;
import mx.rpc.events.ResultEvent;
import mx.rpc.http.mxml.HTTPService;
import mx.utils.ColorUtil;

import twaver.Alarm;
import twaver.AlarmBox;
import twaver.AlarmSeverity;
import twaver.ElementBox;
import twaver.Follower;
import twaver.ICollection;
import twaver.IElement;
import twaver.LayerBox;
import twaver.Node;
import twaver.Utils;
import twaver.XMLSerializer;
import twaver.network.layout.AutoLayouter;
import twaver.network.layout.SpringLayouter;

private var  isAuto:Boolean = false;
private var  xmlSerializer:XMLSerializer;
private var  nodeOverColor:Number = 16776960;
private var  linkOverColor:Number = 16711935;
private var  ErrorAS:AlarmSeverity = null;
private var  dataNodes:ArrayCollection = null;
private var  autoLayouter:AutoLayouter = null;
private var  timer:Timer = null;
private var  ttime:Timer;
private var  springLaouter:SpringLayouter = null;
private var  NormalAS:AlarmSeverity = null;
private var  nodeColor:Number = 16711680;
private var  lastElement:IElement = null;
private var  linkColor:Number = 6737151;
private var  WarningAS:AlarmSeverity = null;
private var  layerBox:LayerBox;
private var  autoLayoutLabel:String = "round";
private var  selectColor:Number = 65280;
private var  box:ElementBox;

[Embed(source="images/MonitorPortal_UrlMonitor1.png")]
public static const  UrlMonitor1:Class;
[Embed(source="images/MonitorPortal_PIC2.png")]
public static const  PIC2:Class;
[Embed(source="images/MonitorPortal_MSSQLDBserver.png")]
public static const  MSSQLDBserver:Class;
[Embed(source="images/MonitorPortal_PIC4.png")]
public static const  PIC4:Class;
[Embed(source="images/MonitorPortal_UrlMonitor.png")]
public static const  UrlMonitor:Class;
[Embed(source="images/MonitorPortal_smile.png")]
public static const  smile:Class;
[Embed(source="images/MonitorPortal_UrlSeq.png")]
public static const  UrlSeq:Class;
[Embed(source="images/MonitorPortal_PIC11.png")]
public static const  PIC11:Class;
[Embed(source="images/MonitorPortal_Windows2000.png")]
public static const  Windows2000:Class;
[Embed(source="images/MonitorPortal_Windows2003.png")]
public static const  Windows2003:Class;
[Embed(source="images/MonitorPortal_Tomcatserver.png")]
public static const  Tomcatserver:Class;
[Embed(source="images/MonitorPortal_HPUX.png")]
public static const  HPUX:Class;
[Embed(source="images/MonitorPortal_subnetworkimage.png")]
public static const  subnetworkimage:Class;
[Embed(source="images/MonitorPortal_AIX.png")]
public static const  AIX:Class;
[Embed(source="images/MonitorPortal_Apacheserver.png")]
public static const  Apacheserver:Class;
[Embed(source="images/MonitorPortal_ORACLEDBserver.png")]
public static const  ORACLEDBserver:Class;
[Embed(source="images/MonitorPortal_NodeImg.png")]
public static const  NodeImg:Class;
[Embed(source="images/MonitorPortal_PIC20111216150907.jpg")]
public static const  PIC20111216150907:Class;
[Embed(source="images/MonitorPortal_WEBLOGICserver.png")]
public static const  WEBLOGICserver:Class;
[Embed(source="images/MonitorPortal_bg400.jpg")]
public static const  bg400:Class;
[Embed(source="images/MonitorPortal_bg600.jpg")]
public static const  bg600:Class;
[Embed(source="images/MonitorPortal_bg800.jpg")]
public static const  bg800:Class;
[Embed(source="images/MonitorPortal_Linux.png")]
public static const  Linux:Class;
[Embed(source="images/MonitorPortal_Switch.png")]
public static const  Switch:Class;
[Embed(source="images/MonitorPortal_sad.png")]
public static const  sad:Class;
[Embed(source="images/MonitorPortal_Router.png")]
public static const  Router:Class; 
[Bindable]
private var userName:String; //登陆账号
[Bindable]
private var resourceId:String;//资源id
[Bindable]
private var resids:String;//资源字符串
[Bindable]
private var preName:String;//资源字符串

[Bindable]
private var arrayList:ArrayList;

private var hasSubnetwork:Boolean;
/**
 * 初始化函数 
 */
public function init() : void
{
	Utils.validateLicense(this.licenseXML);
	var parameters : Object = FlexGlobals.topLevelApplication.parameters;
	this.userName = parameters.uName;
	this.resourceId = parameters.resourceId;
//	this.preName  = parameters.name;//portlet首选项name的值
	var hasSubnet:String = parameters.hasSubnetwork;
	if(hasSubnet == "true"){
		this.hasSubnetwork = true;
	}else{
		this.hasSubnetwork = false;
	}
	
	Utils.registerImageByClass("sad", sad);
	Utils.registerImageByClass("smile", smile);
//	Utils.registerImageByClass("bg400", bg400);
//	Utils.registerImageByClass("bg600", bg600);
//	Utils.registerImageByClass("bg800", bg800);
	TopologyService.getImagesTypeList("prename","weblogic",null,null,true);
	initParameters();
	
	reset();
//	registerImages();
	var timer:Timer = new Timer(1200,1);
	timer.start();
	timer.addEventListener(TimerEvent.TIMER,function onTimer(event:TimerEvent):void{
		getView();
		registerJsFun();
	});
	
	addEventListenerForNodes();
	ErrorAS = register(500, "ErrorAS", "严重",  0xFF0000);
	WarningAS = register(234, "WarningAS", "告警", 0x00FFFF);
	NormalAS = register(100, "NormalAS", "正常",  0xC800FF); 
	
//	doDisplayMSViewData(dp);
}

/**
 * 初始化函数。
 */ 
private function initParameters():void{
	arrayList = new ArrayList();
	var arrayStr:String = FlexGlobals.topLevelApplication.parameters.picArray;
	if(arrayStr){
		var picArray:Array = arrayStr.split(",");
		var obj:Object;
		for (var i:int = 0; i < picArray.length; i++) 
		{
			obj = {};
			obj.source=picArray[i];
			arrayList.addItem(obj);
		}
	}
	
	var j:int = 0;
	
	arrayStr = FlexGlobals.topLevelApplication.parameters.labelArray;
	if(arrayStr){
		var labelArray:Array = arrayStr.split(",");
		for (j = 0; j < labelArray.length; j++) 
		{
			obj =arrayList.getItemAt(j);
			obj.label = labelArray[j];
		}
	}
	
	arrayStr = FlexGlobals.topLevelApplication.parameters.ridsArray;
	if(arrayStr){
		var ridsArray:Array = arrayStr.split(",");
		for (j = 0; j < ridsArray.length; j++) 
		{
			obj =arrayList.getItemAt(j);
			obj.rid = ridsArray[j];
		}
	}
	
	arrayStr = FlexGlobals.topLevelApplication.parameters.bgArray;
	
	if(arrayStr){
		var bgArray:Array = arrayStr.split(",");
		var loader:Loader;
		for (j = 0; j < bgArray.length; j++) 
		{
			var bgSource:String = String(bgArray[j]);
			loader = new Loader();
			loader.load(new URLRequest(encodeURI(bgSource)));
			
			var index:int = bgSource.lastIndexOf("/");
			var dotindex:int = bgSource.lastIndexOf(".");
			var picName:String = bgSource.substring(index+1,dotindex);
			loader.contentLoaderInfo.addEventListener(Event.COMPLETE,onLoaderTypeListComplete(picName));
		}
	}
}
/**
 * 处理调用错误的情况。
 */ 
protected function _getMSData_Fault(event:FaultEvent):void
{
	Alert.show(event.fault.toString(),'出错了');
}

public function _getMSData_result(event:ResultEvent) : void
{
	displayMSViewData(event);
	return;
}

/**
 * 反序列化，显示借点数据。 
 * @param event
 * 
 */
public function displayMSViewData(event:ResultEvent) : void
{
	var result:String = getMSDataService.lastResult as String;
	doDisplayMSViewData(result);
	return;
}

public function doDisplayMSViewData(msdataString:String,ifAddExternalInfo:Boolean = true) : void
{
	box.alarmBox.clear();
	box.clear();
	xmlSerializer.deserialize(msdataString);
	if (timer != null)
	{
		timer.stop();
		timer = null;
	}
	timer = new Timer(1000, 1);
	timer.start();
	timer.addEventListener(TimerEvent.TIMER, function (event:TimerEvent) : void
	{
		if(ifAddExternalInfo){
			addExternalInfo(msdataString);
		}
	}
	);
}

public function addExternalInfo(msdataString:String) : void
{
	var resoureidStr:String = "";
	var xml:XML = XML(msdataString);
	var xmllist:XMLList = xml.children();
	var length:int = xmllist.length();
	reset();
	
	for (var i:int = 0; i < length; i++) 
	{
		var tempXml:XML = xmllist[i];
		if(tempXml.@type == "twaver.Node"){
			var node:Node;
			var simularType:String;
			var MPID:String;
			var nodeId:String = tempXml.@id;
			node = new Node();
			node.setClient("mapID", MPID);
			node.setClient("dataID", nodeId);
			
			for each (var childXml:XML in tempXml.children()) 
			{
				var pro:String = childXml.@n;
				if(pro =="MAPPINGID"){
					MPID = childXml.text();
					resoureidStr += MPID+",";
					
					node.setClient("mapID", MPID);
				}
				
				if(pro =="image"){
					simularType = childXml.text();
					node.setClient("type", simularType);
				}
			}
			
			dataNodes.addItem(node);
		}
	}
	if(resoureidStr != ""){
		resoureidStr = resoureidStr.substring(0, (resoureidStr.length - 1));
	}
	this.resids = resoureidStr;
	
	getAlertListService.send();
//	processAlertLists(alertStr);
	
	return;
}

public function addAlarm(K1K:Object, elementID:Object, alarmSeverity:AlarmSeverity, alarmBox:AlarmBox) : void
{
	var alarm:Alarm = new Alarm(K1K, elementID, alarmSeverity);
	alarmBox.add(alarm);
	return;
}// end function


public function _getAlertList_result(event:ResultEvent) : void
{
	var result:String = getAlertListService.lastResult.toString();
	processAlertLists(result);
	return;
}

/**
 * 处理告警
 */ 
public function processAlertLists(result:String) : void
{
	var alertVoXml:XML = null;
	var _loc_3:XML = XML(result);
	for each (alertVoXml in _loc_3..AlertVO)
	{
		
		renderAlert(alertVoXml.resourceid, alertVoXml.AVAILABILITY, alertVoXml.HEALTH, alertVoXml.type);
	}
	if (timer != null)
	{
		timer.stop();
		timer = null;
	}
	ExternalInterface.call("setPreLoadedCompleted");
	return;
}

/**
 * 显示告警。
 */ 
public function renderAlert(resourceid:String, availability:int, health:int, type:String) : void
{
	var dataIdString:String = null;
	var node:Node = null;
	var mapIDString:String = null;
	var alarm:Alarm = null;
	for each (node in dataNodes)
	{
		
		mapIDString = node.getClient("mapID");
		if (mapIDString == null || mapIDString != resourceid)
		{
			continue;
		}
		dataIdString = node.getClient("dataID");
		if (dataIdString == null)
		{
			continue;
		}
		break;
	}
	if (dataIdString == null)
	{
		return;
	}
	var _loc_7:Node = network.elementBox.getElementByID(dataIdString) as Node;
	if (_loc_7 == null)
	{
		return;
	}
	
	/*if (type == "WEBLOGIC-server")
	{
	}
	else
	{
		
	}*/
	
	alarm = new Alarm("HEALTH_" + dataIdString, dataIdString);
	if (health == 1)
	{
		alarm.alarmSeverity = ErrorAS;
	}
	else if (health == 2 || health == 3 || health == 4)
	{
		alarm.alarmSeverity = WarningAS;
	}
	else if (health == 5)
	{
	}
	
	alarm.setClient("MAPPINGID", resourceid);
	network.elementBox.alarmBox.add(alarm);
	
	_loc_7.setClient("MAPPINGID", resourceid);
	_loc_7.setClient("type", type);
	var follower:Follower = new Follower();
	follower.setSize(16, 16);
	follower.setLocation(_loc_7.x + _loc_7.width - 10, _loc_7.y + _loc_7.height - follower.height);
	follower.layerID = _loc_7.layerID;
	follower.host = _loc_7;
	
	if (availability == 0)
	{
		follower.image = "sad";
	}
	else
	{
		follower.image = "smile";
	}
	
	/* if (type == "WEBLOGIC-server")
	{
	follower.image = "smile";
	} */ 
	network.elementBox.add(follower);
	return;
}

/**
 * 注册告警颜色。
 */ 
public static function register(value:int, name:String, nickName:String, color:uint, displayName:String = null) : AlarmSeverity
{
	var alarmseverity:AlarmSeverity = new AlarmSeverity(value, name, nickName, color, displayName);
	return alarmseverity;
}

protected function loadImages(url:String, data:URLVariables, onEvent:Function):void
{
	var _urlReq:URLRequest = new URLRequest();
	_urlReq.url = url;
	_urlReq.method = URLRequestMethod.POST;
	
	if (data!=null){
		_urlReq.data = data;
	}
	var loader:URLLoader = new URLLoader();
	loader.dataFormat = URLLoaderDataFormat.TEXT;
	loader.load(_urlReq);
	loader.addEventListener(Event.COMPLETE, onEvent);
	loader.addEventListener(IOErrorEvent.IO_ERROR, function onIoError(event:IOErrorEvent):void{
		Alert.show(event.toString());
	});
}

protected function onLoadImageComplete(event:Event):void {
	var loader:URLLoader=URLLoader(event.target); 
	var _data:URLVariables = new URLVariables(loader.data); 
	var xmlContent:String = _data.data;
	var xml:XML=new XML(xmlContent);
	var xmlList:XMLList = xml.elements("Item"); 
	var xmlListCollection:XMLListCollection = new XMLListCollection(xmlList); 
	var imageArray: ArrayCollection = new ArrayCollection(xmlListCollection.toArray());
	if (imageArray.length>0)
	{
		for (var i:int = 0; i<imageArray.length; i++)
		{
			var loader1:Loader = new Loader();
			loader1.load(new URLRequest(encodeURI(imageArray[i].Value)));
			var picName:String = imageArray[i].Name;
			loader1.contentLoaderInfo.addEventListener(Event.COMPLETE, onLoaderTypeListComplete(picName));
		}
	} 
	
	if(this.resourceId && this.resourceId !=''){
		getMSDataService.send();
	}
	/*if(this.userName && this.userName !='' && this.preName && this.preName !=''){
		getViewService.send();
	}*/
	////加载背景图片。
//	getBackGroundImages("/MonitorPortal/Portlet/TopologyView/getBackGroundImageData.do",_data,onLoadBackComplete);
}

public function onLoaderTypeListComplete(picName:String):Function {
	var fun:Function=function(e:Event):Boolean {
		Utils.registerImageByBitmapData(picName, (e.currentTarget.content as Bitmap).bitmapData);
		return false ;
	}
	return fun;
}

///
///处理背景图片（声明和注册）
///
public function getBackGroundImages(url:String, data:URLVariables, onEvent:Function):void {
	var _urlReq:URLRequest = new URLRequest();
	_urlReq.url = url;
	_urlReq.method = URLRequestMethod.POST;
	
	if (data!=null){
		_urlReq.data = data;
	}
	var loader:URLLoader = new URLLoader();
	loader.dataFormat = URLLoaderDataFormat.TEXT;
	loader.load(_urlReq);
	loader.addEventListener(Event.COMPLETE, onEvent);
	loader.addEventListener(IOErrorEvent.IO_ERROR, function onIoError(event:IOErrorEvent):void{
		Alert.show(event.toString());
	});
	/*var _data:URLVariables = new URLVariables();
	_data.preName = preName;
	_data.userName = userName;
	request("/MonitorPortal/Portlet/TopologyView/getBackGroundImages.do", _data,
		function(event:Event):void {
			
		}
	);*/
}

private function onLoadBackComplete(event:Event):void{
	var loader:URLLoader=URLLoader(event.target); 
	var _data:URLVariables = new URLVariables(loader.data); 
	var xmlContent:String = _data.data;
	Alert.show(xmlContent,"调用背景图片成功");
	var xml:XML=new XML(xmlContent);
	var xmlList:XMLList = xml.elements("Item"); 
	var xmlListCollection:XMLListCollection = new XMLListCollection(xmlList); 
	var imageArray: ArrayCollection = new ArrayCollection(xmlListCollection.toArray());
	if (imageArray.length>0)
	{
		for (var i:int = 0; i<imageArray.length; i++)
		{
			
			var picName:String = imageArray[i].Name;
			
			var _urlReq:URLRequest = new URLRequest();
			_urlReq.url = "/MonitorPortal/Portlet/TopologyView/getBackGroundImageData.do";
			_urlReq.method = URLRequestMethod.POST;
			var data:URLVariables = new URLVariables();
			data.userName_fileName = imageArray[i].Value;
			if (data!=null){
				_urlReq.data =data;
			}
			var _loader:Loader = new Loader();
			
			_loader.load(_urlReq);
			
			_loader.contentLoaderInfo.addEventListener(Event.COMPLETE, onLoaderBackgroundComplete(picName));
		}
	} 
}

public function onLoaderBackgroundComplete(picName:String):Function {
	var fun:Function=function(e:Event):Boolean {
		Utils.registerImageByBitmapData(picName, (e.currentTarget.content as Bitmap).bitmapData);
		return false ;
	}
	return fun;
}
//------------------------------------------------------------------------
// js回调函数
//------------------------------------------------------------------------
/**
 * 注册回调函数。
 */ 
public function setupCallBacks() : void
{
	ExternalInterface.addCallback("Nav2SystemViewInFlex", Nav2SystemViewInFlex);
//	ExternalInterface.addCallback("collectResIdAndAlertInFlex", addExternalInfo);
//	ExternalInterface.addCallback("reset", reset);
	ExternalInterface.call("setSwfIsReady");
	return;
}

public function Nav2SystemViewInFlex(uName:String, rid:String) : String
{
	this.userName = uName;
	this.resourceId = rid;
	
	getMSDataService.send();
	return "success";
}

public function getView():void{
	if(this.resourceId && this.resourceId !=''){
		getMSDataService.send();
	}
}
/**
 * 重新设置。
 */ 
public function reset() : void
{
	resids = "";
	if (dataNodes != null)
	{
		dataNodes.removeAll();
		dataNodes = null;
	}
	dataNodes = new ArrayCollection();
	if (box != null)
	{
	}
	box = network.elementBox;
	xmlSerializer = new XMLSerializer(box);
	return;
}

public function registerJsFun() : void
{
	this.callLater(setupCallBacks);
	/* var containerReady:Boolean;
	var readyTimer:Timer;
	if (ExternalInterface.available)
	{
	try
	{
	containerReady = isContainerReady();
	if (containerReady)
	{
	setupCallBacks();
	}
	else
	{
	readyTimer = new Timer(100);
	readyTimer.addEventListener(TimerEvent.TIMER, timeHandler);
	readyTimer.start();
	}
	}
	catch (error:Error)
	{
	trace(error);
	}
	}
	else
	{
	trace("External interface is not available for this container.");
	} */
}

public function isContainerReady() : Boolean
{
	var isReady:Boolean = Boolean(ExternalInterface.call("isReady"));
	return isReady;
}

public function timeHandler(event:TimerEvent) : void
{
	var _loc_2:Boolean = isContainerReady();
	if (_loc_2)
	{
		Timer(event.target).stop();
		setupCallBacks();
	}
	return;
}// end function

/**
 * 侦听节点双击事件。
 */ 
public function addEventListenerForNodes() : void
{
	network.addEventListener(MouseEvent.DOUBLE_CLICK, function (event:MouseEvent) : void
	{
		var iCollection:ICollection = network.selectionModel.selection;
		if (iCollection == null || iCollection.count != 1)
		{
			return;
		}
		var obj:Object = iCollection.toArray()[0];
		if (obj is Node)
		{
		}
		else
		{
			return;
		}
		var node:Node = obj as Node;
		var mappingid:String = node.getClient("MAPPINGID");
		var type:String = node.getClient("type");
//		Alert.show("this.hasSubnetwork的值是:"+hasSubnetwork+",资源id的值是："+mappingid);
		if(mappingid != null && mappingid != "" && hasSubnetwork){
//			Alert.show("资源id是"+mappingid);
			var netWorkGroup:NetWorkGroup = PopUpManager.createPopUp(FlexGlobals.topLevelApplication as DisplayObject,NetWorkGroup) as NetWorkGroup;
			netWorkGroup.resourceid = mappingid;
			netWorkGroup.width = 800;
			netWorkGroup.height = 370;
			PopUpManager.centerPopUp(netWorkGroup);
			netWorkGroup.addEventListener(FlexMouseEvent.MOUSE_DOWN_OUTSIDE,function onMouseDownOutside(event:FlexMouseEvent):void{
				PopUpManager.removePopUp(netWorkGroup);
			});
			return;
		}
		if (mappingid != null && mappingid != "" && type != null && type != "")
		{
			ExternalInterface.call("nav2ElementLink", mappingid, type);
		}
		return;
	}// end function
	);
	return;
}

/**
 * 注册图片。
 */ 
public function registerImages() : void
{
	var _data:URLVariables = new URLVariables();
	if(!this.resourceId){
		_data.preName = "images";
	}else{
		_data.preName = resourceId;
	}
	_data.userName = this.userName;
//	getBackGroundImages("/MonitorPortal/Portlet/TopologyView/getBackGroundImageData.do",_data,onLoadBackComplete);
	loadImages("/MonitorPortal/Portlet/TopologyView/getNetworkResourceTypeImages3.do",_data,onLoadImageComplete);
	
//	Utils.registerImageByClass("sad", sad);
//	Utils.registerImageByClass("smile", smile);
//	Utils.registerImageByClass("AIX", AIX);
//	Utils.registerImageByClass("Apache-server", Apacheserver);
//	Utils.registerImageByClass("HP-UX", HPUX);
//	Utils.registerImageByClass("Linux", Linux);
//	Utils.registerImageByClass("MSSQL-DB-server", MSSQLDBserver);
//	Utils.registerImageByClass("Node", NodeImg);
//	Utils.registerImageByClass("ORACLE-DB-server", ORACLEDBserver);
//	Utils.registerImageByClass("Router", Router);
//	Utils.registerImageByClass("Switch", Switch);
//	Utils.registerImageByClass("Tomcat-server", Tomcatserver);
//	Utils.registerImageByClass("UrlMonitor", UrlMonitor);
//	Utils.registerImageByClass("UrlSeq", UrlSeq);
//	Utils.registerImageByClass("WEBLOGIC-server", WEBLOGICserver);
//	Utils.registerImageByClass("Windows 2000", Windows2000);
//	Utils.registerImageByClass("Windows 2003", Windows2003);
//	Utils.registerImageByClass("20111216150907", PIC20111216150907);
//	Utils.registerImageByClass("02", PIC2);
//	Utils.registerImageByClass("04", PIC4);
//	Utils.registerImageByClass("11", PIC11);
//	Utils.registerImageByClass("bg400", bg400);
//	Utils.registerImageByClass("bg600", bg600);
//	Utils.registerImageByClass("bg800", bg800);
//	Utils.registerImageByClass("subnetwork_image", subnetworkimage);
//	Utils.registerImageByClass("UrlMonitor1", UrlMonitor1);
}

//-----------------------------------------------------------------------------------------------
// 查询视图
//-----------------------------------------------------------------------------------------------
protected function getViewService_faultHandler(event:FaultEvent):void
{
	
}

protected function getViewService_resultHandler(event:ResultEvent):void
{
	var result:String = getViewService.lastResult as String;
	doDisplayMSViewData(result);
}

private var dp:String = "<twaver v='1.2' p='flex'>" +
	"<dataBox type='twaver.ElementBox'>" +
	"<layerBox>" +
	"<layer name='default' visible='true' editable='true' movable='true'/>" +
	"</layerBox>" +
	"<s n='background.type'>image</s>" +
	"<s n='background.image'>bg1</s>" +
	"</dataBox>" +
	"<data type='twaver.Node' ref='0' id='195A846D-1AFA-59D6-3E5F-BB8A1E99E728'>" +
	"<s n='outer.style'>glow</s>" +
	"<s n='label.color'>16777215</s>" +
	"<c n='MAPPINGID'>10000182</c>" +
	"<p n='name'><![CDATA[桌面安全管理系统windows主机服务器(99.12.40.42)]]></p>" +
	"<p n='icon'>Windows 2003</p>" +
	"<p n='image'>Windows 2003</p>" +
	"<p n='location' x='198.64999999999984' y='127.95000000000002'/>" +
	"</data>" +
	"<data type='twaver.Node' ref='1' id='28C4CFC6-60EC-1B48-0A5B-BB8A2C9B40CD'>" +
	"<s n='outer.style'>glow</s>" +
	"<s n='label.color'>16777215</s>" +
	"<c n='MAPPINGID'>10000101</c>" +
	"<p n='name'><![CDATA[桌面安全防护系统登录页面服务(99.12.40.42)]]></p>" +
	"<p n='icon'>UrlMonitor</p>" +
	"<p n='image'>UrlMonitor</p>" +
	"<p n='location' x='642' y='129.09999999999994'/>" +
	"</data>" +
	"<data type='twaver.Node' ref='2' id='72572360-653A-8506-118D-BB8A49B29D9C'>" +
	"<s n='outer.style'>glow</s>" +
	"<s n='label.color'>16777215</s>" +
	"<c n='MAPPINGID'>10000108</c>" +
	"<p n='name'><![CDATA[桌面安全防护系统sqlserver数据库服务器(99.12.40.42)]]></p>" +
	"<p n='icon'>MSSQL-DB-server</p>" +
	"<p n='image'>MSSQL-DB-server</p>" +
	"<p n='location' x='458.1499999999999' y='61.09999999999994'/>" +
	"</data>" +
	"<data type='twaver.Link' ref='3' id='9F38C024-DF01-76F1-ED81-BB8B38947A88'>" +
	"<s n='link.split.by.percent'>true</s>" +
	"<s n='link.type'>flexional</s>" +
	"<p n='fromNode' ref='0'/>" +
	"<p n='toNode' ref='2'/>" +
	"</data>" +
	"<data type='twaver.Node' ref='4' id='8D811550-2B61-9535-1B4D-D731D8B11422'>" +
	"<s n='outer.style'>glow</s>" +
	"<s n='label.color'>16777215</s>" +
	"<c n='MAPPINGID'>10000107</c>" +
	"<p n='name'><![CDATA[桌面安全防护系统IIS服务器(99.12.40.42)]]></p>" +
	"<p n='icon'>Apache-server</p>" +
	"<p n='image'>Apache-server</p>" +
	"<p n='location' x='445.85' y='202.85'/>" +
	"</data>" +
	"<data type='twaver.Link' ref='5' id='75DBFD2F-088C-7161-4396-D7C98062D010'>" +
	"<s n='link.split.by.percent'>true</s>" +
	"<s n='link.type'>flexional</s>" +
	"<p n='fromNode' ref='0'/>" +
	"<p n='toNode' ref='4'/>" +
	"</data>" +
	"<data type='twaver.Link' ref='6' id='32F46317-243A-6EB0-69F4-D7C98D00C3B0'>" +
	"<s n='link.split.by.percent'>true</s>" +
	"<s n='link.type'>flexional</s>" +
	"<p n='fromNode' ref='4'/>" +
	"<p n='toNode' ref='1'/>" +
	"</data>" +
	"</twaver>"
	
	private var alertStr:String = "<AlertVOs><AlertVO><resourceid>10000182</resourceid>" +
		"<AVAILABILITY>1</AVAILABILITY><HEALTH>5</HEALTH><type>Windows 2003</type></AlertVO>" +
		"<AlertVO><resourceid>10000101</resourceid><AVAILABILITY>1</AVAILABILITY><HEALTH>5</HEALTH><type>UrlMonitor</type></AlertVO>" +
		"<AlertVO><resourceid>10000108</resourceid><AVAILABILITY>0</AVAILABILITY><HEALTH>-1</HEALTH><type>MSSQL-DB-server</type></AlertVO>" +
		"<AlertVO><resourceid>10000107</resourceid><AVAILABILITY>1</AVAILABILITY><HEALTH>5</HEALTH><type>IIS-server</type></AlertVO></AlertVOs>";