package cn.nju.edu.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.nju.edu.dao.ChargeLogDao;
import cn.nju.edu.model.ChargeLog;
import cn.nju.edu.model.CommonUser;
import cn.nju.edu.model.Log;

@WebServlet("/rechargeLog")
public class RechargeLog  extends HttpServlet {
	@EJB
	ChargeLogDao ld;
	public RechargeLog() {
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
	    if(session==null)
	    	return;
	    CommonUser com=(CommonUser) session.getAttribute("user");
	    int id=com.getId();
	    
	    List<ChargeLog> ls=ld.get(id);
	    String result="";
	    
	    for(int i=0;i<ls.size();i++){
	    	result+=getLog(ls.get(i));
	    	result+=";";
	    }
	    
	    
	    response.setContentType("text/html;charset=utf-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
	}
	
	private String getLog(ChargeLog lo){
		return String.format("BankID %4d Money %6d MemberCard %6d UserID %4d", lo.getBankcardid(),lo.getMoney(),lo.getMembercard(),lo.getUserid());
	}
}
