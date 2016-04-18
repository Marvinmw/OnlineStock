package cn.nju.edu.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class CommonUser implements Serializable{

	public CommonUser() {
		// TODO Auto-generated constructor stub
		super();
	}
	
   public CommonUser(String name,String pass,String address,String birth,String sex){
	   this.username=name;
	   this.password=pass;
	   this.address=address;
	   this.birthday=java.sql.Date.valueOf(birth);
	   this.sex=sex;
	   this.cardid=id;
	   this.account=0;
	   this.state="false";
	   this.level=0;
	   Calendar calendar = Calendar.getInstance();
	   this.latestCharge = new Date(calendar.getTimeInMillis());
 }
	private int id;
	
	private String username;
	private String  password;
	private String address;
	private Date birthday;
	private String sex;
	
	private int cardid;
	private int account;
	private String state;
	   private int level;
private Date latestCharge;

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public int getCardid() {
		return cardid;
	}


	public void setCardid(int cardid) {
		this.cardid = cardid;
	}


	public int getAccount() {
		return account;
	}


	public void setAccount(int account) {
		this.account = account;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}

	public Date getLatestCharge() {
		return latestCharge;
	}

	public void setLatestCharge(Date latestCharge) {
		this.latestCharge = latestCharge;
	}


}
