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
<header>
    <jsp:include page="../template/header.jsp"/>
</header>
<div id="all-page">
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
    <div id="content">
        <hr/>
        <div class="right">
            <H2>Hello, ${sessionScope.login}!</H2>
            <a href="/controller?command=logout">Logout</a>
        </div>
        <hr/>
    </div>
</div>

<footer>
    <jsp:include page="../template/footer.jsp"/>
</footer>

</body>
</html>
