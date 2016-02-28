(function($) {
    var $win = $(window);
    var $doc = $(document);
    var maxscale = 1,
    minscale = 1;
    var $FF = $.browser.mozilla;
    var $webkit = $.browser.webkit;
    var $safari = $.browser.safari;
    var $msie = $.browser.msie,
    $ie8 = $msie && parseFloat($.browser.version) < 9,
    $ie9 = $msie && parseFloat($.browser.version) <= 9,
    $ie6 = $msie && parseFloat($.browser.version) < 7;
    var $winplatform = (navigator.platform.toLowerCase().indexOf("win") > -1) ? true: false;
    var $ios = ( !! navigator.userAgent.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/));
    var _w, _h, _iw = 1000,
    _ih = 600,
    _all = 6790,
    _cur = 0,
    _step = !$ios ? 30 : 15;
    var $t = true;
    var _am, _ao, _new;
    $f = window.$f || {
        init: function() {
            var self = this;
            self.cssInit();
            $doc.on("mousewheel", $f.wheelHandler);
            $win.on("resize", $f.resizeHandle).trigger("resize");
            $doc.on("keydown", $f.keyHandler);
            self.loading()
        },
        dirSlide: function(tars, dir, call) {
            var size = $(tars).size(),
            cur = $(tars).index($(tars).filter(".current")),
            tar = cur + dir < 0 ? size - 1 : cur + dir >= size ? 0 : cur + dir;
            $(tars).eq(cur).stop().removeClass("current").css({
                left: "0%"
            }).animate({
                left: dir > 0 ? "-100%": "100%"
            },
            750,
            function() {
                $(this).hide()
            });
            $(tars).eq(tar).stop().addClass("current").css({
                left: dir > 0 ? "100%": "-100%",
                display: "block"
            }).animate({
                left: "0%",
                opacity: 1
            },
            750, call)
        },
        slideRender: function(tar, f, t, dur, flag, c, dir) {
            var $tar = $(tar),
            t_start = {
                "display": "block",
                "z-index": 1
            },
            t_end = {},
            f_end = {};
            t_start[!dir ? "left": "top"] = !!flag ? (f > t ? "100%": "-100%") : (f > t ? "-100%": "100%");
            t_end[!dir ? "left": "top"] = "0%";
            f_end[!dir ? "left": "top"] = !!flag ? (f > t ? "-100%": "100%") : (f > t ? "100%": "-100%");
            $tar.eq(t).stop(true, false).trigger("slideIn").css(t_start).animate(t_end, dur, "easeOutSine", c);
            $tar.eq(f).stop(true, false).trigger("slideOut").css({
                "display": "block",
                "z-index": 0
            }).animate(f_end, dur + 50, "easeOutSine",
            function() {
                $(this).hide();
                $(this).trigger("slideOutEnd");
                $(tar).eq(t).trigger("slideInEnd")
            });
            $tar.eq(f).removeClass("current");
            $tar.eq(t).addClass("current")
        },
        keyHandler: function(e) {
            if (e.keyCode >= 37 && e.keyCode <= 40) {
                e.returnValue = false;
                e.preventDefault();
                $f.wheelHandler(e, (e.keyCode == 37 || e.keyCode == 38) ? 1 : -1, 0, 0, true)
            }
        },
        wheelHandler: function(e, delta, deltaX, deltaY, isKey) {
            if (!$f.canMove) {
                return
            }
            var self = $f,
            _top = self.animTop(),
            _tar = _top + (delta > 0 ? -1 : 1) * _step;
            self.ns.setScrollTop(_tar < 0 ? 0 : _tar > _all ? _all: _tar)
        },
        cssInit: function() {
            var _ = this;
            _am = _AOM;
            _ao = _AObj;
            _new = New;
            _.ns = $(".bscroll").niceScroll({
                autohidemode: false,
                cursorwidth: 6,
                cursorcolor: "#00713d"
                /* !$ie8?"rgba(0,0,0,0.75)":"#292929" */
                ,
                cursorborder: "none",
                background: !$ie8 ? "rgba(0,0,0,0.35)": "#A5A5A5",
                horizrailenabled: false,
                railclass: "mscroll",
                cursorborderradius: "3px"
            });
            $(".mscroll").bind("mouseenter",
            function() {
                $(this).stop().animate({
                    width: 10,
                    marginLeft: -4
                },
                350);
                $("div", this).css("width", "100%")
            }).bind("mouseleave",
            function() {
                $(this).stop().animate({
                    width: 6,
                    marginLeft: 0
                },
                350)
            });
            $(".bscroll").bind("scroll",
            function(e) { ! _.animState && _.animateLoop(_.animState)
            });
            $("#logo").bind("click",
            function() {
                $("#nav_0").trigger("click")
            });
            $("#tips").bind("start",
            function() {
                var _ = this,
                flash = function() {
                    $(_).find(".t_unit").each(function(index, element) {
                        var $chd = $(this).children(),
                        cur = $chd.index($(this).find(".current"));
                        $chd.eq(1 - cur).css({
                            "z-index": 1
                        }).fadeIn(!$ie8 ? 500 : 0,
                        function() {
                            $(this).css({
                                "z-index": 0
                            }).addClass("current")
                        });
                        $chd.eq(cur).removeClass("current").fadeOut(!$ie8 ? 500 : 0)
                    });
                    $(_).data("timer", setTimeout(flash, 1500))
                };
                $(_).data("timer", setTimeout(flash, 1000)).css({
                    display: "block"
                })
            }).bind("stop",
            function() {
                clearTimeout($(this).data("timer"));
                $(this).css({
                    display: "none"
                })
            });
            $(".B_more").each(function(index, element) {
                var _this = this;
                $(_this).append('<div class="hover"></div><div class="area"></div>');
                $(_this).parent().bind("mouseenter",
                function() {
                    $(_this).find(".hover").stop().animate({
                        width: 83
                    },
                    350, "easeOutExpo")
                }).bind("mouseleave",
                function() {
                    $(_this).find(".hover").stop().animate({
                        width: 0
                    },
                    250, "easeOutQuint")
                })
            });
            $("#main").append('<a href="javascript:;" id="B_search"></a>');
            $("#B_search").bind("click",
            function() {
                $('.ni[anchor="#Foot"]').trigger("click");
                $(".T_search")[0].focus();
                $(".T_search").stop().css({
                    "background": "#00713d"
                }).animate({
                    "backgroundColor": "#eee"
                },
                750, "easeOutBounce")
            });
            $(".B_search").bind("click",
            function() {
                if ( !! $(".T_search").val()) {
                    _.showFeature("搜索", "", $(this).data("url") + $(".T_search").val());
                    $(".T_search").val("")
                }
            });
            $("#B_myjoin").bind("click",
            function() {
                $("#acount_links").children().eq(0).trigger("click").trigger("mouseenter", true)
            });
            $(".B_login").bind("click",
            function() {
                _.Sc("_callback_url", escape(document.location.href), 0.1)
            });
            var _arr = ["nav", "share", "feature", "footLink", "user", "anim", "audio"];
            $.each(_arr,
            function(i, v) {
                $.isFunction(_[v + "Init"]) && _[v + "Init"]()
            });
            _.renderPoint()
        },
        audioInit: function() {
            if ($ie8) {
                return
            }
            var _ = this;
            $("body").append('<audio id="audio_1" class="music" preload loop volume="0.5"><source src="audio/audio.mp3"></source><source src="audio/audio.ogg"></source></audio>');
            var showBtn = function() {
                $("#main").append('<a id="B_audio" href="javascript:;" class="' + (_.Gc("audio_pause") ? "pause": "play") + '"></a>');
                $("#B_audio").bind("click",
                function() {
                    var _class = $(this).hasClass("play") ? "pause": "play";
                    $(this).attr("class", _class);
                    _class == "pause" ? _.Sc("audio_pause", 1) : _.Dc("audio_pause");
                    $("audio").each(function(index, element) {
                        _class == "pause" ? this.pause() : this.play()
                    })
                })
            };
            $("audio").each(function(index, element) {
                this.volume = 0.35;
                $(this).bind("canplay",
                function() {
                    if (!$("#B_audio")[0]) {
                        showBtn()
                    }
                    var _stop = _.Gc("audio_pause"); ! _stop && this.play()
                })
            })
        },
        resizeHandle: function(e) {
            _w = $win.width() < _iw ? _iw: $win.width();
            _h = $win.height() < _ih ? _ih: $win.height();
            $("#main").css({
                width: _w,
                height: _h
            });
            $(".feature").css({
                height: _h
            });
            $(".bscroll").height($win.height()).find("div").height(_all + $win.height()); !! $f.ns && $f.ns.resize();
            $(".view_bg").each(function(index, element) {
                var _bw = $(this).data("width"),
                _bh = $(this).data("height"),
                _s = Math.max(_w / _bw, _h / _bh);
                $(this).css({
                    width: _s * _bw,
                    height: _s * _bh,
                    marginLeft: -(_s * _bw) / 2,
                    marginTop: -(_s * _bh) / 2,
                    left: "50%",
                    top: "50%"
                })
            });
            $(".view_links").width(_w > 1280 ? 1280 : _w).css({
                left: "50%",
                marginLeft: -(_w > 1280 ? 1280 : _w) / 2
            });
            $(".view_h,.view_w").each(function(index, element) {
                if ($(this).hasClass("view_h")) {
                    $(this).height(_h - $(this).data("offset"))
                } else {
                    $(this).width($(this).parent().width() - $(this).data("offset"))
                }
            });
            $(".logo").css({
                left: (_ = (_w - 532) / 2) > 258 ? (_ - 258) / 2 : _ - 258
            });
            $(".B_left").css({
                marginLeft: _w <= 1130 ? -_w / 2 : -565
            });
            $(".B_right").css({
                marginLeft: _w <= 1130 ? _w / 2 - 65 : 500
            })
        },
        stime: 0,
        loading: function() {
            var _ = this;
            if ( !! _.Gc("loaded")) {
                _.loadComplete()
            } else {
                var module = $b.createModuleByS("body", _.loadHandle, _.loadComplete, 3);
                _.animPause(true);
                $b.loadModule(module);
                _.stime = new Date().getTime()
            }
        },
        loadHandle: function(_m) {
            $("#loadbar").css({
                width: Math.round(_m.getLoadProgress() * 100) + "%"
            });
            var time = new Date().getTime();
            if (time - $f.stime > 15000) {
                $("#loadtip").show()
            }
        },
        loadComplete: function(_m) {
            var _ = this;
            $("#load").fadeOut(500,
            function() {
                $(this).remove()
            });
            $f.loaded()
        },
        loaded: function() {
            var _ = this;
            _.Sc("loaded", "true", 0.5);
            _.animPlay(true);
            $("#v0_more").fadeIn();
            _.anchorHandler();
            _.loadedhandle()
        },
        loadedhandle: function() {
            var _ = this;
            var _hasNew = false,
            _newObj = null,
            _curDate = new Date().getTime(),
            _offset = 24 * 60 * 60 * 1000 * 3,
            _newTpl = '<div id="v0_news" href="javascript:;"><a href="javascript:;" class="close"></a><p class="ncont"><span class="tit">{title}</span><span class="text">{text}</span></p></div><a id="v0_tip" href="javascript:;"></a';
            $(".news_content .view_li").each(function(index, element) {
                var _newDate = new Date($(this).find(".news_date").text().replace(/-/g, "/")).getTime();
                if (_curDate - _newDate < _offset) {
                    _hasNew = true;
                    if (!_newObj || (_newObj.date && _newObj.date < _newDate)) {
                        _newObj = {
                            obj: $(this),
                            date: _newDate
                        }
                    }
                }
            });
            if (_hasNew && _newObj) {
                $("#nav_4").data("tip", ".nav_tip").data("tipfunc",
                function() {
                    $("#v0_news").remove();
                    $("#v0_tip").remove()
                }).find(".icon").append('<div class="nav_tip"><div class="bg"></div></div>');
                $(_newTpl.replace("{title}", _newObj.obj.find(".news_title").text()).replace("{text}", _newObj.obj.find(".news_text").text().substr(0, 70) + "...")).appendTo($("#home"));
                $("#v0_news .close").bind("click",
                function() {
                    $("#v0_news").stop().animate({
                        right: -420
                    },
                    500,
                    function() {
                        $("#v0_tip").show()
                    })
                });
                $("#v0_news .ncont").bind("click",
                function() {
                    $("#nav_4").trigger("click")
                });
                $("#v0_tip").bind("click",
                function() {
                    $(this).data("timer") && (clearTimeout($(this).data("timer")), $(this).data("timer", setTimeout(function() {
                        $("#v0_news .close").trigger("click")
                    },
                    5000)));
                    $(this).hide();
                    $("#v0_news").stop().animate({
                        right: 10
                    },
                    750)
                }).data("timer", setTimeout(function() {
                    $("#v0_news .close").trigger("click")
                },
                5000))
            }
            if (_tad && _.isArray(_tad)) {
                var $ads = $('<div class="tnc_ads"></div>').appendTo($("#home"));
                var _tpl = '<a href="{href}" title="{title}" target="_blank" class="tnc_ad"><img src="{src}" width="{width}" height="{height}"></a>';
                for (var i = 0; i < _tad.length; i++) {
                    var img = new Image(),
                    _ad = _tad[i]; (function(_i) {
                        img.onload = function() {
                            _ad.width = this.width,
                            _ad.height = this.height;
                            var $ad = $(_.TPL(_tpl, _ad)).appendTo($ads);
                            setTimeout(function() {
                                $ad.find("img").animate({
                                    opacity: 1
                                },
                                2000)
                            },
                            _i * 1000)
                        }
                    })(i);
                    _ad.src && (img.src = _ad.src)
                }
            }
        },
        renderPoint: function() {
            var _ = this,
            _tpl = '<a href="javascript:;" class="v3_point" style="left:{l}px;top:{t}px" data-t="{t}">{y}</a>';
            var $b = $('<div class="v3_points"></div>').appendTo($("#v3_body"));
            for (var i in _P) {
                var o = _P[i];
                $b.append(_tpl.replace("{l}", o.x).replace(/{t}/g, o.y).replace("{y}", i));
                if (o.r) {
                    $b.children().last().addClass("R")
                }
            }
            _.Ps = $b;
            var $year = $(".v3_year"),
            $text = $(".v3_txt p"),
            _size = $(".v3_point").size(),
            $more = $(".v3_more");
            $(".v3_point").bind("click",
            function() {
                var _y = $(this).text(),
                _i = $(".v3_point").index(this);
                $year.data("index", _i);
                if ( !! $E && !!$E[_y]) {
                    var _t = $E[_y];
                    $year.text(_y);
                    $text.empty();
                    if (!_.isObject(_t)) {
                        $text.append("<span>" + _t + "</span>");
                        $more.hide();
                        $year.data("o", 0)
                    } else {
                        if (!_t.t) {
                            return
                        }
                        var _s = _t.s,
                        _a = _t.t;
                        for (var i = 0; i < _a.length; i++) {
                            $text.append('<span class="' + (_s == i ? "": "hide") + '">' + _a[i] + "</span>")
                        }
                        $more.show();
                        $year.data("o", 1)
                    }
                }
            }).eq(0).trigger("click");
            $(".v3_btn").bind("click",
            function() {
                var _dir = !$(".v3_btn").index(this) ? -1 : 1,
                _cur = $year.data("index"),
                _tar = _cur + _dir < 0 ? _size - 1 : _cur + _dir >= _size ? 0 : _cur + _dir;
                $(".v3_point").eq(_tar).trigger("click")
            });
            $(".v3_txt").bind("mouseenter",
            function() {
                $(this).find(".hide").stop(true, true).css({
                    display: "block"
                }).animate({
                    color: "#5d4809"
                },
                1200);
                $more.hide()
            }).bind("mouseleave",
            function() {
                $(this).find(".hide").stop(true, true).css({
                    color: "#ffd148",
                    display: "none"
                });
                if ( !! $year.data("o")) {
                    $more.show()
                }
            })
        },
        ellipsis: function(_sel, _w, _h, _ell) {
            var _ = this; ! _ell && (_ell = "...");
            $(_sel).each(function(index, element) {
                $temp = $(this).clone(false).css({
                    width: _w,
                    height: "auto",
                    padding: "0px",
                    "font": $(this).css("font"),
                    "text-indent": $(this).css("text-indent"),
                    "letter-spacing": $(this).css("letter-spacing"),
                    "visibility": "hidden"
                }).appendTo(document.body);
                if ($temp.height() > _h) {
                    $temp.text($(this).text() + _ell);
                    $(this).text(_.ellipsisHandle(_h, $temp, _ell, 3))
                }
                $temp.remove()
            })
        },
        ellipsisHandle: function(_h, $t, _ell, _s) {
            var _ = this,
            _s = !!_s ? _s: 5,
            _t = $t.text();
            if ($t.height() > _h) {
                if (_t.length < _s + _ell.length) {
                    return _t
                } else {
                    $t.text(_t.substr(0, _t.length - _ell.length - _s) + _ell);
                    return _.ellipsisHandle(_h, $t, _ell, _s)
                }
            } else {
                return _t
            }
        },
        footLinkInit: function() {
            var _ = this;
            $(".foot_links").each(function(index, element) {
                var arrIndex = [4, 5, 6];
                var $links = $(this).find(".foot_link"),
                $cursor = $(this).parents(".view_foot").find(".foot_cursor");
                $links.eq(0).addClass("current");
                $links.append('<img src="img/visible.gif">');
                var _s = $links.size(),
                _d = 186,
                _o = -31,
                _w = (_s - 1) * _d;
                var _timer = null;
                $links.bind("mouseenter",
                function(e, f) {
                    if (!$(this).hasClass("current") || f) {
                        var _t = $links.index(this);
                        $cursor.stop().animate({
                            height: 0
                        },
                        250,
                        function() {
                            $(this).stop().css({
                                marginLeft: _t * _d - (_w / 2) + _o
                            }).animate({
                                height: 32
                            },
                            250)
                        })
                    }
                }).bind("mouseleave",
                function(e) {
                    if (!$(this).hasClass("current")) {
                        var _t = $links.index($links.filter(".current"));
                        $cursor.stop().animate({
                            height: 0
                        },
                        250,
                        function() {
                            $(this).stop().css({
                                marginLeft: _t * _d - (_w / 2) + _o
                            }).animate({
                                height: 32
                            },
                            250)
                        })
                    }
                }).bind("click",
                function(_e, _f) {
                    var $par = $(this).parent(),
                    _id = $par.attr("id");
                    if ($(this).hasClass("current") || !!_CLICK[_id]) {
                        return
                    }
                    var t = $links.index(this),
                    f = $links.index($links.filter(".current"));
                    _CLICK[_id] = 1;
                    _.slideRender($par.parents(".view").find(".view_content"), f, t, $f.navCur != arrIndex[index] ? 0 : 750, _f,
                    function() {
                        _CLICK[_id] = 0
                    });
                    $links.removeClass("current");
                    $(this).addClass("current");
                    if ($(_._Links[_id]).hasClass("current")) {
                        var $$ = $(_._Links[_id]);
                        var anc = (_anc = $$.find("dd").eq(t).attr("anchor")) ? _anc: "";
                        window.location.hash = !!$$.attr("anchor") ? $$.attr("anchor") + anc: "";
                        _tPage("/" + ( !! $$.attr("anchor") ? $$.attr("anchor") + anc: ""))
                    }
                }).eq(0).trigger("mouseenter", true)
            });
            var _CLICK = {
                "news_links": 0,
                "interactive_links": 0,
                "acount_links": 0
            };
            $(".view_a").live("mouseenter",
            function(e) {
                $(this).addClass("hover");
                $(".view_text", this).stop(true, true).fadeIn(150)
            }).live("mouseleave",
            function(e) {
                $(this).removeClass("hover");
                $(".view_text", this).stop(true, true).fadeOut(150)
            });
            $('.view_content:not(".static")').each(function(index, e) {
                var $list = $(".view_list", this),
                $btn = $(".view_btn", this),
                $load = $(".B_loading", this),
                url = _TPL_0[index].url,
                tpl = _TPL_0[index].tpl,
                __page = 1,
                __hasnext = $list.attr("hasnext") === undefined ? false: true,
                _cur = 0,
                _all = $list.children().size(),
                _CLICK = {
                    f: 0
                };
                if (!__hasnext && $list.children(".view_ul").size() == 1) {
                    $btn.eq(1).css({
                        display: "none"
                    })
                }
                $btn.bind("click",
                function(e) {
                    if ( !! _CLICK.f) {
                        return
                    }
                    var _dir = !$btn.index(this) ? -1 : 1,
                    _cur = $list.children(".view_ul").index($list.find(".view_ul.current"));
                    if (_dir + _cur >= 0 && _dir + _cur < _all) {
                        _CLICK.f = 1;
                        _.dirSlide($list.children(".view_ul"), _dir,
                        function() {
                            _CLICK.f = 0
                        });
                        $btn.eq(0).css({
                            display: _dir + _cur == 0 ? "none": "block"
                        });
                        $btn.eq(1).css({
                            display: _dir + _cur == _all - 1 && !__hasnext ? "none": "block"
                        })
                    } else {
                        if (_dir > 0 && __hasnext) {
                            _CLICK.f = 1;
                            $load.show();
                            _.ax(url, {
                                page: ++__page,
                                rows: 12
                            },
                            function(json) {
                                if (json.ret == 0) {
                                    var _arr = json.data;
                                    for (var i = 0; i < Math.ceil(_arr.length / 4); i++) {
                                        var $ul = $('<ul class="view_ul"></ul>');
                                        for (var k = i * 4; k < ((i + 1) * 4 > _arr.length ? _arr.length: (i + 1) * 4); k++) {
                                            $ul.append(_.TPL(tpl, _arr[k]))
                                        }
                                        $ul.appendTo($list);
                                        ellipsis($ul)
                                    }
                                    _all = $list.children().size();
                                    _.dirSlide($list.children(".view_ul"), _dir,
                                    function() {
                                        _CLICK.f = 0
                                    })
                                } else {
                                    _CLICK.f = 0
                                }
                                $load.hide();
                                __hasnext = json.hasnext;
                                if (!__hasnext) {
                                    $btn.eq(1).hide()
                                }
                                if (_all > 1) {
                                    $btn.eq(0).show()
                                }
                            },
                            function() {
                                _CLICK.f = 0;
                                $load.hide();
                                __hasnext = false;
                                $btn.eq(1).hide()
                            },
                            "GET")
                        }
                    }
                }).eq(0).css({
                    display: "none"
                })
            });
            ellipsis = function($tar) {
                _.ellipsis($(".view_text p", !!$tar ? $tar: "body"), 194, 132);
                _.ellipsis($(".active_txt p", !!$tar ? $tar: "body"), 214, 152);
                _.ellipsis($(".mytnc_p", !!$tar ? $tar: "body"), 214, 145)
            };
            ellipsis();
            $(".foot_btn").bind("click",
            function() {
                var to = $(this).data("to");
                $('.nav li[anchor="' + to + '"],.nav dd[anchor="' + to + '"]').trigger("click")
            })
        },
        ax: function(tar, option, call, error, type, noCache) {
            $.ajax({
                url: _URL[tar][$t ? 0 : 1],
                data: option,
                type: !type ? "POST": type,
                dataType: "json",
                success: call,
                error: error,
                cache: !noCache ? true: false
            })
        },
        userInit: function() {
            $(".user_logout").bind("click",
            function() {
                $f.ax("logout", {},
                function() {},
                function() {});
                $(".user_ul").hide();
                $(".user_login").fadeIn(300)
            });
            this.updateUser = function(data) {
                if ( !! data) {
                    data.area && $(".user_area").text(data.area);
                    data.sexy && $(".user_sexy").text(data.sexy);
                    data.birthday && $(".user_birthday").text(data.birthday);
                    data.email && $(".user_email").text(data.email);
                    data.nick && $(".user_name").text(data.nick).attr("title", data.nick)
                }
            }
        },
        featureInit: function() {
            var _ = this,
            $fea = $("#feature");
            $(".fea_ul a").bind("mouseenter",
            function() {
                $(this).stop().animate({
                    width: 120
                },
                500, "easeOutExpo").find("span").stop(true, true).show()
            }).bind("mouseleave",
            function() {
                if (!$(this).hasClass("current")) {
                    $(this).stop().animate({
                        width: 60
                    },
                    350, "easeOutExpo").find("span").stop(true, true).hide()
                }
            }).bind("click",
            function() {
                if ($(this).hasClass("current")) {
                    return
                }
                var $links = $(this).parents(".fea_ul").find("a"),
                _c = $links.index($links.filter(".current")),
                _t = $links.index(this);
                $links.eq(_c).removeClass("current").trigger("mouseleave");
                $links.eq(_t).addClass("current");
                _.renderFea($fea, _IFRAME[$(this).data("pro")])
            }).filter(".current").css("width", 120);
            $(".feature").bind("show",
            function(e, ul) {
                _.animPause(1);
                $(".fea_mask").show();
                var css = {
                    left: "35%",
                    marginLeft: -60
                }; ! $ie8 && (css.opacity = 1);
                $(this).stop().show().animate(css, 750, "easeOutQuint",
                function() { !! ul && $(ul, this).stop().animate({
                        left: -10
                    },
                    500)
                }); !! ul && $(ul, this).css({
                    left: 150
                })
            }).bind("hide",
            function(e) {
                $(".fea_mask").hide();
                var css = {
                    left: "100%",
                    marginLeft: 120
                }; ! $ie8 && (css.opacity = 0);
                $(this).stop().animate(css, 750, "easeOutQuint",
                function() {
                    $(this).hide();
                    $(".fea_mask").hide();
                    _.animPlay(1);
                    $(this).find("iframe").attr("src", "about:blank");
                    $(".fea_ul", this).css({
                        left: 150
                    });
                    if (_._TOP_HASH != undefined) {
                        if (_._TOP_HASH.indexOf("#iframe") > -1) {
                            _._TOP_HASH = _._TOP_HASH.substring(0, _._TOP_HASH.indexOf("#iframe"))
                        }
                        document.location.hash = _._TOP_HASH;
                        _._TOP_HASH = ""
                    }
                })
            });
            $(".fea_btn").bind("click",
            function() {
                var _cfg = _IFRAME[$(this).data("pro")];
                _.renderFea($fea, _cfg);
                $fea.trigger("show", _cfg.ul);
                var _tar = $(this).parent().find(".fea_btn").index(this);
                $fea.find(_cfg.ul + " a").eq(_tar).trigger("mouseenter").trigger("click")
            });
            $(".view_a").live("click",
            function() {
                var pro = _IFRAME[$(this).parents(".view_list").data("pro")];
                pro.sec = $(this).attr("title");
                pro.link = $(this).data("url");
                _.renderFea($fea, pro);
                $fea.trigger("show")
            });
            $(".fea_close").bind("click",
            function() {
                _.iframeCloseFea();
                if ( !! MAP_CLICK.f) {
                    TweenLite.to($("#v2_body"), 0.75, {
                        css: {
                            scale: 1,
                            x: 0,
                            y: 0
                        },
                        ease: Expo.easeOut,
                        onComplete: function() {
                            MAP_CLICK.f = 0;
                            $(".map_btn .v2_text").eq(MAP_CLICK.t).trigger("mouseleave")
                        }
                    })
                }
            });
            $(".fea_mask").bind("click",
            function() {
                _.iframeCloseFea()
            });
            var MAP_CLICK = {
                f: 0,
                t: 0
            };
            $(".map_div").append('<img src="img/visible.gif">');
            $(".map_btn").bind("click",
            function() {
                if (!$ie8) {
                    if ( !! MAP_CLICK.f) {
                        return
                    }
                    MAP_CLICK.f = 1;
                    var _this = this,
                    _tar = $(this).parent().find(".map_btn").index(this);
                    var _x = $(".map_div").eq(_tar).data("x"),
                    _y = $(".map_div").eq(_tar).data("y");
                    MAP_CLICK.t = _tar;
                    TweenLite.to($("#v2_body"), 1.5, {
                        css: {
                            scale: 1.5,
                            x: _x,
                            y: _y
                        },
                        ease: Quint.easeInOut,
                        onComplete: function() {
                            var _cfg = _IFRAME[$(_this).data("pro")];
                            _.renderFea($fea, _cfg);
                            $fea.trigger("show", _cfg.ul);
                            $fea.find(_cfg.ul + " a").eq(_tar).trigger("mouseenter").trigger("click")
                        }
                    })
                } else {
                    var _cfg = _IFRAME[$(this).data("pro")];
                    _.renderFea($fea, _cfg);
                    $fea.trigger("show", _cfg.ul);
                    var _tar = $(this).parent().find(".map_btn").index(this);
                    $fea.find(_cfg.ul + " a").eq(_tar).trigger("mouseenter").trigger("click")
                }
            });
            TweenMax.set($(".map_btn"), {
                css: {
                    perspective: 200
                }
            });
            $(".map_btn").bind("mouseenter",
            function() {
                var _this = $(this),
                _tar = $(_this).parent().find(".map_btn").index(_this),
                $div = $(".map_div").eq(_tar);
                if (!MAP_CLICK.f) {
                    TweenLite.to($(_this).children(".circle"), 0.65, {
                        css: {
                            scale: 0,
                            opacity: 0
                        }
                    }); ! $ie6 && TweenLite.to($div, 0.75, {
                        css: {
                            opacity: 1
                        }
                    }) || $div.show()
                }
            }).bind("mouseleave",
            function() {
                var _this = $(this),
                _tar = $(_this).parent().find(".map_btn").index(_this),
                $div = $(".map_div").eq(_tar);
                if (!MAP_CLICK.f) {
                    TweenLite.to($(_this).children(".circle"), 0.65, {
                        css: {
                            scale: 1,
                            opacity: 1
                        }
                    }); ! $ie6 && TweenLite.to($div, 0.75, {
                        css: {
                            opacity: 0
                        }
                    }) || $div.hide()
                }
            })
        },
        showFeature: function(view, sec, _link) {
            var _ = this;
            _.renderFea($("#feature"), {
                view: view,
                sec: sec,
                link: _link
            },
            500);
            $(".feature").trigger("show")
        },
        iframeRenderFea: function(view, sec, _link) {
            var _ = this;
            _.renderFea($("#feature"), {
                view: view,
                sec: sec,
                link: _link
            },
            0);
            return false
        },
        iframeCloseFea: function() {
            var _ = this;
            $("#feature").trigger("hide")
        },
        iframeRenderHead: function(view, sec) { !! view && $(".fea_view").show().find("span").text(view) || $(".fea_view").hide().find("span").text(""); !! sec && $(".fea_sec").show().find("span").text(sec) || $(".fea_sec").hide().find("span").text("")
        },
        iframeURL: function() {
            return escape(window.location.href + "#iframe" + ( !! (_view = $(".fea_view").text()) ? "^view->" + _view: "") + ( !! (_sec = $(".fea_sec").text()) ? "^sec->" + _sec: "") + "^link->" + $(".fea_body iframe").attr("src"))
        },
        _TOP_HASH: "",
        renderFea: function($tar, pro, t) {
            var _ = this;
            t === undefined && (t = 500);
            _.isObject(pro) && _.iframeRenderHead(pro.view, pro.sec);
            _._TOP_HASH = document.location.hash;
            setTimeout(function() {
                $tar.find("iframe").attr("src", pro.link)
            },
            t)
        },
        renderFeaQuick: function($tar, href, t) {
            var _ = this;
            t === undefined && (t = 500);
            _._TOP_HASH = document.location.hash;
            setTimeout(function() {
                $tar.find("iframe").attr("src", href)
            },
            t)
        },
        shareInit: function() {
            var link = "http://tnc.org.cn",
            title = "大自然保护协会（TNC）",
            content = "TNC（The Nature Conservancy  大自然保护协会）成立于1951年，是国际上最大的非营利性的自然环境保护组织之一。一直致力于在全球保护具有重要生态价值的陆地和水域，维护自然环境、提升人类福祉。";
            $(".s_sina").bind("click",
            function() {
                window.open("http://v.t.sina.com.cn/share/share.php?appkey=&url=" + encodeURIComponent(link) + "&title=" + encodeURIComponent(content), "_blank", "scrollbars=no,width=600,height=450,left=75,top=20,status=no,resizable=yes")
            });
            $(".s_qq").bind("click",
            function() {
                window.open("http://share.v.t.qq.com/index.php?c=share&a=index&url=" + encodeURIComponent(link) + "&title=" + encodeURIComponent(content), "_blank", "scrollbars=no,width=600,height=450,left=75,top=20,status=no,resizable=yes")
            });
            $(".s_douban").bind("click",
            function() {
                window.open("http://shuo.douban.com/!service/share?href=" + encodeURIComponent(link) + "&text=" + encodeURIComponent(content) + "&name=" + encodeURIComponent(title), "_blank", "scrollbars=no,width=600,height=450,left=75,top=20,status=no,resizable=yes")
            })
        },
        navInit: function() {
            TweenMax.set($(".nav_sub dl"), {
                css: {
                    perspective: 200
                }
            });
            var _ = this,
            navTimer = null,
            navUpdate = function() {
                $(".nav_li.current").addClass("hover"); ! $ie8 && $(".nav_li.current").find(".nav_sub").stop().show().animate({
                    height: 124,
                    opacity: 1
                },
                500, "easeOutQuint",
                function() {
                    $(this).addClass("toggle");
                    $(this).css({
                        overflow: "visible"
                    })
                }) || $(".nav_li.current").find(".nav_sub").stop().show().css({
                    height: 124,
                    overflow: "visible"
                }).addClass("toggle")
            };
            $(".nav_li").each(function(index, element) {
                if ($(this).find(".nav_sub").get(0)) {
                    var tm = new TimelineMax({
                        repeat: 0
                    }),
                    $dl = $("dl", this),
                    $dd = $("dd", this);
                    $(this).find(".nav_sub .text").append('<div class="hover" style="height:' + $dd.size() * 36 + 'px"></div>');
                    if ($ie8) {
                        tm.to($dl, $dd.size() * 0.1, {
                            css: {
                                height: $dd.size() * 36
                            }
                        })
                    }
                    if ($ie9) {
                        tm.to($dl, $dd.size() * 0.1, {
                            css: {
                                height: $dd.size() * 36,
                                opacity: 1
                            }
                        })
                    } else {
                        TweenMax.set($dl, {
                            css: {
                                height: 36,
                                opacity: 1,
                                overflow: "visible",
                                "boxShadow": "none"
                            }
                        });
                        TweenMax.set($dd, {
                            css: {
                                transformOrigin: "50% -10%",
                                "boxShadow": "2px 2px 4px rgba(0,0,0,0.35)"
                            }
                        });
                        tm.staggerFrom($dd, 0.1, {
                            css: {
                                rotationX: -90,
                                opacity: 0
                            }
                        },
                        0.11)
                    }
                    tm.reverse(0);
                    $(this).data("tm", tm)
                }
                $(this).bind("mouseenter",
                function(e, flag) {
                    $(this).find(".hover").css({
                        display: "block"
                    });
                    clearTimeout(navTimer);
                    if (!$(this).hasClass("current")) {
                        var $cur = $(".nav_li").filter(".current.hover");
                        if ($cur.get(0)) {
                            $cur.removeClass("hover"); ! $ie8 && $(".nav_sub", $cur).stop().animate({
                                height: 0,
                                opacity: 0
                            },
                            300, "easeInOutQuint",
                            function() {
                                $(this).hide().removeClass("toggle")
                            }) || $(".nav_sub", $cur).hide();
                            $("dl", $cur).stop().removeClass("active").hide();
                            $cur.trigger("close")
                        }
                        var $sub = $(".nav_sub", this),
                        $dl = $("dl", this),
                        $dd = $("dd", $dl);
                        $(this).addClass("hover");
                        var _h = 124; ! $ie8 && $sub.stop().show().animate({
                            height: _h,
                            opacity: 1
                        },
                        300, "easeOutQuint",
                        function() {
                            $sub.css({
                                overflow: "visible"
                            }).addClass("toggle");
                            if (!flag) {
                                $dl.stop().addClass("active").show();
                                $(this).trigger("open")
                            }
                        }) || ($sub.stop().show().css({
                            height: _h,
                            overflow: "visible"
                        }).addClass("toggle") && !flag && $dl.stop().addClass("active").show() && $sub.trigger("open"))
                    } else {
                        var $sub = $(".nav_sub", this),
                        $dl = $("dl", this),
                        $dd = $("dd", $dl);
                        $(this).addClass("hover");
                        var _h = 124; ! $ie8 && $sub.stop().show().animate({
                            height: _h,
                            opacity: 1
                        },
                        $sub.hasClass("toggle") ? 0 : 300, "easeOutQuint",
                        function() {
                            $(this).addClass("toggle").css({
                                overflow: "visible"
                            });
                            if (!flag) {
                                $dl.stop().addClass("active").show();
                                $(this).trigger("open")
                            }
                        }) || ($sub.stop().show().css({
                            height: _h,
                            overflow: "visible"
                        }) && !flag && $dl.stop().addClass("active").show() && $sub.trigger("open"))
                    }
                }).bind("mouseleave",
                function(e, flag) {
                    var $sub = $(".nav_sub", this),
                    $dl = $("dl", this),
                    $dd = $("dd", $dl);
                    $(this).find(".hover").css({
                        display: "none"
                    });
                    if (!$(this).hasClass("current")) {
                        $(this).removeClass("current"); ! $ie8 && $sub.stop().animate({
                            height: 0,
                            opacity: 0
                        },
                        300, "easeInOutQuint",
                        function() {
                            $(this).hide().removeClass("toggle")
                        }) || $sub.stop().hide();
                        $dl.stop().removeClass("active").hide();
                        $(this).trigger("close");
                        navTimer = setTimeout(navUpdate, 30)
                    } else {
                        $dl.stop().removeClass("active").hide();
                        $(this).trigger("close")
                    }
                }).bind("open",
                function() {
                    $(this).data("tm") && $(this).data("tm").restart()
                }).bind("close",
                function() {
                    $(this).data("tm") && $(this).data("tm").reverse(0)
                }).bind("click",
                function(e, i) {
                    if ($(this).hasClass("ni")) {
                        _.animGoto($(this).data("pos"), true)
                    } else { !! $("dd", this).get(0) && _.animGoto($("dd", this).eq(0).data("pos"), true)
                    }
                    $(this).trigger("mouseleave")
                }).find("dd").bind("click",
                function(e) {
                    e.preventDefault();
                    e.stopPropagation();
                    if (!$(this).hasClass("ni")) {
                        var $par = $(this).parents(".nav_li"),
                        _id = $par.attr("id"),
                        $dds = $(this).parent().find("dd"),
                        _tar = $dds.index(this);
                        if (_id && _._Links[_id]) {
                            var $link = $(_._Links[_id]).find(".foot_link").eq(_tar);
                            if (!$link.hasClass("current")) {
                                $link.trigger("click").trigger("mouseenter", true)
                            }
                        }
                        _.animGoto($par.data("pos"), true)
                    } else {
                        _.animGoto($(this).data("pos"), true)
                    }
                    $(this).parents(".nav_li").trigger("mouseleave")
                });
                $(".nav_sub dd a").bind("click",
                function() {
                    window.location.href = $(this).attr("href")
                })
            });
            $(".ni").each(function(i, e) {
                _.navPos.push($(this).data("pos"))
            });
            $(".RNav li").bind("mouseenter",
            function() {
                $(".nav_sub", this).stop().show();
                var _h = $(".nav_sub .text", this).height() + 88;
                log(_h);
                $(".nav_sub", this).animate({
                    height: _h,
                    opacity: 1
                },
                500, "easeOutQuint");
                $("dl", this).stop().show().animate({
                    height: 248,
                    opacity: 1
                },
                500, "easeOutQuint")
            }).bind("mouseleave",
            function() {
                $(".nav_sub", this).stop().animate({
                    height: 0,
                    opacity: 0
                },
                500, "easeInOutQuint",
                function() {
                    $(this).hide()
                });
                $("dl", this).stop().animate({
                    height: 0,
                    opacity: 0
                },
                500, "easeOutQuint",
                function() {
                    $(this).hide()
                })
            })
        },
        _Links: {
            "nav_4": "#news_links",
            "nav_5": "#interactive_links",
            "nav_6": "#acount_links",
            "news_links": "#nav_4",
            "interactive_links": "#nav_5",
            "acount_links": "#nav_6"
        },
        navPos: [],
        $ni: $(".ni"),
        $nav: $(".nav_li"),
        navCur: 0,
        navRender: function(_cur) {
            var _ = this;
            var _c = _.getIndex(_cur),
            $$ = _.$ni.eq(_c);
            if (_.$ni.eq(_c).hasClass("nav_li")) {
                var __c = _.$nav.index($$);
                if ($$.data("tip")) {
                    var _tip = $$.data("tip"),
                    _func = $$.data("tipfunc");
                    $$.removeData("tip").find(_tip).fadeOut(1000,
                    function() {
                        $(this).remove()
                    });
                    _func && $.isFunction(_func) && _func()
                }
                if (__c != _.navCur) {
                    _.$nav.eq(__c).addClass("current");
                    _.$nav.eq(_.navCur).removeClass("current").trigger("mouseleave").find("dd").removeClass("current");
                    _.navCur = __c;
                    if ( !! _._Links[$$.attr("id")]) {
                        var $cld = $(_._Links[$$.attr("id")]).find(".foot_link"),
                        _i = $cld.index($cld.filter(".current")),
                        anc = (_anc = $$.find("dd").eq(_i).attr("anchor")) ? _anc: "";
                        window.location.hash = !!$$.attr("anchor") ? $$.attr("anchor") + anc: "";
                        _tPage("/" + ( !! $$.attr("anchor") ? $$.attr("anchor") + anc: ""))
                    } else {
                        window.location.hash = !!$$.attr("anchor") ? $$.attr("anchor") : "";
                        _tPage("/" + ( !! $$.attr("anchor") ? $$.attr("anchor") : ""))
                    }
                }
            } else {
                var __c = _.$nav.index($$.parents(".nav_li"));
                if (__c != _.navCur) {
                    _.$nav.eq(__c).addClass("current");
                    _.$nav.eq(_.navCur).removeClass("current").trigger("mouseleave").find("dd").removeClass("current");
                    _.navCur = __c;
                    window.location.hash = $$.parents(".nav_li").attr("anchor") + $$.attr("anchor");
                    _tPage("/" + $$.parents(".nav_li").attr("anchor") + $$.attr("anchor"))
                }
                if (!$$.hasClass("current")) {
                    $$.parent().children().removeClass("current");
                    $$.addClass("current");
                    window.location.hash = $$.parents(".nav_li").attr("anchor") + $$.attr("anchor");
                    _tPage("/" + $$.parents(".nav_li").attr("anchor") + $$.attr("anchor"))
                }
            }
        },
        anchorHandler: function() {
            var _ = this;
            if (_.Gc("_callback_url")) {
                var href = unescape(_.Gc("_callback_url"));
                _.Dc("_callback_url");
                window.location.href = href
            }
            var _hash = window.location.hash,
            _arr = [],
            _if,
            _ifObj = {},
            _ihref;
            if (/^#.+$/.test(_hash)) {
                _arr = _hash.replace("#", "").split("#");
                var _i = _.findArrIndex(_arr, /^iframe.+$/);
                if (_i > -1) {
                    _if = _arr.splice(_i, 1);
                    _if = _if[0].split("^");
                    if (_if.length > 1) {
                        for (var i = 1; i < _if.length; i++) {
                            var __a = _if[i].split("->");
                            _ifObj[__a[0]] = __a[1]
                        }
                    } else {
                        _ihref = _.decrypt(_if[0].replace("iframe", ""), "tnc.org.cn");
                        if (_ihref.indexOf(document.location.host) == -1) {
                            _ihref = ""
                        }
                    }
                } ! _arr[0] && (_arr[0] = "Home");
                var $li = $('.nav_li[anchor="#' + _arr[0] + '"]'),
                $dd,
                _pos;
                if (!$li.get(0)) {
                    return
                }
                if (_arr.length > 1 && !!_arr[1]) {
                    $dd = $li.find('dd[anchor="#' + _arr[1] + '"]')
                }
                if ($li.hasClass("ni")) {
                    _pos = $li.data("pos");
                    _.animGoto(_pos, true);
                    if (_arr.length > 1 && $dd.get(0)) {
                        $dd.trigger("click")
                    }
                } else {
                    _pos = _arr.length > 1 && $dd.get(0) ? $dd.data("pos") : $li.find("dd").eq(0).data("pos");
                    _.animGoto(_pos, true)
                }
                if ( !! _ihref) {
                    var $fea = $("#feature");
                    _.renderFeaQuick($fea, _ihref);
                    $fea.trigger("show")
                } else {
                    if ( !! _ifObj.link) {
                        var $fea = $("#feature");
                        _.renderFea($fea, _ifObj);
                        $fea.trigger("show")
                    }
                }
            } else {
                _.animGoto(0, true)
            }
        },
        navOfs: 200,
        getIndex: function(_cur) {
            var _ = this;
            for (var i = 0; i < _.navPos.length; i++) {
                if (_cur + _.navOfs < _.navPos[i]) {
                    return i - 1 < 0 ? 0 : i - 1
                }
            }
            return _.navPos.length - 1
        },
        getIndexForAds: function(_cur, _ofs) {
            var _ = this;
            for (var i = 0; i < _.navPos.length; i++) {
                if (_cur == _.navPos[i]) {
                    return undefined
                } else {
                    if (_cur < _.navPos[i] + _ofs && _cur > _.navPos[i] - _ofs) {
                        return _.navPos[i]
                    }
                }
            }
            return undefined
        },
        navFlag: false,
        hideNav: function() {
            $(".menu").stop().animate({
                top: -150
            },
            500, "easeOutQuint")
        },
        showNav: function() {
            if (!this.canMove) {
                return
            }
            $(".menu").stop().animate({
                top: 0
            },
            500)
        },
        animateLoop: function(__) {
            var _ = $f;
            if (__ === true) {
                return
            }
            _.animState = true;
            _.aid = requestAnimationFrame(_.animateLoop);
            if (!_.navFlag) {
                _.navFlag = true;
                _.hideNav()
            }
            var _tar = _.animTop();
            if (Math.round(_cur * 1000) != Math.floor(_tar * 1000)) {
                var temp = _cur;
                var deaccelerate = Math.max(Math.min(Math.abs(_tar - _cur) * 2, 10), 2);
                _cur = _cur + (_tar - _cur) / deaccelerate;
                _.Aom.render(_cur);
                _.navRender(_cur)
            } else {
                cancelAnimationFrame(_.aid);
                if ( !! _.navFlag) {
                    _.navFlag = false;
                    _.showNav();
                    _.adsCall(0)
                }
                _.animState = false;
                if (_cur != _tar) {
                    _cur = _tar;
                    _.Aom.render(_cur);
                    _.navRender(_cur)
                }
            }
        },
        adsTimer: null,
        adsState: false,
        adsOffset: 181,
        adsCall: function(t) {
            var self = this;
            if ( !! self.adsTimer) {
                clearTimeout(self.adsTimer)
            }
            self.adsTimer = setTimeout(function() {
                self.doAdsorption()
            },
            t)
        },
        doAdsorption: function() {
            var _ = this,
            _adsPos = _.getIndexForAds(_cur, _.adsOffset);
            if (_adsPos == undefined) {
                return
            }
            _.ns.setScrollTop(_adsPos)
        },
        animState: false,
        aid: null,
        ns: null,
        canMove: true,
        animPause: function(f) {
            var _ = this;
            _.canMove = false;
            _.ns.locked = true;
            _.ns.hide(); !! f && _.hideNav()
        },
        animPlay: function(f) {
            var _ = this;
            _.canMove = true;
            _.ns.locked = false;
            _.ns.show(); !! f && _.showNav()
        },
        animUpdate: function() {
            var _ = this;
            _.ns.locked = !_.canMove
        },
        animTop: function() {
            return this.ns.scrollTop()
        },
        animGoto: function(pos, imd) {
            var _ = this;
            if (!imd) {
                _.ns.doScrollTop(pos)
            } else {
                _.animState = true;
                _cur = pos;
                _.ns.setScrollTop(pos);
                _.Aom.render(pos, true);
                _.navRender(pos);
                _.animState = false
            }
        },
        animInit: function() {
            var _o = function(_p) {
                return _new(_ao, _p)
            },
            _ = this,
            _pos = function() {
                var args = [],
                vals;
                for (var i = 0; i < arguments.length; args[i] = arguments[i], i++) {}
                var prop = args[0];
                var _arr = [],
                _obj = {};
                for (var i = 0; i < prop.length; _obj[prop[i]] = i, i++) {}
                if ( !! args[1] && _.isObject(args[1])) {
                    for (var i in args[1]) {
                        vals = args[1][i]
                    }
                } else {
                    vals = args.splice(1, args.length)
                }
                for (var i = 0; i < vals.length; i++) {
                    var __pos = {};
                    __pos.start = $.extend({},
                    _obj);
                    for (var k in __pos.start) {
                        __pos.start[k] = vals[i][0][__pos.start[k]]
                    }
                    __pos.end = $.extend({},
                    _obj);
                    for (var k in __pos.end) {
                        __pos.end[k] = vals[i][1][__pos.end[k]]
                    }
                    __pos.step = vals[i][2] || 100;
                    _arr[i] = __pos
                }
                return _arr
            },
            _alia = function(str) {
                var data = {
                    w: "width",
                    h: "height",
                    l: "left",
                    t: "top",
                    r: "right",
                    b: "bottom",
                    o: "opacity",
                    mt: "margin-top",
                    mb: "margin-bottom",
                    ml: "margin-left",
                    mr: "margin-right",
                    pt: "padding-top",
                    pb: "padding-bottom",
                    pl: "padding-left",
                    pr: "padding-right",
                    m: "margin",
                    p: "padding",
                    bY: "backgroundPositionY",
                    bX: "backgroundPositionX"
                };
                return data[str] ? data[str] : str
            },
            renderObj = function(id, _s, _d, a, b, c, p, ps, pe, pm, sta, ani) {
                ps = _.arraySuffix(ps, "%");
                pe = _.arraySuffix(pe, "%");
                pm = _.arraySuffix(pm, "%");
                var _startPos = {},
                _endPos = {};
                for (var i = 0; i < p.length; p[i] = _alia(p[i]), _startPos[p[i]] = ps[i], _endPos[p[i]] = pe[i], i++) {}
                return {
                    id: id,
                    start: _s,
                    end: _s + _d,
                    isStatic: !sta ? false: true,
                    isAnim: !ani ? false: true,
                    step: a + b + c,
                    animStart: _s + 10,
                    animEnd: _s + _d - 10,
                    startPos: _startPos,
                    endPos: _endPos,
                    posArr: !!b ? _pos(p, [ps, pm, a], [pm, pm, b], [pm, pe, c]) : _pos(p, [ps, pe, a + c])
                }
            },
            spliceObj = function(a, b) {
                var arr = [];
                for (var i = 0; i < a.length; arr[i] = [b[i], b[i + 1], a[i]], i++) {}
                return arr
            },
            addArr = function(a) {
                var v = 0;
                for (var i = 0; i < a.length; v += a[i], i++) {}
                return v
            },
            sRenderObj = function(id, _s, _d, p, dua, pos, sta, fix) {
                for (var i = 0; i < pos.length; pos[i] = _.arraySuffix(pos[i], "%"), i++) {}
                var _startPos = {},
                _endPos = {},
                ps = pos[0],
                pe = pos[pos.length - 1];
                for (var i = 0; i < p.length; p[i] = _alia(p[i]), _startPos[p[i]] = ps[i], _endPos[p[i]] = pe[i], i++) {} ! fix && (fix = 0);
                return {
                    id: id,
                    start: _s - fix,
                    end: _s + _d + fix,
                    isStatic: !sta ? false: true,
                    step: addArr(dua),
                    animStart: _s + 10,
                    animEnd: _s + _d - 10,
                    startPos: _startPos,
                    endPos: _endPos,
                    posArr: _pos(p, {
                        arr: spliceObj(dua, pos)
                    })
                }
            },
            mergeObj = function(a, b) {
                return $.extend({},
                a, b)
            },
            _co = function(obj) {
                return _o(obj)
            },
            pageObj = function(id, _s, _d, a, b, c, p, ps, pe, pm) {
                return _co(renderObj(id, _s, _d, a, b, c, p, ps, pe, pm))
            },
            elemObj = function(id, _s, _d, a, b, c, p, ps, pe, pm, sta, ani) {
                var o = renderObj(id, _s, _d, a, b, c, p, ps, pe, pm, sta, ani);
                return _co(o)
            },
            speObj = function(id, _s, _d, p, dua, pos, sta, fix, _merge) {
                return _co(mergeObj(sRenderObj(id, _s, _d, p, dua, pos, sta, fix), _merge))
            },
            staObj = function(id, _s, _d, oShow, oHide) {
                return _co({
                    id: id,
                    start: _s,
                    end: _s + _d,
                    isStatic: true,
                    oShow: oShow,
                    oHide: oHide
                })
            },
            pos = 0;
            var pointShow = function() {
                var $self = this.elem;
                $self.stop(true, true).show().animate({
                    opacity: 1,
                    marginTop: -33
                },
                500,
                function() {});
                TweenMax.staggerTo(_.shuffleArray($(".circle", $self).toArray()), 0.3, {
                    css: {
                        scale: 1
                    }
                },
                0.08)
            },
            pointHide = function() {
                var $self = this.elem;
                TweenMax.staggerTo(_.shuffleArray($(".circle", $self).toArray()), 0.3, {
                    css: {
                        scale: 0
                    }
                },
                0.08);
                $self.stop().animate({
                    opacity: 0,
                    marginTop: -17
                },
                600,
                function() {
                    $(this).css("marginTop", -17).hide()
                })
            };
            _.Aom = _new(_am, {
                arr: [elemObj("home", pos, 520, 255, 0, 255, ["t"], [0], [ - 50], [ - 50], false, true), _o({
                    id: "v0_logo",
                    start: 0,
                    end: 370,
                    isStatic: true,
                    step: 100,
                    animStart: 130,
                    animEnd: 360,
                    startPos: {
                        opacity: 1
                    },
                    endPos: {
                        opacity: 0
                    },
                    posArr: _pos(["opacity"], [[1], [0], 100])
                }), _o({
                    id: "v0_text",
                    start: 0,
                    end: 470,
                    isStatic: true,
                    animStart: 230,
                    animEnd: 450,
                    startPos: {
                        opacity: 1
                    },
                    endPos: {
                        opacity: 0
                    },
                    posArr: _pos(["opacity"], [[1], [0]])
                }), staObj("logo", pos - 100, 520,
                function() {
                    $(this.elem).fadeOut(500)
                },
                function() {
                    $(this.elem).fadeIn(500)
                }), pageObj("tncChina", pos, 1070, 255, 15, 255, ["t", "h"], [100, 75], [ - 50, 100], [0, 100]), elemObj("v1_text", pos + 120, 950, 195, 15, 255, ["t"], [90], [50], [50], true), elemObj("v1_links", pos + 150, 920, 180, 15, 255, ["t"], [150], [70], [70], true), staObj("tips", pos - 100, 210,
                function() {
                    $(this.elem).show().animate({
                        marginTop: -110
                    },
                    500).trigger("start")
                },
                function() {
                    $(this.elem).animate({
                        marginTop: 0
                    },
                    500,
                    function() {
                        $(this).trigger("stop")
                    })
                }), pageObj("tncWorld", pos += 540, 1490, 255, 225, 255, ["t", "h"], [100, 75], [ - 50, 100], [0, 100]), speObj("v2_text", pos + 120, 1370, ["t", "mt"], [195, 225, 255], [[80, "-59px"], [30, "-59px"], [0, "-100px"], [0, "-100px"]]), speObj("tncWorld", pos + 510, 450, ["bY"], [450], [["0px"], ["-450px"]], true), speObj("v2_body", pos + 510, 450, ["t", "mt"], [200], [[70, "0px"], [50, "-213px"]], true, 500), staObj("v2_point_1", pos + 510, 600, pointShow, pointHide), staObj("v2_point_2", pos + 560, 600, pointShow, pointHide), staObj("v2_point_3", pos + 610, 600, pointShow, pointHide), staObj("v2_point_4", pos + 660, 600, pointShow, pointHide), staObj("v2_point_5", pos + 710, 600, pointShow, pointHide), staObj("v2_point_6", pos + 760, 600, pointShow, pointHide), staObj("v2_point_7", pos + 810, 600, pointShow, pointHide), staObj("v2_point_8", pos + 860, 600, pointShow, pointHide), pageObj("tncEvent", pos += 960, 1970, 255, 465, 255, ["t", "h"], [100, 75], [ - 50, 100], [0, 100]), speObj("v3_text", pos + 120, 1550, ["t", "mt"], [195, 115, 455], [[80, "-59px"], [30, "-59px"], [0, "-100px"], [0, "-100px"]], false, 300), speObj("v3_content", pos + 120, 1550, ["t", "mt"], [310, 455], [[100, "-59px"], [0, "150px"], [0, "150px"]], true, 300), speObj("tncEvent", pos + 510, 900, ["bY"], [300], [["0px"], ["-450px"]], true), speObj("v3_body", pos + 450, 1500, ["mt"], [510, 300], [["0px"], ["-1300px"], ["-1300px"]], true), speObj("v3_mask", pos + 450, 1200, ["h"], [600], [["0px"], ["2068px"]], true, 300, {
                    oAnim: function(a, b) {
                        var _h = $(a).height(),
                        $ps = _.Ps.children(),
                        _i = -1;
                        for (var i = 0; i < $ps.size(); i++) {
                            var $p = $ps.eq(i),
                            _t = $p.data("t"),
                            _H = 20;
                            if (_h >= _t + _H) {
                                $p.show();
                                _i++
                            } else {
                                $p.hide()
                            }
                        }
                        _.Ps.children().eq(_i <= 0 ? 0 : _i).trigger("click")
                    }
                }), pageObj("proPlace", pos += 1440, 1070, 255, 15, 255, ["t", "h"], [100, 75], [ - 50, 100], [0, 100]), elemObj("v4_text", pos + 120, 950, 195, 15, 255, ["t"], [90], [50], [50], true), elemObj("v4_links", pos + 150, 920, 180, 15, 255, ["t"], [150], [70], [70], true), pageObj("proWater", pos += 540, 1070, 255, 15, 255, ["t", "h"], [100, 75], [ - 50, 100], [0, 100]), elemObj("v5_text", pos + 120, 950, 195, 15, 255, ["t"], [90], [50], [50], true), elemObj("v5_links", pos + 150, 920, 180, 15, 255, ["t"], [150], [70], [70], true), pageObj("proAtmosphere", pos += 540, 1070, 255, 15, 255, ["t", "h"], [100, 75], [ - 50, 100], [0, 100]), elemObj("v6_text", pos + 120, 950, 195, 15, 255, ["t"], [90], [50], [50], true), elemObj("v6_links", pos + 150, 920, 180, 15, 255, ["t"], [150], [70], [70], true), pageObj("sciFunc", pos += 540, 1070, 255, 15, 255, ["t", "h"], [100, 75], [ - 50, 100], [0, 100]), elemObj("v7_text", pos + 120, 950, 195, 15, 255, ["t"], [90], [50], [50], true), elemObj("v7_links", pos + 150, 920, 180, 15, 255, ["t"], [150], [70], [70], true), pageObj("sciInfo", pos += 540, 1070, 255, 15, 255, ["t", "h"], [100, 75], [ - 50, 100], [0, 100]), elemObj("v8_text", pos + 120, 950, 195, 15, 255, ["t"], [90], [50], [50], true), elemObj("v8_links", pos + 150, 920, 180, 15, 255, ["t"], [150], [70], [70], true), pageObj("sciProtect", pos += 540, 1070, 255, 15, 255, ["t", "h"], [100, 75], [ - 50, 100], [0, 100]), elemObj("v9_text", pos + 120, 950, 195, 15, 255, ["t"], [90], [50], [50], true), elemObj("v9_links", pos + 150, 920, 180, 15, 255, ["t"], [150], [70], [70], true), pageObj("news", pos += 540, 1070, 255, 15, 255, ["t", "h", "l", "w"], [100, 50, 0, 100], [0, 100, -75, 100], [0, 100, 0, 100]), pageObj("interactive", pos += 540, 1070, 255, 15, 255, ["t", "h", "l", "w"], [0, 100, 100, 100], [0, 100, -75, 100], [0, 100, 0, 100]), pageObj("acount", pos += 540, 860, 255, 15, 150, ["t", "h", "l", "w"], [0, 100, 100, 100], [ - 100, 100, 0, 100], [0, 100, 0, 100]), pageObj("foot", pos += 540, 650, 150, 15, 150, ["t", "h"], [100, 100], [0, 100], [0, 100]), elemObj("foot_body", pos, 650, 150, 15, 150, ["b"], [30], [0], [0])]
            });
            _all = pos += 310;
            TweenMax.set($(".circle"), {
                css: {
                    scale: 0
                }
            })
        },
        CSS3: function(a, b) {
            var property = {};
            property[a] = property["-moz-" + a] = property["-webkit-" + a] = property["-ms-" + a] = property["-o-" + a] = b;
            return property
        },
        pxToInt: function(str) {
            return str.toString().indexOf("px") > -1 ? Math.round(parseFloat(str.split("px")[0])) : str
        },
        shuffleArray: function(arr) {
            for (var j, x, i = arr.length; i; j = parseInt(Math.random() * i), x = arr[--i], arr[i] = arr[j], arr[j] = x) {}
            return arr
        },
        sizeOf: function(o) {
            var counter = 0;
            for (var i in o) {
                counter++
            }
            return counter
        },
        objString: function(obj, f) {
            if (f == undefined) {
                f = true
            }
            var str = f ? "{": "";
            for (var i in obj) {
                str += i + ":" + obj[i] + ";"
            }
            return str + (f ? "}": "")
        },
        arraySuffix: function(arr, suff) {
            for (var i = 0; i < arr.length;
            /^-?\d+$/.test(arr[i]) ? arr[i] += suff: arr[i] = arr[i], i++) {}
            return arr
        },
        findArrIndex: function(_arr, reg) {
            for (var i = 0; i < _arr.length; i++) {
                if (reg.test(_arr[i])) {
                    return i
                }
            }
            return - 1
        },
        findArrIndexEx: function(_arr, val) {
            var s = _arr.length;
            for (var i = 0; i < _arr.length; i++) {
                if (val == _arr[i] || (i + 1 <= s && val < _arr[i + 1])) {
                    return i
                }
            }
            return - 1
        },
        TPL: function(template, data) {
            return template.replace(/\{([\w\.]*)\}/g,
            function(str, key) {
                var keys = key.split("."),
                v = data[keys.shift()];
                for (var i = 0,
                l = keys.length; i < l; i++) {
                    v = v[keys[i]]
                }
                return (typeof v !== "undefined" && v !== null) ? v: ""
            })
        },
        is: function(A, _) {
            var $ = Object.prototype.toString.call(_).slice(8, -1).toLowerCase();
            return _ !== undefined && _ !== null && $ === A.toLowerCase()
        },
        isObject: function(o) {
            return this.is("object", o)
        },
        isArray: function(o) {
            return this.is("array", o)
        },
        Ac: function() {
            var str = document.cookie
        },
        Sc: function(objName, objValue, objHours) {
            var str = objName + "=" + escape(objValue); !! (objHours == undefined) && (objHours = 24);
            if (objHours > 0) {
                var date = new Date();
                var ms = objHours * 3600 * 1000;
                date.setTime(date.getTime() + ms);
                str += "; expires=" + date.toGMTString()
            }
            document.cookie = str
        },
        Gc: function(objName) {
            var arrStr = document.cookie.split("; ");
            for (var i = 0; i < arrStr.length; i++) {
                var temp = arrStr[i].split("=");
                if (temp[0] == objName) {
                    return unescape(decodeURIComponent(temp[1]))
                }
            }
        },
        Dc: function(name) {
            var date = new Date();
            date.setTime(date.getTime() - 10000);
            document.cookie = name + "=; expires=" + date.toGMTString()
        },
        encrypt: function(str, pwd) {
            if (pwd == null || pwd.length <= 0) {
                return ""
            }
            var prand = "";
            for (var i = 0; i < pwd.length; i++) {
                prand += pwd.charCodeAt(i).toString()
            }
            var sPos = Math.floor(prand.length / 5);
            var mult = parseInt(prand.charAt(sPos) + prand.charAt(sPos * 2) + prand.charAt(sPos * 3) + prand.charAt(sPos * 4) + prand.charAt(sPos * 5));
            var incr = Math.ceil(pwd.length / 2);
            var modu = Math.pow(2, 31) - 1;
            if (mult < 2) {
                return ""
            }
            var salt = 87654321;
            prand += salt;
            while (prand.length > 10) {
                prand = (parseInt(prand.substring(0, 10)) + parseInt(prand.substring(10, prand.length))).toString()
            }
            prand = (mult * prand + incr) % modu;
            var enc_chr = "";
            var enc_str = "";
            for (var i = 0; i < str.length; i++) {
                enc_chr = parseInt(str.charCodeAt(i) ^ Math.floor((prand / modu) * 255));
                if (enc_chr < 16) {
                    enc_str += "0" + enc_chr.toString(16)
                } else {
                    enc_str += enc_chr.toString(16)
                }
                prand = (mult * prand + incr) % modu
            }
            salt = salt.toString(16);
            while (salt.length < 8) {
                salt = "0" + salt
            }
            enc_str += salt;
            return enc_str
        },
        decrypt: function(str, pwd) {
            if (str == null || str.length < 8) {
                return ""
            }
            if (pwd == null || pwd.length <= 0) {
                return ""
            }
            var prand = "";
            for (var i = 0; i < pwd.length; i++) {
                prand += pwd.charCodeAt(i).toString()
            }
            var sPos = Math.floor(prand.length / 5);
            var mult = parseInt(prand.charAt(sPos) + prand.charAt(sPos * 2) + prand.charAt(sPos * 3) + prand.charAt(sPos * 4) + prand.charAt(sPos * 5));
            var incr = Math.round(pwd.length / 2);
            var modu = Math.pow(2, 31) - 1;
            var salt = parseInt(str.substring(str.length - 8, str.length), 16);
            str = str.substring(0, str.length - 8);
            prand += salt;
            while (prand.length > 10) {
                prand = (parseInt(prand.substring(0, 10)) + parseInt(prand.substring(10, prand.length))).toString()
            }
            prand = (mult * prand + incr) % modu;
            var enc_chr = "";
            var enc_str = "";
            for (var i = 0; i < str.length; i += 2) {
                enc_chr = parseInt(parseInt(str.substring(i, i + 2), 16) ^ Math.floor((prand / modu) * 255));
                enc_str += String.fromCharCode(enc_chr);
                prand = (mult * prand + incr) % modu
            }
            return enc_str
        }
    };
    function log(msg) {
        if (!$t) {
            return
        }
        if (window.console && window.console.log) {
            window.console.log(msg)
        } else {
            if (window.opera && window.opera.postError) {
                window.opera.postError(msg)
            }
        }
    } (function() {
        var lastTime = 0;
        var vendors = ["ms", "moz", "webkit", "o"];
        for (var x = 0; x < vendors.length && !window.requestAnimationFrame; ++x) {
            window.requestAnimationFrame = window[vendors[x] + "RequestAnimationFrame"];
            window.cancelAnimationFrame = window[vendors[x] + "CancelAnimationFrame"] || window[vendors[x] + "CancelRequestAnimationFrame"]
        }
        if (!window.requestAnimationFrame) {
            window.requestAnimationFrame = function(callback, element) {
                var currTime = new Date().getTime();
                var timeToCall = Math.max(0, 16 - (currTime - lastTime));
                var id = window.setTimeout(function() {
                    callback(currTime + timeToCall)
                },
                timeToCall);
                lastTime = currTime + timeToCall;
                return id
            }
        }
        if (!window.cancelAnimationFrame) {
            window.cancelAnimationFrame = function(id) {
                clearTimeout(id)
            }
        }
    } ());
    window._hmt = window._hmt || [];
    var _tEvent = function(a, b, c) {
        window._hmt.push(["_trackEvent", a, b, c])
    },
    _tPage = function(a) {
        window._hmt.push(["_trackPageview", a])
    }; (function() {
        $(".nav_li").bind("click",
        function() {
            _tEvent($(this).attr("anchor"), "click", "MENU")
        }).find("dd").bind("click",
        function() {
            _tEvent($(this).parents(".nav_li").attr("anchor") + $(this).attr("anchor"), "click", "MENU")
        }).find("a").bind("click",
        function() {
            var _href = $(this).attr("href"); !! _href && (_href = _href.replace(document.location.origin, "")) && (_href = _href.replace(document.location.protocol + "//" + document.location.host, "")) && !/^javascript.+/i.test(_href) && _tPage(_href)
        });
        $(".view_a").live("click",
        function() {
            var _url = $(this).data("url"); !! _url && _tPage(_url)
        });
        $(".view_links .B").not(".fea_btn").bind("click",
        function() {
            var _href = $(this).attr("href"); !! _href && (_href = _href.replace(document.location.origin, "")) && (_href = _href.replace(document.location.protocol + "//" + document.location.host, "")) && !/^javascript.+/i.test(_href) && _tPage(_href)
        });
        $(".fea_btn,.map_btn").bind("click",
        function() { !! (_pro = _IFRAME[$(this).data("pro")]) && !!_pro["link"] && _tPage(_pro["link"])
        })
    })();
    var _TPL_0 = [{
        "url": "schedule",
        "tpl": '<li class="view_li"><a href="javascript:;" data-url="{link}" class="view_a news_a" title="{title}"><span class="news_title">{title}</span><div class="news_img"><img onload="resizeImg(this,234,142,\'.view\')"  src="{pic}"></div><span class="news_date">{date}</span><div class="view_text news_text"><p>{describe}</p></div></a></li>'
    },
    {
        "url": "news",
        "tpl": '<li class="view_li"><a href="javascript:;" data-url="{link}" class="view_a news_a" title="{title}"><span class="news_title">{title}</span><div class="news_img"><img onload="resizeImg(this,234,142,\'.view\')"  src="{pic}"></div><span class="news_date">{date}</span><div class="view_text news_text"><p>{describe}</p></div></a></li>'
    },
    {
        "url": "worldschedule",
        "tpl": '<li class="view_li"><a href="javascript:;" data-url="{link}" class="view_a news_a" title="{title}"><span class="news_title">{title}</span><div class="news_img"><img onload="resizeImg(this,234,142,\'.view\')"  src="{pic}"></div><span class="news_date">{date}</span><div class="view_text news_text"><p>{describe}</p></div></a></li>'
    },
    {
        "url": "story",
        "tpl": '<li class="view_li"><a href="javascript:;" data-url="{link}" class="view_a active_a" title="{title}"><span class="active_title">{title}</span><div class="active_img"><img onload="resizeImg(this,234,172,\'.view\')"  src="{pic}"></div><div class="view_text active_text"><p>{describe}</p></div></a></li>'
    },
    {
        "url": "video",
        "tpl": '<li class="view_li"><a href="javascript:;" data-url="{link}" class="view_a active_a" title="{title}"><span class="active_title">{title}</span><div class="active_img"><img onload="resizeImg(this,234,172,\'.view\')"  src="{pic}"></div><div class="view_text active_text"><p>{describe}</p></div></a></li>'
    },
    {
        "url": "card",
        "tpl": '<li class="view_li"><a href="javascript:;" data-url="{link}" class="view_a active_a" title="{title}"><span class="active_title">{title}</span><div class="active_img"><img onload="resizeImg(this,234,172,\'.view\')"  src="{pic}"></div><div class="view_text active_text"><p>{describe}</p></div></a></li>'
    },
    {
        "url": "q&a",
        "tpl": '<li class="view_li"><a href="javascript:;" class="view_a active_a QA_a" data-url="{link}" title="{title}"><span class="active_title">Q:{title}</span><div class="active_txt"><p title="点击查看更多">A:&nbsp;&nbsp;&nbsp;{describe}</p></div></a></li>'
    },
    {
        "url": "join",
        "tpl": '<li class="view_li"><a href="javascript:;" data-url="{link}" class="view_a active_a" title="{title}"><span class="mytnc_title">{title}</span><div class="mytnc_img"><img onload="resizeImg(this,234,172,\'.view\')"  src="{pic}"></div><div class="view_text mytnc_text"><p>{describe}</p></div></a></li>'
    },
    {
        "url": "withtnc",
        "tpl": '<li class="view_li"><a href="javascript:;" data-url="{link}" class="view_a active_a" title="{title}"><span class="mytnc_title">{title}</span><div class="mytnc_img"><img onload="resizeImg(this,234,172,\'.view\')"  src="{pic}"></div><div class="view_text mytnc_text"><p>{describe}</p></div></a></li>'
    }];
    var _URL = {
        "schedule": ["/home/pageSchedule?type=1", ""],
        "news": ["/home/pageNews", ""],
        "worldschedule": ["/home/pageSchedule?type=2", ""],
        "story": ["/home/pageStory", ""],
        "video": ["/home/pageVideo", ""],
        "card": ["/home/pageCard", ""],
        "q&a": ["/home/pageAsk", ""],
        "join": ["/home/pageActivity", ""],
        "withtnc": ["/home/pageItnc", ""],
        "logout": ["/home/logout", ""]
    };
    var _IFRAME = {
        tncMore: {
            view: "了解TNC",
            link: "/home/more/1"
        },
        tncChina: {
            view: "TNC在中国",
            sec: "查看更多",
            link: "/home/tncmore"
        },
        tncWorld: {
            view: "TNC在全球",
            sec: "查看更多",
            link: "/home/more/39"
        },
        tncPlace: {
            view: "保护地",
            sec: "查看更多",
            link: "/home/more/41"
        },
        tncWater: {
            view: "淡水",
            sec: "查看更多",
            link: "/home/more/25"
        },
        tncFunc: {
            view: "保护科学",
            sec: "查看更多",
            link: "/home/more/11"
        },
        newpro: {
            view: "了解TNC",
            sec: "最新项目",
            link: "/home/latest",
            ul: "#fea_china"
        },
        oldpro: {
            view: "了解TNC",
            sec: "以往项目",
            link: "/home/past",
            ul: "#fea_china"
        },
        team: {
            view: "了解TNC",
            sec: "认识我们",
            link: "/home/aboutUs",
            ul: "#fea_china"
        },
        tncNA: {
            view: "TNC在全球",
            sec: "TNC在北美洲",
            link: "/home/more/52",
            ul: "#fea_world"
        },
        tncEU: {
            view: "TNC在全球",
            sec: "TNC在欧洲",
            link: "/home/more/53",
            ul: "#fea_world"
        },
        tncNAsia: {
            view: "TNC在全球",
            sec: "TNC在亚太",
            link: "/home/more/54",
            ul: "#fea_world"
        },
        tncCSea: {
            view: "TNC在全球",
            sec: "TNC在加勒比海",
            link: "/home/more/55",
            ul: "#fea_world"
        },
        tncCA: {
            view: "TNC在全球",
            sec: "TNC在中美洲",
            link: "/home/more/55",
            ul: "#fea_world"
        },
        tncAF: {
            view: "TNC在全球",
            sec: "TNC在非洲",
            link: "/home/more/56",
            ul: "#fea_world"
        },
        tncSA: {
            view: "TNC在全球",
            sec: "TNC在中南美洲",
            link: "/home/more/55",
            ul: "#fea_world"
        },
        tncAsia: {
            view: "TNC在全球",
            sec: "TNC在亚太区",
            link: "/home/more/54",
            ul: "#fea_world"
        },
        schedule: {
            view: "项目进度"
        },
        worldschedule: {
            view: "全球项目进度"
        },
        news: {
            view: "媒体报道"
        },
        story: {
            view: "图片故事"
        },
        video: {
            view: "影像记录"
        },
        card: {
            view: "自然贺卡"
        },
        "q&a": {
            view: "有问有答"
        },
        "lib": {
            view: "TNC阅览室"
        },
        "join": {
            view: "我要参与"
        },
        "withtnc": {
            view: "志愿者故事"
        },
        "message": {
            view: "我要留言"
        },
        "user": {
            view: "修改资料"
        },
        "hr": {
            view: "工作机会",
            link: "/home/hr"
        },
        "partner": {
            view: "合作伙伴",
            link: "/home/more/49"
        },
        "declare": {
            view: "法律声明",
            link: "/home/more/50"
        },
        "contact": {
            view: "联系我们",
            link: "/home/more/51"
        },
        "feeback": {
            view: "问题反馈",
            link: "feedback.html"
        }
    };
    var _P = {
        1915 : {
            x: 262,
            y: 343
        },
        1917 : {
            x: 194,
            y: 366,
            r: true
        },
        1926 : {
            x: 335,
            y: 395
        },
        1946 : {
            x: 215,
            y: 430,
            r: true
        },
        1950 : {
            x: 302,
            y: 462
        },
        1951 : {
            x: 306,
            y: 506,
            r: true
        },
        1954 : {
            x: 424,
            y: 527
        },
        1955 : {
            x: 390,
            y: 560,
            r: true
        },
        1961 : {
            x: 483,
            y: 576
        },
        1965 : {
            x: 409,
            y: 610,
            r: true
        },
        1966 : {
            x: 494,
            y: 650
        },
        1970 : {
            x: 417,
            y: 691,
            r: true
        },
        1974 : {
            x: 471,
            y: 716
        },
        1980 : {
            x: 335,
            y: 729,
            r: true
        },
        1988 : {
            x: 424,
            y: 761
        },
        1989 : {
            x: 291,
            y: 775,
            r: true
        },
        1990 : {
            x: 342,
            y: 833
        },
        1991 : {
            x: 246,
            y: 867,
            r: true
        },
        1994 : {
            x: 357,
            y: 902
        },
        1995 : {
            x: 352,
            y: 949,
            r: true
        },
        1998 : {
            x: 518,
            y: 959
        },
        1999 : {
            x: 459,
            y: 1001,
            r: true
        },
        2000 : {
            x: 627,
            y: 1027
        },
        2001 : {
            x: 615,
            y: 1081,
            r: true
        },
        2002 : {
            x: 878,
            y: 1112
        },
        2003 : {
            x: 741,
            y: 1151
        },
        2004 : {
            x: 559,
            y: 1167,
            r: true
        },
        2005 : {
            x: 626,
            y: 1204
        },
        2006 : {
            x: 522,
            y: 1219,
            r: true
        },
        2007 : {
            x: 552,
            y: 1256
        },
        2008 : {
            x: 421,
            y: 1277,
            r: true
        },
        2009 : {
            x: 543,
            y: 1327
        },
        2010 : {
            x: 478,
            y: 1365,
            r: true
        },
        2011 : {
            x: 680,
            y: 1393
        },
        2012 : {
            x: 644,
            y: 1430,
            r: true
        },
        2013 : {
            x: 747,
            y: 1464
        },
        2014 : {
            x: 685,
            y: 1527,
            r: true
        },
        2015 : {
            x: 790,
            y: 1560
        }
    };
    $(document).ready(function(e) {
        $f.init()
    })
})(jQuery);