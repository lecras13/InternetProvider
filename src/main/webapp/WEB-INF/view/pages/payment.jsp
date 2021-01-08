<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>
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
            <a><ctg:info-time/></a>
            <a href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message
                    key="logout.form.button"/></a>
            <hr/>
        </c:if>
    </div>
    <div class="info">
        <div class="payments">
            <c:if test="${sessionScope.userRole eq 'USER'}">
                <div align="center">
                    <form action="${pageContext.request.contextPath}/controller?command=payment-pay" method=POST>
                        <input type="text" id="amount" name="amount" placeholder="<fmt:message key="money.double"/>">
                        <input type="submit" value="<fmt:message key="button.add.payment"/>">
                    </form>
                </div>
                <h1 align="center"> ${errorMessageData}</h1>
                <div id="message">
                    <p id="validness" class="invalid"><b> <fmt:message key="valid"/></b></p>
                </div>
            </c:if>
        </div>
    </div>
</div>


<footer>
    <jsp:include page="../template/footer.jsp"/>
</footer>
<script src="<c:url value="/static/js/payment.js"/>"></script>
</body>
</html>
