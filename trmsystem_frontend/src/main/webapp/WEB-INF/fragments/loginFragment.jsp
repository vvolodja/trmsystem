<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-5"></div>
        <div class="col-lg-2">
            <form method="POST" action="${contextPath}/login" class="navbar-form navbar-auto margin-top-20" role="form">
                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <div class="input-group">
                        <spring:message code="login.placeholder.username" var="Username"/>
                        <input name="username" type="text" class="form-control autoriz-input" placeholder="${Username}"
                               autofocus="true"/>
                        <spring:message code="login.placeholder.password" var="Password"/>
                        <input name="password" type="password" class="form-control autoriz-input" placeholder="${Password}"/>
                        <span>${error}</span>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <div class="navbar-right margin-right-10px">
                            <button class="btn btn-md btn-primary" type="submit">
                                <spring:message code="login.buttons.login"/>
                            </button>
                        </div>
                    </div>
                </div>
                <h4 class="text-center"><a href="${contextPath}/signUp">
                    <spring:message code="login.link.createAnAccount"/>
                </a></h4>
            </form>
        </div>
        <div class="col-lg-5"></div>
    </div>
</div>

