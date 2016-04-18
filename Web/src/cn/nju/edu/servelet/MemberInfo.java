package cn.nju.edu.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.nju.edu.model.Saler;

@WebServlet("/memberInfo")
public class MemberInfo extends HttpServlet {
	public MemberInfo() {
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
		HttpSession session=request.getSession(false);
		Saler saler=(Saler) session.getAttribute("user");
		
		String r="Name: "+saler.getUsername()+" Store ID: "+saler.getStroreid()+" State: "+saler.getStatus();
		
		 response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			 out.write(r);
	}


}
