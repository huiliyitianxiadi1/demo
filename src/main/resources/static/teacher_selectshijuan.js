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
            var testTable = {};

            //科目
            //  testTable.kemu = $("#kemu").val();
            //题目
            //   testTable.timu = $("#timu").val();

            // testTable.teacherid = $("#chutiren").val();


            testTable.pageSize = d.length;
            testTable.draw = d.draw;
            testTable.offset = d.start;
            return testTable;
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
            "data": "testId",
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
