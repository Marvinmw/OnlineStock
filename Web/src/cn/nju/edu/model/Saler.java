package cn.nju.edu.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Saler  implements Serializable{

	public Saler() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	private int id;
	
	private String username;
	private String password;
	
	private int stroreid;
    private String status;
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

	public int getStroreid() {
		return stroreid;
	}

	public void setStroreid(int stroreid) {
		this.stroreid = stroreid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
