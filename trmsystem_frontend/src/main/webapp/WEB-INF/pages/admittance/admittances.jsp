
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Admittance page</title>
    <meta name="description" content="Crud page for admittance">
    <meta name="author" content="Kyryl Potapenko">
    <meta name="date" content="23.03.2017">
</head>
<body>
<h1>
    Add an Admittance
</h1>
<c:url var="addAction" value="/admin/admittance/add"></c:url>

<form:form action="${addAction}" commandName="admittance">

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
        <input type="submit" value="ADD">

    </form:form>
<br>
<h3>Admittance List</h3>
<c:if test="${!empty admittances}">
    <table class="tg">
        <tr>
            <th width="120">Admittance Name</th>
            <th width="120">Admittance Description</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${admittances}" var="admittance">
            <tr>
                <td>${admittance.name}</td>
                <td>${admittance.description}</td>
                <td><a href="<c:url value='/admittance/edit/${admittance.id}' />">Edit</a></td>
                <td><a href="<c:url value='/admittance/remove/${admittance.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>



</body>
</html>
