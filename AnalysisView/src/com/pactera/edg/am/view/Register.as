package com.pactera.edg.am.view
{
    import com.pactera.edg.am.view.extender.*;
    import com.pactera.edg.am.view.grid.*;
    import com.pactera.edg.am.view.model.*;

    public class Register extends Object
    {

        public function Register()
        {
            var _loc_1:SwimModel = null;
            var _loc_2:SwimModelExtender = null;
            var _loc_3:CombinationModel = null;
            var _loc_4:CombinationModelExtender = null;
            var _loc_5:BasicModel = null;
            var _loc_6:BasicModelExtender = null;
            var _loc_7:Icon = null;
            var _loc_8:IconExtender = null;
            var _loc_9:OpenGrid = null;
            var _loc_10:CloseGrid = null;
            //登记，避免getDefinitionByName()错误
            /*
            ReferenceError: Error #1065: 变量 GetMoreModel 未定义。
	at global/flash.utils::getDefinitionByName()
	at com.pactera.edg.am.factory::ModelFactory/factory()[D:\ide\workspace_center\finance\workspace_flex\AnalysisView_fb3\~AnalysisView\src\com\longtop\factory\ModelFactory.as:248]
            */
            var _loc_11:GetMoreModel =null
            var _loc_12:GetMoreModelExtender =null;
            return;
        }// end function

    }
}
