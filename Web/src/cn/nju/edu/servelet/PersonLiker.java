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
			// 统计各个产品的销量
			if (person.containsKey(type)) {
				person.put(type, person.get(type) + number);
			} else {
				person.put(type, number);
			}
		}

		
		//创建主题样式  
	       StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
	       //设置标题字体  
	       standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
	       //设置图例的字体  
	       standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
	       //设置轴向的字体  
	       standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
		  //应用主题样式  
	    ChartFactory.setChartTheme(standardChartTheme); 
		//设置数据集
		DefaultPieDataset dataset = new DefaultPieDataset();

		Set<Integer> keyset=person.keySet();
		Iterator<Integer> itrp=keyset.iterator();
		while(itrp.hasNext()){
			int key=itrp.next();
			dataset.setValue("商品"+key, person.get(key));
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
		
		response.setContentType("image/jpeg");
		try {
			ChartUtilities.writeChartAsJPEG(response.getOutputStream(),1,chart,500,300,null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		  
	}
}
