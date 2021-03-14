var datatables_options = {

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

            //科目
            BankChoice.kemu = $("#kemu").val();
            //题目
            BankChoice.timu = $("#timu").val();

            BankChoice.teacherid = $("#chutiren").val();


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
            "sWidth": "120px",
            "orderable": false,
            "data": "id",
            'sClass': "text-center"
        },
        {
            "sWidth": "120px",
            "orderable": false,
            "data": "kemu",
            'sClass': "text-center"
        },
        {
            "sWidth": "120px",
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
            "sWidth": "200px",
            "orderable": false,
            "data": "d",
            'sClass': "text-center"
        },
        {
            "sWidth": "200px",
            "orderable": true,
            "data": "answer",
            'sClass': "text-center"
        },
        {
            "sWidth": "200px",
            "orderable": true,
            "data": "fenzhi",
            'sClass': "text-center"
        },
        {
            "sWidth": "200px",
            "orderable": true,
            "data": "teacher.teacherName",
            'sClass': "text-center"
        },


        {
            "sWidth": "60px",
            "orderable": false,
            "targets": 2,//操作按钮目标列
            "data": null,
            "sWidth": "250px",
            'sClass': "text-center",
            "render": function (data, type, row, meta) {
                var id = data.id;

                var t = data.quanxian;

                html = "";
                if (t == 0) {
                    html = "无权限操作";
                } else {

                    html += "<a onclick='Look(" + id + ")' class=\"action-icon\">  <i class=\"mdi mdi-square-edit-outline\"></i></a>"
                    html += "<a onclick='deleteData(" + id + ")'  class=\"action-icon\"> <i class=\"mdi mdi-delete\"></i></a>"

                }


                return html;
            }
        }

    ],


};


var firstTable;

firstTable = $('#xx').DataTable(datatables_options);

$("#toastr-three1").hide();
$("#toastr-three2").hide();
$("#toastr-three3").hide();
$("#toastr-four1").hide();
$("#toastr-four2").hide();
$("#toastr-four3").hide();

//执行条件查询
$("#searchButton").click(function () {
    firstTable.ajax.reload(null, false);
    firstTable.draw(false);
});


//清空输入框
$("#clearSearchButton").click(function () {
    //科目
    $("#kemu").val("");
    //题目
    $("#timu").val("");

    //出题人ID
    $("#chutiren").val("");

});

//提交成功
function SUCCESS(t) {
    if (t === 1) {
        $("#toastr-three1").click();
        $("#guanbi1").click();
    } else if (t === 2) {
        $("#toastr-three2").click();
        $("#guanbi2").click();
    } else if (t === 3) {
        $("#toastr-three3").click();
        $("#guanbi3").click();
    }

    firstTable.ajax.reload(null, false);
    firstTable.draw(false);
}

//提交失败
function ERROR(t) {
    if (t === 1) {
        $("#toastr-four1").click();
        $("#guanbi1").click();
    } else if (t === 2) {
        $("#toastr-four2").click();
        $("#guanbi2").click();
    } else if (t === 3) {
        $("#toastr-four3").click();
        $("#guanbi3").click();
    }
    firstTable.ajax.reload(null, false);
    firstTable.draw(false);
}

//提交按钮
function tijiaoButton() {
    var msg = $("#tianjiatable").serialize();

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
                SUCCESS(1);
            } else {
                //添加失败
                ERROR(1);
            }
        },
        error: function (e) {

        }
    });

}

//查看model
function Look(id) {
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

            $("#Upid").val(res.id)
            $("#Upkemu").val(res.kemu)
            $("#Uptimu").val(res.timu)
            $("#UpA").val(res.a)


            $("#UpB").val(res.b)

            $("#UpC").val(res.c)
            $("#UpD").val(res.d)
            $("#Updaan").val(res.answer)
            $("#Upfenzhi").val(res.fenzhi)


            $("#UpModal").modal()
        }
    });

}

//修改
function Up() {

    var msg = $("#xiugaitable").serialize();

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
                SUCCESS(2);
            } else {
                //修改失败
                ERROR(2);
            }
        },
        error: function (e) {

        }
    });

}

//删除
function del(id) {
    $.ajax({
        type: "get",
        url: "/bankChoiceService/del",
        async: true,
        data: {
            id: $("#zhi").html()
        },
        success: function (res) {
            //设置回显用户数据
            //赋值给全局id，方便修改后使用

            if (res === 1) {
                SUCCESS(3);
            } else {
                ERROR(3);
            }
        }
    });
}

//唤起删除model
function deleteData(id) {
    $("#zhi").html(id);
    $("#DelModal").modal();
}