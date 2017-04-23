<%--
  Created by IntelliJ IDEA.
  User: Vasiliy Kylik
  Date: 11.04.2017
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>User
        Page</title>
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
<h1>
    Edit a User

</h1>
<c:url var="editAction" value="/admin/user/edit/${user.id}"/>

<form:form action="${editAction}" commandName="user">

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
        </tr>        <tr>
        <td>
            <form:label path="firstName">
                <spring:message text="First Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="firstName"/>
        </td>
    </tr>        <tr>
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
    </table>

    <div style="clear: both;"></div>
    <p></p>
    <input type="submit" value="EDIT">

</form:form>


</body>
</html>
