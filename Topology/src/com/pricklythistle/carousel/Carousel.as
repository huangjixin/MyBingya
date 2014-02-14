package com.pricklythistle.carousel
{
	//##################################################################
	//#
	//#		Creates and displays item renderes
	//#
	//##################################################################
	
	import demo.index.IndexItemRenderer;
	import demo.index.index;
	
	import flash.display.DisplayObject;
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.events.MouseEvent;
	
	import mx.collections.ArrayCollection;
	import mx.collections.Sort;
	import mx.collections.SortField;
	import mx.containers.Canvas;
	import mx.core.ClassFactory;
	import mx.core.FlexGlobals;
	import mx.core.IDataRenderer;
	import mx.core.IFactory;
	import mx.effects.Move;
	import mx.effects.Resize;
	import mx.effects.Tween;
	import mx.effects.easing.Exponential;
	import mx.events.EffectEvent;
	import mx.events.ItemClickEvent;
	
	import spark.events.IndexChangeEvent;

	[Event(name="change", type="spark.events.IndexChangeEvent")]
	public class Carousel extends Canvas
	{
		private var _renderers:ArrayCollection;
		private var _selectedVO:CarouselVO;
		private var _tweenPlaying:Boolean = true;
		private var _rotationTween:Tween;
		private var _itemZoom:Boolean = false;
		
		public function Carousel()
		{
			super();
			
			//set defaults
			
			_rotation = 0;
//			_itemRenderer = new ClassFactory(com.pricklythistle.carousel.CarouselRenderer);
			_itemRenderer = new ClassFactory(IndexItemRenderer);
			
			_itemWidth = 200;
			_itemHeight = 150;
			
			_frontScale = 2;
			_backScale = 0.5;
			
			_selectedIndex = 0;
			
			_rotation = 0;
			
			_easingFunction = mx.effects.easing.Exponential.easeIn; 
			
			_duration = 500;
			
			this.horizontalScrollPolicy = "off";
			this.verticalScrollPolicy = "off";
		}
		
		[Bindable]
		public function get itemZoom():Boolean
		{
			return _itemZoom;
		}

		public function set itemZoom(value:Boolean):void
		{
			_itemZoom = value;
		}

		override protected function createChildren():void
		{
			super.createChildren();
		}
		
		private var _renderedData:ArrayCollection;
		override protected function commitProperties():void
		{
			super.commitProperties();
			
			if(_pendingData || _rendererChanged)
			{
				//if data / renderer / number of items changed
				_pendingData = false;
				_rendererChanged = false;
				
				if (_selectedItem == null)_selectedItem = _dataprovider.getItemAt(_selectedIndex);
				
				this.removeAllChildren();
				
				_renderedData = new ArrayCollection();
				_renderers = new ArrayCollection();
				
				//set up sort on array to sort by z for child index positioning
				var numericSort:Sort = new Sort();
				var sortField:SortField = new SortField();
				sortField.numeric = true;
				sortField.name = "z";
				numericSort.fields = [sortField];
				
				_renderers.sort = numericSort;
				
				var currentVO:CarouselVO;
				
				//build rendered list
				_maxItems = _maxItems == 0 ?  _dataprovider.length : _maxItems;
				
				for (var i:int = 0; i < _maxItems; i++)
				{
					_renderedData.addItem(_dataprovider.getItemAt(i));
				}
				
				//angle of each slice
				var sliceAngle:Number = 360/_renderedData.length;
				var currentOffset:Number = 0;
				
				//loop through items in data creating a new VO for each one
				for each (var currentItem:Object in _renderedData)
				{
					var currentRenderer:IDataRenderer = _itemRenderer.newInstance();
					var currentSprite:Sprite = currentRenderer as Sprite;
					currentRenderer.data = currentItem;
					currentSprite.addEventListener(MouseEvent.MOUSE_DOWN,itemClicked);
					currentSprite.buttonMode = true;
					
					currentVO = new CarouselVO();
					currentVO.renderer = currentRenderer;
					currentVO.data = currentItem;
					currentVO.angleOffset = currentOffset;
					
					if(currentItem == _selectedItem)_selectedVO = currentVO;
					
					_renderers.addItem(currentVO);
					//add renderers
					this.addChild(currentRenderer as DisplayObject);
					
					//keep track of current angle
					currentOffset += sliceAngle;
					
				}
			} else if(_selectedItemChange) {
				//change selected item
				for each (currentVO in _renderers)
				{
					if(currentVO.data == _selectedItem)_selectedVO = currentVO;
				}
			}
			
			if(_selectedVO && _selectedVO.angleOffset != rotation)
			{
				//rotate to selected item with a tween			
				var targetRotation:int = -_selectedVO.angleOffset;
				
				//make sure we are rotating the shortest distance
				if(targetRotation - rotation > 180)targetRotation -= 360;
				if(rotation - targetRotation > 180)targetRotation += 360;
				
				//stop and current tweens
				if(_rotationTween)_rotationTween.stop();
				
				_tweenPlaying = true;
				
				_rotationTween = new Tween(this,rotation,targetRotation,duration);
				_rotationTween.easingFunction = easingFunction;
				
			}
		}
		
		public function onTweenUpdate(value:Number):void
		{
			//update rotation
			rotation = value;
		}
		public function onTweenEnd(value:Number):void
		{
			onTweenUpdate(value);
			
			_tweenPlaying = false;
			
			if(rotation < -360)_rotation += 360;
			if(rotation > 0)_rotation -= 360;
		}
		
		override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void
		{
			super.updateDisplayList(unscaledWidth,unscaledHeight);
			
			if(!_itemZoom)
			{
				/* trace("updateDisplayList: " + _rotation + " _elevation: " + _elevation + 
				" unscaledWidth: " + unscaledWidth + " unscaledHeight: " + unscaledHeight + 
				" _itemWidth: " + _itemWidth + " _itemHeight: " + _itemHeight + 
				" _frontScale: " + _frontScale + " _backScale: " + _backScale); */
						
				var safeElevation:Number = ((_elevation*2 + (_itemHeight*frontScale)/2 + (_itemHeight*backScale)/2) > height) ? 
					(height - (_itemHeight*backScale)/2 - (_itemHeight*frontScale)/2)/2 :
					_elevation;
								
				var yZero:Number = (_itemHeight*_backScale)/2 + (height - ((_itemHeight*_backScale) + (_itemHeight*_frontScale))/2)/2;
				
				//if we do not have a zoomed image then update positions of all renderers
				for each (var currentVO:CarouselVO in _renderers)
				{
					currentVO.calculatePosition(_rotation,safeElevation,yZero,
						unscaledWidth,unscaledHeight,
						_itemWidth,_itemHeight,
						_frontScale,_backScale);
				}
				
				//refresh order of renderers (order by z)
				if(_renderers)
					_renderers.refresh();
				
				var currentIndex:int;
				for each (currentVO in _renderers)
				{
					//set child index to get depth right
					this.setChildIndex(currentVO.renderer as DisplayObject,currentIndex++);
				}
			}
		}
		
		private var moveEffect:Move;
		private var resizeEffect:Resize;
		
		private function zoomItem(expand:Boolean):void
		{
			//zooms image when clicked
			if(moveEffect)moveEffect.stop();
			if(resizeEffect)resizeEffect.stop();
			
			moveEffect = new Move(_selectedVO.renderer);
			moveEffect.duration = duration;
			moveEffect.easingFunction = easingFunction;
			moveEffect.xTo = _itemZoom ? _selectedVO.x - (_selectedVO.itemWidth/2) : 10;
			moveEffect.yTo = _itemZoom ? _selectedVO.y - (_selectedVO.itemHeight/2) : 10;
			moveEffect.play();
			
			resizeEffect = new Resize(_selectedVO.renderer);
			resizeEffect.duration = duration;
			resizeEffect.easingFunction = easingFunction;
			resizeEffect.widthTo = _itemZoom ? _selectedVO.itemWidth : this.width - 20;
			resizeEffect.heightTo = _itemZoom ? _selectedVO.itemHeight : this.height - 20;
			resizeEffect.play();
			
			if(!_itemZoom)
			{
				_itemZoom = true;
			} else {
				moveEffect.addEventListener(EffectEvent.EFFECT_END,onZoomFinished);
			}
			
		}
		
		private function onZoomFinished(e:Event):void
		{
			_itemZoom = false;
		}
		
		private function itemClicked(e:MouseEvent):void
		{
			var changeEvent:IndexChangeEvent = new IndexChangeEvent(IndexChangeEvent.CHANGE,true);
			changeEvent.oldIndex = selectedIndex;
			
			var indexApp:index = index(FlexGlobals.topLevelApplication);
			if(selectedItem != e.currentTarget.data)
			{
				selectedItem = e.currentTarget.data;
				indexApp.navList.selectedIndex = indexApp.currentIndex = selectedIndex;
			}else {
				indexApp.navList.selectedIndex = indexApp.currentIndex = changeEvent.newIndex = selectedIndex;
				indexApp.onItemClick(changeEvent);
			} /*else if(!_itemZoom){
				zoomItem(true);
			} else {
				zoomItem(false);
			}*/
		}
		
		public function next():void
		{
			var nextIndex:int = _selectedIndex == 0 ? _renderedData.length-1 : _selectedIndex-1;
			
			selectedIndex = nextIndex;
		}
		public function previous():void
		{
			var previousIndex:int = _selectedIndex == _renderedData.length-1 ? 0 : _selectedIndex+1;
			
			selectedIndex = previousIndex;
		}
		
		//#########################################
		//#
		//#		Setters / getters
		//#
		//#########################################
		
		
		private var _dataprovider:ArrayCollection;
		private var _pendingData:Boolean = false;
		public function set dataprovider(value:ArrayCollection):void
		{
			this._dataprovider = value;
			_pendingData = true;
			invalidateProperties();
			invalidateDisplayList();
		}
		[Bindable]
		public function get dataprovider():ArrayCollection
		{
			return _dataprovider;
		}
	    
		private var _maxItems:int;
	    public function set maxItems(value:int):void
	    {
	    	_maxItems = value;
			_pendingData = true;
			invalidateProperties();
			invalidateDisplayList();
	    }
	    [Bindable]
	    public function get maxItems():int
	    {
	    	return _maxItems;
	    }
		
		private var _itemRenderer:IFactory;
		private var _rendererChanged:Boolean = false;
    	[Inspectable(category="Data")]
	    public function get itemRenderer():IFactory
	    {
	        return _itemRenderer;
	    }
		
	    public function set itemRenderer(value:IFactory):void
	    {
	        _itemRenderer = value;
	
	        invalidateSize();
	        invalidateDisplayList();
	        
	        _rendererChanged = true;
	
	        dispatchEvent(new Event("itemRendererChanged"));
	    }
	    
		private var _rotation:Number;
	    override public function set rotation(value:Number):void
	    {	    	
	    	_rotation = value;
	    	
	    	invalidateDisplayList();
	    }
	    override public function get rotation():Number
	    {
	    	return _rotation;
	    }
	    
	    //Selected item / index
	    
		private var _selectedItem:Object;
		private var _selectedItemChange:Boolean = false;
	    public function set selectedItem(value:Object):void
	    {
	    	_selectedItem = value;
			if (_dataprovider)_selectedIndex = _dataprovider.getItemIndex(_selectedItem);
	    	
	    	_selectedItemChange = true;
	    	
	    	invalidateDisplayList();
	    	invalidateProperties();
	    }
	    public function get selectedItem():Object
	    {
	    	return _selectedItem;
	    }
	    
		private var _selectedIndex:int;
	    public function set selectedIndex(value:int):void
	    {
	    	_selectedIndex = value;
			if (_dataprovider)_selectedItem = _dataprovider.getItemAt(_selectedIndex);
	    	
	    	_selectedItemChange = true;
	    	
	    	invalidateDisplayList();
	    	invalidateProperties();
	    }
		[Bindable]
	    public function get selectedIndex():int
	    {
	    	return _selectedIndex;
	    }
		
		//item dimensions
		
		private var _itemWidth:int;
	    public function set itemWidth(value:int):void
	    {
	    	_itemWidth = value;
	    	
	    	invalidateDisplayList();
	    }
	    public function get itemWidth():int
	    {
	    	return _itemWidth;
	    }
	    
		private var _itemHeight:int;
	    public function set itemHeight(value:int):void
	    {
	    	_itemHeight = value;
	    	invalidateDisplayList();
	    }
	    public function get itemHeight():int
	    {
	    	return _itemHeight;
	    }
		
		//front to back scale
		
		private var _frontScale:Number;
	    public function set frontScale(value:Number):void
	    {
	    	_frontScale = value;
	    	
	    	invalidateDisplayList();
	    }
	    public function get frontScale():Number
	    {
	    	return _frontScale;
	    }
	    
		private var _backScale:Number;
	    public function set backScale(value:Number):void
	    {
	    	_backScale = value;
	    	invalidateDisplayList();
	    }
	    public function get backScale():Number
	    {
	    	return _backScale;
	    }
		
		// elevation
		
		private var _elevation:Number;
	    public function set elevation(value:Number):void
	    {
	    	_elevation = value;
	    	
	    	invalidateDisplayList();
	    }
	    public function get elevation():Number
	    {
	    	return _elevation;
	    }
	    
	    // easing function
	    
		private var _easingFunction:Function;
	    public function set easingFunction(value:Function):void
	    {
	    	_easingFunction = value;
	    }
	    public function get easingFunction():Function
	    {
	    	return _easingFunction;
	    }
	    
		private var _duration:int;
	    public function set duration(value:int):void
	    {
	    	_duration = value;
	    }
	    [Bindable]
	    public function get duration():int
	    {
	    	return _duration;
	    }
		
	}
}