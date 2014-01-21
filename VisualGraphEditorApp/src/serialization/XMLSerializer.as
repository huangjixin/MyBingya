package serialization
{
	import cn.hnisi.ravis.editor.VisualGraphEditor;
	
	import mx.controls.Alert;
	import mx.core.ClassFactory;
	
	import org.un.cava.birdeye.ravis.components.renderers.BaseRenderer;
	import org.un.cava.birdeye.ravis.graphLayout.data.Graph;
	import org.un.cava.birdeye.ravis.graphLayout.data.IEdge;
	import org.un.cava.birdeye.ravis.graphLayout.layout.ConcentricRadialLayouter;
	import org.un.cava.birdeye.ravis.graphLayout.layout.DirectPlacementLayouter;
	import org.un.cava.birdeye.ravis.graphLayout.visual.IVisualEdge;
	import org.un.cava.birdeye.ravis.graphLayout.visual.IVisualNode;
	import org.un.cava.birdeye.ravis.graphLayout.visual.VisualGraph;
	import org.un.cava.birdeye.ravis.graphLayout.visual.edgeRenderers.BaseEdgeRenderer;
	import org.un.cava.birdeye.ravis.graphLayout.visual.edgeRenderers.DirectedArrowEdgeRenderer;

	public class XMLSerializer
	{
		public function XMLSerializer()
		{
		}
		
		/**
		 * Serialize the given object with the tag. 
		 * 
		 */
		public function serialize(object:Object, rootTag:String, childrenOnly:Boolean = true) : XML
		{
//			reset();
			
			var root:XML = new XML("<"+rootTag+"/>");
      
      		if(childrenOnly){
       			serializeChildren(object, root, root);
      		} else {
        	/*var child:XML = serializeObject(object, root);
        		if(child != null)
         			 root.appendChild(child);*/
     		}
     		return root;
		}
		
		private function serializeChildren(object:Object, parent:XML, root:XML) : void
		{
			var children:Array = getChildrenToSerialize(object);
			if(children){
				for (var i:int = 0; i < children.length; i++) 
				{
					var childObject:Object = children[i];
					var child:XML = serializeObject(childObject, root);
					if(child != null)
						parent.appendChild(child);
				}
			}
		}
		
		protected function getChildrenToSerialize(object:Object) : Array
		{
			var children:Array = new Array();
			if(object is VisualGraphEditor){
				children = VisualGraphEditor(object).getRenderders();
				return children;
			}
			return null;
		}
		
		protected function serializeObject(object:Object, root:XML) : XML
		{
			var inode:IVisualNode;
			var iedge:IVisualEdge;
			
			var xml:XML;
			if(object is BaseRenderer){
				inode = BaseRenderer(object).data as IVisualNode;
				if(inode.data is XML){
					xml	= inode.data as XML;
					/*var id:String = inode.id +"";
					xml.@id = id;*/
					xml.@x = inode.x;
					xml.@y = inode.y;
					xml.@type = String(inode.data.@nodeIcon);
					xml.@name = String(inode.data.@name);
					xml.@id = String(inode.data.@id);
//					xml.@importantLevel = String(inode.data.@importantLevel);
					if(inode.data.hasOwnProperty("@importantLevel"))
						xml.@importantLevel = String(inode.data.@importantLevel);
					if(inode.data.hasOwnProperty("@_entityStatus"))
						xml.@_entityStatus = String(inode.data.@_entityStatus);
				}
			}else if(object is BaseEdgeRenderer){
				iedge = BaseEdgeRenderer(object).data as IVisualEdge;
				if(iedge.data && iedge.data is XML){
					xml	= iedge.data as XML;
				}else if(!iedge.data){
					xml = new XML("<"+Graph.DEFAULTNAME_EDGE+"/>");
					xml.@fromID = ""+iedge.edge.node1.data.@id;
					xml.@toID = ""+iedge.edge.node2.data.@id;
//					xml.@id = ""+iedge.edge.data.@id;
				}
			}
			
     		return xml;
    	}
		
		public function deserialize(object:Object, xml:XML, childrenOnly:Boolean = true) : Object
		{
			var result:Object;
			if(object is VisualGraphEditor){
				var xmllist:XMLList = xml.Node;
				var idString:String;
				if(xmllist && xmllist.length()>0){
					idString = xmllist[0].@id;
				}else{
					Alert.show("XML要有Node节点，节点属性要有id");
					return null;
				}
				
				var vgraph:VisualGraphEditor = object as VisualGraphEditor;

				vgraph.graph =  new Graph("XMLAsDocsGraph",false,xml);
				//反序列化需要绝对定位，所以用DirectPlacementLayouter布局。
				vgraph.layouter = new DirectPlacementLayouter(vgraph);;
//				vgraph.layouter.autoFitEnabled = true;

				vgraph.currentRootVNode = vgraph.graph.nodeByStringId(idString).vnode;
				vgraph.draw();
			}
			
			return result;
		}
	}
}