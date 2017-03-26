<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Admittance Page</title>
    <meta name="description" content="Edit page for admittance">
    <meta name="author" content="Kyryl Potapenko">
    <meta name="date" content="23.03.2017">
</head>
<body>
<h1>
    Add an Admittance
</h1>

<c:url var="editAction" value="/admittance/edit/${admittance.id}"></c:url>

<form:form action="${editAction}" commandName="admittance">

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

    </table>

    <div style="clear: both;"></div>
    <p></p>
    <input type="submit" value="EDIT">

</form:form>

</body>
</html>
