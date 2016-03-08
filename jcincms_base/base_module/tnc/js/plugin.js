//easing
;
jQuery.easing["jswing"] = jQuery.easing["swing"];
jQuery.extend(jQuery.easing, {
    def: "easeOutQuad",
    swing: function(C, _, A, B, $) {
        return jQuery.easing[jQuery.easing.def](C, _, A, B, $)
    },
    easeInQuad: function(C, _, A, B, $) {
        return B * (_ /= $) * _ + A
    },
    easeOutQuad: function(C, _, A, B, $) {
        return - B * (_ /= $) * (_ - 2) + A
    },
    easeInOutQuad: function(C, _, A, B, $) {
        if ((_ /= $ / 2) < 1) return B / 2 * _ * _ + A;
        return - B / 2 * ((--_) * (_ - 2) - 1) + A
    },
    easeInCubic: function(C, _, A, B, $) {
        return B * (_ /= $) * _ * _ + A
    },
    easeOutCubic: function(C, _, A, B, $) {
        return B * ((_ = _ / $ - 1) * _ * _ + 1) + A
    },
    easeInOutCubic: function(C, _, A, B, $) {
        if ((_ /= $ / 2) < 1) return B / 2 * _ * _ * _ + A;
        return B / 2 * ((_ -= 2) * _ * _ + 2) + A
    },
    easeInQuart: function(C, _, A, B, $) {
        return B * (_ /= $) * _ * _ * _ + A
    },
    easeOutQuart: function(C, _, A, B, $) {
        return - B * ((_ = _ / $ - 1) * _ * _ * _ - 1) + A
    },
    easeInOutQuart: function(C, _, A, B, $) {
        if ((_ /= $ / 2) < 1) return B / 2 * _ * _ * _ * _ + A;
        return - B / 2 * ((_ -= 2) * _ * _ * _ - 2) + A
    },
    easeInQuint: function(C, _, A, B, $) {
        return B * (_ /= $) * _ * _ * _ * _ + A
    },
    easeOutQuint: function(C, _, A, B, $) {
        return B * ((_ = _ / $ - 1) * _ * _ * _ * _ + 1) + A
    },
    easeInOutQuint: function(C, _, A, B, $) {
        if ((_ /= $ / 2) < 1) return B / 2 * _ * _ * _ * _ * _ + A;
        return B / 2 * ((_ -= 2) * _ * _ * _ * _ + 2) + A
    },
    easeInSine: function(C, _, A, B, $) {
        return - B * Math.cos(_ / $ * (Math.PI / 2)) + B + A
    },
    easeOutSine: function(C, _, A, B, $) {
        return B * Math.sin(_ / $ * (Math.PI / 2)) + A
    },
    easeInOutSine: function(C, _, A, B, $) {
        return - B / 2 * (Math.cos(Math.PI * _ / $) - 1) + A
    },
    easeInExpo: function(C, _, A, B, $) {
        return (_ == 0) ? A: B * Math.pow(2, 10 * (_ / $ - 1)) + A
    },
    easeOutExpo: function(C, _, A, B, $) {
        return (_ == $) ? A + B: B * ( - Math.pow(2, -10 * _ / $) + 1) + A
    },
    easeInOutExpo: function(C, _, A, B, $) {
        if (_ == 0) return A;
        if (_ == $) return A + B;
        if ((_ /= $ / 2) < 1) return B / 2 * Math.pow(2, 10 * (_ - 1)) + A;
        return B / 2 * ( - Math.pow(2, -10 * --_) + 2) + A
    },
    easeInCirc: function(C, _, A, B, $) {
        return - B * (Math.sqrt(1 - (_ /= $) * _) - 1) + A
    },
    easeOutCirc: function(C, _, A, B, $) {
        return B * Math.sqrt(1 - (_ = _ / $ - 1) * _) + A
    },
    easeInOutCirc: function(C, _, A, B, $) {
        if ((_ /= $ / 2) < 1) return - B / 2 * (Math.sqrt(1 - _ * _) - 1) + A;
        return B / 2 * (Math.sqrt(1 - (_ -= 2) * _) + 1) + A
    },
    easeInElastic: function(F, _, B, C, $) {
        var A = 1.70158,
        E = 0,
        D = C;
        if (_ == 0) return B;
        if ((_ /= $) == 1) return B + C;
        if (!E) E = $ * 0.3;
        if (D < Math.abs(C)) {
            D = C;
            A = E / 4
        } else A = E / (2 * Math.PI) * Math.asin(C / D);
        return - (D * Math.pow(2, 10 * (_ -= 1)) * Math.sin((_ * $ - A) * (2 * Math.PI) / E)) + B
    },
    easeOutElastic: function(F, _, B, C, $) {
        var A = 1.70158,
        E = 0,
        D = C;
        if (_ == 0) return B;
        if ((_ /= $) == 1) return B + C;
        if (!E) E = $ * 0.3;
        if (D < Math.abs(C)) {
            D = C;
            A = E / 4
        } else A = E / (2 * Math.PI) * Math.asin(C / D);
        return D * Math.pow(2, -10 * _) * Math.sin((_ * $ - A) * (2 * Math.PI) / E) + C + B
    },
    easeInOutElastic: function(F, _, B, C, $) {
        var A = 1.70158,
        E = 0,
        D = C;
        if (_ == 0) return B;
        if ((_ /= $ / 2) == 2) return B + C;
        if (!E) E = $ * (0.3 * 1.5);
        if (D < Math.abs(C)) {
            D = C;
            A = E / 4
        } else A = E / (2 * Math.PI) * Math.asin(C / D);
        if (_ < 1) return - 0.5 * (D * Math.pow(2, 10 * (_ -= 1)) * Math.sin((_ * $ - A) * (2 * Math.PI) / E)) + B;
        return D * Math.pow(2, -10 * (_ -= 1)) * Math.sin((_ * $ - A) * (2 * Math.PI) / E) * 0.5 + C + B
    },
    easeInBack: function(D, _, B, C, $, A) {
        if (A == undefined) A = 1.70158;
        return C * (_ /= $) * _ * ((A + 1) * _ - A) + B
    },
    easeOutBack: function(D, _, B, C, $, A) {
        if (A == undefined) A = 1.70158;
        return C * ((_ = _ / $ - 1) * _ * ((A + 1) * _ + A) + 1) + B
    },
    easeInOutBack: function(D, _, B, C, $, A) {
        if (A == undefined) A = 1.70158;
        if ((_ /= $ / 2) < 1) return C / 2 * (_ * _ * (((A *= (1.525)) + 1) * _ - A)) + B;
        return C / 2 * ((_ -= 2) * _ * (((A *= (1.525)) + 1) * _ + A) + 2) + B
    },
    easeInBounce: function(C, _, A, B, $) {
        return B - jQuery.easing.easeOutBounce(C, $ - _, 0, B, $) + A
    },
    easeOutBounce: function(C, _, A, B, $) {
        if ((_ /= $) < (1 / 2.75)) return B * (7.5625 * _ * _) + A;
        else if (_ < (2 / 2.75)) return B * (7.5625 * (_ -= (1.5 / 2.75)) * _ + 0.75) + A;
        else if (_ < (2.5 / 2.75)) return B * (7.5625 * (_ -= (2.25 / 2.75)) * _ + 0.9375) + A;
        else return B * (7.5625 * (_ -= (2.625 / 2.75)) * _ + 0.984375) + A
    },
    easeInOutBounce: function(C, _, A, B, $) {
        if (_ < $ / 2) return jQuery.easing.easeInBounce(C, _ * 2, 0, B, $) * 0.5 + A;
        return jQuery.easing.easeOutBounce(C, _ * 2 - $, 0, B, $) * 0.5 + B * 0.5 + A
    },
    easeOutBounceExt: function(F, _, A, D, $) {
        var C = [{
            Nx: 155.4,
            My: 0,
            Mx: 0,
            Ny: -87.5,
            Px: -48.4,
            Py: -410.95
        },
        {
            Nx: 28.2,
            My: -498.45,
            Mx: 107,
            Ny: 736.6,
            Px: 38.65,
            Py: -354.05
        },
        {
            Nx: 112.3,
            My: -115.9,
            Mx: 173.85,
            Ny: -33.4,
            Px: -48.15,
            Py: -349
        },
        {
            Nx: 26,
            My: -498.3,
            Mx: 238,
            Ny: 552.6,
            Px: 45.7,
            Py: -248.05
        },
        {
            Nx: 100.6,
            My: -193.75,
            Mx: 309.7,
            Ny: -53.4,
            Px: -44.2,
            Py: -256
        },
        {
            Nx: 43.5,
            My: -503.15,
            Mx: 366.1,
            Ny: 356.5,
            Px: 25.95,
            Py: -155.95
        },
        {
            Nx: 89.4,
            My: -302.6,
            Mx: 435.55,
            Ny: -67.4,
            Px: -24.95,
            Py: -130
        },
        {
            My: -500,
            Mx: 500
        }],
        E,
        B;
        B = 500 * _ / $;
        for (E = 0; B > C[E + 1].Mx; E++);
        E = C[E];
        if (E.Px != 0) B = ( - E.Nx + Math.sqrt(E.Nx * E.Nx - 4 * E.Px * (E.Mx - B))) / (2 * E.Px);
        else B = -(E.Mx - B) / E.Nx;
        return A - D * ((E.My + E.Ny * B + E.Py * B * B) / 500)
    },
    c_1_Out: function(F, _, A, D, $) {
        var C = [{
            Mx: 0,
            Nx: 236.6,
            Ny: -996.7,
            My: 0,
            Px: 60.4,
            Py: 494
        },
        {
            Mx: 297,
            Nx: 0,
            Ny: 211.4,
            My: -502.7,
            Px: 0,
            Py: -18.05
        },
        {
            Mx: 297,
            Nx: 190,
            Ny: 1.3,
            My: -309.35,
            Px: 13,
            Py: -191.95
        },
        {
            Mx: 500,
            My: -500
        }],
        E,
        B;
        B = 500 * _ / $;
        for (E = 0; B > C[E + 1].Mx; E++);
        E = C[E];
        if (E.Px != 0) B = ( - E.Nx + Math.sqrt(E.Nx * E.Nx - 4 * E.Px * (E.Mx - B))) / (2 * E.Px);
        else B = -(E.Mx - B) / E.Nx;
        return A - D * ((E.My + E.Ny * B + E.Py * B * B) / 500)
    },
    c_2_Out: function(F, _, A, D, $) {
        var C = [{
            Mx: 0,
            Nx: 103,
            Ny: 1,
            My: 0,
            Px: 54,
            Py: -1
        },
        {
            Mx: 157,
            Nx: 125,
            Ny: -1,
            My: 0,
            Px: -14,
            Py: -62
        },
        {
            Mx: 268,
            Nx: 121,
            Ny: -271,
            My: -63,
            Px: 15,
            Py: -82
        },
        {
            Mx: 404,
            Nx: 73,
            Ny: -151,
            My: -416,
            Px: 23,
            Py: 67
        },
        {
            Mx: 500,
            My: -500
        }],
        E,
        B;
        B = 500 * _ / $;
        for (E = 0; B > C[E + 1].Mx; E++);
        E = C[E];
        if (E.Px != 0) B = ( - E.Nx + Math.sqrt(E.Nx * E.Nx - 4 * E.Px * (E.Mx - B))) / (2 * E.Px);
        else B = -(E.Mx - B) / E.Nx;
        return A - D * ((E.My + E.Ny * B + E.Py * B * B) / 500)
    }
});

//mousewheel
; (function($) {
    var _ = ["DOMMouseScroll", "mousewheel"];
    if ($.event.fixHooks) for (var B = _.length; B;) $.event.fixHooks[_[--B]] = $.event.mouseHooks;
    $.event.special.mousewheel = {
        setup: function() {
            if (this.addEventListener) {
                for (var $ = _.length; $;) this.addEventListener(_[--$], A, false)
            } else this.onmousewheel = A
        },
        teardown: function() {
            if (this.removeEventListener) {
                for (var $ = _.length; $;) this.removeEventListener(_[--$], A, false)
            } else this.onmousewheel = null
        }
    };
    $.fn.extend({
        mousewheel: function($) {
            return $ ? this.bind("mousewheel", $) : this.trigger("mousewheel")
        },
        unmousewheel: function($) {
            return this.unbind("mousewheel", $)
        }
    });
    function A(B) {
        var _ = B || window.event,
        A = [].slice.call(arguments, 1),
        D = 0,
        C = true,
        E = 0,
        F = 0;
        B = $.event.fix(_);
        B.type = "mousewheel";
        if (_.wheelDelta) D = _.wheelDelta / 120;
        if (_.detail) D = -_.detail / 3;
        F = D;
        if (_.axis !== undefined && _.axis === _.HORIZONTAL_AXIS) {
            F = 0;
            E = -1 * D
        }
        if (_.wheelDeltaY !== undefined) F = _.wheelDeltaY / 120;
        if (_.wheelDeltaX !== undefined) E = -1 * _.wheelDeltaX / 120;
        A.unshift(B, D, E, F);
        return ($.event.dispatch || $.event.handle).apply(this, A)
    }
})(jQuery);

//nicescroll
/* jquery.nicescroll 3.0.0 InuYaksa*2012 MIT http://areaaperta.com/nicescroll */
(function(d) {
    var s = false,
    w = false,
    B = 5E3,
    C = 2E3,
    D = function() {
        var d = document.getElementsByTagName("script"),
        d = d[d.length - 1].src.split("?")[0];
        return d.split("/").length > 0 ? d.split("/").slice(0, -1).join("/") + "/": ""
    } (),
    q = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame || false,
    r = window.cancelRequestAnimationFrame || window.webkitCancelRequestAnimationFrame || window.mozCancelRequestAnimationFrame || window.oCancelRequestAnimationFrame || window.msCancelRequestAnimationFrame || false,
    x = false,
    E = function() {
        if (x) return x;
        var d = document.createElement("DIV"),
        c = {
            haspointerlock: "pointerLockElement" in document || "mozPointerLockElement" in document || "webkitPointerLockElement" in document
        };
        c.isopera = "opera" in window;
        c.isopera12 = c.isopera && "getUserMedia" in navigator;
        c.isie = "all" in document && "attachEvent" in d && !c.isopera;
        c.isieold = c.isie && !("msInterpolationMode" in d.style);
        c.isie7 = c.isie && !c.isieold && (!("documentMode" in document) || document.documentMode == 7);
        c.isie8 = c.isie && "documentMode" in document && document.documentMode == 8;
        c.isie9 = c.isie && "performance" in window && document.documentMode >= 9;
        c.isie10 = c.isie && "performance" in window && document.documentMode >= 10;
        c.isie9mobile = /iemobile.9/i.test(navigator.userAgent);
        if (c.isie9mobile) c.isie9 = false;
        c.isie7mobile = !c.isie9mobile && c.isie7 && /iemobile/i.test(navigator.userAgent);
        c.ismozilla = "MozAppearance" in d.style;
        c.iswebkit = "WebkitAppearance" in d.style;
        c.ischrome = "chrome" in window;
        c.ischrome22 = c.ischrome && c.haspointerlock;
        c.cantouch = "ontouchstart" in document.documentElement;
        c.hasmstouch = window.navigator.msPointerEnabled || false;
        c.ismac = /^mac$/i.test(navigator.platform);
        c.isios = c.cantouch && /iphone|ipad|ipod/i.test(navigator.platform);
        c.isios4 = c.isios && !("seal" in Object);
        c.isandroid = /android/i.test(navigator.userAgent);
        c.trstyle = false;
        c.hastransform = false;
        c.hastranslate3d = false;
        c.transitionstyle = false;
        c.hastransition = false;
        c.transitionend = false;
        for (var h = ["transform", "msTransform", "webkitTransform", "MozTransform", "OTransform"], i = 0; i < h.length; i++) if (typeof d.style[h[i]] != "undefined") {
            c.trstyle = h[i];
            break
        }
        c.hastransform = c.trstyle != false;
        if (c.hastransform) d.style[c.trstyle] = "translate3d(1px,2px,3px)",
        c.hastranslate3d = /translate3d/.test(d.style[c.trstyle]);
        c.transitionstyle = false;
        c.prefixstyle = "";
        c.transitionend = false;
        for (var h = "transition,webkitTransition,MozTransition,OTransition,OTransition,msTransition,KhtmlTransition".split(","), b = ",-webkit-,-moz-,-o-,-o,-ms-,-khtml-".split(","), o = "transitionend,webkitTransitionEnd,transitionend,otransitionend,oTransitionEnd,msTransitionEnd,KhtmlTransitionEnd".split(","), i = 0; i < h.length; i++) if (h[i] in d.style) {
            c.transitionstyle = h[i];
            c.prefixstyle = b[i];
            c.transitionend = o[i];
            break
        }
        c.hastransition = c.transitionstyle;
        a: {
            h = ["-moz-grab", "-webkit-grab", "grab"];
            if (c.ischrome && !c.ischrome22 || c.isie) h = [];
            for (i = 0; i < h.length; i++) if (b = h[i], d.style.cursor = b, d.style.cursor == b) {
                h = b;
                break a
            }
            h = "url(http://www.google.com/intl/en_ALL/mapfiles/openhand.cur),n-resize"
        }
        c.cursorgrabvalue = h;
        c.hasmousecapture = "setCapture" in d;
        return x = c
    },
    F = function(j, c) {
        function h(f, c, g) {
            c = f.css(c);
            f = parseFloat(c);
            return isNaN(f) ? (f = p[c] || 0, g = f == 3 ? g ? b.win.outerHeight() - b.win.innerHeight() : b.win.outerWidth() - b.win.innerWidth() : 1, b.isie8 && f && (f += 1), g ? f: 0) : f
        }
        function i(f, c) {
            var g = 0,
            e = 0;
            if ("wheelDeltaY" in f) g = Math.floor(f.wheelDeltaX / 2),
            e = Math.floor(f.wheelDeltaY / 2);
            else {
                var d = f.detail ? f.detail * -1 : f.wheelDelta / 40;
                d && (c ? g = Math.floor(d * b.opt.mousescrollstep) : e = Math.floor(d * b.opt.mousescrollstep))
            }
            g && (b.scrollmom && b.scrollmom.stop(), b.lastdeltax += g, b.synched("mousewheelx",
            function() {
                var f = b.lastdeltax;
                b.lastdeltax = 0;
                b.rail.drag || b.doScrollLeftBy(f)
            }));
            e && (b.scrollmom && b.scrollmom.stop(), b.lastdeltay += e, b.synched("mousewheely",
            function() {
                var f = b.lastdeltay;
                b.lastdeltay = 0;
                b.rail.drag || b.doScrollBy(f)
            }))
        }
        var b = this;
        this.version = "3.0.0";
        this.name = "nicescroll";
        this.me = c;
        this.opt = {
            doc: d("body"),
            win: false,
            zindex: 9E3,
            cursoropacitymin: 0,
            cursoropacitymax: 1,
            cursorcolor: "#424242",
            cursorwidth: "5px",
            cursorborder: "1px solid #fff",
            cursorborderradius: "5px",
            scrollspeed: 60,
            mousescrollstep: 24,
            touchbehavior: false,
            hwacceleration: true,
            usetransition: true,
            boxzoom: false,
            dblclickzoom: true,
            gesturezoom: true,
            grabcursorenabled: true,
            autohidemode: true,
            background: "",
            iframeautoresize: true,
            cursorminheight: 32,
            preservenativescrolling: true,
            railoffset: false,
            bouncescroll: true,
            spacebarenabled: true,
            railpadding: {
                top: 0,
                right: 0,
                left: 0,
                bottom: 0
            },
            disableoutline: true,
            horizrailenabled: true,
            railalign: "right",
            railvalign: "bottom",
            enabletranslate3d: true,
            enablemousewheel: true,
            enablekeyboard: true,
            smoothscroll: true,
            sensitiverail: true,
            railclass: ""
        };
        this.opt.snapbackspeed = 80;
        if (j) for (var o in b.opt) typeof j[o] != "undefined" && (b.opt[o] = j[o]);
        this.iddoc = (this.doc = b.opt.doc) && this.doc[0] ? this.doc[0].id || "": "";
        this.ispage = /BODY|HTML/.test(b.opt.win ? b.opt.win[0].nodeName: this.doc[0].nodeName);
        this.haswrapper = b.opt.win !== false;
        this.win = b.opt.win || (this.ispage ? d(window) : this.doc);
        this.docscroll = this.ispage && !this.haswrapper ? d(window) : this.win;
        this.body = d("body");
        this.iframe = this.isfixed = false;
        this.isiframe = this.doc[0].nodeName == "IFRAME" && this.win[0].nodeName == "IFRAME";
        this.istextarea = this.win[0].nodeName == "TEXTAREA";
        this.forcescreen = false;
        this.canshowonmouseevent = b.opt.autohidemode != "scroll";
        this.page = this.view = this.onzoomout = this.onzoomin = this.onscrollcancel = this.onscrollend = this.onscrollstart = this.onclick = this.ongesturezoom = this.onkeypress = this.onmousewheel = this.onmousemove = this.onmouseup = this.onmousedown = false;
        this.scroll = {
            x: 0,
            y: 0
        };
        this.scrollratio = {
            x: 0,
            y: 0
        };
        this.cursorheight = 20;
        this.scrollvaluemax = 0;
        this.observer = this.scrollmom = this.scrollrunning = false;
        do this.id = "ascrail" + C++;
        while (document.getElementById(this.id));
        this.hasmousefocus = this.hasfocus = this.zoomactive = this.zoom = this.cursorfreezed = this.cursor = this.rail = false;
        this.visibility = true;
        this.hidden = this.locked = false;
        this.cursoractive = true;
        this.nativescrollingarea = false;
        this.events = [];
        this.saved = {};
        this.delaylist = {};
        this.synclist = {};
        this.lastdeltay = this.lastdeltax = 0;
        var e = this.detected = E();
        this.ishwscroll = (this.canhwscroll = e.hastransform && b.opt.hwacceleration) && b.haswrapper;
        this.istouchcapable = false;
        if (e.cantouch && e.ischrome && !e.isios && !e.isandroid) this.istouchcapable = true,
        e.cantouch = false;
        if (e.cantouch && e.ismozilla && !e.isios) this.istouchcapable = true,
        e.cantouch = false;
        this.delayed = function(f, c, g, e) {
            var d = b.delaylist[f],
            h = (new Date).getTime();
            if (!e && d && d.tt) return false;
            d && d.tt && clearTimeout(d.tt);
            if (d && d.last + g > h && !d.tt) b.delaylist[f] = {
                last: h + g,
                tt: setTimeout(function() {
                    b.delaylist[f].tt = 0;
                    c.call()
                },
                g)
            };
            else if (!d || !d.tt) b.delaylist[f] = {
                last: h,
                tt: 0
            },
            setTimeout(function() {
                c.call()
            },
            0)
        };
        this.synched = function(f, c) {
            b.synclist[f] = c; (function() {
                if (!b.onsync) q(function() {
                    b.onsync = false;
                    for (f in b.synclist) {
                        var c = b.synclist[f];
                        c && c.call(b);
                        b.synclist[f] = false
                    }
                }),
                b.onsync = true
            })();
            return f
        };
        this.unsynched = function(f) {
            b.synclist[f] && (b.synclist[f] = false)
        };
        this.css = function(f, c) {
            for (var g in c) b.saved.css.push([f, g, f.css(g)]),
            f.css(g, c[g])
        };
        this.scrollTop = function(f) {
            return typeof f == "undefined" ? b.getScrollTop() : b.setScrollTop(f)
        };
        this.scrollLeft = function(f) {
            return typeof f == "undefined" ? b.getScrollLeft() : b.setScrollLeft(f)
        };
        BezierClass = function(b, c, g, e, d, h, i) {
            this.st = b;
            this.ed = c;
            this.spd = g;
            this.p1 = e || 0;
            this.p2 = d || 1;
            this.p3 = h || 0;
            this.p4 = i || 1;
            this.ts = (new Date).getTime();
            this.df = this.ed - this.st
        };
        BezierClass.prototype = {
            B2: function(b) {
                return 3 * b * b * (1 - b)
            },
            B3: function(b) {
                return 3 * b * (1 - b) * (1 - b)
            },
            B4: function(b) {
                return (1 - b) * (1 - b) * (1 - b)
            },
            getNow: function() {
                var b = 1 - ((new Date).getTime() - this.ts) / this.spd,
                c = this.B2(b) + this.B3(b) + this.B4(b);
                return b < 0 ? this.ed: this.st + Math.round(this.df * c)
            },
            update: function(b, c) {
                this.st = this.getNow();
                this.ed = b;
                this.spd = c;
                this.ts = (new Date).getTime();
                this.df = this.ed - this.st;
                return this
            }
        };
        if (this.ishwscroll) {
            this.doc.translate = {
                x: 0,
                y: 0,
                tx: "0px",
                ty: "0px"
            };
            e.hastranslate3d && e.isios && this.doc.css("-webkit-backface-visibility", "hidden");
            var n = function() {
                var f = b.doc.css(e.trstyle);
                return f && f.substr(0, 6) == "matrix" ? f.replace(/^.*\((.*)\)$/g, "$1").replace(/px/g, "").split(/, +/) : false
            };
            this.getScrollTop = function(f) {
                if (!f) {
                    if (f = n()) return f.length == 16 ? -f[13] : -f[5];
                    if (b.timerscroll && b.timerscroll.bz) return b.timerscroll.bz.getNow()
                }
                return b.doc.translate.y
            };
            this.getScrollLeft = function(f) {
                if (!f) {
                    if (f = n()) return f.length == 16 ? -f[12] : -f[4];
                    if (b.timerscroll && b.timerscroll.bh) return b.timerscroll.bh.getNow()
                }
                return b.doc.translate.x
            };
            this.notifyScrollEvent = document.createEvent ?
            function(b) {
                var c = document.createEvent("UIEvents");
                c.initUIEvent("scroll", false, true, window, 1);
                b.dispatchEvent(c)
            }: document.fireEvent ?
            function(b) {
                var c = document.createEventObject();
                b.fireEvent("onscroll");
                c.cancelBubble = true
            }: function() {};
            e.hastranslate3d && b.opt.enabletranslate3d ? (this.setScrollTop = function(f, c) {
                b.doc.translate.y = f;
                b.doc.translate.ty = f * -1 + "px";
                b.doc.css(e.trstyle, "translate3d(" + b.doc.translate.tx + "," + b.doc.translate.ty + ",0px)");
                c || b.notifyScrollEvent(b.win[0])
            },
            this.setScrollLeft = function(f, c) {
                b.doc.translate.x = f;
                b.doc.translate.tx = f * -1 + "px";
                b.doc.css(e.trstyle, "translate3d(" + b.doc.translate.tx + "," + b.doc.translate.ty + ",0px)");
                c || b.notifyScrollEvent(b.win[0])
            }) : (this.setScrollTop = function(f, c) {
                b.doc.translate.y = f;
                b.doc.translate.ty = f * -1 + "px";
                b.doc.css(e.trstyle, "translate(" + b.doc.translate.tx + "," + b.doc.translate.ty + ")");
                c || b.notifyScrollEvent(b.win[0])
            },
            this.setScrollLeft = function(f, c) {
                b.doc.translate.x = f;
                b.doc.translate.tx = f * -1 + "px";
                b.doc.css(e.trstyle, "translate(" + b.doc.translate.tx + "," + b.doc.translate.ty + ")");
                c || b.notifyScrollEvent(b.win[0])
            })
        } else this.getScrollTop = function() {
            return b.docscroll.scrollTop()
        },
        this.setScrollTop = function(f) {
            return b.docscroll.scrollTop(f)
        },
        this.getScrollLeft = function() {
            return b.docscroll.scrollLeft()
        },
        this.setScrollLeft = function(f) {
            return b.docscroll.scrollLeft(f)
        };
        this.getTarget = function(b) {
            return ! b ? false: b.target ? b.target: b.srcElement ? b.srcElement: false
        };
        this.hasParent = function(b, c) {
            if (!b) return false;
            for (var g = b.target || b.srcElement || b || false; g && g.id != c;) g = g.parentNode || false;
            return g !== false
        };
        var p = {
            thin: 1,
            medium: 3,
            thick: 5
        };
        this.updateScrollBar = function(f) {
            if (b.ishwscroll) b.rail.css({
                height: b.win.innerHeight()
            }),
            b.railh && b.railh.css({
                width: b.win.innerWidth()
            });
            else {
                var c = b.isfixed ? {
                    top: parseFloat(b.win.css("top")),
                    left: parseFloat(b.win.css("left"))
                }: b.win.offset(),
                g = c.top,
                e = c.left;
                g += h(b.win, "border-top-width", true);
                b.win.outerWidth();
                b.win.innerWidth();
                e += b.rail.align ? b.win.outerWidth() - h(b.win, "border-right-width") - b.rail.width: h(b.win, "border-left-width");
                var d = b.opt.railoffset;
                d && (d.top && (g += d.top), b.rail.align && d.left && (e += d.left));
                b.locked || b.rail.css({
                    top: g,
                    left: e,
                    height: f ? f.h: b.win.innerHeight()
                });
                b.zoom && b.zoom.css({
                    top: g + 1,
                    left: b.rail.align == 1 ? e - 20 : e + b.rail.width + 4
                });
                if (b.railh && !b.locked) g = c.top,
                e = c.left,
                f = b.railh.align ? g + h(b.win, "border-top-width", true) + b.win.innerHeight() - b.railh.height: g + h(b.win, "border-top-width", true),
                e += h(b.win, "border-left-width"),
                b.railh.css({
                    top: f,
                    left: e,
                    width: b.railh.width
                })
            }
        };
        this.doRailClick = function(f, c, g) {
            var e; ! (b.rail.drag && b.rail.drag.pt != 1) && !b.locked && !b.rail.drag && (b.cancelScroll(), b.cancelEvent(f), c ? (c = g ? b.doScrollLeft: b.doScrollTop, e = g ? (f.pageX - b.railh.offset().left - b.cursorwidth / 2) * b.scrollratio.x: (f.pageY - b.rail.offset().top - b.cursorheight / 2) * b.scrollratio.y, c(e)) : (c = g ? b.doScrollLeftBy: b.doScrollBy, e = g ? b.scroll.x: b.scroll.y, f = g ? f.pageX - b.railh.offset().left: f.pageY - b.rail.offset().top, g = g ? b.view.w: b.view.h, e >= f ? c(g) : c( - g)))
        };
        b.hasanimationframe = q;
        b.hascancelanimationframe = r;
        b.hasanimationframe ? b.hascancelanimationframe || (r = function() {
            b.cancelAnimationFrame = true
        }) : (q = function(b) {
            return setTimeout(b, 16)
        },
        r = clearInterval);
        this.init = function() {
            b.saved.css = [];
            if (e.isie7mobile) return true;
            e.hasmstouch && b.css(b.ispage ? d("html") : b.win, {
                "-ms-touch-action": "none"
            });
            if (!b.ispage || !e.cantouch && !e.isieold && !e.isie9mobile) {
                var f = b.docscroll;
                b.ispage && (f = b.haswrapper ? b.win: b.doc);
                e.isie9mobile || b.css(f, {
                    "overflow-y": "hidden"
                });
                b.ispage && e.isie7 && (b.doc[0].nodeName == "BODY" ? b.css(d("html"), {
                    "overflow-y": "hidden"
                }) : b.doc[0].nodeName == "HTML" && b.css(d("body"), {
                    "overflow-y": "hidden"
                }));
                e.isios && !b.ispage && !b.haswrapper && b.css(d("body"), {
                    "-webkit-overflow-scrolling": "touch"
                });
                var c = d(document.createElement("div"));
                c.css({
                    position: "relative",
                    top: 0,
                    "float": "right",
                    width: b.opt.cursorwidth,
                    height: "0px",
                    "background-color": b.opt.cursorcolor,
                    border: b.opt.cursorborder,
                    "background-clip": "padding-box",
                    "-webkit-border-radius": b.opt.cursorborderradius,
                    "-moz-border-radius": b.opt.cursorborderradius,
                    "border-radius": b.opt.cursorborderradius
                });
                c.hborder = parseFloat(c.outerHeight() - c.innerHeight());
                b.cursor = c;
                var g = d(document.createElement("div"));
                g.attr("id", b.id);
                g.attr("class", b.opt.railclass);
                var h, i, j = ["left", "right"],
                y;
                for (y in j) i = j[y],
                (h = b.opt.railpadding[i]) ? g.css("padding-" + i, h + "px") : b.opt.railpadding[i] = 0;
                g.append(c);
                g.width = Math.max(parseFloat(b.opt.cursorwidth), c.outerWidth()) + b.opt.railpadding.left + b.opt.railpadding.right;
                g.css({
                    width: g.width + "px",
                    zIndex: b.ispage ? b.opt.zindex: b.opt.zindex + 2,
                    background: b.opt.background
                });
                g.visibility = true;
                g.scrollable = true;
                g.align = b.opt.railalign == "left" ? 0 : 1;
                b.rail = g;
                c = b.rail.drag = false;
                if (b.opt.boxzoom && !b.ispage && !e.isieold && (c = document.createElement("div"), b.bind(c, "click", b.doZoom), b.zoom = d(c), b.zoom.css({
                    cursor: "pointer",
                    "z-index": b.opt.zindex,
                    backgroundImage: "url(" + D + "zoomico.png)",
                    height: 18,
                    width: 18,
                    backgroundPosition: "0px 0px"
                }), b.opt.dblclickzoom && b.bind(b.win, "dblclick", b.doZoom), e.cantouch && b.opt.gesturezoom)) b.ongesturezoom = function(c) {
                    c.scale > 1.5 && b.doZoomIn(c);
                    c.scale < 0.8 && b.doZoomOut(c);
                    return b.cancelEvent(c)
                },
                b.bind(b.win, "gestureend", b.ongesturezoom);
                b.railh = false;
                if (b.opt.horizrailenabled) {
                    b.css(f, {
                        "overflow-x": "hidden"
                    });
                    c = d(document.createElement("div"));
                    c.css({
                        position: "relative",
                        top: 0,
                        height: b.opt.cursorwidth,
                        width: "0px",
                        "background-color": b.opt.cursorcolor,
                        border: b.opt.cursorborder,
                        "background-clip": "padding-box",
                        "-webkit-border-radius": b.opt.cursorborderradius,
                        "-moz-border-radius": b.opt.cursorborderradius,
                        "border-radius": b.opt.cursorborderradius
                    });
                    c.wborder = parseFloat(c.outerWidth() - c.innerWidth());
                    b.cursorh = c;
                    var k = d(document.createElement("div"));
                    k.attr("id", b.id + "-hr");
                    k.attr("class", b.opt.railclass);
                    k.height = 1 + Math.max(parseFloat(b.opt.cursorwidth), c.outerHeight());
                    k.css({
                        height: k.height + "px",
                        zIndex: b.ispage ? b.opt.zindex: b.opt.zindex + 2,
                        background: b.opt.background
                    });
                    k.append(c);
                    k.visibility = true;
                    k.scrollable = true;
                    k.align = b.opt.railvalign == "top" ? 0 : 1;
                    b.railh = k;
                    b.railh.drag = false
                }
                b.ispage ? (g.css({
                    position: "fixed",
                    top: "0px",
                    height: "100%"
                }), g.align ? g.css({
                    right: "0px"
                }) : g.css({
                    left: "0px"
                }), b.body.append(g), b.railh && (k.css({
                    position: "fixed",
                    left: "0px",
                    width: "100%"
                }), k.align ? k.css({
                    bottom: "0px"
                }) : k.css({
                    top: "0px"
                }), b.body.append(k))) : (b.ishwscroll ? (b.win.css("position") == "static" && b.css(b.win, {
                    position: "relative"
                }), f = b.win[0].nodeName == "HTML" ? b.body: b.win, b.zoom && (b.zoom.css({
                    position: "absolute",
                    top: 1,
                    right: 0,
                    "margin-right": g.width + 4
                }), f.append(b.zoom)), g.css({
                    position: "absolute",
                    top: 0
                }), g.align ? g.css({
                    right: 0
                }) : g.css({
                    left: 0
                }), f.append(g), k && (k.css({
                    position: "absolute",
                    left: 0,
                    bottom: 0
                }), k.align ? k.css({
                    bottom: 0
                }) : k.css({
                    top: 0
                }), f.append(k))) : (b.isfixed = b.win.css("position") == "fixed", f = b.isfixed ? "fixed": "absolute", g.css({
                    position: f
                }), b.zoom && b.zoom.css({
                    position: f
                }), b.updateScrollBar(), b.body.append(g), b.zoom && b.body.append(b.zoom), b.railh && (k.css({
                    position: f
                }), b.body.append(k))), e.isios && b.css(b.win, {
                    "-webkit-tap-highlight-color": "rgba(0,0,0,0)",
                    "-webkit-touch-callout": "none"
                }), e.isie && b.opt.disableoutline && b.win.attr("hideFocus", "true"), e.iswebkit && b.opt.disableoutline && b.win.css({
                    outline: "none"
                }));
                if (b.opt.autohidemode === false) b.autohidedom = false;
                else if (b.opt.autohidemode === true) {
                    if (b.autohidedom = d().add(b.rail), b.railh) b.autohidedom = b.autohidedom.add(b.railh)
                } else if (b.opt.autohidemode == "scroll") {
                    if (b.autohidedom = d().add(b.rail), b.railh) b.autohidedom = b.autohidedom.add(b.railh)
                } else if (b.opt.autohidemode == "cursor") {
                    if (b.autohidedom = d().add(b.cursor), b.railh) b.autohidedom = b.autohidedom.add(b.railh.cursor)
                } else if (b.opt.autohidemode == "hidden") b.autohidedom = false,
                b.hide(),
                b.locked = false;
                if (e.isie9mobile) b.scrollmom = new z(b),
                b.onmangotouch = function() {
                    var c = b.getScrollTop(),
                    f = b.getScrollLeft();
                    if (c == b.scrollmom.lastscrolly && f == b.scrollmom.lastscrollx) return true;
                    var g = c - b.mangotouch.sy,
                    e = f - b.mangotouch.sx;
                    if (Math.round(Math.sqrt(Math.pow(e, 2) + Math.pow(g, 2))) != 0) {
                        var l = g < 0 ? -1 : 1,
                        d = e < 0 ? -1 : 1,
                        h = +new Date;
                        b.mangotouch.lazy && clearTimeout(b.mangotouch.lazy);
                        if (h - b.mangotouch.tm > 80 || b.mangotouch.dry != l || b.mangotouch.drx != d) b.scrollmom.stop(),
                        b.scrollmom.reset(f, c),
                        b.mangotouch.sy = c,
                        b.mangotouch.ly = c,
                        b.mangotouch.sx = f,
                        b.mangotouch.lx = f,
                        b.mangotouch.dry = l,
                        b.mangotouch.drx = d,
                        b.mangotouch.tm = h;
                        else if (b.scrollmom.stop(), b.scrollmom.update(b.mangotouch.sx - e, b.mangotouch.sy - g), b.mangotouch.tm = h, g = Math.max(Math.abs(b.mangotouch.ly - c), Math.abs(b.mangotouch.lx - f)), b.mangotouch.ly = c, b.mangotouch.lx = f, g > 2) b.mangotouch.lazy = setTimeout(function() {
                            b.mangotouch.lazy = false;
                            b.mangotouch.dry = 0;
                            b.mangotouch.drx = 0;
                            b.mangotouch.tm = 0;
                            b.scrollmom.doMomentum(30)
                        },
                        100)
                    }
                },
                g = b.getScrollTop(),
                k = b.getScrollLeft(),
                b.mangotouch = {
                    sy: g,
                    ly: g,
                    dry: 0,
                    sx: k,
                    lx: k,
                    drx: 0,
                    lazy: false,
                    tm: 0
                },
                b.bind(b.docscroll, "scroll", b.onmangotouch);
                else {
                    if (e.cantouch || b.istouchcapable || b.opt.touchbehavior || e.hasmstouch) {
                        b.scrollmom = new z(b);
                        b.ontouchstart = function(c) {
                            if (c.pointerType && c.pointerType != 2) return false;
                            if (!b.locked) {
                                if (e.hasmstouch) for (var f = c.target ? c.target: false; f;) {
                                    var g = d(f).getNiceScroll();
                                    if (g.length > 0 && g[0].me == b.me) break;
                                    if (g.length > 0) return false;
                                    if (f.nodeName == "DIV" && f.id == b.id) break;
                                    f = f.parentNode ? f.parentNode: false
                                }
                                b.cancelScroll();
                                if ((f = b.getTarget(c)) && /INPUT/i.test(f.nodeName) && /range/i.test(f.type)) return b.stopPropagation(c);
                                if (b.forcescreen) g = c,
                                c = {
                                    original: c.original ? c.original: c
                                },
                                c.clientX = g.screenX,
                                c.clientY = g.screenY;
                                b.rail.drag = {
                                    x: c.clientX,
                                    y: c.clientY,
                                    sx: b.scroll.x,
                                    sy: b.scroll.y,
                                    st: b.getScrollTop(),
                                    sl: b.getScrollLeft(),
                                    pt: 2
                                };
                                b.opt.touchbehavior && b.isiframe && e.isie && (g = b.win.position(), b.rail.drag.x += g.left, b.rail.drag.y += g.top);
                                b.hasmoving = false;
                                b.lastmouseup = false;
                                b.scrollmom.reset(c.clientX, c.clientY);
                                if (!e.cantouch && !this.istouchcapable && !e.hasmstouch) {
                                    if (!f || !/INPUT|SELECT|TEXTAREA/i.test(f.nodeName)) return ! b.ispage && e.hasmousecapture && f.setCapture(),
                                    b.cancelEvent(c);
                                    if (/SUBMIT|CANCEL|BUTTON/i.test(d(f).attr("type"))) pc = {
                                        tg: f,
                                        click: false
                                    },
                                    b.preventclick = pc
                                }
                            }
                        };
                        b.ontouchend = function(c) {
                            if (c.pointerType && c.pointerType != 2) return false;
                            if (b.rail.drag && b.rail.drag.pt == 2 && (b.scrollmom.doMomentum(), b.rail.drag = false, b.hasmoving && (b.hasmoving = false, b.lastmouseup = true, b.hideCursor(), e.hasmousecapture && document.releaseCapture(), !e.cantouch))) return b.cancelEvent(c)
                        };
                        var o = b.opt.touchbehavior && b.isiframe && !e.hasmousecapture;
                        b.ontouchmove = function(c, f) {
                            if (c.pointerType && c.pointerType != 2) return false;
                            if (b.rail.drag && b.rail.drag.pt == 2) {
                                if (e.cantouch && typeof c.original == "undefined") return true;
                                b.hasmoving = true;
                                if (b.preventclick && !b.preventclick.click) b.preventclick.click = b.preventclick.tg.onclick || false,
                                b.preventclick.tg.onclick = b.onpreventclick;
                                if (b.forcescreen) {
                                    var g = c,
                                    c = {
                                        original: c.original ? c.original: c
                                    };
                                    c.clientX = g.screenX;
                                    c.clientY = g.screenY
                                }
                                g = ofy = 0;
                                if (o && !f) {
                                    var l = b.win.position(),
                                    g = -l.left;
                                    ofy = -l.top
                                }
                                var d = c.clientY + ofy,
                                h = b.rail.drag.st - (d - b.rail.drag.y);
                                if (b.ishwscroll && b.opt.bouncescroll) h < 0 ? h = Math.round(h / 2) : h > b.page.maxh && (h = b.page.maxh + Math.round((h - b.page.maxh) / 2));
                                else if (h < 0 && (d = h = 0), h > b.page.maxh) h = b.page.maxh,
                                d = 0;
                                var i = c.clientX + g;
                                if (b.railh && b.railh.scrollable) {
                                    var m = b.rail.drag.sl - (i - b.rail.drag.x);
                                    if (b.ishwscroll && b.opt.bouncescroll) m < 0 ? m = Math.round(m / 2) : m > b.page.maxw && (m = b.page.maxw + Math.round((m - b.page.maxw) / 2));
                                    else if (m < 0 && (i = m = 0), m > b.page.maxw) m = b.page.maxw,
                                    i = 0
                                }
                                b.synched("touchmove",
                                function() {
                                    b.rail.drag && b.rail.drag.pt == 2 && (b.prepareTransition && b.prepareTransition(0), b.rail.scrollable && b.setScrollTop(h), b.scrollmom.update(i, d), b.railh && b.railh.scrollable ? (b.setScrollLeft(m), b.showCursor(h, m)) : b.showCursor(h), e.isie10 && document.selection.clear())
                                });
                                return b.cancelEvent(c)
                            }
                        }
                    }
                    e.cantouch || b.opt.touchbehavior ? (b.onpreventclick = function(c) {
                        if (b.preventclick) return b.preventclick.tg.onclick = b.preventclick.click,
                        b.preventclick = false,
                        b.cancelEvent(c)
                    },
                    b.onmousedown = b.ontouchstart, b.onmouseup = b.ontouchend, b.onclick = e.isios ? false: function(c) {
                        return b.lastmouseup ? (b.lastmouseup = false, b.cancelEvent(c)) : true
                    },
                    b.onmousemove = b.ontouchmove, e.cursorgrabvalue && (b.css(b.ispage ? b.doc: b.win, {
                        cursor: e.cursorgrabvalue
                    }), b.css(b.rail, {
                        cursor: e.cursorgrabvalue
                    }))) : (b.onmousedown = function(c, f) {
                        if (! (b.rail.drag && b.rail.drag.pt != 1)) {
                            if (b.locked) return b.cancelEvent(c);
                            b.cancelScroll();
                            b.rail.drag = {
                                x: c.clientX,
                                y: c.clientY,
                                sx: b.scroll.x,
                                sy: b.scroll.y,
                                pt: 1,
                                hr: !!f
                            };
                            var g = b.getTarget(c); ! b.ispage && e.hasmousecapture && g.setCapture();
                            if (b.isiframe && !e.hasmousecapture) b.saved.csspointerevents = b.doc.css("pointer-events"),
                            b.css(b.doc, {
                                "pointer-events": "none"
                            });
                            return b.cancelEvent(c)
                        }
                    },
                    b.onmouseup = function(c) {
                        if (b.rail.drag && (e.hasmousecapture && document.releaseCapture(), b.isiframe && !e.hasmousecapture && b.doc.css("pointer-events", b.saved.csspointerevents), b.rail.drag.pt == 1)) return b.rail.drag = false,
                        b.cancelEvent(c)
                    },
                    b.onmousemove = function(c) {
                        if (b.rail.drag) {
                            if (b.rail.drag.pt == 1) {
                                if (e.ischrome && c.which == 0) return b.onmouseup(c);
                                b.cursorfreezed = true;
                                if (b.rail.drag.hr) {
                                    b.scroll.x = b.rail.drag.sx + (c.clientX - b.rail.drag.x);
                                    if (b.scroll.x < 0) b.scroll.x = 0;
                                    var f = b.scrollvaluemaxw;
                                    if (b.scroll.x > f) b.scroll.x = f
                                } else {
                                    b.scroll.y = b.rail.drag.sy + (c.clientY - b.rail.drag.y);
                                    if (b.scroll.y < 0) b.scroll.y = 0;
                                    f = b.scrollvaluemax;
                                    if (b.scroll.y > f) b.scroll.y = f
                                }
                                b.synched("mousemove",
                                function() {
                                    b.rail.drag && b.rail.drag.pt == 1 && (b.showCursor(), b.rail.drag.hr ? b.doScrollLeft(Math.round(b.scroll.x * b.scrollratio.x)) : b.doScrollTop(Math.round(b.scroll.y * b.scrollratio.y)))
                                });
                                return b.cancelEvent(c)
                            }
                        } else b.checkarea = true
                    }); (e.cantouch || b.opt.touchbehavior) && b.bind(b.win, "mousedown", b.onmousedown);
                    e.hasmstouch && (b.css(b.rail, {
                        "-ms-touch-action": "none"
                    }), b.css(b.cursor, {
                        "-ms-touch-action": "none"
                    }), b.bind(b.win, "MSPointerDown", b.ontouchstart), b.bind(document, "MSPointerUp", b.ontouchend), b.bind(document, "MSPointerMove", b.ontouchmove), b.bind(b.cursor, "MSGestureHold",
                    function(b) {
                        b.preventDefault()
                    }), b.bind(b.cursor, "contextmenu",
                    function(b) {
                        b.preventDefault()
                    }));
                    this.istouchcapable && (b.bind(b.win, "touchstart", b.ontouchstart), b.bind(document, "touchend", b.ontouchend), b.bind(document, "touchmove", b.ontouchmove));
                    b.bind(b.cursor, "mousedown", b.onmousedown);
                    b.bind(b.cursor, "mouseup", b.onmouseup);
                    b.railh && (b.bind(b.cursorh, "mousedown",
                    function(c) {
                        b.onmousedown(c, true)
                    }), b.bind(b.cursorh, "mouseup",
                    function(c) {
                        if (! (b.rail.drag && b.rail.drag.pt == 2)) return b.rail.drag = false,
                        b.hasmoving = false,
                        b.hideCursor(),
                        e.hasmousecapture && document.releaseCapture(),
                        b.cancelEvent(c)
                    }));
                    b.bind(document, "mouseup", b.onmouseup);
                    e.hasmousecapture && b.bind(b.win, "mouseup", b.onmouseup);
                    b.bind(document, "mousemove", b.onmousemove);
                    b.onclick && b.bind(document, "click", b.onclick); ! e.cantouch && !b.opt.touchbehavior && (b.rail.mouseenter(function() {
                        b.canshowonmouseevent && b.showCursor();
                        b.rail.active = true
                    }), b.rail.mouseleave(function() {
                        b.rail.active = false;
                        b.rail.drag || b.hideCursor()
                    }), b.opt.sensitiverail && (b.rail.click(function(c) {
                        b.doRailClick(c, false, false)
                    }), b.rail.dblclick(function(c) {
                        b.doRailClick(c, true, false)
                    }), b.cursor.click(function(c) {
                        b.cancelEvent(c)
                    }), b.cursor.dblclick(function(c) {
                        b.cancelEvent(c)
                    })), b.railh && (b.railh.mouseenter(function() {
                        b.canshowonmouseevent && b.showCursor();
                        b.rail.active = true
                    }), b.railh.mouseleave(function() {
                        b.rail.active = false;
                        b.rail.drag || b.hideCursor()
                    })), b.zoom && (b.zoom.mouseenter(function() {
                        b.canshowonmouseevent && b.showCursor();
                        b.rail.active = true
                    }), b.zoom.mouseleave(function() {
                        b.rail.active = false;
                        b.rail.drag || b.hideCursor()
                    })));
                    b.opt.enablemousewheel && (b.isiframe || b.bind(e.isie && b.ispage ? document: b.docscroll, "mousewheel", b.onmousewheel), b.bind(b.rail, "mousewheel", b.onmousewheel), b.railh && b.bind(b.railh, "mousewheel", b.onmousewheelhr)); ! b.ispage && !e.cantouch && !/HTML|BODY/.test(b.win[0].nodeName) && (b.win.attr("tabindex") || b.win.attr({
                        tabindex: B++
                    }), b.win.focus(function(c) {
                        s = b.getTarget(c).id || true;
                        b.hasfocus = true;
                        b.canshowonmouseevent && b.noticeCursor()
                    }), b.win.blur(function() {
                        s = false;
                        b.hasfocus = false
                    }), b.win.mouseenter(function(c) {
                        w = b.getTarget(c).id || true;
                        b.hasmousefocus = true;
                        b.canshowonmouseevent && b.noticeCursor()
                    }), b.win.mouseleave(function() {
                        w = false;
                        b.hasmousefocus = false
                    }))
                }
                b.onkeypress = function(c) {
                    if (b.locked && b.page.maxh == 0) return true;
                    var c = c ? c: window.e,
                    f = b.getTarget(c);
                    if (f && /INPUT|TEXTAREA|SELECT|OPTION/.test(f.nodeName) && (!f.getAttribute("type") && !f.type || !/submit|button|cancel/i.tp)) return true;
                    if (b.hasfocus || b.hasmousefocus && !s || b.ispage && !s && !w) {
                        var f = c.keyCode,
                        g = c.ctrlKey || false;
                        if (b.locked && f != 27) return b.cancelEvent(c);
                        var e = false;
                        switch (f) {
                        case 38:
                        case 63233:
                            b.doScrollBy(72);
                            e = true;
                            break;
                        case 40:
                        case 63235:
                            b.doScrollBy( - 72);
                            e = true;
                            break;
                        case 37:
                        case 63232:
                            b.railh && (g ? b.doScrollLeft(0) : b.doScrollLeftBy(72), e = true);
                            break;
                        case 39:
                        case 63234:
                            b.railh && (g ? b.doScrollLeft(b.page.maxw) : b.doScrollLeftBy( - 72), e = true);
                            break;
                        case 33:
                        case 63276:
                            b.doScrollBy(b.view.h);
                            e = true;
                            break;
                        case 34:
                        case 63277:
                            b.doScrollBy( - b.view.h);
                            e = true;
                            break;
                        case 36:
                        case 63273:
                            b.railh && g ? b.doScrollPos(0, 0) : b.doScrollTo(0);
                            e = true;
                            break;
                        case 35:
                        case 63275:
                            b.railh && g ? b.doScrollPos(b.page.maxw, b.page.maxh) : b.doScrollTo(b.page.maxh);
                            e = true;
                            break;
                        case 32:
                            b.opt.spacebarenabled && (b.doScrollBy( - b.view.h), e = true);
                            break;
                        case 27:
                            b.zoomactive && (b.doZoom(), e = true)
                        }
                        if (e) return b.cancelEvent(c)
                    }
                };
                b.opt.enablekeyboard && b.bind(document, e.isopera && !e.isopera12 ? "keypress": "keydown", b.onkeypress);
                b.bind(window, "resize", b.resize);
                b.bind(window, "orientationchange", b.resize);
                b.bind(window, "load", b.resize);
                if (e.ischrome && !b.ispage && !b.haswrapper) {
                    var n = b.win.attr("style"),
                    g = parseFloat(b.win.css("width")) + 1;
                    b.win.css("width", g);
                    b.synched("chromefix",
                    function() {
                        b.win.attr("style", n)
                    })
                }
                b.onAttributeChange = function() {
                    b.lazyResize()
                };
                if (!b.ispage && !b.haswrapper)"WebKitMutationObserver" in window ? (b.observer = new WebKitMutationObserver(function(c) {
                    c.forEach(b.onAttributeChange)
                }), b.observer.observe(b.win[0], {
                    attributes: true,
                    subtree: false
                })) : (b.bind(b.win, e.isie && !e.isie9 ? "propertychange": "DOMAttrModified", b.onAttributeChange), e.isie9 && b.win[0].attachEvent("onpropertychange", b.onAttributeChange)); ! b.ispage && b.opt.boxzoom && b.bind(window, "resize", b.resizeZoom);
                b.istextarea && b.bind(b.win, "mouseup", b.resize);
                b.resize()
            }
            if (this.doc[0].nodeName == "IFRAME") {
                var A = function() {
                    b.iframexd = false;
                    try {
                        var c = "contentDocument" in this ? this.contentDocument: this.contentWindow.document
                    } catch(f) {
                        b.iframexd = true,
                        c = false
                    }
                    if (b.iframexd) return "console" in window && console.log("NiceScroll error: policy restriced iframe"),
                    true;
                    b.forcescreen = true;
                    if (b.isiframe) b.iframe = {
                        doc: d(c),
                        html: b.doc.contents().find("html")[0],
                        body: b.doc.contents().find("body")[0]
                    },
                    b.getContentSize = function() {
                        return {
                            w: Math.max(b.iframe.html.scrollWidth, b.iframe.body.scrollWidth),
                            h: Math.max(b.iframe.html.scrollHeight, b.iframe.body.scrollHeight)
                        }
                    },
                    b.docscroll = d(b.iframe.body);
                    if (!e.isios && b.opt.iframeautoresize && !b.isiframe) {
                        b.win.scrollTop(0);
                        b.doc.height("");
                        var g = Math.max(c.getElementsByTagName("html")[0].scrollHeight, c.body.scrollHeight);
                        b.doc.height(g)
                    }
                    b.resize();
                    e.isie7 && b.css(d(b.iframe.html), {
                        "overflow-y": "hidden"
                    });
                    b.css(d(b.iframe.body), {
                        "overflow-y": "hidden"
                    });
                    "contentWindow" in this ? b.bind(this.contentWindow, "scroll", b.onscroll) : b.bind(c, "scroll", b.onscroll);
                    b.opt.enablemousewheel && b.bind(c, "mousewheel", b.onmousewheel);
                    b.opt.enablekeyboard && b.bind(c, e.isopera ? "keypress": "keydown", b.onkeypress);
                    if (e.cantouch || b.opt.touchbehavior) b.bind(c, "mousedown", b.onmousedown),
                    b.bind(c, "mousemove",
                    function(c) {
                        b.onmousemove(c, true)
                    }),
                    e.cursorgrabvalue && b.css(d(c.body), {
                        cursor: e.cursorgrabvalue
                    });
                    b.bind(c, "mouseup", b.onmouseup);
                    b.zoom && (b.opt.dblclickzoom && b.bind(c, "dblclick", b.doZoom), b.ongesturezoom && b.bind(c, "gestureend", b.ongesturezoom))
                };
                this.doc[0].readyState && this.doc[0].readyState == "complete" && setTimeout(function() {
                    A.call(b.doc[0], false)
                },
                500);
                b.bind(this.doc, "load", A)
            }
        };
        this.showCursor = function(c, e) {
            if (b.cursortimeout) clearTimeout(b.cursortimeout),
            b.cursortimeout = 0;
            if (b.rail) {
                if (b.autohidedom) b.autohidedom.stop().css({
                    opacity: b.opt.cursoropacitymax
                }),
                b.cursoractive = true;
                if (typeof c != "undefined" && c !== false) b.scroll.y = Math.round(c * 1 / b.scrollratio.y);
                if (typeof e != "undefined") b.scroll.x = Math.round(e * 1 / b.scrollratio.x);
                b.cursor.css({
                    height: b.cursorheight,
                    top: b.scroll.y
                });
                if (b.cursorh) ! b.rail.align && b.rail.visibility ? b.cursorh.css({
                    width: b.cursorwidth,
                    left: b.scroll.x + b.rail.width
                }) : b.cursorh.css({
                    width: b.cursorwidth,
                    left: b.scroll.x
                }),
                b.cursoractive = true;
                b.zoom && b.zoom.stop().css({
                    opacity: b.opt.cursoropacitymax
                })
            }
        };
        this.hideCursor = function(c) {
            if (!b.cursortimeout && b.rail && b.autohidedom) b.cursortimeout = setTimeout(function() {
                if (!b.rail.active || !b.showonmouseevent) b.autohidedom.stop().animate({
                    opacity: b.opt.cursoropacitymin
                }),
                b.zoom && b.zoom.stop().animate({
                    opacity: b.opt.cursoropacitymin
                }),
                b.cursoractive = false;
                b.cursortimeout = 0
            },
            c || 400)
        };
        this.noticeCursor = function(c, e, g) {
            b.showCursor(e, g);
            b.rail.active || b.hideCursor(c)
        };
        this.getContentSize = b.ispage ?
        function() {
            return {
                w: Math.max(document.body.scrollWidth, document.documentElement.scrollWidth),
                h: Math.max(document.body.scrollHeight, document.documentElement.scrollHeight)
            }
        }: b.haswrapper ?
        function() {
            return {
                w: b.doc.outerWidth() + parseInt(b.win.css("paddingLeft")) + parseInt(b.win.css("paddingRight")),
                h: b.doc.outerHeight() + parseInt(b.win.css("paddingTop")) + parseInt(b.win.css("paddingBottom"))
            }
        }: function() {
            return {
                w: b.docscroll[0].scrollWidth,
                h: b.docscroll[0].scrollHeight
            }
        };
        this.onResize = function(c, e) {
            if (!b.win) return false;
            if (!b.haswrapper && !b.ispage) if (b.win.css("display") == "none") return b.visibility && b.hideRail().hideRailHr(),
            false;
            else ! b.hidden && !b.visibility && b.showRail().showRailHr();
            var g = b.page.maxh,
            d = b.page.maxw,
            h = b.view.w,
            _h = b.view.h;
            b.view = {
                w: b.ispage ? b.win.width() : parseInt(b.win[0].clientWidth),
                h: b.ispage ? b.win.height() : parseInt(b.win[0].clientHeight)
            };
            b.page = e ? e: b.getContentSize();
            b.page.maxh = Math.max(0, b.page.h - b.view.h);
            b.page.maxw = Math.max(0, b.page.w - b.view.w);
            if (b.page.maxh == g && b.page.maxw == d && b.view.w == h && b.view.h == _h) if (b.ispage) return b;
            else {
                g = b.win.offset();
                if (b.lastposition && (d = b.lastposition, d.top == g.top && d.left == g.left)) return b;
                b.lastposition = g
            }
            b.page.maxh == 0 ? (b.hideRail(), b.scrollvaluemax = 0, b.scroll.y = 0, b.scrollratio.y = 0, b.cursorheight = 0, b.setScrollTop(0), b.rail.scrollable = false) : b.rail.scrollable = true;
            b.page.maxw == 0 ? (b.hideRailHr(), b.scrollvaluemaxw = 0, b.scroll.x = 0, b.scrollratio.x = 0, b.cursorwidth = 0, b.setScrollLeft(0), b.railh.scrollable = false) : b.railh.scrollable = true;
            b.locked = b.page.maxh == 0 && b.page.maxw == 0;
            if (b.locked) return b.ispage || b.updateScrollBar(b.view),
            false; ! b.hidden && !b.visibility ? b.showRail().showRailHr() : !b.hidden && !b.railh.visibility && b.showRailHr();
            b.istextarea && b.win.css("resize") && b.win.css("resize") != "none" && (b.view.h -= 20);
            b.ispage || b.updateScrollBar(b.view);
            b.cursorheight = Math.min(b.view.h, Math.round(b.view.h * (b.view.h / b.page.h)));
            b.cursorheight = Math.max(b.opt.cursorminheight, b.cursorheight);
            b.cursorwidth = Math.min(b.view.w, Math.round(b.view.w * (b.view.w / b.page.w)));
            b.cursorwidth = Math.max(b.opt.cursorminheight, b.cursorwidth);
            b.scrollvaluemax = b.view.h - b.cursorheight - b.cursor.hborder;
            if (b.railh) b.railh.width = b.page.maxh > 0 ? b.view.w - b.rail.width: b.view.w,
            b.scrollvaluemaxw = b.railh.width - b.cursorwidth - b.cursorh.wborder;
            b.scrollratio = {
                x: b.page.maxw / b.scrollvaluemaxw,
                y: b.page.maxh / b.scrollvaluemax
            };
            b.getScrollTop() > b.page.maxh ? b.doScroll(b.page.maxh) : (b.scroll.y = Math.round(b.getScrollTop() * (1 / b.scrollratio.y)), b.scroll.x = Math.round(b.getScrollLeft() * (1 / b.scrollratio.x)), b.cursoractive && b.noticeCursor());
            b.scroll.y && b.getScrollTop() == 0 && b.doScrollTo(Math.floor(b.scroll.y * b.scrollratio.y));
            return b
        };
        this.resize = function() {
            b.delayed("resize", b.onResize, 30);
            return b
        };
        this.lazyResize = function() {
            b.delayed("resize", b.resize, 250)
        };
        this._bind = function(c, e, g, d) {
            b.events.push({
                e: c,
                n: e,
                f: g,
                b: d
            });
            c.addEventListener ? c.addEventListener(e, g, d || false) : c.attachEvent ? c.attachEvent("on" + e, g) : c["on" + e] = g
        };
        this.bind = function(c, d, g, h) {
            var i = "jquery" in c ? c[0] : c;
            i.addEventListener ? (e.cantouch && /mouseup|mousedown|mousemove/.test(d) && b._bind(i, d == "mousedown" ? "touchstart": d == "mouseup" ? "touchend": "touchmove",
            function(b) {
                if (b.touches) {
                    if (b.touches.length < 2) {
                        var c = b.touches.length ? b.touches[0] : b;
                        c.original = b;
                        g.call(this, c)
                    }
                } else if (b.changedTouches) c = b.changedTouches[0],
                c.original = b,
                g.call(this, c)
            },
            h || false), b._bind(i, d, g, h || false), d == "mousewheel" && b._bind(i, "DOMMouseScroll", g, h || false), e.cantouch && d == "mouseup" && b._bind(i, "touchcancel", g, h || false)) : b._bind(i, d,
            function(c) {
                if ((c = c || window.event || false) && c.srcElement) c.target = c.srcElement;
                return g.call(i, c) === false || h === false ? b.cancelEvent(c) : true
            })
        };
        this._unbind = function(b, c, g, e) {
            b.removeEventListener ? b.removeEventListener(c, g, e) : b.detachEvent ? b.detachEvent("on" + c, g) : b["on" + c] = false
        };
        this.unbindAll = function() {
            for (var c = 0; c < b.events.length; c++) {
                var e = b.events[c];
                b._unbind(e.e, e.n, e.f, e.b)
            }
        };
        this.cancelEvent = function(b) {
            b = b.original ? b.original: b ? b: window.event || false;
            if (!b) return false;
            b.preventDefault && b.preventDefault();
            b.stopPropagation && b.stopPropagation();
            b.preventManipulation && b.preventManipulation();
            b.cancelBubble = true;
            b.cancel = true;
            return b.returnValue = false
        };
        this.stopPropagation = function(b) {
            b = b.original ? b.original: b ? b: window.event || false;
            if (!b) return false;
            if (b.stopPropagation) return b.stopPropagation();
            if (b.cancelBubble) b.cancelBubble = true;
            return false
        };
        this.showRail = function() {
            if (b.page.maxh != 0 && (b.ispage || b.win.css("display") != "none")) b.visibility = true,
            b.rail.visibility = true,
            b.rail.css("display", "block");
            return b
        };
        this.showRailHr = function() {
            if (!b.railh) return b;
            if (b.page.maxw != 0 && (b.ispage || b.win.css("display") != "none")) b.railh.visibility = true,
            b.railh.css("display", "block");
            return b
        };
        this.hideRail = function() {
            b.visibility = false;
            b.rail.visibility = false;
            b.rail.css("display", "none");
            return b
        };
        this.hideRailHr = function() {
            if (!b.railh) return b;
            b.railh.visibility = false;
            b.railh.css("display", "none");
            return b
        };
        this.show = function() {
            b.hidden = false;
            b.locked = false;
            return b.showRail().showRailHr()
        };
        this.hide = function() {
            b.hidden = true;
            b.locked = true;
            return b.hideRail().hideRailHr()
        };
        this.remove = function() {
            b.doZoomOut();
            b.unbindAll();
            b.observer !== false && b.observer.disconnect();
            b.events = [];
            if (b.cursor) b.cursor.remove(),
            b.cursor = null;
            if (b.cursorh) b.cursorh.remove(),
            b.cursorh = null;
            if (b.rail) b.rail.remove(),
            b.rail = null;
            if (b.railh) b.railh.remove(),
            b.railh = null;
            if (b.zoom) b.zoom.remove(),
            b.zoom = null;
            for (var c = 0; c < b.saved.css.length; c++) {
                var e = b.saved.css[c];
                e[0].css(e[1], typeof e[2] == "undefined" ? "": e[2])
            }
            b.saved = false;
            b.me.data("__nicescroll", "");
            b.me = null;
            b.doc = null;
            b.docscroll = null;
            b.win = null;
            return b
        };
        this.scrollstart = function(c) {
            this.onscrollstart = c;
            return b
        };
        this.scrollend = function(c) {
            this.onscrollend = c;
            return b
        };
        this.scrollcancel = function(c) {
            this.onscrollcancel = c;
            return b
        };
        this.zoomin = function(c) {
            this.onzoomin = c;
            return b
        };
        this.zoomout = function(c) {
            this.onzoomout = c;
            return b
        };
        this.isScrollable = function(b) {
            for (b = b.target ? b.target: b; b && b.nodeType == 1 && !/BODY|HTML/.test(b.nodeName);) {
                var c = d(b);
                if (/scroll|auto/.test(c.css("overflowY") || c.css("overflowX") || c.css("overflow") || "")) return b.clientHeight != b.scrollHeight;
                b = b.parentNode ? b.parentNode: false
            }
            return false
        };
        this.onmousewheel = function(c) {
            if (b.locked) return true;
            if (!b.rail.scrollable) return b.railh && b.railh.scrollable ? b.onmousewheelhr(c) : true;
            if (b.opt.preservenativescrolling && b.checkarea) b.checkarea = false,
            b.nativescrollingarea = b.isScrollable(c);
            if (b.nativescrollingarea) return true;
            if (b.locked) return b.cancelEvent(c);
            if (b.rail.drag) return b.cancelEvent(c);
            i(c, false);
            return b.cancelEvent(c)
        };
        this.onmousewheelhr = function(c) {
            if (b.locked || !b.railh.scrollable) return true;
            if (b.opt.preservenativescrolling && b.checkarea) b.checkarea = false,
            b.nativescrollingarea = b.isScrollable(c);
            if (b.nativescrollingarea) return true;
            if (b.locked) return b.cancelEvent(c);
            if (b.rail.drag) return b.cancelEvent(c);
            i(c, true);
            return b.cancelEvent(c)
        };
        this.stop = function() {
            b.cancelScroll();
            b.scrollmon && b.scrollmon.stop();
            b.cursorfreezed = false;
            b.scroll.y = Math.round(b.getScrollTop() * (1 / b.scrollratio.y));
            b.noticeCursor();
            return b
        };
        this.getTransitionSpeed = function(c) {
            var e = Math.round(b.opt.scrollspeed * 10),
            c = Math.min(e, Math.round(c / 20 * b.opt.scrollspeed));
            return c > 20 ? c: 0
        };
        b.opt.smoothscroll ? b.ishwscroll && e.hastransition && b.opt.usetransition ? (this.prepareTransition = function(c, d) {
            var g = d ? c > 20 ? c: 0 : b.getTransitionSpeed(c),
            h = g ? e.prefixstyle + "transform " + g + "ms ease-out": "";
            if (!b.lasttransitionstyle || b.lasttransitionstyle != h) b.lasttransitionstyle = h,
            b.doc.css(e.transitionstyle, h);
            return g
        },
        this.doScrollLeft = function(c, e) {
            var g = b.scrollrunning ? b.newscrolly: b.getScrollTop();
            b.doScrollPos(c, g, e)
        },
        this.doScrollTop = function(c, e) {
            var g = b.scrollrunning ? b.newscrollx: b.getScrollLeft();
            b.doScrollPos(g, c, e)
        },
        this.doScrollPos = function(c, d, g) {
            var h = b.getScrollTop(),
            i = b.getScrollLeft(); ((b.newscrolly - h) * (d - h) < 0 || (b.newscrollx - i) * (c - i) < 0) && b.cancelScroll();
            b.newscrolly = d;
            b.newscrollx = c;
            b.newscrollspeed = g || false;
            if (b.timer) return false;
            b.timer = setTimeout(function() {
                var g = b.getScrollTop(),
                h = b.getScrollLeft(),
                i,
                j;
                i = c - h;
                j = d - g;
                i = Math.round(Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2)));
                i = b.prepareTransition(b.newscrollspeed ? b.newscrollspeed: i);
                b.timerscroll && b.timerscroll.tm && clearInterval(b.timerscroll.tm);
                if (i > 0) { ! b.scrollrunning && b.onscrollstart && b.onscrollstart.call(b, {
                        type: "scrollstart",
                        current: {
                            x: h,
                            y: g
                        },
                        request: {
                            x: c,
                            y: d
                        },
                        end: {
                            x: b.newscrollx,
                            y: b.newscrolly
                        },
                        speed: i
                    });
                    if (e.transitionend) {
                        if (!b.scrollendtrapped) b.scrollendtrapped = true,
                        b.bind(b.doc, e.transitionend, b.onScrollEnd, false)
                    } else b.scrollendtrapped && clearTimeout(b.scrollendtrapped),
                    b.scrollendtrapped = setTimeout(b.onScrollEnd, i);
                    b.timerscroll = {
                        bz: new BezierClass(g, b.newscrolly, i, 0, 0, 0.58, 1),
                        bh: new BezierClass(h, b.newscrollx, i, 0, 0, 0.58, 1)
                    };
                    if (!b.cursorfreezed) b.timerscroll.tm = setInterval(function() {
                        b.showCursor(b.getScrollTop(), b.getScrollLeft())
                    },
                    60)
                }
                b.synched("doScroll-set",
                function() {
                    b.timer = 0;
                    if (b.scrollendtrapped) b.scrollrunning = true;
                    b.setScrollTop(b.newscrolly);
                    b.setScrollLeft(b.newscrollx);
                    if (!b.scrollendtrapped) b.onScrollEnd()
                })
            },
            50)
        },
        this.cancelScroll = function() {
            if (!b.scrollendtrapped) return true;
            var c = b.getScrollTop(),
            d = b.getScrollLeft();
            b.scrollrunning = false;
            e.transitionend || clearTimeout(e.transitionend);
            b.scrollendtrapped = false;
            b._unbind(b.doc, e.transitionend, b.onScrollEnd);
            b.prepareTransition(0);
            b.setScrollTop(c);
            b.railh && b.setScrollLeft(d);
            b.timerscroll && b.timerscroll.tm && clearInterval(b.timerscroll.tm);
            b.timerscroll = false;
            b.cursorfreezed = false;
            b.showCursor(c, d);
            return b
        },
        this.onScrollEnd = function() {
            b.scrollendtrapped && b._unbind(b.doc, e.transitionend, b.onScrollEnd);
            b.scrollendtrapped = false;
            b.prepareTransition(0);
            b.timerscroll && b.timerscroll.tm && clearInterval(b.timerscroll.tm);
            b.timerscroll = false;
            var c = b.getScrollTop(),
            d = b.getScrollLeft();
            b.setScrollTop(c);
            b.railh && b.setScrollLeft(d);
            b.noticeCursor(false, c, d);
            b.cursorfreezed = false;
            if (c < 0) c = 0;
            else if (c > b.page.maxh) c = b.page.maxh;
            if (d < 0) d = 0;
            else if (d > b.page.maxw) d = b.page.maxw;
            if (c != b.newscrolly || d != b.newscrollx) return b.doScrollPos(d, c, b.opt.snapbackspeed);
            b.onscrollend && b.scrollrunning && b.onscrollend.call(b, {
                type: "scrollend",
                current: {
                    x: d,
                    y: c
                },
                end: {
                    x: b.newscrollx,
                    y: b.newscrolly
                }
            });
            b.scrollrunning = false
        }) : (this.doScrollLeft = function(c) {
            var e = b.scrollrunning ? b.newscrolly: b.getScrollTop();
            b.doScrollPos(c, e)
        },
        this.doScrollTop = function(c) {
            var e = b.scrollrunning ? b.newscrollx: b.getScrollLeft();
            b.doScrollPos(e, c)
        },
        this.doScrollPos = function(c, e) {
            function g() {
                if (b.cancelAnimationFrame) return true;
                b.scrollrunning = true;
                if (o = 1 - o) return b.timer = q(g) || 1;
                var c = 0,
                f = sy = b.getScrollTop();
                if (b.dst.ay) {
                    var f = b.bzscroll ? b.dst.py + b.bzscroll.getNow() * b.dst.ay: b.newscrolly,
                    e = f - sy;
                    if (e < 0 && f < b.newscrolly || e > 0 && f > b.newscrolly) f = b.newscrolly;
                    b.setScrollTop(f);
                    f == b.newscrolly && (c = 1)
                } else c = 1;
                var d = sx = b.getScrollLeft();
                if (b.dst.ax) {
                    d = b.bzscroll ? b.dst.px + b.bzscroll.getNow() * b.dst.ax: b.newscrollx;
                    e = d - sx;
                    if (e < 0 && d < b.newscrollx || e > 0 && d > b.newscrollx) d = b.newscrollx;
                    b.setScrollLeft(d);
                    d == b.newscrollx && (c += 1)
                } else c += 1;
                if (c == 2) {
                    b.timer = 0;
                    b.cursorfreezed = false;
                    b.bzscroll = false;
                    b.scrollrunning = false;
                    if (f < 0) f = 0;
                    else if (f > b.page.maxh) f = b.page.maxh;
                    if (d < 0) d = 0;
                    else if (d > b.page.maxw) d = b.page.maxw;
                    d != b.newscrollx || f != b.newscrolly ? b.doScrollPos(d, f) : b.onscrollend && b.onscrollend.call(b, {
                        type: "scrollend",
                        current: {
                            x: sx,
                            y: sy
                        },
                        end: {
                            x: b.newscrollx,
                            y: b.newscrolly
                        }
                    })
                } else b.timer = q(g) || 1
            }
            e = typeof e == "undefined" || e === false ? b.getScrollTop(true) : e;
            if (b.timer && b.newscrolly == e && b.newscrollx == c) return true;
            b.timer && r(b.timer);
            b.timer = 0;
            var d = b.getScrollTop(),
            h = b.getScrollLeft(); ((b.newscrolly - d) * (e - d) < 0 || (b.newscrollx - h) * (c - h) < 0) && b.cancelScroll();
            b.newscrolly = e;
            b.newscrollx = c;
            if (!b.bouncescroll || !b.rail.visibility) if (b.newscrolly < 0) b.newscrolly = 0;
            else if (b.newscrolly > b.page.maxh) b.newscrolly = b.page.maxh;
            if (!b.bouncescroll || !b.railh.visibility) if (b.newscrollx < 0) b.newscrollx = 0;
            else if (b.newscrollx > b.page.maxw) b.newscrollx = b.page.maxw;
            b.dst = {};
            b.dst.x = c - h;
            b.dst.y = e - d;
            b.dst.px = h;
            b.dst.py = d;
            var i = Math.round(Math.sqrt(Math.pow(b.dst.x, 2) + Math.pow(b.dst.y, 2)));
            b.dst.ax = b.dst.x / i;
            b.dst.ay = b.dst.y / i;
            var j = 0,
            k = i;
            if (b.dst.x == 0) j = d,
            k = e,
            b.dst.ay = 1,
            b.dst.py = 0;
            else if (b.dst.y == 0) j = h,
            k = c,
            b.dst.ax = 1,
            b.dst.px = 0;
            i = b.getTransitionSpeed(i);
            b.bzscroll = i > 0 ? b.bzscroll ? b.bzscroll.update(k, i) : new BezierClass(j, k, i, 0, 1, 0, 1) : false;
            if (!b.timer) { (d == b.page.maxh && e >= b.page.maxh || h == b.page.maxw && c >= b.page.maxw) && b.checkContentSize();
                var o = 1;
                b.cancelAnimationFrame = false;
                b.timer = 1;
                b.onscrollstart && !b.scrollrunning && b.onscrollstart.call(b, {
                    type: "scrollstart",
                    current: {
                        x: h,
                        y: d
                    },
                    request: {
                        x: c,
                        y: e
                    },
                    end: {
                        x: b.newscrollx,
                        y: b.newscrolly
                    },
                    speed: i
                });
                g(); (d == b.page.maxh && e >= d || h == b.page.maxw && c >= h) && b.checkContentSize();
                b.noticeCursor()
            }
        },
        this.cancelScroll = function() {
            b.timer && r(b.timer);
            b.timer = 0;
            b.bzscroll = false;
            b.scrollrunning = false;
            return b
        }) : (this.doScrollLeft = function(c, e) {
            var g = b.getScrollTop();
            b.doScrollPos(c, g, e)
        },
        this.doScrollTop = function(c, e) {
            var g = b.getScrollLeft();
            b.doScrollPos(g, c, e)
        },
        this.doScrollPos = function(c, e) {
            var g = c > b.page.maxw ? b.page.maxw: c;
            g < 0 && (g = 0);
            var d = e > b.page.maxh ? b.page.maxh: e;
            d < 0 && (d = 0);
            b.synched("scroll",
            function() {
                b.setScrollTop(d);
                b.setScrollLeft(g)
            })
        },
        this.cancelScroll = function() {});
        this.doScrollBy = function(c, e) {
            var d = 0,
            d = e ? Math.floor((b.scroll.y - c) * b.scrollratio.y) : (b.timer ? b.newscrolly: b.getScrollTop(true)) - c;
            if (b.bouncescroll) {
                var h = Math.round(b.view.h / 2);
                d < -h ? d = -h: d > b.page.maxh + h && (d = b.page.maxh + h)
            }
            b.cursorfreezed = false;
            py = b.getScrollTop(true);
            if (d < 0 && py <= 0) return b.noticeCursor();
            else if (d > b.page.maxh && py >= b.page.maxh) return b.checkContentSize(),
            b.noticeCursor();
            b.doScrollTop(d)
        };
        this.doScrollLeftBy = function(c, e) {
            var d = 0,
            d = e ? Math.floor((b.scroll.x - c) * b.scrollratio.x) : (b.timer ? b.newscrollx: b.getScrollLeft(true)) - c;
            if (b.bouncescroll) {
                var h = Math.round(b.view.w / 2);
                d < -h ? d = -h: d > b.page.maxw + h && (d = b.page.maxw + h)
            }
            b.cursorfreezed = false;
            px = b.getScrollLeft(true);
            if (d < 0 && px <= 0) return b.noticeCursor();
            else if (d > b.page.maxw && px >= b.page.maxw) return b.noticeCursor();
            b.doScrollLeft(d)
        };
        this.doScrollTo = function(c, e) {
            e && Math.round(c * b.scrollratio.y);
            b.cursorfreezed = false;
            b.doScrollTop(c)
        };
        this.checkContentSize = function() {
            var c = b.getContentSize(); (c.h != b.page.h || c.w != b.page.w) && b.resize(false, c)
        };
        b.onscroll = function() {
            b.rail.drag || b.cursorfreezed || b.synched("scroll",
            function() {
                b.scroll.y = Math.round(b.getScrollTop() * (1 / b.scrollratio.y));
                if (b.railh) b.scroll.x = Math.round(b.getScrollLeft() * (1 / b.scrollratio.x));
                b.noticeCursor()
            })
        };
        b.bind(b.docscroll, "scroll", b.onscroll);
        this.doZoomIn = function(c) {
            if (!b.zoomactive) {
                b.zoomactive = true;
                b.zoomrestore = {
                    style: {}
                };
                var h = "position,top,left,zIndex,backgroundColor,marginTop,marginBottom,marginLeft,marginRight".split(","),
                g = b.win[0].style,
                i;
                for (i in h) {
                    var j = h[i];
                    b.zoomrestore.style[j] = typeof g[j] != "undefined" ? g[j] : ""
                }
                b.zoomrestore.style.width = b.win.css("width");
                b.zoomrestore.style.height = b.win.css("height");
                b.zoomrestore.padding = {
                    w: b.win.outerWidth() - b.win.width(),
                    h: b.win.outerHeight() - b.win.height()
                };
                if (e.isios4) b.zoomrestore.scrollTop = d(window).scrollTop(),
                d(window).scrollTop(0);
                b.win.css({
                    position: e.isios4 ? "absolute": "fixed",
                    top: 0,
                    left: 0,
                    "z-index": b.opt.zindex + 100,
                    margin: "0px"
                });
                h = b.win.css("backgroundColor"); (h == "" || /transparent|rgba\(0, 0, 0, 0\)|rgba\(0,0,0,0\)/.test(h)) && b.win.css("backgroundColor", "#fff");
                b.rail.css({
                    "z-index": b.opt.zindex + 110
                });
                b.zoom.css({
                    "z-index": b.opt.zindex + 112
                });
                b.zoom.css("backgroundPosition", "0px -18px");
                b.resizeZoom();
                b.onzoomin && b.onzoomin.call(b);
                return b.cancelEvent(c)
            }
        };
        this.doZoomOut = function(c) {
            if (b.zoomactive) return b.zoomactive = false,
            b.win.css("margin", ""),
            b.win.css(b.zoomrestore.style),
            e.isios4 && d(window).scrollTop(b.zoomrestore.scrollTop),
            b.rail.css({
                "z-index": b.ispage ? b.opt.zindex: b.opt.zindex + 2
            }),
            b.zoom.css({
                "z-index": b.opt.zindex
            }),
            b.zoomrestore = false,
            b.zoom.css("backgroundPosition", "0px 0px"),
            b.onResize(),
            b.onzoomout && b.onzoomout.call(b),
            b.cancelEvent(c)
        };
        this.doZoom = function(c) {
            return b.zoomactive ? b.doZoomOut(c) : b.doZoomIn(c)
        };
        this.resizeZoom = function() {
            if (b.zoomactive) {
                var c = b.getScrollTop();
                b.win.css({
                    width: d(window).width() - b.zoomrestore.padding.w + "px",
                    height: d(window).height() - b.zoomrestore.padding.h + "px"
                });
                b.onResize();
                b.setScrollTop(Math.min(b.page.maxh, c))
            }
        };
        this.init();
        d.nicescroll.push(this)
    },
    z = function(d) {
        var c = this;
        this.nc = d;
        this.steptime = this.lasttime = this.speedy = this.speedx = this.lasty = this.lastx = 0;
        this.snapy = this.snapx = false;
        this.demuly = this.demulx = 0;
        this.lastscrolly = this.lastscrollx = -1;
        this.timer = this.chky = this.chkx = 0;
        this.time = function() {
            return + new Date
        };
        this.reset = function(d, i) {
            c.stop();
            var b = c.time();
            c.steptime = 0;
            c.lasttime = b;
            c.speedx = 0;
            c.speedy = 0;
            c.lastx = d;
            c.lasty = i;
            c.lastscrollx = -1;
            c.lastscrolly = -1
        };
        this.update = function(d, i) {
            var b = c.time();
            c.steptime = b - c.lasttime;
            c.lasttime = b;
            var b = i - c.lasty,
            j = d - c.lastx,
            e = c.nc.getScrollTop(),
            n = c.nc.getScrollLeft();
            e += b;
            n += j;
            c.snapx = n < 0 || n > c.nc.page.maxw;
            c.snapy = e < 0 || e > c.nc.page.maxh;
            c.speedx = j;
            c.speedy = b;
            c.lastx = d;
            c.lasty = i
        };
        this.stop = function() {
            c.nc.unsynched("domomentum2d");
            c.timer && clearTimeout(c.timer);
            c.timer = 0;
            c.lastscrollx = -1;
            c.lastscrolly = -1
        };
        this.doSnapy = function(d, i) {
            var b = false;
            if (i < 0) i = 0,
            b = true;
            else if (i > c.nc.page.maxh) i = c.nc.page.maxh,
            b = true;
            if (d < 0) d = 0,
            b = true;
            else if (d > c.nc.page.maxw) d = c.nc.page.maxw,
            b = true;
            b && c.nc.doScrollPos(d, i, c.nc.opt.snapbackspeed)
        };
        this.doMomentum = function(d) {
            var i = c.time(),
            b = d ? i + d: c.lasttime,
            d = c.nc.getScrollLeft(),
            j = c.nc.getScrollTop(),
            e = c.nc.page.maxh,
            n = c.nc.page.maxw;
            c.speedx = n > 0 ? Math.min(60, c.speedx) : 0;
            c.speedy = e > 0 ? Math.min(60, c.speedy) : 0;
            b = b && i - b <= 50;
            if (j < 0 || j > e || d < 0 || d > n) b = false;
            d = c.speedx && b ? c.speedx: false;
            if (c.speedy && b && c.speedy || d) {
                var p = Math.max(16, c.steptime);
                p > 50 && (d = p / 50, c.speedx *= d, c.speedy *= d, p = 50);
                c.demulxy = 0;
                c.lastscrollx = c.nc.getScrollLeft();
                c.chkx = c.lastscrollx;
                c.lastscrolly = c.nc.getScrollTop();
                c.chky = c.lastscrolly;
                var f = c.lastscrollx,
                l = c.lastscrolly,
                g = function() {
                    var b = c.time() - i > 600 ? 0.04 : 0.02;
                    if (c.speedx && (f = Math.floor(c.lastscrollx - c.speedx * (1 - c.demulxy)), c.lastscrollx = f, f < 0 || f > n)) b = 0.1;
                    if (c.speedy && (l = Math.floor(c.lastscrolly - c.speedy * (1 - c.demulxy)), c.lastscrolly = l, l < 0 || l > e)) b = 0.1;
                    c.demulxy = Math.min(1, c.demulxy + b);
                    c.nc.synched("domomentum2d",
                    function() {
                        if (c.speedx) c.nc.getScrollLeft() != c.chkx && c.stop(),
                        c.chkx = f,
                        c.nc.setScrollLeft(f);
                        if (c.speedy) c.nc.getScrollTop() != c.chky && c.stop(),
                        c.chky = l,
                        c.nc.setScrollTop(l);
                        c.timer || (c.nc.hideCursor(), c.doSnapy(f, l))
                    });
                    c.demulxy < 1 ? c.timer = setTimeout(g, p) : (c.stop(), c.nc.hideCursor(), c.doSnapy(f, l))
                };
                g()
            } else c.doSnapy(c.nc.getScrollLeft(), c.nc.getScrollTop())
        }
    },
    t = d.fn.scrollTop;
    d.cssHooks.pageYOffset = {
        get: function(j) {
            var c = d.data(j, "__nicescroll") || false;
            return c && c.ishwscroll ? c.getScrollTop() : t.call(j)
        },
        set: function(j, c) {
            var h = d.data(j, "__nicescroll") || false;
            h && h.ishwscroll ? h.setScrollTop(parseInt(c)) : t.call(j, c);
            return this
        }
    };
    d.fn.scrollTop = function(j) {
        if (typeof j == "undefined") {
            var c = this[0] ? d.data(this[0], "__nicescroll") || false: false;
            return c && c.ishwscroll ? c.getScrollTop() : t.call(this)
        } else return this.each(function() {
            var c = d.data(this, "__nicescroll") || false;
            c && c.ishwscroll ? c.setScrollTop(parseInt(j)) : t.call(d(this), j)
        })
    };
    var u = d.fn.scrollLeft;
    d.cssHooks.pageXOffset = {
        get: function(j) {
            var c = d.data(j, "__nicescroll") || false;
            return c && c.ishwscroll ? c.getScrollLeft() : u.call(j)
        },
        set: function(j, c) {
            var h = d.data(j, "__nicescroll") || false;
            h && h.ishwscroll ? h.setScrollLeft(parseInt(c)) : u.call(j, c);
            return this
        }
    };
    d.fn.scrollLeft = function(j) {
        if (typeof j == "undefined") {
            var c = this[0] ? d.data(this[0], "__nicescroll") || false: false;
            return c && c.ishwscroll ? c.getScrollLeft() : u.call(this)
        } else return this.each(function() {
            var c = d.data(this, "__nicescroll") || false;
            c && c.ishwscroll ? c.setScrollLeft(parseInt(j)) : u.call(d(this), j)
        })
    };
    var v = function(j) {
        var c = this;
        this.length = 0;
        this.name = "nicescrollarray";
        this.each = function(d) {
            for (var b = 0; b < c.length; b++) d.call(c[b]);
            return c
        };
        this.push = function(d) {
            c[c.length] = d;
            c.length++
        };
        this.eq = function(d) {
            return c[d]
        };
        if (j) for (a = 0; a < j.length; a++) {
            var h = d.data(j[a], "__nicescroll") || false;
            h && (this[this.length] = h, this.length++)
        }
        return this
    }; (function(d, c, h) {
        for (var i = 0; i < c.length; i++) h(d, c[i])
    })(v.prototype, "show,hide,onResize,resize,remove,stop,doScrollPos".split(","),
    function(d, c) {
        d[c] = function() {
            var d = arguments;
            return this.each(function() {
                this[c].apply(this, d)
            })
        }
    });
    d.fn.getNiceScroll = function(j) {
        return typeof j == "undefined" ? new v(this) : d.data(this[j], "__nicescroll") || false
    };
    d.extend(d.expr[":"], {
        nicescroll: function(j) {
            return d.data(j, "__nicescroll") ? true: false
        }
    });
    d.fn.niceScroll = function(j, c) {
        typeof c == "undefined" && typeof j == "object" && !("jquery" in j) && (c = j, j = false);
        var h = new v;
        typeof c == "undefined" && (c = {});
        if (j) c.doc = d(j),
        c.win = d(this);
        var i = !("doc" in c);
        if (!i && !("win" in c)) c.win = d(this);
        this.each(function() {
            var b = d(this).data("__nicescroll") || false;
            if (!b) c.doc = i ? d(this) : c.doc,
            b = new F(c, d(this)),
            d(this).data("__nicescroll", b);
            h.push(b)
        });
        return h.length == 1 ? h[0] : h
    };
    window.NiceScroll = {
        getjQuery: function() {
            return d
        }
    };
    if (!d.nicescroll) d.nicescroll = new v
})(jQuery);; (function() {
    _IE6 = $.browser.msie && parseFloat($.browser.version) < 7;
    _Obj = {
        id: null,
        isStatic: false,
        isCur: false,
        type: "deafalt",
        ieHide: true,
        isHide: true,
        duration: [750, 750],
        delay: [0, 0],
        easing: ["swing", "swing"],
        oEvent: null,
        upPos: {},
        dnPos: {},
        pos: {},
        init: function(A) {
            for (var B in A) this[B] = A[B];
            if ( !! this.id && !this.elem) {
                this.elem = $("#" + this.id);
                this.elem.data(this.type, this)
            }
            if ( !! this.oEvent) for (var _ in this.oEvent) this.elem.bind(_, this.oEvent[_])
        },
        slideIn: function(H, F, A, C, _) {
            var D = this;
            if ( !! D.onInStart && $.isFunction(D.onInStart)) D.onInStart(H, F, _);
            if ( !! F || D.isStatic || _ObjFunc.sizeOf(D.pos) == 0) { (!_IE6 && D.elem.css("display", "block")) || ( !! D.ieHide && D.elem.stop(true, true).fadeIn(0));
                D.elem.css(D.pos);
                D.onInEnd(H, F)
            } else {
                var G = $.extend({},
                !!H ? D.dnPos: D.upPos),
                E = !!D.inDly ? (H ? D.inDly[1] : D.inDly[0]) : D.delay[0],
                B = !!D.inDur ? (H ? D.inDur[1] : D.inDur[0]) : D.duration[0]; (!_IE6 && (G.display = "block")) || ( !! D.ieHide && D.elem.stop(true, true).fadeIn(0));
                D.elem.stop().css(G).delay(E).animate(D.pos, B, D.easing[0],
                function() {
                    D.onInEnd(H, F);
                    if (A && $.isFunction(A)) if ( !! C) A(C);
                    else A($(this))
                })
            }
        },
        slideOut: function(G, E, _, B) {
            var C = this;
            if ( !! C.onOutStart && $.isFunction(C.onOutStart)) C.onOutStart(G, E);
            if ( !! E || C.isStatic || _ObjFunc.sizeOf(C.pos) == 0) {
                C.elem.css(G ? C.upPos: C.dnPos);
                C.isHide && ((!_IE6 && C.elem.css("display", "none")) || ( !! C.ieHide && C.elem.stop(true, true).fadeOut(0)));
                C.onOutEnd(G, E)
            } else {
                var F = G ? C.upPos: C.dnPos,
                D = !!C.outDly ? (G ? C.outDly[0] : C.outDly[1]) : C.delay[1],
                A = !!C.outDur ? (G ? C.outDur[0] : C.outDur[1]) : C.duration[1];
                C.elem.stop().delay(D).animate(F, A, C.easing[1],
                function() {
                    C.isHide && ((!_IE6 && C.elem.css("display", "none")) || ( !! C.ieHide && C.elem.stop(true, true).fadeOut(0)));
                    C.onOutEnd(G, E);
                    if (_ && $.isFunction(_)) if ( !! B) _(B);
                    else _($(this))
                })
            }
        },
        onInStart: function(A, _, $) {
            this.callback(this.inDoCall, A, _)
        },
        onInEnd: function(_, $) {
            this.isCur = true;
            this.callback(this.inDoneCall, _, $)
        },
        onOutStart: function(_, $) {
            this.callback(this.outDoCall, _, $)
        },
        onOutEnd: function(_, $) {
            this.isCur = false;
            this.callback(this.outDoneCall, _, $)
        },
        callback: function(_, B, A) {
            if ( !! _ && $.isFunction(_)) _(this.elem, B, A)
        },
        inDoCall: null,
        inDoneCall: null,
        outDoCall: null,
        outDoneCall: null
    };
    _AObj = {
        id: "",
        type: "anim",
        step: 100,
        duration: 500,
        start: 0,
        end: 0,
        animStart: 0,
        animEnd: 0,
        posArr: [],
        startPos: {},
        endPos: {},
        oShow: null,
        oHide: null,
        oAnim: null,
        isAnim: false,
        isAppend: false,
        isStatic: false,
        isCssRender: true,
        eType: "Linear",
        eStyle: "EaseNone",
        oEvent: null,
        curClass: "current",
        init: function(B) {
            var A = this;
            for (var C in B) A[C] = B[C];
            if ( !! A.id && !A.elem) {
                A.elem = $("#" + A.id);
                A.elem.data(A.type, A)
            }
            if ( !! A.oEvent) for (var _ in A.oEvent) A.elem.bind(_, A.oEvent[_]);
            if (!A.isAnim) ! A.isStatic && A.elem.css("display", "none");
            else ! A.isStatic && A.elem.css("display", "block")
        },
        anim: function(C, B) {
            var A = this;
            if (!A.animStart || !A.animEnd || A.posArr.length == 0) return;
            if (C >= A.animStart && C <= A.animEnd) {
                var _ = (C - A.animStart) * A.step / (A.animEnd - A.animStart),
                $ = A.getAnimIndex(_);
                if (!B) {
                    if (A.isCssRender) A.elem.stop().css($);
                    else A.elem.stop().animate($, A.duration)
                } else A.elem.stop().css($);
                if (A.oAnim && typeof(A.oAnim) == "function") A.oAnim(A.elem, C)
            } else if (C < A.animStart) A.elem.css(A.startPos);
            else if (C > A.animEnd) A.elem.css(A.endPos)
        },
        showAnim: function($) {
            var _ = this;
            _.elem.addClass(_.curClass);
            if ($ && typeof($) == "function") $();
            if (!_.isStatic) _.elem.css({
                "display": "block"
            });
            if ( !! _.oShow && typeof(_.oShow)) _.oShow();
            _.isAnim = true
        },
        hideAnim: function($) {
            var _ = this;
            if ($ && typeof($) == "function") $();
            if (!_.isStatic) _.elem.css({
                "display": "none"
            });
            _.elem.removeClass(_.curClass);
            if ( !! _.oHide && typeof(_.oHide)) _.oHide();
            _.isAnim = false
        },
        atStart: function() {
            this.elem.stop().css(this.startPos)
        },
        atEnd: function() {
            this.elem.stop().css(this.endPos)
        },
        render: function(A, _) {
            var $ = this;
            if (A < $.start || A > $.end) {
                if (!$.isAnim) return;
                else {
                    if (Math.abs(A - $.start) <= Math.abs(A - $.end)) $.atStart();
                    else $.atEnd();
                    $.hideAnim()
                }
            } else if (!$.isAnim) {
                if (A - $.start <= $.end - A) $.atStart();
                else $.atEnd();
                $.showAnim();
                if (_) $.anim(A, _)
            } else if ($.isAnim) $.anim(A, _)
        },
        getAnimIndex: function(_) {
            var D = this,
            E = 0,
            B = 0,
            C = D.posArr;
            for (var F = 0; F < C.length; F++) {
                B = E;
                E += C[F].step;
                if (E >= _) {
                    var A = C[F].type ? TWEEN.Easing[C[F].eType][C[F].eStyle]((_ - B) / C[F].step) : TWEEN.Easing[D.eType][D.eStyle]((_ - B) / C[F].step),
                    $ = {};
                    for (E in C[F].start) if ((C[F].start[E] + "").indexOf("%") > -1) $[E] = (Math.round((_ObjFunc.perToInt(C[F].end[E]) - _ObjFunc.perToInt(C[F].start[E])) * A * 100) / 100 + _ObjFunc.perToInt(C[F].start[E])) + "%";
                    else if ((C[F].start[E] + "").indexOf("px") > -1) $[E] = (Math.round((_ObjFunc.pxToInt(C[F].end[E]) - _ObjFunc.pxToInt(C[F].start[E])) * A) + _ObjFunc.pxToInt(C[F].start[E])) + "px";
                    else $[E] = ((parseFloat(C[F].end[E]) - parseFloat(C[F].start[E])) * A) + parseFloat(C[F].start[E]);
                    return $
                }
            }
            return {}
        }
    };
    New = function($, _) {
        function A() {
            $.init.call(this, _)
        }
        A.prototype = $;
        return new A()
    };
    Class = function(_, $) {
        function A() {
            for (var _ in $) this[_] = $[_]
        }
        A.prototype = _;
        return new A()
    };
    _ObjFunc = {
        sizeOf: function(_) {
            var $ = 0;
            for (var A in _) $++;
            return $
        },
        shuffleArray: function($) {
            for (var _, B, A = $.length; A; _ = parseInt(Math.random() * A), B = $[--A], $[A] = $[_], $[_] = B);
            return $
        },
        findCur: function($) {
            var _ = -1;
            for (var A = 0; A < $.length; A++) if ($[A].isCur) _ = A;
            return _
        },
        pxToInt: function($) {
            return $.indexOf("px") > -1 ? Math.round(parseFloat($.split("px")[0])) : $
        },
        perToInt: function($) {
            return $.indexOf("%") > -1 ? Math.round(parseFloat($.split("%")[0])) : $
        }
    };
    _View = Class(_Obj, {
        type: "view",
        pageList: [],
        animList: [],
        globalList: {},
        isAnim: false,
        done: function($) {
            $.isAnim = false
        },
        globalAnim: {
            dur: [750, 750],
            easing: ["swing", "swing"],
            upPos: [],
            dnPos: [],
            posArr: []
        },
        upPos: {
            top: "-100%",
            left: "0%"
        },
        dnPos: {
            top: "100%",
            left: "0%"
        },
        pos: {
            top: "0%",
            left: "0%"
        },
        init: function(A) {
            _Obj.init.call(this, A);
            this.globalAnim.easing = this.easing;
            this.globalAnim.dur = this.duration;
            for (var _ in this.globalList) {
                this.globalList[_] = $.extend({},
                this.globalAnim, this.globalList[_]);
                this.globalList[_].elem = $("#" + _)
            }
            for (var B = 0; B < this.pageList.length; B++) for (_ in this.globalList) if (this.pageList[B].globalList[_]) this.globalList[_].posArr[B] = this.pageList[B].globalList[_];
            else this.globalList[_].posArr[B] = null
        },
        onInStart: function(C, A, $) {
            _Obj.onInStart.call(this, C, A);
            if (this.pageList[0]) {
                var _ = this.pageList[!$ ? 0 : this.pageList.length - 1];
                _.slideIn(C, true);
                for (var B in _.animList) _.animList[B].slideIn(C, A);
                this.gAnimInOut(C, A, !$ ? 0 : this.pageList.length - 1)
            }
            if (!A) this.animInOut(true, C, A)
        },
        onOutStart: function(C, _) {
            _Obj.onOutStart.call(this, C, _);
            if (this.pageList[0]) {
                var A = _ObjFunc.findCur(this.pageList),
                $ = this.pageList[A];
                for (var B in $.animList) $.animList[B].slideOut(C, _)
            }
            if (!_) this.animInOut(false, C, _)
        },
        onOutEnd: function(A, $) {
            _Obj.onOutEnd.call(this, A, $);
            if (this.pageList[0]) {
                var _ = _ObjFunc.findCur(this.pageList);
                this.pageList[_].slideOut(false, true)
            }
        },
        renderPage: function(C, _, A) {
            var B = _ObjFunc.findCur(this.pageList);
            if (!this.isAnim && ((!C && B > 0) || (C && B < this.pageList.length - 1))) {
                this.isAnim = true;
                this.pageList[C ? B + 1 : B - 1].slideIn(C, null, _, A);
                this.pageList[B].slideOut(C, null, this.done, this);
                this.gAnimInOut(C, null, C ? B + 1 : B - 1, B)
            } else if ( !! _ && $.isFunction(_)) if ( !! A) _(A);
            else _(this.elem)
        },
        renderToPage: function(_, A, B) {
            var C = _ObjFunc.findCur(this.pageList),
            D = _ObjFunc.sizeOf(this.pageList);
            if (!this.isAnim && C != _ && _ < D) {
                this.isAnim = true;
                this.pageList[_].slideIn(_ > C, null, A, B);
                this.pageList[C].slideOut(_ > C, null, this.done, this);
                this.gAnimInOut(_ > C, null, _, C)
            } else if ( !! A && $.isFunction(A)) if ( !! B) A(B);
            else A(this.elem)
        },
        animInOut: function($, B, _) {
            for (var A in this.animList) if ($) this.animList[A].slideIn(B, _);
            else this.animList[A].slideOut(B, _)
        },
        gAnimInOut: function(G, F, D, A) {
            for (var B in this.globalList) {
                var E = this.globalList[B];
                if ( !! E.posArr[D]) {
                    var _ = E.posArr[D],
                    $ = !!A ? !!E.posArr[A] ? {}: G ? E.upPos: E.dnPos: {};
                    E.elem.stop().css($).animate(_.pos, !F ? _.dur[G ? 0 : 1] : 0, _.easing[G ? 0 : 1])
                } else {
                    var $ = !!A ? !!E.posArr[A] ? {}: G ? E.upPos: E.dnPos: {},
                    C = !!A ? G ? E.dnPos: E.upPos: {};
                    if ( !! A && !!E.posArr[A]) E.elem.stop().css($).animate(C, !F ? E.dur[G ? 0 : 1] : 0, E.easing[G ? 0 : 1])
                }
            }
        }
    });
    _Page = Class(_Obj, {
        type: "page",
        animList: [],
        globalList: {},
        globalAnim: {
            has: false,
            pos: {},
            dur: [],
            easing: []
        },
        upPos: {
            top: "-100%",
            left: "0%"
        },
        dnPos: {
            top: "100%",
            left: "0%"
        },
        pos: {
            top: "0%",
            left: "0%"
        },
        init: function(A) {
            _Obj.init.call(this, A);
            this.globalAnim.easing = this.easing;
            this.globalAnim.dur = this.duration;
            for (var _ in this.globalList) this.globalList[_] = $.extend({},
            this.globalAnim, this.globalList[_])
        },
        onInStart: function(_, $) {
            _Obj.onInStart.call(this, _, $);
            if (!$) this.animInOut(true, _, $)
        },
        onOutStart: function(_, $) {
            _Obj.onOutStart.call(this, _, $);
            if (!$) this.animInOut(false, _, $)
        },
        animInOut: function($, B, _) {
            for (var A in this.animList) if ($) this.animList[A].slideIn(B, _);
            else this.animList[A].slideOut(B, _)
        }
    });
    _Anim = Class(_Obj, {
        type: "anim"
    });
    _OM = {
        isAnim: false,
        arr: [],
        init: function($) {
            for (var _ in $) this[_] = $[_]
        },
        render: function($, A, _) {
            if (this.arr.length > $ && this.arr.length > A) {
                this.arr[A].slideIn(A > $, false, this.done, this, _);
                this.arr[$].slideOut(A > $)
            }
        },
        done: function($) {
            $.isAnim = false
        },
        goTo: function(A, _) {
            var $ = _ObjFunc.findCur(this.arr),
            B = _ObjFunc.sizeOf(this.arr);
            if ($ > -1 && A != $ && A < B && !this.isAnim) {
                this.isAnim = true;
                this.render($, A, _);
                return true
            } else return false
        }
    };
    _AOM = {
        arr: [],
        tarPos: 0,
        curPos: 0,
        totalPos: 1,
        scrPos: 0,
        allPos: 100,
        getCurPos: function() {
            return this.scrollPos * this.totalPos / this.allPos
        },
        setScrPos: function($) {
            this.scrPos = $
        },
        setTarPos: function(_, $) {
            this.tarPos = _;
            if ($) this.curPos = this.tarPos
        },
        init: function($) {
            for (var _ in $) this[_] = $[_]
        },
        render: function(A, $) {
            for (var _ in this.arr) this.arr[_].render(A, $)
        }
    }
}).call(window);

//TweenMax
/**
 * VERSION: beta 1.641
 * DATE: 2012-11-08
 * JavaScript (ActionScript 3 and 2 also available)
 * UPDATES AND DOCS AT: http://www.greensock.com
 * 
 * Includes all of the following: TweenLite, TweenMax, TimelineLite, TimelineMax, easing.EasePack, plugins.CSSPlugin, plugins.RoundPropsPlugin
 *
 * Copyright (c) 2008-2012, GreenSock. All rights reserved. 
 * This work is subject to the terms in http://www.greensock.com/terms_of_use.html or for 
 * Club GreenSock members, the software agreement that was issued with your membership.
 * 
 * @author: Jack Doyle, jack@greensock.com
 **/
(window._gsQueue || (window._gsQueue = [])).push(function() {
    _gsDefine("TweenMax", ["core.Animation", "core.SimpleTimeline", "TweenLite"],
    function(s, x, g) {
        var q = function(f, d, b) {
            g.call(this, f, d, b);
            this._cycle = 0;
            this._yoyo = !0 === this.vars.yoyo;
            this._repeat = this.vars.repeat || 0;
            this._repeatDelay = this.vars.repeatDelay || 0;
            this._dirty = !0
        },
        n = q.prototype = g.to({},
        0.1, {}),
        c = [];
        q.version = 1.641;
        n.constructor = q;
        n.kill()._gc = !1;
        q.killTweensOf = q.killDelayedCallsTo = g.killTweensOf;
        q.getTweensOf = g.getTweensOf;
        q.ticker = g.ticker;
        n.invalidate = function() {
            this._yoyo = !0 === this.vars.yoyo;
            this._repeat = this.vars.repeat || 0;
            this._repeatDelay = this.vars.repeatDelay || 0;
            this._uncache(!0);
            return g.prototype.invalidate.call(this)
        };
        n.updateTo = function(f, d) {
            var b = this.ratio,
            k;
            d && (null != this.timeline && this._startTime < this._timeline._time) && (this._startTime = this._timeline._time, this._uncache(!1), this._gc ? this._enabled(!0, !1) : this._timeline.insert(this, this._startTime - this._delay));
            for (k in f) this.vars[k] = f[k];
            if (this._initted) if (d) this._initted = !1;
            else if (this._notifyPluginsOfEnabled && this._firstPT && g._onPluginEvent("_onDisable", this), 0.998 < this._time / this._duration) b = this._time,
            this.render(0, !0, !1),
            this._initted = !1,
            this.render(b, !0, !1);
            else if (0 < this._time) {
                this._initted = !1;
                this._init();
                b = 1 / (1 - b);
                k = this._firstPT;
                for (var M; k;) M = k.s + k.c,
                k.c *= b,
                k.s = M - k.c,
                k = k._next
            }
            return this
        };
        n.render = function(f, d, b) {
            var k = !this._dirty ? this._totalDuration: this.totalDuration(),
            M = this._time,
            e = this._totalTime,
            A = this._cycle,
            v,
            I;
            if (f >= k) {
                if (this._totalTime = k, this._cycle = this._repeat, this._yoyo && 0 !== (this._cycle & 1) ? (this._time = 0, this.ratio = this._ease._calcEnd ? this._ease.getRatio(0) : 0) : (this._time = this._duration, this.ratio = this._ease._calcEnd ? this._ease.getRatio(1) : 1), this._reversed || (v = !0, I = "onComplete"), 0 === this._duration) {
                    if (0 === f || 0 > this._rawPrevTime) this._rawPrevTime !== f && (b = !0);
                    this._rawPrevTime = f
                }
            } else if (0 >= f) {
                this._totalTime = this._time = this._cycle = 0;
                this.ratio = this._ease._calcEnd ? this._ease.getRatio(0) : 0;
                if (0 !== e || 0 === this._duration && 0 < this._rawPrevTime) I = "onReverseComplete",
                v = this._reversed;
                0 > f ? (this._active = !1, 0 === this._duration && (0 <= this._rawPrevTime && (b = !0), this._rawPrevTime = f)) : this._initted || (b = !0)
            } else if (this._totalTime = this._time = f, 0 !== this._repeat && (f = this._duration + this._repeatDelay, this._cycle = this._totalTime / f >> 0, 0 !== this._cycle && this._cycle === this._totalTime / f && this._cycle--, this._time = this._totalTime - this._cycle * f, this._yoyo && 0 !== (this._cycle & 1) && (this._time = this._duration - this._time), this._time > this._duration ? this._time = this._duration: 0 > this._time && (this._time = 0)), this._easeType) {
                var f = this._time / this._duration,
                k = this._easeType,
                m = this._easePower;
                if (1 === k || 3 === k && 0.5 <= f) f = 1 - f;
                3 === k && (f *= 2);
                1 === m ? f *= f: 2 === m ? f *= f * f: 3 === m ? f *= f * f * f: 4 === m && (f *= f * f * f * f);
                this.ratio = 1 === k ? 1 - f: 2 === k ? f: 0.5 > this._time / this._duration ? f / 2 : 1 - f / 2
            } else this.ratio = this._ease.getRatio(this._time / this._duration);
            if (M === this._time && !b) e !== this._totalTime && this._onUpdate && (d || this._onUpdate.apply(this.vars.onUpdateScope || this, this.vars.onUpdateParams || c));
            else {
                this._initted || (this._init(), !v && this._time && (this.ratio = this._ease.getRatio(this._time / this._duration))); ! this._active && !this._paused && (this._active = !0);
                if (0 === e && this.vars.onStart && (0 !== this._totalTime || 0 === this._duration)) d || this.vars.onStart.apply(this.vars.onStartScope || this, this.vars.onStartParams || c);
                for (b = this._firstPT; b;) {
                    if (b.f) b.t[b.p](b.c * this.ratio + b.s);
                    else b.t[b.p] = b.c * this.ratio + b.s;
                    b = b._next
                }
                this._onUpdate && (d || this._onUpdate.apply(this.vars.onUpdateScope || this, this.vars.onUpdateParams || c));
                this._cycle !== A && (d || this._gc || this.vars.onRepeat && this.vars.onRepeat.apply(this.vars.onRepeatScope || this, this.vars.onRepeatParams || c));
                I && !this._gc && (v && (this._timeline.autoRemoveChildren && this._enabled(!1, !1), this._active = !1), d || this.vars[I] && this.vars[I].apply(this.vars[I + "Scope"] || this, this.vars[I + "Params"] || c))
            }
        };
        q.to = function(b, d, i) {
            return new q(b, d, i)
        };
        q.from = function(b, d, i) {
            i.runBackwards = !0; ! 1 != i.immediateRender && (i.immediateRender = !0);
            return new q(b, d, i)
        };
        q.fromTo = function(b, d, i, k) {
            k.startAt = i;
            i.immediateRender && (k.immediateRender = !0);
            return new q(b, d, k)
        };
        q.staggerTo = q.allTo = function(b, d, i, k, e, c, A) {
            var k = k || 0,
            v = [],
            I = b.length,
            m = i.delay || 0,
            g,
            w,
            n;
            for (w = 0; w < I; w++) {
                g = {};
                for (n in i) g[n] = i[n];
                g.delay = m;
                w === I - 1 && e && (g.onComplete = function() {
                    i.onComplete && i.onComplete.apply(i.onCompleteScope, i.onCompleteParams);
                    e.apply(A, c)
                });
                v[w] = new q(b[w], d, g);
                m += k
            }
            return v
        };
        q.staggerFrom = q.allFrom = function(b, d, i, k, e, c, A) {
            i.runBackwards = !0; ! 1 != i.immediateRender && (i.immediateRender = !0);
            return q.staggerTo(b, d, i, k, e, c, A)
        };
        q.staggerFromTo = q.allFromTo = function(b, d, i, k, e, c, A, v) {
            k.startAt = i;
            i.immediateRender && (k.immediateRender = !0);
            return q.staggerTo(b, d, k, e, c, A, v)
        };
        q.delayedCall = function(b, d, i, k, e) {
            return new q(d, 0, {
                delay: b,
                onComplete: d,
                onCompleteParams: i,
                onCompleteScope: k,
                onReverseComplete: d,
                onReverseCompleteParams: i,
                onReverseCompleteScope: k,
                immediateRender: !1,
                useFrames: e,
                overwrite: 0
            })
        };
        q.set = function(b, d) {
            return new q(b, 0, d)
        };
        q.isTweening = function(b) {
            for (var b = g.getTweensOf(b), d = b.length, i; - 1 < --d;) if ((i = b[d])._active || i._startTime === i.timeline._time && i.timeline._active) return ! 0;
            return ! 1
        };
        var A = function(b, d) {
            for (var i = [], k = 0, e = b._first; e;) e instanceof g ? i[k++] = e: (d && (i[k++] = e), i = i.concat(A(e, d)), k = i.length),
            e = e._next;
            return i
        },
        e = q.getAllTweens = function(b) {
            return A(s._rootTimeline, b).concat(A(s._rootFramesTimeline, b))
        };
        q.killAll = function(b, d, i, k) {
            null == d && (d = !0);
            null == i && (i = !0);
            var c = e(!1 != k),
            A = c.length,
            k = d && i && k,
            g,
            v,
            I;
            for (I = 0; I < A; I++) if (v = c[I], k || v instanceof x || (g = v.target === v.vars.onComplete) && i || d && !g) b ? v.totalTime(v.totalDuration()) : v._enabled(!1, !1)
        };
        q.killChildTweensOf = function(b, d) {
            if (null != b) if (b.jquery) b.each(function(b, f) {
                q.killChildTweensOf(f, d)
            });
            else {
                var i = g._tweenLookup,
                k = [],
                e,
                c;
                for (c in i) for (e = i[c].target.parentNode; e;) e === b && (k = k.concat(i[c].tweens)),
                e = e.parentNode;
                e = k.length;
                for (i = 0; i < e; i++) d && k[i].totalTime(k[i].totalDuration()),
                k[i]._enabled(!1, !1)
            }
        };
        q.pauseAll = function(f, d, i) {
            b(!0, f, d, i)
        };
        q.resumeAll = function(f, d, i) {
            b(!1, f, d, i)
        };
        var b = function(b, d, i, k) {
            void 0 == d && (d = !0);
            void 0 == i && (i = !0);
            for (var c = e(k), k = d && i && k, A = c.length, g, v; - 1 < --A;) v = c[A],
            (k || v instanceof x || (g = v.target === v.vars.onComplete) && i || d && !g) && v.paused(b)
        };
        n.progress = function(b) {
            return ! arguments.length ? this._time / this.duration() : this.totalTime(this.duration() * (this._yoyo && 0 !== (this._cycle & 1) ? 1 - b: b) + this._cycle * (this._duration + this._repeatDelay), !1)
        };
        n.totalProgress = function(b) {
            return ! arguments.length ? this._totalTime / this.totalDuration() : this.totalTime(this.totalDuration() * b, !1)
        };
        n.time = function(b, d) {
            if (!arguments.length) return this._time;
            this._dirty && this.totalDuration();
            b > this._duration && (b = this._duration);
            this._yoyo && 0 !== (this._cycle & 1) ? b = this._duration - b + this._cycle * (this._duration + this._repeatDelay) : 0 != this._repeat && (b += this._cycle * (this._duration + this._repeatDelay));
            return this.totalTime(b, d)
        };
        n.totalDuration = function(b) {
            return ! arguments.length ? (this._dirty && (this._totalDuration = -1 === this._repeat ? 999999999999 : this._duration * (this._repeat + 1) + this._repeatDelay * this._repeat, this._dirty = !1), this._totalDuration) : -1 == this._repeat ? this: this.duration((b - this._repeat * this._repeatDelay) / (this._repeat + 1))
        };
        n.repeat = function(b) {
            if (!arguments.length) return this._repeat;
            this._repeat = b;
            return this._uncache(!0)
        };
        n.repeatDelay = function(b) {
            if (!arguments.length) return this._repeatDelay;
            this._repeatDelay = b;
            return this._uncache(!0)
        };
        n.yoyo = function(b) {
            if (!arguments.length) return this._yoyo;
            this._yoyo = b;
            return this
        };
        return q
    },
    !0);
    _gsDefine("TimelineLite", ["core.Animation", "core.SimpleTimeline", "TweenLite"],
    function(s, x, g) {
        var q = function(b) {
            x.call(this, b);
            this._labels = {};
            this.autoRemoveChildren = !0 == this.vars.autoRemoveChildren;
            this.smoothChildTiming = !0 == this.vars.smoothChildTiming;
            this._sortChildren = !0;
            this._onUpdate = this.vars.onUpdate;
            for (var b = n.length,
            f, d; - 1 < --b;) if (d = this.vars[n[b]]) for (f = d.length; - 1 < --f;)"{self}" === d[f] && (d = this.vars[n[b]] = d.concat(), d[f] = this);
            this.vars.tweens instanceof Array && this.insertMultiple(this.vars.tweens, 0, this.vars.align || "normal", this.vars.stagger || 0)
        },
        n = ["onStartParams", "onUpdateParams", "onCompleteParams", "onReverseCompleteParams", "onRepeatParams"],
        c = [],
        A = function(b) {
            var f = {},
            d;
            for (d in b) f[d] = b[d];
            return f
        },
        e = q.prototype = new x;
        q.version = 1.641;
        e.constructor = q;
        e.kill()._gc = !1;
        e.to = function(b, f, d, i, k) {
            return this.insert(new g(b, f, d), this._parseTimeOrLabel(k, i, !0))
        };
        e.from = function(b, f, d, i, k) {
            return this.insert(g.from(b, f, d), this._parseTimeOrLabel(k, i, !0))
        };
        e.fromTo = function(b, f, d, i, k, e) {
            return this.insert(g.fromTo(b, f, d, i), this._parseTimeOrLabel(e, k, !0))
        };
        e.staggerTo = function(b, f, d, i, k, e, c, n, v) {
            c = new q({
                onComplete: c,
                onCompleteParams: n,
                onCompleteScope: v
            });
            i = i || 0;
            for (n = 0; n < b.length; n++) null != d.startAt && (d.startAt = A(d.startAt)),
            c.insert(new g(b[n], f, A(d)), n * i);
            return this.insert(c, this._parseTimeOrLabel(e, k, !0))
        };
        e.staggerFrom = function(b, f, d, i, k, e, c, A, v) {
            null == d.immediateRender && (d.immediateRender = !0);
            d.runBackwards = !0;
            return this.staggerTo(b, f, d, i, k, e, c, A, v)
        };
        e.staggerFromTo = function(b, f, d, i, k, e, c, A, v, g) {
            i.startAt = d;
            d.immediateRender && (i.immediateRender = !0);
            return this.staggerTo(b, f, i, k, e, c, A, v, g)
        };
        e.call = function(b, f, d, i, k) {
            return this.insert(g.delayedCall(0, b, f, d), this._parseTimeOrLabel(k, i, !0))
        };
        e.set = function(b, f, d, i) {
            f.immediateRender = !1;
            return this.insert(new g(b, 0, f), this._parseTimeOrLabel(i, d, !0))
        };
        q.exportRoot = function(b, f) {
            b = b || {};
            null == b.smoothChildTiming && (b.smoothChildTiming = !0);
            var d = new q(b),
            i = d._timeline;
            null == f && (f = !0);
            i._remove(d, !0);
            d._startTime = 0;
            d._rawPrevTime = d._time = d._totalTime = i._time;
            for (var k = i._first,
            e; k;) e = k._next,
            (!f || !(k instanceof g && k.target === k.vars.onComplete)) && d.insert(k, k._startTime - k._delay),
            k = e;
            i.insert(d, 0);
            return d
        };
        e.insert = function(b, f) {
            if (! (b instanceof s)) {
                if (b instanceof Array) return this.insertMultiple(b, f);
                if ("string" === typeof b) return this.addLabel(b, this._parseTimeOrLabel(f || 0, 0, !0));
                if ("function" === typeof b) b = g.delayedCall(0, b);
                else throw "ERROR: Cannot insert() " + b + " into the TimelineLite/Max because it is neither a tween, timeline, function, nor a String.";
            }
            x.prototype.insert.call(this, b, this._parseTimeOrLabel(f || 0, 0, !0));
            if (this._gc && !this._paused && this._time === this._duration && this._time < this.duration()) for (var d = this; d._gc && d._timeline;) d._timeline.smoothChildTiming ? d.totalTime(d._totalTime, !0) : d._enabled(!0, !1),
            d = d._timeline;
            return this
        };
        e.remove = function(b) {
            if (b instanceof s) return this._remove(b, !1);
            if (b instanceof Array) {
                for (var f = b.length; - 1 < --f;) this.remove(b[f]);
                return this
            }
            return "string" === typeof b ? this.removeLabel(b) : this.kill(null, b)
        };
        e.append = function(b, f) {
            return this.insert(b, this._parseTimeOrLabel(null, f, !0))
        };
        e.insertMultiple = function(b, f, d, i) {
            for (var d = d || "normal",
            i = i || 0,
            k, e = this._parseTimeOrLabel(f || 0, 0, !0), c = b.length, f = 0; f < c; f++) {
                if ((k = b[f]) instanceof Array) k = new q({
                    tweens: k
                });
                this.insert(k, e);
                "string" === typeof k || "function" === typeof k || ("sequence" === d ? e = k._startTime + k.totalDuration() / k._timeScale: "start" === d && (k._startTime -= k.delay()));
                e += i
            }
            return this._uncache(!0)
        };
        e.appendMultiple = function(b, f, d, i) {
            return this.insertMultiple(b, this._parseTimeOrLabel(null, f, !0), d, i)
        };
        e.addLabel = function(b, f) {
            this._labels[b] = f;
            return this
        };
        e.removeLabel = function(b) {
            delete this._labels[b];
            return this
        };
        e.getLabelTime = function(b) {
            return null != this._labels[b] ? this._labels[b] : -1
        };
        e._parseTimeOrLabel = function(b, f, d) {
            if ("string" === typeof f) return this._parseTimeOrLabel(f, d && "number" === typeof b && null == this._labels[f] ? b - this.duration() : 0, d);
            f = f || 0;
            return null == b ? this.duration() + f: "string" === typeof b && isNaN(b) ? null == this._labels[b] ? d ? this._labels[b] = this.duration() + f: f: this._labels[b] + f: Number(b) + f
        };
        e.seek = function(b, f) {
            return this.totalTime(this._parseTimeOrLabel(b), !1 != f)
        };
        e.stop = function() {
            return this.paused(!0)
        };
        e.gotoAndPlay = function(b, f) {
            return x.prototype.play.call(this, b, f)
        };
        e.gotoAndStop = function(b, f) {
            return this.pause(b, f)
        };
        e.render = function(b, f, d) {
            this._gc && this._enabled(!0, !1);
            this._active = !this._paused;
            var i = !this._dirty ? this._totalDuration: this.totalDuration(),
            k = this._time,
            e = this._startTime,
            A = this._timeScale,
            g = this._paused,
            v,
            I,
            m;
            if (b >= i) {
                this._totalTime = this._time = i;
                if (!this._reversed && !this._hasPausedChild() && (v = !0, m = "onComplete", 0 === this._duration && (0 === b || 0 > this._rawPrevTime))) this._rawPrevTime !== b && (d = !0);
                this._rawPrevTime = b;
                b = i + 1E-6
            } else if (0 >= b) {
                this._totalTime = this._time = 0;
                if (0 !== k || 0 === this._duration && 0 < this._rawPrevTime) m = "onReverseComplete",
                v = this._reversed;
                0 > b ? (this._active = !1, 0 === this._duration && 0 <= this._rawPrevTime && (d = !0)) : this._initted || (d = !0);
                this._rawPrevTime = b;
                b = -1E-6
            } else this._totalTime = this._time = this._rawPrevTime = b;
            if (this._time !== k || d) {
                this._initted || (this._initted = !0);
                0 === k && this.vars.onStart && 0 !== this._time && (f || this.vars.onStart.apply(this.vars.onStartScope || this, this.vars.onStartParams || c));
                if (this._time > k) for (d = this._first; d;) {
                    I = d._next;
                    if (this._paused && !g) break;
                    else if (d._active || d._startTime <= this._time && !d._paused && !d._gc) d._reversed ? d.render((!d._dirty ? d._totalDuration: d.totalDuration()) - (b - d._startTime) * d._timeScale, f, !1) : d.render((b - d._startTime) * d._timeScale, f, !1);
                    d = I
                } else for (d = this._last; d;) {
                    I = d._prev;
                    if (this._paused && !g) break;
                    else if (d._active || d._startTime <= k && !d._paused && !d._gc) d._reversed ? d.render((!d._dirty ? d._totalDuration: d.totalDuration()) - (b - d._startTime) * d._timeScale, f, !1) : d.render((b - d._startTime) * d._timeScale, f, !1);
                    d = I
                }
                this._onUpdate && (f || this._onUpdate.apply(this.vars.onUpdateScope || this, this.vars.onUpdateParams || c));
                if (m && !this._gc && (e === this._startTime || A != this._timeScale)) if (0 === this._time || i >= this.totalDuration()) v && (this._timeline.autoRemoveChildren && this._enabled(!1, !1), this._active = !1),
                f || this.vars[m] && this.vars[m].apply(this.vars[m + "Scope"] || this, this.vars[m + "Params"] || c)
            }
        };
        e._hasPausedChild = function() {
            for (var b = this._first; b;) {
                if (b._paused || b instanceof q && b._hasPausedChild()) return ! 0;
                b = b._next
            }
            return ! 1
        };
        e.getChildren = function(b, f, d, i) {
            for (var i = i || -9999999999,
            k = [], e = this._first, c = 0; e;) e._startTime < i || (e instanceof g ? !1 != f && (k[c++] = e) : (!1 != d && (k[c++] = e), !1 != b && (k = k.concat(e.getChildren(!0, f, d)), c = k.length))),
            e = e._next;
            return k
        };
        e.getTweensOf = function(b, f) {
            for (var d = g.getTweensOf(b), i = d.length, k = [], e = 0; - 1 < --i;) if (d[i].timeline === this || f && this._contains(d[i])) k[e++] = d[i];
            return k
        };
        e._contains = function(b) {
            for (b = b.timeline; b;) {
                if (b === this) return ! 0;
                b = b.timeline
            }
            return ! 1
        };
        e.shiftChildren = function(b, f, d) {
            for (var d = d || 0,
            i = this._first; i;) i._startTime >= d && (i._startTime += b),
            i = i._next;
            if (f) for (var k in this._labels) this._labels[k] >= d && (this._labels[k] += b);
            return this._uncache(!0)
        };
        e._kill = function(b, f) {
            if (null == b && null == f) return this._enabled(!1, !1);
            for (var d = null == f ? this.getChildren(!0, !0, !1) : this.getTweensOf(f), i = d.length, k = !1; - 1 < --i;) d[i]._kill(b, f) && (k = !0);
            return k
        };
        e.clear = function(b) {
            var f = this.getChildren(!1, !0, !0),
            d = f.length;
            for (this._time = this._totalTime = 0; - 1 < --d;) f[d]._enabled(!1, !1); ! 1 != b && (this._labels = {});
            return this._uncache(!0)
        };
        e.invalidate = function() {
            for (var b = this._first; b;) b.invalidate(),
            b = b._next;
            return this
        };
        e._enabled = function(b, f) {
            if (b === this._gc) for (var d = this._first; d;) d._enabled(b, !0),
            d = d._next;
            return x.prototype._enabled.call(this, b, f)
        };
        e.progress = function(b) {
            return ! arguments.length ? this._time / this.duration() : this.totalTime(this.duration() * b, !1)
        };
        e.duration = function(b) {
            if (!arguments.length) return this._dirty && this.totalDuration(),
            this._duration;
            0 !== this.duration() && 0 !== b && this.timeScale(this._duration / b);
            return this
        };
        e.totalDuration = function(b) {
            if (!arguments.length) {
                if (this._dirty) {
                    for (var f = 0,
                    d = this._first,
                    i = -999999999999,
                    k; d;) k = d._next,
                    d._startTime < i && this._sortChildren ? this.insert(d, d._startTime - d._delay) : i = d._startTime,
                    0 > d._startTime && (f -= d._startTime, this.shiftChildren( - d._startTime, !1, -9999999999)),
                    d = d._startTime + (!d._dirty ? d._totalDuration: d.totalDuration()) / d._timeScale,
                    d > f && (f = d),
                    d = k;
                    this._duration = this._totalDuration = f;
                    this._dirty = !1
                }
                return this._totalDuration
            }
            0 !== this.totalDuration() && 0 !== b && this.timeScale(this._totalDuration / b);
            return this
        };
        e.usesFrames = function() {
            for (var b = this._timeline; b._timeline;) b = b._timeline;
            return b === s._rootFramesTimeline
        };
        e.rawTime = function() {
            return this._paused || 0 !== this._totalTime && this._totalTime !== this._totalDuration ? this._totalTime: (this._timeline.rawTime() - this._startTime) * this._timeScale
        };
        return q
    },
    !0);
    _gsDefine("TimelineMax", ["TimelineLite", "TweenLite", "easing.Ease"],
    function(s, x, g) {
        var q = function(c) {
            s.call(this, c);
            this._repeat = this.vars.repeat || 0;
            this._repeatDelay = this.vars.repeatDelay || 0;
            this._cycle = 0;
            this._yoyo = !0 == this.vars.yoyo;
            this._dirty = !0
        },
        n = [],
        c = new g(null, null, 1, 0),
        g = q.prototype = new s;
        g.constructor = q;
        g.kill()._gc = !1;
        q.version = 1.641;
        g.invalidate = function() {
            this._yoyo = !0 === this.vars.yoyo;
            this._repeat = this.vars.repeat || 0;
            this._repeatDelay = this.vars.repeatDelay || 0;
            this._uncache(!0);
            return s.prototype.invalidate.call(this)
        };
        g.addCallback = function(c, e, b, f) {
            return this.insert(x.delayedCall(0, c, b, f), e)
        };
        g.removeCallback = function(c, e) {
            if (null == e) this._kill(null, c);
            else for (var b = this.getTweensOf(c, !1), f = b.length, d = this._parseTimeOrLabel(e); - 1 < --f;) b[f]._startTime === d && b[f]._enabled(!1, !1);
            return this
        };
        g.tweenTo = function(A, e) {
            var e = e || {},
            b = {
                ease: c,
                overwrite: 2,
                useFrames: this.usesFrames(),
                immediateRender: !1
            },
            f,
            d;
            for (f in e) b[f] = e[f];
            b.time = this._parseTimeOrLabel(A);
            d = new x(this, Math.abs(Number(b.time) - this._time) / this._timeScale || 0.001, b);
            b.onStart = function() {
                d.target.paused(!0);
                d.vars.time !== d.target.time() && d.duration(Math.abs(d.vars.time - d.target.time()) / d.target._timeScale);
                e.onStart && e.onStart.apply(e.onStartScope || d, e.onStartParams || n)
            };
            return d
        };
        g.tweenFromTo = function(c, e, b) {
            b = b || {};
            b.startAt = {
                time: this._parseTimeOrLabel(c)
            };
            c = this.tweenTo(e, b);
            return c.duration(Math.abs(c.vars.time - c.vars.startAt.time) / this._timeScale || 0.001)
        };
        g.render = function(c, e, b) {
            this._gc && this._enabled(!0, !1);
            this._active = !this._paused;
            var f = !this._dirty ? this._totalDuration: this.totalDuration(),
            d = this._time,
            i = this._totalTime,
            k = this._startTime,
            g = this._timeScale,
            q = this._rawPrevTime,
            x = this._paused,
            v = this._cycle,
            I,
            m;
            if (c >= f) {
                this._locked || (this._totalTime = f, this._cycle = this._repeat);
                if (!this._reversed && !this._hasPausedChild() && (I = !0, m = "onComplete", 0 === this._duration && (0 === c || 0 > this._rawPrevTime))) this._rawPrevTime !== c && (b = !0);
                this._rawPrevTime = c;
                this._yoyo && 0 !== (this._cycle & 1) ? (this._time = 0, c = -1E-6) : (this._time = this._duration, c = this._duration + 1E-6)
            } else if (0 >= c) {
                this._locked || (this._totalTime = this._cycle = 0);
                this._time = 0;
                if (0 !== d || 0 === this._duration && 0 < this._rawPrevTime && !this._locked) m = "onReverseComplete",
                I = this._reversed;
                0 > c ? (this._active = !1, 0 === this._duration && 0 <= this._rawPrevTime && (b = !0)) : this._initted || (b = !0);
                this._rawPrevTime = c;
                c = 0 === this._duration ? 0 : -1E-6
            } else if (this._time = this._rawPrevTime = c, !this._locked && (this._totalTime = c, 0 !== this._repeat)) {
                var B = this._duration + this._repeatDelay;
                this._cycle = this._totalTime / B >> 0;
                0 !== this._cycle && this._cycle === this._totalTime / B && this._cycle--;
                this._time = this._totalTime - this._cycle * B;
                this._yoyo && 0 !== (this._cycle & 1) && (this._time = this._duration - this._time);
                this._time > this._duration ? (this._time = this._duration, c = this._duration + 1E-6) : 0 > this._time ? this._time = c = 0 : c = this._time
            }
            if (this._cycle !== v && !this._locked) {
                var B = this._yoyo && 0 !== (v & 1),
                w = B === (this._yoyo && 0 !== (this._cycle & 1)),
                s = this._totalTime,
                L = this._cycle,
                E = this._rawPrevTime,
                C = this._time;
                this._totalTime = v * this._duration;
                this._cycle < v ? B = !B: this._totalTime += this._duration;
                this._time = d;
                this._rawPrevTime = 0 === this._duration ? q - 1E-5: q;
                this._cycle = v;
                this._locked = !0;
                d = B ? 0 : this._duration;
                this.render(d, e, 0 === this._duration);
                e || this._gc || this.vars.onRepeat && this.vars.onRepeat.apply(this.vars.onRepeatScope || this, this.vars.onRepeatParams || n);
                w && (d = B ? this._duration + 1E-6: -1E-6, this.render(d, !0, !1));
                this._time = C;
                this._totalTime = s;
                this._cycle = L;
                this._rawPrevTime = E;
                this._locked = !1
            }
            if (this._time === d && !b) i !== this._totalTime && this._onUpdate && (e || this._onUpdate.apply(this.vars.onUpdateScope || this, this.vars.onUpdateParams || n));
            else {
                this._initted || (this._initted = !0);
                0 === i && this.vars.onStart && 0 !== this._totalTime && (e || this.vars.onStart.apply(this.vars.onStartScope || this, this.vars.onStartParams || n));
                if (this._time > d) for (b = this._first; b;) {
                    i = b._next;
                    if (this._paused && !x) break;
                    else if (b._active || b._startTime <= this._time && !b._paused && !b._gc) b._reversed ? b.render((!b._dirty ? b._totalDuration: b.totalDuration()) - (c - b._startTime) * b._timeScale, e, !1) : b.render((c - b._startTime) * b._timeScale, e, !1);
                    b = i
                } else for (b = this._last; b;) {
                    i = b._prev;
                    if (this._paused && !x) break;
                    else if (b._active || b._startTime <= d && !b._paused && !b._gc) b._reversed ? b.render((!b._dirty ? b._totalDuration: b.totalDuration()) - (c - b._startTime) * b._timeScale, e, !1) : b.render((c - b._startTime) * b._timeScale, e, !1);
                    b = i
                }
                this._onUpdate && (e || this._onUpdate.apply(this.vars.onUpdateScope || this, this.vars.onUpdateParams || n));
                if (m && !this._locked && !this._gc && (k === this._startTime || g !== this._timeScale)) if (0 === this._time || f >= this.totalDuration()) I && (this._timeline.autoRemoveChildren && this._enabled(!1, !1), this._active = !1),
                e || this.vars[m] && this.vars[m].apply(this.vars[m + "Scope"] || this, this.vars[m + "Params"] || n)
            }
        };
        g.getActive = function(c, e, b) {
            null == c && (c = !0);
            null == e && (e = !0);
            null == b && (b = !1);
            var f = [],
            c = this.getChildren(c, e, b),
            e = 0,
            b = c.length,
            d,
            i;
            for (d = 0; d < b; d++) if (i = c[d], !i._paused && i._timeline._time >= i._startTime && i._timeline._time < i._startTime + i._totalDuration / i._timeScale) {
                var k;
                a: {
                    for (k = i._timeline; k;) {
                        if (k._paused) {
                            k = !0;
                            break a
                        }
                        k = k._timeline
                    }
                    k = !1
                }
                k || (f[e++] = i)
            }
            return f
        };
        g.getLabelAfter = function(c) { ! c && 0 !== c && (c = this._time);
            var e = this.getLabelsArray(),
            b = e.length,
            f;
            for (f = 0; f < b; f++) if (e[f].time > c) return e[f].name;
            return null
        };
        g.getLabelBefore = function(c) {
            null == c && (c = this._time);
            for (var e = this.getLabelsArray(), b = e.length; - 1 < --b;) if (e[b].time < c) return e[b].name;
            return null
        };
        g.getLabelsArray = function() {
            var c = [],
            e = 0,
            b;
            for (b in this._labels) c[e++] = {
                time: this._labels[b],
                name: b
            };
            c.sort(function(b, d) {
                return b.time - d.time
            });
            return c
        };
        g.progress = function(c) {
            return ! arguments.length ? this._time / this.duration() : this.totalTime(this.duration() * (this._yoyo && 0 !== (this._cycle & 1) ? 1 - c: c) + this._cycle * (this._duration + this._repeatDelay), !1)
        };
        g.totalProgress = function(c) {
            return ! arguments.length ? this._totalTime / this.totalDuration() : this.totalTime(this.totalDuration() * c, !1)
        };
        g.totalDuration = function(c) {
            return ! arguments.length ? (this._dirty && (s.prototype.totalDuration.call(this), this._totalDuration = -1 === this._repeat ? 999999999999 : this._duration * (this._repeat + 1) + this._repeatDelay * this._repeat), this._totalDuration) : -1 === this._repeat ? this: this.duration((c - this._repeat * this._repeatDelay) / (this._repeat + 1))
        };
        g.time = function(c, e) {
            if (!arguments.length) return this._time;
            this._dirty && this.totalDuration();
            c > this._duration && (c = this._duration);
            this._yoyo && 0 !== (this._cycle & 1) ? c = this._duration - c + this._cycle * (this._duration + this._repeatDelay) : 0 !== this._repeat && (c += this._cycle * (this._duration + this._repeatDelay));
            return this.totalTime(c, e)
        };
        g.repeat = function(c) {
            if (!arguments.length) return this._repeat;
            this._repeat = c;
            return this._uncache(!0)
        };
        g.repeatDelay = function(c) {
            if (!arguments.length) return this._repeatDelay;
            this._repeatDelay = c;
            return this._uncache(!0)
        };
        g.yoyo = function(c) {
            if (!arguments.length) return this._yoyo;
            this._yoyo = c;
            return this
        };
        g.currentLabel = function(c) {
            return ! arguments.length ? this.getLabelBefore(this._time + 1E-8) : this.seek(c, !0)
        };
        return q
    },
    !0);
    _gsDefine("plugins.BezierPlugin", ["plugins.TweenPlugin"],
    function(s) {
        var x = function() {
            s.call(this, "bezier", -1);
            this._overwriteProps.pop();
            this._func = {};
            this._round = {}
        },
        g = x.prototype = new s("bezier", 1),
        q = 180 / Math.PI,
        n = [],
        c = [],
        A = [],
        e = {},
        b = function(b, d, c, f) {
            this.a = b;
            this.b = d;
            this.c = c;
            this.d = f;
            this.da = f - b;
            this.ca = c - b;
            this.ba = d - b
        },
        f = x.bezierThrough = function(i, k, f, g, q, v) {
            var I = {},
            m = [],
            B,
            w,
            q = "string" === typeof q ? "," + q + ",": ",x,y,z,left,top,right,bottom,marginTop,marginLeft,marginRight,marginBottom,paddingLeft,paddingTop,paddingRight,paddingBottom,backgroundPosition,backgroundPosition_y,";
            null == k && (k = 1);
            for (w in i[0]) m.push(w);
            n.length = c.length = A.length = 0;
            for (B = m.length; - 1 < --B;) {
                w = m[B];
                e[w] = -1 !== q.indexOf("," + w + ",");
                var x = I,
                L = w,
                E;
                E = i;
                var C = w,
                u = e[w],
                y = v,
                G = [],
                F = void 0,
                z = void 0,
                s = void 0,
                J = void 0,
                h = void 0,
                F = void 0;
                if (y) {
                    E = [y].concat(E);
                    for (z = E.length; - 1 < --z;) if ("string" === typeof(F = E[z][C]))"=" === F.charAt(1) && (E[z][C] = y[C] + Number(F.charAt(0) + F.substr(2)))
                }
                F = E.length - 2;
                if (0 > F) G[0] = new b(E[0][C], 0, 0, E[ - 1 > F ? 0 : 1][C]);
                else {
                    for (z = 0; z < F; z++) s = E[z][C],
                    J = E[z + 1][C],
                    G[z] = new b(s, 0, 0, J),
                    u && (h = E[z + 2][C], n[z] = (n[z] || 0) + (J - s) * (J - s), c[z] = (c[z] || 0) + (h - J) * (h - J));
                    G[z] = new b(E[z][C], 0, 0, E[z + 1][C])
                }
                E = G;
                x[L] = E
            }
            for (B = n.length; - 1 < --B;) n[B] = Math.sqrt(n[B]),
            c[B] = Math.sqrt(c[B]);
            if (!g) {
                for (B = m.length; - 1 < --B;) if (e[w]) {
                    a = I[m[B]];
                    l = a.length - 1;
                    for (j = 0; j < l; j++) r = a[j + 1].da / c[j] + a[j].da / n[j],
                    A[j] = (A[j] || 0) + r * r
                }
                for (B = A.length; - 1 < --B;) A[B] = Math.sqrt(A[B])
            }
            for (B = m.length; - 1 < --B;) {
                w = m[B];
                i = I[w];
                q = k;
                v = f;
                x = g;
                w = e[w];
                L = i.length - 1;
                E = 0;
                for (var C = i[0].a, t = h = J = y = F = J = s = F = z = s = G = y = u = void 0, u = 0; u < L; u++) z = i[E],
                y = z.a,
                G = z.d,
                s = i[E + 1].d,
                w ? (J = n[u], h = c[u], t = 0.25 * (h + J) * q / (x ? 0.5 : A[u] || 0.5), F = G - (G - y) * (x ? 0.5 * q: t / J), s = G + (s - G) * (x ? 0.5 * q: t / h), J = G - (F + (s - F) * (3 * J / (J + h) + 0.5) / 4)) : (F = G - 0.5 * (G - y) * q, s = G + 0.5 * (s - G) * q, J = G - (F + s) / 2),
                F += J,
                s += J,
                z.c = F,
                z.b = 0 != u ? C: C = z.a + 0.6 * (z.c - z.a),
                z.da = G - y,
                z.ca = F - y,
                z.ba = C - y,
                v ? (y = d(y, C, F, G), i.splice(E, 1, y[0], y[1], y[2], y[3]), E += 4) : E++,
                C = s;
                z = i[E];
                z.b = C;
                z.c = C + 0.4 * (z.d - C);
                z.da = z.d - z.a;
                z.ca = z.c - z.a;
                z.ba = C - z.a;
                v && (y = d(z.a, C, z.c, z.d), i.splice(E, 1, y[0], y[1], y[2], y[3]))
            }
            return I
        },
        d = x.cubicToQuadratic = function(b, d, c, f) {
            var e = {
                a: b
            },
            v = {},
            g = {},
            q = {
                c: f
            },
            n = (b + d) / 2,
            w = (d + c) / 2,
            c = (c + f) / 2,
            d = (n + w) / 2,
            w = (w + c) / 2,
            s = (w - d) / 8;
            e.b = n + (b - n) / 4;
            v.b = d + s;
            e.c = v.a = (e.b + v.b) / 2;
            v.c = g.a = (d + w) / 2;
            g.b = w - s;
            q.b = c + (f - c) / 4;
            g.c = q.a = (g.b + q.b) / 2;
            return [e, v, g, q]
        };
        x.quadraticToCubic = function(d, c, f) {
            return new b(d, (2 * c + d) / 3, (2 * c + f) / 3, f)
        };
        g.constructor = x;
        x.API = 2;
        g._onInitTween = function(d, c, e) {
            this._target = d;
            c instanceof Array && (c = {
                values: c
            });
            this._props = [];
            this._timeRes = null == c.timeResolution ? 6 : parseInt(c.timeResolution);
            var g = c.values || [],
            q = {},
            v = g[0],
            e = c.autoRotate || e.vars.orientToBezier,
            n,
            m,
            B;
            this._autoRotate = e ? e instanceof Array ? e: [["x", "y", "rotation", !0 === e ? 0 : Number(e) || 0]] : null;
            for (n in v) this._props.push(n);
            for (v = this._props.length; - 1 < --v;) n = this._props[v],
            this._overwriteProps.push(n),
            e = this._func[n] = "function" === typeof d[n],
            q[n] = !e ? parseFloat(d[n]) : d[n.indexOf("set") || "function" !== typeof d["get" + n.substr(3)] ? n: "get" + n.substr(3)](),
            B || q[n] !== g[0][n] && (B = q);
            if ("cubic" !== c.type && "quadratic" !== c.type && "soft" !== c.type) q = f(g, isNaN(c.curviness) ? 1 : c.curviness, !1, "thruBasic" === c.type, c.correlate, B);
            else {
                e = (e = c.type) || "soft";
                c = {};
                B = "cubic" === e ? 3 : 2;
                var e = "soft" === e,
                v = [],
                w,
                s,
                x,
                A,
                C,
                u,
                y,
                G,
                F;
                e && q && (g = [q].concat(g));
                if (null == g || g.length < B + 1) throw "invalid Bezier data";
                for (s in g[0]) v.push(s);
                for (u = v.length; - 1 < --u;) {
                    s = v[u];
                    c[s] = C = [];
                    F = 0;
                    G = g.length;
                    for (y = 0; y < G; y++) w = null == q ? g[y][s] : "string" === typeof(x = g[y][s]) && "=" === x.charAt(1) ? q[s] + Number(x.charAt(0) + x.substr(2)) : Number(x),
                    e && 1 < y && y < G - 1 && (C[F++] = (w + C[F - 2]) / 2),
                    C[F++] = w;
                    G = F - B + 1;
                    for (y = F = 0; y < G; y += B) w = C[y],
                    s = C[y + 1],
                    x = C[y + 2],
                    A = 2 === B ? 0 : C[y + 3],
                    C[F++] = x = 3 === B ? new b(w, s, x, A) : new b(w, (2 * s + w) / 3, (2 * s + x) / 3, x);
                    C.length = F
                }
                q = c
            }
            this._beziers = q;
            this._segCount = this._beziers[n].length;
            if (this._timeRes) {
                v = this._beziers;
                n = this._timeRes;
                n = n >> 0 || 6;
                q = [];
                s = [];
                g = x = 0;
                c = n - 1;
                B = [];
                e = [];
                for (m in v) {
                    w = v[m];
                    C = q;
                    u = n;
                    y = 1 / u;
                    G = w.length;
                    for (var z = void 0,
                    R = void 0,
                    J = A = F = R = void 0,
                    h = z = void 0,
                    t = void 0,
                    t = J = void 0; - 1 < --G;) {
                        J = w[G];
                        R = J.a;
                        F = J.d - R;
                        A = J.c - R;
                        J = J.b - R;
                        R = 0;
                        for (h = 1; h <= u; h++) z = y * h,
                        t = 1 - z,
                        z = R - (R = (z * z * F + 3 * t * (z * A + t * J)) * z),
                        t = G * u + h - 1,
                        C[t] = (C[t] || 0) + z * z
                    }
                }
                v = q.length;
                for (m = 0; m < v; m++) x += Math.sqrt(q[m]),
                w = m % n,
                e[w] = x,
                w === c && (g += x, w = m / n >> 0, B[w] = e, s[w] = g, x = 0, e = []);
                this._length = g;
                this._lengths = s;
                this._segments = B;
                this._l1 = this._li = this._s1 = this._si = 0;
                this._l2 = this._lengths[0];
                this._curSeg = this._segments[0];
                this._s2 = this._curSeg[0];
                this._prec = 1 / this._curSeg.length
            }
            if (e = this._autoRotate) {
                e[0] instanceof Array || (this._autoRotate = e = [e]);
                for (v = e.length; - 1 < --v;) for (m = 0; 3 > m; m++) n = e[v][m],
                this._func[n] = "function" === typeof d[n] ? d[n.indexOf("set") || "function" !== typeof d["get" + n.substr(3)] ? n: "get" + n.substr(3)] : !1
            }
            return ! 0
        };
        g.setRatio = function(b) {
            var d = this._segCount,
            c = this._func,
            e = this._target,
            f, g, n, m, s;
            if (this._timeRes) {
                f = this._lengths;
                m = this._curSeg;
                b *= this._length;
                g = this._li;
                if (b > this._l2 && g < d - 1) {
                    for (d -= 1; g < d && (this._l2 = f[++g]) <= b;);
                    this._l1 = f[g - 1];
                    this._li = g;
                    this._curSeg = m = this._segments[g];
                    this._s2 = m[this._s1 = this._si = 0]
                } else if (b < this._l1 && 0 < g) {
                    for (; 0 < g && (this._l1 = f[--g]) >= b;);
                    0 === g && b < this._l1 ? this._l1 = 0 : g++;
                    this._l2 = f[g];
                    this._li = g;
                    this._curSeg = m = this._segments[g];
                    this._s1 = m[(this._si = m.length - 1) - 1] || 0;
                    this._s2 = m[this._si]
                }
                f = g;
                b -= this._l1;
                g = this._si;
                if (b > this._s2 && g < m.length - 1) {
                    for (d = m.length - 1; g < d && (this._s2 = m[++g]) <= b;);
                    this._s1 = m[g - 1];
                    this._si = g
                } else if (b < this._s1 && 0 < g) {
                    for (; 0 < g && (this._s1 = m[--g]) >= b;);
                    0 === g && b < this._s1 ? this._s1 = 0 : g++;
                    this._s2 = m[g];
                    this._si = g
                }
                m = (g + (b - this._s1) / (this._s2 - this._s1)) * this._prec
            } else f = 0 > b ? 0 : 1 <= b ? d - 1 : d * b >> 0,
            m = (b - f * (1 / d)) * d;
            d = 1 - m;
            for (g = this._props.length; - 1 < --g;) if (b = this._props[g], n = this._beziers[b][f], s = (m * m * n.da + 3 * d * (m * n.ca + d * n.ba)) * m + n.a, this._round[b] && (s = s + (0 < s ? 0.5 : -0.5) >> 0), c[b]) e[b](s);
            else e[b] = s;
            if (this._autoRotate) {
                var d = this._autoRotate,
                w, x, A, E, C;
                for (g = d.length; - 1 < --g;) b = d[g][2],
                E = d[g][3] || 0,
                C = !0 == d[g][4] ? 1 : q,
                n = this._beziers[d[g][0]][f],
                s = this._beziers[d[g][1]][f],
                w = n.a + (n.b - n.a) * m,
                x = n.b + (n.c - n.b) * m,
                w += (x - w) * m,
                x += (n.c + (n.d - n.c) * m - x) * m,
                n = s.a + (s.b - s.a) * m,
                A = s.b + (s.c - s.b) * m,
                n += (A - n) * m,
                A += (s.c + (s.d - s.c) * m - A) * m,
                s = Math.atan2(A - n, x - w) * C + E,
                c[b] ? c[b].call(e, s) : e[b] = s
            }
        };
        g._roundProps = function(b, d) {
            for (var c = this._overwriteProps,
            e = c.length; - 1 < --e;) if (b[c[e]] || b.bezier || b.bezierThrough) this._round[c[e]] = d
        };
        g._kill = function(b) {
            var d = this._props,
            c, e;
            for (c in _beziers) if (c in b) {
                delete this._beziers[c];
                delete this._func[c];
                for (e = d.length; - 1 < --e;) d[e] === c && d.splice(e, 1)
            }
            return s.prototype._kill.call(this, b)
        };
        s.activate([x]);
        return x
    },
    !0);
    _gsDefine("plugins.CSSPlugin", ["plugins.TweenPlugin", "TweenLite"],
    function(s) {
        var x = function() {
            s.call(this, "css");
            this._overwriteProps.length = 0
        },
        g,
        q,
        n,
        c,
        A = {},
        e = x.prototype = new s("css");
        e.constructor = x;
        x.version = 1.641;
        x.API = 2;
        x.defaultTransformPerspective = 0;
        e = "px";
        x.suffixMap = {
            top: e,
            right: e,
            bottom: e,
            left: e,
            width: e,
            height: e,
            fontSize: e,
            padding: e,
            margin: e,
            perspective: e
        };
        var b = /(?:\d|\-\d|\.\d|\-\.\d)+/g,
        f = /(?:\d|\-\d|\.\d|\-\.\d|\+=\d|\-=\d|\+=.\d|\-=\.\d)+/g,
        d = /(?:\+=|\-=|\-|\b)[\d\-\.]+[a-zA-Z0-9]*(?:%|\b)/gi,
        i = /[^\d\-\.]/g,
        k = /(?:\d|\-|\+|=|#|\.)*/g,
        M = /opacity *= *([^)]*)/,
        aa = /opacity:([^;]*)/,
        W = /([A-Z])/g,
        v = /-([a-z])/gi,
        I = function(b, h) {
            return h.toUpperCase()
        },
        m = /(?:Left|Right|Width)/i,
        B = /(M11|M12|M21|M22)=[\d\-\.e]+/gi,
        w = /progid\:DXImageTransform\.Microsoft\.Matrix\(.+?\)/i,
        S = Math.PI / 180,
        L = 180 / Math.PI,
        E = {},
        C = document,
        u = C.createElement("div"),
        y = navigator.userAgent,
        G,
        F,
        z,
        R,
        J,
        h,
        t = y.indexOf("Android"),
        p = C.createElement("div");
        R = (z = -1 !== y.indexOf("Safari") && -1 === y.indexOf("Chrome") && ( - 1 === t || 3 < Number(y.substr(t + 8, 1)))) && 6 > Number(y.substr(y.indexOf("Version/") + 8, 1));
        /MSIE ([0-9]{1,}[\.0-9]{0,})/.exec(y);
        J = parseFloat(RegExp.$1);
        p.innerHTML = "<a style='top:1px;opacity:.55;'>a</a>";
        h = (y = p.getElementsByTagName("a")[0]) ? /^0.55/.test(y.style.opacity) : !1;
        var H = function(b) {
            return M.test("string" === typeof b ? b: (b.currentStyle ? b.currentStyle.filter: b.style.filter) || "") ? parseFloat(RegExp.$1) / 100 : 1
        },
        D = "",
        N = "",
        U = function(b, h) {
            var h = h || u,
            d = h.style,
            c, e;
            if (void 0 !== d[b]) return b;
            b = b.charAt(0).toUpperCase() + b.substr(1);
            c = ["O", "Moz", "ms", "Ms", "Webkit"];
            for (e = 5; - 1 < --e && void 0 === d[c[e] + b];);
            return 0 <= e ? (N = 3 === e ? "ms": c[e], D = "-" + N.toLowerCase() + "-", N + b) : null
        },
        K = C.defaultView ? C.defaultView.getComputedStyle: function() {},
        Q = x.getStyle = function(b, X, d, c, e) {
            var f;
            if (!h && "opacity" === X) return H(b); ! c && b.style[X] ? f = b.style[X] : (d = d || K(b, null)) ? f = (b = d.getPropertyValue(X.replace(W, "-$1").toLowerCase())) || d.length ? b: d[X] : b.currentStyle && (d = b.currentStyle, f = d[X], !f && "backgroundPosition" === X && (f = d[X + "X"] + " " + d[X + "Y"]));
            return null != e && (!f || "none" === f || "auto" === f || "auto auto" === f) ? e: f
        },
        ea = function(b, d) {
            var c = {},
            e;
            if (d = d || K(b, null)) if (e = d.length) for (; - 1 < --e;) c[d[e].replace(v, I)] = d.getPropertyValue(d[e]);
            else for (e in d) c[e] = d[e];
            else if (d = b.currentStyle || b.style) for (e in d) c[e.replace(v, I)] = d[e];
            h || (c.opacity = H(b));
            e = ga(b, d, !1);
            c.rotation = e.rotation * L;
            c.rotationX = e.rotationX * L;
            c.rotationY = e.rotationY * L;
            c.skewX = e.skewX * L;
            c.scaleX = e.scaleX;
            c.scaleY = e.scaleY;
            c.scaleZ = e.scaleZ;
            c.x = e.x;
            c.y = e.y;
            c.z = e.z;
            c.filters && delete c.filters;
            return c
        },
        la = function(b, h, d, c) {
            var e = {},
            b = b.style,
            f, p, t;
            for (p in d) if ("cssText" !== p && "length" !== p && isNaN(p) && h[p] !== (f = d[p])) if ( - 1 === p.indexOf("Origin") && ("number" === typeof f || "string" === typeof f)) e[p] = ("" === f || "auto" === f || "none" === f) && "string" === typeof h[p] && "" !== h[p].replace(i, "") ? 0 : f,
            void 0 !== b[p] && (t = new ha(b, p, b[p], t));
            if (c) for (p in c)"className" !== p && (e[p] = c[p]);
            return {
                difs: e,
                firstMPT: t
            }
        },
        qa = {
            width: ["Left", "Right"],
            height: ["Top", "Bottom"]
        },
        ra = ["marginLeft", "marginRight", "marginTop", "marginBottom"],
        Y = function(b, h, d, c, e) {
            if ("px" === c || !c) return d;
            if ("auto" === c || !d) return 0;
            var f = m.test(h),
            p = b,
            t = u.style,
            g = 0 > d;
            g && (d = -d);
            "%" === c && -1 !== h.indexOf("border") ? f = d / 100 * (f ? b.clientWidth: b.clientHeight) : (t.cssText = "border-style:solid; border-width:0; position:absolute; line-height:0;", "%" === c || "em" === c || !p.appendChild ? (p = b.parentNode || C.body, t[f ? "width": "height"] = d + c) : t[f ? "borderLeftWidth": "borderTopWidth"] = d + c, p.appendChild(u), f = parseFloat(u[f ? "offsetWidth": "offsetHeight"]), p.removeChild(u), 0 === f && !e && (f = Y(b, h, d, c, !0)));
            return g ? -f: f
        },
        ia = function(b, h) {
            if (null == b || "" === b || "auto" === b || "auto auto" === b) b = "0 0";
            var d = b.split(" "),
            c = -1 !== b.indexOf("left") ? "0%": -1 !== b.indexOf("right") ? "100%": d[0],
            e = -1 !== b.indexOf("top") ? "0%": -1 !== b.indexOf("bottom") ? "100%": d[1];
            null == e ? e = "0": "center" === e && (e = "50%");
            if ("center" === c || isNaN(parseFloat(c))) c = "50%";
            h && (h.oxp = -1 !== c.indexOf("%"), h.oyp = -1 !== e.indexOf("%"), h.oxr = "=" === c.charAt(1), h.oyr = "=" === e.charAt(1), h.ox = parseFloat(c.replace(i, "")), h.oy = parseFloat(e.replace(i, "")));
            return c + " " + e + (2 < d.length ? " " + d[2] : "")
        },
        ma = function(b, h) {
            return "string" === typeof b && "=" === b.charAt(1) ? parseInt(b.charAt(0) + "1") * parseFloat(b.substr(2)) : parseFloat(b) - parseFloat(h)
        },
        Z = function(b, h) {
            return null == b ? h: "string" === typeof b && "=" === b.charAt(1) ? parseInt(b.charAt(0) + "1") * Number(b.substr(2)) + h: Number(b)
        },
        ba = function(b, h) {
            if (null == b) return h;
            var d = -1 === b.indexOf("rad") ? S: 1,
            c = "=" === b.charAt(1),
            b = Number(b.replace(i, "")) * d;
            return c ? b + h: b
        },
        ja = function(b, h) {
            var d = (("number" === typeof b ? b * S: ba(b, h)) - h) % (2 * Math.PI);
            d !== d % Math.PI && (d += Math.PI * (0 > d ? 2 : -2));
            return h + d
        },
        ca = {
            aqua: [0, 255, 255],
            lime: [0, 255, 0],
            silver: [192, 192, 192],
            black: [0, 0, 0],
            maroon: [128, 0, 0],
            teal: [0, 128, 128],
            blue: [0, 0, 255],
            navy: [0, 0, 128],
            white: [255, 255, 255],
            fuchsia: [255, 0, 255],
            olive: [128, 128, 0],
            yellow: [255, 255, 0],
            orange: [255, 165, 0],
            gray: [128, 128, 128],
            purple: [128, 0, 128],
            green: [0, 128, 0],
            red: [255, 0, 0],
            pink: [255, 192, 203],
            cyan: [0, 255, 255],
            transparent: [255, 255, 255, 0]
        },
        ka = function(h) {
            if (!h || "" === h) return ca.black;
            if (ca[h]) return ca[h];
            if ("number" === typeof h) return [h >> 16, h >> 8 & 255, h & 255];
            if ("#" === h.charAt(0)) {
                if (4 === h.length) var d = h.charAt(1),
                c = h.charAt(2),
                h = h.charAt(3),
                h = "#" + d + d + c + c + h + h;
                h = parseInt(h.substr(1), 16);
                return [h >> 16, h >> 8 & 255, h & 255]
            }
            h = h.match(b) || ca.transparent;
            h[0] = Number(h[0]);
            h[1] = Number(h[1]);
            h[2] = Number(h[2]);
            3 < h.length && (h[3] = Number(h[3]));
            return h
        },
        $ = "(?:\\b(?:(?:rgb|rgba)\\(.+?\\))|\\B#.+?\\b";
        for (e in ca) $ += "|" + e + "\\b";
        var $ = RegExp($ + ")", "gi"),
        na = function(h, c, e) {
            if (null == h) return function(b) {
                return b
            };
            var f = c ? (h.match($) || [""])[0] : "",
            p = h.split(f).join("").match(d) || [],
            t = h.substr(0, h.indexOf(p[0])),
            u = ")" === h.charAt(h.length - 1) ? ")": "",
            g = -1 !== h.indexOf(" ") ? " ": ",",
            i = p.length,
            k = 0 < i ? p[0].replace(b, "") : "";
            return c ?
            function(b) {
                "number" === typeof b && (b += k);
                var h = (b.match($) || [f])[0],
                b = b.split(h).join("").match(d) || [],
                c = b.length;
                if (i > c--) for (; ++c < i;) b[c] = e ? b[(c - 1) / 2 >> 0] : p[c];
                return t + b.join(g) + g + h + u
            }: function(b) {
                "number" === typeof b && (b += k);
                var b = b.match(d) || [],
                h = b.length;
                if (i > h--) for (; ++h < i;) b[h] = e ? b[(h - 1) / 2 >> 0] : p[h];
                return t + b.join(g) + u
            }
        },
        y = function(b) {
            b = b.split(",");
            return function(h, d, c, e, f, p, t) {
                d = (d + "").split(" ");
                t = {};
                for (c = 0; 4 > c; c++) t[b[c]] = d[c] = d[c] || d[(c - 1) / 2 >> 0];
                return e.parse(h, t, f, p)
            }
        },
        sa = function(b) {
            this.plugin.setRatio(b);
            for (var b = this.data,
            h = b.proxy,
            d = b.firstMPT,
            c; d;) c = h[d.v],
            d.r ? c = 0 < c ? c + 0.5 >> 0 : c - 0.5 >> 0 : 1E-6 > c && -1E-6 < c && (c = 0),
            d.t[d.p] = c,
            d = d._next;
            b.autoRotate && (b.autoRotate.rotation = h.rotation)
        },
        ha = function(b, h, d, c, e) {
            this.t = b;
            this.p = h;
            this.v = d;
            this.r = e;
            c && (c._prev = this, this._next = c)
        },
        O = function(b, h, d, e, f, p, t, u, i, k, n) {
            this.t = b;
            this.p = h;
            this.s = d;
            this.c = e;
            this.n = t || "css_" + h;
            b instanceof O || c.push(this.n);
            this.r = u;
            this.type = p || 0;
            i && (this.pr = i, g = !0);
            this.b = void 0 === k ? d: k;
            this.e = void 0 === n ? d + e: n;
            f && (this._next = f, f._prev = this)
        },
        fa = x.parseComplex = function(d, c, e, p, t, u, g, i, k, n) {
            var g = new O(d, c, 0, 0, g, n ? 2 : 1, null, !1, i, e, p),
            d = e.split(", ").join(",").split(" "),
            c = (p + "").split(", ").join(",").split(" "),
            e = d.length,
            i = !1 !== G,
            q,
            H,
            s,
            m,
            D;
            e !== c.length && (d = (u || "").split(" "), e = d.length);
            g.plugin = k;
            g.setRatio = n;
            for (u = 0; u < e; u++) if (k = d[u], q = c[u], (n = parseFloat(k)) || 0 === n) g.appendXtra("", n, ma(q, n), q.replace(f, ""), i && -1 !== q.indexOf("px"), !0);
            else if (t && ("#" === k.charAt(0) || 0 === k.indexOf("rgb") || ca[k])) k = ka(k),
            q = ka(q),
            (n = 6 < k.length + q.length) && !h && 0 === q[3] ? (g["xs" + g.l] += g.l ? " transparent": "transparent", g.e = g.e.split(c[u]).join("transparent")) : (g.appendXtra(n ? "rgba(": "rgb(", k[0], q[0] - k[0], ",", !0, !0).appendXtra("", k[1], q[1] - k[1], ",", !0).appendXtra("", k[2], q[2] - k[2], n ? ",": ")", !0), n && (k = 4 > k.length ? 1 : k[3], g.appendXtra("", k, (4 > q.length ? 1 : q[3]) - k, ")", !1)));
            else if (n = k.match(b)) {
                s = q.match(f);
                if (!s || s.length !== n.length) return g;
                for (q = H = 0; q < n.length; q++) D = n[q],
                m = k.indexOf(D, H),
                g.appendXtra(k.substr(H, m - H), Number(D), ma(s[q], D), "", i && "px" === k.substr(m + D.length, 2), 0 === q),
                H = m + D.length;
                g["xs" + g.l] += k.substr(H)
            } else g["xs" + g.l] += g.l ? " " + k: k;
            if ( - 1 !== p.indexOf("=") && g.data) {
                p = g.xs0 + g.data.s;
                for (u = 1; u < g.l; u++) p += g["xs" + u] + g.data["xn" + u];
                g.e = p + g["xs" + u]
            }
            g.l || (g.type = -1, g.xs0 = g.e);
            return g.xfirst || g
        },
        V = 8,
        e = O.prototype;
        for (e.l = e.pr = 0; 0 < --V;) e["xn" + V] = 0,
        e["xs" + V] = "";
        e.xs0 = "";
        e._next = e._prev = e.xfirst = e.data = e.plugin = e.setRatio = e.rxp = null;
        e.appendXtra = function(b, h, d, c, e, f) {
            var p = this.l;
            this["xs" + p] += f && p ? " " + b: b || "";
            if (!d && 0 !== p && !this.plugin) return this["xs" + p] += h + (c || ""),
            this;
            this.l++;
            this.type = this.setRatio ? 2 : 1;
            this["xs" + this.l] = c || "";
            if (0 < p) return this.data["xn" + p] = h + d,
            this.rxp["xn" + p] = e,
            this["xn" + p] = h,
            this.plugin || (this.xfirst = new O(this, "xn" + p, h, d, this.xfirst || this, 0, this.n, e, this.pr), this.xfirst.xs0 = 0),
            this;
            this.data = {
                s: h + d
            };
            this.rxp = {};
            this.s = h;
            this.c = d;
            this.r = e;
            return this
        };
        var oa = function(b, h, d, c, e, p, f) {
            this.p = c ? U(b) || b: b;
            A[b] = A[this.p] = this;
            this.format = p || na(h, e);
            d && (this.parse = d);
            this.clrs = e;
            this.dflt = h;
            this.pr = f || 0
        },
        P = function(b, h, d, c, e, p, f) {
            for (var b = b.split(","), h = h instanceof Array ? h: [h], t = b.length; - 1 < --t;) new oa(b[t], h[t], d, c && 0 === t, e, p, f)
        },
        e = oa.prototype;
        e.parseComplex = function(b, h, d, c, e, p) {
            return fa(b, this.p, h, d, this.clrs, this.dflt, c, this.pr, e, p)
        };
        e.parse = function(b, h, d, c, e, p) {
            return this.parseComplex(b.style, this.format(Q(b, d, n, !1, this.dflt)), this.format(h), e, p)
        };
        x.registerSpecialProp = function(b, h, d) {
            return P(b, null,
            function(b, c, e, p, f, t) {
                e = new O(b, e, 0, 0, f, 2, e, !1, d);
                e.plugin = t;
                e.setRatio = h(b, c, p._tween);
                return e
            },
            !1, !1, null, d)
        };
        var pa = "scaleX scaleY scaleZ x y z skewX rotation rotationX rotationY perspective".split(" "),
        T = U("transform"),
        ta = D + "transform",
        ua = U("transformOrigin"),
        da = null !== U("perspective"),
        ga = function(b, h, d) {
            var c = d ? b._gsTransform || {
                skewY: 0
            }: {
                skewY: 0
            },
            e = 0 > c.scaleX,
            p,
            f;
            T ? p = Q(b, ta, h, !0) : b.currentStyle && (p = (p = b.currentStyle.filter.match(B)) && 4 === p.length ? p[0].substr(4) + "," + Number(p[2].substr(4)) + "," + Number(p[1].substr(4)) + "," + p[3].substr(4) + "," + (c ? c.x: 0) + "," + (c ? c.y: 0) : null);
            p = (p || "").match(/(?:\-|\b)[\d\-\.e]+\b/gi) || [];
            for (f = p.length; - 1 < --f;) p[f] = Number(p[f]);
            if (16 === p.length) {
                if (!d || p[12] !== c.x || p[13] !== c.y || p[14] !== c.z) {
                    var e = p[0],
                    t = p[1],
                    g = p[2],
                    u = p[3],
                    k = p[4],
                    i = p[5],
                    n = p[6],
                    q = p[7],
                    H = p[8],
                    s = p[9],
                    D = p[10],
                    m = p[11],
                    w = c.rotationX = Math.atan2(n, D),
                    y,
                    N,
                    v,
                    K;
                    w && (v = Math.cos( - w), K = Math.sin( - w), w = k * v + H * K, y = i * v + s * K, N = n * v + D * K, H = k * -K + H * v, s = i * -K + s * v, D = n * -K + D * v, m = q * -K + m * v, k = w, i = y, n = N);
                    if (w = c.rotationY = Math.atan2(H, e)) v = Math.cos( - w),
                    K = Math.sin( - w),
                    y = t * v - s * K,
                    N = g * v - D * K,
                    s = t * K + s * v,
                    D = g * K + D * v,
                    m = u * K + m * v,
                    e = e * v - H * K,
                    t = y,
                    g = N;
                    if (w = c.rotation = Math.atan2(t, i)) v = Math.cos( - w),
                    K = Math.sin( - w),
                    e = e * v + k * K,
                    y = t * v + i * K,
                    i = t * -K + i * v,
                    n = g * -K + n * v,
                    t = y;
                    Math.abs(c.rotationY) > Math.PI / 2 && (c.rotationY *= -1, c.rotationX += Math.PI, c.rotation = Math.PI - c.rotation);
                    c.scaleX = Math.sqrt(e * e + t * t);
                    c.scaleY = Math.sqrt(i * i + s * s);
                    c.scaleZ = Math.sqrt(n * n + D * D);
                    c.skewX = 0;
                    c.perspective = m ? 1 / m: 0;
                    c.x = p[12];
                    c.y = p[13];
                    c.z = p[14]
                }
            } else if (!da || 0 === p.length || c.x !== p[4] || c.y !== p[5] || !c.rotationX && !c.rotationY) t = (k = 6 <= p.length) ? p[0] : 1,
            g = p[1] || 0,
            u = p[2] || 0,
            k = k ? p[3] : 1,
            c.x = p[4] || 0,
            c.y = p[5] || 0,
            c.scaleX = Math.sqrt(t * t + g * g),
            c.scaleY = Math.sqrt(k * k + u * u),
            c.rotation = t || g ? Math.atan2(g, t) : c.rotation || 0,
            c.skewX = u || k ? Math.atan2(u, k) + c.rotation: c.skewX || 0,
            Math.abs(c.skewX) > Math.PI / 2 && (e ? (c.scaleX *= -1, c.skewX += 0 >= c.rotation ? Math.PI: -Math.PI, c.rotation += 0 >= c.rotation ? Math.PI: -Math.PI) : (c.scaleY *= -1, c.skewX += 0 >= c.skewX ? Math.PI: -Math.PI)),
            da && (c.rotationX = c.rotationY = c.z = 0, c.perspective = parseFloat(x.defaultTransformPerspective) || 0, c.scaleZ = 1);
            c.zOrigin = da ? parseFloat(Q(b, ua, h, !1, "0 0 0").split(" ")[2]) || c.zOrigin || 0 : 0;
            for (f in c) 1E-6 > c[f] && -1E-6 < c[f] && (c[f] = 0);
            d && (b._gsTransform = c);
            return c
        },
        va = function(b) {
            var h = this.data,
            c = -h.rotation,
            d = c + h.skewX,
            e = Math.cos(c) * h.scaleX,
            c = Math.sin(c) * h.scaleX,
            p = Math.sin(d) * -h.scaleY,
            d = Math.cos(d) * h.scaleY,
            f = 1E-6,
            t = this.t.style,
            g = this.t.currentStyle,
            u;
            if (g) {
                e < f && e > -f && (e = 0);
                c < f && c > -f && (c = 0);
                p < f && p > -f && (p = 0);
                d < f && d > -f && (d = 0);
                f = c;
                c = -p;
                p = -f;
                f = g.filter;
                t.filter = "";
                var i = this.t.offsetWidth;
                u = this.t.offsetHeight;
                var n = "absolute" !== g.position,
                q = "progid:DXImageTransform.Microsoft.Matrix(M11=" + e + ", M12=" + c + ", M21=" + p + ", M22=" + d,
                H = h.x,
                s = h.y,
                D, m;
                null != h.ox && (D = (h.oxp ? 0.01 * i * h.ox: h.ox) - i / 2, m = (h.oyp ? 0.01 * u * h.oy: h.oy) - u / 2, H += D - (D * e + m * c), s += m - (D * p + m * d));
                if (n) D = i / 2,
                m = u / 2,
                q += ", Dx=" + (D - (D * e + m * c) + H) + ", Dy=" + (m - (D * p + m * d) + s) + ")";
                else {
                    var v = 8 > J ? 1 : -1;
                    D = h.ieOffsetX || 0;
                    m = h.ieOffsetY || 0;
                    h.ieOffsetX = Math.round((i - ((0 > e ? -e: e) * i + (0 > c ? -c: c) * u)) / 2 + H);
                    h.ieOffsetY = Math.round((u - ((0 > d ? -d: d) * u + (0 > p ? -p: p) * i)) / 2 + s);
                    for (V = 0; 4 > V; V++) i = ra[V],
                    u = g[i],
                    u = -1 !== u.indexOf("px") ? parseFloat(u) : Y(this.t, i, parseFloat(u), u.replace(k, "")) || 0,
                    H = u !== h[i] ? 2 > V ? -h.ieOffsetX: -h.ieOffsetY: 2 > V ? D - h.ieOffsetX: m - h.ieOffsetY,
                    t[i] = (h[i] = Math.round(u - H * (0 === V || 2 === V ? 1 : v))) + "px";
                    q += ", sizingMethod='auto expand')"
                }
                t.filter = -1 !== f.indexOf("DXImageTransform.Microsoft.Matrix(") ? f.replace(w, q) : q + " " + f;
                if (0 === b || 1 === b) if (1 === e && 0 === c && 0 === p && 1 === d && (!n || -1 !== q.indexOf("Dx=0, Dy=0")))(!M.test(f) || 100 === parseFloat(RegExp.$1)) && t.removeAttribute("filter")
            }
        },
        wa = function() {
            var b = this.data,
            h = b.perspective,
            c = b.scaleX,
            d = 0,
            e = 0,
            p = 0,
            f = 0,
            t = b.scaleY,
            u = 0,
            g = 0,
            i = 0,
            k = 0,
            n = b.scaleZ,
            q = 0,
            H = 0,
            s = 0,
            D = h ? -1 / h: 0,
            m = b.rotation,
            w = b.zOrigin,
            v,
            K,
            x,
            y,
            N;
            m && (v = Math.cos(m), m = Math.sin(m), x = t * m, d = c * -m, t *= v, c *= v, f = x);
            if (m = b.rotationY) v = Math.cos(m),
            m = Math.sin(m),
            y = n * -m,
            N = D * -m,
            e = c * m,
            u = f * m,
            n *= v,
            D *= v,
            c *= v,
            f *= v,
            i = y,
            H = N;
            if (m = b.rotationX) v = Math.cos(m),
            m = Math.sin(m),
            K = d * v + e * m,
            x = t * v + u * m,
            y = k * v + n * m,
            N = s * v + D * m,
            e = d * -m + e * v,
            u = t * -m + u * v,
            n = k * -m + n * v,
            D = s * -m + D * v,
            d = K,
            t = x,
            k = y,
            s = N;
            w && (q -= w, K = e * q, x = u * q, y = n * q + w, p = 1E-6 > K && -1E-6 < K ? 0 : K, g = 1E-6 > x && -1E-6 < x ? 0 : x, q = 1E-6 > y && -1E-6 < y ? 0 : y);
            p += b.x;
            g += b.y;
            q += b.z;
            this.t.style[T] = "matrix3d(" + (1E-6 > c && -1E-6 < c ? 0 : c) + "," + (1E-6 > f && -1E-6 < f ? 0 : f) + "," + (1E-6 > i && -1E-6 < i ? 0 : i) + "," + (1E-6 > H && -1E-6 < H ? 0 : H) + "," + (1E-6 > d && -1E-6 < d ? 0 : d) + "," + (1E-6 > t && -1E-6 < t ? 0 : t) + "," + (1E-6 > k && -1E-6 < k ? 0 : k) + "," + (1E-6 > s && -1E-6 < s ? 0 : s) + "," + (1E-6 > e && -1E-6 < e ? 0 : e) + "," + (1E-6 > u && -1E-6 < u ? 0 : u) + "," + (1E-6 > n && -1E-6 < n ? 0 : n) + "," + (1E-6 > D && -1E-6 < D ? 0 : D) + "," + p + "," + g + "," + q + "," + (h ? 1 + -q / h: 1) + ")"
        },
        xa = function() {
            var b = this.data;
            if (!b.rotation && !b.skewX) this.t.style[T] = "matrix(" + b.scaleX + ",0,0," + b.scaleY + "," + b.x + "," + b.y + ")";
            else {
                var h = b.rotation,
                c = h - b.skewX,
                d = Math.cos(h) * b.scaleX,
                h = Math.sin(h) * b.scaleX,
                e = Math.sin(c) * -b.scaleY,
                c = Math.cos(c) * b.scaleY;
                this.t.style[T] = "matrix(" + (1E-6 > d && -1E-6 < d ? 0 : d) + "," + (1E-6 > h && -1E-6 < h ? 0 : h) + "," + (1E-6 > e && -1E-6 < e ? 0 : e) + "," + (1E-6 > c && -1E-6 < c ? 0 : c) + "," + b.x + "," + b.y + ")"
            }
        };
        P("transform,scale,scaleX,scaleY,scaleZ,x,y,z,rotation,rotationX,rotationY,rotationZ,skewX,skewY,shortRotation,shortRotationX,shortRotationY,shortRotationZ,transformOrigin,transformPerspective", null,
        function(b, h, c, d, e, p, f) {
            if (d._transform) return e;
            var h = d._transform = ga(b, n, !0),
            t = b.style,
            u = pa.length,
            g,
            i;
            if ("string" === typeof f.transform && T) c = t[T],
            t[T] = f.transform,
            g = ga(b, null, !1),
            t[T] = c;
            else if ("object" === typeof f) {
                c = null != f.rotation ? f.rotation: null != f.rotationZ ? f.rotationZ: h.rotation * L;
                g = {
                    scaleX: Z(null != f.scaleX ? f.scaleX: f.scale, h.scaleX),
                    scaleY: Z(null != f.scaleY ? f.scaleY: f.scale, h.scaleY),
                    scaleZ: Z(null != f.scaleZ ? f.scaleZ: f.scale, h.scaleZ),
                    x: Z(f.x, h.x),
                    y: Z(f.y, h.y),
                    z: Z(f.z, h.z),
                    perspective: Z(f.transformPerspective, h.perspective)
                };
                g.rotation = null != f.shortRotation || null != f.shortRotationZ ? ja(f.shortRotation || f.shortRotationZ || 0, h.rotation) : "number" === typeof c ? c * S: ba(c, h.rotation);
                da && (g.rotationX = null != f.shortRotationX ? ja(f.shortRotationX, h.rotationX) : "number" === typeof f.rotationX ? f.rotationX * S: ba(f.rotationX, h.rotationX), g.rotationY = null != f.shortRotationY ? ja(f.shortRotationY, h.rotationY) : "number" === typeof f.rotationY ? f.rotationY * S: ba(f.rotationY, h.rotationY), 1E-6 > g.rotationX && -1E-6 < g.rotationX && (g.rotationX = 0), 1E-6 > g.rotationY && -1E-6 < g.rotationY && (g.rotationY = 0));
                g.skewX = null == f.skewX ? h.skewX: "number" === typeof f.skewX ? f.skewX * S: ba(f.skewX, h.skewX);
                g.skewY = null == f.skewY ? h.skewY: "number" === typeof f.skewY ? f.skewY * S: ba(f.skewY, h.skewY);
                if (c = g.skewY - h.skewY) g.skewX += c,
                g.rotation += c;
                1E-6 > g.skewY && -1E-6 < g.skewY && (g.skewY = 0);
                1E-6 > g.skewX && -1E-6 < g.skewX && (g.skewX = 0);
                1E-6 > g.rotation && -1E-6 < g.rotation && (g.rotation = 0)
            }
            i = h.z || h.rotationX || h.rotationY || g.z || g.rotationX || g.rotationY;
            if (T) {
                if (z) {
                    F = !0;
                    if ("" === t.zIndex && (c = Q(b, "zIndex", n), "auto" === c || "" === c)) t.zIndex = 0;
                    R && (t.WebkitBackfaceVisibility = f.WebkitBackfaceVisibility || (i ? "visible": "hidden"))
                }
            } else t.zoom = 1;
            e = new O(b, "transform", 0, 0, e, 2);
            e.setRatio = i && da ? wa: T ? xa: va;
            e.plugin = p;
            for (e.data = h; - 1 < --u;) if (c = pa[u], i = g[c] - h[c], 1E-6 < i || -1E-6 > i || null != E[c]) e = new O(h, c, h[c], i, e),
            e.xs0 = 0,
            e.plugin = p,
            d._overwriteProps.push(e.n);
            if (null != (i = f.transformOrigin)) i += "",
            T ? (c = T + "Origin", e = new O(t, c, 0, 0, e, -1, "css_transformOrigin"), e.b = t[c], e.xs0 = e.e = t[c] = i, e.plugin = p, da && (c = h.zOrigin, i = i.split(" "), h.zOrigin = parseFloat(i[2]) || 0, e.xs0 = e.e = i[0] + (i[1] || ""), e = new O(h, "zOrigin", 0, 0, e, -1, e.n), e.b = c, e.xs0 = e.e = h.zOrigin)) : ia(i, h);
            return e.t === b ? (e._next && (e._next._prev = null), e._next) : e
        },
        !0);
        P("boxShadow", "0px 0px 0px 0px #999", null, !0, !0);
        P("borderRadius", "0px",
        function(b, h, c, d, e) {
            var h = this.format(h),
            d = ["borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"],
            f = b.style,
            p,
            t,
            g,
            u,
            i,
            k,
            m,
            H,
            s,
            D,
            v,
            w;
            H = parseFloat(b.offsetWidth);
            s = parseFloat(b.offsetHeight);
            h = h.split(" ");
            for (p = 0; p < d.length; p++) this.p.indexOf("border") && (d[p] = U(d[p])),
            u = g = Q(b, d[p], n, !1, "0px"),
            i = t = h[p],
            k = parseFloat(u),
            v = u.substr((k + "").length),
            (w = "=" === i.charAt(1)) ? (m = parseInt(i.charAt(0) + "1"), i = i.substr(2), m *= parseFloat(i), D = i.substr((m + "").length - (0 > m ? 1 : 0)) || "") : (m = parseFloat(i), D = i.substr((m + "").length)),
            "" === D && (D = q[c] || v),
            D !== v && (u = Y(b, "borderLeft", k, v), k = Y(b, "borderTop", k, v), "%" === D ? (u = 100 * (u / H) + "%", g = 100 * (k / s) + "%") : "em" === D ? (v = Y(b, "borderLeft", 1, "em"), u = u / v + "em", g = k / v + "em") : (u += "px", g = k + "px"), w && (i = parseFloat(u) + m + D, t = parseFloat(g) + m + D)),
            e = fa(f, d[p], u + " " + g, i + " " + t, !1, "0px", e);
            return e
        },
        !0, !1, na("0px 0px 0px 0px", !1, !0));
        P("backgroundPosition", "0 0", null, !1, !1, ia);
        P("backgroundSize", "0 0", null, !1, !1, ia);
        P("perspective", "0px", null, !0);
        P("margin", null, y("marginTop,marginRight,marginBottom,marginLeft"));
        P("padding", null, y("paddingTop,paddingRight,paddingBottom,paddingLeft"));
        P("clip", "rect(0px,0px,0px,0px)");
        P("textShadow", "0px 0px 0px #999", null, !1, !0);
        P("autoRound", null,
        function(b, h, c, d, e) {
            return e
        });
        P("border", "0px solid #000",
        function(b, h, c, d, e, p) {
            return this.parseComplex(b.style, this.format(Q(b, "borderTopWidth", n, !1, "0px") + " " + Q(b, "borderTopStyle", n, !1, "solid") + " " + Q(b, "borderTopColor", n, !1, "#000")), this.format(h), e, p)
        },
        !1, !0,
        function(b) {
            var h = b.split(" ");
            return h[0] + " " + (h[1] || "solid") + " " + (b.match($) || ["#000"])[0]
        });
        var ya = function(b) {
            var h = this.t,
            b = this.s + this.c * b,
            c;
            100 === b && (h.removeAttribute("filter"), c = !Q(this.data, "filter"));
            c || (this.xn1 && (h.filter = h.filter || "alpha(opacity=100)"), h.filter = -1 === h.filter.indexOf("opacity") ? h.filter + (" alpha(opacity=" + (b >> 0) + ")") : h.filter.replace(M, "opacity=" + (b >> 0)))
        };
        P("opacity,alpha,autoAlpha", "1",
        function(b, c, d, e, p, f) {
            var t = parseFloat(Q(b, "opacity", n, !1, "1")),
            c = parseFloat(c),
            g = b.style,
            u;
            "autoAlpha" === d && (u = Q(b, "visibility", n), 1 === t && "hidden" === u && (t = 0), p = new O(g, "visibility", 0, 0, p, -1, null, !1, 0, 0 !== t ? "visible": "hidden", 0 === c ? "hidden": "visible"), p.xs0 = "visible", e._overwriteProps.push(p.n));
            h ? p = new O(g, "opacity", t, c - t, p) : (p = new O(g, "opacity", 100 * t, 100 * (c - t), p), p.xn1 = "autoAlpha" === d ? 1 : 0, g.zoom = 1, p.type = 2, p.b = "alpha(opacity=" + p.s + ")", p.e = "alpha(opacity=" + (p.s + p.c) + ")", p.data = b, p.plugin = f, p.setRatio = ya);
            return p
        });
        P("bezier", null,
        function(b, h, c, d, e, p) {
            p = window.com.greensock.plugins.BezierPlugin;
            if (!p) return window.console && console.log("ERROR: BezierPlugin not loaded."),
            e;
            h instanceof Array && (h = {
                values: h
            });
            e = new O(b, "bezier", 0, 0, e, 2);
            e.plugin = p = new p;
            e.setRatio = sa;
            var f = h.values,
            t = f.length - 1,
            g = [],
            u = {},
            i,
            k;
            for (i = 0; i <= t; i++) {
                k = b;
                var n = f[i],
                q = d,
                m = e,
                D = p,
                H = t !== i,
                s = m,
                v = {},
                w = {},
                K = q._transform,
                x = E,
                y = void 0,
                N = void 0,
                z = void 0,
                U = void 0,
                B = void 0;
                q._transform = null;
                E = n;
                m = B = q.parse(k, n, m, D);
                E = x;
                H && (q._transform = K, s && (s._prev = null, s._prev && (s._prev._next = null)));
                for (; m && m !== s;) {
                    if (0 === m.type || 1 === m.type) if (N = m.p, w[N] = m.s + m.c, v[N] = m.s, H || (U = new ha(m, "s", N, U, m.r), m.c = 0), 1 === m.type) for (y = m.l; 0 < --y;) z = "xn" + y,
                    N = m.p + "_" + z,
                    w[N] = m.data[z],
                    v[N] = m[z],
                    H || (U = new ha(m, z, N, U, m.rxp[z]));
                    m = m._next
                }
                k = {
                    proxy: v,
                    end: w,
                    firstMPT: U,
                    pt: B
                };
                g[i] = k.end
            }
            for (c in h) u[c] = h[c];
            u.values = g;
            e.data = k;
            e = k.pt;
            0 === u.autoRotate && (u.autoRotate = !0);
            u.autoRotate && !(u.autoRotate instanceof Array) && (i = !0 == u.autoRotate ? 0 : Number(u.autoRotate) * S, u.autoRotate = null != k.end.left ? [["left", "top", "rotation", i, !0]] : null != k.end.x ? [["x", "y", "rotation", i, !0]] : !1);
            u.autoRotate && (d._transform || (e = A.rotation.parse(b, 0, c, d, e, p, {})), k.autoRotate = d._transform);
            p._onInitTween(k.proxy, u, d._tween);
            return e
        });
        var za = function(b) {
            if (1 === b || 0 === b) {
                this.t.className = 1 === b ? this.e: this.b;
                for (var b = this.data,
                h = this.t.style,
                c = h.removeProperty ? "removeProperty": "removeAttribute"; b;) {
                    if (b.v) h[b.p] = b.v;
                    else h[c](b.p);
                    b = b._next
                }
            } else this.t.className !== this.b && (this.t.className = this.b)
        };
        P("className", null,
        function(b, h, c, d, e, p, f) {
            var t = b.className,
            e = new O(b, c, 0, 0, e, 2);
            e.setRatio = za;
            e.b = t;
            e.e = "=" !== h.charAt(1) ? h: "+" === h.charAt(0) ? t + " " + h.substr(2) : t.split(h.substr(2)).join("");
            d._tween._duration && (h = ea(b, n), b.className = e.e, f = la(b, h, ea(b), f), b.className = t, e.data = f.firstMPT, e = d.parse(b, f.difs, e, p));
            return e
        });
        e = x.prototype;
        e._firstPT = null;
        e._onInitTween = function(b, d, e) {
            if (!b.nodeType) return ! 1;
            this._target = b;
            this._tween = e;
            G = d.autoRound;
            g = !1;
            q = d.suffixMap || x.suffixMap;
            n = K(b, "");
            c = this._overwriteProps;
            var e = b.style,
            p, f, t;
            if (F && "" === e.zIndex && (p = Q(b, "zIndex", n), "auto" === p || "" === p)) e.zIndex = 0;
            "string" === typeof d && (f = e.cssText, p = ea(b, n), e.cssText = f + ";" + d, p = la(b, p, ea(b)).difs, !h && aa.test(d) && (p.opacity = parseFloat(RegExp.$1)), d = p, e.cssText = f);
            this._firstPT = b = this.parse(b, d, null);
            if (g) {
                for (; b;) {
                    e = b._next;
                    for (d = f; d && d.pr > b.pr;) d = d._next; (b._prev = d ? d._prev: t) ? b._prev._next = b: f = b; (b._next = d) ? d._prev = b: t = b;
                    b = e
                }
                this._firstPT = f
            }
            return ! 0
        };
        e.parse = function(b, h, c, d) {
            var e = b.style,
            p, f, t, g, u, i, k, m;
            for (p in h) {
                u = h[p];
                if (f = A[p]) c = f.parse(b, u, p, this, c, d, h);
                else if (f = Q(b, p, n) + "", k = "string" === typeof u, "color" === p || "fill" === p || "stroke" === p || -1 !== p.indexOf("Color") || k && !u.indexOf("rgb")) k || (u = ka(u), u = (3 < u.length ? "rgba(": "rgb(") + u.join(",") + ")"),
                c = fa(e, p, f, u, !0, "transparent", c, 0, d);
                else if (k && ( - 1 !== u.indexOf(" ") || -1 !== u.indexOf(","))) c = fa(e, p, f, u, !0, null, c, 0, d);
                else {
                    t = parseFloat(f);
                    i = f.substr((t + "").length);
                    if ("" === f || "auto" === f) if ("width" === p || "height" === p) {
                        t = b;
                        m = p;
                        g = n;
                        i = parseFloat("width" === m ? t.offsetWidth: t.offsetHeight);
                        m = qa[m];
                        var H = m.length;
                        for (g = g || K(t, null); - 1 < --H;) i -= parseFloat(Q(t, "padding" + m[H], g, !0)) || 0,
                        i -= parseFloat(Q(t, "border" + m[H] + "Width", g, !0)) || 0;
                        t = i;
                        i = "px"
                    } else t = "opacity" !== p ? 0 : 1,
                    i = ""; (m = k && "=" === u.charAt(1)) ? (g = parseInt(u.charAt(0) + "1"), u = u.substr(2), g *= parseFloat(u), k = u.substr((g + "").length - (0 > g ? 1 : 0)) || "") : (g = parseFloat(u), k = k ? u.substr((g + "").length) || "": "");
                    "" === k && (k = q[p] || i);
                    u = g || 0 === g ? (m ? g + t: g) + k: h[p];
                    if (i !== k && "" !== k && (g || 0 === g)) if (t || 0 === t) if (t = Y(b, p, t, i), "%" === k ? (t /= Y(b, p, 100, "%") / 100, 100 < t && (t = 100)) : "em" === k ? t /= Y(b, p, 1, "em") : (g = Y(b, p, g, k), k = "px"), m && (g || 0 === g)) u = g + t + k;
                    m && (g += t); (t || 0 === t) && (g || 0 === g) && t !== g ? (c = new O(e, p, t, g - t, c, 0, "css_" + p, !1 !== G && ("px" === k || "zIndex" === p), 0, f, u), c.xs0 = k) : (c = new O(e, p, 0, 0, c, -1, "css_" + p, !1, 0, f, u), c.xs0 = "display" === p && "none" === u ? f: u)
                }
                d && (c && !c.plugin) && (c.plugin = d)
            }
            return c
        };
        e.setRatio = function(b) {
            var h = this._firstPT,
            c, d;
            if (1 === b && (this._tween._time === this._tween._duration || 0 === this._tween._time)) for (; h;) 2 !== h.type ? h.t[h.p] = h.e: h.setRatio(b),
            h = h._next;
            else if (b || !(this._tween._time === this._tween._duration || 0 === this._tween._time)) for (; h;) {
                c = h.c * b + h.s;
                h.r ? c = 0 < c ? c + 0.5 >> 0 : c - 0.5 >> 0 : 1E-6 > c && -1E-6 < c && (c = 0);
                if (h.type) if (1 === h.type) if (d = h.l, 2 === d) h.t[h.p] = h.xs0 + c + h.xs1 + h.xn1 + h.xs2;
                else if (3 === d) h.t[h.p] = h.xs0 + c + h.xs1 + h.xn1 + h.xs2 + h.xn2 + h.xs3;
                else if (4 === d) h.t[h.p] = h.xs0 + c + h.xs1 + h.xn1 + h.xs2 + h.xn2 + h.xs3 + h.xn3 + h.xs4;
                else if (5 === d) h.t[h.p] = h.xs0 + c + h.xs1 + h.xn1 + h.xs2 + h.xn2 + h.xs3 + h.xn3 + h.xs4 + h.xn4 + h.xs5;
                else {
                    c = h.xs0 + c + h.xs1;
                    for (d = 1; d < h.l; d++) c += h["xn" + d] + h["xs" + (d + 1)];
                    h.t[h.p] = c
                } else - 1 === h.type ? h.t[h.p] = h.xs0: h.setRatio && h.setRatio(b);
                else h.t[h.p] = c + h.xs0;
                h = h._next
            } else for (; h;) 2 !== h.type ? h.t[h.p] = h.b: h.setRatio(b),
            h = h._next
        };
        e._kill = function(h) {
            var b = h,
            c;
            if (h.autoAlpha || h.alpha) {
                b = {};
                for (c in h) b[c] = h[c];
                b.opacity = 1;
                b.autoAlpha && (b.visibility = 1)
            }
            return s.prototype._kill.call(this, b)
        };
        s.activate([x]);
        return x
    },
    !0);
    _gsDefine("plugins.RoundPropsPlugin", ["plugins.TweenPlugin"],
    function(s) {
        var x = function() {
            s.call(this, "roundProps", -1);
            this._overwriteProps.length = 0
        },
        g = x.prototype = new s("roundProps", -1);
        g.constructor = x;
        x.API = 2;
        g._onInitTween = function(g, n, c) {
            this._tween = c;
            return ! 0
        };
        g._onInitAllProps = function() {
            for (var g = this._tween,
            n = g.vars.roundProps instanceof Array ? g.vars.roundProps: g.vars.roundProps.split(","), c = n.length, s = {},
            e = g._propLookup.roundProps, b, f, d; - 1 < --c;) s[n[c]] = 1;
            for (c = n.length; - 1 < --c;) {
                b = n[c];
                for (f = g._firstPT; f;) d = f._next,
                f.pg ? f.t._roundProps(s, !0) : f.n === b && (this._add(f.t, b, f.s, f.c), d && (d._prev = f._prev), f._prev ? f._prev._next = d: _tween._firstPT === f && (g._firstPT = d), f._next = f._prev = null, g._propLookup[b] = e),
                f = d
            }
            return ! 1
        };
        g._add = function(g, n, c, s) {
            this._addTween(g, n, c, c + s, n, !0);
            this._overwriteProps.push(n)
        };
        s.activate([x]);
        return x
    },
    !0);
    _gsDefine("easing.Back", ["easing.Ease"],
    function(s) {
        var x = window.com.greensock._class,
        g = function(b, c) {
            var d = x("easing." + b,
            function() {},
            !0),
            e = d.prototype = new s;
            e.constructor = d;
            e.getRatio = c;
            return d
        },
        q = function(b, c) {
            var d = x("easing." + b,
            function(b) {
                this._p1 = b || 0 === b ? b: 1.70158;
                this._p2 = 1.525 * this._p1
            },
            !0),
            e = d.prototype = new s;
            e.constructor = d;
            e.getRatio = c;
            e.config = function(b) {
                return new d(b)
            };
            return d
        },
        n = q("BackOut",
        function(b) {
            return (b -= 1) * b * ((this._p1 + 1) * b + this._p1) + 1
        }),
        c = q("BackIn",
        function(b) {
            return b * b * ((this._p1 + 1) * b - this._p1)
        }),
        q = q("BackInOut",
        function(b) {
            return 1 > (b *= 2) ? 0.5 * b * b * ((this._p2 + 1) * b - this._p2) : 0.5 * ((b -= 2) * b * ((this._p2 + 1) * b + this._p2) + 2)
        }),
        A = g("BounceOut",
        function(b) {
            return b < 1 / 2.75 ? 7.5625 * b * b: b < 2 / 2.75 ? 7.5625 * (b -= 1.5 / 2.75) * b + 0.75 : b < 2.5 / 2.75 ? 7.5625 * (b -= 2.25 / 2.75) * b + 0.9375 : 7.5625 * (b -= 2.625 / 2.75) * b + 0.984375
        }),
        e = g("BounceIn",
        function(b) {
            return (b = 1 - b) < 1 / 2.75 ? 1 - 7.5625 * b * b: b < 2 / 2.75 ? 1 - (7.5625 * (b -= 1.5 / 2.75) * b + 0.75) : b < 2.5 / 2.75 ? 1 - (7.5625 * (b -= 2.25 / 2.75) * b + 0.9375) : 1 - (7.5625 * (b -= 2.625 / 2.75) * b + 0.984375)
        }),
        b = g("BounceInOut",
        function(b) {
            var c = 0.5 > b,
            b = c ? 1 - 2 * b: 2 * b - 1,
            b = b < 1 / 2.75 ? 7.5625 * b * b: b < 2 / 2.75 ? 7.5625 * (b -= 1.5 / 2.75) * b + 0.75 : b < 2.5 / 2.75 ? 7.5625 * (b -= 2.25 / 2.75) * b + 0.9375 : 7.5625 * (b -= 2.625 / 2.75) * b + 0.984375;
            return c ? 0.5 * (1 - b) : 0.5 * b + 0.5
        }),
        f = g("CircOut",
        function(b) {
            return Math.sqrt(1 - (b -= 1) * b)
        }),
        d = g("CircIn",
        function(b) {
            return - (Math.sqrt(1 - b * b) - 1)
        }),
        i = g("CircInOut",
        function(b) {
            return 1 > (b *= 2) ? -0.5 * (Math.sqrt(1 - b * b) - 1) : 0.5 * (Math.sqrt(1 - (b -= 2) * b) + 1)
        }),
        k = 2 * Math.PI,
        M = function(b, c, d) {
            var e = x("easing." + b,
            function(b, c) {
                this._p1 = b || 1;
                this._p2 = c || d;
                this._p3 = this._p2 / k * (Math.asin(1 / this._p1) || 0)
            },
            !0),
            b = e.prototype = new s;
            b.constructor = e;
            b.getRatio = c;
            b.config = function(b, c) {
                return new e(b, c)
            };
            return e
        },
        aa = M("ElasticOut",
        function(b) {
            return this._p1 * Math.pow(2, -10 * b) * Math.sin((b - this._p3) * k / this._p2) + 1
        },
        0.3),
        W = M("ElasticIn",
        function(b) {
            return - (this._p1 * Math.pow(2, 10 * (b -= 1)) * Math.sin((b - this._p3) * k / this._p2))
        },
        0.3),
        M = M("ElasticInOut",
        function(b) {
            return 1 > (b *= 2) ? -0.5 * this._p1 * Math.pow(2, 10 * (b -= 1)) * Math.sin((b - this._p3) * k / this._p2) : 0.5 * this._p1 * Math.pow(2, -10 * (b -= 1)) * Math.sin((b - this._p3) * k / this._p2) + 1
        },
        0.45),
        v = g("ExpoOut",
        function(b) {
            return 1 - Math.pow(2, -10 * b)
        }),
        I = g("ExpoIn",
        function(b) {
            return Math.pow(2, 10 * (b - 1)) - 0.001
        }),
        m = g("ExpoInOut",
        function(b) {
            return 1 > (b *= 2) ? 0.5 * Math.pow(2, 10 * (b - 1)) : 0.5 * (2 - Math.pow(2, -10 * (b - 1)))
        }),
        B = Math.PI / 2,
        w = g("SineOut",
        function(b) {
            return Math.sin(b * B)
        }),
        S = g("SineIn",
        function(b) {
            return - Math.cos(b * B) + 1
        }),
        g = g("SineInOut",
        function(b) {
            return - 0.5 * (Math.cos(Math.PI * b) - 1)
        }),
        L = x("easing.SlowMo",
        function(b, c, d) {
            null == b ? b = 0.7 : 1 < b && (b = 1);
            this._p = 1 != b ? c || 0 === c ? c: 0.7 : 0;
            this._p1 = (1 - b) / 2;
            this._p2 = b;
            this._p3 = this._p1 + this._p2;
            this._calcEnd = !0 === d
        },
        !0),
        E = L.prototype = new s;
        E.constructor = L;
        E.getRatio = function(b) {
            var c = b + (0.5 - b) * this._p;
            return b < this._p1 ? this._calcEnd ? 1 - (b = 1 - b / this._p1) * b: c - (b = 1 - b / this._p1) * b * b * b * c: b > this._p3 ? this._calcEnd ? 1 - (b = (b - this._p3) / this._p1) * b: c + (b - c) * (b = (b - this._p3) / this._p1) * b * b * b: this._calcEnd ? 1 : c
        };
        L.ease = new L(0.7, 0.7);
        E.config = L.config = function(b, c, d) {
            return new L(b, c, d)
        };
        var C = x("easing.SteppedEase",
        function(b) {
            b = b || 1;
            this._p1 = 1 / b;
            this._p2 = b + 1
        },
        !0),
        E = C.prototype = new s;
        E.constructor = C;
        E.getRatio = function(b) {
            0 > b ? b = 0 : 1 <= b && (b = 0.999999999);
            return (this._p2 * b >> 0) * this._p1
        };
        E.config = C.config = function(b) {
            return new C(b)
        };
        x("easing.Bounce", {
            easeOut: new A,
            easeIn: new e,
            easeInOut: new b
        },
        !0);
        x("easing.Circ", {
            easeOut: new f,
            easeIn: new d,
            easeInOut: new i
        },
        !0);
        x("easing.Elastic", {
            easeOut: new aa,
            easeIn: new W,
            easeInOut: new M
        },
        !0);
        x("easing.Expo", {
            easeOut: new v,
            easeIn: new I,
            easeInOut: new m
        },
        !0);
        x("easing.Sine", {
            easeOut: new w,
            easeIn: new S,
            easeInOut: new g
        },
        !0);
        return {
            easeOut: new n,
            easeIn: new c,
            easeInOut: new q
        }
    },
    !0)
}); (function(s) {
    var x = function(b) {
        var b = b.split("."),
        c = s,
        d;
        for (d = 0; d < b.length; d++) c[b[d]] = c = c[b[d]] || {};
        return c
    },
    g = x("com.greensock"),
    q,
    n,
    c,
    A,
    e,
    b = {},
    f = function(h, c, d, e) {
        this.sc = b[h] ? b[h].sc: [];
        b[h] = this;
        this.gsClass = null;
        this.def = d;
        var g = c || [],
        i = [];
        this.check = function(c) {
            for (var t = g.length,
            k = 0,
            m; - 1 < --t;)(m = b[g[t]] || new f(g[t])).gsClass ? i[t] = m.gsClass: (k++, c && m.sc.push(this));
            if (0 === k && d) {
                var c = ("com.greensock." + h).split("."),
                t = c.pop(),
                n = x(c.join("."))[t] = this.gsClass = d.apply(d, i);
                e && ((s.GreenSockGlobals || s)[t] = n, "function" === typeof define && define.amd ? define((s.GreenSockAMDPath ? s.GreenSockAMDPath + "/": "") + h.split(".").join("/"), [],
                function() {
                    return n
                }) : "undefined" !== typeof module && module.exports && (module.exports = n));
                for (t = 0; t < this.sc.length; t++) this.sc[t].check(!1)
            }
        };
        this.check(!0)
    },
    d = g._class = function(b, c, d) {
        c = c ||
        function() {};
        new f(b, [],
        function() {
            return c
        },
        d);
        return c
    };
    s._gsDefine = function(b, c, d, e) {
        return new f(b, c, d, e)
    };
    var i = [0, 0, 1, 1],
    k = [],
    M = d("easing.Ease",
    function(b, c, d, e) {
        this._func = b;
        this._type = d || 0;
        this._power = e || 0;
        this._params = c ? i.concat(c) : i
    },
    !0);
    c = M.prototype;
    c._calcEnd = !1;
    c.getRatio = function(b) {
        if (this._func) return this._params[0] = b,
        this._func.apply(null, this._params);
        var c = this._type,
        d = this._power,
        e = 1 === c ? 1 - b: 2 === c ? b: 0.5 > b ? 2 * b: 2 * (1 - b);
        1 === d ? e *= e: 2 === d ? e *= e * e: 3 === d ? e *= e * e * e: 4 === d && (e *= e * e * e * e);
        return 1 === c ? 1 - e: 2 === c ? e: 0.5 > b ? e / 2 : 1 - e / 2
    };
    q = ["Linear", "Quad", "Cubic", "Quart", "Quint"];
    for (n = q.length; - 1 < --n;) c = d("easing." + q[n], null, !0),
    A = d("easing.Power" + n, null, !0),
    c.easeOut = A.easeOut = new M(null, null, 1, n),
    c.easeIn = A.easeIn = new M(null, null, 2, n),
    c.easeInOut = A.easeInOut = new M(null, null, 3, n);
    d("easing.Strong", g.easing.Power4, !0);
    g.easing.Linear.easeNone = g.easing.Linear.easeIn;
    var aa = d("events.EventDispatcher",
    function(b) {
        this._listeners = {};
        this._eventTarget = b || this
    });
    c = aa.prototype;
    c.addEventListener = function(b, c, d, e, f) {
        var f = f || 0,
        g = this._listeners[b],
        i = 0,
        k;
        null == g && (this._listeners[b] = g = []);
        for (k = g.length; - 1 < --k;) b = g[k],
        b.c === c ? g.splice(k, 1) : 0 === i && b.pr < f && (i = k + 1);
        g.splice(i, 0, {
            c: c,
            s: d,
            up: e,
            pr: f
        })
    };
    c.removeEventListener = function(b, c) {
        var d = this._listeners[b],
        e;
        if (d) for (e = d.length; - 1 < --e;) if (d[e].c === c) {
            d.splice(e, 1);
            break
        }
    };
    c.dispatchEvent = function(b) {
        var c = this._listeners[b];
        if (c) for (var d = c.length,
        e = this._eventTarget,
        f; - 1 < --d;) f = c[d],
        f.up ? f.c.call(f.s || e, {
            type: b,
            target: e
        }) : f.c.call(f.s || e)
    };
    var W = s.requestAnimationFrame,
    v = s.cancelAnimationFrame,
    I = Date.now ||
    function() {
        return (new Date).getTime()
    };
    q = ["ms", "moz", "webkit", "o"];
    for (n = q.length; - 1 < --n && !W;) W = s[q[n] + "RequestAnimationFrame"],
    v = s[q[n] + "CancelAnimationFrame"] || s[q[n] + "CancelRequestAnimationFrame"];
    d("Ticker",
    function(b, c) {
        var d = this,
        e = I(),
        f = !1 !== c && W,
        g,
        i,
        k,
        m,
        n,
        q = function() {
            null != k && (!f || !v ? s.clearTimeout(k) : v(k), k = null)
        },
        u = function(b) {
            d.time = (I() - e) / 1E3;
            if (!g || d.time >= n || b) d.frame++,
            n = d.time > n ? d.time + m - (d.time - n) : d.time + m - 0.001,
            n < d.time + 0.001 && (n = d.time + 0.001),
            d.dispatchEvent("tick"); ! 0 !== b && (k = i(u))
        };
        aa.call(d);
        this.time = this.frame = 0;
        this.tick = function() {
            u(!0)
        };
        this.fps = function(b) {
            if (!arguments.length) return g;
            g = b;
            m = 1 / (g || 60);
            n = this.time + m;
            i = 0 === g ?
            function() {}: !f || !W ?
            function(b) {
                return s.setTimeout(b, 1E3 * (n - d.time) + 1 >> 0 || 1)
            }: W;
            q();
            k = i(u)
        };
        this.useRAF = function(b) {
            if (!arguments.length) return f;
            q();
            f = b;
            d.fps(g)
        };
        d.fps(b);
        s.setTimeout(function() {
            f && !k && d.useRAF(!1)
        },
        1E3)
    });
    c = g.Ticker.prototype = new g.events.EventDispatcher;
    c.constructor = g.Ticker;
    var m = d("core.Animation",
    function(b, c) {
        this.vars = c || {};
        this._duration = this._totalDuration = b || 0;
        this._delay = Number(this.vars.delay) || 0;
        this._timeScale = 1;
        this._active = !0 === this.vars.immediateRender;
        this.data = this.vars.data;
        this._reversed = !0 === this.vars.reversed;
        if (G) {
            e || (B.tick(), e = !0);
            var d = this.vars.useFrames ? y: G;
            d.insert(this, d._time);
            this.vars.paused && this.paused(!0)
        }
    }),
    B = m.ticker = new g.Ticker;
    c = m.prototype;
    c._dirty = c._gc = c._initted = c._paused = !1;
    c._totalTime = c._time = 0;
    c._rawPrevTime = -1;
    c._next = c._last = c._onUpdate = c._timeline = c.timeline = null;
    c._paused = !1;
    c.play = function(b, c) {
        arguments.length && this.seek(b, c);
        this.reversed(!1);
        return this.paused(!1)
    };
    c.pause = function(b, c) {
        arguments.length && this.seek(b, c);
        return this.paused(!0)
    };
    c.resume = function(b, c) {
        arguments.length && this.seek(b, c);
        return this.paused(!1)
    };
    c.seek = function(b, c) {
        return this.totalTime(Number(b), !1 != c)
    };
    c.restart = function(b, c) {
        this.reversed(!1);
        this.paused(!1);
        return this.totalTime(b ? -this._delay: 0, !1 !== c)
    };
    c.reverse = function(b, c) {
        arguments.length && this.seek(b || this.totalDuration(), c);
        this.reversed(!0);
        return this.paused(!1)
    };
    c.render = function() {};
    c.invalidate = function() {
        return this
    };
    c._enabled = function(b, c) {
        this._gc = !b;
        this._active = b && !this._paused && 0 < this._totalTime && this._totalTime < this._totalDuration; ! 0 !== c && (b && null == this.timeline ? this._timeline.insert(this, this._startTime - this._delay) : !b && null != this.timeline && this._timeline._remove(this, !0));
        return ! 1
    };
    c._kill = function() {
        return this._enabled(!1, !1)
    };
    c.kill = function(b, c) {
        this._kill(b, c);
        return this
    };
    c._uncache = function(b) {
        for (b = b ? this: this.timeline; b;) b._dirty = !0,
        b = b.timeline;
        return this
    };
    c.eventCallback = function(b, c, d, e) {
        if (null == b) return null;
        if ("on" === b.substr(0, 2)) {
            if (1 === arguments.length) return this.vars[b];
            if (null == c) delete this.vars[b];
            else if (this.vars[b] = c, this.vars[b + "Params"] = d, this.vars[b + "Scope"] = e, d) for (var f = d.length; - 1 < --f;)"{self}" === d[f] && (d = this.vars[b + "Params"] = d.concat(), d[f] = this);
            "onUpdate" === b && (this._onUpdate = c)
        }
        return this
    };
    c.delay = function(b) {
        if (!arguments.length) return this._delay;
        this._timeline.smoothChildTiming && this.startTime(this._startTime + b - this._delay);
        this._delay = b;
        return this
    };
    c.duration = function(b) {
        if (!arguments.length) return this._dirty = !1,
        this._duration;
        this._duration = this._totalDuration = b;
        this._uncache(!0);
        this._timeline.smoothChildTiming && this._active && 0 !== b && this.totalTime(this._totalTime * (b / this._duration), !0);
        return this
    };
    c.totalDuration = function(b) {
        this._dirty = !1;
        return ! arguments.length ? this._totalDuration: this.duration(b)
    };
    c.time = function(b, c) {
        if (!arguments.length) return this._time;
        this._dirty && this.totalDuration();
        b > this._duration && (b = this._duration);
        return this.totalTime(b, c)
    };
    c.totalTime = function(b, c) {
        if (!arguments.length) return this._totalTime;
        if (this._timeline) {
            0 > b && (b += this.totalDuration());
            if (this._timeline.smoothChildTiming && (this._dirty && this.totalDuration(), b > this._totalDuration && (b = this._totalDuration), this._startTime = (this._paused ? this._pauseTime: this._timeline._time) - (!this._reversed ? b: this._totalDuration - b) / this._timeScale, this._timeline._dirty || this._uncache(!1), !this._timeline._active)) for (var d = this._timeline; d._timeline;) d.totalTime(d._totalTime, !0),
            d = d._timeline;
            this._gc && this._enabled(!0, !1);
            this._totalTime !== b && this.render(b, c, !1)
        }
        return this
    };
    c.startTime = function(b) {
        if (!arguments.length) return this._startTime;
        b != this._startTime && (this._startTime = b, this.timeline && this.timeline._sortChildren && this.timeline.insert(this, b - this._delay));
        return this
    };
    c.timeScale = function(b) {
        if (!arguments.length) return this._timeScale;
        b = b || 1E-6;
        if (this._timeline && this._timeline.smoothChildTiming) {
            var c = this._pauseTime || 0 === this._pauseTime ? this._pauseTime: this._timeline._totalTime;
            this._startTime = c - (c - this._startTime) * this._timeScale / b
        }
        this._timeScale = b;
        return this._uncache(!1)
    };
    c.reversed = function(b) {
        if (!arguments.length) return this._reversed;
        b !== this._reversed && (this._reversed = b, this.totalTime(this._totalTime, !0));
        return this
    };
    c.paused = function(b) {
        if (!arguments.length) return this._paused;
        b !== this._paused && this._timeline && (!b && this._timeline.smoothChildTiming && (this._startTime += this._timeline.rawTime() - this._pauseTime, this._uncache(!1)), this._pauseTime = b ? this._timeline.rawTime() : null, this._paused = b, this._active = !this._paused && 0 < this._totalTime && this._totalTime < this._totalDuration);
        this._gc && (b || this._enabled(!0, !1));
        return this
    };
    g = d("core.SimpleTimeline",
    function(b) {
        m.call(this, 0, b);
        this.autoRemoveChildren = this.smoothChildTiming = !0
    });
    c = g.prototype = new m;
    c.constructor = g;
    c.kill()._gc = !1;
    c._first = c._last = null;
    c._sortChildren = !1;
    c.insert = function(b, c) {
        b._startTime = Number(c || 0) + b._delay;
        b._paused && this !== b._timeline && (b._pauseTime = b._startTime + (this.rawTime() - b._startTime) / b._timeScale);
        b.timeline && b.timeline._remove(b, !0);
        b.timeline = b._timeline = this;
        b._gc && b._enabled(!0, !0);
        var d = this._last;
        if (this._sortChildren) for (var e = b._startTime; d && d._startTime > e;) d = d._prev;
        d ? (b._next = d._next, d._next = b) : (b._next = this._first, this._first = b);
        b._next ? b._next._prev = b: this._last = b;
        b._prev = d;
        this._timeline && this._uncache(!0);
        return this
    };
    c._remove = function(b, c) {
        b.timeline === this && (c || b._enabled(!1, !0), b.timeline = null, b._prev ? b._prev._next = b._next: this._first === b && (this._first = b._next), b._next ? b._next._prev = b._prev: this._last === b && (this._last = b._prev), this._timeline && this._uncache(!0));
        return this
    };
    c.render = function(b, c) {
        var d = this._first,
        e;
        for (this._totalTime = this._time = this._rawPrevTime = b; d;) {
            e = d._next;
            if (d._active || b >= d._startTime && !d._paused) d._reversed ? d.render((!d._dirty ? d._totalDuration: d.totalDuration()) - (b - d._startTime) * d._timeScale, c, !1) : d.render((b - d._startTime) * d._timeScale, c, !1);
            d = e
        }
    };
    c.rawTime = function() {
        return this._totalTime
    };
    var w = d("TweenLite",
    function(b, c, d) {
        m.call(this, c, d);
        if (null == b) throw "Cannot tween an undefined reference.";
        this.target = b;
        this._overwrite = null == this.vars.overwrite ? u[w.defaultOverwrite] : "number" === typeof this.vars.overwrite ? this.vars.overwrite >> 0 : u[this.vars.overwrite];
        if ((b instanceof Array || b.jquery) && "object" === typeof b[0]) {
            this._targets = b.slice(0);
            this._propLookup = [];
            this._siblings = [];
            for (b = 0; b < this._targets.length; b++) d = this._targets[b],
            d.jquery ? (this._targets.splice(b--, 1), this._targets = this._targets.concat(d.constructor.makeArray(d))) : (this._siblings[b] = F(d, this, !1), 1 === this._overwrite && 1 < this._siblings[b].length && z(d, this, null, 1, this._siblings[b]))
        } else this._propLookup = {},
        this._siblings = F(b, this, !1),
        1 === this._overwrite && 1 < this._siblings.length && z(b, this, null, 1, this._siblings); (this.vars.immediateRender || 0 === c && 0 === this._delay && !1 !== this.vars.immediateRender) && this.render( - this._delay, !1, !0)
    },
    !0);
    c = w.prototype = new m;
    c.constructor = w;
    c.kill()._gc = !1;
    c.ratio = 0;
    c._firstPT = c._targets = c._overwrittenProps = null;
    c._notifyPluginsOfEnabled = !1;
    w.version = 1.63;
    w.defaultEase = c._ease = new M(null, null, 1, 1);
    w.defaultOverwrite = "auto";
    w.ticker = B;
    var S = w._plugins = {},
    L = w._tweenLookup = {},
    E = 0,
    C = {
        ease: 1,
        delay: 1,
        overwrite: 1,
        onComplete: 1,
        onCompleteParams: 1,
        onCompleteScope: 1,
        useFrames: 1,
        runBackwards: 1,
        startAt: 1,
        onUpdate: 1,
        onUpdateParams: 1,
        onUpdateScope: 1,
        onStart: 1,
        onStartParams: 1,
        onStartScope: 1,
        onReverseComplete: 1,
        onReverseCompleteParams: 1,
        onReverseCompleteScope: 1,
        onRepeat: 1,
        onRepeatParams: 1,
        onRepeatScope: 1,
        easeParams: 1,
        yoyo: 1,
        orientToBezier: 1,
        immediateRender: 1,
        repeat: 1,
        repeatDelay: 1,
        data: 1,
        paused: 1,
        reversed: 1
    },
    u = {
        none: 0,
        all: 1,
        auto: 2,
        concurrent: 3,
        allOnStart: 4,
        preexisting: 5,
        "true": 1,
        "false": 0
    },
    y = m._rootFramesTimeline = new g,
    G = m._rootTimeline = new g;
    G._startTime = B.time;
    y._startTime = B.frame;
    G._active = y._active = !0;
    m._updateRoot = function() {
        G.render((B.time - G._startTime) * G._timeScale, !1, !1);
        y.render((B.frame - y._startTime) * y._timeScale, !1, !1);
        if (! (B.frame % 120)) {
            var b, c, d;
            for (d in L) {
                c = L[d].tweens;
                for (b = c.length; - 1 < --b;) c[b]._gc && c.splice(b, 1);
                0 === c.length && delete L[d]
            }
        }
    };
    B.addEventListener("tick", m._updateRoot);
    var F = function(b, c, d) {
        var e = b._gsTweenID,
        f;
        if (!L[e || (b._gsTweenID = e = "t" + E++)]) L[e] = {
            target: b,
            tweens: []
        };
        if (c && (b = L[e].tweens, b[f = b.length] = c, d)) for (; - 1 < --f;) b[f] === c && b.splice(f, 1);
        return L[e].tweens
    },
    z = function(b, c, d, e, f) {
        var g, i, k;
        if (1 === e || 4 <= e) {
            b = f.length;
            for (g = 0; g < b; g++) if ((k = f[g]) !== c) k._gc || k._enabled(!1, !1) && (i = !0);
            else if (5 === e) break;
            return i
        }
        var n = c._startTime + 1E-10,
        m = [],
        q = 0,
        s = 0 === c._duration,
        u;
        for (g = f.length; - 1 < --g;) if (! ((k = f[g]) === c || k._gc || k._paused)) k._timeline !== c._timeline ? (u = u || R(c, 0, s), 0 === R(k, u, s) && (m[q++] = k)) : k._startTime <= n && k._startTime + k.totalDuration() / k._timeScale + 1E-10 > n && ((s || !k._initted) && 2E-10 >= n - k._startTime || (m[q++] = k));
        for (g = q; - 1 < --g;) if (k = m[g], 2 === e && k._kill(d, b) && (i = !0), 2 !== e || !k._firstPT && k._initted) k._enabled(!1, !1) && (i = !0);
        return i
    },
    R = function(b, c, d) {
        for (var e = b._timeline,
        f = e._timeScale,
        g = b._startTime; e._timeline;) {
            g += e._startTime;
            f *= e._timeScale;
            if (e._paused) return - 100;
            e = e._timeline
        }
        g /= f;
        return g > c ? g - c: d && g === c || !b._initted && 2E-10 > g - c ? 1E-10: (g += b.totalDuration() / b._timeScale / f) > c ? 0 : g - c - 1E-10
    };
    c._init = function() {
        this.vars.startAt && (this.vars.startAt.overwrite = 0, this.vars.startAt.immediateRender = !0, w.to(this.target, 0, this.vars.startAt));
        var b, c;
        this._ease = this.vars.ease instanceof M ? this.vars.easeParams instanceof Array ? this.vars.ease.config.apply(this.vars.ease, this.vars.easeParams) : this.vars.ease: "function" === typeof this.vars.ease ? new M(this.vars.ease, this.vars.easeParams) : w.defaultEase;
        this._easeType = this._ease._type;
        this._easePower = this._ease._power;
        this._firstPT = null;
        if (this._targets) for (b = this._targets.length; - 1 < --b;) {
            if (this._initProps(this._targets[b], this._propLookup[b] = {},
            this._siblings[b], this._overwrittenProps ? this._overwrittenProps[b] : null)) c = !0
        } else c = this._initProps(this.target, this._propLookup, this._siblings, this._overwrittenProps);
        c && w._onPluginEvent("_onInitAllProps", this);
        this._overwrittenProps && null == this._firstPT && "function" !== typeof this.target && this._enabled(!1, !1);
        if (this.vars.runBackwards) for (b = this._firstPT; b;) b.s += b.c,
        b.c = -b.c,
        b = b._next;
        this._onUpdate = this.vars.onUpdate;
        this._initted = !0
    };
    c._initProps = function(b, c, d, e) {
        var f, g, k, i, n, m;
        if (null == b) return ! 1;
        for (f in this.vars) {
            if (C[f]) {
                if ("onStartParams" === f || "onUpdateParams" === f || "onCompleteParams" === f || "onReverseCompleteParams" === f || "onRepeatParams" === f) if (n = this.vars[f]) for (g = n.length; - 1 < --g;)"{self}" === n[g] && (n = this.vars[f] = n.concat(), n[g] = this)
            } else if (S[f] && (i = new S[f])._onInitTween(b, this.vars[f], this)) {
                this._firstPT = m = {
                    _next: this._firstPT,
                    t: i,
                    p: "setRatio",
                    s: 0,
                    c: 1,
                    f: !0,
                    n: f,
                    pg: !0,
                    pr: i._priority
                };
                for (g = i._overwriteProps.length; - 1 < --g;) c[i._overwriteProps[g]] = this._firstPT;
                if (i._priority || i._onInitAllProps) k = !0;
                if (i._onDisable || i._onEnable) this._notifyPluginsOfEnabled = !0
            } else this._firstPT = c[f] = m = {
                _next: this._firstPT,
                t: b,
                p: f,
                f: "function" === typeof b[f],
                n: f,
                pg: !1,
                pr: 0
            },
            m.s = !m.f ? parseFloat(b[f]) : b[f.indexOf("set") || "function" !== typeof b["get" + f.substr(3)] ? f: "get" + f.substr(3)](),
            g = this.vars[f],
            m.c = "number" === typeof g ? g - m.s: "string" === typeof g && "=" === g.charAt(1) ? parseInt(g.charAt(0) + "1") * Number(g.substr(2)) : Number(g) || 0;
            m && m._next && (m._next._prev = m)
        }
        return e && this._kill(e, b) ? this._initProps(b, c, d, e) : 1 < this._overwrite && this._firstPT && 1 < d.length && z(b, this, c, this._overwrite, d) ? (this._kill(c, b), this._initProps(b, c, d, e)) : k
    };
    c.render = function(b, c, d) {
        var e = this._time,
        f, g;
        if (b >= this._duration) {
            if (this._totalTime = this._time = this._duration, this.ratio = this._ease._calcEnd ? this._ease.getRatio(1) : 1, this._reversed || (f = !0, g = "onComplete"), 0 === this._duration) {
                if (0 === b || 0 > this._rawPrevTime) this._rawPrevTime !== b && (d = !0);
                this._rawPrevTime = b
            }
        } else if (0 >= b) {
            this._totalTime = this._time = 0;
            this.ratio = this._ease._calcEnd ? this._ease.getRatio(0) : 0;
            if (0 !== e || 0 === this._duration && 0 < this._rawPrevTime) g = "onReverseComplete",
            f = this._reversed;
            0 > b ? (this._active = !1, 0 === this._duration && (0 <= this._rawPrevTime && (d = !0), this._rawPrevTime = b)) : this._initted || (d = !0)
        } else if (this._totalTime = this._time = b, this._easeType) {
            var i = b / this._duration,
            m = this._easeType,
            n = this._easePower;
            if (1 === m || 3 === m && 0.5 <= i) i = 1 - i;
            3 === m && (i *= 2);
            1 === n ? i *= i: 2 === n ? i *= i * i: 3 === n ? i *= i * i * i: 4 === n && (i *= i * i * i * i);
            this.ratio = 1 === m ? 1 - i: 2 === m ? i: 0.5 > b / this._duration ? i / 2 : 1 - i / 2
        } else this.ratio = this._ease.getRatio(b / this._duration);
        if (this._time !== e || d) {
            this._initted || (this._init(), !f && this._time && (this.ratio = this._ease.getRatio(this._time / this._duration))); ! this._active && !this._paused && (this._active = !0);
            if (0 === e && this.vars.onStart && (0 !== this._time || 0 === this._duration)) c || this.vars.onStart.apply(this.vars.onStartScope || this, this.vars.onStartParams || k);
            for (b = this._firstPT; b;) {
                if (b.f) b.t[b.p](b.c * this.ratio + b.s);
                else b.t[b.p] = b.c * this.ratio + b.s;
                b = b._next
            }
            this._onUpdate && (c || this._onUpdate.apply(this.vars.onUpdateScope || this, this.vars.onUpdateParams || k));
            g && !this._gc && (f && (this._timeline.autoRemoveChildren && this._enabled(!1, !1), this._active = !1), c || this.vars[g] && this.vars[g].apply(this.vars[g + "Scope"] || this, this.vars[g + "Params"] || k))
        }
    };
    c._kill = function(b, c) {
        "all" === b && (b = null);
        if (null == b && (null == c || c == this.target)) return this._enabled(!1, !1);
        var c = c || this._targets || this.target,
        d, e, f, g, i, k, m;
        if ((c instanceof Array || c.jquery) && "object" === typeof c[0]) for (d = c.length; - 1 < --d;) this._kill(b, c[d]) && (i = !0);
        else {
            if (this._targets) for (d = this._targets.length; - 1 < --d;) {
                if (c === this._targets[d]) {
                    g = this._propLookup[d] || {};
                    this._overwrittenProps = this._overwrittenProps || [];
                    e = this._overwrittenProps[d] = b ? this._overwrittenProps[d] || {}: "all";
                    break
                }
            } else {
                if (c !== this.target) return ! 1;
                g = this._propLookup;
                e = this._overwrittenProps = b ? this._overwrittenProps || {}: "all"
            }
            if (g) for (f in k = b || g, m = b != e && "all" != e && b != g && (null == b || !0 != b._tempKill), k) {
                if (d = g[f]) {
                    d.pg && d.t._kill(k) && (i = !0);
                    if (!d.pg || 0 === d.t._overwriteProps.length) d._prev ? d._prev._next = d._next: d === this._firstPT && (this._firstPT = d._next),
                    d._next && (d._next._prev = d._prev),
                    d._next = d._prev = null;
                    delete g[f]
                }
                m && (e[f] = 1)
            }
        }
        return i
    };
    c.invalidate = function() {
        this._notifyPluginsOfEnabled && w._onPluginEvent("_onDisable", this);
        this._onUpdate = this._overwrittenProps = this._firstPT = null;
        this._initted = this._active = this._notifyPluginsOfEnabled = !1;
        this._propLookup = this._targets ? {}: [];
        return this
    };
    c._enabled = function(b, c) {
        if (b && this._gc) if (this._targets) for (var d = this._targets.length; - 1 < --d;) this._siblings[d] = F(this._targets[d], this, !0);
        else this._siblings = F(this.target, this, !0);
        m.prototype._enabled.call(this, b, c);
        return this._notifyPluginsOfEnabled && this._firstPT ? w._onPluginEvent(b ? "_onEnable": "_onDisable", this) : !1
    };
    w.to = function(b, c, d) {
        return new w(b, c, d)
    };
    w.from = function(b, c, d) {
        d.runBackwards = !0; ! 1 != d.immediateRender && (d.immediateRender = !0);
        return new w(b, c, d)
    };
    w.fromTo = function(b, c, d, e) {
        e.startAt = d;
        d.immediateRender && (e.immediateRender = !0);
        return new w(b, c, e)
    };
    w.delayedCall = function(b, c, d, e, f) {
        return new w(c, 0, {
            delay: b,
            onComplete: c,
            onCompleteParams: d,
            onCompleteScope: e,
            onReverseComplete: c,
            onReverseCompleteParams: d,
            onReverseCompleteScope: e,
            immediateRender: !1,
            useFrames: f,
            overwrite: 0
        })
    };
    w.set = function(b, c) {
        return new w(b, 0, c)
    };
    w.killTweensOf = w.killDelayedCallsTo = function(b, c) {
        for (var d = w.getTweensOf(b), e = d.length; - 1 < --e;) d[e]._kill(c, b)
    };
    w.getTweensOf = function(b) {
        if (null != b) {
            var c, d, e;
            if ((b instanceof Array || b.jquery) && "object" === typeof b[0]) {
                c = b.length;
                for (d = []; - 1 < --c;) d = d.concat(w.getTweensOf(b[c]));
                for (c = d.length; - 1 < --c;) {
                    e = d[c];
                    for (b = c; - 1 < --b;) e === d[b] && d.splice(c, 1)
                }
            } else {
                d = F(b).concat();
                for (c = d.length; - 1 < --c;) d[c]._gc && d.splice(c, 1)
            }
            return d
        }
    };
    var J = d("plugins.TweenPlugin",
    function(b, c) {
        this._overwriteProps = (b || "").split(",");
        this._propName = this._overwriteProps[0];
        this._priority = c || 0
    },
    !0);
    c = J.prototype;
    J.version = 12;
    J.API = 2;
    c._firstPT = null;
    c._addTween = function(b, c, d, e, f, g) {
        var i;
        if (null != e && (i = "number" === typeof e || "=" !== e.charAt(1) ? Number(e) - d: parseInt(e.charAt(0) + "1") * Number(e.substr(2)))) this._firstPT = b = {
            _next: this._firstPT,
            t: b,
            p: c,
            s: d,
            c: i,
            f: "function" === typeof b[c],
            n: f || c,
            r: g
        },
        b._next && (b._next._prev = b)
    };
    c.setRatio = function(b) {
        for (var c = this._firstPT,
        d; c;) {
            d = c.c * b + c.s;
            c.r && (d = d + (0 < d ? 0.5 : -0.5) >> 0);
            if (c.f) c.t[c.p](d);
            else c.t[c.p] = d;
            c = c._next
        }
    };
    c._kill = function(b) {
        if (null != b[this._propName]) this._overwriteProps = [];
        else for (var c = this._overwriteProps.length; - 1 < --c;) null != b[this._overwriteProps[c]] && this._overwriteProps.splice(c, 1);
        for (c = this._firstPT; c;) null != b[c.n] && (c._next && (c._next._prev = c._prev), c._prev ? (c._prev._next = c._next, c._prev = null) : this._firstPT === c && (this._firstPT = c._next)),
        c = c._next;
        return ! 1
    };
    c._roundProps = function(b, c) {
        for (var d = this._firstPT; d;) {
            if (b[this._propName] || null != d.n && b[d.n.split(this._propName + "_").join("")]) d.r = c;
            d = d._next
        }
    };
    w._onPluginEvent = function(b, c) {
        var d = c._firstPT,
        e;
        if ("_onInitAllProps" === b) {
            for (var f, g, i, k; d;) {
                k = d._next;
                for (f = g; f && f.pr > d.pr;) f = f._next; (d._prev = f ? f._prev: i) ? d._prev._next = d: g = d; (d._next = f) ? f._prev = d: i = d;
                d = k
            }
            d = c._firstPT = g
        }
        for (; d;) d.pg && "function" === typeof d.t[b] && d.t[b]() && (e = !0),
        d = d._next;
        return e
    };
    J.activate = function(b) {
        for (var c = b.length; - 1 < --c;) b[c].API === J.API && (w._plugins[(new b[c])._propName] = b[c]);
        return ! 0
    };
    if (q = s._gsQueue) {
        for (n = 0; n < q.length; n++) q[n]();
        for (c in b) b[c].def || console.log("Warning: TweenLite encountered missing dependency: com.greensock." + c)
    }
})(window);

//tween
;
var TWEEN = (function() {
    var $ = this;
    $.Easing = {
        Linear: {},
        Quadratic: {},
        Cubic: {},
        Quartic: {},
        Quintic: {},
        Sinusoidal: {},
        Exponential: {},
        Circular: {},
        Elastic: {},
        Back: {},
        Bounce: {}
    };
    $.Easing.Linear.EaseNone = function($) {
        return $
    };
    $.Easing.Quadratic.EaseIn = function($) {
        return $ * $
    };
    $.Easing.Quadratic.EaseOut = function($) {
        return - $ * ($ - 2)
    };
    $.Easing.Quadratic.EaseInOut = function($) {
        if (($ *= 2) < 1) return 0.5 * $ * $;
        return - 0.5 * (--$ * ($ - 2) - 1)
    };
    $.Easing.Cubic.EaseIn = function($) {
        return $ * $ * $
    };
    $.Easing.Cubic.EaseOut = function($) {
        return--$ * $ * $ + 1
    };
    $.Easing.Cubic.EaseInOut = function($) {
        if (($ *= 2) < 1) return 0.5 * $ * $ * $;
        return 0.5 * (($ -= 2) * $ * $ + 2)
    };
    $.Easing.Quartic.EaseIn = function($) {
        return $ * $ * $ * $
    };
    $.Easing.Quartic.EaseOut = function($) {
        return - (--$ * $ * $ * $ - 1)
    };
    $.Easing.Quartic.EaseInOut = function($) {
        if (($ *= 2) < 1) return 0.5 * $ * $ * $ * $;
        return - 0.5 * (($ -= 2) * $ * $ * $ - 2)
    };
    $.Easing.Quintic.EaseIn = function($) {
        return $ * $ * $ * $ * $
    };
    $.Easing.Quintic.EaseOut = function($) {
        return ($ = $ - 1) * $ * $ * $ * $ + 1
    };
    $.Easing.Quintic.EaseInOut = function($) {
        if (($ *= 2) < 1) return 0.5 * $ * $ * $ * $ * $;
        return 0.5 * (($ -= 2) * $ * $ * $ * $ + 2)
    };
    $.Easing.Sinusoidal.EaseIn = function($) {
        return - Math.cos($ * Math.PI / 2) + 1
    };
    $.Easing.Sinusoidal.EaseOut = function($) {
        return Math.sin($ * Math.PI / 2)
    };
    $.Easing.Sinusoidal.EaseInOut = function($) {
        return - 0.5 * (Math.cos(Math.PI * $) - 1)
    };
    $.Easing.Exponential.EaseIn = function($) {
        return $ == 0 ? 0 : Math.pow(2, 10 * ($ - 1))
    };
    $.Easing.Exponential.EaseOut = function($) {
        return $ == 1 ? 1 : -Math.pow(2, -10 * $) + 1
    };
    $.Easing.Exponential.EaseInOut = function($) {
        if ($ == 0) return 0;
        if ($ == 1) return 1;
        if (($ *= 2) < 1) return 0.5 * Math.pow(2, 10 * ($ - 1));
        return 0.5 * ( - Math.pow(2, -10 * ($ - 1)) + 2)
    };
    $.Easing.Circular.EaseIn = function($) {
        return - (Math.sqrt(1 - $ * $) - 1)
    };
    $.Easing.Circular.EaseOut = function($) {
        return Math.sqrt(1 - --$ * $)
    };
    $.Easing.Circular.EaseInOut = function($) {
        if (($ /= 0.5) < 1) return - 0.5 * (Math.sqrt(1 - $ * $) - 1);
        return 0.5 * (Math.sqrt(1 - ($ -= 2) * $) + 1)
    };
    $.Easing.Elastic.EaseIn = function(B) {
        var $, A = 0.1,
        _ = 0.4;
        if (B == 0) return 0;
        if (B == 1) return 1;
        if (!_) _ = 0.3;
        if (!A || A < 1) {
            A = 1;
            $ = _ / 4
        } else $ = _ / (2 * Math.PI) * Math.asin(1 / A);
        return - (A * Math.pow(2, 10 * (B -= 1)) * Math.sin((B - $) * (2 * Math.PI) / _))
    };
    $.Easing.Elastic.EaseOut = function(B) {
        var $, A = 0.1,
        _ = 0.4;
        if (B == 0) return 0;
        if (B == 1) return 1;
        if (!_) _ = 0.3;
        if (!A || A < 1) {
            A = 1;
            $ = _ / 4
        } else $ = _ / (2 * Math.PI) * Math.asin(1 / A);
        return (A * Math.pow(2, -10 * B) * Math.sin((B - $) * (2 * Math.PI) / _) + 1)
    };
    $.Easing.Elastic.EaseInOut = function(B) {
        var $, A = 0.1,
        _ = 0.4;
        if (B == 0) return 0;
        if (B == 1) return 1;
        if (!_) _ = 0.3;
        if (!A || A < 1) {
            A = 1;
            $ = _ / 4
        } else $ = _ / (2 * Math.PI) * Math.asin(1 / A);
        if ((B *= 2) < 1) return - 0.5 * (A * Math.pow(2, 10 * (B -= 1)) * Math.sin((B - $) * (2 * Math.PI) / _));
        return A * Math.pow(2, -10 * (B -= 1)) * Math.sin((B - $) * (2 * Math.PI) / _) * 0.5 + 1
    };
    $.Easing.Back.EaseIn = function(_) {
        var $ = 1.70158;
        return _ * _ * (($ + 1) * _ - $)
    };
    $.Easing.Back.EaseOut = function(_) {
        var $ = 1.70158;
        return (_ = _ - 1) * _ * (($ + 1) * _ + $) + 1
    };
    $.Easing.Back.EaseInOut = function(_) {
        var $ = 1.70158 * 1.525;
        if ((_ *= 2) < 1) return 0.5 * (_ * _ * (($ + 1) * _ - $));
        return 0.5 * ((_ -= 2) * _ * (($ + 1) * _ + $) + 2)
    };
    $.Easing.Bounce.EaseIn = function(_) {
        return 1 - $.Easing.Bounce.EaseOut(1 - _)
    };
    $.Easing.Bounce.EaseOut = function($) {
        if (($ /= 1) < (1 / 2.75)) return 7.5625 * $ * $;
        else if ($ < (2 / 2.75)) return 7.5625 * ($ -= (1.5 / 2.75)) * $ + 0.75;
        else if ($ < (2.5 / 2.75)) return 7.5625 * ($ -= (2.25 / 2.75)) * $ + 0.9375;
        else return 7.5625 * ($ -= (2.625 / 2.75)) * $ + 0.984375
    };
    $.Easing.Bounce.EaseInOut = function(_) {
        if (_ < 0.5) return $.Easing.Bounce.EaseIn(_ * 2) * 0.5;
        return $.Easing.Bounce.EaseOut(_ * 2 - 1) * 0.5 + 0.5
    };
    return $
})();

//loading
$b = window.$b || {
    batch: this,
    moduleList: [],
    moduleState: undefined,
    moduleLoding: true,
    moduleLoad: function($) {
        if (!$) $ = 0;
        if ($b.moduleList[$].isLoading) return false;
        $nav.eq($).data("load", true);
        var _ = 0;
        $b.moduleList[$].loadIndex(0,
        function() {
            _++;
            if ( !! _ && _ == 1) if ($b.moduleList[$].length >= 10) {
                $b.moduleList[$].load();
                $b.moduleList[$].load();
                $b.moduleList[$].load()
            } else $b.moduleList[$].load()
        })
    },
    loadModule: function($) {
        var _ = 0;
        $.loadAll()
    },
    progressBar: null,
    singleLoadHandle: function(A) {
        var _ = Math.round(A.getLoadProgress() * 100);
        if (_ >= 100) {
            _ = 100;
            $("#loadnum").find("#num_h").addClass("num num1")
        } else $("#loadnum").find("#num_h").attr("class", "");
        $("#loadnum").find("#num_t").attr("class", "num").addClass("num" + ((_ / 10) >= 10 ? 0 : Math.floor(_ / 10)));
        $("#loadnum").find("#num_d").attr("class", "num").addClass("num" + (_ % 10));
        $("#loadbar").stop().animate({
            "width": _ + "%"
        },
        100);
        $("#mask_container").stop().animate({
            height: Math.round((112 - 20) * _ / 100) + 20
        },
        100)
    },
    singleLoadComplete: function(_) {
        $("#loadbar").stop().animate({
            width: "100%"
        },
        550,
        function() {
            $("#load").fadeOut(750,
            function() {
                $(this).remove();
                $f.loaded()
            })
        })
    },
    loadHandle: function($) {},
    loadComplete: function(_) {
        $b.moduleState[_.moduleIndex] = true;
        var C = false,
        A = false,
        $ = $b.moduleList;
        for (var B in $) {
            if ($[B].isLoading == true) C = true;
            if ($[B].getIsComplete() == false) A = true
        }
        if (!C && A) for (B in $) if ($[B].isLoading == false && $[B].getIsComplete() == false) {
            $b.moduleLoad(B);
            break
        }
        if (!C && !A) $b.moduleLoding = false
    },
    createModuleByP: function(C, D, F, B, A, $, _) {
        var E = {
            moduleIndex: F,
            powerSize: B,
            onProgress: A,
            onComplete: $
        };
        if (_ != undefined && _ != null & _ != "") E["step"] = _;
        return new $b.Module(C, D, E)
    },
    createModuleByS: function(C, B, $, _, A) {
        var E = {
            moduleIndex: 0,
            onProgress: B,
            onComplete: $
        };
        if (_ != undefined && _ != null && _ != "") E["step"] = _;
        if (A != undefined && A != null && A != "") E["parent"] = A;
        else A = "body";
        if ( !! C) {
            var D = C == "body" ? $b.getImages(C) : $b.getImages(C, A);
            return new $b.Module(D, D.length, E)
        }
    },
    getImages: function(_, D) {
        var B = [],
        A = !!D ? $(_, D) : $(_),
        C = A.find("*:not(script)").each(function() {
            var _ = "";
            if ($(this).css("background-image") != "none") _ = $(this).css("background-image");
            else if (typeof($(this).attr("src")) != "undefined" && this.tagName.toLowerCase() == "img") _ = $(this).attr("src");
            if (_.indexOf(",") == -1) {
                _ = _.replace("url(\"", "");
                _ = _.replace("url(", "");
                _ = _.replace("\")", "");
                _ = _.replace(")", "");
                if (_.length > 0 && _ != "none") B.push(_)
            }
        });
        return B
    },
    init: function() {},
    Module: function(J, E, P) {
        var B = this,
        N = {
            parent: "body",
            moduleIndex: 0,
            powerSize: 4,
            onComplete: null,
            onProgress: null,
            step: 64,
            stop: 1
        },
        F = $.extend({},
        N, P);
        this.moduleIndex = F.moduleIndex;
        this.parent = F.parent;
        this.length = E;
        var M = [],
        H = 0,
        C = false;
        this.isLoading = false;
        var O = F.step,
        _ = 0,
        D = false;
        function K($, A, _) {
            if ( !! $) if ( !! _) $.call(A, _);
            else $.apply(A)
        }
        function A(A, _) {
            var $ = Object.prototype.toString.call(_).slice(8, -1).toLowerCase();
            return _ !== undefined && _ !== null && $ === A.toLowerCase()
        }
        this.getLoadProgress = function() {
            return H * F.stop / B.length
        };
        this.isLoaded = function($) {
            if ($ === undefined) return H == B.length;
            else return M[$].isLoaded()
        };
        this.getIsComplete = function() {
            return C
        };
        this.loadPosition = function($, A) {
            $ = Math.min(1, Math.max(0, $));
            var _ = $ * (B.length - 1);
            _ = Math.round(_);
            B.loadIndex(_, A)
        };
        this.loadIndex = function($, _) {
            if ($ < 0 || $ >= B.length) return false;
            if ($ != Math.floor($)) return false;
            B.isLoading = true;
            var A = M[$];
            if (A == null) {
                var D = G($);
                A = new $b.ImageLoader(D);
                M[$] = A
            }
            A.load(function() {
                H++;
                if (!C) K(F.onProgress, this, B);
                K(_, this)
            })
        };
        this.loadAll = function($) {
            B.isLoading = true;
            for (var C = 0; C < B.length; C++) {
                var _ = M[C],
                A = G(C); (function(A) {
                    setTimeout(function() {
                        _ = new $b.ImageLoader(A);
                        M[C] = _;
                        _.load(function() {
                            H++;
                            K(F.onProgress, this, B);
                            if (H >= B.length) I();
                            K($, this)
                        })
                    },
                    C * 10)
                })(A)
            }
        };
        this.loadNext = function($) {
            if (O < F.stop) return;
            function A() {
                L();
                K($, this)
            }
            function C() {
                I();
                K($, this)
            }
            _ += O;
            if (_ >= B.length) {
                if (D) O /= 2;
                D = true;
                _ = O / 2;
                if (_ >= F.stop) B.loadIndex(_, A);
                else I()
            } else B.loadIndex(_, A)
        };
        this.getImageLoader = function($) {
            return M[$]
        };
        function L() {
            setTimeout(function() {
                B.loadNext()
            },
            $.browser.mozilla || $.browser.msie ? 50 : 5)
        }
        function I() {
            C = true;
            B.isLoading = false;
            K(F.onComplete, this, B)
        }
        function G(B) {
            if (A("string", J)) {
                var D = (B + 1 + Math.pow(10, F.powerSize)).toString(10).substr(1);
                return J.replace("{index}", D)
            } else if (A("object", J)) {
                var _ = J.imgs,
                D = "",
                C = 0,
                $ = 0;
                for (var E in _) {
                    if (B < (parseInt(_[E].len) + C) && B >= C) {
                        D = (B + 1 - C + Math.pow(10, _[E].powerSize)).toString(10).substr(1);
                        $ = E
                    }
                    C += _[E].len
                }
                return _[$].path.replace("{index}", D)
            } else if (A("array", J)) return J[B]
        }
        this.getImageObj = function($) {
            return M[$].image
        };
        this.load = function() {
            B.loadIndex(0, L)
        };
        this.stop = function() {
            O = F.stop / 2
        };
        this.reset = function() {
            C = false;
            H = 0;
            O = F.step;
            _ = 0;
            D = false;
            $.each(M,
            function(_, $) { !! $ && $.unload()
            })
        }
    },
    ImageLoader: function(A) {
        this.image = new Image();
        var _ = this.image,
        B = false;
        this.getSrc = function() {
            return A
        };
        this.load = function(C) {
            B = true;
            _.src = A;
            if (_.complete) C.apply(_);
            else $(_).load(C)
        };
        this.unload = function() {
            B = false;
            _ = this.image = new Image()
        };
        this.isLoaded = function() {
            return B && _.complete
        }
    }
};

//jquery.ellipsis.js
/*!
 * jQuery UI 1.8.14
 *
 * Copyright 2011, AUTHORS.txt (http://jqueryui.com/about)
 * Dual licensed under the MIT or GPL Version 2 licenses.
 * http://jquery.org/license
 *
 * http://docs.jquery.com/UI
 */
(function(c, j) {
    function k(a, b) {
        var d = a.nodeName.toLowerCase();
        if ("area" === d) {
            b = a.parentNode;
            d = b.name;
            if (!a.href || !d || b.nodeName.toLowerCase() !== "map") return false;
            a = c("img[usemap=#" + d + "]")[0];
            return !! a && l(a)
        }
        return (/input|select|textarea|button|object/.test(d) ? !a.disabled: "a" == d ? a.href || b: b) && l(a)
    }
    function l(a) {
        return ! c(a).parents().andSelf().filter(function() {
            return c.curCSS(this, "visibility") === "hidden" || c.expr.filters.hidden(this)
        }).length
    }
    c.ui = c.ui || {};
    if (!c.ui.version) {
        c.extend(c.ui, {
            version: "1.8.14",
            keyCode: {
                ALT: 18,
                BACKSPACE: 8,
                CAPS_LOCK: 20,
                COMMA: 188,
                COMMAND: 91,
                COMMAND_LEFT: 91,
                COMMAND_RIGHT: 93,
                CONTROL: 17,
                DELETE: 46,
                DOWN: 40,
                END: 35,
                ENTER: 13,
                ESCAPE: 27,
                HOME: 36,
                INSERT: 45,
                LEFT: 37,
                MENU: 93,
                NUMPAD_ADD: 107,
                NUMPAD_DECIMAL: 110,
                NUMPAD_DIVIDE: 111,
                NUMPAD_ENTER: 108,
                NUMPAD_MULTIPLY: 106,
                NUMPAD_SUBTRACT: 109,
                PAGE_DOWN: 34,
                PAGE_UP: 33,
                PERIOD: 190,
                RIGHT: 39,
                SHIFT: 16,
                SPACE: 32,
                TAB: 9,
                UP: 38,
                WINDOWS: 91
            }
        });
        c.fn.extend({
            _focus: c.fn.focus,
            focus: function(a, b) {
                return typeof a === "number" ? this.each(function() {
                    var d = this;
                    setTimeout(function() {
                        c(d).focus();
                        b && b.call(d)
                    },
                    a)
                }) : this._focus.apply(this, arguments)
            },
            scrollParent: function() {
                var a;
                a = c.browser.msie && /(static|relative)/.test(this.css("position")) || /absolute/.test(this.css("position")) ? this.parents().filter(function() {
                    return /(relative|absolute|fixed)/.test(c.curCSS(this, "position", 1)) && /(auto|scroll)/.test(c.curCSS(this, "overflow", 1) + c.curCSS(this, "overflow-y", 1) + c.curCSS(this, "overflow-x", 1))
                }).eq(0) : this.parents().filter(function() {
                    return /(auto|scroll)/.test(c.curCSS(this, "overflow", 1) + c.curCSS(this, "overflow-y", 1) + c.curCSS(this, "overflow-x", 1))
                }).eq(0);
                return /fixed/.test(this.css("position")) || !a.length ? c(document) : a
            },
            zIndex: function(a) {
                if (a !== j) return this.css("zIndex", a);
                if (this.length) {
                    a = c(this[0]);
                    for (var b; a.length && a[0] !== document;) {
                        b = a.css("position");
                        if (b === "absolute" || b === "relative" || b === "fixed") {
                            b = parseInt(a.css("zIndex"), 10);
                            if (!isNaN(b) && b !== 0) return b
                        }
                        a = a.parent()
                    }
                }
                return 0
            },
            disableSelection: function() {
                return this.bind((c.support.selectstart ? "selectstart": "mousedown") + ".ui-disableSelection",
                function(a) {
                    a.preventDefault()
                })
            },
            enableSelection: function() {
                return this.unbind(".ui-disableSelection")
            }
        });
        c.each(["Width", "Height"],
        function(a, b) {
            function d(f, g, m, n) {
                c.each(e,
                function() {
                    g -= parseFloat(c.curCSS(f, "padding" + this, true)) || 0;
                    if (m) g -= parseFloat(c.curCSS(f, "border" + this + "Width", true)) || 0;
                    if (n) g -= parseFloat(c.curCSS(f, "margin" + this, true)) || 0
                });
                return g
            }
            var e = b === "Width" ? ["Left", "Right"] : ["Top", "Bottom"],
            h = b.toLowerCase(),
            i = {
                innerWidth: c.fn.innerWidth,
                innerHeight: c.fn.innerHeight,
                outerWidth: c.fn.outerWidth,
                outerHeight: c.fn.outerHeight
            };
            c.fn["inner" + b] = function(f) {
                if (f === j) return i["inner" + b].call(this);
                return this.each(function() {
                    c(this).css(h, d(this, f) + "px")
                })
            };
            c.fn["outer" + b] = function(f, g) {
                if (typeof f !== "number") return i["outer" + b].call(this, f);
                return this.each(function() {
                    c(this).css(h, d(this, f, true, g) + "px")
                })
            }
        });
        c.extend(c.expr[":"], {
            data: function(a, b, d) {
                return !! c.data(a, d[3])
            },
            focusable: function(a) {
                return k(a, !isNaN(c.attr(a, "tabindex")))
            },
            tabbable: function(a) {
                var b = c.attr(a, "tabindex"),
                d = isNaN(b);
                return (d || b >= 0) && k(a, !d)
            }
        });
        c(function() {
            var a = document.body,
            b = a.appendChild(b = document.createElement("div"));
            c.extend(b.style, {
                minHeight: "100px",
                height: "auto",
                padding: 0,
                borderWidth: 0
            });
            c.support.minHeight = b.offsetHeight === 100;
            c.support.selectstart = "onselectstart" in b;
            a.removeChild(b).style.display = "none"
        });
        c.extend(c.ui, {
            plugin: {
                add: function(a, b, d) {
                    a = c.ui[a].prototype;
                    for (var e in d) {
                        a.plugins[e] = a.plugins[e] || [];
                        a.plugins[e].push([b, d[e]])
                    }
                },
                call: function(a, b, d) {
                    if ((b = a.plugins[b]) && a.element[0].parentNode) for (var e = 0; e < b.length; e++) a.options[b[e][0]] && b[e][1].apply(a.element, d)
                }
            },
            contains: function(a, b) {
                return document.compareDocumentPosition ? a.compareDocumentPosition(b) & 16 : a !== b && a.contains(b)
            },
            hasScroll: function(a, b) {
                if (c(a).css("overflow") === "hidden") return false;
                b = b && b === "left" ? "scrollLeft": "scrollTop";
                var d = false;
                if (a[b] > 0) return true;
                a[b] = 1;
                d = a[b] > 0;
                a[b] = 0;
                return d
            },
            isOverAxis: function(a, b, d) {
                return a > b && a < b + d
            },
            isOver: function(a, b, d, e, h, i) {
                return c.ui.isOverAxis(a, d, h) && c.ui.isOverAxis(b, e, i)
            }
        })
    }
})(jQuery);
/*widget*/
(function(b, j) {
    if (b.cleanData) {
        var k = b.cleanData;
        b.cleanData = function(a) {
            for (var c = 0,
            d; (d = a[c]) != null; c++) b(d).triggerHandler("remove");
            k(a)
        }
    } else {
        var l = b.fn.remove;
        b.fn.remove = function(a, c) {
            return this.each(function() {
                if (!c) if (!a || b.filter(a, [this]).length) b("*", this).add([this]).each(function() {
                    b(this).triggerHandler("remove")
                });
                return l.call(b(this), a, c)
            })
        }
    }
    b.widget = function(a, c, d) {
        var e = a.split(".")[0],
        f;
        a = a.split(".")[1];
        f = e + "-" + a;
        if (!d) {
            d = c;
            c = b.Widget
        }
        b.expr[":"][f] = function(h) {
            return !! b.data(h, a)
        };
        b[e] = b[e] || {};
        b[e][a] = function(h, g) {
            arguments.length && this._createWidget(h, g)
        };
        c = new c;
        c.options = b.extend(true, {},
        c.options);
        b[e][a].prototype = b.extend(true, c, {
            namespace: e,
            widgetName: a,
            widgetEventPrefix: b[e][a].prototype.widgetEventPrefix || a,
            widgetBaseClass: f
        },
        d);
        b.widget.bridge(a, b[e][a])
    };
    b.widget.bridge = function(a, c) {
        b.fn[a] = function(d) {
            var e = typeof d === "string",
            f = Array.prototype.slice.call(arguments, 1),
            h = this;
            d = !e && f.length ? b.extend.apply(null, [true, d].concat(f)) : d;
            if (e && d.charAt(0) === "_") return h;
            e ? this.each(function() {
                var g = b.data(this, a),
                i = g && b.isFunction(g[d]) ? g[d].apply(g, f) : g;
                if (i !== g && i !== j) {
                    h = i;
                    return false
                }
            }) : this.each(function() {
                var g = b.data(this, a);
                g ? g.option(d || {})._init() : b.data(this, a, new c(d, this))
            });
            return h
        }
    };
    b.Widget = function(a, c) {
        arguments.length && this._createWidget(a, c)
    };
    b.Widget.prototype = {
        widgetName: "widget",
        widgetEventPrefix: "",
        options: {
            disabled: false
        },
        _createWidget: function(a, c) {
            b.data(c, this.widgetName, this);
            this.element = b(c);
            this.options = b.extend(true, {},
            this.options, this._getCreateOptions(), a);
            var d = this;
            this.element.bind("remove." + this.widgetName,
            function() {
                d.destroy()
            });
            this._create();
            this._trigger("create");
            this._init()
        },
        _getCreateOptions: function() {
            return b.metadata && b.metadata.get(this.element[0])[this.widgetName]
        },
        _create: function() {},
        _init: function() {},
        destroy: function() {
            this.element.unbind("." + this.widgetName).removeData(this.widgetName);
            this.widget().unbind("." + this.widgetName).removeAttr("aria-disabled").removeClass(this.widgetBaseClass + "-disabled ui-state-disabled")
        },
        widget: function() {
            return this.element
        },
        option: function(a, c) {
            var d = a;
            if (arguments.length === 0) return b.extend({},
            this.options);
            if (typeof a === "string") {
                if (c === j) return this.options[a];
                d = {};
                d[a] = c
            }
            this._setOptions(d);
            return this
        },
        _setOptions: function(a) {
            var c = this;
            b.each(a,
            function(d, e) {
                c._setOption(d, e)
            });
            return this
        },
        _setOption: function(a, c) {
            this.options[a] = c;
            if (a === "disabled") this.widget()[c ? "addClass": "removeClass"](this.widgetBaseClass + "-disabled ui-state-disabled").attr("aria-disabled", c);
            return this
        },
        enable: function() {
            return this._setOption("disabled", false)
        },
        disable: function() {
            return this._setOption("disabled", true)
        },
        _trigger: function(a, c, d) {
            var e = this.options[a];
            c = b.Event(c);
            c.type = (a === this.widgetEventPrefix ? a: this.widgetEventPrefix + a).toLowerCase();
            d = d || {};
            if (c.originalEvent) {
                a = b.event.props.length;
                for (var f; a;) {
                    f = b.event.props[--a];
                    c[f] = c.originalEvent[f]
                }
            }
            this.element.trigger(c, d);
            return ! (b.isFunction(e) && e.call(this.element[0], c, d) === false || c.isDefaultPrevented())
        }
    }
})(jQuery);
/*mouse*/
(function(b) {
    var d = false;
    b(document).mousedown(function() {
        d = false
    });
    b.widget("ui.mouse", {
        options: {
            cancel: ":input,option",
            distance: 1,
            delay: 0
        },
        _mouseInit: function() {
            var a = this;
            this.element.bind("mousedown." + this.widgetName,
            function(c) {
                return a._mouseDown(c)
            }).bind("click." + this.widgetName,
            function(c) {
                if (true === b.data(c.target, a.widgetName + ".preventClickEvent")) {
                    b.removeData(c.target, a.widgetName + ".preventClickEvent");
                    c.stopImmediatePropagation();
                    return false
                }
            });
            this.started = false
        },
        _mouseDestroy: function() {
            this.element.unbind("." + this.widgetName)
        },
        _mouseDown: function(a) {
            if (!d) {
                this._mouseStarted && this._mouseUp(a);
                this._mouseDownEvent = a;
                var c = this,
                f = a.which == 1,
                g = typeof this.options.cancel == "string" ? b(a.target).closest(this.options.cancel).length: false;
                if (!f || g || !this._mouseCapture(a)) return true;
                this.mouseDelayMet = !this.options.delay;
                if (!this.mouseDelayMet) this._mouseDelayTimer = setTimeout(function() {
                    c.mouseDelayMet = true
                },
                this.options.delay);
                if (this._mouseDistanceMet(a) && this._mouseDelayMet(a)) {
                    this._mouseStarted = this._mouseStart(a) !== false;
                    if (!this._mouseStarted) {
                        a.preventDefault();
                        return true
                    }
                }
                true === b.data(a.target, this.widgetName + ".preventClickEvent") && b.removeData(a.target, this.widgetName + ".preventClickEvent");
                this._mouseMoveDelegate = function(e) {
                    return c._mouseMove(e)
                };
                this._mouseUpDelegate = function(e) {
                    return c._mouseUp(e)
                };
                b(document).bind("mousemove." + this.widgetName, this._mouseMoveDelegate).bind("mouseup." + this.widgetName, this._mouseUpDelegate);
                a.preventDefault();
                return d = true
            }
        },
        _mouseMove: function(a) {
            if (b.browser.msie && !(document.documentMode >= 9) && !a.button) return this._mouseUp(a);
            if (this._mouseStarted) {
                this._mouseDrag(a);
                return a.preventDefault()
            }
            if (this._mouseDistanceMet(a) && this._mouseDelayMet(a))(this._mouseStarted = this._mouseStart(this._mouseDownEvent, a) !== false) ? this._mouseDrag(a) : this._mouseUp(a);
            return ! this._mouseStarted
        },
        _mouseUp: function(a) {
            b(document).unbind("mousemove." + this.widgetName, this._mouseMoveDelegate).unbind("mouseup." + this.widgetName, this._mouseUpDelegate);
            if (this._mouseStarted) {
                this._mouseStarted = false;
                a.target == this._mouseDownEvent.target && b.data(a.target, this.widgetName + ".preventClickEvent", true);
                this._mouseStop(a)
            }
            return false
        },
        _mouseDistanceMet: function(a) {
            return Math.max(Math.abs(this._mouseDownEvent.pageX - a.pageX), Math.abs(this._mouseDownEvent.pageY - a.pageY)) >= this.options.distance
        },
        _mouseDelayMet: function() {
            return this.mouseDelayMet
        },
        _mouseStart: function() {},
        _mouseDrag: function() {},
        _mouseStop: function() {},
        _mouseCapture: function() {
            return true
        }
    })
})(jQuery);
/*draggable*/
(function(d) {
    d.widget("ui.draggable", d.ui.mouse, {
        widgetEventPrefix: "drag",
        options: {
            addClasses: true,
            appendTo: "parent",
            axis: false,
            connectToSortable: false,
            containment: false,
            cursor: "auto",
            cursorAt: false,
            grid: false,
            handle: false,
            helper: "original",
            iframeFix: false,
            opacity: false,
            refreshPositions: false,
            revert: false,
            revertDuration: 500,
            scope: "default",
            scroll: true,
            scrollSensitivity: 20,
            scrollSpeed: 20,
            snap: false,
            snapMode: "both",
            snapTolerance: 20,
            stack: false,
            zIndex: false
        },
        _create: function() {
            if (this.options.helper == "original" && !/^(?:r|a|f)/.test(this.element.css("position"))) this.element[0].style.position = "relative";
            this.options.addClasses && this.element.addClass("ui-draggable");
            this.options.disabled && this.element.addClass("ui-draggable-disabled");
            this._mouseInit()
        },
        destroy: function() {
            if (this.element.data("draggable")) {
                this.element.removeData("draggable").unbind(".draggable").removeClass("ui-draggable ui-draggable-dragging ui-draggable-disabled");
                this._mouseDestroy();
                return this
            }
        },
        _mouseCapture: function(a) {
            var b = this.options;
            if (this.helper || b.disabled || d(a.target).is(".ui-resizable-handle")) return false;
            this.handle = this._getHandle(a);
            if (!this.handle) return false;
            d(b.iframeFix === true ? "iframe": b.iframeFix).each(function() {
                d('<div class="ui-draggable-iframeFix" style="background: #fff;"></div>').css({
                    width: this.offsetWidth + "px",
                    height: this.offsetHeight + "px",
                    position: "absolute",
                    opacity: "0.001",
                    zIndex: 1E3
                }).css(d(this).offset()).appendTo("body")
            });
            return true
        },
        _mouseStart: function(a) {
            var b = this.options;
            this.helper = this._createHelper(a);
            this._cacheHelperProportions();
            if (d.ui.ddmanager) d.ui.ddmanager.current = this;
            this._cacheMargins();
            this.cssPosition = this.helper.css("position");
            this.scrollParent = this.helper.scrollParent();
            this.offset = this.positionAbs = this.element.offset();
            this.offset = {
                top: this.offset.top - this.margins.top,
                left: this.offset.left - this.margins.left
            };
            d.extend(this.offset, {
                click: {
                    left: a.pageX - this.offset.left,
                    top: a.pageY - this.offset.top
                },
                parent: this._getParentOffset(),
                relative: this._getRelativeOffset()
            });
            this.originalPosition = this.position = this._generatePosition(a);
            this.originalPageX = a.pageX;
            this.originalPageY = a.pageY;
            b.cursorAt && this._adjustOffsetFromHelper(b.cursorAt);
            b.containment && this._setContainment();
            if (this._trigger("start", a) === false) {
                this._clear();
                return false
            }
            this._cacheHelperProportions();
            d.ui.ddmanager && !b.dropBehaviour && d.ui.ddmanager.prepareOffsets(this, a);
            this.helper.addClass("ui-draggable-dragging");
            this._mouseDrag(a, true);
            d.ui.ddmanager && d.ui.ddmanager.dragStart(this, a);
            return true
        },
        _mouseDrag: function(a, b) {
            this.position = this._generatePosition(a);
            this.positionAbs = this._convertPositionTo("absolute");
            if (!b) {
                b = this._uiHash();
                if (this._trigger("drag", a, b) === false) {
                    this._mouseUp({});
                    return false
                }
                this.position = b.position
            }
            if (!this.options.axis || this.options.axis != "y") this.helper[0].style.left = this.position.left + "px";
            if (!this.options.axis || this.options.axis != "x") this.helper[0].style.top = this.position.top + "px";
            d.ui.ddmanager && d.ui.ddmanager.drag(this, a);
            return false
        },
        _mouseStop: function(a) {
            var b = false;
            if (d.ui.ddmanager && !this.options.dropBehaviour) b = d.ui.ddmanager.drop(this, a);
            if (this.dropped) {
                b = this.dropped;
                this.dropped = false
            }
            if ((!this.element[0] || !this.element[0].parentNode) && this.options.helper == "original") return false;
            if (this.options.revert == "invalid" && !b || this.options.revert == "valid" && b || this.options.revert === true || d.isFunction(this.options.revert) && this.options.revert.call(this.element, b)) {
                var c = this;
                d(this.helper).animate(this.originalPosition, parseInt(this.options.revertDuration, 10),
                function() {
                    c._trigger("stop", a) !== false && c._clear()
                })
            } else this._trigger("stop", a) !== false && this._clear();
            return false
        },
        _mouseUp: function(a) {
            this.options.iframeFix === true && d("div.ui-draggable-iframeFix").each(function() {
                this.parentNode.removeChild(this)
            });
            d.ui.ddmanager && d.ui.ddmanager.dragStop(this, a);
            return d.ui.mouse.prototype._mouseUp.call(this, a)
        },
        cancel: function() {
            this.helper.is(".ui-draggable-dragging") ? this._mouseUp({}) : this._clear();
            return this
        },
        _getHandle: function(a) {
            var b = !this.options.handle || !d(this.options.handle, this.element).length ? true: false;
            d(this.options.handle, this.element).find("*").andSelf().each(function() {
                if (this == a.target) b = true
            });
            return b
        },
        _createHelper: function(a) {
            var b = this.options;
            a = d.isFunction(b.helper) ? d(b.helper.apply(this.element[0], [a])) : b.helper == "clone" ? this.element.clone().removeAttr("id") : this.element;
            a.parents("body").length || a.appendTo(b.appendTo == "parent" ? this.element[0].parentNode: b.appendTo);
            a[0] != this.element[0] && !/(fixed|absolute)/.test(a.css("position")) && a.css("position", "absolute");
            return a
        },
        _adjustOffsetFromHelper: function(a) {
            if (typeof a == "string") a = a.split(" ");
            if (d.isArray(a)) a = {
                left: +a[0],
                top: +a[1] || 0
            };
            if ("left" in a) this.offset.click.left = a.left + this.margins.left;
            if ("right" in a) this.offset.click.left = this.helperProportions.width - a.right + this.margins.left;
            if ("top" in a) this.offset.click.top = a.top + this.margins.top;
            if ("bottom" in a) this.offset.click.top = this.helperProportions.height - a.bottom + this.margins.top
        },
        _getParentOffset: function() {
            this.offsetParent = this.helper.offsetParent();
            var a = this.offsetParent.offset();
            if (this.cssPosition == "absolute" && this.scrollParent[0] != document && d.ui.contains(this.scrollParent[0], this.offsetParent[0])) {
                a.left += this.scrollParent.scrollLeft();
                a.top += this.scrollParent.scrollTop()
            }
            if (this.offsetParent[0] == document.body || this.offsetParent[0].tagName && this.offsetParent[0].tagName.toLowerCase() == "html" && d.browser.msie) a = {
                top: 0,
                left: 0
            };
            return {
                top: a.top + (parseInt(this.offsetParent.css("borderTopWidth"), 10) || 0),
                left: a.left + (parseInt(this.offsetParent.css("borderLeftWidth"), 10) || 0)
            }
        },
        _getRelativeOffset: function() {
            if (this.cssPosition == "relative") {
                var a = this.element.position();
                return {
                    top: a.top - (parseInt(this.helper.css("top"), 10) || 0) + this.scrollParent.scrollTop(),
                    left: a.left - (parseInt(this.helper.css("left"), 10) || 0) + this.scrollParent.scrollLeft()
                }
            } else return {
                top: 0,
                left: 0
            }
        },
        _cacheMargins: function() {
            this.margins = {
                left: parseInt(this.element.css("marginLeft"), 10) || 0,
                top: parseInt(this.element.css("marginTop"), 10) || 0,
                right: parseInt(this.element.css("marginRight"), 10) || 0,
                bottom: parseInt(this.element.css("marginBottom"), 10) || 0
            }
        },
        _cacheHelperProportions: function() {
            this.helperProportions = {
                width: this.helper.outerWidth(),
                height: this.helper.outerHeight()
            }
        },
        _setContainment: function() {
            var a = this.options;
            if (a.containment == "parent") a.containment = this.helper[0].parentNode;
            if (a.containment == "document" || a.containment == "window") this.containment = [a.containment == "document" ? 0 : d(window).scrollLeft() - this.offset.relative.left - this.offset.parent.left, a.containment == "document" ? 0 : d(window).scrollTop() - this.offset.relative.top - this.offset.parent.top, (a.containment == "document" ? 0 : d(window).scrollLeft()) + d(a.containment == "document" ? document: window).width() - this.helperProportions.width - this.margins.left, (a.containment == "document" ? 0 : d(window).scrollTop()) + (d(a.containment == "document" ? document: window).height() || document.body.parentNode.scrollHeight) - this.helperProportions.height - this.margins.top];
            if (!/^(document|window|parent)$/.test(a.containment) && a.containment.constructor != Array) {
                a = d(a.containment);
                var b = a[0];
                if (b) {
                    a.offset();
                    var c = d(b).css("overflow") != "hidden";
                    this.containment = [(parseInt(d(b).css("borderLeftWidth"), 10) || 0) + (parseInt(d(b).css("paddingLeft"), 10) || 0), (parseInt(d(b).css("borderTopWidth"), 10) || 0) + (parseInt(d(b).css("paddingTop"), 10) || 0), (c ? Math.max(b.scrollWidth, b.offsetWidth) : b.offsetWidth) - (parseInt(d(b).css("borderLeftWidth"), 10) || 0) - (parseInt(d(b).css("paddingRight"), 10) || 0) - this.helperProportions.width - this.margins.left - this.margins.right, (c ? Math.max(b.scrollHeight, b.offsetHeight) : b.offsetHeight) - (parseInt(d(b).css("borderTopWidth"), 10) || 0) - (parseInt(d(b).css("paddingBottom"), 10) || 0) - this.helperProportions.height - this.margins.top - this.margins.bottom];
                    this.relative_container = a
                }
            } else if (a.containment.constructor == Array) this.containment = a.containment
        },
        _convertPositionTo: function(a, b) {
            if (!b) b = this.position;
            a = a == "absolute" ? 1 : -1;
            var c = this.cssPosition == "absolute" && !(this.scrollParent[0] != document && d.ui.contains(this.scrollParent[0], this.offsetParent[0])) ? this.offsetParent: this.scrollParent,
            f = /(html|body)/i.test(c[0].tagName);
            return {
                top: b.top + this.offset.relative.top * a + this.offset.parent.top * a - (d.browser.safari && d.browser.version < 526 && this.cssPosition == "fixed" ? 0 : (this.cssPosition == "fixed" ? -this.scrollParent.scrollTop() : f ? 0 : c.scrollTop()) * a),
                left: b.left + this.offset.relative.left * a + this.offset.parent.left * a - (d.browser.safari && d.browser.version < 526 && this.cssPosition == "fixed" ? 0 : (this.cssPosition == "fixed" ? -this.scrollParent.scrollLeft() : f ? 0 : c.scrollLeft()) * a)
            }
        },
        _generatePosition: function(a) {
            var b = this.options,
            c = this.cssPosition == "absolute" && !(this.scrollParent[0] != document && d.ui.contains(this.scrollParent[0], this.offsetParent[0])) ? this.offsetParent: this.scrollParent,
            f = /(html|body)/i.test(c[0].tagName),
            e = a.pageX,
            h = a.pageY;
            if (this.originalPosition) {
                var g;
                if (this.containment) {
                    if (this.relative_container) {
                        g = this.relative_container.offset();
                        g = [this.containment[0] + g.left, this.containment[1] + g.top, this.containment[2] + g.left, this.containment[3] + g.top]
                    } else g = this.containment;
                    if (a.pageX - this.offset.click.left < g[0]) e = g[0] + this.offset.click.left;
                    if (a.pageY - this.offset.click.top < g[1]) h = g[1] + this.offset.click.top;
                    if (a.pageX - this.offset.click.left > g[2]) e = g[2] + this.offset.click.left;
                    if (a.pageY - this.offset.click.top > g[3]) h = g[3] + this.offset.click.top
                }
                if (b.grid) {
                    h = b.grid[1] ? this.originalPageY + Math.round((h - this.originalPageY) / b.grid[1]) * b.grid[1] : this.originalPageY;
                    h = g ? !(h - this.offset.click.top < g[1] || h - this.offset.click.top > g[3]) ? h: !(h - this.offset.click.top < g[1]) ? h - b.grid[1] : h + b.grid[1] : h;
                    e = b.grid[0] ? this.originalPageX + Math.round((e - this.originalPageX) / b.grid[0]) * b.grid[0] : this.originalPageX;
                    e = g ? !(e - this.offset.click.left < g[0] || e - this.offset.click.left > g[2]) ? e: !(e - this.offset.click.left < g[0]) ? e - b.grid[0] : e + b.grid[0] : e
                }
            }
            return {
                top: h - this.offset.click.top - this.offset.relative.top - this.offset.parent.top + (d.browser.safari && d.browser.version < 526 && this.cssPosition == "fixed" ? 0 : this.cssPosition == "fixed" ? -this.scrollParent.scrollTop() : f ? 0 : c.scrollTop()),
                left: e - this.offset.click.left - this.offset.relative.left - this.offset.parent.left + (d.browser.safari && d.browser.version < 526 && this.cssPosition == "fixed" ? 0 : this.cssPosition == "fixed" ? -this.scrollParent.scrollLeft() : f ? 0 : c.scrollLeft())
            }
        },
        _clear: function() {
            this.helper.removeClass("ui-draggable-dragging");
            this.helper[0] != this.element[0] && !this.cancelHelperRemoval && this.helper.remove();
            this.helper = null;
            this.cancelHelperRemoval = false
        },
        _trigger: function(a, b, c) {
            c = c || this._uiHash();
            d.ui.plugin.call(this, a, [b, c]);
            if (a == "drag") this.positionAbs = this._convertPositionTo("absolute");
            return d.Widget.prototype._trigger.call(this, a, b, c)
        },
        plugins: {},
        _uiHash: function() {
            return {
                helper: this.helper,
                position: this.position,
                originalPosition: this.originalPosition,
                offset: this.positionAbs
            }
        }
    });
    d.extend(d.ui.draggable, {
        version: "1.8.14"
    });
    d.ui.plugin.add("draggable", "connectToSortable", {
        start: function(a, b) {
            var c = d(this).data("draggable"),
            f = c.options,
            e = d.extend({},
            b, {
                item: c.element
            });
            c.sortables = [];
            d(f.connectToSortable).each(function() {
                var h = d.data(this, "sortable");
                if (h && !h.options.disabled) {
                    c.sortables.push({
                        instance: h,
                        shouldRevert: h.options.revert
                    });
                    h.refreshPositions();
                    h._trigger("activate", a, e)
                }
            })
        },
        stop: function(a, b) {
            var c = d(this).data("draggable"),
            f = d.extend({},
            b, {
                item: c.element
            });
            d.each(c.sortables,
            function() {
                if (this.instance.isOver) {
                    this.instance.isOver = 0;
                    c.cancelHelperRemoval = true;
                    this.instance.cancelHelperRemoval = false;
                    if (this.shouldRevert) this.instance.options.revert = true;
                    this.instance._mouseStop(a);
                    this.instance.options.helper = this.instance.options._helper;
                    c.options.helper == "original" && this.instance.currentItem.css({
                        top: "auto",
                        left: "auto"
                    })
                } else {
                    this.instance.cancelHelperRemoval = false;
                    this.instance._trigger("deactivate", a, f)
                }
            })
        },
        drag: function(a, b) {
            var c = d(this).data("draggable"),
            f = this;
            d.each(c.sortables,
            function() {
                this.instance.positionAbs = c.positionAbs;
                this.instance.helperProportions = c.helperProportions;
                this.instance.offset.click = c.offset.click;
                if (this.instance._intersectsWith(this.instance.containerCache)) {
                    if (!this.instance.isOver) {
                        this.instance.isOver = 1;
                        this.instance.currentItem = d(f).clone().removeAttr("id").appendTo(this.instance.element).data("sortable-item", true);
                        this.instance.options._helper = this.instance.options.helper;
                        this.instance.options.helper = function() {
                            return b.helper[0]
                        };
                        a.target = this.instance.currentItem[0];
                        this.instance._mouseCapture(a, true);
                        this.instance._mouseStart(a, true, true);
                        this.instance.offset.click.top = c.offset.click.top;
                        this.instance.offset.click.left = c.offset.click.left;
                        this.instance.offset.parent.left -= c.offset.parent.left - this.instance.offset.parent.left;
                        this.instance.offset.parent.top -= c.offset.parent.top - this.instance.offset.parent.top;
                        c._trigger("toSortable", a);
                        c.dropped = this.instance.element;
                        c.currentItem = c.element;
                        this.instance.fromOutside = c
                    }
                    this.instance.currentItem && this.instance._mouseDrag(a)
                } else if (this.instance.isOver) {
                    this.instance.isOver = 0;
                    this.instance.cancelHelperRemoval = true;
                    this.instance.options.revert = false;
                    this.instance._trigger("out", a, this.instance._uiHash(this.instance));
                    this.instance._mouseStop(a, true);
                    this.instance.options.helper = this.instance.options._helper;
                    this.instance.currentItem.remove();
                    this.instance.placeholder && this.instance.placeholder.remove();
                    c._trigger("fromSortable", a);
                    c.dropped = false
                }
            })
        }
    });
    d.ui.plugin.add("draggable", "cursor", {
        start: function() {
            var a = d("body"),
            b = d(this).data("draggable").options;
            if (a.css("cursor")) b._cursor = a.css("cursor");
            a.css("cursor", b.cursor)
        },
        stop: function() {
            var a = d(this).data("draggable").options;
            a._cursor && d("body").css("cursor", a._cursor)
        }
    });
    d.ui.plugin.add("draggable", "opacity", {
        start: function(a, b) {
            a = d(b.helper);
            b = d(this).data("draggable").options;
            if (a.css("opacity")) b._opacity = a.css("opacity");
            a.css("opacity", b.opacity)
        },
        stop: function(a, b) {
            a = d(this).data("draggable").options;
            a._opacity && d(b.helper).css("opacity", a._opacity)
        }
    });
    d.ui.plugin.add("draggable", "scroll", {
        start: function() {
            var a = d(this).data("draggable");
            if (a.scrollParent[0] != document && a.scrollParent[0].tagName != "HTML") a.overflowOffset = a.scrollParent.offset()
        },
        drag: function(a) {
            var b = d(this).data("draggable"),
            c = b.options,
            f = false;
            if (b.scrollParent[0] != document && b.scrollParent[0].tagName != "HTML") {
                if (!c.axis || c.axis != "x") if (b.overflowOffset.top + b.scrollParent[0].offsetHeight - a.pageY < c.scrollSensitivity) b.scrollParent[0].scrollTop = f = b.scrollParent[0].scrollTop + c.scrollSpeed;
                else if (a.pageY - b.overflowOffset.top < c.scrollSensitivity) b.scrollParent[0].scrollTop = f = b.scrollParent[0].scrollTop - c.scrollSpeed;
                if (!c.axis || c.axis != "y") if (b.overflowOffset.left + b.scrollParent[0].offsetWidth - a.pageX < c.scrollSensitivity) b.scrollParent[0].scrollLeft = f = b.scrollParent[0].scrollLeft + c.scrollSpeed;
                else if (a.pageX - b.overflowOffset.left < c.scrollSensitivity) b.scrollParent[0].scrollLeft = f = b.scrollParent[0].scrollLeft - c.scrollSpeed
            } else {
                if (!c.axis || c.axis != "x") if (a.pageY - d(document).scrollTop() < c.scrollSensitivity) f = d(document).scrollTop(d(document).scrollTop() - c.scrollSpeed);
                else if (d(window).height() - (a.pageY - d(document).scrollTop()) < c.scrollSensitivity) f = d(document).scrollTop(d(document).scrollTop() + c.scrollSpeed);
                if (!c.axis || c.axis != "y") if (a.pageX - d(document).scrollLeft() < c.scrollSensitivity) f = d(document).scrollLeft(d(document).scrollLeft() - c.scrollSpeed);
                else if (d(window).width() - (a.pageX - d(document).scrollLeft()) < c.scrollSensitivity) f = d(document).scrollLeft(d(document).scrollLeft() + c.scrollSpeed)
            }
            f !== false && d.ui.ddmanager && !c.dropBehaviour && d.ui.ddmanager.prepareOffsets(b, a)
        }
    });
    d.ui.plugin.add("draggable", "snap", {
        start: function() {
            var a = d(this).data("draggable"),
            b = a.options;
            a.snapElements = [];
            d(b.snap.constructor != String ? b.snap.items || ":data(draggable)": b.snap).each(function() {
                var c = d(this),
                f = c.offset();
                this != a.element[0] && a.snapElements.push({
                    item: this,
                    width: c.outerWidth(),
                    height: c.outerHeight(),
                    top: f.top,
                    left: f.left
                })
            })
        },
        drag: function(a, b) {
            for (var c = d(this).data("draggable"), f = c.options, e = f.snapTolerance, h = b.offset.left, g = h + c.helperProportions.width, n = b.offset.top, o = n + c.helperProportions.height, i = c.snapElements.length - 1; i >= 0; i--) {
                var j = c.snapElements[i].left,
                l = j + c.snapElements[i].width,
                k = c.snapElements[i].top,
                m = k + c.snapElements[i].height;
                if (j - e < h && h < l + e && k - e < n && n < m + e || j - e < h && h < l + e && k - e < o && o < m + e || j - e < g && g < l + e && k - e < n && n < m + e || j - e < g && g < l + e && k - e < o && o < m + e) {
                    if (f.snapMode != "inner") {
                        var p = Math.abs(k - o) <= e,
                        q = Math.abs(m - n) <= e,
                        r = Math.abs(j - g) <= e,
                        s = Math.abs(l - h) <= e;
                        if (p) b.position.top = c._convertPositionTo("relative", {
                            top: k - c.helperProportions.height,
                            left: 0
                        }).top - c.margins.top;
                        if (q) b.position.top = c._convertPositionTo("relative", {
                            top: m,
                            left: 0
                        }).top - c.margins.top;
                        if (r) b.position.left = c._convertPositionTo("relative", {
                            top: 0,
                            left: j - c.helperProportions.width
                        }).left - c.margins.left;
                        if (s) b.position.left = c._convertPositionTo("relative", {
                            top: 0,
                            left: l
                        }).left - c.margins.left
                    }
                    var t = p || q || r || s;
                    if (f.snapMode != "outer") {
                        p = Math.abs(k - n) <= e;
                        q = Math.abs(m - o) <= e;
                        r = Math.abs(j - h) <= e;
                        s = Math.abs(l - g) <= e;
                        if (p) b.position.top = c._convertPositionTo("relative", {
                            top: k,
                            left: 0
                        }).top - c.margins.top;
                        if (q) b.position.top = c._convertPositionTo("relative", {
                            top: m - c.helperProportions.height,
                            left: 0
                        }).top - c.margins.top;
                        if (r) b.position.left = c._convertPositionTo("relative", {
                            top: 0,
                            left: j
                        }).left - c.margins.left;
                        if (s) b.position.left = c._convertPositionTo("relative", {
                            top: 0,
                            left: l - c.helperProportions.width
                        }).left - c.margins.left
                    }
                    if (!c.snapElements[i].snapping && (p || q || r || s || t)) c.options.snap.snap && c.options.snap.snap.call(c.element, a, d.extend(c._uiHash(), {
                        snapItem: c.snapElements[i].item
                    }));
                    c.snapElements[i].snapping = p || q || r || s || t
                } else {
                    c.snapElements[i].snapping && c.options.snap.release && c.options.snap.release.call(c.element, a, d.extend(c._uiHash(), {
                        snapItem: c.snapElements[i].item
                    }));
                    c.snapElements[i].snapping = false
                }
            }
        }
    });
    d.ui.plugin.add("draggable", "stack", {
        start: function() {
            var a = d(this).data("draggable").options;
            a = d.makeArray(d(a.stack)).sort(function(c, f) {
                return (parseInt(d(c).css("zIndex"), 10) || 0) - (parseInt(d(f).css("zIndex"), 10) || 0)
            });
            if (a.length) {
                var b = parseInt(a[0].style.zIndex) || 0;
                d(a).each(function(c) {
                    this.style.zIndex = b + c
                });
                this[0].style.zIndex = b + a.length
            }
        }
    });
    d.ui.plugin.add("draggable", "zIndex", {
        start: function(a, b) {
            a = d(b.helper);
            b = d(this).data("draggable").options;
            if (a.css("zIndex")) b._zIndex = a.css("zIndex");
            a.css("zIndex", b.zIndex)
        },
        stop: function(a, b) {
            a = d(this).data("draggable").options;
            a._zIndex && d(b.helper).css("zIndex", a._zIndex)
        }
    })
})(jQuery);