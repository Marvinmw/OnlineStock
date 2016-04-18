package cn.nju.edu.servelet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.nju.edu.dao.LogDao;
import cn.nju.edu.model.CommonUser;
import cn.nju.edu.model.Log;

@WebServlet("/PreBuy")
public class PreBuy extends HttpServlet {
	@EJB
	LogDao lo;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PreBuy() {
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
			HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession(false);
		int number = Integer.parseInt(request.getParameter("number"));
		int price = Integer.parseInt(request.getParameter("price"));
		int type = Integer.parseInt(request.getParameter("type"));

		CommonUser userobject = (CommonUser) session.getAttribute("user");
		int userid = userobject.getId();
		int sum = number * price;

		Log log = new Log(number, price, type, userid, sum, "pre",0);
	    boolean result=	lo.saveLog(log);
	    if(result){
	    	request.setAttribute("sum", "½ð¶î£º"+sum);
	    }
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
