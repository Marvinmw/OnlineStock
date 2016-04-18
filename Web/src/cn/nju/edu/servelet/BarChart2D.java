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
	        String s = "ѧ������";
	        //�������������ʾ����
	        String s1 = "����";
	        String s2 = "���";
	        String s3 = "�ӱ�";
	        String s4 = "����";
	        String s5 = "����";
	        String s6 = "����";
	        String s7 = "ɽ��";
	        //��������ͼƬ����Ҫ�����ݼ���
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
	 
	  //����JFreeChart����
	    private static JFreeChart createChart(CategoryDataset categorydataset)
	    {
	        JFreeChart jfreechart = ChartFactory.
							        createBarChart(
							        		"ѧУ��Դͳ����״ͼ", // ͼ�����
							        		"ʡ��", // x�����ʾ��ǩ
							        		"����", // y�����ʾ��ǩ
							        		categorydataset, // ���ݼ�
							        		PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
							        		true, // �Ƿ���ʾͼ��
							        		true, // �Ƿ����ɹ���
							        		false // �Ƿ�����URL����
							        		);
	        jfreechart.setBackgroundPaint(Color.white);
	        CategoryPlot categoryplot = jfreechart.getCategoryPlot();
	        categoryplot.setBackgroundPaint(Color.white);
	        categoryplot.setDomainGridlinePaint(Color.white);
	        categoryplot.setDomainGridlinesVisible(true);
	        categoryplot.setRangeGridlinePaint(Color.blue);
	        return jfreechart;
	    }	 
	    //���ɶ�ά��״ͼ��ͼƬ������ͼƬ�ļ�������
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
