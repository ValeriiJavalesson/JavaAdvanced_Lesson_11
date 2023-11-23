$("button.login")
	.click(
		function() {
			var email = $("form.login-form input.email").val();
			var password = $("form.login-form input.password").val();

			if (email == '' || password == '') {
				$("form.login-form .alert").removeClass("d-none");
				$("form.login-form .alert span").text("Заповніть всі поля для реєстрації!");
			} else if ((password.length) < 8) {
				$("form.login-form .alert").removeClass("d-none");
				$("form.login-form .alert span").text("Пароль має містити щонайменше 8 символів!");
			} else {
				$("form.login-form .alert").addClass("d-none");

				var userLogin = {
					email: email,
					password: password
				};

				$.post("login", userLogin, function(data) {
					if (data == "noUser") {
						location.reload();
					} else {
						var customUrl = '';
						var urlContent = window.location.href.split('/');
						for (var i = 0; i < urlContent.length - 1; i++) {
							customUrl += urlContent[i] + '/';
						}
						customUrl += data.destinationUrl;
						window.location = customUrl;
					}
				});
			}
		});
$("form.login-form .alert button")
	.click(
		function() {
			$("form.login-form .alert").addClass("d-none");
		}
	);