// ActionScript file
import cn.hnisi.ravis.editor.VisualGraphEditor;
import cn.hnisi.ravis.editor.VisualGraphEditorEvent;

import com.itsm.common.Global;
import com.itsm.configuration.controller.TopoProviderEvent;
import com.itsm.configuration.model.TopoProviderRemoteProxy;
import com.itsm.configuration.model.vo.ConfigurationItem;
import com.itsm.configuration.view.ConnectDeviceTitleWin;
import com.itsm.configuration.view.EdgeEditorTitleWin;

import flash.display.StageDisplayState;
import flash.events.Event;
import flash.events.IOErrorEvent;
import flash.events.MouseEvent;
import flash.events.TimerEvent;
import flash.filters.GlowFilter;
import flash.net.FileFilter;
import flash.net.FileReference;
import flash.utils.Timer;

import mx.containers.VBox;
import mx.controls.Alert;
import mx.core.ClassFactory;
import mx.core.FlexGlobals;
import mx.core.UIComponent;
import mx.managers.PopUpManager;
import mx.utils.ObjectUtil;

import org.osmf.events.TimeEvent;
import org.un.cava.birdeye.ravis.components.renderers.BaseRenderer;
import org.un.cava.birdeye.ravis.components.renderers.edgeLabels.BaseEdgeLabelRenderer;
import org.un.cava.birdeye.ravis.components.renderers.nodes.RotatedRectNodeRenderer;
import org.un.cava.birdeye.ravis.graphLayout.data.Graph;
import org.un.cava.birdeye.ravis.graphLayout.data.IGraph;
import org.un.cava.birdeye.ravis.graphLayout.layout.CircularLayouter;
import org.un.cava.birdeye.ravis.graphLayout.layout.ConcentricRadialLayouter;
import org.un.cava.birdeye.ravis.graphLayout.layout.DirectPlacementLayouter;
import org.un.cava.birdeye.ravis.graphLayout.layout.ForceDirectedLayouter;
import org.un.cava.birdeye.ravis.graphLayout.layout.HierarchicalLayouter;
import org.un.cava.birdeye.ravis.graphLayout.layout.ILayoutAlgorithm;
import org.un.cava.birdeye.ravis.graphLayout.visual.IEdgeRenderer;
import org.un.cava.birdeye.ravis.graphLayout.visual.IVisualEdge;
import org.un.cava.birdeye.ravis.graphLayout.visual.IVisualNode;
import org.un.cava.birdeye.ravis.graphLayout.visual.VisualGraph;
import org.un.cava.birdeye.ravis.graphLayout.visual.edgeRenderers.BaseEdgeRenderer;
import org.un.cava.birdeye.ravis.graphLayout.visual.edgeRenderers.DirectedArrowEdgeRenderer;
import org.un.cava.birdeye.ravis.graphLayout.visual.edgeRenderers.FlowEdgeRenderer;
import org.un.cava.birdeye.ravis.graphLayout.visual.events.VisualNodeEvent;

import serialization.XMLSerializer;

import spark.components.List;

private var graph:IGraph;
// active layouter
private var layouter:ILayoutAlgorithm;
// edge renderer
private var selectedEdgeRenderer:IEdgeRenderer;
// root node to start with
private var startRoot:IVisualNode;
// this is used to display the number of visible items
private var itemCount:int = 0;
// important to ensure we are done with the main initialisation
private var initDone:Boolean = false;
private var file:FileReference;
private var currentFileName:String;

/**
 * event handler for HTTPService, does all the remaining required
 * initialisation
 * */

private var topoRemoteProxy:TopoProviderRemoteProxy;

private function initData():void {
	var url:String = "";
	var endPoint:String = "";
	url = FlexGlobals.topLevelApplication.url;
	
	var array:Array = url.split("/");
	if(array && array.length>1){
		//		endPoint = array[0]+ "//" + array[1]+ array[2];
		endPoint = array[0]+ "//" + array[1]+ array[2] + "/" + array[3]; //发布web文件夹下面
		
		url = array[0]+ "//" + array[1]+ array[2] + "/" + array[3]+ "/" + array[4];
		Global.getInstance().url = url;
		//确定端点；
		//Global.getInstance().endPoint = 'messagebroker/amf';
		Global.getInstance().endPoint = endPoint + "/"+'messagebroker/amf';
		
		topoRemoteProxy = new TopoProviderRemoteProxy();
		topoRemoteProxy.getGraphLayout();
		topoRemoteProxy.addEventListener(TopoProviderEvent.GET_GRAPH_LAYOUT_RESULT,getGraphLayoutResult);
		topoRemoteProxy.addEventListener(TopoProviderEvent.GET_GRAPH_LAYOUT_FAULT,getGraphLayoutFault);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	birdEyeZoom.labelEle.text = "放大VS缩小";
}

function getGraphLayoutFault(event:TopoProviderEvent):void
{
	var idString:String = "1";
	var xml:XML = xmldata;
	//	/* create and init a graph object with the XML data */
	graph = new Graph("XMLAsDocsGraph",false,xml);
	
	/* set the graph in the VGraph object, this automatically
	* initializes the VGraph items; 
	* note: vgraph is the id of the mxml specified VisualGraph component */
	vgraph.graph = graph;
	
	/* set the default layouter type */
	layouter = new DirectPlacementLayouter(vgraph);
	layouter.disableAnimation = false;
	//layouter = new CircularLayouter(vgraph);
	vgraph.layouter = layouter;
	layouter.autoFitEnabled = true;
	
	startRoot = graph.nodeByStringId(idString).vnode;
	vgraph.displayEdgeLabels = true;
	/* the following kicks it off .... */
	vgraph.currentRootVNode = startRoot;
	vgraph.draw();
}

function getGraphLayoutResult(event:TopoProviderEvent):void{
//	Alert.show(event.object.toString());
	
	var xml:XML = new XML(event.object.toString());
	var xmllist:XMLList = xml.Node;
	var idString:String = "";
	if(xmllist!=undefined && xmllist.length()>0){
		idString = xmllist[0].@id;
	}else{
//		Alert.show(xml.toString(),"XML有误");
//		createVMLayer();
//		palette.mouseChildren = false;
//		return;
//		xml = xmldata;
	}
	
//	/* create and init a graph object with the XML data */
	graph = new Graph("XMLAsDocsGraph",false,xml);
	
	/* set the graph in the VGraph object, this automatically
	* initializes the VGraph items; 
	* note: vgraph is the id of the mxml specified VisualGraph component */
	vgraph.graph = graph;
	
	/* set the default layouter type */
	layouter = new DirectPlacementLayouter(vgraph);
	layouter.disableAnimation = false;
	//layouter = new CircularLayouter(vgraph);
	vgraph.layouter = layouter;
	layouter.autoFitEnabled = false;
	vgraph.displayEdgeLabels = true;
	if(idString != ""){
		startRoot = graph.nodeByStringId(idString).vnode;
		vgraph.currentRootVNode = startRoot;
	}
	vgraph.draw();
	var timer:Timer = new Timer(100,1);
	timer.start();
	timer.addEventListener(TimerEvent.TIMER,function onTimer(event:TimerEvent):void{
		vgraph.draw();
	});
}

private function createVMLayer():void
{
	var ui:UIComponent = new UIComponent();
	ui.graphics.beginFill(0);
	ui.graphics.drawRect(0,0,this.width,this.height);
	ui.graphics.endFill();
	this.vgraph.parent.addChild(ui);
	ui.mouseEnabled = false;
}

/**
 * 刷新。 
 * @param event
 * 
 */
protected function newBtn_clickHandler(event:MouseEvent):void
{
	deleteAllBtn_clickHandler();
	var xml:XML = new XML(<Graph/>);
	graph = new Graph("XMLAsDocsGraph",false,xmldata);
	vgraph.graph = graph;
	
	layouter = new DirectPlacementLayouter(vgraph);
	layouter.disableAnimation = false;
	vgraph.layouter = layouter;
	layouter.autoFitEnabled = false;
	
	vgraph.draw();
}

/**
 * 刷新。 
 * @param event
 * 
 */
protected function refreshBtn_clickHandler(event:MouseEvent):void
{
	topoRemoteProxy.getGraphLayout();
}

/**
 * 关联两个节点。 
 * @param event
 * 
 */
protected function connectBtn_clickHandler(event:MouseEvent):void
{
	if(vgraph.getSelection().length < 2){
		return;
	}
	var length:int = 0;
	while(length +1 < vgraph.getSelection().length){
		var baseRender0:BaseRenderer = vgraph.getSelection()[length];
		var baseRender1:BaseRenderer = vgraph.getSelection()[length+1];
		var ivNode0:IVisualNode = vgraph.renderToNode(baseRender0);
		var ivNode1:IVisualNode = vgraph.renderToNode(baseRender1);
		if(!ivNode1 || !ivNode0){
			return;
		}
		var iVisualEdge:IVisualEdge = vgraph.linkNodes(ivNode0,ivNode1);
		var xmlString:String = "<Edge fromID=\""+ivNode0.id+"\" toID=\""+ivNode1.id+"\" />";
		var xml:XML =  new XML(xmlString);
		iVisualEdge.data = xml;
		length++;
	}
}

/**
 * 断开节点。 
 * @param event
 * 
 */
protected function disconnectBtn_clickHandler(event:MouseEvent):void
{
	if(vgraph.getSelection().length < 2){
		return;
	}
	var baseRender0:BaseRenderer = vgraph.getSelection()[0];
	var baseRender1:BaseRenderer = vgraph.getSelection()[1];
	var ivNode0:IVisualNode = vgraph.renderToNode(baseRender0);
	var ivNode1:IVisualNode = vgraph.renderToNode(baseRender1);
	
	vgraph.unlinkNodes(ivNode0,ivNode1);
}

/**
 * 布局节点 
 * @param event
 * 
 */
protected function layoutBtn_clickHandler(event:MouseEvent):void
{
	layouter = new ConcentricRadialLayouter(vgraph);
	layouter.disableAnimation = false;
	//layouter = new CircularLayouter(vgraph);
	vgraph.layouter = layouter;
	layouter.autoFitEnabled = true;
	
	if(vgraph.layouter){
		vgraph.layouter.layoutPass();
	}
}

protected function sourceBtn_clickHandler(event:MouseEvent):void
{
	var xmlSerializer:XMLSerializer = new XMLSerializer();
	
	var xml:XML = xmlSerializer.serialize(vgraph,"Graph");
	Alert.show(xml.toString());
}

protected function deleteBtn_clickHandler(event:MouseEvent):void
{
	if(vgraph.getSelection().length == 0){
		return;
	}
	var length:int = vgraph.getSelection().length;
	var renderer:BaseRenderer;
	
	while(length > 0){
		renderer = vgraph.getSelection()[length -1];
		if(renderer){
			vgraph.setSelected(renderer,false);
			vgraph.deleteRenderer(renderer);
		}
		length --;
	}
}

protected function deleteAllBtn_clickHandler(event:MouseEvent = null):void
{
	vgraph.selectAll();
	if(vgraph.getSelection().length == 0){
		return;
	}
	var length:int = vgraph.getSelection().length;
	var renderer:BaseRenderer;
	
	while(length > 0){
		renderer = vgraph.getSelection()[length -1];
		if(renderer){
			vgraph.setSelected(renderer,false);
			vgraph.deleteRenderer(renderer);
		}
		length --;
	}
}

protected function addBtn_clickHandler(event:MouseEvent):void
{
	var list:List = event.currentTarget as List;
	var item:Object = list.selectedItem;

	var data:Object = new XML(item);
	
	var clonedData:Object = ObjectUtil.clone(data);
	var id:String = "";
	var ivisualNode:IVisualNode = vgraph.addRenderer(id,clonedData);
	XML(ivisualNode.data).@id = ""+ivisualNode.id;
	var firstRenderer:UIComponent = vgraph.getRendererByIndex(0);
	if(firstRenderer){
		ivisualNode.viewX = firstRenderer.x + firstRenderer.width/2;
		if(ivisualNode.viewX >= vgraph.width){
			ivisualNode.viewX = 40;
		}
		ivisualNode.viewY = firstRenderer.y + firstRenderer.height/2;
		if(ivisualNode.viewY >= vgraph.height){
			ivisualNode.viewY = 40;
		}
	}
	ivisualNode.refresh();
	ivisualNode.view.parent.setChildIndex(ivisualNode.view,0);
	var filter:GlowFilter = new GlowFilter(0xE9AB96,1,10,10);
	ivisualNode.view.filters = [filter];
}


protected function vgraph_nodeClickHandler(event:VisualNodeEvent):void
{
	trace(event.node.id);
}

protected function exportBtn_clickHandler(event:MouseEvent):void
{
	saveXML();
}

// -----------------------------------------
// Save and Load the contents of the diagram
// -----------------------------------------
private function saveXML() : void 
{
	file = new FileReference();
	var xml:XML = new XMLSerializer().serialize(vgraph, "Graph");
	var fileName:String = currentFileName;
	if(fileName == null)
		fileName = "itsm.xml";
	file.addEventListener(flash.events.Event.COMPLETE, fileSaved);
	file.addEventListener(flash.events.IOErrorEvent.IO_ERROR, ioError);
	file.save(xml, fileName);
}

private function fileSaved(event:flash.events.Event) : void 
{
	if(file != null){
		currentFileName = file.name;
		file = null;
	}
}

private function ioError(event:IOErrorEvent) : void 
{
	Alert.show("导出出错");
}

private function loadXML() : void 
{
	doLoadXML();
	/* if(isModified){
	Alert.show(resourceManager.getString("bpmeditor", "bpmeditor.diagramModified.text"),
	resourceManager.getString("bpmeditor", "bpmeditor.diagramModified.title"),
	Alert.YES|Alert.NO, this, loadAlertCloseHandler, null, Alert.NO);
	} else {
	doLoadXML();
	} */
}

/* private function loadAlertCloseHandler(event:CloseEvent) : void 
{
if(event.detail == Alert.YES)
doLoadXML();
} */

private function doLoadXML(): void
{
	file = new FileReference();
	file.addEventListener(flash.events.Event.SELECT, fileSelectedForLoad);
	file.browse([new FileFilter("itsm文件", "*.xml;")]);
}

private function fileSelectedForLoad(event:flash.events.Event) : void 
{
	if(file != null){
		file.addEventListener(flash.events.Event.COMPLETE, fileLoaded);
		file.addEventListener(flash.events.IOErrorEvent.IO_ERROR, ioError);
		file.load();
	}
}

private function fileLoaded(event:flash.events.Event) : void 
{
	if(file != null){
		try {
			var xml:XML = new XML(file.data.toString());
			if(xml.localName() != "Graph"){
				Alert.show("文件有误");
				return;
			}
			//						
			new XMLSerializer().deserialize(vgraph, xml);
			//						currentFileName = file.name;
		} catch(err:Error){
			Alert.show(err.message);
		}
		file = null;
	}
}  

protected function importBtn_clickHandler(event:MouseEvent):void
{
	loadXML();
}

protected function setStartRootBtn_clickHandler(event:MouseEvent):void
{
	if(vgraph.getSelection().length == 0){
		return;
	}
	
	var baseRenderer:BaseRenderer = vgraph.getSelection()[0];
	var inode:IVisualNode = baseRenderer.data as IVisualNode;
	startRoot = inode;
	vgraph.currentRootVNode = startRoot;
	vgraph.draw();
}

protected function saveBtn_clickHandler(event:MouseEvent):void
{
	var xmlSerializer:XMLSerializer = new XMLSerializer();
	var xml:XML = xmlSerializer.serialize(vgraph,"Graph");
	topoRemoteProxy.saveGraphLayout(xml.toString());
	topoRemoteProxy.addEventListener(TopoProviderEvent.SAVE_GRAPH_LAYOUT_RESULT,onSaveGraphLayoutResult);
	topoRemoteProxy.addEventListener(TopoProviderEvent.SAVE_GRAPH_LAYOUT_FAULT,onSaveGraphLayoutFault);
}

protected function onSaveGraphLayoutResult(event:TopoProviderEvent):void
{
	Alert.show("保存成功");
}

protected function onSaveGraphLayoutFault(event:TopoProviderEvent):void
{
	Alert.show(event.object.rootCause.message.toString(),"保存失败");
}

/**
 * 关联具体设备信息。 
 * @param event
 * 
 */
protected function connectDeviceBtn_clickHandler(event:MouseEvent):void
{
	if(vgraph.getSelection().length !=1){
		return;
	}
	
	var xmlSerializer:XMLSerializer = new XMLSerializer();
	var xml:XML = xmlSerializer.serialize(vgraph,"Graph");
	var baseRenderer:BaseRenderer = vgraph.getSelection()[0];
	
	var titleWin:ConnectDeviceTitleWin = PopUpManager.createPopUp(this,ConnectDeviceTitleWin,true) as ConnectDeviceTitleWin;
	titleWin.xml = xml;
	titleWin.item = baseRenderer.data.data;
	PopUpManager.centerPopUp(titleWin);
	titleWin.saveBtn.addEventListener(MouseEvent.CLICK,function saveBtnTitleWinClick(event:MouseEvent):void{
		var baseRenderer:BaseRenderer = vgraph.getSelection()[0];
		var item:ConfigurationItem = titleWin.item as ConfigurationItem;
		baseRenderer.lb.label = item.CI_NAME;
		baseRenderer.toolTip = item.CI_NAME;
		if(baseRenderer.data is IVisualNode){
			var ivnode:IVisualNode = baseRenderer.data as IVisualNode;
			ivnode.view.filters= [];
			var xml:XML;
			if(ivnode && ivnode.data is XML){
				xml = ivnode.data as XML;
				xml.@ciId = item.CI_ID;
				xml.@ciCode = item.CI_CODE != null ? item.CI_CODE :"";
				xml.@name = item.CI_NAME != null ? item.CI_NAME :"";
				xml.@PN = item.PN != null ? item.PN :"";
				xml.@PROVIDER = item.PROVIDER != null ? item.PROVIDER :"";
				xml.@BRAND = item.BRAND != null ? item.BRAND :"";
				xml.@PRICE = item.PRICE;
				xml.@STORAGE_DATE = item.STORAGE_DATE != null ? item.STORAGE_DATE :"";
				xml.@CI_DESC = item.CI_DESC != null ? item.CI_DESC :"";
			}
		}
		PopUpManager.removePopUp(titleWin);	
	});
}

/**
 * 显示表格 
 * @param event
 * 
 */
protected function showgridBtn_clickHandler(event:MouseEvent):void
{
	vgraph.grid.showGrid = !vgraph.grid.showGrid;
}

/**
 * 全屏。 
 * @param event
 * 
 */
protected function fullScreenBtn_clickHandler(event:MouseEvent):void
{
	this.stage.displayState=StageDisplayState.FULL_SCREEN_INTERACTIVE;
}

/**
 * 全屏。 
 * @param event
 * 
 */
protected function normalScreenBtn_clickHandler(event:MouseEvent):void
{
	this.stage.displayState=StageDisplayState.NORMAL;
}

/**
 * 双击节点。 
 * @param event
 * 
 */
protected function vgraph_rendererDoubleClickHandler(event:VisualNodeEvent):void
{
	var baseRenderer:BaseRenderer = event.baseRenderer;
	if(baseRenderer){
		var xmlSerializer:XMLSerializer = new XMLSerializer();
		var xml:XML = xmlSerializer.serialize(vgraph,"Graph");
		
		var titleWin:ConnectDeviceTitleWin = PopUpManager.createPopUp(this,ConnectDeviceTitleWin,true) as ConnectDeviceTitleWin;
		titleWin.xml = xml;
		titleWin.item = baseRenderer.data.data;
		PopUpManager.centerPopUp(titleWin);
		titleWin.saveBtn.addEventListener(MouseEvent.CLICK,function saveBtnTitleWinClick(event:MouseEvent):void{
			var item:ConfigurationItem = titleWin.item as ConfigurationItem;
			baseRenderer.lb.label = item.CI_NAME;
			baseRenderer.toolTip = item.CI_NAME;
			if(baseRenderer.data is IVisualNode){
				var ivnode:IVisualNode = baseRenderer.data as IVisualNode;
				ivnode.view.filters= [];
				var xml:XML;
				if(ivnode && ivnode.data is XML){
					xml = ivnode.data as XML;
					xml.@ciId = item.CI_ID;
					xml.@ciCode = item.CI_CODE;
					xml.@desc = item.CI_DESC;
					xml.@name = item.CI_NAME;
				}
			}
			PopUpManager.removePopUp(titleWin);	
		});
	}
}

protected function vgraph_edgeDoubleClickHandler(event:VisualGraphEditorEvent):void
{
	/*var baseEdgeRenderer:BaseEdgeRenderer = event.item as BaseEdgeRenderer;
	
	var titleWin:EdgeEditorTitleWin = PopUpManager.createPopUp(this,EdgeEditorTitleWin,true) as EdgeEditorTitleWin;
	titleWin.item = baseEdgeRenderer.data.data;
	PopUpManager.centerPopUp(titleWin);
	titleWin.saveBtn.addEventListener(MouseEvent.CLICK,function saveBtnTitleWinClick(event:MouseEvent):void{
		baseEdgeRenderer.data.data = titleWin.item;
		baseEdgeRenderer.render(true);
		var item:ConfigurationItem = titleWin.item as ConfigurationItem;
		baseEdgeRenderer.l.label = item.CI_NAME;
		baseRenderer.toolTip = item.CI_NAME;
		if(baseRenderer.data is IVisualNode){
			var ivnode:IVisualNode = baseRenderer.data as IVisualNode;
			ivnode.view.filters= [];
			var xml:XML;
			if(ivnode && ivnode.data is XML){
				xml = ivnode.data as XML;
				xml.@ciId = item.CI_ID;
				xml.@ciCode = item.CI_CODE;
				xml.@desc = item.CI_DESC;
				xml.@name = item.CI_NAME;
			}
		}
		PopUpManager.removePopUp(titleWin);	
	});*/
}