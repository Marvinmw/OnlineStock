package cn.nju.edu.daoimp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cn.nju.edu.dao.SalerDao;
import cn.nju.edu.model.CommonUser;
import cn.nju.edu.model.Saler;

@Stateless
public class SalerDaoImp implements SalerDao {
	@PersistenceContext
	EntityManager em;

	public SalerDaoImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Saler saler) {
		
			try {
				em.persist(saler); // 保存Entity到数据库中
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			


	}

	@Override
	public Saler find(String column1, String value1, String column2,
			String value2) {
		try {

			Query query = em.createQuery("from Saler u where u." + column1
					+ "=?1 and u." + column2 + "=?2");
			query.setParameter(1, value1);
			query.setParameter(2, value2);
			Saler user = (Saler) query.getSingleResult();
			em.clear();
			return user;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.clear();
		}
		return null;
	}

	@Override
	public List<Saler> find(String column1, String value1) {
		try {

			Query query = em.createQuery("from Saler u where u." + column1
					+ "=?1 ");
			query.setParameter(1, Integer.parseInt(value1));
			List<Saler> user =query.getResultList();
			em.clear();
			return user;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.clear();
		}
		return null;
		
	}

	@Override
	public void updateByUserid(Saler saler) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					em.merge(saler);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	public void delete(Saler saler){
		try {
			em.remove(em.merge(saler));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
