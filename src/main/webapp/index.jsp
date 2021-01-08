<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>


<html lang="${sessionScope.lang}">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>InternetProvider</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles/index.css">
</head>
<body>
<header>
    <jsp:include page="WEB-INF/view/template/header.jsp"/>
</header>
<div id="all-page">

    <nav>
        <c:if test="${sessionScope.userRole eq 'ADMIN'}">
            <div>
                <jsp:include page="WEB-INF/view/template/admin.jsp"/>
            </div>
            <hr/>
            <div class="right">
                <H2>Hello, ${sessionScope.login}!</H2>
                <a><ctg:info-time/></a>
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
    </nav>

    <div class="content">
        <H2 align="middle"><fmt:message key="label.welcome"/></H2>
        <div class="info">
        </div>
    </div>
</div>

<footer>
    <jsp:include page="WEB-INF/view/template/footer.jsp"/>
</footer>


</body>
</html>