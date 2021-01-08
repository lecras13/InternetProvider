<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


<div class="admin-panel">
    <ul>
        <li><a href="${pageContext.request.contextPath}/controller?command=users" method=POST><fmt:message
                key="user.list"/></a></li>

        <li><a href="${pageContext.request.contextPath}/controller?command=tariffs-edit" method=POST><fmt:message
                key="tariff.add"/></a></li>

        <li><a href="${pageContext.request.contextPath}/controller?command=promotions-edit" method=POST><fmt:message
                key="promotion.add"/></a></li>
    </ul>
</div>
</body>
</html>
