package cn.nju.edu.filter;

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

@WebFilter("/*")
public class TransformCode implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
     
     if (request instanceof HttpServletRequest
				&& response instanceof HttpServletResponse) {
    	 request.setCharacterEncoding("utf-8");
 		
 		response.setContentType("text/html; charset=GBK");
      System.out.println("Filter is called!"+((HttpServletRequest) request).getHeader("Referer"));
      
		}// 在servlet处理请求之前截获
			// pass the request along the filter chain
		chain.doFilter(request, response);
		return;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
        
	}

}
