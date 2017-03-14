<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Team Page</title>
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
    Add a Team
</h1>

<c:url var="addAction" value="/admin/team/add"></c:url>

<form:form action="${addAction}" commandName="team">

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

        <tr>
            <td>
                <form:label path="description">
                    <spring:message text="Description"/>
                </form:label>
            </td>
            <td>
                <form:input path="description"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="supervisor">
                    <spring:message text="Supervisor"/>
                </form:label>
            </td>
            <td>
                <form:select path="supervisor.id">
                    <%--<form:option value="NONE" label="Select responsible user"/>--%>
                    <form:options items="${supervisors}" itemValue="id" itemLabel="username"/>
                </form:select>
            </td>
        </tr>
    </table>

    <div style="clear: both;"></div>
    <p></p>
    <input type="submit" value="ADD">

</form:form>


<br>
<h3>Team List</h3>
<c:if test="${!empty teams}">
    <table class="tg">
        <tr>
            <th width="120">Team Name</th>
            <th width="120">Team Description</th>
            <th width="120">Team Supervisor</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${teams}" var="team">
            <tr>
                <td>${team.name}</td>
                <td>${team.description}</td>
                <td>${team.supervisor.username}</td>
                <td><a href="<c:url value='/admin/team/edit/${team.id}' />">Edit</a></td>
                <td><a href="<c:url value='/admin/team/remove/${team.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>