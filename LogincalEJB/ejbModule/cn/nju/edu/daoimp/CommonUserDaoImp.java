package cn.nju.edu.daoimp;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cn.nju.edu.dao.CommonUserDao;
import cn.nju.edu.model.CommonUser;

@Stateless
public class CommonUserDaoImp implements CommonUserDao {
	@PersistenceContext
	EntityManager em;
	

	public CommonUserDaoImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(CommonUser user) {
		// TODO Auto-generated method stub
		try {
			em.persist(user); // 保存Entity到数据库中
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

	@Override
	public CommonUser find(String column1, String value1, String column2,
			String value2) {
		try {

			Query query = em.createQuery("from CommonUser u where u." + column1
					+ "=?1 and u." + column2 + "=?2");
			query.setParameter(1, value1);
			query.setParameter(2, value2);
			CommonUser user = (CommonUser) query.getSingleResult();
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
	public CommonUser find(String column1, String value1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateByUserid(CommonUser user) {
		// TODO Auto-generated method stub
		try {
			em.merge(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public CommonUser find(String accountid) {
		try {

			Query query = em.createQuery("from CommonUser u where u.cardid=?1");
			query.setParameter(1, Integer.parseInt(accountid));
			CommonUser user = (CommonUser) query.getSingleResult();
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
	public long getNumber(String column,String key){
		try{

			Query query = em.createQuery("select count(*) from CommonUser u where u."+column+"=?1");
			query.setParameter(1, key);
			long count = (Long) query.getSingleResult();
			em.clear();
			return count;
		}catch(Exception ex){
			
		}finally{
			em.clear();
		}
		return 0;
	}
	
	
	public List<CommonUser>  getAll(){

		Query query=em.createQuery("from CommonUser ");
		List<CommonUser> list=query.getResultList();
		em.clear();
		// TODO Auto-generated method stub
		return list;
	}

}
