package valerko.lgs.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import valerko.lgs.domain.Bucket;
import valerko.lgs.domain.Product;
import valerko.lgs.service.BucketService;
import valerko.lgs.service.impl.BucketServiceImpl;

@WebServlet(name = "bucket", urlPatterns = { "/bucket" })
public class BucketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private	BucketService bucketService = BucketServiceImpl.getBucketService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Integer userId = (Integer)session.getAttribute("user_id");
		if(userId != null) {
			List <Bucket> buckets = bucketService.readByUserId(userId);	
			String json = new Gson().toJson(buckets);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("product_id");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("user_id");
		
		Bucket bucket = new Bucket(userId, Integer.parseInt(productId), new Date());
		bucketService.create(bucket);
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bucketId = request.getParameter("bucketId");
		bucketService.delete(Integer.parseInt(bucketId));
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}
