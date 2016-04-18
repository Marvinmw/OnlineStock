package cn.nju.edu.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.nju.edu.dao.CommonUserDao;
import cn.nju.edu.dao.LogDao;
import cn.nju.edu.model.CommonUser;

@WebServlet("/modifyPersonInfo")
public class ModifyPersonInfo extends HttpServlet {
	@EJB
	CommonUserDao cud;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModifyPersonInfo() {
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
		HttpSession session=request.getSession(false);
		CommonUser com=(CommonUser) session.getAttribute("user");
		
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		String newpassword = request.getParameter("newpassword");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birthadyDate");
		String address = request.getParameter("address");
		
		
		if(!com.getPassword().equals(password)){
			return;
		}
		
		com.setAddress(address);
		com.setBirthday(java.sql.Date.valueOf(birth));
		com.setPassword(newpassword);
		com.setUsername(username);
		cud.updateByUserid(com);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write("Success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
