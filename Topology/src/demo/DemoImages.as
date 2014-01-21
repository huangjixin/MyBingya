package demo{
	
	import flash.geom.Rectangle;
	import flash.utils.describeType;
	
	import mx.controls.DateChooser;
	
	import twaver.Consts;
	import twaver.Utils;
	import twaver.controls.GifImage;

	public class DemoImages{
	
 		[Embed(source="images/ps.gif", mimeType="application/octet-stream")]
		public static const ps:Class;	 

 		[Embed(source="images/swf/twaver.swf")]
		public static const swf_twaver:Class; 	
		[Embed(source="images/swf/servasoftware.swf")]
		public static const swf_servasoftware:Class;  
 
 		[Embed(source="images/svg/boy.svg")]
		public static const svg_boy:Class;    
 		[Embed(source="images/svg/girl.svg")]
		public static const svg_girl:Class;    		
 		[Embed(source="images/svg/internet.svg")]
		public static const svg_internet:Class;   
		[Embed(source="images/svg/computer.svg")]
		public static const svg_computer:Class; 
		[Embed(source="images/svg/iphone.svg")]
		public static const svg_iphone:Class;  	
 
		[Embed(source="images/twaverLogo.png")]
		public static const twaverLogo:Class;	
		[Embed(source="images/mainScreen.png")]
		public static const mainScreen:Class;
		[Embed(source="images/stretch.png")]
		public static const stretch:Class;
		[Embed(source="images/pin.gif")]
		public static const pin:Class;
		[Embed(source="images/show.png")]
		public static const show:Class;	
		[Embed(source="images/hide.png")]
		public static const hide:Class;		
		
		[Embed(source="images/element/link_flexional_icon.png")]
		public static const link_flexional_icon:Class;	
		[Embed(source="images/element/link_orthogonal_bottom_icon.png")]
		public static const link_orthogonal_bottom_icon:Class;	
		[Embed(source="images/element/link_orthogonal_control_point_icon.png")]
		public static const link_orthogonal_control_point_icon:Class;	
		[Embed(source="images/element/link_orthogonal_h_icon.png")]
		public static const link_orthogonal_h_icon:Class;	
		[Embed(source="images/element/link_orthogonal_h_v_icon.png")]
		public static const link_orthogonal_h_v_icon:Class;	
		[Embed(source="images/element/link_orthogonal_left_icon.png")]
		public static const link_orthogonal_left_icon:Class;	
		[Embed(source="images/element/link_orthogonal_right_icon.png")]
		public static const link_orthogonal_right_icon:Class;	
		[Embed(source="images/element/link_orthogonal_top_icon.png")]
		public static const link_orthogonal_top_icon:Class;	
		[Embed(source="images/element/link_orthogonal_v_h_icon.png")]
		public static const link_orthogonal_v_h_icon:Class;	
		[Embed(source="images/element/link_orthogonal_v_icon.png")]
		public static const link_orthogonal_v_icon:Class;			
		
		[Embed(source="images/file/fileClose.gif")]
		public static const fileClose:Class;		
		[Embed(source="images/file/fileLeaf.gif")]
		public static const fileLeaf:Class;	
		[Embed(source="images/file/fileOpen.gif")]
		public static const fileOpen:Class;	
		
		[Embed(source="images/category.png")]
		public static const category:Class;	
		[Embed(source="images/leaf.png")]
		public static const leaf:Class;	
		[Embed(source="images/refresh.png")]
		public static const refresh:Class;
		[Embed(source="images/copy.png")]
		public static const copy:Class;		

		[Embed(source="images/toolbar/select.png")]
		public static const select:Class;
		[Embed(source="images/toolbar/ascend.png")]
		public static const ascend:Class;
		[Embed(source="images/toolbar/descend.png")]
		public static const descend:Class;
		[Embed(source="images/toolbar/expand.png")]
		public static const expand:Class;
		[Embed(source="images/toolbar/collapse.png")]
		public static const collapse:Class;
		[Embed(source="images/toolbar/reset.png")]
		public static const reset:Class;	
		[Embed(source="images/toolbar/top.png")]
		public static const top:Class;
		[Embed(source="images/toolbar/up.png")]
		public static const up:Class;
		[Embed(source="images/toolbar/down.png")]
		public static const down:Class;		 
		[Embed(source="images/toolbar/bottom.png")]
		public static const bottom:Class;		

		[Embed(source="images/toolbar/zoomIn.png")]
		public static const zoomIn:Class;			
		[Embed(source="images/toolbar/zoomOut.png")]
		public static const zoomOut:Class;			
		[Embed(source="images/toolbar/zoomOverview.png")]
		public static const zoomOverview:Class;
		[Embed(source="images/toolbar/zoomReset.png")]
		public static const zoomReset:Class;
		[Embed(source="images/toolbar/magnify.png")]
		public static const magnify:Class;		
		[Embed(source="images/toolbar/print.png")]
		public static const print:Class;
		[Embed(source="images/toolbar/export.png")]
		public static const export:Class;		
		[Embed(source="images/toolbar/fullscreen.png")]
		public static const fullscreen:Class;
		[Embed(source="images/toolbar/open.png")]
		public static const open:Class;
		[Embed(source="images/toolbar/save.png")]
		public static const save:Class;		

		[Embed(source="images/element/routerIcon.png")]
		public static const routerIcon:Class;	
		[Embed(source="images/element/routerImage.png")]
		public static const routerImage:Class;		

		[Embed(source="images/element/dummy_icon.png")]
		public static const dummy_icon:Class;
		[Embed(source="images/element/link_icon.png")]
		public static const link_icon:Class;
		[Embed(source="images/element/node_icon.png")]
		public static const node_icon:Class;
		[Embed(source="images/element/node_image.png")]
		public static const node_image:Class;	
		[Embed(source="images/element/subnetwork_icon.png")]
		public static const subnetwork_icon:Class;		
		[Embed(source="images/element/subnetwork_image.png")]
		public static const subnetwork_image:Class;		
		[Embed(source="images/element/group_icon.png")]
		public static const group_icon:Class;		
		[Embed(source="images/element/group_image.png")]
		public static const group_image:Class;	
		[Embed(source="images/element/led_icon.png")]
		public static const led_icon:Class;		
		[Embed(source="images/element/port_icon.png")]
		public static const port_icon:Class;
		[Embed(source="images/element/port_image.png")]
		public static const port_image:Class;									
		[Embed(source="images/element/card_icon.png")]
		public static const card_icon:Class;		
		[Embed(source="images/element/shelf_icon.png")]
		public static const shelf_icon:Class;		
		[Embed(source="images/element/slot_icon.png")]
		public static const slot_icon:Class;				
		[Embed(source="images/element/rack_icon.png")]
		public static const rack_icon:Class;		
		[Embed(source="images/element/grid_icon.png")]
		public static const grid_icon:Class;		
		[Embed(source="images/element/shapenode_icon.png")]
		public static const shapenode_icon:Class;	
		[Embed(source="images/element/shapelink_icon.png")]
		public static const shapelink_icon:Class;				
		[Embed(source="images/element/bus_icon.png")]
		public static const bus_icon:Class;	
		[Embed(source="images/element/linksubnetwork_icon.png")]
		public static const linksubnetwork_icon:Class;	
		[Embed(source="images/element/shapesubnetwork_icon.png")]
		public static const shapesubnetwork_icon:Class;	

		[Embed(source="images/os/centos.png")]	
		public static const centos:Class;						
		[Embed(source="images/os/debian.png")]	
		public static const debian:Class;	
		[Embed(source="images/os/linux.png")]	
		public static const linux:Class;			
		[Embed(source="images/os/solaris.png")]	
		public static const solaris:Class;		

		[Embed(source="images/chassis/bolt.png")]	
		public static const bolt:Class;
		[Embed(source="images/chassis/chassis1.png")]	
		public static const chassis1:Class;	
		[Embed(source="images/chassis/chassis2.png")]	
		public static const chassis2:Class;	
		[Embed(source="images/chassis/chassis3.png")]	
		public static const chassis3:Class;	
		[Embed(source="images/chassis/chassis4.png")]	
		public static const chassis4:Class;			
		[Embed(source="images/chassis/chassis5.png")]	
		public static const chassis5:Class;	
		[Embed(source="images/chassis/chassis6.png")]	
		public static const chassis6:Class;	
		[Embed(source="images/chassis/chassis7.png")]	
		public static const chassis7:Class;	
		[Embed(source="images/chassis/chassis8.png")]	
		public static const chassis8:Class;					
		[Embed(source="images/chassis/chassis9.png")]	
		public static const chassis9:Class;			
		[Embed(source="images/chassis/chassis10.png")]	
		public static const chassis10:Class;

		[Embed(source="images/attachment/att1.png")]
		public static const att1:Class;	
		[Embed(source="images/attachment/att2.png")]
		public static const att2:Class;	
		[Embed(source="images/attachment/att3.png")]
		public static const att3:Class;	
		[Embed(source="images/attachment/att4.png")]
		public static const att4:Class;	
		[Embed(source="images/attachment/att5.png")]
		public static const att5:Class;							
		[Embed(source="images/attachment/att6.png")]
		public static const att6:Class;	
		[Embed(source="images/attachment/att7.png")]
		public static const att7:Class;	
		[Embed(source="images/attachment/att8.png")]
		public static const att8:Class;	
	
		[Embed(source="images/propagation/portDownImage.png")]			
		public static const portDownImage:Class;		
		[Embed(source="images/propagation/portUpImage.png")]			
		public static const portUpImage:Class;			
					
		[Embed(source="images/propagation/rackImage.png")]			
		public static const rackImage:Class;		
		[Embed(source="images/propagation/sunServer1.gif")]			
		public static const sunServer1:Class;		
		[Embed(source="images/propagation/sunServer2.gif")]			
		public static const sunServer2:Class;	
		[Embed(source="images/propagation/sunServer3.gif")]			
		public static const sunServer3:Class;	
		[Embed(source="images/propagation/sunServer4.gif")]			
		public static const sunServer4:Class;	
					
		[Embed(source="images/statistics/center.png")]			
		public static const statistics_center:Class;				
		[Embed(source="images/statistics/gather.png")]			
		public static const statistics_gather:Class;		
		[Embed(source="images/statistics/server.png")]			
		public static const statistics_server:Class;		
		[Embed(source="images/statistics/wanjet.png")]			
		public static const statistics_wanjet:Class;
		[Embed(source="images/statistics/wanjet2.png")]			
		public static const statistics_wanjet2:Class;		
	
		[Embed(source="images/successstory/story0.png")]
		public static const story0:Class;		 
		[Embed(source="images/successstory/story1.png")]
		public static const story1:Class;
		[Embed(source="images/successstory/story2.png")]
		public static const story2:Class;
		[Embed(source="images/successstory/story3.png")]
		public static const story3:Class;
		[Embed(source="images/successstory/story4.png")]
		public static const story4:Class;
		[Embed(source="images/successstory/story5.png")]
		public static const story5:Class;								 
		[Embed(source="images/successstory/story6.png")]
		public static const story6:Class;
		[Embed(source="images/successstory/story7.png")]
		public static const story7:Class;
		[Embed(source="images/successstory/story8.png")]
		public static const story8:Class;
		[Embed(source="images/successstory/story9.png")]
		public static const story9:Class;				
		[Embed(source="images/successstory/story10.png")]
		public static const story10:Class;		 
		[Embed(source="images/successstory/story11.png")]
		public static const story11:Class;
		[Embed(source="images/successstory/story12.png")]
		public static const story12:Class;
		[Embed(source="images/successstory/story13.png")]
		public static const story13:Class;
		[Embed(source="images/successstory/story14.png")]
		public static const story14:Class;
		[Embed(source="images/successstory/story15.png")]
		public static const story15:Class;								 
		[Embed(source="images/successstory/story16.png")]
		public static const story16:Class;
		[Embed(source="images/successstory/story17.png")]
		public static const story17:Class;
		[Embed(source="images/successstory/story18.png")]
		public static const story18:Class;
		[Embed(source="images/successstory/story19.png")]
		public static const story19:Class;													
		[Embed(source="images/successstory/story20.png")]
		public static const story20:Class;		 
		[Embed(source="images/successstory/story21.png")]
		public static const story21:Class;
		[Embed(source="images/successstory/story22.png")]
		public static const story22:Class;
		[Embed(source="images/successstory/story23.png")]
		public static const story23:Class;
		[Embed(source="images/successstory/story24.png")]
		public static const story24:Class;
		[Embed(source="images/successstory/story25.png")]
		public static const story25:Class;								 
		[Embed(source="images/successstory/story26.png")]
		public static const story26:Class;
		[Embed(source="images/successstory/story27.png")]
		public static const story27:Class;
		[Embed(source="images/successstory/story28.png")]
		public static const story28:Class;
		[Embed(source="images/successstory/story29.png")]
		public static const story29:Class;													
		[Embed(source="images/successstory/story30.png")]
		public static const story30:Class;		 
		[Embed(source="images/successstory/story31.png")]
		public static const story31:Class;
		[Embed(source="images/successstory/story32.png")]
		public static const story32:Class;
		[Embed(source="images/successstory/story33.png")]
		public static const story33:Class;
		[Embed(source="images/successstory/story34.png")]
		public static const story34:Class;
		[Embed(source="images/successstory/story35.png")]
		public static const story35:Class;								 
		[Embed(source="images/successstory/story36.png")]
		public static const story36:Class;
		[Embed(source="images/successstory/story37.png")]
		public static const story37:Class;
		[Embed(source="images/successstory/story38.png")]
		public static const story38:Class;
		[Embed(source="images/successstory/story39.png")]
		public static const story39:Class;			
		[Embed(source="images/successstory/story40.png")]
		public static const story40:Class;		 
		[Embed(source="images/successstory/story41.png")]
		public static const story41:Class;
		[Embed(source="images/successstory/story42.png")]
		public static const story42:Class;
		[Embed(source="images/successstory/story43.png")]
		public static const story43:Class;
		[Embed(source="images/successstory/story44.png")]
		public static const story44:Class;
		[Embed(source="images/successstory/story45.png")]
		public static const story45:Class;								 
		[Embed(source="images/successstory/story46.png")]
		public static const story46:Class;
		[Embed(source="images/successstory/story47.png")]
		public static const story47:Class;
		[Embed(source="images/successstory/story48.png")]
		public static const story48:Class;
		[Embed(source="images/successstory/story49.png")]
		public static const story49:Class;				
		[Embed(source="images/successstory/story50.png")]
		public static const story50:Class;		 
		[Embed(source="images/successstory/story51.png")]
		public static const story51:Class;
		[Embed(source="images/successstory/story52.png")]
		public static const story52:Class;
		[Embed(source="images/successstory/story53.png")]
		public static const story53:Class;
		[Embed(source="images/successstory/story54.png")]
		public static const story54:Class;
		[Embed(source="images/successstory/story55.png")]
		public static const story55:Class;								 
		[Embed(source="images/successstory/story56.png")]
		public static const story56:Class;
		[Embed(source="images/successstory/story57.png")]
		public static const story57:Class;
		[Embed(source="images/successstory/story58.png")]
		public static const story58:Class;
		[Embed(source="images/successstory/story59.png")]
		public static const story59:Class;													
		[Embed(source="images/successstory/story60.png")]
		public static const story60:Class;		 
		[Embed(source="images/successstory/story61.png")]
		public static const story61:Class;
		[Embed(source="images/successstory/story62.png")]
		public static const story62:Class;
		[Embed(source="images/successstory/story63.png")]
		public static const story63:Class;
		[Embed(source="images/successstory/story64.png")]
		public static const story64:Class;
		[Embed(source="images/successstory/story65.png")]
		public static const story65:Class;								 
		[Embed(source="images/successstory/story66.png")]
		public static const story66:Class;
		[Embed(source="images/successstory/story67.png")]
		public static const story67:Class;
		[Embed(source="images/successstory/story68.png")]
		public static const story68:Class;
		[Embed(source="images/successstory/story69.png")]
		public static const story69:Class;													
		[Embed(source="images/successstory/story70.png")]
		public static const story70:Class;		 
		[Embed(source="images/successstory/story71.png")]
		public static const story71:Class;
		[Embed(source="images/successstory/story72.png")]
		public static const story72:Class;
		[Embed(source="images/successstory/story73.png")]
		public static const story73:Class;
		[Embed(source="images/successstory/story74.png")]
		public static const story74:Class;
		[Embed(source="images/successstory/story75.png")]
		public static const story75:Class;								 
		[Embed(source="images/successstory/story76.png")]
		public static const story76:Class;
		[Embed(source="images/successstory/story77.png")]
		public static const story77:Class;
		[Embed(source="images/successstory/story78.png")]
		public static const story78:Class;
		[Embed(source="images/successstory/story79.png")]
		public static const story79:Class;		
			
		[Embed(source="images/pstn/tw130.png")]
		public static const tw130Icon:Class;
		[Embed(source="images/pstn/cloud.png")]
		public static const cloudIcon:Class;			
		[Embed(source="images/pstn/router.png")]
		public static const routerIcon2:Class;			
		[Embed(source="images/pstn/satellite_antenna.png")]
		public static const satellite_antennaIcon:Class;			
		[Embed(source="images/pstn/antenna.png")]
		public static const antennaIcon:Class;			
		[Embed(source="images/pstn/msc.png")]
		public static const mscIcon:Class;			
		[Embed(source="images/pstn/cartridge_system.png")]
		public static const cartridge_systemIcon:Class;			
		[Embed(source="images/pstn/wdm.png")]
		public static const wdmIcon:Class;			
		[Embed(source="images/pstn/testing.png")]
		public static const testingIcon:Class;			
		[Embed(source="images/pstn/mainframe.png")]
		public static const mainframeIcon:Class;
		[Embed(source="images/pstn/modem.png")]
		public static const modemIcon:Class;
		[Embed(source="images/pstn/router2.png")]
		public static const router2Icon:Class;
		[Embed(source="images/pstn/terminal.png")]
		public static const terminalIcon:Class;
		[Embed(source="images/pstn/phone.png")]
		public static const phoneIcon:Class;
		
		[Embed(source="images/pipe/PipeHole.png")]
		public static const PipeHole:Class;
		[Embed(source="images/pipe/RoundPipe.png")]
		public static const RoundPipe:Class;
		[Embed(source="images/pipe/SquarePipe.png")]
		public static const SquarePipe:Class;
													
		public static function init():void{
			var classInfo:XML = describeType(DemoImages);
			for each (var c:XML in classInfo..constant){
				var name:String = c.@name;
				Utils.registerImageByClass(name, DemoImages[name]);
			}		
			Utils.registerImageByClass("ps", GifImage, true, null, [ps]);				
			Utils.registerImageByClass("dateChooser", DateChooser, true, new Rectangle(0, 0, 280, 160));		
			Utils.registerImageByClass("swf_servasoftware", swf_servasoftware, true);	
			Utils.registerImageByClass("swf_twaver", swf_twaver, false, new Rectangle(-351, -126, 970, 273));			
			Utils.registerImageByClass("svg_girl", svg_girl, true);
		}

	}
}