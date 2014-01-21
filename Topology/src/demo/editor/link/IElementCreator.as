package demo.editor.link
{
	import flash.events.MouseEvent;
	
	import twaver.IElement;
	import twaver.network.Network;

	public interface IElementCreator
	{
		function createElement(evt:MouseEvent,network:Network):IElement;
	}
}