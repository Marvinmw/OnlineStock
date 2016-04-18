package cn.nju.edu.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.nju.edu.dao.SalerDao;
import cn.nju.edu.model.Saler;

@WebServlet("/manageman")
public class SearchMan  extends HttpServlet{
	@EJB
	SalerDao sd;
	  public SearchMan(){
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
			String storeid=request.getParameter("storeid");
			List<Saler> list=sd.find("stroreid", storeid);
			
			Iterator<Saler> itr=list.iterator();
			String info="";
			while(itr.hasNext()){
			Saler saler= itr.next();
			int id=saler.getId();
			String name=saler.getUsername();
			String status=saler.getStatus();
			info=info+"ID :"+id+" ÐÕÃû: "+name+"  Ö°Î»: "+status+"/";
			}
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw=response.getWriter();
			pw.write(info);
		}
			
			
			
		
}
