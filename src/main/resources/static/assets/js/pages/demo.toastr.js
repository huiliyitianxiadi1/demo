!function (t) {
    "use strict";
    t("#toastr-one").on("click", function (i) {
        t.NotificationApp.send("Heads up!", "This alert needs your attention, but it is not super important.", "top-right", "rgba(0,0,0,0.2)", "info")
    }), t("#toastr-two").on("click", function (i) {
        t.NotificationApp.send("Heads up!", "Check below fields please.", "top-center", "rgba(0,0,0,0.2)", "warning")
    }), t("#toastr-three1").on("click", function (i) {
        t.NotificationApp.send("成功!", "你提交的数据已添加成功", "bottom-right", "rgba(0,0,0,0.2)", "success")
    }), t("#toastr-three2").on("click", function (i) {
        t.NotificationApp.send("成功!", "你提交的数据已修改成功", "bottom-right", "rgba(0,0,0,0.2)", "success")
    }), t("#toastr-three3").on("click", function (i) {
        t.NotificationApp.send("成功!", "你选择的数据已删除成功", "bottom-right", "rgba(0,0,0,0.2)", "success")
    }) , t("#toastr-four1").on("click", function (i) {
        t.NotificationApp.send("失败!", "请检查内容，然后再次尝试提交.", "bottom-left", "rgba(0,0,0,0.2)", "error")
    })   , t("#toastr-four2").on("click", function (i) {
        t.NotificationApp.send("失败!", "请检查内容，然后再次尝试提交.", "bottom-left", "rgba(0,0,0,0.2)", "error")
    })   , t("#toastr-four3").on("click", function (i) {
        t.NotificationApp.send("失败!", "请检查内容，然后再次尝试提交.", "bottom-left", "rgba(0,0,0,0.2)", "error")
    })  , t("#toastr-five").on("click", function (i) {
        t.NotificationApp.send("How to contribute?", ["Fork the repository", "Improve/extend the functionality", "Create a pull request"], "top-right", "rgba(0,0,0,0.2)", "info")
    }), t("#toastr-six").on("click", function (i) {
        t.NotificationApp.send("Can I add <em>icons</em>?", "Yes! check this <a href='https://github.com/kamranahmedse/jquery-toast-plugin/commits/master'>update</a>.", "top-right", "rgba(0,0,0,0.2)", "info", !1)
    }), t("#toastr-seven").on("click", function (i) {
        t.NotificationApp.send("", "Set the `hideAfter` property to false and the toast will become sticky.", "top-right", "rgba(0,0,0,0.2)", "success")
    }), t("#toastr-eight").on("click", function (i) {
        t.NotificationApp.send("", "Set the `showHideTransition` property to fade|plain|slide to achieve different transitions.", "top-right", "rgba(0,0,0,0.2)", "info", 3e3, 1, "fade")
    })
}(window.jQuery);