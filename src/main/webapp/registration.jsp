<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/registration.css">
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-sm-center h-100">
				<div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
					<div class="card shadow-lg">
						<div class="card-body p-4">
							<h1 class="fs-5 card-title fw-bold mb-2">Реєстрація</h1>
							<form class="register-form">
								<div class="mb-3">
									<input class="form-control firstName" type="text" required
										autofocus placeholder="Ім’я" name="firstname">
								</div>
								<div class="mb-3">
									<input class="form-control lastName" type="text"
										placeholder="Прізвище" required autofocus name="lastname">
								</div>
								<div class="mb-3">
									<input class="form-control email" type="email"
										placeholder="E-Mail" required name="email">
								</div>
								<div class="mb-3">
									<input class="form-control password" type="password"
										placeholder="Пароль" required name="password">
								</div>
								<div class="mb-3">
									<input class="form-control cpassword" type="password"
										placeholder="Повторіть пароль" required name="cpassword">
								</div>



								<div
									class="alert alert-warning d-flex align-items-center d-none justify-content-between"
									role="alert">
									<span></span>
									<button type="button" class="btn-close" aria-label="Close"></button>
								</div>



								<p class="form-text text-muted mb-3">Реєструючись, ви
									погоджуєтеся з нашими умовами.</p>
								<div class="align-items-center d-flex">
									<button class="btn btn-primary ms-auto register" type="button"
										data-bs-toggle="modal">Зареєструватися</button>
								</div>
							</form>
						</div>
						<div class="card-footer py-3 border-0">
							<div class="text-center">
								Вже маєте обліковий запис? <a href="index.jsp" class="text-dark">Ввійти</a>
							</div>
						</div>

					</div>
					
					<div
						class="alert alert-success d-flex justify-content-between d-none"
						role="alert">
						<span><b>Успішно!</b> Ви зареєстровані.</span>
						<button type="button" class="btn-close" aria-label="Close"></button>
					</div>					
				</div>
			</div>
		</div>
	</section>
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
	<script src="js/registration.js"></script>
</body>
</html>