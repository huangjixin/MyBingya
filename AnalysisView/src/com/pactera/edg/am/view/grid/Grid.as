package com.pactera.edg.am.view.grid
{
    import com.pactera.edg.am.factory.*;
    import com.pactera.edg.am.system.*;
    import com.pactera.edg.am.view.model.*;

    public class Grid extends Object implements IGridLayoutable
    {
        protected var _models:Array;
        private var factory:ModelFactory = null;
        private var rows:Array;
        private var cols:Array;
        private static const rowHeight:int = 0;
        private static const colWidth:int = 0;

        public function Grid()
        {
            this.cols = [];
            this.rows = [];
            this.factory = ApplicationConfig.getInstance().modelFactory;
            return;
        }// end function

       
        
        public function get rownum() : int
        {
            return this.rows.length;
        }// end function

        public function get colnum() : int
        {
            return this.cols.length;
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
            this.cols = new Array();
            var _loc_2:int = 0;
            for each (_loc_3 in param1)
            {
                
                _loc_2 = Math.max(_loc_2, _loc_3.colNumber);
            }
            _loc_4 = 0;
            while (_loc_4 <= _loc_2)
            {
                
                this.cols.push(Grid.colWidth);
                _loc_4++;
            }
            return;
        }// end function

        public function moveModel(param1:DisplayElement) : void
        {
            var px:* = this.getIndexWidth(param1.colNumber) + this.getGasWidth();
            var py:* = this.getIndexHeight(param1.rowNumber) + this.getGasHeight();
            //trace("move " + param1.mdname);
            //zzg 2011-12-15 
            var moveX:Number;
            var moveY:Number;
            
          
          //zzg 2011-12-15
          //改进支持绝对布局（相对原点）调整为相对布局（相对排列标准位置）。
            if(isNaN(param1.autoPx)){
            	  //原来计算自动排列和手工排列的判断逻辑
	            moveX = isNaN(param1.xPos) ? (px) : (param1.xPos);
	            moveY = isNaN(param1.yPos) ? (py) : (param1.yPos);
            }else{
            	var lastAutoPx:Number=param1.autoPx;
            	var lastAutoPy:Number=param1.autoPy;
            	moveX=isNaN(param1.xPos) ? (px) :((param1.xPos-lastAutoPx)+px);
            	moveY=isNaN(param1.yPos) ? (py) :((param1.yPos-lastAutoPy)+py);
            	//重新记忆调整后的手工排列位置
            	param1.xPos=moveX;
            	param1.yPos=moveY;
            }
 			//记住新的自动排列的位置
            param1.autoPx=px;
            param1.autoPy=py;

            param1.move(moveX, moveY);
        
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

        public function getGasWidth() : int
        {
            return 10;
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

        public function get models() : Array
        {
            return this._models;
        }// end function

        public function getColMaxWidth(param1:int) : Number
        {
            return this.cols[param1];
        }// end function

        //排序去重
        public function sortModelLayer(param1:Array) : Array
        {
            var _loc_3:Number = NaN;
            var _loc_4:Number = NaN;
            var _loc_5:int = 0;
            var _loc_6:int = 0;
            var _loc_7:Number = NaN;
            var _loc_8:Number = NaN;
            var _loc_2:* = new Array();
            for each (_loc_3 in param1)
            {
                
                _loc_2.push(_loc_3);//push具有去重作用
            }
           // trace("[grid.as] _loc_2.length:"+_loc_2.length);
            //冒泡排序，保持升序排列，不断将小数值对象排列到数组的低序号位置。
            _loc_5 = 0;
            while (_loc_5 < _loc_2.length)
            {
                
                _loc_6 = _loc_5 + 1;
                while (_loc_6 < _loc_2.length)
                {
                    
                    
                    _loc_7 = _loc_2[_loc_5];
                    _loc_8 = _loc_2[_loc_6];
                    //如果后面的元素值小，则调换到前面来，
                    //保持小的在前，大的在后，形成升序排列
                    //即，序号越大，值越大，序号越小，值越小
                    if (_loc_7 > _loc_8)
                    {
                        _loc_4 = _loc_2[_loc_5];
                        _loc_2[_loc_5] = _loc_2[_loc_6];
                        _loc_2[_loc_6] = _loc_4;
                    }
                    _loc_6++;
                }
                _loc_5++;
            }
            return _loc_2;
        }// end function

        private function initRow(param1:Array) : void
        {
            var _loc_3:DisplayElement = null;
            var _loc_4:int = 0;
            this.rows = [];
            
            //查找param1数组中，最大行数(rowNumber)
            var _loc_2:int = 0;
            for each (_loc_3 in param1)
            {
                
                _loc_2 = Math.max(_loc_2, _loc_3.rowNumber);
            }
            
            //this.rows初始化，push最大rowNumber个Grid.rowHeight到数组对象
            _loc_4 = 0;
            while (_loc_4 <= _loc_2)
            {
                
                this.rows.push(Grid.rowHeight);
                _loc_4++;
            }
            return;
        }// end function

        public function initColMaxWidth(param1:int, param2:Number) : void
        {
            this.cols[param1] = param2;
            return;
        }// end function

        public function reCalculate(param1:Array) : void
        {
        	 	 	//初始化数据，刷新视图
            //zzg 2011-12-13 刷新缓存，便于重算元素尺寸
        	DisplayElement.resetExCache(param1);
        	
            var _loc_2:DisplayElement = null; 
            var _loc_3:int = 0;
            for each (_loc_2 in param1)
            {
                this.cols[_loc_2.colNumber] = Math.max(this.cols[_loc_2.colNumber], Grid.colWidth, _loc_2.getExWidth() + this.getGasWidth() * 2);
            }
            for each (_loc_2 in param1)
            {
                
                _loc_3 = 0;
                //处理行跨度
                while (_loc_3 < _loc_2.spanrow)
                {
                    
                    this.rows[_loc_2.rowNumber + _loc_3] = Math.max(_loc_2.getExHeight() / _loc_2.spanrow + this.getGasHeight() * 2, this.rows[_loc_2.rowNumber + _loc_3]);
                    _loc_3++;
                }
            }
            return;
        }// end function

		//模型定位格式
        public function ModelPostionFormat(param1:Array) : Array
        {
            var _loc_5:DisplayElement = null;
            //升序数组
            var sortAscArr:Array = null;
            var _loc_7:Number = NaN;
            var _loc_8:DisplayElement = null;
            //是否排列好了层数据
            var isArrangeLayer:Boolean = false;
            var _loc_10:DisplayElement = null;
            var col:Number = 0;
            var row:Number = 0;
            var _loc_4:* = new Array();
            for each (_loc_5 in param1)
            {
                
                _loc_4[_loc_5.sequence] = _loc_5.sequence;
                 // trace("[grid.as]["+param1.length+"]before sort:["+_loc_5.sequence+"]"+_loc_4[_loc_5.sequence])
            }
          
            
            sortAscArr = this.sortModelLayer(_loc_4);
            
             var i:String;
             
           for( i in sortAscArr){
           	  //trace("[grid.as]["+sortAscArr.length+"]after sort:["+i+"]"+sortAscArr[i]);
           }
           
           //安排好各数据对象的行列值（rowNumber,colNumber）
           //相同层的数据具有相同的colNumber
            for each (_loc_7 in sortAscArr)
            {
                
                //是否排列好了层数据,
                //默认未安排
                isArrangeLayer = false;
                //设置相同层的具有相同的col，且row不断加1
                for each (_loc_10 in param1)
                {
                    
                    if (_loc_10.sequence == _loc_7)
                    {
                        _loc_10.colNumber = col;
                        _loc_10.rowNumber = row;
                        //行数增加
                        row = row + 1;
                        //标识为已安排数据
                        isArrangeLayer = true;
                    }
                }
                
                //如果对应层已经排列，将col加1，安排下一层的数据。
                if (isArrangeLayer)
                {
                    col = col + 1;
                }
                //下一层的行值从0开始
                row = 0;
            }
            //看是否有子模型，尝试排列子模型的行列值
            for each (_loc_8 in param1)
            {
                
                if (_loc_8.subModels.length > 0)
                {
                    _loc_8.subModels = this.ModelPostionFormat(_loc_8.subModels);
                }
            }
            return param1;
        }// end function

        public function initAll(param1:Array) : void
        {
            var _loc_2:DisplayElement = null;
            this.initCol(param1);
            this.initRow(param1);
            for each (_loc_2 in param1)
            {
                
                if (_loc_2.subModels.length > 0)
                {
                    _loc_2.initAll();
                }
            }
            return;
        }// end function

        public function getGasHeight() : int
        {
            return 10;
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

        public function getMaxWidth() : int
        {
            return this.getIndexWidth(this.cols.length);
        }// end function

    }
}
