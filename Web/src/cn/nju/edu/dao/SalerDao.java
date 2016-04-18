package cn.nju.edu.dao;

import javax.ejb.Remote;

import cn.nju.edu.model.Saler;


@Remote
public interface SalerDao {

	/*
	 * 像数据库中插入一条user记录
	 */
	public void save(Saler saler);
	
	
	/*
	 * 根据参数列名和这个列上的值查找user对象,如果找到则返回这个对象,否则返回null
	 * column 列名
	 * value 列值
	 */
	Saler find(String column1,String value1,String column2,String value2);
	java.util.List<Saler> find(String column1,String value1);

	/*
	 * 根据id更新user表的一条记录
	 */
	public void updateByUserid(Saler saler);


	public void delete(Saler saler);

}
