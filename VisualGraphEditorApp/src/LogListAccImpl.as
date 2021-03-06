///////////////////////////////////////////////////////////////////////////////
// Licensed Materials - Property of IBM
// 5724-Z78
// © Copyright IBM Corporation 2007, 2012. All Rights Reserved.
//
// Note to U.S. Government Users Restricted Rights:
// Use, duplication or disclosure restricted by GSA ADP Schedule
// Contract with IBM Corp.
///////////////////////////////////////////////////////////////////////////////
package
{
  import mx.core.UIComponent;
  
  import spark.accessibility.ListAccImpl;
  import spark.components.supportClasses.ListBase;
  
  /**
  * LogListAccImpl is the accessibility implementation class
  * for LogList.
  * It uses the unformatted string of the displayed list items.
  */
  public class LogListAccImpl extends ListAccImpl
  {
    
    /**
    * @inheritDoc
    */
    public function LogListAccImpl(master:UIComponent)
    {
      super(master);
    }
    
    /**
     *  Enables accessibility in the LogList class.
     * 
     *  <p>This method is called by application startup code
     *  that is autogenerated by the MXML compiler.
     *  Afterwards, when instances of LogList are initialized,
     *  their <code>accessibilityImplementation</code> property
     *  will be set to an instance of this class.</p>
     *  
     */
    public static function enableAccessibility():void
    {
      LogList.createAccessibilityImplementation =
        createAccessibilityImplementation;
    }
    
    /**
     *  @private
     *  Creates a LogList's AccessibilityImplementation object.
     *  This method is called from UIComponent's
     *  initializeAccessibility() method.
     */
    static internal function createAccessibilityImplementation(
      component:UIComponent):void
    {
      component.accessibilityImplementation =
        new LogListAccImpl(component);
    }
    
    /**
    * @private
    *  Method for returning the name of the list item
    *  which is spoken out by the screen reader.
    *  The item returns the unformated label.
    *
    *  @param childID uint
    *
    *  @return Name String
    */
    override protected function getName(childID:uint):String
    {
      if (childID == 0) return "";
      
      var list:ListBase = ListBase(master);
      
      var index:uint = childID - 1;
      
      // Sometimes the player passes a bad childID such as -1001999997.
      // (SDK-25026) Until this is fixed in the Player,
      // we'll just return an empty string for the name
      // if the childID is bad.
      if (index < 0 || index >= list.dataProvider.length)
        return "";

      return list.dataProvider.getItemAt(index).accLabel;
    }
  }
}
