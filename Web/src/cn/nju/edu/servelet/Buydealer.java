package cn.nju.edu.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.nju.edu.dao.CommonUserDao;
import cn.nju.edu.dao.DiscountDao;
import cn.nju.edu.dao.LogDao;
import cn.nju.edu.model.CommonUser;
import cn.nju.edu.model.Log;
import cn.nju.edu.model.Saler;


@WebServlet("/buydealer")
public class Buydealer   extends HttpServlet {
@EJB
CommonUserDao cud;
@EJB
LogDao ld;
@EJB
DiscountDao dd;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Buydealer() {
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
		  String accountid=request.getParameter("card");
		  CommonUser user=cud.find(accountid);
		  boolean isaccount=(user.getState().equals("false")|user.getState().equals("stop"))?false:true;
		  int account=user.getAccount();
		  String result="";
		  
		  String cardmoney=request.getParameter("money");
		  int moneycard=0;
		  if(!cardmoney.equals(""))
			  moneycard=Integer.parseInt(cardmoney);
		  
		  String cashmoney=request.getParameter("cash");
		  int moneycash=0;
		  if(!cashmoney.equals(""))
			  moneycash=Integer.parseInt(cashmoney);
			  
		  
		  float count=getLevel(user);
		  if(!isaccount)
			  count=1;
		  
		  float chargesum=moneycash+moneycard;
		  String s=request.getParameter("sum");
		  float sum=Integer.parseInt(s)*count;
		  float charge=0;
		  
		  if(chargesum>=sum){
		  charge=chargesum-sum;
		
		  if(isaccount){
		  if(moneycard<=account){
			  user.setAccount(account-moneycard);
			  cud.updateByUserid(user);
		  }else{
			  result+="4;";
			 
		  }
		  }else{
			  if(moneycard>0)
				  result+="4;";
		  }
		  }else{
			result+="4;";  
		  }
		  if(!result.equals("4;"))
			  result+="2;";
		  result+=charge;
		  
		  
		  String bill=request.getParameter("bill");
		  String[] items=bill.split("/");
		  for(int i=0;i<items.length;i++){
			  String[] info=items[i].split(";");
			  int proid=Integer.parseInt(info[0]);
			  int pronu=Integer.parseInt(info[1]);
			  int proprice=Integer.parseInt(info[2]);
			  int userid=user.getId();
			  Log recordlog=new Log(pronu, proprice, proid, userid, pronu*proprice,"saled",saler.getStroreid());
			  ld.saveLog(recordlog);                  
		  }
		
		  
		  response.setContentType("text/html;charset=utf-8");
		  PrintWriter out = response.getWriter();
		  out.println(result);
		
	}

	private float getLevel(CommonUser user) {
		// TODO Auto-generated method stub
		 return  dd.getCount(String.valueOf(user.getLevel()));
	}





}
