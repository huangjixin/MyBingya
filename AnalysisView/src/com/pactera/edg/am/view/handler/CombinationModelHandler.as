package com.pactera.edg.am.view.handler
{
    import com.pactera.edg.am.view.handler.*;
    import com.pactera.edg.am.view.model.*;
    import flash.external.*;

    public class CombinationModelHandler extends Object implements IHandler
    {

        public function CombinationModelHandler()
        {
            return;
        }// end function

        public function owner(param1:DisplayElement, param2:String) : void
        {
            this.sendToJavaScript(param1.modelId, "4");
            return;
        }// end function

        public function impact(param1:DisplayElement, param2:String) : void
        {
            this.sendToJavaScript(param1.modelId, "1");
            return;
        }// end function

        public function quality(param1:DisplayElement, param2:String) : void
        {
            var _loc_3:* = new Object();
            _loc_3["sysId"] = param1.parentmodel.parentmodel.parentmodel.id;
            _loc_3["sysCode"] = param1.parentmodel.parentmodel.parentmodel.mdcode;
            _loc_3["sysName"] = param1.parentmodel.parentmodel.parentmodel.mdname;
            _loc_3["schemaId"] = param1.parentmodel.parentmodel.id;
            _loc_3["schemaCode"] = param1.parentmodel.parentmodel.mdcode;
            _loc_3["schemaName"] = param1.parentmodel.parentmodel.mdname;
            _loc_3["tableId"] = param1.parentmodel.id;
            _loc_3["tableCode"] = param1.parentmodel.mdcode;
            _loc_3["tableName"] = param1.parentmodel.mdname;
            _loc_3["fieldId"] = param1.id;
            _loc_3["fieldCode"] = param1.mdcode;
            _loc_3["fieldName"] = param1.mdname;
            _loc_3["url"] = param2;
            _loc_3["analysType"] = "";
            ExternalInterface.call("sendToJavaScript", _loc_3);
            return;
        }// end function

        public function sendToJavaScript(param1:String, param2:String) : void
        {
            var _loc_3:* = new Object();
            _loc_3["modelId"] = param1;
            _loc_3["analysType"] = param2;
            ExternalInterface.call("sendToJavaScript", _loc_3);
            return;
        }// end function

        public function disposal(param1:DisplayElement, param2:String) : void
        {
            this.sendToJavaScript(param1.modelId, "3");
            return;
        }// end function

        public function lineage(param1:DisplayElement, param2:String) : void
        {
            this.sendToJavaScript(param1.modelId, "2");
            return;
        }// end function

        public function relation(param1:DisplayElement, param2:String) : void
        {
            param1.buildFromModels();
            param1.buildToModels();
            var _loc_3:* = param1.getFromModels()[0];
            var _loc_4:* = param1.getToModels()[0];
            var _loc_5:* = new Object();
            new Object()["fkSysId"] = _loc_3.parentmodel.parentmodel.id;
            _loc_5["fkSysCode"] = _loc_3.parentmodel.parentmodel.mdcode;
            _loc_5["fkSysName"] = _loc_3.parentmodel.parentmodel.mdname;
            _loc_5["fkSchemaId"] = _loc_3.parentmodel.id;
            _loc_5["fkSchemaCode"] = _loc_3.parentmodel.mdcode;
            _loc_5["fkSchemaName"] = _loc_3.parentmodel.mdname;
            _loc_5["fkTableId"] = _loc_3.id;
            _loc_5["fkTableCode"] = _loc_3.mdcode;
            _loc_5["fkTableName"] = _loc_3.mdname;
            _loc_5["pkSysId"] = _loc_4.parentmodel.parentmodel.id;
            _loc_5["pkSysCode"] = _loc_4.parentmodel.parentmodel.mdcode;
            _loc_5["pkSysName"] = _loc_4.parentmodel.parentmodel.mdname;
            _loc_5["pkSchemaId"] = _loc_4.parentmodel.id;
            _loc_5["pkSchemaCode"] = _loc_4.parentmodel.mdcode;
            _loc_5["pkSchemaName"] = _loc_4.parentmodel.mdname;
            _loc_5["pkTableId"] = _loc_4.id;
            _loc_5["pkTableCode"] = _loc_4.mdcode;
            _loc_5["pkTableName"] = _loc_4.mdname;
            _loc_5["url"] = param2;
            _loc_5["analysType"] = "";
            ExternalInterface.call("sendToJavaScript", _loc_5);
            return;
        }// end function

    }
}
