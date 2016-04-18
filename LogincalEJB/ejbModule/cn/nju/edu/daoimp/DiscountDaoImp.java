package cn.nju.edu.daoimp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cn.nju.edu.dao.DiscountDao;
import cn.nju.edu.model.Discount;

@Stateless
public class DiscountDaoImp implements DiscountDao {
	@PersistenceContext
	EntityManager em;
	@Override
	public float getCount(String level) {
		// TODO Auto-generated method stub
		try {

			Query query = em.createQuery("from Discount u where u.id=?1");
			query.setParameter(1, Integer.parseInt(level));
			Discount dis = (Discount) query.getSingleResult();
			em.clear();
			return dis.getCount();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.clear();
		}
		return 1;

	}

	@Override
	public float setCount(String level, String count) {
		// TODO Auto-generated method stub
				try {
					//把所有订单的金额加10
					Query query = em.createQuery("update Discount as o set o.count=?1 where o.id=?2");
					query.setParameter(1, Float.parseFloat(count));
					query.setParameter(2, Integer.parseInt(level));
					//update 的记录数
					int result = query.executeUpdate();
				  em.clear();
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					em.clear();
				}
				return 1;
	
	}

}
