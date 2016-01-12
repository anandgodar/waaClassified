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
||
<a href="#" id="addUser"
	onclick="make_visible('formInput');resetForm('userForm');return false;">Add User</a>
<h1>WELCOME : ${USER.userName}</h1>
<div class="content-body" id="global">
	<table class="CSSTableGenerator">
		<tr>
			<td>Name</td>
			<td>Username</td>
			<td>Email</td>
			<td>Action</td>
		</tr>
		<tbody id="userRecord"></tbody>
	</table>


		<div id="formInput" style="display: none">

			<h3 align="center">Add User</h3>

			<!-- No action method handled by AJAX-->
			<form id="userForm" method="post">
				<input type="hidden" name="id" value="" id="id" />
				<table>
					<tr>
						<td>
							<p>
								<label for="userName"> UserName : </label>
						</td>
						</td>
						<td><input type="text" name="userName" id="userName"
							value="" />
							</p></td>
					</tr>
					<tr>
						<td>
							<p>
								<label for="password">Password : </label>
						</td>
						<td><input type="text" name="password" id="password" value="" />
							</p></td>
					</tr>
					<tr>
						<td>

							<p>
								<label for="firstName"> First Name : </label>
						</td>
						<td><input type="text" name="firstName" id="firstName"
							value="" />
							</p></td>
					</tr>
					<tr>
						<td>
							<p>
								<label for="lastName"> Last Name : </label>
						</td>
						<td><input type="text" name="lastName" id="lastName" value="" />
							</p></td>
					</tr>
					<tr>
						<td>
					<p>
						<label for="email"> Email : </label> </td>
						<td><input type="text"
							name="email" id="email" value="" />
					</p>
					</td>
					</tr>
					<tr>
						<td>
							<p>
								<label for="phoneNumber"> PhoneNumber : </label></td>
						<td> <input
									type="text" name="phoneNumber" id="phoneNumber" value="" />
							</p></td>
					</tr>
					<tr>
						<td>
							<p>
								<label for="dateOfBirth"> DOB : </label>
						</td>
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