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
    </div>

    <div class="table-users">
        <table class="users" width="60%" align="center" border="3">
            <tr>
                <th><fmt:message key="tariff.name"/></th>
                <th><fmt:message key="tariff.price"/></th>
                <th><fmt:message key="tariff.description"/></th>
                <c:if test="${sessionScope.userRole eq 'ADMIN'}">
                    <th><fmt:message key="button.edit"/></th>
                </c:if>
            </tr>

            <c:forEach items="${tariffs}" var="tariff">
                <tr>
                    <td><c:out value="${tariff.tariffName}"/></td>
                    <td><c:out value="${tariff.price}"/></td>
                    <td><c:out value="${tariff.prescription}"/></td>

                    <c:if test="${sessionScope.userRole eq 'ADMIN'}">
                        <td>
                            <form action="/controller?command=tariffs-edit" method=POST>
                                <input type="hidden" name="id" value="${tariff.id}">
                                <input type="hidden" name="tariff-name" value="${tariff.tariffName}">
                                <input type="hidden" name="price" value="${tariff.price}">
                                <input type="hidden" name="prescription" value="${tariff.prescription}">
                                <input type="submit" value="<fmt:message key="button.edit"/>">
                            </form>
                            <form action="/controller?command=tariffs-delete" method=POST>
                                <input type="submit" value="<fmt:message key="button.delete"/>">
                            </form>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${sessionScope.userRole eq 'ADMIN'}">
            <div>
                <form action="/controller?command=tariffs-edit" method=POST>
                    <input type="submit" value="<fmt:message key="button.add"/>">
                </form>
            </div>
        </c:if>
    </div>
</div>


<footer>
    <jsp:include page="../template/footer.jsp"/>
</footer>

</body>
</html>
