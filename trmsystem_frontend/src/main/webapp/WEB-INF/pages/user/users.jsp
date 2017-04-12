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

<form:form action="${addAction}" modelAttribute="user">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <table>
        <tr>
            <td>
                <form:label path="e-mail">
                    <spring:message text="E-mail"/>
                </form:label>
            </td>
            <td>
                <form:input path="e-mail"/>
            </td>
        </tr>        <tr>
            <td>
                <form:label path="usertype">
                    <spring:message text="Usertype"/>
                </form:label>
            </td>
            <td>
                <form:input path="usertype"/>
            </td>
        </tr>        <tr>
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
                <form:label path="first_name">
                    <spring:message text="First_Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="first_name"/>
            </td>
        </tr>        <tr>
            <td>
                <form:label path="e-mail">
                    <spring:message text="E-mail"/>
                </form:label>
            </td>
            <td>
                <form:input path="e-mail"/>
            </td>
        </tr>        <tr>
            <td>
                <form:label path="e-mail">
                    <spring:message text="E-mail"/>
                </form:label>
            </td>
            <td>
                <form:input path="e-mail"/>
            </td>
        </tr>        <tr>
            <td>
                <form:label path="e-mail">
                    <spring:message text="E-mail"/>
                </form:label>
            </td>
            <td>
                <form:input path="e-mail"/>
            </td>
        </tr>        <tr>
            <td>
                <form:label path="e-mail">
                    <spring:message text="E-mail"/>
                </form:label>
            </td>
            <td>
                <form:input path="e-mail"/>
            </td>
        </tr>
    </table>

    <div style="clear: both;"></div>
    <p></p>
    <input type="submit" value="ADD">

</form:form>


<br>
<h1>User List</h1>

<c:if test="${!empty listUsers}">
    <table class="tg">
        <tr>
                <%-- 80+120*3+2*60 = 560 --%>
            <th width="60">E-mail</th>
            <th width="60">Usertype</th>
            <th width="60">Username</th>
            <th width="60">First_Name</th>
            <th width="60">Last_Name</th>
            <th width="60">Reg_Date</th>
            <th width="60">Birth_Date</th>
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
                <td>${user.registrationDate}</td>
                <td>${user.birthDate}</td>
                <td><a href="<c:url value='/admin/user/edit/${user.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/admin/user/remove/${user.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
