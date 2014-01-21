package com.hjx.jbpm
{
	public class Assignment extends JbpmBase
	{
		private var _className:String="";
		
		private var _expression:String="";
		
		private var _actor_id:String="";
		
		private var _pooled_actors:String="";
		
		private var _config_type:String="";
		
		public function Assignment()
		{
		}

		public function get config_type():String
		{
			return _config_type;
		}

		public function set config_type(value:String):void
		{
			_config_type = value;
		}

		public function get pooled_actors():String
		{
			return _pooled_actors;
		}

		public function set pooled_actors(value:String):void
		{
			_pooled_actors = value;
		}

		public function get actor_id():String
		{
			return _actor_id;
		}

		public function set actor_id(value:String):void
		{
			_actor_id = value;
		}

		public function get expression():String
		{
			return _expression;
		}

		public function set expression(value:String):void
		{
			_expression = value;
		}

		/**
		 * 转换为描述文件的时候，要把该属性改成“class” 
		 * @return 
		 * 
		 */
		public function get className():String
		{
			return _className;
		}

		public function set className(value:String):void
		{
			_className = value;
		}
		
		public function canIgnored():Boolean{
			return (config_type=="" &&
				pooled_actors=="" &&
				actor_id=="" &&
				expression=="");
		}
		
		override public function deserialXml(xml:XML):void{
			this.className = xml.attribute("class");
			this.config_type = xml.attribute("config-type");
		}
		
		override public function toXml():XML
		{
			var xml:XML = super.toXml();
			if(this.className && this.className!=""){
				xml.@["class"] = className;			
			}
			if(this.expression && this.expression!=""){
				xml.@["expression"] = expression;			
			}
			if(this.actor_id && this.actor_id!=""){
				xml.@["actor-id"] = actor_id;		
			}
			if(this.pooled_actors && this.pooled_actors!=""){
				xml.@["pooled-actors"] = pooled_actors;		
			}
			if(this.config_type && this.config_type!=""){
				xml.@["config-type"] = config_type;			
			}
			
			return xml;
		}
	}
}