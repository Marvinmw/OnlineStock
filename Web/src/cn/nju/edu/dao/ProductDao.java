package cn.nju.edu.dao;

import javax.ejb.Remote;

import cn.nju.edu.model.Product;

@Remote
public interface ProductDao {
   public void update(Product product);
   public Product find(String storeid,String type, String day);
public void save(Product newp);
}
