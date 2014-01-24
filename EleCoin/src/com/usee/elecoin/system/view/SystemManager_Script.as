import flash.display.DisplayObject;
import flash.events.Event;

import mx.collections.ArrayCollection;
import mx.collections.XMLListCollection;
import mx.core.Container;

import spark.components.NavigatorContent;

private var _secondMenuXmllist:XMLListCollection;

/**
 * 菜单数组。
 */
private var menuNavArrayList:ArrayCollection = new ArrayCollection();

[Bindable(event="secondMenuXmllistChange")]
/**
 * 顶级菜单xml数组。 
 */
public function get secondMenuXmllist():XMLListCollection
{
	return _secondMenuXmllist;
}

/**
 * @private
 */
public function set secondMenuXmllist(value:XMLListCollection):void
{
	if( _secondMenuXmllist !== value)
	{
		_secondMenuXmllist = value;
		this.dispatchEvent(new Event("secondMenuXmllistChange"));
		this.callLater(storgeMenuNav,[this.viewStatck]);
	}
}

protected function storgeMenuNav(container:Container):void
{
	var nav:NavigatorContent;
	for (var i:int = 0; i < container.numElements; i++) 
	{
		nav = container.getElementAt(i) as NavigatorContent;
		if(!menuNavArrayList.contains(nav)){
			menuNavArrayList.addItem(nav);
		}
		if(nav.hasOwnProperty("viewStatck")){
			var displayObject:DisplayObject = nav["viewStatck"];
			if(displayObject){
				storgeMenuNav(displayObject as Container);
			}
		}
	}
	
}