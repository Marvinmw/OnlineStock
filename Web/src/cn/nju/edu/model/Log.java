package cn.nju.edu.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Log  implements Serializable{
   public Log(){
	   super();
   }
   public Log(int number, int price2, int type2, int userid2, int sum2,String state,int storeid) {
	// TODO Auto-generated constructor stub
	   type=type2;
	   price=price2;
	   userid=userid2;
	   sum=sum2;
	   this.state=state;
	   this.number=number;
	   SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");  
	   this.date=format1.format(new java.util.Date());
	   this.storeid=storeid;
}

   private int id;
   private int type;
   private int price;
   private int userid;
   private int sum;
   private int number;
   private String state;
   private String date;
   private int storeid;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public int getSum() {
	return sum;
}
public void setSum(int sum) {
	this.sum = sum;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public int getStoreid() {
	return storeid;
}
public void setStoreid(int storeid) {
	this.storeid = storeid;
}
}
