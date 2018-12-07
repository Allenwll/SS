$(function () {
    $.fn.extend({
        currentDate: null,
        defaultOption: null,
        createCalendar: function (options) {
            var defaultOption = {
                style: "simple", //两种类型 simple duty
                lookFun: function () {
                },
                settingFun: function () {
                },
                loadDataFun: function () {
                }
            };
            if (typeof options === "object") {
                for (var ndx in defaultOption) {
                    if (options[ndx] !== undefined) {
                        defaultOption[ndx] = options[ndx];
                    }
                }
            }
            this.defaultOption = defaultOption;
            this.currentDate = new Date();
            this.initCalendar(new Date());
            this.defaultOption.loadDataFun(this);
            this.initEvent();
            return this;
        },
        initEvent: function () {
            var self = this;
            $(".nextMonth").on("click", function () {
                self.nextMonth();
                self.defaultOption.loadDataFun(self);
            });
            $(".previousMonth").on("click", function () {
                self.previousMonth();
                self.defaultOption.loadDataFun(self);
            });
            $(".nextYear").on("click", function () {
                self.nextYear();
                self.defaultOption.loadDataFun(self);
            });
            $(".previousYear").on("click", function () {
                self.previousYear();
                self.defaultOption.loadDataFun(self);
            });
            $(".jumpToday").on("click", function () {
                self.currentDate = new Date();
                self.initCalendar(self.currentDate);
                self.defaultOption.loadDataFun(self);
            });
            //这里要使用代理
            $(this).delegate(".tdbottom", "click", function (ev) {
                ev.stopPropagation(); //阻止事件冒泡
                var btn = $(this);
                var dayTd = btn.parents(".day");
                self.defaultOption.settingFun(self, dayTd.data("date"));
            });
            //这里要使用代理
            $(this).delegate(".day", "click", function () {
                var btn = $(this);
                self.defaultOption.lookFun(btn.data("date"));
            });
        },
        nextMonth: function () {
            this.currentDate = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() + 1, this.currentDate.getDate());
            this.initCalendar(this.currentDate);
        },
        previousMonth: function () {
            this.currentDate = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() - 1, this.currentDate.getDate());
            this.initCalendar(this.currentDate);
        },
        nextYear: function () {
            this.currentDate = new Date(this.currentDate.getFullYear() + 1, this.currentDate.getMonth(), this.currentDate.getDate());
            this.initCalendar(this.currentDate);
        },
        previousYear: function () {
            this.currentDate = new Date(this.currentDate.getFullYear() - 1, this.currentDate.getMonth(), this.currentDate.getDate());
            this.initCalendar(this.currentDate);
        },
        //初始化表格的基础数据
        initCalendar: function (currentDate) {
            var headNum = this.getMonthFirstDate(currentDate).getDay();
            var monthNum = this.getMonthLastDate(currentDate).getDate();
            var endNum = 42 - headNum - monthNum;
            var calendarData = [];
            for (var i = 0; i < headNum; i++) {
                var obj = {};
                obj.date = this.dateFormat(new Date(this.getMonthFirstDate(currentDate) - 1000 * 60 * 60 * 24 * (headNum - i)), 'yyyy-MM-dd');
                obj.day = new Date(this.getMonthFirstDate(currentDate) - 1000 * 60 * 60 * 24 * (headNum - i)).getDate();
                obj.showDate = false; //是否显示该日期
                calendarData.push(obj);
            }
            for (var i = 0; i < monthNum; i++) {
                var obj = {};
                obj.date = this.dateFormat(new Date(currentDate.getFullYear(), currentDate.getMonth(), (i + 1)), 'yyyy-MM-dd');
                obj.day = new Date(currentDate.getFullYear(), currentDate.getMonth(), (i + 1)).getDate();
                obj.showDate = true; //是否显示该日期
                calendarData.push(obj);
            }
            for (var i = 0; i < endNum; i++) {
                var obj = {};
                obj.date = this.dateFormat(new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, (i + 1)), 'yyyy-MM-dd');
                obj.day = new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, (i + 1)).getDate();
                obj.showDate = false; //是否显示该日期
                calendarData.push(obj);
            }
            this.empty();
            var th = $("<tr><th colspan='7'>" + this.dateFormat(this.currentDate, "yyyy年MM月") + "</th></tr>");
            this.append(th);
            var week = $("<tr><td class='title'>日</td><td class='title'>一</td><td class='title'>二</td><td class='title'>三</td><td class='title'>四</td><td class='title'>五</td><td class='title'>六</td></tr>");
            this.append(week);
            var tr = $("<tr></tr>");
            for (var i = 1; i <= calendarData.length; i++) {
                var active = "";
                if (calendarData[i - 1].date == this.dateFormat(new Date(), 'yyyy-MM-dd')) {
                    active = "activeDay";
                }
                var td;
                if (calendarData[i - 1].showDate) {
                    if (this.defaultOption.style == 'simple') {
                        td = $("<td data-date='" + calendarData[i - 1].date + "' class='day'><div class='tdhead " + active + "'>" + calendarData[i - 1].day + "</div></td>");
                    } else {
                        td = $("<td data-date='" + calendarData[i - 1].date + "' class='day'><div class='tdhead " + active + "'>" + calendarData[i - 1].day +
                            "</div><div class='tdbody'><p>带班领导：</p><p>值班员：</p><p>值班员：</p></div><div" +
                            " class='tdbottom'>设置</div></td>");
                    }
                } else {
                    td = $("<td data-date='" + calendarData[i - 1].date + "'>&nbsp;</td>");
                }
                tr.append(td);
                if (i % 7 == 0) {
                    this.append(tr);
                    if (i != 42) {
                        tr = $("<tr></tr>");
                    }
                }
            }
            //填写当前年和月
            $(".yearText").text(this.dateFormat(this.currentDate, "yyyy年"));
            $(".monthText").text(this.dateFormat(this.currentDate, "MM月"));
        },
        //获取当月的第一天
        getMonthFirstDate: function (date) {
            return new Date(date.getFullYear(), date.getMonth(), 1);
        },
        //获取当月的最后一天
        getMonthLastDate: function (date) {
            var nextMonthFirstDay = new Date(date.getFullYear(), date.getMonth() + 1, 1);
            return new Date(nextMonthFirstDay - 1000 * 60 * 60 * 24);
        },
        //获取表格加载数据的开始时间
        beginDate: function () {
            return this.dateFormat(new Date(this.currentDate.getFullYear(), this.currentDate.getMonth(), 1), 'yyyy-MM-dd');
        },
        //获得表格加载数据的结束时间
        endDate: function () {
            var nextMonthFirstDay = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() + 1, 1);
            return this.dateFormat(new Date(nextMonthFirstDay - 1000 * 60 * 60 * 24), 'yyyy-MM-dd');
        },
        //设置表格的值班数据
        setData: function (datas) {
            var self = this;
            for (var i = 0; i < datas.length; i++) {
                self.setOneData(datas[i]);
            }
        },
        //设置一条表格数据
        setOneData: function (data) {
            //设置值班信息
            if (this.defaultOption.style == 'duty') {
                var text = $("td[data-date='" + data.dutyDate + "']").find(".tdbody");
                text.empty();
                if (data.relDutyUserVos) {
                    for (var i = 0; i < data.relDutyUserVos.length; i++) {
                        var man = $("<span></span><p>" + data.relDutyUserVos[i].dictDutyTypeName + "："
                            + (data.relDutyUserVos[i].name ? data.relDutyUserVos[i].name : '') + "</p>");
                        text.append(man);
                    }
                }
            }
            //设置背景颜色
            var td = $("td[data-date='" + data.dutyDate + "']");
            if (data.dictDutyLevelName == 'A') {
                td.css({
                   /* "color": "red"*/
                });
                $($(td).find("span")[0]).addClass("red-font");
                $($(td).find("span")[0]).text("A级");
            } else if (data.dictDutyLevelName == 'B') {
                td.css({
                  /*  "color": "orange"*/
                });
                $($(td).find("span")[0]).addClass("orange-font");
                $($(td).find("span")[0]).text("B级");
            } else if (data.dictDutyLevelName == 'C') {
                td.css({
                   /* "color": "yellow"*/
                });
                $($(td).find("span")[0]).addClass("yellow-font");
                $($(td).find("span")[0]).text("C级");
            } else if (data.dictDutyLevelName == 'D') {
                td.css({
                   /* "color": "blue"*/
                });
                $($(td).find("span")[0]).addClass("blue-font");
                $($(td).find("span")[0]).text("D级");
            } else {
                td.css({
                   /* "background-color": "#ffffff"*/
                });
                $($(td).find("span")[0]).addClass("")
            }
        },
        //将字符串转换成日期格式
        strToDate: function (dateStr) { //2016-01-14 01:02:03
            return new Date(dateStr.replace(/\-/g, '/'));
        },
        //日期格式化
        dateFormat: function (date, fmt) {
            /**
             * 对Date的扩展，将 Date 转化为指定格式的String
             * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符
             * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
             * eg:
             * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
             * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04
             * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04
             * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04
             * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
             */
            var o = {
                "M+": date.getMonth() + 1, //月份
                "d+": date.getDate(), //日
                "h+": date.getHours() % 12 == 0 ? 12 : date.getHours() % 12, //小时
                "H+": date.getHours(), //小时
                "m+": date.getMinutes(), //分
                "s+": date.getSeconds(), //秒
                "q+": "第" + Math.floor((date.getMonth() + 3) / 3) + "季度", //季度
                "S": date.getMilliseconds() //毫秒
            };
            var week = {
                "0": "日",
                "1": "一",
                "2": "二",
                "3": "三",
                "4": "四",
                "5": "五",
                "6": "六"
            };
            if (/(y+)/.test(fmt)) {
                fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
            }
            if (/(E+)/.test(fmt)) {
                fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "星期" : "周") : "") + week[date.getDay() + ""]);
            }
            for (var k in o) {
                if (new RegExp("(" + k + ")").test(fmt)) {
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                }
            }
            return fmt;
        }
    });
});
