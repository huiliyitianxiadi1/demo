var datatables_options = {
    language: {
        "lengthMenu": '<div class="row"> 每页显示<select class="form-control input-xsmall">' + '<option value="10">10</option>'
            + '<option value="20">20</option>'
            + '<option value="30">30</option>'
            + '<option value="40">40</option>'
            + '<option value="50">50</option>' + '</select>条</div>',
        "paginate": {
            "first": "首页",
            "last": "尾页",
            "previous": "上一页",
            "next": "下一页"
        },
        "processing": "加载中...",  //DataTables载入数据时，是否显示‘进度’提示
        "emptyTable": "暂无数据",
        "info": "共 _PAGES_ 页  _TOTAL_ 条数据  ",
        "infoEmpty": "暂无数据",
        "emptyTable": "暂无要处理的数据...",  //表格中无数据
        "search": "搜索:",
        "infoFiltered": " —— 从  _MAX_ 条数据中筛选",
        "zeroRecords": "没有找到记录"

    },
    ordering: false,//排序显示控制
    searching: false,
    paging: true,//开启分页
    processing: true,
    serverSide: true,//是否开启服务器模式

    ajax: {
        url: '/student/list',
        type: 'post',
        cache: false,
        data: function (d) {
            var student = {};

            student.studentName = $("#StudentName").val();
            student.studentEmail = $("#StudentEmail").val();
            student.studentNumber = $("#StudentNumber").val();


            if ($("#StudentSex").val() == 1) {
                student.studentSex = "男";
            } else if ($("#StudentSex").val() == 0) {
                student.studentSex = "女";
            } else {
                student.studentSex = "";
            }

            student.studentSchool = $("#studentSchool").val();

            student.studentSchool = "";

            student.studentPhone = $("#StudentPhone").val();

            if ($("#StudentStatus").val() === '-1') {
                student.studentStatus = "";
            } else {
                student.studentStatus = $("#StudentStatus").val();
            }


            student.pageSize = d.length;
            student.draw = d.draw;
            student.offset = d.start;
            return student;
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
            "orderable": false,
            "data": null,
            "sWidth": "120px",
            'sClass': "text-center",
            "render": function (data, type, row, meta) {
                var id = row.studentId;
                var html = "";
                html += "<input type=\"checkbox\" name='cb' id=cb" + id + " '  > "
                return html;
            }
        },
        {
            sTitle: '序号',
            data: null,
            "sWidth": "120px",
            className: 'text-center whiteSpace',
            render: function (data, type, row, meta) {
                return meta.row + 1 +
                    meta.settings._iDisplayStart;
            }
        },
        {
            "sWidth": "120px",
            "data": "studentId",
            "name": "id",
            "orderable": true,
            "sDefaultContent": "",  //默认空字符串
            "sClass": "text-center"
        },
        {
            "sWidth": "120px",
            "orderable": false,
            "data": "studentName",
            'sClass': "text-center"
        },
        {
            "sWidth": "120px",
            "orderable": false,
            "data": "studentEmail",
            'sClass': "text-center"
        },
        {
            "orderable": false,
            "data": "studentPassword",
            'sClass': "text-center"
        },
        {
            "orderable": false,
            "data": "studentNumber",
            'sClass': "text-center"
        },

        {
            "sWidth": "50px",
            "orderable": false,
            "data": "studentSex",
            'sClass': "text-center"
        },
        {
            "sWidth": "200px",
            "orderable": false,
            "data": "studentSchool",
            'sClass': "text-center"
        },
        {
            "sWidth": "200px",
            "orderable": true,
            "data": "studentPhone",
            'sClass': "text-center"
        },
        {
            "sWidth": "120px",
            "orderable": false,
            "data": "studentStatus",
            'sClass': "text-center",
            'render': function (data, type, row, meta) {
                var status = row.studentStatus
                var str = ''
                if (status === '1') {
                    str = '已确认'
                }
                if (status === '2') {
                    str = '待确认'
                }
                if (status === '3') {
                    str = '未确认'
                }
                return str

            }
        },

        {
            "sWidth": "120px",
            "orderable": false,
            "targets": 2,//操作按钮目标列
            "data": null,
            "sWidth": "250px",

            "render": function (data, type, row, meta) {
                var id = row.studentId;
                var html = "";


                if (row.photo != null) {
                    html += "<img  src='/getImgByIdAdmin?id=" + id + " '  > "
                } else {
                    html = "空";
                }
                return html;
            }
        },
        {
            "sWidth": "60px",
            "orderable": false,
            "targets": 2,//操作按钮目标列
            "data": null,
            "sWidth": "250px",
            'sClass': "text-center",
            "render": function (data, type, row, meta) {
                var id = row.studentId;
                var html = "";
                html += "<a onclick='OnSelect(" + id + ")' class=\"action-icon\"><i class=\"mdi mdi-eye\"></i></a>"
                html += "<a onclick='OnUpdate(" + id + ")' class=\"action-icon\">  <i class=\"mdi mdi-square-edit-outline\"></i></a>"
                html += "<a onclick='deleteData(" + id + ")'  class=\"action-icon\"> <i class=\"mdi mdi-delete\"></i></a>"

                return html;
            }
        }

    ],


};


var firstTable;
firstTable = $('#datatable_buttons').DataTable(datatables_options);

//添加点击事件
//点击行即可触发全选按钮
$('#datatable_buttons').on('click', 'tr', function () {
    var data = firstTable.row(this).data(); //获取单击那一行的数据
    var hkid = +data.studentId;

    if ($("#cb" + hkid).prop("checked") == true) { //如果值为checked表明选中了，
        //选中了
        $("#cb" + hkid).attr("checked", false);
    } else {
        //没选中
        $("#cb" + hkid).attr("checked", true);

    }

});

//执行条件查询
$("#searchButton").click(function () {
    firstTable.ajax.reload(null, false);
    firstTable.draw(false);
});


/*
function clearAddData() {
$("#StudentName").val('')
$("#StudentEmail").val('')
$("#StudentNumber").val('')

$("#StudentSex").val(-1)

$("#StudentSchool").val(-1)
$("#StudentPhone").val('')
$("#StudentStatus").val(-1)


}

*/

//全局用户id
var userId;


//查看model
function OnSelect(id) {
    $.ajax({
        type: "get",
        url: "/student/get",
        async: true,
        data: {
            userId: id
        },
        success: function (res) {
            //设置回显用户数据
            //赋值给全局id，方便修改后使用

            $("#selectID").val(res.studentId)
            $("#selectNumber").val(res.studentNumber)
            $("#selectName").val(res.studentName)
            $("#selectEmail").val(res.studentEmail)


            $("#selectSex").val(res.studentSex)

            $("#selectPassword").val(res.studentPassword)
            $("#selectSchool").val(res.studentSchool)
            $("#selectPhone").val(res.studentPhone)
            $("#selectStatus").val(res.studentStatus)

            $("#photo").html("<img src='/getImgByIdAdmin?id=" + id + "'></img>")

            $("#selectModel").modal()
        }
    });

}

//禁用输入框
jinyong();
//按钮显示为（修改）按钮
$("#selectBaoCun").hide();


//禁止输入框输入
function jinyong() {

    $('#selectID').attr("readonly", true);
    $('#selectNumber').attr("disabled", true);
    $('#selectName').attr("disabled", true);

    $('#selectEmail').attr("disabled", true);
    $('#selectSex').attr("disabled", true);
    $('#selectPassword').attr("disabled", true);
    $('#selectSchool').attr("disabled", true);

    $('#selectPhone').attr("disabled", true);
    $('#selectStatus').attr("disabled", true);

}

//允许输入框输入
function qiyong() {

    $('#selectNumber').attr("disabled", false);
    $('#selectName').attr("disabled", false);

    $('#selectEmail').attr("disabled", false);
    $('#selectSex').attr("disabled", false);
    $('#selectPassword').attr("disabled", false);
    $('#selectSchool').attr("disabled", false);

    $('#selectPhone').attr("disabled", false);
    $('#selectStatus').attr("disabled", false);
}

//点击修改按钮，修改按钮消失，显示保存按钮，内容可编辑
function selectUpd() {
    $("#selectUp").hide();
    $("#selectBaoCun").show();
    qiyong();

}

//修改提交
function selectbaocun() {
    var msg = $("#form_Select_st").serialize();

    $("#selectUp").show();
    $("#selectBaoCun").hide();
    jinyong();
    BaoCunXinXi(msg);
}

//ajax
//修改信息 保存
function BaoCunXinXi(msg) {
    //alert(msg);
    $.ajax({
        cache: false,//每次读取的是最新的数据。
        type: "POST",
        dataType: "json",//预期服务器返回的数据类型
        url: "/student/studentUpdate",
        data: msg,    //获取模态对话框的全部输入数据
        async: true,  //必须要为false,必须必须//同步
        clearForm: true,        // 成功提交后，清除所有的表单元素的值.

        success: function (data) {

            if (data == '1') {
                alert("修改成功" + data);

            } else {
                alert("失败" + data);
                //待补充
            }
        },
        error: function (e) {
            alert("error");
        }
    });


}

//检查界面-删除
function seldelButton() {
    var i = $("#selectID").val()
    $.ajax({
        type: "get",
        url: "/student/del",
        async: true,
        data: {
            id: i
        },
        success: function (res) {
            //设置回显用户数据
            //赋值给全局id，方便修改后使用

            if (res === true) {

                firstTable.ajax.reload(null, false);
                firstTable.draw(false);
            } else {
                alert("失败");
            }
        }
    });

}


//修改model
function OnUpdate(id) {
    $.ajax({
        type: "get",
        url: "/student/get",
        async: true,
        data: {
            userId: id
        },
        success: function (res) {
            //设置回显用户数据
            //赋值给全局id，方便修改后使用

            $("#updateID").val(res.studentId)
            $("#updateNumber").val(res.studentNumber)
            $("#updateName").val(res.studentName)
            $("#updateEmail").val(res.studentEmail)


            $("#updateSex").val(res.studentSex)

            $("#updatePassword").val(res.studentPassword)
            $("#updateSchool").val(res.studentSchool)
            $("#updatePhone").val(res.studentPhone)
            $("#updateStatus").val(res.studentStatus)

            $("#Upphoto").html("<img src='/getImgByIdAdmin?id=" + id + "'></img>")

            $("#UpdataModal").modal()
        }
    });

}

//唤起删除model
function deleteData(id) {
    $("#zhi").html(id);

    $("#DelModel").modal();
}

//删除model-提交删除
function delOk() {
    $.ajax({
        type: "get",
        url: "/student/del",
        async: true,
        data: {
            id: $("#zhi").html()
        },
        success: function (res) {
            //设置回显用户数据
            //赋值给全局id，方便修改后使用

            if (res === true) {

                firstTable.ajax.reload(null, false);
                firstTable.draw(false);
            } else {
                alert("失败");
            }
        }
    });
}


//清除已输入条件
$("#clearSearchButton").click(function () {

    $("#StudentName").val('')
    $("#StudentEmail").val('')
    $("#StudentNumber").val('')

    $("#StudentSex").val(-1)

    $("#StudentSchool").val(-1)
    $("#StudentPhone").val('')
    $("#StudentStatus").val(-1)

    //重置表单+6534
    firstTable.ajax.reload(null, false);
    firstTable.draw(false);
});


//全选控制
$("#all").on('click', function () {
    $("input[name='cb']").prop("checked", this.checked);
});

$("input[name='cb']").on('click', function () {
    var $subs = $("input[name='cb']");
    $("#all").prop("checked", $subs.length == $subs.filter(":checked").length ? true : false);
});

//一键同意
$("#oneOk").click(function () {
    var checkLength = $("input:checkbox[name='cb']:checked").length;
    if (checkLength == 0) {
        alert("请至少选择一条数据！");
        return;
    }
    $("input[type='checkbox']").each(function () { //遍历checkbox的选择状态
        if ($(this).prop("checked")) { //如果值为checked表明选中了，
            if (($(this).attr("name")) == ("cb")) {//且name值为check
                var id=$(this).closest('tr').find('td').eq(2).text();
                alert(  id); //获取eq为1的那一列数据

            }
        }
    });
});


//一键否决
$("#oneNo").click(function () {
    var checkLength = $("input:checkbox[name='cb']:checked").length;
    if (checkLength == 0) {
        alert("请至少选择一条数据！");
        return;
    }
    $("input[type='checkbox']").each(function () { //遍历checkbox的选择状态
        if ($(this).prop("checked")) { //如果值为checked表明选中了，
            if (($(this).attr("name")) == ("cb")) {//且name值为check
                var id=$(this).closest('tr').find('td').eq(2).text();
                alert(  id); //获取eq为1的那一列数据

            }
        }
    });
});