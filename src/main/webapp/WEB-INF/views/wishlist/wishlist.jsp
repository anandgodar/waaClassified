<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript"
        src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/wishlist.js"/>"></script>
<style type="text/css">@import url("<spring:url value="/resources/css/rest.css"/>");</style>

<h2>Product List</h2>
<div class="success"></div>
<div class="errors"></div>
<table class="CSSTableGenerator">

    <tr>

        <th>Product Name</th>
        <th>Description</th>
        <th>Action</th>


    </tr>

    <%--@elvariable id="USER" type="edu.waa.classified.dto.User"--%>
    <c:forEach items="${USER.products}" var="product">
        <tr id="${product.id}">
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.description}"/></td>
            <td> <a href="#" onclick="deleteWish(${USER.id},${product.id})">DELETE</a></td>

        </tr>

    </c:forEach>

</table>


<br/>