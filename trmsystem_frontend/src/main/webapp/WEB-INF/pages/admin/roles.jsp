<%--
  Created by IntelliJ IDEA.
  User: Vasiliy Kylik
  Date: 31.03.2017
  Time: 1:20
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page for Roles</title>
</head>
<body>
<a href="welcome">Back Welcome page</a>

<br/>
<br/>

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
        <td><a href="<c:url value='admin/roles/edit/${role.id}'/>">Edit</a></td>
        <td><a href="<c:url value='/admin/roles/remove/${role.id}'/>">Delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>

<h1>Add a Role</h1>

<c:url var="addRole" value="/role/add"/>

<form:form action="${addRole}" commandName="role">
    <table>
        <c:if test="${!empty role.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td colspan="2">
                <c:if test="${!empty role.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Role"/>"/>
                </c:if>
                <c:if test="${empty role.name}">
                    <input type="submit"
                           value="<spring:message text="Add Role"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
