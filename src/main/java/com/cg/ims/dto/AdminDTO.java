package com.cg.ims.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class AdminDTO {
	@Id
	private String userName;
	private String password;
	private String confirmpassword;
	private String role;
	public AdminDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AdminDTO(String userName, String password, String confirmpassword,String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.role=role;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getrole() {
		return role;
	}
	public void setrole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AdminDTO [userName=" + userName + ", password=" + password + ", confirmpassword=" + confirmpassword
				+ ", role=" + role + "]";
	}
	
	
	

	
}



