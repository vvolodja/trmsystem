<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Event Page</title>
    <meta name="description" content="Edit page for event">
    <meta name="author" content="Kyryl Potapenko">
    <meta name="date" content="16.04.2017">
</head>
<body>
<h1>
    Add an Event
</h1>

<c:url var="editAction" value="/event/${event.date}"></c:url>

<form:form action="${editAction}" commandName="event">

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
                <form:label path="date">
                    <spring:message text="Date"/>
                </form:label>
            </td>
            <td>
                <form:input path="date"/>
            </td>
        </tr>

    </table>

    <div style="clear: both;"></div>
    <p></p>
    <input type="submit" value="Save">

</form:form>

</body>
</html>
