<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page session="false"%>

<style type="text/css">@import url("<spring:url value="/resources/css/rest.css"/>");</style>
<a href="#" id="addUser"
	onclick="make_visible('formInput');resetForm('userForm');return false;">Add User</a>
<div class="content-body" id="global">
	<table class="CSSTableGenerator">
		<tr>
			<th>Name</th>
			<th>Username</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		<tbody id="userRecord"></tbody>
	</table>


		<div id="formInput" style="display: none">

			<h3 align="center"><spring:message code="User.addUser"/></h3>

			<!-- No action method handled by AJAX-->
			<form id="userForm" method="post">
				<input type="hidden" name="id" value="" id="id" />
				<table>
					<tr>
						<td>
							<p>
								<%--<label for="userName"> UserName : </label>--%>
								<label class="" for="userName"><spring:message code="User.username"/></label>
						</td>
						<td><input type="text" name="userName" id="userName"
							value="" />
							</p></td>
					</tr>
					<tr>
						<td>
							<p>
								<label class="" for="password"><spring:message code="User.password"/></label>
						</td>
						<td><input type="password" name="password" id="password" value="" />
							</p></td>
					</tr>
					<tr>
						<td>

							<p>
								<label class="" for="firstName"><spring:message code="User.firstname"/></label>
						</td>
						<td><input type="text" name="firstName" id="firstName"
							value="" />
							</p></td>
					</tr>
					<tr>
						<td>
							<p>
								<label class="" for="lastName"><spring:message code="User.lastname"/></label>						</td>
						<td><input type="text" name="lastName" id="lastName" value="" />
							</p></td>
					</tr>
					<tr>
						<td>
					<p>
						<label class="" for="email"><spring:message code="User.email"/></label>
						<td><input type="text"
							name="email" id="email" value="" />
					</p>
					</td>
					</tr>
					<tr>
						<td>
							<p>
								<label class="" for="phoneNumber"><spring:message code="User.phone"/></label>
						<td> <input
									type="text" name="phoneNumber" id="phoneNumber" value="" />
							</p></td>
					</tr>
					<tr>
						<td>
							<p>
								<label class="" for="dateOfBirth"><spring:message code="User.dob"/></label>						</td>
						<td><input type="text" name="dateOfBirth" id="dateOfBirth"
							value="" />
							</p></td>
					</tr>
					<!-- <p>
							<label for="userFile"> Image : </label> <input type="file"
								name="userFile" id="userFile" value="" />
						</p> -->
					<tr>
						<td><input type="button" value="Add Employee"
							onclick="userSubmit();return false;" id="submitLabel">
							</form></td>
						<td>
							<h4 align="center">
								<a href="#"
									onclick="make_hidden('formInput'); make_hidden('result');resetForm('userForm');">
									<b>EXIT</b>
								</a>
							</h4></td>
					</tr>
				</table>
		</div>

	</div>
	<div id="result" style="display: none">
		<p id="success"></p>
		<p id="errors"></p>
	</div>

</div>