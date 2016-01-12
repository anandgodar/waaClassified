<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="content-body">
    <a href="?language=en">English</a>|<a href="?language=ne">Nepali</a>
    <form:form method="post" modelAttribute="user">
        <form:errors path="*"/><br/>
        <fieldset>
            <legend>LOGIN</legend>
            <spring:message code="User.username"/> <form:input path="userName"/>(*)<br/><br/>
            <spring:message code="User.password"/> <form:password path="password"/>(*)<br/>
            <input type="submit" value="Login" name="submit"/>
        </fieldset>
    </form:form>
</div>
