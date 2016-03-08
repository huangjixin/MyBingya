$(function(){
	$TNC.init();
});
$TNC={
	config:{
		csstyle:[{opacity:1,scale:1,"y":0},
			{opacity:0.4,scale:0.85,"y":-63},
			{opacity:0.2,scale:0.7,"y":-152},
			{opacity:0.08,scale:0.55,"y":-289},
			{opacity:0,scale:0.55,"y":-289}
		],
		zIndex:[5,4,3,2,1],
		outStyle:{opacity:0,scale:1,"y":100}
	},
	browserCheck:function(){
		if($.browser.msie && parseFloat($.browser.version)<10){
			$("#browsertips").css({"marin-top":-350,"opacity":0,"display":"block"}).animate({"marin-top":-225,"opacity":1},500);
		}else{
			$("#browsertips").remove();
		}
	},
	cssInit:function(){
		var _=this;
		$(".newslist").each(function(index,elem){
			$(this).css(_.config.csstyle[index]).css({"z-index":_.config.zIndex[index]});
		});
		return	_.pageDataInit();
	},
	newsListAnimate:function(callback){
		var _=this;
		var $list=$(".newslist");
		var $cur=$list.eq(1);
		$list.each(function(index,elem){
			if(index>0){
				$(this).css(_.config.csstyle[index]).css({"z-index":_.config.zIndex[index]})
					.transition(_.config.csstyle[index-1],500,function(){
						$(this).css({"z-index":_.config.zIndex[index-1]});
					});
			}
		});
		//前台
		$list.eq(0).transition(_.config.outStyle,300,function(){
			$(this).remove();
		});
		//新加
		if($list.size()<=4){
			var $new=$('<div class="newslist"></div>');
			$list.parent().append($new);
			$new.css(_.config.csstyle[4]).transition(_.config.csstyle[3],300,function(){
				$(this).css({"z-index":_.config.zIndex[3]});
			});
		}
		if(typeof(callback)=='function'){
			callback($cur);
		}
	},
	storylistInit:function(){
		//初始化列表
		var $list=$(".storylist"),_l=$list.size();
		var cur=$list.index($(".storylist.cur"));
		var html='';
		for(var i=0;i<_l;i++){
			html+='<a href="javascript:;" class="dotlist"></a>';
		}
		$(".dotscover").html(html);
		$(".dotscover").find(".dotlist").eq(cur).addClass("cur");
		//事件绑定
		$(".dotlist").bind("click",function(e){
			if($(this).hasClass("cur")){return;}
			var tar=$(".dotlist").index(this),
				cur=$(".dotlist").index($(".dotlist.cur"));
			var beback=(tar<cur);
			$(".storylist").eq(cur).stop().css({left:"0%",display:"block"}).animate({left:beback?"100%":"-100%"},500);
			$(".storylist").eq(tar).stop().css({left:beback?"-100%":"100%",display:"block"}).animate({left:"0%"},500);
			$(".storylist").eq(cur).removeClass("cur");
			$(".storylist").eq(tar).addClass("cur");
			$(".dotlist.cur").removeClass("cur");
			$(this).addClass("cur");
		});
	},
	endTimeClock:function(){
		var curtime=[];
		$(".timeitem").each(function(i,el){
			curtime[i]= parseInt($(this).data("time")) || 0;
		});
		//停止事件
		if(curtime.join("")=="2013"){
			return true;
		}else{
			return false;
		}
	},
	setTimerClock:function(year){
		var val=String(year).split("");
		$(".timeitem").each(function(index,elem){
			$(this).find(".innernum").eq(0).css({"margin-top":-98*parseInt(val[index])});
			$(this).data("time",parseInt(val[index]));
		});
		return this;
	},
	getClockYear:function(){
		var val=[];
		$(".timeitem").each(function(index,elem){
			val[index]=parseInt($(this).data("time")) || 0;
		});
		return parseInt(val.join(""));
	},
	bowenId:null,
	voiceBoWen:function(){
		var _=this;
		clearInterval(_.bowenId);
		var $bowen=$(".voicequan").eq(0).clone(),
			$cover=$(".voicequan").parent();
		if($(".voicequan").size()>=10){return _;}
		$cover.append($bowen);
		$bowen.transition({width:150,height:150,"margin-left":-76,"bottom":-78,opacity:0},3000,function(){
			$(this).remove();
		});
		_.bowenId=setInterval(function(){
			_.voiceBoWen();
		},1500);
	},
	clearBoWen:function(){
		var _=this;
		clearInterval(_.bowenId);
	},
	getValueByKey:function (array,key,val,param){
		for(var i=0;i<array.length;i++){
			if(array[i][key]==val){
				return !!param? (array[i][param]) : (array[i]); //param存在，则返回对应值，不传值，则返回对象
			}
		}
	},
	getValueByKey2:function (array,key1,val1,key2,val2){
		for(var i=0;i<array.length;i++){
			if(array[i][key1]==val1 && array[i][key2]==val2){
				return array[i];
			}
		}
	},
	getValueByKey3:function (array,key1,val1,key2,val2,key3,val3){
		for(var i=0;i<array.length;i++){
			if(array[i][key1]==val1 && array[i][key2]==val2 && array[i][key3]==val3){
				return array[i];
			}
		}
	},
	deleteValueByKey:function (array,key,val){
		for(var i=0;i<array.length;i++){
			if(array[i][key]==val){
				array.splice(i,1);
			}
		}
	},
	getIndexByKey:function(array,key,val){
		for(var i=0;i<array.length;i++){
			if(array[i][key]==val){
				return i;
			}
		}
	},
	getIndexByKey2:function(array,key1,val1,key2,val2){
		for(var i=0;i<array.length;i++){
			if(array[i][key1]==val1 && array[i][key2]==val2){
				return i;
			}
		}
	},
	getIndexByKey3:function(array,key1,val1,key2,val2,key3,val3){
		for(var i=0;i<array.length;i++){
			if(array[i][key1]==val1 && array[i][key2]==val2 && array[i][key3]==val3){
				return i;
			}
		}
	},
	//滚动事件
	windwoScrollHandler:function(){
		var sh=$(window).scrollTop(),wh=$(window).height();
		var viewh=sh+wh;
		//隐藏二维码
		$("#qrcode").fadeOut(200);
		//导航状态
		var _i=0;
		//[0,543,1114,1661,2120];
		if(sh<=700){
			_i=0;
		}else if(sh<=2700){
			_i=1;
		}else if(sh<=3400){
			_i=2;
		}else{
			_i=3;
		}
		$TNC.navAnimate(_i);
		//logo
		if(sh>=300){
			$("#logocover").stop().animate({width:88,height:88,top:20,left:111},500);
			$("#logocover .logo2").fadeOut(200);
			$("#logocover .quancover").stop().animate({top:-31},500);
			$("#logocover .quandots").stop().animate({top:37},500);
		}else{
			$("#logocover").stop().animate({width:224,height:224,top:-20,left:43},500);
			$("#logocover .logo2").fadeIn(200);
			$("#logocover .quancover").stop().animate({top:0},500);
			$("#logocover .quandots").stop().animate({top:68},500);
		}
		//项目背景
		if(viewh>=910 && sh<=1300){
			$("#page0 .title").stop().animate({top:777},500);
			$("#page0 .piccover").stop().animate({top:1072},600);
			$("#page0 .txtcover").stop().animate({top:800},700);
		}else if(viewh<910){
			$("#page0 .title").stop().animate({top:1000},500);
			$("#page0 .piccover").stop().animate({top:1320},500);
			$("#page0 .txtcover").stop().animate({top:1600},500);
		}else{
			$("#page0 .title").stop().animate({top:500},500);
			$("#page0 .piccover").stop().animate({top:470},500);
			$("#page0 .txtcover").stop().animate({top:300},500);
		}
		//canvas动画
		if(viewh>=1600 && sh<=1500){
			$TNC.renderCanvasAnimate();
		}

		//新闻
		if(viewh>=1700 && sh<=2090){
			$("#page1 .topcase").stop().animate({right:"50%"},500);
		}else{
			$("#page1 .topcase").stop().animate({right:"100%"},500);
		}
		if(viewh>=2100 && sh<=2490){
			$("#page1 .bottomcase").stop().animate({left:"50%"},500);
		}else{
			$("#page1 .bottomcase").stop().animate({left:"100%"},500);
		}
		if(viewh>=1700 && sh<=2715){
			$("#page1 .elephtpic").stop().animate({right:0},800);
		}else{
			$("#page1 .elephtpic").stop().animate({right:-670},500);
		}
		//分享按钮
		if(viewh >=4110){
			$("#sharecover").stop().animate({bottom:160},300);
		}else{
			$("#sharecover").stop().animate({bottom:25},300);
		}

			//debug
	$(".scrollh").html('scrollh:'+sh);
	$(".winh").html('winh:'+wh);
	$(".viewh").html('viewh:'+viewh);

	},
	navAnimate:function (i){
		$(".navlist").removeClass("cur");
		$(".navlist").eq(i).addClass("cur");
	},
	renderNets:function(){
		var _=this;
		var orgx=340,orgy=135;
		//画网
		var ctx=document.getElementById("nets").getContext("2d");
		var pointer=cvsModel.drawNetz(ctx);
		//获取 点位置
		//console.log(_.pageData);
		var total=0;
		var rPos=[];
		for(var i=0;i<pointer.length;i++){
			total+=pointer[i].length;
			for(var j=0;j<pointer[i].length;j++){
				if(pointer[i][j].y<=640 && !Math.floor(Math.random()*2)){
					rPos.push(pointer[i][j]);
				}
			}
		}
		//console.log(total);
		//console.log(rPos.length);

		//数据
		var voices=_.pageData.voices;
		var length=Math.min(voices.length,rPos.length);
		for(var m=0;m<length;m++){
			var id=voices[m].id || 0,
				lev=voices[m].level || 1,
				official=voices[m].official || "N";
			//取半径
			//var rs=Math.floor(100*Math.random());
			lev= lev<=1?1:(lev>=5?5:lev);
			var r=6;
			switch(lev){
				case 1:
					r=5
					break;
				case 2:
					r=10
					break;
				case 3:
					r=20
					break;
				case 4:
					r=25
					break;
				case 5:
					r=35
					break;
				default:
					break;
			}
			//if(rPos.length<=0){return;}  //数据长度不会超过 点数
			var index=Math.floor(Math.random()*rPos.length); //随机index
			var _p=rPos[index];  //index 坐标
			//写入圆点 DOM 元素
			var bgcolor="#ebcd00";
			if(official=="Y"){
				bgcolor="#41a0d4";
				//r=10+5*Math.floor(Math.random()*3);
			}
			var $elem=$('<div class="voicedatalist" relid="'+id+'"></div>');
			$(".netcover").append($elem);
			$elem.css({"position":"absolute","left":orgx+_p.x-r,"top":orgy+_p.y-r,"width":2*r,"height":2*r,"border-radius":r,"background":bgcolor,"cursor":"pointer","overflow":"visible"});
			
			rPos.splice(index,1);

			//事件绑定
			var during=(Math.random()+0.5)*3000;
			if(official=="Y"){
				$elem.addClass("huxi");
				$TNC.autoAnimate($elem,during); //呼吸
			}
		}
		//其他空余点 补全黄点
		//console.log(rPos.length);
		
		for (var n =0; n< rPos.length-1; n++) {
			var _p=rPos[n];  //index 坐标
			var $elem=$('<div class="voicedatalist"></div>');
			$(".netcover").append($elem);
			$elem.css({"position":"absolute","left":orgx+_p.x-6,"top":orgy+_p.y-6,"width":2*6,"height":2*6,"border-radius":6,"background":"#ebcd00","cursor":"pointer","overflow":"visible"});
		}
		//事件绑定
		var during=(Math.random()+0.5)*3000;
		$(".voicedatalist").bind("mouseenter",function(e){
			clearTimeout($(this).attr("timeid"));
			e = e || window.event;
			var ww=$(window).width(),wh=$(window).height();
			$TNC.renderElemData($(this),$(this).position());
			$(this).css({"z-index":100}).transition({"scale":1.2},300);
		}).bind("mouseleave",function(e){
			$TNC.closeElemData($(this));
			$(this).css({"z-index":1}).transition({"scale":1},300);
			$TNC.autoAnimate($(this),during); //呼吸
		});
		//自动显示 id
		var vid=parseInt($TNC.getUrlParams('id'));
		if(!!vid && vid>=0){
			$TNC.searchVoice(vid);
		}
		
		return rPos;
	},
	autoAnimate:function(obj,during){
		clearTimeout(obj.attr("timeid"));
		if(!obj.hasClass('huxi')){return;}
		if(obj.hasClass('scaler')){
			obj.removeClass('scaler');
			obj.transition({"scale":0.8},during);
		}else{
			obj.addClass('scaler');
			obj.transition({"scale":1.2},during);
		}
		obj.attr("timeid",setTimeout(function(){
			$TNC.autoAnimate(obj,during);
		},during+50));
	},
	renderElemData:function($obj,pos){
		var id=$obj.attr("relid");
		if(!id){return;}
		//if($("#voicedata").size()>0){
			clearTimeout($("#voicedata").attr("timeid"));
			$("#voicedata").remove();
		//}
		$TNC.tracking("voice",id);
		var data=$TNC.getValueByKey($TNC.pageData.voices,"id",id);
		var cover1='<div id="voicedata" style="position:absolute;left:'+(pos.left-180)+'px;bottom:'+(1100-pos.top+40)+'px;display:none;padding:20px;background:#ebcd00;width:355px;border-radius:10px; font-size:14px;line-height:1.5;color:#415859;z-index:99;">';
		var headhtml='<div style="float:left;width:120px;margin-right:20px;"><img src="http://baby.haier.com/data/attachment/album/20140126195425.jpg" width="100%"/></div>';
		var mp3html='<div class="mp3cover" style="height:32px;padding:5px;cursor:pointer;"><img src="/ir/web/img/icons/icon3.png" /></div>';
		var contenthtml='<p style="padding-bottom:25px;"></p>';
		var namehtml='<p style="text-align: right;position:absolute;right:20px;bottom:20px;"></p>';
		var cover2='<div style="clear:both;height:0px;"></div><div style="position:absolute;width:28px;height:15px;left:50%;margin-left:-14px;bottom:-15px;"><img src="/ir/web/img/icons/icon4.png" /></div></div>';
		if(!!data.head){
			cover1+=('<div style="float:left;width:120px;margin-right:20px;"><img src="'+data.head+'" width="100%"/></div>');
		}
		if(!!data.audio){
			cover1+=('<div class="mp3cover" style="height:32px;padding:5px;cursor:pointer;"><img src="/ir/web/img/icons/icon3.png" />'+
				'<audio><source src="'+data.audio+'" type="audio/mpeg"></audio></div>');
		}
		if(!!data.content){
			var temp='<p style="';
			if(!!data.author){
				temp+='padding-bottom:25px;';
			}
			temp+='">';
			cover1+=(temp+data.content+'</p>');
		}
		if(!!data.author){
			cover1+=('<p style="text-align: right;position:absolute;right:20px;bottom:20px;">'+data.author+'</p>');
		}
		cover1+=cover2;
		$obj.parent().append(cover1); //写入
		$("#voicedata").css({opacity:0,bottom:(1100-pos.top-30),display:"block"}).animate({bottom:(1100-pos.top+40),opacity:1},300);
		$("#voicedata").bind("mouseenter",function(e) {
			clearTimeout($(this).attr("timeid"));
		}).bind("mouseleave",function(e) {
			$(this).fadeOut(100,function(){
				$(this).remove();
			})
		});
		$("#voicedata").find(".mp3cover").click(function(e){
			var audio=$(this).find("audio").get(0);
			if(!!audio){
				if($(this).hasClass("beplay")){
					if(typeof(audio.pause)=='function'){
						audio.pause();
						$(this).removeClass("beplay");
						$(this).find("img").attr("src",$(this).find("img").attr("src").replace(/icon7.png$/,"icon3.png"));
					}
				}else{
					if(typeof(audio.play)=='function'){
						audio.play();
						$(this).addClass("beplay");
						$(this).find("img").attr("src",$(this).find("img").attr("src").replace(/icon3.png$/,"icon7.png"));
					}
				}
			}
		});
	},
	closeElemData:function($obj){
		$("#voicedata").attr("timeid",setTimeout(function(e){
			$("#voicedata").fadeOut(100,function(){
				$("#voicedata").remove();
			});
		},200));
	},
	renderSearchData:function(data){
		var temp=$TNC.getValueByKey($TNC.pageData.voices,"id",data.id);
		if(!temp){
			$TNC.pageData.voices.push(data);
		}
		var i=-1;
		$(".voicedatalist").each(function(index,elem){
			if($(this).attr("relid")==data.id){
				i=index;
			}
		});
		if(i<0){
			i=Math.floor(Math.random()*$(".voicedatalist").size());
		}
		$(".voicedatalist").eq(i).attr("relid",data.id);
		$(".voicedatalist").eq(i).trigger("mouseenter");
	},
	animating:false,
	renderCanvasAnimate:function(){
		var _=this;
		//canvas1
		if(_.animating){return _;}
		_.animating=true;
		var ctx1=document.getElementById("ancvs1").getContext("2d");
		cvsModel.fLineAnimate(ctx1,5,1000);
		//canvas2
		var ctx2=document.getElementById("ancvs2").getContext("2d");
		cvsModel.polygonInit(ctx2,12,140,130,103,0);
		cvsModel.polygonAnimate(ctx2,140,130,103,270,330,500); //330

		$("#page0 .animacover3 .ancvs3").stop().css({width:0}).animate({width:237},1000);
		setTimeout(function(){
			_.animating=false;
		},1000);
	},
	renderErrorTips:function(msg,during){
		var $win=$("#p_tips");
		clearTimeout($win.attr("timeid"));
		$win.html(msg);
		$win.stop().css({"display":"block","opacity":0,"margin-top":100}).animate({"opacity":1,"margin-top":-90},500)
		if(!!during){
			$win.attr("timeid",setTimeout(function(){
				$win.fadeOut(200);
			},during));
		}
	},
	renderVoiceTemplate:function(array){
		$(".voiceitem .vicontxt").each(function(index,elem){
			$(this).html(array[index]);
		});
	},
	renderPortsNum:function(s){
		s= s || 0;
		$("#searchcover .postsnum").html(s);
	},
	getMonthNewsData:function(data,m,s){
		var param=String(m);
		var obj=null;
		if(!!data[param]){
			obj=data[param];
		}else if(s){
			for(var i=1;i<=12;i++){
				if(!!data[String(i)]){
					obj=data[String(i)];
					param=String(i);
					break;
				}
			}
		}
		return {"data":obj,"m":param};
	},
	renderNewsList:function(sb){
		var html='<a href="#"><h3 class="innertit"></h3><p></p></a>';
		var _=this;
		var now=new Date();
		var year =now.getFullYear();
		var month =now.getMonth()+1;
		var $news=$('<h3 class="innertit">没有相关新闻</h3>');
		//var m=month;
		var data;
		var s=false;
		if(!!sb){
			data=sb;
		}else{
			if(_.pageData && _.pageData.news && _.pageData.news[String(year)] && _.pageData.news[String(year)][month-1] && _.pageData.news[String(year)][month-1].length>0){
				data=_.pageData.news[String(year)][month-1][_.pageData.news[String(year)][month-1].length-1];
			}else{
				data=_.newsListData[_.newsListData.length-1];
			}
		}
		if(!!data && (!!data.id || data.id==0)){
			//更改年度
			var oldyear=_.getClockYear();
			year=parseInt(data.year);
			month =parseInt(data.month);
			if(oldyear<year){
				s=true;
				_.setTimerClock(year-1);
				$(".timeitem").eq($(".timeitem").size()-1).trigger("addtime",300);
			}else if(oldyear>year){
				s=true;
				_.setTimerClock(year+1);
				$(".timeitem").eq($(".timeitem").size()-1).trigger("minustime",300);
			}
			//重渲染 月度 dots
			if(s){
				var tempdata=_.pageData.news[String(year)];
				for(var i=0;i<tempdata.length;i++){
					if(!!tempdata[i] && tempdata[i].length>0){
						$(".mlist").eq(i).removeClass('nonews');
					}else{
						$(".mlist").eq(i).addClass('nonews');
					}
				}
			}
			//写入新闻内容
			$news=$('<a href="javascript:;" relid="'+data.id+'"><h3 class="innertit">'+data.title+'</h3><p>'+data.summary+'</p></a>').css({"display":"none"});
			//渲染动画
			_.newsListAnimate(function($tar){
				$tar.empty().append($news);
				$news.fadeIn(200);
				$(".mlist").removeClass("cur");
				$(".mlist").eq(parseInt(month)-1).addClass("cur");
				$news.click(function(e){
					var _year=_.getClockYear();
					var _id=$(this).attr("relid");
					$TNC.tracking("news",_id);
					var data=_.getValueByKey2(_.newsListData,"year",_year,"id",_id);
					_.renderNewsContent(data);
				});
			});
		}else{
			_.renderErrorTips("没有相关数据",2000);
		}	
		/*
		if(_.pageData && _.pageData.news && _.pageData.news[String(year)]){
			var data=_.pageData.news[String(year)];
			//var monobj=_.getMonthNewsData(data,month,!s);
			if(!s){
				for(var i=0;i<data.length;i++){
					if(!!data[i] && data[i].length>0){
						if(!m && m!=0){
							m=i+1;
						}
						$(".mlist").eq(i).removeClass('nonews');
					}else{
						$(".mlist").eq(i).addClass('nonews');
					}
				}
				//更改年度
				var oldyear=_.getClockYear();
				if(oldyear<year){
					_.setTimerClock(year-1);
					$(".timeitem").eq($(".timeitem").size()-1).trigger("addtime",300);
				}else if(oldyear==year){

				}else{
					_.setTimerClock(year+1);
					$(".timeitem").eq($(".timeitem").size()-1).trigger("minustime",300);
				}
			}
			var newsobj=data[parseInt(m)-1];
			if(!!newsobj.length>0){
				$news=$('<a href="javascript:;" relid="'+newsobj.id+'"><h3 class="innertit">'+newsobj.title+'</h3><p>'+newsobj.summary+'</p></a>').css({"display":"none"});
			}
			
			_.newsListAnimate(function($tar){
				$tar.empty().append($news);
				$news.fadeIn(200);
				$(".mlist").removeClass("cur");
				$(".mlist").eq(parseInt(m)-1).addClass("cur");
				$news.click(function(e){
					var _year=_.getClockYear();
					var _id=$(this).attr("relid");
					$TNC.tracking("news",_id);
					_.renderNewsContent(_id);
				});
			});
		}else{
			_.renderErrorTips("没有相关数据",2000);
		}	
		*/
	},
	getJSONLength:function(json){
		var i=0;
		for(var val in json){
			if(!!json[val]){
				i+=1;
			}
		}
		return i;
	},
	/*	
	 *	数据来源 需要保证每年都有新闻，对象为 {} 都可以
	 */ 
	newsListData:[],
	setNewsListData:function(){
		var _=this;
		var data=_.pageData["news"];
		var len=_.getJSONLength(data);
		var year=new Date().getFullYear();
		for(var i=1;i<=len;i++){
			var temp=data[String(year-len+i)];
			for(var j=0;j<12;j++){
				if(!!temp[j] && temp[j].length>0){
					_.newsListData = _.newsListData.concat(temp[j]);
				}
			}
		}
		return _;
	},
	renderNewsContent:function(data){
		var _=this;
		var $popWin=$("#news_wrapper");
		/*
		var year=_.getClockYear();
		var index=_.getIndexByKey2(_.newsListData,"id",id,"year",year);
		var len=_.newsListData.length;
		var data=_.newsListData[index];
		*/
		//var data=_.getValueByKey(_.pageData["news"][String(year)],"id",id);
		var offset=$(".newscover").get(0).getBoundingClientRect();
		var _winW=$(window).width(),_winH=$(window).height();
		if(!!data && !!data.id){
			//渲染 内容
			$popWin.find(".p_content").attr("relid",data.id).attr("relyear",data.year);
			$popWin.find(".p_newstitle").html(data.title);
			$popWin.find(".p_newstime").html("大自然保护协会TNC  "+data.year+"/"+data.month);
			$popWin.find(".p_newscontent").html(data.content);
			//$popWin.fadeIn(300);
			$popWin.stop().css({display:"block",width:658,height:296,opacity:0,left:offset.left,top:offset.top})
				.animate({width:_winW-102,height:_winH-102,opacity:1,left:50,top:50});
			$popWin.find(".p_newscontent").css({"height":_winH-370,"overflow":"auto"});
		}else{
			_.renderErrorTips("没有相关数据",2000);
		}
		return _;
	},
	renderNewsListContent:function(beback){
		var _=this;
		var $popWin=$("#news_wrapper");
		var relid=$popWin.find(".p_content").attr("relid"),
			relyear=$popWin.find(".p_content").attr("relyear");
		var index=_.getIndexByKey2(_.newsListData,"id",relid,"year",relyear);
		var len=_.newsListData.length;
		var tar=!!beback?(index-1<0?len-1:index-1):(index+1>=len?0:index+1);
		var data=_.newsListData[tar];
		var _winH=$(window).height();
		if(!!data && !!data.id){
			$TNC.tracking("news",data.id);
			var $curElem=$popWin.find(".p_content").eq(0);
			var $elem=$('<div class="p_content" relid="'+data.id+'" relyear="'+data.year+'">'+
					'<h5 class="p_newstitle">'+data.title+'</h5>'+
					'<p class="p_newstime">'+'大自然保护协会TNC  '+data.year+'/'+data.month+'</p>' +
					'<div class="p_newscontent">'+data.content+'</div></div>');
			$popWin.append($elem);
			$elem.css({left:!!beback?"-50%":"150%",opacity:0}).stop().animate({left:"50%",opacity:1},300);
			$elem.find(".p_newscontent").css({"height":_winH-370,"overflow":"auto"});
			$curElem.stop().animate({left:!!beback?"150%":"-50%",opacity:0},300,function(){
				$(this).remove();
			});
		}else{
			_.renderErrorTips("没有相关数据",2000);
		}
	},
	pageData:null,
	blankPoint:null,
	pageDataInit:function(){
		var _=this;
		$.ajax({
			url:'/ivory/web/init',////////'./test.json',
			data:{},
			type:"POST",
			dataType:"json",
			success:function(r){
				if(!!r){
					_.pageData=r;
					//模板
					if(!!r.templates && Object.prototype.toString.call(r.templates) =="[object Array]"){
						_.renderVoiceTemplate(r.templates);
					}
					//新闻
					_.setNewsListData();
					_.renderNewsList();
					//发声
					_.blankPoint=_.renderNets(); //存储空白点
					//参与人数
					_.renderPortsNum(r["total_posts"]);
				}else{
					_.renderErrorTips("数据请求失败，请稍后重试",2500);
				}
			},
			error:function(){
				_.renderErrorTips("网络连接错误！请稍后重试",2500);
			}
		});
		return _;
	},
	searchVoice:function(id,callback){
		var _=this;
		$.ajax({
			url:'/ivory/web/getVoice',//,'./test.json',
			data:{"id":id},
			type:"POST",
			dataType:"json",
			success:function(r){
				if(r.ret==0){
					_.renderSearchData(r.data);
				}else{
					_.renderErrorTips(r.msg,2500);
				}
			},
			error:function(){
				_.renderErrorTips("网络连接错误！请稍后重试",2500);
			}
		});
	},
	voiceitemId:null,
	speakVoice:function(msg,name){
		var _=this;
		name=name || "";
		msg=msg || "";
		$.ajax({
			url:'/ivory/web/speak',
			data:{"nick":name,"content":msg},
			type:"POST",
			dataType:"json",
			success:function(r){
				if(r.ret==0){
					_.renderErrorTips('<p style="font-size:25px;line-height:60px;">发送成功</p><p>您的留言ID为：'+r.data.id+'</p>',5000);
					// 清空
					$(".namecover .username,.inputcover .isay").val('');
				}else{
					_.renderErrorTips(r.msg,2500);
				}
			},
			error:function(){
				_.renderErrorTips("网络连接错误！请稍后重试",2500);
			}
		});
	},
	eventInit:function(){
		var _=this;

		$(window).on("scroll",_.windwoScrollHandler);
		_.storylistInit();
		//导航点击事件
		$(".navlist").bind("click",function(e){
			var navpos=[0,760,2600,3500];
			var index=$(".navlist").index(this);
			var sh=$(window).scrollTop();
			$(window).scrollTo(navpos[index],Math.abs(sh-navpos[index])>>1);
		});

		//项目背景展开事件
		$(".btn_more").bind("mouseenter",function(e){
			$(this).parents(".txtproj").find(".innerbg").stop().animate({"width":476},300);
		}).bind("mouseleave",function(e){
			$(this).parents(".txtproj").find(".innerbg").stop().animate({"width":0},300);
		});
		$(".txtproj1 .btn_more").bind("click",function(e){
			if($(this).hasClass("beshown")){
				$(".txtproj1").stop().animate({height:480},350);
				$(".txtproj1 .innerproj").stop().animate({height:416,top:30},350);	
				$(this).removeClass("beshown").find("span").html("更多");
				$(".txtproj1 .innershape").stop().animate({bottom:0,right:0,opacity:1},300);
				$(".txtproj2 .innershape").stop().animate({bottom:0,right:0,opacity:1},300);
				$(".txtproj2 .btn_more span").html("更多");
				$(".txtproj2 .btn_more").removeClass("beshown");
				$(".txtproj2").stop().animate({height:213},350);
				$(".txtproj2 .innerproj").stop().animate({height:148,bottom:34},350);	

			}else{
				$(".txtproj1").stop().animate({height:644},350);
				$(".txtproj1 .innerproj").stop().animate({height:580,top:30},350);		
				$(this).addClass("beshown").find("span").html("收起");
				$(".txtproj1 .innershape").stop().animate({bottom:-30,right:-30,opacity:0},300);
				$(".txtproj2 .innershape").stop().animate({bottom:0,right:0,opacity:1},300);
				$(".txtproj2 .btn_more span").html("更多");
				$(".txtproj2 .btn_more").removeClass("beshown");
				$(".txtproj2").stop().animate({height:50},350);
				$(".txtproj2 .innerproj").stop().animate({height:45,bottom:0},350);
			}			
		});
		$(".txtproj2 .btn_more").bind("click",function(e){
			if($(this).hasClass("beshown")){
				$(".txtproj2").stop().animate({height:213},350);
				$(".txtproj2 .innerproj").stop().animate({height:148,bottom:34},350);
				$(this).removeClass("beshown").find("span").html("更多");
				$(".txtproj1 .innershape").stop().animate({bottom:0,right:0,opacity:1},300);
				$(".txtproj2 .innershape").stop().animate({bottom:0,right:0,opacity:1},300);
				$(".txtproj1 .btn_more span").html("更多");
				$(".txtproj1 .btn_more").removeClass("beshown");
				$(".txtproj1").stop().animate({height:480},350);
				$(".txtproj1 .innerproj").stop().animate({height:416,top:30},350);				
			}else{
				$(".txtproj2").stop().animate({height:644},350);
				$(".txtproj2 .innerproj").stop().animate({height:580,bottom:34},350);
				$(this).addClass("beshown").find("span").html("收起");
				$(".txtproj1 .innershape").stop().animate({bottom:0,right:0,opacity:1},300);
				$(".txtproj2 .innershape").stop().animate({bottom:-30,right:-30,opacity:0},300);
				$(".txtproj1 .btn_more span").html("更多");
				$(".txtproj1 .btn_more").removeClass("beshown");
				$(".txtproj1").stop().animate({height:50},350);
				$(".txtproj1 .innerproj").stop().animate({height:45,top:5},350);
			}	
		});
		//模板
		$(".voiceitem").bind("click",function(e){
	    	clearTimeout(_.voiceitemId);
	    	$(".voiceitem").removeClass("cur");
	    	$(this).addClass("cur");
	    	var msg=$(this).find(".vicontxt").html();
	    	_.voiceitemId=setTimeout(function(){
	    		_.speakVoice(msg);
	    	},300);
	    });
		//输入框
		$(".inputcover .isay,.namecover .username,#searchcover .s_key").bind("keyup blur",function(e){
			var val=$(this).val(),
			 	reltxt=$(this).attr("reltxt"),
				$tips=$(this).parent().find(".inputips");
			$tips.html($.trim(val)=='' ? reltxt:"");
		});
		$(".btn_confirm").bind("click",function(e){
			var nick=$(".namecover .username").val(),
				content=$(".inputcover .isay").val();
			if($.trim(content)==""){
				//为空值
			}else{
				_.speakVoice(content,nick);
			}
		});
		//计时器
	    $(".timeitem").bind("addtime",function(e,during){  // +1
	    	var index=$(".timeitem").index(this);
	    	var $this=$(this);
	    	var maxLen=parseInt($(this).attr("reltime"));
	    	var $innernum=$(this).find(".innernum").eq(0);
	    	var _topval=parseInt($innernum.css("margin-top").replace(/px$|em$/,"").replace("-","")) || 0;
	    	var curtime=Math.floor(_topval/98);
	    	during= during>=300? 300:(during<=10 ? 10:(during|| 300));
	    	if(curtime+1>maxLen){
	    		$(this).append($innernum.clone().css({"margin-top":0}));
	    		if(index-1>=0){
	    			$(".timeitem").eq(index-1).trigger("addtime");
	    		}
	    	}
	    	$innernum.animate({"margin-top":-(curtime+1)*98},during,function(){
				if($this.find(".innernum").size()>1){ $this.find(".innernum").eq(0).remove();}
	    	});
	    	$this.data("time",(curtime+1)%10);
	    });
	    $(".timeitem").bind("minustime",function(e,during){  // -1
	    	var index=$(".timeitem").index(this);
	    	var $this=$(this);
	    	var maxLen=parseInt($(this).attr("reltime"));
	    	var $innernum=$(this).find(".innernum").eq(0);
	    	var _topval=parseInt($innernum.css("margin-top").replace(/px$|em$/,"").replace("-","")) || 0;
	    	var curtime=Math.floor(_topval/98);
	    	during= during>=300? 300:(during<=10 ? 10:(during|| 300));
	    	if(curtime-1<0){
	    		$(this).prepend($innernum.clone().css({"margin-top":-98*(maxLen+1)}));
	    		if(index-1>=0){
	    			$(".timeitem").eq(index-1).trigger("minustime");
	    		}
	    	}

	    	$this.find(".innernum").eq(0).animate({"margin-top":-(curtime-1<0?maxLen:curtime-1)*98},during,function(){
				if($this.find(".innernum").size()>1){ $this.find(".innernum").eq(1).remove();}
	    	});
	    	$this.data("time",(curtime-1+10)%10);
	    });
	    $(".btn_prev").bind("click",function(e){
	    	var year=_.getClockYear();
	    	var month=$(".mlist").index($(".mlist.cur"))+1;
	    	var id=$(".newslist a").attr("relid");
	    	var index=_.getIndexByKey3(_.newsListData,"year",year,"month",month,"id",id);
	    	var len=_.newsListData.length;
	    	var data= _.newsListData[index-1<0?len-1:index-1];
	    	_.renderNewsList(data);
	    });
	    $(".btn_next").bind("click",function(e){
	    	var year=_.getClockYear();
	    	var month=$(".mlist").index($(".mlist.cur"))+1;
	    	var id=$(".newslist a").attr("relid");
	    	var index=_.getIndexByKey3(_.newsListData,"year",year,"month",month,"id",id);
	    	var len=_.newsListData.length;
	    	var data= _.newsListData[index+1>=len?0:index+1];
	    	_.renderNewsList(data);
	    });
	    //新闻 事件
		$(".mlist").bind("click",function(e){
			if($(this).hasClass("nonews") || $(this).hasClass("cur")){return;}
			var month=$(".mlist").index(this)+1;
			var year=_.getClockYear();
			//var id=$(".newslist a").attr("relid");
			var data=_.getValueByKey2(_.newsListData,"year",year,"month",month);
			_.renderNewsList(data);
		});
		//新闻浮层 左右切换
		$("#news_wrapper .p_prev").bind("click",function(e){
			_.renderNewsListContent(true);
		});
		$("#news_wrapper .p_next").bind("click",function(e){
			_.renderNewsListContent(false);
		});

	    $(".close").bind('click',function(e){
	    	$(this).parents(".p_window").fadeOut(200);
	    });
	    //搜索框
	    $(".sinputcover .s_key").bind("click focus",function(e){
	    	$(".sinputcover").transition({width:415,"background":"#dcdcdc"},300);
	    	$(this).transition({width:350},300);
	    }).bind("blur",function(e){
	    	$(".sinputcover").transition({width:315,"background":"#c9c9c9"},300);
	    	$(this).transition({width:250},300);
	    });
	    //搜索
	    $(".btn_search").bind("click",function(e){
	    	var _id=parseInt($(".s_key").val());
	    	if(!!_id || _id==0){
	    		_.searchVoice(_id);
	    	}else{
	    		_.renderErrorTips("请输入正确的留言ID",2500); 
	    	}
	    });
	    $(".s_key").bind("keyup",function(e){
	    	e = e || window.event;
	    	if(e.keyCode ==13){ //回车键
	    		$(".btn_search").trigger("click");
	    	}
	    });

		return	_;
	},
	tracking:function(type,id){
		if(type=="voice"){
			$.ajax({
				url: '/ivory/web/viewVoice',
				data: {"id": id},
				type: 'POST',
				dataType: 'json'
			});			
		}else if(type=="news"){
			$.ajax({
				url: '/ivory/web/viewNews',
				data: {"id": id},
				type: 'POST',
				dataType: 'json'
			});	
		}
	},
	share:function(type){
		var _link = '',
			title = '#为大象发声#想听我在说什么，http://tnc.org.cn/ivory/和我一起发声，为终结象牙贸易出力。@大自然保护协会TNC',
			img='',
			_class='',	//百度收藏
			content = '#为大象发声#想听我在说什么，http://tnc.org.cn/ivory/和我一起发声，为终结象牙贸易出力。@大自然保护协会TNC';
		switch (type){
			case 'sina':
				window.open('http://v.t.sina.com.cn/share/share.php?appkey=&url='+encodeURIComponent(_link)+'&pic='+encodeURIComponent(img)+'&title='+encodeURIComponent(content)+'','_blank','scrollbars=no,width=600,height=450,left=75,top=20,status=no,resizable=yes');
				break;
			case 'wx':
				$("#qrcode").fadeIn(200);
				break;
			case 'lw':
				$("#qrcode").fadeIn(200);
				break;
			default:
				break;
		}
	},
	getUrlParams:function(param){
		var search=window.location.search.substring(1);
		var temp=search.split('&');
		for(var i=0;i<temp.length;i++){
			var val=temp[i].split('=');
			if(val[0]==param){
				return val[1];
			}
		}
	},
	init:function(){
		var _=this;
		_.browserCheck();
		_.cssInit().eventInit();
		_.voiceBoWen();
		//debug
		//_.renderNets();
		return	_;	
	}
};
var cvsModel={
	config:{
		fline:[
			[40,245],
			[85,225],
			[135,217],
			[180,190],
			[228,180],
			[275,143]
		],
		mc:{
			x:150,
			y:150,
			r:100,
			muilts:6
		},
		rect:[
			{w:320,h:260},
			{w:280,h:260}
		]
	},

	drawAllPointer:function(ctx){
		var _=this;
		ctx.fillStyle="#ecce00";
		for(var i=0;i<_.config.fline;i++){
			ctx.beginPath();
			ctx.arc(_.config.fline[i][0],_.config.fline[i][1],8,0,Math.PI*2,false);
			ctx.closePath();
			ctx.fill();
		}
		return _;
	},
	drawPointer:function(ctx,pointX,pointY,r){
		var _=this;
		ctx.fillStyle="#ecce00";
		ctx.beginPath();
		ctx.arc(pointX,pointY,r,0,Math.PI*2,false);
		ctx.closePath();
		ctx.fill();
		return _;
	},
	renderLineTo:function(ctx,index,pointX,pointY){
		var _=this;
		var point=_.config.fline;
		ctx.strokeStyle="#ecce00";
		ctx.lineWidth=3;
		if(index<=0){
			ctx.closePath();
		}else{
			ctx.beginPath();
			ctx.moveTo(point[index-1][0],point[index-1][1]);
			ctx.lineTo(pointX,pointY);
			ctx.closePath();
			ctx.stroke();
		}
	},
	renderFLine:function(ctx,pointX,pointY){
		var _=this;
		var point=_.config.fline;
		if(pointX<=point[0][0]){
			_.renderLineTo(ctx,0,pointX,pointY);
		}else if(pointX<point[1][0]){
			_.drawPointer(ctx,point[0][0],point[0][1],8);
			_.renderLineTo(ctx,1,pointX,pointY);
		}else if(pointX<point[2][0]){
			_.drawPointer(ctx,point[0][0],point[0][1],8);
			_.renderLineTo(ctx,1,point[1][0],point[1][1]);
			_.drawPointer(ctx,point[1][0],point[1][1],8);
			_.renderLineTo(ctx,2,pointX,pointY);
		}else if(pointX<point[3][0]){
			_.drawPointer(ctx,point[0][0],point[0][1],8);
			_.renderLineTo(ctx,1,point[1][0],point[1][1]);
			_.drawPointer(ctx,point[1][0],point[1][1],8);
			_.renderLineTo(ctx,2,point[2][0],point[2][1]);
			_.drawPointer(ctx,point[2][0],point[2][1],8);
			_.renderLineTo(ctx,3,pointX,pointY);
		}else if(pointX<point[4][0]){
			_.drawPointer(ctx,point[0][0],point[0][1],8);
			_.renderLineTo(ctx,1,point[1][0],point[1][1]);
			_.drawPointer(ctx,point[1][0],point[1][1],8);
			_.renderLineTo(ctx,2,point[2][0],point[2][1]);
			_.drawPointer(ctx,point[2][0],point[2][1],8);
			_.renderLineTo(ctx,3,point[3][0],point[3][1]);
			_.drawPointer(ctx,point[3][0],point[3][1],8);
			_.renderLineTo(ctx,4,pointX,pointY);
		}else if(pointX<point[5][0]){
			_.drawPointer(ctx,point[0][0],point[0][1],8);
			_.renderLineTo(ctx,1,point[1][0],point[1][1]);
			_.drawPointer(ctx,point[1][0],point[1][1],8);
			_.renderLineTo(ctx,2,point[2][0],point[2][1]);
			_.drawPointer(ctx,point[2][0],point[2][1],8);
			_.renderLineTo(ctx,3,point[3][0],point[3][1]);
			_.drawPointer(ctx,point[3][0],point[3][1],8);
			_.renderLineTo(ctx,4,point[4][0],point[4][1]);
			_.drawPointer(ctx,point[4][0],point[4][1],8);
			_.renderLineTo(ctx,5,pointX,pointY);
		}else{
			_.drawPointer(ctx,point[0][0],point[0][1],8);
			_.renderLineTo(ctx,1,point[1][0],point[1][1]);
			_.drawPointer(ctx,point[1][0],point[1][1],8);
			_.renderLineTo(ctx,2,point[2][0],point[2][1]);
			_.drawPointer(ctx,point[2][0],point[2][1],8);
			_.renderLineTo(ctx,3,point[3][0],point[3][1]);
			_.drawPointer(ctx,point[3][0],point[3][1],8);
			_.renderLineTo(ctx,4,point[4][0],point[4][1]);
			_.drawPointer(ctx,point[4][0],point[4][1],8);
			_.renderLineTo(ctx,5,point[5][0],point[5][1]);
			_.drawPointer(ctx,point[5][0],point[5][1],8);
		}
		return _;
	},
	fLineAnimate:function(ctx,index,during,cStep){
		var _=this;
		var point=_.config.fline;
		var pertime=10;	//执行间隔 毫秒
		var orgX=point[0][0],orgY=point[0][1];
		var tarX=point[index][0],tarY=point[index][1];
		cStep=cStep || 1;//当前执行的第几步
		var steps=parseInt(during/pertime);//共需要执行步数
		var dx=(tarX-orgX)/steps*cStep+orgX;
		if(dx<=point[1][0]){dy=point[0][1]- (dx-point[0][0])*(point[0][1]-point[1][1])/(point[1][0]-point[0][0]);}
		else if(dx<=point[2][0]){dy=point[1][1]- (dx-point[1][0])*(point[1][1]-point[2][1])/(point[2][0]-point[1][0])}
		else if(dx<=point[3][0]){dy=point[2][1]- (dx-point[2][0])*(point[2][1]-point[3][1])/(point[3][0]-point[2][0]);}
		else if(dx<=point[4][0]){dy=point[3][1]- (dx-point[3][0])*(point[3][1]-point[4][1])/(point[4][0]-point[3][0]);}
		else if(dx<=point[5][0]){dy=point[4][1]- (dx-point[4][0])*(point[4][1]-point[5][1])/(point[5][0]-point[4][0]);}
		else{dy=point[5][1]-(dx-point[5][0]);}
		//dy=_.config.rect[0].h-dy;
		ctx.clearRect(0,0,_.config.rect[0].w,_.config.rect[0].h);
		_.renderFLine(ctx,dx,dy);
		if(cStep<steps){
			setTimeout(function(){
				_.fLineAnimate(ctx,index,during,cStep+1);
			},pertime);
		}
	},
	getPolygonPos:function(s,x,y,r,stardeg){
		var pos=[],temp={};
		var perDeg=Math.PI*2/s;
		for(var i=0;i<s;i++){
			var dx=Math.cos(perDeg*i+stardeg)*r+x;
			var dy=Math.sin(perDeg*i+stardeg)*r+y;
			pos[i]={x:dx,y:dy};
		}
		return pos;
	},
	drawPolygon:function(ctx,s,x,y,r,stardeg){
		var _=this;
		var pos=_.getPolygonPos(s,x,y,r,stardeg);
		ctx.fillStyle="#d9b100";
		ctx.beginPath();
		ctx.moveTo(pos[0].x,pos[0].y);
		for(var i=1;i<pos.length;i++){
			ctx.lineTo(pos[i].x,pos[i].y);
		}
		ctx.closePath();
		ctx.fill();
	},
	polygonInit:function(ctx,s,x,y,r,stardeg){
		var _=this;
		var pos=_.getPolygonPos(s,x,y,r,stardeg);
		ctx.beginPath();
		ctx.moveTo(pos[0].x,pos[0].y);
		for(var i=1;i<pos.length;i++){
			ctx.lineTo(pos[i].x,pos[i].y);
		}
		ctx.closePath();
		ctx.clip();
		//背景
		ctx.fillStyle="#d9b100";
		ctx.fillRect(0,0,_.config.rect[1].w,_.config.rect[1].h);
		return _;
	},
	polygonAnimate:function(ctx,x,y,r,starDeg,endDeg,during,cStep){
		var _=this;
		var pertime=10;	//执行间隔 毫秒
		var starDeg2=Math.PI*starDeg/180;
		var endDeg2=Math.PI*endDeg/180;
		cStep=cStep || 1;//当前执行的第几步
		var steps=parseInt(during/pertime);//共需要执行步数
		var dx=(endDeg2-starDeg2)/steps *cStep+starDeg2;
		ctx.clearRect(0,0,_.config.rect[1].w,_.config.rect[1].h);
		//背景
		ctx.fillStyle="#d9b100";
		ctx.fillRect(0,0,_.config.rect[1].w,_.config.rect[1].h);

		ctx.fillStyle="#ebcd00";
		ctx.beginPath();
		ctx.moveTo(x,y);
		ctx.lineTo(Math.cos(starDeg2)*r+x,Math.sin(starDeg2)*r+y);
		ctx.arc(x,y,r,starDeg2,dx,false);
		ctx.closePath();
		ctx.fill();
		if(cStep<steps){
			setTimeout(function(){
				_.polygonAnimate(ctx,x,y,r,starDeg,endDeg,during,cStep+1);
			},pertime);
		}
	},
	getRandomPolygonPos:function(s,x,y,r,rr,stardeg){
		var pos=[],temp={};
		var perDeg=Math.PI*2/s;
		for(var i=0;i<s;i++){
			var dx=Math.cos(perDeg*i+stardeg)*(r+(Math.random()-0.5)*rr)+x;
			var dy=Math.sin(perDeg*i+stardeg)*(r+(Math.random()-0.5)*rr)+y;
			pos[i]={x:dx,y:dy};
		}
		return pos;
	},
	getRandomPos:function(){
		var _=this;
		var s=35;//+Math.floor(Math.random()*10);
		var stardeg=Math.PI/Math.floor(180*Math.random());
		var pos1=_.getPolygonPos(s,420,420,420,stardeg);
		
		//var pos2=_.getRandomPolygonPos(s,420,420,420,40,stardeg);
		var pos=[];
		pos[0]=pos1;
		for(var i=1;i<=8;i++){
			var dxdeg=Math.PI/180 *Math.floor(10*Math.random()-5);
			pos[i]=_.getRandomPolygonPos(s-i*4,420,420,420-i*50,25,stardeg+dxdeg);
		}
		return pos;
	},
	drawNetz:function(ctx){
		var _=this;
		var pos=_.getRandomPos();
		ctx.clearRect(0,0,840,840);
		//圈线
		ctx.strokeStyle="#aeb8b9";
		ctx.lineWidth=1;
		for(var j=0;j<pos.length;j++){
			var pos0=pos[j];
			ctx.beginPath();
			ctx.moveTo(pos0[0].x,pos0[0].y);
			for(var i=1;i<pos0.length;i++){
				ctx.lineTo(pos0[i].x,pos0[i].y);
			}
			ctx.closePath();
			ctx.stroke();
		}
		//return;
		//内圈线
		for(var k=1;k<pos.length;k++){//
			var position=pos[k];
			var curindex=null,beback=0;
			for(var index=0;index<position.length;index++){//
				//此点是否连线  ------draw 的时候再判断
				//var belink=!(Math.floor(Math.random()*20));
				//if(belink){continue;}
				//连接外圈对应点
				var ib1=Math.floor(index/position.length*pos[k-1].length);
				var ib2;
				if(curindex=ib1){
					ib2=ib1+1;
				}else{
					ib2=ib1+Math.random()-0.5>0?1:-1;	
				}
				curindex=Math.max(ib1,ib2);

				//计算连接点
				ib2= ib2>= pos[k-1].length ? 0 :(ib2<0?pos[k-1].length-1:ib2);
				//curindex=ib2+1>=pos[k-1].length ? 0 :ib2+1;
				//draw Line
				if(!!Math.floor(Math.random()*40)){ //是否 连接第一点
					ctx.beginPath();
					ctx.moveTo(position[index].x,position[index].y);
					ctx.lineTo(pos[k-1][ib1].x,pos[k-1][ib1].y);
					ctx.closePath();
					ctx.stroke();
				}
				if(!!Math.floor(Math.random()*20)){ //是否 连接第二点
					ctx.beginPath();
					ctx.moveTo(position[index].x,position[index].y);
					ctx.lineTo(pos[k-1][ib2].x,pos[k-1][ib2].y);
					ctx.closePath();
					ctx.stroke();
				}
			}
		}
		return pos;
	},
	init:function(){
		var _=this;
		return _;
	}
}