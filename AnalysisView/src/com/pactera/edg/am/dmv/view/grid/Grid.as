package com.pactera.edg.am.dmv.view.grid
{
    import com.pactera.edg.am.dmv.factory.*;
    import com.pactera.edg.am.dmv.system.*;
    import com.pactera.edg.am.dmv.view.grid.*;
    import com.pactera.edg.am.dmv.view.line.*;
    import com.pactera.edg.am.dmv.view.model.*;
    
    

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

        public function SwimModelFormat(param1:Array, param2:Array) : Array
        {
            var _loc_5:DisplayElement = null;
            var _loc_6:DisplayElement = null;
            var _loc_7:int = 0;
            var _loc_3:Number = 0;
            var _loc_4:Number = 0;
            for each (_loc_5 in param1)
            {
                
                _loc_5.rowNumber = _loc_4;
                _loc_5.colNumber = _loc_3;
                _loc_7 = this.LineInModel(_loc_5, param1);
                param1.splice(_loc_7, 1, _loc_5);
                _loc_3 = _loc_3 + 1;
            }
            for each (_loc_6 in param1)
            {
                
                if (_loc_6.subModels.length > 0)
                {
                    _loc_6.subModels = this.ModelFormat(_loc_6.subModels, param2);
                }
            }
            return param1;
        }// end function

        public function init(param1:Array) : void
        {
            this.initCol(param1);
            this.initRow(param1);
            return;
        }// end function

        public function getIndexWidth(param1:int) : int
        {
            var _loc_2:int = 0;
            var _loc_3:int = 0;
            while (_loc_3 < param1)
            {
                
                _loc_2 = _loc_2 + this.cols[_loc_3];
                _loc_3++;
            }
            return _loc_2;
        }// end function

        private function initCol(param1:Array) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_4:int = 0;
            this.rows = new Array();
            var _loc_2:int = 0;
            for each (_loc_3 in param1)
            {
                
                _loc_2 = Math.max(_loc_2, _loc_3.colNumber + _loc_3.spanrow);
            }
            _loc_4 = 0;
            while (_loc_4 < _loc_2)
            {
                
                this.cols.push(Grid.colWidth);
                _loc_4++;
            }
            return;
        }// end function

        public function moveModel(param1:DisplayElement) : void
        {
            var _loc_2:* = this.getIndexWidth(param1.colNumber) + this.getGasWidth();
            var _loc_3:* = this.getIndexHeight(param1.rowNumber) + this.getGasHeight();
            _loc_2 = param1.xPos == 0 ? (_loc_2) : (param1.xPos);
            _loc_3 = param1.yPos == 0 ? (_loc_3) : (param1.yPos);
            param1.move(_loc_2, _loc_3);
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
            var _loc_4:Line = null;
            var _loc_3:Array = [];
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
            var _loc_8:DisplayElement = null;
            var _loc_9:DisplayElement = null;
            var _loc_10:Array = null;
            var _loc_11:int = 0;
            var _loc_12:Array = null;
            var _loc_13:Array = null;
            var _loc_14:Array = null;
            var _loc_15:DisplayElement = null;
            var _loc_16:Array = null;
            var _loc_17:DisplayElement = null;
            var _loc_18:Array = null;
            var _loc_19:DisplayElement = null;
            var _loc_20:DisplayElement = null;
            var _loc_21:Number = NaN;
            var _loc_22:Number = NaN;
            var _loc_23:Number = NaN;
            var _loc_24:DisplayElement = null;
            var _loc_3:Number = 0;
            var _loc_4:Number = 0;
            var _loc_5:Number = 0;
            var _loc_6:Number = 0;
            var _loc_7:Number = 0;
            for each (_loc_8 in param1)
            {
                
                _loc_10 = [];
                _loc_4 = _loc_7;
                _loc_6 = _loc_7;
                _loc_8.rowNumber = _loc_4;
                _loc_8.colNumber = _loc_3;
                _loc_11 = this.LineInModel(_loc_8, param1);
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
                            
                            if (this.LineInModel(_loc_15, param1) > -1)
                            {
                                _loc_15.rowNumber = _loc_4;
                                _loc_15.colNumber = _loc_3;
                                _loc_11 = this.LineInModel(_loc_15, param1);
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
                            
                            if (this.LineInModel(_loc_19, param1) > -1)
                            {
                                _loc_19.rowNumber = _loc_6;
                                _loc_19.colNumber = _loc_5;
                                _loc_11 = this.LineInModel(_loc_19, param1);
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
                    	//zzg 2011-12-19
                    	//初步分析(_loc_28[_loc_27])为_loc_24
                        //(_loc_28[_loc_27])
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
            var _loc_4:Line = null;
            var _loc_3:Array = [];
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
            var _loc_4:DisplayElement = null;
            var _loc_3:Number = 0;
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
            var _loc_2:DisplayElement = null;
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
            var _loc_2:int = 0;
            var _loc_3:int = 0;
            while (_loc_3 < param1)
            {
                
                _loc_2 = _loc_2 + this.rows[_loc_3];
                _loc_3++;
            }
            return _loc_2;
        }// end function

        public function initAll(param1:Array) : void
        {
            var _loc_2:DisplayElement = null;
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
            var _loc_3:DisplayElement = null;
            var _loc_4:int = 0;
            rows = [];
            var _loc_2:int = 0;
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
            var _loc_3:DisplayElement = null;
            var _loc_4:int = 0;
            var _loc_2:Number = 0;
            while (_loc_2 < this.cols.length)
            {
                
                this.cols[_loc_2] = 0;
                _loc_2 = _loc_2 + 1;
            }
            for each (_loc_3 in param1)
            {
                
                this.cols[_loc_3.colNumber] = Math.max(this.cols[_loc_3.colNumber], Grid.colWidth, _loc_3.getExWidth() + this.getGasWidth() * 2);
            }
            for each (_loc_3 in param1)
            {
                
                _loc_4 = 0;
                while (_loc_4 < _loc_3.spanrow)
                {
                    
                    this.rows[_loc_3.rowNumber + _loc_4] = Math.max(_loc_3.getExHeight() / _loc_3.spanrow + this.getGasHeight() * 2, this.rows[_loc_3.rowNumber + _loc_4]);
                    _loc_4++;
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
