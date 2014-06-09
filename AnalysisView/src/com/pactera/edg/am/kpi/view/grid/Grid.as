package com.pactera.edg.am.kpi.view.grid
{
    import com.pactera.edg.am.kpi.factory.*;
    import com.pactera.edg.am.kpi.system.*;
    import com.pactera.edg.am.kpi.view.grid.*;
    import com.pactera.edg.am.kpi.view.line.*;
    import com.pactera.edg.am.kpi.view.model.*;

    public class Grid extends Object implements IGridLayoutable
    {
        protected var _models:Array;
        private var factory:ModelFactory;
        private var rows:Array;
        private var cols:Array;
        private static const rowHeight:int = 0;
        private static const colWidth:int = 0;

        public function Grid()
        {
            cols = [];
            rows = [];
            factory = ApplicationConfig.getInstance().modelFactory;
            return;
        }// end function

        public function get colnum() : int
        {
            return this.cols.length;
        }// end function

        public function FromLineDirection(param1:DisplayElement, param2:DisplayElement, param3:Array) : Number
        {
            var _loc_5:* = null;
            var _loc_4:* = 1;
            for each (_loc_5 in param3)
            {
                
                if (_loc_5.fromModel == param2 && _loc_5.toModel == param1 && _loc_5.direction.direction == 0)
                {
                    _loc_4 = _loc_5.direction.direction;
                }
            }
            return _loc_4;
        }// end function

        public function LineDirection(param1:DisplayElement, param2:DisplayElement, param3:Array) : Number
        {
            var _loc_5:* = null;
            var _loc_4:* = 1;
            for each (_loc_5 in param3)
            {
                
                if (_loc_5.fromModel == param1 && _loc_5.toModel == param2 && _loc_5.direction.direction == 0)
                {
                    _loc_4 = _loc_5.direction.direction;
                }
            }
            return _loc_4;
        }// end function

        public function init(param1:Array) : void
        {
            this.initCol(param1);
            this.initRow(param1);
            return;
        }// end function

        public function getIndexWidth(param1:int) : int
        {
            var ret_width:* = 0;
            var i:* = 0;
            while (i < param1)
            {
                ret_width = ret_width + this.cols[i];
                i++;
            }
            return ret_width;
        }// end function

        private function initCol(param1:Array) : void
        {
            var arrItem:* = null;
            var i:* = 0;
            this.rows = new Array();
			//最大列数
            var maxItemNum:* = 0;
            for each (arrItem in param1)
            {
				maxItemNum = Math.max(maxItemNum, arrItem.colNumber + arrItem.spanrow);
            }
            i = 0;
            while (i < maxItemNum)
            {
                
                this.cols.push(Grid.colWidth);
                i++;
            }
            return;
        }// end function

        public function moveModel(param1:DisplayElement) : void
        {
            param1.move(this.getIndexWidth(param1.colNumber) + this.getGasWidth(), this.getIndexHeight(param1.rowNumber) + this.getGasHeight());
            param1.invalidateDisplayList();
            param1.invalidateSize();
            return;
        }// end function

        public function set models(param1:Array) : void
        {
            this._models = param1;
            return;
        }// end function

        public function getMaxHeigth() : int
        {
            return this.getIndexHeight(this.rows.length);
        }// end function

        public function FromModelInLine(param1:DisplayElement, param2:Array) : Array
        {
            var _loc_4:* = null;
            var _loc_3:* = [];
            for each (_loc_4 in param2)
            {
                
                if (_loc_4.toModel == param1)
                {
                    _loc_3.push(_loc_4.fromModel);
                }
            }
            return _loc_3;
        }// end function

        public function ModelFormat(param1:Array, param2:Array) : Array
        {
            var _loc_8:* = null;
            var _loc_9:* = null;
            var _loc_10:* = null;
            var _loc_11:* = 0;
            var _loc_12:* = null;
            var _loc_13:* = null;
            var _loc_14:* = null;
            var _loc_15:* = null;
            var _loc_16:* = null;
            var _loc_17:* = null;
            var _loc_18:* = null;
            var _loc_19:* = null;
            var _loc_20:* = null;
            var _loc_21:* = NaN;
            var _loc_22:* = NaN;
            var _loc_23:* = NaN;
            var _loc_24:* = null;
            var _loc_3:* = 0;
            var _loc_4:* = 0;
            var _loc_5:* = 0;
            var _loc_6:* = 0;
            var _loc_7:* = 0;
            for each (_loc_8 in param1)
            {
                
                _loc_10 = [];
                _loc_4 = _loc_7;
                _loc_6 = _loc_7;
                if (_loc_8.position)
                {
                    continue;
                }
                _loc_8.rowNumber = _loc_4;
                _loc_8.colNumber = _loc_3;
                _loc_8.position = true;
                _loc_11 = this.LineInModel(_loc_8, param1);
				//zzg 20130528
				param1.splice(_loc_11, 1, _loc_8);
                _loc_10.push(_loc_8);
                _loc_12 = this.ModelInLine(_loc_8, param2);
                _loc_13 = this.FromModelInLine(_loc_8, param2);
                if (_loc_12.length == 0 && _loc_13.length == 0)
                {
                }
                else
                {
                    while (_loc_12.length > 0)
                    {
                        
                        _loc_14 = [];
                        _loc_3 = _loc_3 + 1;
                        for each (_loc_15 in _loc_12)
                        {
                            
                            if (_loc_15.position)
                            {
                                _loc_4 = _loc_4 + 1;
                                continue;
                            }
                            else if (this.LineInModel(_loc_15, param1) > -1)
                            {
                                if (this.LineDirection(_loc_8, _loc_15, param2) == 1)
                                {
                                    _loc_15.rowNumber = _loc_4;
                                    _loc_15.colNumber = _loc_3;
                                    _loc_15.position = true;
                                    _loc_11 = this.LineInModel(_loc_15, param1);
									//zzg 20130528
									param1.splice(_loc_11, 1, _loc_15);
                                    _loc_10.push(_loc_15);
                                    _loc_16 = this.ModelInLine(_loc_15, param2);
                                    if (_loc_16.length > 0)
                                    {
                                        for each (_loc_17 in _loc_16)
                                        {
                                            
                                            _loc_14.push(_loc_17);
                                        }
                                        _loc_4 = _loc_4 + (_loc_16.length - 1);
                                    }
                                }
                                else
                                {
                                    _loc_3 = _loc_3 - 1;
                                    _loc_4 = _loc_4 + 1;
                                    _loc_15.rowNumber = _loc_4;
                                    _loc_15.colNumber = _loc_3;
                                    _loc_15.position = true;
                                    _loc_11 = this.LineInModel(_loc_15, param1);
									//zzg 20130528
									param1.splice(_loc_11, 1, _loc_15);
                                    _loc_10.push(_loc_15);
                                    _loc_3 = _loc_3 + 1;
                                    _loc_16 = this.ModelInLine(_loc_15, param2);
                                    if (_loc_16.length > 0)
                                    {
                                        for each (_loc_17 in _loc_16)
                                        {
                                            
                                            _loc_14.push(_loc_17);
                                        }
                                        _loc_4 = _loc_4 + (_loc_16.length - 1);
                                    }
                                }
                            }
                            _loc_4 = _loc_4 + 1;
                        }
                        _loc_12 = _loc_14;
                        _loc_4 = _loc_7;
                    }
                    _loc_3 = 0;
                    while (_loc_13.length > 0)
                    {
                        
                        _loc_18 = [];
                        _loc_5 = _loc_5 - 1;
                        for each (_loc_19 in _loc_13)
                        {
                            
                            if (_loc_19.position)
                            {
                                _loc_6 = _loc_6 - 1;
                                continue;
                            }
                            else if (this.LineInModel(_loc_19, param1) > -1)
                            {
                                if (this.FromLineDirection(_loc_8, _loc_19, param2) == 1)
                                {
                                    _loc_19.rowNumber = _loc_6;
                                    _loc_19.colNumber = _loc_5;
                                    _loc_19.position = true;
                                    _loc_11 = this.LineInModel(_loc_19, param1);
									//zzg 20130528
									param1.splice(_loc_11, 1, _loc_19);
                                    _loc_10.push(_loc_19);
                                    _loc_16 = this.FromModelInLine(_loc_19, param2);
                                    if (_loc_16.length > 0)
                                    {
                                        for each (_loc_17 in _loc_16)
                                        {
                                            
                                            _loc_18.push(_loc_17);
                                        }
                                        _loc_6 = _loc_6 - (_loc_16.length - 1);
                                    }
                                }
                                else
                                {
                                    _loc_5 = _loc_5 + 1;
                                    _loc_6 = _loc_6 - 1;
                                    _loc_19.rowNumber = _loc_6;
                                    _loc_19.colNumber = _loc_5;
                                    _loc_19.position = true;
                                    _loc_11 = this.LineInModel(_loc_19, param1);
									//zzg 20130528
									param1.splice(_loc_11, 1, _loc_19);
                                    _loc_10.push(_loc_19);
                                    _loc_5 = _loc_5 - 1;
                                    _loc_16 = this.FromModelInLine(_loc_19, param2);
                                    if (_loc_16.length > 0)
                                    {
                                        for each (_loc_17 in _loc_16)
                                        {
                                            
                                            _loc_18.push(_loc_17);
                                        }
                                        _loc_6 = _loc_6 - (_loc_16.length - 1);
                                    }
                                }
                            }
                            _loc_6 = _loc_6 - 1;
                        }
                        _loc_13 = _loc_18;
                        _loc_6 = _loc_7;
                    }
                    _loc_5 = 0;
                    _loc_7 = _loc_7 + 1;
                }
                if (_loc_10.length > 1)
                {
                    _loc_20 = _loc_10[0];
                    _loc_21 = 0;
                    _loc_22 = 0;
                    _loc_23 = 0;
                    for each (_loc_24 in _loc_10)
                    {
                        
                        if (_loc_24.rowNumber - _loc_20.rowNumber < _loc_21)
                        {
                            _loc_21 = _loc_24.rowNumber - _loc_20.rowNumber;
                        }
                        if (_loc_24.colNumber - _loc_20.colNumber < _loc_22)
                        {
                            _loc_22 = _loc_24.colNumber - _loc_20.colNumber;
                        }
                        if (_loc_24.rowNumber - _loc_20.rowNumber > _loc_23)
                        {
                            _loc_23 = _loc_24.rowNumber - _loc_20.rowNumber;
                        }
                    }
                    for each (_loc_24 in _loc_10)
                    {
                        
                        _loc_24.rowNumber = _loc_24.rowNumber - _loc_21;
                        _loc_24.colNumber = _loc_24.colNumber - _loc_22;
                    }
                    _loc_7 = _loc_7 + (_loc_23 - _loc_21);
                    continue;
                }
                _loc_7 = _loc_7 + 1;
            }
            for each (_loc_9 in param1)
            {
                
                if (_loc_9.subModels.length > 0)
                {
                    _loc_9.subModels = this.ModelFormat(_loc_9.subModels, param2);
                }
            }
            return param1;
        }// end function

        public function ModelInLine(param1:DisplayElement, param2:Array) : Array
        {
            var _loc_4:* = null;
            var _loc_3:* = [];
            for each (_loc_4 in param2)
            {
                
                if (_loc_4.fromModel == param1)
                {
                    _loc_3.push(_loc_4.toModel);
                }
            }
            return _loc_3;
        }// end function

        public function getGasWidth() : int
        {
            return 10;
        }// end function

        public function LineInModel(param1:DisplayElement, param2:Array) : Number
        {
            var _loc_4:* = null;
            var _loc_3:* = 0;
            for each (_loc_4 in param2)
            {
                
                if (param1 == _loc_4)
                {
                    return _loc_3;
                }
                _loc_3 = _loc_3 + 1;
            }
            return -1;
        }// end function

        public function moveModelAll(param1:DisplayElement) : void
        {
            var _loc_2:* = null;
            if (param1.subModels.length > 0)
            {
                for each (_loc_2 in param1.subModels)
                {
                    
                    _loc_2.getgrid.moveModelAll(_loc_2);
                }
            }
            else
            {
                param1.move(this.getIndexWidth(param1.colNumber) + this.getGasWidth() * 2, this.getIndexHeight(param1.rowNumber) + this.getGasHeight());
                param1.invalidateDisplayList();
                param1.invalidateSize();
            }
            return;
        }// end function

        public function getGasHeight() : int
        {
            return 10;
        }// end function

        public function get rownum() : int
        {
            return this.rows.length;
        }// end function

        public function get models() : Array
        {
            return this._models;
        }// end function

        public function getIndexHeight(param1:int) : int
        {
            var _loc_2:* = 0;
            var _loc_3:* = 0;
            while (_loc_3 < param1)
            {
                
                _loc_2 = _loc_2 + this.rows[_loc_3];
                _loc_3++;
            }
            return _loc_2;
        }// end function

        public function initAll(param1:Array) : void
        {
            var _loc_2:* = null;
            for each (_loc_2 in param1)
            {
                
                if (_loc_2.image != null)
                {
                    if (_loc_2.isOpen)
                    {
                        _loc_2.image.visible = false;
                    }
                    else
                    {
                        _loc_2.image.visible = true;
                    }
                }
                if (_loc_2.subModels.length > 0)
                {
                    _loc_2.initAll();
                }
            }
            this.initCol(param1);
            this.initRow(param1);
            return;
        }// end function

        private function initRow(param1:Array) : void
        {
            var _loc_3:* = null;
            var _loc_4:* = 0;
            this.rows = new Array();
            var _loc_2:* = 0;
            for each (_loc_3 in param1)
            {
                
                _loc_2 = Math.max(_loc_2, _loc_3.rowNumber);
            }
            _loc_4 = 0;
            while (_loc_4 <= _loc_2)
            {
                
                this.rows.push(Grid.rowHeight);
                _loc_4++;
            }
            return;
        }// end function

        public function reCalculate(param1:Array) : void
        {
            var _loc_2:* = null;
            var arrItem:* = null;
            var i:* = 0;
            for each (_loc_2 in param1)
            {
                
                this.cols[_loc_2.colNumber] = Math.max(this.cols[_loc_2.colNumber], Grid.colWidth, _loc_2.getExWidth() + this.getGasWidth() * 2);
				trace("kpi:reCalculate(): this.cols[_loc_2.colNumber]"+ this.cols[_loc_2.colNumber]);
            }
            for each (arrItem in param1)
            {
                
                i = 0;
                while (i < arrItem.spanrow)
                {
                    
                    if (arrItem.modelClass !== "ChartModel")
                    {
                        this.rows[arrItem.rowNumber + i] = Math.max(arrItem.getExHeight() / arrItem.spanrow + this.getGasHeight() * 2, this.rows[arrItem.rowNumber + i]);
                    }
                    else
                    {
                        this.rows[arrItem.rowNumber + i] = Math.max(arrItem.defaultModelHeight / arrItem.spanrow + this.getGasHeight() * 2, this.rows[arrItem.rowNumber + i]);
                    }
					trace("kpi:reCalculate(): this.rows[_loc_3.rowNumber + _loc_4]"+ this.rows[arrItem.rowNumber + i]);
                    i++;
					
                }
            }
            return;
        }// end function

        public function getMaxWidth() : int
        {
            return this.getIndexWidth(this.cols.length);
        }// end function

    }
}
