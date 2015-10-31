var newcap = {};
newcap.namespace = function(str){
	var arr = str.split('.'),o=newcap;
	for(i=(arr[0]=='newcap') ? 1 : 0; i<arr.length; i++){		
		o[arr[i]] = o[arr[i]] || {};
		o = o[arr[i]];
	}
}
newcap.namespace('page');

var timeOut;
var $navTarget;
var $contentTarget;

newcap.page.naviMenu = function(){
	
	var indexli;
	$('#menu .nav li[is="newcapecmenu"]').hover(function(){

		indexli = $(this).index();

		$navTarget = $(this).find('a:eq(0)');
		$contentTarget = $(this).find('.menudiv');
		var verticalLineHeight = $(this).find('.menudiv').height();
		var PaddingTarget = parseInt($(this).find('div.clearfix').css("padding-bottom"))+parseInt($(this).find('div.menu_content').css("padding-top"));
		if($(this).find('div.menudivbottom').css("display") == "none"){
			
			var verticalLineHeight = $(this).find('.menudiv').height()-PaddingTarget-7;

		}else if($(this).find('div.menudivbottom > div').height() == 1){
			
			var verticalLineHeight = $(this).find('.menudiv').height()-40;
			
		}else{
			
			var verticalLineHeight = $(this).find('.menudiv').height()-PaddingTarget-5;
			
		}
		
		$(this).find('.menuline').each(function(){
			$verticalLineTarget = $(this);
			$verticalLineTarget.height(verticalLineHeight)
		})
		timeout = setTimeout(function(){
			$navTarget .addClass('hover');
			$contentTarget.slideDown(300);
		}, 100);
		
				
	},function(){
		//alert("hidden")
		clearTimeout(timeout);
		$('#menu .nav li .menudiv').stop(true,true);
		$('.menudiv div.menustyle').stop(true,true);
		//$(this).find('div.downarrow').hide();
		$(this).find('a:eq(0)').removeClass('hover');//+indexli);
		$(this).find('.menudiv').hide();
	})
}

function iPx(){
    if ((navigator.userAgent.match(/iPhone/i)) || (navigator.userAgent.match(/iPod/i)) || (navigator.userAgent.match(/iPad/i))) 
        return true;
    return false;
}
var parameter;
newcap.page.onLoad = function(){
			
	newcap.page.naviMenu();
	var l = window.location.href;
	
}

$(function(){	
	newcap.page.onLoad();	
});


(
 function(B)
  {
	 B.tools=B.tools||{version:"1.2.5"};
	 B.tools.scrollable=
	 {
		 conf:
		  {
			 activeClass:"p-active",
			 circular:false,
			 clonedClass:"cloned",
			 disabledClass:"p-disabled",
			 easing:"swing",
			 initialIndex:0,
			 item:null,
			 items:".p-home-banner",
			 keyboard:true,
			 mousewheel:false,
			 next:".p-top-qh-next",
			 prev:".p-top-qh-prev",
			 speed:400,
			 vertical:false,
			 touch:true,
			 wheelSpeed:0
			}
		};
      function D(I,G)
	   {
		  var F=parseInt(I.css(G),10);
		  if(F)
		  {return F}
		  var H=I[0].currentStyle;
		  return H&&H.width&&parseInt(H.width,10)
		}
		function E(F,H){var G=B(H);return G.length<2?G:F.parent().find(H)}
		var C;
		function A(P,O)
		{
			var H=navigator.platform.match(/iPad/i)!=null;
			var R=0;
			var Q=this,G=P.add(Q),F=P.children(),N=0,J=O.vertical;
			if(!C){C=Q}
			if(F.length>1)
			{F=B(O.items,P)}
			B.extend
			(
			  Q,
			  {
				 getConf:function(){return O},
				 getIndex:function(){return N},
				 getSize:function(){return Q.getItems().size()},
				 getNaviButtons:function(){return I.add(K)},
				 getRoot:function(){return P},
				 getItemWrap:function(){return F},
				 getItems:function(){return F.children(O.item).not("."+O.clonedClass)},
				 move:function(T,S){return Q.seekTo(N+T,S)},
				 next:function(S){if(!H){if(R>=100){return }}return Q.move(1,S)},
				 prev:function(S){return Q.move(-1,S)},
				 begin:function(S){return Q.seekTo(0,S)},
				 end:function(S){return Q.seekTo(Q.getSize()-1,S)},
				 focus:function(){C=Q;return Q},
				 addItem:function(S)
				 {
					 S=B(S);
				     if(!O.circular){F.append(S)}
				     else
				     {
					 F.children("."+O.clonedClass+":last").before(S);
                     F.children("."+O.clonedClass+":first").replaceWith(S.clone().addClass(O.clonedClass))
				     }
				    G.trigger("onAddItem",[S]);return Q
				  },
				 seekTo:function(T,Y,V)
				 {
					 if(!H)
					 {
						 if(R>=100){api.stop()}
					   }
					 if(!T.jquery){T*=1}
					 if(O.circular&&T===0&&N==-1&&Y!==0){return Q}
					 if(!O.circular&&T<0||T>Q.getSize()||T<-1){return Q}
					 var W=T;
					 if(T.jquery)
					 {T=Q.getItems().index(T)}
					 else{W=Q.getItems().eq(T)}
					 var X=B.Event("onBeforeSeek");
					 if(!V)
					 {
						 var Z=Q.getRoot().parent().attr("id");
						 if(Z&&Z=="p-top-main")
						 {
							 var S=3300;
							 if(Q.getIndex()=="0")
							 {
								 B("#p-banner-1.p-selected-view h1").animate({left:"-"+S+"px"},{queue:false,duration:1800})
                              }
							 if(Q.getIndex()=="1")
							 {
								 B("#p-banner-2.p-selected-view h2").animate({left:"-"+S+"px"},{queue:false,duration:1800})
							  }
							 if(Q.getIndex()=="2"){B("#p-banner-3.p-selected-view h2").animate({left:"-"+S+"px"},{queue:false,duration:1800})}
						 }
						 G.trigger(X,[T,Y]);
						 if(X.isDefaultPrevented()||!W.length){return Q}
					  }
					 var U=J?{top:-W.position().top}:{left:-W.position().left};
					 B("#p-top-banner .p-banner1-1-1 h1,#p-top-banner .p-banner1-1-1 h2").css("left","0px");

					 N=T;
					 W.siblings().removeClass("p-selected-view");
                     W.addClass("p-selected-view");
					 if(jQuery(".p-alternate.p-selected-view").length)
					  {jQuery("#p-news-feed-inner").addClass("p-alternate")}
					 else{jQuery("#p-news-feed-inner").removeClass("p-alternate")}
					 C=Q;
					 if(Y===undefined)
					 {Y=O.speed}
					 F.animate
					 (
					   U,Y,O.easing,
					   V||function()
					   {
						  G.trigger("onSeek",[T]);
						  B("#p-top-banner .p-banner1-1-1 h1,#p-top-banner .p-banner1-1-1 h2").css("left","0px");
						  if(!H)
						  {
							  if(R>=100)
							  {api.stop();return }
							}
						 }
					   );
					 return Q
				  }
				}
			   );
			  B.each
			   (
				["onBeforeSeek","onSeek","onAddItem"],
				function(T,S)
				 {
					if(B.isFunction(O[S]))
					{
						B(Q).bind(S,O[S])
                      }
					 Q[S]=function(U)
					 {
						 if(U){B(Q).bind(S,U)}
						 return Q
					  }
					}
				  );
			   if(O.circular)
			   {
				   var M=Q.getItems().slice(-1).clone().prependTo(F),L=Q.getItems().eq(1).clone().appendTo(F);
				   M.add(L).addClass(O.clonedClass);
				   Q.onBeforeSeek
				   (
					function(U,S,T)
					 {
						 if(U.isDefaultPrevented()){return }
						 if(S==-1)
						 {
							 Q.seekTo(M,T,function(){Q.end(0)});
							 return U.preventDefault()
						  }
						 else
						  {
							  if(S==Q.getSize())
							  {
								  Q.seekTo(L,T,function(){R++;Q.begin(0)})
							   }
						   }
						}
					 );
				   Q.seekTo(0,0,function(){})
				 }
				 var I=E(P,O.prev).click(function(){Q.prev()}),
				 K=E(P,O.next).click(function(){Q.next()});
				 if(!O.circular&&Q.getSize()>1)
				  {
					 Q.onBeforeSeek
					 (
					   function(T,S)
					    {
							setTimeout
							(
							  function()
							   {
								 if(!T.isDefaultPrevented())
								  {
									  I.toggleClass(O.disabledClass,S<=0);
									  K.toggleClass(O.disabledClass,S>=Q.getSize()-3)
									}
								  },1
								 )
							}
						  );
					  if(!O.initialIndex)
					  {I.addClass(O.disabledClass)}
					 }
					if(O.mousewheel&&B.fn.mousewheel)
					 {
						 P.mousewheel
						 (
						   function(S,T)
						    {
								if(O.mousewheel)
								 {
									 Q.move(T<0?1:-1,O.wheelSpeed||50);
									 return false
								  }
							 }
							)
						 }
					 if(O.keyboard)
					  {
						  B(document).bind
						   (
							 "keydown.scrollable",
							 function(S)
							  {
								 if(!O.keyboard||S.altKey||S.ctrlKey||B(S.target).is(":input"))
								  {return }
								  if(O.keyboard!="static"&&C!=Q){return }
								  var T=S.keyCode;
								  if(J&&(T==38||T==40))
								   {
									   Q.move(T==38?-1:1);
									   return S.preventDefault()
									 }
								  if(!J&&(T==37||T==39))
								   {
									   Q.move(T==37?-1:1);
									   return S.preventDefault()
									 }
								}
							   )
						  }
					 if(O.initialIndex)
					  {
						Q.seekTo(O.initialIndex,0,function(){})
					   }
		  }
		  
		  B.fn.scrollable=function(F)
		   {
			   var G=this.data("scrollable");
			   if(G){return G}
			   F=B.extend({},B.tools.scrollable.conf,F);
			   this.each
			    (
				 function()
				  {
					  G=new A(B(this),F);
					  B(this).data("scrollable",G)
				   }
				 );
				return F.api?G:this
			 }
	}
 )
(jQuery);


(function(B){var A=B.tools.scrollable;
A.autoscroll={conf:{autoplay:true,interval:3000,autopause:true}};B.fn.autoscroll=function(D){if(typeof D=="number"){D={interval:D}}var E=B.extend({},A.autoscroll.conf,D),C;this.each(function(){var F=B(this).data("scrollable");if(F){C=F}var H,G=true;F.play=function(){if(H){return }G=false;H=setInterval(function(){F.next()},E.interval)};F.pause=function(){H=clearInterval(H)};F.stop=function(){F.pause();G=true};if(E.autopause){F.getRoot().add(F.getNaviButtons()).hover(F.pause,F.play)}if(E.autoplay){F.play()
}});return E.api?C:this}})(jQuery);

(function(B){var A=B.tools.scrollable;A.navigator={conf:{navi:".p-top-qh-nav",naviItem:null,activeClass:"p-active",indexed:false,idPrefix:null,history:false}};function C(D,F){var E=B(F);return E.length<2?E:D.parent().find(F)
}B.fn.navigator=function(E){if(typeof E=="string"){E={navi:E}}E=B.extend({},A.navigator.conf,E);var D;this.each(function(){var G=B(this).data("scrollable"),K=E.navi.jquery?E.navi:C(G.getRoot(),E.navi),J=G.getNaviButtons(),N=E.activeClass,H=E.history&&B.fn.history;if(G){D=G}G.getNaviButtons=function(){return J.add(K)};function M(P,O,Q){if(B(P).hasClass("p-active")||B("#p-top-banner .p-bannerqh").is(":animated")){return false}G.seekTo(O);if(H){if(location.hash){location.hash=P.attr("href").replace("#","")
}}else{return Q.preventDefault()}}function F(){return K.find(E.naviItem||"> *")}function L(O){var Q=O+1;var P=B("<"+(E.naviItem||"a")+"/>").click(function(R){M(B(this),O,R)}).attr({href:"#"+O,onclick:"bannerqh.event({'pEV' : 'track', 'pEvAction' : 'plink', 'pEvLinktitle' : 'ls"+Q+"', 'pEvSection' : 'ls"+Q+"'});"}).mouseenter(function(){bannerqh.event({pEV:"track",pEvAction:"phover",pEvLinktitle:"ls"+Q,pEvSection:"ls"+Q})});if(O===0){P.addClass(N)}if(E.indexed){P.text(O+1)}if(E.idPrefix){P.attr("id",E.idPrefix+O)
}return P.appendTo(K)}if(F().length){F().each(function(O){B(this).click(function(P){M(B(this),O,P)})})}else{B.each(G.getItems(),function(O){L(O)})}G.onBeforeSeek(function(P,O){setTimeout(function(){if(!P.isDefaultPrevented()){var Q=F().eq(O);if(!P.isDefaultPrevented()&&Q.length){F().removeClass(N).eq(O).addClass(N)}}},1)});function I(O,Q){var P=F().eq(Q.replace("#",""));if(!P.length){P=F().filter("[href="+Q+"]")}P.click()}G.onAddItem(function(P,O){O=L(G.getItems().index(O));if(H){O.history(I)}});
if(H){F().history(I)}});return E.api?D:this}})(jQuery);(function(C){var A=function(D,E){this.target=C(D);this.touch=E;this.startX=this.currentX=E.screenX;this.startY=this.currentY=E.screenY;this.eventType=null};A.latestTap=null;A.prototype.move=function(D){this.currentX=D.screenX;this.currentY=D.screenY};A.prototype.process=function(){var D=this.currentX-this.startX;var E=this.currentY-this.startY;if(D==0&&E==0){this.checkForDoubleTap()}else{if(Math.abs(E)>Math.abs(D)){this.eventType=E>0?"swipedown":"swipeup";
this.target.trigger("swipe",[this])}else{this.eventType=D>0?"swiperight":"swipeleft";this.target.trigger("swipe",[this])}}this.target.trigger(this.eventType,[this]);this.target.trigger("touch",[this])};A.prototype.checkForDoubleTap=function(){if(A.latestTap){if((new Date()-A.latestTap)<400){this.eventType="doubletap"}}if(!this.eventType){this.eventType="tap"}A.latestTap=new Date()};var B=function(D){D.bind("touchstart",this.touchStart);D.bind("touchmove",this.touchMove);D.bind("touchcancel",this.touchCancel);
D.bind("touchend",this.touchEnd)};B.prototype.touchStart=function(D){var E=this;B.eachTouch(D,function(F){B.touches[F.identifier]=new A(E,F)})};B.prototype.touchMove=function(D){B.eachTouch(D,function(F){var E=B.touches[F.identifier];if(E){E.move(F)}})};B.prototype.touchCancel=function(D){B.eachTouch(D,function(E){B.purge(E,true)})};B.prototype.touchEnd=function(D){B.eachTouch(D,function(E){B.purge(E)})};B.touches={};B.purge=function(F,D){if(!D){var E=B.touches[F.identifier];if(E){E.process()}}delete B.touches[F.identifier]
};B.eachTouch=function(D,G){var D=D.originalEvent;var E=D.changedTouches.length;for(var F=0;F<E;F++){G(D.changedTouches[F])}};C.fn.addSwipeEvents=function(D){new B(this);if(D){this.bind("touch",D)}return this}})(jQuery);jQuery.fn.handleSwipes=function(){return this.each(function(){var A=jQuery(this).data("scrollable");A.getRoot().addSwipeEvents().bind("swipeleft",function(){A.next()}).bind("swiperight",function(){A.prev()})})};

pHPSetupFunction=function(){

	jQuery("#p-top-banner .p-home-banner").css("cursor","pointer");

	jQuery("#p-top-banner .p-home-banner").click(function(M){
		window.location=jQuery(this).find("a").attr("href")
	});
	
	jQuery("#p-top-banner .p-bannerqh").css("width","20000em");
	
	jQuery.easing.custom=function(N,O,M,Q,P){
		if(O==0){return M}
		if(O==P){return M+Q}
		if((O/=P/2)<1){return Q/2*Math.pow(2,8*(O-1))+M}
		return Q/2*(-Math.pow(2,-10*--O)+2)+M
	};
	
	jQuery("#p-top-banner .p-top-qh-pane,#p-top-banner .p-top-qh-pane .p-home-banner").width(jQuery("#p-top-banner").width());

	var L=navigator.platform.match(/iPad/i)!=null;

	if(L){
		var K=jQuery("#p-top-banner .p-top-qh-pane").scrollable({easing:"custom",speed:2000,circular:true}).navigator().handleSwipes()
	}else{
		var K=jQuery("#p-top-banner .p-top-qh-pane").scrollable({easing:"custom",speed:2000,circular:true}).navigator().autoscroll({interval:7500})
	}
	
	window.api=K.data("scrollable");

	jQuery(".p-top-qh-nav a").append('<div class="p-top-qh-view"><div class="p-banner-small-alt"></div></div>');
	
	var E=jQuery("#p-top-main #p-banner-1 img:first").attr("alt");
	var H=jQuery("#p-banner-1 p em:first").clone();
	
	jQuery("span",H).remove();
	
	jQuery(".p-top-qh-nav a:nth-child(1) .p-top-qh-view").addClass("p-banner-small-1").children("div.p-banner-small-alt").prepend('<span class="p-banner-small-1"></span><h2>'+E+"</h2><p>"+H.text()+"</p>");
	
	var C=jQuery("#p-top-main #p-banner-2 img:first").attr("alt");
	var G=jQuery("#p-banner-2 p em:first").clone();
	
	jQuery("span",G).remove();
	jQuery(".p-top-qh-nav a:nth-child(2) .p-top-qh-view").addClass("p-banner-small-2").children("div.p-banner-small-alt").prepend('<span class="p-banner-small-2"></span><h2>'+C+"</h2><p>"+G.text()+"</p>");
	
	var B=jQuery("#p-top-main #p-banner-3 img:first").attr("alt");
	var D=jQuery("#p-banner-3 p em:first").clone();

	jQuery("span",D).remove();
	jQuery(".p-top-qh-nav a:nth-child(3) .p-top-qh-view").addClass("p-banner-small-3").children("div.p-banner-small-alt").prepend('<span class="p-banner-small-3"></span><h2>'+B+"</h2><p>"+D.text()+"</p>");
	
	if(jQuery.browser.msie){
		
		jQuery(".p-top-qh-nav a:nth-child(1)").mouseenter(function(){
			jQuery(this).children().children("div.p-banner-small-alt").css("display","block")
		}).mouseleave(function(){
			jQuery(this).children().children("div.p-banner-small-alt").css("display","none")
		});
		
		jQuery(".p-top-qh-nav a:nth-child(2)").mouseenter(function(){
			jQuery(this).children().children("div.p-banner-small-alt").css("display","block")
		}).mouseleave(function(){
			jQuery(this).children().children("div.p-banner-small-alt").css("display","none")
		});
		
		jQuery(".p-top-qh-nav a:nth-child(3)").mouseenter(function(){
			jQuery(this).children().children("div.p-banner-small-alt").css("display","block")
		}).mouseleave(function(){
			jQuery(this).children().children("div.p-banner-small-alt").css("display","none")
		})
		
	}else{
		
		jQuery(".p-top-qh-nav a:nth-child(1)").mouseenter(function(){
			jQuery(this).children().children("div.p-banner-small-alt").stop(true,true).fadeIn("fast")
		}).mouseleave(function(){
			jQuery(this).children().children("div.p-banner-small-alt").stop(true,true).fadeOut("fast")
		});
		
		jQuery(".p-top-qh-nav a:nth-child(2)").mouseenter(function(){
			jQuery(this).children().children("div.p-banner-small-alt").stop(true,true).fadeIn("fast")
		}).mouseleave(function(){
			jQuery(this).children().children("div.p-banner-small-alt").stop(true,true).fadeOut("fast")
		});
		
		jQuery(".p-top-qh-nav a:nth-child(3)").mouseenter(function(){
			jQuery(this).children().children("div.p-banner-small-alt").stop(true,true).fadeIn("fast")
		}).mouseleave(function(){
			jQuery(this).children().children("div.p-banner-small-alt").stop(true,true).fadeOut("fast")
		})
	}
		   
	var I;
	jQuery(window).resize(function(){

		if(!L){
			if(I){
				clearTimeout(I);
				I=null
			}
		}
		
		if(jQuery("#p-top-banner .p-bannerqh").is(":not(animated)")){
			if(!L){
				api.stop()
			}
			var O=-jQuery("#p-top-banner").width();
			var M=-jQuery("#p-top-banner").width()*2;
			var P=-jQuery("#p-top-banner").width()*3;
			var N=-jQuery("#p-top-banner").width()*298;
			var Q=-jQuery("#p-top-banner").width()*299;
			
			if(jQuery("#p-top-banner #p-banner-1").hasClass("p-selected-view")){
				jQuery("#p-top-banner .p-bannerqh").css("left",O)
			}if(jQuery("#p-top-banner #p-banner-2").hasClass("p-selected-view")){
				jQuery("#p-top-banner .p-bannerqh").css("left",M)
			}if(jQuery("#p-top-banner #p-banner-3").hasClass("p-selected-view")){
				jQuery("#p-top-banner .p-bannerqh").css("left",P)
			}
			
			jQuery("#p-top-banner .p-top-qh-pane,#p-top-banner .p-top-qh-pane .p-home-banner").width(jQuery("#p-top-banner").width());
			
			if(!L){
				I=setTimeout
				(function(){api.play()},1000)
			}
		}
		
	});

};

jQuery(pHPSetupFunction);



function dispaly(url){
   var host = window.location.host;
   if(host.indexOf("edu")>0){
        document.getElementById("new_logo").className = "edu";
   }
   if(host.indexOf("ent")>0){
        document.getElementById("new_logo").className = "ent";
   }
   if(host.indexOf("city")>0){
        document.getElementById("new_logo").className = "city";
   }
   if(host.indexOf("telcom")>0){
        document.getElementById("new_logo").className = "telcom";
   }
}


function setTab(name,cursel,n){
for(i=1;i<=n;i++){
var menu=document.getElementById(name+i);
var con=document.getElementById("con_"+name+"_"+i);
menu.className=i==cursel?"hover":"";
con.style.display=i==cursel?"block":"none";
}
}


function ChangeTabs(obj,cur){
			var objParent = obj.parentNode;
			var liObjs = objParent.getElementsByTagName("li");
			for(var k=0; k<liObjs.length;k++){
				liObjs[k].className = "";
				document.getElementById("Pro_"+k).className = "hidden";
			}
			obj.className = "cur";
			document.getElementById("Pro_"+cur).className = "";
		}
function ChangeTabs2(obj,cur){
			var objParent = obj.parentNode;
			var liObjs = objParent.getElementsByTagName("li");
			for(var k=0; k<liObjs.length;k++){
				liObjs[k].className = "";
				document.getElementById("Pro2_"+k).className = "hidden";
			}
			obj.className = "cur";
			document.getElementById("Pro2_"+cur).className = "";
		}

function AutoScroll(obj) {

            $(obj).find("ul:first").animate({
                marginTop: "-22px"
            }, 500, function() {
                $(this).css({ marginTop: "0px" }).find("li:first").appendTo(this);
            });
        }
        $(document).ready(function() {
            var myar = setInterval('AutoScroll("#scrollDiv")', 3000)
            $("#scrollDiv").hover(function() { clearInterval(myar); }, function() { myar = setInterval('AutoScroll("#scrollDiv")', 3000) }); //当鼠标放上去的时候，滚动停止，鼠标离开的时候滚动开始，-22px是行高
});

function ShowMenu(obj,noid){
	var block =	document.getElementById(noid);
	var n = noid.substr(noid.length-1);
	if(noid.length==4){
		var ul = document.getElementById(noid.substring(0,3)).getElementsByTagName("ul");
		var h2 = document.getElementById(noid.substring(0,3)).getElementsByTagName("h2");
		for(var i=0; i<h2.length;i++){
			h2[i].className = "";
		}
		obj.className = "open";
		for(var i=0; i<ul.length; i++){if(i!=n){ul[i].className = "no";}}
	}else{
		var span = document.getElementById("submenu").getElementsByTagName("span");
		var h1 = document.getElementById("submenu").getElementsByTagName("h1");
		for(var i=0; i<h1.length;i++){
			h1[i].innerHTML = h1[i].innerHTML.replace("+","-");
			h1[i].style.color = "";
		}
		obj.style.color = "#0000FF";
		for(var i=0; i<span.length; i++){if(i!=n){span[i].className = "no";}}
	}
	if(block.className == "no"){
		block.className = "";
		obj.innerHTML = obj.innerHTML.replace("-","+");
	}else{
		block.className = "no";
		obj.className = "";
	}
}



function LMYC() {
var lbmc;
//var treePic;
    for (i=1;i<=2;i++) {
        lbmc = eval('LM' + i);
        lbmc.style.display = 'none';
    }
}
 
function ShowFLT(i) {
    lbmc = eval('LM' + i);
    if (lbmc.style.display == 'none') {
        LMYC();
        lbmc.style.display = '';
    }
    else {
        lbmc.style.display = 'none';
    }
}


function weixin(obj, sType) {
var oDiv = document.getElementById(obj);
if (sType == 'show') { oDiv.style.display = 'block';}
if (sType == 'hide') { oDiv.style.display = 'none';}
}



$(document).ready(function(){
   $(".pro-tab-d > div:not(:first)").hide();
   var myLi = $(".pro-tab > ul > li");
   var myDiv =$(".pro-tab-d > div");
	myLi.each(function(i){
		$(this).click(function(){
		myLi.removeClass("hover");
		$(this).addClass("hover");
		myDiv.hide();
		myDiv.eq(i).show();
    });
   });
});


/*$.fn.smartFloat = function() {
	var position = function(element) {
		var top = element.position().top, pos = element.css("position");
		$(window).scroll(function() {
			var scrolls = $(this).scrollTop();
			if (scrolls > top) {
				if (window.XMLHttpRequest) {
					element.css({
						position: "fixed",
						top: 0
					});	
				} else {
					element.css({
						top: scrolls
					});	
				}
			}else {
				element.css({
					position: pos,
					top: top
				});	
			}
		});
};
	return $(this).each(function() {
		position($(this));						 
	});
};
*/
