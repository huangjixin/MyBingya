import demo.TopologyService;
import demo.index.IndexItemRenderer;
import demo.index.NetWorkGroup;

import flash.display.Bitmap;
import flash.display.BitmapData;
import flash.display.DisplayObject;
import flash.display.Loader;
import flash.display.StageDisplayState;
import flash.events.Event;
import flash.events.IOErrorEvent;
import flash.events.KeyboardEvent;
import flash.events.MouseEvent;
import flash.events.TimerEvent;
import flash.net.URLLoader;
import flash.net.URLLoaderDataFormat;
import flash.net.URLRequest;
import flash.net.URLRequestMethod;
import flash.net.URLVariables;
import flash.ui.Keyboard;
import flash.utils.Timer;

import mx.collections.ArrayCollection;
import mx.collections.ArrayList;
import mx.collections.XMLListCollection;
import mx.controls.Alert;
import mx.core.FlexGlobals;
import mx.core.IVisualElement;
import mx.events.FlexEvent;
import mx.events.FlexMouseEvent;
import mx.events.ItemClickEvent;
import mx.events.SandboxMouseEvent;
import mx.managers.PopUpManager;

import spark.components.Image;
import spark.effects.Resize;
import spark.effects.easing.Bounce;
import spark.effects.easing.Elastic;
import spark.effects.easing.Linear;
import spark.effects.easing.Power;
import spark.effects.easing.Sine;
import spark.events.RendererExistenceEvent;
import spark.primitives.BitmapImage;

import twaver.Utils;
import twaver.network.Network;

private var lastX:Number = 0;
private var lastY:Number = 0;

private var timer:Timer = new Timer(6000,0);

[Bindable]
private var username:String;

[Bindable]
private var resourceId:String;

[Bindable]
private var arrayList:ArrayList;

private var statePicArray:ArrayList = new ArrayList();

private var healthPicArray:ArrayList = new ArrayList();

private var picBitmapDataArray:ArrayList = new ArrayList();

protected function creationCompleteHandler(event:FlexEvent):void
{
	Utils.validateLicense(this.licenseXML);
	username = FlexGlobals.topLevelApplication.parameters.uName;
	resourceId = FlexGlobals.topLevelApplication.parameters.resourceId;
	//				registerImages();
	Utils.registerImageByClass("sad", sad);
	Utils.registerImageByClass("smile", smile);
	Utils.registerImageByClass("bg400", bg400);
	Utils.registerImageByClass("bg600", bg600);
	Utils.registerImageByClass("bg800", bg800);
	
	TopologyService.getImagesTypeList(resourceId,username,null,null,true);
	
	initParameters();
//	getPicAsBitmapData();
	
	img0.source = arrayList.getItemAt(0).source;
	img1.source = arrayList.getItemAt(1).source;
	img2.source = arrayList.getItemAt(2).source;
	currentIndex= 1;
	
	rotate3D1.play();
	rotate3D2.play();
	timer.start();
	timer.addEventListener(TimerEvent.TIMER,onTimer);
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
	
	arrayStr = FlexGlobals.topLevelApplication.parameters.stateArray;
	if(arrayStr){
		var stateArray:Array = arrayStr.split(",");
		for (j = 0; j < stateArray.length; j++) 
		{
			obj =arrayList.getItemAt(j);
			obj.statePic = stateArray[j];
		}
	}
	
	arrayStr = FlexGlobals.topLevelApplication.parameters.healthArray;
	if(arrayStr){
		var healthArray:Array = arrayStr.split(",");
		for (j = 0; j < healthArray.length; j++) 
		{
			obj =arrayList.getItemAt(j);
			obj.healthPic = healthArray[j];
		}
	} 
	
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
}

/**
 * 保存加载完的图片为位图。 
 * 
 */
protected function getPicAsBitmapData():void
{
	for (var i:int = 0; i<arrayList.length; i++)
	{
		var loader:Loader = new Loader();
		var url:String = arrayList.getItemAt(i).source;
		loader.load(new URLRequest(encodeURI(url)));
		loader.contentLoaderInfo.addEventListener(Event.COMPLETE, onLoaderComplete);
		loader.contentLoaderInfo.addEventListener(IOErrorEvent.IO_ERROR, function onIoerr(event:IOErrorEvent):void{});
	}
}

public function onLoaderComplete():Function {
	var fun:Function=function(event:Event):Boolean {
		var bitmapData:BitmapData = (event.currentTarget.content as Bitmap).bitmapData;
		picBitmapDataArray.addItem(bitmapData);
		return false ;
	}
	return fun;
}

private var reverse:Boolean;
[Bindable]
private var currentIndex:int=-1;
protected function onTimer(event:TimerEvent):void
{
	currentIndex++;
	
	if(currentIndex>arrayList.length-1){
		currentIndex=0;
	}
	
	var img0BitmapData:BitmapData;
	var img1BitmapData:BitmapData;
	var img2BitmapData:BitmapData;
	if(currentIndex == 0){
//		img0BitmapData = arrayList.getItemAt(arrayList.length-1) as BitmapData;
//		img0.source = img0BitmapData;
//		crossFade0.bitmapTo = img0BitmapData;
//		crossFade0.play();
		img0.source = arrayList.getItemAt(arrayList.length-1).source;
//		img1BitmapData= arrayList.getItemAt(currentIndex) as BitmapData;
//		img1.source = img1BitmapData;
//		crossFade1.bitmapTo = img1BitmapData;
//		crossFade1.play();
		img1.source = arrayList.getItemAt(currentIndex).source;
//		img2BitmapData = arrayList.getItemAt(currentIndex+1) as BitmapData;
//		img2.source = img2BitmapData;
//		crossFade2.bitmapTo = img2BitmapData;
//		crossFade2.play();
		img2.source = arrayList.getItemAt(currentIndex+1).source;
	}else if(currentIndex == arrayList.length-1){
//		img0BitmapData = arrayList.getItemAt(currentIndex-1) as BitmapData;
//		img0.source = img0BitmapData;
//		crossFade0.bitmapTo = img0BitmapData;
//		crossFade0.play();
		img0.source = arrayList.getItemAt(currentIndex-1).source;
//		img1BitmapData= arrayList.getItemAt(currentIndex) as BitmapData;
//		img1.source = img1BitmapData;
//		crossFade1.bitmapTo = img1BitmapData;
//		crossFade1.play();
		img1.source = arrayList.getItemAt(currentIndex).source;
//		img2BitmapData = arrayList.getItemAt(0) as BitmapData;
//		img2.source = img2BitmapData;
//		crossFade2.bitmapTo = img2BitmapData;
//		crossFade2.play();
		img2.source = arrayList.getItemAt(0).source;
	}else{
//		img0BitmapData = arrayList.getItemAt(currentIndex-1) as BitmapData;
//		crossFade0.bitmapTo = img0BitmapData;
//		crossFade0.play();
//		img0.source = img0BitmapData;
		img0.source = arrayList.getItemAt(currentIndex-1).source;
//		img1BitmapData= arrayList.getItemAt(currentIndex) as BitmapData;
//		img1.source = img1BitmapData;
//		crossFade1.bitmapTo = img1BitmapData;
//		crossFade1.play();
		img1.source = arrayList.getItemAt(currentIndex).source;
//		img2BitmapData = arrayList.getItemAt(currentIndex-1) as BitmapData;
//		img2.source = img2BitmapData;
//		crossFade2.bitmapTo = img2BitmapData;
//		crossFade2.play();
		img2.source = arrayList.getItemAt(currentIndex-1).source;
	}
}

protected function onMouseOver(event:MouseEvent):void
{
	timer.stop();
}

protected function onMouseOut(event:MouseEvent):void
{
	timer.start();
}

/**
 * 获取当前项，弹出来。
 */ 
private function onItemClick(event:ItemClickEvent):void
{
	/*if(list.selectedIndex == event.index){
		var indexItemrenderer:IndexItemRenderer = event.currentTarget as IndexItemRenderer;
		var bitImg:BitmapImage = indexItemrenderer.img;
		var netWorkGroup:NetWorkGroup = PopUpManager.createPopUp(this,NetWorkGroup) as NetWorkGroup;
		netWorkGroup.resourceid = list.dataProvider.getItemAt(event.index).rid;
		netWorkGroup.width = 800;
		netWorkGroup.height = 370;
		PopUpManager.centerPopUp(netWorkGroup);
		netWorkGroup.addEventListener(FlexMouseEvent.MOUSE_DOWN_OUTSIDE,function onMouseDownOutside(event:FlexMouseEvent):void{
			PopUpManager.removePopUp(netWorkGroup);
		});*/
		//					network.visible = true;
		/* img.source = list.dataProvider.getItemAt(event.index).source;
		img.validateDisplayList();
		img.validateProperties();
		img.validateNow();
		var resize:Resize = new Resize(img);
		resize.duration = 1000;
		resize.widthFrom = bitImg.width;
		resize.widthBy =  bitImg.width*2;
		resize.heightFrom = bitImg.height;
		resize.heightBy =  bitImg.height*2;
		resize.play(); */
		
		/*timer.stop();
	}else{
		img.source = null;
		//					network.visible = false;
	}*/
}

public static function getImage(object:Object):Image
{
	while (object is flash.display.DisplayObject) 
	{
		if (object is Image) 
		{
			return Image(object);
		}
		object = object.parent;
	}
	return null;
}

////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
[Embed(source="demo/portal/images/MonitorPortal_UrlMonitor1.png")]
public static const  UrlMonitor1:Class;
[Embed(source="demo/portal/images/MonitorPortal_PIC2.png")]
public static const  PIC2:Class;
[Embed(source="demo/portal/images/MonitorPortal_MSSQLDBserver.png")]
public static const  MSSQLDBserver:Class;
[Embed(source="demo/portal/images/MonitorPortal_PIC4.png")]
public static const  PIC4:Class;
[Embed(source="demo/portal/images/MonitorPortal_UrlMonitor.png")]
public static const  UrlMonitor:Class;
[Embed(source="demo/portal/images/MonitorPortal_smile.png")]
public static const  smile:Class;
[Embed(source="demo/portal/images/MonitorPortal_UrlSeq.png")]
public static const  UrlSeq:Class;
[Embed(source="demo/portal/images/MonitorPortal_PIC11.png")]
public static const  PIC11:Class;
[Embed(source="demo/portal/images/MonitorPortal_Windows2000.png")]
public static const  Windows2000:Class;
[Embed(source="demo/portal/images/MonitorPortal_Windows2003.png")]
public static const  Windows2003:Class;
[Embed(source="demo/portal/images/MonitorPortal_Tomcatserver.png")]
public static const  Tomcatserver:Class;
[Embed(source="demo/portal/images/MonitorPortal_HPUX.png")]
public static const  HPUX:Class;
[Embed(source="demo/portal/images/MonitorPortal_subnetworkimage.png")]
public static const  subnetworkimage:Class;
[Embed(source="demo/portal/images/MonitorPortal_AIX.png")]
public static const  AIX:Class;
[Embed(source="demo/portal/images/MonitorPortal_Apacheserver.png")]
public static const  Apacheserver:Class;
[Embed(source="demo/portal/images/MonitorPortal_ORACLEDBserver.png")]
public static const  ORACLEDBserver:Class;
[Embed(source="demo/portal/images/MonitorPortal_NodeImg.png")]
public static const  NodeImg:Class;
[Embed(source="demo/portal/images/MonitorPortal_PIC20111216150907.jpg")]
public static const  PIC20111216150907:Class;
[Embed(source="demo/portal/images/MonitorPortal_WEBLOGICserver.png")]
public static const  WEBLOGICserver:Class;
[Embed(source="demo/portal/images/MonitorPortal_bg400.jpg")]
public static const  bg400:Class;
[Embed(source="demo/portal/images/MonitorPortal_bg600.jpg")]
public static const  bg600:Class;
[Embed(source="demo/portal/images/MonitorPortal_bg800.jpg")]
public static const  bg800:Class;
[Embed(source="demo/portal/images/MonitorPortal_Linux.png")]
public static const  Linux:Class;
[Embed(source="demo/portal/images/MonitorPortal_Switch.png")]
public static const  Switch:Class;
[Embed(source="demo/portal/images/MonitorPortal_sad.png")]
public static const  sad:Class;
[Embed(source="demo/portal/images/MonitorPortal_Router.png")]
public static const  Router:Class; 

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
	_data.userName = this.username;
	
	loadImages("/MonitorPortal/Portlet/TopologyView/getNetworkResourceTypeImages3.do",_data,onLoadImageComplete);
	
	Utils.registerImageByClass("sad", sad);
	Utils.registerImageByClass("smile", smile);
	Utils.registerImageByClass("AIX", AIX);
	Utils.registerImageByClass("Apache-server", Apacheserver);
	Utils.registerImageByClass("HP-UX", HPUX);
	Utils.registerImageByClass("Linux", Linux);
	Utils.registerImageByClass("MSSQL-DB-server", MSSQLDBserver);
	Utils.registerImageByClass("Node", NodeImg);
	Utils.registerImageByClass("ORACLE-DB-server", ORACLEDBserver);
	Utils.registerImageByClass("Router", Router);
	Utils.registerImageByClass("Switch", Switch);
	Utils.registerImageByClass("Tomcat-server", Tomcatserver);
	Utils.registerImageByClass("UrlMonitor", UrlMonitor);
	Utils.registerImageByClass("UrlSeq", UrlSeq);
	Utils.registerImageByClass("WEBLOGIC-server", WEBLOGICserver);
	Utils.registerImageByClass("Windows 2000", Windows2000);
	Utils.registerImageByClass("Windows 2003", Windows2003);
	Utils.registerImageByClass("20111216150907", PIC20111216150907);
	Utils.registerImageByClass("02", PIC2);
	Utils.registerImageByClass("04", PIC4);
	Utils.registerImageByClass("11", PIC11);
	Utils.registerImageByClass("bg400", bg400);
	Utils.registerImageByClass("bg600", bg600);
	Utils.registerImageByClass("bg800", bg800);
	Utils.registerImageByClass("subnetwork_image", subnetworkimage);
	Utils.registerImageByClass("UrlMonitor1", UrlMonitor1); 
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
	
	var timer:Timer = new Timer(1000,1);
}

public function onLoaderTypeListComplete(picName:String):Function {
	var fun:Function=function(e:Event):Boolean {
		Utils.registerImageByBitmapData(picName, (e.currentTarget.content as Bitmap).bitmapData);
		return false ;
	}
	return fun;
}

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
	loader.addEventListener(IOErrorEvent.IO_ERROR, function onIoError(event:IOErrorEvent):void{});
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