package cn.nju.edu.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.nju.edu.dao.SalerDao;

@WebServlet("/deletemember")
public class Deletemember extends HttpServlet {
	@EJB
	SalerDao sd;
	public Deletemember() {
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
		String id=request.getParameter("id");
		
		String reuslt="success";
		if(sd.find("id", id).get(0)==null)
		{
			reuslt="failed";
		}
			
		sd.delete(sd.find("id", id).get(0));
		
		  response.setContentType("text/html;charset=utf-8");
		  PrintWriter out;
		try {
			out = response.getWriter();
			out.println(reuslt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
