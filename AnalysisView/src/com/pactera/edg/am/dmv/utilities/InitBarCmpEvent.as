package com.pactera.edg.am.dmv.utilities
{
	import flash.events.Event;

/*
 *自定义事件,
 ×用于调整进度条初始化完成事件
 */
	public class InitBarCmpEvent extends Event
	{
	    public function InitBarCmpEvent()
        {
              super("InitBarComplete");
        }
	}
}