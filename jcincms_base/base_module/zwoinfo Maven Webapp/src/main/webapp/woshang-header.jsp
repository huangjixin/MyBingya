<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<div id="header" class="globalWidth">
	<div id="header-top">
		<div class="contentWidth">
			<div class="left">
				&nbsp; <span>电话：139 2620 5227</span>&nbsp;&nbsp;|&nbsp; <span>邮箱：635152644@qq.com</span>&nbsp;&nbsp;|&nbsp;
				<span>QQ群：40497044</span>
				&nbsp;&nbsp;<a
					href="http://wpa.qq.com/msgrd?v=3&amp;uin=635152644&amp;site=www.newcapec.com.cn&amp;menu=yes"
					target="_blank"><img alt="在线客服一" border="0"
					src="http://wpa.qq.com/pa?p=2:635152644:46" title="在线客服一" /></a>
				&nbsp; <a
					href=http://wpa.qq.com/msgrd?V=3&uin=517714860&Site=在线客服二&Menu=yes><img
					border="0" SRC=http://wpa.qq.com/pa?p=1:517714860:5 alt="点击咨询"></a>
			</div>
			<div class="right">
				<a onclick="SetHome(window.location)" href="javascript:void(0)">设为首页</a>
				| <a onclick="AddFavorite(window.location,document.title)"
					href="javascript:void(0)">加入收藏</a>        
			</div>
		</div>
	</div>
	<div id="logo" class="contentWidth">
		<div class="left">
			<div style="float: left;">
				<a href="${ctx}/"><span></span><img alt="智沃科技"
					src="${ctx}/images/logo.png"></a>
			</div>
			<div style="float: left;">
				<div style="height: 5px;"></div>
				<i></i><span>致力华南品牌崛起[专注-用心-热情]</span>
			</div>
		</div>
		<!-- <div id="timer">
          <script language="Javascript">
              var datelocalweek=new Array("星期日", "星期一", "星期二","星期三","星期四", "星期五","星期六");
              var datelocalnow=new Date();
              var datelocalyear=datelocalnow.getFullYear();
              var datelocalmonth=(datelocalmonth="0"+(datelocalnow.getMonth()+1)).substr(datelocalmonth.length-2,2);
              var datelocalday=(datelocalday="0"+datelocalnow.getDate()).substr(datelocalday.length-2,2);
              var datelocalweekday=datelocalweek[datelocalnow.getDay()];
              document.write(datelocalyear+"年"+datelocalmonth+"月"+datelocalday+"日 "+datelocalweekday);
         </script>
       </div> -->
	</div>
</div>
