//显示限制输入字符method
function textAreaChange(obj) {
    var $this = $(obj);
    var count_total = $this.next().children('span').text();
    var count_input = $this.next().children('em');
    var area_val = $this.val();
    if (area_val.len() > count_total) {
        area_val = autoAddEllipsis(area_val, count_total);//根据字节截图内容
        $this.val(area_val);
        count_input.text(0);//显示可输入数
    } else {
        count_input.text(count_total - area_val.len());//显示可输入数
    }
}

//得到字符串的字节长度
String.prototype.len = function () {
    return this.replace(/[^\x00-\xff]/g, "xx").length;
};

/*
* 处理过长的字符串，截取并添加省略号
* 注：半角长度为1，全角长度为2
* pStr:字符串
* pLen:截取长度
* return: 截取后的字符串
*/
function autoAddEllipsis(pStr, pLen) {
    var _ret = cutString(pStr, pLen);
    var _cutFlag = _ret.cutflag;
    var _cutStringn = _ret.cutstring;
    return _cutStringn;
}

/*
* 取得指定长度的字符串
* 注：半角长度为1，全角长度为2
* pStr:字符串
* pLen:截取长度
* return: 截取后的字符串
*/
function cutString(pStr, pLen) {
    // 原字符串长度
    var _strLen = pStr.length;
    var _tmpCode;
    var _cutString;
    // 默认情况下，返回的字符串是原字符串的一部分
    var _cutFlag = "1";
    var _lenCount = 0;
    var _ret = false;
    if (_strLen <= pLen / 2) {
        _cutString = pStr;
        _ret = true;
    }
    if (!_ret) {
        for (var i = 0; i < _strLen; i++) {
            if (isFull(pStr.charAt(i))) {
                _lenCount += 2;
            } else {
                _lenCount += 1;
            }
            if (_lenCount > pLen) {
                _cutString = pStr.substring(0, i);
                _ret = true;
                break;
            } else if (_lenCount == pLen) {
                _cutString = pStr.substring(0, i + 1);
                _ret = true;
                break;
            }
        }
    }
    if (!_ret) {
        _cutString = pStr;
        _ret = true;
    }
    if (_cutString.length == _strLen) {
        _cutFlag = "0";
    }
    return {"cutstring": _cutString, "cutflag": _cutFlag};
}

/*
* 判断是否为全角
*
* pChar:长度为1的字符串
* return: true:全角
*         false:半角
*/
function isFull(pChar) {
    if ((pChar.charCodeAt(0) > 128)) {
        return true;
    } else {
        return false;
    }
}

var textID = window.location.href.split("?")[1].split("=")[1];


function baocun() {

    $("input[type='radio']").each(function () { //遍历checkbox的选择状态
        if ($(this).prop("checked")) { //如果值为checked表明选中了，
            if (($(this).attr("name")).substr(0, 1) === ("d")) {//且name值为d+ 的check

                var length = ($(this).attr("name")).length;
                var danid = ($(this).attr("name")).substr(1, length - 1);
                var daan = ($(this).attr("value"))

                $.ajax({
                    cache: false,//每次读取的是最新的数据。
                    type: "Get",//方法类型
                    dataType: "json",//预期服务器返回的数据类型
                    url: "/shijuan/tianxie",//url
                    data: {
                        st: danid,
                        daan: daan
                    },
                    async: true,  //必须要为false,必须必须//同步
                    clearForm: true,        // 成功提交后，清除所有的表单元素的值.


                    success: function (data) {

                    },
                    error: function (e) {

                    }
                });
            }
        }
    });


    $("input[type='text']").each(function () {
        if (($(this).attr("name")).substr(0, 1) === ("t")) {
            var length = ($(this).attr("name")).length;

            var danid = ($(this).attr("name")).substr(1, length - 1);
            var id = $(this).attr("id")
            var daan = $("#" + id).val();

            $.ajax({
                cache: false,//每次读取的是最新的数据。
                type: "Get",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/shijuan/tianxie",//url
                data: {
                    st: danid,
                    daan: daan
                },
                async: true,  //必须要为false,必须必须//同步


                success: function (data) {

                },
                error: function (e) {

                }
            });

        }


    });


    $("textarea[name^='z']").each(function () {


        var length = ($(this).attr("name")).length;

        var danid = ($(this).attr("name")).substr(1, length - 1);
        var id = $(this).attr("id")


        var daan = $("#" + id).val();


        $.ajax({
            cache: false,//每次读取的是最新的数据。
            type: "Get",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/shijuan/tianxie",//url
            data: {
                st: danid,
                daan: daan
            },
            async: true,  //必须要为false,必须必须//同步
            clearForm: true,        // 成功提交后，清除所有的表单元素的值.


            success: function (data) {

            },
            error: function (e) {

            }
        });
    });

}


