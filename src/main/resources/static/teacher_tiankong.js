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
                var id = data.teacherid;
                var html = id + "";
                html += "<a onclick='OnSelect(" + id + ")' class=\"action-icon\"><i class=\"mdi mdi-eye\"></i></a>"
                html += "<a onclick='OnUpdate(" + id + ")' class=\"action-icon\">  <i class=\"mdi mdi-square-edit-outline\"></i></a>"
                html += "<a onclick='deleteData(" + id + ")'  class=\"action-icon\"> <i class=\"mdi mdi-delete\"></i></a>"

                return html;
            }
        }

    ],


};


var firstTable;

firstTable = $('#xx').DataTable(datatables_options);


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




