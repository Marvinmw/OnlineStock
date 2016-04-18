package cn.nju.edu.servelet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.nju.edu.dao.ChargeLogDao;
import cn.nju.edu.dao.CommonUserDao;
import cn.nju.edu.model.ChargeLog;
import cn.nju.edu.model.CommonUser;

@WebServlet("/ChargeServlet")
public class ChargeServlet  extends HttpServlet {
@EJB
CommonUserDao cud;
@EJB
ChargeLogDao cldao;
	public ChargeServlet(){
		super();
	}
	
	   
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			System.out.println("Fucl++++++++++++++++++++");
		int bankcardid=Integer.parseInt(request.getParameter("card"));
		int money=Integer.parseInt(request.getParameter("money"));
		int membercard=Integer.parseInt(request.getParameter("member_card"));
		String state="false";
	
	   HttpSession session=request.getSession(false);
	   CommonUser user=(CommonUser) session.getAttribute("user");
		if(!user.getState().equals("true")){
			if(money>=100)
				user.setState("true");
		}
		if(user.getCardid()==membercard){
		   user.setAccount(user.getAccount()+money);
		   request.setAttribute("sum", "充值成功！您的账户余额为"+user.getAccount());   
		}
		else{
			request.setAttribute("sum", "充值失败！请检查您的会员卡号。您的账户余额为"+user.getAccount());   
		}
	
		int account=user.getAccount();
		if(account<100)
	      user.setLevel(0);
		else if(account>=100 & account<500)
			user.setLevel(1);
		else
			user.setLevel(2);
		
		   Calendar calendar = Calendar.getInstance();
		   Date latestCharge = new Date(calendar.getTimeInMillis());
		   
		   user.setLatestCharge(latestCharge);
	
		
		cud.updateByUserid(user);
		
		
		ChargeLog charlog=new ChargeLog();
		charlog.setBankcardid(bankcardid);
		charlog.setMembercard(membercard);
		charlog.setMoney(money);
		charlog.setUserid(user.getId());
		cldao.save(charlog);
		
		
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

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {

		
		}
	
	
}
