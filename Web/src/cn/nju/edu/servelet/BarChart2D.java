package cn.nju.edu.servelet;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart2D {
	 private static CategoryDataset createDataset()
	    {
	        String s = "学生人数";
	        //创建横坐标的显示内容
	        String s1 = "北京";
	        String s2 = "天津";
	        String s3 = "河北";
	        String s4 = "安徽";
	        String s5 = "辽宁";
	        String s6 = "河南";
	        String s7 = "山东";
	        //构造生成图片所需要的数据集合
	        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
	        defaultcategorydataset.addValue(2000, s, s1);
	        defaultcategorydataset.addValue(600, s, s2);
	        defaultcategorydataset.addValue(1200, s, s3);
	        defaultcategorydataset.addValue(579, s, s4);
	        defaultcategorydataset.addValue(347, s, s5);
	        defaultcategorydataset.addValue(468, s, s6);
	        defaultcategorydataset.addValue(2000, s, s7);	        
	        return defaultcategorydataset;
	    }
	 
	  //创建JFreeChart对象
	    private static JFreeChart createChart(CategoryDataset categorydataset)
	    {
	        JFreeChart jfreechart = ChartFactory.
							        createBarChart(
							        		"学校生源统计柱状图", // 图表标题
							        		"省份", // x轴的显示标签
							        		"数量", // y轴的显示标签
							        		categorydataset, // 数据集
							        		PlotOrientation.VERTICAL, // 图表方向：水平、垂直
							        		true, // 是否显示图例
							        		true, // 是否生成工具
							        		false // 是否生成URL链接
							        		);
	        jfreechart.setBackgroundPaint(Color.white);
	        CategoryPlot categoryplot = jfreechart.getCategoryPlot();
	        categoryplot.setBackgroundPaint(Color.white);
	        categoryplot.setDomainGridlinePaint(Color.white);
	        categoryplot.setDomainGridlinesVisible(true);
	        categoryplot.setRangeGridlinePaint(Color.blue);
	        return jfreechart;
	    }	 
	    //生成二维柱状图的图片，返回图片文件的名称
	    public static String generateBarChart( HttpSession session, PrintWriter pw) {
			String filename = null;
			CategoryDataset categoryDataset = createDataset();
			JFreeChart chart = createChart(categoryDataset);
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			try {
				filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info,
						session);
			} catch (IOException e) {
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
}
