package cn.nju.edu.servelet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.nju.edu.dao.CommonUserDao;
import cn.nju.edu.model.CommonUser;

@WebServlet("/StopCard")
public class StopCard  extends HttpServlet  {
  @EJB
  CommonUserDao cud;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		CommonUser user=(CommonUser) session.getAttribute("user");
		int card=user.getCardid();
		int cardid=Integer.parseInt(request.getParameter("card"));
		
		if(card==cardid){
			user.setState("stop");
			cud.updateByUserid(user);
			request.setAttribute("sum", "Stop Successfully!");
			RequestDispatcher dispatcher =request.getRequestDispatcher("/page/postbuy.jsp");
		  	if (dispatcher != null)
    		  dispatcher.forward(request,response);
		}else{
			request.setAttribute("sum", "Stop failed!Invalid card id.");
			RequestDispatcher dispatcher =request.getRequestDispatcher("/page/postbuy.jsp");
		  	if (dispatcher != null)
    		  dispatcher.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	
	}

}
