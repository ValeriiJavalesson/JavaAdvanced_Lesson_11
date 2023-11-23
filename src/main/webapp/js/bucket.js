function myFunction() {
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("myInput");
	filter = input.value.toUpperCase();
	table = document.getElementById("myTable");
	tr = table.getElementsByTagName("tr");
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[0];
		if (td) {
			txtValue = td.textContent || td.innerText;
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}

var buckets = null;
$.get("buckets", function(data) {
	if (data !== '') {
		buckets = data;
	}
}).done(function() {


	var tableContent = "<tr class='header'>" +
		"<th style='width: 20%;' class='text-center'>Назва</th>" +
		"<th style='width: 20%;' class='text-center'>Опис</th>" +
		"<th style='width: 20%;' class='text-center'>Ціна</th>" +
		/*	"<th style='width: 20%;' class='text-center'>Дата покупки</th>" +*/
		"<th style='width: 20%;' class='text-center'>Options</th>" +
		"</tr>";
	var sum = 0;
	jQuery.each(buckets, function(i, value) {
		sum += value.price;
		tableContent += "<tr class='table-row'>" +
			"<td class='text-center'>" + value.title + "</td>" +
			"<td class='text-center'>" + value.description + "</td>" +
			"<td class='text-center'>" + value.price + " $</td>" +
			/*	"<td class='text-center'>" + value.purchaseDate + "</td>" +*/
			"<td class='text-center'><button class='btn-close' onclick='deleteOrderFromBucket(" + value.bucketId + ")'></button></td>" +
			"</tr>"

	});
	sum = sum.toFixed(2);
	tableContent += "<tr class='total-row mt-1'>" +
		"<td colspan='2' class='text-center'> Загальна сума: </td>" +
		"<td class='text-center'>" + sum + " $</td>" +
		"<td class='text-center'><button onclick='' class='btn btn-primary'>Купити</button></td>" +
		"</tr>"

	$('#myTable').html(tableContent);

	table = document.getElementById("myTable");
	tr = table.getElementsByTagName("tr");
	if (tr.length == '2') {
		$('.main-content').css('display', 'none');
		$('.empty-cart-container').css('display', 'flex');
	}
	else {
		$('.main-content').css('display', 'block');
		$('.empty-cart-container').css('display', 'none');
	}

});

function deleteOrderFromBucket(bucketId) {
	var customUrl = '';
	var urlContent = window.location.href.split('/');
	for (var i = 0; i < urlContent.length - 1; i++) {
		customUrl += urlContent[i] + '/'
	}
	customUrl += 'bucket?bucketId=' + bucketId;

	$.ajax({
		url: customUrl,
		type: 'DELETE',
		success: function(data) {
			if (data == 'Success') {
				location.reload();
			}
		}
	});
}