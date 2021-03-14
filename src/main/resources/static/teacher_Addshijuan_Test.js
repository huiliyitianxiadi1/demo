//=======单选题右 RA
$("#customCheckRight1").on('click', function () {
    $("input[name='subRA']").prop("checked", this.checked);
});

$("input[name='subRA']").on('click', function () {
    var $subs = $("input[name='subRA']");
    $("#customCheckRight1").prop("checked", $subs.length === $subs.filter(":checked").length);
});

//=======单选题左 LA

$("#customCheckLeft1").on('click', function () {
    $("input[name='subLA']").prop("checked", this.checked);
});

$("input[name='subLA']").on('click', function () {
    var $subs = $("input[name='subLA']");
    $("#customCheckLeft1").prop("checked", $subs.length === $subs.filter(":checked").length);
});

//================================================================================

//=======填空题右 RB
$("#customCheckRight2").on('click', function () {
    $("input[name='subRB']").prop("checked", this.checked);
});

$("input[name='subRB']").on('click', function () {
    var $subs = $("input[name='subRB']");
    $("#customCheckRight2").prop("checked", $subs.length === $subs.filter(":checked").length);
});

//=======填空题左 LB

$("#customCheckLeft2").on('click', function () {
    $("input[name='subLB']").prop("checked", this.checked);
});

$("input[name='subLB']").on('click', function () {
    var $subs = $("input[name='subLB']");
    $("#customCheckLeft2").prop("checked", $subs.length === $subs.filter(":checked").length);
});



//================================================================================


//=======单选题右 RC
$("#customCheckRight3").on('click', function () {
    $("input[name='subRC']").prop("checked", this.checked);
});

$("input[name='subRC']").on('click', function () {
    var $subs = $("input[name='subRC']");
    $("#customCheckRight3").prop("checked", $subs.length === $subs.filter(":checked").length);
});

//=======主观题左 LC

$("#customCheckLeft3").on('click', function () {
    $("input[name='subLC']").prop("checked", this.checked);
});

$("input[name='subLC']").on('click', function () {
    var $subs = $("input[name='subLC']");
    $("#customCheckLeft3").prop("checked", $subs.length === $subs.filter(":checked").length);
});


//================================================================================

