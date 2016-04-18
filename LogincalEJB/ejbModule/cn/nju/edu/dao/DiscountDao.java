package cn.nju.edu.dao;

import javax.ejb.Remote;

@Remote
public interface DiscountDao {
    float getCount(String level);
    float setCount(String level,String count);
}
