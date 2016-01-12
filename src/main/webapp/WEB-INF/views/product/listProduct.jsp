
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/wishlist.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/category.j"/>"></script>


<h2>Product List</h2>
<spring:url var="addProduct" value="/product/add"></spring:url>
<a href="${addProduct}">Add Product</a>
<div id="errordisplay"></div>
<table class="CSSTableGenerator" >

	<tr>

		<th>Product Name</th>
		<th>Description</th>
        <th colspan="2">Action</th>
 
	</tr>
 
 <c:forEach items="${products}" var="product">
 
 <tr>
 <td><c:out value="${product.name}" /></td>
 <td><c:out value="${product.description}" /></td> 
 <td><spring:url var="editProduct" value="/product/edit/${product.id}"></spring:url>
<a href="${editProduct}">Edit Product</a></td>
 <td><a href="#" onclick="deleteProduct(${product.id});return false;" >DELETE</a></td>
 <td><a href="#" onclick="addToWishList(${USER.id},${product.id});return false;" >Add to Wishlist</a></td>
  
 </tr>
 
 </c:forEach>
 
 </table>   
 
 
 <br />