package valerko.lgs.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import valerko.lgs.dao.UserRole;
import valerko.lgs.shared.FilterService;

@WebFilter("/cabinet.jsp")
public class CabinetFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	private FilterService filterService = FilterService.getFilterService();

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		filterService.doFilterValidation(request, response, chain,
				Arrays.asList(UserRole.USER, UserRole.ADMINISTRATOR));
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
