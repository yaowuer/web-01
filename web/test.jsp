<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>测试页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/common.css">
</head>
<body>

<div>
    <table class="tb">
        <c:set var="ccc" scope="page" property="ccc" value="0"/>
        <c:forEach items="${books}" var="x" varStatus="s" begin="0" end="4" step="1">
            <c:if test="${x.amount > 20}">
                <c:set value="${ccc + 1}" var="ccc"/>
                <tr style="background: ${s.count % 2 == 0 ? "pink" : "yellow"}">
                    <td>${s.index + 1} / ${s.count} / ${ccc}</td>
                    <td>${x.id}</td>
                    <td>${x.name}</td>
                    <td style="color: ${x.price > 100 ? "green" : "purple"}">${x.price}</td>
                    <td>${x.amount}</td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</div>

<div>
    <c:out value="${name}" default="3333"/>
    ${empty name ? "3333" : name}
</div>

<div>
    <%--    <c:redirect url="http://www.bing.com" />--%>
    <%--    request.setAttribute("xxx", 333) --%>
    <c:set var="xxx" scope="session" property="xxx" value="333"/>
</div>

<div>
    <c:forTokens items="aaa,bbb,ccc,ddd,eee" delims="," var="t" varStatus="s">
        <li>${s.count}. ${t}</li>
    </c:forTokens>
</div>

<div>
    <c:forEach var="b" items="${books}">
        <c:choose>
            <c:when test="${b.price > 100}">
                <li>${b.name} 的价格大于 100</li>
            </c:when>
            <c:when test="${b.price <= 100 && b.price > 50}">
                <li>${b.name} 并不贵</li>
            </c:when>
            <c:otherwise>
                <li>《${b.name}》太便宜了，便宜没好货</li>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>

<div>
    <c:url var="womendelink" value="/student/lst">
        <c:param name="id" value="3"/>
        <c:param name="xx" value="hello world"/>
        <c:param name="yy" value="上岛咖啡"/>
    </c:url>

    <%--    <a href="${pageContext.request.contextPath}/student/lst/?id=3&name=skdfjksdjf&xxx=skdfjdks%20skdfjksdf">超链接</a>--%>
    <a href="${womendelink}">使用 url 定义的变量</a>
</div>

<div>
    <c:import var="wodeyemian" url="footer.jsp"/>
</div>

<div>
    ${wodeyemian}
</div>

<c:if test="${fn:contains(name, 'd,')}">xxx</c:if>

<%--常用的格式化标签--%>

<div>
    <fmt:formatDate value="${ddd}" pattern="yyyy-MM-dd HH:mm:ss"/>
</div>

<div>
    <fmt:formatNumber value="2323232323" pattern="####,####"/>
</div>

<button onclick="clickMe()">点击我</button>


<script>
    function clickMe() {
        alert('现在的服务器时间为: <fmt:formatDate value="${ddd}" pattern="yyyy-MM-dd HH:mm:ss"/>');
    }
</script>

</body>
</html>
