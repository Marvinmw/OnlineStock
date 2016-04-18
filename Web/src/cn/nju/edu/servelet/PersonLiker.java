package cn.nju.edu.servelet;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

import cn.nju.edu.dao.LogDao;
import cn.nju.edu.model.Log;

@WebServlet("/personliker")
public class PersonLiker extends HttpServlet {
	@EJB
	LogDao ld;

	public PersonLiker() {
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
		int cardid = Integer.parseInt(request.getParameter("card"));
		List<Log> list = ld.getProductNu();
		ListIterator<Log> itr = list.listIterator();
		HashMap<Integer, Integer> person = new HashMap<Integer, Integer>();
		while (itr.hasNext()) {
			Log log = itr.next();
			int type = log.getType();
			int number = log.getNumber();
			int usreid = log.getUserid();
			if(usreid==cardid)
			// ͳ�Ƹ�����Ʒ������
			if (person.containsKey(type)) {
				person.put(type, person.get(type) + number);
			} else {
				person.put(type, number);
			}
		}

		
		//����������ʽ  
	       StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
	       //���ñ�������  
	       standardChartTheme.setExtraLargeFont(new Font("����",Font.BOLD,20));  
	       //����ͼ��������  
	       standardChartTheme.setRegularFont(new Font("����",Font.PLAIN,15));  
	       //�������������  
	       standardChartTheme.setLargeFont(new Font("����",Font.PLAIN,15));  
		  //Ӧ��������ʽ  
	    ChartFactory.setChartTheme(standardChartTheme); 
		//�������ݼ�
		DefaultPieDataset dataset = new DefaultPieDataset();

		Set<Integer> keyset=person.keySet();
		Iterator<Integer> itrp=keyset.iterator();
		while(itrp.hasNext()){
			int key=itrp.next();
			dataset.setValue("��Ʒ"+key, person.get(key));
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
		
		response.setContentType("image/jpeg");
		try {
			ChartUtilities.writeChartAsJPEG(response.getOutputStream(),1,chart,500,300,null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		  
	}
}
