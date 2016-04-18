package cn.nju.edu.dao;

import java.util.List;

import javax.ejb.Remote;

import cn.nju.edu.model.CommonUser;

@Remote
public interface CommonUserDao {
	/*
	 * 像数据库中插入一条user记录
	 */
	public void save(CommonUser user);
	
	
	/*
	 * 根据参数列名和这个列上的值查找user对象,如果找到则返回这个对象,否则返回null
	 * column 列名
	 * value 列值
	 */
	CommonUser find(String column1,String value1,String column2,String value2);
	CommonUser find(String column1,String value1);

	/*
	 * 根据id更新user表的一条记录
	 */
	public void updateByUserid(CommonUser user);


	public CommonUser find(String accountid);
	long getNumber(String column, String key);
	public List<CommonUser>  getAll();

}
