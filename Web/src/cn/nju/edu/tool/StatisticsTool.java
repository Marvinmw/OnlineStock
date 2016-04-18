package cn.nju.edu.tool;

import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

import cn.nju.edu.EjbFactory.EJBFactory;
import cn.nju.edu.dao.CommonUserDao;
import cn.nju.edu.dao.LogDao;
import cn.nju.edu.model.Log;


public class StatisticsTool implements Serializable ,Cloneable{
 // private static StatisticsTool instance;
 
  private CommonUserDao cud=(CommonUserDao)EJBFactory.getEJB("ejb:CakerSaledSystem/LogincalEJB/CommonUserDaoImp!"+CommonUserDao.class.getName());
  private LogDao ld=(LogDao)EJBFactory.getEJB("ejb:CakerSaledSystem/LogincalEJB/LogDaoImp!"+LogDao.class.getName());
  public StatisticsTool(){
			}
	

	
	public  String getSexStatisticsPie(HttpSession session, PrintWriter pw){
		 
	       //应用主题样式  
	       ChartFactory.setChartTheme(supportChinese()); 
		//设置数据集
		DefaultPieDataset dataset = new DefaultPieDataset();

		
		long mannu=cud.getNumber("sex","man" );
		long woman=cud.getNumber("sex", "male");
		double rateman=1.0*mannu/(mannu+woman);
		double ratewoman=1.0*woman/(mannu+woman);
		
		dataset.setValue("男性", rateman);
		dataset.setValue("女性", ratewoman);
		
		//通过工厂类生成JFreeChart对象
		JFreeChart chart = ChartFactory.createPieChart3D("男女比例统计", dataset, true, true, false);
		//获得3D的水晶饼图对象
		PiePlot3D pieplot3d = (PiePlot3D) chart.getPlot();
		//pieplot3d.setExplodePercent(dataset.getKey(1), 0.8);
		//设置开始角度
		pieplot3d.setStartAngle(150D);
		//设置方向为”顺时针方向“
		pieplot3d.setDirection(Rotation.CLOCKWISE);
		//设置透明度，0.5F为半透明，1为不透明，0为全透明
		pieplot3d.setForegroundAlpha(0.5F);
		pieplot3d.setNoDataMessage("无数据显示");
		String filename=null;
		ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
		try {
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ChartUtilities.writeImageMap(pw, filename, info, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.flush();
	
		return filename;
		
	}
	
	
	
	public String getCardInfo(HttpSession session, PrintWriter pw){
		long stopnu=cud.getNumber("state", "stop");
		long usenu=cud.getNumber("state", "true");
		long suspendnu=cud.getNumber("state", "false");
		
		double ratestopnu=1.0*stopnu/(stopnu+usenu+suspendnu);
		double rateusenu=1.0*usenu/(stopnu+usenu+suspendnu);
		double ratesuspendnu=1.0*suspendnu/(stopnu+usenu+suspendnu);
	
	       //应用主题样式  
	       ChartFactory.setChartTheme(supportChinese()); 
		//设置数据集
		DefaultPieDataset dataset = new DefaultPieDataset();
	
		
		dataset.setValue("正在使用", rateusenu);
		dataset.setValue("暂停使用", ratesuspendnu);
		dataset.setValue("停止使用", ratesuspendnu);
		
		//通过工厂类生成JFreeChart对象
		JFreeChart chart = ChartFactory.createPieChart("会员卡使用情况统计", dataset, true, true, false);
		//获得3D的水晶饼图对象
		PiePlot pieplot =(PiePlot) chart.getPlot();
	    pieplot.setExplodePercent(dataset.getKey(0), 0.2);
		//设置开始角度
		pieplot.setStartAngle(150D);
		//设置方向为”顺时针方向“
		pieplot.setDirection(Rotation.CLOCKWISE);
		//设置透明度，0.5F为半透明，1为不透明，0为全透明
	//	pieplot.setForegroundAlpha(0.5F);
		pieplot.setNoDataMessage("无数据显示");
		String filename=null;
		ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
		try {
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ChartUtilities.writeImageMap(pw, filename, info, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.flush();
		ld.getProductNu();
		return filename;
		
		
	}
	
	
	public String getProductRate(HttpSession session, PrintWriter pw){
		HashMap<Integer,Integer> productmap=new HashMap<Integer,Integer>();
		int  sum=0;
		HashMap<Integer,Integer>  storesum=new HashMap<Integer,Integer>();
	  List<Log> list=ld.getProductNu();
	  ListIterator<Log> itr=list.listIterator();
	  while(itr.hasNext()){
		Log log=itr.next();
		int type=log.getType();
		int number=log.getNumber();
		int storeid=log.getStoreid();
		sum+=number;
		//统计各个产品的销量
		if(productmap.containsKey(type)){
			productmap.put(type, productmap.get(type)+number);
		}else{
			productmap.put(type, number);
		}
		
		//统计各个店铺中商品的销量
		if(storesum.containsKey(storeid)){
		     storesum.put(storeid, storesum.get(storeid)+number);
		}else{
			storesum.put(storeid, number);
		}
	    }
	
	   //应用主题样式  
    ChartFactory.setChartTheme(supportChinese()); 
	//设置数据集
	DefaultPieDataset dataset = new DefaultPieDataset();

	Set<Integer> keyset=productmap.keySet();
	Iterator<Integer> itrp=keyset.iterator();
	while(itrp.hasNext()){
		int key=itrp.next();
		dataset.setValue("产品"+key, productmap.get(key));
	}
	
	   
	
	
	
	//通过工厂类生成JFreeChart对象
	JFreeChart chart = ChartFactory.createPieChart("产品销售情况计", dataset, true, true, false);
	//获得3D的水晶饼图对象
	PiePlot pieplot =(PiePlot) chart.getPlot();
  //  pieplot.setExplodePercent(dataset.getKey(0), 0.2);
	//设置开始角度
	pieplot.setStartAngle(150D);
	//设置方向为”顺时针方向“
	pieplot.setDirection(Rotation.CLOCKWISE);
	//设置透明度，0.5F为半透明，1为不透明，0为全透明
//	pieplot.setForegroundAlpha(0.5F);
	pieplot.setNoDataMessage("无数据显示");
	String filename=null;
	ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
	try {
		filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		ChartUtilities.writeImageMap(pw, filename, info, false);
	} catch (IOException e) {
		e.printStackTrace();
	}
	pw.flush();
	ld.getProductNu();
	return filename;
	
		
		
	}
	
	public String getStore(HttpSession session, PrintWriter pw){
		HashMap<Integer,Integer> productmap=new HashMap<Integer,Integer>();
		int  sum=0;
		HashMap<Integer,Integer>  storesum=new HashMap<Integer,Integer>();
	  List<Log> list=ld.getProductNu();
	  ListIterator<Log> itr=list.listIterator();
	  while(itr.hasNext()){
		Log log=itr.next();
		int type=log.getType();
		int number=log.getNumber();
		int storeid=log.getStoreid();
		sum+=number;
		//统计各个产品的销量
		if(productmap.containsKey(type)){
			productmap.put(type, productmap.get(type)+number);
		}else{
			productmap.put(type, number);
		}
		
		//统计各个店铺中商品的销量
		if(storesum.containsKey(storeid)){
		     storesum.put(storeid, storesum.get(storeid)+number);
		}else{
			storesum.put(storeid, number);
		}
	    }
	  
	   //应用主题样式  
	    ChartFactory.setChartTheme(supportChinese()); 
		//设置数据集
		DefaultPieDataset dataset = new DefaultPieDataset();

		Set<Integer> keyset=storesum.keySet();
		Iterator<Integer> itrp=keyset.iterator();
		while(itrp.hasNext()){
			int key=itrp.next();
			dataset.setValue("店铺"+key, storesum.get(key));
		}
	  
		//通过工厂类生成JFreeChart对象
		JFreeChart chart = ChartFactory.createPieChart("店铺销售情况计", dataset, true, true, false);
		//获得3D的水晶饼图对象
		PiePlot pieplot =(PiePlot) chart.getPlot();
	  //  pieplot.setExplodePercent(dataset.getKey(0), 0.2);
		//设置开始角度
		pieplot.setStartAngle(150D);
		//设置方向为”顺时针方向“
		pieplot.setDirection(Rotation.CLOCKWISE);
		//设置透明度，0.5F为半透明，1为不透明，0为全透明
//		pieplot.setForegroundAlpha(0.5F);
		pieplot.setNoDataMessage("无数据显示");
		String filename=null;
		ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
		try {
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ChartUtilities.writeImageMap(pw, filename, info, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.flush();
		ld.getProductNu();
		return filename;
		}
	
	private StandardChartTheme supportChinese(){
		//创建主题样式  
	       StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
	       //设置标题字体  
	       standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
	       //设置图例的字体  
	       standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
	       //设置轴向的字体  
	       standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
	       return standardChartTheme;
	}
}
