$("button.register")
	.click(
		function() {
			var firstName = $("form.register-form input.firstName").val();
			var lastName = $("form.register-form input.lastName").val();
			var email = $("form.register-form input.email").val();
			var password = $("form.register-form input.password").val();
			var cpassword = $("form.register-form input.cpassword")
				.val();



			if (firstName == '' || lastName == '' || email == ''
				|| password == '' || cpassword == '') {
				$("form.register-form .alert").removeClass("d-none");
				$("form.register-form .alert span").text("Заповніть всі поля для реєстрації!");
			} else if ((password.length) < 8) {
				$("form.register-form .alert").removeClass("d-none");
				$("form.register-form .alert span").text("Пароль має містити щонайменше 8 символів!");
			} else if (password != cpassword) {
				$("form.register-form .alert").removeClass("d-none");
				$("form.register-form .alert span").text("Паролі не співпадають!");
			} else {
				$("form.register-form .alert").addClass("d-none");

				var userRegistration = {
					firstName: firstName,
					lastName: lastName,
					email: email,
					password: password
				};

				$.get("login", userRegistration, function(data) {
					if (data == 'Success') {
						$("form.register-form .alert").removeClass("d-none");
						$("form.register-form .alert span").text("Електронна адреса вже зареєстрована, введіть іншу!");
					} else {
						$.post("registration", userRegistration, function(data) {

							var customUrl = '';
							var urlContent = window.location.href.split('/');
							for (var i = 0; i < urlContent.length - 1; i++) {
								customUrl += urlContent[i] + '/';
							}
							if (data == '') {
								customUrl += 'index.jsp';
								window.location = customUrl;
							} else {
								customUrl += data.destinationUrl;
								window.location = customUrl;
							}


						});
					}
				});


			}
		});
$("form.register-form .alert button")
	.click(
		function() {
			$("form.register-form .alert").addClass("d-none");
		}
	);
$("div.alert.alert-success button")
	.click(
		function() {
			$("div.alert.alert-success").addClass("d-none");
		}
	);
function showAlertAfterRegistration() {
	$('div.alert.alert-success').removeClass("d-none");
}			