package demo 
{
	/**
	 * ...
	 * @author kk
	 */
	import adobe.utils.CustomActions;
	
	import demo.alarm.AlarmDemo;
	import demo.alarm.alarmmapping.*;
	import demo.editor.*;
	import demo.editor.link.*;
	
	import flash.display.Bitmap;
	import flash.display.Loader;
	import flash.events.*;
	import flash.net.URLLoader;
	import flash.net.URLLoaderDataFormat;
	import flash.net.URLRequest;
	import flash.net.URLRequestMethod;
	import flash.net.URLVariables;
	import flash.utils.Dictionary;
	
	import mx.collections.ArrayCollection;
	import mx.collections.XMLListCollection;
	import mx.controls.*;
	import mx.controls.Alert;
	import mx.core.*;
	
	import twaver.*;
	import twaver.controls.GifImage;
	import twaver.network.Network;
	
	public class TopologyService
	{
		public static var loaded:Boolean;
		public static var imgNum:int = 0;
		public static var loadedImgNum:int = 0;
		
		public function TopologyService() 
		{
			
		}
		public static var alarmDemo:AlarmDemo;
		protected static function request(url:String, data:URLVariables, onEvent:Function):void
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
		}
		
		///
		///处理类型图片（声明和注册）
		///
		public static function getImagesTypeList(preName:String,userName:String,imageItems:ArrayCollection, network:Network,IsBool:Boolean):void {
			var _data:URLVariables = new URLVariables();
			_data.preName = preName;
			request("/MonitorPortal/Portlet/TopologyView/getNetworkResourceTypeImages3.do", _data,
				function(event:Event):void {
					var loader:URLLoader=URLLoader(event.target); 
					var _data:URLVariables = new URLVariables(loader.data); 
					var xmlContent:String = _data.data;
					var xml:XML=new XML(xmlContent);
					var xmlList:XMLList = xml.elements("Item"); 
					var xmlListCollection:XMLListCollection = new XMLListCollection(xmlList); 
					var imageArray: ArrayCollection = new ArrayCollection(xmlListCollection.toArray());
					
					if (imageArray.length>0)
			     	{
						/*imgNum = imageArray.length;
						loadedImgNum = 0;
						loaded = false;*/
						
						 for (var i:int = 0; i<imageArray.length; i++)
						 {
							var loader1:Loader = new Loader();
							loader1.load(new URLRequest(encodeURI(imageArray[i].Value)));
							var picName:String = imageArray[i].Name;
							loader1.contentLoaderInfo.addEventListener(Event.COMPLETE, onLoaderTypeListComplete(picName));
						 }
				    } 
					
					loaded = true;
					getBackgroundImages(preName,userName,imageItems,network,IsBool);
				}
		    );
		}
	 public static function onLoaderTypeListComplete(picName:String):Function {
		 if(loadedImgNum+1 == imgNum){
			 loaded = true;
		 }else
		 	loadedImgNum++;
		 var fun:Function=function(e:Event):Boolean {
				//var bitmap:BitmapData = new BitmapData(e.currentTarget.content.width, e.currentTarget.content.height,true,0x00ffffff); 
				//bitmap.draw(e.currentTarget.content);
				//Utils.registerImageByBitmapData(picName, bitmap);
				Utils.registerImageByBitmapData(picName, (e.currentTarget.content as Bitmap).bitmapData);
				return false ;
		 }
		return fun;
       }
	   
         ///
		///处理背景图片（声明和注册）
		///
		public static function getBackgroundImages(preName:String,userName:String,imageItems:ArrayCollection, network:Network,IsBool:Boolean):void {
			var _data:URLVariables = new URLVariables();
			_data.preName = preName;
			_data.userName = userName;
			request("/MonitorPortal/Portlet/TopologyView/getBackGroundImages.do", _data,
				function(event:Event):void {
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
							 
							 
							 /*
							var loader1:Loader = new Loader();
							loader1.load(new URLRequest(encodeURI(imageArray[i].Value)));
							var picName:String = imageArray[i].Name;
							loader1.contentLoaderInfo.addEventListener(Event.COMPLETE, onLoaderBackgroundComplete(picName));
							*/
						 }
				    } 
					getNetworkResourceTypeImages(imageItems,network,IsBool);
				}
		    );
		}
	 public static function onLoaderBackgroundComplete(picName:String):Function {
		 var fun:Function=function(e:Event):Boolean {
				//var bitmap:BitmapData = new BitmapData(e.currentTarget.content.width, e.currentTarget.content.height,true,0x00ffffff); 
				//bitmap.draw(e.currentTarget.content);
				//Utils.registerImageByBitmapData(picName, bitmap);
				Utils.registerImageByBitmapData(picName, (e.currentTarget.content as Bitmap).bitmapData);
				return false ;
		 }
		return fun;
       }

        ///
		///处理图片（声明和注册）
		///
		public static function getNetworkResourceTypeImages(imageItems:ArrayCollection, network:Network,IsBool:Boolean):void {
			request("/MonitorPortal/Portlet/TopologyView/getNetworkResourceTypeImages.do", null,
				function(event:Event):void {
					var loader:URLLoader=URLLoader(event.target); 
					var _data:URLVariables = new URLVariables(loader.data); 
					var xmlContent:String=_data.data;
					var xml:XML=new XML(xmlContent);
					var xmlList:XMLList = xml.elements("Item"); 
					 
					var xmlListCollection:XMLListCollection = new XMLListCollection(xmlList); 
					var imageArray: ArrayCollection= new ArrayCollection(xmlListCollection.toArray());
					onGetNetworkResourceTypeImages(imageArray, imageItems,network,IsBool);
				}
			);
		}
		///
		///绑定图片 
		///
		public static function onGetNetworkResourceTypeImages(imageArray:ArrayCollection,imageItems:ArrayCollection, network:Network,IsBool:Boolean):void
		{
			if (imageArray.length>0)
				{
					 for (var i:int = 0; i<imageArray.length; i++)
					 {
						
						var loader:Loader = new Loader();
						loader.load(new URLRequest(encodeURI(imageArray[i].Value)));
						var picName:String = imageArray[i].Name;
						var state:Boolean;
						if (i == imageArray.length - 1)
						{
							state = true;
						}else {
							state = false;
						}
						loader.contentLoaderInfo.addEventListener(Event.COMPLETE, onLoaderComplete(picName, imageItems,network,state,IsBool)
						);
					}
			   } 
		}
		
		public static function onLoaderComplete(picName:String,imageItems:ArrayCollection,network:Network,state:Boolean,IsBool:Boolean):Function {
		 var fun:Function=function(e:Event):Boolean {
				//var bitmap:BitmapData = new BitmapData(e.currentTarget.content.width, e.currentTarget.content.height,true,0x00ffffff); 
				//bitmap.draw(e.currentTarget.content);
				//Utils.registerImageByBitmapData(picName, bitmap);
				Utils.registerImageByBitmapData(picName, (e.currentTarget.content as Bitmap).bitmapData);
					if(imageItems != null){
						var eCreator:ElementCreator=new ElementCreator();
						eCreator.label=picName;
						eCreator.imageName=picName;
						imageItems.addItem(eCreator);
					}
			
				 if(network != null&&state==true) {
			       var parameters : Object = Application.application.parameters;
				   var name : String = parameters.name;
				   var userName:String = parameters.userName;
				   var specifiedSubNetwork : String = parameters.specifiedSubNetwork;
				   TopologyService.getView(name,userName,specifiedSubNetwork,network,IsBool); 
			}
			return false ;
		 }
		return fun;
       }
	   ///
	   ///保存文件名字和xml内容
	   ///
	   public static function saveView(name: String, userName:String, data: String,onEvent:Function):void{
	        var _data:URLVariables = new URLVariables();
			_data.data = data;
			_data.userName = userName;
			_data.preName = name;
		    request("/MonitorPortal/Portlet/TopologyView/saveView.do", 
		      _data,
			  onEvent
			);
	   }
	   
	   ///
	   /// 根据文件名字获取xml内容
	   ///
	   public static function getView(name: String,userName:String, specifiedSubNetwork:String,network:Network,IsBool:Boolean):void {
	       var _data:URLVariables = new URLVariables();
			_data.preName = name;
			_data.userName = userName;
		   request("/MonitorPortal/Portlet/TopologyView/getView.do", _data,
				function(event:Event):void {
					var loader:URLLoader=URLLoader(event.target); 
						var _data:URLVariables = new URLVariables(loader.data);
						
						onGetView(_data.data,specifiedSubNetwork,network,IsBool);
				}
			);	
			
	     }
	   /// 
	   /// 处理异步获取到的内容
	   ///
	   public static function onGetView(data: String,specifiedSubNetwork:String,network:Network,IsBool:Boolean):void {
		   network.elementBox.clear();
		   var serializer:XMLSerializer = new XMLSerializer(network.elementBox);
		   serializer.deserialize(data);
	   if (specifiedSubNetwork != "") {
			   network.elementBox.forEach(function(node:*):Boolean {
				if (specifiedSubNetwork == node.name) {
				   network.currentSubNetwork = node as SubNetwork;
				   return false;
				}
				return true;
			});
		   }
		   if(IsBool == true){
		      alarmDemo.timer.addEventListener(TimerEvent.TIMER, alarmDemo.tick);	
		      alarmDemo.timer.start();
		   }
	   }
     
	    ///
	   /// 根据不同类型获取不同的下拉选择框值列表
	   ///
	   public static function getNetworkResources(type: String, onEvent: Function):void {
		 var _data:URLVariables = new URLVariables();
			_data.type = type; 
			request("/MonitorPortal/Portlet/TopologyView/getNetworkResources.do", 
			  _data,
			  onEvent
		); }   
		
		 ///
	   /// 根据不同类型获取不同图片列表
	   ///
	   public static function getTypePic(type:String, imagetype:ArrayCollection, _lastTypepic:String,objc:LinkEditorDemo):void {
		   //var lastTypepic:String  = _lastTypepic;
		 var _data:URLVariables = new URLVariables();
			_data.type = type; 
			request("/MonitorPortal/Portlet/TopologyView/getNetworkResourceTypeImages2.do", _data,
			  function(event:Event):void {
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
							if (_lastTypepic == objc._lastTypepic) {
							var eCreator:ElementCreator=new ElementCreator();
								eCreator.label=picName;
								eCreator.imageName=picName;
								imagetype.addItem(eCreator);
							}
						 }
				    } 
				}
		    );
		}   
		///
		///获取警告列表
		///
		public static function getAlerts(resources:String,onEvent: Function):void {
			 var _data:URLVariables = new URLVariables();
			 _data.resources = resources; 
			request("/MonitorPortal/Portlet/TopologyView/getAlertList.do", 
				_data,
				onEvent
			); 
		}

		///
		///根据id从network中查找对应的节点
		///

		public static function findNetworkResource(id:String,Message:String, network:Network):IElement {
		var iElement:IElement;
		   network.elementBox.forEach(function(node:Object):Boolean {
			var networkId:String = node.getClient(CustomAlarmElementMapping.MAPPINGID);
			 if (id == networkId) {
				 iElement = network.elementBox.getElementByID(node.id);
				 iElement.setClient("Message", Message);
				 return false;
			 }
			 return true ;
			});
			return iElement;
		}
		
		public static function getNetworkResourceProperties(id: String,type:String, onEvent: Function):void{
            var _data:URLVariables = new URLVariables();
			    _data.id = id; 
				_data.networkResourceType = type;
			   request("/MonitorPortal/Portlet/TopologyView/getNetworkResourceProperties.do", 
				_data,
				onEvent
			); }
			
		public static function SaveAlertColor(name:String,userName:String,lightColor : String, seriousColor : String,isSaveColor:String,onEvent:Function):void {
			var _data:URLVariables = new URLVariables();
			_data.lightColor = lightColor;
            _data.seriousColor = seriousColor;
            _data.isSaveColor = isSaveColor;
			_data.name = name;
			_data.userName = userName;
		     request("/MonitorPortal/Portlet/TopologyView/alertColor.do", 
		      _data,
			  onEvent
			);
		}
		
		public static function getAlertColor(name:String,userName:String,isSaveColor:String,onEvent:Function):void {
			var _data:URLVariables = new URLVariables();
            _data.isSaveColor = isSaveColor;
			_data.name = name;
			_data.userName = userName;
		     request("/MonitorPortal/Portlet/TopologyView/alertColor.do", 
		      _data,
		     onEvent
			);
		}
		
	  public static function getEditAlertColor(name:String,userName:String,LightColor:ColorPicker,SeriousColor:ColorPicker,isSaveColor:String):void {
		var _data:URLVariables = new URLVariables();
            _data.isSaveColor = isSaveColor;
			_data.name = name;
			_data.userName = userName;
			 request("/MonitorPortal/Portlet/TopologyView/alertColor.do", 
			_data,
				function(event:Event):void {
					 var loader:URLLoader=URLLoader(event.target); 
						var _data:URLVariables = new URLVariables(loader.data); 
						var xmlContent:String = _data.data;
						var xml:XML=new XML(xmlContent);
						var xmlList:XMLList = xml.elements("Item"); 
						var xmlListCollection:XMLListCollection = new XMLListCollection(xmlList);
						var array:ArrayCollection = new ArrayCollection(xmlListCollection.toArray());
						if (array.length > 0) {
							
							 var aa:int =int(array[0].lightColor);
							 var bb:int =int(array[0].seriousColor);
							 var LightColorstr:String  = "0x" + (aa).toString(16);
							 var SeriousColorstr:String = "0x" + (bb).toString(16);
							 LightColor.selectedColor=uint(LightColorstr);
				             SeriousColor.selectedColor = uint(SeriousColorstr);
						}
				}
		    );
		}
	}
}