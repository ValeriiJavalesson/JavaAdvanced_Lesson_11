<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add product</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/createProduct.css">
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid main">
		<div class="container row page-title">
			<h2 class="fs-1 fw-bold">ДОДАВАННЯ ТОВАРУ</h2>
		</div>
	</div>
	<div class="product-form-container container shadow-lg p-4 rounded-4 mt-4">
		<form class="addProduct-form d-flex align-items-center flex-column">
			<input type="text" class="form-control productName m-3"
				placeholder="Найменування товару"> <input type="text"
				class="form-control productDescription m-3"
				placeholder="Додайте опис"> <input type="number"
				class="form-control productPrice m-3" placeholder="Ціна">
				<button type="button" class="btn btn-info addProduct-button">Додати</button>
		</form>

	</div>



	<jsp:include page="footer.jsp"></jsp:include>

	<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="js/serverCalls.js"></script>
</body>
</html>