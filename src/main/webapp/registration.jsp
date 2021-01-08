<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>


<html lang="${sessionScope.lang}">
<head>
    <title>InternetProvider</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles/index.css">
</head>
<body>
<div class="header-panel">
    <jsp:include page="WEB-INF/view/template/header.jsp"/>
</div>
<c:if test="${sessionScope.userRole eq 'ADMIN'}">
    <div>
        <jsp:include page="WEB-INF/view/template/admin.jsp"/>
    </div>
    <hr/>
    <div class="right">
        <H2>Hello, ${sessionScope.login}!</H2>
        <a href="${pageContext.request.contextPath}/controller?command=logout">Logout</a>
    </div>
    <hr/>
</c:if>
<c:if test="${sessionScope.userRole eq 'USER'}">
    <div>
        <jsp:include page="WEB-INF/view/template/user.jsp"/>
    </div>
    <hr/>
    <div class="right">
        <H2>Hello, ${sessionScope.login}!</H2>
        <a href="${pageContext.request.contextPath}/controller?command=logout">Logout</a>
    </div>
    <hr/>
</c:if>

<div id="content">
    <form action="${pageContext.request.contextPath}/controller?command=registration" method=POST>
        <table class="reg_form">
            <tr>
                <td>Login</td>
                <td><input type="text" name="login"/></td>
            </tr>
            <tr>
                <td><fmt:message key="first.name"/></td>
                <td><input type="text" name="first_name"/></td>
            </tr>
            <tr>
                <td><fmt:message key="last.name"/></td>
                <td><input type="text" name="last_name"/></td>
            </tr>
            <tr>
                <td><fmt:message key="registr.pass"/></td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><fmt:message key="registr.pass.confirm"/></td>
                <td><input type="password" name="password_confirm"/></td>
            </tr>
            <tr>
                <td><fmt:message key="registr.tel"/></td>
                <td><input type="text" name="contact"/></td>
            </tr>
            <tr>
                <td><fmt:message key="registr.plan"/></td>
                <td>
                    <select name="tariff">
                        <option>Tariff 1</option>
                        <option>Tariff 1</option>
                    </select>
                </td>
            </tr>
            <tr>
            </tr>

            <tr>
                <td>
                </td>
                <td>
                    <button type="submit">Submit</button>
                </td>
            </tr>
        </table>
    </form>
</div>

<footer>
    <jsp:include page="WEB-INF/view/template/footer.jsp"/>
</footer>

</body>
</html>