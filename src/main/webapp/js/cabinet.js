var products = null;
$.get("products", function(data) {
	if (data !== '') {
		products = data;
	}
}).done(function() {
	
	var cardsContent = "";
	jQuery.each(products, function(i, value) {

		cardsContent += "<div class='m-3'>" +
			"<div class='card' style='width: 18rem;'>" +
			"<img src='...' class='card-img-top fs-1' alt='card-image'>" +
			"<div class='card-body'" +
			"<h5 class='card-title'>" + value.title + "</h5>" +
			"<h6 class='card-subtitle mb-2 text-body-secondary fw-bold'>" + value.price + " $ </h6>" +
			"<p class='card-text'>" + value.description + "</p>" +
			"<a href='product?id=" + value.id + "' class='card-link'>Card link</a>" +
			"</div>" +
			"</div>" +
			"</div>"
	});
	$('#product-cards').html(cardsContent);
});