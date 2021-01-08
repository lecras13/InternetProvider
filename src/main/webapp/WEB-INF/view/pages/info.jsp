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
    <div class="content">
        <hr/>
        <div class="right">
            <H2>Hello, ${sessionScope.login}!</H2>
            <a><ctg:info-time/></a>
            <a href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message key="logout.form.button"/></a>
        </div>
        <hr/>
        <h1 align="center"> ${errorMessageData}</h1>
        <br>
        <div class="info">

            <H3><fmt:message key="login"/>: <c:out value="${user.login}"/></H3>
            <H3><fmt:message key="first.name"/>: <c:out value="${user.firstName}"/></H3>
            <H3><fmt:message key="last.name"/>: <c:out value="${user.lastName}"/></H3>
            <H3><fmt:message key="total.amount"/>: <c:out value="${user.totalAmount}"/></H3>

            <form style="display: inline-block"
                  action="${pageContext.request.contextPath}/controller?command=payments-history" method=POST>
                <input type="hidden" name="user_id" value="${user.id}"/>
                <input type="submit" value="<fmt:message key="button.history.payment"/>">
            </form>
            <c:if test="${sessionScope.userRole eq 'USER'}">
                <form style="display: inline-block"
                      action="${pageContext.request.contextPath}/controller?command=payment" method=POST>
                    <input type="hidden" name="user_id" value="${user.id}"/>
                    <input type="submit" value="<fmt:message key="button.add.payment"/>">
                </form>
            </c:if>
            <H3><fmt:message key="traffic"/>: <c:out value="${user.traffic}"/></H3>
            <H3><fmt:message key="tariff"/>: <c:out value="${tariff_name}"/></H3>
            <H3><fmt:message key="promotion.name"/>: <c:out value="${promotion_name}"/></H3>

            <c:if test="${sessionScope.userRole eq 'ADMIN'}">
                <H3><fmt:message key="status"/>: <c:out value="${user.statusBlock}"/></H3>
            </c:if>

            <form style="display: inline-block" action="${pageContext.request.contextPath}/controller?command=user-edit"
                  method=POST>
                <input type="hidden" name="id" value="${user.id}"/>
                <input type="hidden" name="login" value="${user.login}"/>
                <input type="hidden" name="first_name" value="<c:out value="${user.firstName}"/>"/>
                <input type="hidden" name="last_name" value="<c:out value="${user.lastName}"/>"/>
                <input type="hidden" name="role" value="<c:out value="${user.role}"/>"/>
                <input type="hidden" name="discount" value="<c:out value="${user.discount}"/>"/>
                <input type="hidden" name="status_block" value="${user.statusBlock}"/>
                <input type="hidden" name="tariff_id" value="<c:out value="${user.tariffId}"/>"/>
                <input type="hidden" name="traffic" value="<c:out value="${user.traffic}"/>"/>
                <input type="hidden" name="promotion_id" value="<c:out value="${user.promotionId}"/>"/>
                <input type="hidden" name="total_amount" value="<c:out value="${user.totalAmount}"/>"/>


                <input type="submit" value="<fmt:message key="button.edit.profile"/>">
            </form>
            <c:if test="${sessionScope.userRole eq 'USER'}">
                <form style="display: inline-block"
                      action="${pageContext.request.contextPath}/controller?command=user-password-edit"
                      method=POST>
                    <input type="submit" value="<fmt:message key="button.edit.password"/>">
                </form>
            </c:if>
        </div>
    </div>
</div>

<footer>
    <jsp:include page="../template/footer.jsp"/>
</footer>

</body>
</html>
