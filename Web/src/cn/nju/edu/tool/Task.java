package cn.nju.edu.tool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

import cn.nju.edu.EjbFactory.EJBFactory;
import cn.nju.edu.dao.CommonUserDao;
import cn.nju.edu.model.CommonUser;

public class Task extends TimerTask {
	CommonUserDao cud=(CommonUserDao) EJBFactory.getEJB("ejb:CakerSaledSystem/LogincalEJB/CommonUserDaoImp!"+CommonUserDao.class.getName());
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 check();
	}
	
	   public void check(){
		   Calendar cur=Calendar.getInstance();
		   SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd");
		   cur.setTime(java.sql.Date.valueOf(format1.format(new java.util.Date())));
		   cur.add(Calendar.DAY_OF_YEAR , -1);
		   
		   List<CommonUser> list=cud.getAll();
		   Iterator<CommonUser> itr= list.iterator();
		   while(itr.hasNext()){
			   CommonUser com=itr.next();
			   Date date=com.getLatestCharge();
			   Calendar cal=Calendar.getInstance();
			   cal.setTime(date);
			 
			   if(cal.before(cur)){
				   if(com.getState().equals("true"))
					   com.setState("false");
				   else if(com.getState().equals("false")){
					   cal.add(Calendar.DAY_OF_YEAR, +1);
					   if(cal.before(cur))
					   com.setState("stop");
					   }
			   }
			  cud.updateByUserid(com);
		   }
	   }

	  
}
