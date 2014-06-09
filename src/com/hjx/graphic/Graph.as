package com.hjx.graphic
{
	import spark.components.Group;
	import spark.events.ElementExistenceEvent;
	
	/**
	 * @date 2014-6-3,@author 黄记新
	 */
	public class Graph extends Group
	{
		
		private var _owningSubGraph:SubGraph;
		
		private var _subgraphs:Vector.<SubGraph>;
		private var _nodes:Vector.<Node>;
		private var _links:Vector.<Link>;
		
		public function Graph()
		{
			super();
			
			_subgraphs = new Vector.<SubGraph>();
			_nodes = new Vector.<Node>();
			_links = new Vector.<Link>();
			
			addEventListener(ElementExistenceEvent.ELEMENT_ADD,elementAddedHandler);
			addEventListener(ElementExistenceEvent.ELEMENT_REMOVE,elementRemovedHandler);
			
		}
		
		public function get owningSubGraph():SubGraph
		{
			return _owningSubGraph;
		}
		
		public function set owningSubGraph(value:SubGraph):void
		{
			_owningSubGraph = value;
		}
		
		public function getSubGraphs():Vector.<SubGraph>
		{
			return this._subgraphs.slice(0);
		}
		
		internal function subgraphAdded(subGraph:SubGraph):void
		{
			this._subgraphs.push(subGraph);
			return;
		}
		
		internal function subgraphRemoved(subGraph:SubGraph):void
		{
			var index:int=this._subgraphs.indexOf(subGraph);
			if (index != -1) 
			{
				this._subgraphs.splice(index, 1);
			}
			return;
		}
		
		public function getNodes():Vector.<Node>
		{
			return this._nodes.slice(0);
		}
		
		internal function nodeAdded(node:Node):void
		{
			this._nodes.push(node);
			return;
		}
		
		internal function nodeRemoved(node:Node):void
		{
			var index:int=this._nodes.indexOf(node);
			if (index != -1) 
			{
				this._nodes.splice(index, 1);
			}
			return;
		}
		
		public function getLinks():Vector.<Link>
		{
			return this._links.slice(0);
		}
		internal function linkAdded(link:Link):void
		{
			this._links.push(link);
			return;
		}
		
		internal function linkRemoved(link:Link):void
		{
			var index:int=this._links.indexOf(link);
			if (index != -1) 
			{
				this._links.splice(index, 1);
			}
			return;
		}
		
		internal function elementAddedHandler(event:ElementExistenceEvent):void
		{
			var link:Link=null;
			var element:Node =event.element as Node;
			if (element) 
			{
				if (event.element is SubGraph) 
				{
					this.subgraphAdded(SubGraph(event.element));
				}
				this.nodeAdded(element);
			}
			else if (event.element is Link) 
			{
				link = event.element as Link;
				this.linkAdded(link);
			}
			return;
		}
		
		internal function elementRemovedHandler(event:ElementExistenceEvent):void
		{
			var node:Node=null;
			var link:Link;
			
			if (event.element is SubGraph) 
			{
				this.subgraphRemoved(SubGraph(event.element));
			}
			if (event.element is Node) 
			{
				node = event.element as Node;
				this.nodeRemoved(node);
			}
			else if (event.element is Link) 
			{
				link = event.element as Link;
				this.linkRemoved(link);
			}
			return;
		}
	}
}