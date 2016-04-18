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
		 
	       //Ӧ��������ʽ  
	       ChartFactory.setChartTheme(supportChinese()); 
		//�������ݼ�
		DefaultPieDataset dataset = new DefaultPieDataset();

		
		long mannu=cud.getNumber("sex","man" );
		long woman=cud.getNumber("sex", "male");
		double rateman=1.0*mannu/(mannu+woman);
		double ratewoman=1.0*woman/(mannu+woman);
		
		dataset.setValue("����", rateman);
		dataset.setValue("Ů��", ratewoman);
		
		//ͨ������������JFreeChart����
		JFreeChart chart = ChartFactory.createPieChart3D("��Ů����ͳ��", dataset, true, true, false);
		//���3D��ˮ����ͼ����
		PiePlot3D pieplot3d = (PiePlot3D) chart.getPlot();
		//pieplot3d.setExplodePercent(dataset.getKey(1), 0.8);
		//���ÿ�ʼ�Ƕ�
		pieplot3d.setStartAngle(150D);
		//���÷���Ϊ��˳ʱ�뷽��
		pieplot3d.setDirection(Rotation.CLOCKWISE);
		//����͸���ȣ�0.5FΪ��͸����1Ϊ��͸����0Ϊȫ͸��
		pieplot3d.setForegroundAlpha(0.5F);
		pieplot3d.setNoDataMessage("��������ʾ");
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
	
	       //Ӧ��������ʽ  
	       ChartFactory.setChartTheme(supportChinese()); 
		//�������ݼ�
		DefaultPieDataset dataset = new DefaultPieDataset();
	
		
		dataset.setValue("����ʹ��", rateusenu);
		dataset.setValue("��ͣʹ��", ratesuspendnu);
		dataset.setValue("ֹͣʹ��", ratesuspendnu);
		
		//ͨ������������JFreeChart����
		JFreeChart chart = ChartFactory.createPieChart("��Ա��ʹ�����ͳ��", dataset, true, true, false);
		//���3D��ˮ����ͼ����
		PiePlot pieplot =(PiePlot) chart.getPlot();
	    pieplot.setExplodePercent(dataset.getKey(0), 0.2);
		//���ÿ�ʼ�Ƕ�
		pieplot.setStartAngle(150D);
		//���÷���Ϊ��˳ʱ�뷽��
		pieplot.setDirection(Rotation.CLOCKWISE);
		//����͸���ȣ�0.5FΪ��͸����1Ϊ��͸����0Ϊȫ͸��
	//	pieplot.setForegroundAlpha(0.5F);
		pieplot.setNoDataMessage("��������ʾ");
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
		//ͳ�Ƹ�����Ʒ������
		if(productmap.containsKey(type)){
			productmap.put(type, productmap.get(type)+number);
		}else{
			productmap.put(type, number);
		}
		
		//ͳ�Ƹ�����������Ʒ������
		if(storesum.containsKey(storeid)){
		     storesum.put(storeid, storesum.get(storeid)+number);
		}else{
			storesum.put(storeid, number);
		}
	    }
	
	   //Ӧ��������ʽ  
    ChartFactory.setChartTheme(supportChinese()); 
	//�������ݼ�
	DefaultPieDataset dataset = new DefaultPieDataset();

	Set<Integer> keyset=productmap.keySet();
	Iterator<Integer> itrp=keyset.iterator();
	while(itrp.hasNext()){
		int key=itrp.next();
		dataset.setValue("��Ʒ"+key, productmap.get(key));
	}
	
	   
	
	
	
	//ͨ������������JFreeChart����
	JFreeChart chart = ChartFactory.createPieChart("��Ʒ���������", dataset, true, true, false);
	//���3D��ˮ����ͼ����
	PiePlot pieplot =(PiePlot) chart.getPlot();
  //  pieplot.setExplodePercent(dataset.getKey(0), 0.2);
	//���ÿ�ʼ�Ƕ�
	pieplot.setStartAngle(150D);
	//���÷���Ϊ��˳ʱ�뷽��
	pieplot.setDirection(Rotation.CLOCKWISE);
	//����͸���ȣ�0.5FΪ��͸����1Ϊ��͸����0Ϊȫ͸��
//	pieplot.setForegroundAlpha(0.5F);
	pieplot.setNoDataMessage("��������ʾ");
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
		//ͳ�Ƹ�����Ʒ������
		if(productmap.containsKey(type)){
			productmap.put(type, productmap.get(type)+number);
		}else{
			productmap.put(type, number);
		}
		
		//ͳ�Ƹ�����������Ʒ������
		if(storesum.containsKey(storeid)){
		     storesum.put(storeid, storesum.get(storeid)+number);
		}else{
			storesum.put(storeid, number);
		}
	    }
	  
	   //Ӧ��������ʽ  
	    ChartFactory.setChartTheme(supportChinese()); 
		//�������ݼ�
		DefaultPieDataset dataset = new DefaultPieDataset();

		Set<Integer> keyset=storesum.keySet();
		Iterator<Integer> itrp=keyset.iterator();
		while(itrp.hasNext()){
			int key=itrp.next();
			dataset.setValue("����"+key, storesum.get(key));
		}
	  
		//ͨ������������JFreeChart����
		JFreeChart chart = ChartFactory.createPieChart("�������������", dataset, true, true, false);
		//���3D��ˮ����ͼ����
		PiePlot pieplot =(PiePlot) chart.getPlot();
	  //  pieplot.setExplodePercent(dataset.getKey(0), 0.2);
		//���ÿ�ʼ�Ƕ�
		pieplot.setStartAngle(150D);
		//���÷���Ϊ��˳ʱ�뷽��
		pieplot.setDirection(Rotation.CLOCKWISE);
		//����͸���ȣ�0.5FΪ��͸����1Ϊ��͸����0Ϊȫ͸��
//		pieplot.setForegroundAlpha(0.5F);
		pieplot.setNoDataMessage("��������ʾ");
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
		//����������ʽ  
	       StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
	       //���ñ�������  
	       standardChartTheme.setExtraLargeFont(new Font("����",Font.BOLD,20));  
	       //����ͼ��������  
	       standardChartTheme.setRegularFont(new Font("����",Font.PLAIN,15));  
	       //�������������  
	       standardChartTheme.setLargeFont(new Font("����",Font.PLAIN,15));  
	       return standardChartTheme;
	}
}
