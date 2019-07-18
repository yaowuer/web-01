<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<div>
    <h3>
        请输入您的收获信息:
    </h3>
    <form method="get" action="pay">
        <div>
            <label>
                您的姓名: <input name="username">
            </label>
            <label>
                您的联系: <input name="telphone">
            </label>
        </div>

        <div>
            <label>
                省:
                <select name="province">
                    <option>广东省</option>
                    <option>江西省</option>
                    <option>河北省</option>
                </select>
            </label>
            <label>
                市:
                <select name="city">
                    <option>广州市</option>
                    <option>珠海市</option>
                    <option>中山市</option>
                </select>
            </label>
            <label>
                详细地址:
                <input name="addr_detail">
            </label>
        </div>
        <input type="submit" value="下一步">
    </form>
</div>

</body>
</html>
