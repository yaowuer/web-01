<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<label>
    省:
    <select id="province">
        <option value="">--请选择一个省份--</option>
    </select>
</label>
<label>
    市:
    <select id="city">
        <option value="">--请选择一个城市--</option>
    </select>
</label>
<label>
    详细地址:
    <input name="addr_detail">
</label>

<script>
    var arr = ["湖南省", "广东省", "江西省", "广西省"];
    arr["湖南省"] = ["长沙", "emmmm"];
    arr["广东省"] = ["河源市", "珠海", "广州", "深圳", "中山", "湛江", "东莞", "汕头", "佛山", "肇庆", "惠州", "梅州", "江门", "韶关", "茂名", "汕尾", "阳江", "清远", "潮州", "揭阳", "云浮", "阳江", "emmmmm"];
    arr["江西省"] = ["南昌", "emmmmm"];
    arr["广西省"] = ["桂林", "emmmmm"];
    //获取省份下拉框
    var proSelect = document.getElementById("province");
    for (var i = 0; i < arr.length; i++) {
        var pro = arr[i];
        proSelect.options.add(new Option(pro, pro));
    }
    proSelect.onchange = function () {
        var city = document.getElementById("city");

        for (var i = city.options.length - 1; i >= 1; i--) {
            city.options.remove(i);
        }
        var pro = proSelect.value;
        if (pro != "") {
            for (var i = 0; i < arr[pro].length; i++) {
                city.options.add(new Option(arr[pro][i], arr[pro][i]));
            }
        }
    };
</script>