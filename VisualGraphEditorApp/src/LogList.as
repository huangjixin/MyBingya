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
  import spark.components.List;
  
  [AccessibilityClass(implementation="LogListAccImpl")]
  /**
  * This class extending the List component creates its own
  * accessibility implementation in order to use unformatted
  * list item strings.
  */
  public class LogList extends List
  {
    static internal var createAccessibilityImplementation:Function; 
    
    /**
     * @inheritDoc
     */
    override protected function initializeAccessibility():void 
    { 
      if (LogList.createAccessibilityImplementation != null) 
        LogList.createAccessibilityImplementation(this); 
    }
  }
}
