package com.indream.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "serial_no")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	private int id;

	@Column(name = "name")
	@Basic(optional = false)
	private String name;

	@Column(name = "mobile")
	@Basic(optional = false)
	private String mobile;

	@Column(name = "email")
	@Basic(optional = false)
	private String email;

	@Column(name = "password")
	@Basic(optional = false)
	private String password;

	public User() {
	}

	public User(String name, String mobile, String email, String password) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", password="
				+ password + "]";
	}
}
