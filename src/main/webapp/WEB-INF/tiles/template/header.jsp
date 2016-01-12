
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page session="false"%>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript"
	src="<spring:url value="/resources/js/user.js"/>"></script>
<style type="text/css">@import url("<spring:url value="/resources/css/rest.css"/>");</style>
<spring:url value="/user/logout" var="url" htmlEscape="true" />
<a href="${url}">Logout</a>
<spring:url value="/user/manageUser" var="url" htmlEscape="true" />
<a href="${url}" id="manageUser">Manage User</a>
<spring:url value="/wishlist" var="url" htmlEscape="true"/>
<a href="${url}">WishList</a>||<spring:url value="/category" var="url" htmlEscape="true"/>
<a href="${url}">Category</a>||<spring:url value="/product" var="url" htmlEscape="true"/>
<a href="${url}">Product</a>

