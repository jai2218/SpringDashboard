package com.jai.SpringDashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_DTLS")
public class UserRegistrationDTO {
	
	private int id;
	private String name;
	private String email;
	private String userName;
	private String password;
	private String cnfrmPassword;
	private String dob;
	private String gender;
	private String mobileNumber;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="NAME" , nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="EMAIL_ID" , nullable=false, unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="PASSWORD" , nullable=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="DOB" , nullable=false)
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	@Column(name="GENDER" , nullable=false)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name="USER_NAME" , nullable=false)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="CNFRM_PASSWORD" , nullable=false)
	public String getCnfrmPassword() {
		return cnfrmPassword;
	}
	public void setCnfrmPassword(String cnfrmPassword) {
		this.cnfrmPassword = cnfrmPassword;
	}
	
	@Column(name="MOBILE" , nullable=false, unique=true)
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "UserRegistrationDTO [id=" + id + ", name=" + name + ", email=" + email + ", userName=" + userName
				+ ", password=" + password + ", cnfrmPassword=" + cnfrmPassword + ", dob=" + dob + ", gender=" + gender
				+ ", mobileNumber=" + mobileNumber + "]";
	}
	
	
}
