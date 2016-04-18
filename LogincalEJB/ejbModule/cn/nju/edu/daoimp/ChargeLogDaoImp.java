package cn.nju.edu.daoimp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cn.nju.edu.dao.ChargeLogDao;
import cn.nju.edu.model.ChargeLog;
import cn.nju.edu.model.Log;
@Stateless
public class ChargeLogDaoImp implements ChargeLogDao {
	@PersistenceContext
	EntityManager em;
	@Override
	public void save(ChargeLog cd) {
		// TODO Auto-generated method stub
		try {
			em.persist(cd); // 保存Entity到数据库中
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
	}

	@Override
	public List<ChargeLog> get(int userid) {
		// TODO Auto-generated method stub
		try {

			Query query = em.createQuery("from ChargeLog c where c.userid" 
					+ "="+userid);
			List<ChargeLog> list =  query.getResultList();
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
