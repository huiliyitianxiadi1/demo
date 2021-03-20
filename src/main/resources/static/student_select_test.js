$("#toastr-three1").hide();
$("#toastr-three2").hide();
$("#toastr-three3").hide();
$("#toastr-four1").hide();
$("#toastr-four2").hide();
$("#toastr-four3").hide();

$("#toastr-three11").hide();
$("#toastr-four11").hide();

$("#shoudong").hide();
document.getElementById("shoudong").disabled = true;

//提交成功
function SUCCESS() {
    $("#toastr-three11").click();
    $("#guanbi").click();

}

//提交失败
function ERROR() {
    $("#toastr-four11").click();
    $("#guanbi").click();
}

var datatables_options = {

    ordering: false,//排序显示控制
    searching: false,
    paging: true,//开启分页
    processing: true,
    serverSide: true,//是否开启服务器模式

    ajax: {
        url: '/chakan/select_all',
        type: 'post',
        cache: false,
        data: function (d) {
            var test = {};

            //判断传入身份
            //2--学生
            test.shenfen = 2;

            //名字
            test.name = $("#name").val();
            //科目
            test.kemu = $("#kemu").val();
            //开始时间
            //   test.begin = $("#begin").val();
            //结束结束
            // test.end = $("#end").val();
            //出题人ID
            test.teacherId = $("#chutiren").val();


            test.pageSize = d.length;
            test.draw = d.draw;
            test.offset = d.start;
            return test;
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
            "data": "name",
            'sClass': "text-center"
        },
        {
            "sWidth": "120px",
            "orderable": false,
            "data": "begin",
            'sClass': "text-center"
        },
        {
            "orderable": false,
            "data": "end",
            'sClass': "text-center"
        },
        {
            "orderable": false,
            "data": "fenzhi",
            'sClass': "text-center"
        },
        {
            "sWidth": "50px",
            "orderable": false,
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
                var testid = data.id;

                html = "<a onclick='GoModel(" + testid + ")' class=\"action-icon\">   <i class=\"mdi mdi-eye\"></i></a>"


                return html;
            }
        }

    ],


};

var firstTable;

firstTable = $('#xx').DataTable(datatables_options);

//唤起参加考试model
function GoModel(id) {
    $("#testid").html(id);
    $("#chuangjiankaoshi").modal();
}


//提交操作
function tianjia() {
    $.ajax({
        type: "get",
        url: "/studentTest/insert",
        async: true,
        data: {
            testid: $("#testid").html()
        },
        success: function (res) {
            if (res === 1) {
                //成功
                SUCCESS();
            } else if (res === -1) {
                //失败
                //已添加
                ERROR();
            }


        }
    });
}