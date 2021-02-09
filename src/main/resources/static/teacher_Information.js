//禁止输入框输入
function jinyong() {

    $('#name').attr("disabled", true);
    $('#email').attr("disabled", true);
    $('#teacherNumber').attr("disabled", true);

    $('#sex_nan1').attr("disabled", true);
    $('#sex_nv1').attr("disabled", true);
    $('#sex_nan2').attr("disabled", true);
    $('#sex_nv2').attr("disabled", true);

    $('#school').attr("disabled", true);
    $('#iphone').attr("disabled", true);
    $('#subject').attr("disabled", true);
    $('#title').attr("disabled", true);


}

//允许输入框输入
function qiyong() {

    $('#name').attr("disabled", false);
    $('#teacherNumber').attr("disabled", false);

    $('#sex_nv1').attr("disabled", false);
    $('#sex_nan1').attr("disabled", false);
    $('#sex_nv2').attr("disabled", false);
    $('#sex_nan2').attr("disabled", false);

    $('#school').attr("disabled", false);
    $('#iphone').attr("disabled", false);
    $('#subject').attr("disabled", false);
    $('#title').attr("disabled", false);
}


//禁用输入框
jinyong();
//按钮显示为（修改）按钮
$("#baocun").hide();


//ajax
//修改信息-教师
function BaoCunXinXi(msg) {
    // alert(msg);
    $.ajax({
        cache: false,//每次读取的是最新的数据。
        type: "POST",
        dataType: "json",//预期服务器返回的数据类型
        url: "/teacher/teacher_update",
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


//ajax
//修改密码
//  外层的 AJAX 和内层的 AJAX 的 async 属性都要设置为 false,
//  如果不这样的话, 两次请求都是异步的, 可能会导致数据获取不到,
//  但是也有一个弊端, 因为同步, 在异步请求时, 浏览器是锁死状态, 不能进行其他的操作.
function teacher_verification_password_Button() {

    var message = $("#old_form_password").serialize();


    $.ajax({
        cache: false,//每次读取的是最新的数据。
        type: "POST",
        dataType: "json",//预期服务器返回的数据类型
        url: "/teacher/check_teacher_old_password",
        data: message,    //获取模态对话框的全部输入数据
        async: false,  //必须要为false,必须必须//同步
        clearForm: true,        // 成功提交后，清除所有的表单元素的值.

        success: function (data) {

            if (data == '1') {
                // alert("一致" + data);
                //触发model
                $('#xiugai_tea').modal();


            } else {
                alert("不一致" + data);
                //待补充
            }
        },
        error: function (e) {
            alert("error");
        }
    });

}


//确认修改密码按钮
function xiugai_tea_ok() {

    var message2 = $("#xiugai_tea_form").serialize();
    // alert(message2);

    $.ajax({
        cache: false,//每次读取的是最新的数据。
        type: "POST",
        dataType: "json",//预期服务器返回的数据类型
        url: "/teacher/teacher_update",
        data: message2,    //获取模态对话框的全部输入数据
        async: false,  //必须要为false,必须必须//同步
        clearForm: true,        // 成功提交后，清除所有的表单元素的值.

        success: function (data) {

            if (data == '1') {

                //退出登录
                alert("修改成功,即将退出当前账户重新登录");
                window.location.assign("http://localhost:8080/logout");

            } else {
                alert("修改失败" + data);
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
    var msg = $("#xiugai_information_tea").serialize();

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
