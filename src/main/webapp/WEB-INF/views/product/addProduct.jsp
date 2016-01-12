<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="content-body">
	<spring:url value="/product/add" var="addproduct"></spring:url>
	<form:form modelAttribute="product" action="${addproduct}" enctype="multipart/form-data">
		<fieldset>
			<legend>Add Product</legend>
			<form:hidden path="id" value="${productedit.id}" />

			<p>
				<label class="" for="name"><spring:message
						code="Product.name" /></label>
			</p>

			<p>
				<form:input id="name" path="name" type="text"
					value="${productedit.name}" />
			</p>

			<p>
				<form:errors path="name" cssClass="error" />
			</p>

			<p>
				<label class="" for="description"><spring:message
						code="Product.description" /></label>
			</p>

			<p>
				<form:input id="description" path="description" type="text"
					value="${productedit.description}" />
			</p>

			<p>
				<form:errors path="description" cssClass="error" />
			</p>

			<p>
				<label class="" for="parentId"><spring:message
						code="Category.name" /></label>
			</p>

		 <p>
				<form:select path="categoryId" id="category">
					<form:option value="0"> --SELECT--</form:option>
					<form:options items="${categories}" itemLabel="name" itemValue="id" />
				</form:select>
			</p> 

			<p>
				<form:errors path="id" cssClass="error" />
			</p>
			
			<p>
					<label for="productImage"><spring:message code="Product.image" text="Upload Image"/></label>
					<form:input id="productImage" path="fileData" type="file" />
					<strong>${productedit.photoLocation}</strong><br>
				</p>

			<input type="Submit" value="${submitLabel}" name="Submit" />
		</fieldset>
	</form:form>


</div>