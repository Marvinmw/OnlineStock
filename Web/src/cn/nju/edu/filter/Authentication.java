package cn.nju.edu.filter;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import cn.nju.edu.dao.CommonUserDao;
import cn.nju.edu.dao.SalerDao;
import cn.nju.edu.model.CommonUser;
import cn.nju.edu.model.Saler;

@WebFilter("/login")
public class Authentication implements Filter {
	@EJB
	CommonUserDao con;
	@EJB
	SalerDao sd;
	public Authentication() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		
		String status=request.getParameter("status");
		System.out.println(status+"=============================================");
		
		if(status.equals("user")){
		
		CommonUser userobject=con.find("username",request.getParameter("user"),"password", request.getParameter("password"));
		if(null==userobject)
		{
			RequestDispatcher dispatcher =request.getRequestDispatcher("/page/FirstPage.jsp");
		  	if (dispatcher != null)
    		  dispatcher.forward(request,response);
    	
		}else{
		request.setAttribute("user", userobject);
		request.setAttribute("status", status);
		chain.doFilter(request, response);
		}
		}else if(status.equals("root")){

			Saler userobject=sd.find("username",request.getParameter("user"),"password", request.getParameter("password"));
			if(null==userobject)
			{
				RequestDispatcher dispatcher;
				 dispatcher =request.getRequestDispatcher("/page/FirstPage.jsp");
				
			  	if (dispatcher != null)
	    		  dispatcher.forward(request,response);
	    	
			}else{
			request.setAttribute("user", userobject);
			request.setAttribute("status", status);
			chain.doFilter(request, response);
			}
			
			
		}
		}
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
