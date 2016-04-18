package cn.nju.edu.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.nju.edu.dao.DiscountDao;

@WebServlet("/updatediscout")
public class UpdateDiscount  extends HttpServlet{
	@EJB
	DiscountDao dd;
	public UpdateDiscount(){
		  super();
	  }
	  

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
		
			// TODO Auto-generated method stub
			
			
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {

			// TODO Auto-generated method stub
			String l1=request.getParameter("level1");
			String l2=request.getParameter("level2");
			String l3=request.getParameter("level3");
			
			dd.setCount(0+"", l1);
			dd.setCount(1+"", l2);
			dd.setCount(2+"", l3);
			
			 response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			 out.write("Success");
		}
}
