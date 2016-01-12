function deleteWish(uId, pId) {
    $.ajax({
        url: 'wishlist/delete/'+uId+'/'+pId,
        type: 'DELETE',
        dataType: 'json',
        //contentType: 'application/json',
        //data: JSON.stringify({"userId": uId, "productId": pId}),
        success: function (result) {
            if (result) {
                $("#"+pId).remove();
                $("#success").html("<h3>Deleted</h3>");
            }else{
                $("#success").html("<h3>Not Deleted. Try Again</h3>");
            }
        },
        error: function (errorObject) {
            $("#success").html("<h3>Not Deleted. Try Again</h3>");
        }
    });
}

function addToWishList(uId, pId){
    $.ajax({
        url: 'wishlist/add',
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({"userId": uId, "productId": pId}),
        success: function (result) {
            if(result.userId == uId){
                alert("Added");
            }else{
                alert("Alert Error Message");
            }
        },
        error: function (errorObject) {
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
}
make_visible = function(id) {
    var element = document.getElementById(id);
    element.style.display = 'block';
};