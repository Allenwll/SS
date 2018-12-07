$(document).bind("ajaxError", function (XMLHttpRequest, textStatus, errorThrown) {
    if (textStatus.responseText == '连接超时') {
        function home(w) {
            //console.info('连接超时');
            if (w.top === w.self) { // are you trying to put self in an iframe?
                w.location.href = '/portal/home.html';
            } else {
                home(w.parent);
            }
        }

        home(window);
    }
});
function myBrowser() {
    var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
    var isOpera = userAgent.indexOf("Opera") > -1; //判断是否Opera浏览器
    var isIE = userAgent.indexOf("compatible") > -1
        && userAgent.indexOf("MSIE") > -1 && !isOpera; //判断是否IE浏览器
    var isFF = userAgent.indexOf("Firefox") > -1; //判断是否Firefox浏览器
    var isSafari = userAgent.indexOf("Safari") > -1; //判断是否Safari浏览器
    if (isIE) {
        var IE5 = IE55 = IE6 = IE7 = IE8 = false;
        var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
        reIE.test(userAgent);
        var fIEVersion = parseFloat(RegExp["$1"]);
        return fIEVersion;
    }//isIE end
    return -1;
}

var Constants = {
    DEFAULT_GRID_PAGE_SIZE: 10,
    DEFAULT_GRID_SIZE_LIST: [5, 10, 20, 50],
    btnStyle: undefined,
    encodeObjToJSON: function (obj) {
        var params = this.isAttributeEmpty(obj);
        var json = mini.encode(params);
        return this.encodeURI(json);
    },
    encodeURI: function (params) {
        return encodeURIComponent(encodeURIComponent(params));
    },
    decodeURIToObj: function (encodeString) {
        return mini.decode(decodeURIComponent(decodeURIComponent(encodeString)));
        ;
    },
    empty: function (v) {
        switch (typeof v) {
            case 'undefined' :
                return true;
            case 'string' :
                if (trim(v).length == 0)
                    return true;
                break;
            case 'number' :
                if (0 === v)
                    return true;
                break;
            case 'object' :
                if (null === v)
                    return true;
                if (undefined !== v.length && v.length == 0)
                    return true;
                for (var k in v) {
                    return false;
                }
                return true;
                break;
        }
        return false;
    },
    isAttributeEmpty: function (obj) {
        var eachObj = function (obj) {
            // 开始遍历
            for (var p in obj) { // 方法
                if (_.isObject(obj[p])) {
                    arguments.callee(obj[p]);
                } else { // p 为属性名称，obj[p]为对应属性的值
                    if (_.isNull(obj[p]) || (typeof obj[p] == 'undefined') || obj[p] === "") {
                        delete obj[p];
                    }
                }
            }
        }
        eachObj(obj);
        return obj;
    },

    // 把array转为listName[i].key=value&listName[i].key=value形式字符串
    // array js array数组
    // listName 后台接收的list名称 如entity.list 或 userList
    serializeArray: function (array, listName) {
        var text = "";
        for (var i = 0; i < array.length; i++) {
            for (key in array[i]) {
                var subObj = array[i][key];
                if (typeof subObj == 'object') {
                    for (o in subObj) {
                        text += listName + "[" + i + "]." + key + "." + o + "="
                            + subObj[o] + "&";
                    }
                } else {
                    text += listName + "[" + i + "]." + key + "="
                        + array[i][key] + "&";
                }
            }
        }
        return text.substring(0, text.length - 1);
    },

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

}

//文件上传
$.fn.extend({
    pkuUpload: function (options) {
        var defaultOption = {
            url: "",
            subfix: [],//后缀控制
            params: {},//MB
            fileElementId: "",//自动生成的input:file 的id,页面有两个上传的时间此值要不同
            savePathId: ""//保存到数据库中的路径
        };
        if (typeof options === "object") {
            for (var ndx in defaultOption) {
                if (options[ndx] !== undefined) {
                    defaultOption[ndx] = options[ndx];
                }
            }
        }
        var btn = $(this);
        //添加 input:file
        btn.parent().append("<input type='file' id='" + defaultOption.fileElementId + "' name='file' style='display: none'/>");
        //按钮绑定点击事件
        btn.on("click", function () {
            $("#" + defaultOption.fileElementId).off("change");
            $("#" + defaultOption.fileElementId).on("change", function () {
                var filePath = $(this).val();
                var fix = filePath.substring(filePath.lastIndexOf(".") + 1);
                //判断文件是否合法
                if ($.inArray(fix, defaultOption.subfix) != -1) {
                    $.ajaxFileUpload({
                        url: defaultOption.url,//用于文件上传的服务器端请求地址
                        secureuri: false,//一般设置为false
                        fileElementId: defaultOption.fileElementId,//文件上传空间的id属性  <input type="file" id="file" name="file" />
                        dataType: 'json',//返回值类型 一般设置为json
                        data: defaultOption.params,
                        success: function (data, status) {  //服务器成功响应处理函数
                            //清空input:file
                            if (data.flag == "success") {
                                $("#" + defaultOption.fileElementId).val("");
                                mini.get(defaultOption.savePathId).setValue(data.savePath);
                                console.log(data.fileName);
                            } else {
                                mini.alert(data.msg);
                            }
                        },
                        error: function (data, status, e) {//服务器响应失败处理函数
                            mini.alert("程序错误,联系管理员");
                        }
                    });
                } else {
                    mini.alert("文件类型不合法,文件类型应为【" + defaultOption.subfix.join(",") + "】");
                    $("#" + defaultOption.fileElementId).val("");
                }

            });
            return $("#" + defaultOption.fileElementId).click();
        });
    }
});//util作为判断变量具体类型的辅助模块
      var util = (function(){
          var class2type = {};
          ["Null","Undefined","Number","Boolean","String","Object","Function","Array","RegExp","Date"].forEach(function(item){
              class2type["[object "+ item + "]"] = item.toLowerCase();
          })

          function isType(obj, type){
              return getType(obj) === type;
          }
          function getType(obj){
              return class2type[Object.prototype.toString.call(obj)] || "object";
          }
          return {
              isType:isType,
              getType:getType
          }
      })();

      function copy(obj,deep){
           //如果obj不是对象，那么直接返回值就可以了
          if(obj === null || typeof obj !== "object"){
              return obj;
          }
   　　　　//定义需要的局部变脸，根据obj的类型来调整target的类型
          var i, target = util.isType(obj,"array") ? [] : {},value,valueType;
          for(i in obj){
              value = obj[i];
              valueType = util.getType(value);
   　　　　　　　//只有在明确执行深复制，并且当前的value是数组或对象的情况下才执行递归复制
              if(deep && (valueType === "array" || valueType === "object")){
                  target[i] = copy(value);
              }else{
                  target[i] = value;
              }
          }
          return target;
      }