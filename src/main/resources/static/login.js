//注册前检查
//检查单选框是否选择
function toVaild() {
    var shenfen = $('input:radio[name="shenfen"]:checked').val();

    if (shenfen) {
        return true;
    } else {
        alert("你并没有选择身份，请选择身份后再次提交");
        return false;
    }
}
