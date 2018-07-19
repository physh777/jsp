package com.test.jsp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.test.jsp.vo.UserInfo;

public class AuthFilter implements Filter{
	private String ignorePattern;
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String path = req.getRequestURI();
		if(path.matches(ignorePattern)|| path.indexOf("login")!=-1) {
			fc.doFilter(request, res);
			return;
		}
		if(req.getSession().getAttribute("user")!=null) {
			fc.doFilter(request, res);
			return;
		}else {
			UserInfo ui = new UserInfo();
			ui.setId("dev");
			ui.setNum(11);
			ui.setName("개발용");
			req.getSession().setAttribute("user", ui);
			fc.doFilter(request, res);
			return;
		}
//		RequestDispatcher rd = req.getRequestDispatcher("/views/user/login");
//		rd.forward(request, res);
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		ignorePattern = fc.getInitParameter("ignorePattern");
	}

}
