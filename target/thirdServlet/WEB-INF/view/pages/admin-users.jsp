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
    <div>
        <jsp:include page="../template/admin.jsp"/>
    </div>
    <hr/>
    <div class="right">
        <H2>Hello, ${sessionScope.login}!</H2>
        <a href="/controller?command=logout">Logout</a>
    </div>
    <hr/>

    <div class="table-users">
        <table class="users" width="60%" align="center" border="3">
            <tr>
                <th><fmt:message key="login"/></th>
                <th><fmt:message key="first.name"/></th>
                <th><fmt:message key="last.name"/></th>
                <th><fmt:message key="total.amount"/></th>
                <th><fmt:message key="traffic"/></th>
                <th><fmt:message key="tariff"/></th>
                <th><fmt:message key="tariff.discount"/></th>
                <th><fmt:message key="status"/></th>
            </tr>

            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.login}"/>
                    <td><c:out value="${user.firstName}"/>
                    <td><c:out value="${user.lastName}"/>
                    <td><c:out value="${user.totalAmount}"/>
                    <td><c:out value="${user.traffic}"/>
                    <td><c:out value="${user.tariffPlanName}"/>
                    <td><c:out value="${user.discount}"/>
                    <td><c:out value="${user.statusBlock}"/>
                </tr>
            </c:forEach>
        </table>

        <div class="pagination" align="center">
            <c:if test="${currentPage != 1}">
                <a href="${pageContext.request.contextPath}/controller?command=users&page=${currentPage - 1}">Previous</a>
            </c:if>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="${pageContext.request.contextPath}/controller?command=users&page=${i}">${i}</a>
                        </td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:if test="${currentPage lt noOfPages}">
                <a href="${pageContext.request.contextPath}/controller?command=users&page=${currentPage + 1}">Next</a>
            </c:if>
        </div>
    </div>
</div>


<footer>
    <jsp:include page="../template/footer.jsp"/>
</footer>

</body>
</html>
