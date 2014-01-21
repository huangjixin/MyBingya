package demo.alarm.alarmmapping{
	
	import twaver.Consts;
	import twaver.ElementBox;
	import twaver.IAlarm;
	import twaver.IAlarmElementMapping;
	import twaver.IElement;
	import twaver.QuickFinder;

	public class CustomAlarmElementMapping implements IAlarmElementMapping{
		
		public static const MAPPINGID:String = "MAPPINGID";
		
		private var elementFinder:QuickFinder = null;
		private var alarmFinder:QuickFinder = null; 
		
		public function CustomAlarmElementMapping(box:ElementBox){
			this.elementFinder = new QuickFinder(box, MAPPINGID, Consts.PROPERTY_TYPE_CLIENT);
			this.alarmFinder = new QuickFinder(box.alarmBox, MAPPINGID, Consts.PROPERTY_TYPE_CLIENT);
		}

		public function getCorrespondingAlarms(element:IElement):Array{
			return this.alarmFinder.find(element.getClient(MAPPINGID));
		}
		
		public function getCorrespondingElements(alarm:IAlarm):Array{
			return this.elementFinder.find(alarm.getClient(MAPPINGID));
		}
		
	}
}