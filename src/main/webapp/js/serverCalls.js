$("button.addProduct-button")
	.click(
		function() {
			var title = $("form.addProduct-form input.productName").val();
			var description = $("form.addProduct-form input.productDescription").val();
			var price = $("form.addProduct-form input.productPrice").val();

			if (title != '' || description != '' || price != '') {

				var newProduct = {
					title: title,
					description: description,
					price: price
				};

				$.post("product-create", newProduct, function(data) {
					if (data == "Success") {
						alert("Успішно");
						$("form.addProduct-form")[0].reset();
					}
				});
			}
		});

$("a.buy-product").click(function() {
	var product_id = jQuery(this).attr("product_id");

	$.post("bucket", { 'product_id': product_id },
		function(data) {

			if (data == 'Success') {
				checkValueOfBuckets();
			}
		});
});
var buckets = 0;
function checkValueOfBuckets() {
	$.get("bucket", function(data) {
		buckets = data.length;
	}).done(function() {
		if (buckets == '0') {
			$('.shopping-cart-icon::after').removeAttr('display');
		} else {
			$('.shopping-cart-icon::after').attr('display', 'block');
			$("<style>.shopping-cart-icon::after { content: '" + buckets + "';}</style>").appendTo("head");
		}


	});
};		