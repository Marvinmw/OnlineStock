package cn.nju.edu.dao;

import java.util.List;

import javax.ejb.Remote;

import cn.nju.edu.model.CommonUser;

@Remote
public interface CommonUserDao {
	/*
	 * �����ݿ��в���һ��user��¼
	 */
	public void save(CommonUser user);
	
	
	/*
	 * ���ݲ���������������ϵ�ֵ����user����,����ҵ��򷵻��������,���򷵻�null
	 * column ����
	 * value ��ֵ
	 */
	CommonUser find(String column1,String value1,String column2,String value2);
	CommonUser find(String column1,String value1);

	/*
	 * ����id����user���һ����¼
	 */
	public void updateByUserid(CommonUser user);


	public CommonUser find(String accountid);
	long getNumber(String column, String key);
	public List<CommonUser>  getAll();

}
