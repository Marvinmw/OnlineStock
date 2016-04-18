package cn.nju.edu.servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.nju.edu.model.CommonUser;
import cn.nju.edu.model.Saler;


@WebServlet("/login")
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Login() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
		handleRequest(request,response);
	}

	private void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		 // Try to retrieve the cookie from the request.
        boolean cookieFound = false;
        
        Cookie cookie = null;
        Cookie[] cookies = request.getCookies();
        
        if(null!=cookies){
        	for(int i=0;i<cookies.length;i++){
        		cookie=cookies[i];
        		if(cookie.getName().equals("loginCaker")){
        			cookieFound=true;
        			break;
        		}
        	}
        }
        
        
        Object logintest=null;
        
        if(session != null ){
        	logintest=session.getAttribute("login");
        }
        
        
        if(logintest==null){
    	   String loginValue = request.getParameter("user");
           boolean isLoginAction = (null == loginValue) ? false : true;

           if (isLoginAction) { // User is logging in
    	   
        	   if (cookieFound) { // If the cookie exists update the value only if changed
                    if (!loginValue.equals(cookie.getValue())) {
                        cookie.setValue(loginValue);
                        response.addCookie(cookie);
                    }
                } else {
                    // If the cookie does not exist, create it and set value
                    cookie = new Cookie("loginCaker", loginValue);
                    cookie.setMaxAge(Integer.MAX_VALUE);
                   // System.out.println("Add cookie");
                    response.addCookie(cookie);
                }
       
        		// create a session to show that we are logged in
                session = request.getSession(true);            
                session.setAttribute("login",loginValue);
                request.setAttribute("login",loginValue);
                displayLogoutPage(request, response,session);
           }
           else{
        	// Display the login page. If the cookie exists, set login
               response.sendRedirect(request.getContextPath() + "/Login");
           }
       }
       else{
    	   if(!session.getAttribute("login").equals(request.getParameter("user")))
    			   session.setAttribute("login", request.getParameter("user")) ; 
    	   
    	   String loginValue = session.getAttribute("login").toString();
    	   request.setAttribute("login",loginValue);
           displayLogoutPage(request, response,session);
           }
        
        
        
	}

	private void displayLogoutPage(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)  {
		if(((String)request.getAttribute("status")).equals("user")){
	        CommonUser user=(CommonUser) request.getAttribute("user");
	        session.setAttribute("user",user);
	        }
		else{
			Saler user=(Saler) request.getAttribute("user");
			  session.setAttribute("user",user);
		}
	        double count=0;
	        if(session.getAttribute("user")!=null)
	        	;//count= user.getAccount();
	        
	    
//	        request.setAttribute("count", count);
//	        if(count>0){
//	        	request.setAttribute("message", "您的账户余额还有：");
//	        	request.setAttribute("color", "black");
//	         }else if(count==0){
//	        	 request.setAttribute("message", "目前为止您的账户余额为0!");
//	        	 request.setAttribute("color", "blue");
//	         }else {
//	        	 request.setAttribute("message", "警告您的账户余额为负，请尽快还款，谢谢您的配合!");
//	        	 request.setAttribute("color", "red");
//	         }
	        RequestDispatcher dispatcher = null;
	      
	        if(((String)request.getAttribute("status")).equals("user")){
	    	 dispatcher =request.getRequestDispatcher("/page/usermainpage.jsp");
	    	}
	        else{
	        	  Saler userobject=(Saler) request.getAttribute("user");
	        	if(userobject.getStatus().equals("slaer")){
					 dispatcher =request.getRequestDispatcher("/page/memberpage.jsp");}
					else  if(userobject.getStatus().equals("manager")){
						dispatcher =request.getRequestDispatcher("/page/charexample.jsp");
					}else{
						dispatcher =request.getRequestDispatcher("/page/systemer.jsp");
					}
	        	
	        }
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
