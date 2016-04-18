package cn.nju.edu.daoimp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cn.nju.edu.dao.ProductDao;
import cn.nju.edu.model.CommonUser;
import cn.nju.edu.model.Product;

@Stateless
public class ProductDaoImp implements ProductDao {
	@PersistenceContext
	EntityManager em;

	public ProductDaoImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		try {
			em.merge(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Product find(String storeid, String type, String day) {
		try {

			Query query = em.createQuery("from Product u where u.storeid=?1 and u.type=?2 and u.day=?3");
			query.setParameter(1, new Integer(storeid));
			query.setParameter(2, new Integer(type));
			query.setParameter(3, new Integer(day));
			Product product = (Product) query.getSingleResult();
			em.clear();
			return product;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.clear();
		}
		return null;
	}
	
	public void save(Product newp){
		// TODO Auto-generated method stub
				try {
					em.persist(newp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
