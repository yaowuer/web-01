function showPositionsFloatWindow() {
    var mydiv = $("<div><table id='mytable'><tr><th>职位</th><th>工资</th><th>公司</th></tr></table></div>");

    $("body").prepend(mydiv);

    for (var i = 0; i < $(".default_list").length; i++) {
        var xxx = $(".default_list:eq(" + i + ")");

        var a1 = $(".default_list:eq(" + i + ")").attr("data-positionname"); // 职位
        var a2 = $(".default_list:eq(" + i + ")").attr("data-salary");  // 工资
        var a3 = $(".default_list:eq(" + i + ")").attr("data-company"); // 公司
        var td = "<tr><td>" + a1 + "</td><td>" + a2 + "</td><td>" + a3 + "</td></tr>";

        $("#mytable").append(td);
    }

    $("#mytable,th,tr,td").css("border", "1px solid skyblue");
    mydiv.css("width", "500px")
        .css("height", "800px")
        .css("position", "fixed")
        .css("background", "#f0f0f0");
    mydiv.css("z-index", "999");
}

function showPositionsFloatWindow2() {
    // 1. 创建节点，放到 body,然后让它浮动起来
    var $div =
        $("<div><i>x</i><ul></ul></div>")
        .css({
            "position": "fixed",
            "left": "0",
            "top": "0",
            "width": "300px",
            "height": "300px",
            "padding": "10px",
            "margin": "10px",
            "overflow-y": "auto",
            "background": "#ffffff"
        })
        .appendTo("body");

    // 2. 从页面中获取相关数据，并且将数据显示到刚才的 节点上
    $(".default_list").each(function (index, item) {
        $("<li>" + $(item).attr("data-positionname") + " / " + $(item).attr("data-salary") + "</li>")
            .css({
                "border-bottom": "1px solid gray",
                "padding": "8px 0"
            })
            .appendTo($div.find("ul"))
    });

    // 3. 添加关闭事件
    $div.find("i").click(function () {
        $div.fadeOut(5000, function () {
            $div.remove();
        });
    });
}

function showPositionsFloatWindow3() {
    // 1. 创建节点，放到 body，然后让它浮动起来
    var $div = $("<div><i>x</i><ul></ul></div>").appendTo("body");

    // 2. 从页面中获取相关数据，并且将数据显示到刚才的 节点上
    $(".default_list").each(function (index, item) {
        $("<li>" + $(item).attr("data-positionname") + " / " + $(item).attr("data-salary") + "</li>").appendTo($div.find("ul"))
    });

    // 3. 添加关闭事件
    $div.find("i").click(function () { $div.remove(); });
}
