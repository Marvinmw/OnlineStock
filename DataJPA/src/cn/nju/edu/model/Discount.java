package cn.nju.edu.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="discount")
public class Discount  implements Serializable{
  public Discount(){
	  super();
  }
  
  @Id
  private int id;
  private float count;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public float getCount() {
	return count;
}
public void setCount(float count) {
	this.count = count;
}
}
