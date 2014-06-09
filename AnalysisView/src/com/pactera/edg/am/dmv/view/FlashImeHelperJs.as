package com.pactera.edg.am.dmv.view
{
	public class FlashImeHelperJs
	{
		   	////////////////////////////////////////////////////////
		//zzg 2011-12-21 增加
		//通过客户端js逻辑配合，修复透明flash引起的中文输入bug
		//目前，已经能输入中文，并能回车、退格删除，基本可满足输入框文字输入要求。 
		public static const initFlashImeBugJs : XML = 
		    <script><![CDATA[
				function installFih(flashObjectId)
				{
							// create unique namespace
							//flash输入法(IME)辅助类(Helper)
							//fih:Flash Ime Helper
							if(typeof fih == "undefined" || !fih)	
							{
								fih = {};
							}	
							fih.init=function(){
				                var inputCtlObj=document.getElementById(this.inputCtrlId);
								if(typeof inputCtlObj == "undefined" || !inputCtlObj)	
							    {   
									var input =document.createElement("<input type='text' id='"+this.inputCtrlId+"' value='' onkeyDown='fih.onFlashInputHelperKeyDown(event)' style='width:0;height:0'>");
						            document.body.appendChild(input);
							    }
							}
							fih.timeoutId=0;
							fih.inputCtrlId="flashInputHelper";
							fih.FlashObjectID=flashObjectId;
						    fih.setFlashInputHelperFocus=function (){
						       document.getElementById(this.inputCtrlId).focus();
							    //先清除定时器
								if (this.timeoutId != 0) {
									try{
										clearTimeout(this.timeoutId);
										this.timeoutId = 0;
									}catch(err){}
								}
							   this.timeoutId=setTimeout("fih.onFlashInputHelperChange()", 100);
						    }
						    fih.onFlashInputHelperChange=function (){
						    	//customRightClick
						    	var flashObj=document.getElementById(this.FlashObjectID);
						    	var inputCtlObj=document.getElementById(this.inputCtrlId);
								if(flashObj.flashInputHelperValueChange!=null){
							       flashObj.flashInputHelperValueChange(inputCtlObj.value);
								   inputCtlObj.value="";//清空
								}
							    this.timeoutId=setTimeout("fih.onFlashInputHelperChange()", 100);
						    }
						
						   fih.onFlashInputHelperKeyDown=function (e){
									var keynum;
								    if(window.event){//IE
								       keynum = e.keyCode
									}else if(e.which) // Netscape/Firefox/Opera
									{
									   keynum = e.which
									}
									if(keynum==8||keynum==13)//
									{//Backspace(8) or Enter(13)
								        //alert(keynum);
								        var flashObj=document.getElementById(this.FlashObjectID);
								        var inputCtlObj=document.getElementById(this.inputCtrlId);
										if(flashObj.flashInputHelperValueChange!=null){
										   flashObj.flashInputHelperValueChange("key_down_"+keynum);
										  // alert(keynum);
										   inputCtlObj.value="";//清空
										}
									}
								}
								fih.init();
				}
			]]></script>;

	}
}