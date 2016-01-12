function deleteCategory(id) {


    $.ajax({
        url: '/classified/category/delete/' + id,
        type: 'DELETE',
        success: function () {

            $('#errordisplay').html("");
            $('#errordisplay').append(
                '<p> SuccessFully Deleted</p>'
            )

            var x = setTimeout(function () {
                document.location.reload(true);
            }, 300);


        },
        error: function () {

            $('#errordisplay').html("");
            $('#errordisplay').append(
                '<p> Delete Unsuccess</p>'
            )

            document.location.reload(true);


        }

    });


}

function deleteProduct(id) {


    $.ajax({
        url: '/classified/product/delete/' + id,
        type: 'DELETE',
        success: function () {

            $('#errordisplay').html("");
            $('#errordisplay').append(
               alert("Successfully deleted.")
            )

            var x = setTimeout(function () {
                document.location.reload(true);
            }, 300);


        },
        error: function () {

            $('#errordisplay').html("");
            $('#errordisplay').append(
                alert("Delete unsuccessful.")
            )

            document.location.reload(true);


        }

    });


}
	
	
	
	
	
	
	
