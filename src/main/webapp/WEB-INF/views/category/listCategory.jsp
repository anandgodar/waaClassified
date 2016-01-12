<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/category.js"/>"></script>

<style type="text/css">@import url("<spring:url value="/resources/css/rest.css"/>");</style>


<spring:url var="addcategory" value="/category/add"></spring:url>
<a href="${addcategory}">Add Category</a>

<div id="errordisplay"></div>

<table border="2" class="CSSTableGenerator">


    <tr>

        <th>Category Name</th>
        <th>Description</th>

		<th colspan="2">Action</th>
    </tr>

    <c:forEach items="${categories}" var="category">

        <tr>
            <td><c:out value="${category.name}"/></td>
            <td><c:out value="${category.description}"/></td>
            <td><a href="category/edit/${category.id}">EDIT</a></td>
            <td><a href="#" onclick="deleteCategory(${category.id});return false;">DELETE</a></td>

        </tr>

    </c:forEach>

</table>

<br/>