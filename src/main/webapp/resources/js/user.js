$(function() {
	getAllUsers();
});

function getAllUsers() {
	$('#userRecord').html("");
	var myTable = $('#userRecord');

	$.ajax({

		url : '/classified/user/getAllUsers/',
		type : 'GET',
		dataType : 'json', // Accepts
		contentType : 'application/json', // Sends

		success : function(response) {

			for (i = 0; i < response.length; i++) {

				myTable.append("<tr><td>" + response[i].firstName + " "
						+ response[i].lastName + "</td>" + "<td>"
						+ response[i].userName + "</td><td>"
						+ response[i].email + "</td>" + "<td>"
						+ "<a href=\"#\" onclick=\"userDelete("
						+ response[i].id + ");return false;\">Delete</a>"
						+ "||<a href=\"#\" onclick=\"userEdit("
						+ response[i].id + ");return false;\">Edit</a>"
						+ "</td>" + "</tr>");
			}

		}

	});
}

function userDelete(id) {

	var id = id;
	$.ajax({

		url : '/classified/user/deleteUser/' + id,
		type : 'GET',

		success : function(response) {

			getAllUsers();
		}
	});
}


function userSubmit() {
	make_visible('formInput');
	var id = $('#id').val();
	var firstName = $('#firstName').val();
	var lastName = $('#lastName').val();
	var email = $('#email').val();
	var userName = $('#userName').val();
	var password = $('#password').val();
	var dateOfBirth = $('#dateOfBirth').val();
	var phoneNumber = $('#phoneNumber').val();
	var json = {
		"id" : id,
		"firstName" : firstName,
		"lastName" : lastName,
		"userName" : userName,
		"password" : password,
		"email" : email,
		"dateOfBirth" : dateOfBirth,
		"phoneNumber" : phoneNumber
	};

	$
			.ajax({
				data : JSON.stringify(json),
				url : '/classified/user/addUser/',
				type : 'POST',
				dataType : 'json', // Accepts
				contentType : 'application/json', // Sends

				success : function(response) {
					getAllUsers();
					
					$('#errors').html("");
					$('#result').html("");
					$("#result").append(
							'<H3 align="center"> New User Information <H3>');
					$('#result').append(
							"<H4 align='center'>First Name: "
									+ response.firstName + "</h4>");
					$('#result').append(
							"<H4 align='center'>Last Name: "
									+ response.lastName + "</h4>");
					$('#result').append(
							"<H4 align='center'>Email: " + response.email
									+ "</h4>");
					$("#result")
							.append(
									'<h4 align="center"> <a href="#" onclick="make_hidden(\'result\');resetForm(\'employeeForm\');"><b>EXIT</b></a> </h4>');
					make_visible('result');
					make_hidden('errors');
					resetForm('userForm');

				},
				error : function(errorObject) {

					if (errorObject.responseJSON.errorType == "ValidationError") {
						$('#success').html("");
						$('#errors').html("");
						$("#errors").append(
								'<H3 align="center"> Error(s)!! <H3>');
						$("#result").append('<p>');

						var errorList = errorObject.responseJSON.errors;
						$.each(errorList, function(i, error) {
							$("#errors").append(error.message + '<br>');
						});
						$("#errors").append('</p>');
						make_visible('result');
					} else {
						alert(errorObject.responseJSON.errors(0)); // "non"
						// Validation
						// Error
					}
				}

			});

};

function userEdit(id) {

	$.ajax({
		url : '/classified/user/getUser/' + id,
		type : 'GET',
		dataType : 'json', // Accepts
		success : function(response) {
			$.each(response, function(key, result) {

				$('#' + key).val(result);
			})
			
			$('#submitLabel').val("Update User");
			make_visible('formInput');
            
		}
	});

};

toggle_visibility = function(id) {
	var element = document.getElementById(id);
	if (element.style.display == 'block')
		element.style.display = 'none';
	else
		element.style.display = 'block';
}

make_hidden = function(id) {
	var element = document.getElementById(id);
	element.style.display = 'none';
}

make_visible = function(id) {
	var element = document.getElementById(id);
	element.style.display = 'block';
}

resetForm = function(id) {
	var element = document.getElementById(id);
	$(element)[0].reset();
	$("[name=id]").val("");

}

// Translate form to array
// Then put in JSON format
function serializeObject(form) {
	var jsonObject = {};
	var array = form.serializeArray();
	$.each(array, function() {
		jsonObject[this.name] = this.value;
	});
	return jsonObject;

};

