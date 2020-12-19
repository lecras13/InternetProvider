<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>


<html lang="${sessionScope.lang}">
<head>
    <meta charset="UTF-8">
    <title>InternetProvider</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles/index.css">
</head>
<body>

<jsp:include page="../template/header.jsp"/>
<div id="content">
    <nav>
        <c:if test="${sessionScope.userRole eq 'ADMIN'}">
            <div>
                <jsp:include page="../template/admin.jsp"/>
            </div>
        </c:if>
        <c:if test="${sessionScope.userRole eq 'USER'}">
            <div>
                <jsp:include page="../template/user.jsp"/>
            </div>
        </c:if>
    </nav>


    <div class="right">
        <c:if test="${sessionScope.userRole != null}">
            <hr/>
            <H2>Hello, ${sessionScope.login}!</H2>
            <a href="/controller?command=logout">Logout</a>
            <hr/>
        </c:if>


        <form action="/controller?command=tariffs-save" method=POST>
            <table class="reg_form">
                <tr>
                    <td><fmt:message key="tariff.name"/></td>
                    <td><input type="text" name="tariff-name" value="${tariff.tariffName}"/></td>
                </tr>
                <tr>
                    <td><fmt:message key="tariff.price"/></td>
                    <td><input type="text" name="price" value="${tariff.price}"/></td>
                </tr>
                <tr>
                    <td><fmt:message key="tariff.description"/></td>
                    <td><textarea name="prescription" value="${tariff.prescription}"></textarea></td>
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
</div>


<footer>
    <jsp:include page="../template/footer.jsp"/>
</footer>

</body>
</html>
