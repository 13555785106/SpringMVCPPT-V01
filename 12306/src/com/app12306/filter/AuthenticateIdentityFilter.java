package com.app12306.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.app12306.db.model.User;
import com.easyweb.core.EasyHttpServletResponse;

@WebFilter(filterName = "AuthenticateIdentityFilter", urlPatterns = "/service/station/*")
public class AuthenticateIdentityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		EasyHttpServletResponse easyHttpServletResponse = new EasyHttpServletResponse((HttpServletResponse) response,
				"text/html", "UTF-8");
		User user = (User) httpServletRequest.getSession().getAttribute("curUser");
		if (user != null)
			chain.doFilter(request, response);
		else {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("status", "notLoggedIn");
			easyHttpServletResponse.getWriter().append(jsonObject.toString());
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}

	@Override
	public void destroy() {
	}
}
