package cn.nju.edu.servelet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.nju.edu.dao.CommonUserDao;
import cn.nju.edu.model.CommonUser;

@WebServlet("/register")
public class Register extends HttpServlet {
	@EJB
	CommonUserDao cud;
	public Register() {
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
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birthadyDate");
		String address = request.getParameter("address");
        
		
		CommonUser com=new  CommonUser(username,password,address,birth,sex);
		cud.save(com);
		com=cud.find("username",request.getParameter("user"),"password", request.getParameter("password"));
		com.setCardid(com.getId());
		cud.updateByUserid(com);

		String resut="您的会员卡号："+com.getCardid()+"\n请及时充值，激活该卡（充值100以上）";
		
		 request.setAttribute("sum", resut);   
		
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
