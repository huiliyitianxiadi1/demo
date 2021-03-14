$("#toastr-three1").hide();
$("#toastr-three2").hide();
$("#toastr-three3").hide();
$("#toastr-four1").hide();
$("#toastr-four2").hide();
$("#toastr-four3").hide();

//***
//类型
//操作

//提交成功
function SUCCESS(t) {
    if (t === 11 || t === 21 || t === 31) {
        $("#toastr-three1").click();
        $("#guanbi11").click();
        $("#guanbi21").click();
        $("#guanbi31").click();

    } else if (t === 12 || t === 22 || t === 32) {
        $("#toastr-three2").click();
        $("#guanbi12").click();
        $("#guanbi22").click();
        $("#guanbi32").click();
    } else if (t === 13 || t === 23 || t === 33) {
        $("#toastr-three3").click();
        $("#guanbi13").click();
        $("#guanbi23").click();
        $("#guanbi33").click();
    }

    firstTable_dan.ajax.reload(null, false);
    firstTableTest_dan.draw(false);

    firstTable_Tian.ajax.reload(null, false);
    firstTable_Test_Tian.draw(false);

    firstTable_Zhu.ajax.reload(null, false);
    firstTable_Test_Zhu.draw(false);

}

//提交失败
function ERROR(t) {
    if (t === 11 || t === 21 || t === 31) {
        $("#toastr-four1").click();
        $("#guanbi11").click();
        $("#guanbi21").click();
        $("#guanbi31").click();

    } else if (t === 12 || t === 22 || t === 32) {
        $("#toastr-four2").click();
        $("#guanbi12").click();
        $("#guanbi22").click();
        $("#guanbi32").click();
    } else if (t === 13 || t === 23 || t === 33) {
        $("#toastr-four3").click();
        $("#guanbi13").click();
        $("#guanbi23").click();
        $("#guanbi33").click();
    }

    firstTable_dan.ajax.reload(null, false);
    firstTableTest_dan.draw(false);

    firstTable_Tian.ajax.reload(null, false);
    firstTable_Test_Tian.draw(false);

    firstTable_Zhu.ajax.reload(null, false);
    firstTable_Test_Zhu.draw(false);

}

function ADDSUCCESS() {

    firstTable_dan.ajax.reload(null, false);
    firstTableTest_dan.draw(false);

    firstTable_Tian.ajax.reload(null, false);
    firstTable_Test_Tian.draw(false);

    firstTable_Zhu.ajax.reload(null, false);
    firstTable_Test_Zhu.draw(false);

}

function ADDERROR() {
    firstTable_dan.ajax.reload(null, false);
    firstTableTest_dan.draw(false);

    firstTable_Tian.ajax.reload(null, false);
    firstTable_Test_Tian.draw(false);

    firstTable_Zhu.ajax.reload(null, false);
    firstTable_Test_Zhu.draw(false);

}

//题库单选题==============================================================================================//


var datatables_options_dan = {

    ordering: false,//排序显示控制
    searching: false,
    paging: true,//开启分页
    processing: true,
    serverSide: true,//是否开启服务器模式

    ajax: {
        url: '/bankChoiceService/select_all',
        type: 'post',
        cache: false,
        data: function (d) {
            var BankChoice = {};
            BankChoice.lr = 2;

            //科目
            BankChoice.kemu = $("#DANkemu").val();
            //题目
            BankChoice.timu = $("#DANtimu").val();

            BankChoice.teacherid = $("#DANchutiren").val();

            BankChoice.textId = $("#textID").text();

            BankChoice.pageSize = d.length;
            BankChoice.draw = d.draw;
            BankChoice.offset = d.start;
            return BankChoice;
        },

        dataFilter: function (json) {

            json = JSON.parse(json);

            var returnData = {};
            returnData.draw = json.draw;
            returnData.recordsTotal = json.recordsTotal;  //返回数据全部记录
            returnData.recordsFiltered = json.recordsFiltered;  //后台不实现过滤功能，每次查询均视作全部结果
            returnData.data = json.data;  //返回的数据列表
            return JSON.stringify(returnData); //这几个参数都是datatable需要的，必须要


        }
    },

    columns: [


        {
            "sWidth": "30px",
            "orderable": false,
            "targets": 2,//操作按钮目标列
            "data": null,
            "sWidth": "150px",
            'sClass': "text-center",
            "render": function (data, type, row, meta) {
                var id = data.id;


                html = "";

                html += "<input     type=\"checkbox\" id=\"subRA" + id + "\" name=\"subRA\"/> "


                return html;
            }
        },
        {
            "sWidth": "60px",
            "orderable": false,
            "data": "id",
            'sClass': "text-center"
        },
        {
            "sWidth": "70px",
            "orderable": false,
            "data": "kemu",
            'sClass': "text-center"
        },
        {
            "sWidth": "70px",
            "orderable": false,
            "data": "timu",
            'sClass': "text-center"
        },
        {
            "orderable": false,
            "data": "a",
            'sClass': "text-center"
        },
        {
            "orderable": false,
            "data": "b",
            'sClass': "text-center"
        },
        {
            "sWidth": "50px",
            "orderable": false,
            "data": "c",
            'sClass': "text-center"
        },
        {
            "sWidth": "50px",
            "orderable": false,
            "data": "d",
            'sClass': "text-center"
        },
        {
            "sWidth": "50px",
            "orderable": true,
            "data": "answer",
            'sClass': "text-center"
        },
        {
            "sWidth": "50px",
            "orderable": true,
            "data": "fenzhi",
            'sClass': "text-center"
        },
        {
            "sWidth": "50px",
            "orderable": true,
            "data": "teacher.teacherName",
            'sClass': "text-center"
        },
        {
            "sWidth": "60px",
            "orderable": false,
            "targets": 3,//操作按钮目标列
            "data": null,
            "sWidth": "150px",
            'sClass': "text-center",
            "render": function (data, type, row, meta) {
                var id = data.id;

                var t = data.quanxian;

                var Tetype = 1;
                var TestId = $("#textID").text();

                html = "<a onclick='TianJiaDan(" + id + "," + +Tetype + "," + TestId + ")' class=\"action-icon\"> <i class=\"mdi mdi-zodiac-cancer\"></i></a>";
                if (t === 0) {

                } else {

                    html += "<a onclick='Look_dan(" + id + ")' class=\"action-icon\">  <i class=\"mdi mdi-square-edit-outline\"></i></a>"
                    html += "<a onclick='deleteData_dan(" + id + ")'  class=\"action-icon\"> <i class=\"mdi mdi-delete\"></i></a>"

                }


                return html;
            }
        }

    ],


};

var firstTable_dan;

firstTable_dan = $('#danxuan').DataTable(datatables_options_dan);

//执行条件查询
$("#DANsearchButton").click(function () {
    firstTable_dan.ajax.reload(null, false);
    firstTable_dan.draw(false);
});


//清空输入框
$("#DANclearSearchButton").click(function () {
    //科目
    $("#DANkemu").val("");
    //题目
    $("#DANtimu").val("");

    //出题人ID
    $("#DANchutiren").val("");

});


//提交按钮
function tijiaoButton_dan() {
    var msg = $("#tianjiatable_dan").serialize();

    $.ajax({
        cache: false,//每次读取的是最新的数据。
        type: "Get",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/bankChoiceService/add",//url
        data: msg, //将模态框的form表单数据序列化，以便提交到后台
        async: true,  //必须要为false,必须必须//同步
        clearForm: true,        // 成功提交后，清除所有的表单元素的值.


        success: function (data) {
            if (data === true) {
                //添加成功
//                alert("添加成功")
                SUCCESS(11);
            } else {
                //添加失败
                ERROR(11);
            }
        },
        error: function (e) {

        }
    });

}

//查看model
function Look_dan(id) {
    $.ajax({
        type: "get",
        url: "/bankChoiceService/get",
        async: true,
        data: {
            id: id
        },
        success: function (res) {
            //设置回显用户数据
            //赋值给全局id，方便修改后使用

            $("#Upid_dan").val(res.id)
            $("#Upkemu_dan").val(res.kemu)
            $("#Uptimu_dan").val(res.timu)
            $("#UpA").val(res.a)


            $("#UpB").val(res.b)

            $("#UpC").val(res.c)
            $("#UpD").val(res.d)
            $("#Updaan").val(res.answer)
            $("#Upfenzhi_dan").val(res.fenzhi)


            $("#UpModal_dan").modal()
        }
    });

}

//修改
function Up_dan() {

    var msg = $("#xiugaitable_dan").serialize();

    $.ajax({
        cache: false,//每次读取的是最新的数据。
        type: "Get",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/bankChoiceService/up",//url
        data: msg, //将模态框的form表单数据序列化，以便提交到后台
        async: true,  //必须要为false,必须必须//同步
        clearForm: true,        // 成功提交后，清除所有的表单元素的值.


        success: function (data) {
            if (data == 1) {
                //修改成功
                // alert("添加成功")
                SUCCESS(12);
            } else {
                //修改失败
                ERROR(12);
            }
        },
        error: function (e) {

        }
    });

}

//删除
function del_dan(id) {
    $.ajax({
        type: "get",
        url: "/bankChoiceService/del",
        async: true,
        data: {
            id: $("#zhi_dan").html()
        },
        success: function (res) {
            //设置回显用户数据
            //赋值给全局id，方便修改后使用

            if (res === 1) {
                SUCCESS(13);
            } else {
                ERROR(13);
            }
        }
    });
}

//唤起删除model
function deleteData_dan(id) {
    $("#zhi_dan").html(id);
    $("#DelModal_dan").modal();
}


//试卷单选题==============================================================================================//


var datatables_options_test_dan = {

    ordering: false,//排序显示控制
    searching: false,
    paging: true,//开启分页
    processing: true,
    serverSide: true,//是否开启服务器模式

    ajax: {
        url: '/bankChoiceService/select_all',
        type: 'post',
        cache: false,
        data: function (d) {
            var BankChoice = {};
            BankChoice.lr = 1;

            //科目
            BankChoice.kemu = $("#DANkemu").val();
            //题目
            BankChoice.timu = $("#DANtimu").val();

            BankChoice.teacherid = $("#DANchutiren").val();

            BankChoice.textId = $("#textID").text();

            BankChoice.pageSize = d.length;
            BankChoice.draw = d.draw;
            BankChoice.offset = d.start;
            return BankChoice;
        },

        dataFilter: function (json) {

            json = JSON.parse(json);

            var returnData = {};
            returnData.draw = json.draw;
            returnData.recordsTotal = json.recordsTotal;  //返回数据全部记录
            returnData.recordsFiltered = json.recordsFiltered;  //后台不实现过滤功能，每次查询均视作全部结果
            returnData.data = json.data;  //返回的数据列表
            return JSON.stringify(returnData); //这几个参数都是datatable需要的，必须要


        }
    },

    columns: [


        {
            "sWidth": "30px",
            "orderable": false,
            "targets": 2,//操作按钮目标列
            "data": null,
            "sWidth": "150px",
            'sClass': "text-center",
            "render": function (data, type, row, meta) {
                var id = data.id;

                var t = data.quanxian;

                html = "";

                html += "<input     type=\"checkbox\" id=\"subLA" + id + "\" name=\"subLA\"/> "

                return html;
            }
        },
        {
            "sWidth": "60px",
            "orderable": false,
            "data": "id",
            'sClass': "text-center"
        },
        {
            "sWidth": "70px",
            "orderable": false,
            "data": "kemu",
            'sClass': "text-center"
        },
        {
            "sWidth": "70px",
            "orderable": false,
            "data": "timu",
            'sClass': "text-center"
        },
        {
            "orderable": false,
            "data": "a",
            'sClass': "text-center"
        },
        {
            "orderable": false,
            "data": "b",
            'sClass': "text-center"
        },
        {
            "sWidth": "50px",
            "orderable": false,
            "data": "c",
            'sClass': "text-center"
        },
        {
            "sWidth": "50px",
            "orderable": false,
            "data": "d",
            'sClass': "text-center"
        },
        {
            "sWidth": "50px",
            "orderable": true,
            "data": "answer",
            'sClass': "text-center"
        },
        {
            "sWidth": "50px",
            "orderable": true,
            "data": "fenzhi",
            'sClass': "text-center"
        },
        {
            "sWidth": "50px",
            "orderable": true,
            "data": "teacher.teacherName",
            'sClass': "text-center"
        },
        {
            "sWidth": "60px",
            "orderable": false,
            "targets": 3,//操作按钮目标列
            "data": null,
            "sWidth": "150px",
            'sClass': "text-center",
            "render": function (data, type, row, meta) {
                var id = data.id;

                var t = data.quanxian;

                var Tetype = 1;
                var TestId = $("#textID").text();

                html = "<a onclick='YiChu(" + id + "," + +Tetype + "," + TestId + ")' class=\"action-icon\"> <i class=\"mdi mdi-zodiac-cancer\"></i></a>";
                if (t === 0) {

                } else {

                    html += "<a onclick='Look_dan(" + id + ")' class=\"action-icon\">  <i class=\"mdi mdi-square-edit-outline\"></i></a>"
                    html += "<a onclick='deleteData_dan(" + id + ")'  class=\"action-icon\"> <i class=\"mdi mdi-delete\"></i></a>"

                }


                return html;
            }
        }
    ],


};


var firstTableTest_dan;

firstTableTest_dan = $('#Testdanxuan').DataTable(datatables_options_test_dan);


//题库填空题====2==========================================================================================//


var datatables_options_Tian = {

    ordering: false,//排序显示控制
    searching: false,
    paging: true,//开启分页
    processing: true,
    serverSide: true,//是否开启服务器模式

    ajax: {
        url: '/bankFillService/select_all',
        type: 'post',
        cache: false,
        data: function (d) {
            var BankFill = {};

            BankFill.lr = 2;

            //科目
            BankFill.kemu = $("#Tiankemu").val();
            //题目
            BankFill.timu = $("#Tiantimu").val();

            BankFill.teacherid = $("#Tianchutiren").val();

            BankFill.textId = $("#textID").text();


            BankFill.pageSize = d.length;
            BankFill.draw = d.draw;
            BankFill.offset = d.start;
            return BankFill;
        },

        dataFilter: function (json) {

            json = JSON.parse(json);

            var returnData = {};
            returnData.draw = json.draw;
            returnData.recordsTotal = json.recordsTotal;  //返回数据全部记录
            returnData.recordsFiltered = json.recordsFiltered;  //后台不实现过滤功能，每次查询均视作全部结果
            returnData.data = json.data;  //返回的数据列表
            return JSON.stringify(returnData); //这几个参数都是datatable需要的，必须要


        }
    },

    columns: [
//
        {
            "sWidth": "60px",
            "orderable": false,
            "targets": 2,//操作按钮目标列
            "data": null,
            "sWidth": "150px",
            'sClass': "text-center",
            "render": function (data, type, row, meta) {
                var id = data.id;

                html = "";
                html += "<input     type=\"checkbox\" id=\"subRB" + id + "\" name=\"subRB\"/> "


                return html;
            }
        },
        {
            "sWidth": "70px",
            "orderable": false,
            "data": "id",
            'sClass': "text-center"
        },
        {
            "sWidth": "70px",
            "orderable": false,
            "data": "kemu",
            'sClass': "text-center"
        },
        {
            "sWidth": "70px",
            "orderable": false,
            "data": "timu",
            'sClass': "text-center"
        },
        {
            "orderable": false,
            "data": "answer1",
            'sClass': "text-center"
        },
        {
            "orderable": false,
            "data": "answer2",
            'sClass': "text-center"
        },
        {
            "sWidth": "50px",
            "orderable": false,
            "data": "answer3",
            'sClass': "text-center"
        },
        {
            "sWidth": "50px",
            "orderable": false,
            "data": "fenzhi",
            'sClass': "text-center"
        },
        {
            "sWidth": "50px",
            "orderable": true,
            "data": "teacher.teacherName",
            'sClass': "text-center"
        },
        {
            "sWidth": "60px",
            "orderable": false,
            "targets": 3,//操作按钮目标列
            "data": null,
            "sWidth": "150px",
            'sClass': "text-center",
            "render": function (data, type, row, meta) {
                var id = data.id;

                var t = data.quanxian;

                var Tetype = 2;
                var TestId = $("#textID").text();

                html = "<a onclick='TianJiaDan(" + id + "," + +Tetype + "," + TestId + ")' class=\"action-icon\"> <i class=\"mdi mdi-zodiac-cancer\"></i></a>";
                if (t === 0) {

                } else {

                    html += "<a onclick='Look_tian(" + id + ")' class=\"action-icon\">  <i class=\"mdi mdi-square-edit-outline\"></i></a>"
                    html += "<a onclick='deleteData_tian(" + id + ")'  class=\"action-icon\"> <i class=\"mdi mdi-delete\"></i></a>"

                }


                return html;
            }
        }
    ],


};

var firstTable_Tian;

firstTable_Tian = $('#tiankong').DataTable(datatables_options_Tian);

//执行条件查询
$("#TiansearchButton").click(function () {
    firstTable_Tian.ajax.reload(null, false);
    firstTable_Tian.draw(false);
});


//清空
$("#TianclearSearchButton").click(function () {
    //科目
    $("#Tiankemu").val("");
    //题目
    $("#Tiantimu").val("");

    //出题人ID
    $("#Tianchutiren").val("");

});


//提交按钮
function tijiaoButton_tian() {
    var msg = $("#tianjiatable_tian").serialize();


    $.ajax({
        cache: false,//每次读取的是最新的数据。
        type: "Get",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/BankFillService/add",//url
        data: msg, //将模态框的form表单数据序列化，以便提交到后台
        async: true,  //必须要为false,必须必须//同步
        clearForm: true,        // 成功提交后，清除所有的表单元素的值.


        success: function (data) {
            if (data === true) {
                //添加成功
//                alert("添加成功")
                SUCCESS(21);
            } else {
                //添加失败
                ERROR(21);
            }
        },
        error: function (e) {

        }
    });

}

//查看model
function Look_tian(id) {

    $.ajax({
        type: "get",
        url: "/bankFillService/get",
        async: true,
        data: {
            id: id
        },
        success: function (res) {
            //设置回显用户数据
            //赋值给全局id，方便修改后使用

            $("#Upid_tian").val(res.id)
            $("#Upkemu_tian").val(res.kemu)
            $("#Uptimu_tian").val(res.timu)

            $("#Upanswer1").val(res.answer1)


            $("#Upanswer2").val(res.answer2)

            $("#Upanswer3").val(res.answer3)

            $("#Upfenzhi_tian").val(res.fenzhi)


            $("#UpModal_tian").modal()
        }
    });

}

//修改
function Up_tian() {

    var msg = $("#xiugaitable_tian").serialize();

    $.ajax({
        cache: false,//每次读取的是最新的数据。
        type: "Get",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/BankFillService/up",//url
        data: msg, //将模态框的form表单数据序列化，以便提交到后台
        async: true,  //必须要为false,必须必须//同步
        clearForm: true,        // 成功提交后，清除所有的表单元素的值.


        success: function (data) {
            if (data == 1) {
                //修改成功
                // alert("添加成功")
                SUCCESS(22);
            } else {
                //修改失败
                ERROR(22);
            }
        },
        error: function (e) {

        }
    });

}

//删除
function del_tian(id) {
    $.ajax({
        type: "get",
        url: "/BankFillService/del",
        async: true,
        data: {
            id: $("#zhi_tian").html()
        },
        success: function (res) {
            //设置回显用户数据
            //赋值给全局id，方便修改后使用

            if (res === 1) {
                SUCCESS(23);
            } else {
                ERROR(23);
            }
        }
    });
}

//唤起删除model
function deleteData_tian(id) {
    $("#zhi_tian").html(id);
    $("#DelModal_tian").modal();
}


//试卷填空题=====1=========================================================================================//

var datatables_options_Test_Tian = {

    ordering: false,//排序显示控制
    searching: false,
    paging: true,//开启分页
    processing: true,
    serverSide: true,//是否开启服务器模式

    ajax: {
        url: '/bankFillService/select_all',
        type: 'post',
        cache: false,
        data: function (d) {
            var BankSubjective = {};

            BankSubjective.lr = 1;


            BankSubjective.textId = $("#textID").text();


            BankSubjective.pageSize = d.length;
            BankSubjective.draw = d.draw;
            BankSubjective.offset = d.start;
            return BankSubjective;
        },

        dataFilter: function (json) {

            json = JSON.parse(json);

            var returnData = {};
            returnData.draw = json.draw;
            returnData.recordsTotal = json.recordsTotal;  //返回数据全部记录
            returnData.recordsFiltered = json.recordsFiltered;  //后台不实现过滤功能，每次查询均视作全部结果
            returnData.data = json.data;  //返回的数据列表
            return JSON.stringify(returnData); //这几个参数都是datatable需要的，必须要


        }
    },

    columns: [
        {
            "sWidth": "60px",
            "orderable": false,
            "targets": 2,//操作按钮目标列
            "data": null,
            "sWidth": "150px",
            'sClass': "text-center",
            "render": function (data, type, row, meta) {
                var id = data.id;

                html = "";
                html += "<input     type=\"checkbox\" id=\"subLB" + id + "\" name=\"subLB\"/> "


                return html;
            }
        },
        {
            "sWidth": "70px",
            "orderable": false,
            "data": "id",
            'sClass': "text-center"
        },
        {
            "sWidth": "70px",
            "orderable": false,
            "data": "kemu",
            'sClass': "text-center"
        },
        {
            "sWidth": "70px",
            "orderable": false,
            "data": "timu",
            'sClass': "text-center"
        },
        {
            "orderable": false,
            "data": "answer1",
            'sClass': "text-center"
        },
        {
            "orderable": false,
            "data": "answer2",
            'sClass': "text-center"
        },
        {
            "sWidth": "50px",
            "orderable": false,
            "data": "answer3",
            'sClass': "text-center"
        },
        {
            "sWidth": "50px",
            "orderable": false,
            "data": "fenzhi",
            'sClass': "text-center"
        },
        {
            "sWidth": "50px",
            "orderable": true,
            "data": "teacher.teacherName",
            'sClass': "text-center"
        },
        {
            "sWidth": "60px",
            "orderable": false,
            "targets": 3,//操作按钮目标列
            "data": null,
            "sWidth": "150px",
            'sClass': "text-center",
            "render": function (data, type, row, meta) {
                var id = data.id;

                var t = data.quanxian;

                var Tetype = 2;
                var TestId = $("#textID").text();

                html = "<a onclick='YiChu(" + id + "," + +Tetype + "," + TestId + ")' class=\"action-icon\"> <i class=\"mdi mdi-zodiac-cancer\"></i></a>";
                if (t === 0) {

                } else {

                    html += "<a onclick='Look_tian(" + id + ")' class=\"action-icon\">  <i class=\"mdi mdi-square-edit-outline\"></i></a>"
                    html += "<a onclick='deleteData_tian(" + id + ")'  class=\"action-icon\"> <i class=\"mdi mdi-delete\"></i></a>"

                }


                return html;
            }
        }
    ],


};

var firstTable_Test_Tian;

firstTable_Test_Tian = $('#Testtiankong').DataTable(datatables_options_Test_Tian);


//题库主观题====2==========================================================================================//


var datatables_options_Zhu = {

    ordering: false,//排序显示控制
    searching: false,
    paging: true,//开启分页
    processing: true,
    serverSide: true,//是否开启服务器模式

    ajax: {
        url: '/bankSubjectiveService/select_all',
        type: 'post',
        cache: false,
        data: function (d) {
            var BankSubjective = {};


            BankSubjective.textId = $("#textID").text();


            //科目
            BankSubjective.kemu = $("#Zhukemu").val();
            //题目
            BankSubjective.timu = $("#Zhutimu").val();

            BankSubjective.teacherid = $("#Zhuchutiren").val();

            BankSubjective.lr = 2;

            BankSubjective.pageSize = d.length;
            BankSubjective.draw = d.draw;
            BankSubjective.offset = d.start;
            return BankSubjective;
        },

        dataFilter: function (json) {

            json = JSON.parse(json);

            var returnData = {};
            returnData.draw = json.draw;
            returnData.recordsTotal = json.recordsTotal;  //返回数据全部记录
            returnData.recordsFiltered = json.recordsFiltered;  //后台不实现过滤功能，每次查询均视作全部结果
            returnData.data = json.data;  //返回的数据列表
            return JSON.stringify(returnData); //这几个参数都是datatable需要的，必须要


        }
    },

    columns: [
        {
            "sWidth": "60px",
            "orderable": false,
            "targets": 2,//操作按钮目标列
            "data": null,
            "sWidth": "150px",
            'sClass': "text-center",
            "render": function (data, type, row, meta) {
                var id = data.id;

                html = "";
                html += "<input     type=\"checkbox\" id=\"subRC" + id + "\" name=\"subRC\"/> "


                return html;
            }
        },
        {
            "sWidth": "70px",
            "orderable": false,
            "data": "id",
            'sClass': "text-center"
        },
        {
            "sWidth": "70px",
            "orderable": false,
            "data": "kemu",
            'sClass': "text-center"
        },
        {
            "sWidth": "70px",
            "orderable": false,
            "data": "timu",
            'sClass': "text-center"
        },


        {
            "sWidth": "50px",
            "orderable": true,
            "data": "referenceanswer",
            'sClass': "text-center"
        },
        {
            "sWidth": "20px",
            "orderable": true,
            "data": "fenzhi",
            'sClass': "text-center"
        },

        {
            "sWidth": "50px",
            "orderable": true,
            "data": "teacher.teacherName",
            'sClass': "text-center"
        },
        {
            "sWidth": "60px",
            "orderable": false,
            "targets": 3,//操作按钮目标列
            "data": null,
            "sWidth": "150px",
            'sClass': "text-center",
            "render": function (data, type, row, meta) {
                var id = data.id;

                var t = data.quanxian;

                var Tetype = 3;
                var TestId = $("#textID").text();

                html = "<a onclick='TianJiaDan(" + id + "," + +Tetype + "," + TestId + ")' class=\"action-icon\"> <i class=\"mdi mdi-zodiac-cancer\"></i></a>";
                if (t === 0) {

                } else {

                    html += "<a onclick='Look_zhu(" + id + ")' class=\"action-icon\">  <i class=\"mdi mdi-square-edit-outline\"></i></a>"
                    html += "<a onclick='deleteData_zhu(" + id + ")'  class=\"action-icon\"> <i class=\"mdi mdi-delete\"></i></a>"

                }


                return html;
            }
        }

    ],


};


var firstTable_Zhu;

firstTable_Zhu = $('#zhuguan_zhu').DataTable(datatables_options_Zhu);


//执行条件查询
$("#ZhusearchButton").click(function () {
    firstTable_Zhu.ajax.reload(null, false);
    firstTable_Zhu.draw(false);
});


//清空
$("#ZhuclearSearchButton").click(function () {
    //科目
    $("#Zhukemu").val("");
    //题目
    $("#Zhutimu").val("");

    //出题人ID
    $("#Zhuchutiren").val("");

});


//提交按钮
function tijiaoButton_zhu() {
    var msg = $("#tianjiatable_zhu").serialize();


    $.ajax({
        cache: false,//每次读取的是最新的数据。
        type: "Get",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/BankSubjectiveService/add",//url
        data: msg, //将模态框的form表单数据序列化，以便提交到后台
        async: true,  //必须要为false,必须必须//同步
        clearForm: true,        // 成功提交后，清除所有的表单元素的值.


        success: function (data) {
            if (data === true) {
                //添加成功
//                alert("添加成功")
                SUCCESS(31);
            } else {
                //添加失败
                ERROR(31);
            }
        },
        error: function (e) {

        }
    });

}

//查看model
function Look_zhu(id) {

    $.ajax({
        type: "get",
        url: "/bankSubjectiveService/get",
        async: true,
        data: {
            id: id
        },
        success: function (res) {
            //设置回显用户数据
            //赋值给全局id，方便修改后使用

            $("#Upid_zhu").val(res.id)
            $("#Upkemu_zhu").val(res.kemu)
            $("#Uptimu_zhu").val(res.timu)

            $("#Upreferenceanswer").val(res.referenceanswer)


            $("#Upfenzhi_zhu").val(res.fenzhi)


            $("#UpModal_zhu").modal()
        }
    });

}

//修改
function Up_zhu() {

    var msg = $("#xiugaitable_zhu").serialize();

    $.ajax({
        cache: false,//每次读取的是最新的数据。
        type: "Get",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/BankSubjectiveService/up",//url
        data: msg, //将模态框的form表单数据序列化，以便提交到后台
        async: true,  //必须要为false,必须必须//同步
        clearForm: true,        // 成功提交后，清除所有的表单元素的值.


        success: function (data) {
            if (data == 1) {
                //修改成功
                // alert("添加成功")
                SUCCESS(32);
            } else {
                //修改失败
                ERROR(32);
            }
        },
        error: function (e) {

        }
    });

}

//删除
function del_zhu(id) {
    $.ajax({
        type: "get",
        url: "/BankSubjectiveService/del",
        async: true,
        data: {
            id: $("#zhi_zhu").html()
        },
        success: function (res) {
            //设置回显用户数据
            //赋值给全局id，方便修改后使用

            if (res === 1) {
                SUCCESS(33);
            } else {
                ERROR(33);
            }
        }
    });
}

//唤起删除model
function deleteData_zhu(id) {
    $("#zhi_zhu").html(id);
    $("#DelModal_zhu").modal();
}


//试卷主观题=====1=========================================================================================//

var datatables_options_Test_Zhu = {

    ordering: false,//排序显示控制
    searching: false,
    paging: true,//开启分页
    processing: true,
    serverSide: true,//是否开启服务器模式

    ajax: {
        url: '/bankSubjectiveService/select_all',
        type: 'post',
        cache: false,
        data: function (d) {
            var BankSubjective = {};

            //科目
            BankSubjective.kemu = $("#kemu").val();
            //题目
            BankSubjective.timu = $("#timu").val();

            BankSubjective.teacherid = $("#chutiren").val();

            BankSubjective.textId = $("#textID").text();

            BankSubjective.lr = 1;


            BankSubjective.pageSize = d.length;
            BankSubjective.draw = d.draw;
            BankSubjective.offset = d.start;
            return BankSubjective;
        },

        dataFilter: function (json) {

            json = JSON.parse(json);

            var returnData = {};
            returnData.draw = json.draw;
            returnData.recordsTotal = json.recordsTotal;  //返回数据全部记录
            returnData.recordsFiltered = json.recordsFiltered;  //后台不实现过滤功能，每次查询均视作全部结果
            returnData.data = json.data;  //返回的数据列表
            return JSON.stringify(returnData); //这几个参数都是datatable需要的，必须要


        }
    },

    columns: [
        {
            "sWidth": "60px",
            "orderable": false,
            "targets": 2,//操作按钮目标列
            "data": null,
            "sWidth": "150px",
            'sClass': "text-center",
            "render": function (data, type, row, meta) {
                var id = data.id;

                html = "";
                html += "<input     type=\"checkbox\" id=\"subLC" + id + "\" name=\"subLC\"/> "


                return html;
            }
        },
        {
            "sWidth": "70px",
            "orderable": false,
            "data": "id",
            'sClass': "text-center"
        },
        {
            "sWidth": "70px",
            "orderable": false,
            "data": "kemu",
            'sClass': "text-center"
        },
        {
            "sWidth": "70px",
            "orderable": false,
            "data": "timu",
            'sClass': "text-center"
        },


        {
            "sWidth": "50px",
            "orderable": true,
            "data": "referenceanswer",
            'sClass': "text-center"
        },
        {
            "sWidth": "20px",
            "orderable": true,
            "data": "fenzhi",
            'sClass': "text-center"
        },

        {
            "sWidth": "50px",
            "orderable": true,
            "data": "teacher.teacherName",
            'sClass': "text-center"
        },
        {
            "sWidth": "60px",
            "orderable": false,
            "targets": 3,//操作按钮目标列
            "data": null,
            "sWidth": "150px",
            'sClass': "text-center",
            "render": function (data, type, row, meta) {
                var id = data.id;

                var t = data.quanxian;

                var Tetype = 3;
                var TestId = $("#textID").text();

                html = "<a onclick='YiChu(" + id + "," + +Tetype + "," + TestId + ")' class=\"action-icon\"> <i class=\"mdi mdi-zodiac-cancer\"></i></a>";
                if (t === 0) {

                } else {

                    html += "<a onclick='Look_zhu(" + id + ")' class=\"action-icon\">  <i class=\"mdi mdi-square-edit-outline\"></i></a>"
                    html += "<a onclick='deleteData_zhu(" + id + ")'  class=\"action-icon\"> <i class=\"mdi mdi-delete\"></i></a>"

                }


                return html;
            }
        }

    ],


};


var firstTable_Test_Zhu;

firstTable_Test_Zhu = $('#Testzhuguan').DataTable(datatables_options_Test_Zhu);


//================================================================================================================//
function TianJiaDan(id, type, TestId) {
    //id-题id。。。。
    //alert(id + " " + type+" "+TestId);
    //testId 考试码
    //type
    //dan_id,tian_id,zhu_id

    var neirong
    if (type === 1) {
        neirong = 'testId=' + TestId + '&type=' + type + '&danId=' + id

    } else if (type === 2) {
        neirong = 'testId=' + TestId + '&type=' + type + '&tianId=' + id
    } else if (type === 3) {
        neirong = 'testId=' + TestId + '&type=' + type + '&zhuId=' + id
    }


    $.ajax({
        cache: false,//每次读取的是最新的数据。
        type: "Get",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/chakan/AddTestTable",//url
        data: neirong,
        async: true,  //必须要为false,必须必须//同步
        clearForm: true,        // 成功提交后，清除所有的表单元素的值.


        success: function (data) {

            ADDSUCCESS();
        },
        error: function (e) {

        }
    });

}

function YiChu(id, type, TestId) {
    //id-题id。。。。
    //alert(id + " " + type+" "+TestId);
    //testId 考试码
    //type
    //dan_id,tian_id,zhu_id

    var neirong
    if (type === 1) {
        neirong = 'testId=' + TestId + '&type=' + type + '&danId=' + id

    } else if (type === 2) {
        neirong = 'testId=' + TestId + '&type=' + type + '&tianId=' + id
    } else if (type === 3) {
        neirong = 'testId=' + TestId + '&type=' + type + '&zhuId=' + id
    }


    $.ajax({
        cache: false,//每次读取的是最新的数据。
        type: "Get",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/chakan/DelTestTable",//url
        data: neirong,
        async: true,  //必须要为false,必须必须//同步
        clearForm: true,        // 成功提交后，清除所有的表单元素的值.


        success: function (data) {

            ADDSUCCESS();
        },
        error: function (e) {

        }
    });

}
