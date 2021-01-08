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
            <a href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message
                    key="logout.form.button"/></a>
        </div>
        <hr/>

        <div class="info">
            <table class="users" width="60%" align="center" border="3">
                <tr>
                    <th><fmt:message key="login"/></th>
                    <th><fmt:message key="first.name"/></th>
                    <th><fmt:message key="last.name"/></th>
                    <th><fmt:message key="total.amount"/></th>
                    <th><fmt:message key="traffic"/></th>
                    <th><fmt:message key="tariff"/></th>
                    <th><fmt:message key="promotion.name"/></th>
                    <th><fmt:message key="tariff.discount"/></th>
                    <th><fmt:message key="status"/></th>
                    <th><fmt:message key="status.change"/></th>
                </tr>

                <c:forEach items="${users}" var="user">
                    <c:if test="${user.role eq 'USER'}">
                        <tr>
                            <td><c:out value="${user.login}"/>
                            <td><c:out value="${user.firstName}"/>
                            <td><c:out value="${user.lastName}"/>
                            <td><c:out value="${user.totalAmount}"/>
                            <td><c:out value="${user.traffic}"/>
                            <td><c:out value="${user.tariffPlan.tariffName}"/>
                            <td><c:out value="${user.promotion.promotionName}"/>
                            <td><c:out value="${user.discount}"/>
                            <td><c:out value="${user.statusBlock}"/>
                            <td>
                                <form action="${pageContext.request.contextPath}/controller?command=info" method=POST>
                                    <input type="hidden" name="user_id" value="${user.id}"/>
                                    <input type="hidden" name="login" value="${user.login}"/>
                                    <input type="hidden" name="password" value="${user.password}"/>
                                    <input type="hidden" name="first_name" value="${user.firstName}"/>
                                    <input type="hidden" name="last_name" value="${user.lastName}"/>
                                    <input type="hidden" name="total_amount" value="${user.totalAmount}"/>
                                    <input type="hidden" name="traffic" value="${user.traffic}"/>
                                    <input type="hidden" name="discount" value="${user.discount}"/>
                                    <input type="hidden" name="status_block" value="${user.statusBlock}"/>
                                    <input type="submit" value="Info">
                                </form>
                            </td>
                        </tr>
                    </c:if>
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
</div>


<footer>
    <jsp:include page="../template/footer.jsp"/>
</footer>

</body>
</html>
