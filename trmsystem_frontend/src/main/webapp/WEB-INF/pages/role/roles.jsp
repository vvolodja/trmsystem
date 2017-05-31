<%--
  Created by IntelliJ IDEA.
  User: Vasiliy Kylik
  Date: 31.03.2017
  Time: 1:20
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Role Page</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<%--<a href="welcome">Back Welcome page</a>--%>
<h1>
    Add a Role
</h1>
<c:url var="addAction" value="/admin/role/add"></c:url>
<form:form action="${addAction}" modelAttribute="role">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <table>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>

    </table>

    <div style="clear: both;"></div>
    <p></p>
    <input type="submit" value="ADD">

</form:form>



<br>
<h1>Role List</h1>

<c:if test="${!empty listRoles}">
    <table class="tg">
        <tr>
    <%-- 80+120*3+2*60 = 560 --%>
    <th width="320">ID</th>
    <th width="120">Name</th>
    <th width="60">Edit</th>
    <th width="60">Delete</th>
</tr>
<c:forEach items="${listRoles}" var="role">
    <tr>
        <td>${role.id}</td>
        <td>${role.name}</td>
        <td><a href="<c:url value='/admin/role/edit/${role.id}'/>">Edit</a></td>
        <td><a href="<c:url value='/admin/role/remove/${role.id}'/>">Delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>

</body>
</html>
