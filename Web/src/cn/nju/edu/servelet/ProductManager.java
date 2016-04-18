package cn.nju.edu.servelet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.nju.edu.dao.ProductDao;
import cn.nju.edu.model.Product;
import cn.nju.edu.model.Saler;
@WebServlet("/productmanager")
public class ProductManager   extends HttpServlet{
	@EJB
	ProductDao pd;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
      String day=request.getParameter("day");
      String type=request.getParameter("type");
      String price=request.getParameter("price");
      String number=request.getParameter("number");
      HttpSession session=request.getSession(false);
	  Saler s=(Saler) session.getAttribute("user");
	  int storeid=s.getStroreid();
	  
	  Product product=pd.find(String.valueOf(storeid), type,day);
	  
	  if(product==null)
	  {
		  Product newp=new Product();
		   newp.setDay(new Integer(day));
		   newp.setType(new Integer(type));
		   newp.setNumber(new Integer(number));
		   newp.setPrice(new Integer(price));
		   newp.setStoreid(storeid);
		   
		   pd.save(newp);
	  }
	  else{
	  product.setPrice(Integer.parseInt(price));
	  product.setNumber(Integer.parseInt(number));
	   pd.update(product);
	   }
	  
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	
	}
}
