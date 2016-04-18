package cn.nju.edu.dao;

import java.util.List;

import javax.ejb.Remote;

import cn.nju.edu.model.Log;

@Remote
public interface LogDao {

	public Log getLog(int id);
	public void deletelog(int id);
	public boolean saveLog(Log log);
	public List getProductNu();
	public List<Log> getByUserID(int id);
}
