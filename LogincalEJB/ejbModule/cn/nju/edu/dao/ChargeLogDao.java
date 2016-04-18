package cn.nju.edu.dao;

import java.util.List;

import javax.ejb.Remote;

import cn.nju.edu.model.ChargeLog;
@Remote
public interface ChargeLogDao {
     public void save(ChargeLog cd);
     public List<ChargeLog>  get(int userid);
}
