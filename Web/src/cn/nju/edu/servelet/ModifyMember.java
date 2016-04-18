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

@WebServlet("/modify")
public class ModifyMember extends HttpServlet {
	@EJB
	SalerDao sd;
	public ModifyMember() {
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
		String id=request.getParameter("ID");
		List<Saler> list=sd.find("id", id);
		Saler sa=null;
		String result="success";
		if(list!=null)
		  sa=list.get(0);
		else
			 result="failed";
		
		sa.setStroreid(Integer.parseInt(request.getParameter("storeid")));
		sa.setUsername(request.getParameter("name"));
		sa.setStroreid(new Integer(request.getParameter("storeid")));
		sa.setStatus(request.getParameter("State"));
		sd.updateByUserid(sa);
		
		request.setAttribute("sum", result);
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
