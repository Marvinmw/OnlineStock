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

import cn.nju.edu.dao.LogDao;
import cn.nju.edu.dao.SalerDao;
import cn.nju.edu.model.CommonUser;
import cn.nju.edu.model.Log;

@WebServlet("/buylog")
public class SearchLog extends HttpServlet {
	@EJB
	LogDao ld;
	public SearchLog() {
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
	    
	    List<Log> ls=ld.getByUserID(id);
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
	
	private String getLog(Log lo){
		return String.format("Type %4d Price %6d Place %6d Date %20s", lo.getType(),lo.getPrice(),lo.getStoreid(),lo.getDate());
	}
}
