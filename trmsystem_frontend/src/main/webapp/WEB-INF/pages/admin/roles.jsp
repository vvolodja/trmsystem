<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Vasiliy Kylik
  Date: 31.03.2017
  Time: 1:20
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page for Roles</title>
</head>
<body>
<a href="/welcome">Back Welcome page</a>

<br/>
<br/>

<h1>Role List</h1>

<c:if test="${!empty listRoles}">
    <table class="tg">
        <tr>
    <%-- 80+120*3+2*60 = 560 --%>
    <th width="180">ID</th>
    <th width="120">Name</th>
    <th width="120">Users</th>
    <th width="60">Edit</th>
    <th width="60">Delete</th>
</tr>
<c:forEach items="${listRoles}" var="role">
    <tr>
        <td>${role.id}</td>
        <td><a href="/bookdata/${role.id}" target="_blank">${role.bookTitle}</a></td>
        <td>${role.bookAuthor}</td>
        <td>${role.price/100}${role.price%100}</td>
        <td><a href="<c:url value='/edit/${role.id}'/>">Edit</a></td>
        <td><a href="<c:url value='/remove/${role.id}'/>">Delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>

</body>
</html>
