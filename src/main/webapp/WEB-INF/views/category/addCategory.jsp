<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<style type="text/css">@import url("<spring:url value="/resources/css/rest.css"/>");</style>
<div class="content-body" id="formInput">
    <spring:url value="/category/add" var="addcategory"></spring:url>
    <form:form modelAttribute="category" action="${addcategory}">
        <fieldset>
            <legend>Add Category</legend>
            <form:hidden path="id" value="${categoryedit.id}"/>

            <p>
                <label class="" for="name"><spring:message code="Category.name"/></label>
            </p>

            <p>
                <form:input id="name" path="name" type="text" value="${categoryedit.name}"/>
            </p>

            <p>
                <form:errors path="name" Class="error"/>
            </p>

            <p>
                <label class="" for="description"><spring:message code="Category.description"/></label>
            </p>

            <p>
                <form:input id="description" path="description" type="text" value="${categoryedit.description}"/>
            </p>

            <p>
                <form:errors path="description" Class="error"/>
            </p>

            <p>
                <label class="" for="parentId"><spring:message code="Category.parent"/></label>
            </p>

            <p>
                <form:select path="parentId" id="parentId">


                    <form:option value="0"> --SELECT--</form:option>
                    <form:options items="${categories}" itemLabel="name" itemValue="id"/>
                </form:select>
            </p>

            <p>
                <form:errors path="*" Class="error"/>
            </p>

            <input type="Submit" value="${submitLabel}" name="Submit"/>
        </fieldset>
    </form:form>


</div>