package cn.nju.edu.daoimp;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cn.nju.edu.dao.LogDao;
import cn.nju.edu.model.CommonUser;
import cn.nju.edu.model.Log;
@Stateless
public class LogDaoImp implements LogDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public Log getLog(int id) {
		try {

			Query query = em.createQuery("from Log l where l.id" 
					+ "="+id);
			Log log = (Log) query.getSingleResult();
			em.clear();
			return log;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.clear();
		}
		return null;
	}

	@Override
	public void deletelog(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean saveLog(Log log) {
		try {
			em.persist(log); // 保存Entity到数据库中
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List getProductNu() {
		
		
		Query query=em.createQuery("from Log ");
		List list=query.getResultList();
		em.clear();
		// TODO Auto-generated method stub
		return list;
	}

	public List<Log> getByUserID(int id){
		try {

			Query query = em.createQuery("from Log l where l.userid" 
					+ "="+id);
			List<Log> list =  query.getResultList();
			em.clear();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.clear();
		}
		return null;
	}
}
