/*
*author @losmessi
*/
; (function(Q) {
    var B = Q(window),
    Y = Q(document),
    G = 1,
    C = 1,
    D = Q.browser.mozilla,
    O = Q.browser.webkit,
    M = Q.browser.safari,
    K = Q.browser.msie,
    V = K && parseFloat(Q.browser.version) < 9,
    T = K && parseFloat(Q.browser.version) <= 9,
    N = K && parseFloat(Q.browser.version) < 7,
    W = (navigator.platform.toLowerCase().indexOf("win") > -1) ? true: false,
    I = ( !! navigator.userAgent.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/)),
    E,
    $,
    P = 1000,
    F = 600,
    L = 6790,
    J = 0,
    S = !I ? 30 : 15,
    H = true,
    X,
    Z,
    a,
    R = navigator.userAgent.match(/(iPhone|iPod|Android|ios|iPad|Mobile)/i);
    if (R) Q("meta[name=viewport]")[0].content = "minimum-scale=1,maximum-scale=1,width=320";
    try {
        document.domain = "tnc.org.cn"
    } catch(A) {}
    $f = window.$f || {
        init: function() {
            var A = this;
            A.cssInit();
            B.on("resize", $f.resizeHandle).trigger("resize");
            var _ = !R ? 0 : -37,
            $ = !R ? 0 : -179;
            B.on("scroll",
            function() {
                if (Y.scrollTop() > 80 + _) {
                    if (!Q(".p_ul").hasClass("fixed")) Q(".p_ul").addClass("fixed").trigger("mouseleave", true)
                } else if (Q(".p_ul").hasClass("fixed")) {
                    Q(".p_ul").removeClass("fixed");
                    if (!R) Q(".p_ul").trigger("mouseenter")
                }
                if (Y.scrollTop() > 290 + $) {
                    if (!Q(".tagbar").hasClass("fixed")) Q(".tagbar").addClass("fixed");
                    Q(".back").show()
                } else {
                    if (Q(".tagbar").hasClass("fixed")) Q(".tagbar").removeClass("fixed");
                    Q(".back").hide()
                }
            });
            B.on("load",
            function() {
                A.imageHandle();
                A.anchorHandle()
            });
            if (R) {
                Q("body").addClass("RMobile");
                Q(".menu,#foot").remove();
                Q("<a class=\"M_return\" onclick=\"history.back();\" href=\"javascript:;\">\u8fd4\u56de</a>").insertBefore(Q("#container"));
                Q(".sch_more").text(" ")
            } else Q(".menu,#foot").show()
        },
        imageHandle: function() {
            if (N) Q(".article img").each(function(_, $) {
                Q(this).width() > 660 && Q(this).css({
                    width: "100%"
                })
            })
        },
        resizeHandle: function(A) {
            E = !R && B.width() < P ? P: B.width();
            $ = !R && B.height() < F ? F: B.height();
            Q("#main,.menu").css({
                width: E
            });
            Q(".headbar img").each(function(_, $) {
                var C = Q(this).data("width"),
                B = Q(this).data("height"),
                A = Math.max(E / C, 390 / B);
                Q(this).css({
                    width: A * C,
                    height: A * B,
                    marginLeft: -(A * C) / 2,
                    marginTop: -(A * B) / 2,
                    left: "50%",
                    top: "50%"
                })
            });
            Q(".logo").css({
                left: (_ = (E - 532) / 2) > 258 ? (_ - 258) / 2 : _ - 258
            }).css({
                display: "block"
            });
            Q(".p_ul").css({
                left: !R ? (_ = (E - 532) / 2) > 258 ? (_ - 258) / 2 : _ - 258 : 0
            }).css({
                display: "block"
            })
        },
        fontHandle: function() {
            if (R) return;
            var B = this,
            A = "<dl class=\"font_dl\"><dd><a href=\"javascript:;\" class=\"font_s B_font\" title=\"\u51cf\u5c0f\u5b57\u53f7\"></a></dd><dd><a href=\"javascript:;\" class=\"font_l B_font\" title=\"\u589e\u5927\u5b57\u53f7\"></a></dd></dl>",
            _ = B.Gc("font") == undefined ? 1 : B.Gc("font") == "0" ? 0 : 1;
            Q(".left").prepend(A);
            var $ = ["small", "large"];
            Q(".B_font").bind("click",
            function(C, _) {
                if (!_ || !Q(this).hasClass("disable")) {
                    var A = Q(".B_font").index(this);
                    Q(".B_font").removeClass("disable").eq(A).addClass("disable");
                    Q(".left").attr("class", "left " + $[A]);
                    B.Sc("font", A, 7 * 24)
                }
            }).eq(_).trigger("click", true)
        },
        cssInit: function() {
            var _ = this;
            _.navInit();
            _.shareInit();
            _.fontHandle();
            Q("#logo").bind("click",
            function() {
                Q(".nav_0").trigger("click")
            });
            var $ = !R ? 165 : 60;
            setTimeout(function() {
                Q(".p_ul").each(function(A, _) {
                    var B = Q(this).children().size();
                    Q(this).bind("mouseenter",
                    function(_, $) {
                        Q(this).stop().animate({
                            height: B * 58
                        },
                        R ? 0 : 350)
                    }).bind("mouseleave",
                    function(_, $) {
                        if (Q(this).hasClass("fixed") || !!$ || R) Q(this).stop().animate({
                            height: 58
                        },
                        R ? 0 : 250)
                    }).trigger("mouseleave").children("li").not(".p_ul_head").bind("click",
                    function() {
                        Q(this).parent().trigger("mouseleave", true);
                        var A = Q(".p_ul li").not(".p_ul_head"),
                        _ = A.index(this);
                        Y.scrollTop(Q(".article").eq(_).offset().top - $)
                    })
                })
            },
            500);
            Q(".B_search").bind("click",
            function() {
                if ( !! Q(".T_search").val()) window.location.href = "/#Foot#iframe^sec->\u641c\u7d22^link->/home/search?q=" + Q(".T_search").val()
            });
            _.ellipsis(Q(".more_text"), 320, 84);
            if (!R) {
                Q("#main").append("<a class=\"back\" href=\"javascript:;\"></a>");
                Q(".back").bind("click",
                function() {
                    Y.scrollTop(0)
                })
            }
        },
        anchor: {},
        anchorHandle: function() {
            var A = this,
            _ = Q(".title,.subtitle,.smatitle");
            _.each(function(_, $) {
                A.anchor[Q(this).text()] = this
            });
            Q("a[href^=\"#\"],a[href^=\"http://#\"]").bind("click",
            function() {
                var $ = Q(this).attr("href");
                if (/^#.+$/.test($) && !!A.anchor[$.substr(1)]) Y.scrollTop(Q(A.anchor[$.substr(1)]).offset().top - 165);
                if (/^http:\/\/#.+$/.test($) && !!A.anchor[$.substr(8)]) Y.scrollTop(Q(A.anchor[$.substr(8)]).offset().top - 165);
                return false
            });
            var $ = document.location.hash;
            if (/^#.+$/.test($) && !!A.anchor[$.substr(1)]) {
                setTimeout(function() {
                    Y.scrollTop(Q(A.anchor[$.substr(1)]).offset().top - 165)
                },
                100);
                document.location.hash = "#"
            }
        },
        shareInit: function() {
            var A = "http://tnc.org.cn",
            _ = "\u5927\u81ea\u7136\u4fdd\u62a4\u534f\u4f1a\uff08TNC\uff09",
            $ = "\u5927\u81ea\u7136\u4fdd\u62a4\u534f\u4f1a [TNC] \u662f\u6700\u4e3b\u8981\u7684\u81ea\u7136\u4fdd\u62a4\u56fd\u9645\u7ec4\u7ec7\u4e4b\u4e00\uff0c60\u5e74\u6765\u81f4\u529b\u4e8e\u7528\u79d1\u5b66\u7cfb\u7edf\u7684\u65b9\u6cd5\u5728\u5168\u7403\u4fdd\u62a4\u5177\u6709\u91cd\u8981\u751f\u6001\u4ef7\u503c\u7684\u9646\u5730\u548c\u6c34\u57df\uff0c\u4ee5\u7ef4\u62a4\u81ea\u7136\u73af\u5883\u3001\u63d0\u5347\u4eba\u7c7b\u798f\u7949\u3002\u76ee\u524d\u5728\u5168\u740335\u4e2a\u56fd\u5bb6\u5f00\u5c55\u751f\u7269\u591a\u6837\u6027\u4fdd\u62a4\u5de5\u4f5c\u3002";
            Q(".s_sina").bind("click",
            function() {
                window.open("http://v.t.sina.com.cn/share/share.php?appkey=&url=" + encodeURIComponent(A) + "&pic=" + encodeURIComponent(Q(".mine_ul li.current").find("img").attr("src")) + "&title=" + encodeURIComponent($.replace("http://www.autobaojun.com/jyxs/", "")), "_blank", "scrollbars=no,width=600,height=450,left=75,top=20,status=no,resizable=yes")
            });
            Q(".s_qq").bind("click",
            function() {
                window.open("http://share.v.t.qq.com/index.php?c=share&a=index&url=" + encodeURIComponent(A) + "&title=" + encodeURIComponent($.replace("http://www.autobaojun.com/jyxs/", "")) + "&pic=" + encodeURIComponent(Q(".mine_ul li.current").find("img").attr("src")) + "", "_blank", "scrollbars=no,width=600,height=450,left=75,top=20,status=no,resizable=yes")
            });
            Q(".s_douban").bind("click",
            function() {
                window.open("http://shuo.douban.com/!service/share?href=" + encodeURIComponent(A) + "&image=" + encodeURIComponent(Q(".mine_ul li.current").find("img").attr("src")) + "&text=" + encodeURIComponent($) + "&name=" + encodeURIComponent(_), "_blank", "scrollbars=no,width=600,height=450,left=75,top=20,status=no,resizable=yes")
            })
        },
        ellipsis: function(A, _, $, B) {
            var C = this; ! B && (B = "...");
            Q(A).each(function(D, A) {
                var E = Q(this).clone(false).css({
                    width: _,
                    height: "auto",
                    padding: "0px",
                    "font": Q(this).css("font"),
                    "text-indent": Q(this).css("text-indent"),
                    "letter-spacing": Q(this).css("letter-spacing"),
                    "visibility": "hidden"
                }).appendTo(document.body);
                if (E.height() > $) {
                    E.text(Q(this).text() + B);
                    Q(this).text(C.ellipsisHandle($, E, B, 3))
                }
                E.remove()
            })
        },
        ellipsisHandle: function($, _, A, C) {
            var B = this,
            C = !!C ? C: 5,
            D = _.text();
            if (_.height() > $) {
                if (D.length < C + A.length) return D;
                else {
                    _.text(D.substr(0, D.length - A.length - C) + A);
                    return B.ellipsisHandle($, _, A, C)
                }
            } else return D
        },
        navInit: function() {
            TweenMax.set(Q(".nav_sub dl"), {
                css: {
                    perspective: 200
                }
            });
            var $ = this,
            B = null,
            A = function() {
                Q(".nav_li.current").addClass("hover"); ! V && Q(".nav_li.current").find(".nav_sub").stop().show().animate({
                    height: 124,
                    opacity: 1
                },
                500, "easeOutQuint",
                function() {
                    Q(this).addClass("toggle");
                    Q(this).css({
                        overflow: "visible"
                    })
                }) || Q(".nav_li.current").find(".nav_sub").stop().show().css({
                    height: 124,
                    overflow: "visible"
                }).addClass("toggle")
            };
            Q(".nav_li").each(function(D, _) {
                if (Q(this).find(".nav_sub").get(0)) {
                    var C = new TimelineMax({
                        repeat: 0
                    }),
                    E = Q("dl", this),
                    $ = Q("dd", this);
                    Q(this).find(".nav_sub .text").append("<div class=\"hover\" style=\"height:" + $.size() * 36 + "px\"></div>");
                    if (V) C.to(E, $.size() * 0.1, {
                        css: {
                            height: $.size() * 36
                        }
                    });
                    if (T) C.to(E, $.size() * 0.1, {
                        css: {
                            height: $.size() * 36,
                            opacity: 1
                        }
                    });
                    else {
                        TweenMax.set(E, {
                            css: {
                                height: 36,
                                opacity: 1,
                                overflow: "visible",
                                "boxShadow": "none"
                            }
                        });
                        TweenMax.set($, {
                            css: {
                                transformOrigin: "50% -10%",
                                "boxShadow": "2px 2px 4px rgba(0,0,0,0.35)"
                            }
                        });
                        C.staggerFrom($, 0.1, {
                            css: {
                                rotationX: -90,
                                opacity: 0
                            }
                        },
                        0.11)
                    }
                    C.reverse(0);
                    Q(this).data("tm", C)
                }
                Q(this).bind("mouseenter",
                function(C, A) {
                    Q(this).find(".hover").css({
                        display: "block"
                    });
                    clearTimeout(B);
                    if (!Q(this).hasClass("current")) {
                        var D = Q(".nav_li").filter(".current.hover");
                        if (D.get(0)) {
                            D.removeClass("hover"); ! V && Q(".nav_sub", D).stop().animate({
                                height: 0,
                                opacity: 0
                            },
                            300, "easeInOutQuint",
                            function() {
                                Q(this).hide().removeClass("toggle")
                            }) || Q(".nav_sub", D).hide();
                            Q("dl", D).stop().removeClass("active").hide();
                            D.trigger("close")
                        }
                        var _ = Q(".nav_sub", this),
                        E = Q("dl", this),
                        $ = Q("dd", E);
                        Q(this).addClass("hover"); ! V && _.stop().show().animate({
                            height: 124,
                            opacity: 1
                        },
                        300, "easeOutQuint",
                        function() {
                            _.css({
                                overflow: "visible"
                            }).addClass("toggle");
                            if (!A) {
                                E.stop().addClass("active").show();
                                Q(this).trigger("open")
                            }
                        }) || (_.stop().show().css({
                            height: 124,
                            overflow: "visible"
                        }).addClass("toggle") && !A && E.stop().addClass("active").show() && _.trigger("open"))
                    } else {
                        _ = Q(".nav_sub", this),
                        E = Q("dl", this),
                        $ = Q("dd", E);
                        Q(this).addClass("hover"); ! V && _.stop().show().animate({
                            height: 124,
                            opacity: 1
                        },
                        _.hasClass("toggle") ? 0 : 300, "easeOutQuint",
                        function() {
                            Q(this).addClass("toggle").css({
                                overflow: "visible"
                            });
                            if (!A) {
                                E.stop().addClass("active").show();
                                Q(this).trigger("open")
                            }
                        }) || (_.stop().show().css({
                            height: 124,
                            overflow: "visible"
                        }) && !A && E.stop().addClass("active").show() && _.trigger("open"))
                    }
                }).bind("mouseleave",
                function(D, C) {
                    var _ = Q(".nav_sub", this),
                    E = Q("dl", this),
                    $ = Q("dd", E);
                    Q(this).find(".hover").css({
                        display: "none"
                    });
                    if (!Q(this).hasClass("current")) {
                        Q(this).removeClass("current"); ! V && _.stop().animate({
                            height: 0,
                            opacity: 0
                        },
                        300, "easeInOutQuint",
                        function() {
                            Q(this).hide().removeClass("toggle")
                        }) || _.stop().hide();
                        E.stop().removeClass("active").hide();
                        Q(this).trigger("close");
                        B = setTimeout(A, 30)
                    } else {
                        E.stop().removeClass("active").hide();
                        Q(this).trigger("close")
                    }
                }).bind("open",
                function() {
                    Q(this).data("tm") && Q(this).data("tm").restart()
                }).bind("close",
                function() {
                    Q(this).data("tm") && Q(this).data("tm").reverse(0)
                }).bind("click",
                function($, _) {
                    if (Q(this).hasClass("ni"));
                    Q(this).trigger("mouseleave")
                }).find("dd").bind("click",
                function($) {})
            });
            var _ = {
                "nav_4": "#news_links",
                "nav_5": "#interactive_links",
                "nav_6": "#acount_links"
            };
            Q(".RNav li").bind("mouseenter",
            function() {
                Q(".nav_sub", this).stop().show();
                var $ = Q(".nav_sub .text", this).height() + 88;
                Q(".nav_sub", this).animate({
                    height: $,
                    opacity: 1
                },
                500, "easeOutQuint");
                Q("dl", this).stop().show().animate({
                    height: 248,
                    opacity: 1
                },
                500, "easeOutQuint")
            }).bind("mouseleave",
            function() {
                Q(".nav_sub", this).stop().animate({
                    height: 0,
                    opacity: 0
                },
                500, "easeInOutQuint",
                function() {
                    Q(this).hide()
                });
                Q("dl", this).stop().animate({
                    height: 0,
                    opacity: 0
                },
                500, "easeOutQuint",
                function() {
                    Q(this).hide()
                })
            })
        },
        CSS3: function(_, $) {
            var A = {};
            A[_] = A["-moz-" + _] = A["-webkit-" + _] = A["-ms-" + _] = A["-o-" + _] = $;
            return A
        },
        pxToInt: function($) {
            return $.toString().indexOf("px") > -1 ? Math.round(parseFloat($.split("px")[0])) : $
        },
        shuffleArray: function($) {
            for (var _, B, A = $.length; A; _ = parseInt(Math.random() * A), B = $[--A], $[A] = $[_], $[_] = B);
            return $
        },
        sizeOf: function(_) {
            var $ = 0;
            for (var A in _) $++;
            return $
        },
        objString: function(A, $) {
            if ($ == undefined) $ = true;
            var _ = $ ? "{": "";
            for (var B in A) _ += B + ":" + A[B] + ";";
            return _ + ($ ? "}": "")
        },
        arraySuffix: function($, _) {
            for (var A = 0; A < $.length;
            /^-?\d+$/.test($[A]) ? $[A] += _: $[A] = $[A], A++);
            return $
        },
        TPL: function($, _) {
            return $.replace(/\{([\w\.]*)\}/g,
            function(A, D) {
                var B = D.split("."),
                $ = _[B.shift()];
                for (var E = 0,
                C = B.length; E < C; E++) $ = $[B[E]];
                return (typeof $ !== "undefined" && $ !== null) ? $: ""
            })
        },
        is: function($, A) {
            var _ = Object.prototype.toString.call(A).slice(8, -1).toLowerCase();
            return A !== undefined && A !== null && _ === $.toLowerCase()
        },
        isObject: function($) {
            return this.is("object", $)
        },
        Ac: function() {
            var $ = document.cookie
        },
        Sc: function($, A, C) {
            var _ = $ + "=" + escape(A); !! (C == undefined) && (C = 24);
            if (C > 0) {
                var D = new Date(),
                B = C * 3600 * 1000;
                D.setTime(D.getTime() + B);
                _ += "; expires=" + D.toGMTString()
            }
            document.cookie = _
        },
        Gc: function($) {
            var A = document.cookie.split("; ");
            for (var B = 0; B < A.length; B++) {
                var _ = A[B].split("=");
                if (_[0] == $) return unescape(decodeURIComponent(_[1]))
            }
        },
        Dc: function($) {
            var _ = new Date();
            _.setTime(_.getTime() - 10000);
            document.cookie = $ + "=; expires=" + _.toGMTString()
        }
    };
    function U($) {
        if (!H) return;
        if (window.console && window.console.log) window.console.log($);
        else if (window.opera && window.opera.postError) window.opera.postError($)
    }
    Q(document).ready(function($) {
        $f.init()
    })
})(jQuery);