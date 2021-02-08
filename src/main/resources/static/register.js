//注册前检查
//检查单选框是否选择
function toVaild() {
    var shenfen = $('input:radio[name="shenfen"]:checked').val();
    var checkbox_signup = $("input[name='checkbox_signup']").is(':checked');

    if (shenfen) {

        if (checkbox_signup === true) {
            SignUpButton();
            return true;
        } else {
            alert("请先同意协议");
            return false;
        }

    } else {
        alert("你并没有选择身份，请选择身份后再次提交");
        return false;
    }
}


//提交按钮检查
function SignUpButton() {
    //获取模态对话框的全部输入数据
    var msg = $("#RegisterForm").serialize();
    //  alert(msg);

    $.ajax({
        cache: false,//每次读取的是最新的数据。
        type: "POST",
        dataType: "json",//预期服务器返回的数据类型
        url: "/PostSignUp",
        data: $('#RegisterForm').serialize(),    //获取模态对话框的全部输入数据
        async: true,  //必须要为false,必须必须//同步
        clearForm: true,        // 成功提交后，清除所有的表单元素的值.

        success: function (data) {

            if (data == '2000') {
                alert("注册成功" + data + ",页面即将跳转到登录界面");
                 window.location.href = "/login.html";
                // window.location.reload();
            } else if (data == '2002') {
                alert("注册失败" + data);
                //待补充
            } else if (data == '2004') {
                alert("出现异常错误;");
            }
        },
        error: function (e) {
            alert("error");
        }
    });


}


