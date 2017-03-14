<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Team</title>
</head>
<body>

<h2>Team:</h2>

<form method="Post" action="/admin/team/add">

    <h3>SUBJECT:</h3>

    <h2>Name:</h2>
    <input type="text" name="name">
    <div style="clear: both;"></div>

    <h2>Description:</h2>
    <input type="text" name="${}">

    <h3>Supervisor:</h3>
    <select name="supervisorId">
        <c:forEach items="${supervisors}" var="supervisor">
            <option value="${supervisor.getId()}"><c:out
                    value="${supervisor.getName()}" /></option>
        </c:forEach>
    </select>

    <p></p>
    <input type="submit" value="ADD">

</form>
</body>
</html>