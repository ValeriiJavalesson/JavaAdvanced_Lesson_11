package valerko.lgs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import valerko.lgs.domain.User;
import valerko.lgs.dto.UserLogin;
import valerko.lgs.service.UserService;
import valerko.lgs.service.impl.UserServiceImpl;

@WebServlet(name = "registration", urlPatterns = { "/registration" })
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = userService.read(email);
		
		if (user == null ) {
			if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
				user = new User(firstName, lastName, email, password);
				userService.create(user);
				
				HttpSession session = request.getSession();
				user = userService.read(email);
				session.setAttribute("user_id", user.getId());
				session.setAttribute("role", user.getRole().toString());

				UserLogin userLogin = new UserLogin();
				userLogin.destinationUrl = "cabinet.jsp";
				userLogin.userEmail = user.getEmail();
				
				String json = new Gson().toJson(userLogin);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
			}
		}else {
			String json = new Gson().toJson("");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
	}
}
