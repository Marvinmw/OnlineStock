package cn.nju.edu.tool;

import java.util.Calendar;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;




public class CheckCardListener implements ServletContextListener {

	Timer timer;

   public  static void main(String[] args){
	
   }


@Override
public void contextDestroyed(ServletContextEvent event) {
	// TODO Auto-generated method stub
	  timer.cancel(); 
      event.getServletContext().log("定时器销毁"); 
}


@Override
public void contextInitialized(ServletContextEvent event) {
	// TODO Auto-generated method stub
	 timer =new Timer(true); 
     event.getServletContext().log("定时器已启动");  
     Calendar cal = Calendar.getInstance();
     cal.set(Calendar.HOUR, 12);
      timer.schedule(new Task(),cal.getTime() , 24*60*1000); 
     event.getServletContext().log("已经添加任务调度表"); 
}
}
