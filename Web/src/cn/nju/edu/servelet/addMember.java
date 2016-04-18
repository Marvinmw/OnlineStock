package cn.nju.edu.servelet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.nju.edu.dao.SalerDao;
import cn.nju.edu.model.Saler;

@WebServlet("/add")
public class addMember extends HttpServlet {
	@EJB
	SalerDao sd;
	public addMember() {
		// TODO Auto-generated constructor stub
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
		handleRequest(request, response);
	}

	private void handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String storeid=request.getParameter("storeid");
		String name=request.getParameter("name");
		String state=request.getParameter("State");
		String pass="123";
		
		Saler saler=new Saler();
		saler.setPassword(pass);
		saler.setStatus(state);
		saler.setStroreid(Integer.parseInt(storeid));
		saler.setUsername(name);
		
	      sd.save(saler);	
	    request.setAttribute("sum", "Success");
		  RequestDispatcher dispatcher =request.getRequestDispatcher("/page/postbuy.jsp");
		  	if (dispatcher != null)
				try {
					dispatcher.forward(request,response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	}
}
