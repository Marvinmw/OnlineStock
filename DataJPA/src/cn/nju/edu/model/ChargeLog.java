package cn.nju.edu.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chLog")
public class ChargeLog implements Serializable{

	
	public ChargeLog(){
		super();
	}
	@Id
	private int id;
	
	private int bankcardid;
	private int money;
	private int membercard;
	private int userid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBankcardid() {
		return bankcardid;
	}
	public void setBankcardid(int bankcardid) {
		this.bankcardid = bankcardid;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getMembercard() {
		return membercard;
	}
	public void setMembercard(int membercard) {
		this.membercard = membercard;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
	
}
