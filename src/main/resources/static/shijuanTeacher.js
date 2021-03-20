var url = document.location.toString();//获取url地址
var urlParmStr = url.slice(url.indexOf('?') + 1);//获取问号后所有的字符串
var arr = urlParmStr.split('&');//通过&符号将字符串分割转成数组
var textID = arr[0].split("=")[1];//获取数组中第一个参数
var studentID = arr[1].split("=")[1];//第二个参数


function baocun() {



    $("input[name^='d']").each(function () {
        var length = ($(this).attr("name")).length;
        var danid = ($(this).attr("name")).substr(1, length - 1);
        var id = $(this).attr("id")
        var fenzhi = $("#" + id).val();
        $.ajax({
            cache: false,//每次读取的是最新的数据。
            type: "Get",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/shijuan/dafen",//url
            data: {
                st: danid,
                fenzhi: fenzhi
            },
            async: true,  //必须要为false,必须必须//同步
            success: function (data) {
            },
            error: function (e) {
            }
        });
    });

/*

        $("input[name^='t']").each(function () {
             var length = ($(this).attr("name")).length;
             var danid = ($(this).attr("name")).substr(1, length - 1);
             var id = $(this).attr("id")
             var fenzhi = $("#" + id).val();
             $.ajax({
                 cache: false,//每次读取的是最新的数据。
                 type: "Get",//方法类型
                 dataType: "json",//预期服务器返回的数据类型
                 url: "/shijuan/dafen",//url
                 data: {
                     st: danid,
                     fenzhi: fenzhi
                 },
                 async: true,  //必须要为false,必须必须//同步
                 success: function (data) {
                 },
                 error: function (e) {
                 }
             });
         });
*/

    /*  $("input[name^='z']").each(function () {


         var length = ($(this).attr("name")).length;

         var danid = ($(this).attr("name")).substr(1, length - 1);
         var id = $(this).attr("id")


         var fenzhi = $("#" + id).val();


         $.ajax({
             cache: false,//每次读取的是最新的数据。
             type: "Get",//方法类型
             dataType: "json",//预期服务器返回的数据类型
             url: "/shijuan/dafen",//url
             data: {
                 st: danid,
                 fenzhi: fenzhi
             },
             async: true,  //必须要为false,必须必须//同步
             clearForm: true,        // 成功提交后，清除所有的表单元素的值.


             success: function (data) {

             },
             error: function (e) {

             }
         });
     });
 */
}
