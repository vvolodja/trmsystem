<%@ page import="com.sun.xml.internal.bind.v2.TODO" %><%--
  Created by IntelliJ IDEA.
  User: Vasiliy Kylik
  Date: 02.04.2017
  Time: 23:49
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/layout.css" rel="layout_stylesheet">
</head>
<body>

<div class="content">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2><spring:message code="home.head"/> ${pageContext.request.userPrincipal.name} |
            <a onclick="document.forms['logoutForm'].submit()">
                <spring:message code="home.link.logout"/>
            </a>
        </h2>

    </c:if>

    <a href="admin/welcome">
        <button>Go to admin operations</button>
    </a>

</div>

<div class="admin-panel">
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="/admin/roles">
            <button>adminCRUDForRoles</button>
        </a>
    </sec:authorize>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
<%--TODO make as welcome page as user/home.jsp--%>