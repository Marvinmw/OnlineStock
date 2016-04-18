package cn.nju.edu.dao;

import javax.ejb.Remote;

import cn.nju.edu.model.Saler;


@Remote
public interface SalerDao {

	/*
	 * �����ݿ��в���һ��user��¼
	 */
	public void save(Saler saler);
	
	
	/*
	 * ���ݲ���������������ϵ�ֵ����user����,����ҵ��򷵻��������,���򷵻�null
	 * column ����
	 * value ��ֵ
	 */
	Saler find(String column1,String value1,String column2,String value2);
	java.util.List<Saler> find(String column1,String value1);

	/*
	 * ����id����user���һ����¼
	 */
	public void updateByUserid(Saler saler);


	public void delete(Saler saler);

}
