package valerko.lgs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import valerko.lgs.dao.impl.ProductDaoImpl;
import valerko.lgs.domain.Product;
import valerko.lgs.service.ProductService;
import valerko.lgs.service.UserService;
import valerko.lgs.service.impl.ProductServiceImpl;
import valerko.lgs.service.impl.UserServiceImpl;

@WebServlet(name = "product", urlPatterns = { "/product" })
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService = ProductServiceImpl.getProductService();

	// to get resource (product)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String productId = request.getParameter("id");
		Product product = productService.read(Integer.parseInt(productId));
		
		request.setAttribute("product", product);
		request.getRequestDispatcher("singleProduct.jsp").forward(request, response);
	}

	// to create resource (product)
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		
		Product product = new Product(title, description, getValidatePrice(price));
		productService.create(product);
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

	// to update resource (product)
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	// to delete resource (product)
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	private double getValidatePrice(String price) {
		if(price == null || price.isEmpty()) {
			return 0;
		}
		return Double.parseDouble(price);
	}

}
