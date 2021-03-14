var datatables_options = {

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

            //科目
            BankFill.kemu = $("#kemu").val();
            //题目
            BankFill.timu = $("#timu").val();

            BankFill.teacherid = $("#chutiren").val();


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
            "sWidth": "200px",
            "orderable": false,
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


//情空
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
        url: "/BankFillService/add",//url
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
        url: "/bankFillService/get",
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

            $("#Upanswer1").val(res.answer1)


            $("#Upanswer2").val(res.answer2)

            $("#Upanswer3").val(res.answer3)

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
        url: "/BankFillService/up",//url
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
        url: "/BankFillService/del",
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
