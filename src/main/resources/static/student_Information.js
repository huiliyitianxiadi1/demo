//禁止输入框输入
function jinyong() {

    $('#name').attr("disabled", true);
    $('#email').attr("disabled", true);
    $('#studentNumber').attr("disabled", true);

    $('#sex_nan1').attr("disabled", true);
    $('#sex_nv1').attr("disabled", true);
    $('#sex_nan2').attr("disabled", true);
    $('#sex_nv2').attr("disabled", true);

    $('#school').attr("disabled", true);
    $('#iphone').attr("disabled", true);

}

//允许输入框输入
function qiyong() {

    $('#name').attr("disabled", false);
    $('#studentNumber').attr("disabled", false);

    $('#sex_nv1').attr("disabled", false);
    $('#sex_nan1').attr("disabled", false);
    $('#sex_nv2').attr("disabled", false);
    $('#sex_nan2').attr("disabled", false);

    $('#school').attr("disabled", false);
    $('#iphone').attr("disabled", false);
}


//禁用输入框
jinyong();
//按钮显示为（修改）按钮
$("#baocun").hide();


//ajax
function BaoCunXinXi(msg) {
    //alert(msg);
    $.ajax({
        cache: false,//每次读取的是最新的数据。
        type: "POST",
        dataType: "json",//预期服务器返回的数据类型
        url: "/student/student_update",
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


//点击保存按钮
//隐藏（保存）按钮
//显示（修改）按钮

//提交
function baocunButton() {
    var msg = $("#xiugai_information").serialize();

    $("#xiugai").show();
    $("#baocun").hide();
    jinyong();
    BaoCunXinXi(msg);

}

//点击修改按钮--进入修改模式
//隐藏(修改)按钮
//显示(保存)按钮
//启用输入框
function XiugaiButton() {


    $("#xiugai").hide();
    $("#baocun").show();
    qiyong();

}
