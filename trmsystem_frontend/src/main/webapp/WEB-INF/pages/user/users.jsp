<%--
  Created by IntelliJ IDEA.
  User: Vasiliy Kylik
  Date: 06.04.2017
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>User Page</title>
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
    Add a User
</h1>
<c:url var="addAction" value="/admin/user/add"/>
<form:form action="${addAction}" modelAttribute="user">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <table>
        <tr>
            <td>
                <form:label path="email">
                    <spring:message text="E-mail"/>
                </form:label>
            </td>
            <td>
                <form:input path="email"/>
            </td>
        </tr>

        <tr>
            <td>
                <spring:bind path="userType">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:radiobutton path="userType" value="supervisor" onclick="EnableSubmit()"/>
                        <spring:message code="signUp.value.supervisor"/>
                    </div>
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:radiobutton path="userType" value="specialist" onclick="EnableSubmit()"/>
                        <spring:message code="signUp.value.specialist"/>
                    </div>
                    <form:errors path="userType"/>
                </spring:bind>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="username">
                    <spring:message text="Username"/>
                </form:label>
            </td>
            <td>
                <form:input path="username"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="firstName">
                    <spring:message text="First Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="lastName">
                    <spring:message text="Last Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="lastName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">
                    <spring:message text="Password"/>
                </form:label>
            </td>
            <td><form:input path="password"/></td>
        </tr>
            <%--Trying to add Role setting--%>

<%--        <tr>
            <td>
                <form:label path="roles">
                    <spring:message text="Role"/>
                </form:label>
            </td>
            <td>
                <select name="roles">
                    <option>Select Role</option>
                    <c:forEach items="${roles}" var="role">
                        <option value=${role.id}>${role.name}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>--%>
    </table>

    <div style="clear: both;"></div>
    <p></p>
    <input type="submit" value="ADD">

</form:form>


<br>
<h1>User List</h1>

<%--Show table with entities--%>
<c:if test="${!empty listUsers}">
    <table class="tg">
        <tr>
                <%-- 80+120*3+2*60 = 560 --%>
            <th width="60">E-mail</th>
            <th width="60">UserType</th>
            <th width="60">Username</th>
            <th width="60">First Name</th>
            <th width="60">Last Name</th>
                <%--<th width="60">Registration Date</th>--%>
            <th width="60">Birth Date</th>
            <th width="60">Role</th>
            <th width="60">Password</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listUsers}" var="user">
            <tr>
                <td>${user.email}</td>
                <td>${user.userType}</td>
                <td>${user.username}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                    <%--<td>${user.registrationDate}</td>--%>
                <td>${user.birthDate}</td>
                <td>${user.roles}</td>
                <td>${user.password}</td>
                <td><a href="<c:url value='/admin/user/edit/${user.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/admin/user/remove/${user.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
