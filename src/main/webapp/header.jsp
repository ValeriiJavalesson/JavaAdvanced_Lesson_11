<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/header.css">
<header class="mb-3 border-bottom sticky-top bg-body-tertiary">
	<div class="container">

		<div
			class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start navbar p-0">
			<a class="btn admin-menu" data-bs-toggle="offcanvas" href="#offcanvasExample"
				role="button" aria-controls="offcanvasExample"><span
				class="navbar-toggler-icon fs-6 fs-lg-5"></span> </a>
			<div class="logo-id-header col-3 col-sm-2 text-bg-white fs-5 fs-lg-4 order-0">I_SHOP</div>
			<ul
				class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0 order-3 order-lg-1">
				<li><a href="${pageContext.request.contextPath}/cabinet.jsp" class="nav-link px-2 link-dark rounded">Products</a></li>

			</ul>

			<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3 fs-8 p-1 order-4 order-lg-2">
				<input type="search" class="form-control" placeholder="Search..."
					aria-label="Search">
			</form>

			<div class="pe-3 order-1 order-lg-3 position-relative cart-wrapper">
				<a href="${pageContext.request.contextPath}/bucket.jsp" class="d-block link-dark text-decoration-none shopping-cart-icon"
					aria-expanded="false"> <img
					src="style/images/shopping-cart-icon.svg" alt="Cart" width="25"
					height="25">
				</a>
			</div>
			<div class="dropdown text-end order-2 order-lg-4 user-dropdown-menu">
				<a href="#"
					class="d-block link-dark text-decoration-none dropdown-toggle"
					id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
					<img src="style/images/user_icon.gif" alt="User" width="32"
					height="32" class="rounded-circle">
				</a>
				<ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">
					<li><a class="dropdown-item" href="${pageContext.request.contextPath}/cabinet.jsp">Profile</a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a class="dropdown-item logout-button" type="button">Sign
							out</a></li>
				</ul>
			</div>
			
		</div>
	</div>
</header>
<div class="offcanvas offcanvas-start" tabindex="-1"
	id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
	<div class="offcanvas-header">
		<h5 class="offcanvas-title" id="offcanvasExampleLabel">Меню
			адміністратора</h5>
		<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
			aria-label="Close"></button>
	</div>
	<div class="offcanvas-body">
		<div class="d-flex flex-column container">
			<a type="button" class="btn btn-dark m-1"
				href="${pageContext.request.contextPath}/createProduct.jsp">Add
				new product</a> <a type="button" class="btn btn-dark m-1">Another
				action</a>
		</div>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script src="js/header.js"></script>