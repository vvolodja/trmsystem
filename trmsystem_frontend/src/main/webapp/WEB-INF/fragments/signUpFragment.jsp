<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-5"></div>
        <div class="col-lg-2">
            <form:form method="POST" modelAttribute="userForm" class="form-signin">
                <h3 class="form-signin-heading">
                    <spring:message code="signUp.head"/>
                </h3>
                <spring:bind path="username">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <spring:message code="signUp.placeholder.username" var="Username"/>
                        <form:input type="text" path="username" class="form-control" placeholder='${Username}'
                                    autofocus="true"/>

                        <form:errors path="username"/>
                    </div>
                </spring:bind>

                <spring:bind path="firstName">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <spring:message code="signUp.placeholder.firstname" var="Firstname"/>
                        <form:input type="text" path="firstName" class="form-control" placeholder='${Firstname}'
                                    autofocus="true"/>
                        <form:errors path="firstName"/>
                    </div>
                </spring:bind>

                <spring:bind path="lastName">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <spring:message code="signUp.placeholder.lastname" var="Lastname"/>
                        <form:input type="text" path="lastName" class="form-control" placeholder='${Lastname}'
                                    autofocus="true"/>
                        <form:errors path="lastName"/>
                    </div>
                </spring:bind>

                <spring:bind path="password">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <spring:message code="signUp.placeholder.password" var="Password"/>
                        <form:input type="password" path="password" class="form-control"
                                    placeholder='${Password}'/>
                        <form:errors path="password"/>
                    </div>
                </spring:bind>


                <spring:bind path="confirmPassword">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <spring:message code="signUp.placeholder.confirmPassword" var="confirmPassword"/>
                        <form:input type="password" path="confirmPassword" class="form-control"
                                    placeholder='${confirmPassword}'/>
                        <form:errors path="confirmPassword"/>
                    </div>
                </spring:bind>

                <spring:bind path="email">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <spring:message code="signUp.placeholder.email" var="Email"/>
                        <form:input type="text" path="email" class="form-control" placeholder='${Email}'
                                    autofocus="true"/>
                        <form:errors path="email"/>
                    </div>
                </spring:bind>
                <h3 class="form-signin-heading">
                    <spring:message code="signUp.selectUserType"/>
                </h3>

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
                <div class="navbar-right margin-right-10px">
                    <button class="btn btn-md btn-primary btn-block" type="submit">
                        <spring:message code="signUp.buttons.submit"/>
                    </button>
                </div>
            </form:form>
        </div>
        <div class="col-lg-5"></div>
    </div>
</div>